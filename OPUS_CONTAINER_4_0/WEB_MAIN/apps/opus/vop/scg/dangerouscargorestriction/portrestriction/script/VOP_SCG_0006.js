/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0006.js
 *@FileTitle : DG Restriction by Port - Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview commonly used javascript file, calendar related functions are defined.
     */
    /**
     * @extends 
     * @class vop_scg_0006 : business script for vop_scg_0006 
     */
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0; 
 var callbackEvent="";
   
 var pCnt = 0;
 var popPass = false;
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
                case "btn_retrieve":
                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);                        
                    break;
                case "btn_new":
                    doActionIBSheet(sheetObjects[0],document.form,IBINSERT);   
                    break;
                case "btn_delete":
                    doActionIBSheet(sheetObjects[0],document.form,IBDELETE);                        
                    break;
                case "btn_save":
                     doActionIBSheet(sheetObjects[0],document.form,IBSAVE);   
                    break;
                case "btn_saveAs":
                    doActionIBSheet(sheetObjects[0],document.form,COMMAND04);
                    break;
                case "srch_port_cd":
                	var port_cd=document.form.port_cd.value; 
                	//@@417->517, 520->530
//                	ComOpenPopup('/opuscntr/VOP_VSK_0043.do?port_cd=' + port_cd, 517, 530, "setPortCd", "0,0", true);
    				var sUrl="/opuscntr/VOP_VSK_0043.do?port_cd="+port_cd;
            		ComOpenPopup(sUrl, 422, 510, "returnPortHelp", "0,0", true);
                	break;
                case "srch_imdg_un_no":
                	var imdg_un_no=document.form.imdg_un_no.value;
                    var imdg_un_no_seq=document.form.imdg_un_no_seq.value; 
                    ComOpenPopup("/opuscntr/VOP_SCG_3005.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq, 940, 470, "setUnnoAndClassCd", "0,1,1,1,1,1,1,1,1,1", true,false);
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
     function initControl() {
         //Axon event handling1. event catch
       var formObj=document.form;
       imdg_clss_cd.SetDropHeight(200);
       axon_event.addListenerForm('change',  'obj_change',   form);
       axon_event.addListenerForm('click',   'obj_click',    form);   
       axon_event.addListenerForm('blur',    'obj_blur',     form);
//       axon_event.addListenerForm('obj_keyup',    'obj_keyup', form);
       // IBMultiCombo initializing
       for(var k=0; k<comboObjects.length; k++){
          initCombo(comboObjects[k], k + 1);
       }          
       
       /*$('#port_cd').change(function(){
           if( document.form.port_cd.value.length  == 5    ){
           	document.form.port_cd_nm.value="";
            imdg_clss_cd.SetSelectIndex(-1);
            imdg_clss_cd_desc.value="";
            document.form.imdg_un_no.value='';
            document.form.imdg_un_no_seq.value='';    
            document.form.prp_shp_nm.value='';                       
            fnGridEnble(false);
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);                       
           }
       });*/
  }
     /**
      * registering IBCombo Object as list
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
       * initializing Combo
       * setting Combo items
       */
      function initCombo(comboObj, comboNo) {
        switch(comboObj.options.id) {
            case "imdg_clss_cd":
                with(comboObj) {
                    SetTitle("Class|Definition");
                    SetColWidth(0, "50");
                    SetColWidth(1, "700");
                    SetDropHeight(190);
                    SetMultiSelect(0);
                    SetMaxSelect(1);
                    SetUseAutoComplete(1);
                }
                break;  
        }
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
             //setInitValue(sheetObjects[i], true);                          
         }
         initControl();
         initClass();
         doActionIBSheet(sheetObjects[sheetObjects.length-1],document.form,IBCLEAR);  
     }
     /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      // sheet1 init
                 with (sheetObj) {
            	 var HeadTitle="|Port Prohibition|Port Prohibition|Port Prohibition|Port Prohibition|Port Prohibition|Port Prohibition|Port Prohibition|Port Prohibition|Port Prohibition|Port Prohibition|";
            	 var prefix="sheet1_";

            	 SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1, SizeMode:1 } );

            	 var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 InitHeaders(headers, info);

            	 var cols =  [[{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_lod_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_lod_flg_lb",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_dchg_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_dchg_flg_lb",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_ts_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_ts_flg_lb",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_pass_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_pass_flg_lb",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_dy_tm_op_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_dy_tm_op_flg_lb",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }],
            	              
            	              [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_dy_tm_inlnd_tz_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_dy_tm_inlnd_tz_flg_lb", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"1",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"1",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_port_flg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_port_flg_lb",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"2",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"2",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_ngt_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:130,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_ngt_flg_lb",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }]];
            	 
            	 InitColumns(cols,2);
                 SetEditable(1);
                 SetVisible(1);
                 SetCountPosition(0);
                 SetSheetHeight(ComGetSheetHeight(sheetObj, 4)+10, 1);
               }
               break;
             case 2:      // sheet2 init
            	 with (sheetObj) {
            	 var HeadTitle="|Port Restriction|Port Restriction|Port Restriction|Port Restriction|Port Restriction|Port Restriction|Port Restriction|Ton Over|Need Time|Need Time|";
            	 var cRow=0;
            	 var prefix="sheet2_";

            	 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, SizeMode:1 } );

            	 var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 InitHeaders(headers, info);

            	 var cols = [[{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"load",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"load_cmptn_auth_cd_p", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"load_cmptn_auth_cd_p_lb", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"load_cmptn_auth_cd_d", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"load_cmptn_auth_cd_d_lb", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"load_cmptn_auth_cd_n", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"load_cmptn_auth_cd_n_lb", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"load_ton_ovr_vol_qty", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"load_nd_tm_hrs",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"load_2",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            	            
            	             [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dis",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_cmptn_auth_cd_p",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_cmptn_auth_cd_p_lb",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_cmptn_auth_cd_d",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_cmptn_auth_cd_d_lb",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_cmptn_auth_cd_n",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_cmptn_auth_cd_n_lb",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"dis_ton_ovr_vol_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dis_nd_tm_hrs",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_2",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            	             
            	             [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ts",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_cmptn_auth_cd_p",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_cmptn_auth_cd_p_lb",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_cmptn_auth_cd_d",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_cmptn_auth_cd_d_lb",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_cmptn_auth_cd_n",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_cmptn_auth_cd_n_lb",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"ts_ton_ovr_vol_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"ts_nd_tm_hrs",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_2",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            	             
            	             [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pass",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_cmptn_auth_cd_p", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_cmptn_auth_cd_p_lb", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_cmptn_auth_cd_d", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_cmptn_auth_cd_d_lb", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"CheckBox",  Hidden:0, Width:20,  Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_cmptn_auth_cd_n", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",  Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_cmptn_auth_cd_n_lb", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"pass_ton_ovr_vol_qty", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:prefix+"pass_nd_tm_hrs",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_2",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }]];
            	  
            	 InitColumns(cols,4);
                 SetEditable(1);
                 SetVisible(1);
            	 cRow++;
            	 cRow++;
            	 cRow++;
            	 SetCountPosition(0);
            	 SetSheetHeight(ComGetSheetHeight(sheetObj, 6) + 10, 1);
               }
               break;
             case 3:      // sheet3 init
             with (sheetObj) {
            	 var HeadTitle="|";
            	 for(var k=0;k<12;k++){
            	 HeadTitle+= "Max. Quantity|";
            	 }
            	 var cRow=0;
            	 var prefix="sheet3_";

            	 SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1, SizeMode:1 } );	//, SizeMode:1

            	 var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 InitHeaders(headers, info);

            	 var cols = [[{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"load_L1",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"load_L2",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"load_tml_max_qty",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"load_L3",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"load_L4",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"load_L4",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"load_obrd_max_qty",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"load_L5",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"load_L6",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:prefix+"load_L7",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"load_one_tm_hndl_max_qty", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"load_L8",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            	              
            	             [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dis_L1",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_L2",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"dis_tml_max_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_L3",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dis_L4",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_L9",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"dis_obrd_max_qty",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_L5",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dis_L6",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_L7",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"dis_one_tm_hndl_max_qty",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_L8",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            	             
            	             [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ts_L1",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_L2",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"ts_tml_max_qty",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_L3",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ts_L4",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_L9",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"ts_obrd_max_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_L5",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ts_L6",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_L7",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"ts_one_tm_hndl_max_qty",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_L8",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            	             
            	              [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pass_L1",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_L2",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"pass_tml_max_qty",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_L3",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pass_L4",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_L9",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"pass_obrd_max_qty",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_L5",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pass_L6",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_L7",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"pass_one_tm_hndl_max_qty", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	              {Type:"Text",      Hidden:0,  Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_L8",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ]];
            	  
            	 InitColumns(cols,4);
                 SetEditable(1);
                 SetVisible(1);
            	 cRow++;
            	 cRow++;
            	 cRow++;
            	 SetCountPosition(0);
            	 SetSheetHeight(ComGetSheetHeight(sheetObj, 6)+10, 1);
               }
               break;      
             case 4:      // sheet4 init
             with (sheetObj) {
            	 var HeadTitle="|";
            	 for(var k=0;k<2;k++){
            		 HeadTitle+= "Text Explanation|";
            	 }
            	 var prefix="sheet4_";
            	 var cRow=0;

            	 SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1, SizeMode:1 } );

            	 var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 InitHeaders(headers, info);

            	 var cols = [[{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"load_L1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:800,  Align:"Left",    ColMerge:0,   SaveName:prefix+"load_txt_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:250 }],
            	             [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dis_L1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:800,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_txt_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:250 }],
            	             [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ts_L1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:800,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_txt_desc",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:250 }],
            	             [{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pass_L1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:800,  Align:"Left",    ColMerge:0,   SaveName:prefix+"pass_txt_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:250 }]];
            	  
            	 InitColumns(cols,4);
                 SetEditable(1);
                 SetVisible(1);
            	 cRow++;
            	 cRow++;
            	 cRow++;
            	 SetCountPosition(0);
            	 SetSheetHeight(ComGetSheetHeight(sheetObj, 6)+10, 1);
               }
               break;      
             case 5:      // sheet5 init
             with (sheetObj) {
            	 var HeadTitle="|Direct Load / Delivery / T/S|Direct Load / Delivery / T/S|Direct Load / Delivery / T/S|Direct Load / Delivery / T/S|";
            	 HeadTitle += "Storage at CY|Storage at CY|Storage at CY|Storage at CY|";
            	 var prefix="sheet5_";
            	 var cRow=0;

            	 SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1, SizeMode:1 } );

            	 var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
            	 var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 InitHeaders(headers, info);

            	 var cols = [[{Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_lod_flg_L1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_lod_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_lod_flg_L2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dir_lod_flg_L3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_lod_flg_L4",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"load_dys_sto_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"load_sto_dys",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"load_sto_dys_L2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            	             [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_dchg_flg_L1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_dchg_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_dchg_flg_L1",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dir_dchg_flg_L2",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_dchg_flg_L3",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dis_dys_sto_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"dis_sto_dys",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dis_sto_dys_L2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            	             [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_ts_flg_L1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_ts_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_ts_flg_L2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"dir_ts_flg_L3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_ts_flg_L4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ts_dys_sto_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"ts_sto_dys",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"ts_sto_dys_L2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            	             [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_pinsp_flg_L1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_pinsp_flg_L2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_pinsp_flg_L3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"prohi_pinsp_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"prohi_pinsp_flg_L4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_pinsp_flg_L5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"prohi_pinsp_flg_L6",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"prohi_pinsp_flg_L7",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            	             [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"xtra_hndl_chg_flg_L1",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"xtra_hndl_chg_flg_L2",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"xtra_hndl_chg_flg_L3",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"xtra_hndl_chg_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"xtra_hndl_chg_flg_L4",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"xtra_hndl_chg_flg_L5",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"xtra_hndl_chg_flg_L6",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"xtra_hndl_chg_flg_L7",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            	             [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"sft_gad_flg_L1",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"sft_gad_flg_L2",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"sft_gad_flg_L3",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sft_gad_flg",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sft_gad_flg_L4",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"sft_gad_flg_L5",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sft_gad_flg_L6",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"sft_gad_flg_L7",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }],
            	             [{Type:"Status",    Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"NONE" },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"kep_sft_dist_ihb_flg_L1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"kep_sft_dist_ihb_flg_L2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"kep_sft_dist_ihb_flg_L3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"kep_sft_dist_ihb_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	              {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"kep_sft_dist_ihb_dist",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
            	              {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"kep_sft_dist_ihb_flg_L5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"kep_sft_dist_ihb_flg_L6", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	              {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"kep_sft_dist_ihb_flg_L7", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ]];
            	  
            	 InitColumns(cols, 7);
                 SetEditable(1);
                 SetVisible(1);
            	 cRow++;
            	 cRow++;
            	 cRow++;     
            	 cRow++;     
            	 cRow++;     
            	 cRow++;     
            	 SetCountPosition(0);
            	 SetSheetHeight(ComGetSheetHeight(sheetObj, 10)+10, 1);
               }
               break;    
         }
     }
   // handling sheet process
     function doActionIBSheet(sheetObj, formObj, sAction) {
         sheetObj.ShowDebugMsg(false);
         sheetObj.SetSelectionMode(smSelectionCol);
         switch(sAction) {
            case IBCLEAR:      //initialize 1. retrieve Class Combo
                 formObj.f_cmd.value=SEARCH02;      //SEARCH02            
                 var param=FormQueryString(formObj);
                  var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
                 ComXml2ComboItem( sXml, imdg_clss_cd, "imdg_clss_cd","imdg_clss_cd|imdg_clss_cd_desc" );
                 formObj.port_cd.focus();
                 
                 //스크롤 안보이게 처리하면 높이도 없어지기때문
                 for(i=0;i<sheetObjects.length;i++){
                     setInitValue(sheetObjects[i], true);
                 }
                 
                 if( formObj.pPort_cd.value != ""){
                     formObj.optClass[1].checked = true;
                     formObj.port_cd.value           = formObj.pPort_cd.value;
                     formObj.imdg_clss_cd_text.value      = formObj.pImdg_clss_cd.value;
                     formObj.imdg_clss_cd_desc.value = formObj.pImdg_clss_cd_desc.value;
                     formObj.imdg_un_no.value        = formObj.pImdg_un_no.value;
                     formObj.imdg_un_no_seq.value    = formObj.pImdg_un_no_seq.value;
                     formObj.prp_shp_nm.value        = formObj.pPrp_shp_nm.value;
                     //console.log("aaaaaaaaaaaa");
                     doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
                     //console.log("bbbbbbbbbbbb");
                     doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
                     //console.log("cccccccccccc");
                 }
                 

                 break;
            case IBSEARCH:      //retrieve
                  if( !validateForm(sheetObj,formObj,sAction)){
                      return;
                  }else{
                      formObj.f_cmd.value=SEARCH01;
                  }
                  var param="";
                  var optClass=formObj.optClass[0].checked==true?"class":"unno"; 
                  param +="f_cmd="+formObj.f_cmd.value+"&port_cd="+formObj.port_cd.value+"&imdg_clss_cd="+imdg_clss_cd.GetSelectText();
                  param +="&imdg_un_no="+formObj.imdg_un_no.value+"&imdg_un_no_seq="+formObj.imdg_un_no_seq.value+"&optClass="+optClass;
                  var aryPrefix=new Array( "sheet1_","sheet2_","sheet3_","sheet4_","sheet5_"  );                
                   var sXml=sheetObj.GetSearchData("VOP_SCG_0005GS.do", param + "&" + ComGetPrefixParam( aryPrefix ) );
                  var arrXml=sXml.split("|$$|");
                  var sMsg=getMessage(arrXml[0]);
                  //console.log("11111111111>"+sheetObjects.length);
                  //fnGridEnble(true);
                  for(var i=0;i<sheetObjects.length;i++){
                	  //console.log("start>"+i);
                      setInitValue(sheetObjects[i], true);
                      //console.log("end>"+i);
                  }
                  
                  //console.log("44444444444");
                  /******************************************/
                  if( document.form.optClass[0].checked == true ){//Class
                          if( getTotal(arrXml[0]) != "0"){
                              /*  Setting in case data exist  */
                              for(var i=0; i < arrXml.length; i++){ 
                                  setSheetObjectRetValue(sheetObjects[i], arrXml);
                              }
//                              document.all.btn_saveAs.className='btn1';
                          }else{//sMsg
                    	      ComShowCodeMessage("COM130401");
                    	      
                              for(i=0;i<sheetObjects.length;i++){
                                  setInitValue(sheetObjects[i], true);    
                              }  
                              return;
                          }
                  }else{//Unno retrieve
                      var NO_DATA_MSG=ComGetEtcData(arrXml[0], "NO_DATA_MSG");   
                      /* UNNO, retrieve, Set matching CLASS code in retrieve option. */
                      var etcImdg_clss_cd=ComGetEtcData(arrXml[0], "imdg_clss_cd");
                      var etcImdg_clss_cd_desc=ComGetEtcData(arrXml[0], "imdg_clss_cd_desc");
                      if( etcImdg_clss_cd != ""){
                          imdg_clss_cd.SetSelectCode(etcImdg_clss_cd,false);
                      }
                      if( etcImdg_clss_cd_desc != ""){
                          document.form.imdg_clss_cd_desc.value=etcImdg_clss_cd_desc;  
                      }         
                      /******************************************************************
                       *  In case of UN NO retrieving, retrieve by CLASS.  
                       *     First retrieving, use NO_DATA_MSG as no data handling separator.
                       *         
                       ******************************************************************/
                      if( NO_DATA_MSG != undefined && NO_DATA_MSG != ""){
                          //retrieved by unno, retrieved by unno CLASS로 but no data 
                          if( NO_DATA_MSG == "NO_DATA"){
                              ComShowCodeMessage("COM130401");

                              for(i=0;i<sheetObjects.length;i++){
                                  setInitValue(sheetObjects[i], true);    
                              }  
                              return;
                               
                          }
                          if(  etcImdg_clss_cd != undefined  ){
                              /* 
                               * Prohibition grid (MAIN MASTER of grid) = Editable
                               */
                              imdg_clss_cd.SetSelectText(etcImdg_clss_cd,false);
                              for(var i=0;i<=sheetObjects[0].RowCount();i++){
                                  sheetObjects[0].SetRowEditable( i ,1);
                              }                                   
                          }
                          /*
                           *  No data retrieved by UNNO, and data exist when retrieved by CLASS
                           *    1. show message    
                           *       Check! This Un No./Seq. restriction is based on Class restriction. O.K.
                           *    2. Grid setting.
                           *
                           * NO_DATA_MSG : USE_UNNO - retrieved by UNNO, but no data, so retrieved by CLASS
                           */
                          if( NO_DATA_MSG == "USE_UNNO"){  
                              if( getTotal(arrXml[0]) != "0"){
                                  //Check! This Un No./Seq. restriction is based on Class restriction. O.K.
                                  ComShowMessage( sMsg  ); 
//                                  document.all.btn_delete.className='btn1_1';
                                  for(var i=0; i < arrXml.length; i++){ 
                                      setSheetObjectRetValue(sheetObjects[i], arrXml);
                                  }
                                  formObj.imdg_port_rstr_seq.value="";//handling register.
                              }
                          }
                      }else{
                          if( getTotal(arrXml[0]) != "0"){
                              for(var i=0; i < sheetObjects.length; i++){ 
                                  setSheetObjectRetValue(sheetObjects[i], arrXml);
                              }
//                              document.all.btn_saveAs.className='btn1';
                          }else{
                              ComShowMessage( sMsg );  
                              setIuputMode();
                          }
                      }
                  }
                  break;
            case IBINSERT:      // insert
                var aryPrefix=new Array("sheet1_","sheet2_","sheet3_","sheet4_","sheet5_");
//              var sParam          =  ComGetSaveString(sheetObjects, true, true);             
//                if( sParam !=  ""){
//              if( !ComShowCodeConfirm("SCG02007", "Data") )
//                  return;
//                }
                for(i=0;i<sheetObjects.length;i++){
                    setInitValue(sheetObjects[i], true);                          
                }
                formObj.port_cd.value="";
                formObj.port_cd_nm.value="";
                formObj.optClass[0].checked=true;
                formObj.upd_usr_id.value="";
                formObj.upd_dt.value="";
                imdg_clss_cd.SetEnable(1);
                imdg_clss_cd.SetSelectCode("");
                imdg_clss_cd.SetSelectText("");
                formObj.imdg_clss_cd_desc.value="";
                formObj.imdg_un_no.value="";
                formObj.imdg_un_no_seq.value="";
                formObj.prp_shp_nm.value="";                
//                formObj.optClass[0].fireEvent("onclick");
//                $(formObj.optClass[0]).click();
                initClass();
                fnGridEnble(false);
                
                document.form.rstr_rmk.value="";
                formObj.imdg_port_rstr_seq.value="";
                formObj.port_cd.focus();
                break;                 
            case COMMAND04:      //SAVE  AS function.
                 var param="port_cd="            +formObj.port_cd           .value;
                     param += "&port_cd_nm="        +formObj.port_cd_nm        .value;
                     param += "&imdg_clss_cd="      +imdg_clss_cd      .GetSelectText();
                     param += "&imdg_clss_cd_desc=" +formObj.imdg_clss_cd_desc .value;
                     param += "&imdg_un_no="        +formObj.imdg_un_no        .value;
                     param += "&imdg_un_no_seq="    +formObj.imdg_un_no_seq    .value;
                     param += "&imdg_port_rstr_seq="+formObj.imdg_port_rstr_seq.value;                     
                     if( formObj.imdg_port_rstr_seq.value == ""){
                         ComShowCodeMessage("SCG50034");
                         return;
                     }  
                     if(formObj.optClass[0].checked){
                         param += "&optClass=class";
                     }else{
                         param += "&optClass=unno";
                     }
                 ComOpenPopup('/opuscntr/VOP_SCG_1005.do?'+param, 623, 360, "setSaveAs", "1,0,1,1,1,1,1,1", true,false);            
                 break;
            case IBSEARCH_ASYNC01:      //retrieve  PORT_NM
                formObj.f_cmd.value=SEARCH09;
                var aryPrefix=new Array("sheet1_");
                var param=FormQueryString(formObj) +"&" + ComGetPrefixParam( aryPrefix );
                 var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", param);
                var sMsg=getMessage(sXml);
                if(sMsg != ""){
                    ComShowMessage(sMsg);
                    formObj.port_cd.value="";
                    formObj.port_cd_nm.value="";
                    formObj.port_cd.focus(); 
                    formObj.port_cd.select();  
                    return;
                }
                var port_cd_nm=ComGetEtcData(sXml,"port_cd_nm");   //port_cd_nm  
                document.form.port_cd_nm.value=port_cd_nm;       
                if( port_cd_nm != ""   ){ 
                    if( imdg_clss_cd.GetSelectText()!= ""  ){
                       doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                    }
                }
                break; 
            case IBSEARCH_ASYNC02:      //retrieve prp_shp_nm
                 formObj.f_cmd.value=SEARCH05;
                 var param=FormQueryString(formObj) ;
                 //var sXml  =  sheetObj.GetSearchXml("VOP_SCG_0005GS.do", param);
                  var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
                 var sTotal=ComScgGetTotalValue(sXml);
                 formObj.prp_shp_nm.value="";
                 if( sTotal == "0"){
                     ComShowCodeMessage("SCG50010", 'Data');
                     formObj.imdg_un_no_seq.value='';       
                     formObj.imdg_un_no_seq.focus();
                     return;
                 }else{
                     var prp_shp_nm=ComGetEtcData(sXml,"prp_shp_nm");   //prp_shp_nm  
                     var imdgClssCdDesc=ComGetEtcData(sXml,"imdg_clss_cd_desc");   //imdg_clss_cd_desc  
                     var imdgClssCd=ComGetEtcData(sXml,"imdg_clss_cd");   //imdg_clss_cd                         
                     formObj.prp_shp_nm.value=prp_shp_nm;   
                     formObj.imdg_clss_cd_desc.value=imdgClssCdDesc;
                     imdg_clss_cd.SetSelectCode(imdgClssCd,false);
                 }
                 /*************************unno_seq handling, retrieve handling *****************************/
                 if( prp_shp_nm !="" && callbackEvent != ""){
                     if( callbackEvent == "btn_Retrieve"){
                         callbackEvent="";
                        // doActionIBSheet(sheetObjects[0], formObj,IBSEARCH);
                     }
                 }
                 break;
            case IBSEARCH_ASYNC03:      //checkUNNumber
                formObj.f_cmd.value=SEARCH01;
                var param=FormQueryString(formObj) ;
                 var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", param);
                var sTotal=ComScgGetTotalValue(sXml);
                if( sTotal == "0"){
                     ComShowCodeMessage("SCG50010", 'Data');
                     formObj.imdg_un_no.value="";                      
                     formObj.imdg_un_no.focus();
                }else{
                     formObj.imdg_un_no_seq.focus();
                }
            break; 
         }
     }
     function setSaveAs(){
     }
     function setIuputMode(){
             for(var i=0;i<=sheetObjects[0].RowCount();i++){
                 sheetObjects[0].SetRowEditable( i ,1);
             }
             for(var i=4;i<=sheetObjects[4].RowCount();i++){
                 sheetObjects[4].SetRowEditable( i ,1);
             }
             document.form.rstr_rmk.value="";
             document.form.imdg_port_rstr_seq.value="";              
     }
     function setInitValue(sheetObj, dataInsYn){
         with (sheetObj)
         {
             if(sheetObj.id == 'sheet1') {
            	 //console.log("001");
        		 if( dataInsYn ){
        			 //console.log("002");
        			 sheetObj.RemoveAll();
        			 //console.log("003");
        			 sheetObj.DataInsert();
        			 //console.log("004");
        		 }
        		 //console.log("005");
        		 RenderSheet(0);
        		 SetCellText(1,"sheet1_prohi_lod_flg_lb","Load");
        		 SetCellText(1,"sheet1_prohi_dchg_flg_lb" ,"Discharge");
        		 SetCellText(1,"sheet1_prohi_ts_flg_lb" ,"T/S");
        		 SetCellText(1,"sheet1_prohi_pass_flg_lb" ,"Pass");
        		 SetCellText(1,"sheet1_prohi_dy_tm_op_flg_lb" ,"Day Time Operation");
        		 SetCellText(2,"sheet1_prohi_dy_tm_inlnd_tz_flg_lb","Day Time In-Land Transit");
        		 SetCellText(2,"sheet1_prohi_port_flg_lb" ,"In-port Operation");
        		 SetCellText(2, "sheet1_prohi_ngt_flg_lb" ,"Night Time Operation");
        		 SetMergeCell(2,3,1,2);
                 SetMergeCell(2,7,1,2);
                 RenderSheet(1);
                 //console.log("006");
                 
             }else if(sheetObj.id == 'sheet2') {
            	 RemoveAll();
                 DataInsert();
                 var i = 1;
                 SetCellText(i,"sheet2_load" ,"Load");
                 SetCellText(i,"sheet2_load_cmptn_auth_cd_p_lb" ,"Permit");
                 SetCellText(i,"sheet2_load_cmptn_auth_cd_d_lb" ,"Declare");
                 SetCellText(i,"sheet2_load_cmptn_auth_cd_n_lb" ,"No Need");
                 SetCellText(i,10," HRs before BKG or Enter");
                 
                 SetCellText(++i,"sheet2_dis" ,"Dis");
                 SetCellText(i,"sheet2_dis_cmptn_auth_cd_p_lb" ,"Permit");
                 SetCellText(i,"sheet2_dis_cmptn_auth_cd_d_lb" ,"Declare");
                 SetCellText(i,"sheet2_dis_cmptn_auth_cd_n_lb" ,"No Need");
                 SetCellText(i,10 ," HRs before BKG or Enter");

                 SetCellText(++i,"sheet2_ts" ,"T/S");
                 SetCellText(i,"sheet2_ts_cmptn_auth_cd_p_lb" ,"Permit");
                 SetCellText(i,"sheet2_ts_cmptn_auth_cd_d_lb" ,"Declare");
                 SetCellText(i,"sheet2_ts_cmptn_auth_cd_n_lb" ,"No Need");
                 SetCellText(i,10 ," HRs before BKG or Enter");
                
                 SetCellText(++i,"sheet2_pass","Pass");
                 SetCellText(i,"sheet2_pass_cmptn_auth_cd_p_lb" ,"Permit");
                 SetCellText(i,"sheet2_pass_cmptn_auth_cd_d_lb" ,"Declare");
                 SetCellText(i,"sheet2_pass_cmptn_auth_cd_n_lb" ,"No Need");
                 SetCellText(i,10 ," HRs before BKG or Enter");                 
                 SetColBackColor(1,"#EBF6F9");
                 
             }else if(sheetObj.id == 'sheet3') {
                 RemoveAll();
                 DataInsert();
                 SetCellText(1,1 ,"Load");
                 SetCellText(1,2 ,"Terminal");
                 SetCellText(1,4 ,"Kg");
                 SetCellText(1,6 ,"On Board");
                 SetCellText(1,8 ,"Kg");
                 SetCellText(1,10 ,"One Time handling");
                 SetCellText(1,12 ,"Kg");

                 SetCellText(2,1 ,"Dis");
                 SetCellText(2,2 ,"Terminal");
                 SetCellText(2,4 ,"Kg");
                 SetCellText(2,6 ,"On Board");
                 SetCellText(2,8 ,"Kg");
                 SetCellText(2,10 ,"One Time handling");
                 SetCellText(2,12 ,"Kg");

                 SetCellText(3,1 ,"T/S");
                 SetCellText(3,2 ,"Terminal");
                 SetCellText(3,4 ,"Kg");
                 SetCellText(3,6 ,"On Board");
                 SetCellText(3,8 ,"Kg");

                 SetCellText(4,1 ,"Pass");
                 SetCellText(4,2 ,"Terminal");
                 SetCellText(4,4 ,"Kg");
                 SetCellText(4,6 ,"On Board");
                 SetCellText(4,8 ,"Kg");
                 SetColBackColor(1,"#EBF6F9");
                 SetCellEditable(3, "sheet3_pass_one_tm_hndl_max_qty",0);
                 SetCellEditable(4, "sheet3_pass_one_tm_hndl_max_qty",0);
             }else if(sheetObj.id == 'sheet4') {
                 RemoveAll();
                 DataInsert();
                 SetCellText(1,"sheet4_load_L1","Load");
                 SetCellText(2,"sheet4_dis_L1","Dis");
                 SetCellText(3,"sheet4_ts_L1","T/S");
                 SetCellText(4,"sheet4_pass_L1","Pass");
                 
                 SetCellFont("FontBold", 0,1, 0, 10,1);
                 SetColBackColor(1,"#EBF6F9");
             }else if(sheetObj.id == 'sheet5') {
                 RemoveAll();
                 DataInsert();
                 SetCellText(1,1 ,"Direct Load");
                 SetCellText(1,5 ,"Load");
                 SetCellText(1,8 ,"Days Storage");

                 SetCellText(2,1 ,"Direct Delivery");
                 SetCellText(2,5 ,"Dis");
                 SetCellText(2,8 ,"Days Storage");

                 SetCellText(3,1 ,"Direct T/S");
                 SetCellText(3,5 ,"T/S");
                 SetCellText(3,8 ,"Days Storage");

                 SetCellText(4,1 ,"Pre-Inspection");
                 SetCellText(4,2 ,"Pre-Inspection");
                 SetCellText(4,3 ,"Pre-Inspection");
                 SetCellText(4,5 ," ");
                 SetCellText(4,6 ," ");
                 SetCellText(4,7 ," ");
                 SetCellText(4,8 ," ");

                 SetCellText(5,1 ,"Extra Handling Charge");
                 SetCellText(5,2 ,"Extra Handling Charge");
                 SetCellText(5,3 ,"Extra Handling Charge");
                 SetCellText(5,5 ," ");
                 SetCellText(5,6 ," ");
                 SetCellText(5,7 ," ");
                 SetCellText(5,8 ," ");

                 SetCellText(6,1 ,"Safe Guard");
                 SetCellText(6,2 ,"Safe Guard");
                 SetCellText(6,3 ,"Safe Guard");
                 SetCellText(6,5 ," ");
                 SetCellText(6,6 ," ");
                 SetCellText(6,7 ," ");
                 SetCellText(6,8 ," ");

                 SetCellText(7,1 ,"Keep Safety Distance from Inhabitation");
                 SetCellText(7,2 ,"Keep Safety Distance from Inhabitation");
                 SetCellText(7,3 ,"Keep Safety Distance from Inhabitation");
                 SetCellText(7,6 ,"Meter");
                 SetCellText(7,7 ,"Meter");
                 SetCellText(7,8 ,"Meter");
                 SetColBackColor(1,"#EBF6F9");
                 SetColBackColor(5,"#EBF6F9");
                 SetCellBackColor(7,5,"#FFFFFF");
                 SetMergeCell(4,1,1,3);
                 SetMergeCell(4,5,1,4);
                 SetMergeCell(5,1,1,3);
                 SetMergeCell(5,5,1,4);
                 SetMergeCell(6,1,1,3);
                 SetMergeCell(6,5,1,4);
                 SetMergeCell(7,1,1,3);
                 SetMergeCell(7,6,1,3);
             }
             document.form.rstr_rmk.value="";
             document.form.imdg_port_rstr_seq.value="";               
         }       
     }
     function setSheetObjectRetValue(sheetObj, aXml ){ 
         if( sheetObj.id == 'sheet1'){
            with(sheetObj){
               var sXml=aXml[0];
               var aColorder=getColOrder(sXml).split("|");
              RenderSheet(0);
               document.form.imdg_port_rstr_seq.value=getSearchRow(sXml, 1,"sheet1_imdg_port_rstr_seq") ;
              SetCellValue( 1, "sheet1_prohi_dchg_flg" ,getSearchRow(sXml, 1,"sheet1_prohi_dchg_flg")=="Y"?"1":"0",0);
              SetCellValue( 1, "sheet1_prohi_lod_flg" ,getSearchRow(sXml, 1,"sheet1_prohi_lod_flg")=="Y"?"1":"0",0);
              SetCellValue( 1, "sheet1_prohi_ts_flg" ,getSearchRow(sXml, 1,"sheet1_prohi_ts_flg"  )=="Y"?"1":"0",0);
              SetCellValue( 1, "sheet1_prohi_pass_flg" ,getSearchRow(sXml, 1,"sheet1_prohi_pass_flg")=="Y"?"1":"0",0);
              SetCellValue( 1, "sheet1_prohi_dy_tm_op_flg" ,getSearchRow(sXml, 1,"sheet1_prohi_dy_tm_op_flg")=="Y"?"1":"0",0);
              SetCellValue( 2, "sheet1_prohi_dy_tm_inlnd_tz_flg" ,getSearchRow(sXml, 1,"sheet1_prohi_dy_tm_inlnd_tz_flg")=="Y"?"1":"0",0);
              SetCellValue( 2, "sheet1_prohi_port_flg" ,getSearchRow(sXml, 1,"sheet1_prohi_port_flg") =="Y"?"1":"0",0);
              SetCellValue( 2, "sheet1_prohi_ngt_flg" ,getSearchRow(sXml, 1,"sheet1_prohi_ngt_flg")=="Y"?"1":"0",0);
              document.form.upd_usr_id.value=getSearchRow(sXml, 1,"sheet1_upd_usr_id") ;
              document.form.upd_dt.value=getSearchRow(sXml, 1,"sheet1_upd_dt_f") ;
              for(var i=1;i<=sheetObjects[0].RowCount();i++){
                  sheetObjects[0].SetRowEditable( i ,1);
              }
              if(  GetCellValue( 1, "sheet1_prohi_lod_flg" ) == 1 ){
                  for(var i=1;i<2;i++){                      
                      ScgGetRowEditable(sheetObjects[i], 1, "", false);
                  } 
              }else{
                  for(var i=1;i<2;i++){
                      ScgGetRowEditable(sheetObjects[i], 1, sheetObjects[i].id+"_load", true);
                  }                   
              }   
              if(  GetCellValue( 1, "sheet1_prohi_dchg_flg" ) == 1 ){
                  for(var i=1;i<2;i++){                      
                      ScgGetRowEditable(sheetObjects[i], 2, "", false);
                  }
              }else{
                    for(var i=1;i<2;i++){   
                        ScgGetRowEditable(sheetObjects[i], 2, sheetObjects[i].id+"_dis", true);
                        ScgRowClear(sheetObjects[i], 2);      
                    }                 
              }  
              if(  GetCellValue( 1, "sheet1_prohi_ts_flg" ) == 1 ){
                  for(var i=1;i<2;i++){                      
                      ScgGetRowEditable(sheetObjects[i], 3, sheetObjects[i].id+"_ts|"+sheetObjects[i].id+"_ts_one_tm_hndl_max_qty|", false);
                  } 
              }else{
                     for(var i=1;i<2;i++){  
                         ScgGetRowEditable(sheetObjects[i], 3,   sheetObjects[i].id+"_ts|"+sheetObjects[i].id+"_ts_L5|"+sheetObjects[i].id+"_ts_L6|"+ sheetObjects[i].id+"_ts_L7|"+
                                 sheetObjects[i].id+"_ts_L8|"+sheetObjects[i].id+"_ts_one_tm_hndl_max_qty", true);                                  
                         ScgRowClear(sheetObjects[i], 3);       
                     }        
              }
              if(  GetCellValue( 1, "sheet1_prohi_pass_flg" ) == 1 ){
                  for(var i=1;i<2;i++){             
                    ScgGetRowEditable(sheetObjects[i], 4, "", false);
                  }                      
              }else{
                  for(var i=1;i<2;i++){   //
                         ScgGetRowEditable(sheetObjects[i], 4, sheetObjects[i].id+"_pass|"+sheetObjects[i].id+"_pass_one_tm_hndl_max_qty|"+sheetObjects[i].id+"_pass_L8", true);
                         ScgRowClear(sheetObjects[i], 4);          
                 }   
              }
              sheetObjects[4].SetRowEditable( 4 ,1);
              sheetObjects[4].SetRowEditable( 5 ,1);
              sheetObjects[4].SetRowEditable( 6 ,1);
              sheetObjects[4].SetRowEditable( 7 ,1);
            RenderSheet(1);
            }
         }
         if( sheetObj.id == 'sheet2'){
            with(sheetObj){ 
               var sXml=aXml[1];  
               var  imdg_cmptn_auth_cd=getSearchRow(sXml, 1, sheetObj.id+"_"+"load_imdg_cmptn_auth_cd");
//               var  imdg_cmptn_auth_cd=getSearchRow(sXml, 1, sheetObj.id+"_"+"imdg_cmptn_auth_cd");
               SetCellValue( 1, sheetObj.id+"_"+"load_cmptn_auth_cd_p" ,imdg_cmptn_auth_cd=="P"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"load_cmptn_auth_cd_d" ,imdg_cmptn_auth_cd=="D"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"load_cmptn_auth_cd_n" ,imdg_cmptn_auth_cd=="N"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"load_ton_ovr_vol_qty" ,getSearchRow(sXml, 1, sheetObj.id+"_"+"load_ton_ovr_vol_qty") ,0);
               SetCellValue( 1, sheetObj.id+"_"+"load_nd_tm_hrs" ,getSearchRow(sXml, 1, sheetObj.id+"_"+"load_nd_tm_hrs"),0);
               imdg_cmptn_auth_cd=getSearchRow(sXml, 3, sheetObj.id+"_"+"dis_imdg_cmptn_auth_cd");               
//               imdg_cmptn_auth_cd=getSearchRow(sXml, 2, sheetObj.id+"_"+"imdg_cmptn_auth_cd");
               SetCellValue( 1, sheetObj.id+"_"+"dis_cmptn_auth_cd_p" ,imdg_cmptn_auth_cd=="P"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"dis_cmptn_auth_cd_d" ,imdg_cmptn_auth_cd=="D"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"dis_cmptn_auth_cd_n" ,imdg_cmptn_auth_cd=="N"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"dis_ton_ovr_vol_qty" ,getSearchRow(sXml, 3, sheetObj.id+"_"+"dis_ton_ovr_vol_qty") ,0);
               SetCellValue( 1, sheetObj.id+"_"+"dis_nd_tm_hrs" ,getSearchRow(sXml, 3, sheetObj.id+"_"+"dis_nd_tm_hrs"),0);

               imdg_cmptn_auth_cd=getSearchRow(sXml, 5, sheetObj.id+"_"+"ts_imdg_cmptn_auth_cd");  
//               imdg_cmptn_auth_cd=getSearchRow(sXml, 3, sheetObj.id+"_"+"imdg_cmptn_auth_cd");
               SetCellValue( 1, sheetObj.id+"_"+"ts_cmptn_auth_cd_p" ,imdg_cmptn_auth_cd=="P"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"ts_cmptn_auth_cd_d" ,imdg_cmptn_auth_cd=="D"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"ts_cmptn_auth_cd_n" ,imdg_cmptn_auth_cd=="N"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"ts_ton_ovr_vol_qty" ,getSearchRow(sXml, 5, sheetObj.id+"_"+"ts_ton_ovr_vol_qty") ,0);
               SetCellValue( 1, sheetObj.id+"_"+"ts_nd_tm_hrs" ,getSearchRow(sXml, 5, sheetObj.id+"_"+"ts_nd_tm_hrs"),0);

//               imdg_cmptn_auth_cd=getSearchRow(sXml, 4, sheetObj.id+"_"+"pass_imdg_cmptn_auth_cd");              
               imdg_cmptn_auth_cd=getSearchRow(sXml, 7, sheetObj.id+"_"+"imdg_cmptn_auth_cd");
               SetCellValue( 1, sheetObj.id+"_"+"pass_cmptn_auth_cd_p" ,imdg_cmptn_auth_cd=="P"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"pass_cmptn_auth_cd_d" ,imdg_cmptn_auth_cd=="D"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"pass_cmptn_auth_cd_n" ,imdg_cmptn_auth_cd=="N"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"pass_ton_ovr_vol_qty" ,getSearchRow(sXml, 7, sheetObj.id+"_"+"pass_ton_ovr_vol_qty") ,0);
               SetCellValue( 1, sheetObj.id+"_"+"pass_nd_tm_hrs" ,getSearchRow(sXml, 7, sheetObj.id+"_"+"pass_nd_tm_hrs"),0);
            }
         }   
         if( sheetObj.id == 'sheet3'){
            with(sheetObj){ 
               var sXml=aXml[2]; 
               var cRow=1;
               SetCellValue( 1, sheetObj.id+"_"+"load_tml_max_qty" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"load_tml_max_qty") ,0);
               SetCellValue( 1, sheetObj.id+"_"+"load_obrd_max_qty" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"load_obrd_max_qty") ,0);
               SetCellValue( 1, sheetObj.id+"_"+"load_one_tm_hndl_max_qty" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"load_one_tm_hndl_max_qty") ,0);
               cRow = cRow+2;       
               SetCellValue( 1, sheetObj.id+"_"+"dis_tml_max_qty" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"dis_tml_max_qty") ,0);
               SetCellValue( 1, sheetObj.id+"_"+"dis_obrd_max_qty" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"dis_obrd_max_qty") ,0);
               SetCellValue( 1, sheetObj.id+"_"+"dis_one_tm_hndl_max_qty" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"dis_one_tm_hndl_max_qty") ,0);
               cRow = cRow+2;       
               SetCellValue( 1, sheetObj.id+"_"+"ts_tml_max_qty" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"ts_tml_max_qty") ,0);
               SetCellValue( 1, sheetObj.id+"_"+"ts_obrd_max_qty" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"ts_obrd_max_qty") ,0);
               SetCellValue( 1, sheetObj.id+"_"+"ts_one_tm_hndl_max_qty" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"ts_one_tm_hndl_max_qty") ,0);
               cRow = cRow+2;       
               SetCellValue( 1, sheetObj.id+"_"+"pass_tml_max_qty" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"pass_tml_max_qty") ,0);
               SetCellValue( 1, sheetObj.id+"_"+"pass_obrd_max_qty" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"pass_obrd_max_qty") ,0);
               SetCellValue( 1, sheetObj.id+"_"+"pass_one_tm_hndl_max_qty" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"pass_one_tm_hndl_max_qty") ,0);
            }
         }  
         if( sheetObj.id == 'sheet4'){
            with(sheetObj){ 
               var sXml=aXml[3];
               var cRow=1;
               SetCellValue( 1, sheetObj.id+"_"+"load_txt_desc" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"load_txt_desc") ,0);
               cRow = cRow+2;
               SetCellValue( 1, sheetObj.id+"_"+"dis_txt_desc" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"dis_txt_desc") ,0);
               cRow = cRow+2;
               SetCellValue( 1, sheetObj.id+"_"+"ts_txt_desc" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"ts_txt_desc") ,0);
               cRow = cRow+2;
               SetCellValue( 1, sheetObj.id+"_"+"pass_txt_desc" ,getSearchRow(sXml, cRow, sheetObj.id+"_"+"pass_txt_desc") ,0);
            }
         } 
         if( sheetObj.id == 'sheet5'){
            with(sheetObj){ 
               var sXmlM=aXml[0]; 
               var sXmlD=aXml[4];
               var cRow=1;
               SetCellValue( 1, sheetObj.id+"_"+"dir_lod_flg" ,getSearchRow(sXmlM, cRow,  "sheet1_"+"dir_lod_flg")=="Y"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"load_dys_sto_flg" ,getSearchRow(sXmlD, cRow, sheetObj.id+"_"+"load_dys_sto_flg")=="Y"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"load_sto_dys" ,getSearchRow(sXmlD, cRow, sheetObj.id+"_"+"load_sto_dys") ,0);
               cRow = cRow+2;       
               SetCellValue( 1, sheetObj.id+"_"+"dir_dchg_flg" ,getSearchRow(sXmlM, 1,  "sheet1_"+"dir_dchg_flg")=="Y"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"dis_dys_sto_flg" ,getSearchRow(sXmlD, cRow, sheetObj.id+"_"+"dis_dys_sto_flg")=="Y"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"dis_sto_dys" ,getSearchRow(sXmlD, cRow, sheetObj.id+"_"+"dis_sto_dys") ,0);
               cRow = cRow+2;       
               SetCellValue( 1, sheetObj.id+"_"+"dir_ts_flg" ,getSearchRow(sXmlM, 1,  "sheet1_"+"dir_ts_flg")=="Y"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"ts_dys_sto_flg" ,getSearchRow(sXmlD, cRow, sheetObj.id+"_"+"ts_dys_sto_flg")=="Y"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"ts_sto_dys" ,getSearchRow(sXmlD, cRow, sheetObj.id+"_"+"ts_sto_dys") ,0);
               cRow = cRow+2;       
               SetCellValue( 1, sheetObj.id+"_"+"prohi_pinsp_flg" ,getSearchRow(sXmlM, 1,  "sheet1_"+"prohi_pinsp_flg")=="Y"?"1":"0" ,0);
               cRow = cRow+2;       
               SetCellValue( 1, sheetObj.id+"_"+"xtra_hndl_chg_flg" ,getSearchRow(sXmlM, 1,  "sheet1_"+"xtra_hndl_chg_flg")=="Y"?"1":"0" ,0);
               cRow = cRow+2;       
               SetCellValue( 1, sheetObj.id+"_"+"sft_gad_flg" ,getSearchRow(sXmlM, 1,  "sheet1_"+"sft_gad_flg")=="Y"?"1":"0" ,0);
               cRow = cRow+2;       
               SetCellValue( 1, sheetObj.id+"_"+"kep_sft_dist_ihb_flg" ,getSearchRow(sXmlM, 1,  "sheet1_"+"kep_sft_dist_ihb_flg")=="Y"?"1":"0" ,0);
               SetCellValue( 1, sheetObj.id+"_"+"kep_sft_dist_ihb_dist" ,getSearchRow(sXmlM, 1,  "sheet1_"+"kep_sft_dist_ihb_dist") ,0);
               document.form.rstr_rmk.value=getSearchRow(sXmlM, 1,  "sheet1_"+"rstr_rmk") ;
            }
         }       
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	 if( sAction  ==  IBSEARCH ){
             if( formObj.port_cd.value  == ""){
                 ComShowCodeMessage( "SCG50007", " Port Code"  );
//                 formObj.port_cd.focus();
                 return false;
             }
             if( formObj.optClass[0].checked   ){
                 if(comboObjects[0].GetSelectCode() == ""){
                     ComShowCodeMessage( "SCG50011", " Class"  );
//                     formObj.imdg_clss_cd.focus();
                     return false;
                 }
             }else{
                 if(formObj.imdg_un_no.value == "" ){
                     ComShowCodeMessage( "SCG50007", " UN No."  );
//                     formObj.imdg_un_no.focus();
                     return false;
                 }  
                 if(formObj.imdg_un_no.value.length != 4 ){
                     ComShowCodeMessage( "SCG50006", "UN No.", "4"  );
//                     formObj.imdg_un_no.select();
                     return false;
                 }                           
                 if(formObj.imdg_un_no_seq.value == "" ){
                     ComShowCodeMessage( "SCG50007", " UN No./Seq."  );
//                     formObj.imdg_un_no_seq.focus();
                     return false;
                 }                       
             }
         } 
         if( sAction  ==  IBDELETE ){
             if ( document.all.btn_delete.className == "btn1_1" ){
                 return false;
             }
             if( formObj.imdg_port_rstr_seq.value == ""){
                 return false;
             } 
             if( !ComShowCodeConfirm('SCG50002' , 'data' ) ){
                 return false;
             }
         }
         if( sAction  ==  IBSAVE ){
             if( formObj.port_cd.value  == ""){
                 ComShowCodeMessage( "SCG50007", " Port Code"  );
//                 formObj.port_cd.focus();
                 return false;
             }             
             if( formObj.optClass[0].checked   ){
                 if(  imdg_clss_cd.GetSelectText()== ""  ){
                     ComShowCodeMessage( "SCG50011", " Class"  );//'Please select {?msg1}';
//                     formObj.imdg_clss_cd.focus();
                     return false;                              
                 }
             }else{
                 if(  formObj.imdg_un_no.value == ""   ){
                     ComShowCodeMessage( "SCG50007", " UN No."  );//'Please input {?msg1}.'
//                     formObj.imdg_un_no.focus();
                     return false;                              
                 }
                 if( formObj.imdg_un_no.value.length != 4 ){
                     ComShowCodeMessage( "SCG50006", " UN No.","4"  );
//                     formObj.imdg_un_no.select();
                     return false;
                 }                       
                 if(  formObj.imdg_un_no_seq.value == "" ){
                     ComShowCodeMessage( "SCG50007", " UN No./Seq."  );//'Please input {?msg1}.'
//                     formObj.imdg_un_no_seq.focus();
                     return false;       
                 } 
             }
             var cByte=ComGetLenByByte(formObj.rstr_rmk  );
             if ( cByte > 4000  ){
                 ComShowCodeMessage("COM12142", "［Remark(s)］", "4000byte (Current:"+cByte+")");
                 formObj.rstr_rmk.focus();
                 return false;
             }
             if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
                 return false;   
             }
             for(var i=0;i<sheetObjects.length;i++){
          	   var ibflag=sheetObjects[i].GetRowStatus(0);
                 if( ibflag == "U"){
              	   sheetObjects[0].GetRowStatus[0]="U";
                 }
             }
         }   
         return true;
     }
    // event when cell value changes
    function sheet1_OnChange(sheetObj, Row, Col, Value)
    {  
        with(sheetObj)
        {
             if( ColSaveName(Col) == sheetObj.id+"_prohi_lod_flg" ){
                 if( Value == 1 ){
                      for(var i=1;i<2;i++){
                          ScgRowClear(sheetObjects[i], 1);                                
                          ScgGetRowEditable(sheetObjects[i], 1, "", false);
                      }
                 }else{
                      for(var i=1;i<2;i++){
                          ScgGetRowEditable(sheetObjects[i], 1, sheetObjects[i].id+"_load", true);
                          ScgRowClear(sheetObjects[i], 1);      
                      }                         
                 }
             }
             if( ColSaveName(Col) == sheetObj.id+"_prohi_dchg_flg"  ){
                 if( Value == 1){
                     for(var i=1;i<2;i++){      
                          ScgRowClear(sheetObjects[i], 2);                               
                          ScgGetRowEditable(sheetObjects[i], 2, "", false);
                     }
                 }else{
                    for(var i=1;i<2;i++){   
                        ScgGetRowEditable(sheetObjects[i], 2, sheetObjects[i].id+"_dis", true);
                        ScgRowClear(sheetObjects[i], 2);      
                    }                       
                 }
             } 
             if( ColSaveName(Col) == sheetObj.id+"_prohi_ts_flg"  ){
                 if( Value == 1){
                     for(var i=1;i<2;i++){                       
                         ScgRowClear(sheetObjects[i], 3);   
                         ScgGetRowEditable(sheetObjects[i], 3,   "", false);
                     }
                 }else{
                     for(var i=1;i<2;i++){  
                         ScgGetRowEditable(sheetObjects[i], 3,   sheetObjects[i].id+"_ts|"+sheetObjects[i].id+"_ts_L5|"+sheetObjects[i].id+"_ts_L6|"+ sheetObjects[i].id+"_ts_L7|"+
                                 sheetObjects[i].id+"_ts_L8|"+sheetObjects[i].id+"_ts_one_tm_hndl_max_qty", true);                                     
                     }                          
                 }
             }
             if( ColSaveName(Col) == sheetObj.id+"_prohi_pass_flg"  ){
                 if( Value == 1){
                      for(var i=1;i<2;i++){     
                         ScgRowClear(sheetObjects[i], 4);                                 
                         ScgGetRowEditable(sheetObjects[i], 4,   "", false);
                      }
                 }else{
                      for(var i=1;i<2;i++){   //
                         ScgGetRowEditable(sheetObjects[i], 4, sheetObjects[i].id+"_pass|"+sheetObjects[i].id+"_pass_one_tm_hndl_max_qty|"+sheetObjects[i].id+"_pass_L8", true);
                      }                         
                 }
             }               
        }
    }
    /**
     * 
     */
    /**
     *   Cell clear.
     * @param sheetObj
     * @param Row
     * @return
     */
    function ScgRowClear(sheetObj, Row){
        var Col=sheetObj.LastCol();
        for(var i=0;i<= Col;i++){
             if (  sheetObj.GetCellEditable(Row, i) == true  ){
                 if( sheetObj.id == 'sheet5'){
                      if( Row == 3){
                         sheetObj.SetCellValue(Row, 2,0,0);
                         sheetObj.SetCellValue(Row, 6,0,0);
                      }
                 }
                 if ( sheetObj.GetCellProperty(Row, i,"Type")== "CheckBox"  ){
                      sheetObj.SetCellValue(Row, i,0,0);
                 }       
                 if ( sheetObj.GetCellProperty(Row, i,"Type")==  "Float"  ){
                    sheetObj.SetCellValue(Row, i,"",0);
                 }
             }
        }
    }
    // event when cell value changes
    function sheet2_OnChange(sheetObj, Row, Col, Value)
    {  
        with(sheetObj)
        {
             if( ColSaveName(Col) == sheetObj.id+"_load_cmptn_auth_cd_p" ){
                 if( Value == 1 ){
                     SetCellValue( Row, sheetObj.id+"_load_cmptn_auth_cd_d" ,0,0);
                     SetCellValue( Row, sheetObj.id+"_load_cmptn_auth_cd_n" ,0,0);
                 } 
             }
             if( ColSaveName(Col) == sheetObj.id+"_load_cmptn_auth_cd_d" ){
                 if( Value == 1 ){
                     SetCellValue( Row, sheetObj.id+"_load_cmptn_auth_cd_p" ,0,0);
                     SetCellValue( Row, sheetObj.id+"_load_cmptn_auth_cd_n" ,0,0);
                 } 
             }
             if( ColSaveName(Col) == sheetObj.id+"_load_cmptn_auth_cd_n" ){
                 if( Value == 1 ){
                     SetCellValue( Row, sheetObj.id+"_load_cmptn_auth_cd_p" ,0,0);
                     SetCellValue( Row, sheetObj.id+"_load_cmptn_auth_cd_d" ,0,0);
                 } 
             }               
        }
    }  
    /**
     * Handling Object Onchange event in Form
     * 
     * @return void
     */
     function obj_change(){
        obj=ComGetEvent();
        var formObj=document.form;
        //alert(obj.name);
        switch(obj.name ) {
            case "optClass":
//              for(var i =0;i<sheetObjects.length;i++){
//              //    setInitValue(sheetObjects[i], true);
//              }
                break;
            case "imdg_un_no_seq":
               if( document.form.imdg_un_no.value.length  == 4  && document.form.imdg_un_no_seq.value.length  > 0 ){ //}!= ""    ){
                       doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC02);
                   }  
               break;
           case "imdg_un_no":
               if( formObj.imdg_un_no.value.length  == 4    ){
                   doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC03);
               }
               break;
           case "port_cd":                
               if( formObj.port_cd.value.length  == 5 && formObj.popupYN.value != "Y"){
            	   popPass = true;
                }else if( formObj.port_cd.value.length  == 5 && formObj.popupYN.value == "Y" && pCnt > 0){
                   popPass = true;
                }else{	//popPass > false > 처음에 셋팅되는 로직
                   pCnt = 1;
                   
                   if(formObj.popupYN.value == "Y"){ //팝업인 경우 셋팅 - UN No./Seq. 활성   
	                   initUnno();
                   }
                }
               
                if(popPass){
            	   document.form.port_cd_nm.value="";
                   imdg_clss_cd.SetSelectIndex(-1);
                   document.form.imdg_clss_cd_desc.value="";
                   document.form.imdg_un_no.value='';
                   document.form.imdg_un_no_seq.value='';    
                   document.form.prp_shp_nm.value='';                       
                   fnGridEnble(false);
                   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 
                }
               break;          
        } // end switch 
     } 
    /**
     * Handling Object OnBLur event in Form
     * 
     * @return void
     */        
     function obj_blur(){ 
         var obj = ComGetEvent();
         var formObj=document.form;
         switch(ComGetEvent("name")) {
             case "port_cd":
                 if( formObj.port_cd.value != ""){
                     if(!ComChkObjValid(obj)){       
                         obj.focus(); 
                         obj.select(); 
                         formObj.port_cd_nm.value = "";
                         formObj.port_cd.value = "";
                         return false;
                     }
                     else{
                    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01); 
                     }
                 }
                 break;          
            case "imdg_un_no":
                 if( formObj.imdg_un_no.value != "" ){
                     if(!ComChkObjValid(obj)){       
                         obj.focus(); 
                         obj.select();                          
                         return false;
                     }
                 }
                 break;
            case "imdg_un_no_seq":
//                 if( formObj.imdg_un_no.value.length  == 4  && formObj.imdg_un_no_seq.value.length  != ""    ){
//                     doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC02);
//                 }  
//                 break;              
         }
     }
     function obj_click(){
        var obj=ComGetEvent();
        if(obj.name == "optClass"){
            if(obj.value == "class"){
                initClass();
                fnGridEnble(false);
            }
            if(obj.value == "unno"){
                initUnno();
                fnGridEnble(false);
            }
        }    
      }
    /**
     * Handling Object Onkeyup event in Form
     * 
     * @return void
     */     
