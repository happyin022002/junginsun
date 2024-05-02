/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AsiaInlandCostAccountVO.java
*@FileTitle : AsiaInlandCostAccountVO
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.aoc.asiacostmgt.asiainlandcostmanage.vo;

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

public class AsiaInlandCostAccountVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AsiaInlandCostAccountVO> models = new ArrayList<AsiaInlandCostAccountVO>();
	
	/* Column Info */
	private String trfAmt20ft = null;
	/* Column Info */
	private String calcRmk20ft = null;
	/* Column Info */
	private String srcCd = null;
	/* Column Info */
	private String trfRoutDesc = null;
	/* Column Info */
	private String actGrp = null;
	/* Column Info */
	private String stndCostNm = null;
	/* Column Info */
	private String sysSrcCd20ft = null;
	/* Column Info */
	private String calcRmk40ft = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trfRoutSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trfAmt40ft = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String srcNm = null;
	/* Column Info */
	private String actGrpCd = null;
	/* Column Info */
	private String sysSrcCd40ft = null;
	/* Column Info */
	private String stndCostCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AsiaInlandCostAccountVO() {}

	public AsiaInlandCostAccountVO(String ibflag, String pagerows, String trfNo, String trfRoutSeq, String trfRoutDesc, String actGrp, String stndCostCd, String stndCostNm, String srcCd, String srcNm, String actGrpCd, String trfAmt20ft, String sysSrcCd20ft, String calcRmk20ft, String trfAmt40ft, String sysSrcCd40ft, String calcRmk40ft) {
		this.trfAmt20ft = trfAmt20ft;
		this.calcRmk20ft = calcRmk20ft;
		this.srcCd = srcCd;
		this.trfRoutDesc = trfRoutDesc;
		this.actGrp = actGrp;
		this.stndCostNm = stndCostNm;
		this.sysSrcCd20ft = sysSrcCd20ft;
		this.calcRmk40ft = calcRmk40ft;
		this.pagerows = pagerows;
		this.trfRoutSeq = trfRoutSeq;
		this.ibflag = ibflag;
		this.trfAmt40ft = trfAmt40ft;
		this.trfNo = trfNo;
		this.srcNm = srcNm;
		this.actGrpCd = actGrpCd;
		this.sysSrcCd40ft = sysSrcCd40ft;
		this.stndCostCd = stndCostCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trf_amt_20ft", getTrfAmt20ft());
		this.hashColumns.put("calc_rmk_20ft", getCalcRmk20ft());
		this.hashColumns.put("src_cd", getSrcCd());
		this.hashColumns.put("trf_rout_desc", getTrfRoutDesc());
		this.hashColumns.put("act_grp", getActGrp());
		this.hashColumns.put("stnd_cost_nm", getStndCostNm());
		this.hashColumns.put("sys_src_cd_20ft", getSysSrcCd20ft());
		this.hashColumns.put("calc_rmk_40ft", getCalcRmk40ft());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trf_rout_seq", getTrfRoutSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trf_amt_40ft", getTrfAmt40ft());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("src_nm", getSrcNm());
		this.hashColumns.put("act_grp_cd", getActGrpCd());
		this.hashColumns.put("sys_src_cd_40ft", getSysSrcCd40ft());
		this.hashColumns.put("stnd_cost_cd", getStndCostCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trf_amt_20ft", "trfAmt20ft");
		this.hashFields.put("calc_rmk_20ft", "calcRmk20ft");
		this.hashFields.put("src_cd", "srcCd");
		this.hashFields.put("trf_rout_desc", "trfRoutDesc");
		this.hashFields.put("act_grp", "actGrp");
		this.hashFields.put("stnd_cost_nm", "stndCostNm");
		this.hashFields.put("sys_src_cd_20ft", "sysSrcCd20ft");
		this.hashFields.put("calc_rmk_40ft", "calcRmk40ft");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trf_rout_seq", "trfRoutSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trf_amt_40ft", "trfAmt40ft");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("src_nm", "srcNm");
		this.hashFields.put("act_grp_cd", "actGrpCd");
		this.hashFields.put("sys_src_cd_40ft", "sysSrcCd40ft");
		this.hashFields.put("stnd_cost_cd", "stndCostCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return trfAmt20ft
	 */
	public String getTrfAmt20ft() {
		return this.trfAmt20ft;
	}
	
	/**
	 * Column Info
	 * @return calcRmk20ft
	 */
	public String getCalcRmk20ft() {
		return this.calcRmk20ft;
	}
	
	/**
	 * Column Info
	 * @return srcCd
	 */
	public String getSrcCd() {
		return this.srcCd;
	}
	
	/**
	 * Column Info
	 * @return trfRoutDesc
	 */
	public String getTrfRoutDesc() {
		return this.trfRoutDesc;
	}
	
	/**
	 * Column Info
	 * @return actGrp
	 */
	public String getActGrp() {
		return this.actGrp;
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
	 * @return sysSrcCd20ft
	 */
	public String getSysSrcCd20ft() {
		return this.sysSrcCd20ft;
	}
	
	/**
	 * Column Info
	 * @return calcRmk40ft
	 */
	public String getCalcRmk40ft() {
		return this.calcRmk40ft;
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
	 * @return trfRoutSeq
	 */
	public String getTrfRoutSeq() {
		return this.trfRoutSeq;
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
	 * @return trfAmt40ft
	 */
	public String getTrfAmt40ft() {
		return this.trfAmt40ft;
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
	 * @return srcNm
	 */
	public String getSrcNm() {
		return this.srcNm;
	}
	
	/**
	 * Column Info
	 * @return actGrpCd
	 */
	public String getActGrpCd() {
		return this.actGrpCd;
	}
	
	/**
	 * Column Info
	 * @return sysSrcCd40ft
	 */
	public String getSysSrcCd40ft() {
		return this.sysSrcCd40ft;
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
	 * @param trfAmt20ft
	 */
	public void setTrfAmt20ft(String trfAmt20ft) {
		this.trfAmt20ft = trfAmt20ft;
	}
	
	/**
	 * Column Info
	 * @param calcRmk20ft
	 */
	public void setCalcRmk20ft(String calcRmk20ft) {
		this.calcRmk20ft = calcRmk20ft;
	}
	
	/**
	 * Column Info
	 * @param srcCd
	 */
	public void setSrcCd(String srcCd) {
		this.srcCd = srcCd;
	}
	
	/**
	 * Column Info
	 * @param trfRoutDesc
	 */
	public void setTrfRoutDesc(String trfRoutDesc) {
		this.trfRoutDesc = trfRoutDesc;
	}
	
	/**
	 * Column Info
	 * @param actGrp
	 */
	public void setActGrp(String actGrp) {
		this.actGrp = actGrp;
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
	 * @param sysSrcCd20ft
	 */
	public void setSysSrcCd20ft(String sysSrcCd20ft) {
		this.sysSrcCd20ft = sysSrcCd20ft;
	}
	
	/**
	 * Column Info
	 * @param calcRmk40ft
	 */
	public void setCalcRmk40ft(String calcRmk40ft) {
		this.calcRmk40ft = calcRmk40ft;
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
	 * @param trfRoutSeq
	 */
	public void setTrfRoutSeq(String trfRoutSeq) {
		this.trfRoutSeq = trfRoutSeq;
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
	 * @param trfAmt40ft
	 */
	public void setTrfAmt40ft(String trfAmt40ft) {
		this.trfAmt40ft = trfAmt40ft;
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
	 * @param srcNm
	 */
	public void setSrcNm(String srcNm) {
		this.srcNm = srcNm;
	}
	
	/**
	 * Column Info
	 * @param actGrpCd
	 */
	public void setActGrpCd(String actGrpCd) {
		this.actGrpCd = actGrpCd;
	}
	
	/**
	 * Column Info
	 * @param sysSrcCd40ft
	 */
	public void setSysSrcCd40ft(String sysSrcCd40ft) {
		this.sysSrcCd40ft = sysSrcCd40ft;
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
		setTrfAmt20ft(JSPUtil.getParameter(request, prefix + "trf_amt_20ft", ""));
		setCalcRmk20ft(JSPUtil.getParameter(request, prefix + "calc_rmk_20ft", ""));
		setSrcCd(JSPUtil.getParameter(request, prefix + "src_cd", ""));
		setTrfRoutDesc(JSPUtil.getParameter(request, prefix + "trf_rout_desc", ""));
		setActGrp(JSPUtil.getParameter(request, prefix + "act_grp", ""));
		setStndCostNm(JSPUtil.getParameter(request, prefix + "stnd_cost_nm", ""));
		setSysSrcCd20ft(JSPUtil.getParameter(request, prefix + "sys_src_cd_20ft", ""));
		setCalcRmk40ft(JSPUtil.getParameter(request, prefix + "calc_rmk_40ft", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrfRoutSeq(JSPUtil.getParameter(request, prefix + "trf_rout_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrfAmt40ft(JSPUtil.getParameter(request, prefix + "trf_amt_40ft", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setSrcNm(JSPUtil.getParameter(request, prefix + "src_nm", ""));
		setActGrpCd(JSPUtil.getParameter(request, prefix + "act_grp_cd", ""));
		setSysSrcCd40ft(JSPUtil.getParameter(request, prefix + "sys_src_cd_40ft", ""));
		setStndCostCd(JSPUtil.getParameter(request, prefix + "stnd_cost_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AsiaInlandCostAccountVO[]
	 */
	public AsiaInlandCostAccountVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AsiaInlandCostAccountVO[]
	 */
	public AsiaInlandCostAccountVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AsiaInlandCostAccountVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] trfAmt20ft = (JSPUtil.getParameter(request, prefix	+ "trf_amt_20ft", length));
			String[] calcRmk20ft = (JSPUtil.getParameter(request, prefix	+ "calc_rmk_20ft", length));
			String[] srcCd = (JSPUtil.getParameter(request, prefix	+ "src_cd", length));
			String[] trfRoutDesc = (JSPUtil.getParameter(request, prefix	+ "trf_rout_desc", length));
			String[] actGrp = (JSPUtil.getParameter(request, prefix	+ "act_grp", length));
			String[] stndCostNm = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_nm", length));
			String[] sysSrcCd20ft = (JSPUtil.getParameter(request, prefix	+ "sys_src_cd_20ft", length));
			String[] calcRmk40ft = (JSPUtil.getParameter(request, prefix	+ "calc_rmk_40ft", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trfRoutSeq = (JSPUtil.getParameter(request, prefix	+ "trf_rout_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trfAmt40ft = (JSPUtil.getParameter(request, prefix	+ "trf_amt_40ft", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] srcNm = (JSPUtil.getParameter(request, prefix	+ "src_nm", length));
			String[] actGrpCd = (JSPUtil.getParameter(request, prefix	+ "act_grp_cd", length));
			String[] sysSrcCd40ft = (JSPUtil.getParameter(request, prefix	+ "sys_src_cd_40ft", length));
			String[] stndCostCd = (JSPUtil.getParameter(request, prefix	+ "stnd_cost_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AsiaInlandCostAccountVO();
				if (trfAmt20ft[i] != null)
					model.setTrfAmt20ft(trfAmt20ft[i]);
				if (calcRmk20ft[i] != null)
					model.setCalcRmk20ft(calcRmk20ft[i]);
				if (srcCd[i] != null)
					model.setSrcCd(srcCd[i]);
				if (trfRoutDesc[i] != null)
					model.setTrfRoutDesc(trfRoutDesc[i]);
				if (actGrp[i] != null)
					model.setActGrp(actGrp[i]);
				if (stndCostNm[i] != null)
					model.setStndCostNm(stndCostNm[i]);
				if (sysSrcCd20ft[i] != null)
					model.setSysSrcCd20ft(sysSrcCd20ft[i]);
				if (calcRmk40ft[i] != null)
					model.setCalcRmk40ft(calcRmk40ft[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trfRoutSeq[i] != null)
					model.setTrfRoutSeq(trfRoutSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trfAmt40ft[i] != null)
					model.setTrfAmt40ft(trfAmt40ft[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (srcNm[i] != null)
					model.setSrcNm(srcNm[i]);
				if (actGrpCd[i] != null)
					model.setActGrpCd(actGrpCd[i]);
				if (sysSrcCd40ft[i] != null)
					model.setSysSrcCd40ft(sysSrcCd40ft[i]);
				if (stndCostCd[i] != null)
					model.setStndCostCd(stndCostCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInlandCostAccountVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AsiaInlandCostAccountVO[]
	 */
	public AsiaInlandCostAccountVO[] getSearchInlandCostAccountVOs(){
		AsiaInlandCostAccountVO[] vos = (AsiaInlandCostAccountVO[])models.toArray(new AsiaInlandCostAccountVO[models.size()]);
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
		this.trfAmt20ft = this.trfAmt20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk20ft = this.calcRmk20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcCd = this.srcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRoutDesc = this.trfRoutDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actGrp = this.actGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostNm = this.stndCostNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSrcCd20ft = this.sysSrcCd20ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk40ft = this.calcRmk40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRoutSeq = this.trfRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfAmt40ft = this.trfAmt40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcNm = this.srcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actGrpCd = this.actGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSrcCd40ft = this.sysSrcCd40ft .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndCostCd = this.stndCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
