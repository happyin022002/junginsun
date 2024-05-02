/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltMQCEstimateVO.java
*@FileTitle : RsltMQCEstimateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.05.11 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltMQCEstimateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltMQCEstimateVO> models = new ArrayList<RsltMQCEstimateVO>();
	
	/* Column Info */
	private String calcFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String propScpStsCd = null;
	/* Column Info */
	private String prsPropScpMqcQty = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String sumMqc = null;
	/* Column Info */
	private String unitNm = null;
	/* Column Info */
	private String cntrLodUtCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltMQCEstimateVO() {}

	public RsltMQCEstimateVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String prsPropScpMqcQty, String cntrLodUtCd, String unitNm, String propScpStsCd, String calcFlg, String sumMqc) {
		this.calcFlg = calcFlg;
		this.ibflag = ibflag;
		this.propScpStsCd = propScpStsCd;
		this.prsPropScpMqcQty = prsPropScpMqcQty;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.svcScpCd = svcScpCd;
		this.sumMqc = sumMqc;
		this.unitNm = unitNm;
		this.cntrLodUtCd = cntrLodUtCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("calc_flg", getCalcFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prop_scp_sts_cd", getPropScpStsCd());
		this.hashColumns.put("prs_prop_scp_mqc_qty", getPrsPropScpMqcQty());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("sum_mqc", getSumMqc());
		this.hashColumns.put("unit_nm", getUnitNm());
		this.hashColumns.put("cntr_lod_ut_cd", getCntrLodUtCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("calc_flg", "calcFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prop_scp_sts_cd", "propScpStsCd");
		this.hashFields.put("prs_prop_scp_mqc_qty", "prsPropScpMqcQty");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("sum_mqc", "sumMqc");
		this.hashFields.put("unit_nm", "unitNm");
		this.hashFields.put("cntr_lod_ut_cd", "cntrLodUtCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return calcFlg
	 */
	public String getCalcFlg() {
		return this.calcFlg;
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
	 * @return propScpStsCd
	 */
	public String getPropScpStsCd() {
		return this.propScpStsCd;
	}
	
	/**
	 * Column Info
	 * @return prsPropScpMqcQty
	 */
	public String getPrsPropScpMqcQty() {
		return this.prsPropScpMqcQty;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return sumMqc
	 */
	public String getSumMqc() {
		return this.sumMqc;
	}
	
	/**
	 * Column Info
	 * @return unitNm
	 */
	public String getUnitNm() {
		return this.unitNm;
	}
	
	/**
	 * Column Info
	 * @return cntrLodUtCd
	 */
	public String getCntrLodUtCd() {
		return this.cntrLodUtCd;
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
	 * @param calcFlg
	 */
	public void setCalcFlg(String calcFlg) {
		this.calcFlg = calcFlg;
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
	 * @param propScpStsCd
	 */
	public void setPropScpStsCd(String propScpStsCd) {
		this.propScpStsCd = propScpStsCd;
	}
	
	/**
	 * Column Info
	 * @param prsPropScpMqcQty
	 */
	public void setPrsPropScpMqcQty(String prsPropScpMqcQty) {
		this.prsPropScpMqcQty = prsPropScpMqcQty;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param sumMqc
	 */
	public void setSumMqc(String sumMqc) {
		this.sumMqc = sumMqc;
	}
	
	/**
	 * Column Info
	 * @param unitNm
	 */
	public void setUnitNm(String unitNm) {
		this.unitNm = unitNm;
	}
	
	/**
	 * Column Info
	 * @param cntrLodUtCd
	 */
	public void setCntrLodUtCd(String cntrLodUtCd) {
		this.cntrLodUtCd = cntrLodUtCd;
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
		setCalcFlg(JSPUtil.getParameter(request, prefix + "calc_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPropScpStsCd(JSPUtil.getParameter(request, prefix + "prop_scp_sts_cd", ""));
		setPrsPropScpMqcQty(JSPUtil.getParameter(request, prefix + "prs_prop_scp_mqc_qty", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setSumMqc(JSPUtil.getParameter(request, prefix + "sum_mqc", ""));
		setUnitNm(JSPUtil.getParameter(request, prefix + "unit_nm", ""));
		setCntrLodUtCd(JSPUtil.getParameter(request, prefix + "cntr_lod_ut_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltMQCEstimateVO[]
	 */
	public RsltMQCEstimateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltMQCEstimateVO[]
	 */
	public RsltMQCEstimateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltMQCEstimateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] calcFlg = (JSPUtil.getParameter(request, prefix	+ "calc_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] propScpStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_sts_cd", length));
			String[] prsPropScpMqcQty = (JSPUtil.getParameter(request, prefix	+ "prs_prop_scp_mqc_qty", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] sumMqc = (JSPUtil.getParameter(request, prefix	+ "sum_mqc", length));
			String[] unitNm = (JSPUtil.getParameter(request, prefix	+ "unit_nm", length));
			String[] cntrLodUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_lod_ut_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltMQCEstimateVO();
				if (calcFlg[i] != null)
					model.setCalcFlg(calcFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (propScpStsCd[i] != null)
					model.setPropScpStsCd(propScpStsCd[i]);
				if (prsPropScpMqcQty[i] != null)
					model.setPrsPropScpMqcQty(prsPropScpMqcQty[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (sumMqc[i] != null)
					model.setSumMqc(sumMqc[i]);
				if (unitNm[i] != null)
					model.setUnitNm(unitNm[i]);
				if (cntrLodUtCd[i] != null)
					model.setCntrLodUtCd(cntrLodUtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltMQCEstimateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltMQCEstimateVO[]
	 */
	public RsltMQCEstimateVO[] getRsltMQCEstimateVOs(){
		RsltMQCEstimateVO[] vos = (RsltMQCEstimateVO[])models.toArray(new RsltMQCEstimateVO[models.size()]);
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
		this.calcFlg = this.calcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpStsCd = this.propScpStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsPropScpMqcQty = this.prsPropScpMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumMqc = this.sumMqc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unitNm = this.unitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodUtCd = this.cntrLodUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
