<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0401.jsp
*@FileTitle  : Insurance Main 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.cps.cni.insurance.insurance.event.CpsCni0401Event"%>
<%@ page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsCni0401Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Insurance.Insurance");
	SignOnUserAccount account = null;

	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (CpsCni0401Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 

    //roles = "CNI51";
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->
<input type="hidden" name="insur_tp_nm" id="insur_tp_nm" />
<input type="hidden" name="pop_desc" id="pop_desc" />

<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" readonly="readonly"/>
<input type="hidden" name="usr_roles" value="<%=roles%>" id="usr_roles" readonly="readonly"/>
<input type="hidden" name="usr_area" value="<%=area%>" id="usr_area" readonly="readonly"/>
<input type="hidden" name="usr_office" value="<%=ofcCd%>" id="usr_office" />
<div class="page_title_area clear">
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn1_New"  	id="btn1_New">New</button><!--  
	--><button type="button" class="btn_normal" name="btn1_Save" 	id="btn1_Save">Save</button><!--  
	--><button type="button" class="btn_normal" name="btn1_Delete" 	id="btn1_Delete">Delete</button><!--  
	--></div>
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<div class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="110">
				<col width="230">
				<col width="90">
				<col width="*">
			</colgroup>
			<tr>
				<th>Type of Insurance</th>
				<td><select name="insur_tp_cd" id="insur_tp_cd" style="width:227px;" class="input1" required  caption="Type of Insurance"></select></td>
				<th>Policy Year</th>
				<td><input type="text" name="insur_plcy_yr" value="" class="input1" caption="Policy Year" style="width:50px;ime-mode:disabled;text-align:center" maxlength="4" dataformat="num"  required="" id="insur_plcy_yr" /></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<div id="tabLayer" class="tabLayer" style="display:inline">
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="110">
					<col width="400">
					<col width="60">
					<col width="*">
				</colgroup>
				<tr>
					<td><button type="button" class="btn_etc" style="width: 110px" name="btn_insur_ctnt" 	id="btn_insur_ctnt">Insurer</button></td>  
					<td><input type="text" name="insur_clm_pty_nm" required class="input1" caption="Insurer" dataformat="eng" style="width:315px;" value="" id="insur_clm_pty_nm" /><!--  
					--><button type="button" name="pop_insur_clm_pty" id="pop_insur_clm_pty" class="input_seach_btn"></button></td>
					<td><button type="button" style="width: 190px" class="btn_etc" name="btn_ins_ctnt" 	id="btn_ins_ctnt">Insured</button></td>
					<td><input type="text" name="ins_clm_pty_nm" dataformat="eng" style="width:265px;" value="" id="ins_clm_pty_nm" /><!--  
					--><button type="button" name="pop_ins_clm_pty" id="pop_ins_clm_pty" class="input_seach_btn"></button></td>
					<td style="display: none;"><input type="hidden" name="insur_clm_pty_no" id="insur_clm_pty_no" /><textarea name="insur_ctnt" id="insur_ctnt"></textarea></td>
					<td style="display: none;"><input type="hidden" name="ins_clm_pty_no" id="ins_clm_pty_no" /><textarea name="ins_ctnt" id="ins_ctnt"></textarea></td>
				</tr>
				<tr>
					<td><button type="button" style="width: 110px" class="btn_etc" name="btn_rins_ctnt" 	id="btn_rins_ctnt">Reinsurer</button></td>
					<td><input type="text" name="rins_clm_pty_nm" dataformat="eng" style="width:315px;" value="" id="rins_clm_pty_nm" /><!--  
					--><button type="button" name="pop_ins_clm_pty" id="pop_ins_clm_pty" class="input_seach_btn"></button></td>
					<td><button type="button" style="width: 190px" class="btn_etc" name="btn_cins_ctnt" 	id="btn_cins_ctnt">Co-Insured</button></td>
					<td><input type="text" name="cins_clm_pty_nm" dataformat="eng" style="width:265px;" value="" id="cins_clm_pty_nm" /><!--  
					--><button type="button" name="pop_rins_clm_pty" id="pop_rins_clm_pty" class="input_seach_btn"></button></td>
					<td style="display:none"><input type="hidden" name="rins_clm_pty_no" id="rins_clm_pty_no" /><textarea name="rins_ctnt"></textarea></td>
					<td style="display:none"><input type="hidden" name="cins_clm_pty_no" id="cins_clm_pty_no" /><textarea name="cins_ctnt"></textarea></td>
				</tr>
				<tr>
					<th>Broker</th>
					<td><input type="text" name="bro_clm_pty_nm" dataformat="eng" style="width:315px;" value="" id="bro_clm_pty_nm" /><!--  
					--><button type="button" name="pop_bro_clm_pty" id="pop_bro_clm_pty" class="input_seach_btn"></button></td>
					<td><button type="button" style="width: 190px" name="btn_int_desc" id="btn_int_desc" class="btn_etc">Interest</button></td>
					<td><textarea name="int_desc_nm" caption="Interest" maxlength="4000" style="width:294px;height:25px;resize:none;" rows=1></textarea></td>
					<td><input type="hidden" name="bro_clm_pty_no" id="bro_clm_pty_no" /></td>
					<td style="display:none"><textarea name="int_desc"></textarea></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="115">
					<col width="50">
					<col width="80">
					<col width="40">
					<col width="197">
					<col width="60">
					<col width="*">
				</colgroup>
				<tr>
					<th>Period</th>
					<td>From</td>
					<td><input type="text" name="insur_ctrt_eff_dt" caption="Period(From)" style="width:80px;ime-mode:disabled;text-align:center" dataformat="ymd"  id="insur_ctrt_eff_dt" /><!--  
					--><button type="button" id="cal_insur_ctrt_eff_dt" name="cal_insur_ctrt_eff_dt" class="calendar ir"></button></td>
					<td>To</td>
					<td><input type="text" name="insur_ctrt_exp_dt" caption="Period(To)" style="width:80px;ime-mode:disabled;text-align:center" dataformat="ymd" id="insur_ctrt_exp_dt" /><!--  
					--><button type="button" id="cal_insur_ctrt_exp_dt" name="cal_insur_ctrt_exp_dt" class="calendar ir"></button></td>
					<td><button type="button" style="width: 190px" name="btn_subj_mat_ins_desc" id="btn_subj_mat_ins_desc" class="btn_etc">Subject Matter Insured</button></td>
					<td><textarea name="subj_mat_ins_desc_nm" caption="Subject Matter Insured" maxlength="4000" style="width:294px;height:25px;resize:none;" rows=1></textarea></td>
					<td style="display:none"><textarea name="subj_mat_ins_desc"></textarea></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="115">
					<col width="70">
					<col width="290">
					<col width="80">
					<col width="150">
					<col width="57">
					<col width="*">
				</colgroup>
				<tr>
					<th>Total Premium</th>
					<td><input type="text" name="insur_ttl_curr_cd" style="width:40px;text-align:center" readonly class="input2" value="" id="insur_ttl_curr_cd" /></td>
					<td><input type="text" name="insur_ttl_locl_amt" style="width:247px;text-align:right" readonly class="input2" value="" id="insur_ttl_locl_amt" /></td>
					<th>R. O. E.</th>
					<td><input type="text" name="insur_ttl_xch_rt" style="width:80px;text-align:right" readonly class="input2" value="" id="insur_ttl_xch_rt" /></td>
					<th>USD</th>
					<td><input type="text" name="insur_ttl_usd_amt" style="width:241px; text-align:right" readonly value="" class="input2" id="insur_ttl_usd_amt" /></td>
				</tr>
				<tr>
					<th>Amount Insured</th>
					<td><input type="text" name="ins_curr_cd" caption="Amount Insured(Currency)" style="width:40px;text-align:center;ime-mode:disabled" value="" maxlength="3" dataformat="engup"  id="ins_curr_cd" /><button type="button" id="pop_ins_curr_cd" name="pop_ins_curr_cd" class="input_seach_btn"></button></td>
					<td><input type="text" name="ins_locl_amt" style="width:247px; text-align:right" dataformat="float" maxlength="18" value="" id="ins_locl_amt" /></td>
					<th>R. O. E.</th>
					<td><input type="text" name="ins_xch_rt" style="width:80px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="" id="ins_xch_rt" /><button type="button" id="pop_ins_xch_rt" name="pop_ins_xch_rt" class="input_seach_btn"></button></td>
					<th>USD</th>
					<td><input type="text" name="ins_usd_amt" style="width:241px; text-align:right" readonly value="" class="input2" id="ins_usd_amt" /></td>
				</tr>
				<tr>
					<th>Limit</th>
					<td><input type="text" name="lmt_ins_curr_cd" caption="Limit(Currency)" style="width:40px;text-align:center;ime-mode:disabled" value="" maxlength="3" dataformat="engup"  id="lmt_ins_curr_cd" /><!--  
					--><button type="button" id="pop_lmt_ins_curr_cd" name="pop_lmt_ins_curr_cd" class="input_seach_btn"></button></td>
					<td><input type="text" name="lmt_ins_locl_amt" style="width:247px; text-align:right" dataformat="float" maxlength="18" value="" id="lmt_ins_locl_amt" /></td>
					<th>R. O. E.</th>
					<td><input type="text" name="lmt_ins_xch_rt" style="width:80px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="" id="lmt_ins_xch_rt" /><!--  
					--><button type="button" id="pop_lmt_ins_xch_rt" name="pop_lmt_ins_xch_rt" class="input_seach_btn"></button></td>
					<th>USD</th>
					<td><input type="text" name="lmt_ins_usd_amt" style="width:241px; text-align:right" readonly value="" class="input2" id="lmt_ins_usd_amt" /></td>
				</tr>
			</table>
		</div>
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab2')</script>
		</div>
		<div class="tabLayer1" id="tabLayer1" style="display:inline;height:230">
			<div class="opus_design_data">
				<table>
					<tr>
						<td><textarea name="insur_rmk" caption="Main Terms Remark" maxlength="4000" style="width:100%;resize:none;" rows="15"></textarea></td>
					</tr>
				</table> 	
			</div>
		</div>
		<div class="tabLayer1" id="tabLayer1" style="display:none;height:230">
			<div class="opus_design_grid">
				<div class="opus_design_btn"><!--  
				--><button type="button" class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add">Row Add</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Insert"  	id="btn2_Row_Insert">Row Insert</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Delete" 	id="btn2_Row_Delete">Row Delete</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Save" 	id="btn2_Save">File Save</button><!--  
				--></div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>	
			</div>
		</div>
		<div class="tabLayer1" id="tabLayer1" style="display:none;height:230">
			<div class="opus_design_grid">
				<div class="opus_design_btn"><!--  
				--><button type="button" class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add">Row Add</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Insert"  	id="btn2_Row_Insert">Row Insert</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Delete" 	id="btn2_Row_Delete">Row Delete</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Save" 	id="btn2_Save">File Save</button><!--  
				--></div>
				<script type="text/javascript">ComSheetObject('sheet2');</script>	
			</div>
		</div>
		<div class="tabLayer1" id="tabLayer1" style="display:none;height:230">
			<div class="opus_design_grid">
				<div class="opus_design_btn"><!--  
				--><button type="button" class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add">Row Add</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Insert"  	id="btn2_Row_Insert">Row Insert</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Delete" 	id="btn2_Row_Delete">Row Delete</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Save" 	id="btn2_Save">File Save</button><!--  
				--></div>
				<script type="text/javascript">ComSheetObject('sheet3');</script>	
			</div>
		</div>
		<div class="tabLayer1" id="tabLayer1" style="display:none;height:230">
			<div class="opus_design_grid">
				<div class="opus_design_btn"><!--  
				--><button type="button" class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add">Row Add</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Insert"  	id="btn2_Row_Insert">Row Insert</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Delete" 	id="btn2_Row_Delete">Row Delete</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Save" 	id="btn2_Save">File Save</button><!--  
				--></div>
				<script type="text/javascript">ComSheetObject('sheet4');</script>	
			</div>
		</div>
		<div class="tabLayer1" id="tabLayer1" style="display:none;height:230">
			<div class="opus_design_grid">
				<div class="opus_design_btn"><!--  
				--><button type="button" class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add">Row Add</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Insert"  	id="btn2_Row_Insert">Row Insert</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Delete" 	id="btn2_Row_Delete">Row Delete</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Save" 	id="btn2_Save">File Save</button><!--  
				--></div>
				<script type="text/javascript">ComSheetObject('sheet5');</script>	
			</div>
		</div>
		<div class="tabLayer1" id="tabLayer1" style="display:none;height:230">
			<div class="opus_design_grid">
				<div class="opus_design_btn"><!--  
				--><button type="button" class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add">Row Add</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Insert"  	id="btn2_Row_Insert">Row Insert</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Delete" 	id="btn2_Row_Delete">Row Delete</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Save" 	id="btn2_Save">File Save</button><!--  
				--></div>
				<script type="text/javascript">ComSheetObject('sheet6');</script>	
			</div>
		</div>
		<div class="tabLayer1" id="tabLayer1" style="display:none;height:230">
			<div class="opus_design_grid">
				<div class="opus_design_btn"><!--  
				--><button type="button" class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add">Row Add</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Insert"  	id="btn2_Row_Insert">Row Insert</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Delete" 	id="btn2_Row_Delete">Row Delete</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Save" 	id="btn2_Save">File Save</button><!--  
				--></div>
				<script type="text/javascript">ComSheetObject('sheet7');</script>	
			</div>
		</div>
		<div class="tabLayer1" id="tabLayer1" style="display:none;height:230">
			<div class="opus_design_grid">
				<div class="opus_design_btn"><!--  
				--><button type="button" class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add">Row Add</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Insert"  	id="btn2_Row_Insert">Row Insert</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Delete" 	id="btn2_Row_Delete">Row Delete</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Save" 	id="btn2_Save">File Save</button><!--  
				--></div>
				<script type="text/javascript">ComSheetObject('sheet8');</script>	
			</div>
		</div>
	</div>
	
	
	
	<!--  /////////////////////////////////////////////////////////////  -->
	<div id="tabLayer" class="tabLayer" style="display:inline">
		<div class="opus_design_inquiry">
			<table>
				<col width="100">
				<col width="320">
				<col width="*"> 
				<tr>
					<th>Insurer</th>
					<td><input type="text" name="insur_clm_pty_prm_nm" required class="input1" caption="Insurer" dataformat="eng" style="width:315px;" value="" id="insur_clm_pty_prm_nm" /></td>
					<td><input type="hidden" name="insur_clm_pty_prm_no" id="insur_clm_pty_prm_no" /></td>
				</tr>
			</table>
		</div>

    	<div class="layout_wrap">
    			<div class="layout_wrap">
    		<div class="layout_vertical_2" >
    			<div class="opus_design_inquiry">
					<table>
						<colgroup>
							<col width="100">
							<col width="*">
						</colgroup>
						<tr>
							<th>Type of Premium</th>
							<td><select name="insur_prm_tp_cd" style="width:200px;" required class="input1"  caption="Type of Premium"></select></td>
						</tr>
					</table>
				</div>
    		</div>
    	</div>
    	
    		<div class="layout_vertical_2 sm" style="width: 280px;">
    			<div class="wrap_result">
	    			<h3 class="title_design">Total</h3>
					<div class="opus_design_inquiry">
						<table>
							<tr>
								<th>Amount&nbsp;&nbsp;<input type="text" name="ttl_curr_cd" caption="Amount(Currency)" style="width:40px;text-align:center;ime-mode:disabled" value="" maxlength="3" dataformat="engup" fullfill id="ttl_curr_cd" /><!--  
								--><button type="button" id="pop_ttl_curr_cd" name="pop_ttl_curr_cd" class="input_seach_btn"></button></th>
								<td><input type="text" name="ttl_locl_amt" style="width:114px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value="" id="ttl_locl_amt" /></td>
							</tr>
							<tr>
								<th>R. O. E.</th>
								<td><input type="text" name="ttl_xch_rt" style="width:85px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="" id="ttl_xch_rt" /><!--  
								--><button type="button" id="pop_ttl_xch_rt" name="pop_ttl_xch_rt" class="input_seach_btn"></button></td>
							</tr>
							<tr>
								<th>Amount USD</th>
								<td><input type="text" name="ttl_usd_amt" caption="Total Amount USD" style="width:114px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value="" id="ttl_usd_amt" /></td>
							</tr>
							<tr>
								<th>Due Date</th>
								<td><input type="text" name="ttl_due_dt" caption="Total Due Date" style="width:85px;ime-mode:disabled;text-align:center" dataformat="ymd"  value="" id="ttl_due_dt" /><!--  
								--><button type="button" id="cal_ttl_due_dt" name="cal_ttl_due_dt" class="calendar ir"></button></td>
							</tr>
							<tr>
								<th>Paid Date</th>
								<td><input type="text" name="ttl_pay_dt" caption="Total Paid Date" style="width:85px;ime-mode:disabled;text-align:center" dataformat="ymd"  value="" id="ttl_pay_dt" /><!--  
								--><button type="button" id="cal_ttl_pay_dt" name="cal_ttl_pay_dt" class="calendar ir"></button></td>
							</tr>
						</table>
					</div>
    			</div>
    		</div>

    		<div class="layout_vertical_2" style="width: 370px;">
    		<h3 class="title_design" style="margin-left:15px !important;">Installment</h3>
    			<div class="wrap_result">
    				<div class="opus_design_inquiry">
	    				<table>
	    					<colgroup>
								<col width="80">
								<col width="80">
								<col width="*">
							</colgroup>
							<tr>
								<td><b>Paid</b></td>
								<td><b>Refunded</b></td>
								<td><b>O/S</b></td>
							</tr>
							<tr>
								<td><input type="text" name="adj_locl_amt" caption="Paid Amount" style="width:104px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value="" id="adj_locl_amt" /></td>
								<td><input type="text" name="rfnd_locl_amt" caption="Refunded Amount" style="width:104px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value="" id="rfnd_locl_amt" /></td>
								<td><input type="text" name="ots_locl_amt" caption="O/S Amount" style="width:104px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value="" id="ots_locl_amt" /></td>
							</tr>
							<tr>
								<td><input type="text" name="adj_xch_rt" caption="Paid R. O. E." style="width:75px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="" id="adj_xch_rt" /><!--  
								--><button type="button" id="pop_adj_xch_rt" name="pop_adj_xch_rt" class="input_seach_btn"></button></td>
								<td><input type="text" name="rfnd_xch_rt" caption="Refunded R. O. E." style="width:75px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="" id="rfnd_xch_rt" /><!--  
								--><button type="button" id="pop_rfnd_xch_rt" name="pop_rfnd_xch_rt" class="input_seach_btn"></button></td>
								<td><input type="text" name="ots_xch_rt" caption="O/S R. O. E." style="width:75px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="" id="ots_xch_rt" /><!--  
								--><button type="button" id="pop_ots_xch_rt" name="pop_ots_xch_rt" class="input_seach_btn"></button></td>
							</tr>
							<tr >
								<td><input type="text" name="adj_usd_amt" caption="Paid Amount USD" style="width:104px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value="" id="adj_usd_amt" /></td>
								<td><input type="text" name="rfnd_usd_amt" caption="Refunded Amount USD" style="width:104px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value="" id="rfnd_usd_amt" /></td>
								<td><input type="text" name="ots_usd_amt" caption="O/S Amount USD" style="width:104px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value="" id="ots_usd_amt" /></td>
							</tr>
							<tr >
								<td><input type="text" name="adj_due_dt" caption="Paid Due Date" style="width:75px;ime-mode:disabled;text-align:center" dataformat="ymd"  id="adj_due_dt" /><!--  
								--><button type="button" id="cal_adj_due_dt" name="cal_adj_due_dt" class="calendar ir"></button></td>
								<td><input type="text" name="rfnd_due_dt" caption="Refunded Due Date" style="width:75px;ime-mode:disabled;text-align:center" dataformat="ymd"  id="rfnd_due_dt" /><!--  
								--><button type="button" id="cal_rfnd_due_dt" name="cal_rfnd_due_dt" class="calendar ir"></button></td>
								<td><input type="text" name="ots_due_dt" caption="O/S Due Date" style="width:75px;ime-mode:disabled;text-align:center" dataformat="ymd"  id="ots_due_dt" /><!--  
								--><button type="button" id="cal_ots_due_dt" name="cal_ots_due_dt" class="calendar ir"></button></td>
							</tr>
							<tr >
								<td><input type="text" name="adj_pay_dt" caption="Paid Paid Date" style="width:75px;ime-mode:disabled;text-align:center" dataformat="ymd" id="adj_pay_dt" /><!--  
								--><button type="button" id="cal_adj_pay_dt" name="cal_adj_pay_dt" class="calendar ir"></button></td>
								<td><input type="text" name="rfnd_pay_dt" caption="Refunded Paid Date" style="width:75px;ime-mode:disabled;text-align:center" dataformat="ymd"  id="rfnd_pay_dt" /><!--  
								--><button type="button" id="cal_rfnd_pay_dt" name="cal_rfnd_pay_dt" class="calendar ir"></button></td>
								<td><input type="text" name="ots_pay_dt" caption="O/S Paid Date" style="width:75px;ime-mode:disabled;text-align:center" dataformat="ymd"  id="ots_pay_dt" /><!--  
								--><button type="button" id="cal_ots_pay_dt" name="cal_ots_pay_dt" class="calendar ir"></button></td>
							</tr>
	    				</table>
	    			</div>
    			</div>
    		</div>
    		<div class="layout_vertical_2" style="display:inline;width:340px;height:200px;overflow:scroll;overflow-y:hidden; margin-top:30px;">
    			<div class="wrap_result">
    				<div class="opus_design_inquiry">
    					<table>
    						<tr> 
							<% for (int i=1; i<11; i++) { %>
									<% String strOrder = null;
									   if (i==1) {
									   		strOrder = i+"st";
									   } else if (i==2) {
									   		strOrder = i+"nd";
									   } else if (i==3) {
									   		strOrder = i+"rd";
									   } else {
									   		strOrder = i+"th";
									   } 
									%>
									<td><b><%=strOrder%></b></td>
							<% } %>
							</tr>
							<tr>
							<% for (int i=1; i<11; i++) { %>
								<% String strOrder = null;
								   if (i==1) {
								   		strOrder = i+"st";
								   } else if (i==2) {
								   		strOrder = i+"nd";
								   } else if (i==3) {
								   		strOrder = i+"rd";
								   } else {
								   		strOrder = i+"th";
								   } 
								%>
								<td><input type="text" name="inst_locl_amt_<%=i%>" caption="<%=strOrder%> Amount" styl="width:104px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value="" id="inst_locl_amt_<%=i%>" /></td>
							<% } %>
							</tr>
							<tr>
							<% for (int i=1; i<11; i++) { %>
								<% String strOrder = null;
									   if (i==1) {
									   		strOrder = i+"st";
									   } else if (i==2) {
									   		strOrder = i+"nd";
									   } else if (i==3) {
									   		strOrder = i+"rd";
									   } else {
									   		strOrder = i+"th";
									   } 
									%>
								<td><input type="text" name="inst_xch_rt_<%=i%>" caption="<%=strOrder%> R. O. E." style="width:75px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="" id="inst_xch_rt_<%=i%>" /><!--  
								--><button type="button" id="pop_inst_xch_rt_<%=i%>" name="pop_inst_xch_rt_<%=i%>" class="input_seach_btn"></button></td>
							<% } %>
							</tr>
							<tr>
							<% for (int i=1; i<11; i++) { %>
								<% String strOrder = null;
									   if (i==1) {
									   		strOrder = i+"st";
									   } else if (i==2) {
									   		strOrder = i+"nd";
									   } else if (i==3) {
									   		strOrder = i+"rd";
									   } else {
									   		strOrder = i+"th";
									   } 
								%>
								<td><input type="text" name="inst_usd_amt_<%=i%>" caption="<%=strOrder%> Amount USD" style="width:104px;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value="" id="inst_usd_amt_<%=i%>" /></td>
							<% } %>
							</tr>
							<tr>
							<% for (int i=1; i<11; i++) { %>
								<% String strOrder = null;
									   if (i==1) {
									   		strOrder = i+"st";
									   } else if (i==2) {
									   		strOrder = i+"nd";
									   } else if (i==3) {
									   		strOrder = i+"rd";
									   } else {
									   		strOrder = i+"th";
									   } 
									%>
								<td><input type="text" name="inst_due_dt_<%=i%>" caption="<%=strOrder%> Due Date" style="width:75px;ime-mode:disabled;text-align:center" dataformat="ymd"  id="inst_due_dt_<%=i%>" /><!--  
								--><button type="button" id="cal_inst_due_dt_<%=i%>" name="cal_inst_due_dt_<%=i%>" class="calendar ir"></button></td>
							<% } %>
							</tr>
							<tr>
							<% for (int i=1; i<11; i++) { %>
								<% String strOrder = null;
									   if (i==1) {
									   		strOrder = i+"st";
									   } else if (i==2) {
									   		strOrder = i+"nd";
									   } else if (i==3) {
									   		strOrder = i+"rd";
									   } else {
									   		strOrder = i+"th";
									   } 
									%>
								<td><input type="text" name="inst_pay_dt_<%=i%>" caption="<%=strOrder%> Paid Date" style="width:75px;ime-mode:disabled;text-align:center" dataformat="ymd"  id="inst_pay_dt_<%=i%>" /><!--  
								--><button type="button" id="cal_inst_pay_dt_<%=i%>" name="cal_inst_pay_dt_<%=i%>" class="calendar ir"></button></td>
							<% } %>
							</tr>
						</table>
	    			</div>
    			</div>
    		</div>
    	</div>
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab3')</script>
		</div>
		<div id="tabLayer3" style="display:inline">
			<table class="search" id="mainTable"> 
			    <tr>
			    	<td><textarea name="diff_rmk" caption="Premium Remark" maxlength="4000" style="width:100%;resize:none;" rows="12"></textarea>
				</tr>
			</table> 
		</div>
		<div id="tabLayer3" style="display:none;">
			<div class="opus_design_grid" id="mainTable">
				<div class="opus_design_btn"><!--  
				--><button type="button" class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add">Row Add</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Insert"  	id="btn2_Row_Insert">Row Insert</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Delete" 	id="btn2_Row_Delete">Row Delete</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Save" 	id="btn2_Save">File Save</button><!--  
				--></div>
				<script type="text/javascript">ComSheetObject('sheet9');</script>	
			</div>
		</div>
		<div id="tabLayer3" style="display:none;">
			<div class="opus_design_grid" id="mainTable">
				<div class="opus_design_btn"><!--  
				--><button type="button" class="btn_accent" name="btn2_Row_Add" id="btn2_Row_Add">Row Add</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Insert"  	id="btn2_Row_Insert">Row Insert</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Row_Delete" 	id="btn2_Row_Delete">Row Delete</button><!--  
				--><button type="button" class="btn_normal" name="btn2_Save" 	id="btn2_Save">File Save</button><!--  
				--></div>
				<script type="text/javascript">ComSheetObject('sheet10');</script>	
			</div>
		</div>
	</div>
</div>
<div style="display:none;">
<script type="text/javascript">ComSheetObject('sheet11');</script>
<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>
</form>