/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceInquiryInPutVO.java
*@FileTitle : ARInvoiceInquiryInPutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.07.30 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInvoiceInquiryInPutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInvoiceInquiryInPutVO> models = new ArrayList<ARInvoiceInquiryInPutVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String issueFlag = null;
	/* Column Info */
	private String scope = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String revSrcCd = null;
	/* Column Info */
	private String dateOption = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String goodFlag = null;
	/* Column Info */
	private String bound = null;
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private int iPage = 1;
	/* Column Info */
	private String invClrFlg = null;
	/* Column Info */
	private String lclChg = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInvoiceInquiryInPutVO() {}

	public ARInvoiceInquiryInPutVO(String ibflag, String pagerows, String dateOption, String fromDate, String toDate, String issueFlag, String goodFlag, String office, String actCustCntCd, String actCustSeq, String revTpCd, String vvd, String scope, String bound, String port, String chgCd, String revSrcCd, String userOfcCd, String invClrFlg, String lclChg, String updUsrId) {
		this.port = port;
		this.office = office;
		this.issueFlag = issueFlag;
		this.scope = scope;
		this.actCustSeq = actCustSeq;
		this.toDate = toDate;
		this.revTpCd = revTpCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.fromDate = fromDate;
		this.revSrcCd = revSrcCd;
		this.dateOption = dateOption;
		this.actCustCntCd = actCustCntCd;
		this.goodFlag = goodFlag;
		this.bound = bound;
		this.userOfcCd = userOfcCd;
		this.invClrFlg = invClrFlg;
		this.lclChg = lclChg;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("issue_flag", getIssueFlag());
		this.hashColumns.put("scope", getScope());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		this.hashColumns.put("date_option", getDateOption());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("good_flag", getGoodFlag());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("inv_clr_flg", getInvClrFlg());
		this.hashColumns.put("lcl_chg", getLclChg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("office", "office");
		this.hashFields.put("issue_flag", "issueFlag");
		this.hashFields.put("scope", "scope");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("date_option", "dateOption");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("good_flag", "goodFlag");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("inv_clr_flg", "invClrFlg");
		this.hashFields.put("lcl_chg", "lclChg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public String getUserOfcCd() {
		return userOfcCd;
	}

	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}

	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return issueFlag
	 */
	public String getIssueFlag() {
		return this.issueFlag;
	}
	
	/**
	 * Column Info
	 * @return scope
	 */
	public String getScope() {
		return this.scope;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return revTpCd
	 */
	public String getRevTpCd() {
		return this.revTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return revSrcCd
	 */
	public String getRevSrcCd() {
		return this.revSrcCd;
	}
	
	/**
	 * Column Info
	 * @return dateOption
	 */
	public String getDateOption() {
		return this.dateOption;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return goodFlag
	 */
	public String getGoodFlag() {
		return this.goodFlag;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
	}
	

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param issueFlag
	 */
	public void setIssueFlag(String issueFlag) {
		this.issueFlag = issueFlag;
	}
	
	/**
	 * Column Info
	 * @param scope
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param revTpCd
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param revSrcCd
	 */
	public void setRevSrcCd(String revSrcCd) {
		this.revSrcCd = revSrcCd;
	}
	
	/**
	 * Column Info
	 * @param dateOption
	 */
	public void setDateOption(String dateOption) {
		this.dateOption = dateOption;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param goodFlag
	 */
	public void setGoodFlag(String goodFlag) {
		this.goodFlag = goodFlag;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * @param iPage the iPage to set
	 */
	public void setIPage(int iPage) {
		this.iPage = iPage;
	}

	/**
	 * @return the iPage
	 */
	public int getIPage() {
		return iPage;
	}
	
	public String getInvClrFlg() {
		return invClrFlg;
	}

	public void setInvClrFlg(String invClrFlg) {
		this.invClrFlg = invClrFlg;
	}

	public String getLclChg() {
		return lclChg;
	}

	public void setLclChg(String lclChg) {
		this.lclChg = lclChg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPort(JSPUtil.getParameter(request, "port", ""));
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setIssueFlag(JSPUtil.getParameter(request, "issue_flag", ""));
		setScope(JSPUtil.getParameter(request, "scope", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setToDate(JSPUtil.getParameter(request, "to_date", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFromDate(JSPUtil.getParameter(request, "from_date", ""));
		setRevSrcCd(JSPUtil.getParameter(request, "rev_src_cd", ""));
		setDateOption(JSPUtil.getParameter(request, "date_option", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setGoodFlag(JSPUtil.getParameter(request, "good_flag", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setIPage(JSPUtil.getParameterAsInt(request, "iPage", 1));
		setInvClrFlg(JSPUtil.getParameter(request, "inv_clr_flg", ""));
		setLclChg(JSPUtil.getParameter(request, "lcl_chg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceInquiryInPutVO[]
	 */
	public ARInvoiceInquiryInPutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInvoiceInquiryInPutVO[]
	 */
	public ARInvoiceInquiryInPutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInvoiceInquiryInPutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] issueFlag = (JSPUtil.getParameter(request, prefix	+ "issue_flag", length));
			String[] scope = (JSPUtil.getParameter(request, prefix	+ "scope", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd", length));
			String[] dateOption = (JSPUtil.getParameter(request, prefix	+ "date_option", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] goodFlag = (JSPUtil.getParameter(request, prefix	+ "good_flag", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] invClrFlg = (JSPUtil.getParameter(request, prefix	+ "inv_clr_flg", length));
			String[] lclChg = (JSPUtil.getParameter(request, prefix	+ "lcl_chg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInvoiceInquiryInPutVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (office[i] != null)
					model.setOffice(office[i]);
				if (issueFlag[i] != null)
					model.setIssueFlag(issueFlag[i]);
				if (scope[i] != null)
					model.setScope(scope[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				if (dateOption[i] != null)
					model.setDateOption(dateOption[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (goodFlag[i] != null)
					model.setGoodFlag(goodFlag[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (invClrFlg[i] != null)
					model.setInvClrFlg(invClrFlg[i]);
				if (lclChg[i] != null)
					model.setLclChg(lclChg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInvoiceInquiryInPutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInvoiceInquiryInPutVO[]
	 */
	public ARInvoiceInquiryInPutVO[] getARInvoiceInquiryInPutVOs(){
		ARInvoiceInquiryInPutVO[] vos = (ARInvoiceInquiryInPutVO[])models.toArray(new ARInvoiceInquiryInPutVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueFlag = this.issueFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scope = this.scope .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateOption = this.dateOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.goodFlag = this.goodFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invClrFlg = this.invClrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclChg = this.lclChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
