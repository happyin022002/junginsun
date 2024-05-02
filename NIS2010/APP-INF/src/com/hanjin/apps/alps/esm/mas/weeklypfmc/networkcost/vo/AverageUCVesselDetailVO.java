/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AverageUCVesselDetailVO.java
*@FileTitle : AverageUCVesselDetailVO
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

public class AverageUCVesselDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AverageUCVesselDetailVO> models = new ArrayList<AverageUCVesselDetailVO>();
	
	/* Column Info */
	private String dhirAmt = null;
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String grpKnt = null;
	/* Column Info */
	private String vslClssCapa = null;
	/* Column Info */
	private String vslKnt = null;
	/* Column Info */
	private String effYrmon = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String effWk = null;
	/* Column Info */
	private String stndCostCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AverageUCVesselDetailVO() {}

	public AverageUCVesselDetailVO(String ibflag, String pagerows, String costYrmon, String stndCostCd, String vslClssCapa, String vslCd, String dhirAmt, String vslKnt, String updUsrId, String grpKnt, String effYrmon, String effWk) {
		this.dhirAmt = dhirAmt;
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.grpKnt = grpKnt;
		this.vslClssCapa = vslClssCapa;
		this.vslKnt = vslKnt;
		this.effYrmon = effYrmon;
		this.updUsrId = updUsrId;
		this.effWk = effWk;
		this.stndCostCd = stndCostCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dhir_amt", getDhirAmt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("grp_knt", getGrpKnt());
		this.hashColumns.put("vsl_clss_capa", getVslClssCapa());
		this.hashColumns.put("vsl_knt", getVslKnt());
		this.hashColumns.put("eff_yrmon", getEffYrmon());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eff_wk", getEffWk());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dhir_amt", "dhirAmt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("grp_knt", "grpKnt");
		this.hashFields.put("vsl_clss_capa", "vslClssCapa");
		this.hashFields.put("vsl_knt", "vslKnt");
		this.hashFields.put("eff_yrmon", "effYrmon");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eff_wk", "effWk");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dhirAmt
	 */
	public String getDhirAmt() {
		return this.dhirAmt;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return grpKnt
	 */
	public String getGrpKnt() {
		return this.grpKnt;
	}
	
	/**
	 * Column Info
	 * @return vslClssCapa
	 */
	public String getVslClssCapa() {
		return this.vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @return vslKnt
	 */
	public String getVslKnt() {
		return this.vslKnt;
	}
	
	/**
	 * Column Info
	 * @return effYrmon
	 */
	public String getEffYrmon() {
		return this.effYrmon;
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
	 * @return effWk
	 */
	public String getEffWk() {
		return this.effWk;
	}
	
	/**
	 * Column Info
	 * @return stndCostCd
	 */
	public String getStndCostCd() {
		return this.stndCostCd;
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
	 * @param dhirAmt
	 */
	public void setDhirAmt(String dhirAmt) {
		this.dhirAmt = dhirAmt;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param grpKnt
	 */
	public void setGrpKnt(String grpKnt) {
		this.grpKnt = grpKnt;
	}
	
	/**
	 * Column Info
	 * @param vslClssCapa
	 */
	public void setVslClssCapa(String vslClssCapa) {
		this.vslClssCapa = vslClssCapa;
	}
	
	/**
	 * Column Info
	 * @param vslKnt
	 */
	public void setVslKnt(String vslKnt) {
		this.vslKnt = vslKnt;
	}
	
	/**
	 * Column Info
	 * @param effYrmon
	 */
	public void setEffYrmon(String effYrmon) {
		this.effYrmon = effYrmon;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param effWk
	 */
	public void setEffWk(String effWk) {
		this.effWk = effWk;
	}
	
	/**
	 * Column Info
	 * @param stndCostCd
	 */
	public void setStndCostCd(String stndCostCd) {
		this.stndCostCd = stndCostCd;
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
		setDhirAmt(JSPUtil.getParameter(request, prefix + "dhir_amt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setGrpKnt(JSPUtil.getParameter(request, prefix + "grp_knt", ""));
		setVslClssCapa(JSPUtil.getParameter(request, prefix + "vsl_clss_capa", ""));
		setVslKnt(JSPUtil.getParameter(request, prefix + "vsl_knt", ""));
		setEffYrmon(JSPUtil.getParameter(request, prefix + "eff_yrmon", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEffWk(JSPUtil.getParameter(request, prefix + "eff_wk", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AverageUCVesselDetailVO[]
	 */
	public AverageUCVesselDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AverageUCVesselDetailVO[]
	 */
	public AverageUCVesselDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AverageUCVesselDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dhirAmt = (JSPUtil.getParameter(request, prefix	+ "dhir_amt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] grpKnt = (JSPUtil.getParameter(request, prefix	+ "grp_knt", length));
			String[] vslClssCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_clss_capa", length));
			String[] vslKnt = (JSPUtil.getParameter(request, prefix	+ "vsl_knt", length));
			String[] effYrmon = (JSPUtil.getParameter(request, prefix	+ "eff_yrmon", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] effWk = (JSPUtil.getParameter(request, prefix	+ "eff_wk", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AverageUCVesselDetailVO();
				if (dhirAmt[i] != null)
					model.setDhirAmt(dhirAmt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (grpKnt[i] != null)
					model.setGrpKnt(grpKnt[i]);
				if (vslClssCapa[i] != null)
					model.setVslClssCapa(vslClssCapa[i]);
				if (vslKnt[i] != null)
					model.setVslKnt(vslKnt[i]);
				if (effYrmon[i] != null)
					model.setEffYrmon(effYrmon[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (effWk[i] != null)
					model.setEffWk(effWk[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAverageUCVesselDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AverageUCVesselDetailVO[]
	 */
	public AverageUCVesselDetailVO[] getAverageUCVesselDetailVOs(){
		AverageUCVesselDetailVO[] vos = (AverageUCVesselDetailVO[])models.toArray(new AverageUCVesselDetailVO[models.size()]);
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
		this.dhirAmt = this.dhirAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpKnt = this.grpKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClssCapa = this.vslClssCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslKnt = this.vslKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYrmon = this.effYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effWk = this.effWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
