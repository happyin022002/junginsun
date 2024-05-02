/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchOPCreditRtPortPairVO.java
*@FileTitle : SearchOPCreditRtPortPairVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.30  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SearchOPCreditRtPortPairVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOPCreditRtPortPairVO> models = new ArrayList<SearchOPCreditRtPortPairVO>();
	
	/* Column Info */
	private String porEccCd = null;
	private String delEccCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String tpszD4 = null;
	/* Column Info */
	private String tpszD2 = null;
	/* Column Info */
	private String tpszD5 = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String costYrmon = null;
	private String fCostYrmon = null;
	private String cntNm = null;

	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchOPCreditRtPortPairVO() {}

	public SearchOPCreditRtPortPairVO(String ibflag, String pagerows, String cntCd, String porEccCd, String tpszD2, String tpszD4, String tpszD5, String costYrmon, String delEccCd, String cntNm,String fCostYrmon) {
		this.porEccCd = porEccCd;
		this.delEccCd = delEccCd;
		this.ibflag = ibflag;
		this.cntCd = cntCd;
		this.tpszD4 = tpszD4;
		this.tpszD2 = tpszD2;
		this.tpszD5 = tpszD5;
		this.pagerows = pagerows;
		this.costYrmon = costYrmon;
		this.fCostYrmon = fCostYrmon;
		this.cntNm = cntNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_ecc_cd", getPorEccCd());
		this.hashColumns.put("del_ecc_cd", getDelEccCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("tpsz_d4", getTpszD4());
		this.hashColumns.put("tpsz_d2", getTpszD2());
		this.hashColumns.put("tpsz_d5", getTpszD5());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cnt_nm", getCntNm());
		return this.hashColumns;
	}
	
	public String getfCostYrmon() {
		return fCostYrmon;
	}

	public void setfCostYrmon(String fCostYrmon) {
		this.costYrmon = fCostYrmon.replaceAll("-", "");
	}

	public String getCntNm() {
		return cntNm;
	}

	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
	}

	public String getDelEccCd() {
		return delEccCd;
	}

	public void setDelEccCd(String delEccCd) {
		this.delEccCd = delEccCd;
	}

	public String getCostYrmon() {
		return costYrmon;
	}

	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_ecc_cd", "porEccCd");
		this.hashFields.put("del_ecc_cd", "delEccCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("tpsz_d4", "tpszD4");
		this.hashFields.put("tpsz_d2", "tpszD2");
		this.hashFields.put("tpsz_d5", "tpszD5");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cnt_nm", "cntNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porEccCd
	 */
	public String getPorEccCd() {
		return this.porEccCd;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return tpszD4
	 */
	public String getTpszD4() {
		return this.tpszD4;
	}
	
	/**
	 * Column Info
	 * @return tpszD2
	 */
	public String getTpszD2() {
		return this.tpszD2;
	}
	
	/**
	 * Column Info
	 * @return tpszD5
	 */
	public String getTpszD5() {
		return this.tpszD5;
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
	 * @param porEccCd
	 */
	public void setPorEccCd(String porEccCd) {
		this.porEccCd = porEccCd;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param tpszD4
	 */
	public void setTpszD4(String tpszD4) {
		this.tpszD4 = tpszD4;
	}
	
	/**
	 * Column Info
	 * @param tpszD2
	 */
	public void setTpszD2(String tpszD2) {
		this.tpszD2 = tpszD2;
	}
	
	/**
	 * Column Info
	 * @param tpszD5
	 */
	public void setTpszD5(String tpszD5) {
		this.tpszD5 = tpszD5;
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
		setPorEccCd(JSPUtil.getParameter(request, prefix + "por_ecc_cd", ""));
		setDelEccCd(JSPUtil.getParameter(request, prefix + "del_ecc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setTpszD4(JSPUtil.getParameter(request, prefix + "tpsz_d4", ""));
		setTpszD2(JSPUtil.getParameter(request, prefix + "tpsz_d2", ""));
		setTpszD5(JSPUtil.getParameter(request, prefix + "tpsz_d5", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setfCostYrmon(JSPUtil.getParameter(request, prefix + "f_cost_yrmon", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOPCreditRtPortPairVO[]
	 */
	public SearchOPCreditRtPortPairVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOPCreditRtPortPairVO[]
	 */
	public SearchOPCreditRtPortPairVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOPCreditRtPortPairVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porEccCd = (JSPUtil.getParameter(request, prefix	+ "por_ecc_cd", length));
			String[] delEccCd = (JSPUtil.getParameter(request, prefix	+ "del_ecc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] tpszD4 = (JSPUtil.getParameter(request, prefix	+ "tpsz_d4", length));
			String[] tpszD2 = (JSPUtil.getParameter(request, prefix	+ "tpsz_d2", length));
			String[] tpszD5 = (JSPUtil.getParameter(request, prefix	+ "tpsz_d5", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOPCreditRtPortPairVO();
				if (porEccCd[i] != null)
					model.setPorEccCd(porEccCd[i]);
				if (delEccCd[i] != null)
					model.setDelEccCd(delEccCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (tpszD4[i] != null)
					model.setTpszD4(tpszD4[i]);
				if (tpszD2[i] != null)
					model.setTpszD2(tpszD2[i]);
				if (tpszD5[i] != null)
					model.setTpszD5(tpszD5[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOPCreditRtPortPairVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOPCreditRtPortPairVO[]
	 */
	public SearchOPCreditRtPortPairVO[] getSearchOPCreditRtPortPairVOs(){
		SearchOPCreditRtPortPairVO[] vos = (SearchOPCreditRtPortPairVO[])models.toArray(new SearchOPCreditRtPortPairVO[models.size()]);
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
		this.porEccCd = this.porEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEccCd = this.delEccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD4 = this.tpszD4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD2 = this.tpszD2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszD5 = this.tpszD5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
