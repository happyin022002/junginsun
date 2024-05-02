/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchFixCostByVVDOP4ListVO.java
*@FileTitle : SearchFixCostByVVDOP4ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09 
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.03.09 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFixCostByVVDOP4ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFixCostByVVDOP4ListVO> models = new ArrayList<SearchFixCostByVVDOP4ListVO>();
	
	/* Column Info */
	private String amt03 = null;
	/* Column Info */
	private String amt02 = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String amt01 = null;
	/* Column Info */
	private String rlaneCd = null;
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
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amt08 = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String amt09 = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String laneTpCd = null;
	/* Column Info */
	private String amt10 = null;
	/* Column Info */
	private String amt12 = null;
	/* Column Info */
	private String amt11 = null;
	/* Column Info */
	private String amt14 = null;
	/* Column Info */
	private String amt13 = null;
	/* Column Info */
	private String amt15 = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String bsa = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchFixCostByVVDOP4ListVO() {}

	public SearchFixCostByVVDOP4ListVO(String ibflag, String pagerows, String slsYrmon, String costYrmon, String costWk, String trdCd, String rlaneCd, String laneTpCd, String vvd, String hulBndCd, String bsa, String amt01, String amt02, String amt03, String amt04, String amt05, String amt06, String amt07, String amt08, String amt09, String amt10, String amt11, String amt12, String amt13, String amt14, String amt15) {
		this.amt03 = amt03;
		this.amt02 = amt02;
		this.trdCd = trdCd;
		this.amt01 = amt01;
		this.rlaneCd = rlaneCd;
		this.amt07 = amt07;
		this.amt06 = amt06;
		this.amt05 = amt05;
		this.pagerows = pagerows;
		this.amt04 = amt04;
		this.ibflag = ibflag;
		this.amt08 = amt08;
		this.costYrmon = costYrmon;
		this.amt09 = amt09;
		this.hulBndCd = hulBndCd;
		this.laneTpCd = laneTpCd;
		this.amt10 = amt10;
		this.amt12 = amt12;
		this.amt11 = amt11;
		this.amt14 = amt14;
		this.amt13 = amt13;
		this.amt15 = amt15;
		this.vvd = vvd;
		this.slsYrmon = slsYrmon;
		this.costWk = costWk;
		this.bsa = bsa;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amt_03", getAmt03());
		this.hashColumns.put("amt_02", getAmt02());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("amt_01", getAmt01());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("amt_07", getAmt07());
		this.hashColumns.put("amt_06", getAmt06());
		this.hashColumns.put("amt_05", getAmt05());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amt_04", getAmt04());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amt_08", getAmt08());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("amt_09", getAmt09());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("lane_tp_cd", getLaneTpCd());
		this.hashColumns.put("amt_10", getAmt10());
		this.hashColumns.put("amt_12", getAmt12());
		this.hashColumns.put("amt_11", getAmt11());
		this.hashColumns.put("amt_14", getAmt14());
		this.hashColumns.put("amt_13", getAmt13());
		this.hashColumns.put("amt_15", getAmt15());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("bsa", getBsa());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amt_03", "amt03");
		this.hashFields.put("amt_02", "amt02");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("amt_01", "amt01");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("amt_07", "amt07");
		this.hashFields.put("amt_06", "amt06");
		this.hashFields.put("amt_05", "amt05");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amt_04", "amt04");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amt_08", "amt08");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("amt_09", "amt09");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("lane_tp_cd", "laneTpCd");
		this.hashFields.put("amt_10", "amt10");
		this.hashFields.put("amt_12", "amt12");
		this.hashFields.put("amt_11", "amt11");
		this.hashFields.put("amt_14", "amt14");
		this.hashFields.put("amt_13", "amt13");
		this.hashFields.put("amt_15", "amt15");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("bsa", "bsa");
		return this.hashFields;
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
	 * @return amt02
	 */
	public String getAmt02() {
		return this.amt02;
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
	 * @return amt01
	 */
	public String getAmt01() {
		return this.amt01;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return amt08
	 */
	public String getAmt08() {
		return this.amt08;
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
	 * @return amt09
	 */
	public String getAmt09() {
		return this.amt09;
	}
	
	/**
	 * Column Info
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return laneTpCd
	 */
	public String getLaneTpCd() {
		return this.laneTpCd;
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
	 * @return amt11
	 */
	public String getAmt11() {
		return this.amt11;
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
	 * @return amt13
	 */
	public String getAmt13() {
		return this.amt13;
	}
	
	/**
	 * Column Info
	 * @return amt15
	 */
	public String getAmt15() {
		return this.amt15;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return slsYrmon
	 */
	public String getSlsYrmon() {
		return this.slsYrmon;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
	}
	
	/**
	 * Column Info
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
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
	 * @param amt02
	 */
	public void setAmt02(String amt02) {
		this.amt02 = amt02;
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
	 * @param amt01
	 */
	public void setAmt01(String amt01) {
		this.amt01 = amt01;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param amt08
	 */
	public void setAmt08(String amt08) {
		this.amt08 = amt08;
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
	 * @param amt09
	 */
	public void setAmt09(String amt09) {
		this.amt09 = amt09;
	}
	
	/**
	 * Column Info
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param laneTpCd
	 */
	public void setLaneTpCd(String laneTpCd) {
		this.laneTpCd = laneTpCd;
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
	 * @param amt11
	 */
	public void setAmt11(String amt11) {
		this.amt11 = amt11;
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
	 * @param amt13
	 */
	public void setAmt13(String amt13) {
		this.amt13 = amt13;
	}
	
	/**
	 * Column Info
	 * @param amt15
	 */
	public void setAmt15(String amt15) {
		this.amt15 = amt15;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param slsYrmon
	 */
	public void setSlsYrmon(String slsYrmon) {
		this.slsYrmon = slsYrmon;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
	}
	
	/**
	 * Column Info
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
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
		setAmt03(JSPUtil.getParameter(request, prefix + "amt_03", ""));
		setAmt02(JSPUtil.getParameter(request, prefix + "amt_02", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setAmt01(JSPUtil.getParameter(request, prefix + "amt_01", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setAmt07(JSPUtil.getParameter(request, prefix + "amt_07", ""));
		setAmt06(JSPUtil.getParameter(request, prefix + "amt_06", ""));
		setAmt05(JSPUtil.getParameter(request, prefix + "amt_05", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAmt04(JSPUtil.getParameter(request, prefix + "amt_04", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmt08(JSPUtil.getParameter(request, prefix + "amt_08", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setAmt09(JSPUtil.getParameter(request, prefix + "amt_09", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setLaneTpCd(JSPUtil.getParameter(request, prefix + "lane_tp_cd", ""));
		setAmt10(JSPUtil.getParameter(request, prefix + "amt_10", ""));
		setAmt12(JSPUtil.getParameter(request, prefix + "amt_12", ""));
		setAmt11(JSPUtil.getParameter(request, prefix + "amt_11", ""));
		setAmt14(JSPUtil.getParameter(request, prefix + "amt_14", ""));
		setAmt13(JSPUtil.getParameter(request, prefix + "amt_13", ""));
		setAmt15(JSPUtil.getParameter(request, prefix + "amt_15", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setBsa(JSPUtil.getParameter(request, prefix + "bsa", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFixCostByVVDOP4ListVO[]
	 */
	public SearchFixCostByVVDOP4ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFixCostByVVDOP4ListVO[]
	 */
	public SearchFixCostByVVDOP4ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFixCostByVVDOP4ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amt03 = (JSPUtil.getParameter(request, prefix	+ "amt_03", length));
			String[] amt02 = (JSPUtil.getParameter(request, prefix	+ "amt_02", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] amt01 = (JSPUtil.getParameter(request, prefix	+ "amt_01", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] amt07 = (JSPUtil.getParameter(request, prefix	+ "amt_07", length));
			String[] amt06 = (JSPUtil.getParameter(request, prefix	+ "amt_06", length));
			String[] amt05 = (JSPUtil.getParameter(request, prefix	+ "amt_05", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] amt04 = (JSPUtil.getParameter(request, prefix	+ "amt_04", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amt08 = (JSPUtil.getParameter(request, prefix	+ "amt_08", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] amt09 = (JSPUtil.getParameter(request, prefix	+ "amt_09", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] laneTpCd = (JSPUtil.getParameter(request, prefix	+ "lane_tp_cd", length));
			String[] amt10 = (JSPUtil.getParameter(request, prefix	+ "amt_10", length));
			String[] amt12 = (JSPUtil.getParameter(request, prefix	+ "amt_12", length));
			String[] amt11 = (JSPUtil.getParameter(request, prefix	+ "amt_11", length));
			String[] amt14 = (JSPUtil.getParameter(request, prefix	+ "amt_14", length));
			String[] amt13 = (JSPUtil.getParameter(request, prefix	+ "amt_13", length));
			String[] amt15 = (JSPUtil.getParameter(request, prefix	+ "amt_15", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFixCostByVVDOP4ListVO();
				if (amt03[i] != null)
					model.setAmt03(amt03[i]);
				if (amt02[i] != null)
					model.setAmt02(amt02[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (amt01[i] != null)
					model.setAmt01(amt01[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
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
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amt08[i] != null)
					model.setAmt08(amt08[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (amt09[i] != null)
					model.setAmt09(amt09[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (laneTpCd[i] != null)
					model.setLaneTpCd(laneTpCd[i]);
				if (amt10[i] != null)
					model.setAmt10(amt10[i]);
				if (amt12[i] != null)
					model.setAmt12(amt12[i]);
				if (amt11[i] != null)
					model.setAmt11(amt11[i]);
				if (amt14[i] != null)
					model.setAmt14(amt14[i]);
				if (amt13[i] != null)
					model.setAmt13(amt13[i]);
				if (amt15[i] != null)
					model.setAmt15(amt15[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFixCostByVVDOP4ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFixCostByVVDOP4ListVO[]
	 */
	public SearchFixCostByVVDOP4ListVO[] getSearchFixCostByVVDOP4ListVOs(){
		SearchFixCostByVVDOP4ListVO[] vos = (SearchFixCostByVVDOP4ListVO[])models.toArray(new SearchFixCostByVVDOP4ListVO[models.size()]);
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
		this.amt03 = this.amt03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt02 = this.amt02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt01 = this.amt01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt07 = this.amt07 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt06 = this.amt06 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt05 = this.amt05 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt04 = this.amt04 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt08 = this.amt08 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt09 = this.amt09 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneTpCd = this.laneTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt10 = this.amt10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt12 = this.amt12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt11 = this.amt11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt14 = this.amt14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt13 = this.amt13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt15 = this.amt15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
