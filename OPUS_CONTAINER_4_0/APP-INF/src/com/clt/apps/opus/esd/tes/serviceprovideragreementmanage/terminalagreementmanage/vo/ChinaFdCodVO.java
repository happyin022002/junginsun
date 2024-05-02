/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChinaFdCodVO.java
*@FileTitle : ChinaFdCodVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.18
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.04.18 조정민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo;

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
 * @author 조정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChinaFdCodVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChinaFdCodVO> models = new ArrayList<ChinaFdCodVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String podLocNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String polLocNm = null;
	/* Column Info */
	private String searchCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String chkPolCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fdrPolCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String chkPodCd = null;
	/* Column Info */
	private String fdrPodCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChinaFdCodVO() {}

	public ChinaFdCodVO(String ibflag, String pagerows, String fdrPolCd, String fdrPodCd, String polCd, String podCd, String chkPolCd, String chkPodCd, String creUsrId, String creDt, String updUsrId, String updDt, String polLocNm, String podLocNm, String searchCd) {
		this.updDt = updDt;
		this.podLocNm = podLocNm;
		this.creDt = creDt;
		this.polLocNm = polLocNm;
		this.searchCd = searchCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.chkPolCd = chkPolCd;
		this.ibflag = ibflag;
		this.fdrPolCd = fdrPolCd;
		this.polCd = polCd;
		this.creUsrId = creUsrId;
		this.chkPodCd = chkPodCd;
		this.fdrPodCd = fdrPodCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pod_loc_nm", getPodLocNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pol_loc_nm", getPolLocNm());
		this.hashColumns.put("search_cd", getSearchCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("chk_pol_cd", getChkPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fdr_pol_cd", getFdrPolCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("chk_pod_cd", getChkPodCd());
		this.hashColumns.put("fdr_pod_cd", getFdrPodCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pod_loc_nm", "podLocNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pol_loc_nm", "polLocNm");
		this.hashFields.put("search_cd", "searchCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("chk_pol_cd", "chkPolCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fdr_pol_cd", "fdrPolCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chk_pod_cd", "chkPodCd");
		this.hashFields.put("fdr_pod_cd", "fdrPodCd");
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
	 * @return podLocNm
	 */
	public String getPodLocNm() {
		return this.podLocNm;
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
	 * @return polLocNm
	 */
	public String getPolLocNm() {
		return this.polLocNm;
	}
	
	/**
	 * Column Info
	 * @return searchCd
	 */
	public String getSearchCd() {
		return this.searchCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return chkPolCd
	 */
	public String getChkPolCd() {
		return this.chkPolCd;
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
	 * @return fdrPolCd
	 */
	public String getFdrPolCd() {
		return this.fdrPolCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return chkPodCd
	 */
	public String getChkPodCd() {
		return this.chkPodCd;
	}
	
	/**
	 * Column Info
	 * @return fdrPodCd
	 */
	public String getFdrPodCd() {
		return this.fdrPodCd;
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
	 * @param podLocNm
	 */
	public void setPodLocNm(String podLocNm) {
		this.podLocNm = podLocNm;
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
	 * @param polLocNm
	 */
	public void setPolLocNm(String polLocNm) {
		this.polLocNm = polLocNm;
	}
	
	/**
	 * Column Info
	 * @param searchCd
	 */
	public void setSearchCd(String searchCd) {
		this.searchCd = searchCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param chkPolCd
	 */
	public void setChkPolCd(String chkPolCd) {
		this.chkPolCd = chkPolCd;
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
	 * @param fdrPolCd
	 */
	public void setFdrPolCd(String fdrPolCd) {
		this.fdrPolCd = fdrPolCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param chkPodCd
	 */
	public void setChkPodCd(String chkPodCd) {
		this.chkPodCd = chkPodCd;
	}
	
	/**
	 * Column Info
	 * @param fdrPodCd
	 */
	public void setFdrPodCd(String fdrPodCd) {
		this.fdrPodCd = fdrPodCd;
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
		setPodLocNm(JSPUtil.getParameter(request, prefix + "pod_loc_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPolLocNm(JSPUtil.getParameter(request, prefix + "pol_loc_nm", ""));
		setSearchCd(JSPUtil.getParameter(request, prefix + "search_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setChkPolCd(JSPUtil.getParameter(request, prefix + "chk_pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFdrPolCd(JSPUtil.getParameter(request, prefix + "fdr_pol_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setChkPodCd(JSPUtil.getParameter(request, prefix + "chk_pod_cd", ""));
		setFdrPodCd(JSPUtil.getParameter(request, prefix + "fdr_pod_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaFdCodVO[]
	 */
	public ChinaFdCodVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChinaFdCodVO[]
	 */
	public ChinaFdCodVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaFdCodVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] podLocNm = (JSPUtil.getParameter(request, prefix	+ "pod_loc_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] polLocNm = (JSPUtil.getParameter(request, prefix	+ "pol_loc_nm", length));
			String[] searchCd = (JSPUtil.getParameter(request, prefix	+ "search_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] chkPolCd = (JSPUtil.getParameter(request, prefix	+ "chk_pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fdrPolCd = (JSPUtil.getParameter(request, prefix	+ "fdr_pol_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] chkPodCd = (JSPUtil.getParameter(request, prefix	+ "chk_pod_cd", length));
			String[] fdrPodCd = (JSPUtil.getParameter(request, prefix	+ "fdr_pod_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChinaFdCodVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (podLocNm[i] != null)
					model.setPodLocNm(podLocNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (polLocNm[i] != null)
					model.setPolLocNm(polLocNm[i]);
				if (searchCd[i] != null)
					model.setSearchCd(searchCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (chkPolCd[i] != null)
					model.setChkPolCd(chkPolCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fdrPolCd[i] != null)
					model.setFdrPolCd(fdrPolCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (chkPodCd[i] != null)
					model.setChkPodCd(chkPodCd[i]);
				if (fdrPodCd[i] != null)
					model.setFdrPodCd(fdrPodCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaFdCodVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaFdCodVO[]
	 */
	public ChinaFdCodVO[] getChinaFdCodVOs(){
		ChinaFdCodVO[] vos = (ChinaFdCodVO[])models.toArray(new ChinaFdCodVO[models.size()]);
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
		this.podLocNm = this.podLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polLocNm = this.polLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchCd = this.searchCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPolCd = this.chkPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrPolCd = this.fdrPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPodCd = this.chkPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrPodCd = this.fdrPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
