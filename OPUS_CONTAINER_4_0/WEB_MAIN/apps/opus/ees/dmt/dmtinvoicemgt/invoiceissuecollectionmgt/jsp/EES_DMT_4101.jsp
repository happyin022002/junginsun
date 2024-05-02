<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4101.jsp
*@FileTitle  : Sheet Setting Screen 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/18
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4101Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    EesDmt4101Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB ResultSet list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
	String[] arrUsrAuth = null;
	String sec_invoice	= "Y";	// setting button authority of Save, Cancel, A/R I/F
	int i_cnt = 0;

    String tIssoff = "";
    String tJspno = "";
    String tTftp2 = "";
    String tSheetp = "";
    String invoice_issue = "";

    Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
		arrUsrAuth	= account.getUserAuth();	//USR_ROLE_CD of COM_USR_ROLE_MTCH
		StringBuffer sb = new StringBuffer();

		// check authority- if Role of login User if not DMT01, DMT02, DMT03, DMT04
		//					no authority: disply alert "You have no authority to XXXX!" 
		if(arrUsrAuth == null){
			log.debug("[USER_AUTH] null");
			sec_invoice = "N";
		}else{
			log.debug("[USER_AUTH] "+arrUsrAuth.length);
			for(int i = 0; i < arrUsrAuth.length; i++) {
				//test
				sb.append(arrUsrAuth[i]).append("===");

				if(arrUsrAuth[i].equals("DMT01") 
						|| arrUsrAuth[i].equals("DMT02") 
						|| arrUsrAuth[i].equals("DMT03")
						|| arrUsrAuth[i].equals("DMT04"))
				{
					i_cnt++;
				}
			}
			if(i_cnt == 0 ){
				sec_invoice = "N";
			}
		}

		log.debug("[USER_AUTH]"+sb.toString());

        event = (EesDmt4101Event)request.getAttribute("Event");
        tJspno = (String)request.getParameter("jspno");
        invoice_issue   = JSPUtil.getParameter(request,"invoice_issue","1");
        if ( tJspno.equals("EES_DMT_4011") || tJspno.equals("EES_DMT_4012") || tJspno.equals("EES_DMT_3108") || tJspno.equals("EES_DMT_3109") || tJspno.equals("EES_DMT_3007") ) {
            tIssoff = strUsr_of;
        } else {
            if ( invoice_issue.equals("1") ) {
                tIssoff = strUsr_of;
            } else {
                tIssoff = (String)request.getParameter("issoff");
            }
        }
        tTftp2 = (String)request.getParameter("tftp2");
        tSheetp = (String)request.getParameter("sheetp");

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // in loading page, Get data from server.
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<head>
<title>Sheet Setting Screen</title>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="copyFlag" value="N" id="copyFlag" />
<input type="hidden" name="tJspno" value="<%=StringUtil.xssFilter(tJspno)%>" id="tJspno" />
<input type="hidden" name="h_user_office" value="<%= strUsr_of %>" id="h_user_office" />
<input type="hidden" name="sec_invoice" value="<%=sec_invoice %>" id="sec_invoice" />
<input type="hidden" name="hOfad01" id="hOfad01" />
<input type="hidden" name="hOfad02" id="hOfad02" />
<input type="hidden" name="hOfad03" id="hOfad03" />
<input type="hidden" name="hHead01" id="hHead01" />
<input type="hidden" name="hHead02" id="hHead02" />
<input type="hidden" name="hHead03" id="hHead03" />
<input type="hidden" name="hHead04" id="hHead04" />
<input type="hidden" name="hHead05" id="hHead05" />
<input type="hidden" name="hHead06" id="hHead06" />
<input type="hidden" name="hHead07" id="hHead07" />
<input type="hidden" name="hHead08" id="hHead08" />
<input type="hidden" name="hHead09" id="hHead09" />
<input type="hidden" name="hHead10" id="hHead10" />
<input type="hidden" name="hFoot01" id="hFoot01" />
<input type="hidden" name="hFoot02" id="hFoot02" />
<input type="hidden" name="hFoot03" id="hFoot03" />
<input type="hidden" name="hFoot04" id="hFoot04" />
<input type="hidden" name="hFoot05" id="hFoot05" />
<input type="hidden" name="hFoot06" id="hFoot06" />
<input type="hidden" name="hFoot07" id="hFoot07" />
<input type="hidden" name="hFoot08" id="hFoot08" />
<input type="hidden" name="hFoot09" id="hFoot09" />
<input type="hidden" name="hFoot10" id="hFoot10" />
<input type="hidden" name="hFoot11" id="hFoot11" />
<input type="hidden" name="hFoot12" id="hFoot12" />
<input type="hidden" name="hFoot13" id="hFoot13" />
<input type="hidden" name="hFoot14" id="hFoot14" />
<input type="hidden" name="tftp2" value="<%= StringUtil.xssFilter(tTftp2) %>" id="tftp2" />
<input type="hidden" name="trftpp" id="trftpp" />
<input type="hidden" name="sheetp" value="<%=StringUtil.xssFilter(tSheetp) %>" id="sheetp" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Sheet Setting Screen</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			 <button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_copy" 	 id="btn_copy">Copy</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_del"  id="btn_del">Delete</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close"   id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title(E) -->
</div>
<div class="layer_popup_contents">
	<div class= "wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
					<colgroup>
						<col width="70" />
						<col width="100" />
						<col width="50" />
						<col width="80" />
						<col width="50" />
						<col width="" />
					</colgroup>
					<tbody>
					<tr>
	                    <th>Sheet Type</th>
	                    <td>
	                        <select style="width:120px;" name="shttpp" id="shttpp">
	                            <option value="I" selected>Invoice</option>
	                            <option value="D"         >Demand Note</option>
	                            <option value="G"         >Group Demand</option>
	                            <option value="O"         >OTS Invoice</option>
	                        </select>
	                    </td>
	                    <th>Office</th>
	                    <td><input type="text" style="width:60px;" class="input2" value="<%=StringUtil.xssFilter(tIssoff)%>" name="issoff" readonly id="issoff" /> </td>
	                    <th>Tariff Type</th>
	                    <td><script type="text/javascript">ComComboObject('combo1',2,80,1,1)</script></td>
	                </tr>
				</tbody>
			</table>
			</div>
		</div>
			<div class="wrap_result">
			 <table class="grid_2"> 
			 	<tbody>
			 		<colgroup>
			 			<col width="120" />
			 			<col width="*" />
			 		</colgroup>
			 	
	                <tr>
	                    <td colspan="2" align="center"><b>Office Address</b></td>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 1" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="ofad01" maxlength="85" required="" id="ofad01" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 2" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="ofad02" maxlength="85" required="" id="ofad02" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 3" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="ofad03" maxlength="85" required="" id="ofad03" /> </td>
	                </tr>
	                <tr >
	                    <td colspan="2" align="center"><b>Header</b></td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 1" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head01" maxlength="85" required="" id="head01" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 2" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head02" maxlength="85" required="" id="head02" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 3" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head03" maxlength="85" required="" id="head03" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 4" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head04" maxlength="85" required="" id="head04" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 5" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head05" maxlength="85" required="" id="head05" /> </td>
	                </tr>
	            </tbody>
	        </table>
	        <div id = "div_view01" style = "display:'none'" >
	            <table  class="grid_2">
	            	<colgroup>
			 			<col width="120" />
			 			<col width="*" />
			 		</colgroup>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 6" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head06" maxlength="85" required="" id="head06" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 7" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head07" maxlength="85" required="" id="head07" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 8" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head08" maxlength="85" required="" id="head08" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 9" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head09" maxlength="85" required="" id="head09" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value="10" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="head10" maxlength="85" required="" id="head10" /> </td>
	                </tr>
	            </table>
			</div>
			<div id = "div_view02" style = "display:''" >
	           <table class="grid_2">
	           		<colgroup>
			 			<col width="120" />
			 			<col width="*" />
			 		</colgroup>
	                <tr>
	                	<td colspan="2" align="center"><b>Footer</b></td>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 1" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot01" maxlength="85" required="" id="foot01" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 2" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot02" maxlength="85" required="" id="foot02" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 3" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot03" maxlength="85" required="" id="foot03" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 4" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot04" maxlength="85" required="" id="foot04" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 5" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot05" maxlength="85" required="" id="foot05" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 6" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot06" maxlength="85" required="" id="foot06" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 7" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot07" maxlength="85" required="" id="foot07" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 8" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot08" maxlength="85" required="" id="foot08" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 9" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot09" maxlength="85" required="" id="foot09" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 10" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot10" maxlength="85" required="" id="foot10" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 11" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot11" maxlength="85" required="" id="foot11" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 12" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot12" maxlength="85" required="" id="foot12" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 13" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot13" maxlength="85" required="" id="foot13" /> </td>
	                </tr>
	                <tr>
	                    <td><input type="text" style="width:100%;" class="input1" value=" 14" /> </td>
	                    <td><input type="text" style="width:100%; font-family: Arial;" class="noinput1" value="" name="foot14" maxlength="85" required="" id="foot14" /> </td>
	                </tr>
	            </table>
			
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet1',0,0);</script>
		</div>
	</div>	
</div>
</div>
</form>         