//      function obj_keyup(){
//         obj=ComGetEvent();
//         var formObj=document.form;
//         switch(obj.name ) {
//            case "imdg_un_no":
//                fnGridEnble(false);
//                formObj.imdg_un_no_seq.value="";
//                formObj.prp_shp_nm.value=''; 
//                imdg_clss_cd.SetSelectCode("",false);
//                imdg_clss_cd_desc.value="";              
//                 if( formObj.imdg_un_no.value.length  == 4     ){
//                     fnGridEnble(false);
//                     formObj.imdg_un_no_seq.value='';    
//                     formObj.prp_shp_nm.value='';                     
//                     formObj.imdg_un_no_seq.focus();
//                     imdg_clss_cd.SetSelectCode("",false);
//                     imdg_clss_cd_desc.value="";               
//                     if( formObj.imdg_un_no.value.length  == 4     ){
//                         doActionIBSheet(sheetObjects[0], formObj,IBSEARCH_ASYNC03);
//                     }
//                 }  
//                break;
//            case "imdg_un_no_seq":
//                 fnGridEnble(false);
//                 if( formObj.imdg_un_no_seq.value == '' ){
//                     formObj.imdg_un_no_seq.value="";
//                 }
//                 formObj.prp_shp_nm.value=''; 
//                 imdg_clss_cd.SetSelectCode("",false);
//                 imdg_clss_cd_desc.value="";              
//                 break;
//            case "port_cd"://Retrieve prp_shp_nm when Un No or Seq is inserted
//                 if( document.form.port_cd.value.length  == 5    ){
//                	document.form.port_cd_nm.value="";
//                    imdg_clss_cd.SetSelectIndex(-1);
//                    imdg_clss_cd_desc.value="";
//                    document.form.imdg_un_no.value='';
//                    document.form.imdg_un_no_seq.value='';    
//                    document.form.prp_shp_nm.value='';                       
//                    fnGridEnble(false);
//                    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);                    
//                 }     
//                 break;
//         } // end switch
//     }        
    /**
     * 
     */
