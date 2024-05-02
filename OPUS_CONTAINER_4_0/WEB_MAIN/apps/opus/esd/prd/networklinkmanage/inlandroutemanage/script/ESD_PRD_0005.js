/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0005.js
*@FileTitle  : Inland Route Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     			OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable 
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var maxPrioSeq=0;
var i_origin="";
var i_destination="";
var validateData="";
var retValidate=0;
var priority_seq="";
var comData1="";
var comData2="";
var min_state='MIN';
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
            	  var btnDis=eval("document.getElementById('" + srcName + "').disabled");
                  if (btnDis) return;
              }
            /****************************
             handling enterKey
            *****************************/
            var srcObj=window.ComGetEvent("nodeName");
            var keyObj=window.event.keyCode;
            /****************************/
            switch(srcName) {
        	    case "btn_retrieve":
    	            if(!checkInput()) return false;
    	            if(!ComChkRequired(formObject)) return false;
    	            
    	            formObject.i_org_cd.value=formObject.i_org_cd_ib.value;
    	            formObject.i_dest_cd.value=formObject.i_dest_cd_ib.value;	
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
	                //if it is not USA, bottom form disable
    	            bottomFrmDisable(true);
                    bottomFrmClear(formObject);
    	            sheetObject1.RemoveAll();
            	        break;    
        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            var cntCd=formObject.cnt_cd.value;
    	            formObject.reset();
    	            formObject.cnt_cd.value=cntCd;
        	        break;
        	    case "btn_save":
    	             doActionIBSheet(sheetObject,formObject,IBSAVE);
    	             sheetObject1.RemoveAll();
    	             bottomFrmClear(formObject);
    	             formObject.i_org_cd.value=i_origin;
    	             formObject.i_dest_cd.value=i_destination;
    	             
        	         break;
        	     case "btng_listlink":
        	        var oriLoc="";
                    var destLoc="";
        	        if(sheetObject1.LastRow() != 0 ) {
        	        	oriLoc=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),"lnk_org_loc");
        	        	destLoc=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),"lnk_dest_loc");
        	        } else {
        	            sheetObject1.DataInsert(-1);
        	        }
        	        var param='?f_cmd=' + SEARCH12 +'&i_org_cd='+ oriLoc +'&i_dest_cd='+destLoc+"&row=" + sheetObject1.GetSelectRow()+ "&col=" + sheetObject1.GetSelectCol();
        	        myWin=ComOpenWindowCenter('ESD_PRD_0007.do'+param, 'compop', 700, 450, false);
		            myWin.focus();
        	        break;
          	    case "btng_save":
          	        /*
          	         * USA is not available in this screen(using 057)
          	         */
          	        if(isUsaInSheet(sheetObject1 )== true) {
          	            return ;
          	        }
          	        if(chkCombindMode(sheetObject1)) {
            	        doActionIBSheet2(sheetObject1,formObject,IBSAVE);          	            
          	        }
        	        break;
        	    case "btng_rowadd":
    	            doActionIBSheet2(sheetObject1,formObject,IBINSERT);
        	        break;
                // 05. Location (COM_ENS_051)
                case "btn_org_loc":
                   dispaly="1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	       classId="COM_ENS_051";
        		   param='?classId='+classId;
        		   chkStr=dispaly.substring(0,3);
                       // radio PopUp  
                       if(chkStr == "1,0") {
                    	   ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getOrgLoc', dispaly, true);
                       } else {
                           ComShowMessage(ComGetMsg('PRD90063'));
                           return;
                      }
                  break;
               case "btn_dest_loc":
                   dispaly="1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
        	       classId="COM_ENS_051";
        		   param='?classId='+classId;
        		   chkStr=dispaly.substring(0,3)
                       // radio PopUp  
                       if(chkStr == "1,0") {
                           ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getDestLoc', dispaly, true);
                       } else {
                           ComShowMessage(ComGetMsg('PRD90063'));
                           return;
                      }
                  break;
               case "btng_clear":
                  sheetObject1.RowDelete(sheetObject1.LastRow(),1)
                  break;
        	   case "btng_new":
        	        sheetObject1.SetEditable(1);
        	        ComEnableObject(formObject.i_inv,true);
        	        ComEnableObject(formObject.i_rout_pln_cd,true);               
    	            sheetObject1.RemoveAll();
    	            bottomFrmClear(formObject);
    	            formObject.i_org_cd.value=i_origin;
    	            formObject.i_dest_cd.value=i_destination;
        	        break;         
        	   /*
        	    * in case of 'SAVEAS'
        	    * it is possible to make IRG which is different from search condition of FROM and TO
        	    * IRG can be made easily using details of similar master by double-clicking 
        	    * 
        	    */     
               case "btng_saveas" :
                    /*
          	         * USA is not available in this screen(using 057)
          	         */
          	        if(isUsaInSheet(sheetObject1 )== true) {
          	            return ;
          	        }
                    if(!confirm(ComGetMsg('PRD90043'))) {
                        break;
                    };
                    if(!chkCombindMode(sheetObject1)) {
                        break;
          	        }
                    // checking connection
                    if(!checkRoute3(sheetObject1,formObject)) {
                        break;
                    }
           	        doActionIBSheet2(sheetObject1,formObject, MULTI02);  
                    break;
 			   case "ib_org_tml_btn":
 			   		selectTml(formObject,'IB_ORG_TML');
 			   		break;     	        
 			   case "ib_dest_loc_btn":
 				    selectTml(formObject,'IB_DEST_LOC');
 			   		break;        	                 
    		   case "btn_minimize":
                    sheetMinimize(sheetObject);
    			    break; 		
               case "btn_downexcel":
					if(sheetObject.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
	                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					}
                    break;    			    	   				   					   				   		
            } 
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111'));
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    function doIBSheetClear(sheetObj) {
        var firstChk=false;
        var firstChkRow=0;
        for( i=1; i<=+sheetObj.RowCount(); i++) {
        	if(firstChk ==true && i> firstChkRow && sheetObj.GetCellValue(i,"clear_chk")!=1 ){
                 sheetObj.SetCellValue(i,"clear_chk",1,0);
            }
        	if(sheetObj.GetCellValue(i,"clear_chk")==1){
                if(firstChk ==false){
                    firstChk=true;
                    firstChkRow=i;
                }
                sheetObj.SetCellValue(i,"lnk_org_loc","",0);
                sheetObj.SetCellValue(i,"lnk_org_type","",0);
                sheetObj.SetCellValue(i,"lnk_dest_loc","",0);
                sheetObj.SetCellValue(i,"lnk_dest_type","",0);
                sheetObj.SetCellValue(i,"trsp_mod_cd","",0);
                sheetObj.SetCellValue(i,"spname","",0);
                sheetObj.SetCellValue(i,"vndr_seq","",0);
                sheetObj.SetCellValue(i,"vndr_name","",0);
                sheetObj.SetCellValue(i,"tztm_hrs","",0);
                sheetObj.SetCellValue(i,"rail_crr_tp_cd","",0);
                sheetObj.SetCellValue(i,"inlnd_rout_junc_nm","",0);
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
		axon_event.addListener('keypress', 'PrdComKeyEnter' , 'i_org_cd_ib', 'i_dest_cd_ib');
		ComSetUIItem(sheetObjects[0],document.form,'PRD','ESD_PRD_0005');
		itemControl(sheetObjects[0],document.form,'');
		doActionIBSheet(sheetObjects[0],document.form,SEARCH03);
    }
    var item_vndr='N';
    function itemControl(sheetObj,formObj,sAction) {
   	// function skip 로직
    	if(undefined != formObj.skip_flag_fun_itemControl && "Y" == formObj.skip_flag_fun_itemControl.value) {
    		item_vndr='Y';
    		return;
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
            	      var HeadTitle="Del.|BKG|CHK|STS|Priority|ORG Node|DEST Node|Route|Tmp Flg|FREE SHTL|Currency|Total Cost(or USD)|Total T/T|C.user|C.OFC|C.Date|U.user|U.Date|D.user|D.Date|Remarks" ;

            	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	      InitHeaders(headers, info);

            	      var cols = [ {Type:"DelCheck",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"delChk",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
            	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"bkg_chk",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1, TrueValue:"Y", FalseValue:"N"  },
            	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"un_del",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
            	             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"prio_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2},
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rout_org_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rout_dest_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:470,  Align:"Left",    ColMerge:0,   SaveName:"route",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rout_tmp_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, TrueValue:"Y", FalseValue:"N" },
            	             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rout_incl_sttl_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, TrueValue:"Y", FalseValue:"N" },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:120,  Align:"Right",   ColMerge:0,   SaveName:"ttl_cost",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tot_tt",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_id",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_ofc",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_date",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_id",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"upd_date",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"del_id",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"del_date",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"inlnd_rout_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hub_search_gb",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"front_gb",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"undefine_nod",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"group_gubun",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ori_prio_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"ori_loc",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ori_loc_type",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dest_loc_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
            	       
            	      	InitColumns(cols);
            	      	SetEditable(1);
            	      	SetSheetHeight(290 );
        	            SetColProperty("tot_tt", {Format:"##D##H"} );
    	            	SetColProperty(0 ,"ori_loc" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
    	            	SetColProperty(0 ,"ori_loc_type" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
    	            	SetColProperty(0 ,"dest_loc" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
    	            	SetColProperty(0 ,"dest_loc_type" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
           	         	SetColProperty(0 ,"prio_seq" , 	 {AcceptKeys:"N",	ExceptKeys:"[-]", 	DefaultValue:"99",	AllowNull:false,	Focus:true});
            	      }


                break;
            case 2:      //IBSheet2 init
                with(sheetObj){
            	      var HeadTitle="Del.|STS|SEQ|Clear|From Node|From Node|To Node|To Node|Mode|S/P Name|S/P Name|T/T(DD.HH)|AGMT No|Reference No|Combined Mode|C/TOFC|Junction|Currency|Cost|Expiry Date|a|b|c|d|e|f|g" ;

            	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

            	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	      InitHeaders(headers, info);

            	      var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"",                         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibseq",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"clear_chk",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lnk_org_loc",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 ,},
            	             {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"lnk_org_type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
            	             {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lnk_dest_loc",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
            	             {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:"lnk_dest_type",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
            	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"trsp_mod_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",                 KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"vndr_name",                KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"tztm_hrs",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"refe_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"CheckBox",  Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"combined_md",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N"},
            	             {Type:"Combo",     Hidden:0, Width:85,   Align:"Left",    ColMerge:0,   SaveName:"rail_crr_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"inlnd_rout_junc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",       			  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"agree_rate",       		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_to_dt",       		  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },            	  
            	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lnk_org_nod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"lnk_dest_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"clon_trsp_mod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_org_nod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_dest_nod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_seq",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rout_dtl_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"selRow",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"clon_vndr_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"clon_agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:9 },
            	             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"clon_combined_md",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:85,   Align:"Left",    ColMerge:0,   SaveName:"clon_rail_crr_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"clon_inlnd_rout_junc_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            	       
            	      		  InitColumns(cols);

            	      			SetEditable(1);
            	              	SetColProperty("trsp_mod_cd", {ComboText:trsp_mod_cdText, ComboCode:trsp_mod_cdCode} );
            	            	SetColProperty("rail_crr_tp_cd", {ComboText:rail_crr_tp_cdText, ComboCode:rail_crr_tp_cdCode} );
            	            	SetColProperty(0, "tztm_hrs", {AcceptKeys:"N", Format:"##.##"} );
            	            	SetColProperty(0 ,"lnk_org_loc" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
            	            	SetColProperty(0 ,"lnk_org_type" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
            	            	SetColProperty(0 ,"lnk_dest_loc" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
            	            	SetColProperty(0 ,"lnk_dest_type" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
            	            	SetColProperty(0 ,"vndr_seq" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
            	            	SetColProperty(0 ,"agmt_no" , {Accagmt_noeptKeys:"E|N" , InputCaseSensitive:1});
            		  	        SetSheetHeight(180);
            		  	        ComResizeSheet(sheetObj, 80);
            	      }
                break;
        }
    }
  // handling of Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var sXml ;
        switch(sAction) {
           case IBSEARCH:      
               formObj.f_cmd.value=SEARCHLIST;
               i_origin=formObj.i_org_cd.value;
               i_destination=formObj.i_dest_cd.value;
               sheetObj.DoSearch("ESD_PRD_0005GS.do", PrdFQString(formObj), {Sync:2} );
               break;
            case IBSAVE: 
                 if(!checkRouteList(sheetObj)) return false;
                 formObj.f_cmd.value=MULTI;
                 sheetObj.DoSave("ESD_PRD_0005GS.do", {Param:PrdFQString(formObj), Sync:2} );
                 break;
           case IBCOPYROW:       
              sheetObj.DataCopy();
              break;
           case IBDOWNEXCEL:        
        	   sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
              break;
           case SEARCH02:
              formObj.f_cmd.value=SEARCH02;
              sXml=sheetObj.GetSaveData("PRD_VALIDATE.do","uid=ESD_PRD_0005&check_data="+validateData+"&"+PrdFQString(formObj));
              retValidate=ComGetEtcData(sXml, "rowCount");
              break;              
           case SEARCH05:
              formObj.f_cmd.value=SEARCH05;
              sXml=sheetObj.GetSaveData("PRD_VALIDATE.do","uid=ESD_PRD_0005&check_data="+validateData+"&"+PrdFQString(formObj));
              retValidate=ComGetEtcData(sXml, "rowCount");
              break; 
           case SEARCH03:
              formObj.f_cmd.value=SEARCH03;
 	          var sXml=sheetObj.GetSearchData("ESD_PRD_0005GS.do", PrdFQString(formObj));
 	          formObj.cnt_cd.value=ComGetEtcData(sXml,"cnt_cd");
 	      	  break;
        }
    }
    // sheet1 double click event
    function sheet1_OnDblClick(sheetObj, row, col, value) {
        var formObj=document.form;
        formObj.i_sel_row.value=row;
        doActionIBSheet2(sheetObjects[1],formObj, IBSEARCH);  //sheetObjects[1]->sheet2
    }
    function sheet1_OnSearchEnd(sheetObj,ErrMsg)
    {
        if(sheetObj.RowCount()>0) {
        	ComBtnEnable("btn_save");
        } 
    }  
    
    function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
    	var formObj=document.form;
    	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
    }  
    
    function sheet2_OnSearchEnd(sheetObj,ErrMsg)  {
        var formObj=document.form;
        if(chkAmericanContinent(formObj)) {
            var findRd=false;
            sheetObj.FindText("trsp_mod_cd" , "RAIL" , 0+parseInt(sheetObj.HeaderRows()) , -1 )!= -1? findRd=true: "" ;
            //if there is NEW or MOD - if the start and the end is different, it's editable 
            var statusFlg=false;
            //no support[check again]CLT 
            for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
            	if(sheetObj.GetRowStatus(i)=='I' || sheetObj.GetRowStatus(i)=='U') {
                    statusFlg=true;
                }
            }
        }else {
            sheetObj.SetEditable(1);
            ComBtnEnable("btng_save");
        }
        
        for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
        	sheetObj.SetCellEditable(i, "agmt_no",0);
        }
        
    }  
    /*
     * checking there are USA in grid
     */
    function isUsaInSheet(sheetObj )
    {
        //no support[check again]CLT 
    	for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
    		var lnk_org=sheetObj.GetCellValue(i,"lnk_org_loc")+sheetObj.GetCellValue(i,"lnk_org_type");
    		var lnk_dest=sheetObj.GetCellValue(i,"lnk_dest_loc")+sheetObj.GetCellValue(i,"lnk_dest_type");
            /*
             * USA is not available in this menu(using 057)
             */
            if( lnk_org.substring(0,2) == "US" ||lnk_org.substring(0,2) == "CA" || lnk_dest.substring(0,2) == "US" ||lnk_dest.substring(0,2) == "CA"  ) {
                ComShowMessage("Only Europe and Asia use possibility");
                sheetObj.RemoveAll();
                return true;  
            }
        }
        return false;
    } 
    //checking mandatory elements if the row has the case of USA Rail
    function chkMandatoryForAmerican(formObj, sheetObj) {
            // inv billing, Route Plan is mandatory input condition if it is the Americas and has RD in link 
            var invIdx=formObj.i_inv.selectedIndex;
            var routPlnIdx=formObj.i_rout_pln_cd.selectedIndex;
            var findRd=false;
            //no support[check again]CLT 
            for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
                sheetObj.FindText("trsp_mod_cd" , "RAIL" , i , -1 )!= -1? findRd=true: "" ;
            }
            if(findRd){
                if(invIdx ==0) {
                    ComShowMessage(ComGetMsg('PRD90017'));
                    formObj.i_inv.focus();
                    return false;
                } 
                if(routPlnIdx ==0) {
                    ComShowMessage(ComGetMsg('PRD90018'));
                    formObj.i_rout_pln_cd.focus();
                    return false;
                } 
                // In case of USA Rail, AGMT NO is mandatory item. 
                // In case of USA Rail, rail_crr_tp_cd is mandatory item.(c/tofc)  
                for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
					if( sheetObj.GetCellValue(i, "trsp_mod_cd") == "RD" ) {
						if( sheetObj.GetCellValue(i,"agmt_no")=="" || sheetObj.GetCellValue(i,"refe_no")=="" ) {
                            //'In case of USA Rail, AGMT NO(Reference No) is mandatory item.'
                            ComShowMessage(ComGetMsg('PRD90037'));
                            sheetObj.SelectCell(i,"agmt_no");
                            return false;
                        }
					if( sheetObj.GetCellValue(i,"rail_crr_tp_cd")==""  ) {
                            //'In case of USA Rail, C/T OFC is mandatory item.'
                            ComShowMessage(ComGetMsg('PRD90038'));
                            sheetObj.SelectCell(i,"rail_crr_tp_cd");
                            return false;
                        }
                    } else {
                    	if( sheetObj.GetCellValue(i,"agmt_no")!="" || sheetObj.GetCellValue(i,"refe_no")!="" ) {
                            //There is no authority to use the function.
                            ComShowMessage(ComGetMsg('PRD90039'));
                            sheetObj.SelectCell(i,"agmt_no");
                            return false;
                        }
                    	if( sheetObj.GetCellValue(i,"rail_crr_tp_cd")!=""  ) {
                        	//You just select a interim route which makes irregular route possible to a certain booking.\n\n 
                        	//It may contain incorrect cost or transit time, and cause unnecessary rehandling.\n\n 
                        	//Please, make sure your route with your supervisor or other reference available.'
                            ComShowMessage(ComGetMsg('PRD90040'));
                            sheetObj.SelectCell(i,"rail_crr_tp_cd");
                            return false;
                        }                        
                    }
                }  //FOR 
            }
            return true;        
    }
    // double click event - SHEET1, save event - SHEET2
    function chkCombindMode(sheetObj){
            // checking combindmode through all rd if inv billing,pattern starts with 'C','S'
            var formObj=document.form;
            var inv=formObj.i_inv.value;
            var firstRD=false;
            var lastRD=false;
            var firstRow=0;
            var lastRow=0;
            var combindChk=true;
			var rdLink1=false;
			var rdLink2=false;
			var rdLink3=false;
			var chkCnt=0;
			var rdCnt=0;
            //finding the first and last row which is RD. counting rd 
            if(inv.substring(0,1) == 'C' || inv.substring(0,1) == 'S') {
            	for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
            	if( firstRD == false && sheetObj.GetCellValue(i, "trsp_mod_cd") == "RD" ) {
                        firstRD=true;
                        firstRow=i;
                        lastRow=firstRow;
                        rdCnt++;
            	} else if(firstRD == true && sheetObj.GetCellValue(i, "trsp_mod_cd") == "RD")  {
                        lastRow=i ;
                        rdCnt++;
                    }
            	if(  sheetObj.GetCellValue(i,"combined_md")==1) chkCnt++;
                }      
                //ComShowMessage( 'firstrow:'+firstRow+' lastRow:'+lastRow+' rdCnt:'+rdCnt+ 'chkCnt:'+chkCnt +'lastRow-firstRow:'+eval(lastRow-firstRow) ); 
				//when the max of difference between 2 rds is 2 and The maximum number of RD link is 3 
				if( eval(lastRow-firstRow) > 2 || rdCnt > 3 ) {
	                combindChk=false;
	                ComShowMessage(ComGetMsg('PRD90021'));
	                return combindChk; 
				}
				// followings are only when the max of difference between 2 rds is 2 and the number of rds is under 4 
				// when including the RD-RD-RD 
				if( rdCnt == 3 && eval(lastRow-firstRow) == 2) {
					if(ComIsContainsChars(formObj.i_inv,"3")!=true) {
	                    ComShowMessage(ComGetMsg('PRD90034'));
	                    combindChk=false;
	                    return combindChk; 
					}
					for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
						if( sheetObj.GetCellValue(i,"combined_md")==1) {
	                		//rd range
	                		if( i < firstRow || i > lastRow) {
				                combindChk=false;
				                ComShowMessage(ComGetMsg('PRD90021'));
				                return combindChk;
	                		}
	                	} else {
	                		if( i >= firstRow && i <= lastRow) {
				                combindChk=false;
				                ComShowMessage(ComGetMsg('PRD90021'));
				                return combindChk;
	                		}
	                	}
	                }
	            // when including the RD-RD 
				} else if( rdCnt == 2 && eval(lastRow-firstRow)== 1){ // if it has two consecutive rds
					if(ComIsContainsChars(formObj.i_inv,"2")!=true) {
	                    ComShowMessage(ComGetMsg('PRD90034'));
	                    combindChk=false;
	                    return combindChk; 
					}
					for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
						if( sheetObj.GetCellValue(i,"combined_md")==1) {
	                		//out of range of rd
	                		if( i < firstRow || i > lastRow) {
				                combindChk=false;
				                ComShowMessage(ComGetMsg('PRD90021'));
				                return combindChk;
	                		}
	                	} else {
	                		if( i >= firstRow && i <= lastRow) {
				                combindChk=false;
				                ComShowMessage(ComGetMsg('PRD90021'));
				                return combindChk;
	                		}
	                	}
	                }
	            // when the number of rd is 2 and it is RD-TD-RD 
				} else if( rdCnt == 2 && eval(lastRow-firstRow)== 2){ 
					if(ComIsContainsChars(formObj.i_inv,"1")!=true) {
	                    ComShowMessage(ComGetMsg('PRD90034'));
	                    combindChk=false;
	                    return combindChk; 
					}
					for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
						if( sheetObj.GetCellValue(i,"combined_md")==1) {
			                combindChk=false;
			                ComShowMessage(ComGetMsg('PRD90021'));
			                return combindChk;
	                	}
	                }
				} else if( rdCnt == 1 ){ 
					if(ComIsContainsChars(formObj.i_inv,"1")!=true) {
	                    ComShowMessage(ComGetMsg('PRD90034'));
	                    combindChk=false;
	                    return combindChk; 
					}
					for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
						if( sheetObj.GetCellValue(i,"combined_md")==1) {
			                combindChk=false;
			                ComShowMessage(ComGetMsg('PRD90021'));
			                return combindChk;
	                	}
	                }
				} else if( rdCnt == 0 ){ 
	                var invIdx=formObj.i_inv.selectedIndex;
					if(invIdx >0) {
	                    ComShowMessage(ComGetMsg('PRD90034'));
	                    combindChk=false;
	                    return combindChk; 
					}
					for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
						if( sheetObj.GetCellValue(i,"combined_md")==1) {
			                combindChk=false;
			                ComShowMessage(ComGetMsg('PRD90021'));
			                return combindChk;
	                	}
	                }
				}
            } else { // checking that sp is same when mode is different and inv billing,pattern is not 'C','S' and combind mode is set
                var sp='';
                var firstCombindMode=false;
                var firstCombindCnt=0;
                var first_trsp_mod_cd='';
                for(var j=sheetObj.HeaderRows(); j < sheetObj.LastRow()+1 ; j++) {
					if( sheetObj.GetCellValue(j,"combined_md")==1 && firstCombindMode == false && sheetObj.RowCount()> 1){ //in case of first combind
						sp=sheetObj.GetCellValue(j, "vndr_seq");
						first_trsp_mod_cd=sheetObj.GetCellValue(j, "trsp_mod_cd");
                        firstCombindMode=true;
                        firstCombindCnt ++;
					} else if(sheetObj.GetCellValue(j,"combined_md")==1 && firstCombindMode == true && sheetObj.RowCount()> 1 ) {   //after first combind
						if( sp != sheetObj.GetCellValue(j, "vndr_seq") ) {
                            ComShowMessage(ComGetMsg('PRD90022'));
                            combindChk=false;
                            return combindChk;   
                        }
						if( first_trsp_mod_cd == sheetObj.GetCellValue(j, "trsp_mod_cd") ) {
                            ComShowMessage(ComGetMsg('PRD90075'));
                            combindChk=false;
                            return combindChk;   
                        }
                        firstCombindCnt ++;
					} else if(sheetObj.GetCellValue(j,"combined_md")==1 && sheetObj.RowCount()==1 ) {  // when there is 1 data
                            ComShowMessage(ComGetMsg('PRD90021'));
                            combindChk=false;
                            return combindChk;   
                    } else if( firstCombindMode == true && firstCombindCnt <2 ){ // when there is 1 checked data  
                            ComShowMessage(ComGetMsg('PRD90024'));
                            combindChk=false;
                            return combindChk;  
                    }
                }//for 
                if( firstCombindMode == true && firstCombindCnt <2 ){ // when there is 1 checked data  
                    ComShowMessage(ComGetMsg('PRD90024'));
                    combindChk=false;
                    return combindChk;  
                }
            }
            return combindChk;  
    }    
    // in case of selecting INV Billing
    function setCombindMode() {
        var sheetObj=sheetObjects[1];
        var formObj=document.form;
            var inv=formObj.i_inv.value;
            var firstRD=false;
            var lastRD=false;
            var firstRow=0;
            var lastRow=0;
            sheetObj.CheckAll("combined_md",0);
            //finding first and last row which is RD
            if(inv.substring(0,1) == 'C' || inv.substring(0,1) == 'S') {
            	for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
            		if( firstRD == false && sheetObj.GetCellValue(i, "trsp_mod_cd") == "RD" ) {
                        firstRD=true;
                        firstRow=i;
                        lastRow=firstRow;
            		} else if(firstRD == true && sheetObj.GetCellValue(i, "trsp_mod_cd") == "RD")  {
                        lastRow=i ;
                    }
                }                  
                //checking RD from the beginning to the end(not checking when it is RTR and the number of RD is 1)
                if( firstRow > 0){
                     for(j=firstRow ; j<= lastRow ; j++) {
                        //checking when the number of RD is 2 or 3
                        if(eval(lastRow-firstRow)==1 || eval(lastRow-firstRow)==2  ) {
                            sheetObj.SetCellValue(j,"combined_md",1,0);
                        }
                    }                   
                }
            }
    }
    // handling of Sheet process
    function doActionIBSheet2(sheetObj,formObj,sAction) {
    	var sXml ;
        // to show data in case of retrieving details(using event object which has link with hub) 
		var rout_org_nod_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"rout_org_nod_cd") ;
		var rout_dest_nod_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"rout_dest_nod_cd") ;
		var rout_seq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"rout_seq") ;
		var hub_search_gb=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"hub_search_gb") ;
		var front_gb=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"front_gb") ;
		var undefine_nod=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"undefine_nod") ;
        switch(sAction) {
           case IBSEARCH:      //click event of Sheet1 -> showing data on Sheet2 
               formObj.f_cmd.value=SEARCH;
               // to show data in case of retrieving details(using event object which has link with hub)
               formObj.i_rout_org_nod_cd.value=rout_org_nod_cd;
               formObj.i_rout_dest_nod_cd.value=rout_dest_nod_cd;
               formObj.i_rout_seq.value=rout_seq;
               formObj.i_hub_search_gb.value=hub_search_gb;
               formObj.i_front_gb.value=front_gb;
               formObj.i_undefine_nod.value=undefine_nod;
               //------------------------------------------------------------------------------------------
               sheetObj.DoSearch("ESD_PRD_0005GS.do", PrdFQString(formObj), {Sync:2}  );
               ComEtcDataToForm(formObj,sheetObj);
               formObj.detail_org_i_inv.value=sheetObj.GetEtcData("i_inv");
               formObj.detail_org_i_rout_pln_cd.value=sheetObj.GetEtcData("i_rout_pln_cd");
               formObj.detail_org_i_bkg_flg.value=sheetObj.GetEtcData("i_bkg_flg");
               formObj.i_mcntr_rout_flg.value=sheetObj.GetEtcData("i_mcntr_rout_flg");
               chkCombindMode(sheetObj);
               if (formObj.disable_bkg_flg.value == 'F') // F,T 
            	   ComEnableObject(formObj.i_bkg_flg,false);
               else 
            	   ComEnableObject(formObj.i_bkg_flg,true);
               break;
            case IBSAVE:        //saving detail( checking combind is done)
                // in case of USA Rail, c/TOFC will be enabled when retrieving details(it is not mandatory now)
              // if(!comCheckRequiredField(formObj)) return;
                if(validateForm(sheetObj,formObj,sAction))  
                var isNew=false;
                for (var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
                   //possible to save in case of 'NEW'. duplication will be checked on the server side 
                	if(isNew || sheetObj.GetRowStatus(i) =='I') {
                       isNew=true;
                   } else {
                       isNew=false;
                   }
                }//for1                
                if(!checkRoute2(sheetObj,formObj)) return;
                if(isNew){
                    sheetObjects[0].DataInsert(-1);
                    formObj.i_sel_row.value=sheetObjects[0].LastRow(); //row number of master which will be set after saving detail
                }
                formObj.f_cmd.value=MULTI01;
                var SaveStr=sheetObj.GetSaveString(true);
                if (sheetObj.IsDataModified()&& SaveStr == "") return;
                sXml=sheetObj.GetSaveData("ESD_PRD_0005MST_ROWSEARCH.do",SaveStr+"&"+PrdFQString(formObj)+"&isNew="+isNew);
                var strErrMsg = ComGetEtcData(sXml,'strErrMsg');
                if(strErrMsg ==''){
                    sheetObj.RemoveAll();
                    bottomFrmClear(formObj);
                    formObj.i_org_cd.value=i_origin;
                    formObj.i_dest_cd.value=i_destination;
                    doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
                }else{
                    //in case of existing same route
                    ComShowMessage(strErrMsg );
                    if(sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow())=='I'){
                    	sheetObjects[0].RowDelete(sheetObjects[0].GetSelectRow(),false);
                    }
                }
                break;
           case MULTI02: //SAVEAS 
                formObj.f_cmd.value=MULTI02;
                //if there are no changed values, duplicate IRG can'be created
                var updateRow=false;
                //checking grid data
                for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
                	if(sheetObj.GetRowStatus(i) !='R') {
                 	    //OK when it is changed 
                 	    updateRow=true;
                 	} 
                }    
                //checking data excepting grid 
               var detail_org_i_inv=formObj.detail_org_i_inv.value ;
               var detail_org_i_rout_pln_cd=formObj.detail_org_i_rout_pln_cd.value ;
               var detail_org_i_bkg_flg=formObj.detail_org_i_bkg_flg.value ;
               var i_inv=formObj.i_inv.value ;
               var i_rout_pln_cd=formObj.i_rout_pln_cd.value ;
               var i_bkg_flg=formObj.i_bkg_flg.value ;
               var etcInDataUpdate=true;
                if( detail_org_i_inv ==i_inv && detail_org_i_rout_pln_cd == i_rout_pln_cd && detail_org_i_bkg_flg==i_bkg_flg) {
                    etcInDataUpdate=false;
                } else {
                    etcInDataUpdate=true;
                }
                // saving when data is created or updated
                if( updateRow || etcInDataUpdate ){
                        // insert row on master when creating new detail                
                        sheetObjects[0].DataInsert(-1);
                        formObj.i_sel_row.value=sheetObjects[0].LastRow(); //row number of master which will be set after saving detail
                        var SaveStr=sheetObj.GetSaveString(true);
                        sXml=sheetObj.GetSaveData("ESD_PRD_0005MST_ROWSEARCH.do",SaveStr+"&"+PrdFQString(formObj));
                        var strErrMsg = ComGetEtcData(sXml,'strErrMsg');
                        if(strErrMsg ==''){
                            sheetObj.RemoveAll();
                            bottomFrmClear(formObj);
                            formObj.i_org_cd.value=i_origin;
                            formObj.i_dest_cd.value=i_destination;
                            doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
                        } else {
                            ComShowMessage(strErrMsg);
                            sheetObjects[0].RowDelete(sheetObjects[0].LastRow(),false);
                        }
                }else {
                    ComShowMessage(ComGetMsg('PRD90042'));
                }
                break;     
           case IBINSERT:      
                if(validateForm(sheetObj,formObj,sAction))
				var modRoutOrgLoc=sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_org_loc");
				var modRoutOrgType=sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_org_type");
				var modRoutDestLoc=sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_loc");
				var modRoutDestType=sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_type");
               if(sheetObj.RowCount()>0) {
                   if(modRoutOrgLoc.length >0 && modRoutDestLoc.length>0) {
                       var row=sheetObj.DataInsert(-1);
                       sheetObj.SetRowEditable(row,1);
                       sheetObj.SetCellValue(sheetObj.LastRow(),"lnk_org_loc",modRoutDestLoc,0);
                       sheetObj.SetCellValue(sheetObj.LastRow(),"lnk_org_type",modRoutDestType,0);
                   } else {
                       ComShowMessage(ComGetMsg('PRD90025'));
                       return;
                   }
               } else {
                   // in case of creating route
                   var row=sheetObj.DataInsert(-1);
                   sheetObj.SetRowEditable(row,1);
               }
                break;       
           case SEARCH08:
              formObj.f_cmd.value=SEARCH08;
              sXml=sheetObj.GetSearchData("PRD_VALIDATE.do","uid=ESD_PRD_0005&check_data="+validateData+"&"+PrdFQString(formObj));
              retValidate=ComGetEtcData(sXml, "rowCount");
              comData1=ComGetEtcData(sXml,"comData1");
              comData2=ComGetEtcData(sXml,"comData2");
              
                //if row count is lesser than 1
                if(retValidate < 1) {
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(),"vndr_name",comData2,0);
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(),"vndr_seq","",0);
                    sheetObj.SelectCell(sheetObj.GetSelectRow(),"vndr_seq");
                }else {
                    sheetObj.SetCellValue(sheetObj.GetSelectRow(),"vndr_name",comData2,0);
                }
              break;                 
        }
    }
    function chkRailLinkForMt(sheetObj){
    	if( sheetObj.GetCellValue(parseInt(sheetObj.HeaderRows()), "trsp_mod_cd")!="RD" || sheetObj.GetCellValue(sheetObj.LastRow(), "trsp_mod_cd")!="RD") {
            return false;
        }
        return true;
    }
    /*
     * checking Mandatory elements
     */
    function checkMandatory() {
        var formObj=document.form;
        var retValue=true;
        var gubun='';
        for(i=0; i < formObj.r_inbound.length ; i++) {
        	if(formObj.r_inbound[i].checked) {
        		gubun=formObj.r_inbound[i].value;
        	}
        }
        // setting i_org_cd,i_dest_cd with from, to which is the value of retrieving 
    	orgCd=formObj.i_org_cd_ib.value;
    	destCd=formObj.i_dest_cd_ib.value;
     	formObj.i_org_cd.value=formObj.i_org_cd_ib.value;
    	formObj.i_dest_cd.value=formObj.i_dest_cd_ib.value;	
        if( !( orgCd.length > 0   &&   destCd.length > 0 )) retValue=false;
		if (!retValue){
			ComShowMessage(ComGetMsg('PRD90007'));
		}
        return retValue;
    }
    function checkRouteList(sheetObject) {
        var retValue=true;
    	var sIRow=sheetObject.FindStatusRow("I");
        if(sIRow.length >0 ) {
       	   sIRow = sIRow +";";
        }
         //putting received result into array
        var arIRow=sIRow.split(";");
        if(arIRow.length > 1 ) { // when data exists
             ComShowMessage(ComGetMsg('PRD90026'));
             retValue=false;
        }
        return retValue;
    }
    // validation for Location code
    function validateLocation(loc, num) {
    	if (num ==1) {
        	document.form.i_org_cd.value=loc.toUpperCase();
    	}
    	if (num ==2) {
        	document.form.i_dest_cd.value=loc.toUpperCase();
    	}        
        validateData=loc.toUpperCase();
    	doActionIBSheet(sheetObjects[0],document.form, SEARCH02);
    	if(retValidate < 1) { //if row count is lesser than 1 
        	if (num ==1) {
            	//document.form.i_org_cd.value = "";
            	document.form.i_org_cd.focus();
        	}else if (num ==2) {
            	//document.form.i_dest_cd.value = "";
            	document.form.i_dest_cd.focus();
        	}
    	}else {
        	if (num ==1) {
            	//document.form.i_org_cd.value = "";
            	document.form.i_dest_cd.focus();
        	}
    	}
    	return false;
    }  
    // if there is changed value on row which is USA Rail, showing message that it should be done with 'save as'
    function checkSpChange(sheetObj) {
    	for (var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
           //possible to save in case of 'NEW'. duplication will be checked on the server side 
    		if(sheetObj.GetRowStatus(i) =='I') return true;
    	}//for1
    	for (var i=sheetObj.HeaderRows(); i < sheetObj.LastRow()+1 ; i++){
    		if(sheetObj.GetRowStatus(i) !='R'  ) {
         		// when it is only updated(not existing created data) and clon from,to,mode are same value
         		// mode - td : only sp can be modified
         		// mode - rd : only junk can be modified 
				if(sheetObj.GetCellValue(i,"lnk_org_nod_cd") == sheetObj.GetCellValue(i,"lnk_org_loc") + sheetObj.GetCellValue(i,"lnk_org_type") ||
				sheetObj.GetCellValue(i,"lnk_dest_nod_cd") == sheetObj.GetCellValue(i,"lnk_dest_loc") + sheetObj.GetCellValue(i,"lnk_dest_type") ||
				sheetObj.GetCellValue(i,"clon_trsp_mod_cd") == sheetObj.GetCellValue(i,"trsp_mod_cd"))
         	    {
         	    	// if from,to,mode are not changed 
         	        // when it is not RD, only sp can be modified 
					if(sheetObj.GetCellValue(i, "trsp_mod_cd") != "RD"){
						if( sheetObj.GetCellValue(i,"clon_agmt_no")!=sheetObj.GetCellValue(i,"agmt_no") ||
								sheetObj.GetCellValue(i,"clon_combined_md")!=sheetObj.GetCellValue(i,"combined_md") ||
								sheetObj.GetCellValue(i,"clon_inlnd_rout_junc_nm")!=sheetObj.GetCellValue(i,"inlnd_rout_junc_nm")    ){
         	                return false;
         	            }
      	            //when it is RD, only junk can be modified 
					} else if( sheetObj.GetCellValue(i,"clon_agmt_no")!=sheetObj.GetCellValue(i,"agmt_no") ||
							sheetObj.GetCellValue(i,"clon_rail_crr_tp_cd")!=sheetObj.GetCellValue(i,"rail_crr_tp_cd") ||
							sheetObj.GetCellValue(i,"clon_vndr_seq")!=sheetObj.GetCellValue(i,"vndr_seq") ) {
                            return false;        	            
         	        }
         	    }else {
         	        // using save as
         	        return false;
         	    }
         	}
        }//for2        
        return true;
    }
    /*
     * check connection 
     */
    function checkRoute2(sheetObj,formObj) {
        var k=0;
        var modRoutOrgLoc="";
        var modRoutDestLoc="";
        var routOrgNod=new Array();
        var routDestNod=new Array();
        routOrgNod[k]="";
        routDestNod[k]="";
         var sURow=sheetObj.FindStatusRow("U");
         if(sURow.length >0 ) {
        	 sURow = sURow +";";
         }
         //putting received result into array
         var arURow=sURow.split(";");
         var sIRow=sheetObj.FindStatusRow("I");
         if(sIRow.length >0 ) {
        	 sIRow = sIRow +";";
         }
         //putting received result into array
         var arIRow=sIRow.split(";");                 
         formObj.i_new_route_cd.value="";  
         //in case of updating Route, checking it is same with value of master
         //checking it is updated (arURow.length > 1)
         var gubun='';
         for(i=0; i < formObj.r_inbound.length ; i++) {
        	if(formObj.r_inbound[i].checked) {
        		gubun=formObj.r_inbound[i].value;
        	}
         }
         if(arIRow.length >= 2 && arURow.length==1  ) {
             formObj.i_new_route_cd.value="Y";   
             formObj.i_rout_seq.value=0;  
             //<!-- setting hidden value of first and last route - sheetObj2 --> 
             // setting when clicking at master grid. formObj.i_rout_org_nod_cd,formObj.i_rout_dest_nod_cd
             formObj.i_rout_org_nod_cd.value=sheetObj.GetCellValue(1,"lnk_org_loc")  + sheetObj.GetCellValue(1,"lnk_org_type");
             formObj.i_rout_dest_nod_cd.value=sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_loc")  + sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_type");
            // checking if search condition is same with loc of ori,dest
            // getting search condition     
             var org_loc=formObj.i_org_cd.value;
        	 var dest_loc=formObj.i_dest_cd.value;
         } else {
             if(arURow.length > 1 ) {
                 formObj.i_new_route_cd.value="N";
             }
             var hRoutOrgNodCd=formObj.i_rout_org_nod_cd.value;     //the value which is set by double-clicking at master gird,master org of route which will modified 
             var hRoutDestNodCd=formObj.i_rout_dest_nod_cd.value;   //master dest route which will be modified
             var firstRoutOrgNodCd=sheetObj.GetCellValue(1,"lnk_org_loc")  + sheetObj.GetCellValue(1,"lnk_org_type");  //first org route which is modified
             var lastRoutDestNodCd=sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_loc")  + sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_type"); //last dest route which is modified
             //in case of updating, the first and last ones before modifying should be same with the ones after modifying(because it is key value of master table)
             if( hRoutOrgNodCd != firstRoutOrgNodCd || hRoutDestNodCd != lastRoutDestNodCd ) {
                 ComShowMessage(ComGetMsg('PRD90029'));
                 return false;
             }         
         }
         // it is also possible to modify master data only as well as update or create each link(Y: insert, N:update, M:master update) 
         if(formObj.i_new_route_cd.value != "Y" && formObj.i_new_route_cd.value != "N")  
         {
             formObj.i_new_route_cd.value="M";   
         }
        //putting into array to know the connection later. if rows are cleared, it can be judged as 'Delete' 
        for( i=1; i<= sheetObj.RowCount(); i++) {
        	routOrgNod[k]=sheetObj.GetCellValue(i,"lnk_org_loc")  + sheetObj.GetCellValue(i,"lnk_org_type");
        	routDestNod[k]=sheetObj.GetCellValue(i,"lnk_dest_loc") + sheetObj.GetCellValue(i,"lnk_dest_type");
            k++;
        }
         var j=0;
         //checking the connection 
         for( i=0; i< routOrgNod.length; i++ ) {
            if(sheetObj.RowCount()==1) {
                return true;
            } else {
                j=i+1;
            }
            if(routDestNod[i]==routOrgNod[j]) { // 크롬에서는 value 삭제 
                if (j == (routOrgNod.length-1)) return true;
            } else {
                ComShowMessage(ComGetMsg('PRD90030'));
                return false;
            }
         }      
    }
    //checking connection of 'saveas'
    function checkRoute3(sheetObj,formObj) {
        var k=0;
        var modRoutOrgLoc="";
        var modRoutDestLoc="";
        var routOrgNod=new Array();
        var routDestNod=new Array();
        routOrgNod[k]="";
        routDestNod[k]="";
         var sURow=sheetObj.FindStatusRow("U");
         if(sURow.length >0 ) {
        	 sURow = sURow +";";
         }
         //putting received result into array
         var arURow=sURow.split(";");
         var sIRow=sheetObj.FindStatusRow("I");
         if(sIRow.length >0 ) {
        	 sIRow = sIRow +";";
         }
         //putting received result into array
         var arIRow=sIRow.split(";");                 
         formObj.i_new_route_cd.value="";  
         //in case of updating Route, checking it is same with value of master
         //checking it is updated (arURow.length > 1)
         var gubun='';
         for(i=0; i < formObj.r_inbound.length ; i++) {
        	if(formObj.r_inbound[i].checked) {
        		gubun=formObj.r_inbound[i].value;
        	}
         }
         //new Route
         if(arIRow.length >= 2 && arURow.length==1  ) {
             formObj.i_new_route_cd.value="Y";   
             formObj.i_rout_seq.value=0;   
             formObj.i_rout_org_nod_cd.value=sheetObj.GetCellValue(1,"lnk_org_loc")  + sheetObj.GetCellValue(1,"lnk_org_type");
             formObj.i_rout_dest_nod_cd.value=sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_loc")  + sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_type");
             var org_loc=formObj.i_org_cd.value;
        	 var dest_loc=formObj.i_dest_cd.value;
         } else {
             if(arURow.length > 1 ) {
                 formObj.i_new_route_cd.value="N";
             }
             var hRoutOrgNodCd=formObj.i_rout_org_nod_cd.value;     //master org of route which will be modified
             var hRoutDestNodCd=formObj.i_rout_dest_nod_cd.value;   //master dest of route which will be modified
             var firstRoutOrgNodCd=sheetObj.GetCellValue(1,"lnk_org_loc")  + sheetObj.GetCellValue(1,"lnk_org_type");  //first org of modified route
             var lastRoutDestNodCd=sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_loc")  + sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_type"); //last dest of modified route
             //changing basic information in case of SAVE AS
             if(hRoutOrgNodCd != firstRoutOrgNodCd) {
                 formObj.i_rout_org_nod_cd.value=firstRoutOrgNodCd;
              }
             if(hRoutDestNodCd != lastRoutDestNodCd) {
                 formObj.i_rout_dest_nod_cd.value=lastRoutDestNodCd;
             }
         }
         // it is also possible to modify master data only as well as update or create each link(Y: insert, N:update, M:master update) 
         if(formObj.i_new_route_cd.value != "Y" && formObj.i_new_route_cd.value != "N")  
         {
             formObj.i_new_route_cd.value="M";   
         }
        //putting into array to know the connection later. if rows are cleared, it can be judged as 'Delete' 
        for( i=1; i<= sheetObj.RowCount(); i++) {
        	routOrgNod[k]=sheetObj.GetCellValue(i,"lnk_org_loc")  + sheetObj.GetCellValue(i,"lnk_org_type");
        	routDestNod[k]=sheetObj.GetCellValue(i,"lnk_dest_loc") + sheetObj.GetCellValue(i,"lnk_dest_type");
            k++;
        }
         var j=0;
         //checking connection
         for( i=0; i< routOrgNod.length; i++ ) {
            if(sheetObj.RowCount()==1) {
                return true;
            } else {
                j=i+1;
            }
            if(routDestNod[i]==routOrgNod[j]) { //the number of rows are more than 2 
                if (j == (routOrgNod.length-1)) return true;
            } else {
                ComShowMessage(ComGetMsg('PRD90030'));
                return false;
            }
         }
    }
    /*
     * checking route when saving master data
     */
    function checkLocCondition(sheetObj) {
        var formObject=document.form;
        var org_loc=formObject.i_org_cd.value;
    	var dest_loc=formObject.i_dest_cd.value;
		var gubun='';
        for(i=0; i < formObject.r_inbound.length ; i++) {
        	if(formObject.r_inbound[i].checked) {
        		gubun=formObject.r_inbound[i].value;
        	}
        }
        var orgSheetVal='';
        var destSheetVal='';
    	for(var i=1; i <= sheetObj.RowCount();i++){
	        if(gubun=='I'){ //7,5
	        	orgSheetVal=sheetObj.GetCellValue(i,"rout_org_nod_cd") ;
	        	destSheetVal=sheetObj.GetCellValue(i,"dest_loc");
			}
			if(gubun=='O'){ //5,7
				orgSheetVal=sheetObj.GetCellValue(i,"ori_loc");
				destSheetVal=sheetObj.GetCellValue(i,"rout_dest_nod_cd");
			}
			if(gubun=='B'){ //5,5
				orgSheetVal=sheetObj.GetCellValue(i,"ori_loc") ;
				destSheetVal=sheetObj.GetCellValue(i,"dest_loc");
			}    	
			if(gubun=='M'){ //7,7
				orgSheetVal=sheetObj.GetCellValue(i,"rout_org_nod_cd") ;
				destSheetVal=sheetObj.GetCellValue(i,"rout_dest_nod_cd");
			}			
    	    if( org_loc != orgSheetVal || dest_loc != destSheetVal){
    	        ComShowMessage(ComGetMsg('PRD90031'));
    	        return false;
    	    }
    	}
    	return true;
    }
    /*
     * checking route when saving detail data
     */
    function checkDtlLocCondition(sheetObj) {
        var formObject=document.form;
        var org_loc=formObject.i_org_cd.value;
    	var dest_loc=formObject.i_dest_cd.value;
		var gubun='';
        for(i=0; i < formObject.r_inbound.length ; i++) {
        	if(formObject.r_inbound[i].checked) {
        		gubun=formObject.r_inbound[i].value;
        	}
        }
        var orgSheetVal='';
        var destSheetVal='';
        if(gubun=='I'){
        	orgSheetVal=sheetObj.GetCellValue(1,"lnk_org_loc")+sheetObj.GetCellValue(1,"lnk_org_type");
        	destSheetVal=sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_loc");
		}
		if(gubun=='O'){
			orgSheetVal=sheetObj.GetCellValue(1,"lnk_org_loc");
			destSheetVal=sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_loc")+sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_type");
		}
		if(gubun=='B'){
			orgSheetVal=sheetObj.GetCellValue(1,"lnk_org_loc");//sheetObj.GetCellValue(1,"lnk_org_type");
			destSheetVal=sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_loc");//+sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_type");
		}
		if(gubun=='M'){
			orgSheetVal=sheetObj.GetCellValue(1,"lnk_org_loc")+sheetObj.GetCellValue(1,"lnk_org_type");
			destSheetVal=sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_loc")+sheetObj.GetCellValue(sheetObj.LastRow(),"lnk_dest_type");
		}
	    if( org_loc != orgSheetVal || dest_loc != destSheetVal ){ 
	        ComShowMessage(ComGetMsg('PRD90032'));
	        return false;
	    }
    	return true;
    }
    function getCOM_ENS_051_1(rowArray) {
    	//alertComPopupData(rowArray);
    	var colArray=rowArray[0];
    	document.all.i_org_cd.value=colArray[3];
    }
    function getOrgLoc(rowArray) {
    	//alertComPopupData(rowArray);
    	var colArray=rowArray[0];
    	document.all.i_org_cd.value=colArray[3];
    }
    function getDestLoc(rowArray) {
    	//alertComPopupData(rowArray);
    	var colArray=rowArray[0];
    	document.all.i_dest_cd.value=colArray[3];
    }
    /*
     * priority will be given as retrieving data 
     */
    	var delCnt=1;
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
     	if(sheetObj.ColSaveName(Col)=="prio_seq" ) {
     		if(Value == '')  {
     			return false;	
     			return false;
     		}
     		var o = Number(Value);
     		if(o == 0 ) {
     			sheetObj.SetCellValue(Row, Col, sheetObj.GetCellValue(Row, "ori_prio_seq"), 0);
     	        ComShowMessage(ComGetMsg('PRD90090'));
     	    } else {
     	    	sheetObj.SetCellValue(Row, Col, o, 0);
     	    }
     		return false;
     	}
    }
    
    function sheet2_OnChange (sheetObj,Row,Col,Value) {
    	var lnk_org_loc_cd=sheetObj.GetCellValue(Row,"lnk_org_loc")+sheetObj.GetCellValue(Row,"lnk_org_type");
    	var lnk_dest_loc_cd=sheetObj.GetCellValue(Row,"lnk_dest_loc")+sheetObj.GetCellValue(Row,"lnk_dest_type");
        /*
         * USA is not available at this menu(using 057)
         */
        if( lnk_org_loc_cd.substring(0,2) == "US" ||lnk_org_loc_cd.substring(0,2) == "CA" || lnk_dest_loc_cd.substring(0,2) == "US" ||lnk_dest_loc_cd.substring(0,2) == "CA"  ) {
            ComShowMessage("Only Europe and Asia use possibility");
            sheetObj.RemoveAll();
            return false;  
        }
        if((sheetObj.GetRowStatus(Row) =="I" || sheetObj.GetRowStatus(Row) =="U" ) &&
           ( sheetObj.ColSaveName(Col)=="lnk_org_loc" || sheetObj.ColSaveName(Col)=="lnk_dest_loc" || sheetObj.ColSaveName(Col)=="trsp_mod_cd" ||
             sheetObj.ColSaveName(Col)=="lnk_org_type" || sheetObj.ColSaveName(Col)=="lnk_dest_type" ) )
        {
        	if(sheetObj.GetCellValue(Row,"lnk_org_loc") !="" && sheetObj.GetCellValue(Row,"lnk_dest_loc")!="" && sheetObj.GetCellValue(Row,"trsp_mod_cd")!="" && sheetObj.GetCellValue(Row,"lnk_org_type")!="" && sheetObj.GetCellValue(Row,"lnk_dest_type")!="" )
            {
        		sheetObj.DoRowSearch(Row,"ESD_PRD_0005ROWSEARCH.do", "f_cmd="+SEARCH11+"&from_nod="+lnk_org_loc_cd +"&to_nod="+lnk_dest_loc_cd +"&trsp_mod="+sheetObj.GetCellValue(Row,"trsp_mod_cd")+"&row="+Row+"&col="+Col, {Sync:2}  )
        		if(sheetObj.GetEtcData("rowCount")==0) {
        			sheetObj.SetCellValue(Row,"lnk_org_loc","",0);
                    sheetObj.SetCellValue(Row,"lnk_dest_loc","",0);
                    sheetObj.SetCellValue(Row,"lnk_org_type","",0);
                    sheetObj.SetCellValue(Row,"lnk_dest_type","",0);
                      
                    sheetObj.SetCellValue(Row,"vndr_seq","",0);
                    sheetObj.SetCellValue(Row,"vndr_name","",0);
                    sheetObj.SetCellValue(Row,"tztm_hrs","",0);
                    sheetObj.SetCellValue(Row,"rail_crr_tp_cd","",0);
                    sheetObj.SetCellValue(Row,"combined_md","",0);
                    sheetObj.SetCellValue(Row,"inlnd_rout_junc_nm","",0);
                  
                    sheetObj.SelectCell(Row,"lnk_dest_loc");
                }
            }
        }
        //checking sp code
    	if (sheetObj.ColSaveName(Col) == "vndr_seq")
    	{
    		if( sheetObj.GetCellValue(Row,"vndr_seq").length > 0) {
            	//validateData - nod cd 
    			validateData=sheetObj.GetCellValue(Row,"vndr_seq");
                doActionIBSheet2(sheetObj,document.form, SEARCH08);
                //if row count is lesser than 1
                if(retValidate < 1) {
                	ComShowMessage(ComGetMsg("PRD90130"));
                    sheetObj.SetCellValue(Row,"vndr_name",comData2,0);
                    sheetObj.SelectCell(Row,"vndr_seq");
                } else {
                    sheetObj.SetCellValue(Row,"vndr_name",comData2,0);
                }
            }   
    	} 
        // checking validation for agree no
        if ( sheetObj.ColSaveName(Col) == "agmt_no"  ){
            if(Value =="") {
                sheetObj.SetCellValue(Row,"refe_no","",0);
                return;
            }
            var cty_cd=Value.substring(0,3);
            var agmt_cd=Value.substring(3);
            var vndr_seq=sheetObj.GetCellValue(Row,"vndr_seq");
            sheetObj.DoRowSearch(Row,"ESD_PRD_0005_AGMT_NO_GS.do", "f_cmd="+SEARCH01+"&cty_cd="+cty_cd +"&agmt_seq="+agmt_cd +"&row="+Row+"&col="+Col+"&vndr_seq="+vndr_seq , {Sync:2} );
        	if(sheetObj.GetEtcData("rowCount")==0) {
        	    sheetObj.SetCellValue(Row,"refe_no","",0);
        	    sheetObj.SetCellValue(Row,"agmt_no","",0);
        	}            
        } 
    	// enabling in case of USA Rail  (S) -----------------------------------------------
        if( chkAmericanContinent(document.form) && sheetObj.GetCellValue(Row,"trsp_mod_cd")=="RD" ) {
    	    sheetObj.SetCellEditable(Row,"agmt_no",1);
    	    sheetObj.SetCellEditable(Row,"rail_crr_tp_cd" ,1);
    	    sheetObj.SetCellEditable(Row,"inlnd_rout_junc_nm" ,1);
    	} else {
    		if(!ComIsEmpty(sheetObj.GetCellValue(Row,"agmt_no"))  ) {
         	    sheetObj.SetCellValue(Row,"agmt_no","",0);
    	        sheetObj.SelectCell(Row,"agmt_no");
    	        ComShowMessage(ComGetMsg('PRD90076'));
    	     }
    		if(!ComIsEmpty(sheetObj.GetCellValue(Row,"refe_no"))  ) {
         	    sheetObj.SetCellValue(Row,"refe_no","",0);
    	        sheetObj.SelectCell(Row,"refe_no");
      	        ComShowMessage(ComGetMsg('PRD90050'));
    	     }
    		if(!ComIsEmpty(sheetObj.GetCellValue(Row,"rail_crr_tp_cd"))  ) {
         	    sheetObj.SetCellValue(Row,"rail_crr_tp_cd","",0);
    	        sheetObj.SelectCell(Row,"rail_crr_tp_cd");
      	        ComShowMessage(ComGetMsg('PRD90051'));
    	     }    	    
    		if(!ComIsEmpty(sheetObj.GetCellValue(Row,"inlnd_rout_junc_nm"))  ) {
         	    sheetObj.SetCellValue(Row,"inlnd_rout_junc_nm","",0);
    	        sheetObj.SelectCell(Row,"inlnd_rout_junc_nm");
    	        ComShowMessage(ComGetMsg('PRD90052'));
    	     }    	    
    	    sheetObj.SetCellEditable(Row,"agmt_no",0);
    	    sheetObj.SetCellEditable(Row,"rail_crr_tp_cd" ,0);
    	    sheetObj.SetCellEditable(Row,"inlnd_rout_junc_nm" ,0);
    	}
    	// enabling in case of USA Rail (E) -----------------------------------------------           
    }
