/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchEGKpiTargetConditionVO.java
*@FileTitle : SearchEGKpiTargetConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.vo;

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
public class SearchEGKpiTargetConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEGKpiTargetConditionVO> models = new ArrayList<SearchEGKpiTargetConditionVO>();
	
	/* Column Info */
	private String tmp2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tmp1 = null;
	/* Column Info */
	private String egCtyCd = null;
	/* Column Info */
	private String egIdSeq = null;
	/* Column Info */
	private String egRhqCd = null;
	/* Column Info */
	private String mapped = null;
	/* Column Info */
	private String evYr = null;
	/* Column Info */
	private String egId = null;
	/* Column Info */
	private String svcCateCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchEGKpiTargetConditionVO() {}

	public SearchEGKpiTargetConditionVO(String ibflag, String pagerows, String egId, String egIdSeq, String egRhqCd, String evYr, String egCtyCd, String svcCateCd, String mapped, String tmp1, String tmp2) {
		this.tmp2 = tmp2;
		this.ibflag = ibflag;
		this.tmp1 = tmp1;
		this.egCtyCd = egCtyCd;
		this.egIdSeq = egIdSeq;
		this.egRhqCd = egRhqCd;
		this.mapped = mapped;
		this.evYr = evYr;
		this.egId = egId;
		this.svcCateCd = svcCateCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tmp2", getTmp2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tmp1", getTmp1());
		this.hashColumns.put("eg_cty_cd", getEgCtyCd());
		this.hashColumns.put("eg_id_seq", getEgIdSeq());
		this.hashColumns.put("eg_rhq_cd", getEgRhqCd());
		this.hashColumns.put("mapped", getMapped());
		this.hashColumns.put("ev_yr", getEvYr());
		this.hashColumns.put("eg_id", getEgId());
		this.hashColumns.put("svc_cate_cd", getSvcCateCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tmp2", "tmp2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tmp1", "tmp1");
		this.hashFields.put("eg_cty_cd", "egCtyCd");
		this.hashFields.put("eg_id_seq", "egIdSeq");
		this.hashFields.put("eg_rhq_cd", "egRhqCd");
		this.hashFields.put("mapped", "mapped");
		this.hashFields.put("ev_yr", "evYr");
		this.hashFields.put("eg_id", "egId");
		this.hashFields.put("svc_cate_cd", "svcCateCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tmp2
	 */
	public String getTmp2() {
		return this.tmp2;
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
	 * @return tmp1
	 */
	public String getTmp1() {
		return this.tmp1;
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
	 * @return egIdSeq
	 */
	public String getEgIdSeq() {
		return this.egIdSeq;
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
	 * @return mapped
	 */
	public String getMapped() {
		return this.mapped;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * Column Info
	 * @param tmp2
	 */
	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
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
	 * @param tmp1
	 */
	public void setTmp1(String tmp1) {
		this.tmp1 = tmp1;
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
	 * @param egIdSeq
	 */
	public void setEgIdSeq(String egIdSeq) {
		this.egIdSeq = egIdSeq;
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
	 * @param mapped
	 */
	public void setMapped(String mapped) {
		this.mapped = mapped;
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
		setTmp2(JSPUtil.getParameter(request, prefix + "tmp2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTmp1(JSPUtil.getParameter(request, prefix + "tmp1", ""));
		setEgCtyCd(JSPUtil.getParameter(request, prefix + "eg_cty_cd", ""));
		setEgIdSeq(JSPUtil.getParameter(request, prefix + "eg_id_seq", ""));
		setEgRhqCd(JSPUtil.getParameter(request, prefix + "eg_rhq_cd", ""));
		setMapped(JSPUtil.getParameter(request, prefix + "mapped", ""));
		setEvYr(JSPUtil.getParameter(request, prefix + "ev_yr", ""));
		setEgId(JSPUtil.getParameter(request, prefix + "eg_id", ""));
		setSvcCateCd(JSPUtil.getParameter(request, prefix + "svc_cate_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEGKpiTargetConditionVO[]
	 */
	public SearchEGKpiTargetConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEGKpiTargetConditionVO[]
	 */
	public SearchEGKpiTargetConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEGKpiTargetConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tmp2 = (JSPUtil.getParameter(request, prefix	+ "tmp2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp1", length));
			String[] egCtyCd = (JSPUtil.getParameter(request, prefix	+ "eg_cty_cd", length));
			String[] egIdSeq = (JSPUtil.getParameter(request, prefix	+ "eg_id_seq", length));
			String[] egRhqCd = (JSPUtil.getParameter(request, prefix	+ "eg_rhq_cd", length));
			String[] mapped = (JSPUtil.getParameter(request, prefix	+ "mapped", length));
			String[] evYr = (JSPUtil.getParameter(request, prefix	+ "ev_yr", length));
			String[] egId = (JSPUtil.getParameter(request, prefix	+ "eg_id", length));
			String[] svcCateCd = (JSPUtil.getParameter(request, prefix	+ "svc_cate_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEGKpiTargetConditionVO();
				if (tmp2[i] != null)
					model.setTmp2(tmp2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tmp1[i] != null)
					model.setTmp1(tmp1[i]);
				if (egCtyCd[i] != null)
					model.setEgCtyCd(egCtyCd[i]);
				if (egIdSeq[i] != null)
					model.setEgIdSeq(egIdSeq[i]);
				if (egRhqCd[i] != null)
					model.setEgRhqCd(egRhqCd[i]);
				if (mapped[i] != null)
					model.setMapped(mapped[i]);
				if (evYr[i] != null)
					model.setEvYr(evYr[i]);
				if (egId[i] != null)
					model.setEgId(egId[i]);
				if (svcCateCd[i] != null)
					model.setSvcCateCd(svcCateCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEGKpiTargetConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEGKpiTargetConditionVO[]
	 */
	public SearchEGKpiTargetConditionVO[] getSearchEGKpiTargetConditionVOs(){
		SearchEGKpiTargetConditionVO[] vos = (SearchEGKpiTargetConditionVO[])models.toArray(new SearchEGKpiTargetConditionVO[models.size()]);
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
		this.tmp2 = this.tmp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp1 = this.tmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egCtyCd = this.egCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egIdSeq = this.egIdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egRhqCd = this.egRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapped = this.mapped .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evYr = this.evYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.egId = this.egId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCateCd = this.svcCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
