/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PreCMRemarkVO.java
*@FileTitle : PreCMRemarkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2014.08.18 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PreCMRemarkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreCMRemarkVO> models = new ArrayList<PreCMRemarkVO>();
	
	/* Column Info */
	private String masCostSrcCd = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String avgLvlChk = null;
	/* Column Info */
	private String vndr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String masCostSrcNm = null;
	/* Column Info */
	private String amt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grp = null;
	/* Column Info */
	private String ctrtRtnFlg = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String costCalcRmk = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PreCMRemarkVO() {}

	public PreCMRemarkVO(String ibflag, String pagerows, String nodCd, String grp, String stndCostCd, String stndCostNm, String masCostSrcCd, String masCostSrcNm, String amt, String ctrtRtnFlg, String costCalcRmk, String avgLvlChk, String vndr) {
		this.masCostSrcCd = masCostSrcCd;
		this.stndCostNm = stndCostNm;
		this.avgLvlChk = avgLvlChk;
		this.vndr = vndr;
		this.pagerows = pagerows;
		this.masCostSrcNm = masCostSrcNm;
		this.amt = amt;
		this.ibflag = ibflag;
		this.grp = grp;
		this.ctrtRtnFlg = ctrtRtnFlg;
		this.nodCd = nodCd;
		this.costCalcRmk = costCalcRmk;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mas_cost_src_cd", getMasCostSrcCd());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("avg_lvl_chk", getAvgLvlChk());
		this.hashColumns.put("vndr", getVndr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mas_cost_src_nm", getMasCostSrcNm());
		this.hashColumns.put("amt", getAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("ctrt_rtn_flg", getCtrtRtnFlg());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("cost_calc_rmk", getCostCalcRmk());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mas_cost_src_cd", "masCostSrcCd");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("avg_lvl_chk", "avgLvlChk");
		this.hashFields.put("vndr", "vndr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mas_cost_src_nm", "masCostSrcNm");
		this.hashFields.put("amt", "amt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp", "grp");
		this.hashFields.put("ctrt_rtn_flg", "ctrtRtnFlg");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("cost_calc_rmk", "costCalcRmk");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return masCostSrcCd
	 */
	public String getMasCostSrcCd() {
		return this.masCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @return stndCostNm
	 */
	public String getStndCostNm() {
		return this.stndCostNm;
	}
	
	/**
	 * Column Info
	 * @return avgLvlChk
	 */
	public String getAvgLvlChk() {
		return this.avgLvlChk;
	}
	
	/**
	 * Column Info
	 * @return vndr
	 */
	public String getVndr() {
		return this.vndr;
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
	 * @return masCostSrcNm
	 */
	public String getMasCostSrcNm() {
		return this.masCostSrcNm;
	}
	
	/**
	 * Column Info
	 * @return amt
	 */
	public String getAmt() {
		return this.amt;
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
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
	}
	
	/**
	 * Column Info
	 * @return ctrtRtnFlg
	 */
	public String getCtrtRtnFlg() {
		return this.ctrtRtnFlg;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return costCalcRmk
	 */
	public String getCostCalcRmk() {
		return this.costCalcRmk;
	}
	
	/**
	 * Column Info
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
	}
	

	/**
	 * Column Info
	 * @param masCostSrcCd
	 */
	public void setMasCostSrcCd(String masCostSrcCd) {
		this.masCostSrcCd = masCostSrcCd;
	}
	
	/**
	 * Column Info
	 * @param stndCostNm
	 */
	public void setStndCostNm(String stndCostNm) {
		this.stndCostNm = stndCostNm;
	}
	
	/**
	 * Column Info
	 * @param avgLvlChk
	 */
	public void setAvgLvlChk(String avgLvlChk) {
		this.avgLvlChk = avgLvlChk;
	}
	
	/**
	 * Column Info
	 * @param vndr
	 */
	public void setVndr(String vndr) {
		this.vndr = vndr;
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
	 * @param masCostSrcNm
	 */
	public void setMasCostSrcNm(String masCostSrcNm) {
		this.masCostSrcNm = masCostSrcNm;
	}
	
	/**
	 * Column Info
	 * @param amt
	 */
	public void setAmt(String amt) {
		this.amt = amt;
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
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
	}
	
	/**
	 * Column Info
	 * @param ctrtRtnFlg
	 */
	public void setCtrtRtnFlg(String ctrtRtnFlg) {
		this.ctrtRtnFlg = ctrtRtnFlg;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param costCalcRmk
	 */
	public void setCostCalcRmk(String costCalcRmk) {
		this.costCalcRmk = costCalcRmk;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
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
		setMasCostSrcCd(JSPUtil.getParameter(request, prefix + "mas_cost_src_cd", ""));
		setStndCostNm(JSPUtil.getParameter(request, prefix + "stnd_cost_nm", ""));
		setAvgLvlChk(JSPUtil.getParameter(request, prefix + "avg_lvl_chk", ""));
		setVndr(JSPUtil.getParameter(request, prefix + "vndr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMasCostSrcNm(JSPUtil.getParameter(request, prefix + "mas_cost_src_nm", ""));
		setAmt(JSPUtil.getParameter(request, prefix + "amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGrp(JSPUtil.getParameter(request, prefix + "grp", ""));
		setCtrtRtnFlg(JSPUtil.getParameter(request, prefix + "ctrt_rtn_flg", ""));
		setNodCd(JSPUtil.getParameter(request, prefix + "nod_cd", ""));
		setCostCalcRmk(JSPUtil.getParameter(request, prefix + "cost_calc_rmk", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreCMRemarkVO[]
	 */
	public PreCMRemarkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreCMRemarkVO[]
	 */
	public PreCMRemarkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreCMRemarkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] masCostSrcCd = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_cd", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] avgLvlChk = (JSPUtil.getParameter(request, prefix	+ "avg_lvl_chk", length));
			String[] vndr = (JSPUtil.getParameter(request, prefix	+ "vndr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] masCostSrcNm = (JSPUtil.getParameter(request, prefix	+ "mas_cost_src_nm", length));
			String[] amt = (JSPUtil.getParameter(request, prefix	+ "amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] ctrtRtnFlg = (JSPUtil.getParameter(request, prefix	+ "ctrt_rtn_flg", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] costCalcRmk = (JSPUtil.getParameter(request, prefix	+ "cost_calc_rmk", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PreCMRemarkVO();
				if (masCostSrcCd[i] != null)
					model.setMasCostSrcCd(masCostSrcCd[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (avgLvlChk[i] != null)
					model.setAvgLvlChk(avgLvlChk[i]);
				if (vndr[i] != null)
					model.setVndr(vndr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (masCostSrcNm[i] != null)
					model.setMasCostSrcNm(masCostSrcNm[i]);
				if (amt[i] != null)
					model.setAmt(amt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (ctrtRtnFlg[i] != null)
					model.setCtrtRtnFlg(ctrtRtnFlg[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (costCalcRmk[i] != null)
					model.setCostCalcRmk(costCalcRmk[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreCMRemarkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreCMRemarkVO[]
	 */
	public PreCMRemarkVO[] getPreCMRemarkVOs(){
		PreCMRemarkVO[] vos = (PreCMRemarkVO[])models.toArray(new PreCMRemarkVO[models.size()]);
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
		this.masCostSrcCd = this.masCostSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgLvlChk = this.avgLvlChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndr = this.vndr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.masCostSrcNm = this.masCostSrcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amt = this.amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRtnFlg = this.ctrtRtnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCalcRmk = this.costCalcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
