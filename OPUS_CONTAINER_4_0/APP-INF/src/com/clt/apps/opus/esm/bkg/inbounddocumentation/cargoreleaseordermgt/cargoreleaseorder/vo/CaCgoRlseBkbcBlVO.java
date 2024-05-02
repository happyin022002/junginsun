/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CaCgoRlseBkbcBlVO.java
*@FileTitle : CaCgoRlseBkbcBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.10.20 박성호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
 
/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CaCgoRlseBkbcBlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaCgoRlseBkbcBlVO> models = new ArrayList<CaCgoRlseBkbcBlVO>();
	
	/* Column Info */
	private String ipiStatus = null;
	/* Column Info */
	private String cgorEdiSndCd = null;
	/* Column Info */
	private String newFrtCltFlg = null;
	/* Column Info */
	private String partialCnt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cstmsDspoCd = null;
	/* Column Info */
	private String newOblRdemFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String termId = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String oldCstmsClrCd = null;
	/* Column Info */
	private String partialClear = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldOblRdemFlg = null;
	/* Column Info */
	private String fincCtrlOfcCd = null;
	/* Column Info */
	private String newCstmsClrCd = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String allCInd = null;
	/* Column Info */
	private String fullRlseEdiCd = null;
	/* Column Info */
	private String cValue = null;
	/* Column Info */
	private String oldFrtCltFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CaCgoRlseBkbcBlVO() {}

	public CaCgoRlseBkbcBlVO(String ibflag, String pagerows, String blNo, String vvd, String podCd, String delCd, String fincCtrlOfcCd, String ipiStatus, String fullRlseEdiCd, String termId, String cValue, String cstmsDspoCd, String cgorEdiSndCd, String hisSeq, String partialCnt, String allCInd, String partialClear, String oldFrtCltFlg, String oldOblRdemFlg, String oldCstmsClrCd, String newFrtCltFlg, String newOblRdemFlg, String newCstmsClrCd) {
		this.ipiStatus = ipiStatus;
		this.cgorEdiSndCd = cgorEdiSndCd;
		this.newFrtCltFlg = newFrtCltFlg;
		this.partialCnt = partialCnt;
		this.delCd = delCd;
		this.blNo = blNo;
		this.cstmsDspoCd = cstmsDspoCd;
		this.newOblRdemFlg = newOblRdemFlg;
		this.pagerows = pagerows;
		this.termId = termId;
		this.vvd = vvd;
		this.podCd = podCd;
		this.oldCstmsClrCd = oldCstmsClrCd;
		this.partialClear = partialClear;
		this.ibflag = ibflag;
		this.oldOblRdemFlg = oldOblRdemFlg;
		this.fincCtrlOfcCd = fincCtrlOfcCd;
		this.newCstmsClrCd = newCstmsClrCd;
		this.hisSeq = hisSeq;
		this.allCInd = allCInd;
		this.fullRlseEdiCd = fullRlseEdiCd;
		this.cValue = cValue;
		this.oldFrtCltFlg = oldFrtCltFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ipi_status", getIpiStatus());
		this.hashColumns.put("cgor_edi_snd_cd", getCgorEdiSndCd());
		this.hashColumns.put("new_frt_clt_flg", getNewFrtCltFlg());
		this.hashColumns.put("partial_cnt", getPartialCnt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cstms_dspo_cd", getCstmsDspoCd());
		this.hashColumns.put("new_obl_rdem_flg", getNewOblRdemFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("term_id", getTermId());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("old_cstms_clr_cd", getOldCstmsClrCd());
		this.hashColumns.put("partial_clear", getPartialClear());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("old_obl_rdem_flg", getOldOblRdemFlg());
		this.hashColumns.put("finc_ctrl_ofc_cd", getFincCtrlOfcCd());
		this.hashColumns.put("new_cstms_clr_cd", getNewCstmsClrCd());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("all_c_ind", getAllCInd());
		this.hashColumns.put("full_rlse_edi_cd", getFullRlseEdiCd());
		this.hashColumns.put("c_value", getCValue());
		this.hashColumns.put("old_frt_clt_flg", getOldFrtCltFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ipi_status", "ipiStatus");
		this.hashFields.put("cgor_edi_snd_cd", "cgorEdiSndCd");
		this.hashFields.put("new_frt_clt_flg", "newFrtCltFlg");
		this.hashFields.put("partial_cnt", "partialCnt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cstms_dspo_cd", "cstmsDspoCd");
		this.hashFields.put("new_obl_rdem_flg", "newOblRdemFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("term_id", "termId");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("old_cstms_clr_cd", "oldCstmsClrCd");
		this.hashFields.put("partial_clear", "partialClear");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("old_obl_rdem_flg", "oldOblRdemFlg");
		this.hashFields.put("finc_ctrl_ofc_cd", "fincCtrlOfcCd");
		this.hashFields.put("new_cstms_clr_cd", "newCstmsClrCd");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("all_c_ind", "allCInd");
		this.hashFields.put("full_rlse_edi_cd", "fullRlseEdiCd");
		this.hashFields.put("c_value", "cValue");
		this.hashFields.put("old_frt_clt_flg", "oldFrtCltFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ipiStatus
	 */
	public String getIpiStatus() {
		return this.ipiStatus;
	}
	
	/**
	 * Column Info
	 * @return cgorEdiSndCd
	 */
	public String getCgorEdiSndCd() {
		return this.cgorEdiSndCd;
	}
	
	/**
	 * Column Info
	 * @return newFrtCltFlg
	 */
	public String getNewFrtCltFlg() {
		return this.newFrtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return partialCnt
	 */
	public String getPartialCnt() {
		return this.partialCnt;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsDspoCd
	 */
	public String getCstmsDspoCd() {
		return this.cstmsDspoCd;
	}
	
	/**
	 * Column Info
	 * @return newOblRdemFlg
	 */
	public String getNewOblRdemFlg() {
		return this.newOblRdemFlg;
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
	 * @return termId
	 */
	public String getTermId() {
		return this.termId;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return oldCstmsClrCd
	 */
	public String getOldCstmsClrCd() {
		return this.oldCstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @return partialClear
	 */
	public String getPartialClear() {
		return this.partialClear;
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
	 * @return oldOblRdemFlg
	 */
	public String getOldOblRdemFlg() {
		return this.oldOblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return fincCtrlOfcCd
	 */
	public String getFincCtrlOfcCd() {
		return this.fincCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return newCstmsClrCd
	 */
	public String getNewCstmsClrCd() {
		return this.newCstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return allCInd
	 */
	public String getAllCInd() {
		return this.allCInd;
	}
	
	/**
	 * Column Info
	 * @return fullRlseEdiCd
	 */
	public String getFullRlseEdiCd() {
		return this.fullRlseEdiCd;
	}
	
	/**
	 * Column Info
	 * @return cValue
	 */
	public String getCValue() {
		return this.cValue;
	}
	
	/**
	 * Column Info
	 * @return oldFrtCltFlg
	 */
	public String getOldFrtCltFlg() {
		return this.oldFrtCltFlg;
	}
	

	/**
	 * Column Info
	 * @param ipiStatus
	 */
	public void setIpiStatus(String ipiStatus) {
		this.ipiStatus = ipiStatus;
	}
	
	/**
	 * Column Info
	 * @param cgorEdiSndCd
	 */
	public void setCgorEdiSndCd(String cgorEdiSndCd) {
		this.cgorEdiSndCd = cgorEdiSndCd;
	}
	
	/**
	 * Column Info
	 * @param newFrtCltFlg
	 */
	public void setNewFrtCltFlg(String newFrtCltFlg) {
		this.newFrtCltFlg = newFrtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param partialCnt
	 */
	public void setPartialCnt(String partialCnt) {
		this.partialCnt = partialCnt;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsDspoCd
	 */
	public void setCstmsDspoCd(String cstmsDspoCd) {
		this.cstmsDspoCd = cstmsDspoCd;
	}
	
	/**
	 * Column Info
	 * @param newOblRdemFlg
	 */
	public void setNewOblRdemFlg(String newOblRdemFlg) {
		this.newOblRdemFlg = newOblRdemFlg;
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
	 * @param termId
	 */
	public void setTermId(String termId) {
		this.termId = termId;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param oldCstmsClrCd
	 */
	public void setOldCstmsClrCd(String oldCstmsClrCd) {
		this.oldCstmsClrCd = oldCstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @param partialClear
	 */
	public void setPartialClear(String partialClear) {
		this.partialClear = partialClear;
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
	 * @param oldOblRdemFlg
	 */
	public void setOldOblRdemFlg(String oldOblRdemFlg) {
		this.oldOblRdemFlg = oldOblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param fincCtrlOfcCd
	 */
	public void setFincCtrlOfcCd(String fincCtrlOfcCd) {
		this.fincCtrlOfcCd = fincCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param newCstmsClrCd
	 */
	public void setNewCstmsClrCd(String newCstmsClrCd) {
		this.newCstmsClrCd = newCstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param allCInd
	 */
	public void setAllCInd(String allCInd) {
		this.allCInd = allCInd;
	}
	
	/**
	 * Column Info
	 * @param fullRlseEdiCd
	 */
	public void setFullRlseEdiCd(String fullRlseEdiCd) {
		this.fullRlseEdiCd = fullRlseEdiCd;
	}
	
	/**
	 * Column Info
	 * @param cValue
	 */
	public void setCValue(String cValue) {
		this.cValue = cValue;
	}
	
	/**
	 * Column Info
	 * @param oldFrtCltFlg
	 */
	public void setOldFrtCltFlg(String oldFrtCltFlg) {
		this.oldFrtCltFlg = oldFrtCltFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIpiStatus(JSPUtil.getParameter(request, "ipi_status", ""));
		setCgorEdiSndCd(JSPUtil.getParameter(request, "cgor_edi_snd_cd", ""));
		setNewFrtCltFlg(JSPUtil.getParameter(request, "new_frt_clt_flg", ""));
		setPartialCnt(JSPUtil.getParameter(request, "partial_cnt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCstmsDspoCd(JSPUtil.getParameter(request, "cstms_dspo_cd", ""));
		setNewOblRdemFlg(JSPUtil.getParameter(request, "new_obl_rdem_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTermId(JSPUtil.getParameter(request, "term_id", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOldCstmsClrCd(JSPUtil.getParameter(request, "old_cstms_clr_cd", ""));
		setPartialClear(JSPUtil.getParameter(request, "partial_clear", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOldOblRdemFlg(JSPUtil.getParameter(request, "old_obl_rdem_flg", ""));
		setFincCtrlOfcCd(JSPUtil.getParameter(request, "finc_ctrl_ofc_cd", ""));
		setNewCstmsClrCd(JSPUtil.getParameter(request, "new_cstms_clr_cd", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setAllCInd(JSPUtil.getParameter(request, "all_c_ind", ""));
		setFullRlseEdiCd(JSPUtil.getParameter(request, "full_rlse_edi_cd", ""));
		setCValue(JSPUtil.getParameter(request, "c_value", ""));
		setOldFrtCltFlg(JSPUtil.getParameter(request, "old_frt_clt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaCgoRlseBkbcBlVO[]
	 */
	public CaCgoRlseBkbcBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaCgoRlseBkbcBlVO[]
	 */
	public CaCgoRlseBkbcBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaCgoRlseBkbcBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ipiStatus = (JSPUtil.getParameter(request, prefix	+ "ipi_status", length));
			String[] cgorEdiSndCd = (JSPUtil.getParameter(request, prefix	+ "cgor_edi_snd_cd", length));
			String[] newFrtCltFlg = (JSPUtil.getParameter(request, prefix	+ "new_frt_clt_flg", length));
			String[] partialCnt = (JSPUtil.getParameter(request, prefix	+ "partial_cnt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cstmsDspoCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dspo_cd", length));
			String[] newOblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "new_obl_rdem_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] termId = (JSPUtil.getParameter(request, prefix	+ "term_id", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] oldCstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "old_cstms_clr_cd", length));
			String[] partialClear = (JSPUtil.getParameter(request, prefix	+ "partial_clear", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldOblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "old_obl_rdem_flg", length));
			String[] fincCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "finc_ctrl_ofc_cd", length));
			String[] newCstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "new_cstms_clr_cd", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] allCInd = (JSPUtil.getParameter(request, prefix	+ "all_c_ind", length));
			String[] fullRlseEdiCd = (JSPUtil.getParameter(request, prefix	+ "full_rlse_edi_cd", length));
			String[] cValue = (JSPUtil.getParameter(request, prefix	+ "c_value", length));
			String[] oldFrtCltFlg = (JSPUtil.getParameter(request, prefix	+ "old_frt_clt_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaCgoRlseBkbcBlVO();
				if (ipiStatus[i] != null)
					model.setIpiStatus(ipiStatus[i]);
				if (cgorEdiSndCd[i] != null)
					model.setCgorEdiSndCd(cgorEdiSndCd[i]);
				if (newFrtCltFlg[i] != null)
					model.setNewFrtCltFlg(newFrtCltFlg[i]);
				if (partialCnt[i] != null)
					model.setPartialCnt(partialCnt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cstmsDspoCd[i] != null)
					model.setCstmsDspoCd(cstmsDspoCd[i]);
				if (newOblRdemFlg[i] != null)
					model.setNewOblRdemFlg(newOblRdemFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (termId[i] != null)
					model.setTermId(termId[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (oldCstmsClrCd[i] != null)
					model.setOldCstmsClrCd(oldCstmsClrCd[i]);
				if (partialClear[i] != null)
					model.setPartialClear(partialClear[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldOblRdemFlg[i] != null)
					model.setOldOblRdemFlg(oldOblRdemFlg[i]);
				if (fincCtrlOfcCd[i] != null)
					model.setFincCtrlOfcCd(fincCtrlOfcCd[i]);
				if (newCstmsClrCd[i] != null)
					model.setNewCstmsClrCd(newCstmsClrCd[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (allCInd[i] != null)
					model.setAllCInd(allCInd[i]);
				if (fullRlseEdiCd[i] != null)
					model.setFullRlseEdiCd(fullRlseEdiCd[i]);
				if (cValue[i] != null)
					model.setCValue(cValue[i]);
				if (oldFrtCltFlg[i] != null)
					model.setOldFrtCltFlg(oldFrtCltFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaCgoRlseBkbcBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaCgoRlseBkbcBlVO[]
	 */
	public CaCgoRlseBkbcBlVO[] getCaCgoRlseBkbcBlVOs(){
		CaCgoRlseBkbcBlVO[] vos = (CaCgoRlseBkbcBlVO[])models.toArray(new CaCgoRlseBkbcBlVO[models.size()]);
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
		this.ipiStatus = this.ipiStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgorEdiSndCd = this.cgorEdiSndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newFrtCltFlg = this.newFrtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partialCnt = this.partialCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDspoCd = this.cstmsDspoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newOblRdemFlg = this.newOblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termId = this.termId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCstmsClrCd = this.oldCstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.partialClear = this.partialClear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOblRdemFlg = this.oldOblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincCtrlOfcCd = this.fincCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newCstmsClrCd = this.newCstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allCInd = this.allCInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRlseEdiCd = this.fullRlseEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cValue = this.cValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldFrtCltFlg = this.oldFrtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
