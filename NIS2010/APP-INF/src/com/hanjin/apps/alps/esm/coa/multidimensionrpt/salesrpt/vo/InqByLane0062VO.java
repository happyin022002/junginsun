/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InqByLane0062VO.java
*@FileTitle : InqByLane0062VO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.02
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.01.02 최성민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo;

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

public class InqByLane0062VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InqByLane0062VO> models = new ArrayList<InqByLane0062VO>();
	
	/* Column Info */
	private String rev = null;
	/* Column Info */
	private String cm2 = null;
	/* Column Info */
	private String opcost = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String opb = null;
	/* Column Info */
	private String opc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String opCost = null;
	/* Column Info */
	private String gRpb = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String op = null;
	/* Column Info */
	private String cmCost = null;
	/* Column Info */
	private String slsYrmon = null;
	/* Column Info */
	private String cmb = null;
	/* Column Info */
	private String cmc = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String spclCntrTpszCd = null;
	/* Column Info */
	private String load = null;
	/* Column Info */
	private String ownFdrAmt = null;
	/* Column Info */
	private String cmcost = null;
	/* Column Info */
	private String trdDirCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InqByLane0062VO() {}

	public InqByLane0062VO(String ibflag, String pagerows, String trdCd, String costYrmon, String slsYrmon, String costWk, String rlaneCd, String dirCd, String bkgNo, String spclCntrTpszCd, String load, String rev, String cmc, String cm, String ownFdrAmt, String cm2, String opc, String op, String gRpb, String cmCost, String cmcost, String cmb, String opCost, String opcost, String opb, String trdDirCd) {
		this.rev = rev;
		this.cm2 = cm2;
		this.opcost = opcost;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.opb = opb;
		this.opc = opc;
		this.pagerows = pagerows;
		this.opCost = opCost;
		this.gRpb = gRpb;
		this.ibflag = ibflag;
		this.costYrmon = costYrmon;
		this.dirCd = dirCd;
		this.op = op;
		this.cmCost = cmCost;
		this.slsYrmon = slsYrmon;
		this.cmb = cmb;
		this.cmc = cmc;
		this.bkgNo = bkgNo;
		this.cm = cm;
		this.costWk = costWk;
		this.spclCntrTpszCd = spclCntrTpszCd;
		this.load = load;
		this.ownFdrAmt = ownFdrAmt;
		this.cmcost = cmcost;
		this.trdDirCd = trdDirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rev", getRev());
		this.hashColumns.put("cm2", getCm2());
		this.hashColumns.put("opcost", getOpcost());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("opb", getOpb());
		this.hashColumns.put("opc", getOpc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("op_cost", getOpCost());
		this.hashColumns.put("g_rpb", getGRpb());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("op", getOp());
		this.hashColumns.put("cm_cost", getCmCost());
		this.hashColumns.put("sls_yrmon", getSlsYrmon());
		this.hashColumns.put("cmb", getCmb());
		this.hashColumns.put("cmc", getCmc());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("spcl_cntr_tpsz_cd", getSpclCntrTpszCd());
		this.hashColumns.put("load", getLoad());
		this.hashColumns.put("own_fdr_amt", getOwnFdrAmt());
		this.hashColumns.put("cmcost", getCmcost());
		this.hashColumns.put("trd_dir_cd", getTrdDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rev", "rev");
		this.hashFields.put("cm2", "cm2");
		this.hashFields.put("opcost", "opcost");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("opb", "opb");
		this.hashFields.put("opc", "opc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("op_cost", "opCost");
		this.hashFields.put("g_rpb", "gRpb");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("op", "op");
		this.hashFields.put("cm_cost", "cmCost");
		this.hashFields.put("sls_yrmon", "slsYrmon");
		this.hashFields.put("cmb", "cmb");
		this.hashFields.put("cmc", "cmc");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("spcl_cntr_tpsz_cd", "spclCntrTpszCd");
		this.hashFields.put("load", "load");
		this.hashFields.put("own_fdr_amt", "ownFdrAmt");
		this.hashFields.put("cmcost", "cmcost");
		this.hashFields.put("trd_dir_cd", "trdDirCd");
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
	 * @return cm2
	 */
	public String getCm2() {
		return this.cm2;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return opb
	 */
	public String getOpb() {
		return this.opb;
	}
	
	/**
	 * Column Info
	 * @return opc
	 */
	public String getOpc() {
		return this.opc;
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
	 * @return opCost
	 */
	public String getOpCost() {
		return this.opCost;
	}
	
	/**
	 * Column Info
	 * @return gRpb
	 */
	public String getGRpb() {
		return this.gRpb;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
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
	 * @return cmCost
	 */
	public String getCmCost() {
		return this.cmCost;
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
	 * @return cmb
	 */
	public String getCmb() {
		return this.cmb;
	}
	
	/**
	 * Column Info
	 * @return cmc
	 */
	public String getCmc() {
		return this.cmc;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return spclCntrTpszCd
	 */
	public String getSpclCntrTpszCd() {
		return this.spclCntrTpszCd;
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
	 * @return ownFdrAmt
	 */
	public String getOwnFdrAmt() {
		return this.ownFdrAmt;
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
	 * @return ownFdrAmt
	 */
	public String getTrdDirCd() {
		return this.trdDirCd;
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
	 * @param cm2
	 */
	public void setCm2(String cm2) {
		this.cm2 = cm2;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param opb
	 */
	public void setOpb(String opb) {
		this.opb = opb;
	}
	
	/**
	 * Column Info
	 * @param opc
	 */
	public void setOpc(String opc) {
		this.opc = opc;
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
	 * @param opCost
	 */
	public void setOpCost(String opCost) {
		this.opCost = opCost;
	}
	
	/**
	 * Column Info
	 * @param gRpb
	 */
	public void setGRpb(String gRpb) {
		this.gRpb = gRpb;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
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
	 * @param cmCost
	 */
	public void setCmCost(String cmCost) {
		this.cmCost = cmCost;
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
	 * @param cmb
	 */
	public void setCmb(String cmb) {
		this.cmb = cmb;
	}
	
	/**
	 * Column Info
	 * @param cmc
	 */
	public void setCmc(String cmc) {
		this.cmc = cmc;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param spclCntrTpszCd
	 */
	public void setSpclCntrTpszCd(String spclCntrTpszCd) {
		this.spclCntrTpszCd = spclCntrTpszCd;
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
	 * @param ownFdrAmt
	 */
	public void setOwnFdrAmt(String ownFdrAmt) {
		this.ownFdrAmt = ownFdrAmt;
	}
	
	/**
	 * Column Info
	 * @param cmcost
	 */
	public void setCmcost(String cmcost) {
		this.cmcost = cmcost;
	}
	
	/**
	 * Column Info
	 * @param trdDirCd
	 */
	public void setTrdDirCd(String trdDirCd) {
		this.trdDirCd = trdDirCd;
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
		setRev(JSPUtil.getParameter(request, prefix + "rev", ""));
		setCm2(JSPUtil.getParameter(request, prefix + "cm2", ""));
		setOpcost(JSPUtil.getParameter(request, prefix + "opcost", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setOpb(JSPUtil.getParameter(request, prefix + "opb", ""));
		setOpc(JSPUtil.getParameter(request, prefix + "opc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOpCost(JSPUtil.getParameter(request, prefix + "op_cost", ""));
		setGRpb(JSPUtil.getParameter(request, prefix + "g_rpb", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setOp(JSPUtil.getParameter(request, prefix + "op", ""));
		setCmCost(JSPUtil.getParameter(request, prefix + "cm_cost", ""));
		setSlsYrmon(JSPUtil.getParameter(request, prefix + "sls_yrmon", ""));
		setCmb(JSPUtil.getParameter(request, prefix + "cmb", ""));
		setCmc(JSPUtil.getParameter(request, prefix + "cmc", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCm(JSPUtil.getParameter(request, prefix + "cm", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setSpclCntrTpszCd(JSPUtil.getParameter(request, prefix + "spcl_cntr_tpsz_cd", ""));
		setLoad(JSPUtil.getParameter(request, prefix + "load", ""));
		setOwnFdrAmt(JSPUtil.getParameter(request, prefix + "own_fdr_amt", ""));
		setCmcost(JSPUtil.getParameter(request, prefix + "cmcost", ""));
		setTrdDirCd(JSPUtil.getParameter(request, prefix + "trd_dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InqByLane0062VO[]
	 */
	public InqByLane0062VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InqByLane0062VO[]
	 */
	public InqByLane0062VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InqByLane0062VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rev = (JSPUtil.getParameter(request, prefix	+ "rev", length));
			String[] cm2 = (JSPUtil.getParameter(request, prefix	+ "cm2", length));
			String[] opcost = (JSPUtil.getParameter(request, prefix	+ "opcost", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] opb = (JSPUtil.getParameter(request, prefix	+ "opb", length));
			String[] opc = (JSPUtil.getParameter(request, prefix	+ "opc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] opCost = (JSPUtil.getParameter(request, prefix	+ "op_cost", length));
			String[] gRpb = (JSPUtil.getParameter(request, prefix	+ "g_rpb", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] op = (JSPUtil.getParameter(request, prefix	+ "op", length));
			String[] cmCost = (JSPUtil.getParameter(request, prefix	+ "cm_cost", length));
			String[] slsYrmon = (JSPUtil.getParameter(request, prefix	+ "sls_yrmon", length));
			String[] cmb = (JSPUtil.getParameter(request, prefix	+ "cmb", length));
			String[] cmc = (JSPUtil.getParameter(request, prefix	+ "cmc", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] spclCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cntr_tpsz_cd", length));
			String[] load = (JSPUtil.getParameter(request, prefix	+ "load", length));
			String[] ownFdrAmt = (JSPUtil.getParameter(request, prefix	+ "own_fdr_amt", length));
			String[] cmcost = (JSPUtil.getParameter(request, prefix	+ "cmcost", length));
			String[] trdDirCd = (JSPUtil.getParameter(request, prefix	+ "trd_dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InqByLane0062VO();
				if (rev[i] != null)
					model.setRev(rev[i]);
				if (cm2[i] != null)
					model.setCm2(cm2[i]);
				if (opcost[i] != null)
					model.setOpcost(opcost[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (opb[i] != null)
					model.setOpb(opb[i]);
				if (opc[i] != null)
					model.setOpc(opc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (opCost[i] != null)
					model.setOpCost(opCost[i]);
				if (gRpb[i] != null)
					model.setGRpb(gRpb[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (op[i] != null)
					model.setOp(op[i]);
				if (cmCost[i] != null)
					model.setCmCost(cmCost[i]);
				if (slsYrmon[i] != null)
					model.setSlsYrmon(slsYrmon[i]);
				if (cmb[i] != null)
					model.setCmb(cmb[i]);
				if (cmc[i] != null)
					model.setCmc(cmc[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (spclCntrTpszCd[i] != null)
					model.setSpclCntrTpszCd(spclCntrTpszCd[i]);
				if (load[i] != null)
					model.setLoad(load[i]);
				if (ownFdrAmt[i] != null)
					model.setOwnFdrAmt(ownFdrAmt[i]);
				if (cmcost[i] != null)
					model.setCmcost(cmcost[i]);
				if (trdDirCd[i] != null)
					model.setTrdDirCd(trdDirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInqByLane0062VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InqByLane0062VO[]
	 */
	public InqByLane0062VO[] getInqByLane0062VOs(){
		InqByLane0062VO[] vos = (InqByLane0062VO[])models.toArray(new InqByLane0062VO[models.size()]);
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
		this.cm2 = this.cm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opcost = this.opcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opb = this.opb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opc = this.opc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCost = this.opCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRpb = this.gRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op = this.op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCost = this.cmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsYrmon = this.slsYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb = this.cmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmc = this.cmc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCntrTpszCd = this.spclCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load = this.load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownFdrAmt = this.ownFdrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmcost = this.cmcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdDirCd = this.trdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
