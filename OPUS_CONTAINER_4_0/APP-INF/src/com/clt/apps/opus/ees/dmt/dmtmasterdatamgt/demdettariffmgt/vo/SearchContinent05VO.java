/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchContinent05VO.java
*@FileTitle : SearchContinent05VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.12.29 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchContinent05VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchContinent05VO> models = new ArrayList<SearchContinent05VO>();
	
	/* Column Info */
	private String dmdtBzcTrfGrpNm = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ftDys = null;
	/* Column Info */
	private String orgDest = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String freeTime = null;
	/* Column Info */
	private String trfGrpSeq = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String covrg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchContinent05VO() {}

	public SearchContinent05VO(String ibflag, String pagerows, String dmdtTrfCd, String covrg, String orgDest, String trfGrpSeq, String dmdtBzcTrfGrpNm, String effDt, String expDt, String freeTime, String ftDys) {
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.ftDys = ftDys;
		this.orgDest = orgDest;
		this.expDt = expDt;
		this.freeTime = freeTime;
		this.trfGrpSeq = trfGrpSeq;
		this.dmdtTrfCd = dmdtTrfCd;
		this.covrg = covrg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dmdt_bzc_trf_grp_nm", getDmdtBzcTrfGrpNm());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ft_dys", getFtDys());
		this.hashColumns.put("org_dest", getOrgDest());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("free_time", getFreeTime());
		this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("covrg", getCovrg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dmdt_bzc_trf_grp_nm", "dmdtBzcTrfGrpNm");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("org_dest", "orgDest");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("free_time", "freeTime");
		this.hashFields.put("trf_grp_seq", "trfGrpSeq");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("covrg", "covrg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dmdtBzcTrfGrpNm
	 */
	public String getDmdtBzcTrfGrpNm() {
		return this.dmdtBzcTrfGrpNm;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return ftDys
	 */
	public String getFtDys() {
		return this.ftDys;
	}
	
	/**
	 * Column Info
	 * @return orgDest
	 */
	public String getOrgDest() {
		return this.orgDest;
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
	 * @return freeTime
	 */
	public String getFreeTime() {
		return this.freeTime;
	}
	
	/**
	 * Column Info
	 * @return trfGrpSeq
	 */
	public String getTrfGrpSeq() {
		return this.trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return covrg
	 */
	public String getCovrg() {
		return this.covrg;
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
	 * @param dmdtBzcTrfGrpNm
	 */
	public void setDmdtBzcTrfGrpNm(String dmdtBzcTrfGrpNm) {
		this.dmdtBzcTrfGrpNm = dmdtBzcTrfGrpNm;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param ftDys
	 */
	public void setFtDys(String ftDys) {
		this.ftDys = ftDys;
	}
	
	/**
	 * Column Info
	 * @param orgDest
	 */
	public void setOrgDest(String orgDest) {
		this.orgDest = orgDest;
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
	 * @param freeTime
	 */
	public void setFreeTime(String freeTime) {
		this.freeTime = freeTime;
	}
	
	/**
	 * Column Info
	 * @param trfGrpSeq
	 */
	public void setTrfGrpSeq(String trfGrpSeq) {
		this.trfGrpSeq = trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param covrg
	 */
	public void setCovrg(String covrg) {
		this.covrg = covrg;
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
		setDmdtBzcTrfGrpNm(JSPUtil.getParameter(request, "dmdt_bzc_trf_grp_nm", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFtDys(JSPUtil.getParameter(request, "ft_dys", ""));
		setOrgDest(JSPUtil.getParameter(request, "org_dest", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setFreeTime(JSPUtil.getParameter(request, "free_time", ""));
		setTrfGrpSeq(JSPUtil.getParameter(request, "trf_grp_seq", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setCovrg(JSPUtil.getParameter(request, "covrg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchContinent05VO[]
	 */
	public SearchContinent05VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchContinent05VO[]
	 */
	public SearchContinent05VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchContinent05VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dmdtBzcTrfGrpNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_bzc_trf_grp_nm", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ftDys = (JSPUtil.getParameter(request, prefix	+ "ft_dys", length));
			String[] orgDest = (JSPUtil.getParameter(request, prefix	+ "org_dest", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] freeTime = (JSPUtil.getParameter(request, prefix	+ "free_time", length));
			String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "trf_grp_seq", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] covrg = (JSPUtil.getParameter(request, prefix	+ "covrg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchContinent05VO();
				if (dmdtBzcTrfGrpNm[i] != null)
					model.setDmdtBzcTrfGrpNm(dmdtBzcTrfGrpNm[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ftDys[i] != null)
					model.setFtDys(ftDys[i]);
				if (orgDest[i] != null)
					model.setOrgDest(orgDest[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (freeTime[i] != null)
					model.setFreeTime(freeTime[i]);
				if (trfGrpSeq[i] != null)
					model.setTrfGrpSeq(trfGrpSeq[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (covrg[i] != null)
					model.setCovrg(covrg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchContinent05VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchContinent05VO[]
	 */
	public SearchContinent05VO[] getSearchContinent05VOs(){
		SearchContinent05VO[] vos = (SearchContinent05VO[])models.toArray(new SearchContinent05VO[models.size()]);
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
		this.dmdtBzcTrfGrpNm = this.dmdtBzcTrfGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys = this.ftDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDest = this.orgDest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeTime = this.freeTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfGrpSeq = this.trfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.covrg = this.covrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}