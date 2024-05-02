/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PsaCntrNoVO.java
*@FileTitle : PsaCntrNoVO
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

public class PsaCntrNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsaCntrNoVO> models = new ArrayList<PsaCntrNoVO>();
	
	/* Column Info */
	private String n2ndCntrNo = null;
	/* Column Info */
	private String psaSerNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n1stCntrNo = null;
	/* Column Info */
	private String n4thCntrNo = null;
	/* Column Info */
	private String n6thCntrNo = null;
	/* Column Info */
	private String n5thCntrNo = null;
	/* Column Info */
	private String n3rdCntrNo = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsaCntrNoVO() {}

	public PsaCntrNoVO(String ibflag, String pagerows, String n1stCntrNo, String n2ndCntrNo, String n3rdCntrNo, String n4thCntrNo, String n5thCntrNo, String n6thCntrNo, String bkgNo, String bkgSeq, String psaSerNo) {
		this.n2ndCntrNo = n2ndCntrNo;
		this.psaSerNo = psaSerNo;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.n1stCntrNo = n1stCntrNo;
		this.n4thCntrNo = n4thCntrNo;
		this.n6thCntrNo = n6thCntrNo;
		this.n5thCntrNo = n5thCntrNo;
		this.n3rdCntrNo = n3rdCntrNo;
		this.bkgSeq = bkgSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n2nd_cntr_no", getN2ndCntrNo());
		this.hashColumns.put("psa_ser_no", getPsaSerNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n1st_cntr_no", getN1stCntrNo());
		this.hashColumns.put("n4th_cntr_no", getN4thCntrNo());
		this.hashColumns.put("n6th_cntr_no", getN6thCntrNo());
		this.hashColumns.put("n5th_cntr_no", getN5thCntrNo());
		this.hashColumns.put("n3rd_cntr_no", getN3rdCntrNo());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n2nd_cntr_no", "n2ndCntrNo");
		this.hashFields.put("psa_ser_no", "psaSerNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n1st_cntr_no", "n1stCntrNo");
		this.hashFields.put("n4th_cntr_no", "n4thCntrNo");
		this.hashFields.put("n6th_cntr_no", "n6thCntrNo");
		this.hashFields.put("n5th_cntr_no", "n5thCntrNo");
		this.hashFields.put("n3rd_cntr_no", "n3rdCntrNo");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n2ndCntrNo
	 */
	public String getN2ndCntrNo() {
		return this.n2ndCntrNo;
	}
	
	/**
	 * Column Info
	 * @return psaSerNo
	 */
	public String getPsaSerNo() {
		return this.psaSerNo;
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
	 * @return n1stCntrNo
	 */
	public String getN1stCntrNo() {
		return this.n1stCntrNo;
	}
	
	/**
	 * Column Info
	 * @return n4thCntrNo
	 */
	public String getN4thCntrNo() {
		return this.n4thCntrNo;
	}
	
	/**
	 * Column Info
	 * @return n6thCntrNo
	 */
	public String getN6thCntrNo() {
		return this.n6thCntrNo;
	}
	
	/**
	 * Column Info
	 * @return n5thCntrNo
	 */
	public String getN5thCntrNo() {
		return this.n5thCntrNo;
	}
	
	/**
	 * Column Info
	 * @return n3rdCntrNo
	 */
	public String getN3rdCntrNo() {
		return this.n3rdCntrNo;
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
	 * @param n2ndCntrNo
	 */
	public void setN2ndCntrNo(String n2ndCntrNo) {
		this.n2ndCntrNo = n2ndCntrNo;
	}
	
	/**
	 * Column Info
	 * @param psaSerNo
	 */
	public void setPsaSerNo(String psaSerNo) {
		this.psaSerNo = psaSerNo;
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
	 * @param n1stCntrNo
	 */
	public void setN1stCntrNo(String n1stCntrNo) {
		this.n1stCntrNo = n1stCntrNo;
	}
	
	/**
	 * Column Info
	 * @param n4thCntrNo
	 */
	public void setN4thCntrNo(String n4thCntrNo) {
		this.n4thCntrNo = n4thCntrNo;
	}
	
	/**
	 * Column Info
	 * @param n6thCntrNo
	 */
	public void setN6thCntrNo(String n6thCntrNo) {
		this.n6thCntrNo = n6thCntrNo;
	}
	
	/**
	 * Column Info
	 * @param n5thCntrNo
	 */
	public void setN5thCntrNo(String n5thCntrNo) {
		this.n5thCntrNo = n5thCntrNo;
	}
	
	/**
	 * Column Info
	 * @param n3rdCntrNo
	 */
	public void setN3rdCntrNo(String n3rdCntrNo) {
		this.n3rdCntrNo = n3rdCntrNo;
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
		setN2ndCntrNo(JSPUtil.getParameter(request, prefix + "n2nd_cntr_no", ""));
		setPsaSerNo(JSPUtil.getParameter(request, prefix + "psa_ser_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setN1stCntrNo(JSPUtil.getParameter(request, prefix + "n1st_cntr_no", ""));
		setN4thCntrNo(JSPUtil.getParameter(request, prefix + "n4th_cntr_no", ""));
		setN6thCntrNo(JSPUtil.getParameter(request, prefix + "n6th_cntr_no", ""));
		setN5thCntrNo(JSPUtil.getParameter(request, prefix + "n5th_cntr_no", ""));
		setN3rdCntrNo(JSPUtil.getParameter(request, prefix + "n3rd_cntr_no", ""));
		setBkgSeq(JSPUtil.getParameter(request, prefix + "bkg_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaCntrNoVO[]
	 */
	public PsaCntrNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsaCntrNoVO[]
	 */
	public PsaCntrNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaCntrNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n2ndCntrNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_cntr_no", length));
			String[] psaSerNo = (JSPUtil.getParameter(request, prefix	+ "psa_ser_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n1stCntrNo = (JSPUtil.getParameter(request, prefix	+ "n1st_cntr_no", length));
			String[] n4thCntrNo = (JSPUtil.getParameter(request, prefix	+ "n4th_cntr_no", length));
			String[] n6thCntrNo = (JSPUtil.getParameter(request, prefix	+ "n6th_cntr_no", length));
			String[] n5thCntrNo = (JSPUtil.getParameter(request, prefix	+ "n5th_cntr_no", length));
			String[] n3rdCntrNo = (JSPUtil.getParameter(request, prefix	+ "n3rd_cntr_no", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PsaCntrNoVO();
				if (n2ndCntrNo[i] != null)
					model.setN2ndCntrNo(n2ndCntrNo[i]);
				if (psaSerNo[i] != null)
					model.setPsaSerNo(psaSerNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n1stCntrNo[i] != null)
					model.setN1stCntrNo(n1stCntrNo[i]);
				if (n4thCntrNo[i] != null)
					model.setN4thCntrNo(n4thCntrNo[i]);
				if (n6thCntrNo[i] != null)
					model.setN6thCntrNo(n6thCntrNo[i]);
				if (n5thCntrNo[i] != null)
					model.setN5thCntrNo(n5thCntrNo[i]);
				if (n3rdCntrNo[i] != null)
					model.setN3rdCntrNo(n3rdCntrNo[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaCntrNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaCntrNoVO[]
	 */
	public PsaCntrNoVO[] getPsaCntrNoVOs(){
		PsaCntrNoVO[] vos = (PsaCntrNoVO[])models.toArray(new PsaCntrNoVO[models.size()]);
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
		this.n2ndCntrNo = this.n2ndCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaSerNo = this.psaSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCntrNo = this.n1stCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thCntrNo = this.n4thCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n6thCntrNo = this.n6thCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n5thCntrNo = this.n5thCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdCntrNo = this.n3rdCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
