/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TesEdiRcvRuleVndrMgmtVO.java
*@FileTitle : TesEdiRcvRuleVndrMgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesEdiRcvRuleVndrMgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesEdiRcvRuleVndrMgmtVO> models = new ArrayList<TesEdiRcvRuleVndrMgmtVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String invOfcMdmRefFlg = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String implSubTpCd = null;
	/* Column Info */
	private String vndrTrfRefFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ediRmk = null;
	/* Column Info */
	private String implTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ediVndrSeq = null;
	/* Column Info */
	private String implMnTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costOfcMdmRefFlg = null;
	/* Column Info */
	private String stoPrdDtChkFlg = null;
	/* Column Info */
	private String parsMzdCd = null;
	/* Column Info */
	private String ediRcvRuleMnSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesEdiRcvRuleVndrMgmtVO() {}

	public TesEdiRcvRuleVndrMgmtVO(String ibflag, String pagerows, String ediRcvRuleMnSeq, String ediVndrSeq, String invOfcCd, String invOfcMdmRefFlg, String costOfcCd, String costOfcMdmRefFlg, String implMnTpCd, String implTpCd, String implSubTpCd, String parsMzdCd, String ediRmk, String creUsrId, String creDt, String updUsrId, String updDt, String vndrTrfRefFlg, String stoPrdDtChkFlg) {
		this.updDt = updDt;
		this.invOfcMdmRefFlg = invOfcMdmRefFlg;
		this.costOfcCd = costOfcCd;
		this.implSubTpCd = implSubTpCd;
		this.vndrTrfRefFlg = vndrTrfRefFlg;
		this.creDt = creDt;
		this.ediRmk = ediRmk;
		this.implTpCd = implTpCd;
		this.pagerows = pagerows;
		this.ediVndrSeq = ediVndrSeq;
		this.implMnTpCd = implMnTpCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.costOfcMdmRefFlg = costOfcMdmRefFlg;
		this.stoPrdDtChkFlg = stoPrdDtChkFlg;
		this.parsMzdCd = parsMzdCd;
		this.ediRcvRuleMnSeq = ediRcvRuleMnSeq;
		this.updUsrId = updUsrId;
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inv_ofc_mdm_ref_flg", getInvOfcMdmRefFlg());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("impl_sub_tp_cd", getImplSubTpCd());
		this.hashColumns.put("vndr_trf_ref_flg", getVndrTrfRefFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("edi_rmk", getEdiRmk());
		this.hashColumns.put("impl_tp_cd", getImplTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("edi_vndr_seq", getEdiVndrSeq());
		this.hashColumns.put("impl_mn_tp_cd", getImplMnTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_ofc_mdm_ref_flg", getCostOfcMdmRefFlg());
		this.hashColumns.put("sto_prd_dt_chk_flg", getStoPrdDtChkFlg());
		this.hashColumns.put("pars_mzd_cd", getParsMzdCd());
		this.hashColumns.put("edi_rcv_rule_mn_seq", getEdiRcvRuleMnSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_ofc_mdm_ref_flg", "invOfcMdmRefFlg");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("impl_sub_tp_cd", "implSubTpCd");
		this.hashFields.put("vndr_trf_ref_flg", "vndrTrfRefFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("edi_rmk", "ediRmk");
		this.hashFields.put("impl_tp_cd", "implTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("edi_vndr_seq", "ediVndrSeq");
		this.hashFields.put("impl_mn_tp_cd", "implMnTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_ofc_mdm_ref_flg", "costOfcMdmRefFlg");
		this.hashFields.put("sto_prd_dt_chk_flg", "stoPrdDtChkFlg");
		this.hashFields.put("pars_mzd_cd", "parsMzdCd");
		this.hashFields.put("edi_rcv_rule_mn_seq", "ediRcvRuleMnSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
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
	 * @return invOfcMdmRefFlg
	 */
	public String getInvOfcMdmRefFlg() {
		return this.invOfcMdmRefFlg;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
	}
	
	/**
	 * Column Info
	 * @return implSubTpCd
	 */
	public String getImplSubTpCd() {
		return this.implSubTpCd;
	}
	
	/**
	 * Column Info
	 * @return vndrTrfRefFlg
	 */
	public String getVndrTrfRefFlg() {
		return this.vndrTrfRefFlg;
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
	 * @return ediRmk
	 */
	public String getEdiRmk() {
		return this.ediRmk;
	}
	
	/**
	 * Column Info
	 * @return implTpCd
	 */
	public String getImplTpCd() {
		return this.implTpCd;
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
	 * @return ediVndrSeq
	 */
	public String getEdiVndrSeq() {
		return this.ediVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return implMnTpCd
	 */
	public String getImplMnTpCd() {
		return this.implMnTpCd;
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
	 * @return costOfcMdmRefFlg
	 */
	public String getCostOfcMdmRefFlg() {
		return this.costOfcMdmRefFlg;
	}
	
	/**
	 * Column Info
	 * @return stoPrdDtChkFlg
	 */
	public String getStoPrdDtChkFlg() {
		return this.stoPrdDtChkFlg;
	}
	
	/**
	 * Column Info
	 * @return parsMzdCd
	 */
	public String getParsMzdCd() {
		return this.parsMzdCd;
	}
	
	/**
	 * Column Info
	 * @return ediRcvRuleMnSeq
	 */
	public String getEdiRcvRuleMnSeq() {
		return this.ediRcvRuleMnSeq;
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
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
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
	 * @param invOfcMdmRefFlg
	 */
	public void setInvOfcMdmRefFlg(String invOfcMdmRefFlg) {
		this.invOfcMdmRefFlg = invOfcMdmRefFlg;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
	}
	
	/**
	 * Column Info
	 * @param implSubTpCd
	 */
	public void setImplSubTpCd(String implSubTpCd) {
		this.implSubTpCd = implSubTpCd;
	}
	
	/**
	 * Column Info
	 * @param vndrTrfRefFlg
	 */
	public void setVndrTrfRefFlg(String vndrTrfRefFlg) {
		this.vndrTrfRefFlg = vndrTrfRefFlg;
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
	 * @param ediRmk
	 */
	public void setEdiRmk(String ediRmk) {
		this.ediRmk = ediRmk;
	}
	
	/**
	 * Column Info
	 * @param implTpCd
	 */
	public void setImplTpCd(String implTpCd) {
		this.implTpCd = implTpCd;
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
	 * @param ediVndrSeq
	 */
	public void setEdiVndrSeq(String ediVndrSeq) {
		this.ediVndrSeq = ediVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param implMnTpCd
	 */
	public void setImplMnTpCd(String implMnTpCd) {
		this.implMnTpCd = implMnTpCd;
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
	 * @param costOfcMdmRefFlg
	 */
	public void setCostOfcMdmRefFlg(String costOfcMdmRefFlg) {
		this.costOfcMdmRefFlg = costOfcMdmRefFlg;
	}
	
	/**
	 * Column Info
	 * @param stoPrdDtChkFlg
	 */
	public void setStoPrdDtChkFlg(String stoPrdDtChkFlg) {
		this.stoPrdDtChkFlg = stoPrdDtChkFlg;
	}
	
	/**
	 * Column Info
	 * @param parsMzdCd
	 */
	public void setParsMzdCd(String parsMzdCd) {
		this.parsMzdCd = parsMzdCd;
	}
	
	/**
	 * Column Info
	 * @param ediRcvRuleMnSeq
	 */
	public void setEdiRcvRuleMnSeq(String ediRcvRuleMnSeq) {
		this.ediRcvRuleMnSeq = ediRcvRuleMnSeq;
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
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
		setInvOfcMdmRefFlg(JSPUtil.getParameter(request, prefix + "inv_ofc_mdm_ref_flg", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setImplSubTpCd(JSPUtil.getParameter(request, prefix + "impl_sub_tp_cd", ""));
		setVndrTrfRefFlg(JSPUtil.getParameter(request, prefix + "vndr_trf_ref_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEdiRmk(JSPUtil.getParameter(request, prefix + "edi_rmk", ""));
		setImplTpCd(JSPUtil.getParameter(request, prefix + "impl_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEdiVndrSeq(JSPUtil.getParameter(request, prefix + "edi_vndr_seq", ""));
		setImplMnTpCd(JSPUtil.getParameter(request, prefix + "impl_mn_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostOfcMdmRefFlg(JSPUtil.getParameter(request, prefix + "cost_ofc_mdm_ref_flg", ""));
		setStoPrdDtChkFlg(JSPUtil.getParameter(request, prefix + "sto_prd_dt_chk_flg", ""));
		setParsMzdCd(JSPUtil.getParameter(request, prefix + "pars_mzd_cd", ""));
		setEdiRcvRuleMnSeq(JSPUtil.getParameter(request, prefix + "edi_rcv_rule_mn_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesEdiRcvRuleVndrMgmtVO[]
	 */
	public TesEdiRcvRuleVndrMgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesEdiRcvRuleVndrMgmtVO[]
	 */
	public TesEdiRcvRuleVndrMgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesEdiRcvRuleVndrMgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] invOfcMdmRefFlg = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_mdm_ref_flg", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] implSubTpCd = (JSPUtil.getParameter(request, prefix	+ "impl_sub_tp_cd", length));
			String[] vndrTrfRefFlg = (JSPUtil.getParameter(request, prefix	+ "vndr_trf_ref_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ediRmk = (JSPUtil.getParameter(request, prefix	+ "edi_rmk", length));
			String[] implTpCd = (JSPUtil.getParameter(request, prefix	+ "impl_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ediVndrSeq = (JSPUtil.getParameter(request, prefix	+ "edi_vndr_seq", length));
			String[] implMnTpCd = (JSPUtil.getParameter(request, prefix	+ "impl_mn_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costOfcMdmRefFlg = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_mdm_ref_flg", length));
			String[] stoPrdDtChkFlg = (JSPUtil.getParameter(request, prefix	+ "sto_prd_dt_chk_flg", length));
			String[] parsMzdCd = (JSPUtil.getParameter(request, prefix	+ "pars_mzd_cd", length));
			String[] ediRcvRuleMnSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_rule_mn_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesEdiRcvRuleVndrMgmtVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (invOfcMdmRefFlg[i] != null)
					model.setInvOfcMdmRefFlg(invOfcMdmRefFlg[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (implSubTpCd[i] != null)
					model.setImplSubTpCd(implSubTpCd[i]);
				if (vndrTrfRefFlg[i] != null)
					model.setVndrTrfRefFlg(vndrTrfRefFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ediRmk[i] != null)
					model.setEdiRmk(ediRmk[i]);
				if (implTpCd[i] != null)
					model.setImplTpCd(implTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ediVndrSeq[i] != null)
					model.setEdiVndrSeq(ediVndrSeq[i]);
				if (implMnTpCd[i] != null)
					model.setImplMnTpCd(implMnTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costOfcMdmRefFlg[i] != null)
					model.setCostOfcMdmRefFlg(costOfcMdmRefFlg[i]);
				if (stoPrdDtChkFlg[i] != null)
					model.setStoPrdDtChkFlg(stoPrdDtChkFlg[i]);
				if (parsMzdCd[i] != null)
					model.setParsMzdCd(parsMzdCd[i]);
				if (ediRcvRuleMnSeq[i] != null)
					model.setEdiRcvRuleMnSeq(ediRcvRuleMnSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesEdiRcvRuleVndrMgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesEdiRcvRuleVndrMgmtVO[]
	 */
	public TesEdiRcvRuleVndrMgmtVO[] getTesEdiRcvRuleVndrMgmtVOs(){
		TesEdiRcvRuleVndrMgmtVO[] vos = (TesEdiRcvRuleVndrMgmtVO[])models.toArray(new TesEdiRcvRuleVndrMgmtVO[models.size()]);
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
		this.invOfcMdmRefFlg = this.invOfcMdmRefFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.implSubTpCd = this.implSubTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrTrfRefFlg = this.vndrTrfRefFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRmk = this.ediRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.implTpCd = this.implTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVndrSeq = this.ediVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.implMnTpCd = this.implMnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcMdmRefFlg = this.costOfcMdmRefFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoPrdDtChkFlg = this.stoPrdDtChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.parsMzdCd = this.parsMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvRuleMnSeq = this.ediRcvRuleMnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
