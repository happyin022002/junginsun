/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchAverageUCListVO.java
*@FileTitle : SearchAverageUCListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2013.10.21 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAverageUCListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAverageUCListVO> models = new ArrayList<SearchAverageUCListVO>();
	
	/* Column Info */
	private String amt10 = null;
	/* Column Info */
	private String amt12 = null;
	/* Column Info */
	private String amt03 = null;
	/* Column Info */
	private String amt11 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String amt02 = null;
	/* Column Info */
	private String amt14 = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String amt01 = null;
	/* Column Info */
	private String amt13 = null;
	/* Column Info */
	private String amt07 = null;
	/* Column Info */
	private String amt06 = null;
	/* Column Info */
	private String amt05 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String amt04 = null;
	/* Column Info */
	private String amt08 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amt09 = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String dirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAverageUCListVO() {}

	public SearchAverageUCListVO(String ibflag, String pagerows, String costYrmon, String trdCd, String rlaneCd, String dirCd, String amt01, String amt02, String amt03, String amt04, String amt05, String amt06, String amt07, String amt08, String amt09, String amt10, String amt11, String amt12, String amt13, String amt14) {
		this.amt10 = amt10;
		this.amt12 = amt12;
		this.amt03 = amt03;
		this.amt11 = amt11;
		this.trdCd = trdCd;
		this.amt02 = amt02;
		this.amt14 = amt14;
		this.rlaneCd = rlaneCd;
		this.amt01 = amt01;
		this.amt13 = amt13;
		this.amt07 = amt07;
		this.amt06 = amt06;
		this.amt05 = amt05;
		this.pagerows = pagerows;
		this.amt04 = amt04;
		this.amt08 = amt08;
		this.ibflag = ibflag;
		this.amt09 = amt09;
		this.costYrmon = costYrmon;
		this.dirCd = dirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amt_10", getAmt10());
		this.hashColumns.put("amt_12", getAmt12());
		this.hashColumns.put("amt_03", getAmt03());
		this.hashColumns.put("amt_11", getAmt11());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("amt_02", getAmt02());
		this.hashColumns.put("amt_14", getAmt14());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("amt_01", getAmt01());
		this.hashColumns.put("amt_13", getAmt13());
		this.hashColumns.put("amt_07", getAmt07());
		this.hashColumns.put("amt_06", getAmt06());
		this.hashColumns.put("amt_05", getAmt05());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amt_04", getAmt04());
		this.hashColumns.put("amt_08", getAmt08());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amt_09", getAmt09());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("dir_cd", getDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amt_10", "amt10");
		this.hashFields.put("amt_12", "amt12");
		this.hashFields.put("amt_03", "amt03");
		this.hashFields.put("amt_11", "amt11");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("amt_02", "amt02");
		this.hashFields.put("amt_14", "amt14");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("amt_01", "amt01");
		this.hashFields.put("amt_13", "amt13");
		this.hashFields.put("amt_07", "amt07");
		this.hashFields.put("amt_06", "amt06");
		this.hashFields.put("amt_05", "amt05");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amt_04", "amt04");
		this.hashFields.put("amt_08", "amt08");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amt_09", "amt09");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("dir_cd", "dirCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return amt10
	 */
	public String getAmt10() {
		return this.amt10;
	}
	
	/**
	 * Column Info
	 * @return amt12
	 */
	public String getAmt12() {
		return this.amt12;
	}
	
	/**
	 * Column Info
	 * @return amt03
	 */
	public String getAmt03() {
		return this.amt03;
	}
	
	/**
	 * Column Info
	 * @return amt11
	 */
	public String getAmt11() {
		return this.amt11;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return amt02
	 */
	public String getAmt02() {
		return this.amt02;
	}
	
	/**
	 * Column Info
	 * @return amt14
	 */
	public String getAmt14() {
		return this.amt14;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return amt01
	 */
	public String getAmt01() {
		return this.amt01;
	}
	
	/**
	 * Column Info
	 * @return amt13
	 */
	public String getAmt13() {
		return this.amt13;
	}
	
	/**
	 * Column Info
	 * @return amt07
	 */
	public String getAmt07() {
		return this.amt07;
	}
	
	/**
	 * Column Info
	 * @return amt06
	 */
	public String getAmt06() {
		return this.amt06;
	}
	
	/**
	 * Column Info
	 * @return amt05
	 */
	public String getAmt05() {
		return this.amt05;
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
	 * @return amt04
	 */
	public String getAmt04() {
		return this.amt04;
	}
	
	/**
	 * Column Info
	 * @return amt08
	 */
	public String getAmt08() {
		return this.amt08;
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
	 * @return amt09
	 */
	public String getAmt09() {
		return this.amt09;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	

	/**
	 * Column Info
	 * @param amt10
	 */
	public void setAmt10(String amt10) {
		this.amt10 = amt10;
	}
	
	/**
	 * Column Info
	 * @param amt12
	 */
	public void setAmt12(String amt12) {
		this.amt12 = amt12;
	}
	
	/**
	 * Column Info
	 * @param amt03
	 */
	public void setAmt03(String amt03) {
		this.amt03 = amt03;
	}
	
	/**
	 * Column Info
	 * @param amt11
	 */
	public void setAmt11(String amt11) {
		this.amt11 = amt11;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param amt02
	 */
	public void setAmt02(String amt02) {
		this.amt02 = amt02;
	}
	
	/**
	 * Column Info
	 * @param amt14
	 */
	public void setAmt14(String amt14) {
		this.amt14 = amt14;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param amt01
	 */
	public void setAmt01(String amt01) {
		this.amt01 = amt01;
	}
	
	/**
	 * Column Info
	 * @param amt13
	 */
	public void setAmt13(String amt13) {
		this.amt13 = amt13;
	}
	
	/**
	 * Column Info
	 * @param amt07
	 */
	public void setAmt07(String amt07) {
		this.amt07 = amt07;
	}
	
	/**
	 * Column Info
	 * @param amt06
	 */
	public void setAmt06(String amt06) {
		this.amt06 = amt06;
	}
	
	/**
	 * Column Info
	 * @param amt05
	 */
	public void setAmt05(String amt05) {
		this.amt05 = amt05;
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
	 * @param amt04
	 */
	public void setAmt04(String amt04) {
		this.amt04 = amt04;
	}
	
	/**
	 * Column Info
	 * @param amt08
	 */
	public void setAmt08(String amt08) {
		this.amt08 = amt08;
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
	 * @param amt09
	 */
	public void setAmt09(String amt09) {
		this.amt09 = amt09;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
		setAmt10(JSPUtil.getParameter(request, prefix + "amt_10", ""));
		setAmt12(JSPUtil.getParameter(request, prefix + "amt_12", ""));
		setAmt03(JSPUtil.getParameter(request, prefix + "amt_03", ""));
		setAmt11(JSPUtil.getParameter(request, prefix + "amt_11", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setAmt02(JSPUtil.getParameter(request, prefix + "amt_02", ""));
		setAmt14(JSPUtil.getParameter(request, prefix + "amt_14", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setAmt01(JSPUtil.getParameter(request, prefix + "amt_01", ""));
		setAmt13(JSPUtil.getParameter(request, prefix + "amt_13", ""));
		setAmt07(JSPUtil.getParameter(request, prefix + "amt_07", ""));
		setAmt06(JSPUtil.getParameter(request, prefix + "amt_06", ""));
		setAmt05(JSPUtil.getParameter(request, prefix + "amt_05", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAmt04(JSPUtil.getParameter(request, prefix + "amt_04", ""));
		setAmt08(JSPUtil.getParameter(request, prefix + "amt_08", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmt09(JSPUtil.getParameter(request, prefix + "amt_09", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAverageUCListVO[]
	 */
	public SearchAverageUCListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAverageUCListVO[]
	 */
	public SearchAverageUCListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAverageUCListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amt10 = (JSPUtil.getParameter(request, prefix	+ "amt_10", length));
			String[] amt12 = (JSPUtil.getParameter(request, prefix	+ "amt_12", length));
			String[] amt03 = (JSPUtil.getParameter(request, prefix	+ "amt_03", length));
			String[] amt11 = (JSPUtil.getParameter(request, prefix	+ "amt_11", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] amt02 = (JSPUtil.getParameter(request, prefix	+ "amt_02", length));
			String[] amt14 = (JSPUtil.getParameter(request, prefix	+ "amt_14", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] amt01 = (JSPUtil.getParameter(request, prefix	+ "amt_01", length));
			String[] amt13 = (JSPUtil.getParameter(request, prefix	+ "amt_13", length));
			String[] amt07 = (JSPUtil.getParameter(request, prefix	+ "amt_07", length));
			String[] amt06 = (JSPUtil.getParameter(request, prefix	+ "amt_06", length));
			String[] amt05 = (JSPUtil.getParameter(request, prefix	+ "amt_05", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amt04 = (JSPUtil.getParameter(request, prefix	+ "amt_04", length));
			String[] amt08 = (JSPUtil.getParameter(request, prefix	+ "amt_08", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amt09 = (JSPUtil.getParameter(request, prefix	+ "amt_09", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAverageUCListVO();
				if (amt10[i] != null)
					model.setAmt10(amt10[i]);
				if (amt12[i] != null)
					model.setAmt12(amt12[i]);
				if (amt03[i] != null)
					model.setAmt03(amt03[i]);
				if (amt11[i] != null)
					model.setAmt11(amt11[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (amt02[i] != null)
					model.setAmt02(amt02[i]);
				if (amt14[i] != null)
					model.setAmt14(amt14[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (amt01[i] != null)
					model.setAmt01(amt01[i]);
				if (amt13[i] != null)
					model.setAmt13(amt13[i]);
				if (amt07[i] != null)
					model.setAmt07(amt07[i]);
				if (amt06[i] != null)
					model.setAmt06(amt06[i]);
				if (amt05[i] != null)
					model.setAmt05(amt05[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (amt04[i] != null)
					model.setAmt04(amt04[i]);
				if (amt08[i] != null)
					model.setAmt08(amt08[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amt09[i] != null)
					model.setAmt09(amt09[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAverageUCListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAverageUCListVO[]
	 */
	public SearchAverageUCListVO[] getSearchAverageUCListVOs(){
		SearchAverageUCListVO[] vos = (SearchAverageUCListVO[])models.toArray(new SearchAverageUCListVO[models.size()]);
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
		this.amt10 = this.amt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt12 = this.amt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt03 = this.amt03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt11 = this.amt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt02 = this.amt02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt14 = this.amt14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt01 = this.amt01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt13 = this.amt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt07 = this.amt07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt06 = this.amt06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt05 = this.amt05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt04 = this.amt04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt08 = this.amt08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt09 = this.amt09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
