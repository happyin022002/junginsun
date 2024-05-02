/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GlineRevInVO.java
*@FileTitle : GlineRevInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.04  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

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

public class GlineRevInVO extends AbstractValueObject { 

	private static final long serialVersionUID = 1L;
	
	private Collection<GlineRevInVO> models = new ArrayList<GlineRevInVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String trspModeCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pntLocCd = null;
	/* Column Info */
	private String dryFlag = null;
	/* Column Info */
	private String dgFlag = null;
	/* Column Info */
	private String rfFlag = null;
	/* Column Info */
	private String bsePortLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String awkFlag = null;
	/* Column Info */
	private String optmFlag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String trspChgFlg = null;
	/* Column Info */
	private String addRevAmt = null;
	/* Column Info */
	private String addRevAmt2 = null;
	/* Column Info */
	private String addRevAmt3 = null;
	/* Column Info */
	private String multiRev = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GlineRevInVO() {}

	public GlineRevInVO(String ibflag, String pagerows, String bkgNo, String cfmDt, String bsePortLocCd, String pntLocCd, String trspModeCd, String cntrTpszCd, String dryFlag, String dgFlag, String rfFlag, String ioBndCd, String awkFlag, String optmFlag, String cntrNo, String trspChgFlg, String addRevAmt, String multiRev, String addRevAmt2, String addRevAmt3) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cfmDt = cfmDt;
		this.trspModeCd = trspModeCd;
		this.cntrTpszCd = cntrTpszCd;
		this.pntLocCd = pntLocCd;
		this.dryFlag = dryFlag;
		this.dgFlag = dgFlag;
		this.rfFlag = rfFlag;
		this.bsePortLocCd = bsePortLocCd;
		this.pagerows = pagerows;
		this.ioBndCd = ioBndCd;
		this.awkFlag = awkFlag;
		this.optmFlag = optmFlag;
		this.cntrNo = cntrNo;
		this.trspChgFlg = trspChgFlg;
		this.addRevAmt = addRevAmt;
		this.addRevAmt2 = addRevAmt2;
		this.addRevAmt3 = addRevAmt3;
		this.multiRev = multiRev;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("trsp_mode_cd", getTrspModeCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pnt_loc_cd", getPntLocCd());
		this.hashColumns.put("dry_flag", getDryFlag());
		this.hashColumns.put("dg_flag", getDgFlag());
		this.hashColumns.put("rf_flag", getRfFlag());
		this.hashColumns.put("bse_port_loc_cd", getBsePortLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("awk_flag", getAwkFlag());
		this.hashColumns.put("optm_flag", getOptmFlag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("trsp_chg_flg", getTrspChgFlg());
		this.hashColumns.put("add_rev_amt", getAddRevAmt());
		this.hashColumns.put("add_rev_amt2", getAddRevAmt2());
		this.hashColumns.put("add_rev_amt3", getAddRevAmt3());
		this.hashColumns.put("multi_rev", getMultiRev());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("trsp_mode_cd", "trspModeCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pnt_loc_cd", "pntLocCd");
		this.hashFields.put("dry_flag", "dryFlag");
		this.hashFields.put("dg_flag", "dgFlag");
		this.hashFields.put("rf_flag", "rfFlag");
		this.hashFields.put("bse_port_loc_cd", "bsePortLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("awk_flag", "awkFlag");
		this.hashFields.put("optm_flag", "optmFlag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("trsp_chg_flg", "trspChgFlg");
		this.hashFields.put("add_rev_amt", "addRevAmt");
		this.hashFields.put("add_rev_amt2", "addRevAmt2");
		this.hashFields.put("add_rev_amt3", "addRevAmt3");
		this.hashFields.put("multi_rev", "multiRev");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return trspModeCd
	 */
	public String getTrspModeCd() {
		return this.trspModeCd;
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
	 * @return pntLocCd
	 */
	public String getPntLocCd() {
		return this.pntLocCd;
	}
	
	/**
	 * Column Info
	 * @return dryFlag
	 */
	public String getDryFlag() {
		return this.dryFlag;
	}
	
	/**
	 * Column Info
	 * @return dgFlag
	 */
	public String getDgFlag() {
		return this.dgFlag;
	}
	
	/**
	 * Column Info
	 * @return rfFlag
	 */
	public String getRfFlag() {
		return this.rfFlag;
	}
	
	/**
	 * Column Info
	 * @return bsePortLocCd
	 */
	public String getBsePortLocCd() {
		return this.bsePortLocCd;
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
	 * @return trspChgFlg
	 */
	public String getTrspChgFlg() {
		return trspChgFlg;
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
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return ioBndCd;
	}

	/**
	 * @Column Info
	 * @return awkFlag
	 */
	public String getAwkFlag() {
		return awkFlag;
	}
	
	/**
	 * @Column Info
	 * @return optmFlag
	 */
	public String getOptmFlag() {
		return optmFlag;
	}
	
	/**
	 * @Column Info
	 * @return addRevAmt
	 */
	public String getAddRevAmt() {
		return addRevAmt;
	}
	
	/**
	 * @Column Info
	 * @return addRevAmt3
	 */
	public String getAddRevAmt3() {
		return addRevAmt3;
	}
	
	/**
	 * @Column Info
	 * @return addRevAmt2
	 */
	public String getAddRevAmt2() {
		return addRevAmt2;
	}

	/**
	 * @Column Info
	 * @return multiRev
	 */
	public String getMultiRev() {
		return multiRev;
	}

	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param trspModeCd
	 */
	public void setTrspModeCd(String trspModeCd) {
		this.trspModeCd = trspModeCd;
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
	 * @param pntLocCd
	 */
	public void setPntLocCd(String pntLocCd) {
		this.pntLocCd = pntLocCd;
	}
	
	/**
	 * Column Info
	 * @param dryFlag
	 */
	public void setDryFlag(String dryFlag) {
		this.dryFlag = dryFlag;
	}
	
	/**
	 * Column Info
	 * @param dgFlag
	 */
	public void setDgFlag(String dgFlag) {
		this.dgFlag = dgFlag;
	}
	
	/**
	 * Column Info
	 * @param rfFlag
	 */
	public void setRfFlag(String rfFlag) {
		this.rfFlag = rfFlag;
	}
	
	/**
	 * Column Info
	 * @param bsePortLocCd
	 */
	public void setBsePortLocCd(String bsePortLocCd) {
		this.bsePortLocCd = bsePortLocCd;
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
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param awkFlag
	 */
	public void setAwkFlag(String awkFlag) {
		this.awkFlag = awkFlag;
	}

	/**
	 * Column Info
	 * @param optmFlag
	 */
	public void setOptmFlag(String optmFlag) {
		this.optmFlag = optmFlag;
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
	 * @param trspChgFlg
	 */
	public void setTrspChgFlg(String trspChgFlg) {
		this.trspChgFlg = trspChgFlg;
	}
	
	/**
	 * Column Info
	 * @param addRevAmt
	 */
	public void setAddRevAmt(String addRevAmt) {
		this.addRevAmt = addRevAmt;
	}
	
	/**
	 * Column Info
	 * @param addRevAmt
	 */
	public void setAddRevAmt2(String addRevAmt2) {
		this.addRevAmt2 = addRevAmt2;
	}
	
	/**
	 * Column Info
	 * @param addRevAmt
	 */
	public void setAddRevAmt3(String addRevAmt3) {
		this.addRevAmt3 = addRevAmt3;
	}

	/**
	 * Column Info
	 * @param multiRev
	 */
	public void setMultiRev(String multiRev) {
		this.multiRev = multiRev;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setTrspModeCd(JSPUtil.getParameter(request, prefix + "trsp_mode_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPntLocCd(JSPUtil.getParameter(request, prefix + "pnt_loc_cd", ""));
		setDryFlag(JSPUtil.getParameter(request, prefix + "dry_flag", ""));
		setDgFlag(JSPUtil.getParameter(request, prefix + "dg_flag", ""));
		setRfFlag(JSPUtil.getParameter(request, prefix + "rf_flag", ""));
		setBsePortLocCd(JSPUtil.getParameter(request, prefix + "bse_port_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setAwkFlag(JSPUtil.getParameter(request, prefix + "awk_flag", ""));
		setOptmFlag(JSPUtil.getParameter(request, prefix + "optm_flag", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setTrspChgFlg(JSPUtil.getParameter(request, prefix + "trsp_chg_flg", ""));
		setAddRevAmt(JSPUtil.getParameter(request, prefix + "add_rev_amt", ""));
		setAddRevAmt2(JSPUtil.getParameter(request, prefix + "add_rev_amt2", ""));
		setAddRevAmt3(JSPUtil.getParameter(request, prefix + "add_rev_amt3", ""));
		setMultiRev(JSPUtil.getParameter(request, prefix + "multi_rev", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GlineRevInVO[]
	 */
	public GlineRevInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GlineRevInVO[]
	 */
	public GlineRevInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GlineRevInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] trspModeCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mode_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pntLocCd = (JSPUtil.getParameter(request, prefix	+ "pnt_loc_cd", length));
			String[] dryFlag = (JSPUtil.getParameter(request, prefix	+ "dry_flag", length));
			String[] dgFlag = (JSPUtil.getParameter(request, prefix	+ "dg_flag", length));
			String[] rfFlag = (JSPUtil.getParameter(request, prefix	+ "rf_flag", length));
			String[] bsePortLocCd = (JSPUtil.getParameter(request, prefix	+ "bse_port_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] awkFlag = (JSPUtil.getParameter(request, prefix	+ "awk_flag", length));
			String[] optmFlag = (JSPUtil.getParameter(request, prefix	+ "optm_flag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] trspChgFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_chg_flg", length));
			String[] addRevAmt = (JSPUtil.getParameter(request, prefix	+ "add_rev_amt", length));
			String[] addRevAmt2 = (JSPUtil.getParameter(request, prefix	+ "add_rev_amt2", length));
			String[] addRevAmt3 = (JSPUtil.getParameter(request, prefix	+ "add_rev_amt3", length));
			String[] multiRev = (JSPUtil.getParameter(request, prefix	+ "multi_rev", length));
			
			for (int i = 0; i < length; i++) {
				model = new GlineRevInVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (trspModeCd[i] != null)
					model.setTrspModeCd(trspModeCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pntLocCd[i] != null)
					model.setPntLocCd(pntLocCd[i]);
				if (dryFlag[i] != null)
					model.setDryFlag(dryFlag[i]);
				if (dgFlag[i] != null)
					model.setDgFlag(dgFlag[i]);
				if (rfFlag[i] != null)
					model.setRfFlag(rfFlag[i]);
				if (bsePortLocCd[i] != null)
					model.setBsePortLocCd(bsePortLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (awkFlag[i] != null)
					model.setAwkFlag(awkFlag[i]);
				if (optmFlag[i] != null)
					model.setOptmFlag(optmFlag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (trspChgFlg[i] != null)
					model.setTrspChgFlg(trspChgFlg[i]);
				if (addRevAmt[i] != null)
					model.setAddRevAmt(addRevAmt[i]);
				if (addRevAmt2[i] != null)
					model.setAddRevAmt2(addRevAmt2[i]);
				if (addRevAmt3[i] != null)
					model.setAddRevAmt3(addRevAmt3[i]);
				if (multiRev[i] != null)
					model.setMultiRev(multiRev[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGlineRevInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GlineRevInVO[]
	 */
	public GlineRevInVO[] getGlineRevInVOs(){
		GlineRevInVO[] vos = (GlineRevInVO[])models.toArray(new GlineRevInVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModeCd = this.trspModeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pntLocCd = this.pntLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dryFlag = this.dryFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgFlag = this.dgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfFlag = this.rfFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortLocCd = this.bsePortLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkFlag = this.awkFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmFlag = this.optmFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspChgFlg = this.trspChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevAmt = this.addRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevAmt2 = this.addRevAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevAmt3 = this.addRevAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multiRev = this.multiRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
