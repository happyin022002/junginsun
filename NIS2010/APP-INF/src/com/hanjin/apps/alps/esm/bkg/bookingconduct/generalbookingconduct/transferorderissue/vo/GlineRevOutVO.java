/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GlineRevOutVO.java
*@FileTitle : GlineRevOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.07  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class GlineRevOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GlineRevOutVO> models = new ArrayList<GlineRevOutVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String manifestFlag = null;
	/* Column Info */
	private String glineCurrCd = null;
	/* Column Info */
	private String glineRevAmt = null;
	/* Column Info */
	private String optmStsCd = null;
	/* Column Info */
	private String cntrTermCd = null;
	/* Column Info */
	private String trspModCd = null;
	/* Column Info */
	private String allInRtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* dih amt */
	private String dihAmt = null;
	/* Column Info */
	private String agmtWgt = null;
	/* Column Info */
	private String ihcTrfNo = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String svcScpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GlineRevOutVO() {}

	public GlineRevOutVO(String ibflag, String pagerows, String glineCurrCd, String glineRevAmt, String manifestFlag, String optmStsCd, String cntrTermCd, String trspModCd, String allInRtCd, String dihAmt, String agmtWgt, String orgDestTpCd, String ihcTrfNo, String svcScpCd) {
		this.ibflag = ibflag;
		this.manifestFlag = manifestFlag;
		this.glineCurrCd = glineCurrCd;
		this.glineRevAmt = glineRevAmt;
		this.optmStsCd = optmStsCd;
		this.cntrTermCd = cntrTermCd;
		this.trspModCd = trspModCd; 
		this.allInRtCd = allInRtCd; 
		this.agmtWgt = agmtWgt; 
		this.pagerows = pagerows;
		this.dihAmt = dihAmt;
		this.ihcTrfNo = ihcTrfNo;
		this.svcScpCd = svcScpCd;
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("manifest_flag", getManifestFlag());
		this.hashColumns.put("gline_curr_cd", getGlineCurrCd());
		this.hashColumns.put("gline_rev_amt", getGlineRevAmt());
		this.hashColumns.put("optm_sts_cd", getOptmStsCd());
		this.hashColumns.put("cntr_term_cd", getCntrTermCd());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("all_in_rt_cd", getAllInRtCd());
		this.hashColumns.put("agmt_wgt", getAgmtWgt());
		this.hashColumns.put("ihc_trf_no", getIhcTrfNo());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dih_amt", getDihAmt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("manifest_flag", "manifestFlag");
		this.hashFields.put("gline_curr_cd", "glineCurrCd");
		this.hashFields.put("gline_rev_amt", "glineRevAmt");
		this.hashFields.put("optm_sts_cd", "optmStsCd");
		this.hashFields.put("cntr_term_cd", "cntrTermCd");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("all_in_rt_cd", "allInRtCd");
		this.hashFields.put("ihc_trf_no", "ihcTrfNo");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("agmt_wgt", "agmtWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dih_amt", "dihAmt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		return this.hashFields;
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
	 * @return manifestFlag
	 */
	public String getManifestFlag() {
		return this.manifestFlag;
	}
	
	/**
	 * Column Info
	 * @return glineCurrCd
	 */
	public String getGlineCurrCd() {
		return this.glineCurrCd;
	}
	
	/**
	 * Column Info
	 * @return glineRevAmt
	 */
	public String getGlineRevAmt() {
		return this.glineRevAmt;
	}
	
	/**
	 * Column Info
	 * @return agmtWgt
	 */
	public String getAgmtWgt() {
		return this.agmtWgt;
	}
	
	/**
	 * Column Info
	 * @return optmStsCd
	 */
	public String getOptmStsCd() {
		return this.optmStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTermCd
	 */
	public String getCntrTermCd() {
		return this.cntrTermCd;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
	}
	
	/**
	 * Column Info
	 * @return allInRtCd
	 */
	public String getAllInRtCd() {
		return this.allInRtCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	public String getDihAmt() {
		return dihAmt;
	}

	public void setDihAmt(String dihAmt) {
		this.dihAmt = dihAmt;
	}

	
	public String getIhcTrfNo() {
		return ihcTrfNo;
	}

	public void setIhcTrfNo(String ihcTrfNo) {
		this.ihcTrfNo = ihcTrfNo;
	}
	
	public String getOrgDestTpCd() {
		return orgDestTpCd;
	}

	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	public String getSvcScpCd() {
		return svcScpCd;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param manifestFlag
	 */
	public void setManifestFlag(String manifestFlag) {
		this.manifestFlag = manifestFlag;
	}
	
	/**
	 * Column Info
	 * @param glineCurrCd
	 */
	public void setOptmStsCd(String optmStsCd) {
		this.optmStsCd = optmStsCd;
	}
	
	/**
	 * Column Info
	 * @param glineRevAmt
	 */
	public void setGlineRevAmt(String glineRevAmt) {
		this.glineRevAmt = glineRevAmt;
	}
	
	/**
	 * Column Info
	 * @param glineCurrCd
	 */
	public void setGlineCurrCd(String glineCurrCd) {
		this.glineCurrCd = glineCurrCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTermCd
	 */
	public void setCntrTermCd(String cntrTermCd) {
		this.cntrTermCd = cntrTermCd;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
	}
	
	/**
	 * Column Info
	 * @param allInRtCd
	 */
	public void setAllInRtCd(String allInRtCd) {
		this.allInRtCd = allInRtCd;
	}
	
	/**
	 * Column Info
	 * @param agmtWgt
	 */
	public void setAgmtWgt(String agmtWgt) {
		this.agmtWgt = agmtWgt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setManifestFlag(JSPUtil.getParameter(request, prefix + "manifest_flag", ""));
		setGlineCurrCd(JSPUtil.getParameter(request, prefix + "gline_curr_cd", ""));
		setGlineRevAmt(JSPUtil.getParameter(request, prefix + "gline_rev_amt", ""));
		setOptmStsCd(JSPUtil.getParameter(request, prefix + "optm_sts_cd", ""));
		setCntrTermCd(JSPUtil.getParameter(request, prefix + "cntr_term_cd", ""));
		setTrspModCd(JSPUtil.getParameter(request, prefix + "trsp_mod_cd", ""));
		setAllInRtCd(JSPUtil.getParameter(request, prefix + "all_in_rt_cd", ""));
		setAgmtWgt(JSPUtil.getParameter(request, prefix + "agmt_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDihAmt(JSPUtil.getParameter(request, prefix + "dih_amt", ""));
		setIhcTrfNo(JSPUtil.getParameter(request, prefix + "ihc_trf_no", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GlineRevOutVO[]
	 */
	public GlineRevOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GlineRevOutVO[]
	 */
	public GlineRevOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GlineRevOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] manifestFlag = (JSPUtil.getParameter(request, prefix	+ "manifest_flag", length));
			String[] glineCurrCd = (JSPUtil.getParameter(request, prefix	+ "gline_curr_cd", length));
			String[] glineRevAmt = (JSPUtil.getParameter(request, prefix	+ "gline_rev_amt", length));
			String[] optmStsCd = (JSPUtil.getParameter(request, prefix	+ "optm_sts_cd", length));
			String[] cntrTermCd = (JSPUtil.getParameter(request, prefix	+ "cntr_term_cd", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] allInRtCd = (JSPUtil.getParameter(request, prefix	+ "all_in_rt_cd", length));
			String[] agmtWgt = (JSPUtil.getParameter(request, prefix	+ "agmt_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dihAmt = (JSPUtil.getParameter(request, prefix	+ "dih_amt", length));
			String[] ihcTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new GlineRevOutVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (manifestFlag[i] != null)
					model.setManifestFlag(manifestFlag[i]);
				if (glineCurrCd[i] != null)
					model.setGlineCurrCd(glineCurrCd[i]);
				if (glineRevAmt[i] != null)
					model.setGlineRevAmt(glineRevAmt[i]);
				if (optmStsCd[i] != null)
					model.setOptmStsCd(optmStsCd[i]);
				if (cntrTermCd[i] != null)
					model.setCntrTermCd(cntrTermCd[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (allInRtCd[i] != null)
					model.setAllInRtCd(allInRtCd[i]);
				if (agmtWgt[i] != null)
					model.setAgmtWgt(agmtWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dihAmt[i] != null)
					model.setDihAmt(dihAmt[i]);
				if (ihcTrfNo[i] != null)
					model.setIhcTrfNo(ihcTrfNo[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGlineRevOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GlineRevOutVO[]
	 */
	public GlineRevOutVO[] getGlineRevOutVOs(){
		GlineRevOutVO[] vos = (GlineRevOutVO[])models.toArray(new GlineRevOutVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manifestFlag = this.manifestFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineCurrCd = this.glineCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineRevAmt = this.glineRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmStsCd = this.optmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTermCd = this.cntrTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtWgt = this.agmtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allInRtCd = this.allInRtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNo = this.ihcTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dihAmt = this.dihAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
