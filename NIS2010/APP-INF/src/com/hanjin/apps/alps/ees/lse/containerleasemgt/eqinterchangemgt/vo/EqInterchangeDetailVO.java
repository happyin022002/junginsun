/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeDetailVO.java
*@FileTitle : EqInterchangeDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.02  
* 1.0 Creation
* 2015-07-09 [CHM-201536018] EQ INTERCHANGE WORK module 신규 개발 제안
=========================================================*/

package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.vo;

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

public class EqInterchangeDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqInterchangeDetailVO> models = new ArrayList<EqInterchangeDetailVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String rntlChgFreeDys = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String cntrStsEvntDt = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ttlUseDys = null;
	/* Column Info */
	private String lsiRefNo = null;
	/* Column Info */
	private String rtnYdCd = null;
	/* Column Info */
	private String etdDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cntrRtnEvntDt = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String lsiAgmtNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EqInterchangeDetailVO() {}

	public EqInterchangeDetailVO(String ibflag, String pagerows, String seqNo, String cntrNo, String cntrTpszCd, String lsiAgmtNo, String lsiRefNo, String cnmvStsCd, String cntrStsEvntDt, String ydCd, String rntlChgFreeDys, String cntrRtnEvntDt, String rtnYdCd, String ttlUseDys, String bkgNo, String polCd, String porCd, String podCd, String delCd, String etdDt, String etaDt, String vvd) {
		this.porCd = porCd;
		this.rntlChgFreeDys = rntlChgFreeDys;
		this.seqNo = seqNo;
		this.cntrStsEvntDt = cntrStsEvntDt;
		this.etaDt = etaDt;
		this.delCd = delCd;
		this.ttlUseDys = ttlUseDys;
		this.lsiRefNo = lsiRefNo;
		this.rtnYdCd = rtnYdCd;
		this.etdDt = etdDt;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.cntrRtnEvntDt = cntrRtnEvntDt;
		this.polCd = polCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.lsiAgmtNo = lsiAgmtNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rntl_chg_free_dys", getRntlChgFreeDys());
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("cntr_sts_evnt_dt", getCntrStsEvntDt());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ttl_use_dys", getTtlUseDys());
		this.hashColumns.put("lsi_ref_no", getLsiRefNo());
		this.hashColumns.put("rtn_yd_cd", getRtnYdCd());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cntr_rtn_evnt_dt", getCntrRtnEvntDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("lsi_agmt_no", getLsiAgmtNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rntl_chg_free_dys", "rntlChgFreeDys");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("cntr_sts_evnt_dt", "cntrStsEvntDt");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ttl_use_dys", "ttlUseDys");
		this.hashFields.put("lsi_ref_no", "lsiRefNo");
		this.hashFields.put("rtn_yd_cd", "rtnYdCd");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cntr_rtn_evnt_dt", "cntrRtnEvntDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lsi_agmt_no", "lsiAgmtNo");
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
	 * @return rntlChgFreeDys
	 */
	public String getRntlChgFreeDys() {
		return this.rntlChgFreeDys;
	}
	
	/**
	 * Column Info
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
	}
	
	/**
	 * Column Info
	 * @return cntrStsEvntDt
	 */
	public String getCntrStsEvntDt() {
		return this.cntrStsEvntDt;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
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
	 * @return ttlUseDys
	 */
	public String getTtlUseDys() {
		return this.ttlUseDys;
	}
	
	/**
	 * Column Info
	 * @return lsiRefNo
	 */
	public String getLsiRefNo() {
		return this.lsiRefNo;
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
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
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
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return cntrRtnEvntDt
	 */
	public String getCntrRtnEvntDt() {
		return this.cntrRtnEvntDt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return lsiAgmtNo
	 */
	public String getLsiAgmtNo() {
		return this.lsiAgmtNo;
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
	 * @param rntlChgFreeDys
	 */
	public void setRntlChgFreeDys(String rntlChgFreeDys) {
		this.rntlChgFreeDys = rntlChgFreeDys;
	}
	
	/**
	 * Column Info
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	
	/**
	 * Column Info
	 * @param cntrStsEvntDt
	 */
	public void setCntrStsEvntDt(String cntrStsEvntDt) {
		this.cntrStsEvntDt = cntrStsEvntDt;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
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
	 * @param ttlUseDys
	 */
	public void setTtlUseDys(String ttlUseDys) {
		this.ttlUseDys = ttlUseDys;
	}
	
	/**
	 * Column Info
	 * @param lsiRefNo
	 */
	public void setLsiRefNo(String lsiRefNo) {
		this.lsiRefNo = lsiRefNo;
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
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
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
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param cntrRtnEvntDt
	 */
	public void setCntrRtnEvntDt(String cntrRtnEvntDt) {
		this.cntrRtnEvntDt = cntrRtnEvntDt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param lsiAgmtNo
	 */
	public void setLsiAgmtNo(String lsiAgmtNo) {
		this.lsiAgmtNo = lsiAgmtNo;
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
		setRntlChgFreeDys(JSPUtil.getParameter(request, prefix + "rntl_chg_free_dys", ""));
		setSeqNo(JSPUtil.getParameter(request, prefix + "seq_no", ""));
		setCntrStsEvntDt(JSPUtil.getParameter(request, prefix + "cntr_sts_evnt_dt", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setTtlUseDys(JSPUtil.getParameter(request, prefix + "ttl_use_dys", ""));
		setLsiRefNo(JSPUtil.getParameter(request, prefix + "lsi_ref_no", ""));
		setRtnYdCd(JSPUtil.getParameter(request, prefix + "rtn_yd_cd", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCntrRtnEvntDt(JSPUtil.getParameter(request, prefix + "cntr_rtn_evnt_dt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setLsiAgmtNo(JSPUtil.getParameter(request, prefix + "lsi_agmt_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqInterchangeDetailVO[]
	 */
	public EqInterchangeDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqInterchangeDetailVO[]
	 */
	public EqInterchangeDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqInterchangeDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] rntlChgFreeDys = (JSPUtil.getParameter(request, prefix	+ "rntl_chg_free_dys", length));
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] cntrStsEvntDt = (JSPUtil.getParameter(request, prefix	+ "cntr_sts_evnt_dt", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ttlUseDys = (JSPUtil.getParameter(request, prefix	+ "ttl_use_dys", length));
			String[] lsiRefNo = (JSPUtil.getParameter(request, prefix	+ "lsi_ref_no", length));
			String[] rtnYdCd = (JSPUtil.getParameter(request, prefix	+ "rtn_yd_cd", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cntrRtnEvntDt = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_evnt_dt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] lsiAgmtNo = (JSPUtil.getParameter(request, prefix	+ "lsi_agmt_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqInterchangeDetailVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (rntlChgFreeDys[i] != null)
					model.setRntlChgFreeDys(rntlChgFreeDys[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (cntrStsEvntDt[i] != null)
					model.setCntrStsEvntDt(cntrStsEvntDt[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ttlUseDys[i] != null)
					model.setTtlUseDys(ttlUseDys[i]);
				if (lsiRefNo[i] != null)
					model.setLsiRefNo(lsiRefNo[i]);
				if (rtnYdCd[i] != null)
					model.setRtnYdCd(rtnYdCd[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cntrRtnEvntDt[i] != null)
					model.setCntrRtnEvntDt(cntrRtnEvntDt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (lsiAgmtNo[i] != null)
					model.setLsiAgmtNo(lsiAgmtNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqInterchangeDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqInterchangeDetailVO[]
	 */
	public EqInterchangeDetailVO[] getEqInterchangeDetailVOs(){
		EqInterchangeDetailVO[] vos = (EqInterchangeDetailVO[])models.toArray(new EqInterchangeDetailVO[models.size()]);
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
		this.rntlChgFreeDys = this.rntlChgFreeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsEvntDt = this.cntrStsEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlUseDys = this.ttlUseDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsiRefNo = this.lsiRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnYdCd = this.rtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnEvntDt = this.cntrRtnEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsiAgmtNo = this.lsiAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