/**
 * calling Biz common pop up from sheet
 * - calling comPopupInSheet() : Parameter - row, col  
 */
    function sheet2_OnPopupClick(sheetObj, row, col){   
	    var loc_cd_val ;
	    var dispaly ;
	    var classId ;
	    var param ;
	    var chkStr ;
        if ( sheetObj.ColSaveName(col) == "lnk_org_loc" || sheetObj.ColSaveName(col) == "lnk_dest_loc" )
        {
        	loc_cd_val=sheetObj.GetCellValue(row, col);
            dispaly="1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
            classId="COM_ENS_061";
    	    param='?loc_cd='+loc_cd_val+'&classId='+classId;
    	    chkStr=dispaly.substring(0,3)          
    	    ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getNode', "1,0,1,1,1,1,1,1,1,1,1,1",true,true, row, col);
        }
        if ( sheetObj.ColSaveName(col) == "vndr_seq"  )
        {
        	loc_cd_val=sheetObj.GetCellValue(row, col);
            dispaly="1,0,1,1,1,1,1,1,1,1,1,1";    // Radio PopUp
            classId="COM_ENS_0C1";
    	    param='?classId='+classId;
    	    chkStr=dispaly.substring(0,3)          
            // Radio PopUp  
            if(chkStr == "1,0") {
            	ComOpenPopup('/opuscntr/COM_ENS_0C1.do' + param , 810, 550, 'getVendor', dispaly, true, false, row, col, 1);
            } else {
               ComShowMessage(ComGetMst('PRD90063'));
               return;
            }
        }    
     }    
     function getVendor(rowArray, row, col) {
        var sheetObj=sheetObjects[1];
    	var colArray=rowArray[0];
    	sheetObj.SetCellValue(row, "vndr_seq",colArray[2],0);
    	sheetObj.SetCellValue(row, "vndr_name",colArray[4],0);
    }
