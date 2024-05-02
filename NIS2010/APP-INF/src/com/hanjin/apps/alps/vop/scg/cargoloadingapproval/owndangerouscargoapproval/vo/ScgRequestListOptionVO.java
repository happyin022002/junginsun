/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ScgRequestListOptionVO.java
*@FileTitle : ScgRequestListOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.03
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2012.07.03 [CHM-201218537] SPCL CGO APVL for Own BKG lane code 입력 방식 변경
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
 * @author 조경완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScgRequestListOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScgRequestListOptionVO> models = new ArrayList<ScgRequestListOptionVO>();
	
	/* Column Info */
	private String slanCd24 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String slanCd23 = null;
	/* Column Info */
	private String slanCd26 = null;
	/* Column Info */
	private String slanCd25 = null;
	/* Column Info */
	private String slanCd28 = null;
	/* Column Info */
	private String slanCd27 = null;
	/* Column Info */
	private String slanCd29 = null;
	/* Column Info */
	private String imdgUnNoSeq = null;
	/* Column Info */
	private String scgFlg = null;
	/* Column Info */
	private String slanCd20 = null;
	/* Column Info */
	private String slanCd22 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String slanCd21 = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String toEtaDt = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rgnShpOprCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String slanCd30 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String aproRefNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String slanCd3 = null;
	/* Column Info */
	private String authFlg = null;
	/* Column Info */
	private String slanCd4 = null;
	/* Column Info */
	private String slanCd5 = null;
	/* Column Info */
	private String valOprTpCd = null;
	/* Column Info */
	private String slanCd6 = null;
	/* Column Info */
	private String slanCd1 = null;
	/* Column Info */
	private String slanCd2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fromEtaDt = null;
	/* Column Info */
	private String spclCgoAproRqstSeq = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String slanCd8 = null;
	/* Column Info */
	private String slanCd7 = null;
	/* Column Info */
	private String slanCd9 = null;
	/* Column Info */
	private String slanCd19 = null;
	/* Column Info */
	private String slanCd18 = null;
	/* Column Info */
	private String slanCd17 = null;
	/* Column Info */
	private String slanCd16 = null;
	/* Column Info */
	private String slanCd15 = null;
	/* Column Info */
	private String slanCd14 = null;
	/* Column Info */
	private String slanCd13 = null;
	/* Column Info */
	private String bookingNo = null;
	/* Column Info */
	private String slanCd12 = null;
	/* Column Info */
	private String slanCd11 = null;
	/* Column Info */
	private String slanCd10 = null;
	/* Column Info */
	private String emlSndNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String cgoOprCd = null;
	/* Column Info */
	private String prpShpNm = null;
	/* Column Info */
	private String rqstDtRange = null;
	/* Column Info */
	private String vpsEtaDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScgRequestListOptionVO() {}

	public ScgRequestListOptionVO(String ibflag, String pagerows, String bookingNo, String slanCd3, String authFlg, String slanCd4, String rgnShpOprCd, String slanCd5, String valOprTpCd, String slanCd6, String slanCd1, String slanCd2, String slanCd11, String slanCd10, String slanCd8, String slanCd7, String slanCd9, String scgFlg, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd, String cgoOprCd, String aproRefNo, String imdgUnNo, String imdgUnNoSeq, String imdgClssCd, String fromEtaDt, String toEtaDt, String shprNm, String prpShpNm, String emlSndNo, String updUsrId, String spclCgoAproRqstSeq, String bkgNo, String slanCd12, String slanCd13, String slanCd14, String slanCd15, String slanCd16, String slanCd17, String slanCd18, String slanCd19, String slanCd20, String slanCd21, String slanCd22, String slanCd23, String slanCd24, String slanCd25, String slanCd26, String slanCd27, String slanCd28, String slanCd29, String slanCd30, String rqstDtRange, String vpsEtaDt) {
		this.slanCd24 = slanCd24;
		this.vslCd = vslCd;
		this.slanCd23 = slanCd23;
		this.slanCd26 = slanCd26;
		this.slanCd25 = slanCd25;
		this.slanCd28 = slanCd28;
		this.slanCd27 = slanCd27;
		this.slanCd29 = slanCd29;
		this.imdgUnNoSeq = imdgUnNoSeq;
		this.scgFlg = scgFlg;
		this.slanCd20 = slanCd20;
		this.slanCd22 = slanCd22;
		this.pagerows = pagerows;
		this.slanCd21 = slanCd21;
		this.polCd = polCd;
		this.toEtaDt = toEtaDt;
		this.imdgUnNo = imdgUnNo;
		this.updUsrId = updUsrId;
		this.rgnShpOprCd = rgnShpOprCd;
		this.skdVoyNo = skdVoyNo;
		this.slanCd30 = slanCd30;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.aproRefNo = aproRefNo;
		this.imdgClssCd = imdgClssCd;
		this.slanCd3 = slanCd3;
		this.authFlg = authFlg;
		this.slanCd4 = slanCd4;
		this.slanCd5 = slanCd5;
		this.valOprTpCd = valOprTpCd;
		this.slanCd6 = slanCd6;
		this.slanCd1 = slanCd1;
		this.slanCd2 = slanCd2;
		this.ibflag = ibflag;
		this.fromEtaDt = fromEtaDt;
		this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
		this.shprNm = shprNm;
		this.slanCd8 = slanCd8;
		this.slanCd7 = slanCd7;
		this.slanCd9 = slanCd9;
		this.slanCd19 = slanCd19;
		this.slanCd18 = slanCd18;
		this.slanCd17 = slanCd17;
		this.slanCd16 = slanCd16;
		this.slanCd15 = slanCd15;
		this.slanCd14 = slanCd14;
		this.slanCd13 = slanCd13;
		this.bookingNo = bookingNo;
		this.slanCd12 = slanCd12;
		this.slanCd11 = slanCd11;
		this.slanCd10 = slanCd10;
		this.emlSndNo = emlSndNo;
		this.skdDirCd = skdDirCd;
		this.cgoOprCd = cgoOprCd;
		this.prpShpNm = prpShpNm;
		this.rqstDtRange = rqstDtRange;
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("slan_cd24", getSlanCd24());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("slan_cd23", getSlanCd23());
		this.hashColumns.put("slan_cd26", getSlanCd26());
		this.hashColumns.put("slan_cd25", getSlanCd25());
		this.hashColumns.put("slan_cd28", getSlanCd28());
		this.hashColumns.put("slan_cd27", getSlanCd27());
		this.hashColumns.put("slan_cd29", getSlanCd29());
		this.hashColumns.put("imdg_un_no_seq", getImdgUnNoSeq());
		this.hashColumns.put("scg_flg", getScgFlg());
		this.hashColumns.put("slan_cd20", getSlanCd20());
		this.hashColumns.put("slan_cd22", getSlanCd22());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("slan_cd21", getSlanCd21());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("to_eta_dt", getToEtaDt());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rgn_shp_opr_cd", getRgnShpOprCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("slan_cd30", getSlanCd30());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("apro_ref_no", getAproRefNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("slan_cd3", getSlanCd3());
		this.hashColumns.put("auth_flg", getAuthFlg());
		this.hashColumns.put("slan_cd4", getSlanCd4());
		this.hashColumns.put("slan_cd5", getSlanCd5());
		this.hashColumns.put("val_opr_tp_cd", getValOprTpCd());
		this.hashColumns.put("slan_cd6", getSlanCd6());
		this.hashColumns.put("slan_cd1", getSlanCd1());
		this.hashColumns.put("slan_cd2", getSlanCd2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("from_eta_dt", getFromEtaDt());
		this.hashColumns.put("spcl_cgo_apro_rqst_seq", getSpclCgoAproRqstSeq());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("slan_cd8", getSlanCd8());
		this.hashColumns.put("slan_cd7", getSlanCd7());
		this.hashColumns.put("slan_cd9", getSlanCd9());
		this.hashColumns.put("slan_cd19", getSlanCd19());
		this.hashColumns.put("slan_cd18", getSlanCd18());
		this.hashColumns.put("slan_cd17", getSlanCd17());
		this.hashColumns.put("slan_cd16", getSlanCd16());
		this.hashColumns.put("slan_cd15", getSlanCd15());
		this.hashColumns.put("slan_cd14", getSlanCd14());
		this.hashColumns.put("slan_cd13", getSlanCd13());
		this.hashColumns.put("booking_no", getBookingNo());
		this.hashColumns.put("slan_cd12", getSlanCd12());
		this.hashColumns.put("slan_cd11", getSlanCd11());
		this.hashColumns.put("slan_cd10", getSlanCd10());
		this.hashColumns.put("eml_snd_no", getEmlSndNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cgo_opr_cd", getCgoOprCd());
		this.hashColumns.put("prp_shp_nm", getPrpShpNm());
		this.hashColumns.put("rqst_dt_range", getRqstDtRange());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("slan_cd24", "slanCd24");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("slan_cd23", "slanCd23");
		this.hashFields.put("slan_cd26", "slanCd26");
		this.hashFields.put("slan_cd25", "slanCd25");
		this.hashFields.put("slan_cd28", "slanCd28");
		this.hashFields.put("slan_cd27", "slanCd27");
		this.hashFields.put("slan_cd29", "slanCd29");
		this.hashFields.put("imdg_un_no_seq", "imdgUnNoSeq");
		this.hashFields.put("scg_flg", "scgFlg");
		this.hashFields.put("slan_cd20", "slanCd20");
		this.hashFields.put("slan_cd22", "slanCd22");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("slan_cd21", "slanCd21");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("to_eta_dt", "toEtaDt");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rgn_shp_opr_cd", "rgnShpOprCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("slan_cd30", "slanCd30");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("apro_ref_no", "aproRefNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("slan_cd3", "slanCd3");
		this.hashFields.put("auth_flg", "authFlg");
		this.hashFields.put("slan_cd4", "slanCd4");
		this.hashFields.put("slan_cd5", "slanCd5");
		this.hashFields.put("val_opr_tp_cd", "valOprTpCd");
		this.hashFields.put("slan_cd6", "slanCd6");
		this.hashFields.put("slan_cd1", "slanCd1");
		this.hashFields.put("slan_cd2", "slanCd2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("from_eta_dt", "fromEtaDt");
		this.hashFields.put("spcl_cgo_apro_rqst_seq", "spclCgoAproRqstSeq");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("slan_cd8", "slanCd8");
		this.hashFields.put("slan_cd7", "slanCd7");
		this.hashFields.put("slan_cd9", "slanCd9");
		this.hashFields.put("slan_cd19", "slanCd19");
		this.hashFields.put("slan_cd18", "slanCd18");
		this.hashFields.put("slan_cd17", "slanCd17");
		this.hashFields.put("slan_cd16", "slanCd16");
		this.hashFields.put("slan_cd15", "slanCd15");
		this.hashFields.put("slan_cd14", "slanCd14");
		this.hashFields.put("slan_cd13", "slanCd13");
		this.hashFields.put("booking_no", "bookingNo");
		this.hashFields.put("slan_cd12", "slanCd12");
		this.hashFields.put("slan_cd11", "slanCd11");
		this.hashFields.put("slan_cd10", "slanCd10");
		this.hashFields.put("eml_snd_no", "emlSndNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cgo_opr_cd", "cgoOprCd");
		this.hashFields.put("prp_shp_nm", "prpShpNm");
		this.hashFields.put("rqst_dt_range", "rqstDtRange");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return slanCd24
	 */
	public String getSlanCd24() {
		return this.slanCd24;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd23
	 */
	public String getSlanCd23() {
		return this.slanCd23;
	}
	
	/**
	 * Column Info
	 * @return slanCd26
	 */
	public String getSlanCd26() {
		return this.slanCd26;
	}
	
	/**
	 * Column Info
	 * @return slanCd25
	 */
	public String getSlanCd25() {
		return this.slanCd25;
	}
	
	/**
	 * Column Info
	 * @return slanCd28
	 */
	public String getSlanCd28() {
		return this.slanCd28;
	}
	
	/**
	 * Column Info
	 * @return slanCd27
	 */
	public String getSlanCd27() {
		return this.slanCd27;
	}
	
	/**
	 * Column Info
	 * @return slanCd29
	 */
	public String getSlanCd29() {
		return this.slanCd29;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNoSeq
	 */
	public String getImdgUnNoSeq() {
		return this.imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @return scgFlg
	 */
	public String getScgFlg() {
		return this.scgFlg;
	}
	
	/**
	 * Column Info
	 * @return slanCd20
	 */
	public String getSlanCd20() {
		return this.slanCd20;
	}
	
	/**
	 * Column Info
	 * @return slanCd22
	 */
	public String getSlanCd22() {
		return this.slanCd22;
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
	 * @return slanCd21
	 */
	public String getSlanCd21() {
		return this.slanCd21;
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
	 * @return toEtaDt
	 */
	public String getToEtaDt() {
		return this.toEtaDt;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
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
	 * @return rgnShpOprCd
	 */
	public String getRgnShpOprCd() {
		return this.rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return slanCd30
	 */
	public String getSlanCd30() {
		return this.slanCd30;
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
	 * @return aproRefNo
	 */
	public String getAproRefNo() {
		return this.aproRefNo;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd3
	 */
	public String getSlanCd3() {
		return this.slanCd3;
	}
	
	/**
	 * Column Info
	 * @return authFlg
	 */
	public String getAuthFlg() {
		return this.authFlg;
	}
	
	/**
	 * Column Info
	 * @return slanCd4
	 */
	public String getSlanCd4() {
		return this.slanCd4;
	}
	
	/**
	 * Column Info
	 * @return slanCd5
	 */
	public String getSlanCd5() {
		return this.slanCd5;
	}
	
	/**
	 * Column Info
	 * @return valOprTpCd
	 */
	public String getValOprTpCd() {
		return this.valOprTpCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd6
	 */
	public String getSlanCd6() {
		return this.slanCd6;
	}
	
	/**
	 * Column Info
	 * @return slanCd1
	 */
	public String getSlanCd1() {
		return this.slanCd1;
	}
	
	/**
	 * Column Info
	 * @return slanCd2
	 */
	public String getSlanCd2() {
		return this.slanCd2;
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
	 * @return fromEtaDt
	 */
	public String getFromEtaDt() {
		return this.fromEtaDt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAproRqstSeq
	 */
	public String getSpclCgoAproRqstSeq() {
		return this.spclCgoAproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return slanCd8
	 */
	public String getSlanCd8() {
		return this.slanCd8;
	}
	
	/**
	 * Column Info
	 * @return slanCd7
	 */
	public String getSlanCd7() {
		return this.slanCd7;
	}
	
	/**
	 * Column Info
	 * @return slanCd9
	 */
	public String getSlanCd9() {
		return this.slanCd9;
	}
	
	/**
	 * Column Info
	 * @return slanCd19
	 */
	public String getSlanCd19() {
		return this.slanCd19;
	}
	
	/**
	 * Column Info
	 * @return slanCd18
	 */
	public String getSlanCd18() {
		return this.slanCd18;
	}
	
	/**
	 * Column Info
	 * @return slanCd17
	 */
	public String getSlanCd17() {
		return this.slanCd17;
	}
	
	/**
	 * Column Info
	 * @return slanCd16
	 */
	public String getSlanCd16() {
		return this.slanCd16;
	}
	
	/**
	 * Column Info
	 * @return slanCd15
	 */
	public String getSlanCd15() {
		return this.slanCd15;
	}
	
	/**
	 * Column Info
	 * @return slanCd14
	 */
	public String getSlanCd14() {
		return this.slanCd14;
	}
	
	/**
	 * Column Info
	 * @return slanCd13
	 */
	public String getSlanCd13() {
		return this.slanCd13;
	}
	
	/**
	 * Column Info
	 * @return bookingNo
	 */
	public String getBookingNo() {
		return this.bookingNo;
	}
	
	/**
	 * Column Info
	 * @return slanCd12
	 */
	public String getSlanCd12() {
		return this.slanCd12;
	}
	
	/**
	 * Column Info
	 * @return slanCd11
	 */
	public String getSlanCd11() {
		return this.slanCd11;
	}
	
	/**
	 * Column Info
	 * @return slanCd10
	 */
	public String getSlanCd10() {
		return this.slanCd10;
	}
	
	/**
	 * Column Info
	 * @return emlSndNo
	 */
	public String getEmlSndNo() {
		return this.emlSndNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cgoOprCd
	 */
	public String getCgoOprCd() {
		return this.cgoOprCd;
	}
	
	/**
	 * Column Info
	 * @return prpShpNm
	 */
	public String getPrpShpNm() {
		return this.prpShpNm;
	}
	

	/**
	 * Column Info
	 * @param slanCd24
	 */
	public void setSlanCd24(String slanCd24) {
		this.slanCd24 = slanCd24;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd23
	 */
	public void setSlanCd23(String slanCd23) {
		this.slanCd23 = slanCd23;
	}
	
	/**
	 * Column Info
	 * @param slanCd26
	 */
	public void setSlanCd26(String slanCd26) {
		this.slanCd26 = slanCd26;
	}
	
	/**
	 * Column Info
	 * @param slanCd25
	 */
	public void setSlanCd25(String slanCd25) {
		this.slanCd25 = slanCd25;
	}
	
	/**
	 * Column Info
	 * @param slanCd28
	 */
	public void setSlanCd28(String slanCd28) {
		this.slanCd28 = slanCd28;
	}
	
	/**
	 * Column Info
	 * @param slanCd27
	 */
	public void setSlanCd27(String slanCd27) {
		this.slanCd27 = slanCd27;
	}
	
	/**
	 * Column Info
	 * @param slanCd29
	 */
	public void setSlanCd29(String slanCd29) {
		this.slanCd29 = slanCd29;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNoSeq
	 */
	public void setImdgUnNoSeq(String imdgUnNoSeq) {
		this.imdgUnNoSeq = imdgUnNoSeq;
	}
	
	/**
	 * Column Info
	 * @param scgFlg
	 */
	public void setScgFlg(String scgFlg) {
		this.scgFlg = scgFlg;
	}
	
	/**
	 * Column Info
	 * @param slanCd20
	 */
	public void setSlanCd20(String slanCd20) {
		this.slanCd20 = slanCd20;
	}
	
	/**
	 * Column Info
	 * @param slanCd22
	 */
	public void setSlanCd22(String slanCd22) {
		this.slanCd22 = slanCd22;
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
	 * @param slanCd21
	 */
	public void setSlanCd21(String slanCd21) {
		this.slanCd21 = slanCd21;
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
	 * @param toEtaDt
	 */
	public void setToEtaDt(String toEtaDt) {
		this.toEtaDt = toEtaDt;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
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
	 * @param rgnShpOprCd
	 */
	public void setRgnShpOprCd(String rgnShpOprCd) {
		this.rgnShpOprCd = rgnShpOprCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param slanCd30
	 */
	public void setSlanCd30(String slanCd30) {
		this.slanCd30 = slanCd30;
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
	 * @param aproRefNo
	 */
	public void setAproRefNo(String aproRefNo) {
		this.aproRefNo = aproRefNo;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd3
	 */
	public void setSlanCd3(String slanCd3) {
		this.slanCd3 = slanCd3;
	}
	
	/**
	 * Column Info
	 * @param authFlg
	 */
	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}
	
	/**
	 * Column Info
	 * @param slanCd4
	 */
	public void setSlanCd4(String slanCd4) {
		this.slanCd4 = slanCd4;
	}
	
	/**
	 * Column Info
	 * @param slanCd5
	 */
	public void setSlanCd5(String slanCd5) {
		this.slanCd5 = slanCd5;
	}
	
	/**
	 * Column Info
	 * @param valOprTpCd
	 */
	public void setValOprTpCd(String valOprTpCd) {
		this.valOprTpCd = valOprTpCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd6
	 */
	public void setSlanCd6(String slanCd6) {
		this.slanCd6 = slanCd6;
	}
	
	/**
	 * Column Info
	 * @param slanCd1
	 */
	public void setSlanCd1(String slanCd1) {
		this.slanCd1 = slanCd1;
	}
	
	/**
	 * Column Info
	 * @param slanCd2
	 */
	public void setSlanCd2(String slanCd2) {
		this.slanCd2 = slanCd2;
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
	 * @param fromEtaDt
	 */
	public void setFromEtaDt(String fromEtaDt) {
		this.fromEtaDt = fromEtaDt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAproRqstSeq
	 */
	public void setSpclCgoAproRqstSeq(String spclCgoAproRqstSeq) {
		this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param slanCd8
	 */
	public void setSlanCd8(String slanCd8) {
		this.slanCd8 = slanCd8;
	}
	
	/**
	 * Column Info
	 * @param slanCd7
	 */
	public void setSlanCd7(String slanCd7) {
		this.slanCd7 = slanCd7;
	}
	
	/**
	 * Column Info
	 * @param slanCd9
	 */
	public void setSlanCd9(String slanCd9) {
		this.slanCd9 = slanCd9;
	}
	
	/**
	 * Column Info
	 * @param slanCd19
	 */
	public void setSlanCd19(String slanCd19) {
		this.slanCd19 = slanCd19;
	}
	
	/**
	 * Column Info
	 * @param slanCd18
	 */
	public void setSlanCd18(String slanCd18) {
		this.slanCd18 = slanCd18;
	}
	
	/**
	 * Column Info
	 * @param slanCd17
	 */
	public void setSlanCd17(String slanCd17) {
		this.slanCd17 = slanCd17;
	}
	
	/**
	 * Column Info
	 * @param slanCd16
	 */
	public void setSlanCd16(String slanCd16) {
		this.slanCd16 = slanCd16;
	}
	
	/**
	 * Column Info
	 * @param slanCd15
	 */
	public void setSlanCd15(String slanCd15) {
		this.slanCd15 = slanCd15;
	}
	
	/**
	 * Column Info
	 * @param slanCd14
	 */
	public void setSlanCd14(String slanCd14) {
		this.slanCd14 = slanCd14;
	}
	
	/**
	 * Column Info
	 * @param slanCd13
	 */
	public void setSlanCd13(String slanCd13) {
		this.slanCd13 = slanCd13;
	}
	
	/**
	 * Column Info
	 * @param bookingNo
	 */
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	
	/**
	 * Column Info
	 * @param slanCd12
	 */
	public void setSlanCd12(String slanCd12) {
		this.slanCd12 = slanCd12;
	}
	
	/**
	 * Column Info
	 * @param slanCd11
	 */
	public void setSlanCd11(String slanCd11) {
		this.slanCd11 = slanCd11;
	}
	
	/**
	 * Column Info
	 * @param slanCd10
	 */
	public void setSlanCd10(String slanCd10) {
		this.slanCd10 = slanCd10;
	}
	
	/**
	 * Column Info
	 * @param emlSndNo
	 */
	public void setEmlSndNo(String emlSndNo) {
		this.emlSndNo = emlSndNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cgoOprCd
	 */
	public void setCgoOprCd(String cgoOprCd) {
		this.cgoOprCd = cgoOprCd;
	}
	
	/**
	 * Column Info
	 * @param prpShpNm
	 */
	public void setPrpShpNm(String prpShpNm) {
		this.prpShpNm = prpShpNm;
	}
	
	/**
	 * Column Info
	 * @param rqstDtRange
	 */
	public String getRqstDtRange() {
		return rqstDtRange;
	}

	/**
	 * Column Info
	 * @param rqstDtRange
	 */
	public void setRqstDtRange(String rqstDtRange) {
		this.rqstDtRange = rqstDtRange;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
		setSlanCd24(JSPUtil.getParameter(request, prefix + "slan_cd24", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSlanCd23(JSPUtil.getParameter(request, prefix + "slan_cd23", ""));
		setSlanCd26(JSPUtil.getParameter(request, prefix + "slan_cd26", ""));
		setSlanCd25(JSPUtil.getParameter(request, prefix + "slan_cd25", ""));
		setSlanCd28(JSPUtil.getParameter(request, prefix + "slan_cd28", ""));
		setSlanCd27(JSPUtil.getParameter(request, prefix + "slan_cd27", ""));
		setSlanCd29(JSPUtil.getParameter(request, prefix + "slan_cd29", ""));
		setImdgUnNoSeq(JSPUtil.getParameter(request, prefix + "imdg_un_no_seq", ""));
		setScgFlg(JSPUtil.getParameter(request, prefix + "scg_flg", ""));
		setSlanCd20(JSPUtil.getParameter(request, prefix + "slan_cd20", ""));
		setSlanCd22(JSPUtil.getParameter(request, prefix + "slan_cd22", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSlanCd21(JSPUtil.getParameter(request, prefix + "slan_cd21", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setToEtaDt(JSPUtil.getParameter(request, prefix + "to_eta_dt", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRgnShpOprCd(JSPUtil.getParameter(request, prefix + "rgn_shp_opr_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSlanCd30(JSPUtil.getParameter(request, prefix + "slan_cd30", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setAproRefNo(JSPUtil.getParameter(request, prefix + "apro_ref_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setSlanCd3(JSPUtil.getParameter(request, prefix + "slan_cd3", ""));
		setAuthFlg(JSPUtil.getParameter(request, prefix + "auth_flg", ""));
		setSlanCd4(JSPUtil.getParameter(request, prefix + "slan_cd4", ""));
		setSlanCd5(JSPUtil.getParameter(request, prefix + "slan_cd5", ""));
		setValOprTpCd(JSPUtil.getParameter(request, prefix + "val_opr_tp_cd", ""));
		setSlanCd6(JSPUtil.getParameter(request, prefix + "slan_cd6", ""));
		setSlanCd1(JSPUtil.getParameter(request, prefix + "slan_cd1", ""));
		setSlanCd2(JSPUtil.getParameter(request, prefix + "slan_cd2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFromEtaDt(JSPUtil.getParameter(request, prefix + "from_eta_dt", ""));
		setSpclCgoAproRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setSlanCd8(JSPUtil.getParameter(request, prefix + "slan_cd8", ""));
		setSlanCd7(JSPUtil.getParameter(request, prefix + "slan_cd7", ""));
		setSlanCd9(JSPUtil.getParameter(request, prefix + "slan_cd9", ""));
		setSlanCd19(JSPUtil.getParameter(request, prefix + "slan_cd19", ""));
		setSlanCd18(JSPUtil.getParameter(request, prefix + "slan_cd18", ""));
		setSlanCd17(JSPUtil.getParameter(request, prefix + "slan_cd17", ""));
		setSlanCd16(JSPUtil.getParameter(request, prefix + "slan_cd16", ""));
		setSlanCd15(JSPUtil.getParameter(request, prefix + "slan_cd15", ""));
		setSlanCd14(JSPUtil.getParameter(request, prefix + "slan_cd14", ""));
		setSlanCd13(JSPUtil.getParameter(request, prefix + "slan_cd13", ""));
		setBookingNo(JSPUtil.getParameter(request, prefix + "booking_no", ""));
		setSlanCd12(JSPUtil.getParameter(request, prefix + "slan_cd12", ""));
		setSlanCd11(JSPUtil.getParameter(request, prefix + "slan_cd11", ""));
		setSlanCd10(JSPUtil.getParameter(request, prefix + "slan_cd10", ""));
		setEmlSndNo(JSPUtil.getParameter(request, prefix + "eml_snd_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCgoOprCd(JSPUtil.getParameter(request, prefix + "cgo_opr_cd", ""));
		setPrpShpNm(JSPUtil.getParameter(request, prefix + "prp_shp_nm", ""));
		setRqstDtRange(JSPUtil.getParameter(request, prefix + "rqst_dt_range", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgRequestListOptionVO[]
	 */
	public ScgRequestListOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScgRequestListOptionVO[]
	 */
	public ScgRequestListOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScgRequestListOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] slanCd24 = (JSPUtil.getParameter(request, prefix	+ "slan_cd24", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] slanCd23 = (JSPUtil.getParameter(request, prefix	+ "slan_cd23", length));
			String[] slanCd26 = (JSPUtil.getParameter(request, prefix	+ "slan_cd26", length));
			String[] slanCd25 = (JSPUtil.getParameter(request, prefix	+ "slan_cd25", length));
			String[] slanCd28 = (JSPUtil.getParameter(request, prefix	+ "slan_cd28", length));
			String[] slanCd27 = (JSPUtil.getParameter(request, prefix	+ "slan_cd27", length));
			String[] slanCd29 = (JSPUtil.getParameter(request, prefix	+ "slan_cd29", length));
			String[] imdgUnNoSeq = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no_seq", length));
			String[] scgFlg = (JSPUtil.getParameter(request, prefix	+ "scg_flg", length));
			String[] slanCd20 = (JSPUtil.getParameter(request, prefix	+ "slan_cd20", length));
			String[] slanCd22 = (JSPUtil.getParameter(request, prefix	+ "slan_cd22", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] slanCd21 = (JSPUtil.getParameter(request, prefix	+ "slan_cd21", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] toEtaDt = (JSPUtil.getParameter(request, prefix	+ "to_eta_dt", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rgnShpOprCd = (JSPUtil.getParameter(request, prefix	+ "rgn_shp_opr_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] slanCd30 = (JSPUtil.getParameter(request, prefix	+ "slan_cd30", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] aproRefNo = (JSPUtil.getParameter(request, prefix	+ "apro_ref_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] slanCd3 = (JSPUtil.getParameter(request, prefix	+ "slan_cd3", length));
			String[] authFlg = (JSPUtil.getParameter(request, prefix	+ "auth_flg", length));
			String[] slanCd4 = (JSPUtil.getParameter(request, prefix	+ "slan_cd4", length));
			String[] slanCd5 = (JSPUtil.getParameter(request, prefix	+ "slan_cd5", length));
			String[] valOprTpCd = (JSPUtil.getParameter(request, prefix	+ "val_opr_tp_cd", length));
			String[] slanCd6 = (JSPUtil.getParameter(request, prefix	+ "slan_cd6", length));
			String[] slanCd1 = (JSPUtil.getParameter(request, prefix	+ "slan_cd1", length));
			String[] slanCd2 = (JSPUtil.getParameter(request, prefix	+ "slan_cd2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fromEtaDt = (JSPUtil.getParameter(request, prefix	+ "from_eta_dt", length));
			String[] spclCgoAproRqstSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_apro_rqst_seq", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] slanCd8 = (JSPUtil.getParameter(request, prefix	+ "slan_cd8", length));
			String[] slanCd7 = (JSPUtil.getParameter(request, prefix	+ "slan_cd7", length));
			String[] slanCd9 = (JSPUtil.getParameter(request, prefix	+ "slan_cd9", length));
			String[] slanCd19 = (JSPUtil.getParameter(request, prefix	+ "slan_cd19", length));
			String[] slanCd18 = (JSPUtil.getParameter(request, prefix	+ "slan_cd18", length));
			String[] slanCd17 = (JSPUtil.getParameter(request, prefix	+ "slan_cd17", length));
			String[] slanCd16 = (JSPUtil.getParameter(request, prefix	+ "slan_cd16", length));
			String[] slanCd15 = (JSPUtil.getParameter(request, prefix	+ "slan_cd15", length));
			String[] slanCd14 = (JSPUtil.getParameter(request, prefix	+ "slan_cd14", length));
			String[] slanCd13 = (JSPUtil.getParameter(request, prefix	+ "slan_cd13", length));
			String[] bookingNo = (JSPUtil.getParameter(request, prefix	+ "booking_no", length));
			String[] slanCd12 = (JSPUtil.getParameter(request, prefix	+ "slan_cd12", length));
			String[] slanCd11 = (JSPUtil.getParameter(request, prefix	+ "slan_cd11", length));
			String[] slanCd10 = (JSPUtil.getParameter(request, prefix	+ "slan_cd10", length));
			String[] emlSndNo = (JSPUtil.getParameter(request, prefix	+ "eml_snd_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] cgoOprCd = (JSPUtil.getParameter(request, prefix	+ "cgo_opr_cd", length));
			String[] prpShpNm = (JSPUtil.getParameter(request, prefix	+ "prp_shp_nm", length));
			String[] rqstDtRange = (JSPUtil.getParameter(request, prefix	+ "rqst_dt_range", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScgRequestListOptionVO();
				if (slanCd24[i] != null)
					model.setSlanCd24(slanCd24[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (slanCd23[i] != null)
					model.setSlanCd23(slanCd23[i]);
				if (slanCd26[i] != null)
					model.setSlanCd26(slanCd26[i]);
				if (slanCd25[i] != null)
					model.setSlanCd25(slanCd25[i]);
				if (slanCd28[i] != null)
					model.setSlanCd28(slanCd28[i]);
				if (slanCd27[i] != null)
					model.setSlanCd27(slanCd27[i]);
				if (slanCd29[i] != null)
					model.setSlanCd29(slanCd29[i]);
				if (imdgUnNoSeq[i] != null)
					model.setImdgUnNoSeq(imdgUnNoSeq[i]);
				if (scgFlg[i] != null)
					model.setScgFlg(scgFlg[i]);
				if (slanCd20[i] != null)
					model.setSlanCd20(slanCd20[i]);
				if (slanCd22[i] != null)
					model.setSlanCd22(slanCd22[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (slanCd21[i] != null)
					model.setSlanCd21(slanCd21[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (toEtaDt[i] != null)
					model.setToEtaDt(toEtaDt[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rgnShpOprCd[i] != null)
					model.setRgnShpOprCd(rgnShpOprCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (slanCd30[i] != null)
					model.setSlanCd30(slanCd30[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (aproRefNo[i] != null)
					model.setAproRefNo(aproRefNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (slanCd3[i] != null)
					model.setSlanCd3(slanCd3[i]);
				if (authFlg[i] != null)
					model.setAuthFlg(authFlg[i]);
				if (slanCd4[i] != null)
					model.setSlanCd4(slanCd4[i]);
				if (slanCd5[i] != null)
					model.setSlanCd5(slanCd5[i]);
				if (valOprTpCd[i] != null)
					model.setValOprTpCd(valOprTpCd[i]);
				if (slanCd6[i] != null)
					model.setSlanCd6(slanCd6[i]);
				if (slanCd1[i] != null)
					model.setSlanCd1(slanCd1[i]);
				if (slanCd2[i] != null)
					model.setSlanCd2(slanCd2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fromEtaDt[i] != null)
					model.setFromEtaDt(fromEtaDt[i]);
				if (spclCgoAproRqstSeq[i] != null)
					model.setSpclCgoAproRqstSeq(spclCgoAproRqstSeq[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (slanCd8[i] != null)
					model.setSlanCd8(slanCd8[i]);
				if (slanCd7[i] != null)
					model.setSlanCd7(slanCd7[i]);
				if (slanCd9[i] != null)
					model.setSlanCd9(slanCd9[i]);
				if (slanCd19[i] != null)
					model.setSlanCd19(slanCd19[i]);
				if (slanCd18[i] != null)
					model.setSlanCd18(slanCd18[i]);
				if (slanCd17[i] != null)
					model.setSlanCd17(slanCd17[i]);
				if (slanCd16[i] != null)
					model.setSlanCd16(slanCd16[i]);
				if (slanCd15[i] != null)
					model.setSlanCd15(slanCd15[i]);
				if (slanCd14[i] != null)
					model.setSlanCd14(slanCd14[i]);
				if (slanCd13[i] != null)
					model.setSlanCd13(slanCd13[i]);
				if (bookingNo[i] != null)
					model.setBookingNo(bookingNo[i]);
				if (slanCd12[i] != null)
					model.setSlanCd12(slanCd12[i]);
				if (slanCd11[i] != null)
					model.setSlanCd11(slanCd11[i]);
				if (slanCd10[i] != null)
					model.setSlanCd10(slanCd10[i]);
				if (emlSndNo[i] != null)
					model.setEmlSndNo(emlSndNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (cgoOprCd[i] != null)
					model.setCgoOprCd(cgoOprCd[i]);
				if (prpShpNm[i] != null)
					model.setPrpShpNm(prpShpNm[i]);
				if (rqstDtRange[i] != null)
					model.setRqstDtRange(rqstDtRange[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScgRequestListOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScgRequestListOptionVO[]
	 */
	public ScgRequestListOptionVO[] getScgRequestListOptionVOs(){
		ScgRequestListOptionVO[] vos = (ScgRequestListOptionVO[])models.toArray(new ScgRequestListOptionVO[models.size()]);
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
		this.slanCd24 = this.slanCd24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd23 = this.slanCd23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd26 = this.slanCd26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd25 = this.slanCd25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd28 = this.slanCd28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd27 = this.slanCd27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd29 = this.slanCd29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNoSeq = this.imdgUnNoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgFlg = this.scgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd20 = this.slanCd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd22 = this.slanCd22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd21 = this.slanCd21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEtaDt = this.toEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnShpOprCd = this.rgnShpOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd30 = this.slanCd30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRefNo = this.aproRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd3 = this.slanCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authFlg = this.authFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd4 = this.slanCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd5 = this.slanCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valOprTpCd = this.valOprTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd6 = this.slanCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd1 = this.slanCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd2 = this.slanCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromEtaDt = this.fromEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproRqstSeq = this.spclCgoAproRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd8 = this.slanCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd7 = this.slanCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd9 = this.slanCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd19 = this.slanCd19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd18 = this.slanCd18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd17 = this.slanCd17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd16 = this.slanCd16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd15 = this.slanCd15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd14 = this.slanCd14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd13 = this.slanCd13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bookingNo = this.bookingNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd12 = this.slanCd12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd11 = this.slanCd11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd10 = this.slanCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndNo = this.emlSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoOprCd = this.cgoOprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prpShpNm = this.prpShpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDtRange = this.rqstDtRange .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
