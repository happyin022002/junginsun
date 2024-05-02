/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchInqByCondition060ListVO.java
*@FileTitle : SearchInqByCondition060ListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo;

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

public class SearchInqByCondition060ListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchInqByCondition060ListVO> models = new ArrayList<SearchInqByCondition060ListVO>();
	
	/* Column Info */
	private String rev = null;
	/* Column Info */
	private String op = null;
	/* Column Info */
	private String opcost = null;
	/* Column Info */
	private String tpszCode = null;
	/* Column Info */
	private String opb = null;
	/* Column Info */
	private String cmCost = null;
	/* Column Info */
	private String opc = null;
	/* Column Info */
	private String opCost = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cmb = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String gRpb = null;
	/* Column Info */
	private String cmc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String dirCd2 = null;
	/* Column Info */
	private String load = null;
	/* Column Info */
	private String cmcost = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchInqByCondition060ListVO() {}

	public SearchInqByCondition060ListVO(String ibflag, String pagerows, String costYrmon, String slsYrmon, String costWk, String dirCd2, String tpszCode, String load, String rev, String cmc, String cm, String opc, String op, String gRpb, String cmCost, String cmcost, String cmb, String opCost, String opcost, String opb) {
		this.rev = rev;
		this.op = op;
		this.opcost = opcost;
		this.tpszCode = tpszCode;
		this.opb = opb;
		this.cmCost = cmCost;
		this.opc = opc;
		this.opCost = opCost;
		this.pagerows = pagerows;
		this.cmb = cmb;
		this.slsYrmon = slsYrmon;
		this.gRpb = gRpb;
		this.cmc = cmc;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.cm = cm;
		this.costWk = costWk;
		this.dirCd2 = dirCd2;
		this.load = load;
		this.cmcost = cmcost;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev", getRev());
		this.hashColumns.put("op", getOp());
		this.hashColumns.put("opcost", getOpcost());
		this.hashColumns.put("tpsz_code", getTpszCode());
		this.hashColumns.put("opb", getOpb());
		this.hashColumns.put("cm_cost", getCmCost());
		this.hashColumns.put("opc", getOpc());
		this.hashColumns.put("op_cost", getOpCost());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cmb", getCmb());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("g_rpb", getGRpb());
		this.hashColumns.put("cmc", getCmc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("dir_cd2", getDirCd2());
		this.hashColumns.put("load", getLoad());
		this.hashColumns.put("cmcost", getCmcost());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev", "rev");
		this.hashFields.put("op", "op");
		this.hashFields.put("opcost", "opcost");
		this.hashFields.put("tpsz_code", "tpszCode");
		this.hashFields.put("opb", "opb");
		this.hashFields.put("cm_cost", "cmCost");
		this.hashFields.put("opc", "opc");
		this.hashFields.put("op_cost", "opCost");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cmb", "cmb");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("g_rpb", "gRpb");
		this.hashFields.put("cmc", "cmc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("dir_cd2", "dirCd2");
		this.hashFields.put("load", "load");
		this.hashFields.put("cmcost", "cmcost");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rev
	 */
	public String getRev() {
		return this.rev;
	}
	
	/**
	 * Column Info
	 * @return op
	 */
	public String getOp() {
		return this.op;
	}
	
	/**
	 * Column Info
	 * @return opcost
	 */
	public String getOpcost() {
		return this.opcost;
	}
	
	/**
	 * Column Info
	 * @return tpszCode
	 */
	public String getTpszCode() {
		return this.tpszCode;
	}
	
	/**
	 * Column Info
	 * @return opb
	 */
	public String getOpb() {
		return this.opb;
	}
	
	/**
	 * Column Info
	 * @return cmCost
	 */
	public String getCmCost() {
		return this.cmCost;
	}
	
	/**
	 * Column Info
	 * @return opc
	 */
	public String getOpc() {
		return this.opc;
	}
	
	/**
	 * Column Info
	 * @return opCost
	 */
	public String getOpCost() {
		return this.opCost;
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
	 * @return cmb
	 */
	public String getCmb() {
		return this.cmb;
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
	 * @return gRpb
	 */
	public String getGRpb() {
		return this.gRpb;
	}
	
	/**
	 * Column Info
	 * @return cmc
	 */
	public String getCmc() {
		return this.cmc;
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
	 * @return cm
	 */
	public String getCm() {
		return this.cm;
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
	 * @return dirCd2
	 */
	public String getDirCd2() {
		return this.dirCd2;
	}
	
	/**
	 * Column Info
	 * @return load
	 */
	public String getLoad() {
		return this.load;
	}
	
	/**
	 * Column Info
	 * @return cmcost
	 */
	public String getCmcost() {
		return this.cmcost;
	}
	

	/**
	 * Column Info
	 * @param rev
	 */
	public void setRev(String rev) {
		this.rev = rev;
	}
	
	/**
	 * Column Info
	 * @param op
	 */
	public void setOp(String op) {
		this.op = op;
	}
	
	/**
	 * Column Info
	 * @param opcost
	 */
	public void setOpcost(String opcost) {
		this.opcost = opcost;
	}
	
	/**
	 * Column Info
	 * @param tpszCode
	 */
	public void setTpszCode(String tpszCode) {
		this.tpszCode = tpszCode;
	}
	
	/**
	 * Column Info
	 * @param opb
	 */
	public void setOpb(String opb) {
		this.opb = opb;
	}
	
	/**
	 * Column Info
	 * @param cmCost
	 */
	public void setCmCost(String cmCost) {
		this.cmCost = cmCost;
	}
	
	/**
	 * Column Info
	 * @param opc
	 */
	public void setOpc(String opc) {
		this.opc = opc;
	}
	
	/**
	 * Column Info
	 * @param opCost
	 */
	public void setOpCost(String opCost) {
		this.opCost = opCost;
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
	 * @param cmb
	 */
	public void setCmb(String cmb) {
		this.cmb = cmb;
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
	 * @param gRpb
	 */
	public void setGRpb(String gRpb) {
		this.gRpb = gRpb;
	}
	
	/**
	 * Column Info
	 * @param cmc
	 */
	public void setCmc(String cmc) {
		this.cmc = cmc;
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
	 * @param cm
	 */
	public void setCm(String cm) {
		this.cm = cm;
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
	 * @param dirCd2
	 */
	public void setDirCd2(String dirCd2) {
		this.dirCd2 = dirCd2;
	}
	
	/**
	 * Column Info
	 * @param load
	 */
	public void setLoad(String load) {
		this.load = load;
	}
	
	/**
	 * Column Info
	 * @param cmcost
	 */
	public void setCmcost(String cmcost) {
		this.cmcost = cmcost;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRev(JSPUtil.getParameter(request, "rev", ""));
		setOp(JSPUtil.getParameter(request, "op", ""));
		setOpcost(JSPUtil.getParameter(request, "opcost", ""));
		setTpszCode(JSPUtil.getParameter(request, "tpsz_code", ""));
		setOpb(JSPUtil.getParameter(request, "opb", ""));
		setCmCost(JSPUtil.getParameter(request, "cm_cost", ""));
		setOpc(JSPUtil.getParameter(request, "opc", ""));
		setOpCost(JSPUtil.getParameter(request, "op_cost", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCmb(JSPUtil.getParameter(request, "cmb", ""));
		setSlsYrmon(JSPUtil.getParameter(request, "sls_yrmon", ""));
		setGRpb(JSPUtil.getParameter(request, "g_rpb", ""));
		setCmc(JSPUtil.getParameter(request, "cmc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setCm(JSPUtil.getParameter(request, "cm", ""));
		setCostWk(JSPUtil.getParameter(request, "cost_wk", ""));
		setDirCd2(JSPUtil.getParameter(request, "dir_cd2", ""));
		setLoad(JSPUtil.getParameter(request, "load", ""));
		setCmcost(JSPUtil.getParameter(request, "cmcost", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchInqByCondition060ListVO[]
	 */
	public SearchInqByCondition060ListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchInqByCondition060ListVO[]
	 */
	public SearchInqByCondition060ListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchInqByCondition060ListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rev = (JSPUtil.getParameter(request, prefix	+ "rev", length));
			String[] op = (JSPUtil.getParameter(request, prefix	+ "op", length));
			String[] opcost = (JSPUtil.getParameter(request, prefix	+ "opcost", length));
			String[] tpszCode = (JSPUtil.getParameter(request, prefix	+ "tpsz_code", length));
			String[] opb = (JSPUtil.getParameter(request, prefix	+ "opb", length));
			String[] cmCost = (JSPUtil.getParameter(request, prefix	+ "cm_cost", length));
			String[] opc = (JSPUtil.getParameter(request, prefix	+ "opc", length));
			String[] opCost = (JSPUtil.getParameter(request, prefix	+ "op_cost", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cmb = (JSPUtil.getParameter(request, prefix	+ "cmb", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] gRpb = (JSPUtil.getParameter(request, prefix	+ "g_rpb", length));
			String[] cmc = (JSPUtil.getParameter(request, prefix	+ "cmc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] dirCd2 = (JSPUtil.getParameter(request, prefix	+ "dir_cd2", length));
			String[] load = (JSPUtil.getParameter(request, prefix	+ "load", length));
			String[] cmcost = (JSPUtil.getParameter(request, prefix	+ "cmcost", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchInqByCondition060ListVO();
				if (rev[i] != null)
					model.setRev(rev[i]);
				if (op[i] != null)
					model.setOp(op[i]);
				if (opcost[i] != null)
					model.setOpcost(opcost[i]);
				if (tpszCode[i] != null)
					model.setTpszCode(tpszCode[i]);
				if (opb[i] != null)
					model.setOpb(opb[i]);
				if (cmCost[i] != null)
					model.setCmCost(cmCost[i]);
				if (opc[i] != null)
					model.setOpc(opc[i]);
				if (opCost[i] != null)
					model.setOpCost(opCost[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cmb[i] != null)
					model.setCmb(cmb[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (gRpb[i] != null)
					model.setGRpb(gRpb[i]);
				if (cmc[i] != null)
					model.setCmc(cmc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (dirCd2[i] != null)
					model.setDirCd2(dirCd2[i]);
				if (load[i] != null)
					model.setLoad(load[i]);
				if (cmcost[i] != null)
					model.setCmcost(cmcost[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchInqByCondition060ListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchInqByCondition060ListVO[]
	 */
	public SearchInqByCondition060ListVO[] getSearchInqByCondition060ListVOs(){
		SearchInqByCondition060ListVO[] vos = (SearchInqByCondition060ListVO[])models.toArray(new SearchInqByCondition060ListVO[models.size()]);
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
		this.rev = this.rev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op = this.op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opcost = this.opcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCode = this.tpszCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opb = this.opb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCost = this.cmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opc = this.opc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCost = this.opCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb = this.cmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRpb = this.gRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmc = this.cmc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd2 = this.dirCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load = this.load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmcost = this.cmcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
