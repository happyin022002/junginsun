/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName :  EES_MST_QEXE.js
*@FileTitle : EES_MST_QEXE
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
     * @extends Mst   
     * @class ees_mst_qexe : business script for ees_mst_qexe.
     */ 
    function ees_mst_qexe() {    
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm; 
    }     
   	/* developer job	*/  
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/* Event handler processing by button name */
	function processButtonClick(){
		var sheetObj=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
			
				case "btn_Run":	
					doActionIBSheet(sheetObj,formObject,IBBATCH);		
				break;  
				
				case "btn_new":
					formObject.run_cnt.value = "1";
				    formObject.mst_query.value = "";
	            break;
				case "btn_GetInsert":		
					doActionIBSheet(sheetObj,formObject,IBCREATE);
				break;				
				case "btn_ret":		
					doActionIBSheet(sheetObj,formObject,IBSEARCH);
				break;	            
				case "btn_FileOpen":
					var msg="select query."
					// open path	
					var local_path="C:\\query";	
					//no support[check again]CLT 					var file=sheetObj.OpenFileDialog(msg,"",local_path,"SQL script(*.sql)|*.sql|All files(*.*)|*.*|Backup Files(*.~*)|*.~*");	
					if(file.indexOf('\\') == -1){
						break; 					
					}	
					//file load 	   
  					var fileObject=new ActiveXObject("Scripting.FileSystemObject");
					var fOpen=fileObject.OpenTextFile(file,1);
					var tempTxt="";
					while(!fOpen.AtEndOfStream){
						tempTxt += fOpen.Readline();	
					}
					ComClosePopup(); 
					tempTxt=tempTxt.replace(/;/g,';\n\n');				
					formObject.mst_query.value=tempTxt;  
				break;

				case "btn_SendEDI": 
					alert("Currently not available. Plz Contact MST Staff");
					//doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC01);  			
					//ComOpenWindowCenter("http://203.246.150.28:9001/opuscntr/sppMain.ws?authKey=5555", "xx", 1024, 768, false, true);
					break;									 
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComFuncErrMsg(e); 
			} else {
				ComFuncErrMsg(e); 
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
		initControl();
        for(i=0;i<sheetObjects.length;i++){
            initSheet(sheetObjects[i],i + 1); 
        }	       
    } 
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) { 
            case "sheet1":
                with (sheetObj) {
                    //setting Host information[HostIp, Port, PagePath]
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			}  		  
			break;  		
        }	
    }	
    
    // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {	
			case IBBATCH:      //EXE
				if(validateForm(sheetObj,formObj,sAction)){	 
					var query=formObj.mst_query.value;  
					query=query.replace(/&/g,'☞');   
					var sCondition=new Array (  	
						new Array("EesMstQexe",query,ComGetObjValue(formObj.run_cnt)) 	
					)			
					var sXml=MstQexeRun(sheetObj,sCondition);   
					if(MstComGetErrMsg(sXml) == null){
						var arrXml=sXml.split("|$$|");	
						var retValue=new Array();	
						for(var i=0; i < arrXml.length; i++){ 	  
							retValue[i]=MstXml2ComboString(arrXml[i], "cd_id", "cd_desc");
						} 	
						var resultStr="";	
						if(retValue[0] != null){ 
							for(var j=0; j < retValue[0].length;j++){ 
								var tempText=retValue[0][j].split("|");   
								resultStr += (tempText[0] + "\n RESULT ==>" + tempText[1] + "\n"); 
							}		
						}	
						// return result
						alert(resultStr);	
					} else {
						var exception="Exception : " + ComGetEtcData(sXml,"Exception");
						var msg="ERROR MSG : " + MstComGetErrMsg(sXml)
						// return error message
						alert(exception + "\n" + msg); 
					}	
				}	     	
				break; 
				
			case IBCREATE:      //GET
				if(validateForm(sheetObj,formObj,sAction)){		 
					var query=formObj.mst_query.value;  
					query=query.replace(/&/g,'☞');
					var sCondition=new Array (  	
						new Array("EesMstQexe",query, "GET")    	
					)	
					var comboList = MstComSearchCombo(sheetObj,sCondition);   
						 
					//var tempStr = "";    	 	  												
					//if(comboList[0] != null){  	       
					//	for(var j = 0; j < comboList[0].length;j++){ 
					//		var tempText = comboList[0][j].split("|");	 		  		
					//		tempStr += (tempText[1] + "\n"); 						
					//	}		  			 				    
					//}				  
					var resultStr=formObj.mst_query.value;
					resultStr += "\n\n ============================================  RESULT ============================================\n\n";
					//resultStr += tempStr;  
					formObj.mst_query.value=resultStr;		 		   
				}			     	
				break;  
			case IBSEARCH:      //EDI SEND 
				if(validateForm(sheetObj,formObj,sAction)){		 
					var f_query = '&';					
					/*f_query += 'ibflag=X&';	 			
					f_query += 'del_chk=0&'; 	  
					f_query += 'check_type' + '=' + '' + '&';	
					f_query += 'check_value' + '=' + '';		*/
					formObj.f_cmd.value=COMMAND40;
					var sXml = sheetObj.GetSearchData("EES_MST_COMGS.do",FormQueryString(formObj)+f_query);
					var sUserPass = ComGetEtcData(sXml,"user_pass");
					formObj.result_value.value = sUserPass;
				}				     	
				break;  				
			case IBSEARCH_ASYNC01:      //EDI SEND 
				if(validateForm(sheetObj,formObj,sAction)){		 
					var f_query = '';					
					f_query += 'f_cmd' + '=' + COMMAND40 + '&'; 
					f_query += 'ibflag=X&';	 			
					f_query += 'del_chk=0&'; 	  
					f_query += 'check_type' + '=' + '' + '&';	
					f_query += 'check_value' + '=' + '';	
																		        
					var sXml = sheetObj.GetSearchData("EES_MST_COMGS.do","" ,f_query,true);
				}				     	
				break;  
		}		
    }     
    
    /**
     * handling process for input validation
     */         
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){      
			if(sAction==IBSEARCH) {        
				//if (!ComChkValid(formObj)) return false;        
			} 	 	
        }       	
        return true; 
    }
        	
/* developer job */
