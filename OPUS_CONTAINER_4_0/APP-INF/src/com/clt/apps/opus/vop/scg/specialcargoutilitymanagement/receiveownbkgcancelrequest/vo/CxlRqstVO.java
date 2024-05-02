/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CxlRqstVO.java
*@FileTitle : CxlRqstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.vo;

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

public class CxlRqstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CxlRqstVO> models = new ArrayList<CxlRqstVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cxlCgoKndCd = null;
	/* Column Info */
	private String cxlCgoRqstDt = null;
	/* Column Info */
	private String spclCgoAproRqstSeq = null;
	/* Column Info */
	private String vslSeq = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String cxlCgoRsn = null;
	/* Column Info */
	private String dcgoCxlRqstSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mapgEdiTrsmStsCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CxlRqstVO() {}

	public CxlRqstVO(String ibflag, String pagerows, String bkgNo, String spclCgoAproRqstSeq, String vslPrePstCd, String vslSeq, String mapgEdiTrsmStsCd, String dcgoCxlRqstSeq, String cxlCgoKndCd, String cxlCgoRqstDt, String cxlCgoRsn, String updUsrId) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cxlCgoKndCd = cxlCgoKndCd;
		this.cxlCgoRqstDt = cxlCgoRqstDt;
		this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
		this.vslSeq = vslSeq;
		this.vslPrePstCd = vslPrePstCd;
		this.cxlCgoRsn = cxlCgoRsn;
		this.dcgoCxlRqstSeq = dcgoCxlRqstSeq;
		this.updUsrId = updUsrId;
		this.mapgEdiTrsmStsCd = mapgEdiTrsmStsCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cxl_cgo_knd_cd", getCxlCgoKndCd());
		this.hashColumns.put("cxl_cgo_rqst_dt", getCxlCgoRqstDt());
		this.hashColumns.put("spcl_cgo_apro_rqst_seq", getSpclCgoAproRqstSeq());
		this.hashColumns.put("vsl_seq", getVslSeq());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("cxl_cgo_rsn", getCxlCgoRsn());
		this.hashColumns.put("dcgo_cxl_rqst_seq", getDcgoCxlRqstSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mapg_edi_trsm_sts_cd", getMapgEdiTrsmStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cxl_cgo_knd_cd", "cxlCgoKndCd");
		this.hashFields.put("cxl_cgo_rqst_dt", "cxlCgoRqstDt");
		this.hashFields.put("spcl_cgo_apro_rqst_seq", "spclCgoAproRqstSeq");
		this.hashFields.put("vsl_seq", "vslSeq");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("cxl_cgo_rsn", "cxlCgoRsn");
		this.hashFields.put("dcgo_cxl_rqst_seq", "dcgoCxlRqstSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mapg_edi_trsm_sts_cd", "mapgEdiTrsmStsCd");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return cxlCgoKndCd
	 */
	public String getCxlCgoKndCd() {
		return this.cxlCgoKndCd;
	}
	
	/**
	 * Column Info
	 * @return cxlCgoRqstDt
	 */
	public String getCxlCgoRqstDt() {
		return this.cxlCgoRqstDt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAproRqstSeq
	 */
	public String getSpclCgoAproRqstSeq() {
		return this.spclCgoAproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return vslSeq
	 */
	public String getVslSeq() {
		return this.vslSeq;
	}
	
	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @return cxlCgoRsn
	 */
	public String getCxlCgoRsn() {
		return this.cxlCgoRsn;
	}
	
	/**
	 * Column Info
	 * @return dcgoCxlRqstSeq
	 */
	public String getDcgoCxlRqstSeq() {
		return this.dcgoCxlRqstSeq;
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
	 * @return mapgEdiTrsmStsCd
	 */
	public String getMapgEdiTrsmStsCd() {
		return this.mapgEdiTrsmStsCd;
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
	 * @param cxlCgoKndCd
	 */
	public void setCxlCgoKndCd(String cxlCgoKndCd) {
		this.cxlCgoKndCd = cxlCgoKndCd;
	}
	
	/**
	 * Column Info
	 * @param cxlCgoRqstDt
	 */
	public void setCxlCgoRqstDt(String cxlCgoRqstDt) {
		this.cxlCgoRqstDt = cxlCgoRqstDt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAproRqstSeq
	 */
	public void setSpclCgoAproRqstSeq(String spclCgoAproRqstSeq) {
		this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param vslSeq
	 */
	public void setVslSeq(String vslSeq) {
		this.vslSeq = vslSeq;
	}
	
	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
	}
	
	/**
	 * Column Info
	 * @param cxlCgoRsn
	 */
	public void setCxlCgoRsn(String cxlCgoRsn) {
		this.cxlCgoRsn = cxlCgoRsn;
	}
	
	/**
	 * Column Info
	 * @param dcgoCxlRqstSeq
	 */
	public void setDcgoCxlRqstSeq(String dcgoCxlRqstSeq) {
		this.dcgoCxlRqstSeq = dcgoCxlRqstSeq;
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
	 * @param mapgEdiTrsmStsCd
	 */
	public void setMapgEdiTrsmStsCd(String mapgEdiTrsmStsCd) {
		this.mapgEdiTrsmStsCd = mapgEdiTrsmStsCd;
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
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCxlCgoKndCd(JSPUtil.getParameter(request, prefix + "cxl_cgo_knd_cd", ""));
		setCxlCgoRqstDt(JSPUtil.getParameter(request, prefix + "cxl_cgo_rqst_dt", ""));
		setSpclCgoAproRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", ""));
		setVslSeq(JSPUtil.getParameter(request, prefix + "vsl_seq", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
		setCxlCgoRsn(JSPUtil.getParameter(request, prefix + "cxl_cgo_rsn", ""));
		setDcgoCxlRqstSeq(JSPUtil.getParameter(request, prefix + "dcgo_cxl_rqst_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMapgEdiTrsmStsCd(JSPUtil.getParameter(request, prefix + "mapg_edi_trsm_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CxlRqstVO[]
	 */
	public CxlRqstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CxlRqstVO[]
	 */
	public CxlRqstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CxlRqstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cxlCgoKndCd = (JSPUtil.getParameter(request, prefix	+ "cxl_cgo_knd_cd", length));
			String[] cxlCgoRqstDt = (JSPUtil.getParameter(request, prefix	+ "cxl_cgo_rqst_dt", length));
			String[] spclCgoAproRqstSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_apro_rqst_seq", length));
			String[] vslSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_seq", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] cxlCgoRsn = (JSPUtil.getParameter(request, prefix	+ "cxl_cgo_rsn", length));
			String[] dcgoCxlRqstSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_cxl_rqst_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mapgEdiTrsmStsCd = (JSPUtil.getParameter(request, prefix	+ "mapg_edi_trsm_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CxlRqstVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cxlCgoKndCd[i] != null)
					model.setCxlCgoKndCd(cxlCgoKndCd[i]);
				if (cxlCgoRqstDt[i] != null)
					model.setCxlCgoRqstDt(cxlCgoRqstDt[i]);
				if (spclCgoAproRqstSeq[i] != null)
					model.setSpclCgoAproRqstSeq(spclCgoAproRqstSeq[i]);
				if (vslSeq[i] != null)
					model.setVslSeq(vslSeq[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (cxlCgoRsn[i] != null)
					model.setCxlCgoRsn(cxlCgoRsn[i]);
				if (dcgoCxlRqstSeq[i] != null)
					model.setDcgoCxlRqstSeq(dcgoCxlRqstSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mapgEdiTrsmStsCd[i] != null)
					model.setMapgEdiTrsmStsCd(mapgEdiTrsmStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCxlRqstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CxlRqstVO[]
	 */
	public CxlRqstVO[] getCxlRqstVOs(){
		CxlRqstVO[] vos = (CxlRqstVO[])models.toArray(new CxlRqstVO[models.size()]);
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
		this.cxlCgoKndCd = this.cxlCgoKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlCgoRqstDt = this.cxlCgoRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproRqstSeq = this.spclCgoAproRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSeq = this.vslSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlCgoRsn = this.cxlCgoRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoCxlRqstSeq = this.dcgoCxlRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgEdiTrsmStsCd = this.mapgEdiTrsmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
