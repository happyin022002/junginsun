/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0055.jsp
*@FileTitle  : D/Dock Schedule Review - Graph
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class esm_fms_0055 : esm_fms_0055 definition of biz script for creation screen
     */

	//  common global variables 
	var sheetObjects=new Array();
	var sheetCnt=0;
	var queryStr="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name  */
    function processButtonClick(){
		var sheetObject=sheetObjects[0];
		var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            	case "btn_retrieve":
	             	if (!duration_change()) return;
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                break;
				case "btn_new":
					ComResetAll();
					inputReadOnly("New");
                break;
				case "btn_DownExcel":
					var strColSkipList=getColumnSkipList(formObject);
 					if(sheetObject.RowCount() < 1){//no data	
 						ComShowCodeMessage("COM132501");
 					}else{	
// 						sheetObject.Down2Excel({ HiddenColumn:0,Merge:true,TreeLevel:false});
 						sheetObject.Down2Excel({ SheetDesign:1, HiddenColumn:1, Merge:1 });
 					}	
                break;
				case "btn_Print":
					if(validateForm(sheetObject,formObject)){
						getPrintParam(formObject);
						//RD Open
						rdOpen(formObject);
					}
                break;
				case "btn_vslpop":
					ComOpenPopup("ESM_FMS_0022.do", 520, 470,"setVslCd", "1,0,1,1,1", true, false, null, null, 0, "ESM_FMS_0022");
					break;
				case "btn_lanepop":
					ComOpenPopup("ESM_FMS_0036.do", 620, 430,"setLaneCd", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0036");
					break;
				case "btn_ownerpop":
					ComOpenPopup("ESM_FMS_0083.do", 500, 375,"setOwner", "1,0,1,1,1", false, false, null, null, 0, "ESM_FMS_0083");
					break;
     			case "btn_fr_duration":
     				var cal=new ComCalendar();
 					cal.setDisplayType('year');
					cal.select(form.fr_duration, 'yyyy');
					break;					
     			case "btn_to_duration":
     				var cal=new ComCalendar();
 					cal.setDisplayType('year');
					cal.select(form.to_duration, 'yyyy');
					break;
     			case "btn_ownrclr":
     				form.ownr_nm.value="";
     				form.ownr_seq.value="";
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
     * Generating Column List skipped when Excel Download
     **/
    function getColumnSkipList(formObject) {
		var fr_duration=parseFloat(formObject.fr_duration.value);
		var to_duration=parseFloat(formObject.to_duration.value);
		var k=(to_duration - fr_duration)+2;
		var strColSkipList='';
		for (ii=k;ii<4;ii++) {
			for (j=1;j<13;j++) {
				if (j<10) {
			        strColSkipList=strColSkipList + "ym"+ii+"_0"+j+"|";
				} else {
			        strColSkipList=strColSkipList + "ym"+ii+"_"+j+"|";
				}
			}
		}
		return strColSkipList;
	}	
    /**
     * Generating required Parameter when clicking print button <br>
     * @param {Form Object} formObject     	form name
     **/
    function getPrintParam(formObject) {
		var fr_duration=parseFloat(formObject.fr_duration.value);
		var to_duration=parseFloat(formObject.to_duration.value);
		if (fr_duration < to_duration) {
			formObject.snd_year.value=(fr_duration+1);
		} else {
			formObject.snd_year.value='';
		}
		if (fr_duration+2 == to_duration) {
			formObject.trd_year.value=to_duration;
		} else {
			formObject.trd_year.value='';
		}
		formObject.flet_dck_svey_tp_nm.value=formObject.flet_dck_svey_tp_cd.options[formObject.flet_dck_svey_tp_cd.selectedIndex].text;
		formObject.reflection_nm.value=formObject.reflection_cd.options[formObject.reflection_cd.selectedIndex].text;
	}
    /**
     * Screen handling by Event <br>
     * @param {String} flag     	Event Separator
     **/
    function inputReadOnly(flag) {
    	var readOnly=true;
    	var cursor="default";
    	var img="no_";
    	if(flag == "New") {
    		readOnly=false;
    		cursor="hand";
    		img="";
    	}
    	form.vsl_cd.readOnly=readOnly;
    	form.lane_cd.readOnly=readOnly;
    	form.flet_ctrt_tp_cd.disabled=readOnly;
    	form.vsl_dznd_capa_fr.readOnly=readOnly;
    	form.vsl_dznd_capa_to.readOnly=readOnly;
    	form.flet_dck_svey_tp_cd.disabled=readOnly;
		form.fr_duration.readOnly=readOnly;
		form.to_duration.readOnly=readOnly;
    	form.reflection_cd.disabled=readOnly;
//    	document.images["btn_vslpop"].name=img+"btn_vslpop";
//    	document.images["btn_lanepop"].name=img+"btn_lanepop";
//    	document.images["btn_ownerpop"].name=img+"btn_ownerpop";
//    	document.images["btn_fr_duration"].name=img+"btn_fr_duration";
//    	document.images["btn_to_duration"].name=img+"btn_to_duration";
    	form.btn_vslpop.style.cursor=cursor;
    	form.btn_lanepop.style.cursor=cursor;
    	form.btn_ownerpop.style.cursor=cursor;
    	form.btn_fr_duration.style.cursor=cursor;
    	form.btn_to_duration.style.cursor=cursor;
    }
	/**
	 * Insering Vessel Code<br>
	 * @param {arry} aryPopupData
	 */
	function setVslCd(aryPopupData) {
		axon_event.removeListener('vsl_cd', 'change', 'vsl_cd_change');
		form.vsl_cd.value=aryPopupData[0][2];
		form.vsl_eng_nm.value=aryPopupData[0][3];
		axon_event.addListener('change', 'vsl_cd_change', 'vsl_cd');		
	}
    /**
	 * Inserting Lane Code<br>
	 * @param {arry} aryPopupData
	 */
	function setLaneCd(aryPopupData){
		form.lane_cd.value=aryPopupData[0][3];
	}
    /**
	 * Inserting Owner<br>
	 * @param {arry} aryPopupData
	 */
	function setOwner(aryPopupData){
		form.ownr_seq.value=aryPopupData[0][3];
		form.ownr_nm.value=aryPopupData[0][4];
        form.btn_ownrclr.checked=true;
	}
    /**
     * Getting Name when changing VslCd <br>
     **/
    function vsl_cd_change() {
    	form.vsl_eng_nm.value="";
    	if (form.vsl_cd.value != "" && form.vsl_cd.value.trim().length == 4) {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'vsl_cd');
    	}
    }
    /**
     * Checking Lane Code when LaneCd is changed <br>
     **/
    function lane_cd_change() {
    	if (form.lane_cd.value != "") {
   			doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, 'lane_cd');
    	}
    }
    /**
    * Registering IBSheet Object as Array
    * In case there is needs to do batch processing, process saving as Array can be added
    * defining array on the top of source
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
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
		//RD

		sheet1_OnLoadFinish(sheet1);
    }
    /**
     * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
     * Adding first-served function
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.SetWaitImageVisible(0);
    	doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");
        removeContractTP();
		sheetObj.SetWaitImageVisible(1);
    }

	/**
     * Loading Event of HTML_Control existing on page dynamically <br>
     * Calling the function from {@link #loadPage} to initialize IBSheet Object<br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sequence of sheetObjects array
     **/
    function initControl() {
        //Axon Event Handling1. Event catch
    	axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- Code handling to OnBeforeDeactivate(blur) Event of All Controls
//        axon_event.addListenerFormat('keypress'        , 'obj_keypress'  , 	form); 	//- Code handling to onkeypress Event of All Controls having dateformat attribute
//        axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd');			//- Input only Upper case English when inserting Veesel Code
        axon_event.addListener  ('change'  , 'vsl_cd_change', 'vsl_cd');			//- Getting Name information after inserting Vessel Code
//        axon_event.addListener  ('keypress', 'eng_keypress' , 'lane_cd');			//- Only input Upper case English when inserting Lane Code
        axon_event.addListener  ('change'  , 'lane_cd_change', 'lane_cd');			//- Getting Name information after inserting Lane Code
        axon_event.addListener  ('change'  , 'vsl_size_change', 'vsl_dznd_capa_fr');	//- Comparing From-To after inserting Vessel Size
        axon_event.addListener  ('change'  , 'vsl_size_change', 'vsl_dznd_capa_to');	//- Comparing From-To after inserting Vessel Size
        axon_event.addListener  ('change'  , 'duration_change', 'fr_duration');			//- Comparing From-To after inserting Duration
        axon_event.addListener  ('change'  , 'duration_change', 'to_duration');			//- Comparing From-To after inserting Duration
        //doActionIBSheet(sheetObjects[0], document.form, IBROWSEARCH, "ComCd");
        //removeContractTP();
    }
    /**
     * Checking Validation in onblur Event of HTML Control <br>
     **/
    function obj_deactivate(){
    	//if (event.srcElement.getAttribute("required") != null) return;
    	switch(event.srcElement.name){
			case "fr_duration":
				ComChkObjValid(event.srcElement, true, false, false);
				break;
			case "to_duration":
				ComChkObjValid(event.srcElement, true, false, false);
				break;
			case "vsl_dznd_capa_fr":
				ComChkObjValid(event.srcElement, true, false, false);
				break;
			case "vsl_dznd_capa_to":
				ComChkObjValid(event.srcElement, true, false, false);
				break;
			default:
				//ComAddSeparator(event.srcElement);
				ComChkObjValid(event.srcElement);
    	}
    }
	/**
     * Comparing From-To after inserting Vessel Size
     **/
    function vsl_size_change() {
		var formObj=document.form;
		var vsl_dznd_capa_fr=formObj.vsl_dznd_capa_fr.value;
		var vsl_dznd_capa_to=formObj.vsl_dznd_capa_to.value;
		if (vsl_dznd_capa_fr != '' && vsl_dznd_capa_to != '') {
			if (parseFloat(vsl_dznd_capa_fr) > parseFloat(vsl_dznd_capa_to)) {
				ComAlertFocus(formObj.vsl_dznd_capa_fr, ComGetMsg('FMS01714'));
				formObj.vsl_dznd_capa_to.value='';
			}
		}
	}	
	/**
     * Comparing From-To after inserting Duration
     **/
    function duration_change() {
		var formObj=document.form;
		var fr_duration=formObj.fr_duration.value;
		var to_duration=formObj.to_duration.value;
		if (fr_duration != '' && to_duration != '') {
			if (parseFloat(fr_duration) > parseFloat(to_duration)) {
				ComAlertFocus(formObj.to_duration, ComGetMsg('FMS01715'));
				return false;
			}
			if (parseFloat(to_duration) - parseFloat(fr_duration) >= 3) {
				ComAlertFocus(formObj.to_duration, ComGetMsg('FMS01716'));
				return false;
			}
		}
		return true;
	}	
	/**
     * Deleting TO of Contract Type
     **/
    function removeContractTP() {
		for (var i=0;i<document.form.flet_ctrt_tp_cd.length;i++) {
			if (document.form.flet_ctrt_tp_cd.options[i].value == "TO") {
				document.form.flet_ctrt_tp_cd.remove(i);
				break;
			}
		}
	}	
	/**
     * Setting Head Title and Column information and retrieving year when retrieving 
     **/
    function setColumnInfo(formObj) {
		var fr_duration=parseFloat(formObj.fr_duration.value);
		var to_duration=parseFloat(formObj.to_duration.value);
		var k=1;
		for (var i=fr_duration;i<=to_duration;i++) {
			for (var j=1;j<13;j++) {
				if (j<10) {
					sheetObjects[0].SetCellValue(1,"ym"+ k +"_0"+j,i);
					sheetObjects[0].SetCellValue(2,"ym"+ k +"_0"+j,i.toString().substr(2)+"0"+j);
		        	sheetObjects[0].SetColHidden("ym" + k + "_0" + j,0);
				} else {
					sheetObjects[0].SetCellValue(1,"ym"+ k +"_"+j,i);
					sheetObjects[0].SetCellValue(2,"ym"+ k +"_"+j,i.toString().substr(2)+j);
		        	sheetObjects[0].SetColHidden("ym" + k + "_" + j,0);
				}
			}
			k++;
		}
		for (var ii=k;ii<4;ii++) {
			for (var j=1;j<13;j++) {
				if (j<10) {
			        sheetObjects[0].SetColHidden("ym"+ii+"_0"+j,1);
				} else {
			        sheetObjects[0].SetColHidden("ym"+ii+"_"+j,1);
				}
			}
		}
	}	
  /**
     * setting sheet initial values and header <br>
     * adding case as numbers of counting sheets <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
     * @return N/A
     * @author 
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
		              var HeadTitle1="Seq|TEU|Vessel\nCode|Lane";
		              var HeadTitle2="Seq|TEU|Vessel\nCode|Lane";
		              var HeadTitle3="Seq|TEU|Vessel\nCode|Lane";
		              var arrMonth=new Array(13);
		              for (var iYear=1; iYear < 4; iYear++){
			              HeadTitle1 += arrMonth.join("|Duration(Year/Month)");
			              HeadTitle2 += arrMonth.join("|Year");
			              for(var iMon=1; iMon < 13; iMon++) {
				              if (iMon<10) {
				            	  HeadTitle3 += "|" + "0" + iMon;
				              } else {
				            	  HeadTitle3 += "|" + iMon;
				              }
			              }
		              }
		
		              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
		              var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"},{ Text:HeadTitle3, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                           {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_dznd_capa" },
		                           {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd" },
		                           {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd" } ];
		             
		              for (var iYear=1; iYear < 2; iYear++){
			              for(var iMon=1; iMon < 13; iMon++) {
				              if (iMon<10) {
				            	  sName="ym"+iYear.toString() + "_" + "0" + iMon;
				              } else {
				            	  sName="ym"+iYear.toString() + "_" + iMon;
				              }
				              cols.push({Type:"Text",     Hidden:0,  Width:60,    Align:"Center",  ColMerge:1,   SaveName:sName });
			              }
		              }
		              for (var iYear=2; iYear < 4; iYear++){
			              for(var iMon=1; iMon < 13; iMon++) {
				              if (iMon<10) {
				            	  sName="ym"+iYear.toString() + "_" + "0" + iMon;
				              } else {
				            	  sName="ym"+iYear.toString() + "_" + iMon;
				              }
				              cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:sName });
				              
			              }
			          }
			         
		            InitColumns(cols);
	              	SetEditable(0);
	              	SetExtendLastCol(0);
                    SetSelectionMode(0);
//                  SetSheetHeight(390);
                    resizeSheet();     
              }
           break;
        }
    }
  	// Handling Sheet Process
    function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
         	case IBSEARCH:      
       	   	  	if(validateForm(sheetObj,formObj,sAction)){
	        		formObj.f_cmd.value=SEARCH;
					sheetObj.SetDataFontColor("#FFFFFF");
 	        	   	//sheetObj.DoSearch("ESM_FMS_0055GS.do", FormQueryString(formObj) );
 	        	   	var sXml=sheetObj.GetSearchData("ESM_FMS_0055GS.do", FormQueryString(formObj));
 	        	   	//UI개선(201408 민정호)
//       	   	  		setColumnInfo(formObj);
       	   	  		//inputReadOnly("Search");
 	        	    var aXml=sXml.split("|$$|");
 	        	   	//sheetObj = sheetObj.Reset();
 	           		//sheetObjects[0] = sheetObj;
 	           		//initSheet(sheetObj, 1 );
 	           		sheetObj.LoadSearchData(aXml[0],{Sync:1} );
	  	   	  	}	
                break;
			case IBROWSEARCH:   
				if (Col == "ComCd") {//Status, Dry Dock Type
					CoFmsGetCombo("FORM", formObj, sheetObj, "CD01748:CD01513","flet_dck_svey_tp_cd:flet_ctrt_tp_cd", "flet_dck_svey_tp_cdText:flet_ctrt_tp_cdText");
	    		} else if (Col == "vsl_cd") {
					formObj.f_cmd.value=SEARCH01;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var vslEngNm=ComGetEtcData(sXml, "vslEngNm");
		   			if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
		   				formObj.vsl_eng_nm.value=vslEngNm;
					} else {
						formObj.vsl_cd.value="";
						formObj.vsl_eng_nm.value="";
						ComAlertFocus(formObj.vsl_cd, ComGetMsg("FMS01056"));
						return;
					}
	    		} else if (Col == "lane_cd") {
					formObj.f_cmd.value=SEARCH05;
 		   			var sXml=sheetObj.GetSearchData("ESM_FMS_0022GS.do" , FormQueryString(formObj));
		   			var cdName=ComGetEtcData(sXml, "cdName");
		   			if(typeof cdName != "undefined" && cdName != "" ) {
					} else {
						formObj.lane_cd.value="";
						ComAlertFocus(formObj.lane_cd, ComGetMsg("FMS01237"));
						return;
					}
				}	
                break;
        }
    }
    /**
     * Handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        if (!ComChkValid(formObj)) return false;
        return true;
    }
     /**
      * Event implements after retrieving IBSheet
      */
    function sheet1_OnSearchEnd(sheetObj, code, ErrMsg){
 		/*
		S=Special Class Survey		light yellow	FFFF00
		I=Intermediate Class Survey	light sky-blue	99CCFF
		D=Docking Survey				light purple CC99FF
		P=Propeller Shaft Survey		light flesh-color	FFCC99
		T=Temporary Class Survey		light green	CCFFFF
 		*/
    	var arrColor=new Array(6);
    	arrColor[0]="#FFFF00";
    	arrColor[1]="#FFFF00";
    	arrColor[2]="#99CCFF";
    	arrColor[3]="#CC99FF";
    	arrColor[4]="#FFCC99";
    	arrColor[5]="#CCFFFF";
		var formObj=document.form;
		var fr_duration=formObj.fr_duration.value;
		var to_duration=formObj.to_duration.value;
		var lastCol=(parseFloat(to_duration) - parseFloat(fr_duration)+1)*12+3 ;
        //sheetObj.SetCellFontColor(4,2,arrColor[iColor]);
    	
        for (var ir=sheetObj.HeaderRows(); ir<=sheetObj.LastRow(); ir++) {
	    	for (var ic=4; ic<=lastCol; ic++) {
	    		var TypeCd=sheetObj.GetCellText(ir,ic);
	    		
	    		if (TypeCd=="") continue;
	    		var iColor=getDockTP(TypeCd);
	    		sheetObj.SetCellBackColor(ir,ic,arrColor[iColor]);
            	sheetObj.SetCellFontColor(ir,ic,arrColor[iColor]);
        		if(TypeCd=="S"){
    	    		sheetObj.SetCellBackColor(ir, ic, "#FFFF00");
    	    		sheetObj.SetCellFontColor(ir,ic, "#FFFF00");
    	    	}
	    	}
	    }
	    sheetObj.SetDataFontColor("#000000");
	
 		
 		//UI개선(201408 민정호)
 		setColumnInfo(formObj); 		
    }
     /**
      * Event implemets In case Mouse over in IBSheet
      */
	function sheet1_OnMouseMove(sheetObj,Button,Shift,X,Y) {
		if (sheetObj.MouseRow()> 2 && sheetObj.MouseCol()> 3) {
			var sText=sheetObj.GetCellText(sheetObj.MouseRow(),sheetObj.MouseCol());
			if (sText != "") {
 				//sheetObj.MouseToolTipText = document.form.flet_dck_svey_tp_cd.options[getDockTP(sText)].text;
			}
		}
	}
	/**
     * Getting Location information of D/Dock TP
     **/
    function getDockTP(TypeCd) {
    	var obj=document.form.flet_dck_svey_tp_cd;
		for (var i=0;i<obj.length;i++) {
			if (obj.options[i].value == TypeCd) {
				return i;
			}
		}
		return -1;
	}	

	function rdOpen(formObject){
  		
 		//rdParam = RD_FormQueryString(formObject,1);
 		var rdParam = '/rv '+ RD_FormQueryString(formObject,1);
 		//var rdParam  = '/rv '+ rdParam;
		    rdParam += " sqlQuery["+getSqlQuery(formObject)+"]";
		    
		var rdFile = "apps/opus/esm/fms/timecharterinoutfleetmanagement/tchariodockschedule/report/ESM_FMS_056_3.mrd";
		if (formObject.snd_year.value == '') {
			rdFile = 'apps/opus/esm/fms/timecharterinoutfleetmanagement/tchariodockschedule/report/ESM_FMS_056_1.mrd';
		} else if (formObject.trd_year.value == '') {
			rdFile = 'apps/opus/esm/fms/timecharterinoutfleetmanagement/tchariodockschedule/report/ESM_FMS_056_2.mrd';
		}
		
 		formObject.com_mrdPath.value = rdFile;
 		formObject.com_mrdArguments.value = rdParam;
 	    ComOpenRDPopup();
	}
    /**
     * Generating required Parameter when clicking print button <br>
     * @param {Form Object} formObject     	form name
     **/
    function getSqlQuery(formObject) {
		var sqlStr=" select vsl_cd,slan_cd,vsl_dznd_capa																																								"
					+ " ,ym1_01                                                                                                                                                             							"
					+ " ,ym1_02                                                                                                                                                             							"
					+ " ,ym1_03                                                                                                                                                             							"
					+ " ,ym1_04                                                                                                                                                             							"
					+ " ,ym1_05                                                                                                                                                             							"
					+ " ,ym1_06                                                                                                                                                             							"
					+ " ,ym1_07                                                                                                                                                             							"
					+ " ,ym1_08                                                                                                                                                             							"
					+ " ,ym1_09                                                                                                                                                             							"
					+ " ,ym1_10                                                                                                                                                             							"
					+ " ,ym1_11                                                                                                                                                             							"
					+ " ,ym1_12                                                                                                                                                             							";
				if (formObject.snd_year.value != "") {
					sqlStr=sqlStr +"	,ym2_01                                                                                                                                                             							"
					+ " ,ym2_02                                                                                                                                                             							"
					+ " ,ym2_03                                                                                                                                                             							"
					+ " ,ym2_04                                                                                                                                                             							"
					+ " ,ym2_05                                                                                                                                                             							"
					+ " ,ym2_06                                                                                                                                                             							"
					+ " ,ym2_07                                                                                                                                                             							"
					+ " ,ym2_08                                                                                                                                                             							"
					+ " ,ym2_09                                                                                                                                                             							"
					+ " ,ym2_10                                                                                                                                                             							"
					+ " ,ym2_11                                                                                                                                                             							"
					+ " ,ym2_12                                                                                                                                                             							";
				}
				if (formObject.trd_year.value != "") {
					sqlStr=sqlStr +"	,ym3_01                                                                                                                                                             							"
					+ " ,ym3_02                                                                                                                                                             							"
					+ " ,ym3_03                                                                                                                                                             							"
					+ " ,ym3_04                                                                                                                                                             							"
					+ " ,ym3_05                                                                                                                                                             							"
					+ " ,ym3_06                                                                                                                                                             							"
					+ " ,ym3_07                                                                                                                                                             							"
					+ " ,ym3_08                                                                                                                                                             							"
					+ " ,ym3_09                                                                                                                                                             							"
					+ " ,ym3_10                                                                                                                                                             							"
					+ " ,ym3_11                                                                                                                                                             							"
					+ " ,ym3_12                                                                                                                                                             							";
				}
				sqlStr=sqlStr + " "
					+" from (                                                                                                                                                              							"
					+ "	select a.vsl_cd,																																												"
					+ "			d.slan_cd,                                                                                                                                                                              "
					+ "			b.vsl_dznd_capa                                                                                                                                                                         ";
		if (formObject.reflection_cd.value == "I") {
				sqlStr=sqlStr +"	,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0131' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0101' then a.flet_dck_svey_tp_cd else '' end) ym1_01                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0231' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0201' then a.flet_dck_svey_tp_cd else '' end) ym1_02                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0331' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0301' then a.flet_dck_svey_tp_cd else '' end) ym1_03                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0431' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0401' then a.flet_dck_svey_tp_cd else '' end) ym1_04                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0531' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0501' then a.flet_dck_svey_tp_cd else '' end) ym1_05                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0631' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0601' then a.flet_dck_svey_tp_cd else '' end) ym1_06                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0731' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0701' then a.flet_dck_svey_tp_cd else '' end) ym1_07                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0831' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0801' then a.flet_dck_svey_tp_cd else '' end) ym1_08                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'0931' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'0901' then a.flet_dck_svey_tp_cd else '' end) ym1_09                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'1031' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'1001' then a.flet_dck_svey_tp_cd else '' end) ym1_10                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'1131' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'1101' then a.flet_dck_svey_tp_cd else '' end) ym1_11                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.fr_duration.value+"'||'1231' and phs_in_dt >= '"+formObject.fr_duration.value+"'||'1201' then a.flet_dck_svey_tp_cd else '' end) ym1_12                                                ";
				if (formObject.snd_year.value != "") {
					sqlStr=sqlStr +"	,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0131' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0101' then a.flet_dck_svey_tp_cd else '' end) ym2_01                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0231' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0201' then a.flet_dck_svey_tp_cd else '' end) ym2_02                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0331' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0301' then a.flet_dck_svey_tp_cd else '' end) ym2_03                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0431' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0401' then a.flet_dck_svey_tp_cd else '' end) ym2_04                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0531' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0501' then a.flet_dck_svey_tp_cd else '' end) ym2_05                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0631' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0601' then a.flet_dck_svey_tp_cd else '' end) ym2_06                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0731' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0701' then a.flet_dck_svey_tp_cd else '' end) ym2_07                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0831' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0801' then a.flet_dck_svey_tp_cd else '' end) ym2_08                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'0931' and phs_in_dt >= '"+formObject.snd_year.value+"'||'0901' then a.flet_dck_svey_tp_cd else '' end) ym2_09                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'1031' and phs_in_dt >= '"+formObject.snd_year.value+"'||'1001' then a.flet_dck_svey_tp_cd else '' end) ym2_10                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'1131' and phs_in_dt >= '"+formObject.snd_year.value+"'||'1101' then a.flet_dck_svey_tp_cd else '' end) ym2_11                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.snd_year.value+"'||'1231' and phs_in_dt >= '"+formObject.snd_year.value+"'||'1201' then a.flet_dck_svey_tp_cd else '' end) ym2_12                                                ";
				}
				if (formObject.trd_year.value != "") {
					sqlStr=sqlStr +"	,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0131' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0101' then a.flet_dck_svey_tp_cd else '' end) ym3_01                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0231' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0201' then a.flet_dck_svey_tp_cd else '' end) ym3_02                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0331' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0301' then a.flet_dck_svey_tp_cd else '' end) ym3_03                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0431' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0401' then a.flet_dck_svey_tp_cd else '' end) ym3_04                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0531' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0501' then a.flet_dck_svey_tp_cd else '' end) ym3_05                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0631' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0601' then a.flet_dck_svey_tp_cd else '' end) ym3_06                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0731' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0701' then a.flet_dck_svey_tp_cd else '' end) ym3_07                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0831' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0801' then a.flet_dck_svey_tp_cd else '' end) ym3_08                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'0931' and phs_in_dt >= '"+formObject.trd_year.value+"'||'0901' then a.flet_dck_svey_tp_cd else '' end) ym3_09                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'1031' and phs_in_dt >= '"+formObject.trd_year.value+"'||'1001' then a.flet_dck_svey_tp_cd else '' end) ym3_10                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'1131' and phs_in_dt >= '"+formObject.trd_year.value+"'||'1101' then a.flet_dck_svey_tp_cd else '' end) ym3_11                                                "
					+ "				,max(case when phs_out_dt <= '"+formObject.trd_year.value+"'||'1231' and phs_in_dt >= '"+formObject.trd_year.value+"'||'1201' then a.flet_dck_svey_tp_cd else '' end) ym3_12                                                ";
				}
			} else {
				sqlStr=sqlStr +"	,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'01','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_01	"
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'02','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_02   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'03','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0301','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_03   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'04','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0401','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_04   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'05','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0501','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_05   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'06','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0601','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_06   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'07','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0701','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_07   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'08','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0801','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_08   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'09','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0901','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_09   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'10','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'1001','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_10   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'11','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'1101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_11   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.fr_duration.value+"'||'12','yyyymm')) and dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'1201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym1_12   ";
				if (formObject.snd_year.value != "") {
					sqlStr=sqlStr +"	,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'01','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_01   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'02','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_02   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'03','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0301','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_03   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'04','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0401','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_04   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'05','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0501','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_05   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'06','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0601','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_06   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'07','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0701','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_07   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'08','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0801','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_08   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'09','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'0901','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_09   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'10','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'1001','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_10   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'11','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'1101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_11   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.snd_year.value+"'||'12','yyyymm')) and dck_to_dt >= to_date('"+formObject.snd_year.value+"'||'1201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym2_12   ";
				}
				if (formObject.trd_year.value != "") {
					sqlStr=sqlStr +"	,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'01','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_01   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'02','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_02   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'03','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0301','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_03   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'04','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0401','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_04   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'05','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0501','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_05   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'06','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0601','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_06   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'07','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0701','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_07   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'08','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0801','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_08   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'09','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'0901','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_09   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'10','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'1001','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_10   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'11','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'1101','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_11   "
					+ "				,max(case when dck_fm_dt <= last_day(to_date('"+formObject.trd_year.value+"'||'12','yyyymm')) and dck_to_dt >= to_date('"+formObject.trd_year.value+"'||'1201','yyyymmdd') then a.flet_dck_svey_tp_cd else '' end) ym3_12   ";
				}
		}
			sqlStr += "			from fms_dck_skd a, fms_contract b,                                                                                                                                                     "
					+ "				(select vsl_cd, flet_ctrt_no                                                                                                                                                        "
					+ "				from (                                                                                                                                                                              "
					+ "						select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num                                                                      "
					+ "						from fms_contract                                                                                                                                                           "
					+ "						where flet_ctrt_tp_cd <> 'TO'                                                                                                                                               "
					+ "					)                                                                                                                                                                               "
					+ "				where row_num=1                                                                                                                                                                   "
					+ "				union all                                                                                                                                                                           "
					+ "				select vsl_cd, flet_ctrt_no                                                                                                                                                         "
					+ "				from (                                                                                                                                                                              "
					+ "						select vsl_cd, flet_ctrt_no, row_number() over(partition by vsl_cd order by flet_ctrt_no desc) row_num                                                                      "
					+ "						from fms_id_vsl a                                                                                                                                                           "
					+ "						where not exists (select null from fms_contract where vsl_cd=a.vsl_cd)                                                                                                    "
					+ "					)                                                                                                                                                                               "
					+ "				where row_num=1                                                                                                                                                                   "
					+ "				) c,                                                                                                                                                                                "
					+ "				(select vsl_cd, slan_cd                                                                                                                                                             "
					+ "				 from (                                                                                                                                                                             "
					+ "						select vsl_cd, slan_cd, vps_eta_dt, row_number() over(partition by vsl_cd order by vps_eta_dt desc) lane_num                                                                "
					+ "						from vsk_vsl_port_skd                                                                                                                                                       "
					+ "						where vps_eta_dt between to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd') and to_date('"+formObject.to_duration.value+"'||'1231','yyyymmdd')                      "
					+ "					)                                                                                                                                                                               "
					+ "				 where lane_num=1) d                                                                                                                                                              ";
			if (formObject.ownr_seq.value != "") { 
				sqlStr += "			 ,(select vndr_seq from mdm_vendor                                                                                                                                                  "
						+ "				where flet_mgmt_ownr_vndr_seq="+formObject.ownr_seq.value+") e                                                                                                                ";
			} 
			sqlStr += "			where a.vsl_cd=c.vsl_cd(+)                                                                                                                                                            "
					+ "			and   a.vsl_cd=d.vsl_cd(+)                                                                                                                                                            "
					+ "			and   b.flet_ctrt_no(+)=c.flet_ctrt_no                                                                                                                                                ";
			if (formObject.flet_ctrt_tp_cd.value != "") {
				sqlStr += "		and   b.flet_ctrt_tp_cd like '"+formObject.flet_ctrt_tp_cd.value+"'||'%'                                                                                                                  ";
			}
			if (formObject.vsl_dznd_capa_fr.value != "") { 
				sqlStr += "		and   b.vsl_dznd_capa >= "+formObject.vsl_dznd_capa_fr.value+"                                                                                                                          ";
			}  
			if (formObject.vsl_dznd_capa_to.value != "") {
				sqlStr += "		and   b.vsl_dznd_capa <= "+formObject.vsl_dznd_capa_to.value+"                                                                                                                          ";
			}
			if (formObject.lane_cd.value != "") {  
				sqlStr += "		and   d.slan_cd like '"+formObject.lane_cd.value+"'||'%'                                                                                                                                  ";
			} 
			if (formObject.ownr_seq.value != "") {
				sqlStr += "		and   b.vndr_seq=e.vndr_seq                                                                                                                                                           ";
			}
			sqlStr += "			and	  a.vsl_cd like '"+formObject.vsl_cd.value+"'||'%'                                                                                                                                    "
					+ "			and   a.dck_sel_cd='E'                                                                                                                                                                "
					+ "			and   a.flet_dck_svey_tp_cd like '"+formObject.flet_dck_svey_tp_cd.value+"'||'%'                                                                                                          ";
			if (formObject.reflection_cd.value == "I") { 
				sqlStr += "		and a.phs_out_dt <= '"+formObject.to_duration.value+"'||'1231' and a.phs_in_dt >= '"+formObject.fr_duration.value+"'                                                           ";
			} else {
				sqlStr += "		and a.dck_fm_dt <= to_date('"+formObject.to_duration.value+"'||'1231','yyyymmdd') and a.dck_to_dt >= to_date('"+formObject.fr_duration.value+"'||'0101','yyyymmdd')            ";
			}
			sqlStr += "	group by a.vsl_cd,                                                                                                                                                                              "
					+ "			d.slan_cd,                                                                                                                                                                              "
					+ "			b.vsl_dznd_capa )                                                                                                                                                                       ";    
		return sqlStr;
	}
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }    
