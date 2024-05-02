/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24BlCntrSealNoListVO.java
*@FileTitle : Eur24BlCntrSealNoListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.19  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eur24BlCntrSealNoListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eur24BlCntrSealNoListVO> models = new ArrayList<Eur24BlCntrSealNoListVO>();
	
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sealPtyTpCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String sealKndCd = null;
	/* Column Info */
	private String sealNoSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sealPtyNm = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eur24BlCntrSealNoListVO() {}

	public Eur24BlCntrSealNoListVO(String ibflag, String pagerows, String vvd, String blNo, String cstmsPortCd, String cntrNo, String sealNoSeq, String sealNo, String sealPtyTpCd, String sealPtyNm, String sealKndCd) {
		this.sealNo = sealNo;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.sealPtyTpCd = sealPtyTpCd;
		this.cntrNo = cntrNo;
		this.sealKndCd = sealKndCd;
		this.sealNoSeq = sealNoSeq;
		this.blNo = blNo;
		this.sealPtyNm = sealPtyNm;
		this.cstmsPortCd = cstmsPortCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("seal_pty_tp_cd", getSealPtyTpCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("seal_knd_cd", getSealKndCd());
		this.hashColumns.put("seal_no_seq", getSealNoSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("seal_pty_nm", getSealPtyNm());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("seal_pty_tp_cd", "sealPtyTpCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("seal_knd_cd", "sealKndCd");
		this.hashFields.put("seal_no_seq", "sealNoSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("seal_pty_nm", "sealPtyNm");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return sealPtyTpCd
	 */
	public String getSealPtyTpCd() {
		return this.sealPtyTpCd;
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
	 * @return sealKndCd
	 */
	public String getSealKndCd() {
		return this.sealKndCd;
	}
	
	/**
	 * Column Info
	 * @return sealNoSeq
	 */
	public String getSealNoSeq() {
		return this.sealNoSeq;
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
	 * @return sealPtyNm
	 */
	public String getSealPtyNm() {
		return this.sealPtyNm;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
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
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param sealPtyTpCd
	 */
	public void setSealPtyTpCd(String sealPtyTpCd) {
		this.sealPtyTpCd = sealPtyTpCd;
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
	 * @param sealKndCd
	 */
	public void setSealKndCd(String sealKndCd) {
		this.sealKndCd = sealKndCd;
	}
	
	/**
	 * Column Info
	 * @param sealNoSeq
	 */
	public void setSealNoSeq(String sealNoSeq) {
		this.sealNoSeq = sealNoSeq;
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
	 * @param sealPtyNm
	 */
	public void setSealPtyNm(String sealPtyNm) {
		this.sealPtyNm = sealPtyNm;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
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
		setSealNo(JSPUtil.getParameter(request, prefix + "seal_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSealPtyTpCd(JSPUtil.getParameter(request, prefix + "seal_pty_tp_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSealKndCd(JSPUtil.getParameter(request, prefix + "seal_knd_cd", ""));
		setSealNoSeq(JSPUtil.getParameter(request, prefix + "seal_no_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setSealPtyNm(JSPUtil.getParameter(request, prefix + "seal_pty_nm", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eur24BlCntrSealNoListVO[]
	 */
	public Eur24BlCntrSealNoListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eur24BlCntrSealNoListVO[]
	 */
	public Eur24BlCntrSealNoListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eur24BlCntrSealNoListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sealPtyTpCd = (JSPUtil.getParameter(request, prefix	+ "seal_pty_tp_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] sealKndCd = (JSPUtil.getParameter(request, prefix	+ "seal_knd_cd", length));
			String[] sealNoSeq = (JSPUtil.getParameter(request, prefix	+ "seal_no_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sealPtyNm = (JSPUtil.getParameter(request, prefix	+ "seal_pty_nm", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eur24BlCntrSealNoListVO();
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sealPtyTpCd[i] != null)
					model.setSealPtyTpCd(sealPtyTpCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (sealKndCd[i] != null)
					model.setSealKndCd(sealKndCd[i]);
				if (sealNoSeq[i] != null)
					model.setSealNoSeq(sealNoSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sealPtyNm[i] != null)
					model.setSealPtyNm(sealPtyNm[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEur24BlCntrSealNoListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eur24BlCntrSealNoListVO[]
	 */
	public Eur24BlCntrSealNoListVO[] getEur24BlCntrSealNoListVOs(){
		Eur24BlCntrSealNoListVO[] vos = (Eur24BlCntrSealNoListVO[])models.toArray(new Eur24BlCntrSealNoListVO[models.size()]);
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
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealPtyTpCd = this.sealPtyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealKndCd = this.sealKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNoSeq = this.sealNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealPtyNm = this.sealPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
