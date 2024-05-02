/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BkgBookingVO.java
*@FileTitle : BkgBookingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.09.05 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo;

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

public class BkgBookingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgBookingVO> models = new ArrayList<BkgBookingVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String bdrCngFlg = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String unNo = null;
	/* Column Info */
	private String brdDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String cbm = null;
	/* Column Info */
	private String bkgCgoTpCd2 = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String kgs = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String clssCd = null;
	/* Column Info */
	private String bbCgoFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgBookingVO() {}

	public BkgBookingVO(String ibflag, String pagerows, String porCd, String bkgCgoTpCd, String bdrCngFlg, String bdrFlg, String delCd, String brdDt, String blNo, String actWgt, String podCd, String deTermCd, String polCd, String cmdtCd, String dcgoFlg, String measQty, String pckQty, String bkgCgoTpCd2, String cbm, String kgs, String rcvTermCd, String pckTpCd, String unNo, String clssCd, String bbCgoFlg) {
		this.porCd = porCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.bdrCngFlg = bdrCngFlg;
		this.bdrFlg = bdrFlg;
		this.delCd = delCd;
		this.unNo = unNo;
		this.brdDt = brdDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.actWgt = actWgt;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.cmdtCd = cmdtCd;
		this.measQty = measQty;
		this.dcgoFlg = dcgoFlg;
		this.pckQty = pckQty;
		this.cbm = cbm;
		this.bkgCgoTpCd2 = bkgCgoTpCd2;
		this.rcvTermCd = rcvTermCd;
		this.kgs = kgs;
		this.pckTpCd = pckTpCd;
		this.clssCd = clssCd;
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("bdr_cng_flg", getBdrCngFlg());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("un_no", getUnNo());
		this.hashColumns.put("brd_dt", getBrdDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cbm", getCbm());
		this.hashColumns.put("bkg_cgo_tp_cd2", getBkgCgoTpCd2());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("kgs", getKgs());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("clss_cd", getClssCd());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("bdr_cng_flg", "bdrCngFlg");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("un_no", "unNo");
		this.hashFields.put("brd_dt", "brdDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cbm", "cbm");
		this.hashFields.put("bkg_cgo_tp_cd2", "bkgCgoTpCd2");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("kgs", "kgs");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("clss_cd", "clssCd");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return bdrCngFlg
	 */
	public String getBdrCngFlg() {
		return this.bdrCngFlg;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return unNo
	 */
	public String getUnNo() {
		return this.unNo;
	}
	
	/**
	 * Column Info
	 * @return brdDt
	 */
	public String getBrdDt() {
		return this.brdDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return cbm
	 */
	public String getCbm() {
		return this.cbm;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd2
	 */
	public String getBkgCgoTpCd2() {
		return this.bkgCgoTpCd2;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return kgs
	 */
	public String getKgs() {
		return this.kgs;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return clssCd
	 */
	public String getClssCd() {
		return this.clssCd;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param bdrCngFlg
	 */
	public void setBdrCngFlg(String bdrCngFlg) {
		this.bdrCngFlg = bdrCngFlg;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param unNo
	 */
	public void setUnNo(String unNo) {
		this.unNo = unNo;
	}
	
	/**
	 * Column Info
	 * @param brdDt
	 */
	public void setBrdDt(String brdDt) {
		this.brdDt = brdDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param cbm
	 */
	public void setCbm(String cbm) {
		this.cbm = cbm;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd2
	 */
	public void setBkgCgoTpCd2(String bkgCgoTpCd2) {
		this.bkgCgoTpCd2 = bkgCgoTpCd2;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param kgs
	 */
	public void setKgs(String kgs) {
		this.kgs = kgs;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param clssCd
	 */
	public void setClssCd(String clssCd) {
		this.clssCd = clssCd;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setBdrCngFlg(JSPUtil.getParameter(request, prefix + "bdr_cng_flg", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setUnNo(JSPUtil.getParameter(request, prefix + "un_no", ""));
		setBrdDt(JSPUtil.getParameter(request, prefix + "brd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setCbm(JSPUtil.getParameter(request, prefix + "cbm", ""));
		setBkgCgoTpCd2(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd2", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setKgs(JSPUtil.getParameter(request, prefix + "kgs", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setClssCd(JSPUtil.getParameter(request, prefix + "clss_cd", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgBookingVO[]
	 */
	public BkgBookingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgBookingVO[]
	 */
	public BkgBookingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgBookingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] bdrCngFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_cng_flg", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] unNo = (JSPUtil.getParameter(request, prefix	+ "un_no", length));
			String[] brdDt = (JSPUtil.getParameter(request, prefix	+ "brd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] cbm = (JSPUtil.getParameter(request, prefix	+ "cbm", length));
			String[] bkgCgoTpCd2 = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd2", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] kgs = (JSPUtil.getParameter(request, prefix	+ "kgs", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] clssCd = (JSPUtil.getParameter(request, prefix	+ "clss_cd", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgBookingVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (bdrCngFlg[i] != null)
					model.setBdrCngFlg(bdrCngFlg[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (unNo[i] != null)
					model.setUnNo(unNo[i]);
				if (brdDt[i] != null)
					model.setBrdDt(brdDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (cbm[i] != null)
					model.setCbm(cbm[i]);
				if (bkgCgoTpCd2[i] != null)
					model.setBkgCgoTpCd2(bkgCgoTpCd2[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (kgs[i] != null)
					model.setKgs(kgs[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (clssCd[i] != null)
					model.setClssCd(clssCd[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgBookingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgBookingVO[]
	 */
	public BkgBookingVO[] getBkgBookingVOs(){
		BkgBookingVO[] vos = (BkgBookingVO[])models.toArray(new BkgBookingVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrCngFlg = this.bdrCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unNo = this.unNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brdDt = this.brdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbm = this.cbm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd2 = this.bkgCgoTpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kgs = this.kgs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clssCd = this.clssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
