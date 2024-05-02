/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSlipCorrectionDetailListVO.java
*@FileTitle : SearchSlipCorrectionDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.08.05 정윤태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo;

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
 * @author 정윤태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSlipCorrectionDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSlipCorrectionDetailListVO> models = new ArrayList<SearchSlipCorrectionDetailListVO>();
	
	/* Column Info */
	private String fletCtrtTpCd = null;
	/* Column Info */
	private String drAmt = null;
	/* Column Info */
	private String csrDesc = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String csrDesc3 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String crAmt = null;
	/* Column Info */
	private String ctrCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String csrDesc1 = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String csrDesc2 = null;
	/* Column Info */
	private String ownrCd = null;
	/* Column Info */
	private String csrAmt = null;
	/* Column Info */
	private String keyNum = null;
	/* Column Info */
	private String slpLocCd = null;
	/* Column Info */
	private String orgSlpSeqNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSlipCorrectionDetailListVO() {}

	public SearchSlipCorrectionDetailListVO(String ibflag, String pagerows, String slpSeqNo, String acctCd, String ownrCd, String ctrCd, String slpLocCd, String effDt, String csrAmt, String csrDesc, String csrDesc1, String csrDesc2, String csrDesc3, String vvdCd, String keyNum, String drAmt, String crAmt, String fletCtrtTpCd, String orgSlpSeqNo) {
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.drAmt = drAmt;
		this.csrDesc = csrDesc;
		this.slpSeqNo = slpSeqNo;
		this.csrDesc3 = csrDesc3;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.crAmt = crAmt;
		this.ctrCd = ctrCd;
		this.vvdCd = vvdCd;
		this.csrDesc1 = csrDesc1;
		this.acctCd = acctCd;
		this.csrDesc2 = csrDesc2;
		this.ownrCd = ownrCd;
		this.csrAmt = csrAmt;
		this.keyNum = keyNum;
		this.slpLocCd = slpLocCd;
		this.orgSlpSeqNo = orgSlpSeqNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("dr_amt", getDrAmt());
		this.hashColumns.put("csr_desc", getCsrDesc());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("csr_desc3", getCsrDesc3());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cr_amt", getCrAmt());
		this.hashColumns.put("ctr_cd", getCtrCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("csr_desc1", getCsrDesc1());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("csr_desc2", getCsrDesc2());
		this.hashColumns.put("ownr_cd", getOwnrCd());
		this.hashColumns.put("csr_amt", getCsrAmt());
		this.hashColumns.put("key_num", getKeyNum());
		this.hashColumns.put("slp_loc_cd", getSlpLocCd());
		this.hashColumns.put("org_slp_seq_no", getOrgSlpSeqNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("dr_amt", "drAmt");
		this.hashFields.put("csr_desc", "csrDesc");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("csr_desc3", "csrDesc3");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("csr_desc1", "csrDesc1");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("csr_desc2", "csrDesc2");
		this.hashFields.put("ownr_cd", "ownrCd");
		this.hashFields.put("csr_amt", "csrAmt");
		this.hashFields.put("key_num", "keyNum");
		this.hashFields.put("slp_loc_cd", "slpLocCd");
		this.hashFields.put("org_slp_seq_no", "orgSlpSeqNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fletCtrtTpCd
	 */
	public String getFletCtrtTpCd() {
		return this.fletCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return drAmt
	 */
	public String getDrAmt() {
		return this.drAmt;
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
	 * @return slpSeqNo
	 */
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return csrDesc3
	 */
	public String getCsrDesc3() {
		return this.csrDesc3;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return crAmt
	 */
	public String getCrAmt() {
		return this.crAmt;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return csrDesc1
	 */
	public String getCsrDesc1() {
		return this.csrDesc1;
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
	 * @return csrDesc2
	 */
	public String getCsrDesc2() {
		return this.csrDesc2;
	}
	
	/**
	 * Column Info
	 * @return ownrCd
	 */
	public String getOwnrCd() {
		return this.ownrCd;
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
	 * @return keyNum
	 */
	public String getKeyNum() {
		return this.keyNum;
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
	 * @return orgSlpSeqNo
	 */
	public String getOrgSlpSeqNo() {
		return this.orgSlpSeqNo;
	}
	

	/**
	 * Column Info
	 * @param fletCtrtTpCd
	 */
	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param drAmt
	 */
	public void setDrAmt(String drAmt) {
		this.drAmt = drAmt;
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
	 * @param slpSeqNo
	 */
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param csrDesc3
	 */
	public void setCsrDesc3(String csrDesc3) {
		this.csrDesc3 = csrDesc3;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param crAmt
	 */
	public void setCrAmt(String crAmt) {
		this.crAmt = crAmt;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param csrDesc1
	 */
	public void setCsrDesc1(String csrDesc1) {
		this.csrDesc1 = csrDesc1;
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
	 * @param csrDesc2
	 */
	public void setCsrDesc2(String csrDesc2) {
		this.csrDesc2 = csrDesc2;
	}
	
	/**
	 * Column Info
	 * @param ownrCd
	 */
	public void setOwnrCd(String ownrCd) {
		this.ownrCd = ownrCd;
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
	 * @param keyNum
	 */
	public void setKeyNum(String keyNum) {
		this.keyNum = keyNum;
	}
	
	/**
	 * Column Info
	 * @param slpLocCd
	 */
	public void setSlpLocCd(String slpLocCd) {
		this.slpLocCd = slpLocCd;
	}
	
	/**
	 * Column Info
	 * @param orgSlpSeqNo
	 */
	public void setOrgSlpSeqNo(String orgSlpSeqNo) {
		this.orgSlpSeqNo = orgSlpSeqNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFletCtrtTpCd(JSPUtil.getParameter(request, "flet_ctrt_tp_cd", ""));
		setDrAmt(JSPUtil.getParameter(request, "dr_amt", ""));
		setCsrDesc(JSPUtil.getParameter(request, "csr_desc", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, "slp_seq_no", ""));
		setCsrDesc3(JSPUtil.getParameter(request, "csr_desc3", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCrAmt(JSPUtil.getParameter(request, "cr_amt", ""));
		setCtrCd(JSPUtil.getParameter(request, "ctr_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setCsrDesc1(JSPUtil.getParameter(request, "csr_desc1", ""));
		setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
		setCsrDesc2(JSPUtil.getParameter(request, "csr_desc2", ""));
		setOwnrCd(JSPUtil.getParameter(request, "ownr_cd", ""));
		setCsrAmt(JSPUtil.getParameter(request, "csr_amt", ""));
		setKeyNum(JSPUtil.getParameter(request, "key_num", ""));
		setSlpLocCd(JSPUtil.getParameter(request, "slp_loc_cd", ""));
		setOrgSlpSeqNo(JSPUtil.getParameter(request, "org_slp_seq_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSlipCorrectionDetailListVO[]
	 */
	public SearchSlipCorrectionDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSlipCorrectionDetailListVO[]
	 */
	public SearchSlipCorrectionDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSlipCorrectionDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd", length));
			String[] drAmt = (JSPUtil.getParameter(request, prefix	+ "dr_amt", length));
			String[] csrDesc = (JSPUtil.getParameter(request, prefix	+ "csr_desc", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] csrDesc3 = (JSPUtil.getParameter(request, prefix	+ "csr_desc3", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] crAmt = (JSPUtil.getParameter(request, prefix	+ "cr_amt", length));
			String[] ctrCd = (JSPUtil.getParameter(request, prefix	+ "ctr_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] csrDesc1 = (JSPUtil.getParameter(request, prefix	+ "csr_desc1", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] csrDesc2 = (JSPUtil.getParameter(request, prefix	+ "csr_desc2", length));
			String[] ownrCd = (JSPUtil.getParameter(request, prefix	+ "ownr_cd", length));
			String[] csrAmt = (JSPUtil.getParameter(request, prefix	+ "csr_amt", length));
			String[] keyNum = (JSPUtil.getParameter(request, prefix	+ "key_num", length));
			String[] slpLocCd = (JSPUtil.getParameter(request, prefix	+ "slp_loc_cd", length));
			String[] orgSlpSeqNo = (JSPUtil.getParameter(request, prefix	+ "org_slp_seq_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSlipCorrectionDetailListVO();
				if (fletCtrtTpCd[i] != null)
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (drAmt[i] != null)
					model.setDrAmt(drAmt[i]);
				if (csrDesc[i] != null)
					model.setCsrDesc(csrDesc[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (csrDesc3[i] != null)
					model.setCsrDesc3(csrDesc3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (crAmt[i] != null)
					model.setCrAmt(crAmt[i]);
				if (ctrCd[i] != null)
					model.setCtrCd(ctrCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (csrDesc1[i] != null)
					model.setCsrDesc1(csrDesc1[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (csrDesc2[i] != null)
					model.setCsrDesc2(csrDesc2[i]);
				if (ownrCd[i] != null)
					model.setOwnrCd(ownrCd[i]);
				if (csrAmt[i] != null)
					model.setCsrAmt(csrAmt[i]);
				if (keyNum[i] != null)
					model.setKeyNum(keyNum[i]);
				if (slpLocCd[i] != null)
					model.setSlpLocCd(slpLocCd[i]);
				if (orgSlpSeqNo[i] != null)
					model.setOrgSlpSeqNo(orgSlpSeqNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSlipCorrectionDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSlipCorrectionDetailListVO[]
	 */
	public SearchSlipCorrectionDetailListVO[] getSearchSlipCorrectionDetailListVOs(){
		SearchSlipCorrectionDetailListVO[] vos = (SearchSlipCorrectionDetailListVO[])models.toArray(new SearchSlipCorrectionDetailListVO[models.size()]);
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
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drAmt = this.drAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc = this.csrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc3 = this.csrDesc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt = this.crAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd = this.ctrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc1 = this.csrDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrDesc2 = this.csrDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrCd = this.ownrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrAmt = this.csrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyNum = this.keyNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpLocCd = this.slpLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpSeqNo = this.orgSlpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}