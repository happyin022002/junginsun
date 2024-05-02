/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogInternalMst_1VO.java
*@FileTitle : ProductCatalogInternalMst_1VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.10.19 노승배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo;

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
 * @author 노승배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ProductCatalogInternalMst_1VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ProductCatalogInternalMst_1VO> models = new ArrayList<ProductCatalogInternalMst_1VO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String totalCost = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ord = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Column Info */
	private String ibItchgCtnt = null;
	/* Column Info */
	private String trnkLane = null;
	/* Column Info */
	private String remarkImg = null;
	/* Column Info */
	private String pctlNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String routFlag = null;
	/* Column Info */
	private String routCnstSeq = null;
	/* Column Info */
	private String trnkAvalSpc = null;
	/* Column Info */
	private String obItchgCtnt = null;
	/* Column Info */
	private String tsRoute = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ttlTztmHrs = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String trnkVvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ProductCatalogInternalMst_1VO() {}

	public ProductCatalogInternalMst_1VO(String ibflag, String pagerows, String porCd, String obItchgCtnt, String polCd, String tsRoute, String podCd, String ibItchgCtnt, String delCd, String ttlTztmHrs, String remarkImg, String remark, String totalCost, String trnkAvalSpc, String pctlNo, String trnkVvd, String trnkLane, String mtyPkupYdCd, String porNodCd, String delNodCd, String routCnstSeq, String routFlag, String ord) {
		this.porCd = porCd;
		this.porNodCd = porNodCd;
		this.totalCost = totalCost;
		this.remark = remark;
		this.delCd = delCd;
		this.ord = ord;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.ibItchgCtnt = ibItchgCtnt;
		this.trnkLane = trnkLane;
		this.remarkImg = remarkImg;
		this.pctlNo = pctlNo;
		this.pagerows = pagerows;
		this.routFlag = routFlag;
		this.routCnstSeq = routCnstSeq;
		this.trnkAvalSpc = trnkAvalSpc;
		this.obItchgCtnt = obItchgCtnt;
		this.tsRoute = tsRoute;
		this.podCd = podCd;
		this.ttlTztmHrs = ttlTztmHrs;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.delNodCd = delNodCd;
		this.trnkVvd = trnkVvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("total_cost", getTotalCost());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ord", getOrd());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("ib_itchg_ctnt", getIbItchgCtnt());
		this.hashColumns.put("trnk_lane", getTrnkLane());
		this.hashColumns.put("remark_img", getRemarkImg());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rout_flag", getRoutFlag());
		this.hashColumns.put("rout_cnst_seq", getRoutCnstSeq());
		this.hashColumns.put("trnk_aval_spc", getTrnkAvalSpc());
		this.hashColumns.put("ob_itchg_ctnt", getObItchgCtnt());
		this.hashColumns.put("ts_route", getTsRoute());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ttl_tztm_hrs", getTtlTztmHrs());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("trnk_vvd", getTrnkVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("total_cost", "totalCost");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ord", "ord");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("ib_itchg_ctnt", "ibItchgCtnt");
		this.hashFields.put("trnk_lane", "trnkLane");
		this.hashFields.put("remark_img", "remarkImg");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rout_flag", "routFlag");
		this.hashFields.put("rout_cnst_seq", "routCnstSeq");
		this.hashFields.put("trnk_aval_spc", "trnkAvalSpc");
		this.hashFields.put("ob_itchg_ctnt", "obItchgCtnt");
		this.hashFields.put("ts_route", "tsRoute");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ttl_tztm_hrs", "ttlTztmHrs");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("trnk_vvd", "trnkVvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return totalCost
	 */
	public String getTotalCost() {
		return this.totalCost;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return ord
	 */
	public String getOrd() {
		return this.ord;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
	public String getMtyPkupYdCd() {
		return this.mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return ibItchgCtnt
	 */
	public String getIbItchgCtnt() {
		return this.ibItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @return trnkLane
	 */
	public String getTrnkLane() {
		return this.trnkLane;
	}
	
	/**
	 * Column Info
	 * @return remarkImg
	 */
	public String getRemarkImg() {
		return this.remarkImg;
	}
	
	/**
	 * Column Info
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
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
	 * @return routFlag
	 */
	public String getRoutFlag() {
		return this.routFlag;
	}
	
	/**
	 * Column Info
	 * @return routCnstSeq
	 */
	public String getRoutCnstSeq() {
		return this.routCnstSeq;
	}
	
	/**
	 * Column Info
	 * @return trnkAvalSpc
	 */
	public String getTrnkAvalSpc() {
		return this.trnkAvalSpc;
	}
	
	/**
	 * Column Info
	 * @return obItchgCtnt
	 */
	public String getObItchgCtnt() {
		return this.obItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @return tsRoute
	 */
	public String getTsRoute() {
		return this.tsRoute;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return ttlTztmHrs
	 */
	public String getTtlTztmHrs() {
		return this.ttlTztmHrs;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return trnkVvd
	 */
	public String getTrnkVvd() {
		return this.trnkVvd;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param totalCost
	 */
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param ord
	 */
	public void setOrd(String ord) {
		this.ord = ord;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
	public void setMtyPkupYdCd(String mtyPkupYdCd) {
		this.mtyPkupYdCd = mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param ibItchgCtnt
	 */
	public void setIbItchgCtnt(String ibItchgCtnt) {
		this.ibItchgCtnt = ibItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @param trnkLane
	 */
	public void setTrnkLane(String trnkLane) {
		this.trnkLane = trnkLane;
	}
	
	/**
	 * Column Info
	 * @param remarkImg
	 */
	public void setRemarkImg(String remarkImg) {
		this.remarkImg = remarkImg;
	}
	
	/**
	 * Column Info
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
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
	 * @param routFlag
	 */
	public void setRoutFlag(String routFlag) {
		this.routFlag = routFlag;
	}
	
	/**
	 * Column Info
	 * @param routCnstSeq
	 */
	public void setRoutCnstSeq(String routCnstSeq) {
		this.routCnstSeq = routCnstSeq;
	}
	
	/**
	 * Column Info
	 * @param trnkAvalSpc
	 */
	public void setTrnkAvalSpc(String trnkAvalSpc) {
		this.trnkAvalSpc = trnkAvalSpc;
	}
	
	/**
	 * Column Info
	 * @param obItchgCtnt
	 */
	public void setObItchgCtnt(String obItchgCtnt) {
		this.obItchgCtnt = obItchgCtnt;
	}
	
	/**
	 * Column Info
	 * @param tsRoute
	 */
	public void setTsRoute(String tsRoute) {
		this.tsRoute = tsRoute;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param ttlTztmHrs
	 */
	public void setTtlTztmHrs(String ttlTztmHrs) {
		this.ttlTztmHrs = ttlTztmHrs;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param trnkVvd
	 */
	public void setTrnkVvd(String trnkVvd) {
		this.trnkVvd = trnkVvd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setPorNodCd(JSPUtil.getParameter(request, "por_nod_cd", ""));
		setTotalCost(JSPUtil.getParameter(request, "total_cost", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setOrd(JSPUtil.getParameter(request, "ord", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, "mty_pkup_yd_cd", ""));
		setIbItchgCtnt(JSPUtil.getParameter(request, "ib_itchg_ctnt", ""));
		setTrnkLane(JSPUtil.getParameter(request, "trnk_lane", ""));
		setRemarkImg(JSPUtil.getParameter(request, "remark_img", ""));
		setPctlNo(JSPUtil.getParameter(request, "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRoutFlag(JSPUtil.getParameter(request, "rout_flag", ""));
		setRoutCnstSeq(JSPUtil.getParameter(request, "rout_cnst_seq", ""));
		setTrnkAvalSpc(JSPUtil.getParameter(request, "trnk_aval_spc", ""));
		setObItchgCtnt(JSPUtil.getParameter(request, "ob_itchg_ctnt", ""));
		setTsRoute(JSPUtil.getParameter(request, "ts_route", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setTtlTztmHrs(JSPUtil.getParameter(request, "ttl_tztm_hrs", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, "del_nod_cd", ""));
		setTrnkVvd(JSPUtil.getParameter(request, "trnk_vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ProductCatalogInternalMst_1VO[]
	 */
	public ProductCatalogInternalMst_1VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ProductCatalogInternalMst_1VO[]
	 */
	public ProductCatalogInternalMst_1VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ProductCatalogInternalMst_1VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] totalCost = (JSPUtil.getParameter(request, prefix	+ "total_cost", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ord = (JSPUtil.getParameter(request, prefix	+ "ord", length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd", length));
			String[] ibItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ib_itchg_ctnt", length));
			String[] trnkLane = (JSPUtil.getParameter(request, prefix	+ "trnk_lane", length));
			String[] remarkImg = (JSPUtil.getParameter(request, prefix	+ "remark_img", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] routFlag = (JSPUtil.getParameter(request, prefix	+ "rout_flag", length));
			String[] routCnstSeq = (JSPUtil.getParameter(request, prefix	+ "rout_cnst_seq", length));
			String[] trnkAvalSpc = (JSPUtil.getParameter(request, prefix	+ "trnk_aval_spc", length));
			String[] obItchgCtnt = (JSPUtil.getParameter(request, prefix	+ "ob_itchg_ctnt", length));
			String[] tsRoute = (JSPUtil.getParameter(request, prefix	+ "ts_route", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ttlTztmHrs = (JSPUtil.getParameter(request, prefix	+ "ttl_tztm_hrs", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] trnkVvd = (JSPUtil.getParameter(request, prefix	+ "trnk_vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ProductCatalogInternalMst_1VO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (totalCost[i] != null)
					model.setTotalCost(totalCost[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ord[i] != null)
					model.setOrd(ord[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (ibItchgCtnt[i] != null)
					model.setIbItchgCtnt(ibItchgCtnt[i]);
				if (trnkLane[i] != null)
					model.setTrnkLane(trnkLane[i]);
				if (remarkImg[i] != null)
					model.setRemarkImg(remarkImg[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (routFlag[i] != null)
					model.setRoutFlag(routFlag[i]);
				if (routCnstSeq[i] != null)
					model.setRoutCnstSeq(routCnstSeq[i]);
				if (trnkAvalSpc[i] != null)
					model.setTrnkAvalSpc(trnkAvalSpc[i]);
				if (obItchgCtnt[i] != null)
					model.setObItchgCtnt(obItchgCtnt[i]);
				if (tsRoute[i] != null)
					model.setTsRoute(tsRoute[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ttlTztmHrs[i] != null)
					model.setTtlTztmHrs(ttlTztmHrs[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (trnkVvd[i] != null)
					model.setTrnkVvd(trnkVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getProductCatalogInternalMst_1VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ProductCatalogInternalMst_1VO[]
	 */
	public ProductCatalogInternalMst_1VO[] getProductCatalogInternalMst_1VOs(){
		ProductCatalogInternalMst_1VO[] vos = (ProductCatalogInternalMst_1VO[])models.toArray(new ProductCatalogInternalMst_1VO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCost = this.totalCost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ord = this.ord .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibItchgCtnt = this.ibItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkLane = this.trnkLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remarkImg = this.remarkImg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routFlag = this.routFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCnstSeq = this.routCnstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkAvalSpc = this.trnkAvalSpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obItchgCtnt = this.obItchgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsRoute = this.tsRoute .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTztmHrs = this.ttlTztmHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvd = this.trnkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
