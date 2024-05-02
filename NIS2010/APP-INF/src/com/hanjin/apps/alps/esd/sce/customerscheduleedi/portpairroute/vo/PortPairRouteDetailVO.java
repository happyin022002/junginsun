/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PortPairRouteDetailVO.java
*@FileTitle : PortPairRouteDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2010.03.09 신한성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo;

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
 * @author 신한성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortPairRouteDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortPairRouteDetailVO> models = new ArrayList<PortPairRouteDetailVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String routRcvDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String n1stPolCd = null;
	/* Column Info */
	private String mnlUseFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n2ndPodCd = null;
	/* Column Info */
	private String n4thPodCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n3rdPolCd = null;
	/* Column Info */
	private String custTrdPrnrId = null;
	/* Column Info */
	private String oceanFlag = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String n1stPodCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String useFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String n4thPolCd = null;
	/* Column Info */
	private String n3rdPodCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String n2ndPolCd = null;
	/* Column Info */
	private String blockLanes = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortPairRouteDetailVO() {}

	public PortPairRouteDetailVO(String ibflag, String pagerows, String routRcvDt, String routSeq, String custTrdPrnrId, String porCd, String polCd, String n1stPolCd, String n1stPodCd, String n2ndPolCd, String n2ndPodCd, String n3rdPolCd, String n3rdPodCd, String n4thPolCd, String n4thPodCd, String podCd, String delCd, String oceanFlag, String useFlg, String mnlUseFlg, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String blockLanes) {
		this.porCd = porCd;
		this.routRcvDt = routRcvDt;
		this.deltFlg = deltFlg;
		this.n1stPolCd = n1stPolCd;
		this.mnlUseFlg = mnlUseFlg;
		this.creDt = creDt;
		this.n2ndPodCd = n2ndPodCd;
		this.n4thPodCd = n4thPodCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.n3rdPolCd = n3rdPolCd;
		this.custTrdPrnrId = custTrdPrnrId;
		this.oceanFlag = oceanFlag;
		this.updUsrId = updUsrId;
		this.n1stPodCd = n1stPodCd;
		this.updDt = updDt;
		this.useFlg = useFlg;
		this.delCd = delCd;
		this.n4thPolCd = n4thPolCd;
		this.n3rdPodCd = n3rdPodCd;
		this.routSeq = routSeq;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.n2ndPolCd = n2ndPolCd;
		this.blockLanes = blockLanes;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("rout_rcv_dt", getRoutRcvDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("n1st_pol_cd", getN1stPolCd());
		this.hashColumns.put("mnl_use_flg", getMnlUseFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n2nd_pod_cd", getN2ndPodCd());
		this.hashColumns.put("n4th_pod_cd", getN4thPodCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n3rd_pol_cd", getN3rdPolCd());
		this.hashColumns.put("cust_trd_prnr_id", getCustTrdPrnrId());
		this.hashColumns.put("ocean_flag", getOceanFlag());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("n1st_pod_cd", getN1stPodCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("use_flg", getUseFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("n4th_pol_cd", getN4thPolCd());
		this.hashColumns.put("n3rd_pod_cd", getN3rdPodCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("n2nd_pol_cd", getN2ndPolCd());
		this.hashColumns.put("block_lanes", getBlockLanes());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("rout_rcv_dt", "routRcvDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("n1st_pol_cd", "n1stPolCd");
		this.hashFields.put("mnl_use_flg", "mnlUseFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n2nd_pod_cd", "n2ndPodCd");
		this.hashFields.put("n4th_pod_cd", "n4thPodCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n3rd_pol_cd", "n3rdPolCd");
		this.hashFields.put("cust_trd_prnr_id", "custTrdPrnrId");
		this.hashFields.put("ocean_flag", "oceanFlag");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("n1st_pod_cd", "n1stPodCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("use_flg", "useFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("n4th_pol_cd", "n4thPolCd");
		this.hashFields.put("n3rd_pod_cd", "n3rdPodCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("n2nd_pol_cd", "n2ndPolCd");
		this.hashFields.put("block_lanes", "blockLanes");
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
	 * @return routRcvDt
	 */
	public String getRoutRcvDt() {
		return this.routRcvDt;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return n1stPolCd
	 */
	public String getN1stPolCd() {
		return this.n1stPolCd;
	}
	
	/**
	 * Column Info
	 * @return mnlUseFlg
	 */
	public String getMnlUseFlg() {
		return this.mnlUseFlg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return n2ndPodCd
	 */
	public String getN2ndPodCd() {
		return this.n2ndPodCd;
	}
	
	/**
	 * Column Info
	 * @return n4thPodCd
	 */
	public String getN4thPodCd() {
		return this.n4thPodCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return n3rdPolCd
	 */
	public String getN3rdPolCd() {
		return this.n3rdPolCd;
	}
	
	/**
	 * Column Info
	 * @return custTrdPrnrId
	 */
	public String getCustTrdPrnrId() {
		return this.custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return oceanFlag
	 */
	public String getOceanFlag() {
		return this.oceanFlag;
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
	 * @return n1stPodCd
	 */
	public String getN1stPodCd() {
		return this.n1stPodCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return useFlg
	 */
	public String getUseFlg() {
		return this.useFlg;
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
	 * @return n4thPolCd
	 */
	public String getN4thPolCd() {
		return this.n4thPolCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPodCd
	 */
	public String getN3rdPodCd() {
		return this.n3rdPodCd;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return n2ndPolCd
	 */
	public String getN2ndPolCd() {
		return this.n2ndPolCd;
	}
	

	public String getBlockLanes() {
		return blockLanes;
	}

	public void setBlockLanes(String blockLanes) {
		this.blockLanes = blockLanes;
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
	 * @param routRcvDt
	 */
	public void setRoutRcvDt(String routRcvDt) {
		this.routRcvDt = routRcvDt;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param n1stPolCd
	 */
	public void setN1stPolCd(String n1stPolCd) {
		this.n1stPolCd = n1stPolCd;
	}
	
	/**
	 * Column Info
	 * @param mnlUseFlg
	 */
	public void setMnlUseFlg(String mnlUseFlg) {
		this.mnlUseFlg = mnlUseFlg;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param n2ndPodCd
	 */
	public void setN2ndPodCd(String n2ndPodCd) {
		this.n2ndPodCd = n2ndPodCd;
	}
	
	/**
	 * Column Info
	 * @param n4thPodCd
	 */
	public void setN4thPodCd(String n4thPodCd) {
		this.n4thPodCd = n4thPodCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param n3rdPolCd
	 */
	public void setN3rdPolCd(String n3rdPolCd) {
		this.n3rdPolCd = n3rdPolCd;
	}
	
	/**
	 * Column Info
	 * @param custTrdPrnrId
	 */
	public void setCustTrdPrnrId(String custTrdPrnrId) {
		this.custTrdPrnrId = custTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param oceanFlag
	 */
	public void setOceanFlag(String oceanFlag) {
		this.oceanFlag = oceanFlag;
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
	 * @param n1stPodCd
	 */
	public void setN1stPodCd(String n1stPodCd) {
		this.n1stPodCd = n1stPodCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param useFlg
	 */
	public void setUseFlg(String useFlg) {
		this.useFlg = useFlg;
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
	 * @param n4thPolCd
	 */
	public void setN4thPolCd(String n4thPolCd) {
		this.n4thPolCd = n4thPolCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPodCd
	 */
	public void setN3rdPodCd(String n3rdPodCd) {
		this.n3rdPodCd = n3rdPodCd;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param n2ndPolCd
	 */
	public void setN2ndPolCd(String n2ndPolCd) {
		this.n2ndPolCd = n2ndPolCd;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setRoutRcvDt(JSPUtil.getParameter(request, prefix + "rout_rcv_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setN1stPolCd(JSPUtil.getParameter(request, prefix + "n1st_pol_cd", ""));
		setMnlUseFlg(JSPUtil.getParameter(request, prefix + "mnl_use_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setN2ndPodCd(JSPUtil.getParameter(request, prefix + "n2nd_pod_cd", ""));
		setN4thPodCd(JSPUtil.getParameter(request, prefix + "n4th_pod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setN3rdPolCd(JSPUtil.getParameter(request, prefix + "n3rd_pol_cd", ""));
		setCustTrdPrnrId(JSPUtil.getParameter(request, prefix + "cust_trd_prnr_id", ""));
		setOceanFlag(JSPUtil.getParameter(request, prefix + "ocean_flag", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setN1stPodCd(JSPUtil.getParameter(request, prefix + "n1st_pod_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setUseFlg(JSPUtil.getParameter(request, prefix + "use_flg", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setN4thPolCd(JSPUtil.getParameter(request, prefix + "n4th_pol_cd", ""));
		setN3rdPodCd(JSPUtil.getParameter(request, prefix + "n3rd_pod_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setN2ndPolCd(JSPUtil.getParameter(request, prefix + "n2nd_pol_cd", ""));
		setBlockLanes(JSPUtil.getParameter(request, prefix + "block_lanes", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortPairRouteDetailVO[]
	 */
	public PortPairRouteDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortPairRouteDetailVO[]
	 */
	public PortPairRouteDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortPairRouteDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
		
//		System.out.println("tmp.length ==> "+tmp.length);
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] routRcvDt = (JSPUtil.getParameter(request, prefix	+ "rout_rcv_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] n1stPolCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pol_cd", length));
			String[] mnlUseFlg = (JSPUtil.getParameter(request, prefix	+ "mnl_use_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] n2ndPodCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pod_cd", length));
			String[] n4thPodCd = (JSPUtil.getParameter(request, prefix	+ "n4th_pod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n3rdPolCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pol_cd", length));
			String[] custTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "cust_trd_prnr_id", length));
			String[] oceanFlag = (JSPUtil.getParameter(request, prefix	+ "ocean_flag", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] n1stPodCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pod_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] useFlg = (JSPUtil.getParameter(request, prefix	+ "use_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] n4thPolCd = (JSPUtil.getParameter(request, prefix	+ "n4th_pol_cd", length));
			String[] n3rdPodCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_pod_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] n2ndPolCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pol_cd", length));
			String[] blockLanes = (JSPUtil.getParameter(request, prefix	+ "block_lanes", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortPairRouteDetailVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (routRcvDt[i] != null)
					model.setRoutRcvDt(routRcvDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (n1stPolCd[i] != null)
					model.setN1stPolCd(n1stPolCd[i]);
				if (mnlUseFlg[i] != null)
					model.setMnlUseFlg(mnlUseFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n2ndPodCd[i] != null)
					model.setN2ndPodCd(n2ndPodCd[i]);
				if (n4thPodCd[i] != null)
					model.setN4thPodCd(n4thPodCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n3rdPolCd[i] != null)
					model.setN3rdPolCd(n3rdPolCd[i]);
				if (custTrdPrnrId[i] != null)
					model.setCustTrdPrnrId(custTrdPrnrId[i]);
				if (oceanFlag[i] != null)
					model.setOceanFlag(oceanFlag[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (n1stPodCd[i] != null)
					model.setN1stPodCd(n1stPodCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (useFlg[i] != null)
					model.setUseFlg(useFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (n4thPolCd[i] != null)
					model.setN4thPolCd(n4thPolCd[i]);
				if (n3rdPodCd[i] != null)
					model.setN3rdPodCd(n3rdPodCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (n2ndPolCd[i] != null)
					model.setN2ndPolCd(n2ndPolCd[i]);
				if (blockLanes[i] != null)
					model.setBlockLanes(blockLanes[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortPairRouteDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortPairRouteDetailVO[]
	 */
	public PortPairRouteDetailVO[] getPortPairRouteDetailVOs(){
		PortPairRouteDetailVO[] vos = (PortPairRouteDetailVO[])models.toArray(new PortPairRouteDetailVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routRcvDt = this.routRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPolCd = this.n1stPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlUseFlg = this.mnlUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPodCd = this.n2ndPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPodCd = this.n4thPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPolCd = this.n3rdPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTrdPrnrId = this.custTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oceanFlag = this.oceanFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPodCd = this.n1stPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useFlg = this.useFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n4thPolCd = this.n4thPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPodCd = this.n3rdPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPolCd = this.n2ndPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blockLanes = this.blockLanes .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
