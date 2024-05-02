/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EdiJbSkdVO.java
*@FileTitle : EdiJbSkdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.11.30 장창수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo;

import java.lang.reflect.Field;
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
 * @author 장창수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EdiJbSkdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdiJbSkdVO> models = new ArrayList<EdiJbSkdVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String batItmNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String batId = null;
	
	private String custTrdPrnrId = null;
	
	/* Column Info */
	private String jbStatus = null;
	/* Column Info */
	private String jbId = null;
	/* Column Info */
	private String updChk = null;
	/* Column Info */
	private String jbEndDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String jbStDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String jbFmYrmon = null;
	/* Column Info */
	private String jbToYrmon = null;	
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EdiJbSkdVO() {}

	public EdiJbSkdVO(String ibflag, String pagerows, String updDt, String fromDt, String batItmNm, String creDt, String batId, String custTrdPrnrId, String jbStatus, String jbId, String jbEndDt, String toDt, String jbStDt, String effDt, String creUsrId, String jbFmYrmon, String jbToYrmon, String updUsrId, String updChk) {
		this.updDt = updDt;
		this.fromDt = fromDt;
		this.batItmNm = batItmNm;
		this.creDt = creDt;
		this.batId = batId;
		this.custTrdPrnrId = custTrdPrnrId;
		this.jbStatus = jbStatus;
		this.jbId = jbId;
		this.updChk = updChk;
		this.jbEndDt = jbEndDt;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.jbStDt = jbStDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.jbFmYrmon = jbFmYrmon;
		this.jbToYrmon = jbToYrmon;		
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("bat_itm_nm", getBatItmNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bat_id", getBatId());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("jb_status", getJbStatus());
		this.hashColumns.put("jb_id", getJbId());
		this.hashColumns.put("upd_chk", getUpdChk());
		this.hashColumns.put("jb_end_dt", getJbEndDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("jb_st_dt", getJbStDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("jb_fm_yrmon", getJbFmYrmon());
		this.hashColumns.put("jb_to_yrmon", getJbToYrmon());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("bat_itm_nm", "batItmNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bat_id", "batId");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("jb_status", "jbStatus");
		this.hashFields.put("jb_id", "jbId");
		this.hashFields.put("upd_chk", "updChk");
		this.hashFields.put("jb_end_dt", "jbEndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("jb_st_dt", "jbStDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("jb_fm_yrmon", "jbFmYrmon");
		this.hashFields.put("jb_to_yrmon", "jbToYrmon");
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
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return batItmNm
	 */
	public String getBatItmNm() {
		return this.batItmNm;
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
	 * @return batId
	 */
	public String getBatId() {
		return this.batId;
	}
	
	public String getCustTrdPrnrId() {
		return this.custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return jbStatus
	 */
	public String getJbStatus() {
		return this.jbStatus;
	}
	
	/**
	 * Column Info
	 * @return jbId
	 */
	public String getJbId() {
		return this.jbId;
	}
	
	/**
	 * Column Info
	 * @return updChk
	 */
	public String getUpdChk() {
		return this.updChk;
	}
	
	/**
	 * Column Info
	 * @return jbEndDt
	 */
	public String getJbEndDt() {
		return this.jbEndDt;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return jbStDt
	 */
	public String getJbStDt() {
		return this.jbStDt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return jbFmYrmon
	 */
	public String getJbFmYrmon() {
		return this.jbFmYrmon;
	}
	/**
	 * Column Info
	 * @return jbToYrmon
	 */
	public String getJbToYrmon() {
		return this.jbToYrmon;
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
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param batItmNm
	 */
	public void setBatItmNm(String batItmNm) {
		this.batItmNm = batItmNm;
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
	 * @param batId
	 */
	public void setBatId(String batId) {
		this.batId = batId;
	}
	
	public void setCustTrdPrnrId(String custTrdPrnrId) {
		this.custTrdPrnrId = custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param jbStatus
	 */
	public void setJbStatus(String jbStatus) {
		this.jbStatus = jbStatus;
	}
	
	/**
	 * Column Info
	 * @param jbId
	 */
	public void setJbId(String jbId) {
		this.jbId = jbId;
	}
	
	/**
	 * Column Info
	 * @param updChk
	 */
	public void setUpdChk(String updChk) {
		this.updChk = updChk;
	}
	
	/**
	 * Column Info
	 * @param jbEndDt
	 */
	public void setJbEndDt(String jbEndDt) {
		this.jbEndDt = jbEndDt;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param jbStDt
	 */
	public void setJbStDt(String jbStDt) {
		this.jbStDt = jbStDt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param jbFmYrmon
	 */
	public void setJbFmYrmon(String jbFmYrmon) {
		this.jbFmYrmon = jbFmYrmon;
	}
	
	/**
	 * Column Info
	 * @param jbYrmon
	 */
	public void setJbToYrmon(String jbToYrmon) {
		this.jbToYrmon = jbToYrmon;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setBatItmNm(JSPUtil.getParameter(request, "bat_itm_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBatId(JSPUtil.getParameter(request, "bat_id", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, "cust_trd_prnr_id", ""));
		setJbStatus(JSPUtil.getParameter(request, "jb_status", ""));
		setJbId(JSPUtil.getParameter(request, "jb_id", ""));
		setUpdChk(JSPUtil.getParameter(request, "upd_chk", ""));
		setJbEndDt(JSPUtil.getParameter(request, "jb_end_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setJbStDt(JSPUtil.getParameter(request, "jb_st_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setJbFmYrmon(JSPUtil.getParameter(request, "jb_fm_yrmon", ""));
		setJbToYrmon(JSPUtil.getParameter(request, "jb_to_yrmon", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdiJbSkdVO[]
	 */
	public EdiJbSkdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdiJbSkdVO[]
	 */
	public EdiJbSkdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdiJbSkdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] batItmNm = (JSPUtil.getParameter(request, prefix	+ "bat_itm_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] batId = (JSPUtil.getParameter(request, prefix	+ "bat_id", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] jbStatus = (JSPUtil.getParameter(request, prefix	+ "jb_status", length));
			String[] jbId = (JSPUtil.getParameter(request, prefix	+ "jb_id", length));
			String[] updChk = (JSPUtil.getParameter(request, prefix	+ "upd_chk", length));
			String[] jbEndDt = (JSPUtil.getParameter(request, prefix	+ "jb_end_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] jbStDt = (JSPUtil.getParameter(request, prefix	+ "jb_st_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] jbFmYrmon = (JSPUtil.getParameter(request, prefix	+ "jb_fm_yrmon", length));
			String[] jbToYrmon = (JSPUtil.getParameter(request, prefix	+ "jb_to_yrmon", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdiJbSkdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (batItmNm[i] != null)
					model.setBatItmNm(batItmNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (batId[i] != null)
					model.setBatId(batId[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (jbStatus[i] != null)
					model.setJbStatus(jbStatus[i]);
				if (jbId[i] != null)
					model.setJbId(jbId[i]);
				if (updChk[i] != null)
					model.setUpdChk(updChk[i]);
				if (jbEndDt[i] != null)
					model.setJbEndDt(jbEndDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (jbStDt[i] != null)
					model.setJbStDt(jbStDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (jbFmYrmon[i] != null)
					model.setJbFmYrmon(jbFmYrmon[i]);
				if (jbToYrmon[i] != null)
					model.setJbToYrmon(jbToYrmon[i]);				
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdiJbSkdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdiJbSkdVO[]
	 */
	public EdiJbSkdVO[] getEdiJbSkdVOs(){
		EdiJbSkdVO[] vos = (EdiJbSkdVO[])models.toArray(new EdiJbSkdVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batItmNm = this.batItmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batId = this.batId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbStatus = this.jbStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbId = this.jbId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updChk = this.updChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbEndDt = this.jbEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbStDt = this.jbStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbFmYrmon = this.jbFmYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jbToYrmon = this.jbToYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
