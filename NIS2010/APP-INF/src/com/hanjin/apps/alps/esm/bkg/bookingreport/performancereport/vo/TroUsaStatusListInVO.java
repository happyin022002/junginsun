/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TroUsaStatusListInVO.java
*@FileTitle : TroUsaStatusListInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class TroUsaStatusListInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TroUsaStatusListInVO> models = new ArrayList<TroUsaStatusListInVO>();
	
	/* Column Info */
	private String p4 = null;
	/* Column Info */
	private String p2 = null;
	/* Column Info */
	private String z4 = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String d9 = null;
	/* Column Info */
	private String d8 = null;
	/* Column Info */
	private String z2 = null;
	/* Column Info */
	private String d5 = null;
	/* Column Info */
	private String d4 = null;
	/* Column Info */
	private String d7 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgDtTo = null;
	/* Column Info */
	private String pkupYdCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String d2 = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String bkgTpsz = null;
	/* Column Info */
	private String troDtFr = null;
	/* Column Info */
	private String dTerm = null;
	/* Column Info */
	private String serviceProvider = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String pupDtFr = null;
	/* Column Info */
	private String pupDtTo = null;
	/* Column Info */
	private String woIssId = null;
	/* Column Info */
	private String bkgDtFr = null;
	/* Column Info */
	private String soCreDt = null;
	/* Column Info */
	private String soSts = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String t4 = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String soCreId = null;
	/* Column Info */
	private String totSum = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String t2 = null;
	/* Column Info */
	private String troTpsz = null;
	/* Column Info */
	private String dw = null;
	/* Column Info */
	private String dx = null;
	/* Column Info */
	private String dorArrDt = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String deDt = null;
	/* Column Info */
	private String doorSvcTp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String apntDt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String a2 = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String troDtTo = null;
	/* Column Info */
	private String a4 = null;
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
	private String troDt = null;
	/* Column Info */
	private String s2 = null;
	/* Column Info */
	private String o2 = null;
	/* Column Info */
	private String o4 = null;
	/* Column Info */
	private String soFlg = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String o5 = null;
	/* Column Info */
	private String dorLocCd = null;
	/* Column Info */
	private String rtnYdCd = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String r2 = null;
	/* Column Info */
	private String r4 = null;
	/* Column Info */
	private String rTerm = null;
	/* Column Info */
	private String r5 = null;
	/* Column Info */
	private String a5 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TroUsaStatusListInVO() {}

	public TroUsaStatusListInVO(String ibflag, String pagerows, String rnum, String bkgNo, String slanCd, String vvdCd, String porCd, String polCd, String bkgTpsz, String opCntrQty, String troSeq, String dorLocCd, String pkupYdCd, String rtnYdCd, String troTpsz, String troQty, String troDt, String rqstDt, String cfmFlg, String eqNo, String copNo, String soSts, String soNo, String soCreDt, String soCreId, String woIssId, String woNo, String interRmk, String doorSvcTp, String creOfcCd, String dorArrDt, String deDt, String apntDt, String serviceProvider, String cntcPsonNm, String locCd, String cnmvStsCd, String d2, String d4, String d5, String d7, String d8, String d9, String dw, String dx, String r2, String r4, String r5, String f2, String f4, String f5, String o2, String o4, String o5, String s2, String s4, String t2, String t4, String a2, String a4, String p2, String p4, String z2, String z4, String totSum, String bkgDtFr, String bkgDtTo, String bkgOfcCd, String troDtFr, String troDtTo, String soFlg, String pupDtFr, String pupDtTo, String eqCtrlOfcCd, String rTerm, String dTerm, String a5) {
		this.p4 = p4;
		this.p2 = p2;
		this.z4 = z4;
		this.copNo = copNo;
		this.d9 = d9;
		this.d8 = d8;
		this.z2 = z2;
		this.d5 = d5;
		this.d4 = d4;
		this.d7 = d7;
		this.pagerows = pagerows;
		this.bkgDtTo = bkgDtTo;
		this.pkupYdCd = pkupYdCd;
		this.polCd = polCd;
		this.locCd = locCd;
		this.d2 = d2;
		this.vvdCd = vvdCd;
		this.rnum = rnum;
		this.bkgTpsz = bkgTpsz;
		this.troDtFr = troDtFr;
		this.dTerm = dTerm;
		this.serviceProvider = serviceProvider;
		this.bkgOfcCd = bkgOfcCd;
		this.soNo = soNo;
		this.pupDtFr = pupDtFr;
		this.pupDtTo = pupDtTo;
		this.woIssId = woIssId;
		this.bkgDtFr = bkgDtFr;
		this.soCreDt = soCreDt;
		this.soSts = soSts;
		this.bkgNo = bkgNo;
		this.t4 = t4;
		this.opCntrQty = opCntrQty;
		this.soCreId = soCreId;
		this.totSum = totSum;
		this.porCd = porCd;
		this.t2 = t2;
		this.troTpsz = troTpsz;
		this.dw = dw;
		this.dx = dx;
		this.dorArrDt = dorArrDt;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.deDt = deDt;
		this.doorSvcTp = doorSvcTp;
		this.ibflag = ibflag;
		this.cnmvStsCd = cnmvStsCd;
		this.eqNo = eqNo;
		this.interRmk = interRmk;
		this.apntDt = apntDt;
		this.creOfcCd = creOfcCd;
		this.cntcPsonNm = cntcPsonNm;
		this.a2 = a2;
		this.woNo = woNo;
		this.troDtTo = troDtTo;
		this.a4 = a4;
		this.f2 = f2;
		this.f5 = f5;
		this.s4 = s4;
		this.f4 = f4;
		this.troQty = troQty;
		this.rqstDt = rqstDt;
		this.troDt = troDt;
		this.s2 = s2;
		this.o2 = o2;
		this.o4 = o4;
		this.soFlg = soFlg;
		this.troSeq = troSeq;
		this.o5 = o5;
		this.dorLocCd = dorLocCd;
		this.rtnYdCd = rtnYdCd;
		this.cfmFlg = cfmFlg;
		this.slanCd = slanCd;
		this.r2 = r2;
		this.r4 = r4;
		this.rTerm = rTerm;
		this.r5 = r5;
		this.a5 = a5;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p4", getP4());
		this.hashColumns.put("p2", getP2());
		this.hashColumns.put("z4", getZ4());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("d9", getD9());
		this.hashColumns.put("d8", getD8());
		this.hashColumns.put("z2", getZ2());
		this.hashColumns.put("d5", getD5());
		this.hashColumns.put("d4", getD4());
		this.hashColumns.put("d7", getD7());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_dt_to", getBkgDtTo());
		this.hashColumns.put("pkup_yd_cd", getPkupYdCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("d2", getD2());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("bkg_tpsz", getBkgTpsz());
		this.hashColumns.put("tro_dt_fr", getTroDtFr());
		this.hashColumns.put("d_term", getDTerm());
		this.hashColumns.put("service_provider", getServiceProvider());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("pup_dt_fr", getPupDtFr());
		this.hashColumns.put("pup_dt_to", getPupDtTo());
		this.hashColumns.put("wo_iss_id", getWoIssId());
		this.hashColumns.put("bkg_dt_fr", getBkgDtFr());
		this.hashColumns.put("so_cre_dt", getSoCreDt());
		this.hashColumns.put("so_sts", getSoSts());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("t4", getT4());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("so_cre_id", getSoCreId());
		this.hashColumns.put("tot_sum", getTotSum());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("t2", getT2());
		this.hashColumns.put("tro_tpsz", getTroTpsz());
		this.hashColumns.put("dw", getDw());
		this.hashColumns.put("dx", getDx());
		this.hashColumns.put("dor_arr_dt", getDorArrDt());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("de_dt", getDeDt());
		this.hashColumns.put("door_svc_tp", getDoorSvcTp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("apnt_dt", getApntDt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("a2", getA2());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("tro_dt_to", getTroDtTo());
		this.hashColumns.put("a4", getA4());
		this.hashColumns.put("f2", getF2());
		this.hashColumns.put("f5", getF5());
		this.hashColumns.put("s4", getS4());
		this.hashColumns.put("f4", getF4());
		this.hashColumns.put("tro_qty", getTroQty());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("tro_dt", getTroDt());
		this.hashColumns.put("s2", getS2());
		this.hashColumns.put("o2", getO2());
		this.hashColumns.put("o4", getO4());
		this.hashColumns.put("so_flg", getSoFlg());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("o5", getO5());
		this.hashColumns.put("dor_loc_cd", getDorLocCd());
		this.hashColumns.put("rtn_yd_cd", getRtnYdCd());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("r2", getR2());
		this.hashColumns.put("r4", getR4());
		this.hashColumns.put("r_term", getRTerm());
		this.hashColumns.put("r5", getR5());
		this.hashColumns.put("a5", getA5());
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
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("d9", "d9");
		this.hashFields.put("d8", "d8");
		this.hashFields.put("z2", "z2");
		this.hashFields.put("d5", "d5");
		this.hashFields.put("d4", "d4");
		this.hashFields.put("d7", "d7");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_dt_to", "bkgDtTo");
		this.hashFields.put("pkup_yd_cd", "pkupYdCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("d2", "d2");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("bkg_tpsz", "bkgTpsz");
		this.hashFields.put("tro_dt_fr", "troDtFr");
		this.hashFields.put("d_term", "dTerm");
		this.hashFields.put("service_provider", "serviceProvider");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("pup_dt_fr", "pupDtFr");
		this.hashFields.put("pup_dt_to", "pupDtTo");
		this.hashFields.put("wo_iss_id", "woIssId");
		this.hashFields.put("bkg_dt_fr", "bkgDtFr");
		this.hashFields.put("so_cre_dt", "soCreDt");
		this.hashFields.put("so_sts", "soSts");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("t4", "t4");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("so_cre_id", "soCreId");
		this.hashFields.put("tot_sum", "totSum");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("t2", "t2");
		this.hashFields.put("tro_tpsz", "troTpsz");
		this.hashFields.put("dw", "dw");
		this.hashFields.put("dx", "dx");
		this.hashFields.put("dor_arr_dt", "dorArrDt");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("de_dt", "deDt");
		this.hashFields.put("door_svc_tp", "doorSvcTp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("apnt_dt", "apntDt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("a2", "a2");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("tro_dt_to", "troDtTo");
		this.hashFields.put("a4", "a4");
		this.hashFields.put("f2", "f2");
		this.hashFields.put("f5", "f5");
		this.hashFields.put("s4", "s4");
		this.hashFields.put("f4", "f4");
		this.hashFields.put("tro_qty", "troQty");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("tro_dt", "troDt");
		this.hashFields.put("s2", "s2");
		this.hashFields.put("o2", "o2");
		this.hashFields.put("o4", "o4");
		this.hashFields.put("so_flg", "soFlg");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("o5", "o5");
		this.hashFields.put("dor_loc_cd", "dorLocCd");
		this.hashFields.put("rtn_yd_cd", "rtnYdCd");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("r2", "r2");
		this.hashFields.put("r4", "r4");
		this.hashFields.put("r_term", "rTerm");
		this.hashFields.put("r5", "r5");
		this.hashFields.put("a5", "a5");
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
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
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
	 * @return z2
	 */
	public String getZ2() {
		return this.z2;
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
	 * @return bkgDtTo
	 */
	public String getBkgDtTo() {
		return this.bkgDtTo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return bkgTpsz
	 */
	public String getBkgTpsz() {
		return this.bkgTpsz;
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
	 * @return dTerm
	 */
	public String getDTerm() {
		return this.dTerm;
	}
	
	/**
	 * Column Info
	 * @return serviceProvider
	 */
	public String getServiceProvider() {
		return this.serviceProvider;
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
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
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
	 * @return pupDtTo
	 */
	public String getPupDtTo() {
		return this.pupDtTo;
	}
	
	/**
	 * Column Info
	 * @return woIssId
	 */
	public String getWoIssId() {
		return this.woIssId;
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
	 * @return soCreDt
	 */
	public String getSoCreDt() {
		return this.soCreDt;
	}
	
	/**
	 * Column Info
	 * @return soSts
	 */
	public String getSoSts() {
		return this.soSts;
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
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return soCreId
	 */
	public String getSoCreId() {
		return this.soCreId;
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
	 * @return troTpsz
	 */
	public String getTroTpsz() {
		return this.troTpsz;
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
	 * @return dx
	 */
	public String getDx() {
		return this.dx;
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
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return deDt
	 */
	public String getDeDt() {
		return this.deDt;
	}
	
	/**
	 * Column Info
	 * @return doorSvcTp
	 */
	public String getDoorSvcTp() {
		return this.doorSvcTp;
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
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return apntDt
	 */
	public String getApntDt() {
		return this.apntDt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return a2
	 */
	public String getA2() {
		return this.a2;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
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
	 * @return troDt
	 */
	public String getTroDt() {
		return this.troDt;
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
	 * @return o5
	 */
	public String getO5() {
		return this.o5;
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
	 * @return rtnYdCd
	 */
	public String getRtnYdCd() {
		return this.rtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
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
	 * @return rTerm
	 */
	public String getRTerm() {
		return this.rTerm;
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
	 * @return a5
	 */
	public String getA5() {
		return this.a5;
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
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
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
	 * @param z2
	 */
	public void setZ2(String z2) {
		this.z2 = z2;
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
	 * @param bkgDtTo
	 */
	public void setBkgDtTo(String bkgDtTo) {
		this.bkgDtTo = bkgDtTo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param bkgTpsz
	 */
	public void setBkgTpsz(String bkgTpsz) {
		this.bkgTpsz = bkgTpsz;
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
	 * @param dTerm
	 */
	public void setDTerm(String dTerm) {
		this.dTerm = dTerm;
	}
	
	/**
	 * Column Info
	 * @param serviceProvider
	 */
	public void setServiceProvider(String serviceProvider) {
		this.serviceProvider = serviceProvider;
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
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
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
	 * @param pupDtTo
	 */
	public void setPupDtTo(String pupDtTo) {
		this.pupDtTo = pupDtTo;
	}
	
	/**
	 * Column Info
	 * @param woIssId
	 */
	public void setWoIssId(String woIssId) {
		this.woIssId = woIssId;
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
	 * @param soCreDt
	 */
	public void setSoCreDt(String soCreDt) {
		this.soCreDt = soCreDt;
	}
	
	/**
	 * Column Info
	 * @param soSts
	 */
	public void setSoSts(String soSts) {
		this.soSts = soSts;
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
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param soCreId
	 */
	public void setSoCreId(String soCreId) {
		this.soCreId = soCreId;
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
	 * @param troTpsz
	 */
	public void setTroTpsz(String troTpsz) {
		this.troTpsz = troTpsz;
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
	 * @param dx
	 */
	public void setDx(String dx) {
		this.dx = dx;
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
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param deDt
	 */
	public void setDeDt(String deDt) {
		this.deDt = deDt;
	}
	
	/**
	 * Column Info
	 * @param doorSvcTp
	 */
	public void setDoorSvcTp(String doorSvcTp) {
		this.doorSvcTp = doorSvcTp;
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
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param apntDt
	 */
	public void setApntDt(String apntDt) {
		this.apntDt = apntDt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param a2
	 */
	public void setA2(String a2) {
		this.a2 = a2;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
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
	 * @param troDt
	 */
	public void setTroDt(String troDt) {
		this.troDt = troDt;
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
	 * @param o5
	 */
	public void setO5(String o5) {
		this.o5 = o5;
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
	 * @param rtnYdCd
	 */
	public void setRtnYdCd(String rtnYdCd) {
		this.rtnYdCd = rtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
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
	 * @param rTerm
	 */
	public void setRTerm(String rTerm) {
		this.rTerm = rTerm;
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
	 * @param a5
	 */
	public void setA5(String a5) {
		this.a5 = a5;
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
		setP4(JSPUtil.getParameter(request, prefix + "p4", ""));
		setP2(JSPUtil.getParameter(request, prefix + "p2", ""));
		setZ4(JSPUtil.getParameter(request, prefix + "z4", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setD9(JSPUtil.getParameter(request, prefix + "d9", ""));
		setD8(JSPUtil.getParameter(request, prefix + "d8", ""));
		setZ2(JSPUtil.getParameter(request, prefix + "z2", ""));
		setD5(JSPUtil.getParameter(request, prefix + "d5", ""));
		setD4(JSPUtil.getParameter(request, prefix + "d4", ""));
		setD7(JSPUtil.getParameter(request, prefix + "d7", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgDtTo(JSPUtil.getParameter(request, prefix + "bkg_dt_to", ""));
		setPkupYdCd(JSPUtil.getParameter(request, prefix + "pkup_yd_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setD2(JSPUtil.getParameter(request, prefix + "d2", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setRnum(JSPUtil.getParameter(request, prefix + "rnum", ""));
		setBkgTpsz(JSPUtil.getParameter(request, prefix + "bkg_tpsz", ""));
		setTroDtFr(JSPUtil.getParameter(request, prefix + "tro_dt_fr", ""));
		setDTerm(JSPUtil.getParameter(request, prefix + "d_term", ""));
		setServiceProvider(JSPUtil.getParameter(request, prefix + "service_provider", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setPupDtFr(JSPUtil.getParameter(request, prefix + "pup_dt_fr", ""));
		setPupDtTo(JSPUtil.getParameter(request, prefix + "pup_dt_to", ""));
		setWoIssId(JSPUtil.getParameter(request, prefix + "wo_iss_id", ""));
		setBkgDtFr(JSPUtil.getParameter(request, prefix + "bkg_dt_fr", ""));
		setSoCreDt(JSPUtil.getParameter(request, prefix + "so_cre_dt", ""));
		setSoSts(JSPUtil.getParameter(request, prefix + "so_sts", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setT4(JSPUtil.getParameter(request, prefix + "t4", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setSoCreId(JSPUtil.getParameter(request, prefix + "so_cre_id", ""));
		setTotSum(JSPUtil.getParameter(request, prefix + "tot_sum", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setT2(JSPUtil.getParameter(request, prefix + "t2", ""));
		setTroTpsz(JSPUtil.getParameter(request, prefix + "tro_tpsz", ""));
		setDw(JSPUtil.getParameter(request, prefix + "dw", ""));
		setDx(JSPUtil.getParameter(request, prefix + "dx", ""));
		setDorArrDt(JSPUtil.getParameter(request, prefix + "dor_arr_dt", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
		setDeDt(JSPUtil.getParameter(request, prefix + "de_dt", ""));
		setDoorSvcTp(JSPUtil.getParameter(request, prefix + "door_svc_tp", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setApntDt(JSPUtil.getParameter(request, prefix + "apnt_dt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setA2(JSPUtil.getParameter(request, prefix + "a2", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setTroDtTo(JSPUtil.getParameter(request, prefix + "tro_dt_to", ""));
		setA4(JSPUtil.getParameter(request, prefix + "a4", ""));
		setF2(JSPUtil.getParameter(request, prefix + "f2", ""));
		setF5(JSPUtil.getParameter(request, prefix + "f5", ""));
		setS4(JSPUtil.getParameter(request, prefix + "s4", ""));
		setF4(JSPUtil.getParameter(request, prefix + "f4", ""));
		setTroQty(JSPUtil.getParameter(request, prefix + "tro_qty", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setTroDt(JSPUtil.getParameter(request, prefix + "tro_dt", ""));
		setS2(JSPUtil.getParameter(request, prefix + "s2", ""));
		setO2(JSPUtil.getParameter(request, prefix + "o2", ""));
		setO4(JSPUtil.getParameter(request, prefix + "o4", ""));
		setSoFlg(JSPUtil.getParameter(request, prefix + "so_flg", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setO5(JSPUtil.getParameter(request, prefix + "o5", ""));
		setDorLocCd(JSPUtil.getParameter(request, prefix + "dor_loc_cd", ""));
		setRtnYdCd(JSPUtil.getParameter(request, prefix + "rtn_yd_cd", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setR2(JSPUtil.getParameter(request, prefix + "r2", ""));
		setR4(JSPUtil.getParameter(request, prefix + "r4", ""));
		setRTerm(JSPUtil.getParameter(request, prefix + "r_term", ""));
		setR5(JSPUtil.getParameter(request, prefix + "r5", ""));
		setA5(JSPUtil.getParameter(request, "a5", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TroUsaStatusListInVO[]
	 */
	public TroUsaStatusListInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TroUsaStatusListInVO[]
	 */
	public TroUsaStatusListInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TroUsaStatusListInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] p4 = (JSPUtil.getParameter(request, prefix	+ "p4", length));
			String[] p2 = (JSPUtil.getParameter(request, prefix	+ "p2", length));
			String[] z4 = (JSPUtil.getParameter(request, prefix	+ "z4", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] d9 = (JSPUtil.getParameter(request, prefix	+ "d9", length));
			String[] d8 = (JSPUtil.getParameter(request, prefix	+ "d8", length));
			String[] z2 = (JSPUtil.getParameter(request, prefix	+ "z2", length));
			String[] d5 = (JSPUtil.getParameter(request, prefix	+ "d5", length));
			String[] d4 = (JSPUtil.getParameter(request, prefix	+ "d4", length));
			String[] d7 = (JSPUtil.getParameter(request, prefix	+ "d7", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgDtTo = (JSPUtil.getParameter(request, prefix	+ "bkg_dt_to", length));
			String[] pkupYdCd = (JSPUtil.getParameter(request, prefix	+ "pkup_yd_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] d2 = (JSPUtil.getParameter(request, prefix	+ "d2", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] bkgTpsz = (JSPUtil.getParameter(request, prefix	+ "bkg_tpsz", length));
			String[] troDtFr = (JSPUtil.getParameter(request, prefix	+ "tro_dt_fr", length));
			String[] dTerm = (JSPUtil.getParameter(request, prefix	+ "d_term", length));
			String[] serviceProvider = (JSPUtil.getParameter(request, prefix	+ "service_provider", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] pupDtFr = (JSPUtil.getParameter(request, prefix	+ "pup_dt_fr", length));
			String[] pupDtTo = (JSPUtil.getParameter(request, prefix	+ "pup_dt_to", length));
			String[] woIssId = (JSPUtil.getParameter(request, prefix	+ "wo_iss_id", length));
			String[] bkgDtFr = (JSPUtil.getParameter(request, prefix	+ "bkg_dt_fr", length));
			String[] soCreDt = (JSPUtil.getParameter(request, prefix	+ "so_cre_dt", length));
			String[] soSts = (JSPUtil.getParameter(request, prefix	+ "so_sts", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] t4 = (JSPUtil.getParameter(request, prefix	+ "t4", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] soCreId = (JSPUtil.getParameter(request, prefix	+ "so_cre_id", length));
			String[] totSum = (JSPUtil.getParameter(request, prefix	+ "tot_sum", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] t2 = (JSPUtil.getParameter(request, prefix	+ "t2", length));
			String[] troTpsz = (JSPUtil.getParameter(request, prefix	+ "tro_tpsz", length));
			String[] dw = (JSPUtil.getParameter(request, prefix	+ "dw", length));
			String[] dx = (JSPUtil.getParameter(request, prefix	+ "dx", length));
			String[] dorArrDt = (JSPUtil.getParameter(request, prefix	+ "dor_arr_dt", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] deDt = (JSPUtil.getParameter(request, prefix	+ "de_dt", length));
			String[] doorSvcTp = (JSPUtil.getParameter(request, prefix	+ "door_svc_tp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] apntDt = (JSPUtil.getParameter(request, prefix	+ "apnt_dt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] a2 = (JSPUtil.getParameter(request, prefix	+ "a2", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] troDtTo = (JSPUtil.getParameter(request, prefix	+ "tro_dt_to", length));
			String[] a4 = (JSPUtil.getParameter(request, prefix	+ "a4", length));
			String[] f2 = (JSPUtil.getParameter(request, prefix	+ "f2", length));
			String[] f5 = (JSPUtil.getParameter(request, prefix	+ "f5", length));
			String[] s4 = (JSPUtil.getParameter(request, prefix	+ "s4", length));
			String[] f4 = (JSPUtil.getParameter(request, prefix	+ "f4", length));
			String[] troQty = (JSPUtil.getParameter(request, prefix	+ "tro_qty", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] troDt = (JSPUtil.getParameter(request, prefix	+ "tro_dt", length));
			String[] s2 = (JSPUtil.getParameter(request, prefix	+ "s2", length));
			String[] o2 = (JSPUtil.getParameter(request, prefix	+ "o2", length));
			String[] o4 = (JSPUtil.getParameter(request, prefix	+ "o4", length));
			String[] soFlg = (JSPUtil.getParameter(request, prefix	+ "so_flg", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] o5 = (JSPUtil.getParameter(request, prefix	+ "o5", length));
			String[] dorLocCd = (JSPUtil.getParameter(request, prefix	+ "dor_loc_cd", length));
			String[] rtnYdCd = (JSPUtil.getParameter(request, prefix	+ "rtn_yd_cd", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] r2 = (JSPUtil.getParameter(request, prefix	+ "r2", length));
			String[] r4 = (JSPUtil.getParameter(request, prefix	+ "r4", length));
			String[] rTerm = (JSPUtil.getParameter(request, prefix	+ "r_term", length));
			String[] r5 = (JSPUtil.getParameter(request, prefix	+ "r5", length));
			String[] a5 = (JSPUtil.getParameter(request, prefix	+ "a5", length));
			
			for (int i = 0; i < length; i++) {
				model = new TroUsaStatusListInVO();
				if (p4[i] != null)
					model.setP4(p4[i]);
				if (p2[i] != null)
					model.setP2(p2[i]);
				if (z4[i] != null)
					model.setZ4(z4[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (d9[i] != null)
					model.setD9(d9[i]);
				if (d8[i] != null)
					model.setD8(d8[i]);
				if (z2[i] != null)
					model.setZ2(z2[i]);
				if (d5[i] != null)
					model.setD5(d5[i]);
				if (d4[i] != null)
					model.setD4(d4[i]);
				if (d7[i] != null)
					model.setD7(d7[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgDtTo[i] != null)
					model.setBkgDtTo(bkgDtTo[i]);
				if (pkupYdCd[i] != null)
					model.setPkupYdCd(pkupYdCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (d2[i] != null)
					model.setD2(d2[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (bkgTpsz[i] != null)
					model.setBkgTpsz(bkgTpsz[i]);
				if (troDtFr[i] != null)
					model.setTroDtFr(troDtFr[i]);
				if (dTerm[i] != null)
					model.setDTerm(dTerm[i]);
				if (serviceProvider[i] != null)
					model.setServiceProvider(serviceProvider[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (pupDtFr[i] != null)
					model.setPupDtFr(pupDtFr[i]);
				if (pupDtTo[i] != null)
					model.setPupDtTo(pupDtTo[i]);
				if (woIssId[i] != null)
					model.setWoIssId(woIssId[i]);
				if (bkgDtFr[i] != null)
					model.setBkgDtFr(bkgDtFr[i]);
				if (soCreDt[i] != null)
					model.setSoCreDt(soCreDt[i]);
				if (soSts[i] != null)
					model.setSoSts(soSts[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (t4[i] != null)
					model.setT4(t4[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (soCreId[i] != null)
					model.setSoCreId(soCreId[i]);
				if (totSum[i] != null)
					model.setTotSum(totSum[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (t2[i] != null)
					model.setT2(t2[i]);
				if (troTpsz[i] != null)
					model.setTroTpsz(troTpsz[i]);
				if (dw[i] != null)
					model.setDw(dw[i]);
				if (dx[i] != null)
					model.setDx(dx[i]);
				if (dorArrDt[i] != null)
					model.setDorArrDt(dorArrDt[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (deDt[i] != null)
					model.setDeDt(deDt[i]);
				if (doorSvcTp[i] != null)
					model.setDoorSvcTp(doorSvcTp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (apntDt[i] != null)
					model.setApntDt(apntDt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (a2[i] != null)
					model.setA2(a2[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (troDtTo[i] != null)
					model.setTroDtTo(troDtTo[i]);
				if (a4[i] != null)
					model.setA4(a4[i]);
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
				if (troDt[i] != null)
					model.setTroDt(troDt[i]);
				if (s2[i] != null)
					model.setS2(s2[i]);
				if (o2[i] != null)
					model.setO2(o2[i]);
				if (o4[i] != null)
					model.setO4(o4[i]);
				if (soFlg[i] != null)
					model.setSoFlg(soFlg[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (o5[i] != null)
					model.setO5(o5[i]);
				if (dorLocCd[i] != null)
					model.setDorLocCd(dorLocCd[i]);
				if (rtnYdCd[i] != null)
					model.setRtnYdCd(rtnYdCd[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (r2[i] != null)
					model.setR2(r2[i]);
				if (r4[i] != null)
					model.setR4(r4[i]);
				if (rTerm[i] != null)
					model.setRTerm(rTerm[i]);
				if (r5[i] != null)
					model.setR5(r5[i]);
				if (a5[i] != null)
					model.setA5(a5[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTroUsaStatusListInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TroUsaStatusListInVO[]
	 */
	public TroUsaStatusListInVO[] getTroUsaStatusListInVOs(){
		TroUsaStatusListInVO[] vos = (TroUsaStatusListInVO[])models.toArray(new TroUsaStatusListInVO[models.size()]);
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
		this.p4 = this.p4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p2 = this.p2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.z4 = this.z4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d9 = this.d9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d8 = this.d8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.z2 = this.z2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5 = this.d5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4 = this.d4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7 = this.d7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDtTo = this.bkgDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCd = this.pkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2 = this.d2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTpsz = this.bkgTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troDtFr = this.troDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dTerm = this.dTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serviceProvider = this.serviceProvider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pupDtFr = this.pupDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pupDtTo = this.pupDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssId = this.woIssId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDtFr = this.bkgDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreDt = this.soCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSts = this.soSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t4 = this.t4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCreId = this.soCreId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSum = this.totSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t2 = this.t2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troTpsz = this.troTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dw = this.dw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dx = this.dx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorArrDt = this.dorArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deDt = this.deDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doorSvcTp = this.doorSvcTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apntDt = this.apntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2 = this.a2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troDtTo = this.troDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4 = this.a4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f2 = this.f2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f5 = this.f5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s4 = this.s4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.f4 = this.f4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troQty = this.troQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troDt = this.troDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.s2 = this.s2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2 = this.o2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4 = this.o4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soFlg = this.soFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5 = this.o5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorLocCd = this.dorLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnYdCd = this.rtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2 = this.r2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r4 = this.r4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rTerm = this.rTerm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5 = this.r5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5 = this.a5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
