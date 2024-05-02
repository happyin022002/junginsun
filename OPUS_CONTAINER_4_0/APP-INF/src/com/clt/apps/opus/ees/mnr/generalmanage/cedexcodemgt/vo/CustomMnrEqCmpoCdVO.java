/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMnrEqCmpoCdVO.java
*@FileTitle : CustomMnrEqCmpoCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.29
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.07.29 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrEqCmpoCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrEqCmpoCdVO> models = new ArrayList<CustomMnrEqCmpoCdVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String eqPrntCmpoCd = null;
	/* Column Info */
	private String cntrCmpoFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqCmpoNumIsoCd = null;
	/* Column Info */
	private String chssCmpoFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqCmpoNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String eqCmpoDesc = null;
	/* Column Info */
	private String mgstCmpoFlg = null;
	/* Column Info */
	private String eqCmpoGrpTpCd = null;
	/* Column Info */
	private String eqPrntCmpoGrpTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String eqCmpoCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrEqCmpoCdVO() {}

	public CustomMnrEqCmpoCdVO(String ibflag, String pagerows, String eqCmpoNm, String eqCmpoCd, String eqCmpoGrpTpCd, String updUsrId, String updDt, String creDt, String eqKndCd, String creUsrId, String eqCmpoNumIsoCd, String eqPrntCmpoGrpTpCd, String eqCmpoDesc, String eqPrntCmpoCd, String cntrCmpoFlg, String chssCmpoFlg, String mgstCmpoFlg) {
		this.updDt = updDt;
		this.eqPrntCmpoCd = eqPrntCmpoCd;
		this.cntrCmpoFlg = cntrCmpoFlg;
		this.creDt = creDt;
		this.eqKndCd = eqKndCd;
		this.eqCmpoNumIsoCd = eqCmpoNumIsoCd;
		this.chssCmpoFlg = chssCmpoFlg;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqCmpoNm = eqCmpoNm;
		this.creUsrId = creUsrId;
		this.eqCmpoDesc = eqCmpoDesc;
		this.mgstCmpoFlg = mgstCmpoFlg;
		this.eqCmpoGrpTpCd = eqCmpoGrpTpCd;
		this.eqPrntCmpoGrpTpCd = eqPrntCmpoGrpTpCd;
		this.updUsrId = updUsrId;
		this.eqCmpoCd = eqCmpoCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("eq_prnt_cmpo_cd", getEqPrntCmpoCd());
		this.hashColumns.put("cntr_cmpo_flg", getCntrCmpoFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_cmpo_num_iso_cd", getEqCmpoNumIsoCd());
		this.hashColumns.put("chss_cmpo_flg", getChssCmpoFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_cmpo_nm", getEqCmpoNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eq_cmpo_desc", getEqCmpoDesc());
		this.hashColumns.put("mgst_cmpo_flg", getMgstCmpoFlg());
		this.hashColumns.put("eq_cmpo_grp_tp_cd", getEqCmpoGrpTpCd());
		this.hashColumns.put("eq_prnt_cmpo_grp_tp_cd", getEqPrntCmpoGrpTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("eq_prnt_cmpo_cd", "eqPrntCmpoCd");
		this.hashFields.put("cntr_cmpo_flg", "cntrCmpoFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_cmpo_num_iso_cd", "eqCmpoNumIsoCd");
		this.hashFields.put("chss_cmpo_flg", "chssCmpoFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_cmpo_nm", "eqCmpoNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eq_cmpo_desc", "eqCmpoDesc");
		this.hashFields.put("mgst_cmpo_flg", "mgstCmpoFlg");
		this.hashFields.put("eq_cmpo_grp_tp_cd", "eqCmpoGrpTpCd");
		this.hashFields.put("eq_prnt_cmpo_grp_tp_cd", "eqPrntCmpoGrpTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
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
	 * @return eqPrntCmpoCd
	 */
	public String getEqPrntCmpoCd() {
		return this.eqPrntCmpoCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCmpoFlg
	 */
	public String getCntrCmpoFlg() {
		return this.cntrCmpoFlg;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoNumIsoCd
	 */
	public String getEqCmpoNumIsoCd() {
		return this.eqCmpoNumIsoCd;
	}
	
	/**
	 * Column Info
	 * @return chssCmpoFlg
	 */
	public String getChssCmpoFlg() {
		return this.chssCmpoFlg;
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
	 * @return eqCmpoNm
	 */
	public String getEqCmpoNm() {
		return this.eqCmpoNm;
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
	 * @return eqCmpoDesc
	 */
	public String getEqCmpoDesc() {
		return this.eqCmpoDesc;
	}
	
	/**
	 * Column Info
	 * @return mgstCmpoFlg
	 */
	public String getMgstCmpoFlg() {
		return this.mgstCmpoFlg;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoGrpTpCd
	 */
	public String getEqCmpoGrpTpCd() {
		return this.eqCmpoGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqPrntCmpoGrpTpCd
	 */
	public String getEqPrntCmpoGrpTpCd() {
		return this.eqPrntCmpoGrpTpCd;
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
	 * @return eqCmpoCd
	 */
	public String getEqCmpoCd() {
		return this.eqCmpoCd;
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
	 * @param eqPrntCmpoCd
	 */
	public void setEqPrntCmpoCd(String eqPrntCmpoCd) {
		this.eqPrntCmpoCd = eqPrntCmpoCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCmpoFlg
	 */
	public void setCntrCmpoFlg(String cntrCmpoFlg) {
		this.cntrCmpoFlg = cntrCmpoFlg;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoNumIsoCd
	 */
	public void setEqCmpoNumIsoCd(String eqCmpoNumIsoCd) {
		this.eqCmpoNumIsoCd = eqCmpoNumIsoCd;
	}
	
	/**
	 * Column Info
	 * @param chssCmpoFlg
	 */
	public void setChssCmpoFlg(String chssCmpoFlg) {
		this.chssCmpoFlg = chssCmpoFlg;
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
	 * @param eqCmpoNm
	 */
	public void setEqCmpoNm(String eqCmpoNm) {
		this.eqCmpoNm = eqCmpoNm;
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
	 * @param eqCmpoDesc
	 */
	public void setEqCmpoDesc(String eqCmpoDesc) {
		this.eqCmpoDesc = eqCmpoDesc;
	}
	
	/**
	 * Column Info
	 * @param mgstCmpoFlg
	 */
	public void setMgstCmpoFlg(String mgstCmpoFlg) {
		this.mgstCmpoFlg = mgstCmpoFlg;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoGrpTpCd
	 */
	public void setEqCmpoGrpTpCd(String eqCmpoGrpTpCd) {
		this.eqCmpoGrpTpCd = eqCmpoGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqPrntCmpoGrpTpCd
	 */
	public void setEqPrntCmpoGrpTpCd(String eqPrntCmpoGrpTpCd) {
		this.eqPrntCmpoGrpTpCd = eqPrntCmpoGrpTpCd;
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
	 * @param eqCmpoCd
	 */
	public void setEqCmpoCd(String eqCmpoCd) {
		this.eqCmpoCd = eqCmpoCd;
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
		setEqPrntCmpoCd(JSPUtil.getParameter(request, prefix + "eq_prnt_cmpo_cd", ""));
		setCntrCmpoFlg(JSPUtil.getParameter(request, prefix + "cntr_cmpo_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setEqCmpoNumIsoCd(JSPUtil.getParameter(request, prefix + "eq_cmpo_num_iso_cd", ""));
		setChssCmpoFlg(JSPUtil.getParameter(request, prefix + "chss_cmpo_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqCmpoNm(JSPUtil.getParameter(request, prefix + "eq_cmpo_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEqCmpoDesc(JSPUtil.getParameter(request, prefix + "eq_cmpo_desc", ""));
		setMgstCmpoFlg(JSPUtil.getParameter(request, prefix + "mgst_cmpo_flg", ""));
		setEqCmpoGrpTpCd(JSPUtil.getParameter(request, prefix + "eq_cmpo_grp_tp_cd", ""));
		setEqPrntCmpoGrpTpCd(JSPUtil.getParameter(request, prefix + "eq_prnt_cmpo_grp_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, prefix + "eq_cmpo_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrEqCmpoCdVO[]
	 */
	public CustomMnrEqCmpoCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrEqCmpoCdVO[]
	 */
	public CustomMnrEqCmpoCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrEqCmpoCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] eqPrntCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_prnt_cmpo_cd", length));
			String[] cntrCmpoFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_cmpo_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] eqCmpoNumIsoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_num_iso_cd", length));
			String[] chssCmpoFlg = (JSPUtil.getParameter(request, prefix	+ "chss_cmpo_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqCmpoNm = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] eqCmpoDesc = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_desc", length));
			String[] mgstCmpoFlg = (JSPUtil.getParameter(request, prefix	+ "mgst_cmpo_flg", length));
			String[] eqCmpoGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_grp_tp_cd", length));
			String[] eqPrntCmpoGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_prnt_cmpo_grp_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrEqCmpoCdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (eqPrntCmpoCd[i] != null)
					model.setEqPrntCmpoCd(eqPrntCmpoCd[i]);
				if (cntrCmpoFlg[i] != null)
					model.setCntrCmpoFlg(cntrCmpoFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqCmpoNumIsoCd[i] != null)
					model.setEqCmpoNumIsoCd(eqCmpoNumIsoCd[i]);
				if (chssCmpoFlg[i] != null)
					model.setChssCmpoFlg(chssCmpoFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqCmpoNm[i] != null)
					model.setEqCmpoNm(eqCmpoNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (eqCmpoDesc[i] != null)
					model.setEqCmpoDesc(eqCmpoDesc[i]);
				if (mgstCmpoFlg[i] != null)
					model.setMgstCmpoFlg(mgstCmpoFlg[i]);
				if (eqCmpoGrpTpCd[i] != null)
					model.setEqCmpoGrpTpCd(eqCmpoGrpTpCd[i]);
				if (eqPrntCmpoGrpTpCd[i] != null)
					model.setEqPrntCmpoGrpTpCd(eqPrntCmpoGrpTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrEqCmpoCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrEqCmpoCdVO[]
	 */
	public CustomMnrEqCmpoCdVO[] getCustomMnrEqCmpoCdVOs(){
		CustomMnrEqCmpoCdVO[] vos = (CustomMnrEqCmpoCdVO[])models.toArray(new CustomMnrEqCmpoCdVO[models.size()]);
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
		this.eqPrntCmpoCd = this.eqPrntCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCmpoFlg = this.cntrCmpoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoNumIsoCd = this.eqCmpoNumIsoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssCmpoFlg = this.chssCmpoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoNm = this.eqCmpoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoDesc = this.eqCmpoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstCmpoFlg = this.mgstCmpoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoGrpTpCd = this.eqCmpoGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqPrntCmpoGrpTpCd = this.eqPrntCmpoGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
