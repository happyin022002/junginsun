/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EqrCtrlFcastSmryVO.java
*@FileTitle : EqrCtrlFcastSmryVO
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

public class EqrCtrlFcastSmryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EqrCtrlFcastSmryVO> models = new ArrayList<EqrCtrlFcastSmryVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String normSplsFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String stkDcrzFlg = null;
	/* Column Info */
	private String srosShtgFlg = null;
	/* Column Info */
	private String locGrpCd = null;
	/* Column Info */
	private String stkIcrzFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String inpYrwk = null;
	/* Column Info */
	private String balFlg = null;
	/* Column Info */
	private String srosSplsFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String normShtgFlg = null;
	/* Column Info */
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EqrCtrlFcastSmryVO() {}

	public EqrCtrlFcastSmryVO(String ibflag, String pagerows, String inpYrwk, String locGrpCd, String locCd, String cntrTpszCd, String stkIcrzFlg, String stkDcrzFlg, String srosSplsFlg, String normSplsFlg, String srosShtgFlg, String normShtgFlg, String creUsrId, String creDt, String updUsrId, String updDt, String balFlg) {
		this.pagerows = pagerows;
		this.normSplsFlg = normSplsFlg;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.stkDcrzFlg = stkDcrzFlg;
		this.srosShtgFlg = srosShtgFlg;
		this.locGrpCd = locGrpCd;
		this.stkIcrzFlg = stkIcrzFlg;
		this.updUsrId = updUsrId;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.inpYrwk = inpYrwk;
		this.balFlg = balFlg;
		this.srosSplsFlg = srosSplsFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.normShtgFlg = normShtgFlg;
		this.updDt = updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("norm_spls_flg", getNormSplsFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("stk_dcrz_flg", getStkDcrzFlg());
		this.hashColumns.put("sros_shtg_flg", getSrosShtgFlg());
		this.hashColumns.put("loc_grp_cd", getLocGrpCd());
		this.hashColumns.put("stk_icrz_flg", getStkIcrzFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("inp_yrwk", getInpYrwk());
		this.hashColumns.put("bal_flg", getBalFlg());
		this.hashColumns.put("sros_spls_flg", getSrosSplsFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("norm_shtg_flg", getNormShtgFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("norm_spls_flg", "normSplsFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("stk_dcrz_flg", "stkDcrzFlg");
		this.hashFields.put("sros_shtg_flg", "srosShtgFlg");
		this.hashFields.put("loc_grp_cd", "locGrpCd");
		this.hashFields.put("stk_icrz_flg", "stkIcrzFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inp_yrwk", "inpYrwk");
		this.hashFields.put("bal_flg", "balFlg");
		this.hashFields.put("sros_spls_flg", "srosSplsFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("norm_shtg_flg", "normShtgFlg");
		this.hashFields.put("upd_dt", "updDt");
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
	 * Column Info
	 * @return normSplsFlg
	 */
	public String getNormSplsFlg() {
		return this.normSplsFlg;
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
	 * @return stkDcrzFlg
	 */
	public String getStkDcrzFlg() {
		return this.stkDcrzFlg;
	}
	
	/**
	 * Column Info
	 * @return srosShtgFlg
	 */
	public String getSrosShtgFlg() {
		return this.srosShtgFlg;
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
	 * @return stkIcrzFlg
	 */
	public String getStkIcrzFlg() {
		return this.stkIcrzFlg;
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
	 * @return inpYrwk
	 */
	public String getInpYrwk() {
		return this.inpYrwk;
	}
	
	/**
	 * Column Info
	 * @return balFlg
	 */
	public String getBalFlg() {
		return this.balFlg;
	}
	
	/**
	 * Column Info
	 * @return srosSplsFlg
	 */
	public String getSrosSplsFlg() {
		return this.srosSplsFlg;
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
	 * @return normShtgFlg
	 */
	public String getNormShtgFlg() {
		return this.normShtgFlg;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @param normSplsFlg
	 */
	public void setNormSplsFlg(String normSplsFlg) {
		this.normSplsFlg = normSplsFlg;
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
	 * @param stkDcrzFlg
	 */
	public void setStkDcrzFlg(String stkDcrzFlg) {
		this.stkDcrzFlg = stkDcrzFlg;
	}
	
	/**
	 * Column Info
	 * @param srosShtgFlg
	 */
	public void setSrosShtgFlg(String srosShtgFlg) {
		this.srosShtgFlg = srosShtgFlg;
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
	 * @param stkIcrzFlg
	 */
	public void setStkIcrzFlg(String stkIcrzFlg) {
		this.stkIcrzFlg = stkIcrzFlg;
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
	 * @param inpYrwk
	 */
	public void setInpYrwk(String inpYrwk) {
		this.inpYrwk = inpYrwk;
	}
	
	/**
	 * Column Info
	 * @param balFlg
	 */
	public void setBalFlg(String balFlg) {
		this.balFlg = balFlg;
	}
	
	/**
	 * Column Info
	 * @param srosSplsFlg
	 */
	public void setSrosSplsFlg(String srosSplsFlg) {
		this.srosSplsFlg = srosSplsFlg;
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
	 * @param normShtgFlg
	 */
	public void setNormShtgFlg(String normShtgFlg) {
		this.normShtgFlg = normShtgFlg;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
		setNormSplsFlg(JSPUtil.getParameter(request, prefix + "norm_spls_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setStkDcrzFlg(JSPUtil.getParameter(request, prefix + "stk_dcrz_flg", ""));
		setSrosShtgFlg(JSPUtil.getParameter(request, prefix + "sros_shtg_flg", ""));
		setLocGrpCd(JSPUtil.getParameter(request, prefix + "loc_grp_cd", ""));
		setStkIcrzFlg(JSPUtil.getParameter(request, prefix + "stk_icrz_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setInpYrwk(JSPUtil.getParameter(request, prefix + "inp_yrwk", ""));
		setBalFlg(JSPUtil.getParameter(request, prefix + "bal_flg", ""));
		setSrosSplsFlg(JSPUtil.getParameter(request, prefix + "sros_spls_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setNormShtgFlg(JSPUtil.getParameter(request, prefix + "norm_shtg_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EqrCtrlFcastSmryVO[]
	 */
	public EqrCtrlFcastSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EqrCtrlFcastSmryVO[]
	 */
	public EqrCtrlFcastSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EqrCtrlFcastSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] normSplsFlg = (JSPUtil.getParameter(request, prefix	+ "norm_spls_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] stkDcrzFlg = (JSPUtil.getParameter(request, prefix	+ "stk_dcrz_flg", length));
			String[] srosShtgFlg = (JSPUtil.getParameter(request, prefix	+ "sros_shtg_flg", length));
			String[] locGrpCd = (JSPUtil.getParameter(request, prefix	+ "loc_grp_cd", length));
			String[] stkIcrzFlg = (JSPUtil.getParameter(request, prefix	+ "stk_icrz_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] inpYrwk = (JSPUtil.getParameter(request, prefix	+ "inp_yrwk", length));
			String[] balFlg = (JSPUtil.getParameter(request, prefix	+ "bal_flg", length));
			String[] srosSplsFlg = (JSPUtil.getParameter(request, prefix	+ "sros_spls_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] normShtgFlg = (JSPUtil.getParameter(request, prefix	+ "norm_shtg_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new EqrCtrlFcastSmryVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (normSplsFlg[i] != null)
					model.setNormSplsFlg(normSplsFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (stkDcrzFlg[i] != null)
					model.setStkDcrzFlg(stkDcrzFlg[i]);
				if (srosShtgFlg[i] != null)
					model.setSrosShtgFlg(srosShtgFlg[i]);
				if (locGrpCd[i] != null)
					model.setLocGrpCd(locGrpCd[i]);
				if (stkIcrzFlg[i] != null)
					model.setStkIcrzFlg(stkIcrzFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (inpYrwk[i] != null)
					model.setInpYrwk(inpYrwk[i]);
				if (balFlg[i] != null)
					model.setBalFlg(balFlg[i]);
				if (srosSplsFlg[i] != null)
					model.setSrosSplsFlg(srosSplsFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (normShtgFlg[i] != null)
					model.setNormShtgFlg(normShtgFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEqrCtrlFcastSmryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EqrCtrlFcastSmryVO[]
	 */
	public EqrCtrlFcastSmryVO[] getEqrCtrlFcastSmryVOs(){
		EqrCtrlFcastSmryVO[] vos = (EqrCtrlFcastSmryVO[])models.toArray(new EqrCtrlFcastSmryVO[models.size()]);
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
		this.normSplsFlg = this.normSplsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkDcrzFlg = this.stkDcrzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srosShtgFlg = this.srosShtgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locGrpCd = this.locGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkIcrzFlg = this.stkIcrzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpYrwk = this.inpYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balFlg = this.balFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srosSplsFlg = this.srosSplsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.normShtgFlg = this.normShtgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
