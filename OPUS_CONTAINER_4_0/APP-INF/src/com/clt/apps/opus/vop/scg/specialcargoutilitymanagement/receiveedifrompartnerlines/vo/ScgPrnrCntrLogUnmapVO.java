/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ScgPrnrCntrLogUnmapVO.java
*@FileTitle : ScgPrnrCntrLogUnmapVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.16  
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

public class ScgPrnrCntrLogUnmapVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgPrnrCntrLogUnmapVO> models = new ArrayList<ScgPrnrCntrLogUnmapVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trsmDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String spclCgoCateCd = null;
	/* Column Info */
	private String trsmBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ediUnmapSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ediUnmapDtlCd = null;
	/* Column Info */
	private String cntrSeq = null;
	/* Column Info */
	private String ediUnmapDtlDesc = null;
	/* Column Info */
	private String prnrSpclCgoSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrRefNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ScgPrnrCntrLogUnmapVO() {}

	public ScgPrnrCntrLogUnmapVO(String ibflag, String pagerows, String trsmBndCd, String trsmDt, String spclCgoCateCd, String prnrSpclCgoSeq, String cntrSeq, String ediUnmapSeq, String cntrRefNo, String ediUnmapDtlCd, String ediUnmapDtlDesc, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.trsmDt = trsmDt;
		this.creDt = creDt;
		this.spclCgoCateCd = spclCgoCateCd;
		this.trsmBndCd = trsmBndCd;
		this.pagerows = pagerows;
		this.ediUnmapSeq = ediUnmapSeq;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.ediUnmapDtlCd = ediUnmapDtlCd;
		this.cntrSeq = cntrSeq;
		this.ediUnmapDtlDesc = ediUnmapDtlDesc;
		this.prnrSpclCgoSeq = prnrSpclCgoSeq;
		this.updUsrId = updUsrId;
		this.cntrRefNo = cntrRefNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trsm_dt", getTrsmDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
		this.hashColumns.put("trsm_bnd_cd", getTrsmBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("edi_unmap_seq", getEdiUnmapSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("edi_unmap_dtl_cd", getEdiUnmapDtlCd());
		this.hashColumns.put("cntr_seq", getCntrSeq());
		this.hashColumns.put("edi_unmap_dtl_desc", getEdiUnmapDtlDesc());
		this.hashColumns.put("prnr_spcl_cgo_seq", getPrnrSpclCgoSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_ref_no", getCntrRefNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trsm_dt", "trsmDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
		this.hashFields.put("trsm_bnd_cd", "trsmBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("edi_unmap_seq", "ediUnmapSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("edi_unmap_dtl_cd", "ediUnmapDtlCd");
		this.hashFields.put("cntr_seq", "cntrSeq");
		this.hashFields.put("edi_unmap_dtl_desc", "ediUnmapDtlDesc");
		this.hashFields.put("prnr_spcl_cgo_seq", "prnrSpclCgoSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_ref_no", "cntrRefNo");
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
	 * @return trsmDt
	 */
	public String getTrsmDt() {
		return this.trsmDt;
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
	 * @return spclCgoCateCd
	 */
	public String getSpclCgoCateCd() {
		return this.spclCgoCateCd;
	}
	
	/**
	 * Column Info
	 * @return trsmBndCd
	 */
	public String getTrsmBndCd() {
		return this.trsmBndCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cntrSeq
	 */
	public String getCntrSeq() {
		return this.cntrSeq;
	}
	
	/**
	 * Column Info
	 * @return ediUnmapDtlDesc
	 */
	public String getEdiUnmapDtlDesc() {
		return this.ediUnmapDtlDesc;
	}
	
	/**
	 * Column Info
	 * @return prnrSpclCgoSeq
	 */
	public String getPrnrSpclCgoSeq() {
		return this.prnrSpclCgoSeq;
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
	 * @return cntrRefNo
	 */
	public String getCntrRefNo() {
		return this.cntrRefNo;
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
	 * @param trsmDt
	 */
	public void setTrsmDt(String trsmDt) {
		this.trsmDt = trsmDt;
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
	 * @param spclCgoCateCd
	 */
	public void setSpclCgoCateCd(String spclCgoCateCd) {
		this.spclCgoCateCd = spclCgoCateCd;
	}
	
	/**
	 * Column Info
	 * @param trsmBndCd
	 */
	public void setTrsmBndCd(String trsmBndCd) {
		this.trsmBndCd = trsmBndCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cntrSeq
	 */
	public void setCntrSeq(String cntrSeq) {
		this.cntrSeq = cntrSeq;
	}
	
	/**
	 * Column Info
	 * @param ediUnmapDtlDesc
	 */
	public void setEdiUnmapDtlDesc(String ediUnmapDtlDesc) {
		this.ediUnmapDtlDesc = ediUnmapDtlDesc;
	}
	
	/**
	 * Column Info
	 * @param prnrSpclCgoSeq
	 */
	public void setPrnrSpclCgoSeq(String prnrSpclCgoSeq) {
		this.prnrSpclCgoSeq = prnrSpclCgoSeq;
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
	 * @param cntrRefNo
	 */
	public void setCntrRefNo(String cntrRefNo) {
		this.cntrRefNo = cntrRefNo;
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
		setTrsmDt(JSPUtil.getParameter(request, prefix + "trsm_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
		setTrsmBndCd(JSPUtil.getParameter(request, prefix + "trsm_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEdiUnmapSeq(JSPUtil.getParameter(request, prefix + "edi_unmap_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEdiUnmapDtlCd(JSPUtil.getParameter(request, prefix + "edi_unmap_dtl_cd", ""));
		setCntrSeq(JSPUtil.getParameter(request, prefix + "cntr_seq", ""));
		setEdiUnmapDtlDesc(JSPUtil.getParameter(request, prefix + "edi_unmap_dtl_desc", ""));
		setPrnrSpclCgoSeq(JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCntrRefNo(JSPUtil.getParameter(request, prefix + "cntr_ref_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPrnrCntrLogUnmapVO[]
	 */
	public ScgPrnrCntrLogUnmapVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgPrnrCntrLogUnmapVO[]
	 */
	public ScgPrnrCntrLogUnmapVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgPrnrCntrLogUnmapVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] trsmDt = (JSPUtil.getParameter(request, prefix	+ "trsm_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cate_cd", length));
			String[] trsmBndCd = (JSPUtil.getParameter(request, prefix	+ "trsm_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ediUnmapSeq = (JSPUtil.getParameter(request, prefix	+ "edi_unmap_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ediUnmapDtlCd = (JSPUtil.getParameter(request, prefix	+ "edi_unmap_dtl_cd", length));
			String[] cntrSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_seq", length));
			String[] ediUnmapDtlDesc = (JSPUtil.getParameter(request, prefix	+ "edi_unmap_dtl_desc", length));
			String[] prnrSpclCgoSeq = (JSPUtil.getParameter(request, prefix	+ "prnr_spcl_cgo_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrRefNo = (JSPUtil.getParameter(request, prefix	+ "cntr_ref_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgPrnrCntrLogUnmapVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trsmDt[i] != null)
					model.setTrsmDt(trsmDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (spclCgoCateCd[i] != null)
					model.setSpclCgoCateCd(spclCgoCateCd[i]);
				if (trsmBndCd[i] != null)
					model.setTrsmBndCd(trsmBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ediUnmapSeq[i] != null)
					model.setEdiUnmapSeq(ediUnmapSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ediUnmapDtlCd[i] != null)
					model.setEdiUnmapDtlCd(ediUnmapDtlCd[i]);
				if (cntrSeq[i] != null)
					model.setCntrSeq(cntrSeq[i]);
				if (ediUnmapDtlDesc[i] != null)
					model.setEdiUnmapDtlDesc(ediUnmapDtlDesc[i]);
				if (prnrSpclCgoSeq[i] != null)
					model.setPrnrSpclCgoSeq(prnrSpclCgoSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrRefNo[i] != null)
					model.setCntrRefNo(cntrRefNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgPrnrCntrLogUnmapVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgPrnrCntrLogUnmapVO[]
	 */
	public ScgPrnrCntrLogUnmapVO[] getScgPrnrCntrLogUnmapVOs(){
		ScgPrnrCntrLogUnmapVO[] vos = (ScgPrnrCntrLogUnmapVO[])models.toArray(new ScgPrnrCntrLogUnmapVO[models.size()]);
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
		this.trsmDt = this.trsmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCateCd = this.spclCgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmBndCd = this.trsmBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediUnmapSeq = this.ediUnmapSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediUnmapDtlCd = this.ediUnmapDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq = this.cntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediUnmapDtlDesc = this.ediUnmapDtlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnrSpclCgoSeq = this.prnrSpclCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRefNo = this.cntrRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