/**
 * Location : in case of single selection of radio button on pop up
 */
    function getNode(rowArray, row, col) {
        var sheetObj=sheetObjects[1];
    	var colArray=rowArray[0];
    	sheetObj.SetCellValue(parseInt(row), parseInt(col)+1,colArray[3].substring(5),0);
    	sheetObj.SetCellValue(parseInt(row), parseInt(col),colArray[3].substring(0,5),0);
    }
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
     /**
     * disabling form input value
     */
    function bottomFrmDisable(gb) {
        var formObj=document.form;
        if(gb){
        	ComEnableObject(formObj.i_inv,false);
        	ComEnableObject(formObj.i_rout_pln_cd,false);
        } else{
        	ComEnableObject(formObj.i_inv,true);
        	ComEnableObject(formObj.i_rout_pln_cd,true);
        }
        var gubun=formObj.rBtnIrgCd.value ;
    }
    function chkAmericanContinent(formObj) {
        var org=formObj.i_org_cd.value.substring(0,2);
        var des=formObj.i_dest_cd.value.substring(0,2);
        if( (org == "US" || org == "CA" || org == "MX" ) && (des == "US" || des == "CA" || des == "MX"  )) {
            return true;
        }
        return false;
    }
    function bottomFrmClear(formObj) {
        ComClearObject(formObj.i_inv);
        ComClearObject(formObj.i_rout_pln_cd);
        ComClearObject(formObj.i_route_rmk);
        ComClearObject(formObj.i_bkg_flg);
    }
    function changeNodTy1(nodTy)  {
        document.form.rBtnNodTyCd1.value=nodTy;
    }
    function checkedBkgFlg() {
        if(document.form.i_bkg_flg.checked) {
            document.form.i_bkg_flg.value='Y';
        } else {
            document.form.i_bkg_flg.value='';
        }
    }
	function changeSelection(gubun){
	    var formObj=document.form;
	    formObj.rBtnIrgCd.value=gubun;
        sheetObjects[0].RemoveAll();
        sheetObjects[1].RemoveAll();
        if (gubun == 'B') {
        	ComEnableObject(formObj.nod_tp_cd1[0],false);
        	ComEnableObject(formObj.nod_tp_cd1[1],false);
        	formObj.rBtnNodTyCd1.value='X';
        } else {
        	ComEnableObject(formObj.nod_tp_cd1[0],true);
        	ComEnableObject(formObj.nod_tp_cd1[1],true);
        	for(var index=0; index<formObj.nod_tp_cd1.length; index++) {
        		if(formObj.nod_tp_cd1[index].checked == true) {
        		    formObj.rBtnNodTyCd1.value=formObj.nod_tp_cd1[index].value;
        		}
        	}
        }	    
	    bottomFrmClear(formObj);
	}    
	var portInd='';
	function selectTml(frm, pt) {
		portInd=pt;
		if(pt == 'IB_ORG_TML')  param="?node_cd="+frm.i_org_cd_ib.value;
		if(pt == 'IB_DEST_LOC') param="?node_cd="+frm.i_dest_cd_ib.value;
		if(pt == 'TS_ORG_YD')   param="?node_cd="+frm.i_org_cd_ts.value;
		if(pt == 'TS_DEST_YD')  param="?node_cd="+frm.i_dest_cd_ts.value;
		if(pt == 'MT_ORG_YD')   param="?node_cd="+frm.i_org_cd_ts.value;
		if(pt == 'MT_DEST_YD')  param="?node_cd="+frm.i_dest_cd_ts.value;		
		ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 810, 550, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}
	function getCOM_ENS_061(rArray) {
		var cArray=rArray [0];	
		var frm=document.form;
		if(portInd == 'IB_ORG_TML'){
			 frm.i_org_cd_ib.value=cArray[3];
		}
		if(portInd == 'IB_DEST_LOC'){
			 frm.i_dest_cd_ib.value=cArray[3];
		}
		if(portInd == 'TS_ORG_YD'){
			 frm.i_org_cd_ts.value=cArray[3];
		}
		if(portInd == 'TS_DEST_YD'){
			 frm.i_dest_cd_ts.value=cArray[3];
		}	
		if(portInd == 'MT_ORG_YD'){
			 frm.i_org_cd_mt.value=cArray[3];
		}
		if(portInd == 'MT_DEST_YD'){
			 frm.i_dest_cd_mt.value=cArray[3];
		}									
	}
	function selectLoc(frm, pt) {
		portInd=pt;
		if(pt == 'IB_DEST_LOC') param="?loc_cd="+frm.i_dest_cd_ib.value;
		if(pt == 'OB_ORG_LOC') param="?loc_cd="+frm.i_org_cd_ob.value;
		ComOpenPopup('/opuscntr/COM_ENS_051.do' + param, 800, 550, 'getCOM_ENS_051', '1,0,1,1,1,1,1,1,1,1,1,1', true);
	}
	function getCOM_ENS_051(rArray) {
		var cArray=rArray [0];	
		var frm=document.form;
		if(portInd == 'IB_ORG_TML'){
			 frm.i_dest_cd_ib.value=cArray[3];
		}	
		if(portInd == 'OB_ORG_LOC'){
			 frm.i_org_cd_ob.value=cArray[3];
		}
		if(portInd == 'IB_DEST_LOC'){
			frm.i_dest_cd_ib.value=cArray[3];
		}
	}	
	/*
	 * hiding detail information
	 */
    function sheetMinimize(sheetObj){
    	var objs=document.all.item("minimize");
    	if( min_state == "MIN" ) {
    	    min_state="MAX"
    		objs.style.display="none";
    	    sheetObj.SetSheetHeight(390 );
    	} else {
    	    min_state="MIN"
    		objs.style.display="inline";
    	    sheetObj.SetSheetHeight(290 );
    	}        
    }		
    function changeDeltFlg() {
        var frm=document.form;
        sheetObjects[0].RemoveAll();
        sheetObjects[0].RenderSheet(0);
        if(frm.i_del_flg.checked ){
           sheetObjects[0].SetColHidden("upd_id",1);
           sheetObjects[0].SetColHidden("upd_date",1);
           sheetObjects[0].SetColHidden("del_id",0);
           sheetObjects[0].SetColHidden("del_date",0);
         } else {
           sheetObjects[0].SetColHidden("upd_id",0);
           sheetObjects[0].SetColHidden("upd_date",0);
           sheetObjects[0].SetColHidden("del_id",1);
           sheetObjects[0].SetColHidden("del_date",1);
        }
        sheetObjects[0].RenderSheet(1);
    }	        
	   /*
     * checking input condition for retrieve
     */
     function checkInput() {
         var formObject=document.form;
         var i_org_cd_ib=formObject.i_org_cd_ib.value;
         var i_dest_cd_ib=formObject.i_dest_cd_ib.value;

         // 2015.04.23
	     if(i_org_cd_ib == "" && i_dest_cd_ib == "") {
	    	 ComShowCodeMessage("COM130403", 'From or To');
	         return false;
	     }
         // Check Input Field From
    	 if(i_org_cd_ib.length > 0 && !(i_org_cd_ib.length ==5 || i_org_cd_ib.length ==7)){
			 ComShowMessage(ComGetMsg('PRD90120','From','5 or 7'));
			 formObject.i_org_cd_ib.select();
			 formObject.i_org_cd_ib.focus();  
			 return false;
    	 }
		 var org=i_org_cd_ib.substring(0,2);
		 if( chkAmericaCnt("i_org_cd_ib") == true ){
          	 ComShowMessage(ComGetMsg('PRD90074'));
			 formObject.i_org_cd_ib.select();
			 formObject.i_org_cd_ib.focus();  
			 return false;
		 }
		 // Check Input Field To
   		if(i_dest_cd_ib.length > 0 && !(i_dest_cd_ib.length ==5 || i_dest_cd_ib.length ==7)){
   			ComShowMessage(ComGetMsg('PRD90120','To','5 or 7'));
   			formObject.i_dest_cd_ib.select();
   			formObject.i_dest_cd_ib.focus();  
   			return false;
   		}
		 var dest=i_dest_cd_ib.substring(0,2);
		 if( chkAmericaCnt("i_dest_cd_ib") == true ){
         	 ComShowMessage(ComGetMsg('PRD90074'));
         	 formObject.i_dest_cd_ib.select();
         	 formObject.i_dest_cd_ib.focus();  
         	 return false;
		 }
         return true;
     }
     function chkAmericaCnt(objNm){
    	 var cnt_cd=document.form.cnt_cd.value;
    	 var obj=document.getElementsByName(objNm);
    	 var str=obj[0].value;
    	 var cnt=0;
    	 if( cnt_cd != null && cnt_cd.length >= 3 ){
    		 for( var idx=0;idx<cnt_cd.length;idx=idx+3 ){
    			 if( cnt_cd.substr(idx,2) == str.substr(0,2) ){
    				 cnt++;
    			 }
    		 }
    	 }
    	 if( cnt <= 0 ){
    		 return false;
    	 }else{
    		 return true;
    	 }
     }
     
