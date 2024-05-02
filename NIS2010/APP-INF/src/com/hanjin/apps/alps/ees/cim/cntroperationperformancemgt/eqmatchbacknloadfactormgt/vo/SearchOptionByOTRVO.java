/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchOptionByOTRVO.java
*@FileTitle : SearchOptionByOTRVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.29
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2011.03.29 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOptionByOTRVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOptionByOTRVO> models = new ArrayList<SearchOptionByOTRVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rfLvl = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntrTpszLvl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trdNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String socLvl = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOptionByOTRVO() {}

	public SearchOptionByOTRVO(String ibflag, String pagerows, String usrId, String cntrTpszLvl, String rfLvl, String trdNm, String socLvl, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.rfLvl = rfLvl;
		this.creUsrId = creUsrId;
		this.cntrTpszLvl = cntrTpszLvl;
		this.ibflag = ibflag;
		this.trdNm = trdNm;
		this.usrId = usrId;
		this.socLvl = socLvl;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rf_lvl", getRfLvl());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntr_tpsz_lvl", getCntrTpszLvl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trd_nm", getTrdNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("soc_lvl", getSocLvl());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rf_lvl", "rfLvl");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntr_tpsz_lvl", "cntrTpszLvl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trd_nm", "trdNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("soc_lvl", "socLvl");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return rfLvl
	 */
	public String getRfLvl() {
		return this.rfLvl;
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
	 * @return cntrTpszLvl
	 */
	public String getCntrTpszLvl() {
		return this.cntrTpszLvl;
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
	 * @return trdNm
	 */
	public String getTrdNm() {
		return this.trdNm;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return socLvl
	 */
	public String getSocLvl() {
		return this.socLvl;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rfLvl
	 */
	public void setRfLvl(String rfLvl) {
		this.rfLvl = rfLvl;
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
	 * @param cntrTpszLvl
	 */
	public void setCntrTpszLvl(String cntrTpszLvl) {
		this.cntrTpszLvl = cntrTpszLvl;
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
	 * @param trdNm
	 */
	public void setTrdNm(String trdNm) {
		this.trdNm = trdNm;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param socLvl
	 */
	public void setSocLvl(String socLvl) {
		this.socLvl = socLvl;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRfLvl(JSPUtil.getParameter(request, prefix + "rf_lvl", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCntrTpszLvl(JSPUtil.getParameter(request, prefix + "cntr_tpsz_lvl", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrdNm(JSPUtil.getParameter(request, prefix + "trd_nm", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSocLvl(JSPUtil.getParameter(request, prefix + "soc_lvl", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOptionByOTRVO[]
	 */
	public SearchOptionByOTRVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOptionByOTRVO[]
	 */
	public SearchOptionByOTRVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOptionByOTRVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rfLvl = (JSPUtil.getParameter(request, prefix	+ "rf_lvl", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntrTpszLvl = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_lvl", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trdNm = (JSPUtil.getParameter(request, prefix	+ "trd_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] socLvl = (JSPUtil.getParameter(request, prefix	+ "soc_lvl", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOptionByOTRVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rfLvl[i] != null)
					model.setRfLvl(rfLvl[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntrTpszLvl[i] != null)
					model.setCntrTpszLvl(cntrTpszLvl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trdNm[i] != null)
					model.setTrdNm(trdNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (socLvl[i] != null)
					model.setSocLvl(socLvl[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOptionByOTRVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOptionByOTRVO[]
	 */
	public SearchOptionByOTRVO[] getSearchOptionByOTRVOs(){
		SearchOptionByOTRVO[] vos = (SearchOptionByOTRVO[])models.toArray(new SearchOptionByOTRVO[models.size()]);
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
		this.rfLvl = this.rfLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszLvl = this.cntrTpszLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdNm = this.trdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socLvl = this.socLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
