/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchServiceProviderRelationshipAttractivenessResultListVO.java
*@FileTitle : SearchServiceProviderRelationshipAttractivenessResultListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.spe.serviceproviderresultmanage.serviceproviderrelationshipattractivenessresult.vo;

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
public class SearchServiceProviderRelationshipAttractivenessResultListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchServiceProviderRelationshipAttractivenessResultListVO> models = new ArrayList<SearchServiceProviderRelationshipAttractivenessResultListVO>();
	
	/* Column Info */
	private String spName = null;
	/* Column Info */
	private String egCtyCd = null;
	/* Column Info */
	private String egRhqCd = null;
	/* Column Info */
	private String raGrpCd = null;
	/* Column Info */
	private String egName = null;
	/* Column Info */
	private String tempIbflag = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String raScre = null;
	/* Column Info */
	private String raGrpNm = null;
	/* Column Info */
	private String atrcToHjsScre = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String egIdSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String egId2 = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String egId = null;
	/* Column Info */
	private String svcCateCd = null;
	/* Column Info */
	private String atrcToSpScre = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchServiceProviderRelationshipAttractivenessResultListVO() {}

	public SearchServiceProviderRelationshipAttractivenessResultListVO(String ibflag, String pagerows, String tempIbflag, String vndrSeq, String evYr, String atrcToHjsScre, String atrcToSpScre, String raScre, String raGrpCd, String raGrpNm, String egId, String egIdSeq, String egRhqCd, String egCtyCd, String svcCateCd, String egName, String spName, String egId2) {
		this.spName = spName;
		this.egCtyCd = egCtyCd;
		this.egRhqCd = egRhqCd;
		this.raGrpCd = raGrpCd;
		this.egName = egName;
		this.tempIbflag = tempIbflag;
		this.pagerows = pagerows;
		this.raScre = raScre;
		this.raGrpNm = raGrpNm;
		this.atrcToHjsScre = atrcToHjsScre;
		this.ibflag = ibflag;
		this.egIdSeq = egIdSeq;
		this.vndrSeq = vndrSeq;
		this.egId2 = egId2;
		this.evYr = evYr;
		this.egId = egId;
		this.svcCateCd = svcCateCd;
		this.atrcToSpScre = atrcToSpScre;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sp_name", getSpName());
		this.hashColumns.put("eg_cty_cd", getEgCtyCd());
		this.hashColumns.put("eg_rhq_cd", getEgRhqCd());
		this.hashColumns.put("ra_grp_cd", getRaGrpCd());
		this.hashColumns.put("eg_name", getEgName());
		this.hashColumns.put("temp_ibflag", getTempIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ra_scre", getRaScre());
		this.hashColumns.put("ra_grp_nm", getRaGrpNm());
		this.hashColumns.put("atrc_to_hjs_scre", getAtrcToHjsScre());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eg_id_seq", getEgIdSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("eg_id2", getEgId2());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("eg_id", getEgId());
		this.hashColumns.put("svc_cate_cd", getSvcCateCd());
		this.hashColumns.put("atrc_to_sp_scre", getAtrcToSpScre());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("eg_cty_cd", "egCtyCd");
		this.hashFields.put("eg_rhq_cd", "egRhqCd");
		this.hashFields.put("ra_grp_cd", "raGrpCd");
		this.hashFields.put("eg_name", "egName");
		this.hashFields.put("temp_ibflag", "tempIbflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ra_scre", "raScre");
		this.hashFields.put("ra_grp_nm", "raGrpNm");
		this.hashFields.put("atrc_to_hjs_scre", "atrcToHjsScre");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eg_id_seq", "egIdSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eg_id2", "egId2");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("eg_id", "egId");
		this.hashFields.put("svc_cate_cd", "svcCateCd");
		this.hashFields.put("atrc_to_sp_scre", "atrcToSpScre");
		return this.hashFields;
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
	 * @return egCtyCd
	 */
	public String getEgCtyCd() {
		return this.egCtyCd;
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
	 * @return raGrpCd
	 */
	public String getRaGrpCd() {
		return this.raGrpCd;
	}
	
	/**
	 * Column Info
	 * @return egName
	 */
	public String getEgName() {
		return this.egName;
	}
	
	/**
	 * Column Info
	 * @return tempIbflag
	 */
	public String getTempIbflag() {
		return this.tempIbflag;
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
	 * Column Info
	 * @return atrcToHjsScre
	 */
	public String getAtrcToHjsScre() {
		return this.atrcToHjsScre;
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
	 * @return egIdSeq
	 */
	public String getEgIdSeq() {
		return this.egIdSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return evYr
	 */
	public String getEvYr() {
		return this.evYr;
	}
	
	/**
	 * Column Info
	 * @return egId
	 */
	public String getEgId() {
		return this.egId;
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
	 * @return atrcToSpScre
	 */
	public String getAtrcToSpScre() {
		return this.atrcToSpScre;
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
	 * @param egCtyCd
	 */
	public void setEgCtyCd(String egCtyCd) {
		this.egCtyCd = egCtyCd;
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
	 * @param raGrpCd
	 */
	public void setRaGrpCd(String raGrpCd) {
		this.raGrpCd = raGrpCd;
	}
	
	/**
	 * Column Info
	 * @param egName
	 */
	public void setEgName(String egName) {
		this.egName = egName;
	}
	
	/**
	 * Column Info
	 * @param tempIbflag
	 */
	public void setTempIbflag(String tempIbflag) {
		this.tempIbflag = tempIbflag;
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
	 * Column Info
	 * @param atrcToHjsScre
	 */
	public void setAtrcToHjsScre(String atrcToHjsScre) {
		this.atrcToHjsScre = atrcToHjsScre;
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
	 * @param egIdSeq
	 */
	public void setEgIdSeq(String egIdSeq) {
		this.egIdSeq = egIdSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param evYr
	 */
	public void setEvYr(String evYr) {
		this.evYr = evYr;
	}
	
	/**
	 * Column Info
	 * @param egId
	 */
	public void setEgId(String egId) {
		this.egId = egId;
	}
	
	/**
	 * Column Info
	 * @param svcCateCd
	 */
	public void setSvcCateCd(String svcCateCd) {
		this.svcCateCd = svcCateCd;
	}
	
	/**
	 * Column Info
	 * @param atrcToSpScre
	 */
	public void setAtrcToSpScre(String atrcToSpScre) {
		this.atrcToSpScre = atrcToSpScre;
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
		setSpName(JSPUtil.getParameter(request, prefix + "sp_name", ""));
		setEgCtyCd(JSPUtil.getParameter(request, prefix + "eg_cty_cd", ""));
		setEgRhqCd(JSPUtil.getParameter(request, prefix + "eg_rhq_cd", ""));
		setRaGrpCd(JSPUtil.getParameter(request, prefix + "ra_grp_cd", ""));
		setEgName(JSPUtil.getParameter(request, prefix + "eg_name", ""));
		setTempIbflag(JSPUtil.getParameter(request, prefix + "temp_ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRaScre(JSPUtil.getParameter(request, prefix + "ra_scre", ""));
		setRaGrpNm(JSPUtil.getParameter(request, prefix + "ra_grp_nm", ""));
		setAtrcToHjsScre(JSPUtil.getParameter(request, prefix + "atrc_to_hjs_scre", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEgIdSeq(JSPUtil.getParameter(request, prefix + "eg_id_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setEgId2(JSPUtil.getParameter(request, prefix + "eg_id2", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
		setSvcCateCd(JSPUtil.getParameter(request, prefix + "svc_cate_cd", ""));
		setAtrcToSpScre(JSPUtil.getParameter(request, prefix + "atrc_to_sp_scre", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchServiceProviderRelationshipAttractivenessResultListVO[]
	 */
	public SearchServiceProviderRelationshipAttractivenessResultListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchServiceProviderRelationshipAttractivenessResultListVO[]
	 */
	public SearchServiceProviderRelationshipAttractivenessResultListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchServiceProviderRelationshipAttractivenessResultListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] spName = (JSPUtil.getParameter(request, prefix	+ "sp_name", length));
			String[] egCtyCd = (JSPUtil.getParameter(request, prefix	+ "eg_cty_cd", length));
			String[] egRhqCd = (JSPUtil.getParameter(request, prefix	+ "eg_rhq_cd", length));
			String[] raGrpCd = (JSPUtil.getParameter(request, prefix	+ "ra_grp_cd", length));
			String[] egName = (JSPUtil.getParameter(request, prefix	+ "eg_name", length));
			String[] tempIbflag = (JSPUtil.getParameter(request, prefix	+ "temp_ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] raScre = (JSPUtil.getParameter(request, prefix	+ "ra_scre", length));
			String[] raGrpNm = (JSPUtil.getParameter(request, prefix	+ "ra_grp_nm", length));
			String[] atrcToHjsScre = (JSPUtil.getParameter(request, prefix	+ "atrc_to_hjs_scre", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] egIdSeq = (JSPUtil.getParameter(request, prefix	+ "eg_id_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] egId2 = (JSPUtil.getParameter(request, prefix	+ "eg_id2", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			String[] svcCateCd = (JSPUtil.getParameter(request, prefix	+ "svc_cate_cd", length));
			String[] atrcToSpScre = (JSPUtil.getParameter(request, prefix	+ "atrc_to_sp_scre", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchServiceProviderRelationshipAttractivenessResultListVO();
				if (spName[i] != null)
					model.setSpName(spName[i]);
				if (egCtyCd[i] != null)
					model.setEgCtyCd(egCtyCd[i]);
				if (egRhqCd[i] != null)
					model.setEgRhqCd(egRhqCd[i]);
				if (raGrpCd[i] != null)
					model.setRaGrpCd(raGrpCd[i]);
				if (egName[i] != null)
					model.setEgName(egName[i]);
				if (tempIbflag[i] != null)
					model.setTempIbflag(tempIbflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (raScre[i] != null)
					model.setRaScre(raScre[i]);
				if (raGrpNm[i] != null)
					model.setRaGrpNm(raGrpNm[i]);
				if (atrcToHjsScre[i] != null)
					model.setAtrcToHjsScre(atrcToHjsScre[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (egIdSeq[i] != null)
					model.setEgIdSeq(egIdSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (egId2[i] != null)
					model.setEgId2(egId2[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				if (svcCateCd[i] != null)
					model.setSvcCateCd(svcCateCd[i]);
				if (atrcToSpScre[i] != null)
					model.setAtrcToSpScre(atrcToSpScre[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchServiceProviderRelationshipAttractivenessResultListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchServiceProviderRelationshipAttractivenessResultListVO[]
	 */
	public SearchServiceProviderRelationshipAttractivenessResultListVO[] getSearchServiceProviderRelationshipAttractivenessResultListVOs(){
		SearchServiceProviderRelationshipAttractivenessResultListVO[] vos = (SearchServiceProviderRelationshipAttractivenessResultListVO[])models.toArray(new SearchServiceProviderRelationshipAttractivenessResultListVO[models.size()]);
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
		this.spName = this.spName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egCtyCd = this.egCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egRhqCd = this.egRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raGrpCd = this.raGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egName = this.egName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempIbflag = this.tempIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raScre = this.raScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raGrpNm = this.raGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atrcToHjsScre = this.atrcToHjsScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egIdSeq = this.egIdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId2 = this.egId2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateCd = this.svcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atrcToSpScre = this.atrcToSpScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
