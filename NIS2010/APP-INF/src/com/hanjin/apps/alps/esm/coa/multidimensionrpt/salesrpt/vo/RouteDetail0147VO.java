/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RouteDetail0147VO.java
*@FileTitle : RouteDetail0147VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.14 송호진 
* 1.0 Creation
* 
* 2012.02.06 이석준 [CHM-201215969-01] CM2 적용
=========================================================*/

package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RouteDetail0147VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RouteDetail0147VO> models = new ArrayList<RouteDetail0147VO>();
	
	/* Column Info */
	private String bkgPorCd = null; 
	/* Column Info */
	private String rev = null;
	/* Column Info */
	private String op = null;
	/* Column Info */
	private String opcost = null;
	/* Column Info */
	private String org = null;
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
	private String gRpb = null;
	/* Column Info */
	private String cmc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dest = null;
	/* Column Info */
	private String cm = null;
	/* Column Info */
	private String bkgDelCd = null;
	/* Column Info */
	private String revPodCd = null;
	/* Column Info */
	private String spclCntrTpszCd = null;
	/* Column Info */
	private String revPolCd = null;
	/* Column Info */
	private String load = null;
	/* Column Info */
	private String cmcost = null;
	/* Column Info */
	private String cm2 = null;
	/* Column Info */
	private String cm2Cost = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RouteDetail0147VO() {}

	public RouteDetail0147VO(String ibflag, String pagerows, String org, String dest, String bkgPorCd, String revPolCd, String revPodCd, String bkgDelCd, String spclCntrTpszCd, String load, String rev, String cmc, String cm, String opc, String op, String gRpb, String cmCost, String cmcost, String cmb, String opCost, String opcost, String opb,String cm2,String cm2Cost) {
		this.bkgPorCd = bkgPorCd;
		this.rev = rev;
		this.op = op;
		this.opcost = opcost;
		this.org = org;
		this.opb = opb;
		this.cmCost = cmCost;
		this.opc = opc;
		this.opCost = opCost;
		this.pagerows = pagerows;
		this.cmb = cmb;
		this.gRpb = gRpb;
		this.cmc = cmc;
		this.ibflag = ibflag;
		this.dest = dest;
		this.cm = cm;
		this.bkgDelCd = bkgDelCd;
		this.revPodCd = revPodCd;
		this.spclCntrTpszCd = spclCntrTpszCd;
		this.revPolCd = revPolCd;
		this.load = load;
		this.cmcost = cmcost;
		this.cm2 = cm2;
		this.cm2Cost = cm2Cost;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_por_cd", getBkgPorCd());
		this.hashColumns.put("rev", getRev());
		this.hashColumns.put("op", getOp());
		this.hashColumns.put("opcost", getOpcost());
		this.hashColumns.put("org", getOrg());
		this.hashColumns.put("opb", getOpb());
		this.hashColumns.put("cm_cost", getCmCost());
		this.hashColumns.put("opc", getOpc());
		this.hashColumns.put("op_cost", getOpCost());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cmb", getCmb());
		this.hashColumns.put("g_rpb", getGRpb());
		this.hashColumns.put("cmc", getCmc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dest", getDest());
		this.hashColumns.put("cm", getCm());
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());
		this.hashColumns.put("rev_pod_cd", getRevPodCd());
		this.hashColumns.put("spcl_cntr_tpsz_cd", getSpclCntrTpszCd());
		this.hashColumns.put("rev_pol_cd", getRevPolCd());
		this.hashColumns.put("load", getLoad());
		this.hashColumns.put("cmcost", getCmcost());
		this.hashColumns.put("cm2", getCm2());
		this.hashColumns.put("cm2_cost", getCm2Cost());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_por_cd", "bkgPorCd");
		this.hashFields.put("rev", "rev");
		this.hashFields.put("op", "op");
		this.hashFields.put("opcost", "opcost");
		this.hashFields.put("org", "org");
		this.hashFields.put("opb", "opb");
		this.hashFields.put("cm_cost", "cmCost");
		this.hashFields.put("opc", "opc");
		this.hashFields.put("op_cost", "opCost");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cmb", "cmb");
		this.hashFields.put("g_rpb", "gRpb");
		this.hashFields.put("cmc", "cmc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dest", "dest");
		this.hashFields.put("cm", "cm");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		this.hashFields.put("rev_pod_cd", "revPodCd");
		this.hashFields.put("spcl_cntr_tpsz_cd", "spclCntrTpszCd");
		this.hashFields.put("rev_pol_cd", "revPolCd");
		this.hashFields.put("load", "load");
		this.hashFields.put("cmcost", "cmcost");
		this.hashFields.put("cm2", "cm2");
		this.hashFields.put("cm2_cost", "cm2Cost");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgPorCd
	 */
	public String getBkgPorCd() {
		return this.bkgPorCd;
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
	 * @return org
	 */
	public String getOrg() {
		return this.org;
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
	 * @return dest
	 */
	public String getDest() {
		return this.dest;
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
	 * @return bkgDelCd
	 */
	public String getBkgDelCd() {
		return this.bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @return revPodCd
	 */
	public String getRevPodCd() {
		return this.revPodCd;
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
	 * @return revPolCd
	 */
	public String getRevPolCd() {
		return this.revPolCd;
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
	 * @return cm2
	 */
	public String getCm2() {
		return this.cm2;
	}	
	

	/**
	 * Column Info
	 * @return cm2Cost
	 */
	public String getCm2Cost() {
		return this.cm2Cost;
	}
	
	/**
	 * Column Info
	 * @param bkgPorCd
	 */
	public void setBkgPorCd(String bkgPorCd) {
		this.bkgPorCd = bkgPorCd;
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
	 * @param org
	 */
	public void setOrg(String org) {
		this.org = org;
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
	 * @param dest
	 */
	public void setDest(String dest) {
		this.dest = dest;
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
	 * @param bkgDelCd
	 */
	public void setBkgDelCd(String bkgDelCd) {
		this.bkgDelCd = bkgDelCd;
	}
	
	/**
	 * Column Info
	 * @param revPodCd
	 */
	public void setRevPodCd(String revPodCd) {
		this.revPodCd = revPodCd;
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
	 * @param revPolCd
	 */
	public void setRevPolCd(String revPolCd) {
		this.revPolCd = revPolCd;
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
	 * Column Info
	 * @param cm2
	 */
	public void setCm2(String cm2) {
		this.cm2 = cm2;
	}
	
	/**
	 * Column Info
	 * @param cm2Cost
	 */
	public void setCm2Cost(String cm2Cost) {
		this.cm2Cost = cm2Cost;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgPorCd(JSPUtil.getParameter(request, "bkg_por_cd", ""));
		setRev(JSPUtil.getParameter(request, "rev", ""));
		setOp(JSPUtil.getParameter(request, "op", ""));
		setOpcost(JSPUtil.getParameter(request, "opcost", ""));
		setOrg(JSPUtil.getParameter(request, "org", ""));
		setOpb(JSPUtil.getParameter(request, "opb", ""));
		setCmCost(JSPUtil.getParameter(request, "cm_cost", ""));
		setOpc(JSPUtil.getParameter(request, "opc", ""));
		setOpCost(JSPUtil.getParameter(request, "op_cost", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCmb(JSPUtil.getParameter(request, "cmb", ""));
		setGRpb(JSPUtil.getParameter(request, "g_rpb", ""));
		setCmc(JSPUtil.getParameter(request, "cmc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDest(JSPUtil.getParameter(request, "dest", ""));
		setCm(JSPUtil.getParameter(request, "cm", ""));
		setBkgDelCd(JSPUtil.getParameter(request, "bkg_del_cd", ""));
		setRevPodCd(JSPUtil.getParameter(request, "rev_pod_cd", ""));
		setSpclCntrTpszCd(JSPUtil.getParameter(request, "spcl_cntr_tpsz_cd", ""));
		setRevPolCd(JSPUtil.getParameter(request, "rev_pol_cd", ""));
		setLoad(JSPUtil.getParameter(request, "load", ""));
		setCmcost(JSPUtil.getParameter(request, "cmcost", ""));
		setCm2(JSPUtil.getParameter(request, "cm2", ""));
		setCm2Cost(JSPUtil.getParameter(request, "cm2Cost", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RouteDetail0147VO[]
	 */
	public RouteDetail0147VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RouteDetail0147VO[]
	 */
	public RouteDetail0147VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RouteDetail0147VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgPorCd = (JSPUtil.getParameter(request, prefix	+ "bkg_por_cd", length));
			String[] rev = (JSPUtil.getParameter(request, prefix	+ "rev", length));
			String[] op = (JSPUtil.getParameter(request, prefix	+ "op", length));
			String[] opcost = (JSPUtil.getParameter(request, prefix	+ "opcost", length));
			String[] org = (JSPUtil.getParameter(request, prefix	+ "org", length));
			String[] opb = (JSPUtil.getParameter(request, prefix	+ "opb", length));
			String[] cmCost = (JSPUtil.getParameter(request, prefix	+ "cm_cost", length));
			String[] opc = (JSPUtil.getParameter(request, prefix	+ "opc", length));
			String[] opCost = (JSPUtil.getParameter(request, prefix	+ "op_cost", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cmb = (JSPUtil.getParameter(request, prefix	+ "cmb", length));
			String[] gRpb = (JSPUtil.getParameter(request, prefix	+ "g_rpb", length));
			String[] cmc = (JSPUtil.getParameter(request, prefix	+ "cmc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dest = (JSPUtil.getParameter(request, prefix	+ "dest", length));
			String[] cm = (JSPUtil.getParameter(request, prefix	+ "cm", length));
			String[] bkgDelCd = (JSPUtil.getParameter(request, prefix	+ "bkg_del_cd", length));
			String[] revPodCd = (JSPUtil.getParameter(request, prefix	+ "rev_pod_cd", length));
			String[] spclCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cntr_tpsz_cd", length));
			String[] revPolCd = (JSPUtil.getParameter(request, prefix	+ "rev_pol_cd", length));
			String[] load = (JSPUtil.getParameter(request, prefix	+ "load", length));
			String[] cmcost = (JSPUtil.getParameter(request, prefix	+ "cmcost", length));
			
			String[] cm2 = (JSPUtil.getParameter(request, prefix	+ "cm2", length));			
			String[] cm2Cost = (JSPUtil.getParameter(request, prefix	+ "cm2Cost", length));
			
			for (int i = 0; i < length; i++) {
				model = new RouteDetail0147VO();
				if (bkgPorCd[i] != null)
					model.setBkgPorCd(bkgPorCd[i]);
				if (rev[i] != null)
					model.setRev(rev[i]);
				if (op[i] != null)
					model.setOp(op[i]);
				if (opcost[i] != null)
					model.setOpcost(opcost[i]);
				if (org[i] != null)
					model.setOrg(org[i]);
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
				if (gRpb[i] != null)
					model.setGRpb(gRpb[i]);
				if (cmc[i] != null)
					model.setCmc(cmc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dest[i] != null)
					model.setDest(dest[i]);
				if (cm[i] != null)
					model.setCm(cm[i]);
				if (bkgDelCd[i] != null)
					model.setBkgDelCd(bkgDelCd[i]);
				if (revPodCd[i] != null)
					model.setRevPodCd(revPodCd[i]);
				if (spclCntrTpszCd[i] != null)
					model.setSpclCntrTpszCd(spclCntrTpszCd[i]);
				if (revPolCd[i] != null)
					model.setRevPolCd(revPolCd[i]);
				if (load[i] != null)
					model.setLoad(load[i]);
				if (cmcost[i] != null)
					model.setCmcost(cmcost[i]);
				if (cm2[i] != null)
					model.setCm2(cm2[i]);
				if (cm2Cost[i] != null)
					model.setCm2Cost(cm2Cost[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRouteDetail0147VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RouteDetail0147VO[]
	 */
	public RouteDetail0147VO[] getRouteDetail0147VOs(){
		RouteDetail0147VO[] vos = (RouteDetail0147VO[])models.toArray(new RouteDetail0147VO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bkgPorCd = this.bkgPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rev = this.rev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.op = this.op .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opcost = this.opcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.org = this.org .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opb = this.opb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmCost = this.cmCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opc = this.opc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCost = this.opCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmb = this.cmb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gRpb = this.gRpb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmc = this.cmc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dest = this.dest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm = this.cm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd = this.bkgDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPodCd = this.revPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCntrTpszCd = this.spclCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revPolCd = this.revPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.load = this.load .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmcost = this.cmcost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.cm2 = this.cm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cm2Cost = this.cm2Cost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