//     function obj_keypress(){
//        obj=ComGetEvent();
//        var formObj=document.form;
//        switch(obj.name ) {
//            case "port_cd":  
//                  ComKeyOnlyAlphabet('upper');  
//                 break;
//        } // end switch
//     }
     /**
      * Mouse down handling event
      * @return
      */
     function mouse_down(){
         var obj=ComGetEvent();
         var formObj=document.form;
         switch ( obj.id ){
            case "btn_Retrieve":                
                callbackEvent="btn_Retrieve";     
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
 	function returnPortHelp(rtnObjs){
 		var formObj=document.form;
 		var sheetObj=null;
 		if(rtnObjs){
 			var rtnDatas=rtnObjs;
 			if(rtnDatas){
 				if(rtnDatas.length > 0){
 					formObj.port_cd.value=rtnDatas;
 					doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC01);
 				}
 			}
 		}
 	}     
     
   /**
    * Retrieving Unno, seq, ClassCd by Unno Help Popup
    * @param  {Array} aryPopupData  compulsory   Array Object
    * @param  {Int} row             optional Row
    * @param  {Int} col             optional Column
    * @param  {Int} sheetIdx        optional Sheet Index
    * @return none
    */  
    function setUnnoAndClassCd(aryPopupData){
        with(document.form){
            //imdg_clss_cd.Text2    = aryPopupData[0][4]; 
            imdg_un_no.value=aryPopupData[0][2];      
            imdg_un_no_seq.value=aryPopupData[0][3];                  
            prp_shp_nm.value=aryPopupData[0][6]; 
            imdg_un_no_seq.focus();
            imdg_un_no_seq.select();
            //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);              
        }
    }
    function setPortCd(aryPopupData){
        with(document.form){
            port_cd.value=aryPopupData[0][2];
            doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC01);               
        }
    }
    
    /**
     * 
     */
