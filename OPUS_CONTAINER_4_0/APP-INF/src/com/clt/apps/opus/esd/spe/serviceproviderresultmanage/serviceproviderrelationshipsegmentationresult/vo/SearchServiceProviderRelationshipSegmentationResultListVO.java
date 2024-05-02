/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchServiceProviderRelationshipSegmentationResultListVO.java
*@FileTitle : SearchServiceProviderRelationshipSegmentationResultListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipsegmentationresult.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

@SuppressWarnings("unused")
public class SearchServiceProviderRelationshipSegmentationResultListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchServiceProviderRelationshipSegmentationResultListVO> models = new ArrayList<SearchServiceProviderRelationshipSegmentationResultListVO>();
	
	/* Column Info */
	private String egCtyCd = null;
	/* Column Info */
	private String siScre = null;
	/* Column Info */
	private String spName = null;
	/* Column Info */
	private String modiSiScre = null;
	/* Column Info */
	private String srsGrpNm = null;
	/* Column Info */
	private String egRhqCd = null;
	/* Column Info */
	private String egName = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String raScre = null;
	/* Column Info */
	private String raGrpNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String srsGrpCd = null;
	/* Column Info */
	private String siGrpNm = null;
	/* Column Info */
	private String modiRaScre = null;
	/* Column Info */
	private String srsScre = null;
	/* Column Info */
	private String egId2 = null;
	/* Column Info */
	private String svcCateCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchServiceProviderRelationshipSegmentationResultListVO() {}

	public SearchServiceProviderRelationshipSegmentationResultListVO(String ibflag, String pagerows, String siScre, String modiSiScre, String raScre, String modiRaScre, String srsScre, String srsGrpCd, String srsGrpNm, String egName, String spName, String siGrpNm, String raGrpNm, String egRhqCd, String egCtyCd, String svcCateCd, String egId2) {
		this.egCtyCd = egCtyCd;
		this.siScre = siScre;
		this.spName = spName;
		this.modiSiScre = modiSiScre;
		this.srsGrpNm = srsGrpNm;
		this.egRhqCd = egRhqCd;
		this.egName = egName;
		this.pagerows = pagerows;
		this.raScre = raScre;
		this.raGrpNm = raGrpNm;
		this.ibflag = ibflag;
		this.srsGrpCd = srsGrpCd;
		this.siGrpNm = siGrpNm;
		this.modiRaScre = modiRaScre;
		this.srsScre = srsScre;
		this.egId2 = egId2;
		this.svcCateCd = svcCateCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eg_cty_cd", getEgCtyCd());
		this.hashColumns.put("si_scre", getSiScre());
		this.hashColumns.put("sp_name", getSpName());
		this.hashColumns.put("modi_si_scre", getModiSiScre());
		this.hashColumns.put("srs_grp_nm", getSrsGrpNm());
		this.hashColumns.put("eg_rhq_cd", getEgRhqCd());
		this.hashColumns.put("eg_name", getEgName());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ra_scre", getRaScre());
		this.hashColumns.put("ra_grp_nm", getRaGrpNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("srs_grp_cd", getSrsGrpCd());
		this.hashColumns.put("si_grp_nm", getSiGrpNm());
		this.hashColumns.put("modi_ra_scre", getModiRaScre());
		this.hashColumns.put("srs_scre", getSrsScre());
		this.hashColumns.put("eg_id2", getEgId2());
		this.hashColumns.put("svc_cate_cd", getSvcCateCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eg_cty_cd", "egCtyCd");
		this.hashFields.put("si_scre", "siScre");
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("modi_si_scre", "modiSiScre");
		this.hashFields.put("srs_grp_nm", "srsGrpNm");
		this.hashFields.put("eg_rhq_cd", "egRhqCd");
		this.hashFields.put("eg_name", "egName");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ra_scre", "raScre");
		this.hashFields.put("ra_grp_nm", "raGrpNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("srs_grp_cd", "srsGrpCd");
		this.hashFields.put("si_grp_nm", "siGrpNm");
		this.hashFields.put("modi_ra_scre", "modiRaScre");
		this.hashFields.put("srs_scre", "srsScre");
		this.hashFields.put("eg_id2", "egId2");
		this.hashFields.put("svc_cate_cd", "svcCateCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return egCtyCd
	 */
	public String getEgCtyCd() {
		return this.egCtyCd;
	}
	
	/**
	 * Column Info
	 * @return siScre
	 */
	public String getSiScre() {
		return this.siScre;
	}
	
	/**
	 * Column Info
	 * @return spName
	 */
	public String getSpName() {
		return this.spName;
	}
	
	/**
	 * Column Info
	 * @return modiSiScre
	 */
	public String getModiSiScre() {
		return this.modiSiScre;
	}
	
	/**
	 * Column Info
	 * @return srsGrpNm
	 */
	public String getSrsGrpNm() {
		return this.srsGrpNm;
	}
	
	/**
	 * Column Info
	 * @return egRhqCd
	 */
	public String getEgRhqCd() {
		return this.egRhqCd;
	}
	
	/**
	 * Column Info
	 * @return egName
	 */
	public String getEgName() {
		return this.egName;
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
	 * @return raScre
	 */
	public String getRaScre() {
		return this.raScre;
	}
	
	/**
	 * Column Info
	 * @return raGrpNm
	 */
	public String getRaGrpNm() {
		return this.raGrpNm;
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
	 * @return srsGrpCd
	 */
	public String getSrsGrpCd() {
		return this.srsGrpCd;
	}
	
	/**
	 * Column Info
	 * @return siGrpNm
	 */
	public String getSiGrpNm() {
		return this.siGrpNm;
	}
	
	/**
	 * Column Info
	 * @return modiRaScre
	 */
	public String getModiRaScre() {
		return this.modiRaScre;
	}
	
	/**
	 * Column Info
	 * @return srsScre
	 */
	public String getSrsScre() {
		return this.srsScre;
	}
	
	/**
	 * Column Info
	 * @return egId2
	 */
	public String getEgId2() {
		return this.egId2;
	}
	
	/**
	 * Column Info
	 * @return svcCateCd
	 */
	public String getSvcCateCd() {
		return this.svcCateCd;
	}
	

	/**
	 * Column Info
	 * @param egCtyCd
	 */
	public void setEgCtyCd(String egCtyCd) {
		this.egCtyCd = egCtyCd;
	}
	
	/**
	 * Column Info
	 * @param siScre
	 */
	public void setSiScre(String siScre) {
		this.siScre = siScre;
	}
	
	/**
	 * Column Info
	 * @param spName
	 */
	public void setSpName(String spName) {
		this.spName = spName;
	}
	
	/**
	 * Column Info
	 * @param modiSiScre
	 */
	public void setModiSiScre(String modiSiScre) {
		this.modiSiScre = modiSiScre;
	}
	
	/**
	 * Column Info
	 * @param srsGrpNm
	 */
	public void setSrsGrpNm(String srsGrpNm) {
		this.srsGrpNm = srsGrpNm;
	}
	
	/**
	 * Column Info
	 * @param egRhqCd
	 */
	public void setEgRhqCd(String egRhqCd) {
		this.egRhqCd = egRhqCd;
	}
	
	/**
	 * Column Info
	 * @param egName
	 */
	public void setEgName(String egName) {
		this.egName = egName;
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
	 * @param raScre
	 */
	public void setRaScre(String raScre) {
		this.raScre = raScre;
	}
	
	/**
	 * Column Info
	 * @param raGrpNm
	 */
	public void setRaGrpNm(String raGrpNm) {
		this.raGrpNm = raGrpNm;
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
	 * @param srsGrpCd
	 */
	public void setSrsGrpCd(String srsGrpCd) {
		this.srsGrpCd = srsGrpCd;
	}
	
	/**
	 * Column Info
	 * @param siGrpNm
	 */
	public void setSiGrpNm(String siGrpNm) {
		this.siGrpNm = siGrpNm;
	}
	
	/**
	 * Column Info
	 * @param modiRaScre
	 */
	public void setModiRaScre(String modiRaScre) {
		this.modiRaScre = modiRaScre;
	}
	
	/**
	 * Column Info
	 * @param srsScre
	 */
	public void setSrsScre(String srsScre) {
		this.srsScre = srsScre;
	}
	
	/**
	 * Column Info
	 * @param egId2
	 */
	public void setEgId2(String egId2) {
		this.egId2 = egId2;
	}
	
	/**
	 * Column Info
	 * @param svcCateCd
	 */
	public void setSvcCateCd(String svcCateCd) {
		this.svcCateCd = svcCateCd;
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
		setEgCtyCd(JSPUtil.getParameter(request, prefix + "eg_cty_cd", ""));
		setSiScre(JSPUtil.getParameter(request, prefix + "si_scre", ""));
		setSpName(JSPUtil.getParameter(request, prefix + "sp_name", ""));
		setModiSiScre(JSPUtil.getParameter(request, prefix + "modi_si_scre", ""));
		setSrsGrpNm(JSPUtil.getParameter(request, prefix + "srs_grp_nm", ""));
		setEgRhqCd(JSPUtil.getParameter(request, prefix + "eg_rhq_cd", ""));
		setEgName(JSPUtil.getParameter(request, prefix + "eg_name", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRaScre(JSPUtil.getParameter(request, prefix + "ra_scre", ""));
		setRaGrpNm(JSPUtil.getParameter(request, prefix + "ra_grp_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSrsGrpCd(JSPUtil.getParameter(request, prefix + "srs_grp_cd", ""));
		setSiGrpNm(JSPUtil.getParameter(request, prefix + "si_grp_nm", ""));
		setModiRaScre(JSPUtil.getParameter(request, prefix + "modi_ra_scre", ""));
		setSrsScre(JSPUtil.getParameter(request, prefix + "srs_scre", ""));
		setEgId2(JSPUtil.getParameter(request, prefix + "eg_id2", ""));
		setSvcCateCd(JSPUtil.getParameter(request, prefix + "svc_cate_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchServiceProviderRelationshipSegmentationResultListVO[]
	 */
	public SearchServiceProviderRelationshipSegmentationResultListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchServiceProviderRelationshipSegmentationResultListVO[]
	 */
	public SearchServiceProviderRelationshipSegmentationResultListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchServiceProviderRelationshipSegmentationResultListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] egCtyCd = (JSPUtil.getParameter(request, prefix	+ "eg_cty_cd", length));
			String[] siScre = (JSPUtil.getParameter(request, prefix	+ "si_scre", length));
			String[] spName = (JSPUtil.getParameter(request, prefix	+ "sp_name", length));
			String[] modiSiScre = (JSPUtil.getParameter(request, prefix	+ "modi_si_scre", length));
			String[] srsGrpNm = (JSPUtil.getParameter(request, prefix	+ "srs_grp_nm", length));
			String[] egRhqCd = (JSPUtil.getParameter(request, prefix	+ "eg_rhq_cd", length));
			String[] egName = (JSPUtil.getParameter(request, prefix	+ "eg_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] raScre = (JSPUtil.getParameter(request, prefix	+ "ra_scre", length));
			String[] raGrpNm = (JSPUtil.getParameter(request, prefix	+ "ra_grp_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] srsGrpCd = (JSPUtil.getParameter(request, prefix	+ "srs_grp_cd", length));
			String[] siGrpNm = (JSPUtil.getParameter(request, prefix	+ "si_grp_nm", length));
			String[] modiRaScre = (JSPUtil.getParameter(request, prefix	+ "modi_ra_scre", length));
			String[] srsScre = (JSPUtil.getParameter(request, prefix	+ "srs_scre", length));
			String[] egId2 = (JSPUtil.getParameter(request, prefix	+ "eg_id2", length));
			String[] svcCateCd = (JSPUtil.getParameter(request, prefix	+ "svc_cate_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchServiceProviderRelationshipSegmentationResultListVO();
				if (egCtyCd[i] != null)
					model.setEgCtyCd(egCtyCd[i]);
				if (siScre[i] != null)
					model.setSiScre(siScre[i]);
				if (spName[i] != null)
					model.setSpName(spName[i]);
				if (modiSiScre[i] != null)
					model.setModiSiScre(modiSiScre[i]);
				if (srsGrpNm[i] != null)
					model.setSrsGrpNm(srsGrpNm[i]);
				if (egRhqCd[i] != null)
					model.setEgRhqCd(egRhqCd[i]);
				if (egName[i] != null)
					model.setEgName(egName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (raScre[i] != null)
					model.setRaScre(raScre[i]);
				if (raGrpNm[i] != null)
					model.setRaGrpNm(raGrpNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (srsGrpCd[i] != null)
					model.setSrsGrpCd(srsGrpCd[i]);
				if (siGrpNm[i] != null)
					model.setSiGrpNm(siGrpNm[i]);
				if (modiRaScre[i] != null)
					model.setModiRaScre(modiRaScre[i]);
				if (srsScre[i] != null)
					model.setSrsScre(srsScre[i]);
				if (egId2[i] != null)
					model.setEgId2(egId2[i]);
				if (svcCateCd[i] != null)
					model.setSvcCateCd(svcCateCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchServiceProviderRelationshipSegmentationResultListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchServiceProviderRelationshipSegmentationResultListVO[]
	 */
	public SearchServiceProviderRelationshipSegmentationResultListVO[] getSearchServiceProviderRelationshipSegmentationResultListVOs(){
		SearchServiceProviderRelationshipSegmentationResultListVO[] vos = (SearchServiceProviderRelationshipSegmentationResultListVO[])models.toArray(new SearchServiceProviderRelationshipSegmentationResultListVO[models.size()]);
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
		this.egCtyCd = this.egCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siScre = this.siScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spName = this.spName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiSiScre = this.modiSiScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srsGrpNm = this.srsGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egRhqCd = this.egRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egName = this.egName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raScre = this.raScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raGrpNm = this.raGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srsGrpCd = this.srsGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siGrpNm = this.siGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modiRaScre = this.modiRaScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srsScre = this.srsScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId2 = this.egId2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateCd = this.svcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
