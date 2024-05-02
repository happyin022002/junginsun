/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesAudCfgVO.java
*@FileTitle : TesAudCfgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.14
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.07.14 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesAudCfgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesAudCfgVO> models = new ArrayList<TesAudCfgVO>();
	
	/* Column Info */
	private String costCalcMzdCd = null;
	/* Column Info */
	private String actVvdCalcCd = null;
	/* Column Info */
	private String spclCgoTpCalcCd = null;
	/* Column Info */
	private String stoPrdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tsFlg = null;
	/* Column Info */
	private String lgsCostSubjCd = null;
	/* Column Info */
	private String cntrStyCd = null;
	/* Column Info */
	private String expnMaxPrmtRto = null;
	/* Column Info */
	private String audOfcCd = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String expnAudTgtFlg = null;
	/* Column Info */
	private String tpszGrpFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String lgsCostFullNm = null;
	/* Column Info */
	private String audRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TesAudCfgVO() {}

	public TesAudCfgVO(String ibflag, String pagerows, String audOfcCd, String lgsCostSubjCd, String lgsCostCd, String lgsCostFullNm, String cntrStyCd, String costCalcMzdCd, String expnAudTgtFlg, String expnMaxPrmtRto, String tsFlg, String spclCgoTpCalcCd, String tpszGrpFlg, String actVvdCalcCd, String stoPrdCd, String audRmk, String updUsrId) {
		this.costCalcMzdCd = costCalcMzdCd;
		this.actVvdCalcCd = actVvdCalcCd;
		this.spclCgoTpCalcCd = spclCgoTpCalcCd;
		this.stoPrdCd = stoPrdCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.tsFlg = tsFlg;
		this.lgsCostSubjCd = lgsCostSubjCd;
		this.cntrStyCd = cntrStyCd;
		this.expnMaxPrmtRto = expnMaxPrmtRto;
		this.audOfcCd = audOfcCd;
		this.lgsCostCd = lgsCostCd;
		this.expnAudTgtFlg = expnAudTgtFlg;
		this.tpszGrpFlg = tpszGrpFlg;
		this.updUsrId = updUsrId;
		this.lgsCostFullNm = lgsCostFullNm;
		this.audRmk = audRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cost_calc_mzd_cd", getCostCalcMzdCd());
		this.hashColumns.put("act_vvd_calc_cd", getActVvdCalcCd());
		this.hashColumns.put("spcl_cgo_tp_calc_cd", getSpclCgoTpCalcCd());
		this.hashColumns.put("sto_prd_cd", getStoPrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts_flg", getTsFlg());
		this.hashColumns.put("lgs_cost_subj_cd", getLgsCostSubjCd());
		this.hashColumns.put("cntr_sty_cd", getCntrStyCd());
		this.hashColumns.put("expn_max_prmt_rto", getExpnMaxPrmtRto());
		this.hashColumns.put("aud_ofc_cd", getAudOfcCd());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("expn_aud_tgt_flg", getExpnAudTgtFlg());
		this.hashColumns.put("tpsz_grp_flg", getTpszGrpFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
		this.hashColumns.put("aud_rmk", getAudRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cost_calc_mzd_cd", "costCalcMzdCd");
		this.hashFields.put("act_vvd_calc_cd", "actVvdCalcCd");
		this.hashFields.put("spcl_cgo_tp_calc_cd", "spclCgoTpCalcCd");
		this.hashFields.put("sto_prd_cd", "stoPrdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts_flg", "tsFlg");
		this.hashFields.put("lgs_cost_subj_cd", "lgsCostSubjCd");
		this.hashFields.put("cntr_sty_cd", "cntrStyCd");
		this.hashFields.put("expn_max_prmt_rto", "expnMaxPrmtRto");
		this.hashFields.put("aud_ofc_cd", "audOfcCd");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("expn_aud_tgt_flg", "expnAudTgtFlg");
		this.hashFields.put("tpsz_grp_flg", "tpszGrpFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
		this.hashFields.put("aud_rmk", "audRmk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return costCalcMzdCd
	 */
	public String getCostCalcMzdCd() {
		return this.costCalcMzdCd;
	}
	
	/**
	 * Column Info
	 * @return actVvdCalcCd
	 */
	public String getActVvdCalcCd() {
		return this.actVvdCalcCd;
	}
	
	/**
	 * Column Info
	 * @return spclCgoTpCalcCd
	 */
	public String getSpclCgoTpCalcCd() {
		return this.spclCgoTpCalcCd;
	}
	
	/**
	 * Column Info
	 * @return stoPrdCd
	 */
	public String getStoPrdCd() {
		return this.stoPrdCd;
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
	 * @return tsFlg
	 */
	public String getTsFlg() {
		return this.tsFlg;
	}
	
	/**
	 * Column Info
	 * @return lgsCostSubjCd
	 */
	public String getLgsCostSubjCd() {
		return this.lgsCostSubjCd;
	}
	
	/**
	 * Column Info
	 * @return cntrStyCd
	 */
	public String getCntrStyCd() {
		return this.cntrStyCd;
	}
	
	/**
	 * Column Info
	 * @return expnMaxPrmtRto
	 */
	public String getExpnMaxPrmtRto() {
		return this.expnMaxPrmtRto;
	}
	
	/**
	 * Column Info
	 * @return audOfcCd
	 */
	public String getAudOfcCd() {
		return this.audOfcCd;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return expnAudTgtFlg
	 */
	public String getExpnAudTgtFlg() {
		return this.expnAudTgtFlg;
	}
	
	/**
	 * Column Info
	 * @return tpszGrpFlg
	 */
	public String getTpszGrpFlg() {
		return this.tpszGrpFlg;
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
	 * @return lgsCostFullNm
	 */
	public String getLgsCostFullNm() {
		return this.lgsCostFullNm;
	}
	
	/**
	 * Column Info
	 * @return audRmk
	 */
	public String getAudRmk() {
		return this.audRmk;
	}
	

	/**
	 * Column Info
	 * @param costCalcMzdCd
	 */
	public void setCostCalcMzdCd(String costCalcMzdCd) {
		this.costCalcMzdCd = costCalcMzdCd;
	}
	
	/**
	 * Column Info
	 * @param actVvdCalcCd
	 */
	public void setActVvdCalcCd(String actVvdCalcCd) {
		this.actVvdCalcCd = actVvdCalcCd;
	}
	
	/**
	 * Column Info
	 * @param spclCgoTpCalcCd
	 */
	public void setSpclCgoTpCalcCd(String spclCgoTpCalcCd) {
		this.spclCgoTpCalcCd = spclCgoTpCalcCd;
	}
	
	/**
	 * Column Info
	 * @param stoPrdCd
	 */
	public void setStoPrdCd(String stoPrdCd) {
		this.stoPrdCd = stoPrdCd;
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
	 * @param tsFlg
	 */
	public void setTsFlg(String tsFlg) {
		this.tsFlg = tsFlg;
	}
	
	/**
	 * Column Info
	 * @param lgsCostSubjCd
	 */
	public void setLgsCostSubjCd(String lgsCostSubjCd) {
		this.lgsCostSubjCd = lgsCostSubjCd;
	}
	
	/**
	 * Column Info
	 * @param cntrStyCd
	 */
	public void setCntrStyCd(String cntrStyCd) {
		this.cntrStyCd = cntrStyCd;
	}
	
	/**
	 * Column Info
	 * @param expnMaxPrmtRto
	 */
	public void setExpnMaxPrmtRto(String expnMaxPrmtRto) {
		this.expnMaxPrmtRto = expnMaxPrmtRto;
	}
	
	/**
	 * Column Info
	 * @param audOfcCd
	 */
	public void setAudOfcCd(String audOfcCd) {
		this.audOfcCd = audOfcCd;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param expnAudTgtFlg
	 */
	public void setExpnAudTgtFlg(String expnAudTgtFlg) {
		this.expnAudTgtFlg = expnAudTgtFlg;
	}
	
	/**
	 * Column Info
	 * @param tpszGrpFlg
	 */
	public void setTpszGrpFlg(String tpszGrpFlg) {
		this.tpszGrpFlg = tpszGrpFlg;
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
	 * @param lgsCostFullNm
	 */
	public void setLgsCostFullNm(String lgsCostFullNm) {
		this.lgsCostFullNm = lgsCostFullNm;
	}
	
	/**
	 * Column Info
	 * @param audRmk
	 */
	public void setAudRmk(String audRmk) {
		this.audRmk = audRmk;
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
		setCostCalcMzdCd(JSPUtil.getParameter(request, prefix + "cost_calc_mzd_cd", ""));
		setActVvdCalcCd(JSPUtil.getParameter(request, prefix + "act_vvd_calc_cd", ""));
		setSpclCgoTpCalcCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_tp_calc_cd", ""));
		setStoPrdCd(JSPUtil.getParameter(request, prefix + "sto_prd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTsFlg(JSPUtil.getParameter(request, prefix + "ts_flg", ""));
		setLgsCostSubjCd(JSPUtil.getParameter(request, prefix + "lgs_cost_subj_cd", ""));
		setCntrStyCd(JSPUtil.getParameter(request, prefix + "cntr_sty_cd", ""));
		setExpnMaxPrmtRto(JSPUtil.getParameter(request, prefix + "expn_max_prmt_rto", ""));
		setAudOfcCd(JSPUtil.getParameter(request, prefix + "aud_ofc_cd", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setExpnAudTgtFlg(JSPUtil.getParameter(request, prefix + "expn_aud_tgt_flg", ""));
		setTpszGrpFlg(JSPUtil.getParameter(request, prefix + "tpsz_grp_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setLgsCostFullNm(JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm", ""));
		setAudRmk(JSPUtil.getParameter(request, prefix + "aud_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesAudCfgVO[]
	 */
	public TesAudCfgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesAudCfgVO[]
	 */
	public TesAudCfgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesAudCfgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] costCalcMzdCd = (JSPUtil.getParameter(request, prefix	+ "cost_calc_mzd_cd", length));
			String[] actVvdCalcCd = (JSPUtil.getParameter(request, prefix	+ "act_vvd_calc_cd", length));
			String[] spclCgoTpCalcCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_tp_calc_cd", length));
			String[] stoPrdCd = (JSPUtil.getParameter(request, prefix	+ "sto_prd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tsFlg = (JSPUtil.getParameter(request, prefix	+ "ts_flg", length));
			String[] lgsCostSubjCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_subj_cd", length));
			String[] cntrStyCd = (JSPUtil.getParameter(request, prefix	+ "cntr_sty_cd", length));
			String[] expnMaxPrmtRto = (JSPUtil.getParameter(request, prefix	+ "expn_max_prmt_rto", length));
			String[] audOfcCd = (JSPUtil.getParameter(request, prefix	+ "aud_ofc_cd", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] expnAudTgtFlg = (JSPUtil.getParameter(request, prefix	+ "expn_aud_tgt_flg", length));
			String[] tpszGrpFlg = (JSPUtil.getParameter(request, prefix	+ "tpsz_grp_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_full_nm", length));
			String[] audRmk = (JSPUtil.getParameter(request, prefix	+ "aud_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesAudCfgVO();
				if (costCalcMzdCd[i] != null)
					model.setCostCalcMzdCd(costCalcMzdCd[i]);
				if (actVvdCalcCd[i] != null)
					model.setActVvdCalcCd(actVvdCalcCd[i]);
				if (spclCgoTpCalcCd[i] != null)
					model.setSpclCgoTpCalcCd(spclCgoTpCalcCd[i]);
				if (stoPrdCd[i] != null)
					model.setStoPrdCd(stoPrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tsFlg[i] != null)
					model.setTsFlg(tsFlg[i]);
				if (lgsCostSubjCd[i] != null)
					model.setLgsCostSubjCd(lgsCostSubjCd[i]);
				if (cntrStyCd[i] != null)
					model.setCntrStyCd(cntrStyCd[i]);
				if (expnMaxPrmtRto[i] != null)
					model.setExpnMaxPrmtRto(expnMaxPrmtRto[i]);
				if (audOfcCd[i] != null)
					model.setAudOfcCd(audOfcCd[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (expnAudTgtFlg[i] != null)
					model.setExpnAudTgtFlg(expnAudTgtFlg[i]);
				if (tpszGrpFlg[i] != null)
					model.setTpszGrpFlg(tpszGrpFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (lgsCostFullNm[i] != null)
					model.setLgsCostFullNm(lgsCostFullNm[i]);
				if (audRmk[i] != null)
					model.setAudRmk(audRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesAudCfgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesAudCfgVO[]
	 */
	public TesAudCfgVO[] getTesAudCfgVOs(){
		TesAudCfgVO[] vos = (TesAudCfgVO[])models.toArray(new TesAudCfgVO[models.size()]);
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
		this.costCalcMzdCd = this.costCalcMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actVvdCalcCd = this.actVvdCalcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoTpCalcCd = this.spclCgoTpCalcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoPrdCd = this.stoPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsFlg = this.tsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostSubjCd = this.lgsCostSubjCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStyCd = this.cntrStyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnMaxPrmtRto = this.expnMaxPrmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audOfcCd = this.audOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnAudTgtFlg = this.expnAudTgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszGrpFlg = this.tpszGrpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostFullNm = this.lgsCostFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audRmk = this.audRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