//     function OnSearchEnd(obj, msg){
//         alert( msg );
//     }
    /**
     *  Change retrieving option Class style by OptClass item setting
     * @return
     */
    function initClass(){
        var formObj=document.form;
        imdg_clss_cd.DisabledBackColor="#E8E7EC"; 
        imdg_clss_cd.SetEnable(1);
        formObj.imdg_un_no_seq.readOnly=true;
        formObj.imdg_un_no.readOnly=true;
        formObj.imdg_un_no.className='input2';
        formObj.imdg_un_no_seq.className='input2';
        //formObj.srch_imdg_un_no.style.display = "none"; 
        formObj.imdg_un_no.value='';
        formObj.imdg_un_no_seq.value='';
        formObj.prp_shp_nm.value='';          
        ComEnableObject( document.all.srch_imdg_un_no, false);
//      document.all.srch_imdg_un_no.src =  '/opuscntr/img/btns_search_off.gif';   
//      document.all.srch_imdg_un_no.className='';
    }     
    /**
     *  Change retrieving option Class style by OptClass item setting
     * @return
     */
    function initUnno(){
        var formObj=document.form;
        imdg_clss_cd.DisabledBackColor="#eeeeee"; 
        imdg_clss_cd.SetEnable(0);
        imdg_clss_cd.SetSelectText("",false);
        formObj.imdg_clss_cd_desc.value="";       
//        formObj.imdg_un_no.className='input1';
        formObj.imdg_un_no.readOnly=false;
        formObj.imdg_un_no_seq.readOnly=false;        
        $("input[name=imdg_un_no]").attr('validate', 'required:true');
        $("input[name=imdg_un_no_seq]").attr('validate', 'required:true');
        formObj.imdg_un_no.className='input1';
        formObj.imdg_un_no_seq.className='input1';
        formObj.srch_imdg_un_no.style.display=""; 
        formObj.imdg_un_no.focus();
        formObj.imdg_un_no.select();    
        ComEnableObject( document.all.srch_imdg_un_no, true);       
//      document.all.srch_imdg_un_no.src =  '/opuscntr/img/btns_search.gif';   
//      document.all.srch_imdg_un_no.className='Cursor';        
    }    
     /**
      * Class combo OnChange event handling
      * @param comboObj
      * @param value
      * @param text
      * @return
      */
     function imdg_clss_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
         document.form.imdg_clss_cd_desc.value= comboObj.GetText(newCode, 1); 
         fnGridEnble(false);
     }
      /**
       * one-line xml retrieve
       *    two savename | use.
       * @param xmlStr
       * @param savename
       * @return
       */
      function getSearchRow(xmlStr, cRowIndx, savename)  {
          if (xmlStr == null || xmlStr == ""  ) {
               return;
          }
          if (savename  == null || savename == ""  ) {
              return;
          }
          try {
        	  var xmlDoc = ComGetXmlDoc(xmlStr);
        	  if (xmlDoc == null) return;
        	  var xmlRoot = xmlDoc.documentElement;
        	  if (xmlRoot == null) return;
                var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
                if (dataNode == null || dataNode.attributes.length < 3) {
                        return;
                }
                var col=dataNode.getAttribute("COLORDER");
                var colArr=col.split("|");
                var sep=dataNode.getAttribute("COLSEPARATOR");
                var dataChildNodes=dataNode.childNodes;
                if (dataChildNodes == null) {
                        return;
                }
                //getSearchRow(sXml, 3, sheetObj.id+"_"+"ts_imdg_cmptn_auth_cd"); 
                var colListIdx=Array();
                var arrText=savename.split("|");
                for (var i=0; i < colArr.length; i++) {
                        for (var j=0; j < arrText.length; j++) {
                                if (colArr[i] == arrText[j]) {
                                        colListIdx[j]=i;
                                }
                        }
                }
                /*var TOTAL_ROWS=eval( dataNode.getAttribute("TOTAL") );
                if(  cRowIndx   >  TOTAL_ROWS ){
                    return "";
                }*/
                var cIdx = dataChildNodes[cRowIndx-1].nodeType == Node.TEXT_NODE ? cRowIndx : cRowIndx - 1;
                var arrData=dataChildNodes[cIdx].firstChild.nodeValue.split(sep);
                var trData="";
                for (var j=0; j < colListIdx.length; j++) {
                        trData += arrData[colListIdx[j]];
                }
                return trData;
          } catch (err) {
                 ComFuncErrMsg(err.message);
         }               
    }
   function getColOrder(xmlStr)  {
        try {
        	var xmlDoc = ComGetXmlDoc(xmlStr);
        	if (xmlDoc == null) return;
        	var xmlRoot = xmlDoc.documentElement;
             if (xmlRoot == null) {
                     return;
             }
             var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
             if (dataNode == null || dataNode.attributes.length < 3) {
                     return;
             }
             var col=dataNode.getAttribute("COLORDER");
             return col;
       } catch (err) {
              ComFuncErrMsg(err.message);
       }               
 }
   function getTotal(sXml){
        if ( sXml == null  || sXml == "" ) return;
        try {
        	var xmlDoc = ComGetXmlDoc(sXml);
        	if (xmlDoc == null) return;
        	var xmlRoot = xmlDoc.documentElement;
            if(xmlRoot == null) return;
            var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
            if(dataNode == null) return "";
            return dataNode.getAttribute("TOTAL");
        } catch(err) { ComFuncErrMsg(err.message); }
    }   
   function getMessage(sXml){
        if ( sXml == null  || sXml == "" ) return;
        try {
        	var xmlDoc = ComGetXmlDoc(sXml);
        	if (xmlDoc == null) return;
        	var xmlRoot = xmlDoc.documentElement;
            if(xmlRoot == null) return;
            var msgNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
            if(msgNode == null) return "";
            return msgNode.firstChild.nodeValue;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
   function getTrAllValue(sXml){
        if ( sXml == null  || sXml == "" ) return;
        try {
        	var xmlDoc = ComGetXmlDoc(sXml);
        	if (xmlDoc == null) return;
        	var xmlRoot = xmlDoc.documentElement;
            if(xmlRoot == null) return;
            var msgNode=xmlRoot.getElementsByTagName("TR-ALL").item(0);
            if(msgNode == null) return "";
            return msgNode.firstChild.nodeValue;
        } catch(err) { ComFuncErrMsg(err.message); }
    }  
   /**
    *  row Editable 
    * @param sheetObj
    * @param cRow  row 
    * @param exept cCols  ex) aaa|bbb|
    * @return
    */
   function ScgGetRowEditable(sheetObj, cRow, cSaveNames, tf){
       var aSaveNames=cSaveNames.split("|");
       sheetObj.SetRowEditable(cRow,tf);
       for(var i=0;i<aSaveNames.length;i++){
           var switchvalue=!tf;
           sheetObj.SetCellEditable(cRow, aSaveNames[i] ,switchvalue);
       }
   }
    /**
     * grid Enable = true or false
     */    
    function fnGridEnble( yn ){
        var formObj=document.form;
        if( yn ){
        	//console.log("2222222222222");
            for(i=0;i<sheetObjects.length;i++){
                setInitValue(sheetObjects[i], true);                          
            }
        }else{
        	//console.log("3333333333333");
            fnNewGrid();   
            formObj.rstr_rmk.value="";
        }
        
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
//         for(var i=0;i<sheetObjects.length;i++){
//             var cnt=sheetObjects[i].RowCount();
//             for(var j=1;j<= cnt;j++ ){
//                 sheetObjects[i].RowDelete(1, false);
//             }
//         }
         document.form.imdg_port_rstr_seq.value="";
     }     
   /***************************************
    * setting CmptnAuthCd
    *
    * @param void
    * @return
    ***************************************/
    function setCmptnAuthCd (){
         var load_cmptn_auth_cd="";
         var dis_cmptn_auth_cd="";
         var ts_cmptn_auth_cd="";
         var pass_cmptn_auth_cd="";
         if (sheetObjects[1].GetCellValue(1, "sheet2_load_cmptn_auth_cd_p" ) ){
            load_cmptn_auth_cd="P";
         }
         if (sheetObjects[1].GetCellValue(1, "sheet2_load_cmptn_auth_cd_d" ) ){
                load_cmptn_auth_cd="D";
         }
         if (sheetObjects[1].GetCellValue(1, "sheet2_load_cmptn_auth_cd_n" ) ){
                load_cmptn_auth_cd="N";
         }  
         if(sheetObjects[1].GetCellValue(2, "sheet2_dis_cmptn_auth_cd_p" ) ){
             dis_cmptn_auth_cd="P";
         }
	 	if (sheetObjects[1].GetCellValue(2, "sheet2_dis_cmptn_auth_cd_d" ) ){
             dis_cmptn_auth_cd="D";
         }
	 	if (sheetObjects[1].GetCellValue(2, "sheet2_dis_cmptn_auth_cd_n" ) ){
             dis_cmptn_auth_cd="N";
         }  
	 	if (sheetObjects[1].GetCellValue(3, "sheet2_ts_cmptn_auth_cd_p" ) ){
             ts_cmptn_auth_cd="P";
         }
	 	if (sheetObjects[1].GetCellValue(3, "sheet2_ts_cmptn_auth_cd_d" ) ){
             ts_cmptn_auth_cd="D";
         }
	 	if (sheetObjects[1].GetCellValue(3, "sheet2_ts_cmptn_auth_cd_n" ) ){
             ts_cmptn_auth_cd="N";
         } 
	 	if (sheetObjects[1].GetCellValue(4, "sheet2_pass_cmptn_auth_cd_p" ) ){
             pass_cmptn_auth_cd="P";
         }
	 	if (sheetObjects[1].GetCellValue(4, "sheet2_pass_cmptn_auth_cd_d" ) ){
             pass_cmptn_auth_cd="D";
         }
	 	if (sheetObjects[1].GetCellValue(4, "sheet2_pass_cmptn_auth_cd_n" ) ){
             pass_cmptn_auth_cd="N";
         }   
         document.form.load_imdg_cmptn_auth_cd.value=load_cmptn_auth_cd;
         document.form.dis_imdg_cmptn_auth_cd.value=dis_cmptn_auth_cd;
         document.form.ts_imdg_cmptn_auth_cd.value=ts_cmptn_auth_cd;
         document.form.pass_imdg_cmptn_auth_cd.value=pass_cmptn_auth_cd;
    }