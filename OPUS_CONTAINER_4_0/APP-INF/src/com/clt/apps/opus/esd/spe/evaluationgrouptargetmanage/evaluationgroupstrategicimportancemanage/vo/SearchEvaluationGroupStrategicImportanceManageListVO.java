/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchEvaluationGroupStrategicImportanceManageListVO.java
*@FileTitle : SearchEvaluationGroupStrategicImportanceManageListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.vo;

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
public class SearchEvaluationGroupStrategicImportanceManageListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEvaluationGroupStrategicImportanceManageListVO> models = new ArrayList<SearchEvaluationGroupStrategicImportanceManageListVO>();
	
	/* Column Info */
	private String siScre = null;
	/* Column Info */
	private String egCtyCd = null;
	/* Column Info */
	private String egRhqCd = null;
	/* Column Info */
	private String tempIbflag = null;
	/* Column Info */
	private String dsScre = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String egNm = null;
	/* Column Info */
	private String siGrpNm = null;
	/* Column Info */
	private String egIdSeq = null;
	/* Column Info */
	private String siGrpCd = null;
	/* Column Info */
	private String egId2 = null;
	/* Column Info */
	private String biScre = null;
	/* Column Info */
	private String egId = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String svcCateCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEvaluationGroupStrategicImportanceManageListVO() {}

	public SearchEvaluationGroupStrategicImportanceManageListVO(String ibflag, String pagerows, String tempIbflag, String egId, String egIdSeq, String egId2, String egRhqCd, String egCtyCd, String svcCateCd, String egNm, String evYr, String biScre, String dsScre, String siScre, String siGrpCd, String siGrpNm) {
		this.siScre = siScre;
		this.egCtyCd = egCtyCd;
		this.egRhqCd = egRhqCd;
		this.tempIbflag = tempIbflag;
		this.dsScre = dsScre;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.egNm = egNm;
		this.siGrpNm = siGrpNm;
		this.egIdSeq = egIdSeq;
		this.siGrpCd = siGrpCd;
		this.egId2 = egId2;
		this.biScre = biScre;
		this.egId = egId;
		this.evYr = evYr;
		this.svcCateCd = svcCateCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("si_scre", getSiScre());
		this.hashColumns.put("eg_cty_cd", getEgCtyCd());
		this.hashColumns.put("eg_rhq_cd", getEgRhqCd());
		this.hashColumns.put("temp_ibflag", getTempIbflag());
		this.hashColumns.put("ds_scre", getDsScre());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eg_nm", getEgNm());
		this.hashColumns.put("si_grp_nm", getSiGrpNm());
		this.hashColumns.put("eg_id_seq", getEgIdSeq());
		this.hashColumns.put("si_grp_cd", getSiGrpCd());
		this.hashColumns.put("eg_id2", getEgId2());
		this.hashColumns.put("bi_scre", getBiScre());
		this.hashColumns.put("eg_id", getEgId());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("svc_cate_cd", getSvcCateCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("si_scre", "siScre");
		this.hashFields.put("eg_cty_cd", "egCtyCd");
		this.hashFields.put("eg_rhq_cd", "egRhqCd");
		this.hashFields.put("temp_ibflag", "tempIbflag");
		this.hashFields.put("ds_scre", "dsScre");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eg_nm", "egNm");
		this.hashFields.put("si_grp_nm", "siGrpNm");
		this.hashFields.put("eg_id_seq", "egIdSeq");
		this.hashFields.put("si_grp_cd", "siGrpCd");
		this.hashFields.put("eg_id2", "egId2");
		this.hashFields.put("bi_scre", "biScre");
		this.hashFields.put("eg_id", "egId");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("svc_cate_cd", "svcCateCd");
		return this.hashFields;
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
	 * @return tempIbflag
	 */
	public String getTempIbflag() {
		return this.tempIbflag;
	}
	
	/**
	 * Column Info
	 * @return dsScre
	 */
	public String getDsScre() {
		return this.dsScre;
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
	 * @return egNm
	 */
	public String getEgNm() {
		return this.egNm;
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
	 * @return egIdSeq
	 */
	public String getEgIdSeq() {
		return this.egIdSeq;
	}
	
	/**
	 * Column Info
	 * @return siGrpCd
	 */
	public String getSiGrpCd() {
		return this.siGrpCd;
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
	 * @return biScre
	 */
	public String getBiScre() {
		return this.biScre;
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
	 * @return evYr
	 */
	public String getEvYr() {
		return this.evYr;
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
	 * @param siScre
	 */
	public void setSiScre(String siScre) {
		this.siScre = siScre;
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
	 * @param tempIbflag
	 */
	public void setTempIbflag(String tempIbflag) {
		this.tempIbflag = tempIbflag;
	}
	
	/**
	 * Column Info
	 * @param dsScre
	 */
	public void setDsScre(String dsScre) {
		this.dsScre = dsScre;
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
	 * @param egNm
	 */
	public void setEgNm(String egNm) {
		this.egNm = egNm;
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
	 * @param egIdSeq
	 */
	public void setEgIdSeq(String egIdSeq) {
		this.egIdSeq = egIdSeq;
	}
	
	/**
	 * Column Info
	 * @param siGrpCd
	 */
	public void setSiGrpCd(String siGrpCd) {
		this.siGrpCd = siGrpCd;
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
	 * @param biScre
	 */
	public void setBiScre(String biScre) {
		this.biScre = biScre;
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
	 * @param evYr
	 */
	public void setEvYr(String evYr) {
		this.evYr = evYr;
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
		setSiScre(JSPUtil.getParameter(request, prefix + "si_scre", ""));
		setEgCtyCd(JSPUtil.getParameter(request, prefix + "eg_cty_cd", ""));
		setEgRhqCd(JSPUtil.getParameter(request, prefix + "eg_rhq_cd", ""));
		setTempIbflag(JSPUtil.getParameter(request, prefix + "temp_ibflag", ""));
		setDsScre(JSPUtil.getParameter(request, prefix + "ds_scre", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEgNm(JSPUtil.getParameter(request, prefix + "eg_nm", ""));
		setSiGrpNm(JSPUtil.getParameter(request, prefix + "si_grp_nm", ""));
		setEgIdSeq(JSPUtil.getParameter(request, prefix + "eg_id_seq", ""));
		setSiGrpCd(JSPUtil.getParameter(request, prefix + "si_grp_cd", ""));
		setEgId2(JSPUtil.getParameter(request, prefix + "eg_id2", ""));
		setBiScre(JSPUtil.getParameter(request, prefix + "bi_scre", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setSvcCateCd(JSPUtil.getParameter(request, prefix + "svc_cate_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEvaluationGroupStrategicImportanceManageListVO[]
	 */
	public SearchEvaluationGroupStrategicImportanceManageListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEvaluationGroupStrategicImportanceManageListVO[]
	 */
	public SearchEvaluationGroupStrategicImportanceManageListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEvaluationGroupStrategicImportanceManageListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] siScre = (JSPUtil.getParameter(request, prefix	+ "si_scre", length));
			String[] egCtyCd = (JSPUtil.getParameter(request, prefix	+ "eg_cty_cd", length));
			String[] egRhqCd = (JSPUtil.getParameter(request, prefix	+ "eg_rhq_cd", length));
			String[] tempIbflag = (JSPUtil.getParameter(request, prefix	+ "temp_ibflag", length));
			String[] dsScre = (JSPUtil.getParameter(request, prefix	+ "ds_scre", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] egNm = (JSPUtil.getParameter(request, prefix	+ "eg_nm", length));
			String[] siGrpNm = (JSPUtil.getParameter(request, prefix	+ "si_grp_nm", length));
			String[] egIdSeq = (JSPUtil.getParameter(request, prefix	+ "eg_id_seq", length));
			String[] siGrpCd = (JSPUtil.getParameter(request, prefix	+ "si_grp_cd", length));
			String[] egId2 = (JSPUtil.getParameter(request, prefix	+ "eg_id2", length));
			String[] biScre = (JSPUtil.getParameter(request, prefix	+ "bi_scre", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] svcCateCd = (JSPUtil.getParameter(request, prefix	+ "svc_cate_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEvaluationGroupStrategicImportanceManageListVO();
				if (siScre[i] != null)
					model.setSiScre(siScre[i]);
				if (egCtyCd[i] != null)
					model.setEgCtyCd(egCtyCd[i]);
				if (egRhqCd[i] != null)
					model.setEgRhqCd(egRhqCd[i]);
				if (tempIbflag[i] != null)
					model.setTempIbflag(tempIbflag[i]);
				if (dsScre[i] != null)
					model.setDsScre(dsScre[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (egNm[i] != null)
					model.setEgNm(egNm[i]);
				if (siGrpNm[i] != null)
					model.setSiGrpNm(siGrpNm[i]);
				if (egIdSeq[i] != null)
					model.setEgIdSeq(egIdSeq[i]);
				if (siGrpCd[i] != null)
					model.setSiGrpCd(siGrpCd[i]);
				if (egId2[i] != null)
					model.setEgId2(egId2[i]);
				if (biScre[i] != null)
					model.setBiScre(biScre[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (svcCateCd[i] != null)
					model.setSvcCateCd(svcCateCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEvaluationGroupStrategicImportanceManageListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEvaluationGroupStrategicImportanceManageListVO[]
	 */
	public SearchEvaluationGroupStrategicImportanceManageListVO[] getSearchEvaluationGroupStrategicImportanceManageListVOs(){
		SearchEvaluationGroupStrategicImportanceManageListVO[] vos = (SearchEvaluationGroupStrategicImportanceManageListVO[])models.toArray(new SearchEvaluationGroupStrategicImportanceManageListVO[models.size()]);
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
		this.siScre = this.siScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egCtyCd = this.egCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egRhqCd = this.egRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempIbflag = this.tempIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsScre = this.dsScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egNm = this.egNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siGrpNm = this.siGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egIdSeq = this.egIdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siGrpCd = this.siGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId2 = this.egId2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.biScre = this.biScre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateCd = this.svcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
