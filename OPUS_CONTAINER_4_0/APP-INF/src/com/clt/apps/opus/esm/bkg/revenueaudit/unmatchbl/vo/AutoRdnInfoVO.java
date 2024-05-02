/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AutoRdnInfoVO.java
*@FileTitle : AutoRdnInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.24
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.08.24 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AutoRdnInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AutoRdnInfoVO> models = new ArrayList<AutoRdnInfoVO>();
	
	/* Column Info */
	private String rctOfcCd = null;
	/* Column Info */
	private String rdnIssRsnCd = null;
	/* Column Info */
	private String respbRhqCd = null;
	/* Column Info */
	private String issOfcCd = null;
	/* Column Info */
	private String rdnRmk = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revAudToolCd = null;
	/* Column Info */
	private String rdnIssDtWk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String umchSubTpCd = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String umchTpCd = null;
	/* Column Info */
	private String rdnIssDt = null;
	/* Column Info */
	private String respbOfcCd = null;
	/* Column Info */
	private String rctRhqCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AutoRdnInfoVO() {}

	public AutoRdnInfoVO(String ibflag, String pagerows, String blNo, String bkgNo, String issOfcCd, String rctRhqCd, String rctOfcCd, String respbRhqCd, String respbOfcCd, String umchTpCd, String umchSubTpCd, String rdnIssRsnCd, String scRfaNo, String revAudToolCd, String rdnRmk, String rdnIssDt, String rdnIssDtWk) {
		this.rctOfcCd = rctOfcCd;
		this.rdnIssRsnCd = rdnIssRsnCd;
		this.respbRhqCd = respbRhqCd;
		this.issOfcCd = issOfcCd;
		this.rdnRmk = rdnRmk;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.revAudToolCd = revAudToolCd;
		this.rdnIssDtWk = rdnIssDtWk;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.umchSubTpCd = umchSubTpCd;
		this.scRfaNo = scRfaNo;
		this.umchTpCd = umchTpCd;
		this.rdnIssDt = rdnIssDt;
		this.respbOfcCd = respbOfcCd;
		this.rctRhqCd = rctRhqCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("rdn_iss_rsn_cd", getRdnIssRsnCd());
		this.hashColumns.put("respb_rhq_cd", getRespbRhqCd());
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());
		this.hashColumns.put("rdn_rmk", getRdnRmk());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_aud_tool_cd", getRevAudToolCd());
		this.hashColumns.put("rdn_iss_dt_wk", getRdnIssDtWk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("umch_sub_tp_cd", getUmchSubTpCd());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("umch_tp_cd", getUmchTpCd());
		this.hashColumns.put("rdn_iss_dt", getRdnIssDt());
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
		this.hashColumns.put("rct_rhq_cd", getRctRhqCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("rdn_iss_rsn_cd", "rdnIssRsnCd");
		this.hashFields.put("respb_rhq_cd", "respbRhqCd");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("rdn_rmk", "rdnRmk");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_aud_tool_cd", "revAudToolCd");
		this.hashFields.put("rdn_iss_dt_wk", "rdnIssDtWk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("umch_sub_tp_cd", "umchSubTpCd");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("umch_tp_cd", "umchTpCd");
		this.hashFields.put("rdn_iss_dt", "rdnIssDt");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("rct_rhq_cd", "rctRhqCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rctOfcCd
	 */
	public String getRctOfcCd() {
		return this.rctOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rdnIssRsnCd
	 */
	public String getRdnIssRsnCd() {
		return this.rdnIssRsnCd;
	}
	
	/**
	 * Column Info
	 * @return respbRhqCd
	 */
	public String getRespbRhqCd() {
		return this.respbRhqCd;
	}
	
	/**
	 * Column Info
	 * @return issOfcCd
	 */
	public String getIssOfcCd() {
		return this.issOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rdnRmk
	 */
	public String getRdnRmk() {
		return this.rdnRmk;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return revAudToolCd
	 */
	public String getRevAudToolCd() {
		return this.revAudToolCd;
	}
	
	/**
	 * Column Info
	 * @return rdnIssDtWk
	 */
	public String getRdnIssDtWk() {
		return this.rdnIssDtWk;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return umchSubTpCd
	 */
	public String getUmchSubTpCd() {
		return this.umchSubTpCd;
	}
	
	/**
	 * Column Info
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
	}
	
	/**
	 * Column Info
	 * @return umchTpCd
	 */
	public String getUmchTpCd() {
		return this.umchTpCd;
	}
	
	/**
	 * Column Info
	 * @return rdnIssDt
	 */
	public String getRdnIssDt() {
		return this.rdnIssDt;
	}
	
	/**
	 * Column Info
	 * @return respbOfcCd
	 */
	public String getRespbOfcCd() {
		return this.respbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rctRhqCd
	 */
	public String getRctRhqCd() {
		return this.rctRhqCd;
	}
	

	/**
	 * Column Info
	 * @param rctOfcCd
	 */
	public void setRctOfcCd(String rctOfcCd) {
		this.rctOfcCd = rctOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rdnIssRsnCd
	 */
	public void setRdnIssRsnCd(String rdnIssRsnCd) {
		this.rdnIssRsnCd = rdnIssRsnCd;
	}
	
	/**
	 * Column Info
	 * @param respbRhqCd
	 */
	public void setRespbRhqCd(String respbRhqCd) {
		this.respbRhqCd = respbRhqCd;
	}
	
	/**
	 * Column Info
	 * @param issOfcCd
	 */
	public void setIssOfcCd(String issOfcCd) {
		this.issOfcCd = issOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rdnRmk
	 */
	public void setRdnRmk(String rdnRmk) {
		this.rdnRmk = rdnRmk;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param revAudToolCd
	 */
	public void setRevAudToolCd(String revAudToolCd) {
		this.revAudToolCd = revAudToolCd;
	}
	
	/**
	 * Column Info
	 * @param rdnIssDtWk
	 */
	public void setRdnIssDtWk(String rdnIssDtWk) {
		this.rdnIssDtWk = rdnIssDtWk;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param umchSubTpCd
	 */
	public void setUmchSubTpCd(String umchSubTpCd) {
		this.umchSubTpCd = umchSubTpCd;
	}
	
	/**
	 * Column Info
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
	}
	
	/**
	 * Column Info
	 * @param umchTpCd
	 */
	public void setUmchTpCd(String umchTpCd) {
		this.umchTpCd = umchTpCd;
	}
	
	/**
	 * Column Info
	 * @param rdnIssDt
	 */
	public void setRdnIssDt(String rdnIssDt) {
		this.rdnIssDt = rdnIssDt;
	}
	
	/**
	 * Column Info
	 * @param respbOfcCd
	 */
	public void setRespbOfcCd(String respbOfcCd) {
		this.respbOfcCd = respbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rctRhqCd
	 */
	public void setRctRhqCd(String rctRhqCd) {
		this.rctRhqCd = rctRhqCd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setRctOfcCd(JSPUtil.getParameter(request, prefix + "rct_ofc_cd", ""));
		setRdnIssRsnCd(JSPUtil.getParameter(request, prefix + "rdn_iss_rsn_cd", ""));
		setRespbRhqCd(JSPUtil.getParameter(request, prefix + "respb_rhq_cd", ""));
		setIssOfcCd(JSPUtil.getParameter(request, prefix + "iss_ofc_cd", ""));
		setRdnRmk(JSPUtil.getParameter(request, prefix + "rdn_rmk", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevAudToolCd(JSPUtil.getParameter(request, prefix + "rev_aud_tool_cd", ""));
		setRdnIssDtWk(JSPUtil.getParameter(request, prefix + "rdn_iss_dt_wk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setUmchSubTpCd(JSPUtil.getParameter(request, prefix + "umch_sub_tp_cd", ""));
		setScRfaNo(JSPUtil.getParameter(request, prefix + "sc_rfa_no", ""));
		setUmchTpCd(JSPUtil.getParameter(request, prefix + "umch_tp_cd", ""));
		setRdnIssDt(JSPUtil.getParameter(request, prefix + "rdn_iss_dt", ""));
		setRespbOfcCd(JSPUtil.getParameter(request, prefix + "respb_ofc_cd", ""));
		setRctRhqCd(JSPUtil.getParameter(request, prefix + "rct_rhq_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AutoRdnInfoVO[]
	 */
	public AutoRdnInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AutoRdnInfoVO[]
	 */
	public AutoRdnInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AutoRdnInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] rdnIssRsnCd = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_rsn_cd", length));
			String[] respbRhqCd = (JSPUtil.getParameter(request, prefix	+ "respb_rhq_cd", length));
			String[] issOfcCd = (JSPUtil.getParameter(request, prefix	+ "iss_ofc_cd", length));
			String[] rdnRmk = (JSPUtil.getParameter(request, prefix	+ "rdn_rmk", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revAudToolCd = (JSPUtil.getParameter(request, prefix	+ "rev_aud_tool_cd", length));
			String[] rdnIssDtWk = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_dt_wk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] umchSubTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_sub_tp_cd", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] umchTpCd = (JSPUtil.getParameter(request, prefix	+ "umch_tp_cd", length));
			String[] rdnIssDt = (JSPUtil.getParameter(request, prefix	+ "rdn_iss_dt", length));
			String[] respbOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_cd", length));
			String[] rctRhqCd = (JSPUtil.getParameter(request, prefix	+ "rct_rhq_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AutoRdnInfoVO();
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (rdnIssRsnCd[i] != null)
					model.setRdnIssRsnCd(rdnIssRsnCd[i]);
				if (respbRhqCd[i] != null)
					model.setRespbRhqCd(respbRhqCd[i]);
				if (issOfcCd[i] != null)
					model.setIssOfcCd(issOfcCd[i]);
				if (rdnRmk[i] != null)
					model.setRdnRmk(rdnRmk[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revAudToolCd[i] != null)
					model.setRevAudToolCd(revAudToolCd[i]);
				if (rdnIssDtWk[i] != null)
					model.setRdnIssDtWk(rdnIssDtWk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (umchSubTpCd[i] != null)
					model.setUmchSubTpCd(umchSubTpCd[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (umchTpCd[i] != null)
					model.setUmchTpCd(umchTpCd[i]);
				if (rdnIssDt[i] != null)
					model.setRdnIssDt(rdnIssDt[i]);
				if (respbOfcCd[i] != null)
					model.setRespbOfcCd(respbOfcCd[i]);
				if (rctRhqCd[i] != null)
					model.setRctRhqCd(rctRhqCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAutoRdnInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AutoRdnInfoVO[]
	 */
	public AutoRdnInfoVO[] getAutoRdnInfoVOs(){
		AutoRdnInfoVO[] vos = (AutoRdnInfoVO[])models.toArray(new AutoRdnInfoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.rctOfcCd = this.rctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssRsnCd = this.rdnIssRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbRhqCd = this.respbRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd = this.issOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnRmk = this.rdnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudToolCd = this.revAudToolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssDtWk = this.rdnIssDtWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchSubTpCd = this.umchSubTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchTpCd = this.umchTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnIssDt = this.rdnIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd = this.respbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRhqCd = this.rctRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
