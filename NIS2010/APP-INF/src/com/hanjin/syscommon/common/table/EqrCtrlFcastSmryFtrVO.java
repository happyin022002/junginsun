/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EqrCtrlFcastSmryFtrVO.java
*@FileTitle : EqrCtrlFcastSmryFtrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.04  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EqrCtrlFcastSmryFtrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqrCtrlFcastSmryFtrVO> models = new ArrayList<EqrCtrlFcastSmryFtrVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String locGrpCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String srosShtgFtrFlg = null;
	/* Column Info */
	private String normShtgFtrFlg = null;
	/* Column Info */
	private String deltFtrFlg = null;
	/* Column Info */
	private String stkIcrzFtrFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String srosSplsFtrFlg = null;
	/* Column Info */
	private String normSplsFtrFlg = null;
	/* Column Info */
	private String balFtrFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String stkDcrzFtrFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EqrCtrlFcastSmryFtrVO() {}

	public EqrCtrlFcastSmryFtrVO(String ibflag, String pagerows, String rccCd, String stkIcrzFtrFlg, String stkDcrzFtrFlg, String srosSplsFtrFlg, String normSplsFtrFlg, String srosShtgFtrFlg, String normShtgFtrFlg, String deltFtrFlg, String creUsrId, String creDt, String updUsrId, String updDt, String locCd, String locGrpCd, String hulBndCd, String balFtrFlg) {
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.locGrpCd = locGrpCd;
		this.rccCd = rccCd;
		this.srosShtgFtrFlg = srosShtgFtrFlg;
		this.normShtgFtrFlg = normShtgFtrFlg;
		this.deltFtrFlg = deltFtrFlg;
		this.stkIcrzFtrFlg = stkIcrzFtrFlg;
		this.updUsrId = updUsrId;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.hulBndCd = hulBndCd;
		this.srosSplsFtrFlg = srosSplsFtrFlg;
		this.normSplsFtrFlg = normSplsFtrFlg;
		this.balFtrFlg = balFtrFlg;
		this.updDt = updDt;
		this.stkDcrzFtrFlg = stkDcrzFtrFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("loc_grp_cd", getLocGrpCd());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("sros_shtg_ftr_flg", getSrosShtgFtrFlg());
		this.hashColumns.put("norm_shtg_ftr_flg", getNormShtgFtrFlg());
		this.hashColumns.put("delt_ftr_flg", getDeltFtrFlg());
		this.hashColumns.put("stk_icrz_ftr_flg", getStkIcrzFtrFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("sros_spls_ftr_flg", getSrosSplsFtrFlg());
		this.hashColumns.put("norm_spls_ftr_flg", getNormSplsFtrFlg());
		this.hashColumns.put("bal_ftr_flg", getBalFtrFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("stk_dcrz_ftr_flg", getStkDcrzFtrFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("loc_grp_cd", "locGrpCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("sros_shtg_ftr_flg", "srosShtgFtrFlg");
		this.hashFields.put("norm_shtg_ftr_flg", "normShtgFtrFlg");
		this.hashFields.put("delt_ftr_flg", "deltFtrFlg");
		this.hashFields.put("stk_icrz_ftr_flg", "stkIcrzFtrFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("sros_spls_ftr_flg", "srosSplsFtrFlg");
		this.hashFields.put("norm_spls_ftr_flg", "normSplsFtrFlg");
		this.hashFields.put("bal_ftr_flg", "balFtrFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("stk_dcrz_ftr_flg", "stkDcrzFtrFlg");
		return this.hashFields;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return locGrpCd
	 */
	public String getLocGrpCd() {
		return this.locGrpCd;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return srosShtgFtrFlg
	 */
	public String getSrosShtgFtrFlg() {
		return this.srosShtgFtrFlg;
	}
	
	/**
	 * Column Info
	 * @return normShtgFtrFlg
	 */
	public String getNormShtgFtrFlg() {
		return this.normShtgFtrFlg;
	}
	
	/**
	 * Column Info
	 * @return deltFtrFlg
	 */
	public String getDeltFtrFlg() {
		return this.deltFtrFlg;
	}
	
	/**
	 * Column Info
	 * @return stkIcrzFtrFlg
	 */
	public String getStkIcrzFtrFlg() {
		return this.stkIcrzFtrFlg;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return srosSplsFtrFlg
	 */
	public String getSrosSplsFtrFlg() {
		return this.srosSplsFtrFlg;
	}
	
	/**
	 * Column Info
	 * @return normSplsFtrFlg
	 */
	public String getNormSplsFtrFlg() {
		return this.normSplsFtrFlg;
	}
	
	/**
	 * Column Info
	 * @return balFtrFlg
	 */
	public String getBalFtrFlg() {
		return this.balFtrFlg;
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
	 * @return stkDcrzFtrFlg
	 */
	public String getStkDcrzFtrFlg() {
		return this.stkDcrzFtrFlg;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param locGrpCd
	 */
	public void setLocGrpCd(String locGrpCd) {
		this.locGrpCd = locGrpCd;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param srosShtgFtrFlg
	 */
	public void setSrosShtgFtrFlg(String srosShtgFtrFlg) {
		this.srosShtgFtrFlg = srosShtgFtrFlg;
	}
	
	/**
	 * Column Info
	 * @param normShtgFtrFlg
	 */
	public void setNormShtgFtrFlg(String normShtgFtrFlg) {
		this.normShtgFtrFlg = normShtgFtrFlg;
	}
	
	/**
	 * Column Info
	 * @param deltFtrFlg
	 */
	public void setDeltFtrFlg(String deltFtrFlg) {
		this.deltFtrFlg = deltFtrFlg;
	}
	
	/**
	 * Column Info
	 * @param stkIcrzFtrFlg
	 */
	public void setStkIcrzFtrFlg(String stkIcrzFtrFlg) {
		this.stkIcrzFtrFlg = stkIcrzFtrFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param srosSplsFtrFlg
	 */
	public void setSrosSplsFtrFlg(String srosSplsFtrFlg) {
		this.srosSplsFtrFlg = srosSplsFtrFlg;
	}
	
	/**
	 * Column Info
	 * @param normSplsFtrFlg
	 */
	public void setNormSplsFtrFlg(String normSplsFtrFlg) {
		this.normSplsFtrFlg = normSplsFtrFlg;
	}
	
	/**
	 * Column Info
	 * @param balFtrFlg
	 */
	public void setBalFtrFlg(String balFtrFlg) {
		this.balFtrFlg = balFtrFlg;
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
	 * @param stkDcrzFtrFlg
	 */
	public void setStkDcrzFtrFlg(String stkDcrzFtrFlg) {
		this.stkDcrzFtrFlg = stkDcrzFtrFlg;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setLocGrpCd(JSPUtil.getParameter(request, prefix + "loc_grp_cd", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setSrosShtgFtrFlg(JSPUtil.getParameter(request, prefix + "sros_shtg_ftr_flg", ""));
		setNormShtgFtrFlg(JSPUtil.getParameter(request, prefix + "norm_shtg_ftr_flg", ""));
		setDeltFtrFlg(JSPUtil.getParameter(request, prefix + "delt_ftr_flg", ""));
		setStkIcrzFtrFlg(JSPUtil.getParameter(request, prefix + "stk_icrz_ftr_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setSrosSplsFtrFlg(JSPUtil.getParameter(request, prefix + "sros_spls_ftr_flg", ""));
		setNormSplsFtrFlg(JSPUtil.getParameter(request, prefix + "norm_spls_ftr_flg", ""));
		setBalFtrFlg(JSPUtil.getParameter(request, prefix + "bal_ftr_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setStkDcrzFtrFlg(JSPUtil.getParameter(request, prefix + "stk_dcrz_ftr_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqrCtrlFcastSmryFtrVO[]
	 */
	public EqrCtrlFcastSmryFtrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqrCtrlFcastSmryFtrVO[]
	 */
	public EqrCtrlFcastSmryFtrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqrCtrlFcastSmryFtrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] locGrpCd = (JSPUtil.getParameter(request, prefix	+ "loc_grp_cd", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] srosShtgFtrFlg = (JSPUtil.getParameter(request, prefix	+ "sros_shtg_ftr_flg", length));
			String[] normShtgFtrFlg = (JSPUtil.getParameter(request, prefix	+ "norm_shtg_ftr_flg", length));
			String[] deltFtrFlg = (JSPUtil.getParameter(request, prefix	+ "delt_ftr_flg", length));
			String[] stkIcrzFtrFlg = (JSPUtil.getParameter(request, prefix	+ "stk_icrz_ftr_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] srosSplsFtrFlg = (JSPUtil.getParameter(request, prefix	+ "sros_spls_ftr_flg", length));
			String[] normSplsFtrFlg = (JSPUtil.getParameter(request, prefix	+ "norm_spls_ftr_flg", length));
			String[] balFtrFlg = (JSPUtil.getParameter(request, prefix	+ "bal_ftr_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] stkDcrzFtrFlg = (JSPUtil.getParameter(request, prefix	+ "stk_dcrz_ftr_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqrCtrlFcastSmryFtrVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (locGrpCd[i] != null)
					model.setLocGrpCd(locGrpCd[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (srosShtgFtrFlg[i] != null)
					model.setSrosShtgFtrFlg(srosShtgFtrFlg[i]);
				if (normShtgFtrFlg[i] != null)
					model.setNormShtgFtrFlg(normShtgFtrFlg[i]);
				if (deltFtrFlg[i] != null)
					model.setDeltFtrFlg(deltFtrFlg[i]);
				if (stkIcrzFtrFlg[i] != null)
					model.setStkIcrzFtrFlg(stkIcrzFtrFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (srosSplsFtrFlg[i] != null)
					model.setSrosSplsFtrFlg(srosSplsFtrFlg[i]);
				if (normSplsFtrFlg[i] != null)
					model.setNormSplsFtrFlg(normSplsFtrFlg[i]);
				if (balFtrFlg[i] != null)
					model.setBalFtrFlg(balFtrFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (stkDcrzFtrFlg[i] != null)
					model.setStkDcrzFtrFlg(stkDcrzFtrFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqrCtrlFcastSmryFtrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqrCtrlFcastSmryFtrVO[]
	 */
	public EqrCtrlFcastSmryFtrVO[] getEqrCtrlFcastSmryFtrVOs(){
		EqrCtrlFcastSmryFtrVO[] vos = (EqrCtrlFcastSmryFtrVO[])models.toArray(new EqrCtrlFcastSmryFtrVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpCd = this.locGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srosShtgFtrFlg = this.srosShtgFtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.normShtgFtrFlg = this.normShtgFtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFtrFlg = this.deltFtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkIcrzFtrFlg = this.stkIcrzFtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srosSplsFtrFlg = this.srosSplsFtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.normSplsFtrFlg = this.normSplsFtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balFtrFlg = this.balFtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkDcrzFtrFlg = this.stkDcrzFtrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
