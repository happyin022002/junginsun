/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ScgPrnrRqstCgoUnmapVO.java
*@FileTitle : ScgPrnrRqstCgoUnmapVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgPrnrRqstCgoUnmapVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPrnrRqstCgoUnmapVO> models = new ArrayList<ScgPrnrRqstCgoUnmapVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String spclCgoRqstSeq = null;
	/* Column Info */
	private String spclCgoSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String spclCntrSeq = null;
	/* Column Info */
	private String edwUpdDt = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ediUnmapSeq = null;
	/* Column Info */
	private String bkgRefNo = null;
	/* Column Info */
	private String ediUnmapCorrRsltCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediUnmapCorrDt = null;
	/* Column Info */
	private String prnrCgoRqstSeq = null;
	/* Column Info */
	private String ediUnmapDtlCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ScgPrnrRqstCgoUnmapVO() {}

	public ScgPrnrRqstCgoUnmapVO(String ibflag, String pagerows, String crrCd, String bkgRefNo, String spclCgoRqstSeq, String spclCntrSeq, String spclCgoSeq, String prnrCgoRqstSeq, String ediUnmapSeq, String ediUnmapDtlCd, String ediUnmapCorrRsltCd, String ediUnmapCorrDt, String creUsrId, String creDt, String updUsrId, String updDt, String edwUpdDt) {
		this.updDt = updDt;
		this.spclCgoRqstSeq = spclCgoRqstSeq;
		this.spclCgoSeq = spclCgoSeq;
		this.creDt = creDt;
		this.spclCntrSeq = spclCntrSeq;
		this.edwUpdDt = edwUpdDt;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
		this.ediUnmapSeq = ediUnmapSeq;
		this.bkgRefNo = bkgRefNo;
		this.ediUnmapCorrRsltCd = ediUnmapCorrRsltCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.ediUnmapCorrDt = ediUnmapCorrDt;
		this.prnrCgoRqstSeq = prnrCgoRqstSeq;
		this.ediUnmapDtlCd = ediUnmapDtlCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("spcl_cgo_rqst_seq", getSpclCgoRqstSeq());
		this.hashColumns.put("spcl_cgo_seq", getSpclCgoSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("spcl_cntr_seq", getSpclCntrSeq());
		this.hashColumns.put("edw_upd_dt", getEdwUpdDt());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("edi_unmap_seq", getEdiUnmapSeq());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("edi_unmap_corr_rslt_cd", getEdiUnmapCorrRsltCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_unmap_corr_dt", getEdiUnmapCorrDt());
		this.hashColumns.put("prnr_cgo_rqst_seq", getPrnrCgoRqstSeq());
		this.hashColumns.put("edi_unmap_dtl_cd", getEdiUnmapDtlCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("spcl_cgo_rqst_seq", "spclCgoRqstSeq");
		this.hashFields.put("spcl_cgo_seq", "spclCgoSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spcl_cntr_seq", "spclCntrSeq");
		this.hashFields.put("edw_upd_dt", "edwUpdDt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("edi_unmap_seq", "ediUnmapSeq");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("edi_unmap_corr_rslt_cd", "ediUnmapCorrRsltCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_unmap_corr_dt", "ediUnmapCorrDt");
		this.hashFields.put("prnr_cgo_rqst_seq", "prnrCgoRqstSeq");
		this.hashFields.put("edi_unmap_dtl_cd", "ediUnmapDtlCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return spclCgoRqstSeq
	 */
	public String getSpclCgoRqstSeq() {
		return this.spclCgoRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return spclCgoSeq
	 */
	public String getSpclCgoSeq() {
		return this.spclCgoSeq;
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
	 * @return spclCntrSeq
	 */
	public String getSpclCntrSeq() {
		return this.spclCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return edwUpdDt
	 */
	public String getEdwUpdDt() {
		return this.edwUpdDt;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @return ediUnmapSeq
	 */
	public String getEdiUnmapSeq() {
		return this.ediUnmapSeq;
	}
	
	/**
	 * Column Info
	 * @return bkgRefNo
	 */
	public String getBkgRefNo() {
		return this.bkgRefNo;
	}
	
	/**
	 * Column Info
	 * @return ediUnmapCorrRsltCd
	 */
	public String getEdiUnmapCorrRsltCd() {
		return this.ediUnmapCorrRsltCd;
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
	 * @return ediUnmapCorrDt
	 */
	public String getEdiUnmapCorrDt() {
		return this.ediUnmapCorrDt;
	}
	
	/**
	 * Column Info
	 * @return prnrCgoRqstSeq
	 */
	public String getPrnrCgoRqstSeq() {
		return this.prnrCgoRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return ediUnmapDtlCd
	 */
	public String getEdiUnmapDtlCd() {
		return this.ediUnmapDtlCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoRqstSeq
	 */
	public void setSpclCgoRqstSeq(String spclCgoRqstSeq) {
		this.spclCgoRqstSeq = spclCgoRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param spclCgoSeq
	 */
	public void setSpclCgoSeq(String spclCgoSeq) {
		this.spclCgoSeq = spclCgoSeq;
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
	 * @param spclCntrSeq
	 */
	public void setSpclCntrSeq(String spclCntrSeq) {
		this.spclCntrSeq = spclCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param edwUpdDt
	 */
	public void setEdwUpdDt(String edwUpdDt) {
		this.edwUpdDt = edwUpdDt;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
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
	 * @param ediUnmapSeq
	 */
	public void setEdiUnmapSeq(String ediUnmapSeq) {
		this.ediUnmapSeq = ediUnmapSeq;
	}
	
	/**
	 * Column Info
	 * @param bkgRefNo
	 */
	public void setBkgRefNo(String bkgRefNo) {
		this.bkgRefNo = bkgRefNo;
	}
	
	/**
	 * Column Info
	 * @param ediUnmapCorrRsltCd
	 */
	public void setEdiUnmapCorrRsltCd(String ediUnmapCorrRsltCd) {
		this.ediUnmapCorrRsltCd = ediUnmapCorrRsltCd;
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
	 * @param ediUnmapCorrDt
	 */
	public void setEdiUnmapCorrDt(String ediUnmapCorrDt) {
		this.ediUnmapCorrDt = ediUnmapCorrDt;
	}
	
	/**
	 * Column Info
	 * @param prnrCgoRqstSeq
	 */
	public void setPrnrCgoRqstSeq(String prnrCgoRqstSeq) {
		this.prnrCgoRqstSeq = prnrCgoRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param ediUnmapDtlCd
	 */
	public void setEdiUnmapDtlCd(String ediUnmapDtlCd) {
		this.ediUnmapDtlCd = ediUnmapDtlCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setSpclCgoRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_rqst_seq", ""));
		setSpclCgoSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSpclCntrSeq(JSPUtil.getParameter(request, prefix + "spcl_cntr_seq", ""));
		setEdwUpdDt(JSPUtil.getParameter(request, prefix + "edw_upd_dt", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEdiUnmapSeq(JSPUtil.getParameter(request, prefix + "edi_unmap_seq", ""));
		setBkgRefNo(JSPUtil.getParameter(request, prefix + "bkg_ref_no", ""));
		setEdiUnmapCorrRsltCd(JSPUtil.getParameter(request, prefix + "edi_unmap_corr_rslt_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdiUnmapCorrDt(JSPUtil.getParameter(request, prefix + "edi_unmap_corr_dt", ""));
		setPrnrCgoRqstSeq(JSPUtil.getParameter(request, prefix + "prnr_cgo_rqst_seq", ""));
		setEdiUnmapDtlCd(JSPUtil.getParameter(request, prefix + "edi_unmap_dtl_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPrnrRqstCgoUnmapVO[]
	 */
	public ScgPrnrRqstCgoUnmapVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPrnrRqstCgoUnmapVO[]
	 */
	public ScgPrnrRqstCgoUnmapVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPrnrRqstCgoUnmapVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] spclCgoRqstSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_rqst_seq", length));
			String[] spclCgoSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] spclCntrSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cntr_seq", length));
			String[] edwUpdDt = (JSPUtil.getParameter(request, prefix	+ "edw_upd_dt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ediUnmapSeq = (JSPUtil.getParameter(request, prefix	+ "edi_unmap_seq", length));
			String[] bkgRefNo = (JSPUtil.getParameter(request, prefix	+ "bkg_ref_no", length));
			String[] ediUnmapCorrRsltCd = (JSPUtil.getParameter(request, prefix	+ "edi_unmap_corr_rslt_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediUnmapCorrDt = (JSPUtil.getParameter(request, prefix	+ "edi_unmap_corr_dt", length));
			String[] prnrCgoRqstSeq = (JSPUtil.getParameter(request, prefix	+ "prnr_cgo_rqst_seq", length));
			String[] ediUnmapDtlCd = (JSPUtil.getParameter(request, prefix	+ "edi_unmap_dtl_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPrnrRqstCgoUnmapVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (spclCgoRqstSeq[i] != null)
					model.setSpclCgoRqstSeq(spclCgoRqstSeq[i]);
				if (spclCgoSeq[i] != null)
					model.setSpclCgoSeq(spclCgoSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (spclCntrSeq[i] != null)
					model.setSpclCntrSeq(spclCntrSeq[i]);
				if (edwUpdDt[i] != null)
					model.setEdwUpdDt(edwUpdDt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ediUnmapSeq[i] != null)
					model.setEdiUnmapSeq(ediUnmapSeq[i]);
				if (bkgRefNo[i] != null)
					model.setBkgRefNo(bkgRefNo[i]);
				if (ediUnmapCorrRsltCd[i] != null)
					model.setEdiUnmapCorrRsltCd(ediUnmapCorrRsltCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediUnmapCorrDt[i] != null)
					model.setEdiUnmapCorrDt(ediUnmapCorrDt[i]);
				if (prnrCgoRqstSeq[i] != null)
					model.setPrnrCgoRqstSeq(prnrCgoRqstSeq[i]);
				if (ediUnmapDtlCd[i] != null)
					model.setEdiUnmapDtlCd(ediUnmapDtlCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPrnrRqstCgoUnmapVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPrnrRqstCgoUnmapVO[]
	 */
	public ScgPrnrRqstCgoUnmapVO[] getScgPrnrRqstCgoUnmapVOs(){
		ScgPrnrRqstCgoUnmapVO[] vos = (ScgPrnrRqstCgoUnmapVO[])models.toArray(new ScgPrnrRqstCgoUnmapVO[models.size()]);
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
		this.spclCgoRqstSeq = this.spclCgoRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoSeq = this.spclCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCntrSeq = this.spclCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edwUpdDt = this.edwUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediUnmapSeq = this.ediUnmapSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo = this.bkgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediUnmapCorrRsltCd = this.ediUnmapCorrRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediUnmapCorrDt = this.ediUnmapCorrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnrCgoRqstSeq = this.prnrCgoRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediUnmapDtlCd = this.ediUnmapDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
