/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KrWhfRateVO.java
*@FileTitle : KrWhfRateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.08.19 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfRateVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfRateVO extends WhfRateVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfRateVO> models = new ArrayList<KrWhfRateVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String chgRtSeq = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntrPerTpCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String declRmk = null;
	/* Column Info */
	private String whfDeclNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String whfDeclIfFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String teuQty = null;
	/* Column Info */
	private String whfDeclDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffAmt = null;
	/* Column Info */
	private String arIfFlg = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String krWhfExptCd = null;
	/* Column Info */
	private String arIfDt = null;
	/* Column Info */
	private String newChgAmt = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String oldChgAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfRateVO() {}

	public KrWhfRateVO(String ibflag, String pagerows, String blNo, String chgRtSeq, String cntrWgt, String measQty, String teuQty, String cntrPerTpCd, String oldChgAmt, String newChgAmt, String diffAmt, String whfDeclNo, String whfDeclDt, String krWhfExptCd, String whfDeclIfFlg, String arIfFlg, String arIfDt, String declRmk, String creDt, String wgtUtCd, String measUtCd, String vslCd, String skdVoyNo, String skdDirCd) {
		this.vslCd = vslCd;
		this.chgRtSeq = chgRtSeq;
		this.cntrWgt = cntrWgt;
		this.creDt = creDt;
		this.cntrPerTpCd = cntrPerTpCd;
		this.skdVoyNo = skdVoyNo;
		this.declRmk = declRmk;
		this.whfDeclNo = whfDeclNo;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.whfDeclIfFlg = whfDeclIfFlg;
		this.pagerows = pagerows;
		this.teuQty = teuQty;
		this.whfDeclDt = whfDeclDt;
		this.ibflag = ibflag;
		this.diffAmt = diffAmt;
		this.arIfFlg = arIfFlg;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.krWhfExptCd = krWhfExptCd;
		this.arIfDt = arIfDt;
		this.newChgAmt = newChgAmt;
		this.measUtCd = measUtCd;
		this.oldChgAmt = oldChgAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("chg_rt_seq", getChgRtSeq());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntr_per_tp_cd", getCntrPerTpCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("decl_rmk", getDeclRmk());
		this.hashColumns.put("whf_decl_no", getWhfDeclNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("whf_decl_if_flg", getWhfDeclIfFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("teu_qty", getTeuQty());
		this.hashColumns.put("whf_decl_dt", getWhfDeclDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_amt", getDiffAmt());
		this.hashColumns.put("ar_if_flg", getArIfFlg());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("kr_whf_expt_cd", getKrWhfExptCd());
		this.hashColumns.put("ar_if_dt", getArIfDt());
		this.hashColumns.put("new_chg_amt", getNewChgAmt());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("old_chg_amt", getOldChgAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("chg_rt_seq", "chgRtSeq");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntr_per_tp_cd", "cntrPerTpCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("decl_rmk", "declRmk");
		this.hashFields.put("whf_decl_no", "whfDeclNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("whf_decl_if_flg", "whfDeclIfFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("teu_qty", "teuQty");
		this.hashFields.put("whf_decl_dt", "whfDeclDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_amt", "diffAmt");
		this.hashFields.put("ar_if_flg", "arIfFlg");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("kr_whf_expt_cd", "krWhfExptCd");
		this.hashFields.put("ar_if_dt", "arIfDt");
		this.hashFields.put("new_chg_amt", "newChgAmt");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("old_chg_amt", "oldChgAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return chgRtSeq
	 */
	public String getChgRtSeq() {
		return this.chgRtSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
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
	 * @return cntrPerTpCd
	 */
	public String getCntrPerTpCd() {
		return this.cntrPerTpCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return declRmk
	 */
	public String getDeclRmk() {
		return this.declRmk;
	}
	
	/**
	 * Column Info
	 * @return whfDeclNo
	 */
	public String getWhfDeclNo() {
		return this.whfDeclNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return whfDeclIfFlg
	 */
	public String getWhfDeclIfFlg() {
		return this.whfDeclIfFlg;
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
	 * @return teuQty
	 */
	public String getTeuQty() {
		return this.teuQty;
	}
	
	/**
	 * Column Info
	 * @return whfDeclDt
	 */
	public String getWhfDeclDt() {
		return this.whfDeclDt;
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
	 * @return diffAmt
	 */
	public String getDiffAmt() {
		return this.diffAmt;
	}
	
	/**
	 * Column Info
	 * @return arIfFlg
	 */
	public String getArIfFlg() {
		return this.arIfFlg;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
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
	 * @return krWhfExptCd
	 */
	public String getKrWhfExptCd() {
		return this.krWhfExptCd;
	}
	
	/**
	 * Column Info
	 * @return arIfDt
	 */
	public String getArIfDt() {
		return this.arIfDt;
	}
	
	/**
	 * Column Info
	 * @return newChgAmt
	 */
	public String getNewChgAmt() {
		return this.newChgAmt;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return oldChgAmt
	 */
	public String getOldChgAmt() {
		return this.oldChgAmt;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param chgRtSeq
	 */
	public void setChgRtSeq(String chgRtSeq) {
		this.chgRtSeq = chgRtSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
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
	 * @param cntrPerTpCd
	 */
	public void setCntrPerTpCd(String cntrPerTpCd) {
		this.cntrPerTpCd = cntrPerTpCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param declRmk
	 */
	public void setDeclRmk(String declRmk) {
		this.declRmk = declRmk;
	}
	
	/**
	 * Column Info
	 * @param whfDeclNo
	 */
	public void setWhfDeclNo(String whfDeclNo) {
		this.whfDeclNo = whfDeclNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param whfDeclIfFlg
	 */
	public void setWhfDeclIfFlg(String whfDeclIfFlg) {
		this.whfDeclIfFlg = whfDeclIfFlg;
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
	 * @param teuQty
	 */
	public void setTeuQty(String teuQty) {
		this.teuQty = teuQty;
	}
	
	/**
	 * Column Info
	 * @param whfDeclDt
	 */
	public void setWhfDeclDt(String whfDeclDt) {
		this.whfDeclDt = whfDeclDt;
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
	 * @param diffAmt
	 */
	public void setDiffAmt(String diffAmt) {
		this.diffAmt = diffAmt;
	}
	
	/**
	 * Column Info
	 * @param arIfFlg
	 */
	public void setArIfFlg(String arIfFlg) {
		this.arIfFlg = arIfFlg;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
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
	 * @param krWhfExptCd
	 */
	public void setKrWhfExptCd(String krWhfExptCd) {
		this.krWhfExptCd = krWhfExptCd;
	}
	
	/**
	 * Column Info
	 * @param arIfDt
	 */
	public void setArIfDt(String arIfDt) {
		this.arIfDt = arIfDt;
	}
	
	/**
	 * Column Info
	 * @param newChgAmt
	 */
	public void setNewChgAmt(String newChgAmt) {
		this.newChgAmt = newChgAmt;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param oldChgAmt
	 */
	public void setOldChgAmt(String oldChgAmt) {
		this.oldChgAmt = oldChgAmt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setChgRtSeq(JSPUtil.getParameter(request, "chg_rt_seq", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCntrPerTpCd(JSPUtil.getParameter(request, "cntr_per_tp_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setDeclRmk(JSPUtil.getParameter(request, "decl_rmk", ""));
		setWhfDeclNo(JSPUtil.getParameter(request, "whf_decl_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setWhfDeclIfFlg(JSPUtil.getParameter(request, "whf_decl_if_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTeuQty(JSPUtil.getParameter(request, "teu_qty", ""));
		setWhfDeclDt(JSPUtil.getParameter(request, "whf_decl_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiffAmt(JSPUtil.getParameter(request, "diff_amt", ""));
		setArIfFlg(JSPUtil.getParameter(request, "ar_if_flg", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setKrWhfExptCd(JSPUtil.getParameter(request, "kr_whf_expt_cd", ""));
		setArIfDt(JSPUtil.getParameter(request, "ar_if_dt", ""));
		setNewChgAmt(JSPUtil.getParameter(request, "new_chg_amt", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setOldChgAmt(JSPUtil.getParameter(request, "old_chg_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfRateVO[]
	 */
	public KrWhfRateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfRateVO[]
	 */
	public KrWhfRateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfRateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] chgRtSeq = (JSPUtil.getParameter(request, prefix	+ "chg_rt_seq", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntrPerTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_per_tp_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] declRmk = (JSPUtil.getParameter(request, prefix	+ "decl_rmk", length));
			String[] whfDeclNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] whfDeclIfFlg = (JSPUtil.getParameter(request, prefix	+ "whf_decl_if_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] teuQty = (JSPUtil.getParameter(request, prefix	+ "teu_qty", length));
			String[] whfDeclDt = (JSPUtil.getParameter(request, prefix	+ "whf_decl_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffAmt = (JSPUtil.getParameter(request, prefix	+ "diff_amt", length));
			String[] arIfFlg = (JSPUtil.getParameter(request, prefix	+ "ar_if_flg", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] krWhfExptCd = (JSPUtil.getParameter(request, prefix	+ "kr_whf_expt_cd", length));
			String[] arIfDt = (JSPUtil.getParameter(request, prefix	+ "ar_if_dt", length));
			String[] newChgAmt = (JSPUtil.getParameter(request, prefix	+ "new_chg_amt", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] oldChgAmt = (JSPUtil.getParameter(request, prefix	+ "old_chg_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfRateVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (chgRtSeq[i] != null)
					model.setChgRtSeq(chgRtSeq[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntrPerTpCd[i] != null)
					model.setCntrPerTpCd(cntrPerTpCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (declRmk[i] != null)
					model.setDeclRmk(declRmk[i]);
				if (whfDeclNo[i] != null)
					model.setWhfDeclNo(whfDeclNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (whfDeclIfFlg[i] != null)
					model.setWhfDeclIfFlg(whfDeclIfFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (teuQty[i] != null)
					model.setTeuQty(teuQty[i]);
				if (whfDeclDt[i] != null)
					model.setWhfDeclDt(whfDeclDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffAmt[i] != null)
					model.setDiffAmt(diffAmt[i]);
				if (arIfFlg[i] != null)
					model.setArIfFlg(arIfFlg[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (krWhfExptCd[i] != null)
					model.setKrWhfExptCd(krWhfExptCd[i]);
				if (arIfDt[i] != null)
					model.setArIfDt(arIfDt[i]);
				if (newChgAmt[i] != null)
					model.setNewChgAmt(newChgAmt[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (oldChgAmt[i] != null)
					model.setOldChgAmt(oldChgAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfRateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfRateVO[]
	 */
	public KrWhfRateVO[] getKrWhfRateVOs(){
		KrWhfRateVO[] vos = (KrWhfRateVO[])models.toArray(new KrWhfRateVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRtSeq = this.chgRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPerTpCd = this.cntrPerTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declRmk = this.declRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclNo = this.whfDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclIfFlg = this.whfDeclIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuQty = this.teuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclDt = this.whfDeclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffAmt = this.diffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfFlg = this.arIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krWhfExptCd = this.krWhfExptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfDt = this.arIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newChgAmt = this.newChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldChgAmt = this.oldChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
