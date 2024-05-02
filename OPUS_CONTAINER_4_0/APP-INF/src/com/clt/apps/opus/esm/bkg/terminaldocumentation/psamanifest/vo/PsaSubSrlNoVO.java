/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PsaSubSrlNoVO.java
*@FileTitle : PsaSubSrlNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.08
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo;

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

public class PsaSubSrlNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PsaSubSrlNoVO> models = new ArrayList<PsaSubSrlNoVO>();

	/* Column Info */
	private String psaSerNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String subPsaSerNo = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PsaSubSrlNoVO() {}

	public PsaSubSrlNoVO(String ibflag, String pagerows, String subPsaSerNo, String bkgNo, String bkgSeq, String psaSerNo, String ydCd, String cntrTpszCd) {
		this.psaSerNo = psaSerNo;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.subPsaSerNo = subPsaSerNo;
		this.ydCd = ydCd;
		this.cntrTpszCd = cntrTpszCd;
		this.bkgSeq = bkgSeq;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("psa_ser_no", getPsaSerNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sub_psa_ser_no", getSubPsaSerNo());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("psa_ser_no", "psaSerNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sub_psa_ser_no", "subPsaSerNo");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return subPsaSerNo
	 */
	public String getSubPsaSerNo() {
		return this.subPsaSerNo;
	}

	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @param subPsaSerNo
	 */
	public void setSubPsaSerNo(String subPsaSerNo) {
		this.subPsaSerNo = subPsaSerNo;
	}

	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
		setPsaSerNo(JSPUtil.getParameter(request, prefix + "psa_ser_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSubPsaSerNo(JSPUtil.getParameter(request, prefix + "sub_psa_ser_no", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setBkgSeq(JSPUtil.getParameter(request, prefix + "bkg_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaSubSrlNoVO[]
	 */
	public PsaSubSrlNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PsaSubSrlNoVO[]
	 */
	public PsaSubSrlNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaSubSrlNoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] psaSerNo = (JSPUtil.getParameter(request, prefix	+ "psa_ser_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] subPsaSerNo = (JSPUtil.getParameter(request, prefix	+ "sub_psa_ser_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new PsaSubSrlNoVO();
				if (psaSerNo[i] != null)
					model.setPsaSerNo(psaSerNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (subPsaSerNo[i] != null)
					model.setSubPsaSerNo(subPsaSerNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaSubSrlNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaSubSrlNoVO[]
	 */
	public PsaSubSrlNoVO[] getPsaSubSrlNoVOs(){
		PsaSubSrlNoVO[] vos = (PsaSubSrlNoVO[])models.toArray(new PsaSubSrlNoVO[models.size()]);
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
		this.psaSerNo = this.psaSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subPsaSerNo = this.subPsaSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
