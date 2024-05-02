/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchCostSetUpListVO.java
*@FileTitle : SearchCostSetUpListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.17  
* 1.0 Creation
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
=========================================================*/

package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo;

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

public class SearchCostSetUpListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCostSetUpListVO> models = new ArrayList<SearchCostSetUpListVO>();
	
	/* Column Info */
	private String aesOldAmt = null;
	/* Column Info */
	private String tpsOldAmt = null;
	/* Column Info */
	private String tasOldAmt = null;
	/* Column Info */
	private String tasAmt = null;
	/* Column Info */
	private String srt = null;
	/* Column Info */
	private String emsAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String emsOldAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String itmCd = null;
	/* Column Info */
	private String iasAmt = null;
	/* Column Info */
	private String comOldAmt = null;
	/* Column Info */
	private String aesAmt = null;
	/* Column Info */
	private String tpsAmt = null;
	/* Column Info */
	private String itmNm = null;
	/* Column Info */
	private String comAmt = null;
	/* Column Info */
	private String iasOldAmt = null;
	/* Column Info */
	private String ttlAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchCostSetUpListVO() {}

	public SearchCostSetUpListVO(String ibflag, String pagerows, String itmCd, String itmNm, String srt, String tpsAmt, String aesAmt, String tasAmt, String iasAmt, String emsAmt, String comAmt, String tpsOldAmt, String aesOldAmt, String tasOldAmt, String iasOldAmt, String emsOldAmt, String comOldAmt,String ttlAmt) {
		this.aesOldAmt = aesOldAmt;
		this.tpsOldAmt = tpsOldAmt;
		this.tasOldAmt = tasOldAmt;
		this.tasAmt = tasAmt;
		this.srt = srt;
		this.emsAmt = emsAmt;
		this.pagerows = pagerows;
		this.emsOldAmt = emsOldAmt;
		this.ibflag = ibflag;
		this.itmCd = itmCd;
		this.iasAmt = iasAmt;
		this.comOldAmt = comOldAmt;
		this.aesAmt = aesAmt;
		this.tpsAmt = tpsAmt;
		this.itmNm = itmNm;
		this.comAmt = comAmt;
		this.iasOldAmt = iasOldAmt;
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aes_old_amt", getAesOldAmt());
		this.hashColumns.put("tps_old_amt", getTpsOldAmt());
		this.hashColumns.put("tas_old_amt", getTasOldAmt());
		this.hashColumns.put("tas_amt", getTasAmt());
		this.hashColumns.put("srt", getSrt());
		this.hashColumns.put("ems_amt", getEmsAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ems_old_amt", getEmsOldAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("itm_cd", getItmCd());
		this.hashColumns.put("ias_amt", getIasAmt());
		this.hashColumns.put("com_old_amt", getComOldAmt());
		this.hashColumns.put("aes_amt", getAesAmt());
		this.hashColumns.put("tps_amt", getTpsAmt());
		this.hashColumns.put("itm_nm", getItmNm());
		this.hashColumns.put("com_amt", getComAmt());
		this.hashColumns.put("ias_old_amt", getIasOldAmt());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aes_old_amt", "aesOldAmt");
		this.hashFields.put("tps_old_amt", "tpsOldAmt");
		this.hashFields.put("tas_old_amt", "tasOldAmt");
		this.hashFields.put("tas_amt", "tasAmt");
		this.hashFields.put("srt", "srt");
		this.hashFields.put("ems_amt", "emsAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ems_old_amt", "emsOldAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("itm_cd", "itmCd");
		this.hashFields.put("ias_amt", "iasAmt");
		this.hashFields.put("com_old_amt", "comOldAmt");
		this.hashFields.put("aes_amt", "aesAmt");
		this.hashFields.put("tps_amt", "tpsAmt");
		this.hashFields.put("itm_nm", "itmNm");
		this.hashFields.put("com_amt", "comAmt");
		this.hashFields.put("ias_old_amt", "iasOldAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aesOldAmt
	 */
	public String getAesOldAmt() {
		return this.aesOldAmt;
	}
	
	/**
	 * Column Info
	 * @return tpsOldAmt
	 */
	public String getTpsOldAmt() {
		return this.tpsOldAmt;
	}
	
	/**
	 * Column Info
	 * @return tasOldAmt
	 */
	public String getTasOldAmt() {
		return this.tasOldAmt;
	}
	
	/**
	 * Column Info
	 * @return tasAmt
	 */
	public String getTasAmt() {
		return this.tasAmt;
	}
	
	/**
	 * Column Info
	 * @return srt
	 */
	public String getSrt() {
		return this.srt;
	}
	
	/**
	 * Column Info
	 * @return emsAmt
	 */
	public String getEmsAmt() {
		return this.emsAmt;
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
	 * @return emsOldAmt
	 */
	public String getEmsOldAmt() {
		return this.emsOldAmt;
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
	 * @return itmCd
	 */
	public String getItmCd() {
		return this.itmCd;
	}
	
	/**
	 * Column Info
	 * @return iasAmt
	 */
	public String getIasAmt() {
		return this.iasAmt;
	}
	
	/**
	 * Column Info
	 * @return comOldAmt
	 */
	public String getComOldAmt() {
		return this.comOldAmt;
	}
	
	/**
	 * Column Info
	 * @return aesAmt
	 */
	public String getAesAmt() {
		return this.aesAmt;
	}
	
	/**
	 * Column Info
	 * @return tpsAmt
	 */
	public String getTpsAmt() {
		return this.tpsAmt;
	}
	
	/**
	 * Column Info
	 * @return itmNm
	 */
	public String getItmNm() {
		return this.itmNm;
	}
	
	/**
	 * Column Info
	 * @return comAmt
	 */
	public String getComAmt() {
		return this.comAmt;
	}
	
	/**
	 * Column Info
	 * @return iasOldAmt
	 */
	public String getIasOldAmt() {
		return this.iasOldAmt;
	}
	
	/**
	 * Column Info
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}

	/**
	 * Column Info
	 * @param aesOldAmt
	 */
	public void setAesOldAmt(String aesOldAmt) {
		this.aesOldAmt = aesOldAmt;
	}
	
	/**
	 * Column Info
	 * @param tpsOldAmt
	 */
	public void setTpsOldAmt(String tpsOldAmt) {
		this.tpsOldAmt = tpsOldAmt;
	}
	
	/**
	 * Column Info
	 * @param tasOldAmt
	 */
	public void setTasOldAmt(String tasOldAmt) {
		this.tasOldAmt = tasOldAmt;
	}
	
	/**
	 * Column Info
	 * @param tasAmt
	 */
	public void setTasAmt(String tasAmt) {
		this.tasAmt = tasAmt;
	}
	
	/**
	 * Column Info
	 * @param srt
	 */
	public void setSrt(String srt) {
		this.srt = srt;
	}
	
	/**
	 * Column Info
	 * @param emsAmt
	 */
	public void setEmsAmt(String emsAmt) {
		this.emsAmt = emsAmt;
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
	 * @param emsOldAmt
	 */
	public void setEmsOldAmt(String emsOldAmt) {
		this.emsOldAmt = emsOldAmt;
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
	 * @param itmCd
	 */
	public void setItmCd(String itmCd) {
		this.itmCd = itmCd;
	}
	
	/**
	 * Column Info
	 * @param iasAmt
	 */
	public void setIasAmt(String iasAmt) {
		this.iasAmt = iasAmt;
	}
	
	/**
	 * Column Info
	 * @param comOldAmt
	 */
	public void setComOldAmt(String comOldAmt) {
		this.comOldAmt = comOldAmt;
	}
	
	/**
	 * Column Info
	 * @param aesAmt
	 */
	public void setAesAmt(String aesAmt) {
		this.aesAmt = aesAmt;
	}
	
	/**
	 * Column Info
	 * @param tpsAmt
	 */
	public void setTpsAmt(String tpsAmt) {
		this.tpsAmt = tpsAmt;
	}
	
	/**
	 * Column Info
	 * @param itmNm
	 */
	public void setItmNm(String itmNm) {
		this.itmNm = itmNm;
	}
	
	/**
	 * Column Info
	 * @param comAmt
	 */
	public void setComAmt(String comAmt) {
		this.comAmt = comAmt;
	}
	
	/**
	 * Column Info
	 * @param iasOldAmt
	 */
	public void setIasOldAmt(String iasOldAmt) {
		this.iasOldAmt = iasOldAmt;
	}
	
	/**
	 * Column Info
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
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
		setAesOldAmt(JSPUtil.getParameter(request, prefix + "aes_old_amt", ""));
		setTpsOldAmt(JSPUtil.getParameter(request, prefix + "tps_old_amt", ""));
		setTasOldAmt(JSPUtil.getParameter(request, prefix + "tas_old_amt", ""));
		setTasAmt(JSPUtil.getParameter(request, prefix + "tas_amt", ""));
		setSrt(JSPUtil.getParameter(request, prefix + "srt", ""));
		setEmsAmt(JSPUtil.getParameter(request, prefix + "ems_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEmsOldAmt(JSPUtil.getParameter(request, prefix + "ems_old_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setItmCd(JSPUtil.getParameter(request, prefix + "itm_cd", ""));
		setIasAmt(JSPUtil.getParameter(request, prefix + "ias_amt", ""));
		setComOldAmt(JSPUtil.getParameter(request, prefix + "com_old_amt", ""));
		setAesAmt(JSPUtil.getParameter(request, prefix + "aes_amt", ""));
		setTpsAmt(JSPUtil.getParameter(request, prefix + "tps_amt", ""));
		setItmNm(JSPUtil.getParameter(request, prefix + "itm_nm", ""));
		setComAmt(JSPUtil.getParameter(request, prefix + "com_amt", ""));
		setIasOldAmt(JSPUtil.getParameter(request, prefix + "ias_old_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCostSetUpListVO[]
	 */
	public SearchCostSetUpListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCostSetUpListVO[]
	 */
	public SearchCostSetUpListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCostSetUpListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aesOldAmt = (JSPUtil.getParameter(request, prefix	+ "aes_old_amt", length));
			String[] tpsOldAmt = (JSPUtil.getParameter(request, prefix	+ "tps_old_amt", length));
			String[] tasOldAmt = (JSPUtil.getParameter(request, prefix	+ "tas_old_amt", length));
			String[] tasAmt = (JSPUtil.getParameter(request, prefix	+ "tas_amt", length));
			String[] srt = (JSPUtil.getParameter(request, prefix	+ "srt", length));
			String[] emsAmt = (JSPUtil.getParameter(request, prefix	+ "ems_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] emsOldAmt = (JSPUtil.getParameter(request, prefix	+ "ems_old_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] itmCd = (JSPUtil.getParameter(request, prefix	+ "itm_cd", length));
			String[] iasAmt = (JSPUtil.getParameter(request, prefix	+ "ias_amt", length));
			String[] comOldAmt = (JSPUtil.getParameter(request, prefix	+ "com_old_amt", length));
			String[] aesAmt = (JSPUtil.getParameter(request, prefix	+ "aes_amt", length));
			String[] tpsAmt = (JSPUtil.getParameter(request, prefix	+ "tps_amt", length));
			String[] itmNm = (JSPUtil.getParameter(request, prefix	+ "itm_nm", length));
			String[] comAmt = (JSPUtil.getParameter(request, prefix	+ "com_amt", length));
			String[] iasOldAmt = (JSPUtil.getParameter(request, prefix	+ "ias_old_amt", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCostSetUpListVO();
				if (aesOldAmt[i] != null)
					model.setAesOldAmt(aesOldAmt[i]);
				if (tpsOldAmt[i] != null)
					model.setTpsOldAmt(tpsOldAmt[i]);
				if (tasOldAmt[i] != null)
					model.setTasOldAmt(tasOldAmt[i]);
				if (tasAmt[i] != null)
					model.setTasAmt(tasAmt[i]);
				if (srt[i] != null)
					model.setSrt(srt[i]);
				if (emsAmt[i] != null)
					model.setEmsAmt(emsAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (emsOldAmt[i] != null)
					model.setEmsOldAmt(emsOldAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (itmCd[i] != null)
					model.setItmCd(itmCd[i]);
				if (iasAmt[i] != null)
					model.setIasAmt(iasAmt[i]);
				if (comOldAmt[i] != null)
					model.setComOldAmt(comOldAmt[i]);
				if (aesAmt[i] != null)
					model.setAesAmt(aesAmt[i]);
				if (tpsAmt[i] != null)
					model.setTpsAmt(tpsAmt[i]);
				if (itmNm[i] != null)
					model.setItmNm(itmNm[i]);
				if (comAmt[i] != null)
					model.setComAmt(comAmt[i]);
				if (iasOldAmt[i] != null)
					model.setIasOldAmt(iasOldAmt[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCostSetUpListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCostSetUpListVO[]
	 */
	public SearchCostSetUpListVO[] getSearchCostSetUpListVOs(){
		SearchCostSetUpListVO[] vos = (SearchCostSetUpListVO[])models.toArray(new SearchCostSetUpListVO[models.size()]);
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
		this.aesOldAmt = this.aesOldAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsOldAmt = this.tpsOldAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tasOldAmt = this.tasOldAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tasAmt = this.tasAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srt = this.srt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsAmt = this.emsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsOldAmt = this.emsOldAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCd = this.itmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasAmt = this.iasAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comOldAmt = this.comOldAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aesAmt = this.aesAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsAmt = this.tpsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNm = this.itmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comAmt = this.comAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iasOldAmt = this.iasOldAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
