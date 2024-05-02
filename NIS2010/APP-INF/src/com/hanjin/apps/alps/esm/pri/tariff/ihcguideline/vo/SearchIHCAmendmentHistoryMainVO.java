/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchIHCAmendmentHistoryMainVO.java
*@FileTitle : SearchIHCAmendmentHistoryMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.27
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.06.27 CHLOE MIJIN SEO 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchIHCAmendmentHistoryMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchIHCAmendmentHistoryMainVO> models = new ArrayList<SearchIHCAmendmentHistoryMainVO>();
	
	/* Column Info */
	private String pubUsr = null;
	/* Column Info */
	private String ihcTrfNoFormat = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String ihcTrfNo = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String detailTp = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pubDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String costCntCd = null;
	/* Column Info */
	private String creUsr = null;
	/* Column Info */
	private String cfmUsr = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String ihcTrfAmdtTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchIHCAmendmentHistoryMainVO() {}

	public SearchIHCAmendmentHistoryMainVO(String ibflag, String pagerows, String amdtSeq, String ihcTrfAmdtTpCd, String ihcTrfNoFormat, String ihcTrfNo, String effDt, String expDt, String creDt, String creUsr, String cfmDt, String cfmUsr, String pubDt, String pubUsr, String svcScpCd, String orgDestTpCd, String costCntCd, String rhqCd, String loclCurrCd, String detailTp) {
		this.pubUsr = pubUsr;
		this.ihcTrfNoFormat = ihcTrfNoFormat;
		this.rhqCd = rhqCd;
		this.ihcTrfNo = ihcTrfNo;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.detailTp = detailTp;
		this.loclCurrCd = loclCurrCd;
		this.cfmDt = cfmDt;
		this.orgDestTpCd = orgDestTpCd;
		this.creDt = creDt;
		this.pubDt = pubDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.costCntCd = costCntCd;
		this.creUsr = creUsr;
		this.cfmUsr = cfmUsr;
		this.expDt = expDt;
		this.ihcTrfAmdtTpCd = ihcTrfAmdtTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pub_usr", getPubUsr());
		this.hashColumns.put("ihc_trf_no_format", getIhcTrfNoFormat());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("ihc_trf_no", getIhcTrfNo());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("detail_tp", getDetailTp());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pub_dt", getPubDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cost_cnt_cd", getCostCntCd());
		this.hashColumns.put("cre_usr", getCreUsr());
		this.hashColumns.put("cfm_usr", getCfmUsr());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("ihc_trf_amdt_tp_cd", getIhcTrfAmdtTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pub_usr", "pubUsr");
		this.hashFields.put("ihc_trf_no_format", "ihcTrfNoFormat");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("ihc_trf_no", "ihcTrfNo");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("detail_tp", "detailTp");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pub_dt", "pubDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cost_cnt_cd", "costCntCd");
		this.hashFields.put("cre_usr", "creUsr");
		this.hashFields.put("cfm_usr", "cfmUsr");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("ihc_trf_amdt_tp_cd", "ihcTrfAmdtTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pubUsr
	 */
	public String getPubUsr() {
		return this.pubUsr;
	}
	
	/**
	 * Column Info
	 * @return ihcTrfNoFormat
	 */
	public String getIhcTrfNoFormat() {
		return this.ihcTrfNoFormat;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return ihcTrfNo
	 */
	public String getIhcTrfNo() {
		return this.ihcTrfNo;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
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
	 * @return detailTp
	 */
	public String getDetailTp() {
		return this.detailTp;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return pubDt
	 */
	public String getPubDt() {
		return this.pubDt;
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
	 * @return costCntCd
	 */
	public String getCostCntCd() {
		return this.costCntCd;
	}
	
	/**
	 * Column Info
	 * @return creUsr
	 */
	public String getCreUsr() {
		return this.creUsr;
	}
	
	/**
	 * Column Info
	 * @return cfmUsr
	 */
	public String getCfmUsr() {
		return this.cfmUsr;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return ihcTrfAmdtTpCd
	 */
	public String getIhcTrfAmdtTpCd() {
		return this.ihcTrfAmdtTpCd;
	}
	

	/**
	 * Column Info
	 * @param pubUsr
	 */
	public void setPubUsr(String pubUsr) {
		this.pubUsr = pubUsr;
	}
	
	/**
	 * Column Info
	 * @param ihcTrfNoFormat
	 */
	public void setIhcTrfNoFormat(String ihcTrfNoFormat) {
		this.ihcTrfNoFormat = ihcTrfNoFormat;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param ihcTrfNo
	 */
	public void setIhcTrfNo(String ihcTrfNo) {
		this.ihcTrfNo = ihcTrfNo;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
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
	 * @param detailTp
	 */
	public void setDetailTp(String detailTp) {
		this.detailTp = detailTp;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param pubDt
	 */
	public void setPubDt(String pubDt) {
		this.pubDt = pubDt;
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
	 * @param costCntCd
	 */
	public void setCostCntCd(String costCntCd) {
		this.costCntCd = costCntCd;
	}
	
	/**
	 * Column Info
	 * @param creUsr
	 */
	public void setCreUsr(String creUsr) {
		this.creUsr = creUsr;
	}
	
	/**
	 * Column Info
	 * @param cfmUsr
	 */
	public void setCfmUsr(String cfmUsr) {
		this.cfmUsr = cfmUsr;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param ihcTrfAmdtTpCd
	 */
	public void setIhcTrfAmdtTpCd(String ihcTrfAmdtTpCd) {
		this.ihcTrfAmdtTpCd = ihcTrfAmdtTpCd;
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
		setPubUsr(JSPUtil.getParameter(request, prefix + "pub_usr", ""));
		setIhcTrfNoFormat(JSPUtil.getParameter(request, prefix + "ihc_trf_no_format", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setIhcTrfNo(JSPUtil.getParameter(request, prefix + "ihc_trf_no", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setDetailTp(JSPUtil.getParameter(request, prefix + "detail_tp", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPubDt(JSPUtil.getParameter(request, prefix + "pub_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCostCntCd(JSPUtil.getParameter(request, prefix + "cost_cnt_cd", ""));
		setCreUsr(JSPUtil.getParameter(request, prefix + "cre_usr", ""));
		setCfmUsr(JSPUtil.getParameter(request, prefix + "cfm_usr", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setIhcTrfAmdtTpCd(JSPUtil.getParameter(request, prefix + "ihc_trf_amdt_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchIHCAmendmentHistoryMainVO[]
	 */
	public SearchIHCAmendmentHistoryMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchIHCAmendmentHistoryMainVO[]
	 */
	public SearchIHCAmendmentHistoryMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchIHCAmendmentHistoryMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pubUsr = (JSPUtil.getParameter(request, prefix	+ "pub_usr", length));
			String[] ihcTrfNoFormat = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no_format", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] ihcTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] detailTp = (JSPUtil.getParameter(request, prefix	+ "detail_tp", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pubDt = (JSPUtil.getParameter(request, prefix	+ "pub_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] costCntCd = (JSPUtil.getParameter(request, prefix	+ "cost_cnt_cd", length));
			String[] creUsr = (JSPUtil.getParameter(request, prefix	+ "cre_usr", length));
			String[] cfmUsr = (JSPUtil.getParameter(request, prefix	+ "cfm_usr", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] ihcTrfAmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_amdt_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchIHCAmendmentHistoryMainVO();
				if (pubUsr[i] != null)
					model.setPubUsr(pubUsr[i]);
				if (ihcTrfNoFormat[i] != null)
					model.setIhcTrfNoFormat(ihcTrfNoFormat[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (ihcTrfNo[i] != null)
					model.setIhcTrfNo(ihcTrfNo[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (detailTp[i] != null)
					model.setDetailTp(detailTp[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pubDt[i] != null)
					model.setPubDt(pubDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (costCntCd[i] != null)
					model.setCostCntCd(costCntCd[i]);
				if (creUsr[i] != null)
					model.setCreUsr(creUsr[i]);
				if (cfmUsr[i] != null)
					model.setCfmUsr(cfmUsr[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (ihcTrfAmdtTpCd[i] != null)
					model.setIhcTrfAmdtTpCd(ihcTrfAmdtTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchIHCAmendmentHistoryMainVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchIHCAmendmentHistoryMainVO[]
	 */
	public SearchIHCAmendmentHistoryMainVO[] getSearchIHCAmendmentHistoryMainVOs(){
		SearchIHCAmendmentHistoryMainVO[] vos = (SearchIHCAmendmentHistoryMainVO[])models.toArray(new SearchIHCAmendmentHistoryMainVO[models.size()]);
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
		this.pubUsr = this.pubUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNoFormat = this.ihcTrfNoFormat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNo = this.ihcTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detailTp = this.detailTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubDt = this.pubDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCntCd = this.costCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsr = this.creUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsr = this.cfmUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfAmdtTpCd = this.ihcTrfAmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
