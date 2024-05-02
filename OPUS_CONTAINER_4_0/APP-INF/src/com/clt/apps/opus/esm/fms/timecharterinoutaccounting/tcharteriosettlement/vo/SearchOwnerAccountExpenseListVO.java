/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOwnerAccountExpenseListVO.java
*@FileTitle : SearchOwnerAccountExpenseListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.06.15 윤세영 
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

public class SearchOwnerAccountExpenseListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOwnerAccountExpenseListVO> models = new ArrayList<SearchOwnerAccountExpenseListVO>();
	
	/* Column Info */
	private String orgSlpTpCd = null;
	/* Column Info */
	private String orgSlpFuncCd = null;
	/* Column Info */
	private String orgSlpSeqNo = null;
	/* Column Info */
	private String apDesc4 = null;
	/* Column Info */
	private String apDesc5 = null;
	/* Column Info */
	private String apDesc2 = null;
	/* Column Info */
	private String apDesc3 = null;
	/* Column Info */
	private String apDesc1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdCd1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String n1stAmt = null;
	/* Column Info */
	private String orgSlpSerNo = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String orgSlpOfcCd = null;
	/* Column Info */
	private String orgSlpIssDt = null;
	/* Column Info */
	private String dummy1 = null;
	/* Column Info */
	private String orgSlipNo = null;
	/* Column Info */
	private String n1stCurrCd = null;
	/* Column Info */
	private String fletPpayRltCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOwnerAccountExpenseListVO() {}

	public SearchOwnerAccountExpenseListVO(String ibflag, String pagerows, String orgSlipNo, String orgSlpTpCd, String orgSlpFuncCd, String orgSlpOfcCd, String orgSlpIssDt, String orgSlpSerNo, String orgSlpSeqNo, String fletPpayRltCd, String acctCd, String vvdCd, String vvdCd1, String n1stCurrCd, String n1stAmt, String apDesc1, String apDesc2, String apDesc3, String apDesc4, String apDesc5, String dummy1) {
		this.orgSlpTpCd = orgSlpTpCd;
		this.orgSlpFuncCd = orgSlpFuncCd;
		this.orgSlpSeqNo = orgSlpSeqNo;
		this.apDesc4 = apDesc4;
		this.apDesc5 = apDesc5;
		this.apDesc2 = apDesc2;
		this.apDesc3 = apDesc3;
		this.apDesc1 = apDesc1;
		this.pagerows = pagerows;
		this.vvdCd1 = vvdCd1;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.n1stAmt = n1stAmt;
		this.orgSlpSerNo = orgSlpSerNo;
		this.acctCd = acctCd;
		this.orgSlpOfcCd = orgSlpOfcCd;
		this.orgSlpIssDt = orgSlpIssDt;
		this.dummy1 = dummy1;
		this.orgSlipNo = orgSlipNo;
		this.n1stCurrCd = n1stCurrCd;
		this.fletPpayRltCd = fletPpayRltCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_slp_tp_cd", getOrgSlpTpCd());
		this.hashColumns.put("org_slp_func_cd", getOrgSlpFuncCd());
		this.hashColumns.put("org_slp_seq_no", getOrgSlpSeqNo());
		this.hashColumns.put("ap_desc4", getApDesc4());
		this.hashColumns.put("ap_desc5", getApDesc5());
		this.hashColumns.put("ap_desc2", getApDesc2());
		this.hashColumns.put("ap_desc3", getApDesc3());
		this.hashColumns.put("ap_desc1", getApDesc1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd_cd1", getVvdCd1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("n1st_amt", getN1stAmt());
		this.hashColumns.put("org_slp_ser_no", getOrgSlpSerNo());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("org_slp_ofc_cd", getOrgSlpOfcCd());
		this.hashColumns.put("org_slp_iss_dt", getOrgSlpIssDt());
		this.hashColumns.put("dummy1", getDummy1());
		this.hashColumns.put("org_slip_no", getOrgSlipNo());
		this.hashColumns.put("n1st_curr_cd", getN1stCurrCd());
		this.hashColumns.put("flet_ppay_rlt_cd", getFletPpayRltCd());
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
		this.hashFields.put("ap_desc4", "apDesc4");
		this.hashFields.put("ap_desc5", "apDesc5");
		this.hashFields.put("ap_desc2", "apDesc2");
		this.hashFields.put("ap_desc3", "apDesc3");
		this.hashFields.put("ap_desc1", "apDesc1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd_cd1", "vvdCd1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("n1st_amt", "n1stAmt");
		this.hashFields.put("org_slp_ser_no", "orgSlpSerNo");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("org_slp_ofc_cd", "orgSlpOfcCd");
		this.hashFields.put("org_slp_iss_dt", "orgSlpIssDt");
		this.hashFields.put("dummy1", "dummy1");
		this.hashFields.put("org_slip_no", "orgSlipNo");
		this.hashFields.put("n1st_curr_cd", "n1stCurrCd");
		this.hashFields.put("flet_ppay_rlt_cd", "fletPpayRltCd");
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
	 * @return apDesc4
	 */
	public String getApDesc4() {
		return this.apDesc4;
	}
	
	/**
	 * Column Info
	 * @return apDesc5
	 */
	public String getApDesc5() {
		return this.apDesc5;
	}
	
	/**
	 * Column Info
	 * @return apDesc2
	 */
	public String getApDesc2() {
		return this.apDesc2;
	}
	
	/**
	 * Column Info
	 * @return apDesc3
	 */
	public String getApDesc3() {
		return this.apDesc3;
	}
	
	/**
	 * Column Info
	 * @return apDesc1
	 */
	public String getApDesc1() {
		return this.apDesc1;
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
	 * @return vvdCd1
	 */
	public String getVvdCd1() {
		return this.vvdCd1;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return n1stAmt
	 */
	public String getN1stAmt() {
		return this.n1stAmt;
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
	 * @return dummy1
	 */
	public String getDummy1() {
		return this.dummy1;
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
	 * @return n1stCurrCd
	 */
	public String getN1stCurrCd() {
		return this.n1stCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fletPpayRltCd
	 */
	public String getFletPpayRltCd() {
		return this.fletPpayRltCd;
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
	 * @param apDesc4
	 */
	public void setApDesc4(String apDesc4) {
		this.apDesc4 = apDesc4;
	}
	
	/**
	 * Column Info
	 * @param apDesc5
	 */
	public void setApDesc5(String apDesc5) {
		this.apDesc5 = apDesc5;
	}
	
	/**
	 * Column Info
	 * @param apDesc2
	 */
	public void setApDesc2(String apDesc2) {
		this.apDesc2 = apDesc2;
	}
	
	/**
	 * Column Info
	 * @param apDesc3
	 */
	public void setApDesc3(String apDesc3) {
		this.apDesc3 = apDesc3;
	}
	
	/**
	 * Column Info
	 * @param apDesc1
	 */
	public void setApDesc1(String apDesc1) {
		this.apDesc1 = apDesc1;
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
	 * @param vvdCd1
	 */
	public void setVvdCd1(String vvdCd1) {
		this.vvdCd1 = vvdCd1;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param n1stAmt
	 */
	public void setN1stAmt(String n1stAmt) {
		this.n1stAmt = n1stAmt;
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
	 * @param dummy1
	 */
	public void setDummy1(String dummy1) {
		this.dummy1 = dummy1;
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
	 * @param n1stCurrCd
	 */
	public void setN1stCurrCd(String n1stCurrCd) {
		this.n1stCurrCd = n1stCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fletPpayRltCd
	 */
	public void setFletPpayRltCd(String fletPpayRltCd) {
		this.fletPpayRltCd = fletPpayRltCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOrgSlpTpCd(JSPUtil.getParameter(request, "org_slp_tp_cd", ""));
		setOrgSlpFuncCd(JSPUtil.getParameter(request, "org_slp_func_cd", ""));
		setOrgSlpSeqNo(JSPUtil.getParameter(request, "org_slp_seq_no", ""));
		setApDesc4(JSPUtil.getParameter(request, "ap_desc4", ""));
		setApDesc5(JSPUtil.getParameter(request, "ap_desc5", ""));
		setApDesc2(JSPUtil.getParameter(request, "ap_desc2", ""));
		setApDesc3(JSPUtil.getParameter(request, "ap_desc3", ""));
		setApDesc1(JSPUtil.getParameter(request, "ap_desc1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvdCd1(JSPUtil.getParameter(request, "vvd_cd1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setN1stAmt(JSPUtil.getParameter(request, "n1st_amt", ""));
		setOrgSlpSerNo(JSPUtil.getParameter(request, "org_slp_ser_no", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setOrgSlpOfcCd(JSPUtil.getParameter(request, "org_slp_ofc_cd", ""));
		setOrgSlpIssDt(JSPUtil.getParameter(request, "org_slp_iss_dt", ""));
		setDummy1(JSPUtil.getParameter(request, "dummy1", ""));
		setOrgSlipNo(JSPUtil.getParameter(request, "org_slip_no", ""));
		setN1stCurrCd(JSPUtil.getParameter(request, "n1st_curr_cd", ""));
		setFletPpayRltCd(JSPUtil.getParameter(request, "flet_ppay_rlt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOwnerAccountExpenseListVO[]
	 */
	public SearchOwnerAccountExpenseListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOwnerAccountExpenseListVO[]
	 */
	public SearchOwnerAccountExpenseListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOwnerAccountExpenseListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgSlpTpCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_tp_cd", length));
			String[] orgSlpFuncCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_func_cd", length));
			String[] orgSlpSeqNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_seq_no", length));
			String[] apDesc4 = (JSPUtil.getParameter(request, prefix	+ "ap_desc4", length));
			String[] apDesc5 = (JSPUtil.getParameter(request, prefix	+ "ap_desc5", length));
			String[] apDesc2 = (JSPUtil.getParameter(request, prefix	+ "ap_desc2", length));
			String[] apDesc3 = (JSPUtil.getParameter(request, prefix	+ "ap_desc3", length));
			String[] apDesc1 = (JSPUtil.getParameter(request, prefix	+ "ap_desc1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdCd1 = (JSPUtil.getParameter(request, prefix	+ "vvd_cd1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] n1stAmt = (JSPUtil.getParameter(request, prefix	+ "n1st_amt", length));
			String[] orgSlpSerNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_ser_no", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] orgSlpOfcCd = (JSPUtil.getParameter(request, prefix	+ "org_slp_ofc_cd", length));
			String[] orgSlpIssDt = (JSPUtil.getParameter(request, prefix	+ "org_slp_iss_dt", length));
			String[] dummy1 = (JSPUtil.getParameter(request, prefix	+ "dummy1", length));
			String[] orgSlipNo = (JSPUtil.getParameter(request, prefix	+ "org_slip_no", length));
			String[] n1stCurrCd = (JSPUtil.getParameter(request, prefix	+ "n1st_curr_cd", length));
			String[] fletPpayRltCd = (JSPUtil.getParameter(request, prefix	+ "flet_ppay_rlt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOwnerAccountExpenseListVO();
				if (orgSlpTpCd[i] != null)
					model.setOrgSlpTpCd(orgSlpTpCd[i]);
				if (orgSlpFuncCd[i] != null)
					model.setOrgSlpFuncCd(orgSlpFuncCd[i]);
				if (orgSlpSeqNo[i] != null)
					model.setOrgSlpSeqNo(orgSlpSeqNo[i]);
				if (apDesc4[i] != null)
					model.setApDesc4(apDesc4[i]);
				if (apDesc5[i] != null)
					model.setApDesc5(apDesc5[i]);
				if (apDesc2[i] != null)
					model.setApDesc2(apDesc2[i]);
				if (apDesc3[i] != null)
					model.setApDesc3(apDesc3[i]);
				if (apDesc1[i] != null)
					model.setApDesc1(apDesc1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdCd1[i] != null)
					model.setVvdCd1(vvdCd1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (n1stAmt[i] != null)
					model.setN1stAmt(n1stAmt[i]);
				if (orgSlpSerNo[i] != null)
					model.setOrgSlpSerNo(orgSlpSerNo[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (orgSlpOfcCd[i] != null)
					model.setOrgSlpOfcCd(orgSlpOfcCd[i]);
				if (orgSlpIssDt[i] != null)
					model.setOrgSlpIssDt(orgSlpIssDt[i]);
				if (dummy1[i] != null)
					model.setDummy1(dummy1[i]);
				if (orgSlipNo[i] != null)
					model.setOrgSlipNo(orgSlipNo[i]);
				if (n1stCurrCd[i] != null)
					model.setN1stCurrCd(n1stCurrCd[i]);
				if (fletPpayRltCd[i] != null)
					model.setFletPpayRltCd(fletPpayRltCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOwnerAccountExpenseListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOwnerAccountExpenseListVO[]
	 */
	public SearchOwnerAccountExpenseListVO[] getSearchOwnerAccountExpenseListVOs(){
		SearchOwnerAccountExpenseListVO[] vos = (SearchOwnerAccountExpenseListVO[])models.toArray(new SearchOwnerAccountExpenseListVO[models.size()]);
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
		this.apDesc4 = this.apDesc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc5 = this.apDesc5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc2 = this.apDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc3 = this.apDesc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc1 = this.apDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd1 = this.vvdCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAmt = this.n1stAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSerNo = this.orgSlpSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpOfcCd = this.orgSlpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpIssDt = this.orgSlpIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dummy1 = this.dummy1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlipNo = this.orgSlipNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCurrCd = this.n1stCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletPpayRltCd = this.fletPpayRltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
