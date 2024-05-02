/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchUsInlandServiceModeTotalVO.java
*@FileTitle : SearchUsInlandServiceModeTotalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.13
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.13 CHLOE MIJIN SEO 
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

public class SearchUsInlandServiceModeTotalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchUsInlandServiceModeTotalVO> models = new ArrayList<SearchUsInlandServiceModeTotalVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ihcTrfNo = null;
	/* Column Info */
	private String usaCostTrfSvcModNm = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totalCount = null;
	/* Column Info */
	private String costCntCd = null;
	/* Column Info */
	private String ihcCgoTpCd = null;
	/* Column Info */
	private String usaCostTrfSvcModCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchUsInlandServiceModeTotalVO() {}

	public SearchUsInlandServiceModeTotalVO(String ibflag, String pagerows, String usaCostTrfSvcModNm, String usaCostTrfSvcModCd, String totalCount, String updDt, String updUsrId, String svcScpCd, String orgDestTpCd, String ihcTrfNo, String amdtSeq, String ihcCgoTpCd, String costCntCd) {
		this.updDt = updDt;
		this.ihcTrfNo = ihcTrfNo;
		this.usaCostTrfSvcModNm = usaCostTrfSvcModNm;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.orgDestTpCd = orgDestTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.totalCount = totalCount;
		this.costCntCd = costCntCd;
		this.ihcCgoTpCd = ihcCgoTpCd;
		this.usaCostTrfSvcModCd = usaCostTrfSvcModCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ihc_trf_no", getIhcTrfNo());
		this.hashColumns.put("usa_cost_trf_svc_mod_nm", getUsaCostTrfSvcModNm());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("total_count", getTotalCount());
		this.hashColumns.put("cost_cnt_cd", getCostCntCd());
		this.hashColumns.put("ihc_cgo_tp_cd", getIhcCgoTpCd());
		this.hashColumns.put("usa_cost_trf_svc_mod_cd", getUsaCostTrfSvcModCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ihc_trf_no", "ihcTrfNo");
		this.hashFields.put("usa_cost_trf_svc_mod_nm", "usaCostTrfSvcModNm");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("total_count", "totalCount");
		this.hashFields.put("cost_cnt_cd", "costCntCd");
		this.hashFields.put("ihc_cgo_tp_cd", "ihcCgoTpCd");
		this.hashFields.put("usa_cost_trf_svc_mod_cd", "usaCostTrfSvcModCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return usaCostTrfSvcModNm
	 */
	public String getUsaCostTrfSvcModNm() {
		return this.usaCostTrfSvcModNm;
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
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
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
	 * @return totalCount
	 */
	public String getTotalCount() {
		return this.totalCount;
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
	 * @return ihcCgoTpCd
	 */
	public String getIhcCgoTpCd() {
		return this.ihcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return usaCostTrfSvcModCd
	 */
	public String getUsaCostTrfSvcModCd() {
		return this.usaCostTrfSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param usaCostTrfSvcModNm
	 */
	public void setUsaCostTrfSvcModNm(String usaCostTrfSvcModNm) {
		this.usaCostTrfSvcModNm = usaCostTrfSvcModNm;
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
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
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
	 * @param totalCount
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
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
	 * @param ihcCgoTpCd
	 */
	public void setIhcCgoTpCd(String ihcCgoTpCd) {
		this.ihcCgoTpCd = ihcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param usaCostTrfSvcModCd
	 */
	public void setUsaCostTrfSvcModCd(String usaCostTrfSvcModCd) {
		this.usaCostTrfSvcModCd = usaCostTrfSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIhcTrfNo(JSPUtil.getParameter(request, prefix + "ihc_trf_no", ""));
		setUsaCostTrfSvcModNm(JSPUtil.getParameter(request, prefix + "usa_cost_trf_svc_mod_nm", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotalCount(JSPUtil.getParameter(request, prefix + "total_count", ""));
		setCostCntCd(JSPUtil.getParameter(request, prefix + "cost_cnt_cd", ""));
		setIhcCgoTpCd(JSPUtil.getParameter(request, prefix + "ihc_cgo_tp_cd", ""));
		setUsaCostTrfSvcModCd(JSPUtil.getParameter(request, prefix + "usa_cost_trf_svc_mod_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUsInlandServiceModeTotalVO[]
	 */
	public SearchUsInlandServiceModeTotalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUsInlandServiceModeTotalVO[]
	 */
	public SearchUsInlandServiceModeTotalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchUsInlandServiceModeTotalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ihcTrfNo = (JSPUtil.getParameter(request, prefix	+ "ihc_trf_no", length));
			String[] usaCostTrfSvcModNm = (JSPUtil.getParameter(request, prefix	+ "usa_cost_trf_svc_mod_nm", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totalCount = (JSPUtil.getParameter(request, prefix	+ "total_count", length));
			String[] costCntCd = (JSPUtil.getParameter(request, prefix	+ "cost_cnt_cd", length));
			String[] ihcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "ihc_cgo_tp_cd", length));
			String[] usaCostTrfSvcModCd = (JSPUtil.getParameter(request, prefix	+ "usa_cost_trf_svc_mod_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchUsInlandServiceModeTotalVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ihcTrfNo[i] != null)
					model.setIhcTrfNo(ihcTrfNo[i]);
				if (usaCostTrfSvcModNm[i] != null)
					model.setUsaCostTrfSvcModNm(usaCostTrfSvcModNm[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totalCount[i] != null)
					model.setTotalCount(totalCount[i]);
				if (costCntCd[i] != null)
					model.setCostCntCd(costCntCd[i]);
				if (ihcCgoTpCd[i] != null)
					model.setIhcCgoTpCd(ihcCgoTpCd[i]);
				if (usaCostTrfSvcModCd[i] != null)
					model.setUsaCostTrfSvcModCd(usaCostTrfSvcModCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchUsInlandServiceModeTotalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUsInlandServiceModeTotalVO[]
	 */
	public SearchUsInlandServiceModeTotalVO[] getSearchUsInlandServiceModeTotalVOs(){
		SearchUsInlandServiceModeTotalVO[] vos = (SearchUsInlandServiceModeTotalVO[])models.toArray(new SearchUsInlandServiceModeTotalVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcTrfNo = this.ihcTrfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCostTrfSvcModNm = this.usaCostTrfSvcModNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCount = this.totalCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCntCd = this.costCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcCgoTpCd = this.ihcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCostTrfSvcModCd = this.usaCostTrfSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
