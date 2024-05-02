/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpusQtyVO.java
*@FileTitle : OpusQtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.11.04 김병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OpusQtyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OpusQtyVO> models = new ArrayList<OpusQtyVO>();
	
	/* Column Info */
	private String dcgoQty = null;
	/* Column Info */
	private String crrHngrSglBarQty = null;
	/* Column Info */
	private String eqSubstCgoQty = null;
	/* Column Info */
	private String obTroQty = null;
	/* Column Info */
	private String crrHngrQty = null;
	/* Column Info */
	private String awkCgoQty = null;
	/* Column Info */
	private String actCntrQty = null;
	/* Column Info */
	private String orgCntrQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String crrHngrDblBarQty = null;
	/* Column Info */
	private String eqSubstCntrTpszCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcQty = null;
	/* Column Info */
	private String ibTroQty = null;
	/* Column Info */
	private String bbCgoQty = null;
	/* Column Info */
	private String destCntrQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String flexHgtFlg = null;
	/* Column Info */
	private String crrHngrTplBarQty = null;
	/* Column Info */
	private String socQty = null;
	/* Column Info */
	private String merHngrQty = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OpusQtyVO() {}

	public OpusQtyVO(String ibflag, String pagerows, String cntrTpszCd, String opCntrQty, String actCntrQty, String dcgoQty, String awkCgoQty, String rcQty, String bbCgoQty, String socQty, String eqSubstCntrTpszCd, String eqSubstCgoQty, String merHngrQty, String crrHngrQty, String crrHngrSglBarQty, String crrHngrDblBarQty, String crrHngrTplBarQty, String orgCntrQty, String destCntrQty, String obTroQty, String ibTroQty, String flexHgtFlg) {
		this.dcgoQty = dcgoQty;
		this.crrHngrSglBarQty = crrHngrSglBarQty;
		this.eqSubstCgoQty = eqSubstCgoQty;
		this.obTroQty = obTroQty;
		this.crrHngrQty = crrHngrQty;
		this.awkCgoQty = awkCgoQty;
		this.actCntrQty = actCntrQty;
		this.orgCntrQty = orgCntrQty;
		this.pagerows = pagerows;
		this.crrHngrDblBarQty = crrHngrDblBarQty;
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
		this.ibflag = ibflag;
		this.rcQty = rcQty;
		this.ibTroQty = ibTroQty;
		this.bbCgoQty = bbCgoQty;
		this.destCntrQty = destCntrQty;
		this.cntrTpszCd = cntrTpszCd;
		this.opCntrQty = opCntrQty;
		this.flexHgtFlg = flexHgtFlg;
		this.crrHngrTplBarQty = crrHngrTplBarQty;
		this.socQty = socQty;
		this.merHngrQty = merHngrQty;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dcgo_qty", getDcgoQty());
		this.hashColumns.put("crr_hngr_sgl_bar_qty", getCrrHngrSglBarQty());
		this.hashColumns.put("eq_subst_cgo_qty", getEqSubstCgoQty());
		this.hashColumns.put("ob_tro_qty", getObTroQty());
		this.hashColumns.put("crr_hngr_qty", getCrrHngrQty());
		this.hashColumns.put("awk_cgo_qty", getAwkCgoQty());
		this.hashColumns.put("act_cntr_qty", getActCntrQty());
		this.hashColumns.put("org_cntr_qty", getOrgCntrQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("crr_hngr_dbl_bar_qty", getCrrHngrDblBarQty());
		this.hashColumns.put("eq_subst_cntr_tpsz_cd", getEqSubstCntrTpszCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rc_qty", getRcQty());
		this.hashColumns.put("ib_tro_qty", getIbTroQty());
		this.hashColumns.put("bb_cgo_qty", getBbCgoQty());
		this.hashColumns.put("dest_cntr_qty", getDestCntrQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
		this.hashColumns.put("crr_hngr_tpl_bar_qty", getCrrHngrTplBarQty());
		this.hashColumns.put("soc_qty", getSocQty());
		this.hashColumns.put("mer_hngr_qty", getMerHngrQty());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dcgo_qty", "dcgoQty");
		this.hashFields.put("crr_hngr_sgl_bar_qty", "crrHngrSglBarQty");
		this.hashFields.put("eq_subst_cgo_qty", "eqSubstCgoQty");
		this.hashFields.put("ob_tro_qty", "obTroQty");
		this.hashFields.put("crr_hngr_qty", "crrHngrQty");
		this.hashFields.put("awk_cgo_qty", "awkCgoQty");
		this.hashFields.put("act_cntr_qty", "actCntrQty");
		this.hashFields.put("org_cntr_qty", "orgCntrQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("crr_hngr_dbl_bar_qty", "crrHngrDblBarQty");
		this.hashFields.put("eq_subst_cntr_tpsz_cd", "eqSubstCntrTpszCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rc_qty", "rcQty");
		this.hashFields.put("ib_tro_qty", "ibTroQty");
		this.hashFields.put("bb_cgo_qty", "bbCgoQty");
		this.hashFields.put("dest_cntr_qty", "destCntrQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
		this.hashFields.put("crr_hngr_tpl_bar_qty", "crrHngrTplBarQty");
		this.hashFields.put("soc_qty", "socQty");
		this.hashFields.put("mer_hngr_qty", "merHngrQty");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dcgoQty
	 */
	public String getDcgoQty() {
		return this.dcgoQty;
	}
	
	/**
	 * Column Info
	 * @return crrHngrSglBarQty
	 */
	public String getCrrHngrSglBarQty() {
		return this.crrHngrSglBarQty;
	}
	
	/**
	 * Column Info
	 * @return eqSubstCgoQty
	 */
	public String getEqSubstCgoQty() {
		return this.eqSubstCgoQty;
	}
	
	/**
	 * Column Info
	 * @return obTroQty
	 */
	public String getObTroQty() {
		return this.obTroQty;
	}
	
	/**
	 * Column Info
	 * @return crrHngrQty
	 */
	public String getCrrHngrQty() {
		return this.crrHngrQty;
	}
	
	/**
	 * Column Info
	 * @return awkCgoQty
	 */
	public String getAwkCgoQty() {
		return this.awkCgoQty;
	}
	
	/**
	 * Column Info
	 * @return actCntrQty
	 */
	public String getActCntrQty() {
		return this.actCntrQty;
	}
	
	/**
	 * Column Info
	 * @return orgCntrQty
	 */
	public String getOrgCntrQty() {
		return this.orgCntrQty;
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
	 * @return crrHngrDblBarQty
	 */
	public String getCrrHngrDblBarQty() {
		return this.crrHngrDblBarQty;
	}
	
	/**
	 * Column Info
	 * @return eqSubstCntrTpszCd
	 */
	public String getEqSubstCntrTpszCd() {
		return this.eqSubstCntrTpszCd;
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
	 * @return rcQty
	 */
	public String getRcQty() {
		return this.rcQty;
	}
	
	/**
	 * Column Info
	 * @return ibTroQty
	 */
	public String getIbTroQty() {
		return this.ibTroQty;
	}
	
	/**
	 * Column Info
	 * @return bbCgoQty
	 */
	public String getBbCgoQty() {
		return this.bbCgoQty;
	}
	
	/**
	 * Column Info
	 * @return destCntrQty
	 */
	public String getDestCntrQty() {
		return this.destCntrQty;
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
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return flexHgtFlg
	 */
	public String getFlexHgtFlg() {
		return this.flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @return crrHngrTplBarQty
	 */
	public String getCrrHngrTplBarQty() {
		return this.crrHngrTplBarQty;
	}
	
	/**
	 * Column Info
	 * @return socQty
	 */
	public String getSocQty() {
		return this.socQty;
	}
	
	/**
	 * Column Info
	 * @return merHngrQty
	 */
	public String getMerHngrQty() {
		return this.merHngrQty;
	}
	

	/**
	 * Column Info
	 * @param dcgoQty
	 */
	public void setDcgoQty(String dcgoQty) {
		this.dcgoQty = dcgoQty;
	}
	
	/**
	 * Column Info
	 * @param crrHngrSglBarQty
	 */
	public void setCrrHngrSglBarQty(String crrHngrSglBarQty) {
		this.crrHngrSglBarQty = crrHngrSglBarQty;
	}
	
	/**
	 * Column Info
	 * @param eqSubstCgoQty
	 */
	public void setEqSubstCgoQty(String eqSubstCgoQty) {
		this.eqSubstCgoQty = eqSubstCgoQty;
	}
	
	/**
	 * Column Info
	 * @param obTroQty
	 */
	public void setObTroQty(String obTroQty) {
		this.obTroQty = obTroQty;
	}
	
	/**
	 * Column Info
	 * @param crrHngrQty
	 */
	public void setCrrHngrQty(String crrHngrQty) {
		this.crrHngrQty = crrHngrQty;
	}
	
	/**
	 * Column Info
	 * @param awkCgoQty
	 */
	public void setAwkCgoQty(String awkCgoQty) {
		this.awkCgoQty = awkCgoQty;
	}
	
	/**
	 * Column Info
	 * @param actCntrQty
	 */
	public void setActCntrQty(String actCntrQty) {
		this.actCntrQty = actCntrQty;
	}
	
	/**
	 * Column Info
	 * @param orgCntrQty
	 */
	public void setOrgCntrQty(String orgCntrQty) {
		this.orgCntrQty = orgCntrQty;
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
	 * @param crrHngrDblBarQty
	 */
	public void setCrrHngrDblBarQty(String crrHngrDblBarQty) {
		this.crrHngrDblBarQty = crrHngrDblBarQty;
	}
	
	/**
	 * Column Info
	 * @param eqSubstCntrTpszCd
	 */
	public void setEqSubstCntrTpszCd(String eqSubstCntrTpszCd) {
		this.eqSubstCntrTpszCd = eqSubstCntrTpszCd;
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
	 * @param rcQty
	 */
	public void setRcQty(String rcQty) {
		this.rcQty = rcQty;
	}
	
	/**
	 * Column Info
	 * @param ibTroQty
	 */
	public void setIbTroQty(String ibTroQty) {
		this.ibTroQty = ibTroQty;
	}
	
	/**
	 * Column Info
	 * @param bbCgoQty
	 */
	public void setBbCgoQty(String bbCgoQty) {
		this.bbCgoQty = bbCgoQty;
	}
	
	/**
	 * Column Info
	 * @param destCntrQty
	 */
	public void setDestCntrQty(String destCntrQty) {
		this.destCntrQty = destCntrQty;
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
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param flexHgtFlg
	 */
	public void setFlexHgtFlg(String flexHgtFlg) {
		this.flexHgtFlg = flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @param crrHngrTplBarQty
	 */
	public void setCrrHngrTplBarQty(String crrHngrTplBarQty) {
		this.crrHngrTplBarQty = crrHngrTplBarQty;
	}
	
	/**
	 * Column Info
	 * @param socQty
	 */
	public void setSocQty(String socQty) {
		this.socQty = socQty;
	}
	
	/**
	 * Column Info
	 * @param merHngrQty
	 */
	public void setMerHngrQty(String merHngrQty) {
		this.merHngrQty = merHngrQty;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDcgoQty(JSPUtil.getParameter(request, "dcgo_qty", ""));
		setCrrHngrSglBarQty(JSPUtil.getParameter(request, "crr_hngr_sgl_bar_qty", ""));
		setEqSubstCgoQty(JSPUtil.getParameter(request, "eq_subst_cgo_qty", ""));
		setObTroQty(JSPUtil.getParameter(request, "ob_tro_qty", ""));
		setCrrHngrQty(JSPUtil.getParameter(request, "crr_hngr_qty", ""));
		setAwkCgoQty(JSPUtil.getParameter(request, "awk_cgo_qty", ""));
		setActCntrQty(JSPUtil.getParameter(request, "act_cntr_qty", ""));
		setOrgCntrQty(JSPUtil.getParameter(request, "org_cntr_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCrrHngrDblBarQty(JSPUtil.getParameter(request, "crr_hngr_dbl_bar_qty", ""));
		setEqSubstCntrTpszCd(JSPUtil.getParameter(request, "eq_subst_cntr_tpsz_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRcQty(JSPUtil.getParameter(request, "rc_qty", ""));
		setIbTroQty(JSPUtil.getParameter(request, "ib_tro_qty", ""));
		setBbCgoQty(JSPUtil.getParameter(request, "bb_cgo_qty", ""));
		setDestCntrQty(JSPUtil.getParameter(request, "dest_cntr_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setOpCntrQty(JSPUtil.getParameter(request, "op_cntr_qty", ""));
		setFlexHgtFlg(JSPUtil.getParameter(request, "flex_hgt_flg", ""));
		setCrrHngrTplBarQty(JSPUtil.getParameter(request, "crr_hngr_tpl_bar_qty", ""));
		setSocQty(JSPUtil.getParameter(request, "soc_qty", ""));
		setMerHngrQty(JSPUtil.getParameter(request, "mer_hngr_qty", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OpusQtyVO[]
	 */
	public OpusQtyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OpusQtyVO[]
	 */
	public OpusQtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OpusQtyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dcgoQty = (JSPUtil.getParameter(request, prefix	+ "dcgo_qty", length));
			String[] crrHngrSglBarQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_sgl_bar_qty", length));
			String[] eqSubstCgoQty = (JSPUtil.getParameter(request, prefix	+ "eq_subst_cgo_qty", length));
			String[] obTroQty = (JSPUtil.getParameter(request, prefix	+ "ob_tro_qty", length));
			String[] crrHngrQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_qty", length));
			String[] awkCgoQty = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_qty", length));
			String[] actCntrQty = (JSPUtil.getParameter(request, prefix	+ "act_cntr_qty", length));
			String[] orgCntrQty = (JSPUtil.getParameter(request, prefix	+ "org_cntr_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] crrHngrDblBarQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_dbl_bar_qty", length));
			String[] eqSubstCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_subst_cntr_tpsz_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcQty = (JSPUtil.getParameter(request, prefix	+ "rc_qty", length));
			String[] ibTroQty = (JSPUtil.getParameter(request, prefix	+ "ib_tro_qty", length));
			String[] bbCgoQty = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_qty", length));
			String[] destCntrQty = (JSPUtil.getParameter(request, prefix	+ "dest_cntr_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix	+ "flex_hgt_flg", length));
			String[] crrHngrTplBarQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_tpl_bar_qty", length));
			String[] socQty = (JSPUtil.getParameter(request, prefix	+ "soc_qty", length));
			String[] merHngrQty = (JSPUtil.getParameter(request, prefix	+ "mer_hngr_qty", length));
			
			for (int i = 0; i < length; i++) {
				model = new OpusQtyVO();
				if (dcgoQty[i] != null)
					model.setDcgoQty(dcgoQty[i]);
				if (crrHngrSglBarQty[i] != null)
					model.setCrrHngrSglBarQty(crrHngrSglBarQty[i]);
				if (eqSubstCgoQty[i] != null)
					model.setEqSubstCgoQty(eqSubstCgoQty[i]);
				if (obTroQty[i] != null)
					model.setObTroQty(obTroQty[i]);
				if (crrHngrQty[i] != null)
					model.setCrrHngrQty(crrHngrQty[i]);
				if (awkCgoQty[i] != null)
					model.setAwkCgoQty(awkCgoQty[i]);
				if (actCntrQty[i] != null)
					model.setActCntrQty(actCntrQty[i]);
				if (orgCntrQty[i] != null)
					model.setOrgCntrQty(orgCntrQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (crrHngrDblBarQty[i] != null)
					model.setCrrHngrDblBarQty(crrHngrDblBarQty[i]);
				if (eqSubstCntrTpszCd[i] != null)
					model.setEqSubstCntrTpszCd(eqSubstCntrTpszCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcQty[i] != null)
					model.setRcQty(rcQty[i]);
				if (ibTroQty[i] != null)
					model.setIbTroQty(ibTroQty[i]);
				if (bbCgoQty[i] != null)
					model.setBbCgoQty(bbCgoQty[i]);
				if (destCntrQty[i] != null)
					model.setDestCntrQty(destCntrQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (flexHgtFlg[i] != null)
					model.setFlexHgtFlg(flexHgtFlg[i]);
				if (crrHngrTplBarQty[i] != null)
					model.setCrrHngrTplBarQty(crrHngrTplBarQty[i]);
				if (socQty[i] != null)
					model.setSocQty(socQty[i]);
				if (merHngrQty[i] != null)
					model.setMerHngrQty(merHngrQty[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOpusQtyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OpusQtyVO[]
	 */
	public OpusQtyVO[] getOpusQtyVOs(){
		OpusQtyVO[] vos = (OpusQtyVO[])models.toArray(new OpusQtyVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.dcgoQty = this.dcgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrSglBarQty = this.crrHngrSglBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstCgoQty = this.eqSubstCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obTroQty = this.obTroQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrQty = this.crrHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoQty = this.awkCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntrQty = this.actCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCntrQty = this.orgCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrDblBarQty = this.crrHngrDblBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSubstCntrTpszCd = this.eqSubstCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcQty = this.rcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTroQty = this.ibTroQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoQty = this.bbCgoQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCntrQty = this.destCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flexHgtFlg = this.flexHgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrTplBarQty = this.crrHngrTplBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socQty = this.socQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.merHngrQty = this.merHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
