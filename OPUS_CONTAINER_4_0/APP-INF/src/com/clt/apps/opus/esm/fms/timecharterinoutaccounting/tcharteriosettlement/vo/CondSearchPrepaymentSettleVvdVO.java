/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondSearchPrepaymentSettleVvdVO.java
*@FileTitle : CondSearchPrepaymentSettleVvdVO
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

public class CondSearchPrepaymentSettleVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondSearchPrepaymentSettleVvdVO> models = new ArrayList<CondSearchPrepaymentSettleVvdVO>();
	
	/* Column Info */
	private String orgSlpTpCd = null;
	/* Column Info */
	private String orgSlpFuncCd = null;
	/* Column Info */
	private String orgSlpSeqNo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String slpAmt = null;
	/* Column Info */
	private String vvdExpDt = null;
	/* Column Info */
	private String csrCurrCd = null;
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String slpDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fletCtrtNo = null;
	/* Column Info */
	private String vvdEffDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String orgSlpSerNo = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String orgSlpOfcCd = null;
	/* Column Info */
	private String orgSlpIssDt = null;
	/* Column Info */
	private String orgSlipNo = null;
	/* Column Info */
	private String slpLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CondSearchPrepaymentSettleVvdVO() {}

	public CondSearchPrepaymentSettleVvdVO(String ibflag, String pagerows, String acctCd, String vslCd, String fletCtrtNo, String vndrSeq, String csrCurrCd, String effDt, String slpDesc, String orgSlipNo, String slpAmt, String orgSlpTpCd, String orgSlpFuncCd, String orgSlpOfcCd, String orgSlpIssDt, String orgSlpSerNo, String orgSlpSeqNo, String ctrCd, String slpLocCd, String vvdExpDt, String vvdEffDt, String invSeq) {
		this.orgSlpTpCd = orgSlpTpCd;
		this.orgSlpFuncCd = orgSlpFuncCd;
		this.orgSlpSeqNo = orgSlpSeqNo;
		this.vslCd = vslCd;
		this.slpAmt = slpAmt;
		this.vvdExpDt = vvdExpDt;
		this.csrCurrCd = csrCurrCd;
		this.invSeq = invSeq;
		this.slpDesc = slpDesc;
		this.pagerows = pagerows;
		this.fletCtrtNo = fletCtrtNo;
		this.vvdEffDt = vvdEffDt;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.ctrCd = ctrCd;
		this.vndrSeq = vndrSeq;
		this.orgSlpSerNo = orgSlpSerNo;
		this.acctCd = acctCd;
		this.orgSlpOfcCd = orgSlpOfcCd;
		this.orgSlpIssDt = orgSlpIssDt;
		this.orgSlipNo = orgSlipNo;
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_slp_tp_cd", getOrgSlpTpCd());
		this.hashColumns.put("org_slp_func_cd", getOrgSlpFuncCd());
		this.hashColumns.put("org_slp_seq_no", getOrgSlpSeqNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("slp_amt", getSlpAmt());
		this.hashColumns.put("vvd_exp_dt", getVvdExpDt());
		this.hashColumns.put("csr_curr_cd", getCsrCurrCd());
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("slp_desc", getSlpDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());
		this.hashColumns.put("vvd_eff_dt", getVvdEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("org_slp_ser_no", getOrgSlpSerNo());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("org_slp_ofc_cd", getOrgSlpOfcCd());
		this.hashColumns.put("org_slp_iss_dt", getOrgSlpIssDt());
		this.hashColumns.put("org_slip_no", getOrgSlipNo());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_slp_tp_cd", "orgSlpTpCd");
		this.hashFields.put("org_slp_func_cd", "orgSlpFuncCd");
		this.hashFields.put("org_slp_seq_no", "orgSlpSeqNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("slp_amt", "slpAmt");
		this.hashFields.put("vvd_exp_dt", "vvdExpDt");
		this.hashFields.put("csr_curr_cd", "csrCurrCd");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("slp_desc", "slpDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("vvd_eff_dt", "vvdEffDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("org_slp_ser_no", "orgSlpSerNo");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("org_slp_ofc_cd", "orgSlpOfcCd");
		this.hashFields.put("org_slp_iss_dt", "orgSlpIssDt");
		this.hashFields.put("org_slip_no", "orgSlipNo");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgSlpTpCd
	 */
	public String getOrgSlpTpCd() {
		return this.orgSlpTpCd;
	}
	
	/**
	 * Column Info
	 * @return orgSlpFuncCd
	 */
	public String getOrgSlpFuncCd() {
		return this.orgSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @return orgSlpSeqNo
	 */
	public String getOrgSlpSeqNo() {
		return this.orgSlpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return slpAmt
	 */
	public String getSlpAmt() {
		return this.slpAmt;
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
	 * @return slpDesc
	 */
	public String getSlpDesc() {
		return this.slpDesc;
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
	 * @return fletCtrtNo
	 */
	public String getFletCtrtNo() {
		return this.fletCtrtNo;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return orgSlpSerNo
	 */
	public String getOrgSlpSerNo() {
		return this.orgSlpSerNo;
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
	 * @return orgSlpOfcCd
	 */
	public String getOrgSlpOfcCd() {
		return this.orgSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return orgSlpIssDt
	 */
	public String getOrgSlpIssDt() {
		return this.orgSlpIssDt;
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
	 * @return slpLocCd
	 */
	public String getSlpLocCd() {
		return this.slpLocCd;
	}
	

	/**
	 * Column Info
	 * @param orgSlpTpCd
	 */
	public void setOrgSlpTpCd(String orgSlpTpCd) {
		this.orgSlpTpCd = orgSlpTpCd;
	}
	
	/**
	 * Column Info
	 * @param orgSlpFuncCd
	 */
	public void setOrgSlpFuncCd(String orgSlpFuncCd) {
		this.orgSlpFuncCd = orgSlpFuncCd;
	}
	
	/**
	 * Column Info
	 * @param orgSlpSeqNo
	 */
	public void setOrgSlpSeqNo(String orgSlpSeqNo) {
		this.orgSlpSeqNo = orgSlpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param slpAmt
	 */
	public void setSlpAmt(String slpAmt) {
		this.slpAmt = slpAmt;
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
	 * @param slpDesc
	 */
	public void setSlpDesc(String slpDesc) {
		this.slpDesc = slpDesc;
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
	 * @param fletCtrtNo
	 */
	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param orgSlpSerNo
	 */
	public void setOrgSlpSerNo(String orgSlpSerNo) {
		this.orgSlpSerNo = orgSlpSerNo;
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
	 * @param orgSlpOfcCd
	 */
	public void setOrgSlpOfcCd(String orgSlpOfcCd) {
		this.orgSlpOfcCd = orgSlpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param orgSlpIssDt
	 */
	public void setOrgSlpIssDt(String orgSlpIssDt) {
		this.orgSlpIssDt = orgSlpIssDt;
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
		setOrgSlpTpCd(JSPUtil.getParameter(request, "org_slp_tp_cd", ""));
		setOrgSlpFuncCd(JSPUtil.getParameter(request, "org_slp_func_cd", ""));
		setOrgSlpSeqNo(JSPUtil.getParameter(request, "org_slp_seq_no", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSlpAmt(JSPUtil.getParameter(request, "slp_amt", ""));
		setVvdExpDt(JSPUtil.getParameter(request, "vvd_exp_dt", ""));
		setCsrCurrCd(JSPUtil.getParameter(request, "csr_curr_cd", ""));
		setInvSeq(JSPUtil.getParameter(request, "inv_seq", ""));
		setSlpDesc(JSPUtil.getParameter(request, "slp_desc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request, "flet_ctrt_no", ""));
		setVvdEffDt(JSPUtil.getParameter(request, "vvd_eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setOrgSlpSerNo(JSPUtil.getParameter(request, "org_slp_ser_no", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setOrgSlpOfcCd(JSPUtil.getParameter(request, "org_slp_ofc_cd", ""));
		setOrgSlpIssDt(JSPUtil.getParameter(request, "org_slp_iss_dt", ""));
		setOrgSlipNo(JSPUtil.getParameter(request, "org_slip_no", ""));
		setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondSearchPrepaymentSettleVvdVO[]
	 */
	public CondSearchPrepaymentSettleVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondSearchPrepaymentSettleVvdVO[]
	 */
	public CondSearchPrepaymentSettleVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondSearchPrepaymentSettleVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_tp_cd", length));
			String[] orgSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_func_cd", length));
			String[] orgSlpSeqNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_seq_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] slpAmt = (JSPUtil.getParameter(request, prefix	+ "slp_amt", length));
			String[] vvdExpDt = (JSPUtil.getParameter(request, prefix	+ "vvd_exp_dt", length));
			String[] csrCurrCd = (JSPUtil.getParameter(request, prefix	+ "csr_curr_cd", length));
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] slpDesc = (JSPUtil.getParameter(request, prefix	+ "slp_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fletCtrtNo = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_no", length));
			String[] vvdEffDt = (JSPUtil.getParameter(request, prefix	+ "vvd_eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] orgSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_ser_no", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] orgSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_ofc_cd", length));
			String[] orgSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "org_slp_iss_dt", length));
			String[] orgSlipNo = (JSPUtil.getParameter(request, prefix	+ "org_slip_no", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CondSearchPrepaymentSettleVvdVO();
				if (orgSlpTpCd[i] != null)
					model.setOrgSlpTpCd(orgSlpTpCd[i]);
				if (orgSlpFuncCd[i] != null)
					model.setOrgSlpFuncCd(orgSlpFuncCd[i]);
				if (orgSlpSeqNo[i] != null)
					model.setOrgSlpSeqNo(orgSlpSeqNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (slpAmt[i] != null)
					model.setSlpAmt(slpAmt[i]);
				if (vvdExpDt[i] != null)
					model.setVvdExpDt(vvdExpDt[i]);
				if (csrCurrCd[i] != null)
					model.setCsrCurrCd(csrCurrCd[i]);
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (slpDesc[i] != null)
					model.setSlpDesc(slpDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fletCtrtNo[i] != null)
					model.setFletCtrtNo(fletCtrtNo[i]);
				if (vvdEffDt[i] != null)
					model.setVvdEffDt(vvdEffDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (orgSlpSerNo[i] != null)
					model.setOrgSlpSerNo(orgSlpSerNo[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (orgSlpOfcCd[i] != null)
					model.setOrgSlpOfcCd(orgSlpOfcCd[i]);
				if (orgSlpIssDt[i] != null)
					model.setOrgSlpIssDt(orgSlpIssDt[i]);
				if (orgSlipNo[i] != null)
					model.setOrgSlipNo(orgSlipNo[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCondSearchPrepaymentSettleVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CondSearchPrepaymentSettleVvdVO[]
	 */
	public CondSearchPrepaymentSettleVvdVO[] getCondSearchPrepaymentSettleVvdVOs(){
		CondSearchPrepaymentSettleVvdVO[] vos = (CondSearchPrepaymentSettleVvdVO[])models.toArray(new CondSearchPrepaymentSettleVvdVO[models.size()]);
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
		this.orgSlpTpCd = this.orgSlpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpFuncCd = this.orgSlpFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSeqNo = this.orgSlpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpAmt = this.slpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdExpDt = this.vvdExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrCurrCd = this.csrCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpDesc = this.slpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo = this.fletCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdEffDt = this.vvdEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSerNo = this.orgSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpOfcCd = this.orgSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpIssDt = this.orgSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlipNo = this.orgSlipNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
