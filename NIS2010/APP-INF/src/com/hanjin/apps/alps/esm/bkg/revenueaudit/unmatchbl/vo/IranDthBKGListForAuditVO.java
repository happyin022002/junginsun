/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : IranDthBKGListForAuditVO.java
*@FileTitle : IranDthBKGListForAuditVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IranDthBKGListForAuditVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IranDthBKGListForAuditVO> models = new ArrayList<IranDthBKGListForAuditVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String revAudDt = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String bkgRhqCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String rdnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ttlBkgCnt = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String oth = null;
	/* Column Info */
	private String dth = null;
	/* Column Info */
	private String audStsCd = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public IranDthBKGListForAuditVO() {}

	public IranDthBKGListForAuditVO(String ibflag, String pagerows, String bkgNo, String rtAplyDt, String bkgCtrtTpCd, String ctrtNo, String porCd, String polCd, String podCd, String delCd, String oth, String dth, String bkgRhqCd, String svcScpCd, String fmDt, String toDt, String audStsCd, String revAudDt, String interRmk, String rdnNo, String ttlBkgCnt) {
		this.porCd = porCd;
		this.revAudDt = revAudDt;
		this.fmDt = fmDt;
		this.svcScpCd = svcScpCd;
		this.rtAplyDt = rtAplyDt;
		this.bkgRhqCd = bkgRhqCd;
		this.delCd = delCd;
		this.rdnNo = rdnNo;
		this.pagerows = pagerows;
		this.ttlBkgCnt = ttlBkgCnt;
		this.toDt = toDt;
		this.ctrtNo = ctrtNo;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.interRmk = interRmk;
		this.oth = oth;
		this.dth = dth;
		this.audStsCd = audStsCd;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rev_aud_dt", getRevAudDt());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("bkg_rhq_cd", getBkgRhqCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rdn_no", getRdnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ttl_bkg_cnt", getTtlBkgCnt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("oth", getOth());
		this.hashColumns.put("dth", getDth());
		this.hashColumns.put("aud_sts_cd", getAudStsCd());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rev_aud_dt", "revAudDt");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("bkg_rhq_cd", "bkgRhqCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rdn_no", "rdnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_bkg_cnt", "ttlBkgCnt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("oth", "oth");
		this.hashFields.put("dth", "dth");
		this.hashFields.put("aud_sts_cd", "audStsCd");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return revAudDt
	 */
	public String getRevAudDt() {
		return this.revAudDt;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @return bkgRhqCd
	 */
	public String getBkgRhqCd() {
		return this.bkgRhqCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return rdnNo
	 */
	public String getRdnNo() {
		return this.rdnNo;
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
	 * @return ttlBkgCnt
	 */
	public String getTtlBkgCnt() {
		return this.ttlBkgCnt;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return oth
	 */
	public String getOth() {
		return this.oth;
	}
	
	/**
	 * Column Info
	 * @return dth
	 */
	public String getDth() {
		return this.dth;
	}
	
	/**
	 * Column Info
	 * @return audStsCd
	 */
	public String getAudStsCd() {
		return this.audStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param revAudDt
	 */
	public void setRevAudDt(String revAudDt) {
		this.revAudDt = revAudDt;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @param bkgRhqCd
	 */
	public void setBkgRhqCd(String bkgRhqCd) {
		this.bkgRhqCd = bkgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param rdnNo
	 */
	public void setRdnNo(String rdnNo) {
		this.rdnNo = rdnNo;
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
	 * @param ttlBkgCnt
	 */
	public void setTtlBkgCnt(String ttlBkgCnt) {
		this.ttlBkgCnt = ttlBkgCnt;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param oth
	 */
	public void setOth(String oth) {
		this.oth = oth;
	}
	
	/**
	 * Column Info
	 * @param dth
	 */
	public void setDth(String dth) {
		this.dth = dth;
	}
	
	/**
	 * Column Info
	 * @param audStsCd
	 */
	public void setAudStsCd(String audStsCd) {
		this.audStsCd = audStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setRevAudDt(JSPUtil.getParameter(request, prefix + "rev_aud_dt", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setBkgRhqCd(JSPUtil.getParameter(request, prefix + "bkg_rhq_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setRdnNo(JSPUtil.getParameter(request, prefix + "rdn_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTtlBkgCnt(JSPUtil.getParameter(request, prefix + "ttl_bkg_cnt", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setOth(JSPUtil.getParameter(request, prefix + "oth", ""));
		setDth(JSPUtil.getParameter(request, prefix + "dth", ""));
		setAudStsCd(JSPUtil.getParameter(request, prefix + "aud_sts_cd", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IranDthBKGListForAuditVO[]
	 */
	public IranDthBKGListForAuditVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IranDthBKGListForAuditVO[]
	 */
	public IranDthBKGListForAuditVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IranDthBKGListForAuditVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] revAudDt = (JSPUtil.getParameter(request, prefix	+ "rev_aud_dt", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] bkgRhqCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rhq_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] rdnNo = (JSPUtil.getParameter(request, prefix	+ "rdn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ttlBkgCnt = (JSPUtil.getParameter(request, prefix	+ "ttl_bkg_cnt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] oth = (JSPUtil.getParameter(request, prefix	+ "oth", length));
			String[] dth = (JSPUtil.getParameter(request, prefix	+ "dth", length));
			String[] audStsCd = (JSPUtil.getParameter(request, prefix	+ "aud_sts_cd", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new IranDthBKGListForAuditVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (revAudDt[i] != null)
					model.setRevAudDt(revAudDt[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (bkgRhqCd[i] != null)
					model.setBkgRhqCd(bkgRhqCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (rdnNo[i] != null)
					model.setRdnNo(rdnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ttlBkgCnt[i] != null)
					model.setTtlBkgCnt(ttlBkgCnt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (oth[i] != null)
					model.setOth(oth[i]);
				if (dth[i] != null)
					model.setDth(dth[i]);
				if (audStsCd[i] != null)
					model.setAudStsCd(audStsCd[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIranDthBKGListForAuditVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IranDthBKGListForAuditVO[]
	 */
	public IranDthBKGListForAuditVO[] getIranDthBKGListForAuditVOs(){
		IranDthBKGListForAuditVO[] vos = (IranDthBKGListForAuditVO[])models.toArray(new IranDthBKGListForAuditVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAudDt = this.revAudDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRhqCd = this.bkgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnNo = this.rdnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBkgCnt = this.ttlBkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oth = this.oth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dth = this.dth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audStsCd = this.audStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
