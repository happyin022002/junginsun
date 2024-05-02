/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TroStatusListInVO.java
*@FileTitle : TroStatusListInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.09.07 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TroStatusListInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TroStatusListInVO> models = new ArrayList<TroStatusListInVO>();
	
	/* Column Info */
	private String p4 = null;
	/* Column Info */
	private String p2 = null;
	/* Column Info */
	private String z4 = null;
	/* Column Info */
	private String d9 = null;
	/* Column Info */
	private String d8 = null;
	/* Column Info */
	private String teuB = null;
	/* Column Info */
	private String z2 = null;
	/* Column Info */
	private String teuA = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String d7 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pkupYdCd = null;
	/* Column Info */
	private String bkgDtTo = null;
	/* Column Info */
	private String d2 = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String troDtFr = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String hLineType = null;
	/* Column Info */
	private String pkupLocCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String troSubSeq = null;
	/* Column Info */
	private String pupDtFr = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String pupDtTo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgDtFr = null;
	/* Column Info */
	private String dLineType = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String t4 = null;
	/* Column Info */
	private String mdst = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String totSum = null;
	/* Column Info */
	private String actShprNm = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String t2 = null;
	/* Column Info */
	private String dw = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String dx = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String dorArrDt = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String ownrTrkFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String a2 = null;
	/* Column Info */
	private String troDtTo = null;
	/* Column Info */
	private String a4 = null;
	/* Column Info */
	private String a5 = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String f2 = null;
	/* Column Info */
	private String f5 = null;
	/* Column Info */
	private String s4 = null;
	/* Column Info */
	private String f4 = null;
	/* Column Info */
	private String troQty = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String s2 = null;
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String subgroupTitle = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String soFlg = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String dorLocCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String zoneCode = null;
	/* Column Info */
	private String rtnLocCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String r4 = null;
	/* Column Info */
	private String bkgStaff = null;
	/* Column Info */
	private String r5 = null;
	/* Column Info */
	private String o5 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TroStatusListInVO() {}

	public TroStatusListInVO(String ibflag, String pagerows, String rnum, String bkgNo, String troSeq, String troSubSeq, String actShprNm, String cntcPsonNm, String dorLocCd, String teuA, String teuB, String cntrTpszCd, String troQty, String dorArrDt, String pkupLocCd, String rtnLocCd, String rcvTermCd, String soFlg, String rqstDt, String diffRmk, String porCd, String polCd, String podCd, String delCd, String slanCd, String vvdCd, String eqCtrlOfcCd, String bkgOfcCd, String ownrTrkFlg, String custCntCd, String custSeq, String custNm, String pkupYdCd, String docUsrId, String bkgDtFr, String bkgDtTo, String bkgStsCd, String troDtFr, String troDtTo, String pupDtFr, String pupDtTo, String bkgStaff, String dcgoFlg, String awkCgoFlg, String bbCgoFlg, String rdCgoFlg, String rcFlg, String zoneCode, String hLineType, String dLineType, String mdst, String ioBndCd, String d2, String d4, String d5, String d7, String d8, String d9, String dw, String dx, String r2, String r4, String r5, String f2, String f4, String f5, String o2, String o4, String s2, String s4, String t2, String t4, String a2, String a4,String a5, String p2, String p4, String z2, String z4, String o5 ,String totSum, String subgroupTitle) {
		this.p4 = p4;
		this.p2 = p2;
		this.z4 = z4;
		this.d9 = d9;
		this.d8 = d8;
		this.teuB = teuB;
		this.z2 = z2;
		this.teuA = teuA;
		this.d5 = d5;
		this.d4 = d4;
		this.d7 = d7;
		this.pagerows = pagerows;
		this.pkupYdCd = pkupYdCd;
		this.bkgDtTo = bkgDtTo;
		this.d2 = d2;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.rnum = rnum;
		this.cntrTpszCd = cntrTpszCd;
		this.troDtFr = troDtFr;
		this.custCntCd = custCntCd;
		this.hLineType = hLineType;
		this.pkupLocCd = pkupLocCd;
		this.bkgOfcCd = bkgOfcCd;
		this.troSubSeq = troSubSeq;
		this.pupDtFr = pupDtFr;
		this.awkCgoFlg = awkCgoFlg;
		this.pupDtTo = pupDtTo;
		this.delCd = delCd;
		this.bkgDtFr = bkgDtFr;
		this.dLineType = dLineType;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.t4 = t4;
		this.mdst = mdst;
		this.rcFlg = rcFlg;
		this.totSum = totSum;
		this.actShprNm = actShprNm;
		this.porCd = porCd;
		this.t2 = t2;
		this.dw = dw;
		this.docUsrId = docUsrId;
		this.dx = dx;
		this.custNm = custNm;
		this.dorArrDt = dorArrDt;
		this.rdCgoFlg = rdCgoFlg;
		this.bkgStsCd = bkgStsCd;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.ownrTrkFlg = ownrTrkFlg;
		this.ibflag = ibflag;
		this.cntcPsonNm = cntcPsonNm;
		this.bbCgoFlg = bbCgoFlg;
		this.dcgoFlg = dcgoFlg;
		this.a2 = a2;
		this.troDtTo = troDtTo;
		this.a4 = a4;
		this.a5 = a5;
		this.rcvTermCd = rcvTermCd;
		this.f2 = f2;
		this.f5 = f5;
		this.s4 = s4;
		this.f4 = f4;
		this.troQty = troQty;
		this.rqstDt = rqstDt;
		this.s2 = s2;
		this.o2 = o2;
		this.subgroupTitle = subgroupTitle;
		this.o4 = o4;
		this.soFlg = soFlg;
		this.troSeq = troSeq;
		this.dorLocCd = dorLocCd;
		this.ioBndCd = ioBndCd;
		this.custSeq = custSeq;
		this.zoneCode = zoneCode;
		this.rtnLocCd = rtnLocCd;
		this.slanCd = slanCd;
		this.diffRmk = diffRmk;
		this.r2 = r2;
		this.r4 = r4;
		this.bkgStaff = bkgStaff;
		this.r5 = r5;
		this.o5 = o5;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p4", getP4());
		this.hashColumns.put("p2", getP2());
		this.hashColumns.put("z4", getZ4());
		this.hashColumns.put("d9", getD9());
		this.hashColumns.put("d8", getD8());
		this.hashColumns.put("teu_b", getTeuB());
		this.hashColumns.put("z2", getZ2());
		this.hashColumns.put("teu_a", getTeuA());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pkup_yd_cd", getPkupYdCd());
		this.hashColumns.put("bkg_dt_to", getBkgDtTo());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("tro_dt_fr", getTroDtFr());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("h_line_type", getHLineType());
		this.hashColumns.put("pkup_loc_cd", getPkupLocCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("tro_sub_seq", getTroSubSeq());
		this.hashColumns.put("pup_dt_fr", getPupDtFr());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("pup_dt_to", getPupDtTo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bkg_dt_fr", getBkgDtFr());
		this.hashColumns.put("d_line_type", getDLineType());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("t4", getT4());
		this.hashColumns.put("mdst", getMdst());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("tot_sum", getTotSum());
		this.hashColumns.put("act_shpr_nm", getActShprNm());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("t2", getT2());
		this.hashColumns.put("dw", getDw());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("dx", getDx());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("dor_arr_dt", getDorArrDt());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("ownr_trk_flg", getOwnrTrkFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("a2", getA2());
		this.hashColumns.put("tro_dt_to", getTroDtTo());
		this.hashColumns.put("a4", getA4());
		this.hashColumns.put("a5", getA5());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("f5", getF5());
		this.hashColumns.put("s4", getS4());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("tro_qty", getTroQty());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("s2", getS2());
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("subgroup_title", getSubgroupTitle());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("so_flg", getSoFlg());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("dor_loc_cd", getDorLocCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("zone_code", getZoneCode());
		this.hashColumns.put("rtn_loc_cd", getRtnLocCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("r4", getR4());
		this.hashColumns.put("bkg_staff", getBkgStaff());
		this.hashColumns.put("r5", getR5());
		this.hashColumns.put("o5", getO5());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p4", "p4");
		this.hashFields.put("p2", "p2");
		this.hashFields.put("z4", "z4");
		this.hashFields.put("d9", "d9");
		this.hashFields.put("d8", "d8");
		this.hashFields.put("teu_b", "teuB");
		this.hashFields.put("z2", "z2");
		this.hashFields.put("teu_a", "teuA");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pkup_yd_cd", "pkupYdCd");
		this.hashFields.put("bkg_dt_to", "bkgDtTo");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("tro_dt_fr", "troDtFr");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("h_line_type", "hLineType");
		this.hashFields.put("pkup_loc_cd", "pkupLocCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("tro_sub_seq", "troSubSeq");
		this.hashFields.put("pup_dt_fr", "pupDtFr");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("pup_dt_to", "pupDtTo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bkg_dt_fr", "bkgDtFr");
		this.hashFields.put("d_line_type", "dLineType");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("t4", "t4");
		this.hashFields.put("mdst", "mdst");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("tot_sum", "totSum");
		this.hashFields.put("act_shpr_nm", "actShprNm");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("t2", "t2");
		this.hashFields.put("dw", "dw");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("dx", "dx");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("dor_arr_dt", "dorArrDt");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("ownr_trk_flg", "ownrTrkFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("a2", "a2");
		this.hashFields.put("tro_dt_to", "troDtTo");
		this.hashFields.put("a4", "a4");
		this.hashFields.put("a5", "a5");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("s4", "s4");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("tro_qty", "troQty");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("subgroup_title", "subgroupTitle");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("so_flg", "soFlg");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("dor_loc_cd", "dorLocCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("zone_code", "zoneCode");
		this.hashFields.put("rtn_loc_cd", "rtnLocCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("r4", "r4");
		this.hashFields.put("bkg_staff", "bkgStaff");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("o5", "o5");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return p4
	 */
	public String getP4() {
		return this.p4;
	}
	
	/**
	 * Column Info
	 * @return p2
	 */
	public String getP2() {
		return this.p2;
	}
	
	/**
	 * Column Info
	 * @return z4
	 */
	public String getZ4() {
		return this.z4;
	}
	
	/**
	 * Column Info
	 * @return d9
	 */
	public String getD9() {
		return this.d9;
	}
	
	/**
	 * Column Info
	 * @return d8
	 */
	public String getD8() {
		return this.d8;
	}
	
	/**
	 * Column Info
	 * @return teuB
	 */
	public String getTeuB() {
		return this.teuB;
	}
	
	/**
	 * Column Info
	 * @return z2
	 */
	public String getZ2() {
		return this.z2;
	}
	
	/**
	 * Column Info
	 * @return teuA
	 */
	public String getTeuA() {
		return this.teuA;
	}
	
	/**
	 * Column Info
	 * @return d5
	 */
	public String getD5() {
		return this.d5;
	}
	
	/**
	 * Column Info
	 * @return d4
	 */
	public String getD4() {
		return this.d4;
	}
	
	/**
	 * Column Info
	 * @return d7
	 */
	public String getD7() {
		return this.d7;
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
	 * @return pkupYdCd
	 */
	public String getPkupYdCd() {
		return this.pkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return bkgDtTo
	 */
	public String getBkgDtTo() {
		return this.bkgDtTo;
	}
	
	/**
	 * Column Info
	 * @return d2
	 */
	public String getD2() {
		return this.d2;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return troDtFr
	 */
	public String getTroDtFr() {
		return this.troDtFr;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return hLineType
	 */
	public String getHLineType() {
		return this.hLineType;
	}
	
	/**
	 * Column Info
	 * @return pkupLocCd
	 */
	public String getPkupLocCd() {
		return this.pkupLocCd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return troSubSeq
	 */
	public String getTroSubSeq() {
		return this.troSubSeq;
	}
	
	/**
	 * Column Info
	 * @return pupDtFr
	 */
	public String getPupDtFr() {
		return this.pupDtFr;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return pupDtTo
	 */
	public String getPupDtTo() {
		return this.pupDtTo;
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
	 * @return bkgDtFr
	 */
	public String getBkgDtFr() {
		return this.bkgDtFr;
	}
	
	/**
	 * Column Info
	 * @return dLineType
	 */
	public String getDLineType() {
		return this.dLineType;
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
	 * @return t4
	 */
	public String getT4() {
		return this.t4;
	}
	
	/**
	 * Column Info
	 * @return mdst
	 */
	public String getMdst() {
		return this.mdst;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return totSum
	 */
	public String getTotSum() {
		return this.totSum;
	}
	
	/**
	 * Column Info
	 * @return actShprNm
	 */
	public String getActShprNm() {
		return this.actShprNm;
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
	 * @return t2
	 */
	public String getT2() {
		return this.t2;
	}
	
	/**
	 * Column Info
	 * @return dw
	 */
	public String getDw() {
		return this.dw;
	}
	
	/**
	 * Column Info
	 * @return docUsrId
	 */
	public String getDocUsrId() {
		return this.docUsrId;
	}
	
	/**
	 * Column Info
	 * @return dx
	 */
	public String getDx() {
		return this.dx;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return dorArrDt
	 */
	public String getDorArrDt() {
		return this.dorArrDt;
	}
	
	/**
	 * Column Info
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ownrTrkFlg
	 */
	public String getOwnrTrkFlg() {
		return this.ownrTrkFlg;
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
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return a2
	 */
	public String getA2() {
		return this.a2;
	}
	
	/**
	 * Column Info
	 * @return troDtTo
	 */
	public String getTroDtTo() {
		return this.troDtTo;
	}
	
	/**
	 * Column Info
	 * @return a4
	 */
	public String getA4() {
		return this.a4;
	}

	/**
	 * Column Info
	 * @return a5
	 */
	public String getA5() {
		return this.a5;
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
	 * @return f2
	 */
	public String getF2() {
		return this.f2;
	}
	
	/**
	 * Column Info
	 * @return f5
	 */
	public String getF5() {
		return this.f5;
	}
	
	/**
	 * Column Info
	 * @return s4
	 */
	public String getS4() {
		return this.s4;
	}
	
	/**
	 * Column Info
	 * @return f4
	 */
	public String getF4() {
		return this.f4;
	}
	
	/**
	 * Column Info
	 * @return troQty
	 */
	public String getTroQty() {
		return this.troQty;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return s2
	 */
	public String getS2() {
		return this.s2;
	}
	
	/**
	 * Column Info
	 * @return o2
	 */
	public String getO2() {
		return this.o2;
	}
	
	/**
	 * Column Info
	 * @return subgroupTitle
	 */
	public String getSubgroupTitle() {
		return this.subgroupTitle;
	}
	
	/**
	 * Column Info
	 * @return o4
	 */
	public String getO4() {
		return this.o4;
	}
	
	/**
	 * Column Info
	 * @return soFlg
	 */
	public String getSoFlg() {
		return this.soFlg;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return dorLocCd
	 */
	public String getDorLocCd() {
		return this.dorLocCd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return zoneCode
	 */
	public String getZoneCode() {
		return this.zoneCode;
	}
	
	/**
	 * Column Info
	 * @return rtnLocCd
	 */
	public String getRtnLocCd() {
		return this.rtnLocCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return r2
	 */
	public String getR2() {
		return this.r2;
	}
	
	/**
	 * Column Info
	 * @return r4
	 */
	public String getR4() {
		return this.r4;
	}
	
	/**
	 * Column Info
	 * @return bkgStaff
	 */
	public String getBkgStaff() {
		return this.bkgStaff;
	}
	
	/**
	 * Column Info
	 * @return r5
	 */
	public String getR5() {
		return this.r5;
	}
	
	/**
	 * Column Info
	 * @return o5
	 */
	public String getO5() {
		return this.o5;
	}
	

	/**
	 * Column Info
	 * @param p4
	 */
	public void setP4(String p4) {
		this.p4 = p4;
	}
	
	/**
	 * Column Info
	 * @param p2
	 */
	public void setP2(String p2) {
		this.p2 = p2;
	}
	
	/**
	 * Column Info
	 * @param z4
	 */
	public void setZ4(String z4) {
		this.z4 = z4;
	}
	
	/**
	 * Column Info
	 * @param d9
	 */
	public void setD9(String d9) {
		this.d9 = d9;
	}
	
	/**
	 * Column Info
	 * @param d8
	 */
	public void setD8(String d8) {
		this.d8 = d8;
	}
	
	/**
	 * Column Info
	 * @param teuB
	 */
	public void setTeuB(String teuB) {
		this.teuB = teuB;
	}
	
	/**
	 * Column Info
	 * @param z2
	 */
	public void setZ2(String z2) {
		this.z2 = z2;
	}
	
	/**
	 * Column Info
	 * @param teuA
	 */
	public void setTeuA(String teuA) {
		this.teuA = teuA;
	}
	
	/**
	 * Column Info
	 * @param d5
	 */
	public void setD5(String d5) {
		this.d5 = d5;
	}
	
	/**
	 * Column Info
	 * @param d4
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}
	
	/**
	 * Column Info
	 * @param d7
	 */
	public void setD7(String d7) {
		this.d7 = d7;
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
	 * @param pkupYdCd
	 */
	public void setPkupYdCd(String pkupYdCd) {
		this.pkupYdCd = pkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param bkgDtTo
	 */
	public void setBkgDtTo(String bkgDtTo) {
		this.bkgDtTo = bkgDtTo;
	}
	
	/**
	 * Column Info
	 * @param d2
	 */
	public void setD2(String d2) {
		this.d2 = d2;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param troDtFr
	 */
	public void setTroDtFr(String troDtFr) {
		this.troDtFr = troDtFr;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param hLineType
	 */
	public void setHLineType(String hLineType) {
		this.hLineType = hLineType;
	}
	
	/**
	 * Column Info
	 * @param pkupLocCd
	 */
	public void setPkupLocCd(String pkupLocCd) {
		this.pkupLocCd = pkupLocCd;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param troSubSeq
	 */
	public void setTroSubSeq(String troSubSeq) {
		this.troSubSeq = troSubSeq;
	}
	
	/**
	 * Column Info
	 * @param pupDtFr
	 */
	public void setPupDtFr(String pupDtFr) {
		this.pupDtFr = pupDtFr;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param pupDtTo
	 */
	public void setPupDtTo(String pupDtTo) {
		this.pupDtTo = pupDtTo;
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
	 * @param bkgDtFr
	 */
	public void setBkgDtFr(String bkgDtFr) {
		this.bkgDtFr = bkgDtFr;
	}
	
	/**
	 * Column Info
	 * @param dLineType
	 */
	public void setDLineType(String dLineType) {
		this.dLineType = dLineType;
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
	 * @param t4
	 */
	public void setT4(String t4) {
		this.t4 = t4;
	}
	
	/**
	 * Column Info
	 * @param mdst
	 */
	public void setMdst(String mdst) {
		this.mdst = mdst;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param totSum
	 */
	public void setTotSum(String totSum) {
		this.totSum = totSum;
	}
	
	/**
	 * Column Info
	 * @param actShprNm
	 */
	public void setActShprNm(String actShprNm) {
		this.actShprNm = actShprNm;
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
	 * @param t2
	 */
	public void setT2(String t2) {
		this.t2 = t2;
	}
	
	/**
	 * Column Info
	 * @param dw
	 */
	public void setDw(String dw) {
		this.dw = dw;
	}
	
	/**
	 * Column Info
	 * @param docUsrId
	 */
	public void setDocUsrId(String docUsrId) {
		this.docUsrId = docUsrId;
	}
	
	/**
	 * Column Info
	 * @param dx
	 */
	public void setDx(String dx) {
		this.dx = dx;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param dorArrDt
	 */
	public void setDorArrDt(String dorArrDt) {
		this.dorArrDt = dorArrDt;
	}
	
	/**
	 * Column Info
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ownrTrkFlg
	 */
	public void setOwnrTrkFlg(String ownrTrkFlg) {
		this.ownrTrkFlg = ownrTrkFlg;
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
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param a2
	 */
	public void setA2(String a2) {
		this.a2 = a2;
	}
	
	/**
	 * Column Info
	 * @param troDtTo
	 */
	public void setTroDtTo(String troDtTo) {
		this.troDtTo = troDtTo;
	}

	
	/**
	 * Column Info
	 * @param a4
	 */
	public void setA4(String a4) {
		this.a4 = a4;
	}
	
	/**
	 * Column Info
	 * @param a5
	 */
	public void setA5(String a5) {
		this.a5 = a5;
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
	 * @param f2
	 */
	public void setF2(String f2) {
		this.f2 = f2;
	}
	
	/**
	 * Column Info
	 * @param f5
	 */
	public void setF5(String f5) {
		this.f5 = f5;
	}
	
	/**
	 * Column Info
	 * @param s4
	 */
	public void setS4(String s4) {
		this.s4 = s4;
	}
	
	/**
	 * Column Info
	 * @param f4
	 */
	public void setF4(String f4) {
		this.f4 = f4;
	}
	
	/**
	 * Column Info
	 * @param troQty
	 */
	public void setTroQty(String troQty) {
		this.troQty = troQty;
	}
	
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param s2
	 */
	public void setS2(String s2) {
		this.s2 = s2;
	}
	
	/**
	 * Column Info
	 * @param o2
	 */
	public void setO2(String o2) {
		this.o2 = o2;
	}
	
	/**
	 * Column Info
	 * @param subgroupTitle
	 */
	public void setSubgroupTitle(String subgroupTitle) {
		this.subgroupTitle = subgroupTitle;
	}
	
	/**
	 * Column Info
	 * @param o4
	 */
	public void setO4(String o4) {
		this.o4 = o4;
	}
	
	/**
	 * Column Info
	 * @param soFlg
	 */
	public void setSoFlg(String soFlg) {
		this.soFlg = soFlg;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param dorLocCd
	 */
	public void setDorLocCd(String dorLocCd) {
		this.dorLocCd = dorLocCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param zoneCode
	 */
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	
	/**
	 * Column Info
	 * @param rtnLocCd
	 */
	public void setRtnLocCd(String rtnLocCd) {
		this.rtnLocCd = rtnLocCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param r2
	 */
	public void setR2(String r2) {
		this.r2 = r2;
	}
	
	/**
	 * Column Info
	 * @param r4
	 */
	public void setR4(String r4) {
		this.r4 = r4;
	}
	
	/**
	 * Column Info
	 * @param bkgStaff
	 */
	public void setBkgStaff(String bkgStaff) {
		this.bkgStaff = bkgStaff;
	}
	
	/**
	 * Column Info
	 * @param r5
	 */
	public void setR5(String r5) {
		this.r5 = r5;
	}
	
	/**
	 * Column Info
	 * @param o5
	 */
	public void setO5(String o5) {
		this.o5 = o5;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setP4(JSPUtil.getParameter(request, "p4", ""));
		setP2(JSPUtil.getParameter(request, "p2", ""));
		setZ4(JSPUtil.getParameter(request, "z4", ""));
		setD9(JSPUtil.getParameter(request, "d9", ""));
		setD8(JSPUtil.getParameter(request, "d8", ""));
		setTeuB(JSPUtil.getParameter(request, "teu_b", ""));
		setZ2(JSPUtil.getParameter(request, "z2", ""));
		setTeuA(JSPUtil.getParameter(request, "teu_a", ""));
		setD5(JSPUtil.getParameter(request, "d5", ""));
		setD4(JSPUtil.getParameter(request, "d4", ""));
		setD7(JSPUtil.getParameter(request, "d7", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPkupYdCd(JSPUtil.getParameter(request, "pkup_yd_cd", ""));
		setBkgDtTo(JSPUtil.getParameter(request, "bkg_dt_to", ""));
		setD2(JSPUtil.getParameter(request, "d2", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setRnum(JSPUtil.getParameter(request, "rnum", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setTroDtFr(JSPUtil.getParameter(request, "tro_dt_fr", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setHLineType(JSPUtil.getParameter(request, "h_line_type", ""));
		setPkupLocCd(JSPUtil.getParameter(request, "pkup_loc_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setTroSubSeq(JSPUtil.getParameter(request, "tro_sub_seq", ""));
		setPupDtFr(JSPUtil.getParameter(request, "pup_dt_fr", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setPupDtTo(JSPUtil.getParameter(request, "pup_dt_to", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBkgDtFr(JSPUtil.getParameter(request, "bkg_dt_fr", ""));
		setDLineType(JSPUtil.getParameter(request, "d_line_type", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setT4(JSPUtil.getParameter(request, "t4", ""));
		setMdst(JSPUtil.getParameter(request, "mdst", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setTotSum(JSPUtil.getParameter(request, "tot_sum", ""));
		setActShprNm(JSPUtil.getParameter(request, "act_shpr_nm", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setT2(JSPUtil.getParameter(request, "t2", ""));
		setDw(JSPUtil.getParameter(request, "dw", ""));
		setDocUsrId(JSPUtil.getParameter(request, "doc_usr_id", ""));
		setDx(JSPUtil.getParameter(request, "dx", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setDorArrDt(JSPUtil.getParameter(request, "dor_arr_dt", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, "eq_ctrl_ofc_cd", ""));
		setOwnrTrkFlg(JSPUtil.getParameter(request, "ownr_trk_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, "bb_cgo_flg", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setA2(JSPUtil.getParameter(request, "a2", ""));
		setTroDtTo(JSPUtil.getParameter(request, "tro_dt_to", ""));
		setA4(JSPUtil.getParameter(request, "a4", ""));
		setA5(JSPUtil.getParameter(request, "a5", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setF2(JSPUtil.getParameter(request, "f2", ""));
		setF5(JSPUtil.getParameter(request, "f5", ""));
		setS4(JSPUtil.getParameter(request, "s4", ""));
		setF4(JSPUtil.getParameter(request, "f4", ""));
		setTroQty(JSPUtil.getParameter(request, "tro_qty", ""));
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
		setS2(JSPUtil.getParameter(request, "s2", ""));
		setO2(JSPUtil.getParameter(request, "o2", ""));
		setSubgroupTitle(JSPUtil.getParameter(request, "subgroup_title", ""));
		setO4(JSPUtil.getParameter(request, "o4", ""));
		setSoFlg(JSPUtil.getParameter(request, "so_flg", ""));
		setTroSeq(JSPUtil.getParameter(request, "tro_seq", ""));
		setDorLocCd(JSPUtil.getParameter(request, "dor_loc_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setZoneCode(JSPUtil.getParameter(request, "zone_code", ""));
		setRtnLocCd(JSPUtil.getParameter(request, "rtn_loc_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setR2(JSPUtil.getParameter(request, "r2", ""));
		setR4(JSPUtil.getParameter(request, "r4", ""));
		setBkgStaff(JSPUtil.getParameter(request, "bkg_staff", ""));
		setR5(JSPUtil.getParameter(request, "r5", ""));
		setO5(JSPUtil.getParameter(request, "o5", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TroStatusListInVO[]
	 */
	public TroStatusListInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TroStatusListInVO[]
	 */
	public TroStatusListInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TroStatusListInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] p4 = (JSPUtil.getParameter(request, prefix	+ "p4", length));
			String[] p2 = (JSPUtil.getParameter(request, prefix	+ "p2", length));
			String[] z4 = (JSPUtil.getParameter(request, prefix	+ "z4", length));
			String[] d9 = (JSPUtil.getParameter(request, prefix	+ "d9", length));
			String[] d8 = (JSPUtil.getParameter(request, prefix	+ "d8", length));
			String[] teuB = (JSPUtil.getParameter(request, prefix	+ "teu_b", length));
			String[] z2 = (JSPUtil.getParameter(request, prefix	+ "z2", length));
			String[] teuA = (JSPUtil.getParameter(request, prefix	+ "teu_a", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pkupYdCd = (JSPUtil.getParameter(request, prefix	+ "pkup_yd_cd", length));
			String[] bkgDtTo = (JSPUtil.getParameter(request, prefix	+ "bkg_dt_to", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] troDtFr = (JSPUtil.getParameter(request, prefix	+ "tro_dt_fr", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] hLineType = (JSPUtil.getParameter(request, prefix	+ "h_line_type", length));
			String[] pkupLocCd = (JSPUtil.getParameter(request, prefix	+ "pkup_loc_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] troSubSeq = (JSPUtil.getParameter(request, prefix	+ "tro_sub_seq", length));
			String[] pupDtFr = (JSPUtil.getParameter(request, prefix	+ "pup_dt_fr", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] pupDtTo = (JSPUtil.getParameter(request, prefix	+ "pup_dt_to", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bkgDtFr = (JSPUtil.getParameter(request, prefix	+ "bkg_dt_fr", length));
			String[] dLineType = (JSPUtil.getParameter(request, prefix	+ "d_line_type", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] t4 = (JSPUtil.getParameter(request, prefix	+ "t4", length));
			String[] mdst = (JSPUtil.getParameter(request, prefix	+ "mdst", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] totSum = (JSPUtil.getParameter(request, prefix	+ "tot_sum", length));
			String[] actShprNm = (JSPUtil.getParameter(request, prefix	+ "act_shpr_nm", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] t2 = (JSPUtil.getParameter(request, prefix	+ "t2", length));
			String[] dw = (JSPUtil.getParameter(request, prefix	+ "dw", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] dx = (JSPUtil.getParameter(request, prefix	+ "dx", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] dorArrDt = (JSPUtil.getParameter(request, prefix	+ "dor_arr_dt", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] ownrTrkFlg = (JSPUtil.getParameter(request, prefix	+ "ownr_trk_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] a2 = (JSPUtil.getParameter(request, prefix	+ "a2", length));
			String[] troDtTo = (JSPUtil.getParameter(request, prefix	+ "tro_dt_to", length));
			String[] a4 = (JSPUtil.getParameter(request, prefix	+ "a4", length));
			String[] a5 = (JSPUtil.getParameter(request, prefix	+ "a5", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] f5 = (JSPUtil.getParameter(request, prefix	+ "f5", length));
			String[] s4 = (JSPUtil.getParameter(request, prefix	+ "s4", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] troQty = (JSPUtil.getParameter(request, prefix	+ "tro_qty", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] s2 = (JSPUtil.getParameter(request, prefix	+ "s2", length));
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] subgroupTitle = (JSPUtil.getParameter(request, prefix	+ "subgroup_title", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] soFlg = (JSPUtil.getParameter(request, prefix	+ "so_flg", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] dorLocCd = (JSPUtil.getParameter(request, prefix	+ "dor_loc_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] zoneCode = (JSPUtil.getParameter(request, prefix	+ "zone_code", length));
			String[] rtnLocCd = (JSPUtil.getParameter(request, prefix	+ "rtn_loc_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] r4 = (JSPUtil.getParameter(request, prefix	+ "r4", length));
			String[] bkgStaff = (JSPUtil.getParameter(request, prefix	+ "bkg_staff", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			String[] o5 = (JSPUtil.getParameter(request, prefix	+ "o5", length));
			
			for (int i = 0; i < length; i++) {
				model = new TroStatusListInVO();
				if (p4[i] != null)
					model.setP4(p4[i]);
				if (p2[i] != null)
					model.setP2(p2[i]);
				if (z4[i] != null)
					model.setZ4(z4[i]);
				if (d9[i] != null)
					model.setD9(d9[i]);
				if (d8[i] != null)
					model.setD8(d8[i]);
				if (teuB[i] != null)
					model.setTeuB(teuB[i]);
				if (z2[i] != null)
					model.setZ2(z2[i]);
				if (teuA[i] != null)
					model.setTeuA(teuA[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pkupYdCd[i] != null)
					model.setPkupYdCd(pkupYdCd[i]);
				if (bkgDtTo[i] != null)
					model.setBkgDtTo(bkgDtTo[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (troDtFr[i] != null)
					model.setTroDtFr(troDtFr[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (hLineType[i] != null)
					model.setHLineType(hLineType[i]);
				if (pkupLocCd[i] != null)
					model.setPkupLocCd(pkupLocCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (troSubSeq[i] != null)
					model.setTroSubSeq(troSubSeq[i]);
				if (pupDtFr[i] != null)
					model.setPupDtFr(pupDtFr[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (pupDtTo[i] != null)
					model.setPupDtTo(pupDtTo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bkgDtFr[i] != null)
					model.setBkgDtFr(bkgDtFr[i]);
				if (dLineType[i] != null)
					model.setDLineType(dLineType[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (t4[i] != null)
					model.setT4(t4[i]);
				if (mdst[i] != null)
					model.setMdst(mdst[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (totSum[i] != null)
					model.setTotSum(totSum[i]);
				if (actShprNm[i] != null)
					model.setActShprNm(actShprNm[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (t2[i] != null)
					model.setT2(t2[i]);
				if (dw[i] != null)
					model.setDw(dw[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (dx[i] != null)
					model.setDx(dx[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (dorArrDt[i] != null)
					model.setDorArrDt(dorArrDt[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (ownrTrkFlg[i] != null)
					model.setOwnrTrkFlg(ownrTrkFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (a2[i] != null)
					model.setA2(a2[i]);
				if (troDtTo[i] != null)
					model.setTroDtTo(troDtTo[i]);
				if (a4[i] != null)
					model.setA4(a4[i]);
				if (a5[i] != null)
					model.setA5(a5[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (f2[i] != null)
					model.setF2(f2[i]);
				if (f5[i] != null)
					model.setF5(f5[i]);
				if (s4[i] != null)
					model.setS4(s4[i]);
				if (f4[i] != null)
					model.setF4(f4[i]);
				if (troQty[i] != null)
					model.setTroQty(troQty[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (s2[i] != null)
					model.setS2(s2[i]);
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (subgroupTitle[i] != null)
					model.setSubgroupTitle(subgroupTitle[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (soFlg[i] != null)
					model.setSoFlg(soFlg[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (dorLocCd[i] != null)
					model.setDorLocCd(dorLocCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (zoneCode[i] != null)
					model.setZoneCode(zoneCode[i]);
				if (rtnLocCd[i] != null)
					model.setRtnLocCd(rtnLocCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (r4[i] != null)
					model.setR4(r4[i]);
				if (bkgStaff[i] != null)
					model.setBkgStaff(bkgStaff[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				if (o5[i] != null)
					model.setO5(o5[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTroStatusListInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TroStatusListInVO[]
	 */
	public TroStatusListInVO[] getTroStatusListInVOs(){
		TroStatusListInVO[] vos = (TroStatusListInVO[])models.toArray(new TroStatusListInVO[models.size()]);
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
		this.p4 = this.p4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2 = this.p2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.z4 = this.z4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9 = this.d9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d8 = this.d8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuB = this.teuB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.z2 = this.z2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuA = this.teuA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCd = this.pkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDtTo = this.bkgDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troDtFr = this.troDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hLineType = this.hLineType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupLocCd = this.pkupLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSubSeq = this.troSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pupDtFr = this.pupDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pupDtTo = this.pupDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDtFr = this.bkgDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dLineType = this.dLineType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4 = this.t4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdst = this.mdst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSum = this.totSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprNm = this.actShprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t2 = this.t2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dw = this.dw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dx = this.dx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorArrDt = this.dorArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrTrkFlg = this.ownrTrkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2 = this.a2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troDtTo = this.troDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4 = this.a4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5 = this.a5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 = this.f5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 = this.s4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troQty = this.troQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 = this.s2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subgroupTitle = this.subgroupTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soFlg = this.soFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorLocCd = this.dorLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zoneCode = this.zoneCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnLocCd = this.rtnLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4 = this.r4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStaff = this.bkgStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5 = this.o5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
