/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdPatternVO.java
*@FileTitle : PrdPatternVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.10.13 정선용 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정선용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PrdPatternVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrdPatternVO> models = new ArrayList<PrdPatternVO>();
	
	/* Column Info */
	private String copSoKnt = null;
	/* Column Info */
	private String bkgOpRmk = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String copOpTpCd = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Column Info */
	private String obTroFlg = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String ibItchgCtnt = null;
	/* Column Info */
	private String copPattOrdNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String obItchgCtnt = null;
	/* Column Info */
	private String ocnItchgCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ibTroFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String crntFlg = null;
	/* Column Info */
	private String mtyRtnYdCd = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String copMapgSeq = null;
	
	private String copPcObTrspModCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PrdPatternVO() {}

	public PrdPatternVO(String ibflag, String pagerows, String pctlNo, String bkgNo, String copNo, String crntFlg, String cntrNo, String cntrTpszCd, String copOpTpCd, String obItchgCtnt, String mtyPkupYdCd, String bkgOpRmk, String mtyRtnYdCd, String ibItchgCtnt, String porNodCd, String ocnItchgCtnt, String polNodCd, String bkgRcvTermCd, String bkgDeTermCd, String obTroFlg, String ibTroFlg, String copPattOrdNo, String copSoKnt, String copMapgSeq, String copPcObTrspModCd) {
		this.copSoKnt = copSoKnt;
		this.bkgOpRmk = bkgOpRmk;
		this.porNodCd = porNodCd;
		this.copNo = copNo;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.copOpTpCd = copOpTpCd;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.obTroFlg = obTroFlg;
		this.polNodCd = polNodCd;
		this.ibItchgCtnt = ibItchgCtnt;
		this.copPattOrdNo = copPattOrdNo;
		this.pagerows = pagerows;
		this.pctlNo = pctlNo;
		this.obItchgCtnt = obItchgCtnt;
		this.ocnItchgCtnt = ocnItchgCtnt;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.ibTroFlg = ibTroFlg;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.crntFlg = crntFlg;
		this.mtyRtnYdCd = mtyRtnYdCd;
		this.bkgDeTermCd = bkgDeTermCd;
		this.copMapgSeq = copMapgSeq;
		this.copPcObTrspModCd = copPcObTrspModCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cop_so_knt", getCopSoKnt());
		this.hashColumns.put("bkg_op_rmk", getBkgOpRmk());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("cop_op_tp_cd", getCopOpTpCd());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("ob_tro_flg", getObTroFlg());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("ib_itchg_ctnt", getIbItchgCtnt());
		this.hashColumns.put("cop_patt_ord_no", getCopPattOrdNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("ob_itchg_ctnt", getObItchgCtnt());
		this.hashColumns.put("ocn_itchg_ctnt", getOcnItchgCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ib_tro_flg", getIbTroFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("crnt_flg", getCrntFlg());
		this.hashColumns.put("mty_rtn_yd_cd", getMtyRtnYdCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("cop_mapg_seq", getCopMapgSeq());
		this.hashColumns.put("cop_pc_ob_trsp_mod_cd", getCopPcObTrspModCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cop_so_knt", "copSoKnt");
		this.hashFields.put("bkg_op_rmk", "bkgOpRmk");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("cop_op_tp_cd", "copOpTpCd");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("ob_tro_flg", "obTroFlg");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("ib_itchg_ctnt", "ibItchgCtnt");
		this.hashFields.put("cop_patt_ord_no", "copPattOrdNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("ob_itchg_ctnt", "obItchgCtnt");
		this.hashFields.put("ocn_itchg_ctnt", "ocnItchgCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ib_tro_flg", "ibTroFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("crnt_flg", "crntFlg");
		this.hashFields.put("mty_rtn_yd_cd", "mtyRtnYdCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("cop_mapg_seq", "copMapgSeq");
		this.hashFields.put("cop_pc_ob_trsp_mod_cd", "copPcObTrspModCd");
		return this.hashFields;
	}
	
	public String getCopMapgSeq() {
		return this.copMapgSeq;
	}

	public void setCopMapgSeq(String copMapgSeq) {
		this.copMapgSeq = copMapgSeq;
	}

	/**
	 * Column Info
	 * @return copSoKnt
	 */
	public String getCopSoKnt() {
		return this.copSoKnt;
	}
	
	/**
	 * Column Info
	 * @return bkgOpRmk
	 */
	public String getBkgOpRmk() {
		return this.bkgOpRmk;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return copOpTpCd
	 */
	public String getCopOpTpCd() {
		return this.copOpTpCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
	public String getMtyPkupYdCd() {
		return this.mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return obTroFlg
	 */
	public String getObTroFlg() {
		return this.obTroFlg;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return ibItchgCtnt
	 */
	public String getIbItchgCtnt() {
		return this.ibItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @return copPattOrdNo
	 */
	public String getCopPattOrdNo() {
		return this.copPattOrdNo;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
	}
	
	/**
	 * Column Info
	 * @return obItchgCtnt
	 */
	public String getObItchgCtnt() {
		return this.obItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @return ocnItchgCtnt
	 */
	public String getOcnItchgCtnt() {
		return this.ocnItchgCtnt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return ibTroFlg
	 */
	public String getIbTroFlg() {
		return this.ibTroFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return crntFlg
	 */
	public String getCrntFlg() {
		return this.crntFlg;
	}
	
	/**
	 * Column Info
	 * @return mtyRtnYdCd
	 */
	public String getMtyRtnYdCd() {
		return this.mtyRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
	}
	

	public String getCopPcObTrspModCd() {
		return copPcObTrspModCd;
	}

	public void setCopPcObTrspModCd(String copPcObTrspModCd) {
		this.copPcObTrspModCd = copPcObTrspModCd;
	}

	/**
	 * Column Info
	 * @param copSoKnt
	 */
	public void setCopSoKnt(String copSoKnt) {
		this.copSoKnt = copSoKnt;
	}
	
	/**
	 * Column Info
	 * @param bkgOpRmk
	 */
	public void setBkgOpRmk(String bkgOpRmk) {
		this.bkgOpRmk = bkgOpRmk;
	}
	
	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param copOpTpCd
	 */
	public void setCopOpTpCd(String copOpTpCd) {
		this.copOpTpCd = copOpTpCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
	public void setMtyPkupYdCd(String mtyPkupYdCd) {
		this.mtyPkupYdCd = mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param obTroFlg
	 */
	public void setObTroFlg(String obTroFlg) {
		this.obTroFlg = obTroFlg;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param ibItchgCtnt
	 */
	public void setIbItchgCtnt(String ibItchgCtnt) {
		this.ibItchgCtnt = ibItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @param copPattOrdNo
	 */
	public void setCopPattOrdNo(String copPattOrdNo) {
		this.copPattOrdNo = copPattOrdNo;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}
	
	/**
	 * Column Info
	 * @param obItchgCtnt
	 */
	public void setObItchgCtnt(String obItchgCtnt) {
		this.obItchgCtnt = obItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @param ocnItchgCtnt
	 */
	public void setOcnItchgCtnt(String ocnItchgCtnt) {
		this.ocnItchgCtnt = ocnItchgCtnt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param ibTroFlg
	 */
	public void setIbTroFlg(String ibTroFlg) {
		this.ibTroFlg = ibTroFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param crntFlg
	 */
	public void setCrntFlg(String crntFlg) {
		this.crntFlg = crntFlg;
	}
	
	/**
	 * Column Info
	 * @param mtyRtnYdCd
	 */
	public void setMtyRtnYdCd(String mtyRtnYdCd) {
		this.mtyRtnYdCd = mtyRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCopSoKnt(JSPUtil.getParameter(request, "cop_so_knt", ""));
		setBkgOpRmk(JSPUtil.getParameter(request, "bkg_op_rmk", ""));
		setPorNodCd(JSPUtil.getParameter(request, "por_nod_cd", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, "bkg_rcv_term_cd", ""));
		setCopOpTpCd(JSPUtil.getParameter(request, "cop_op_tp_cd", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, "mty_pkup_yd_cd", ""));
		setObTroFlg(JSPUtil.getParameter(request, "ob_tro_flg", ""));
		setPolNodCd(JSPUtil.getParameter(request, "pol_nod_cd", ""));
		setIbItchgCtnt(JSPUtil.getParameter(request, "ib_itchg_ctnt", ""));
		setCopPattOrdNo(JSPUtil.getParameter(request, "cop_patt_ord_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPctlNo(JSPUtil.getParameter(request, "pctl_no", ""));
		setObItchgCtnt(JSPUtil.getParameter(request, "ob_itchg_ctnt", ""));
		setOcnItchgCtnt(JSPUtil.getParameter(request, "ocn_itchg_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbTroFlg(JSPUtil.getParameter(request, "ib_tro_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCrntFlg(JSPUtil.getParameter(request, "crnt_flg", ""));
		setMtyRtnYdCd(JSPUtil.getParameter(request, "mty_rtn_yd_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, "bkg_de_term_cd", ""));
		setCopMapgSeq(JSPUtil.getParameter(request, "cop_mapg_seq", ""));
		setCopPcObTrspModCd(JSPUtil.getParameter(request, "cop_pc_ob_trsp_mod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdPatternVO[]
	 */
	public PrdPatternVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrdPatternVO[]
	 */
	public PrdPatternVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdPatternVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] copSoKnt = (JSPUtil.getParameter(request, prefix	+ "cop_so_knt", length));
			String[] bkgOpRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_op_rmk", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] copOpTpCd = (JSPUtil.getParameter(request, prefix	+ "cop_op_tp_cd", length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd", length));
			String[] obTroFlg = (JSPUtil.getParameter(request, prefix	+ "ob_tro_flg", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] ibItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ib_itchg_ctnt", length));
			String[] copPattOrdNo = (JSPUtil.getParameter(request, prefix	+ "cop_patt_ord_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] obItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ob_itchg_ctnt", length));
			String[] ocnItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ocn_itchg_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibTroFlg = (JSPUtil.getParameter(request, prefix	+ "ib_tro_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] crntFlg = (JSPUtil.getParameter(request, prefix	+ "crnt_flg", length));
			String[] mtyRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_rtn_yd_cd", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			String[] copMapgSeq = (JSPUtil.getParameter(request, prefix	+ "cop_mapg_seq", length));
			String[] copPcObTrspModCd = (JSPUtil.getParameter(request, prefix	+ "cop_pc_ob_trsp_mod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrdPatternVO();
				if (copSoKnt[i] != null)
					model.setCopSoKnt(copSoKnt[i]);
				if (bkgOpRmk[i] != null)
					model.setBkgOpRmk(bkgOpRmk[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (copOpTpCd[i] != null)
					model.setCopOpTpCd(copOpTpCd[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (obTroFlg[i] != null)
					model.setObTroFlg(obTroFlg[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (ibItchgCtnt[i] != null)
					model.setIbItchgCtnt(ibItchgCtnt[i]);
				if (copPattOrdNo[i] != null)
					model.setCopPattOrdNo(copPattOrdNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (obItchgCtnt[i] != null)
					model.setObItchgCtnt(obItchgCtnt[i]);
				if (ocnItchgCtnt[i] != null)
					model.setOcnItchgCtnt(ocnItchgCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibTroFlg[i] != null)
					model.setIbTroFlg(ibTroFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (crntFlg[i] != null)
					model.setCrntFlg(crntFlg[i]);
				if (mtyRtnYdCd[i] != null)
					model.setMtyRtnYdCd(mtyRtnYdCd[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (copMapgSeq[i] != null)
					model.setCopMapgSeq(copMapgSeq[i]);				
				if (copPcObTrspModCd[i] != null)
					model.setCopPcObTrspModCd(copPcObTrspModCd[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdPatternVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrdPatternVO[]
	 */
	public PrdPatternVO[] getPrdPatternVOs(){
		PrdPatternVO[] vos = (PrdPatternVO[])models.toArray(new PrdPatternVO[models.size()]);
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
		this.copSoKnt = this.copSoKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOpRmk = this.bkgOpRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copOpTpCd = this.copOpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obTroFlg = this.obTroFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibItchgCtnt = this.ibItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copPattOrdNo = this.copPattOrdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obItchgCtnt = this.obItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnItchgCtnt = this.ocnItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibTroFlg = this.ibTroFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntFlg = this.crntFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRtnYdCd = this.mtyRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copMapgSeq = this.copMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copPcObTrspModCd = this.copPcObTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
