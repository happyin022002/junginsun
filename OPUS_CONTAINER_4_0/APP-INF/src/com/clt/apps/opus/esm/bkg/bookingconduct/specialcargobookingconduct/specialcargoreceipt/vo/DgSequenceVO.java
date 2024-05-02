/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DgSequenceVO.java
*@FileTitle : DgSequenceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.11.10 이병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

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
 * @author 이병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DgSequenceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DgSequenceVO> models = new ArrayList<DgSequenceVO>();
	
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String dcgoSeq = null;
	/* Column Info */
	private String dcgoStsCd = null;
	/* Column Info */
	private String cntrCgoSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrNo1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String mrnPolutFlg = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String dgCntrSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DgSequenceVO() {}

	public DgSequenceVO(String ibflag, String pagerows, String cntrNo, String cntrNo1, String cntrTpszCd, String cntrCgoSeq, String imdgUnNo, String imdgUnNoSeq, String imdgClssCd, String prpShpNm, String dcgoStsCd, String mrnPolutFlg, String imdgPckGrpCd, String dgCntrSeq, String dcgoSeq) {
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.dcgoSeq = dcgoSeq;
		this.dcgoStsCd = dcgoStsCd;
		this.cntrCgoSeq = cntrCgoSeq;
		this.pagerows = pagerows;
		this.cntrNo1 = cntrNo1;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.prpShpNm = prpShpNm;
		this.mrnPolutFlg = mrnPolutFlg;
		this.imdgUnNo = imdgUnNo;
		this.imdgClssCd = imdgClssCd;
		this.dgCntrSeq = dgCntrSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("dcgo_seq", getDcgoSeq());
		this.hashColumns.put("dcgo_sts_cd", getDcgoStsCd());
		this.hashColumns.put("cntr_cgo_seq", getCntrCgoSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_no1", getCntrNo1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("dg_cntr_seq", getDgCntrSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("dcgo_seq", "dcgoSeq");
		this.hashFields.put("dcgo_sts_cd", "dcgoStsCd");
		this.hashFields.put("cntr_cgo_seq", "cntrCgoSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_no1", "cntrNo1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("dg_cntr_seq", "dgCntrSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @return dcgoSeq
	 */
	public String getDcgoSeq() {
		return this.dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @return dcgoStsCd
	 */
	public String getDcgoStsCd() {
		return this.dcgoStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCgoSeq
	 */
	public String getCntrCgoSeq() {
		return this.cntrCgoSeq;
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
	 * @return cntrNo1
	 */
	public String getCntrNo1() {
		return this.cntrNo1;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	
	/**
	 * Column Info
	 * @return mrnPolutFlg
	 */
	public String getMrnPolutFlg() {
		return this.mrnPolutFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return dgCntrSeq
	 */
	public String getDgCntrSeq() {
		return this.dgCntrSeq;
	}
	

	/**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @param dcgoSeq
	 */
	public void setDcgoSeq(String dcgoSeq) {
		this.dcgoSeq = dcgoSeq;
	}
	
	/**
	 * Column Info
	 * @param dcgoStsCd
	 */
	public void setDcgoStsCd(String dcgoStsCd) {
		this.dcgoStsCd = dcgoStsCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCgoSeq
	 */
	public void setCntrCgoSeq(String cntrCgoSeq) {
		this.cntrCgoSeq = cntrCgoSeq;
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
	 * @param cntrNo1
	 */
	public void setCntrNo1(String cntrNo1) {
		this.cntrNo1 = cntrNo1;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param mrnPolutFlg
	 */
	public void setMrnPolutFlg(String mrnPolutFlg) {
		this.mrnPolutFlg = mrnPolutFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param dgCntrSeq
	 */
	public void setDgCntrSeq(String dgCntrSeq) {
		this.dgCntrSeq = dgCntrSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setImdgPckGrpCd(JSPUtil.getParameter(request, "imdg_pck_grp_cd", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, "imdg_un_no_seq", ""));
		setDcgoSeq(JSPUtil.getParameter(request, "dcgo_seq", ""));
		setDcgoStsCd(JSPUtil.getParameter(request, "dcgo_sts_cd", ""));
		setCntrCgoSeq(JSPUtil.getParameter(request, "cntr_cgo_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrNo1(JSPUtil.getParameter(request, "cntr_no1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setPrpShpNm(JSPUtil.getParameter(request, "prp_shp_nm", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request, "mrn_polut_flg", ""));
		setImdgUnNo(JSPUtil.getParameter(request, "imdg_un_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setDgCntrSeq(JSPUtil.getParameter(request, "dg_cntr_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgSequenceVO[]
	 */
	public DgSequenceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DgSequenceVO[]
	 */
	public DgSequenceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgSequenceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] dcgoSeq = (JSPUtil.getParameter(request, prefix	+ "dcgo_seq", length));
			String[] dcgoStsCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_sts_cd", length));
			String[] cntrCgoSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_cgo_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_no1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_polut_flg", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] dgCntrSeq = (JSPUtil.getParameter(request, prefix	+ "dg_cntr_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new DgSequenceVO();
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (dcgoSeq[i] != null)
					model.setDcgoSeq(dcgoSeq[i]);
				if (dcgoStsCd[i] != null)
					model.setDcgoStsCd(dcgoStsCd[i]);
				if (cntrCgoSeq[i] != null)
					model.setCntrCgoSeq(cntrCgoSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrNo1[i] != null)
					model.setCntrNo1(cntrNo1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (mrnPolutFlg[i] != null)
					model.setMrnPolutFlg(mrnPolutFlg[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (dgCntrSeq[i] != null)
					model.setDgCntrSeq(dgCntrSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgSequenceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgSequenceVO[]
	 */
	public DgSequenceVO[] getDgSequenceVOs(){
		DgSequenceVO[] vos = (DgSequenceVO[])models.toArray(new DgSequenceVO[models.size()]);
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
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoSeq = this.dcgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoStsCd = this.dcgoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCgoSeq = this.cntrCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo1 = this.cntrNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg = this.mrnPolutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrSeq = this.dgCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
