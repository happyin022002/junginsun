/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchTariffCodeALLVO.java
*@FileTitle : SearchTariffCodeALLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.27
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.27 서미진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.tariffcode.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTariffCodeALLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTariffCodeALLVO> models = new ArrayList<SearchTariffCodeALLVO>();
	
	/* Column Info */
	private String trfBzcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String trfNm = null;
	/* Column Info */
	private String tariffCode = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchTariffCodeALLVO() {}

	public SearchTariffCodeALLVO(String ibflag, String pagerows, String tariffCode, String amdtSeq, String trfBzcTpCd, String trfNm, String trfPfxCd, String trfNo) {
		this.trfBzcTpCd = trfBzcTpCd;
		this.ibflag = ibflag;
		this.amdtSeq = amdtSeq;
		this.trfNo = trfNo;
		this.trfNm = trfNm;
		this.tariffCode = tariffCode;
		this.trfPfxCd = trfPfxCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trf_bzc_tp_cd", getTrfBzcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("trf_nm", getTrfNm());
		this.hashColumns.put("tariff_code", getTariffCode());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trf_bzc_tp_cd", "trfBzcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("trf_nm", "trfNm");
		this.hashFields.put("tariff_code", "tariffCode");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trfBzcTpCd
	 */
	public String getTrfBzcTpCd() {
		return this.trfBzcTpCd;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return trfNm
	 */
	public String getTrfNm() {
		return this.trfNm;
	}
	
	/**
	 * Column Info
	 * @return tariffCode
	 */
	public String getTariffCode() {
		return this.tariffCode;
	}
	
	/**
	 * Column Info
	 * @return trfPfxCd
	 */
	public String getTrfPfxCd() {
		return this.trfPfxCd;
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
	 * @param trfBzcTpCd
	 */
	public void setTrfBzcTpCd(String trfBzcTpCd) {
		this.trfBzcTpCd = trfBzcTpCd;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param trfNm
	 */
	public void setTrfNm(String trfNm) {
		this.trfNm = trfNm;
	}
	
	/**
	 * Column Info
	 * @param tariffCode
	 */
	public void setTariffCode(String tariffCode) {
		this.tariffCode = tariffCode;
	}
	
	/**
	 * Column Info
	 * @param trfPfxCd
	 */
	public void setTrfPfxCd(String trfPfxCd) {
		this.trfPfxCd = trfPfxCd;
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
		setTrfBzcTpCd(JSPUtil.getParameter(request, prefix + "trf_bzc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setTrfNm(JSPUtil.getParameter(request, prefix + "trf_nm", ""));
		setTariffCode(JSPUtil.getParameter(request, prefix + "tariff_code", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, prefix + "trf_pfx_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTariffCodeALLVO[]
	 */
	public SearchTariffCodeALLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTariffCodeALLVO[]
	 */
	public SearchTariffCodeALLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTariffCodeALLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trfBzcTpCd = (JSPUtil.getParameter(request, prefix	+ "trf_bzc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] trfNm = (JSPUtil.getParameter(request, prefix	+ "trf_nm", length));
			String[] tariffCode = (JSPUtil.getParameter(request, prefix	+ "tariff_code", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTariffCodeALLVO();
				if (trfBzcTpCd[i] != null)
					model.setTrfBzcTpCd(trfBzcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (trfNm[i] != null)
					model.setTrfNm(trfNm[i]);
				if (tariffCode[i] != null)
					model.setTariffCode(tariffCode[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTariffCodeALLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTariffCodeALLVO[]
	 */
	public SearchTariffCodeALLVO[] getSearchTariffCodeALLVOs(){
		SearchTariffCodeALLVO[] vos = (SearchTariffCodeALLVO[])models.toArray(new SearchTariffCodeALLVO[models.size()]);
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
		this.trfBzcTpCd = this.trfBzcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNm = this.trfNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariffCode = this.tariffCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
