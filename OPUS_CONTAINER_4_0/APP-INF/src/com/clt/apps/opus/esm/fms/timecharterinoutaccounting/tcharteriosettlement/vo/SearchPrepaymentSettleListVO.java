/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchPrepaymentSettleListVO.java
*@FileTitle : SearchPrepaymentSettleListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.07.29 윤세영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤세영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPrepaymentSettleListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPrepaymentSettleListVO> models = new ArrayList<SearchPrepaymentSettleListVO>();
	
	/* Column Info */
	private String slpFuncCd = null;
	/* Column Info */
	private String vvdExpDt = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String slpOfcCd = null;
	/* Column Info */
	private String slpIssDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdEffDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String slpTpCd = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String orgSlipNo = null;
	/* Column Info */
	private String slpSerNo = null;
	/* Column Info */
	private String slpLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPrepaymentSettleListVO() {}

	public SearchPrepaymentSettleListVO(String ibflag, String pagerows, String csrDesc, String orgSlipNo, String slpTpCd, String slpFuncCd, String slpOfcCd, String slpIssDt, String slpSerNo, String slpSeqNo, String acctCd, String csrCurrCd, String csrAmt, String ctrCd, String slpLocCd, String vvdEffDt, String vvdExpDt, String invSeq) {
		this.slpFuncCd = slpFuncCd;
		this.vvdExpDt = vvdExpDt;
		this.csrDesc = csrDesc;
		this.csrCurrCd = csrCurrCd;
		this.invSeq = invSeq;
		this.slpSeqNo = slpSeqNo;
		this.slpOfcCd = slpOfcCd;
		this.slpIssDt = slpIssDt;
		this.pagerows = pagerows;
		this.vvdEffDt = vvdEffDt;
		this.ibflag = ibflag;
		this.ctrCd = ctrCd;
		this.acctCd = acctCd;
		this.slpTpCd = slpTpCd;
		this.csrAmt = csrAmt;
		this.orgSlipNo = orgSlipNo;
		this.slpSerNo = slpSerNo;
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());
		this.hashColumns.put("vvd_exp_dt", getVvdExpDt());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("slp_ofc_cd", getSlpOfcCd());
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_eff_dt", getVvdEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("org_slip_no", getOrgSlipNo());
		this.hashColumns.put("slp_ser_no", getSlpSerNo());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("vvd_exp_dt", "vvdExpDt");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("slp_ofc_cd", "slpOfcCd");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_eff_dt", "vvdEffDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("org_slip_no", "orgSlipNo");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return slpFuncCd
	 */
	public String getSlpFuncCd() {
		return this.slpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return vvdExpDt
	 */
	public String getVvdExpDt() {
		return this.vvdExpDt;
	}
	
	/**
	 * Column Info
	 * @return csrDesc
	 */
	public String getCsrDesc() {
		return this.csrDesc;
	}
	
	/**
	 * Column Info
	 * @return csrCurrCd
	 */
	public String getCsrCurrCd() {
		return this.csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return slpSeqNo
	 */
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return slpOfcCd
	 */
	public String getSlpOfcCd() {
		return this.slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return slpIssDt
	 */
	public String getSlpIssDt() {
		return this.slpIssDt;
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
	 * @return vvdEffDt
	 */
	public String getVvdEffDt() {
		return this.vvdEffDt;
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
	 * @return ctrCd
	 */
	public String getCtrCd() {
		return this.ctrCd;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return slpTpCd
	 */
	public String getSlpTpCd() {
		return this.slpTpCd;
	}
	
	/**
	 * Column Info
	 * @return csrAmt
	 */
	public String getCsrAmt() {
		return this.csrAmt;
	}
	
	/**
	 * Column Info
	 * @return orgSlipNo
	 */
	public String getOrgSlipNo() {
		return this.orgSlipNo;
	}
	
	/**
	 * Column Info
	 * @return slpSerNo
	 */
	public String getSlpSerNo() {
		return this.slpSerNo;
	}
	
	/**
	 * Column Info
	 * @return slpLocCd
	 */
	public String getSlpLocCd() {
		return this.slpLocCd;
	}
	

	/**
	 * Column Info
	 * @param slpFuncCd
	 */
	public void setSlpFuncCd(String slpFuncCd) {
		this.slpFuncCd = slpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param vvdExpDt
	 */
	public void setVvdExpDt(String vvdExpDt) {
		this.vvdExpDt = vvdExpDt;
	}
	
	/**
	 * Column Info
	 * @param csrDesc
	 */
	public void setCsrDesc(String csrDesc) {
		this.csrDesc = csrDesc;
	}
	
	/**
	 * Column Info
	 * @param csrCurrCd
	 */
	public void setCsrCurrCd(String csrCurrCd) {
		this.csrCurrCd = csrCurrCd;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param slpSeqNo
	 */
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param slpOfcCd
	 */
	public void setSlpOfcCd(String slpOfcCd) {
		this.slpOfcCd = slpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param slpIssDt
	 */
	public void setSlpIssDt(String slpIssDt) {
		this.slpIssDt = slpIssDt;
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
	 * @param vvdEffDt
	 */
	public void setVvdEffDt(String vvdEffDt) {
		this.vvdEffDt = vvdEffDt;
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
	 * @param ctrCd
	 */
	public void setCtrCd(String ctrCd) {
		this.ctrCd = ctrCd;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param slpTpCd
	 */
	public void setSlpTpCd(String slpTpCd) {
		this.slpTpCd = slpTpCd;
	}
	
	/**
	 * Column Info
	 * @param csrAmt
	 */
	public void setCsrAmt(String csrAmt) {
		this.csrAmt = csrAmt;
	}
	
	/**
	 * Column Info
	 * @param orgSlipNo
	 */
	public void setOrgSlipNo(String orgSlipNo) {
		this.orgSlipNo = orgSlipNo;
	}
	
	/**
	 * Column Info
	 * @param slpSerNo
	 */
	public void setSlpSerNo(String slpSerNo) {
		this.slpSerNo = slpSerNo;
	}
	
	/**
	 * Column Info
	 * @param slpLocCd
	 */
	public void setSlpLocCd(String slpLocCd) {
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSlpFuncCd(JSPUtil.getParameter(request, "slp_func_cd", ""));
		setVvdExpDt(JSPUtil.getParameter(request, "vvd_exp_dt", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, "slp_seq_no", ""));
		setSlpOfcCd(JSPUtil.getParameter(request, "slp_ofc_cd", ""));
		setSlpIssDt(JSPUtil.getParameter(request, "slp_iss_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvdEffDt(JSPUtil.getParameter(request, "vvd_eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setSlpTpCd(JSPUtil.getParameter(request, "slp_tp_cd", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setOrgSlipNo(JSPUtil.getParameter(request, "org_slip_no", ""));
		setSlpSerNo(JSPUtil.getParameter(request, "slp_ser_no", ""));
		setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPrepaymentSettleListVO[]
	 */
	public SearchPrepaymentSettleListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPrepaymentSettleListVO[]
	 */
	public SearchPrepaymentSettleListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPrepaymentSettleListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] slpFuncCd = (JSPUtil.getParameter(request, prefix	+ "slp_func_cd", length));
			String[] vvdExpDt = (JSPUtil.getParameter(request, prefix	+ "vvd_exp_dt", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] slpOfcCd = (JSPUtil.getParameter(request, prefix	+ "slp_ofc_cd", length));
			String[] slpIssDt = (JSPUtil.getParameter(request, prefix	+ "slp_iss_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdEffDt = (JSPUtil.getParameter(request, prefix	+ "vvd_eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] slpTpCd = (JSPUtil.getParameter(request, prefix	+ "slp_tp_cd", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] orgSlipNo = (JSPUtil.getParameter(request, prefix	+ "org_slip_no", length));
			String[] slpSerNo = (JSPUtil.getParameter(request, prefix	+ "slp_ser_no", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPrepaymentSettleListVO();
				if (slpFuncCd[i] != null)
					model.setSlpFuncCd(slpFuncCd[i]);
				if (vvdExpDt[i] != null)
					model.setVvdExpDt(vvdExpDt[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (slpOfcCd[i] != null)
					model.setSlpOfcCd(slpOfcCd[i]);
				if (slpIssDt[i] != null)
					model.setSlpIssDt(slpIssDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdEffDt[i] != null)
					model.setVvdEffDt(vvdEffDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (slpTpCd[i] != null)
					model.setSlpTpCd(slpTpCd[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (orgSlipNo[i] != null)
					model.setOrgSlipNo(orgSlipNo[i]);
				if (slpSerNo[i] != null)
					model.setSlpSerNo(slpSerNo[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPrepaymentSettleListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPrepaymentSettleListVO[]
	 */
	public SearchPrepaymentSettleListVO[] getSearchPrepaymentSettleListVOs(){
		SearchPrepaymentSettleListVO[] vos = (SearchPrepaymentSettleListVO[])models.toArray(new SearchPrepaymentSettleListVO[models.size()]);
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
		this.slpFuncCd = this.slpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdExpDt = this.vvdExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpOfcCd = this.slpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt = this.slpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdEffDt = this.vvdEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd = this.slpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlipNo = this.orgSlipNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo = this.slpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
