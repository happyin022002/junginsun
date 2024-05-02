/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StwgAproInfoVO.java
*@FileTitle : StwgAproInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.11
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2014.12.11 Maeda Atsushi 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

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
 * @author Maeda Atsushi
 * @since J2EE 1.6
 * @see AbstractValueObject 
 */

public class StwgAproInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StwgAproInfoVO> models = new ArrayList<StwgAproInfoVO>();
	
	/* Column Info */
	private String stwgSeq = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spclCgoAproCd = null;
	/* Column Info */
	private String stwgRmk = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rqstGdt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public StwgAproInfoVO() {}

	public StwgAproInfoVO(String ibflag, String pagerows, String bkgNo, String stwgSeq, String stwgCd, String stwgRmk, String rqstUsrId, String rqstDt, String rqstGdt, String spclCgoAproCd, String creUsrId, String updUsrId) {
		this.stwgSeq = stwgSeq;
		this.rqstDt = rqstDt;
		this.creUsrId = creUsrId;
		this.rqstUsrId = rqstUsrId;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.spclCgoAproCd = spclCgoAproCd;
		this.stwgRmk = stwgRmk;
		this.stwgCd = stwgCd;
		this.updUsrId = updUsrId;
		this.rqstGdt = rqstGdt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("stwg_seq", getStwgSeq());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spcl_cgo_apro_cd", getSpclCgoAproCd());
		this.hashColumns.put("stwg_rmk", getStwgRmk());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rqst_gdt", getRqstGdt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("stwg_seq", "stwgSeq");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spcl_cgo_apro_cd", "spclCgoAproCd");
		this.hashFields.put("stwg_rmk", "stwgRmk");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rqst_gdt", "rqstGdt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return stwgSeq
	 */
	public String getStwgSeq() {
		return this.stwgSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
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
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
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
	 * @return spclCgoAproCd
	 */
	public String getSpclCgoAproCd() {
		return this.spclCgoAproCd;
	}
	
	/**
	 * Column Info
	 * @return stwgRmk
	 */
	public String getStwgRmk() {
		return this.stwgRmk;
	}
	
	/**
	 * Column Info
	 * @return stwgCd
	 */
	public String getStwgCd() {
		return this.stwgCd;
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
	 * @return rqstGdt
	 */
	public String getRqstGdt() {
		return this.rqstGdt;
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
	 * @param stwgSeq
	 */
	public void setStwgSeq(String stwgSeq) {
		this.stwgSeq = stwgSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
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
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
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
	 * @param spclCgoAproCd
	 */
	public void setSpclCgoAproCd(String spclCgoAproCd) {
		this.spclCgoAproCd = spclCgoAproCd;
	}
	
	/**
	 * Column Info
	 * @param stwgRmk
	 */
	public void setStwgRmk(String stwgRmk) {
		this.stwgRmk = stwgRmk;
	}
	
	/**
	 * Column Info
	 * @param stwgCd
	 */
	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
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
	 * @param rqstGdt
	 */
	public void setRqstGdt(String rqstGdt) {
		this.rqstGdt = rqstGdt;
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
		setStwgSeq(JSPUtil.getParameter(request, prefix + "stwg_seq", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpclCgoAproCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_cd", ""));
		setStwgRmk(JSPUtil.getParameter(request, prefix + "stwg_rmk", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRqstGdt(JSPUtil.getParameter(request, prefix + "rqst_gdt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StwgAproInfoVO[]
	 */
	public StwgAproInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StwgAproInfoVO[]
	 */
	public StwgAproInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StwgAproInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] stwgSeq = (JSPUtil.getParameter(request, prefix	+ "stwg_seq", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spclCgoAproCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_apro_cd", length));
			String[] stwgRmk = (JSPUtil.getParameter(request, prefix	+ "stwg_rmk", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rqstGdt = (JSPUtil.getParameter(request, prefix	+ "rqst_gdt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new StwgAproInfoVO();
				if (stwgSeq[i] != null)
					model.setStwgSeq(stwgSeq[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spclCgoAproCd[i] != null)
					model.setSpclCgoAproCd(spclCgoAproCd[i]);
				if (stwgRmk[i] != null)
					model.setStwgRmk(stwgRmk[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rqstGdt[i] != null)
					model.setRqstGdt(rqstGdt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStwgAproInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StwgAproInfoVO[]
	 */
	public StwgAproInfoVO[] getStwgAproInfoVOs(){
		StwgAproInfoVO[] vos = (StwgAproInfoVO[])models.toArray(new StwgAproInfoVO[models.size()]);
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
		this.stwgSeq = this.stwgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproCd = this.spclCgoAproCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgRmk = this.stwgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstGdt = this.rqstGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
