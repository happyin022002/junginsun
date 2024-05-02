/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartialBkgInfoVO.java
*@FileTitle : PartialBkgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.09.04 김병규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김병규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PartialBkgInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PartialBkgInfoVO> models = new ArrayList<PartialBkgInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String org = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podyd1 = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podyd3 = null;
	/* Column Info */
	private String podyd2 = null;
	/* Column Info */
	private String podyd4 = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String polyd4 = null;
	/* Column Info */
	private String polyd2 = null;
	/* Column Info */
	private String polyd3 = null;
	/* Column Info */
	private String polyd1 = null;
	/* Column Info */
	private String obSo = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String pol4 = null;
	/* Column Info */
	private String pol3 = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String pol2 = null;
	/* Column Info */
	private String pol1 = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String pod2 = null;
	/* Column Info */
	private String pod1 = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String pod4 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dest = null;
	/* Column Info */
	private String pod3 = null;
	/* Column Info */
	private String vvd4 = null;
	/* Column Info */
	private String bkgTrunkVvd = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String pstRlyPortCd = null;
	/* Column Info */
	private String ocpCd = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Column Info */
	private String fullRtnYdCd = null;
	/* Column Info */
	private String mtyPkupDt = null;
	/* Column Info */
	private String orgTrnsModCd = null;
	/* Column Info */
	private String lodgDueDt = null;
	/* Column Info */
	private String mtyDorArrDt = null;
	/* Column Info */
	private String fullPkupYdCd = null;
	/* Column Info */
	private String mtyRtnYdCd = null;
	/* Column Info */
	private String destTrnsModCd = null;
	/* Column Info */
	private String deDueDt = null;
	/* Column Info */
	private String orgTrnsSvcModCd = null;
	/* Column Info */
	private String destTrnsSvcModCd = null;		
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String deTermCd = null;			
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PartialBkgInfoVO() {}

	public PartialBkgInfoVO(String ibflag, String pagerows, String bkgNo, String porCd, String porNodCd, String polCd, String polNodCd, String obSo, String vvd1, String pol1, String polyd1, String pod1, String podyd1, String vvd2, String pol2, String polyd2, String pod2, String podyd2, String vvd3, String pol3, String polyd3, String pod3, String podyd3, String vvd4, String pol4, String polyd4, String pod4, String podyd4, String podCd, String podNodCd, String delCd, String delNodCd, String org, String dest, String bkgTrunkVvd, String preRlyPortCd, String pstRlyPortCd, String ocpCd, String mtyPkupYdCd, String fullRtnYdCd, String mtyPkupDt, String orgTrnsModCd, String lodgDueDt, String mtyDorArrDt, String fullPkupYdCd, String mtyRtnYdCd, String destTrnsModCd, String deDueDt, String orgTrnsSvcModCd, String destTrnsSvcModCd, String rcvTermCd, String deTermCd) {
		this.porCd = porCd;
		this.org = org;
		this.pagerows = pagerows;
		this.podyd1 = podyd1;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.podyd3 = podyd3;
		this.podyd2 = podyd2;
		this.podyd4 = podyd4;
		this.delNodCd = delNodCd;
		this.polyd4 = polyd4;
		this.polyd2 = polyd2;
		this.polyd3 = polyd3;
		this.polyd1 = polyd1;
		this.obSo = obSo;
		this.porNodCd = porNodCd;
		this.delCd = delCd;
		this.pol4 = pol4;
		this.pol3 = pol3;
		this.polNodCd = polNodCd;
		this.pol2 = pol2;
		this.pol1 = pol1;
		this.vvd2 = vvd2;
		this.vvd3 = vvd3;
		this.vvd1 = vvd1;
		this.podCd = podCd;
		this.pod2 = pod2;
		this.pod1 = pod1;
		this.podNodCd = podNodCd;
		this.pod4 = pod4;
		this.bkgNo = bkgNo;
		this.dest = dest;
		this.pod3 = pod3;
		this.vvd4 = vvd4;
		this.bkgTrunkVvd = bkgTrunkVvd;
		this.preRlyPortCd = preRlyPortCd;
		this.pstRlyPortCd = pstRlyPortCd;
		this.ocpCd = ocpCd;		
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.fullRtnYdCd = fullRtnYdCd;
		this.mtyPkupDt = mtyPkupDt;
		this.orgTrnsModCd = orgTrnsModCd;
		this.lodgDueDt = lodgDueDt;
		this.mtyDorArrDt = mtyDorArrDt;
		this.fullPkupYdCd = fullPkupYdCd;
		this.mtyRtnYdCd = mtyRtnYdCd;
		this.destTrnsModCd = destTrnsModCd;
		this.deDueDt = deDueDt;
		this.orgTrnsSvcModCd = orgTrnsSvcModCd;
		this.destTrnsSvcModCd = destTrnsSvcModCd;	
		this.rcvTermCd = rcvTermCd;
		this.deTermCd = deTermCd;				
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("org", getOrg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("podyd1", getPodyd1());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("podyd3", getPodyd3());
		this.hashColumns.put("podyd2", getPodyd2());
		this.hashColumns.put("podyd4", getPodyd4());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("polyd4", getPolyd4());
		this.hashColumns.put("polyd2", getPolyd2());
		this.hashColumns.put("polyd3", getPolyd3());
		this.hashColumns.put("polyd1", getPolyd1());
		this.hashColumns.put("ob_so", getObSo());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pol4", getPol4());
		this.hashColumns.put("pol3", getPol3());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("pol2", getPol2());
		this.hashColumns.put("pol1", getPol1());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod2", getPod2());
		this.hashColumns.put("pod1", getPod1());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("pod4", getPod4());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dest", getDest());
		this.hashColumns.put("pod3", getPod3());
		this.hashColumns.put("vvd4", getVvd4());
		this.hashColumns.put("bkg_trunk_vvd", getBkgTrunkVvd());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		this.hashColumns.put("ocp_cd", getOcpCd());			
		this.hashColumns.put("mtyPkupYdCd", getMtyPkupYdCd());
		this.hashColumns.put("fullRtnYdCd", getFullRtnYdCd());
		this.hashColumns.put("mtyPkupDt", getMtyPkupDt());
		this.hashColumns.put("orgTrnsModCd", getOrgTrnsModCd());
		this.hashColumns.put("lodgDueDt", getLodgDueDt());
		this.hashColumns.put("mtyDorArrDt", getMtyDorArrDt());
		this.hashColumns.put("fullPkupYdCd", getFullPkupYdCd());
		this.hashColumns.put("mtyRtnYdCd", getMtyRtnYdCd());
		this.hashColumns.put("destTrnsModCd", getDestTrnsModCd());
		this.hashColumns.put("deDueDt", getDeDueDt());
		this.hashColumns.put("orgTrnsSvcModCd", getOrgTrnsSvcModCd());
		this.hashColumns.put("destTrnsSvcModCd", getDestTrnsSvcModCd());	
		this.hashColumns.put("rcvTermCd", getRcvTermCd());
		this.hashColumns.put("deTermCd", getDeTermCd());				
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("org", "org");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("podyd1", "podyd1");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("podyd3", "podyd3");
		this.hashFields.put("podyd2", "podyd2");
		this.hashFields.put("podyd4", "podyd4");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("polyd4", "polyd4");
		this.hashFields.put("polyd2", "polyd2");
		this.hashFields.put("polyd3", "polyd3");
		this.hashFields.put("polyd1", "polyd1");
		this.hashFields.put("ob_so", "obSo");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pol4", "pol4");
		this.hashFields.put("pol3", "pol3");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("pol2", "pol2");
		this.hashFields.put("pol1", "pol1");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pod2", "pod2");
		this.hashFields.put("pod1", "pod1");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("pod4", "pod4");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dest", "dest");
		this.hashFields.put("pod3", "pod3");
		this.hashFields.put("vvd4", "vvd4");
		this.hashFields.put("bkg_trunk_vvd", "bkgTrunkVvd");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		this.hashFields.put("ocp_cd", "ocpCd");		
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
		this.hashFields.put("mty_pkup_dt", "mtyPkupDt");
		this.hashFields.put("org_trns_mod_cd", "orgTrnsModCd");
		this.hashFields.put("lodg_due_dt", "lodgDueDt");
		this.hashFields.put("mty_dor_arr_dt", "mtyDorArrDt");
		this.hashFields.put("full_pkup_yd_cd", "fullPkupYdCd");
		this.hashFields.put("mty_rtn_yd_cd", "mtyRtnYdCd");
		this.hashFields.put("dest_trns_mod_cd", "destTrnsModCd");
		this.hashFields.put("de_due_dt", "deDueDt");
		this.hashFields.put("org_trns_svc_mod_cd", "orgTrnsSvcModCd");
		this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");	
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("de_term_cd", "deTermCd");			
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
	 * @return org
	 */
	public String getOrg() {
		return this.org;
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
	 * @return podyd1
	 */
	public String getPodyd1() {
		return this.podyd1;
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
	 * @return podyd3
	 */
	public String getPodyd3() {
		return this.podyd3;
	}
	
	/**
	 * Column Info
	 * @return podyd2
	 */
	public String getPodyd2() {
		return this.podyd2;
	}
	
	/**
	 * Column Info
	 * @return podyd4
	 */
	public String getPodyd4() {
		return this.podyd4;
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
	 * @return polyd4
	 */
	public String getPolyd4() {
		return this.polyd4;
	}
	
	/**
	 * Column Info
	 * @return polyd2
	 */
	public String getPolyd2() {
		return this.polyd2;
	}
	
	/**
	 * Column Info
	 * @return polyd3
	 */
	public String getPolyd3() {
		return this.polyd3;
	}
	
	/**
	 * Column Info
	 * @return polyd1
	 */
	public String getPolyd1() {
		return this.polyd1;
	}
	
	/**
	 * Column Info
	 * @return obSo
	 */
	public String getObSo() {
		return this.obSo;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return pol4
	 */
	public String getPol4() {
		return this.pol4;
	}
	
	/**
	 * Column Info
	 * @return pol3
	 */
	public String getPol3() {
		return this.pol3;
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
	 * @return pol2
	 */
	public String getPol2() {
		return this.pol2;
	}
	
	/**
	 * Column Info
	 * @return pol1
	 */
	public String getPol1() {
		return this.pol1;
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
	 * @return pod2
	 */
	public String getPod2() {
		return this.pod2;
	}
	
	/**
	 * Column Info
	 * @return pod1
	 */
	public String getPod1() {
		return this.pod1;
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
	 * @return pod4
	 */
	public String getPod4() {
		return this.pod4;
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
	 * @return dest
	 */
	public String getDest() {
		return this.dest;
	}
	
	/**
	 * Column Info
	 * @return pod3
	 */
	public String getPod3() {
		return this.pod3;
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
	 * @return bkgTrunkVvd
	 */
	public String getBkgTrunkVvd() {
		return this.bkgTrunkVvd;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return ocpCd
	 */
	public String getOcpCd() {
		return this.ocpCd;
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
	 * @return fullRtnYdCd
	 */
	public String getFullRtnYdCd() {
		return this.fullRtnYdCd;
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
	 * @return orgTrnsModCd
	 */
	public String getOrgTrnsModCd() {
		return this.orgTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return lodgDueDt
	 */
	public String getLodgDueDt() {
		return this.lodgDueDt;
	}
	
	/**
	 * Column Info
	 * @return mtyDorArrDt
	 */
	public String getMtyDorArrDt() {
		return this.mtyDorArrDt;
	}
	
	/**
	 * Column Info
	 * @return fullPkupYdCd
	 */
	public String getFullPkupYdCd() {
		return this.fullPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return mtyRtnYdCd
	 */
	public String getMtyRtnYdCd() {
		return this.mtyRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return destTrnsModCd
	 */
	public String getDestTrnsModCd() {
		return this.destTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return deDueDt
	 */
	public String getDeDueDt() {
		return this.deDueDt;
	}
	
	/**
	 * Column Info
	 * @return orgTrnsSvcModCd
	 */
	public String getOrgTrnsSvcModCd() {
		return this.orgTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @return destTrnsSvcModCd
	 */
	public String getDestTrnsSvcModCd() {
		return this.destTrnsSvcModCd;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @param org
	 */
	public void setOrg(String org) {
		this.org = org;
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
	 * @param podyd1
	 */
	public void setPodyd1(String podyd1) {
		this.podyd1 = podyd1;
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
	 * @param podyd3
	 */
	public void setPodyd3(String podyd3) {
		this.podyd3 = podyd3;
	}
	
	/**
	 * Column Info
	 * @param podyd2
	 */
	public void setPodyd2(String podyd2) {
		this.podyd2 = podyd2;
	}
	
	/**
	 * Column Info
	 * @param podyd4
	 */
	public void setPodyd4(String podyd4) {
		this.podyd4 = podyd4;
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
	 * @param polyd4
	 */
	public void setPolyd4(String polyd4) {
		this.polyd4 = polyd4;
	}
	
	/**
	 * Column Info
	 * @param polyd2
	 */
	public void setPolyd2(String polyd2) {
		this.polyd2 = polyd2;
	}
	
	/**
	 * Column Info
	 * @param polyd3
	 */
	public void setPolyd3(String polyd3) {
		this.polyd3 = polyd3;
	}
	
	/**
	 * Column Info
	 * @param polyd1
	 */
	public void setPolyd1(String polyd1) {
		this.polyd1 = polyd1;
	}
	
	/**
	 * Column Info
	 * @param obSo
	 */
	public void setObSo(String obSo) {
		this.obSo = obSo;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param pol4
	 */
	public void setPol4(String pol4) {
		this.pol4 = pol4;
	}
	
	/**
	 * Column Info
	 * @param pol3
	 */
	public void setPol3(String pol3) {
		this.pol3 = pol3;
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
	 * @param pol2
	 */
	public void setPol2(String pol2) {
		this.pol2 = pol2;
	}
	
	/**
	 * Column Info
	 * @param pol1
	 */
	public void setPol1(String pol1) {
		this.pol1 = pol1;
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
	 * @param pod2
	 */
	public void setPod2(String pod2) {
		this.pod2 = pod2;
	}
	
	/**
	 * Column Info
	 * @param pod1
	 */
	public void setPod1(String pod1) {
		this.pod1 = pod1;
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
	 * @param pod4
	 */
	public void setPod4(String pod4) {
		this.pod4 = pod4;
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
	 * @param dest
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}
	
	/**
	 * Column Info
	 * @param pod3
	 */
	public void setPod3(String pod3) {
		this.pod3 = pod3;
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
	 * @param bkgTrunkVvd
	 */
	public void setBkgTrunkVvd(String bkgTrunkVvd) {
		this.bkgTrunkVvd = bkgTrunkVvd;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param ocpCd
	 */
	public void setOcpCd(String ocpCd) {
		this.ocpCd = ocpCd;
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
	 * @param fullRtnYdCd
	 */
	public void setFullRtnYdCd(String fullRtnYdCd) {
		this.fullRtnYdCd = fullRtnYdCd;
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
	 * @param orgTrnsModCd
	 */
	public void setOrgTrnsModCd(String orgTrnsModCd) {
		this.orgTrnsModCd = orgTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param lodgDueDt
	 */
	public void setLodgDueDt(String lodgDueDt) {
		this.lodgDueDt = lodgDueDt;
	}
	
	/**
	 * Column Info
	 * @param mtyDorArrDt
	 */
	public void setMtyDorArrDt(String mtyDorArrDt) {
		this.mtyDorArrDt = mtyDorArrDt;
	}
	
	/**
	 * Column Info
	 * @param fullPkupYdCd
	 */
	public void setFullPkupYdCd(String fullPkupYdCd) {
		this.fullPkupYdCd = fullPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param mtyRtnYdCd
	 */
	public void setMtyRtnYdCd(String mtyRtnYdCd) {
		this.mtyRtnYdCd = mtyRtnYdCd;
	}
	/**
	 * Column Info
	 * @param destTrnsModCd
	 */
	public void setDestTrnsModCd(String destTrnsModCd) {
		this.destTrnsModCd = destTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param deDueDt
	 */
	public void setDeDueDt(String deDueDt) {
		this.deDueDt = deDueDt;
	}
	
	/**
	 * Column Info
	 * @param orgTrnsSvcModCd
	 */
	public void setOrgTrnsSvcModCd(String orgTrnsSvcModCd) {
		this.orgTrnsSvcModCd = orgTrnsSvcModCd;
	}
	
	/**
	 * Column Info
	 * @param destTrnsSvcModCd
	 */
	public void setDestTrnsSvcModCd(String destTrnsSvcModCd) {
		this.destTrnsSvcModCd = destTrnsSvcModCd;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}	
				
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setOrg(JSPUtil.getParameter(request, "org", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodyd1(JSPUtil.getParameter(request, "podyd1", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPodyd3(JSPUtil.getParameter(request, "podyd3", ""));
		setPodyd2(JSPUtil.getParameter(request, "podyd2", ""));
		setPodyd4(JSPUtil.getParameter(request, "podyd4", ""));
		setDelNodCd(JSPUtil.getParameter(request, "del_nod_cd", ""));
		setPolyd4(JSPUtil.getParameter(request, "polyd4", ""));
		setPolyd2(JSPUtil.getParameter(request, "polyd2", ""));
		setPolyd3(JSPUtil.getParameter(request, "polyd3", ""));
		setPolyd1(JSPUtil.getParameter(request, "polyd1", ""));
		setObSo(JSPUtil.getParameter(request, "ob_so", ""));
		setPorNodCd(JSPUtil.getParameter(request, "por_nod_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setPol4(JSPUtil.getParameter(request, "pol4", ""));
		setPol3(JSPUtil.getParameter(request, "pol3", ""));
		setPolNodCd(JSPUtil.getParameter(request, "pol_nod_cd", ""));
		setPol2(JSPUtil.getParameter(request, "pol2", ""));
		setPol1(JSPUtil.getParameter(request, "pol1", ""));
		setVvd2(JSPUtil.getParameter(request, "vvd2", ""));
		setVvd3(JSPUtil.getParameter(request, "vvd3", ""));
		setVvd1(JSPUtil.getParameter(request, "vvd1", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPod2(JSPUtil.getParameter(request, "pod2", ""));
		setPod1(JSPUtil.getParameter(request, "pod1", ""));
		setPodNodCd(JSPUtil.getParameter(request, "pod_nod_cd", ""));
		setPod4(JSPUtil.getParameter(request, "pod4", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDest(JSPUtil.getParameter(request, "dest", ""));
		setPod3(JSPUtil.getParameter(request, "pod3", ""));
		setVvd4(JSPUtil.getParameter(request, "vvd4", ""));
		setBkgTrunkVvd(JSPUtil.getParameter(request, "bkg_trunk_vvd", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, "pre_rly_port_cd", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, "pst_rly_port_cd", ""));
		setOcpCd(JSPUtil.getParameter(request, "ocp_cd", ""));			
		setMtyPkupYdCd(JSPUtil.getParameter(request, "mty_pkup_yd_cd", ""));
		setFullRtnYdCd(JSPUtil.getParameter(request, "full_rtn_yd_cd", ""));
		setMtyPkupDt(JSPUtil.getParameter(request, "mty_pkup_dt", ""));
		setOrgTrnsModCd(JSPUtil.getParameter(request, "org_trns_mod_cd", ""));
		setLodgDueDt(JSPUtil.getParameter(request, "lodg_due_dt", ""));
		setMtyDorArrDt(JSPUtil.getParameter(request, "mty_dor_arr_dt", ""));
		setFullPkupYdCd(JSPUtil.getParameter(request, "full_pkup_yd_cd", ""));
		setMtyRtnYdCd(JSPUtil.getParameter(request, "mty_rtn_yd_cd", ""));
		setDestTrnsModCd(JSPUtil.getParameter(request, "dest_trns_mod_cd", ""));
		setDeDueDt(JSPUtil.getParameter(request, "de_due_dt", ""));
		setOrgTrnsSvcModCd(JSPUtil.getParameter(request, "org_trns_svc_mod_cd", ""));
		setDestTrnsSvcModCd(JSPUtil.getParameter(request, "dest_trns_svc_mod_cd", ""));		
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));			
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PartialBkgInfoVO[]
	 */
	public PartialBkgInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PartialBkgInfoVO[]
	 */
	public PartialBkgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PartialBkgInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] org = (JSPUtil.getParameter(request, prefix	+ "org", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podyd1 = (JSPUtil.getParameter(request, prefix	+ "podyd1", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podyd3 = (JSPUtil.getParameter(request, prefix	+ "podyd3", length));
			String[] podyd2 = (JSPUtil.getParameter(request, prefix	+ "podyd2", length));
			String[] podyd4 = (JSPUtil.getParameter(request, prefix	+ "podyd4", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] polyd4 = (JSPUtil.getParameter(request, prefix	+ "polyd4", length));
			String[] polyd2 = (JSPUtil.getParameter(request, prefix	+ "polyd2", length));
			String[] polyd3 = (JSPUtil.getParameter(request, prefix	+ "polyd3", length));
			String[] polyd1 = (JSPUtil.getParameter(request, prefix	+ "polyd1", length));
			String[] obSo = (JSPUtil.getParameter(request, prefix	+ "ob_so", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] pol4 = (JSPUtil.getParameter(request, prefix	+ "pol4", length));
			String[] pol3 = (JSPUtil.getParameter(request, prefix	+ "pol3", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] pol2 = (JSPUtil.getParameter(request, prefix	+ "pol2", length));
			String[] pol1 = (JSPUtil.getParameter(request, prefix	+ "pol1", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix	+ "vvd3", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] pod2 = (JSPUtil.getParameter(request, prefix	+ "pod2", length));
			String[] pod1 = (JSPUtil.getParameter(request, prefix	+ "pod1", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] pod4 = (JSPUtil.getParameter(request, prefix	+ "pod4", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dest = (JSPUtil.getParameter(request, prefix	+ "dest", length));
			String[] pod3 = (JSPUtil.getParameter(request, prefix	+ "pod3", length));
			String[] vvd4 = (JSPUtil.getParameter(request, prefix	+ "vvd4", length));
			String[] bkgTrunkVvd = (JSPUtil.getParameter(request, prefix	+ "bkg_trunk_vvd", length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd", length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd", length));
			String[] ocpCd = (JSPUtil.getParameter(request, prefix	+ "ocp_cd", length));			
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd", length));
			String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "full_rtn_yd_cd", length));
			String[] mtyPkupDt = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_dt", length));
			String[] orgTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "org_trns_mod_cd", length));
			String[] lodgDueDt = (JSPUtil.getParameter(request, prefix	+ "lodg_due_dt", length));
			String[] mtyDorArrDt = (JSPUtil.getParameter(request, prefix	+ "mty_dor_arr_dt", length));
			String[] fullPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "full_pkup_yd_cd", length));
			String[] mtyRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_rtn_yd_cd", length));
			String[] destTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_mod_cd", length));
			String[] deDueDt = (JSPUtil.getParameter(request, prefix	+ "de_due_dt", length));
			String[] orgTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "org_trns_svc_mod_cd", length));
			String[] destTrnsSvcModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_svc_mod_cd", length));	
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));	
			
			for (int i = 0; i < length; i++) {
				model = new PartialBkgInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (org[i] != null)
					model.setOrg(org[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podyd1[i] != null)
					model.setPodyd1(podyd1[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podyd3[i] != null)
					model.setPodyd3(podyd3[i]);
				if (podyd2[i] != null)
					model.setPodyd2(podyd2[i]);
				if (podyd4[i] != null)
					model.setPodyd4(podyd4[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (polyd4[i] != null)
					model.setPolyd4(polyd4[i]);
				if (polyd2[i] != null)
					model.setPolyd2(polyd2[i]);
				if (polyd3[i] != null)
					model.setPolyd3(polyd3[i]);
				if (polyd1[i] != null)
					model.setPolyd1(polyd1[i]);
				if (obSo[i] != null)
					model.setObSo(obSo[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (pol4[i] != null)
					model.setPol4(pol4[i]);
				if (pol3[i] != null)
					model.setPol3(pol3[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (pol2[i] != null)
					model.setPol2(pol2[i]);
				if (pol1[i] != null)
					model.setPol1(pol1[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (pod2[i] != null)
					model.setPod2(pod2[i]);
				if (pod1[i] != null)
					model.setPod1(pod1[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (pod4[i] != null)
					model.setPod4(pod4[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dest[i] != null)
					model.setDest(dest[i]);
				if (pod3[i] != null)
					model.setPod3(pod3[i]);
				if (vvd4[i] != null)
					model.setVvd4(vvd4[i]);
				if (bkgTrunkVvd[i] != null)
					model.setBkgTrunkVvd(bkgTrunkVvd[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				if (ocpCd[i] != null)
					model.setOcpCd(ocpCd[i]);				
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (fullRtnYdCd[i] != null)
					model.setFullRtnYdCd(fullRtnYdCd[i]);
				if (mtyPkupDt[i] != null)
					model.setMtyPkupDt(mtyPkupDt[i]);
				if (orgTrnsModCd[i] != null)
					model.setOrgTrnsModCd(orgTrnsModCd[i]);
				if (lodgDueDt[i] != null)
					model.setLodgDueDt(lodgDueDt[i]);
				if (mtyDorArrDt[i] != null)
					model.setMtyDorArrDt(mtyDorArrDt[i]);
				if (fullPkupYdCd[i] != null)
					model.setFullPkupYdCd(fullPkupYdCd[i]);
				if (mtyRtnYdCd[i] != null)
					model.setMtyRtnYdCd(mtyRtnYdCd[i]);
				if (destTrnsModCd[i] != null)
					model.setDestTrnsModCd(destTrnsModCd[i]);
				if (deDueDt[i] != null)
					model.setDeDueDt(deDueDt[i]);
				if (orgTrnsSvcModCd[i] != null)
					model.setOrgTrnsSvcModCd(orgTrnsSvcModCd[i]);
				if (destTrnsSvcModCd[i] != null)
					model.setDestTrnsSvcModCd(destTrnsSvcModCd[i]);	
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPartialBkgInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PartialBkgInfoVO[]
	 */
	public PartialBkgInfoVO[] getPartialBkgInfoVOs(){
		PartialBkgInfoVO[] vos = (PartialBkgInfoVO[])models.toArray(new PartialBkgInfoVO[models.size()]);
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
		this.org = this.org .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podyd1 = this.podyd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podyd3 = this.podyd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podyd2 = this.podyd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podyd4 = this.podyd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polyd4 = this.polyd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polyd2 = this.polyd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polyd3 = this.polyd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polyd1 = this.polyd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSo = this.obSo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4 = this.pol4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3 = this.pol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2 = this.pol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1 = this.pol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2 = this.pod2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1 = this.pod1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4 = this.pod4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dest = this.dest .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3 = this.pod3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4 = this.vvd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrunkVvd = this.bkgTrunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocpCd = this.ocpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnYdCd = this.fullRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupDt = this.mtyPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrnsModCd = this.orgTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgDueDt = this.lodgDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyDorArrDt = this.mtyDorArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullPkupYdCd = this.fullPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRtnYdCd = this.mtyRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsModCd = this.destTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deDueDt = this.deDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrnsSvcModCd = this.orgTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsSvcModCd = this.destTrnsSvcModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");			
	}
}
