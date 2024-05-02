/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SimAgnRateDetailSubVO.java
*@FileTitle : SimAgnRateDetailSubVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.06.05 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SimAgnRateDetailSubVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SimAgnRateDetailSubVO> models = new ArrayList<SimAgnRateDetailSubVO>();
	
	/* Column Info */
	private String routLvlCd = null;
	/* Column Info */
	private String routRefDivCd = null;
	/* Column Info */
	private String agnAgmtChgSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String agnAgmtCntrSeq = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnAgmtNo = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String agnAgmtSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String routInfoCd = null;
	/* Column Info */
	private String chgDivCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String agnAgmtRoutSeq = null;
	/* Column Info */
	private String acTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SimAgnRateDetailSubVO() {}

	public SimAgnRateDetailSubVO(String ibflag, String pagerows, String agnCd, String agnAgmtNo, String ioBndCd, String acTpCd, String agnAgmtSeq, String agnAgmtCntrSeq, String cntrTpszCd, String agnAgmtRoutSeq, String routRefDivCd, String routLvlCd, String routInfoCd, String agnAgmtChgSeq, String chgDivCd, String chgCd, String usrId) {
		this.routLvlCd = routLvlCd;
		this.routRefDivCd = routRefDivCd;
		this.agnAgmtChgSeq = agnAgmtChgSeq;
		this.ioBndCd = ioBndCd;
		this.agnAgmtCntrSeq = agnAgmtCntrSeq;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.agnAgmtNo = agnAgmtNo;
		this.agnCd = agnCd;
		this.agnAgmtSeq = agnAgmtSeq;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.routInfoCd = routInfoCd;
		this.chgDivCd = chgDivCd;
		this.cntrTpszCd = cntrTpszCd;
		this.agnAgmtRoutSeq = agnAgmtRoutSeq;
		this.acTpCd = acTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rout_lvl_cd", getRoutLvlCd());
		this.hashColumns.put("rout_ref_div_cd", getRoutRefDivCd());
		this.hashColumns.put("agn_agmt_chg_seq", getAgnAgmtChgSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("agn_agmt_cntr_seq", getAgnAgmtCntrSeq());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("agn_agmt_seq", getAgnAgmtSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("rout_info_cd", getRoutInfoCd());
		this.hashColumns.put("chg_div_cd", getChgDivCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("agn_agmt_rout_seq", getAgnAgmtRoutSeq());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rout_lvl_cd", "routLvlCd");
		this.hashFields.put("rout_ref_div_cd", "routRefDivCd");
		this.hashFields.put("agn_agmt_chg_seq", "agnAgmtChgSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("agn_agmt_cntr_seq", "agnAgmtCntrSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("agn_agmt_seq", "agnAgmtSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rout_info_cd", "routInfoCd");
		this.hashFields.put("chg_div_cd", "chgDivCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agn_agmt_rout_seq", "agnAgmtRoutSeq");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return routLvlCd
	 */
	public String getRoutLvlCd() {
		return this.routLvlCd;
	}
	
	/**
	 * Column Info
	 * @return routRefDivCd
	 */
	public String getRoutRefDivCd() {
		return this.routRefDivCd;
	}
	
	/**
	 * Column Info
	 * @return agnAgmtChgSeq
	 */
	public String getAgnAgmtChgSeq() {
		return this.agnAgmtChgSeq;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return agnAgmtCntrSeq
	 */
	public String getAgnAgmtCntrSeq() {
		return this.agnAgmtCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return agnAgmtNo
	 */
	public String getAgnAgmtNo() {
		return this.agnAgmtNo;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}
	
	/**
	 * Column Info
	 * @return agnAgmtSeq
	 */
	public String getAgnAgmtSeq() {
		return this.agnAgmtSeq;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return routInfoCd
	 */
	public String getRoutInfoCd() {
		return this.routInfoCd;
	}
	
	/**
	 * Column Info
	 * @return chgDivCd
	 */
	public String getChgDivCd() {
		return this.chgDivCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return agnAgmtRoutSeq
	 */
	public String getAgnAgmtRoutSeq() {
		return this.agnAgmtRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return acTpCd
	 */
	public String getAcTpCd() {
		return this.acTpCd;
	}
	

	/**
	 * Column Info
	 * @param routLvlCd
	 */
	public void setRoutLvlCd(String routLvlCd) {
		this.routLvlCd = routLvlCd;
	}
	
	/**
	 * Column Info
	 * @param routRefDivCd
	 */
	public void setRoutRefDivCd(String routRefDivCd) {
		this.routRefDivCd = routRefDivCd;
	}
	
	/**
	 * Column Info
	 * @param agnAgmtChgSeq
	 */
	public void setAgnAgmtChgSeq(String agnAgmtChgSeq) {
		this.agnAgmtChgSeq = agnAgmtChgSeq;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param agnAgmtCntrSeq
	 */
	public void setAgnAgmtCntrSeq(String agnAgmtCntrSeq) {
		this.agnAgmtCntrSeq = agnAgmtCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param agnAgmtNo
	 */
	public void setAgnAgmtNo(String agnAgmtNo) {
		this.agnAgmtNo = agnAgmtNo;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}
	
	/**
	 * Column Info
	 * @param agnAgmtSeq
	 */
	public void setAgnAgmtSeq(String agnAgmtSeq) {
		this.agnAgmtSeq = agnAgmtSeq;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param routInfoCd
	 */
	public void setRoutInfoCd(String routInfoCd) {
		this.routInfoCd = routInfoCd;
	}
	
	/**
	 * Column Info
	 * @param chgDivCd
	 */
	public void setChgDivCd(String chgDivCd) {
		this.chgDivCd = chgDivCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param agnAgmtRoutSeq
	 */
	public void setAgnAgmtRoutSeq(String agnAgmtRoutSeq) {
		this.agnAgmtRoutSeq = agnAgmtRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param acTpCd
	 */
	public void setAcTpCd(String acTpCd) {
		this.acTpCd = acTpCd;
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
		setRoutLvlCd(JSPUtil.getParameter(request, prefix + "rout_lvl_cd", ""));
		setRoutRefDivCd(JSPUtil.getParameter(request, prefix + "rout_ref_div_cd", ""));
		setAgnAgmtChgSeq(JSPUtil.getParameter(request, prefix + "agn_agmt_chg_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setAgnAgmtCntrSeq(JSPUtil.getParameter(request, prefix + "agn_agmt_cntr_seq", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request, prefix + "agn_agmt_no", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setAgnAgmtSeq(JSPUtil.getParameter(request, prefix + "agn_agmt_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setRoutInfoCd(JSPUtil.getParameter(request, prefix + "rout_info_cd", ""));
		setChgDivCd(JSPUtil.getParameter(request, prefix + "chg_div_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setAgnAgmtRoutSeq(JSPUtil.getParameter(request, prefix + "agn_agmt_rout_seq", ""));
		setAcTpCd(JSPUtil.getParameter(request, prefix + "ac_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SimAgnRateDetailSubVO[]
	 */
	public SimAgnRateDetailSubVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SimAgnRateDetailSubVO[]
	 */
	public SimAgnRateDetailSubVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SimAgnRateDetailSubVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] routLvlCd = (JSPUtil.getParameter(request, prefix	+ "rout_lvl_cd", length));
			String[] routRefDivCd = (JSPUtil.getParameter(request, prefix	+ "rout_ref_div_cd", length));
			String[] agnAgmtChgSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_chg_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] agnAgmtCntrSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_cntr_seq", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnAgmtNo = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_no", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] agnAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] routInfoCd = (JSPUtil.getParameter(request, prefix	+ "rout_info_cd", length));
			String[] chgDivCd = (JSPUtil.getParameter(request, prefix	+ "chg_div_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] agnAgmtRoutSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_rout_seq", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SimAgnRateDetailSubVO();
				if (routLvlCd[i] != null)
					model.setRoutLvlCd(routLvlCd[i]);
				if (routRefDivCd[i] != null)
					model.setRoutRefDivCd(routRefDivCd[i]);
				if (agnAgmtChgSeq[i] != null)
					model.setAgnAgmtChgSeq(agnAgmtChgSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (agnAgmtCntrSeq[i] != null)
					model.setAgnAgmtCntrSeq(agnAgmtCntrSeq[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnAgmtNo[i] != null)
					model.setAgnAgmtNo(agnAgmtNo[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (agnAgmtSeq[i] != null)
					model.setAgnAgmtSeq(agnAgmtSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (routInfoCd[i] != null)
					model.setRoutInfoCd(routInfoCd[i]);
				if (chgDivCd[i] != null)
					model.setChgDivCd(chgDivCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (agnAgmtRoutSeq[i] != null)
					model.setAgnAgmtRoutSeq(agnAgmtRoutSeq[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSimAgnRateDetailSubVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SimAgnRateDetailSubVO[]
	 */
	public SimAgnRateDetailSubVO[] getSimAgnRateDetailSubVOs(){
		SimAgnRateDetailSubVO[] vos = (SimAgnRateDetailSubVO[])models.toArray(new SimAgnRateDetailSubVO[models.size()]);
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
		this.routLvlCd = this.routLvlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routRefDivCd = this.routRefDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtChgSeq = this.agnAgmtChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtCntrSeq = this.agnAgmtCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo = this.agnAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtSeq = this.agnAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routInfoCd = this.routInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDivCd = this.chgDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtRoutSeq = this.agnAgmtRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
