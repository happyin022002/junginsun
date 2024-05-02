/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EDISpclCgoSeqMapgVO.java
*@FileTitle : EDISpclCgoSeqMapgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.25  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo;

import java.lang.reflect.Field;
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

public class EDISpclCgoSeqMapgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EDISpclCgoSeqMapgVO> models = new ArrayList<EDISpclCgoSeqMapgVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cgoSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dcgoRefNo = null;
	/* Column Info */
	private String cgoMapgSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ediItmSeq = null;
	/* Column Info */
	private String prnrSpclCgoSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrRefNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EDISpclCgoSeqMapgVO() {}

	public EDISpclCgoSeqMapgVO(String ibflag, String pagerows, String prnrSpclCgoSeq, String cgoMapgSeq, String cntrSeq, String cgoSeq, String cntrTpszCd, String cntrRefNo, String ediItmSeq, String dcgoRefNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.cgoSeq = cgoSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.dcgoRefNo = dcgoRefNo;
		this.cgoMapgSeq = cgoMapgSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrSeq = cntrSeq;
		this.creDt = creDt;
		this.ediItmSeq = ediItmSeq;
		this.prnrSpclCgoSeq = prnrSpclCgoSeq;
		this.updUsrId = updUsrId;
		this.cntrRefNo = cntrRefNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cgo_seq", getCgoSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dcgo_ref_no", getDcgoRefNo());
		this.hashColumns.put("cgo_mapg_seq", getCgoMapgSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_seq", getCntrSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("edi_itm_seq", getEdiItmSeq());
		this.hashColumns.put("prnr_spcl_cgo_seq", getPrnrSpclCgoSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_ref_no", getCntrRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cgo_seq", "cgoSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dcgo_ref_no", "dcgoRefNo");
		this.hashFields.put("cgo_mapg_seq", "cgoMapgSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_seq", "cntrSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("edi_itm_seq", "ediItmSeq");
		this.hashFields.put("prnr_spcl_cgo_seq", "prnrSpclCgoSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_ref_no", "cntrRefNo");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return cgoSeq
	 */
	public String getCgoSeq() {
		return this.cgoSeq;
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
	 * @return dcgoRefNo
	 */
	public String getDcgoRefNo() {
		return this.dcgoRefNo;
	}
	
	/**
	 * Column Info
	 * @return cgoMapgSeq
	 */
	public String getCgoMapgSeq() {
		return this.cgoMapgSeq;
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
	 * @return cntrSeq
	 */
	public String getCntrSeq() {
		return this.cntrSeq;
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
	 * @return ediItmSeq
	 */
	public String getEdiItmSeq() {
		return this.ediItmSeq;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param cgoSeq
	 */
	public void setCgoSeq(String cgoSeq) {
		this.cgoSeq = cgoSeq;
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
	 * @param dcgoRefNo
	 */
	public void setDcgoRefNo(String dcgoRefNo) {
		this.dcgoRefNo = dcgoRefNo;
	}
	
	/**
	 * Column Info
	 * @param cgoMapgSeq
	 */
	public void setCgoMapgSeq(String cgoMapgSeq) {
		this.cgoMapgSeq = cgoMapgSeq;
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
	 * @param cntrSeq
	 */
	public void setCntrSeq(String cntrSeq) {
		this.cntrSeq = cntrSeq;
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
	 * @param ediItmSeq
	 */
	public void setEdiItmSeq(String ediItmSeq) {
		this.ediItmSeq = ediItmSeq;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setCgoSeq(JSPUtil.getParameter(request, prefix + "cgo_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDcgoRefNo(JSPUtil.getParameter(request, prefix + "dcgo_ref_no", ""));
		setCgoMapgSeq(JSPUtil.getParameter(request, prefix + "cgo_mapg_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCntrSeq(JSPUtil.getParameter(request, prefix + "cntr_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setEdiItmSeq(JSPUtil.getParameter(request, prefix + "edi_itm_seq", ""));
		setPrnrSpclCgoSeq(JSPUtil.getParameter(request, prefix + "prnr_spcl_cgo_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCntrRefNo(JSPUtil.getParameter(request, prefix + "cntr_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EDISpclCgoSeqMapgVO[]
	 */
	public EDISpclCgoSeqMapgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EDISpclCgoSeqMapgVO[]
	 */
	public EDISpclCgoSeqMapgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EDISpclCgoSeqMapgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cgoSeq = (JSPUtil.getParameter(request, prefix	+ "cgo_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dcgoRefNo = (JSPUtil.getParameter(request, prefix	+ "dcgo_ref_no", length));
			String[] cgoMapgSeq = (JSPUtil.getParameter(request, prefix	+ "cgo_mapg_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cntrSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ediItmSeq = (JSPUtil.getParameter(request, prefix	+ "edi_itm_seq", length));
			String[] prnrSpclCgoSeq = (JSPUtil.getParameter(request, prefix	+ "prnr_spcl_cgo_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrRefNo = (JSPUtil.getParameter(request, prefix	+ "cntr_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			/* Add a field line, do not delete */
			for (int i = 0; i < length; i++) {
				model = new EDISpclCgoSeqMapgVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cgoSeq[i] != null)
					model.setCgoSeq(cgoSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dcgoRefNo[i] != null)
					model.setDcgoRefNo(dcgoRefNo[i]);
				if (cgoMapgSeq[i] != null)
					model.setCgoMapgSeq(cgoMapgSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrSeq[i] != null)
					model.setCntrSeq(cntrSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ediItmSeq[i] != null)
					model.setEdiItmSeq(ediItmSeq[i]);
				if (prnrSpclCgoSeq[i] != null)
					model.setPrnrSpclCgoSeq(prnrSpclCgoSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrRefNo[i] != null)
					model.setCntrRefNo(cntrRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				/* Add a Method line, do not delete */
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEDISpclCgoSeqMapgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EDISpclCgoSeqMapgVO[]
	 */
	public EDISpclCgoSeqMapgVO[] getEDISpclCgoSeqMapgVOs(){
		EDISpclCgoSeqMapgVO[] vos = (EDISpclCgoSeqMapgVO[])models.toArray(new EDISpclCgoSeqMapgVO[models.size()]);
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
		this.cgoSeq = this.cgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoRefNo = this.dcgoRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoMapgSeq = this.cgoMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq = this.cntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediItmSeq = this.ediItmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnrSpclCgoSeq = this.prnrSpclCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRefNo = this.cntrRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
