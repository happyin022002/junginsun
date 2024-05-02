/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DmtTrfTpVO.java
*@FileTitle : DmtTrfTpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtTrfTpVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtTrfTpVO> models = new ArrayList<DmtTrfTpVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mgmtTrfDivCd = null;
	/* Column Info */
	private String dmdtCalcTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dmdtTrfDivCd = null;
	/* Column Info */
	private String dmdtTrfNm = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String mgmtCalcTpCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtTrfTpVO() {}

	public DmtTrfTpVO(String ibflag, String pagerows, String dmdtTrfCd, String dmdtTrfNm, String ioBndCd, String dmdtCalcTpCd, String dmdtTrfDivCd, String mgmtCalcTpCd, String mgmtTrfDivCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.mgmtTrfDivCd = mgmtTrfDivCd;
		this.dmdtCalcTpCd = dmdtCalcTpCd;
		this.creDt = creDt;
		this.dmdtTrfDivCd = dmdtTrfDivCd;
		this.dmdtTrfNm = dmdtTrfNm;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.mgmtCalcTpCd = mgmtCalcTpCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mgmt_trf_div_cd", getMgmtTrfDivCd());
		this.hashColumns.put("dmdt_calc_tp_cd", getDmdtCalcTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dmdt_trf_div_cd", getDmdtTrfDivCd());
		this.hashColumns.put("dmdt_trf_nm", getDmdtTrfNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("mgmt_calc_tp_cd", getMgmtCalcTpCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mgmt_trf_div_cd", "mgmtTrfDivCd");
		this.hashFields.put("dmdt_calc_tp_cd", "dmdtCalcTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dmdt_trf_div_cd", "dmdtTrfDivCd");
		this.hashFields.put("dmdt_trf_nm", "dmdtTrfNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mgmt_calc_tp_cd", "mgmtCalcTpCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
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
	 * @return mgmtTrfDivCd
	 */
	public String getMgmtTrfDivCd() {
		return this.mgmtTrfDivCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtCalcTpCd
	 */
	public String getDmdtCalcTpCd() {
		return this.dmdtCalcTpCd;
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
	 * @return dmdtTrfDivCd
	 */
	public String getDmdtTrfDivCd() {
		return this.dmdtTrfDivCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfNm
	 */
	public String getDmdtTrfNm() {
		return this.dmdtTrfNm;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return mgmtCalcTpCd
	 */
	public String getMgmtCalcTpCd() {
		return this.mgmtCalcTpCd;
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
	 * @param mgmtTrfDivCd
	 */
	public void setMgmtTrfDivCd(String mgmtTrfDivCd) {
		this.mgmtTrfDivCd = mgmtTrfDivCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtCalcTpCd
	 */
	public void setDmdtCalcTpCd(String dmdtCalcTpCd) {
		this.dmdtCalcTpCd = dmdtCalcTpCd;
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
	 * @param dmdtTrfDivCd
	 */
	public void setDmdtTrfDivCd(String dmdtTrfDivCd) {
		this.dmdtTrfDivCd = dmdtTrfDivCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfNm
	 */
	public void setDmdtTrfNm(String dmdtTrfNm) {
		this.dmdtTrfNm = dmdtTrfNm;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param mgmtCalcTpCd
	 */
	public void setMgmtCalcTpCd(String mgmtCalcTpCd) {
		this.mgmtCalcTpCd = mgmtCalcTpCd;
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
		setMgmtTrfDivCd(JSPUtil.getParameter(request, prefix + "mgmt_trf_div_cd", ""));
		setDmdtCalcTpCd(JSPUtil.getParameter(request, prefix + "dmdt_calc_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDmdtTrfDivCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_div_cd", ""));
		setDmdtTrfNm(JSPUtil.getParameter(request, prefix + "dmdt_trf_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setMgmtCalcTpCd(JSPUtil.getParameter(request, prefix + "mgmt_calc_tp_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtTrfTpVO[]
	 */
	public DmtTrfTpVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtTrfTpVO[]
	 */
	public DmtTrfTpVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtTrfTpVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mgmtTrfDivCd = (JSPUtil.getParameter(request, prefix	+ "mgmt_trf_div_cd", length));
			String[] dmdtCalcTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_calc_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dmdtTrfDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_div_cd", length));
			String[] dmdtTrfNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_nm", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] mgmtCalcTpCd = (JSPUtil.getParameter(request, prefix	+ "mgmt_calc_tp_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtTrfTpVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mgmtTrfDivCd[i] != null)
					model.setMgmtTrfDivCd(mgmtTrfDivCd[i]);
				if (dmdtCalcTpCd[i] != null)
					model.setDmdtCalcTpCd(dmdtCalcTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dmdtTrfDivCd[i] != null)
					model.setDmdtTrfDivCd(dmdtTrfDivCd[i]);
				if (dmdtTrfNm[i] != null)
					model.setDmdtTrfNm(dmdtTrfNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (mgmtCalcTpCd[i] != null)
					model.setMgmtCalcTpCd(mgmtCalcTpCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtTrfTpVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtTrfTpVO[]
	 */
	public DmtTrfTpVO[] getDmtTrfTpVOs(){
		DmtTrfTpVO[] vos = (DmtTrfTpVO[])models.toArray(new DmtTrfTpVO[models.size()]);
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
		this.mgmtTrfDivCd = this.mgmtTrfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCalcTpCd = this.dmdtCalcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfDivCd = this.dmdtTrfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfNm = this.dmdtTrfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgmtCalcTpCd = this.mgmtCalcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
