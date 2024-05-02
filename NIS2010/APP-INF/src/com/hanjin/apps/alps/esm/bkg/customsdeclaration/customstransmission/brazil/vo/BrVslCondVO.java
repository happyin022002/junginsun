/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BrVslCondVO.java
*@FileTitle : BrVslCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.02
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.12.02 김보배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo;

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
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BrVslCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrVslCondVO> models = new ArrayList<BrVslCondVO>();
	
	/* Column Info */
	private String compId = null;
	/* Column Info */
	private String bkgCgoTp = null;
	/* Column Info */
	private String bkgSpeBb = null;
	/* Column Info */
	private String searchPodCd = null;
	/* Column Info */
	private String modeType = null;
	/* Column Info */
	private String cntGubun = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrMfSeq = null;
	/* Column Info */
	private String bkgSpeDg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String hideCheck = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String bkgSpeRd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bkgSpeRf = null;
	/* Column Info */
	private String hiddenRateType = null;
	/* Column Info */
	private String bkgSpeAk = null;
	/* Column Info */
	private String ediSendId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrVslCondVO() {}

	public BrVslCondVO(String ibflag, String pagerows, String compId, String bkgCgoTp, String bkgSpeBb, String blNo, String bkgSpeDg, String podCd, String bkgNo, String polCd, String vvdCd, String bkgSpeRd, String cmdtCd, String cmdtDesc, String cntrNo, String bkgSpeRf, String bkgSpeAk, String hiddenRateType, String hideCheck, String ediSendId, String cntGubun, String searchPodCd, String cntrMfSeq, String modeType) {
		this.compId = compId;
		this.bkgCgoTp = bkgCgoTp;
		this.bkgSpeBb = bkgSpeBb;
		this.searchPodCd = searchPodCd;
		this.modeType = modeType;
		this.cntGubun = cntGubun;
		this.blNo = blNo;
		this.cntrMfSeq = cntrMfSeq;
		this.bkgSpeDg = bkgSpeDg;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.hideCheck = hideCheck;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.cmdtDesc = cmdtDesc;
		this.bkgSpeRd = bkgSpeRd;
		this.cmdtCd = cmdtCd;
		this.cntrNo = cntrNo;
		this.bkgSpeRf = bkgSpeRf;
		this.hiddenRateType = hiddenRateType;
		this.bkgSpeAk = bkgSpeAk;
		this.ediSendId = ediSendId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("comp_id", getCompId());
		this.hashColumns.put("bkg_cgo_tp", getBkgCgoTp());
		this.hashColumns.put("bkg_spe_bb", getBkgSpeBb());
		this.hashColumns.put("search_pod_cd", getSearchPodCd());
		this.hashColumns.put("mode_type", getModeType());
		this.hashColumns.put("cnt_gubun", getCntGubun());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("bkg_spe_dg", getBkgSpeDg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("hide_check", getHideCheck());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("bkg_spe_rd", getBkgSpeRd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bkg_spe_rf", getBkgSpeRf());
		this.hashColumns.put("hidden_rate_type", getHiddenRateType());
		this.hashColumns.put("bkg_spe_ak", getBkgSpeAk());
		this.hashColumns.put("edi_send_id", getEdiSendId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("comp_id", "compId");
		this.hashFields.put("bkg_cgo_tp", "bkgCgoTp");
		this.hashFields.put("bkg_spe_bb", "bkgSpeBb");
		this.hashFields.put("search_pod_cd", "searchPodCd");
		this.hashFields.put("mode_type", "modeType");
		this.hashFields.put("cnt_gubun", "cntGubun");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("bkg_spe_dg", "bkgSpeDg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("hide_check", "hideCheck");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("bkg_spe_rd", "bkgSpeRd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bkg_spe_rf", "bkgSpeRf");
		this.hashFields.put("hidden_rate_type", "hiddenRateType");
		this.hashFields.put("bkg_spe_ak", "bkgSpeAk");
		this.hashFields.put("edi_send_id", "ediSendId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return compId
	 */
	public String getCompId() {
		return this.compId;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTp
	 */
	public String getBkgCgoTp() {
		return this.bkgCgoTp;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeBb
	 */
	public String getBkgSpeBb() {
		return this.bkgSpeBb;
	}
	
	/**
	 * Column Info
	 * @return searchPodCd
	 */
	public String getSearchPodCd() {
		return this.searchPodCd;
	}
	
	/**
	 * Column Info
	 * @return modeType
	 */
	public String getModeType() {
		return this.modeType;
	}
	
	/**
	 * Column Info
	 * @return cntGubun
	 */
	public String getCntGubun() {
		return this.cntGubun;
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
	 * @return cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeDg
	 */
	public String getBkgSpeDg() {
		return this.bkgSpeDg;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return hideCheck
	 */
	public String getHideCheck() {
		return this.hideCheck;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeRd
	 */
	public String getBkgSpeRd() {
		return this.bkgSpeRd;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeRf
	 */
	public String getBkgSpeRf() {
		return this.bkgSpeRf;
	}
	
	/**
	 * Column Info
	 * @return hiddenRateType
	 */
	public String getHiddenRateType() {
		return this.hiddenRateType;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeAk
	 */
	public String getBkgSpeAk() {
		return this.bkgSpeAk;
	}
	
	/**
	 * Column Info
	 * @return ediSendId
	 */
	public String getEdiSendId() {
		return this.ediSendId;
	}
	

	/**
	 * Column Info
	 * @param compId
	 */
	public void setCompId(String compId) {
		this.compId = compId;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTp
	 */
	public void setBkgCgoTp(String bkgCgoTp) {
		this.bkgCgoTp = bkgCgoTp;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeBb
	 */
	public void setBkgSpeBb(String bkgSpeBb) {
		this.bkgSpeBb = bkgSpeBb;
	}
	
	/**
	 * Column Info
	 * @param searchPodCd
	 */
	public void setSearchPodCd(String searchPodCd) {
		this.searchPodCd = searchPodCd;
	}
	
	/**
	 * Column Info
	 * @param modeType
	 */
	public void setModeType(String modeType) {
		this.modeType = modeType;
	}
	
	/**
	 * Column Info
	 * @param cntGubun
	 */
	public void setCntGubun(String cntGubun) {
		this.cntGubun = cntGubun;
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
	 * @param cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeDg
	 */
	public void setBkgSpeDg(String bkgSpeDg) {
		this.bkgSpeDg = bkgSpeDg;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param hideCheck
	 */
	public void setHideCheck(String hideCheck) {
		this.hideCheck = hideCheck;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeRd
	 */
	public void setBkgSpeRd(String bkgSpeRd) {
		this.bkgSpeRd = bkgSpeRd;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeRf
	 */
	public void setBkgSpeRf(String bkgSpeRf) {
		this.bkgSpeRf = bkgSpeRf;
	}
	
	/**
	 * Column Info
	 * @param hiddenRateType
	 */
	public void setHiddenRateType(String hiddenRateType) {
		this.hiddenRateType = hiddenRateType;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeAk
	 */
	public void setBkgSpeAk(String bkgSpeAk) {
		this.bkgSpeAk = bkgSpeAk;
	}
	
	/**
	 * Column Info
	 * @param ediSendId
	 */
	public void setEdiSendId(String ediSendId) {
		this.ediSendId = ediSendId;
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
		setCompId(JSPUtil.getParameter(request, prefix + "comp_id", ""));
		setBkgCgoTp(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp", ""));
		setBkgSpeBb(JSPUtil.getParameter(request, prefix + "bkg_spe_bb", ""));
		setSearchPodCd(JSPUtil.getParameter(request, prefix + "search_pod_cd", ""));
		setModeType(JSPUtil.getParameter(request, prefix + "mode_type", ""));
		setCntGubun(JSPUtil.getParameter(request, prefix + "cnt_gubun", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, prefix + "cntr_mf_seq", ""));
		setBkgSpeDg(JSPUtil.getParameter(request, prefix + "bkg_spe_dg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setHideCheck(JSPUtil.getParameter(request, prefix + "hide_check", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
		setBkgSpeRd(JSPUtil.getParameter(request, prefix + "bkg_spe_rd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setBkgSpeRf(JSPUtil.getParameter(request, prefix + "bkg_spe_rf", ""));
		setHiddenRateType(JSPUtil.getParameter(request, prefix + "hidden_rate_type", ""));
		setBkgSpeAk(JSPUtil.getParameter(request, prefix + "bkg_spe_ak", ""));
		setEdiSendId(JSPUtil.getParameter(request, prefix + "edi_send_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrVslCondVO[]
	 */
	public BrVslCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrVslCondVO[]
	 */
	public BrVslCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrVslCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] compId = (JSPUtil.getParameter(request, prefix	+ "comp_id", length));
			String[] bkgCgoTp = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp", length));
			String[] bkgSpeBb = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_bb", length));
			String[] searchPodCd = (JSPUtil.getParameter(request, prefix	+ "search_pod_cd", length));
			String[] modeType = (JSPUtil.getParameter(request, prefix	+ "mode_type", length));
			String[] cntGubun = (JSPUtil.getParameter(request, prefix	+ "cnt_gubun", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq", length));
			String[] bkgSpeDg = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_dg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] hideCheck = (JSPUtil.getParameter(request, prefix	+ "hide_check", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] bkgSpeRd = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_rd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bkgSpeRf = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_rf", length));
			String[] hiddenRateType = (JSPUtil.getParameter(request, prefix	+ "hidden_rate_type", length));
			String[] bkgSpeAk = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_ak", length));
			String[] ediSendId = (JSPUtil.getParameter(request, prefix	+ "edi_send_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new BrVslCondVO();
				if (compId[i] != null)
					model.setCompId(compId[i]);
				if (bkgCgoTp[i] != null)
					model.setBkgCgoTp(bkgCgoTp[i]);
				if (bkgSpeBb[i] != null)
					model.setBkgSpeBb(bkgSpeBb[i]);
				if (searchPodCd[i] != null)
					model.setSearchPodCd(searchPodCd[i]);
				if (modeType[i] != null)
					model.setModeType(modeType[i]);
				if (cntGubun[i] != null)
					model.setCntGubun(cntGubun[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrMfSeq[i] != null)
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (bkgSpeDg[i] != null)
					model.setBkgSpeDg(bkgSpeDg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (hideCheck[i] != null)
					model.setHideCheck(hideCheck[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (bkgSpeRd[i] != null)
					model.setBkgSpeRd(bkgSpeRd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bkgSpeRf[i] != null)
					model.setBkgSpeRf(bkgSpeRf[i]);
				if (hiddenRateType[i] != null)
					model.setHiddenRateType(hiddenRateType[i]);
				if (bkgSpeAk[i] != null)
					model.setBkgSpeAk(bkgSpeAk[i]);
				if (ediSendId[i] != null)
					model.setEdiSendId(ediSendId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBrVslCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BrVslCondVO[]
	 */
	public BrVslCondVO[] getBrVslCondVOs(){
		BrVslCondVO[] vos = (BrVslCondVO[])models.toArray(new BrVslCondVO[models.size()]);
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
		this.compId = this.compId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTp = this.bkgCgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeBb = this.bkgSpeBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchPodCd = this.searchPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.modeType = this.modeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntGubun = this.cntGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeDg = this.bkgSpeDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hideCheck = this.hideCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeRd = this.bkgSpeRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeRf = this.bkgSpeRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hiddenRateType = this.hiddenRateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeAk = this.bkgSpeAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSendId = this.ediSendId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
