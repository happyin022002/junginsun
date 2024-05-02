/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PrdMainInfoVO.java
*@FileTitle : PrdMainInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.28 류대영 
* 1.0 Creation
* 2010.11.17 전성진 [CHM-201005932] PRD FlexHeight 및 TRO Split 처리관련 BKG 수정
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PrdMainInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrdMainInfoVO> models = new ArrayList<PrdMainInfoVO>();
	
	/* Column Info */
	private String pod2C = null;
	/* Column Info */
	private String com = null;
	/* Column Info */
	private String ldDt = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String rcvT = null;
	/* Column Info */
	private String polN = null;
	/* Column Info */
	private String pol1C = null;
	/* Column Info */
	private String pmF = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String rfaOfc = null;
	/* Column Info */
	private String pod1N = null;
	/* Column Info */
	private String podN = null;
	/* Column Info */
	private String porN = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String pol4N = null;
	/* Column Info */
	private String orgSalOfc = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String pod3C = null;
	/* Column Info */
	private String wgtUn = null;
	/* Column Info */
	private String pol4C = null;
	/* Column Info */
	private String bbF = null;
	/* Column Info */
	private String pol4 = null;
	/* Column Info */
	private String sc = null;
	/* Column Info */
	private String pol3 = null;
	/* Column Info */
	private String scOfc = null;
	/* Column Info */
	private String pol2 = null;
	/* Column Info */
	private String hgF = null;
	/* Column Info */
	private String pol1 = null;
	/* Column Info */
	private String repCom = null;
	/* Column Info */
	private String drDt = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String cngn = null;
	/* Column Info */
	private String akF = null;
	/* Column Info */
	private String vvd3 = null;
	/* Column Info */
	private String socF = null;
	/* Column Info */
	private String destTrnsMode = null;
	/* Column Info */
	private String vvd1 = null;
	/* Column Info */
	private String pod2 = null;
	/* Column Info */
	private String pol3N = null;
	/* Column Info */
	private String pod1 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String pod4 = null;
	/* Column Info */
	private String pod3 = null;
	/* Column Info */
	private String vvd4 = null;
	/* Column Info */
	private String pod2N = null;
	/* Column Info */
	private String mPu = null;
	/* Column Info */
	private String rdF = null;
	/* Column Info */
	private String mtPkupDt = null;
	/* Column Info */
	private String delN = null;
	/* Column Info */
	private String pod4N = null;
	/* Column Info */
	private String pol3C = null;
	/* Column Info */
	private String rfa = null;
	/* Column Info */
	private String imdg = null;
	/* Column Info */
	private String delT = null;
	/* Column Info */
	private String pod4C = null;
	/* Column Info */
	private String orgTrnsMode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String copyCnt = null;
	/* Column Info */
	private String bkgOfc = null;
	/* Column Info */
	private String fRt = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String pod3N = null;
	/* Column Info */
	private String pcMode = null;
	/* Column Info */
	private String pol2N = null;
	/* Column Info */
	private String comBkgNo = null;
	/* Column Info */
	private String subF = null;
	/* Column Info */
	private String lane4 = null;
	/* Column Info */
	private String ocnSeq = null;
	/* Column Info */
	private String pod1C = null;
	/* Column Info */
	private String pol2C = null;
	/* Column Info */
	private String hitchment = null;
	/* Column Info */
	private String lane2 = null;
	/* Column Info */
	private String lane3 = null;
	/* Column Info */
	private String parentBkgNo = null;
	/* Column Info */
	private String lane1 = null;
	/* Column Info */
	private String rfF = null;
	/* Column Info */
	private String dgF = null;
	/* Column Info */
	private String cgoTp = null;
	/* Column Info */
	private String shpr = null;
	/* Column Info */
	private String pol1N = null;
	/* Column Info */
	private String flexHgtFlg = null;
	/* Column Info */
	private String idaHlgTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PrdMainInfoVO() {}

	public PrdMainInfoVO(String ibflag, String pagerows, String fCmd, String pcMode, String bkgNo, String tVvd, String rcvT, String delT, String por, String porN, String pol, String polN, String pod, String podN, String del, String delN, String pod1, String pod1N, String pod1C, String pol1, String pol1N, String pol1C, String vvd1, String lane1, String pod2, String pod2N, String pod2C, String pol2, String pol2N, String pol2C, String vvd2, String lane2, String pod3, String pod3N, String pod3C, String pol3, String pol3N, String pol3C, String vvd3, String lane3, String pod4, String pod4N, String pod4C, String pol4, String pol4N, String pol4C, String vvd4, String lane4, String ldDt, String drDt, String mtPkupDt, String mPu, String fRt, String orgTrnsMode, String destTrnsMode, String cgoTp, String pmF, String dgF, String rfF, String akF, String bbF, String rdF, String socF, String com, String repCom, String bkgOfc, String orgSalOfc, String wgt, String wgtUn, String hgF, String subF, String rfa, String sc, String rfaOfc, String scOfc, String shpr, String cngn, String imdg, String comBkgNo, String hitchment, String parentBkgNo, String copyCnt, String ocnSeq, String flexHgtFlg, String idaHlgTpCd) {
		this.pod2C = pod2C;
		this.com = com;
		this.ldDt = ldDt;
		this.fCmd = fCmd;
		this.por = por;
		this.rcvT = rcvT;
		this.polN = polN;
		this.pol1C = pol1C;
		this.pmF = pmF;
		this.pagerows = pagerows;
		this.tVvd = tVvd;
		this.wgt = wgt;
		this.rfaOfc = rfaOfc;
		this.pod1N = pod1N;
		this.podN = podN;
		this.porN = porN;
		this.pol = pol;
		this.pol4N = pol4N;
		this.orgSalOfc = orgSalOfc;
		this.pod = pod;
		this.pod3C = pod3C;
		this.wgtUn = wgtUn;
		this.pol4C = pol4C;
		this.bbF = bbF;
		this.pol4 = pol4;
		this.sc = sc;
		this.pol3 = pol3;
		this.scOfc = scOfc;
		this.pol2 = pol2;
		this.hgF = hgF;
		this.pol1 = pol1;
		this.repCom = repCom;
		this.drDt = drDt;
		this.vvd2 = vvd2;
		this.cngn = cngn;
		this.akF = akF;
		this.vvd3 = vvd3;
		this.socF = socF;
		this.destTrnsMode = destTrnsMode;
		this.vvd1 = vvd1;
		this.pod2 = pod2;
		this.pol3N = pol3N;
		this.pod1 = pod1;
		this.bkgNo = bkgNo;
		this.pod4 = pod4;
		this.pod3 = pod3;
		this.vvd4 = vvd4;
		this.pod2N = pod2N;
		this.mPu = mPu;
		this.rdF = rdF;
		this.mtPkupDt = mtPkupDt;
		this.delN = delN;
		this.pod4N = pod4N;
		this.pol3C = pol3C;
		this.rfa = rfa;
		this.imdg = imdg;
		this.delT = delT;
		this.pod4C = pod4C;
		this.orgTrnsMode = orgTrnsMode;
		this.ibflag = ibflag;
		this.copyCnt = copyCnt;
		this.bkgOfc = bkgOfc;
		this.fRt = fRt;
		this.del = del;
		this.pod3N = pod3N;
		this.pcMode = pcMode;
		this.pol2N = pol2N;
		this.comBkgNo = comBkgNo;
		this.subF = subF;
		this.lane4 = lane4;
		this.ocnSeq = ocnSeq;
		this.pod1C = pod1C;
		this.pol2C = pol2C;
		this.hitchment = hitchment;
		this.lane2 = lane2;
		this.lane3 = lane3;
		this.parentBkgNo = parentBkgNo;
		this.lane1 = lane1;
		this.rfF = rfF;
		this.dgF = dgF;
		this.cgoTp = cgoTp;
		this.shpr = shpr;
		this.pol1N = pol1N;
		this.flexHgtFlg = flexHgtFlg;		
		this.idaHlgTpCd = idaHlgTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod2_c", getPod2C());
		this.hashColumns.put("com", getCom());
		this.hashColumns.put("ld_dt", getLdDt());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("rcv_t", getRcvT());
		this.hashColumns.put("pol_n", getPolN());
		this.hashColumns.put("pol1_c", getPol1C());
		this.hashColumns.put("pm_f", getPmF());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("rfa_ofc", getRfaOfc());
		this.hashColumns.put("pod1_n", getPod1N());
		this.hashColumns.put("pod_n", getPodN());
		this.hashColumns.put("por_n", getPorN());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pol4_n", getPol4N());
		this.hashColumns.put("org_sal_ofc", getOrgSalOfc());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pod3_c", getPod3C());
		this.hashColumns.put("wgt_un", getWgtUn());
		this.hashColumns.put("pol4_c", getPol4C());
		this.hashColumns.put("bb_f", getBbF());
		this.hashColumns.put("pol4", getPol4());
		this.hashColumns.put("sc", getSc());
		this.hashColumns.put("pol3", getPol3());
		this.hashColumns.put("sc_ofc", getScOfc());
		this.hashColumns.put("pol2", getPol2());
		this.hashColumns.put("hg_f", getHgF());
		this.hashColumns.put("pol1", getPol1());
		this.hashColumns.put("rep_com", getRepCom());
		this.hashColumns.put("dr_dt", getDrDt());
		this.hashColumns.put("vvd2", getVvd2());
		this.hashColumns.put("cngn", getCngn());
		this.hashColumns.put("ak_f", getAkF());
		this.hashColumns.put("vvd3", getVvd3());
		this.hashColumns.put("soc_f", getSocF());
		this.hashColumns.put("dest_trns_mode", getDestTrnsMode());
		this.hashColumns.put("vvd1", getVvd1());
		this.hashColumns.put("pod2", getPod2());
		this.hashColumns.put("pol3_n", getPol3N());
		this.hashColumns.put("pod1", getPod1());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pod4", getPod4());
		this.hashColumns.put("pod3", getPod3());
		this.hashColumns.put("vvd4", getVvd4());
		this.hashColumns.put("pod2_n", getPod2N());
		this.hashColumns.put("m_pu", getMPu());
		this.hashColumns.put("rd_f", getRdF());
		this.hashColumns.put("mt_pkup_dt", getMtPkupDt());
		this.hashColumns.put("del_n", getDelN());
		this.hashColumns.put("pod4_n", getPod4N());
		this.hashColumns.put("pol3_c", getPol3C());
		this.hashColumns.put("rfa", getRfa());
		this.hashColumns.put("imdg", getImdg());
		this.hashColumns.put("del_t", getDelT());
		this.hashColumns.put("pod4_c", getPod4C());
		this.hashColumns.put("org_trns_mode", getOrgTrnsMode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("copy_cnt", getCopyCnt());
		this.hashColumns.put("bkg_ofc", getBkgOfc());
		this.hashColumns.put("f_rt", getFRt());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("pod3_n", getPod3N());
		this.hashColumns.put("pc_mode", getPcMode());
		this.hashColumns.put("pol2_n", getPol2N());
		this.hashColumns.put("com_bkg_no", getComBkgNo());
		this.hashColumns.put("sub_f", getSubF());
		this.hashColumns.put("lane4", getLane4());
		this.hashColumns.put("ocn_seq", getOcnSeq());
		this.hashColumns.put("pod1_c", getPod1C());
		this.hashColumns.put("pol2_c", getPol2C());
		this.hashColumns.put("hitchment", getHitchment());
		this.hashColumns.put("lane2", getLane2());
		this.hashColumns.put("lane3", getLane3());
		this.hashColumns.put("parent_bkg_no", getParentBkgNo());
		this.hashColumns.put("lane1", getLane1());
		this.hashColumns.put("rf_f", getRfF());
		this.hashColumns.put("dg_f", getDgF());
		this.hashColumns.put("cgo_tp", getCgoTp());
		this.hashColumns.put("shpr", getShpr());
		this.hashColumns.put("pol1_n", getPol1N());
		this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
		this.hashColumns.put("ida_hlg_tp_cd", getIdaHlgTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod2_c", "pod2C");
		this.hashFields.put("com", "com");
		this.hashFields.put("ld_dt", "ldDt");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("por", "por");
		this.hashFields.put("rcv_t", "rcvT");
		this.hashFields.put("pol_n", "polN");
		this.hashFields.put("pol1_c", "pol1C");
		this.hashFields.put("pm_f", "pmF");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("rfa_ofc", "rfaOfc");
		this.hashFields.put("pod1_n", "pod1N");
		this.hashFields.put("pod_n", "podN");
		this.hashFields.put("por_n", "porN");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pol4_n", "pol4N");
		this.hashFields.put("org_sal_ofc", "orgSalOfc");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pod3_c", "pod3C");
		this.hashFields.put("wgt_un", "wgtUn");
		this.hashFields.put("pol4_c", "pol4C");
		this.hashFields.put("bb_f", "bbF");
		this.hashFields.put("pol4", "pol4");
		this.hashFields.put("sc", "sc");
		this.hashFields.put("pol3", "pol3");
		this.hashFields.put("sc_ofc", "scOfc");
		this.hashFields.put("pol2", "pol2");
		this.hashFields.put("hg_f", "hgF");
		this.hashFields.put("pol1", "pol1");
		this.hashFields.put("rep_com", "repCom");
		this.hashFields.put("dr_dt", "drDt");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("cngn", "cngn");
		this.hashFields.put("ak_f", "akF");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("soc_f", "socF");
		this.hashFields.put("dest_trns_mode", "destTrnsMode");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("pod2", "pod2");
		this.hashFields.put("pol3_n", "pol3N");
		this.hashFields.put("pod1", "pod1");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pod4", "pod4");
		this.hashFields.put("pod3", "pod3");
		this.hashFields.put("vvd4", "vvd4");
		this.hashFields.put("pod2_n", "pod2N");
		this.hashFields.put("m_pu", "mPu");
		this.hashFields.put("rd_f", "rdF");
		this.hashFields.put("mt_pkup_dt", "mtPkupDt");
		this.hashFields.put("del_n", "delN");
		this.hashFields.put("pod4_n", "pod4N");
		this.hashFields.put("pol3_c", "pol3C");
		this.hashFields.put("rfa", "rfa");
		this.hashFields.put("imdg", "imdg");
		this.hashFields.put("del_t", "delT");
		this.hashFields.put("pod4_c", "pod4C");
		this.hashFields.put("org_trns_mode", "orgTrnsMode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("copy_cnt", "copyCnt");
		this.hashFields.put("bkg_ofc", "bkgOfc");
		this.hashFields.put("f_rt", "fRt");
		this.hashFields.put("del", "del");
		this.hashFields.put("pod3_n", "pod3N");
		this.hashFields.put("pc_mode", "pcMode");
		this.hashFields.put("pol2_n", "pol2N");
		this.hashFields.put("com_bkg_no", "comBkgNo");
		this.hashFields.put("sub_f", "subF");
		this.hashFields.put("lane4", "lane4");
		this.hashFields.put("ocn_seq", "ocnSeq");
		this.hashFields.put("pod1_c", "pod1C");
		this.hashFields.put("pol2_c", "pol2C");
		this.hashFields.put("hitchment", "hitchment");
		this.hashFields.put("lane2", "lane2");
		this.hashFields.put("lane3", "lane3");
		this.hashFields.put("parent_bkg_no", "parentBkgNo");
		this.hashFields.put("lane1", "lane1");
		this.hashFields.put("rf_f", "rfF");
		this.hashFields.put("dg_f", "dgF");
		this.hashFields.put("cgo_tp", "cgoTp");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("pol1_n", "pol1N");
		this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
		this.hashFields.put("ida_hlg_tp_cd", "idaHlgTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pod2C
	 */
	public String getPod2C() {
		return this.pod2C;
	}
	
	/**
	 * Column Info
	 * @return com
	 */
	public String getCom() {
		return this.com;
	}
	
	/**
	 * Column Info
	 * @return ldDt
	 */
	public String getLdDt() {
		return this.ldDt;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return rcvT
	 */
	public String getRcvT() {
		return this.rcvT;
	}
	
	/**
	 * Column Info
	 * @return polN
	 */
	public String getPolN() {
		return this.polN;
	}
	
	/**
	 * Column Info
	 * @return pol1C
	 */
	public String getPol1C() {
		return this.pol1C;
	}
	
	/**
	 * Column Info
	 * @return pmF
	 */
	public String getPmF() {
		return this.pmF;
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
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
	}
	
	/**
	 * Column Info
	 * @return rfaOfc
	 */
	public String getRfaOfc() {
		return this.rfaOfc;
	}
	
	/**
	 * Column Info
	 * @return pod1N
	 */
	public String getPod1N() {
		return this.pod1N;
	}
	
	/**
	 * Column Info
	 * @return podN
	 */
	public String getPodN() {
		return this.podN;
	}
	
	/**
	 * Column Info
	 * @return porN
	 */
	public String getPorN() {
		return this.porN;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return pol4N
	 */
	public String getPol4N() {
		return this.pol4N;
	}
	
	/**
	 * Column Info
	 * @return orgSalOfc
	 */
	public String getOrgSalOfc() {
		return this.orgSalOfc;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return pod3C
	 */
	public String getPod3C() {
		return this.pod3C;
	}
	
	/**
	 * Column Info
	 * @return wgtUn
	 */
	public String getWgtUn() {
		return this.wgtUn;
	}
	
	/**
	 * Column Info
	 * @return pol4C
	 */
	public String getPol4C() {
		return this.pol4C;
	}
	
	/**
	 * Column Info
	 * @return bbF
	 */
	public String getBbF() {
		return this.bbF;
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
	 * @return sc
	 */
	public String getSc() {
		return this.sc;
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
	 * @return scOfc
	 */
	public String getScOfc() {
		return this.scOfc;
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
	 * @return hgF
	 */
	public String getHgF() {
		return this.hgF;
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
	 * @return repCom
	 */
	public String getRepCom() {
		return this.repCom;
	}
	
	/**
	 * Column Info
	 * @return drDt
	 */
	public String getDrDt() {
		return this.drDt;
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
	 * @return cngn
	 */
	public String getCngn() {
		return this.cngn;
	}
	
	/**
	 * Column Info
	 * @return akF
	 */
	public String getAkF() {
		return this.akF;
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
	 * @return socF
	 */
	public String getSocF() {
		return this.socF;
	}
	
	/**
	 * Column Info
	 * @return destTrnsMode
	 */
	public String getDestTrnsMode() {
		return this.destTrnsMode;
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
	 * @return pod2
	 */
	public String getPod2() {
		return this.pod2;
	}
	
	/**
	 * Column Info
	 * @return pol3N
	 */
	public String getPol3N() {
		return this.pol3N;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return pod2N
	 */
	public String getPod2N() {
		return this.pod2N;
	}
	
	/**
	 * Column Info
	 * @return mPu
	 */
	public String getMPu() {
		return this.mPu;
	}
	
	/**
	 * Column Info
	 * @return rdF
	 */
	public String getRdF() {
		return this.rdF;
	}
	
	/**
	 * Column Info
	 * @return mtPkupDt
	 */
	public String getMtPkupDt() {
		return this.mtPkupDt;
	}
	
	/**
	 * Column Info
	 * @return delN
	 */
	public String getDelN() {
		return this.delN;
	}
	
	/**
	 * Column Info
	 * @return pod4N
	 */
	public String getPod4N() {
		return this.pod4N;
	}
	
	/**
	 * Column Info
	 * @return pol3C
	 */
	public String getPol3C() {
		return this.pol3C;
	}
	
	/**
	 * Column Info
	 * @return rfa
	 */
	public String getRfa() {
		return this.rfa;
	}
	
	/**
	 * Column Info
	 * @return imdg
	 */
	public String getImdg() {
		return this.imdg;
	}
	
	/**
	 * Column Info
	 * @return delT
	 */
	public String getDelT() {
		return this.delT;
	}
	
	/**
	 * Column Info
	 * @return pod4C
	 */
	public String getPod4C() {
		return this.pod4C;
	}
	
	/**
	 * Column Info
	 * @return orgTrnsMode
	 */
	public String getOrgTrnsMode() {
		return this.orgTrnsMode;
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
	 * @return copyCnt
	 */
	public String getCopyCnt() {
		return this.copyCnt;
	}
	
	/**
	 * Column Info
	 * @return bkgOfc
	 */
	public String getBkgOfc() {
		return this.bkgOfc;
	}
	
	/**
	 * Column Info
	 * @return fRt
	 */
	public String getFRt() {
		return this.fRt;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return pod3N
	 */
	public String getPod3N() {
		return this.pod3N;
	}
	
	/**
	 * Column Info
	 * @return pcMode
	 */
	public String getPcMode() {
		return this.pcMode;
	}
	
	/**
	 * Column Info
	 * @return pol2N
	 */
	public String getPol2N() {
		return this.pol2N;
	}
	
	/**
	 * Column Info
	 * @return comBkgNo
	 */
	public String getComBkgNo() {
		return this.comBkgNo;
	}
	
	/**
	 * Column Info
	 * @return subF
	 */
	public String getSubF() {
		return this.subF;
	}
	
	/**
	 * Column Info
	 * @return lane4
	 */
	public String getLane4() {
		return this.lane4;
	}
	
	/**
	 * Column Info
	 * @return ocnSeq
	 */
	public String getOcnSeq() {
		return this.ocnSeq;
	}
	
	/**
	 * Column Info
	 * @return pod1C
	 */
	public String getPod1C() {
		return this.pod1C;
	}
	
	/**
	 * Column Info
	 * @return pol2C
	 */
	public String getPol2C() {
		return this.pol2C;
	}
	
	/**
	 * Column Info
	 * @return hitchment
	 */
	public String getHitchment() {
		return this.hitchment;
	}
	
	/**
	 * Column Info
	 * @return lane2
	 */
	public String getLane2() {
		return this.lane2;
	}
	
	/**
	 * Column Info
	 * @return lane3
	 */
	public String getLane3() {
		return this.lane3;
	}
	
	/**
	 * Column Info
	 * @return parentBkgNo
	 */
	public String getParentBkgNo() {
		return this.parentBkgNo;
	}
	
	/**
	 * Column Info
	 * @return lane1
	 */
	public String getLane1() {
		return this.lane1;
	}
	
	/**
	 * Column Info
	 * @return rfF
	 */
	public String getRfF() {
		return this.rfF;
	}
	
	/**
	 * Column Info
	 * @return dgF
	 */
	public String getDgF() {
		return this.dgF;
	}
	
	/**
	 * Column Info
	 * @return cgoTp
	 */
	public String getCgoTp() {
		return this.cgoTp;
	}
	
	/**
	 * Column Info
	 * @return shpr
	 */
	public String getShpr() {
		return this.shpr;
	}
	
	/**
	 * Column Info
	 * @return pol1N
	 */
	public String getPol1N() {
		return this.pol1N;
	}
	
	/**
	 * Column Info
	 * @return the flexHgtFlg
	 */
	public String getFlexHgtFlg() {
		return flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @return the idaHlgTpCd
	 */
	public String getIdaHlgTpCd() {
		return idaHlgTpCd;
	}

	/**
	 * Column Info
	 * @param pod2C
	 */
	public void setPod2C(String pod2C) {
		this.pod2C = pod2C;
	}
	
	/**
	 * Column Info
	 * @param com
	 */
	public void setCom(String com) {
		this.com = com;
	}
	
	/**
	 * Column Info
	 * @param ldDt
	 */
	public void setLdDt(String ldDt) {
		this.ldDt = ldDt;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param rcvT
	 */
	public void setRcvT(String rcvT) {
		this.rcvT = rcvT;
	}
	
	/**
	 * Column Info
	 * @param polN
	 */
	public void setPolN(String polN) {
		this.polN = polN;
	}
	
	/**
	 * Column Info
	 * @param pol1C
	 */
	public void setPol1C(String pol1C) {
		this.pol1C = pol1C;
	}
	
	/**
	 * Column Info
	 * @param pmF
	 */
	public void setPmF(String pmF) {
		this.pmF = pmF;
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
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	
	/**
	 * Column Info
	 * @param rfaOfc
	 */
	public void setRfaOfc(String rfaOfc) {
		this.rfaOfc = rfaOfc;
	}
	
	/**
	 * Column Info
	 * @param pod1N
	 */
	public void setPod1N(String pod1N) {
		this.pod1N = pod1N;
	}
	
	/**
	 * Column Info
	 * @param podN
	 */
	public void setPodN(String podN) {
		this.podN = podN;
	}
	
	/**
	 * Column Info
	 * @param porN
	 */
	public void setPorN(String porN) {
		this.porN = porN;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param pol4N
	 */
	public void setPol4N(String pol4N) {
		this.pol4N = pol4N;
	}
	
	/**
	 * Column Info
	 * @param orgSalOfc
	 */
	public void setOrgSalOfc(String orgSalOfc) {
		this.orgSalOfc = orgSalOfc;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param pod3C
	 */
	public void setPod3C(String pod3C) {
		this.pod3C = pod3C;
	}
	
	/**
	 * Column Info
	 * @param wgtUn
	 */
	public void setWgtUn(String wgtUn) {
		this.wgtUn = wgtUn;
	}
	
	/**
	 * Column Info
	 * @param pol4C
	 */
	public void setPol4C(String pol4C) {
		this.pol4C = pol4C;
	}
	
	/**
	 * Column Info
	 * @param bbF
	 */
	public void setBbF(String bbF) {
		this.bbF = bbF;
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
	 * @param sc
	 */
	public void setSc(String sc) {
		this.sc = sc;
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
	 * @param scOfc
	 */
	public void setScOfc(String scOfc) {
		this.scOfc = scOfc;
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
	 * @param hgF
	 */
	public void setHgF(String hgF) {
		this.hgF = hgF;
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
	 * @param repCom
	 */
	public void setRepCom(String repCom) {
		this.repCom = repCom;
	}
	
	/**
	 * Column Info
	 * @param drDt
	 */
	public void setDrDt(String drDt) {
		this.drDt = drDt;
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
	 * @param cngn
	 */
	public void setCngn(String cngn) {
		this.cngn = cngn;
	}
	
	/**
	 * Column Info
	 * @param akF
	 */
	public void setAkF(String akF) {
		this.akF = akF;
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
	 * @param socF
	 */
	public void setSocF(String socF) {
		this.socF = socF;
	}
	
	/**
	 * Column Info
	 * @param destTrnsMode
	 */
	public void setDestTrnsMode(String destTrnsMode) {
		this.destTrnsMode = destTrnsMode;
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
	 * @param pod2
	 */
	public void setPod2(String pod2) {
		this.pod2 = pod2;
	}
	
	/**
	 * Column Info
	 * @param pol3N
	 */
	public void setPol3N(String pol3N) {
		this.pol3N = pol3N;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param pod2N
	 */
	public void setPod2N(String pod2N) {
		this.pod2N = pod2N;
	}
	
	/**
	 * Column Info
	 * @param mPu
	 */
	public void setMPu(String mPu) {
		this.mPu = mPu;
	}
	
	/**
	 * Column Info
	 * @param rdF
	 */
	public void setRdF(String rdF) {
		this.rdF = rdF;
	}
	
	/**
	 * Column Info
	 * @param mtPkupDt
	 */
	public void setMtPkupDt(String mtPkupDt) {
		this.mtPkupDt = mtPkupDt;
	}
	
	/**
	 * Column Info
	 * @param delN
	 */
	public void setDelN(String delN) {
		this.delN = delN;
	}
	
	/**
	 * Column Info
	 * @param pod4N
	 */
	public void setPod4N(String pod4N) {
		this.pod4N = pod4N;
	}
	
	/**
	 * Column Info
	 * @param pol3C
	 */
	public void setPol3C(String pol3C) {
		this.pol3C = pol3C;
	}
	
	/**
	 * Column Info
	 * @param rfa
	 */
	public void setRfa(String rfa) {
		this.rfa = rfa;
	}
	
	/**
	 * Column Info
	 * @param imdg
	 */
	public void setImdg(String imdg) {
		this.imdg = imdg;
	}
	
	/**
	 * Column Info
	 * @param delT
	 */
	public void setDelT(String delT) {
		this.delT = delT;
	}
	
	/**
	 * Column Info
	 * @param pod4C
	 */
	public void setPod4C(String pod4C) {
		this.pod4C = pod4C;
	}
	
	/**
	 * Column Info
	 * @param orgTrnsMode
	 */
	public void setOrgTrnsMode(String orgTrnsMode) {
		this.orgTrnsMode = orgTrnsMode;
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
	 * @param copyCnt
	 */
	public void setCopyCnt(String copyCnt) {
		this.copyCnt = copyCnt;
	}
	
	/**
	 * Column Info
	 * @param bkgOfc
	 */
	public void setBkgOfc(String bkgOfc) {
		this.bkgOfc = bkgOfc;
	}
	
	/**
	 * Column Info
	 * @param fRt
	 */
	public void setFRt(String fRt) {
		this.fRt = fRt;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param pod3N
	 */
	public void setPod3N(String pod3N) {
		this.pod3N = pod3N;
	}
	
	/**
	 * Column Info
	 * @param pcMode
	 */
	public void setPcMode(String pcMode) {
		this.pcMode = pcMode;
	}
	
	/**
	 * Column Info
	 * @param pol2N
	 */
	public void setPol2N(String pol2N) {
		this.pol2N = pol2N;
	}
	
	/**
	 * Column Info
	 * @param comBkgNo
	 */
	public void setComBkgNo(String comBkgNo) {
		this.comBkgNo = comBkgNo;
	}
	
	/**
	 * Column Info
	 * @param subF
	 */
	public void setSubF(String subF) {
		this.subF = subF;
	}
	
	/**
	 * Column Info
	 * @param lane4
	 */
	public void setLane4(String lane4) {
		this.lane4 = lane4;
	}
	
	/**
	 * Column Info
	 * @param ocnSeq
	 */
	public void setOcnSeq(String ocnSeq) {
		this.ocnSeq = ocnSeq;
	}
	
	/**
	 * Column Info
	 * @param pod1C
	 */
	public void setPod1C(String pod1C) {
		this.pod1C = pod1C;
	}
	
	/**
	 * Column Info
	 * @param pol2C
	 */
	public void setPol2C(String pol2C) {
		this.pol2C = pol2C;
	}
	
	/**
	 * Column Info
	 * @param hitchment
	 */
	public void setHitchment(String hitchment) {
		this.hitchment = hitchment;
	}
	
	/**
	 * Column Info
	 * @param lane2
	 */
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}
	
	/**
	 * Column Info
	 * @param lane3
	 */
	public void setLane3(String lane3) {
		this.lane3 = lane3;
	}
	
	/**
	 * Column Info
	 * @param parentBkgNo
	 */
	public void setParentBkgNo(String parentBkgNo) {
		this.parentBkgNo = parentBkgNo;
	}
	
	/**
	 * Column Info
	 * @param lane1
	 */
	public void setLane1(String lane1) {
		this.lane1 = lane1;
	}
	
	/**
	 * Column Info
	 * @param rfF
	 */
	public void setRfF(String rfF) {
		this.rfF = rfF;
	}
	
	/**
	 * Column Info
	 * @param dgF
	 */
	public void setDgF(String dgF) {
		this.dgF = dgF;
	}
	
	/**
	 * Column Info
	 * @param cgoTp
	 */
	public void setCgoTp(String cgoTp) {
		this.cgoTp = cgoTp;
	}
	
	/**
	 * Column Info
	 * @param shpr
	 */
	public void setShpr(String shpr) {
		this.shpr = shpr;
	}
	
	/**
	 * Column Info
	 * @param pol1N
	 */
	public void setPol1N(String pol1N) {
		this.pol1N = pol1N;
	}

	/**
	 * Column Info
	 * @param flexHgtFlg the flexHgtFlg to set
	 */
	public void setFlexHgtFlg(String flexHgtFlg) {
		this.flexHgtFlg = flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @param idaHlgTpCd
	 */
	public void setIdaHlgTpCd(String idaHlgTpCd) {
		this.idaHlgTpCd = idaHlgTpCd;
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
		setPod2C(JSPUtil.getParameter(request, prefix + "pod2_c", ""));
		setCom(JSPUtil.getParameter(request, prefix + "com", ""));
		setLdDt(JSPUtil.getParameter(request, prefix + "ld_dt", ""));
		setFCmd(JSPUtil.getParameter(request, prefix + "f_cmd", ""));
		setPor(JSPUtil.getParameter(request, prefix + "por", ""));
		setRcvT(JSPUtil.getParameter(request, prefix + "rcv_t", ""));
		setPolN(JSPUtil.getParameter(request, prefix + "pol_n", ""));
		setPol1C(JSPUtil.getParameter(request, prefix + "pol1_c", ""));
		setPmF(JSPUtil.getParameter(request, prefix + "pm_f", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setWgt(JSPUtil.getParameter(request, prefix + "wgt", ""));
		setRfaOfc(JSPUtil.getParameter(request, prefix + "rfa_ofc", ""));
		setPod1N(JSPUtil.getParameter(request, prefix + "pod1_n", ""));
		setPodN(JSPUtil.getParameter(request, prefix + "pod_n", ""));
		setPorN(JSPUtil.getParameter(request, prefix + "por_n", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setPol4N(JSPUtil.getParameter(request, prefix + "pol4_n", ""));
		setOrgSalOfc(JSPUtil.getParameter(request, prefix + "org_sal_ofc", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setPod3C(JSPUtil.getParameter(request, prefix + "pod3_c", ""));
		setWgtUn(JSPUtil.getParameter(request, prefix + "wgt_un", ""));
		setPol4C(JSPUtil.getParameter(request, prefix + "pol4_c", ""));
		setBbF(JSPUtil.getParameter(request, prefix + "bb_f", ""));
		setPol4(JSPUtil.getParameter(request, prefix + "pol4", ""));
		setSc(JSPUtil.getParameter(request, prefix + "sc", ""));
		setPol3(JSPUtil.getParameter(request, prefix + "pol3", ""));
		setScOfc(JSPUtil.getParameter(request, prefix + "sc_ofc", ""));
		setPol2(JSPUtil.getParameter(request, prefix + "pol2", ""));
		setHgF(JSPUtil.getParameter(request, prefix + "hg_f", ""));
		setPol1(JSPUtil.getParameter(request, prefix + "pol1", ""));
		setRepCom(JSPUtil.getParameter(request, prefix + "rep_com", ""));
		setDrDt(JSPUtil.getParameter(request, prefix + "dr_dt", ""));
		setVvd2(JSPUtil.getParameter(request, prefix + "vvd2", ""));
		setCngn(JSPUtil.getParameter(request, prefix + "cngn", ""));
		setAkF(JSPUtil.getParameter(request, prefix + "ak_f", ""));
		setVvd3(JSPUtil.getParameter(request, prefix + "vvd3", ""));
		setSocF(JSPUtil.getParameter(request, prefix + "soc_f", ""));
		setDestTrnsMode(JSPUtil.getParameter(request, prefix + "dest_trns_mode", ""));
		setVvd1(JSPUtil.getParameter(request, prefix + "vvd1", ""));
		setPod2(JSPUtil.getParameter(request, prefix + "pod2", ""));
		setPol3N(JSPUtil.getParameter(request, prefix + "pol3_n", ""));
		setPod1(JSPUtil.getParameter(request, prefix + "pod1", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPod4(JSPUtil.getParameter(request, prefix + "pod4", ""));
		setPod3(JSPUtil.getParameter(request, prefix + "pod3", ""));
		setVvd4(JSPUtil.getParameter(request, prefix + "vvd4", ""));
		setPod2N(JSPUtil.getParameter(request, prefix + "pod2_n", ""));
		setMPu(JSPUtil.getParameter(request, prefix + "m_pu", ""));
		setRdF(JSPUtil.getParameter(request, prefix + "rd_f", ""));
		setMtPkupDt(JSPUtil.getParameter(request, prefix + "mt_pkup_dt", ""));
		setDelN(JSPUtil.getParameter(request, prefix + "del_n", ""));
		setPod4N(JSPUtil.getParameter(request, prefix + "pod4_n", ""));
		setPol3C(JSPUtil.getParameter(request, prefix + "pol3_c", ""));
		setRfa(JSPUtil.getParameter(request, prefix + "rfa", ""));
		setImdg(JSPUtil.getParameter(request, prefix + "imdg", ""));
		setDelT(JSPUtil.getParameter(request, prefix + "del_t", ""));
		setPod4C(JSPUtil.getParameter(request, prefix + "pod4_c", ""));
		setOrgTrnsMode(JSPUtil.getParameter(request, prefix + "org_trns_mode", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCopyCnt(JSPUtil.getParameter(request, prefix + "copy_cnt", ""));
		setBkgOfc(JSPUtil.getParameter(request, prefix + "bkg_ofc", ""));
		setFRt(JSPUtil.getParameter(request, prefix + "f_rt", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setPod3N(JSPUtil.getParameter(request, prefix + "pod3_n", ""));
		setPcMode(JSPUtil.getParameter(request, prefix + "pc_mode", ""));
		setPol2N(JSPUtil.getParameter(request, prefix + "pol2_n", ""));
		setComBkgNo(JSPUtil.getParameter(request, prefix + "com_bkg_no", ""));
		setSubF(JSPUtil.getParameter(request, prefix + "sub_f", ""));
		setLane4(JSPUtil.getParameter(request, prefix + "lane4", ""));
		setOcnSeq(JSPUtil.getParameter(request, prefix + "ocn_seq", ""));
		setPod1C(JSPUtil.getParameter(request, prefix + "pod1_c", ""));
		setPol2C(JSPUtil.getParameter(request, prefix + "pol2_c", ""));
		setHitchment(JSPUtil.getParameter(request, prefix + "hitchment", ""));
		setLane2(JSPUtil.getParameter(request, prefix + "lane2", ""));
		setLane3(JSPUtil.getParameter(request, prefix + "lane3", ""));
		setParentBkgNo(JSPUtil.getParameter(request, prefix + "parent_bkg_no", ""));
		setLane1(JSPUtil.getParameter(request, prefix + "lane1", ""));
		setRfF(JSPUtil.getParameter(request, prefix + "rf_f", ""));
		setDgF(JSPUtil.getParameter(request, prefix + "dg_f", ""));
		setCgoTp(JSPUtil.getParameter(request, prefix + "cgo_tp", ""));
		setShpr(JSPUtil.getParameter(request, prefix + "shpr", ""));
		setPol1N(JSPUtil.getParameter(request, prefix + "pol1_n", ""));
		setFlexHgtFlg(JSPUtil.getParameter(request, prefix + "flex_hgt_flg", ""));
		setIdaHlgTpCd(JSPUtil.getParameter(request, prefix + "ida_hlg_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdMainInfoVO[]
	 */
	public PrdMainInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrdMainInfoVO[]
	 */
	public PrdMainInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdMainInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pod2C = (JSPUtil.getParameter(request, prefix	+ "pod2_c", length));
			String[] com = (JSPUtil.getParameter(request, prefix	+ "com", length));
			String[] ldDt = (JSPUtil.getParameter(request, prefix	+ "ld_dt", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] rcvT = (JSPUtil.getParameter(request, prefix	+ "rcv_t", length));
			String[] polN = (JSPUtil.getParameter(request, prefix	+ "pol_n", length));
			String[] pol1C = (JSPUtil.getParameter(request, prefix	+ "pol1_c", length));
			String[] pmF = (JSPUtil.getParameter(request, prefix	+ "pm_f", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] rfaOfc = (JSPUtil.getParameter(request, prefix	+ "rfa_ofc", length));
			String[] pod1N = (JSPUtil.getParameter(request, prefix	+ "pod1_n", length));
			String[] podN = (JSPUtil.getParameter(request, prefix	+ "pod_n", length));
			String[] porN = (JSPUtil.getParameter(request, prefix	+ "por_n", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] pol4N = (JSPUtil.getParameter(request, prefix	+ "pol4_n", length));
			String[] orgSalOfc = (JSPUtil.getParameter(request, prefix	+ "org_sal_ofc", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] pod3C = (JSPUtil.getParameter(request, prefix	+ "pod3_c", length));
			String[] wgtUn = (JSPUtil.getParameter(request, prefix	+ "wgt_un", length));
			String[] pol4C = (JSPUtil.getParameter(request, prefix	+ "pol4_c", length));
			String[] bbF = (JSPUtil.getParameter(request, prefix	+ "bb_f", length));
			String[] pol4 = (JSPUtil.getParameter(request, prefix	+ "pol4", length));
			String[] sc = (JSPUtil.getParameter(request, prefix	+ "sc", length));
			String[] pol3 = (JSPUtil.getParameter(request, prefix	+ "pol3", length));
			String[] scOfc = (JSPUtil.getParameter(request, prefix	+ "sc_ofc", length));
			String[] pol2 = (JSPUtil.getParameter(request, prefix	+ "pol2", length));
			String[] hgF = (JSPUtil.getParameter(request, prefix	+ "hg_f", length));
			String[] pol1 = (JSPUtil.getParameter(request, prefix	+ "pol1", length));
			String[] repCom = (JSPUtil.getParameter(request, prefix	+ "rep_com", length));
			String[] drDt = (JSPUtil.getParameter(request, prefix	+ "dr_dt", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd2", length));
			String[] cngn = (JSPUtil.getParameter(request, prefix	+ "cngn", length));
			String[] akF = (JSPUtil.getParameter(request, prefix	+ "ak_f", length));
			String[] vvd3 = (JSPUtil.getParameter(request, prefix	+ "vvd3", length));
			String[] socF = (JSPUtil.getParameter(request, prefix	+ "soc_f", length));
			String[] destTrnsMode = (JSPUtil.getParameter(request, prefix	+ "dest_trns_mode", length));
			String[] vvd1 = (JSPUtil.getParameter(request, prefix	+ "vvd1", length));
			String[] pod2 = (JSPUtil.getParameter(request, prefix	+ "pod2", length));
			String[] pol3N = (JSPUtil.getParameter(request, prefix	+ "pol3_n", length));
			String[] pod1 = (JSPUtil.getParameter(request, prefix	+ "pod1", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] pod4 = (JSPUtil.getParameter(request, prefix	+ "pod4", length));
			String[] pod3 = (JSPUtil.getParameter(request, prefix	+ "pod3", length));
			String[] vvd4 = (JSPUtil.getParameter(request, prefix	+ "vvd4", length));
			String[] pod2N = (JSPUtil.getParameter(request, prefix	+ "pod2_n", length));
			String[] mPu = (JSPUtil.getParameter(request, prefix	+ "m_pu", length));
			String[] rdF = (JSPUtil.getParameter(request, prefix	+ "rd_f", length));
			String[] mtPkupDt = (JSPUtil.getParameter(request, prefix	+ "mt_pkup_dt", length));
			String[] delN = (JSPUtil.getParameter(request, prefix	+ "del_n", length));
			String[] pod4N = (JSPUtil.getParameter(request, prefix	+ "pod4_n", length));
			String[] pol3C = (JSPUtil.getParameter(request, prefix	+ "pol3_c", length));
			String[] rfa = (JSPUtil.getParameter(request, prefix	+ "rfa", length));
			String[] imdg = (JSPUtil.getParameter(request, prefix	+ "imdg", length));
			String[] delT = (JSPUtil.getParameter(request, prefix	+ "del_t", length));
			String[] pod4C = (JSPUtil.getParameter(request, prefix	+ "pod4_c", length));
			String[] orgTrnsMode = (JSPUtil.getParameter(request, prefix	+ "org_trns_mode", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] copyCnt = (JSPUtil.getParameter(request, prefix	+ "copy_cnt", length));
			String[] bkgOfc = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc", length));
			String[] fRt = (JSPUtil.getParameter(request, prefix	+ "f_rt", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] pod3N = (JSPUtil.getParameter(request, prefix	+ "pod3_n", length));
			String[] pcMode = (JSPUtil.getParameter(request, prefix	+ "pc_mode", length));
			String[] pol2N = (JSPUtil.getParameter(request, prefix	+ "pol2_n", length));
			String[] comBkgNo = (JSPUtil.getParameter(request, prefix	+ "com_bkg_no", length));
			String[] subF = (JSPUtil.getParameter(request, prefix	+ "sub_f", length));
			String[] lane4 = (JSPUtil.getParameter(request, prefix	+ "lane4", length));
			String[] ocnSeq = (JSPUtil.getParameter(request, prefix	+ "ocn_seq", length));
			String[] pod1C = (JSPUtil.getParameter(request, prefix	+ "pod1_c", length));
			String[] pol2C = (JSPUtil.getParameter(request, prefix	+ "pol2_c", length));
			String[] hitchment = (JSPUtil.getParameter(request, prefix	+ "hitchment", length));
			String[] lane2 = (JSPUtil.getParameter(request, prefix	+ "lane2", length));
			String[] lane3 = (JSPUtil.getParameter(request, prefix	+ "lane3", length));
			String[] parentBkgNo = (JSPUtil.getParameter(request, prefix	+ "parent_bkg_no", length));
			String[] lane1 = (JSPUtil.getParameter(request, prefix	+ "lane1", length));
			String[] rfF = (JSPUtil.getParameter(request, prefix	+ "rf_f", length));
			String[] dgF = (JSPUtil.getParameter(request, prefix	+ "dg_f", length));
			String[] cgoTp = (JSPUtil.getParameter(request, prefix	+ "cgo_tp", length));
			String[] shpr = (JSPUtil.getParameter(request, prefix	+ "shpr", length));
			String[] pol1N = (JSPUtil.getParameter(request, prefix	+ "pol1_n", length));
			String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix	+ "flex_hgt_flg", length));
			String[] idaHlgTpCd = (JSPUtil.getParameter(request, prefix	+ "ida_hlg_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrdMainInfoVO();
				if (pod2C[i] != null)
					model.setPod2C(pod2C[i]);
				if (com[i] != null)
					model.setCom(com[i]);
				if (ldDt[i] != null)
					model.setLdDt(ldDt[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (rcvT[i] != null)
					model.setRcvT(rcvT[i]);
				if (polN[i] != null)
					model.setPolN(polN[i]);
				if (pol1C[i] != null)
					model.setPol1C(pol1C[i]);
				if (pmF[i] != null)
					model.setPmF(pmF[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (rfaOfc[i] != null)
					model.setRfaOfc(rfaOfc[i]);
				if (pod1N[i] != null)
					model.setPod1N(pod1N[i]);
				if (podN[i] != null)
					model.setPodN(podN[i]);
				if (porN[i] != null)
					model.setPorN(porN[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (pol4N[i] != null)
					model.setPol4N(pol4N[i]);
				if (orgSalOfc[i] != null)
					model.setOrgSalOfc(orgSalOfc[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pod3C[i] != null)
					model.setPod3C(pod3C[i]);
				if (wgtUn[i] != null)
					model.setWgtUn(wgtUn[i]);
				if (pol4C[i] != null)
					model.setPol4C(pol4C[i]);
				if (bbF[i] != null)
					model.setBbF(bbF[i]);
				if (pol4[i] != null)
					model.setPol4(pol4[i]);
				if (sc[i] != null)
					model.setSc(sc[i]);
				if (pol3[i] != null)
					model.setPol3(pol3[i]);
				if (scOfc[i] != null)
					model.setScOfc(scOfc[i]);
				if (pol2[i] != null)
					model.setPol2(pol2[i]);
				if (hgF[i] != null)
					model.setHgF(hgF[i]);
				if (pol1[i] != null)
					model.setPol1(pol1[i]);
				if (repCom[i] != null)
					model.setRepCom(repCom[i]);
				if (drDt[i] != null)
					model.setDrDt(drDt[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (cngn[i] != null)
					model.setCngn(cngn[i]);
				if (akF[i] != null)
					model.setAkF(akF[i]);
				if (vvd3[i] != null)
					model.setVvd3(vvd3[i]);
				if (socF[i] != null)
					model.setSocF(socF[i]);
				if (destTrnsMode[i] != null)
					model.setDestTrnsMode(destTrnsMode[i]);
				if (vvd1[i] != null)
					model.setVvd1(vvd1[i]);
				if (pod2[i] != null)
					model.setPod2(pod2[i]);
				if (pol3N[i] != null)
					model.setPol3N(pol3N[i]);
				if (pod1[i] != null)
					model.setPod1(pod1[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (pod4[i] != null)
					model.setPod4(pod4[i]);
				if (pod3[i] != null)
					model.setPod3(pod3[i]);
				if (vvd4[i] != null)
					model.setVvd4(vvd4[i]);
				if (pod2N[i] != null)
					model.setPod2N(pod2N[i]);
				if (mPu[i] != null)
					model.setMPu(mPu[i]);
				if (rdF[i] != null)
					model.setRdF(rdF[i]);
				if (mtPkupDt[i] != null)
					model.setMtPkupDt(mtPkupDt[i]);
				if (delN[i] != null)
					model.setDelN(delN[i]);
				if (pod4N[i] != null)
					model.setPod4N(pod4N[i]);
				if (pol3C[i] != null)
					model.setPol3C(pol3C[i]);
				if (rfa[i] != null)
					model.setRfa(rfa[i]);
				if (imdg[i] != null)
					model.setImdg(imdg[i]);
				if (delT[i] != null)
					model.setDelT(delT[i]);
				if (pod4C[i] != null)
					model.setPod4C(pod4C[i]);
				if (orgTrnsMode[i] != null)
					model.setOrgTrnsMode(orgTrnsMode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (copyCnt[i] != null)
					model.setCopyCnt(copyCnt[i]);
				if (bkgOfc[i] != null)
					model.setBkgOfc(bkgOfc[i]);
				if (fRt[i] != null)
					model.setFRt(fRt[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (pod3N[i] != null)
					model.setPod3N(pod3N[i]);
				if (pcMode[i] != null)
					model.setPcMode(pcMode[i]);
				if (pol2N[i] != null)
					model.setPol2N(pol2N[i]);
				if (comBkgNo[i] != null)
					model.setComBkgNo(comBkgNo[i]);
				if (subF[i] != null)
					model.setSubF(subF[i]);
				if (lane4[i] != null)
					model.setLane4(lane4[i]);
				if (ocnSeq[i] != null)
					model.setOcnSeq(ocnSeq[i]);
				if (pod1C[i] != null)
					model.setPod1C(pod1C[i]);
				if (pol2C[i] != null)
					model.setPol2C(pol2C[i]);
				if (hitchment[i] != null)
					model.setHitchment(hitchment[i]);
				if (lane2[i] != null)
					model.setLane2(lane2[i]);
				if (lane3[i] != null)
					model.setLane3(lane3[i]);
				if (parentBkgNo[i] != null)
					model.setParentBkgNo(parentBkgNo[i]);
				if (lane1[i] != null)
					model.setLane1(lane1[i]);
				if (rfF[i] != null)
					model.setRfF(rfF[i]);
				if (dgF[i] != null)
					model.setDgF(dgF[i]);
				if (cgoTp[i] != null)
					model.setCgoTp(cgoTp[i]);
				if (shpr[i] != null)
					model.setShpr(shpr[i]);
				if (pol1N[i] != null)
					model.setPol1N(pol1N[i]);
				if (flexHgtFlg[i] != null)
					model.setFlexHgtFlg(flexHgtFlg[i]);
				if (idaHlgTpCd[i] != null)
					model.setIdaHlgTpCd(idaHlgTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdMainInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrdMainInfoVO[]
	 */
	public PrdMainInfoVO[] getPrdMainInfoVOs(){
		PrdMainInfoVO[] vos = (PrdMainInfoVO[])models.toArray(new PrdMainInfoVO[models.size()]);
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
		this.pod2C = this.pod2C .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.com = this.com .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldDt = this.ldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvT = this.rcvT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polN = this.polN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1C = this.pol1C .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmF = this.pmF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaOfc = this.rfaOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1N = this.pod1N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podN = this.podN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porN = this.porN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4N = this.pol4N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSalOfc = this.orgSalOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3C = this.pod3C .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUn = this.wgtUn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4C = this.pol4C .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbF = this.bbF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol4 = this.pol4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sc = this.sc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3 = this.pol3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scOfc = this.scOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2 = this.pol2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hgF = this.hgF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1 = this.pol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCom = this.repCom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drDt = this.drDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngn = this.cngn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akF = this.akF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 = this.vvd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socF = this.socF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsMode = this.destTrnsMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 = this.vvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2 = this.pod2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3N = this.pol3N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1 = this.pod1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4 = this.pod4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3 = this.pod3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd4 = this.vvd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod2N = this.pod2N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mPu = this.mPu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdF = this.rdF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtPkupDt = this.mtPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delN = this.delN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4N = this.pod4N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol3C = this.pol3C .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfa = this.rfa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdg = this.imdg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delT = this.delT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod4C = this.pod4C .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgTrnsMode = this.orgTrnsMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copyCnt = this.copyCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfc = this.bkgOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fRt = this.fRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod3N = this.pod3N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcMode = this.pcMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2N = this.pol2N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comBkgNo = this.comBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subF = this.subF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane4 = this.lane4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ocnSeq = this.ocnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod1C = this.pod1C .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol2C = this.pol2C .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hitchment = this.hitchment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane2 = this.lane2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane3 = this.lane3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.parentBkgNo = this.parentBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane1 = this.lane1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfF = this.rfF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgF = this.dgF .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTp = this.cgoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr = this.shpr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol1N = this.pol1N .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flexHgtFlg = this.flexHgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaHlgTpCd = this.idaHlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
