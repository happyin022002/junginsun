/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VvdDetailForPortAssignVO.java
*@FileTitle : VvdDetailForPortAssignVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.16
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.03.16 Maeda Atsushi 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Maeda Atsushi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class VvdDetailForPortAssignVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VvdDetailForPortAssignVO> models = new ArrayList<VvdDetailForPortAssignVO>();
	
	/* Column Info */
	private String orgTrnsModCd = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String polYdCd4 = null;
	/* Column Info */
	private String polYdCd3 = null;
	/* Column Info */
	private String polYdCd2 = null;
	/* Column Info */
	private String polYdCd1 = null;
	/* Column Info */
	private String mtyPkupDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String fullRtnYdCd = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String podClptIndSeq1 = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String polCd1 = null;
	/* Column Info */
	private String vvd4 = null;
	/* Column Info */
	private String polCd2 = null;
	/* Column Info */
	private String polCd3 = null;
	/* Column Info */
	private String polCd4 = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String destTrnsModCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tvvdSeq = null;
	/* Column Info */
	private String podClptIndSeq3 = null;
	/* Column Info */
	private String podClptIndSeq2 = null;
	/* Column Info */
	private String podClptIndSeq4 = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String routeKey = null;
	/* Column Info */
	private String podYdCd4 = null;
	/* Column Info */
	private String podYdCd3 = null;
	/* Column Info */
	private String podYdCd2 = null;
	/* Column Info */
	private String podCd1 = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String podYdCd1 = null;
	/* Column Info */
	private String podCd2 = null;
	/* Column Info */
	private String podCd3 = null;
	/* Column Info */
	private String podCd4 = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String polClptIndSeq3 = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String polClptIndSeq2 = null;
	/* Column Info */
	private String polClptIndSeq4 = null;
	/* Column Info */
	private String vvdKey = null;
	/* Column Info */
	private String polClptIndSeq1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VvdDetailForPortAssignVO() {}

	public VvdDetailForPortAssignVO(String ibflag, String pagerows, String bkgNo, String blNo, String porCd, String porNodCd, String polCd, String polNodCd, String podCd, String podNodCd, String delCd, String delNodCd, String rcvTermCd, String deTermCd, String mtyPkupYdCd, String orgTrnsModCd, String destTrnsModCd, String tvvd, String mtyPkupDt, String fullRtnYdCd, String polCd1, String polYdCd1, String polClptIndSeq1, String vvd1, String podCd1, String podYdCd1, String podClptIndSeq1, String polCd2, String polYdCd2, String polClptIndSeq2, String vvd2, String podCd2, String podYdCd2, String podClptIndSeq2, String polCd3, String polYdCd3, String polClptIndSeq3, String vvd3, String podCd3, String podYdCd3, String podClptIndSeq3, String polCd4, String polYdCd4, String polClptIndSeq4, String vvd4, String podCd4, String podYdCd4, String podClptIndSeq4, String routeKey, String vvdKey, String tvvdSeq) {
		this.orgTrnsModCd = orgTrnsModCd;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.delNodCd = delNodCd;
		this.polYdCd4 = polYdCd4;
		this.polYdCd3 = polYdCd3;
		this.polYdCd2 = polYdCd2;
		this.polYdCd1 = polYdCd1;
		this.mtyPkupDt = mtyPkupDt;
		this.delCd = delCd;
		this.tvvd = tvvd;
		this.fullRtnYdCd = fullRtnYdCd;
		this.vvd2 = vvd2;
		this.podClptIndSeq1 = podClptIndSeq1;
		this.vvd3 = vvd3;
		this.vvd1 = vvd1;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.podNodCd = podNodCd;
		this.polCd1 = polCd1;
		this.vvd4 = vvd4;
		this.polCd2 = polCd2;
		this.polCd3 = polCd3;
		this.polCd4 = polCd4;
		this.porCd = porCd;
		this.destTrnsModCd = destTrnsModCd;
		this.ibflag = ibflag;
		this.tvvdSeq = tvvdSeq;
		this.podClptIndSeq3 = podClptIndSeq3;
		this.podClptIndSeq2 = podClptIndSeq2;
		this.podClptIndSeq4 = podClptIndSeq4;
		this.rcvTermCd = rcvTermCd;
		this.routeKey = routeKey;
		this.podYdCd4 = podYdCd4;
		this.podYdCd3 = podYdCd3;
		this.podYdCd2 = podYdCd2;
		this.podCd1 = podCd1;
		this.porNodCd = porNodCd;
		this.podYdCd1 = podYdCd1;
		this.podCd2 = podCd2;
		this.podCd3 = podCd3;
		this.podCd4 = podCd4;
		this.polNodCd = polNodCd;
		this.polClptIndSeq3 = polClptIndSeq3;
		this.deTermCd = deTermCd;
		this.polClptIndSeq2 = polClptIndSeq2;
		this.polClptIndSeq4 = polClptIndSeq4;
		this.vvdKey = vvdKey;
		this.polClptIndSeq1 = polClptIndSeq1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("org_trns_mod_cd", getOrgTrnsModCd());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("pol_yd_cd4", getPolYdCd4());
		this.hashColumns.put("pol_yd_cd3", getPolYdCd3());
		this.hashColumns.put("pol_yd_cd2", getPolYdCd2());
		this.hashColumns.put("pol_yd_cd1", getPolYdCd1());
		this.hashColumns.put("mty_pkup_dt", getMtyPkupDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("full_rtn_yd_cd", getFullRtnYdCd());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("pod_clpt_ind_seq1", getPodClptIndSeq1());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("pol_cd1", getPolCd1());
		this.hashColumns.put("vvd4", getVvd4());
		this.hashColumns.put("pol_cd2", getPolCd2());
		this.hashColumns.put("pol_cd3", getPolCd3());
		this.hashColumns.put("pol_cd4", getPolCd4());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("dest_trns_mod_cd", getDestTrnsModCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tvvd_seq", getTvvdSeq());
		this.hashColumns.put("pod_clpt_ind_seq3", getPodClptIndSeq3());
		this.hashColumns.put("pod_clpt_ind_seq2", getPodClptIndSeq2());
		this.hashColumns.put("pod_clpt_ind_seq4", getPodClptIndSeq4());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("route_key", getRouteKey());
		this.hashColumns.put("pod_yd_cd4", getPodYdCd4());
		this.hashColumns.put("pod_yd_cd3", getPodYdCd3());
		this.hashColumns.put("pod_yd_cd2", getPodYdCd2());
		this.hashColumns.put("pod_cd1", getPodCd1());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("pod_yd_cd1", getPodYdCd1());
		this.hashColumns.put("pod_cd2", getPodCd2());
		this.hashColumns.put("pod_cd3", getPodCd3());
		this.hashColumns.put("pod_cd4", getPodCd4());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("pol_clpt_ind_seq3", getPolClptIndSeq3());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("pol_clpt_ind_seq2", getPolClptIndSeq2());
		this.hashColumns.put("pol_clpt_ind_seq4", getPolClptIndSeq4());
		this.hashColumns.put("vvd_key", getVvdKey());
		this.hashColumns.put("pol_clpt_ind_seq1", getPolClptIndSeq1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("org_trns_mod_cd", "orgTrnsModCd");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("pol_yd_cd4", "polYdCd4");
		this.hashFields.put("pol_yd_cd3", "polYdCd3");
		this.hashFields.put("pol_yd_cd2", "polYdCd2");
		this.hashFields.put("pol_yd_cd1", "polYdCd1");
		this.hashFields.put("mty_pkup_dt", "mtyPkupDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("pod_clpt_ind_seq1", "podClptIndSeq1");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("pol_cd1", "polCd1");
		this.hashFields.put("vvd4", "vvd4");
		this.hashFields.put("pol_cd2", "polCd2");
		this.hashFields.put("pol_cd3", "polCd3");
		this.hashFields.put("pol_cd4", "polCd4");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("dest_trns_mod_cd", "destTrnsModCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tvvd_seq", "tvvdSeq");
		this.hashFields.put("pod_clpt_ind_seq3", "podClptIndSeq3");
		this.hashFields.put("pod_clpt_ind_seq2", "podClptIndSeq2");
		this.hashFields.put("pod_clpt_ind_seq4", "podClptIndSeq4");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("route_key", "routeKey");
		this.hashFields.put("pod_yd_cd4", "podYdCd4");
		this.hashFields.put("pod_yd_cd3", "podYdCd3");
		this.hashFields.put("pod_yd_cd2", "podYdCd2");
		this.hashFields.put("pod_cd1", "podCd1");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("pod_yd_cd1", "podYdCd1");
		this.hashFields.put("pod_cd2", "podCd2");
		this.hashFields.put("pod_cd3", "podCd3");
		this.hashFields.put("pod_cd4", "podCd4");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("pol_clpt_ind_seq3", "polClptIndSeq3");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("pol_clpt_ind_seq2", "polClptIndSeq2");
		this.hashFields.put("pol_clpt_ind_seq4", "polClptIndSeq4");
		this.hashFields.put("vvd_key", "vvdKey");
		this.hashFields.put("pol_clpt_ind_seq1", "polClptIndSeq1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return orgTrnsModCd
	 */
	public String getOrgTrnsModCd() {
		return this.orgTrnsModCd;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return polYdCd4
	 */
	public String getPolYdCd4() {
		return this.polYdCd4;
	}
	
	/**
	 * Column Info
	 * @return polYdCd3
	 */
	public String getPolYdCd3() {
		return this.polYdCd3;
	}
	
	/**
	 * Column Info
	 * @return polYdCd2
	 */
	public String getPolYdCd2() {
		return this.polYdCd2;
	}
	
	/**
	 * Column Info
	 * @return polYdCd1
	 */
	public String getPolYdCd1() {
		return this.polYdCd1;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupDt
	 */
	public String getMtyPkupDt() {
		return this.mtyPkupDt;
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
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}
	
	/**
	 * Column Info
	 * @return fullRtnYdCd
	 */
	public String getFullRtnYdCd() {
		return this.fullRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}
	
	/**
	 * Column Info
	 * @return podClptIndSeq1
	 */
	public String getPodClptIndSeq1() {
		return this.podClptIndSeq1;
	}
	
	/**
	 * Column Info
	 * @return vvd3
	 */
	public String getVvd3() {
		return this.vvd3;
	}
	
	/**
	 * Column Info
	 * @return vvd1
	 */
	public String getVvd1() {
		return this.vvd1;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}
	
	/**
	 * Column Info
	 * @return polCd1
	 */
	public String getPolCd1() {
		return this.polCd1;
	}
	
	/**
	 * Column Info
	 * @return vvd4
	 */
	public String getVvd4() {
		return this.vvd4;
	}
	
	/**
	 * Column Info
	 * @return polCd2
	 */
	public String getPolCd2() {
		return this.polCd2;
	}
	
	/**
	 * Column Info
	 * @return polCd3
	 */
	public String getPolCd3() {
		return this.polCd3;
	}
	
	/**
	 * Column Info
	 * @return polCd4
	 */
	public String getPolCd4() {
		return this.polCd4;
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
	 * @return destTrnsModCd
	 */
	public String getDestTrnsModCd() {
		return this.destTrnsModCd;
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
	 * @return tvvdSeq
	 */
	public String getTvvdSeq() {
		return this.tvvdSeq;
	}
	
	/**
	 * Column Info
	 * @return podClptIndSeq3
	 */
	public String getPodClptIndSeq3() {
		return this.podClptIndSeq3;
	}
	
	/**
	 * Column Info
	 * @return podClptIndSeq2
	 */
	public String getPodClptIndSeq2() {
		return this.podClptIndSeq2;
	}
	
	/**
	 * Column Info
	 * @return podClptIndSeq4
	 */
	public String getPodClptIndSeq4() {
		return this.podClptIndSeq4;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return routeKey
	 */
	public String getRouteKey() {
		return this.routeKey;
	}
	
	/**
	 * Column Info
	 * @return podYdCd4
	 */
	public String getPodYdCd4() {
		return this.podYdCd4;
	}
	
	/**
	 * Column Info
	 * @return podYdCd3
	 */
	public String getPodYdCd3() {
		return this.podYdCd3;
	}
	
	/**
	 * Column Info
	 * @return podYdCd2
	 */
	public String getPodYdCd2() {
		return this.podYdCd2;
	}
	
	/**
	 * Column Info
	 * @return podCd1
	 */
	public String getPodCd1() {
		return this.podCd1;
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
	 * @return podYdCd1
	 */
	public String getPodYdCd1() {
		return this.podYdCd1;
	}
	
	/**
	 * Column Info
	 * @return podCd2
	 */
	public String getPodCd2() {
		return this.podCd2;
	}
	
	/**
	 * Column Info
	 * @return podCd3
	 */
	public String getPodCd3() {
		return this.podCd3;
	}
	
	/**
	 * Column Info
	 * @return podCd4
	 */
	public String getPodCd4() {
		return this.podCd4;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return polClptIndSeq3
	 */
	public String getPolClptIndSeq3() {
		return this.polClptIndSeq3;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return polClptIndSeq2
	 */
	public String getPolClptIndSeq2() {
		return this.polClptIndSeq2;
	}
	
	/**
	 * Column Info
	 * @return polClptIndSeq4
	 */
	public String getPolClptIndSeq4() {
		return this.polClptIndSeq4;
	}
	
	/**
	 * Column Info
	 * @return vvdKey
	 */
	public String getVvdKey() {
		return this.vvdKey;
	}
	
	/**
	 * Column Info
	 * @return polClptIndSeq1
	 */
	public String getPolClptIndSeq1() {
		return this.polClptIndSeq1;
	}
	

	/**
	 * Column Info
	 * @param orgTrnsModCd
	 */
	public void setOrgTrnsModCd(String orgTrnsModCd) {
		this.orgTrnsModCd = orgTrnsModCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param polYdCd4
	 */
	public void setPolYdCd4(String polYdCd4) {
		this.polYdCd4 = polYdCd4;
	}
	
	/**
	 * Column Info
	 * @param polYdCd3
	 */
	public void setPolYdCd3(String polYdCd3) {
		this.polYdCd3 = polYdCd3;
	}
	
	/**
	 * Column Info
	 * @param polYdCd2
	 */
	public void setPolYdCd2(String polYdCd2) {
		this.polYdCd2 = polYdCd2;
	}
	
	/**
	 * Column Info
	 * @param polYdCd1
	 */
	public void setPolYdCd1(String polYdCd1) {
		this.polYdCd1 = polYdCd1;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupDt
	 */
	public void setMtyPkupDt(String mtyPkupDt) {
		this.mtyPkupDt = mtyPkupDt;
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
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}
	
	/**
	 * Column Info
	 * @param fullRtnYdCd
	 */
	public void setFullRtnYdCd(String fullRtnYdCd) {
		this.fullRtnYdCd = fullRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}
	
	/**
	 * Column Info
	 * @param podClptIndSeq1
	 */
	public void setPodClptIndSeq1(String podClptIndSeq1) {
		this.podClptIndSeq1 = podClptIndSeq1;
	}
	
	/**
	 * Column Info
	 * @param vvd3
	 */
	public void setVvd3(String vvd3) {
		this.vvd3 = vvd3;
	}
	
	/**
	 * Column Info
	 * @param vvd1
	 */
	public void setVvd1(String vvd1) {
		this.vvd1 = vvd1;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}
	
	/**
	 * Column Info
	 * @param polCd1
	 */
	public void setPolCd1(String polCd1) {
		this.polCd1 = polCd1;
	}
	
	/**
	 * Column Info
	 * @param vvd4
	 */
	public void setVvd4(String vvd4) {
		this.vvd4 = vvd4;
	}
	
	/**
	 * Column Info
	 * @param polCd2
	 */
	public void setPolCd2(String polCd2) {
		this.polCd2 = polCd2;
	}
	
	/**
	 * Column Info
	 * @param polCd3
	 */
	public void setPolCd3(String polCd3) {
		this.polCd3 = polCd3;
	}
	
	/**
	 * Column Info
	 * @param polCd4
	 */
	public void setPolCd4(String polCd4) {
		this.polCd4 = polCd4;
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
	 * @param destTrnsModCd
	 */
	public void setDestTrnsModCd(String destTrnsModCd) {
		this.destTrnsModCd = destTrnsModCd;
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
	 * @param tvvdSeq
	 */
	public void setTvvdSeq(String tvvdSeq) {
		this.tvvdSeq = tvvdSeq;
	}
	
	/**
	 * Column Info
	 * @param podClptIndSeq3
	 */
	public void setPodClptIndSeq3(String podClptIndSeq3) {
		this.podClptIndSeq3 = podClptIndSeq3;
	}
	
	/**
	 * Column Info
	 * @param podClptIndSeq2
	 */
	public void setPodClptIndSeq2(String podClptIndSeq2) {
		this.podClptIndSeq2 = podClptIndSeq2;
	}
	
	/**
	 * Column Info
	 * @param podClptIndSeq4
	 */
	public void setPodClptIndSeq4(String podClptIndSeq4) {
		this.podClptIndSeq4 = podClptIndSeq4;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param routeKey
	 */
	public void setRouteKey(String routeKey) {
		this.routeKey = routeKey;
	}
	
	/**
	 * Column Info
	 * @param podYdCd4
	 */
	public void setPodYdCd4(String podYdCd4) {
		this.podYdCd4 = podYdCd4;
	}
	
	/**
	 * Column Info
	 * @param podYdCd3
	 */
	public void setPodYdCd3(String podYdCd3) {
		this.podYdCd3 = podYdCd3;
	}
	
	/**
	 * Column Info
	 * @param podYdCd2
	 */
	public void setPodYdCd2(String podYdCd2) {
		this.podYdCd2 = podYdCd2;
	}
	
	/**
	 * Column Info
	 * @param podCd1
	 */
	public void setPodCd1(String podCd1) {
		this.podCd1 = podCd1;
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
	 * @param podYdCd1
	 */
	public void setPodYdCd1(String podYdCd1) {
		this.podYdCd1 = podYdCd1;
	}
	
	/**
	 * Column Info
	 * @param podCd2
	 */
	public void setPodCd2(String podCd2) {
		this.podCd2 = podCd2;
	}
	
	/**
	 * Column Info
	 * @param podCd3
	 */
	public void setPodCd3(String podCd3) {
		this.podCd3 = podCd3;
	}
	
	/**
	 * Column Info
	 * @param podCd4
	 */
	public void setPodCd4(String podCd4) {
		this.podCd4 = podCd4;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param polClptIndSeq3
	 */
	public void setPolClptIndSeq3(String polClptIndSeq3) {
		this.polClptIndSeq3 = polClptIndSeq3;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param polClptIndSeq2
	 */
	public void setPolClptIndSeq2(String polClptIndSeq2) {
		this.polClptIndSeq2 = polClptIndSeq2;
	}
	
	/**
	 * Column Info
	 * @param polClptIndSeq4
	 */
	public void setPolClptIndSeq4(String polClptIndSeq4) {
		this.polClptIndSeq4 = polClptIndSeq4;
	}
	
	/**
	 * Column Info
	 * @param vvdKey
	 */
	public void setVvdKey(String vvdKey) {
		this.vvdKey = vvdKey;
	}
	
	/**
	 * Column Info
	 * @param polClptIndSeq1
	 */
	public void setPolClptIndSeq1(String polClptIndSeq1) {
		this.polClptIndSeq1 = polClptIndSeq1;
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
		setOrgTrnsModCd(JSPUtil.getParameter(request, prefix + "org_trns_mod_cd", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setPolYdCd4(JSPUtil.getParameter(request, prefix + "pol_yd_cd4", ""));
		setPolYdCd3(JSPUtil.getParameter(request, prefix + "pol_yd_cd3", ""));
		setPolYdCd2(JSPUtil.getParameter(request, prefix + "pol_yd_cd2", ""));
		setPolYdCd1(JSPUtil.getParameter(request, prefix + "pol_yd_cd1", ""));
		setMtyPkupDt(JSPUtil.getParameter(request, prefix + "mty_pkup_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setTvvd(JSPUtil.getParameter(request, prefix + "tvvd", ""));
		setFullRtnYdCd(JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setPodClptIndSeq1(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq1", ""));
		setVvd3(JSPUtil.getParameter(request, prefix + "vvd3", ""));
		setVvd1(JSPUtil.getParameter(request, prefix + "vvd1", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setPolCd1(JSPUtil.getParameter(request, prefix + "pol_cd1", ""));
		setVvd4(JSPUtil.getParameter(request, prefix + "vvd4", ""));
		setPolCd2(JSPUtil.getParameter(request, prefix + "pol_cd2", ""));
		setPolCd3(JSPUtil.getParameter(request, prefix + "pol_cd3", ""));
		setPolCd4(JSPUtil.getParameter(request, prefix + "pol_cd4", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setDestTrnsModCd(JSPUtil.getParameter(request, prefix + "dest_trns_mod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTvvdSeq(JSPUtil.getParameter(request, prefix + "tvvd_seq", ""));
		setPodClptIndSeq3(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq3", ""));
		setPodClptIndSeq2(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq2", ""));
		setPodClptIndSeq4(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq4", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setRouteKey(JSPUtil.getParameter(request, prefix + "route_key", ""));
		setPodYdCd4(JSPUtil.getParameter(request, prefix + "pod_yd_cd4", ""));
		setPodYdCd3(JSPUtil.getParameter(request, prefix + "pod_yd_cd3", ""));
		setPodYdCd2(JSPUtil.getParameter(request, prefix + "pod_yd_cd2", ""));
		setPodCd1(JSPUtil.getParameter(request, prefix + "pod_cd1", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setPodYdCd1(JSPUtil.getParameter(request, prefix + "pod_yd_cd1", ""));
		setPodCd2(JSPUtil.getParameter(request, prefix + "pod_cd2", ""));
		setPodCd3(JSPUtil.getParameter(request, prefix + "pod_cd3", ""));
		setPodCd4(JSPUtil.getParameter(request, prefix + "pod_cd4", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setPolClptIndSeq3(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq3", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setPolClptIndSeq2(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq2", ""));
		setPolClptIndSeq4(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq4", ""));
		setVvdKey(JSPUtil.getParameter(request, prefix + "vvd_key", ""));
		setPolClptIndSeq1(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VvdDetailForPortAssignVO[]
	 */
	public VvdDetailForPortAssignVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VvdDetailForPortAssignVO[]
	 */
	public VvdDetailForPortAssignVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VvdDetailForPortAssignVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] orgTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "org_trns_mod_cd", length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] polYdCd4 = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd4", length));
			String[] polYdCd3 = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd3", length));
			String[] polYdCd2 = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd2", length));
			String[] polYdCd1 = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd1", length));
			String[] mtyPkupDt = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "full_rtn_yd_cd", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] podClptIndSeq1 = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq1", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix	+ "vvd3", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] polCd1 = (JSPUtil.getParameter(request, prefix	+ "pol_cd1", length));
			String[] vvd4 = (JSPUtil.getParameter(request, prefix	+ "vvd4", length));
			String[] polCd2 = (JSPUtil.getParameter(request, prefix	+ "pol_cd2", length));
			String[] polCd3 = (JSPUtil.getParameter(request, prefix	+ "pol_cd3", length));
			String[] polCd4 = (JSPUtil.getParameter(request, prefix	+ "pol_cd4", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] destTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_mod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tvvdSeq = (JSPUtil.getParameter(request, prefix	+ "tvvd_seq", length));
			String[] podClptIndSeq3 = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq3", length));
			String[] podClptIndSeq2 = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq2", length));
			String[] podClptIndSeq4 = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq4", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] routeKey = (JSPUtil.getParameter(request, prefix	+ "route_key", length));
			String[] podYdCd4 = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd4", length));
			String[] podYdCd3 = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd3", length));
			String[] podYdCd2 = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd2", length));
			String[] podCd1 = (JSPUtil.getParameter(request, prefix	+ "pod_cd1", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] podYdCd1 = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd1", length));
			String[] podCd2 = (JSPUtil.getParameter(request, prefix	+ "pod_cd2", length));
			String[] podCd3 = (JSPUtil.getParameter(request, prefix	+ "pod_cd3", length));
			String[] podCd4 = (JSPUtil.getParameter(request, prefix	+ "pod_cd4", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] polClptIndSeq3 = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq3", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] polClptIndSeq2 = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq2", length));
			String[] polClptIndSeq4 = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq4", length));
			String[] vvdKey = (JSPUtil.getParameter(request, prefix	+ "vvd_key", length));
			String[] polClptIndSeq1 = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq1", length));
			
			for (int i = 0; i < length; i++) {
				model = new VvdDetailForPortAssignVO();
				if (orgTrnsModCd[i] != null)
					model.setOrgTrnsModCd(orgTrnsModCd[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (polYdCd4[i] != null)
					model.setPolYdCd4(polYdCd4[i]);
				if (polYdCd3[i] != null)
					model.setPolYdCd3(polYdCd3[i]);
				if (polYdCd2[i] != null)
					model.setPolYdCd2(polYdCd2[i]);
				if (polYdCd1[i] != null)
					model.setPolYdCd1(polYdCd1[i]);
				if (mtyPkupDt[i] != null)
					model.setMtyPkupDt(mtyPkupDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (fullRtnYdCd[i] != null)
					model.setFullRtnYdCd(fullRtnYdCd[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (podClptIndSeq1[i] != null)
					model.setPodClptIndSeq1(podClptIndSeq1[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (polCd1[i] != null)
					model.setPolCd1(polCd1[i]);
				if (vvd4[i] != null)
					model.setVvd4(vvd4[i]);
				if (polCd2[i] != null)
					model.setPolCd2(polCd2[i]);
				if (polCd3[i] != null)
					model.setPolCd3(polCd3[i]);
				if (polCd4[i] != null)
					model.setPolCd4(polCd4[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (destTrnsModCd[i] != null)
					model.setDestTrnsModCd(destTrnsModCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tvvdSeq[i] != null)
					model.setTvvdSeq(tvvdSeq[i]);
				if (podClptIndSeq3[i] != null)
					model.setPodClptIndSeq3(podClptIndSeq3[i]);
				if (podClptIndSeq2[i] != null)
					model.setPodClptIndSeq2(podClptIndSeq2[i]);
				if (podClptIndSeq4[i] != null)
					model.setPodClptIndSeq4(podClptIndSeq4[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (routeKey[i] != null)
					model.setRouteKey(routeKey[i]);
				if (podYdCd4[i] != null)
					model.setPodYdCd4(podYdCd4[i]);
				if (podYdCd3[i] != null)
					model.setPodYdCd3(podYdCd3[i]);
				if (podYdCd2[i] != null)
					model.setPodYdCd2(podYdCd2[i]);
				if (podCd1[i] != null)
					model.setPodCd1(podCd1[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (podYdCd1[i] != null)
					model.setPodYdCd1(podYdCd1[i]);
				if (podCd2[i] != null)
					model.setPodCd2(podCd2[i]);
				if (podCd3[i] != null)
					model.setPodCd3(podCd3[i]);
				if (podCd4[i] != null)
					model.setPodCd4(podCd4[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (polClptIndSeq3[i] != null)
					model.setPolClptIndSeq3(polClptIndSeq3[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (polClptIndSeq2[i] != null)
					model.setPolClptIndSeq2(polClptIndSeq2[i]);
				if (polClptIndSeq4[i] != null)
					model.setPolClptIndSeq4(polClptIndSeq4[i]);
				if (vvdKey[i] != null)
					model.setVvdKey(vvdKey[i]);
				if (polClptIndSeq1[i] != null)
					model.setPolClptIndSeq1(polClptIndSeq1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVvdDetailForPortAssignVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VvdDetailForPortAssignVO[]
	 */
	public VvdDetailForPortAssignVO[] getVvdDetailForPortAssignVOs(){
		VvdDetailForPortAssignVO[] vos = (VvdDetailForPortAssignVO[])models.toArray(new VvdDetailForPortAssignVO[models.size()]);
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
		this.orgTrnsModCd = this.orgTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd4 = this.polYdCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd3 = this.polYdCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd2 = this.polYdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd1 = this.polYdCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupDt = this.mtyPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnYdCd = this.fullRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq1 = this.podClptIndSeq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd1 = this.polCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4 = this.vvd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd2 = this.polCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd3 = this.polCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd4 = this.polCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsModCd = this.destTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvdSeq = this.tvvdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq3 = this.podClptIndSeq3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq2 = this.podClptIndSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq4 = this.podClptIndSeq4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routeKey = this.routeKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd4 = this.podYdCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd3 = this.podYdCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd2 = this.podYdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd1 = this.podCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd1 = this.podYdCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd2 = this.podCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd3 = this.podCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd4 = this.podCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq3 = this.polClptIndSeq3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq2 = this.polClptIndSeq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq4 = this.polClptIndSeq4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdKey = this.vvdKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq1 = this.polClptIndSeq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
