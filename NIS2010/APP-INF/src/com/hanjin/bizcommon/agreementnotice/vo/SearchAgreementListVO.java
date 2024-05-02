/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchAgreementListVO.java
*@FileTitle : SearchAgreementListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.04
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.02.04 CHLOE MIJIN SEO 
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.agreementnotice.vo;

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
 * Table Value Object<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author CHLOE MIJIN SEO
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAgreementListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAgreementListVO> models = new ArrayList<SearchAgreementListVO>();
	
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String agmtEffDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String liveFlg = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String agmtTrspTpCd = null;
	/* Column Info */
	private String agmtExpDt = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String sysCd = null;
	/* Column Info */
	private String agmtCnt = null;
	/* Column Info */
	private String ctrtCreUsrNm = null;
	/* Column Info */
	private String ctrtCreUsrId = null;
	/* Column Info */
	private String ctrtUpdDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchAgreementListVO() {}

	public SearchAgreementListVO(String ibflag, String pagerows, String sysCd, String agmtCnt, String agmtNo, String vndrNm, String ctrtOfcCd, String agmtTrspTpCd, String ctrtCreUsrId, String ctrtCreUsrNm, String liveFlg, String agmtEffDt, String agmtExpDt, String ctrtUpdDt) {
		this.vndrNm = vndrNm;
		this.agmtEffDt = agmtEffDt;
		this.ibflag = ibflag;
		this.liveFlg = liveFlg;
		this.ctrtOfcCd = ctrtOfcCd;
		this.agmtTrspTpCd = agmtTrspTpCd;
		this.agmtExpDt = agmtExpDt;
		this.agmtNo = agmtNo;
		this.sysCd = sysCd;
		this.agmtCnt = agmtCnt;
		this.ctrtCreUsrNm = ctrtCreUsrNm;
		this.ctrtCreUsrId = ctrtCreUsrId;
		this.ctrtUpdDt = ctrtUpdDt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("agmt_eff_dt", getAgmtEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("live_flg", getLiveFlg());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("agmt_trsp_tp_cd", getAgmtTrspTpCd());
		this.hashColumns.put("agmt_exp_dt", getAgmtExpDt());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("sys_cd", getSysCd());
		this.hashColumns.put("agmt_cnt", getAgmtCnt());
		this.hashColumns.put("ctrt_cre_usr_nm", getCtrtCreUsrNm());
		this.hashColumns.put("ctrt_cre_usr_id", getCtrtCreUsrId());
		this.hashColumns.put("ctrt_upd_dt", getCtrtUpdDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("agmt_eff_dt", "agmtEffDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("live_flg", "liveFlg");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("agmt_trsp_tp_cd", "agmtTrspTpCd");
		this.hashFields.put("agmt_exp_dt", "agmtExpDt");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("sys_cd", "sysCd");
		this.hashFields.put("agmt_cnt", "agmtCnt");
		this.hashFields.put("ctrt_cre_usr_nm", "ctrtCreUsrNm");
		this.hashFields.put("ctrt_cre_usr_id", "ctrtCreUsrId");
		this.hashFields.put("ctrt_upd_dt", "ctrtUpdDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return agmtEffDt
	 */
	public String getAgmtEffDt() {
		return this.agmtEffDt;
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
	 * @return liveFlg
	 */
	public String getLiveFlg() {
		return this.liveFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agmtTrspTpCd
	 */
	public String getAgmtTrspTpCd() {
		return this.agmtTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @return agmtExpDt
	 */
	public String getAgmtExpDt() {
		return this.agmtExpDt;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return sysCd
	 */
	public String getSysCd() {
		return this.sysCd;
	}
	
	/**
	 * Column Info
	 * @return agmtCnt
	 */
	public String getAgmtCnt() {
		return this.agmtCnt;
	}
	
	/**
	 * Column Info
	 * @return ctrtCreUsrNm
	 */
	public String getCtrtCreUsrNm() {
		return this.ctrtCreUsrNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtCreUsrId
	 */
	public String getCtrtCreUsrId() {
		return this.ctrtCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return ctrtUpdDt
	 */
	public String getCtrtUpdDt() {
		return this.ctrtUpdDt;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param agmtEffDt
	 */
	public void setAgmtEffDt(String agmtEffDt) {
		this.agmtEffDt = agmtEffDt;
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
	 * @param liveFlg
	 */
	public void setLiveFlg(String liveFlg) {
		this.liveFlg = liveFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agmtTrspTpCd
	 */
	public void setAgmtTrspTpCd(String agmtTrspTpCd) {
		this.agmtTrspTpCd = agmtTrspTpCd;
	}
	
	/**
	 * Column Info
	 * @param agmtExpDt
	 */
	public void setAgmtExpDt(String agmtExpDt) {
		this.agmtExpDt = agmtExpDt;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param sysCd
	 */
	public void setSysCd(String sysCd) {
		this.sysCd = sysCd;
	}
	
	/**
	 * Column Info
	 * @param agmtCnt
	 */
	public void setAgmtCnt(String agmtCnt) {
		this.agmtCnt = agmtCnt;
	}
	
	/**
	 * Column Info
	 * @param ctrtCreUsrNm
	 */
	public void setCtrtCreUsrNm(String ctrtCreUsrNm) {
		this.ctrtCreUsrNm = ctrtCreUsrNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtCreUsrId
	 */
	public void setCtrtCreUsrId(String ctrtCreUsrId) {
		this.ctrtCreUsrId = ctrtCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param ctrtUpdDt
	 */
	public void setCtrtUpdDt(String ctrtUpdDt) {
		this.ctrtUpdDt = ctrtUpdDt;
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
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setAgmtEffDt(JSPUtil.getParameter(request, prefix + "agmt_eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLiveFlg(JSPUtil.getParameter(request, prefix + "live_flg", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setAgmtTrspTpCd(JSPUtil.getParameter(request, prefix + "agmt_trsp_tp_cd", ""));
		setAgmtExpDt(JSPUtil.getParameter(request, prefix + "agmt_exp_dt", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setSysCd(JSPUtil.getParameter(request, prefix + "sys_cd", ""));
		setAgmtCnt(JSPUtil.getParameter(request, prefix + "agmt_cnt", ""));
		setCtrtCreUsrNm(JSPUtil.getParameter(request, prefix + "ctrt_cre_usr_nm", ""));
		setCtrtCreUsrId(JSPUtil.getParameter(request, prefix + "ctrt_cre_usr_id", ""));
		setCtrtUpdDt(JSPUtil.getParameter(request, prefix + "ctrt_upd_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAgreementListVO[]
	 */
	public SearchAgreementListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAgreementListVO[]
	 */
	public SearchAgreementListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAgreementListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] agmtEffDt = (JSPUtil.getParameter(request, prefix	+ "agmt_eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] liveFlg = (JSPUtil.getParameter(request, prefix	+ "live_flg", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] agmtTrspTpCd = (JSPUtil.getParameter(request, prefix	+ "agmt_trsp_tp_cd", length));
			String[] agmtExpDt = (JSPUtil.getParameter(request, prefix	+ "agmt_exp_dt", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] sysCd = (JSPUtil.getParameter(request, prefix	+ "sys_cd", length));
			String[] agmtCnt = (JSPUtil.getParameter(request, prefix	+ "agmt_cnt", length));
			String[] ctrtCreUsrNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_cre_usr_nm", length));
			String[] ctrtCreUsrId = (JSPUtil.getParameter(request, prefix	+ "ctrt_cre_usr_id", length));
			String[] ctrtUpdDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_upd_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAgreementListVO();
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (agmtEffDt[i] != null)
					model.setAgmtEffDt(agmtEffDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (liveFlg[i] != null)
					model.setLiveFlg(liveFlg[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (agmtTrspTpCd[i] != null)
					model.setAgmtTrspTpCd(agmtTrspTpCd[i]);
				if (agmtExpDt[i] != null)
					model.setAgmtExpDt(agmtExpDt[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (sysCd[i] != null)
					model.setSysCd(sysCd[i]);
				if (agmtCnt[i] != null)
					model.setAgmtCnt(agmtCnt[i]);
				if (ctrtCreUsrNm[i] != null)
					model.setCtrtCreUsrNm(ctrtCreUsrNm[i]);
				if (ctrtCreUsrId[i] != null)
					model.setCtrtCreUsrId(ctrtCreUsrId[i]);
				if (ctrtUpdDt[i] != null)
					model.setCtrtUpdDt(ctrtUpdDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAgreementListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAgreementListVO[]
	 */
	public SearchAgreementListVO[] getSearchAgreementListVOs(){
		SearchAgreementListVO[] vos = (SearchAgreementListVO[])models.toArray(new SearchAgreementListVO[models.size()]);
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
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtEffDt = this.agmtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liveFlg = this.liveFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtTrspTpCd = this.agmtTrspTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtExpDt = this.agmtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysCd = this.sysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCnt = this.agmtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCreUsrNm = this.ctrtCreUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCreUsrId = this.ctrtCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtUpdDt = this.ctrtUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
