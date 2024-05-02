/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PsaBkgRlsOrdCntrTpszVO.java
*@FileTitle : PsaBkgRlsOrdCntrTpszVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.09 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaBkgRlsOrdCntrTpszVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaBkgRlsOrdCntrTpszVO> models = new ArrayList<PsaBkgRlsOrdCntrTpszVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrTp = null;
	/* Column Info */
	private String roDo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String roNoCntr = null;
	/* Column Info */
	private String roSeq = null;
	/* Column Info */
	private String roCntrTp = null;
	/* Column Info */
	private String roNo = null;
	/* Column Info */
	private String roFi = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsaBkgRlsOrdCntrTpszVO() {}

	public PsaBkgRlsOrdCntrTpszVO(String ibflag, String pagerows, String roNo, String roFi, String roSeq, String roDo, String roCntrTp, String cntrTp, String roNoCntr, String bkgNo, String bkgSeq) {
		this.bkgNo = bkgNo;
		this.cntrTp = cntrTp;
		this.roDo = roDo;
		this.ibflag = ibflag;
		this.roNoCntr = roNoCntr;
		this.roSeq = roSeq;
		this.roCntrTp = roCntrTp;
		this.roNo = roNo;
		this.roFi = roFi;
		this.bkgSeq = bkgSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_tp", getCntrTp());
		this.hashColumns.put("ro_do", getRoDo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ro_no_cntr", getRoNoCntr());
		this.hashColumns.put("ro_seq", getRoSeq());
		this.hashColumns.put("ro_cntr_tp", getRoCntrTp());
		this.hashColumns.put("ro_no", getRoNo());
		this.hashColumns.put("ro_fi", getRoFi());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_tp", "cntrTp");
		this.hashFields.put("ro_do", "roDo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ro_no_cntr", "roNoCntr");
		this.hashFields.put("ro_seq", "roSeq");
		this.hashFields.put("ro_cntr_tp", "roCntrTp");
		this.hashFields.put("ro_no", "roNo");
		this.hashFields.put("ro_fi", "roFi");
		this.hashFields.put("bkg_seq", "bkgSeq");
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
	 * Column Info
	 * @return cntrTp
	 */
	public String getCntrTp() {
		return this.cntrTp;
	}
	
	/**
	 * Column Info
	 * @return roDo
	 */
	public String getRoDo() {
		return this.roDo;
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
	 * @return roNoCntr
	 */
	public String getRoNoCntr() {
		return this.roNoCntr;
	}
	
	/**
	 * Column Info
	 * @return roSeq
	 */
	public String getRoSeq() {
		return this.roSeq;
	}
	
	/**
	 * Column Info
	 * @return roCntrTp
	 */
	public String getRoCntrTp() {
		return this.roCntrTp;
	}
	
	/**
	 * Column Info
	 * @return roNo
	 */
	public String getRoNo() {
		return this.roNo;
	}
	
	/**
	 * Column Info
	 * @return roFi
	 */
	public String getRoFi() {
		return this.roFi;
	}
	
	/**
	 * Column Info
	 * @return bkgSeq
	 */
	public String getBkgSeq() {
		return this.bkgSeq;
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
	 * Column Info
	 * @param cntrTp
	 */
	public void setCntrTp(String cntrTp) {
		this.cntrTp = cntrTp;
	}
	
	/**
	 * Column Info
	 * @param roDo
	 */
	public void setRoDo(String roDo) {
		this.roDo = roDo;
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
	 * @param roNoCntr
	 */
	public void setRoNoCntr(String roNoCntr) {
		this.roNoCntr = roNoCntr;
	}
	
	/**
	 * Column Info
	 * @param roSeq
	 */
	public void setRoSeq(String roSeq) {
		this.roSeq = roSeq;
	}
	
	/**
	 * Column Info
	 * @param roCntrTp
	 */
	public void setRoCntrTp(String roCntrTp) {
		this.roCntrTp = roCntrTp;
	}
	
	/**
	 * Column Info
	 * @param roNo
	 */
	public void setRoNo(String roNo) {
		this.roNo = roNo;
	}
	
	/**
	 * Column Info
	 * @param roFi
	 */
	public void setRoFi(String roFi) {
		this.roFi = roFi;
	}
	
	/**
	 * Column Info
	 * @param bkgSeq
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
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
		setCntrTp(JSPUtil.getParameter(request, prefix + "cntr_tp", ""));
		setRoDo(JSPUtil.getParameter(request, prefix + "ro_do", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRoNoCntr(JSPUtil.getParameter(request, prefix + "ro_no_cntr", ""));
		setRoSeq(JSPUtil.getParameter(request, prefix + "ro_seq", ""));
		setRoCntrTp(JSPUtil.getParameter(request, prefix + "ro_cntr_tp", ""));
		setRoNo(JSPUtil.getParameter(request, prefix + "ro_no", ""));
		setRoFi(JSPUtil.getParameter(request, prefix + "ro_fi", ""));
		setBkgSeq(JSPUtil.getParameter(request, prefix + "bkg_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaBkgRlsOrdCntrTpszVO[]
	 */
	public PsaBkgRlsOrdCntrTpszVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaBkgRlsOrdCntrTpszVO[]
	 */
	public PsaBkgRlsOrdCntrTpszVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaBkgRlsOrdCntrTpszVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrTp = (JSPUtil.getParameter(request, prefix	+ "cntr_tp", length));
			String[] roDo = (JSPUtil.getParameter(request, prefix	+ "ro_do", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] roNoCntr = (JSPUtil.getParameter(request, prefix	+ "ro_no_cntr", length));
			String[] roSeq = (JSPUtil.getParameter(request, prefix	+ "ro_seq", length));
			String[] roCntrTp = (JSPUtil.getParameter(request, prefix	+ "ro_cntr_tp", length));
			String[] roNo = (JSPUtil.getParameter(request, prefix	+ "ro_no", length));
			String[] roFi = (JSPUtil.getParameter(request, prefix	+ "ro_fi", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaBkgRlsOrdCntrTpszVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrTp[i] != null)
					model.setCntrTp(cntrTp[i]);
				if (roDo[i] != null)
					model.setRoDo(roDo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (roNoCntr[i] != null)
					model.setRoNoCntr(roNoCntr[i]);
				if (roSeq[i] != null)
					model.setRoSeq(roSeq[i]);
				if (roCntrTp[i] != null)
					model.setRoCntrTp(roCntrTp[i]);
				if (roNo[i] != null)
					model.setRoNo(roNo[i]);
				if (roFi[i] != null)
					model.setRoFi(roFi[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaBkgRlsOrdCntrTpszVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaBkgRlsOrdCntrTpszVO[]
	 */
	public PsaBkgRlsOrdCntrTpszVO[] getPsaBkgRlsOrdCntrTpszVOs(){
		PsaBkgRlsOrdCntrTpszVO[] vos = (PsaBkgRlsOrdCntrTpszVO[])models.toArray(new PsaBkgRlsOrdCntrTpszVO[models.size()]);
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
		this.cntrTp = this.cntrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roDo = this.roDo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roNoCntr = this.roNoCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roSeq = this.roSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roCntrTp = this.roCntrTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roNo = this.roNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roFi = this.roFi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
