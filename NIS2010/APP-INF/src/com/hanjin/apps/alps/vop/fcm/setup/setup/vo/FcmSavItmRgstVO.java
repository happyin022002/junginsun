/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FcmSavItmRgstVO.java
*@FileTitle : FcmSavItmRgstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.12.28  
* 1.0 Creation
* 
* History
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
=========================================================*/

package com.hanjin.apps.alps.vop.fcm.setup.setup.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FcmSavItmRgstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FcmSavItmRgstVO> models = new ArrayList<FcmSavItmRgstVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String trndLineConsVal = null;
	/* Column Info */
	private String n2ndVarDgrVal = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String savItmCd = null;
	/* Column Info */
	private String n2ndCoefVal = null;
	/* Column Info */
	private String cntrVslClssCapa = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String savCsmSubItmCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String itmTrndLineCd = null;
	/* Column Info */
	private String trndLineSeq = null;
	/* Column Info */
	private String itmUtPrc = null;
	/* Column Info */
	private String n1stVarDgrVal = null;
	/* Column Info */
	private String vslClssSubCd = null;
	/* Column Info */
	private String trndLineNo = null;
	/* Column Info */
	private String itmCsmRto = null;
	/* Column Info */
	private String n1stCoefVal = null;
	/* Column Info */
	private String itmNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FcmSavItmRgstVO() {}

	public FcmSavItmRgstVO(String ibflag, String pagerows, String updDt, String trndLineConsVal, String n2ndVarDgrVal, String savCsmSubItmCd, String creDt, String savItmCd, String n2ndCoefVal, String cntrVslClssCapa, String creUsrId, String itmTrndLineCd, String trndLineSeq, String itmUtPrc, String n1stVarDgrVal, String itmCsmRto, String n1stCoefVal, String updUsrId, String itmNm, String trndLineNo, String vslClssSubCd) {
		this.updDt = updDt;
		this.trndLineConsVal = trndLineConsVal;
		this.n2ndVarDgrVal = n2ndVarDgrVal;
		this.creDt = creDt;
		this.savItmCd = savItmCd;
		this.n2ndCoefVal = n2ndCoefVal;
		this.cntrVslClssCapa = cntrVslClssCapa;
		this.pagerows = pagerows;
		this.savCsmSubItmCd = savCsmSubItmCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.itmTrndLineCd = itmTrndLineCd;
		this.trndLineSeq = trndLineSeq;
		this.itmUtPrc = itmUtPrc;
		this.n1stVarDgrVal = n1stVarDgrVal;
		this.vslClssSubCd = vslClssSubCd;
		this.trndLineNo = trndLineNo;
		this.itmCsmRto = itmCsmRto;
		this.n1stCoefVal = n1stCoefVal;
		this.itmNm = itmNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("trnd_line_cons_val", getTrndLineConsVal());
		this.hashColumns.put("n2nd_var_dgr_val", getN2ndVarDgrVal());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sav_itm_cd", getSavItmCd());
		this.hashColumns.put("n2nd_coef_val", getN2ndCoefVal());
		this.hashColumns.put("cntr_vsl_clss_capa", getCntrVslClssCapa());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sav_csm_sub_itm_cd", getSavCsmSubItmCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("itm_trnd_line_cd", getItmTrndLineCd());
		this.hashColumns.put("trnd_line_seq", getTrndLineSeq());
		this.hashColumns.put("itm_ut_prc", getItmUtPrc());
		this.hashColumns.put("n1st_var_dgr_val", getN1stVarDgrVal());
		this.hashColumns.put("vsl_clss_sub_cd", getVslClssSubCd());
		this.hashColumns.put("trnd_line_no", getTrndLineNo());
		this.hashColumns.put("itm_csm_rto", getItmCsmRto());
		this.hashColumns.put("n1st_coef_val", getN1stCoefVal());
		this.hashColumns.put("itm_nm", getItmNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("trnd_line_cons_val", "trndLineConsVal");
		this.hashFields.put("n2nd_var_dgr_val", "n2ndVarDgrVal");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sav_itm_cd", "savItmCd");
		this.hashFields.put("n2nd_coef_val", "n2ndCoefVal");
		this.hashFields.put("cntr_vsl_clss_capa", "cntrVslClssCapa");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sav_csm_sub_itm_cd", "savCsmSubItmCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("itm_trnd_line_cd", "itmTrndLineCd");
		this.hashFields.put("trnd_line_seq", "trndLineSeq");
		this.hashFields.put("itm_ut_prc", "itmUtPrc");
		this.hashFields.put("n1st_var_dgr_val", "n1stVarDgrVal");
		this.hashFields.put("vsl_clss_sub_cd", "vslClssSubCd");
		this.hashFields.put("trnd_line_no", "trndLineNo");
		this.hashFields.put("itm_csm_rto", "itmCsmRto");
		this.hashFields.put("n1st_coef_val", "n1stCoefVal");
		this.hashFields.put("itm_nm", "itmNm");
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
	 * @return trndLineConsVal
	 */
	public String getTrndLineConsVal() {
		return this.trndLineConsVal;
	}
	
	/**
	 * Column Info
	 * @return n2ndVarDgrVal
	 */
	public String getN2ndVarDgrVal() {
		return this.n2ndVarDgrVal;
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
	 * @return savItmCd
	 */
	public String getSavItmCd() {
		return this.savItmCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndCoefVal
	 */
	public String getN2ndCoefVal() {
		return this.n2ndCoefVal;
	}
	
	/**
	 * Column Info
	 * @return cntrVslClssCapa
	 */
	public String getCntrVslClssCapa() {
		return this.cntrVslClssCapa;
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
	 * @return savCsmSubItmCd
	 */
	public String getSavCsmSubItmCd() {
		return this.savCsmSubItmCd;
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
	 * @return itmTrndLineCd
	 */
	public String getItmTrndLineCd() {
		return this.itmTrndLineCd;
	}
	
	/**
	 * Column Info
	 * @return trndLineSeq
	 */
	public String getTrndLineSeq() {
		return this.trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @return itmUtPrc
	 */
	public String getItmUtPrc() {
		return this.itmUtPrc;
	}
	
	/**
	 * Column Info
	 * @return n1stVarDgrVal
	 */
	public String getN1stVarDgrVal() {
		return this.n1stVarDgrVal;
	}
	
	/**
	 * Column Info
	 * @return vslClssSubCd
	 */
	public String getVslClssSubCd() {
		return this.vslClssSubCd;
	}
	
	/**
	 * Column Info
	 * @return trndLineNo
	 */
	public String getTrndLineNo() {
		return this.trndLineNo;
	}
	
	/**
	 * Column Info
	 * @return itmCsmRto
	 */
	public String getItmCsmRto() {
		return this.itmCsmRto;
	}
	
	/**
	 * Column Info
	 * @return n1stCoefVal
	 */
	public String getN1stCoefVal() {
		return this.n1stCoefVal;
	}
	
	/**
	 * Column Info
	 * @return itmNm
	 */
	public String getItmNm() {
		return this.itmNm;
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
	 * @param trndLineConsVal
	 */
	public void setTrndLineConsVal(String trndLineConsVal) {
		this.trndLineConsVal = trndLineConsVal;
	}
	
	/**
	 * Column Info
	 * @param n2ndVarDgrVal
	 */
	public void setN2ndVarDgrVal(String n2ndVarDgrVal) {
		this.n2ndVarDgrVal = n2ndVarDgrVal;
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
	 * @param savItmCd
	 */
	public void setSavItmCd(String savItmCd) {
		this.savItmCd = savItmCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndCoefVal
	 */
	public void setN2ndCoefVal(String n2ndCoefVal) {
		this.n2ndCoefVal = n2ndCoefVal;
	}
	
	/**
	 * Column Info
	 * @param cntrVslClssCapa
	 */
	public void setCntrVslClssCapa(String cntrVslClssCapa) {
		this.cntrVslClssCapa = cntrVslClssCapa;
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
	 * @param savCsmSubItmCd
	 */
	public void setSavCsmSubItmCd(String savCsmSubItmCd) {
		this.savCsmSubItmCd = savCsmSubItmCd;
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
	 * @param itmTrndLineCd
	 */
	public void setItmTrndLineCd(String itmTrndLineCd) {
		this.itmTrndLineCd = itmTrndLineCd;
	}
	
	/**
	 * Column Info
	 * @param trndLineSeq
	 */
	public void setTrndLineSeq(String trndLineSeq) {
		this.trndLineSeq = trndLineSeq;
	}
	
	/**
	 * Column Info
	 * @param itmUtPrc
	 */
	public void setItmUtPrc(String itmUtPrc) {
		this.itmUtPrc = itmUtPrc;
	}
	
	/**
	 * Column Info
	 * @param n1stVarDgrVal
	 */
	public void setN1stVarDgrVal(String n1stVarDgrVal) {
		this.n1stVarDgrVal = n1stVarDgrVal;
	}
	
	/**
	 * Column Info
	 * @param vslClssSubCd
	 */
	public void setVslClssSubCd(String vslClssSubCd) {
		this.vslClssSubCd = vslClssSubCd;
	}
	
	/**
	 * Column Info
	 * @param trndLineNo
	 */
	public void setTrndLineNo(String trndLineNo) {
		this.trndLineNo = trndLineNo;
	}
	
	/**
	 * Column Info
	 * @param itmCsmRto
	 */
	public void setItmCsmRto(String itmCsmRto) {
		this.itmCsmRto = itmCsmRto;
	}
	
	/**
	 * Column Info
	 * @param n1stCoefVal
	 */
	public void setN1stCoefVal(String n1stCoefVal) {
		this.n1stCoefVal = n1stCoefVal;
	}
	
	/**
	 * Column Info
	 * @param itmNm
	 */
	public void setItmNm(String itmNm) {
		this.itmNm = itmNm;
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
		setTrndLineConsVal(JSPUtil.getParameter(request, prefix + "trnd_line_cons_val", ""));
		setN2ndVarDgrVal(JSPUtil.getParameter(request, prefix + "n2nd_var_dgr_val", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSavItmCd(JSPUtil.getParameter(request, prefix + "sav_itm_cd", ""));
		setN2ndCoefVal(JSPUtil.getParameter(request, prefix + "n2nd_coef_val", ""));
		setCntrVslClssCapa(JSPUtil.getParameter(request, prefix + "cntr_vsl_clss_capa", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSavCsmSubItmCd(JSPUtil.getParameter(request, prefix + "sav_csm_sub_itm_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setItmTrndLineCd(JSPUtil.getParameter(request, prefix + "itm_trnd_line_cd", ""));
		setTrndLineSeq(JSPUtil.getParameter(request, prefix + "trnd_line_seq", ""));
		setItmUtPrc(JSPUtil.getParameter(request, prefix + "itm_ut_prc", ""));
		setN1stVarDgrVal(JSPUtil.getParameter(request, prefix + "n1st_var_dgr_val", ""));
		setVslClssSubCd(JSPUtil.getParameter(request, prefix + "vsl_clss_sub_cd", ""));
		setTrndLineNo(JSPUtil.getParameter(request, prefix + "trnd_line_no", ""));
		setItmCsmRto(JSPUtil.getParameter(request, prefix + "itm_csm_rto", ""));
		setN1stCoefVal(JSPUtil.getParameter(request, prefix + "n1st_coef_val", ""));
		setItmNm(JSPUtil.getParameter(request, prefix + "itm_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FcmSavItmRgstVO[]
	 */
	public FcmSavItmRgstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FcmSavItmRgstVO[]
	 */
	public FcmSavItmRgstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FcmSavItmRgstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] trndLineConsVal = (JSPUtil.getParameter(request, prefix	+ "trnd_line_cons_val", length));
			String[] n2ndVarDgrVal = (JSPUtil.getParameter(request, prefix	+ "n2nd_var_dgr_val", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] savItmCd = (JSPUtil.getParameter(request, prefix	+ "sav_itm_cd", length));
			String[] n2ndCoefVal = (JSPUtil.getParameter(request, prefix	+ "n2nd_coef_val", length));
			String[] cntrVslClssCapa = (JSPUtil.getParameter(request, prefix	+ "cntr_vsl_clss_capa", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] savCsmSubItmCd = (JSPUtil.getParameter(request, prefix	+ "sav_csm_sub_itm_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] itmTrndLineCd = (JSPUtil.getParameter(request, prefix	+ "itm_trnd_line_cd", length));
			String[] trndLineSeq = (JSPUtil.getParameter(request, prefix	+ "trnd_line_seq", length));
			String[] itmUtPrc = (JSPUtil.getParameter(request, prefix	+ "itm_ut_prc", length));
			String[] n1stVarDgrVal = (JSPUtil.getParameter(request, prefix	+ "n1st_var_dgr_val", length));
			String[] vslClssSubCd = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_sub_cd", length));
			String[] trndLineNo = (JSPUtil.getParameter(request, prefix	+ "trnd_line_no", length));
			String[] itmCsmRto = (JSPUtil.getParameter(request, prefix	+ "itm_csm_rto", length));
			String[] n1stCoefVal = (JSPUtil.getParameter(request, prefix	+ "n1st_coef_val", length));
			String[] itmNm = (JSPUtil.getParameter(request, prefix	+ "itm_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new FcmSavItmRgstVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (trndLineConsVal[i] != null)
					model.setTrndLineConsVal(trndLineConsVal[i]);
				if (n2ndVarDgrVal[i] != null)
					model.setN2ndVarDgrVal(n2ndVarDgrVal[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (savItmCd[i] != null)
					model.setSavItmCd(savItmCd[i]);
				if (n2ndCoefVal[i] != null)
					model.setN2ndCoefVal(n2ndCoefVal[i]);
				if (cntrVslClssCapa[i] != null)
					model.setCntrVslClssCapa(cntrVslClssCapa[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (savCsmSubItmCd[i] != null)
					model.setSavCsmSubItmCd(savCsmSubItmCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (itmTrndLineCd[i] != null)
					model.setItmTrndLineCd(itmTrndLineCd[i]);
				if (trndLineSeq[i] != null)
					model.setTrndLineSeq(trndLineSeq[i]);
				if (itmUtPrc[i] != null)
					model.setItmUtPrc(itmUtPrc[i]);
				if (n1stVarDgrVal[i] != null)
					model.setN1stVarDgrVal(n1stVarDgrVal[i]);
				if (vslClssSubCd[i] != null)
					model.setVslClssSubCd(vslClssSubCd[i]);
				if (trndLineNo[i] != null)
					model.setTrndLineNo(trndLineNo[i]);
				if (itmCsmRto[i] != null)
					model.setItmCsmRto(itmCsmRto[i]);
				if (n1stCoefVal[i] != null)
					model.setN1stCoefVal(n1stCoefVal[i]);
				if (itmNm[i] != null)
					model.setItmNm(itmNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFcmSavItmRgstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FcmSavItmRgstVO[]
	 */
	public FcmSavItmRgstVO[] getFcmSavItmRgstVOs(){
		FcmSavItmRgstVO[] vos = (FcmSavItmRgstVO[])models.toArray(new FcmSavItmRgstVO[models.size()]);
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
		this.trndLineConsVal = this.trndLineConsVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVarDgrVal = this.n2ndVarDgrVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savItmCd = this.savItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndCoefVal = this.n2ndCoefVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVslClssCapa = this.cntrVslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savCsmSubItmCd = this.savCsmSubItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmTrndLineCd = this.itmTrndLineCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineSeq = this.trndLineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmUtPrc = this.itmUtPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVarDgrVal = this.n1stVarDgrVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssSubCd = this.vslClssSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trndLineNo = this.trndLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmCsmRto = this.itmCsmRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCoefVal = this.n1stCoefVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itmNm = this.itmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
