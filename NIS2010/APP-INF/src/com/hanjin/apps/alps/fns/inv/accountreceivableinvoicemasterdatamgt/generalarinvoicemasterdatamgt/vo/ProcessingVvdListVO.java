/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ProcessingVvdListVO.java
*@FileTitle : ProcessingVvdListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.12
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.05.12 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ProcessingVvdListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ProcessingVvdListVO> models = new ArrayList<ProcessingVvdListVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vstDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String estmBcDivCd = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String vedDt = null;
	/* Column Info */
	private String estmIocDivCd = null;
	/* Column Info */
	private String estmVvdTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ProcessingVvdListVO() {}

	public ProcessingVvdListVO(String ibflag, String pagerows, String exeYrmon, String revYrmon, String vvd, String estmVvdTpCd, String estmIocDivCd, String estmBcDivCd, String rlaneCd, String creDt, String vstDt, String vedDt) {
		this.vvd = vvd;
		this.vstDt = vstDt;
		this.ibflag = ibflag;
		this.estmBcDivCd = estmBcDivCd;
		this.revYrmon = revYrmon;
		this.exeYrmon = exeYrmon;
		this.creDt = creDt;
		this.rlaneCd = rlaneCd;
		this.vedDt = vedDt;
		this.estmIocDivCd = estmIocDivCd;
		this.estmVvdTpCd = estmVvdTpCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vst_dt", getVstDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("estm_bc_div_cd", getEstmBcDivCd());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ved_dt", getVedDt());
		this.hashColumns.put("estm_ioc_div_cd", getEstmIocDivCd());
		this.hashColumns.put("estm_vvd_tp_cd", getEstmVvdTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vst_dt", "vstDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("estm_bc_div_cd", "estmBcDivCd");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ved_dt", "vedDt");
		this.hashFields.put("estm_ioc_div_cd", "estmIocDivCd");
		this.hashFields.put("estm_vvd_tp_cd", "estmVvdTpCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return vstDt
	 */
	public String getVstDt() {
		return this.vstDt;
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
	 * @return estmBcDivCd
	 */
	public String getEstmBcDivCd() {
		return this.estmBcDivCd;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return vedDt
	 */
	public String getVedDt() {
		return this.vedDt;
	}
	
	/**
	 * Column Info
	 * @return estmIocDivCd
	 */
	public String getEstmIocDivCd() {
		return this.estmIocDivCd;
	}
	
	/**
	 * Column Info
	 * @return estmVvdTpCd
	 */
	public String getEstmVvdTpCd() {
		return this.estmVvdTpCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param vstDt
	 */
	public void setVstDt(String vstDt) {
		this.vstDt = vstDt;
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
	 * @param estmBcDivCd
	 */
	public void setEstmBcDivCd(String estmBcDivCd) {
		this.estmBcDivCd = estmBcDivCd;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param vedDt
	 */
	public void setVedDt(String vedDt) {
		this.vedDt = vedDt;
	}
	
	/**
	 * Column Info
	 * @param estmIocDivCd
	 */
	public void setEstmIocDivCd(String estmIocDivCd) {
		this.estmIocDivCd = estmIocDivCd;
	}
	
	/**
	 * Column Info
	 * @param estmVvdTpCd
	 */
	public void setEstmVvdTpCd(String estmVvdTpCd) {
		this.estmVvdTpCd = estmVvdTpCd;
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
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setVstDt(JSPUtil.getParameter(request, prefix + "vst_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEstmBcDivCd(JSPUtil.getParameter(request, prefix + "estm_bc_div_cd", ""));
		setRevYrmon(JSPUtil.getParameter(request, prefix + "rev_yrmon", ""));
		setExeYrmon(JSPUtil.getParameter(request, prefix + "exe_yrmon", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setVedDt(JSPUtil.getParameter(request, prefix + "ved_dt", ""));
		setEstmIocDivCd(JSPUtil.getParameter(request, prefix + "estm_ioc_div_cd", ""));
		setEstmVvdTpCd(JSPUtil.getParameter(request, prefix + "estm_vvd_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ProcessingVvdListVO[]
	 */
	public ProcessingVvdListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ProcessingVvdListVO[]
	 */
	public ProcessingVvdListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ProcessingVvdListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vstDt = (JSPUtil.getParameter(request, prefix	+ "vst_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] estmBcDivCd = (JSPUtil.getParameter(request, prefix	+ "estm_bc_div_cd", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] vedDt = (JSPUtil.getParameter(request, prefix	+ "ved_dt", length));
			String[] estmIocDivCd = (JSPUtil.getParameter(request, prefix	+ "estm_ioc_div_cd", length));
			String[] estmVvdTpCd = (JSPUtil.getParameter(request, prefix	+ "estm_vvd_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ProcessingVvdListVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vstDt[i] != null)
					model.setVstDt(vstDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (estmBcDivCd[i] != null)
					model.setEstmBcDivCd(estmBcDivCd[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (vedDt[i] != null)
					model.setVedDt(vedDt[i]);
				if (estmIocDivCd[i] != null)
					model.setEstmIocDivCd(estmIocDivCd[i]);
				if (estmVvdTpCd[i] != null)
					model.setEstmVvdTpCd(estmVvdTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getProcessingVvdListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ProcessingVvdListVO[]
	 */
	public ProcessingVvdListVO[] getProcessingVvdListVOs(){
		ProcessingVvdListVO[] vos = (ProcessingVvdListVO[])models.toArray(new ProcessingVvdListVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vstDt = this.vstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmBcDivCd = this.estmBcDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vedDt = this.vedDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmIocDivCd = this.estmIocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmVvdTpCd = this.estmVvdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
