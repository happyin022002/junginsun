/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CoaLaneTsBsaCmmtVO.java
*@FileTitle : CoaLaneTsBsaCmmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.12.04 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CoaLaneTsBsaCmmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CoaLaneTsBsaCmmtVO> models = new ArrayList<CoaLaneTsBsaCmmtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String bsaCmmtRto = null;
	/* Column Info */
	private String toTrdCd = null;
	/* Column Info */
	private String bsaCmmtAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String toHulBndCd = null;
	/* Column Info */
	private String fmDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmTrdCd = null;
	/* Column Info */
	private String fmHulBndCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String fmRlaneCd = null;
	/* Column Info */
	private String fmIocCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CoaLaneTsBsaCmmtVO() {}

	public CoaLaneTsBsaCmmtVO(String ibflag, String pagerows, String costYrmon, String fmTrdCd, String fmRlaneCd, String fmIocCd, String fmDirCd, String toTrdCd, String bsaCmmtAmt, String creUsrId, String creDt, String updUsrId, String updDt, String fmHulBndCd, String toHulBndCd, String bsaCmmtRto) {
		this.updDt = updDt;
		this.bsaCmmtRto = bsaCmmtRto;
		this.toTrdCd = toTrdCd;
		this.bsaCmmtAmt = bsaCmmtAmt;
		this.creDt = creDt;
		this.toHulBndCd = toHulBndCd;
		this.fmDirCd = fmDirCd;
		this.pagerows = pagerows;
		this.fmTrdCd = fmTrdCd;
		this.fmHulBndCd = fmHulBndCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.costYrmon = costYrmon;
		this.fmRlaneCd = fmRlaneCd;
		this.fmIocCd = fmIocCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bsa_cmmt_rto", getBsaCmmtRto());
		this.hashColumns.put("to_trd_cd", getToTrdCd());
		this.hashColumns.put("bsa_cmmt_amt", getBsaCmmtAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("to_hul_bnd_cd", getToHulBndCd());
		this.hashColumns.put("fm_dir_cd", getFmDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_trd_cd", getFmTrdCd());
		this.hashColumns.put("fm_hul_bnd_cd", getFmHulBndCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("fm_rlane_cd", getFmRlaneCd());
		this.hashColumns.put("fm_ioc_cd", getFmIocCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bsa_cmmt_rto", "bsaCmmtRto");
		this.hashFields.put("to_trd_cd", "toTrdCd");
		this.hashFields.put("bsa_cmmt_amt", "bsaCmmtAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("to_hul_bnd_cd", "toHulBndCd");
		this.hashFields.put("fm_dir_cd", "fmDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_trd_cd", "fmTrdCd");
		this.hashFields.put("fm_hul_bnd_cd", "fmHulBndCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("fm_rlane_cd", "fmRlaneCd");
		this.hashFields.put("fm_ioc_cd", "fmIocCd");
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
	 * @return bsaCmmtRto
	 */
	public String getBsaCmmtRto() {
		return this.bsaCmmtRto;
	}
	
	/**
	 * Column Info
	 * @return toTrdCd
	 */
	public String getToTrdCd() {
		return this.toTrdCd;
	}
	
	/**
	 * Column Info
	 * @return bsaCmmtAmt
	 */
	public String getBsaCmmtAmt() {
		return this.bsaCmmtAmt;
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
	 * @return toHulBndCd
	 */
	public String getToHulBndCd() {
		return this.toHulBndCd;
	}
	
	/**
	 * Column Info
	 * @return fmDirCd
	 */
	public String getFmDirCd() {
		return this.fmDirCd;
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
	 * @return fmTrdCd
	 */
	public String getFmTrdCd() {
		return this.fmTrdCd;
	}
	
	/**
	 * Column Info
	 * @return fmHulBndCd
	 */
	public String getFmHulBndCd() {
		return this.fmHulBndCd;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return fmRlaneCd
	 */
	public String getFmRlaneCd() {
		return this.fmRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return fmIocCd
	 */
	public String getFmIocCd() {
		return this.fmIocCd;
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
	 * @param bsaCmmtRto
	 */
	public void setBsaCmmtRto(String bsaCmmtRto) {
		this.bsaCmmtRto = bsaCmmtRto;
	}
	
	/**
	 * Column Info
	 * @param toTrdCd
	 */
	public void setToTrdCd(String toTrdCd) {
		this.toTrdCd = toTrdCd;
	}
	
	/**
	 * Column Info
	 * @param bsaCmmtAmt
	 */
	public void setBsaCmmtAmt(String bsaCmmtAmt) {
		this.bsaCmmtAmt = bsaCmmtAmt;
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
	 * @param toHulBndCd
	 */
	public void setToHulBndCd(String toHulBndCd) {
		this.toHulBndCd = toHulBndCd;
	}
	
	/**
	 * Column Info
	 * @param fmDirCd
	 */
	public void setFmDirCd(String fmDirCd) {
		this.fmDirCd = fmDirCd;
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
	 * @param fmTrdCd
	 */
	public void setFmTrdCd(String fmTrdCd) {
		this.fmTrdCd = fmTrdCd;
	}
	
	/**
	 * Column Info
	 * @param fmHulBndCd
	 */
	public void setFmHulBndCd(String fmHulBndCd) {
		this.fmHulBndCd = fmHulBndCd;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param fmRlaneCd
	 */
	public void setFmRlaneCd(String fmRlaneCd) {
		this.fmRlaneCd = fmRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param fmIocCd
	 */
	public void setFmIocCd(String fmIocCd) {
		this.fmIocCd = fmIocCd;
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
		setBsaCmmtRto(JSPUtil.getParameter(request, prefix + "bsa_cmmt_rto", ""));
		setToTrdCd(JSPUtil.getParameter(request, prefix + "to_trd_cd", ""));
		setBsaCmmtAmt(JSPUtil.getParameter(request, prefix + "bsa_cmmt_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setToHulBndCd(JSPUtil.getParameter(request, prefix + "to_hul_bnd_cd", ""));
		setFmDirCd(JSPUtil.getParameter(request, prefix + "fm_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFmTrdCd(JSPUtil.getParameter(request, prefix + "fm_trd_cd", ""));
		setFmHulBndCd(JSPUtil.getParameter(request, prefix + "fm_hul_bnd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setFmRlaneCd(JSPUtil.getParameter(request, prefix + "fm_rlane_cd", ""));
		setFmIocCd(JSPUtil.getParameter(request, prefix + "fm_ioc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CoaLaneTsBsaCmmtVO[]
	 */
	public CoaLaneTsBsaCmmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CoaLaneTsBsaCmmtVO[]
	 */
	public CoaLaneTsBsaCmmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CoaLaneTsBsaCmmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] bsaCmmtRto = (JSPUtil.getParameter(request, prefix	+ "bsa_cmmt_rto", length));
			String[] toTrdCd = (JSPUtil.getParameter(request, prefix	+ "to_trd_cd", length));
			String[] bsaCmmtAmt = (JSPUtil.getParameter(request, prefix	+ "bsa_cmmt_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] toHulBndCd = (JSPUtil.getParameter(request, prefix	+ "to_hul_bnd_cd", length));
			String[] fmDirCd = (JSPUtil.getParameter(request, prefix	+ "fm_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmTrdCd = (JSPUtil.getParameter(request, prefix	+ "fm_trd_cd", length));
			String[] fmHulBndCd = (JSPUtil.getParameter(request, prefix	+ "fm_hul_bnd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] fmRlaneCd = (JSPUtil.getParameter(request, prefix	+ "fm_rlane_cd", length));
			String[] fmIocCd = (JSPUtil.getParameter(request, prefix	+ "fm_ioc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CoaLaneTsBsaCmmtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (bsaCmmtRto[i] != null)
					model.setBsaCmmtRto(bsaCmmtRto[i]);
				if (toTrdCd[i] != null)
					model.setToTrdCd(toTrdCd[i]);
				if (bsaCmmtAmt[i] != null)
					model.setBsaCmmtAmt(bsaCmmtAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (toHulBndCd[i] != null)
					model.setToHulBndCd(toHulBndCd[i]);
				if (fmDirCd[i] != null)
					model.setFmDirCd(fmDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmTrdCd[i] != null)
					model.setFmTrdCd(fmTrdCd[i]);
				if (fmHulBndCd[i] != null)
					model.setFmHulBndCd(fmHulBndCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (fmRlaneCd[i] != null)
					model.setFmRlaneCd(fmRlaneCd[i]);
				if (fmIocCd[i] != null)
					model.setFmIocCd(fmIocCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCoaLaneTsBsaCmmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CoaLaneTsBsaCmmtVO[]
	 */
	public CoaLaneTsBsaCmmtVO[] getCoaLaneTsBsaCmmtVOs(){
		CoaLaneTsBsaCmmtVO[] vos = (CoaLaneTsBsaCmmtVO[])models.toArray(new CoaLaneTsBsaCmmtVO[models.size()]);
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
		this.bsaCmmtRto = this.bsaCmmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTrdCd = this.toTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCmmtAmt = this.bsaCmmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toHulBndCd = this.toHulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDirCd = this.fmDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTrdCd = this.fmTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmHulBndCd = this.fmHulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRlaneCd = this.fmRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmIocCd = this.fmIocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
