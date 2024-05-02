/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EuDoCntrRlseStsVO.java
*@FileTitle : EuDoCntrRlseStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EuDoCntrRlseStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EuDoCntrRlseStsVO> models = new ArrayList<EuDoCntrRlseStsVO>();
	
	/* Column Info */
	private String rtnYdCd = null;
	/* Column Info */
	private String rlseSeq = null;
	/* Column Info */
	private String rlseStsNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String rlseStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rlseStsSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String mvmtRefNo = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String cntrHldFlg = null;
	/* Column Info */
	private String cntrHldNm = null;
	/* Column Info */
	private String cntrHldDt = null;
	/* Column Info */
	private String cntrHldUsrId = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EuDoCntrRlseStsVO() {}

	public EuDoCntrRlseStsVO(String ibflag, String pagerows, String bkgNo, String rlseSeq, String rlseStsSeq, String cntrNo, String rlseStsCd, String rlseStsNm, String doNo, String mvmtRefNo, String rtnYdCd, String evntDt, String evntUsrId, String evntOfcCd, String cntrHldFlg, String cntrHldNm, String cntrHldDt, String cntrHldUsrId) {
		this.rtnYdCd = rtnYdCd;
		this.rlseSeq = rlseSeq;
		this.rlseStsNm = rlseStsNm;
		this.pagerows = pagerows;
		this.doNo = doNo;
		this.rlseStsCd = rlseStsCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.rlseStsSeq = rlseStsSeq;
		this.cntrNo = cntrNo;
		this.evntUsrId = evntUsrId;
		this.mvmtRefNo = mvmtRefNo;
		this.evntDt = evntDt;
		this.evntOfcCd = evntOfcCd;
		this.cntrHldFlg = cntrHldFlg;
		this.cntrHldNm = cntrHldNm;
		this.cntrHldDt = cntrHldDt;
		this.cntrHldUsrId = cntrHldUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rtn_yd_cd", getRtnYdCd());
		this.hashColumns.put("rlse_seq", getRlseSeq());
		this.hashColumns.put("rlse_sts_nm", getRlseStsNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("rlse_sts_cd", getRlseStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rlse_sts_seq", getRlseStsSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("mvmt_ref_no", getMvmtRefNo());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("cntr_hld_flg", getCntrHldFlg());
		this.hashColumns.put("cntr_hld_nm", getCntrHldNm());
		this.hashColumns.put("cntr_hld_dt", getCntrHldDt());
		this.hashColumns.put("cntr_hld_usr_id", getCntrHldUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rtn_yd_cd", "rtnYdCd");
		this.hashFields.put("rlse_seq", "rlseSeq");
		this.hashFields.put("rlse_sts_nm", "rlseStsNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("rlse_sts_cd", "rlseStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rlse_sts_seq", "rlseStsSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("mvmt_ref_no", "mvmtRefNo");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("cntr_hld_flg", "cntrHldFlg");
		this.hashFields.put("cntr_hld_nm", "cntrHldNm");
		this.hashFields.put("cntr_hld_dt", "cntrHldDt");
		this.hashFields.put("cntr_hld_usr_id", "cntrHldUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rtnYdCd
	 */
	public String getRtnYdCd() {
		return this.rtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return rlseSeq
	 */
	public String getRlseSeq() {
		return this.rlseSeq;
	}
	
	/**
	 * Column Info
	 * @return rlseStsNm
	 */
	public String getRlseStsNm() {
		return this.rlseStsNm;
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
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * Column Info
	 * @return rlseStsCd
	 */
	public String getRlseStsCd() {
		return this.rlseStsCd;
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
	 * @return rlseStsSeq
	 */
	public String getRlseStsSeq() {
		return this.rlseStsSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
	}
	
	/**
	 * Column Info
	 * @return mvmtRefNo
	 */
	public String getMvmtRefNo() {
		return this.mvmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	
	/**
	 * Column Info
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntrHldFlg
	 */
	public String getCntrHldFlg() {
		return this.cntrHldFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrHldNm
	 */
	public String getCntrHldNm() {
		return this.cntrHldNm;
	}
	
	/**
	 * Column Info
	 * @return cntrHldDt
	 */
	public String getCntrHldDt() {
		return this.cntrHldDt;
	}
	
	/**
	 * Column Info
	 * @return cntrHldUsrId
	 */
	public String getCntrHldUsrId() {
		return this.cntrHldUsrId;
	}
	
	/**
	 * Column Info
	 * @param rtnYdCd
	 */
	public void setRtnYdCd(String rtnYdCd) {
		this.rtnYdCd = rtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param rlseSeq
	 */
	public void setRlseSeq(String rlseSeq) {
		this.rlseSeq = rlseSeq;
	}
	
	/**
	 * Column Info
	 * @param rlseStsNm
	 */
	public void setRlseStsNm(String rlseStsNm) {
		this.rlseStsNm = rlseStsNm;
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
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	
	/**
	 * Column Info
	 * @param rlseStsCd
	 */
	public void setRlseStsCd(String rlseStsCd) {
		this.rlseStsCd = rlseStsCd;
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
	 * @param rlseStsSeq
	 */
	public void setRlseStsSeq(String rlseStsSeq) {
		this.rlseStsSeq = rlseStsSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Column Info
	 * @param mvmtRefNo
	 */
	public void setMvmtRefNo(String mvmtRefNo) {
		this.mvmtRefNo = mvmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Column Info
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntrHldFlg
	 */
	public void setCntrHldFlg(String cntrHldFlg) {
		this.cntrHldFlg = cntrHldFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrHldNm
	 */
	public void setCntrHldNm(String cntrHldNm) {
		this.cntrHldNm = cntrHldNm;
	}
	
	/**
	 * Column Info
	 * @param cntrHldDt
	 */
	public void setCntrHldDt(String cntrHldDt) {
		this.cntrHldDt = cntrHldDt;
	}
	
	/**
	 * Column Info
	 * @param cntrHldUsrId
	 */
	public void setCntrHldUsrId(String cntrHldUsrId) {
		this.cntrHldUsrId = cntrHldUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRtnYdCd(JSPUtil.getParameter(request, "rtn_yd_cd", ""));
		setRlseSeq(JSPUtil.getParameter(request, "rlse_seq", ""));
		setRlseStsNm(JSPUtil.getParameter(request, "rlse_sts_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setRlseStsCd(JSPUtil.getParameter(request, "rlse_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRlseStsSeq(JSPUtil.getParameter(request, "rlse_sts_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setMvmtRefNo(JSPUtil.getParameter(request, "mvmt_ref_no", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setCntrHldFlg(JSPUtil.getParameter(request, "cntr_hld_flg", ""));
		setCntrHldNm(JSPUtil.getParameter(request, "cntr_hld_nm", ""));
		setCntrHldDt(JSPUtil.getParameter(request, "cntr_hld_dt", ""));
		setCntrHldUsrId(JSPUtil.getParameter(request, "cntr_hld_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EuDoCntrRlseStsVO[]
	 */
	public EuDoCntrRlseStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EuDoCntrRlseStsVO[]
	 */
	public EuDoCntrRlseStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EuDoCntrRlseStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rtnYdCd = (JSPUtil.getParameter(request, prefix	+ "rtn_yd_cd", length));
			String[] rlseSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_seq", length));
			String[] rlseStsNm = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] rlseStsCd = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rlseStsSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_sts_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] mvmtRefNo = (JSPUtil.getParameter(request, prefix	+ "mvmt_ref_no", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] cntrHldFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_hld_flg", length));
			String[] cntrHldNm = (JSPUtil.getParameter(request, prefix	+ "cntr_hld_nm", length));
			String[] cntrHldDt = (JSPUtil.getParameter(request, prefix	+ "cntr_hld_dt", length));
			String[] cntrHldUsrId = (JSPUtil.getParameter(request, prefix	+ "cntr_hld_usr_id", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new EuDoCntrRlseStsVO();
				if (rtnYdCd[i] != null)
					model.setRtnYdCd(rtnYdCd[i]);
				if (rlseSeq[i] != null)
					model.setRlseSeq(rlseSeq[i]);
				if (rlseStsNm[i] != null)
					model.setRlseStsNm(rlseStsNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (rlseStsCd[i] != null)
					model.setRlseStsCd(rlseStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rlseStsSeq[i] != null)
					model.setRlseStsSeq(rlseStsSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (mvmtRefNo[i] != null)
					model.setMvmtRefNo(mvmtRefNo[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (cntrHldFlg[i] != null)
					model.setCntrHldFlg(cntrHldFlg[i]);
				if (cntrHldNm[i] != null)
					model.setCntrHldNm(cntrHldNm[i]);
				if (cntrHldDt[i] != null)
					model.setCntrHldDt(cntrHldDt[i]);
				if (cntrHldUsrId[i] != null)
					model.setCntrHldUsrId(cntrHldUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEuDoCntrRlseStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EuDoCntrRlseStsVO[]
	 */
	public EuDoCntrRlseStsVO[] getEuDoCntrRlseStsVOs(){
		EuDoCntrRlseStsVO[] vos = (EuDoCntrRlseStsVO[])models.toArray(new EuDoCntrRlseStsVO[models.size()]);
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
		this.rtnYdCd = this.rtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseSeq = this.rlseSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsNm = this.rlseStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsCd = this.rlseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseStsSeq = this.rlseStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtRefNo = this.mvmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHldFlg = this.cntrHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHldNm = this.cntrHldNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHldDt = this.cntrHldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHldUsrId = this.cntrHldUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
