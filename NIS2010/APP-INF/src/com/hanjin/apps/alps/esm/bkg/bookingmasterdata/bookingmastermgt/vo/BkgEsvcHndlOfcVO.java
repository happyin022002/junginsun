/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BkgEsvcHndlOfcVO.java
*@FileTitle : BkgEsvcHndlOfcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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

public class BkgEsvcHndlOfcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgEsvcHndlOfcVO> models = new ArrayList<BkgEsvcHndlOfcVO>();
	
	/* Column Info */
	private String hndlOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgNtfcEml = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String ctrlOfcCd29 = null;
	/* Column Info */
	private String ctrlOfcCd28 = null;
	/* Column Info */
	private String ctrlOfcCd25 = null;
	/* Column Info */
	private String ctrlOfcCd24 = null;
	/* Column Info */
	private String ctrlOfcCd27 = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String ctrlOfcCd26 = null;
	/* Column Info */
	private String ctrlOfcCd21 = null;
	/* Column Info */
	private String subGrpCtnt = null;
	/* Column Info */
	private String ctrlOfcCd20 = null;
	/* Column Info */
	private String subGsoOfcCd = null;
	/* Column Info */
	private String ctrlOfcCd23 = null;
	/* Column Info */
	private String ctrlOfcCd22 = null;
	/* Column Info */
	private String chkOp = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String gsoOfcCd = null;
	/* Column Info */
	private String ctrlOfcCd10 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrlOfcCd11 = null;
	/* Column Info */
	private String ctrlOfcCd12 = null;
	/* Column Info */
	private String ctrlOfcCd13 = null;
	/* Column Info */
	private String ctrlOfcCd14 = null;
	/* Column Info */
	private String ctrlOfcCd15 = null;
	/* Column Info */
	private String ctrlOfcCd16 = null;
	/* Column Info */
	private String ctrlOfcCd17 = null;
	/* Column Info */
	private String ctrlOfcCd18 = null;
	/* Column Info */
	private String ctrlOfcCd19 = null;
	/* Column Info */
	private String rgnOfcCd = null;
	/* Column Info */
	private String ctrlOfcCd5 = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ctrlOfcCd4 = null;
	/* Column Info */
	private String ctrlOfcCd3 = null;
	/* Column Info */
	private String ctrlOfcCd2 = null;
	/* Column Info */
	private String ctrlOfcCd9 = null;
	/* Column Info */
	private String ctrlOfcCd8 = null;
	/* Column Info */
	private String ctrlOfcCd7 = null;
	/* Column Info */
	private String useFlg = null;
	/* Column Info */
	private String ctrlOfcCd6 = null;
	/* Column Info */
	private String siNtfcEml = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String hndlOfcSeq = null;
	/* Column Info */
	private String ctrlOfcCd0 = null;
	/* Column Info */
	private String ctrlOfcCd1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgEsvcHndlOfcVO() {}

	public BkgEsvcHndlOfcVO(String ibflag, String pagerows, String hndlOfcCd, String bkgNtfcEml, String updUsrId, String bkgOfcCd, String ctrlOfcCd29, String ctrlOfcCd28, String ctrlOfcCd25, String ctrlOfcCd24, String ctrlOfcCd27, String ctrlOfcCd26, String ctrlOfcCd, String ctrlOfcCd21, String ctrlOfcCd20, String subGrpCtnt, String ctrlOfcCd23, String ctrlOfcCd22, String chkOp, String creUsrId, String porCd, String creDt, String gsoOfcCd, String ctrlOfcCd10, String ctrlOfcCd11, String ctrlOfcCd12, String ctrlOfcCd13, String ctrlOfcCd14, String ctrlOfcCd15, String ctrlOfcCd16, String ctrlOfcCd17, String ctrlOfcCd18, String ctrlOfcCd19, String rgnOfcCd, String ctrlOfcCd5, String updDt, String ctrlOfcCd4, String ctrlOfcCd3, String ctrlOfcCd2, String ctrlOfcCd9, String ctrlOfcCd8, String ctrlOfcCd7, String useFlg, String ctrlOfcCd6, String siNtfcEml, String ofcCd, String hndlOfcSeq, String ctrlOfcCd0, String ctrlOfcCd1, String subGsoOfcCd) {
		this.hndlOfcCd = hndlOfcCd;
		this.pagerows = pagerows;
		this.bkgNtfcEml = bkgNtfcEml;
		this.updUsrId = updUsrId;
		this.bkgOfcCd = bkgOfcCd;
		this.ctrlOfcCd29 = ctrlOfcCd29;
		this.ctrlOfcCd28 = ctrlOfcCd28;
		this.ctrlOfcCd25 = ctrlOfcCd25;
		this.ctrlOfcCd24 = ctrlOfcCd24;
		this.ctrlOfcCd27 = ctrlOfcCd27;
		this.ctrlOfcCd = ctrlOfcCd;
		this.ctrlOfcCd26 = ctrlOfcCd26;
		this.ctrlOfcCd21 = ctrlOfcCd21;
		this.subGrpCtnt = subGrpCtnt;
		this.ctrlOfcCd20 = ctrlOfcCd20;
		this.subGsoOfcCd = subGsoOfcCd;
		this.ctrlOfcCd23 = ctrlOfcCd23;
		this.ctrlOfcCd22 = ctrlOfcCd22;
		this.chkOp = chkOp;
		this.creUsrId = creUsrId;
		this.porCd = porCd;
		this.creDt = creDt;
		this.gsoOfcCd = gsoOfcCd;
		this.ctrlOfcCd10 = ctrlOfcCd10;
		this.ibflag = ibflag;
		this.ctrlOfcCd11 = ctrlOfcCd11;
		this.ctrlOfcCd12 = ctrlOfcCd12;
		this.ctrlOfcCd13 = ctrlOfcCd13;
		this.ctrlOfcCd14 = ctrlOfcCd14;
		this.ctrlOfcCd15 = ctrlOfcCd15;
		this.ctrlOfcCd16 = ctrlOfcCd16;
		this.ctrlOfcCd17 = ctrlOfcCd17;
		this.ctrlOfcCd18 = ctrlOfcCd18;
		this.ctrlOfcCd19 = ctrlOfcCd19;
		this.rgnOfcCd = rgnOfcCd;
		this.ctrlOfcCd5 = ctrlOfcCd5;
		this.updDt = updDt;
		this.ctrlOfcCd4 = ctrlOfcCd4;
		this.ctrlOfcCd3 = ctrlOfcCd3;
		this.ctrlOfcCd2 = ctrlOfcCd2;
		this.ctrlOfcCd9 = ctrlOfcCd9;
		this.ctrlOfcCd8 = ctrlOfcCd8;
		this.ctrlOfcCd7 = ctrlOfcCd7;
		this.useFlg = useFlg;
		this.ctrlOfcCd6 = ctrlOfcCd6;
		this.siNtfcEml = siNtfcEml;
		this.ofcCd = ofcCd;
		this.hndlOfcSeq = hndlOfcSeq;
		this.ctrlOfcCd0 = ctrlOfcCd0;
		this.ctrlOfcCd1 = ctrlOfcCd1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_ntfc_eml", getBkgNtfcEml());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("ctrl_ofc_cd_29", getCtrlOfcCd29());
		this.hashColumns.put("ctrl_ofc_cd_28", getCtrlOfcCd28());
		this.hashColumns.put("ctrl_ofc_cd_25", getCtrlOfcCd25());
		this.hashColumns.put("ctrl_ofc_cd_24", getCtrlOfcCd24());
		this.hashColumns.put("ctrl_ofc_cd_27", getCtrlOfcCd27());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("ctrl_ofc_cd_26", getCtrlOfcCd26());
		this.hashColumns.put("ctrl_ofc_cd_21", getCtrlOfcCd21());
		this.hashColumns.put("sub_grp_ctnt", getSubGrpCtnt());
		this.hashColumns.put("ctrl_ofc_cd_20", getCtrlOfcCd20());
		this.hashColumns.put("sub_gso_ofc_cd", getSubGsoOfcCd());
		this.hashColumns.put("ctrl_ofc_cd_23", getCtrlOfcCd23());
		this.hashColumns.put("ctrl_ofc_cd_22", getCtrlOfcCd22());
		this.hashColumns.put("chk_op", getChkOp());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("gso_ofc_cd", getGsoOfcCd());
		this.hashColumns.put("ctrl_ofc_cd_10", getCtrlOfcCd10());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrl_ofc_cd_11", getCtrlOfcCd11());
		this.hashColumns.put("ctrl_ofc_cd_12", getCtrlOfcCd12());
		this.hashColumns.put("ctrl_ofc_cd_13", getCtrlOfcCd13());
		this.hashColumns.put("ctrl_ofc_cd_14", getCtrlOfcCd14());
		this.hashColumns.put("ctrl_ofc_cd_15", getCtrlOfcCd15());
		this.hashColumns.put("ctrl_ofc_cd_16", getCtrlOfcCd16());
		this.hashColumns.put("ctrl_ofc_cd_17", getCtrlOfcCd17());
		this.hashColumns.put("ctrl_ofc_cd_18", getCtrlOfcCd18());
		this.hashColumns.put("ctrl_ofc_cd_19", getCtrlOfcCd19());
		this.hashColumns.put("rgn_ofc_cd", getRgnOfcCd());
		this.hashColumns.put("ctrl_ofc_cd_5", getCtrlOfcCd5());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ctrl_ofc_cd_4", getCtrlOfcCd4());
		this.hashColumns.put("ctrl_ofc_cd_3", getCtrlOfcCd3());
		this.hashColumns.put("ctrl_ofc_cd_2", getCtrlOfcCd2());
		this.hashColumns.put("ctrl_ofc_cd_9", getCtrlOfcCd9());
		this.hashColumns.put("ctrl_ofc_cd_8", getCtrlOfcCd8());
		this.hashColumns.put("ctrl_ofc_cd_7", getCtrlOfcCd7());
		this.hashColumns.put("use_flg", getUseFlg());
		this.hashColumns.put("ctrl_ofc_cd_6", getCtrlOfcCd6());
		this.hashColumns.put("si_ntfc_eml", getSiNtfcEml());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("hndl_ofc_seq", getHndlOfcSeq());
		this.hashColumns.put("ctrl_ofc_cd_0", getCtrlOfcCd0());
		this.hashColumns.put("ctrl_ofc_cd_1", getCtrlOfcCd1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_ntfc_eml", "bkgNtfcEml");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("ctrl_ofc_cd_29", "ctrlOfcCd29");
		this.hashFields.put("ctrl_ofc_cd_28", "ctrlOfcCd28");
		this.hashFields.put("ctrl_ofc_cd_25", "ctrlOfcCd25");
		this.hashFields.put("ctrl_ofc_cd_24", "ctrlOfcCd24");
		this.hashFields.put("ctrl_ofc_cd_27", "ctrlOfcCd27");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("ctrl_ofc_cd_26", "ctrlOfcCd26");
		this.hashFields.put("ctrl_ofc_cd_21", "ctrlOfcCd21");
		this.hashFields.put("sub_grp_ctnt", "subGrpCtnt");
		this.hashFields.put("ctrl_ofc_cd_20", "ctrlOfcCd20");
		this.hashFields.put("sub_gso_ofc_cd", "subGsoOfcCd");
		this.hashFields.put("ctrl_ofc_cd_23", "ctrlOfcCd23");
		this.hashFields.put("ctrl_ofc_cd_22", "ctrlOfcCd22");
		this.hashFields.put("chk_op", "chkOp");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("gso_ofc_cd", "gsoOfcCd");
		this.hashFields.put("ctrl_ofc_cd_10", "ctrlOfcCd10");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrl_ofc_cd_11", "ctrlOfcCd11");
		this.hashFields.put("ctrl_ofc_cd_12", "ctrlOfcCd12");
		this.hashFields.put("ctrl_ofc_cd_13", "ctrlOfcCd13");
		this.hashFields.put("ctrl_ofc_cd_14", "ctrlOfcCd14");
		this.hashFields.put("ctrl_ofc_cd_15", "ctrlOfcCd15");
		this.hashFields.put("ctrl_ofc_cd_16", "ctrlOfcCd16");
		this.hashFields.put("ctrl_ofc_cd_17", "ctrlOfcCd17");
		this.hashFields.put("ctrl_ofc_cd_18", "ctrlOfcCd18");
		this.hashFields.put("ctrl_ofc_cd_19", "ctrlOfcCd19");
		this.hashFields.put("rgn_ofc_cd", "rgnOfcCd");
		this.hashFields.put("ctrl_ofc_cd_5", "ctrlOfcCd5");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ctrl_ofc_cd_4", "ctrlOfcCd4");
		this.hashFields.put("ctrl_ofc_cd_3", "ctrlOfcCd3");
		this.hashFields.put("ctrl_ofc_cd_2", "ctrlOfcCd2");
		this.hashFields.put("ctrl_ofc_cd_9", "ctrlOfcCd9");
		this.hashFields.put("ctrl_ofc_cd_8", "ctrlOfcCd8");
		this.hashFields.put("ctrl_ofc_cd_7", "ctrlOfcCd7");
		this.hashFields.put("use_flg", "useFlg");
		this.hashFields.put("ctrl_ofc_cd_6", "ctrlOfcCd6");
		this.hashFields.put("si_ntfc_eml", "siNtfcEml");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("hndl_ofc_seq", "hndlOfcSeq");
		this.hashFields.put("ctrl_ofc_cd_0", "ctrlOfcCd0");
		this.hashFields.put("ctrl_ofc_cd_1", "ctrlOfcCd1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hndlOfcCd
	 */
	public String getHndlOfcCd() {
		return this.hndlOfcCd;
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
	 * @return bkgNtfcEml
	 */
	public String getBkgNtfcEml() {
		return this.bkgNtfcEml;
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd29
	 */
	public String getCtrlOfcCd29() {
		return this.ctrlOfcCd29;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd28
	 */
	public String getCtrlOfcCd28() {
		return this.ctrlOfcCd28;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd25
	 */
	public String getCtrlOfcCd25() {
		return this.ctrlOfcCd25;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd24
	 */
	public String getCtrlOfcCd24() {
		return this.ctrlOfcCd24;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd27
	 */
	public String getCtrlOfcCd27() {
		return this.ctrlOfcCd27;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd26
	 */
	public String getCtrlOfcCd26() {
		return this.ctrlOfcCd26;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd21
	 */
	public String getCtrlOfcCd21() {
		return this.ctrlOfcCd21;
	}
	
	/**
	 * Column Info
	 * @return subGrpCtnt
	 */
	public String getSubGrpCtnt() {
		return this.subGrpCtnt;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd20
	 */
	public String getCtrlOfcCd20() {
		return this.ctrlOfcCd20;
	}
	
	/**
	 * Column Info
	 * @return subGsoOfcCd
	 */
	public String getSubGsoOfcCd() {
		return this.subGsoOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd23
	 */
	public String getCtrlOfcCd23() {
		return this.ctrlOfcCd23;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd22
	 */
	public String getCtrlOfcCd22() {
		return this.ctrlOfcCd22;
	}
	
	/**
	 * Column Info
	 * @return chkOp
	 */
	public String getChkOp() {
		return this.chkOp;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return gsoOfcCd
	 */
	public String getGsoOfcCd() {
		return this.gsoOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd10
	 */
	public String getCtrlOfcCd10() {
		return this.ctrlOfcCd10;
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
	 * @return ctrlOfcCd11
	 */
	public String getCtrlOfcCd11() {
		return this.ctrlOfcCd11;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd12
	 */
	public String getCtrlOfcCd12() {
		return this.ctrlOfcCd12;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd13
	 */
	public String getCtrlOfcCd13() {
		return this.ctrlOfcCd13;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd14
	 */
	public String getCtrlOfcCd14() {
		return this.ctrlOfcCd14;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd15
	 */
	public String getCtrlOfcCd15() {
		return this.ctrlOfcCd15;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd16
	 */
	public String getCtrlOfcCd16() {
		return this.ctrlOfcCd16;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd17
	 */
	public String getCtrlOfcCd17() {
		return this.ctrlOfcCd17;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd18
	 */
	public String getCtrlOfcCd18() {
		return this.ctrlOfcCd18;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd19
	 */
	public String getCtrlOfcCd19() {
		return this.ctrlOfcCd19;
	}
	
	/**
	 * Column Info
	 * @return rgnOfcCd
	 */
	public String getRgnOfcCd() {
		return this.rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd5
	 */
	public String getCtrlOfcCd5() {
		return this.ctrlOfcCd5;
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
	 * @return ctrlOfcCd4
	 */
	public String getCtrlOfcCd4() {
		return this.ctrlOfcCd4;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd3
	 */
	public String getCtrlOfcCd3() {
		return this.ctrlOfcCd3;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd2
	 */
	public String getCtrlOfcCd2() {
		return this.ctrlOfcCd2;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd9
	 */
	public String getCtrlOfcCd9() {
		return this.ctrlOfcCd9;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd8
	 */
	public String getCtrlOfcCd8() {
		return this.ctrlOfcCd8;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd7
	 */
	public String getCtrlOfcCd7() {
		return this.ctrlOfcCd7;
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
	 * @return ctrlOfcCd6
	 */
	public String getCtrlOfcCd6() {
		return this.ctrlOfcCd6;
	}
	
	/**
	 * Column Info
	 * @return siNtfcEml
	 */
	public String getSiNtfcEml() {
		return this.siNtfcEml;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return hndlOfcSeq
	 */
	public String getHndlOfcSeq() {
		return this.hndlOfcSeq;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd0
	 */
	public String getCtrlOfcCd0() {
		return this.ctrlOfcCd0;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd1
	 */
	public String getCtrlOfcCd1() {
		return this.ctrlOfcCd1;
	}
	

	/**
	 * Column Info
	 * @param hndlOfcCd
	 */
	public void setHndlOfcCd(String hndlOfcCd) {
		this.hndlOfcCd = hndlOfcCd;
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
	 * @param bkgNtfcEml
	 */
	public void setBkgNtfcEml(String bkgNtfcEml) {
		this.bkgNtfcEml = bkgNtfcEml;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd29
	 */
	public void setCtrlOfcCd29(String ctrlOfcCd29) {
		this.ctrlOfcCd29 = ctrlOfcCd29;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd28
	 */
	public void setCtrlOfcCd28(String ctrlOfcCd28) {
		this.ctrlOfcCd28 = ctrlOfcCd28;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd25
	 */
	public void setCtrlOfcCd25(String ctrlOfcCd25) {
		this.ctrlOfcCd25 = ctrlOfcCd25;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd24
	 */
	public void setCtrlOfcCd24(String ctrlOfcCd24) {
		this.ctrlOfcCd24 = ctrlOfcCd24;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd27
	 */
	public void setCtrlOfcCd27(String ctrlOfcCd27) {
		this.ctrlOfcCd27 = ctrlOfcCd27;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd26
	 */
	public void setCtrlOfcCd26(String ctrlOfcCd26) {
		this.ctrlOfcCd26 = ctrlOfcCd26;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd21
	 */
	public void setCtrlOfcCd21(String ctrlOfcCd21) {
		this.ctrlOfcCd21 = ctrlOfcCd21;
	}
	
	/**
	 * Column Info
	 * @param subGrpCtnt
	 */
	public void setSubGrpCtnt(String subGrpCtnt) {
		this.subGrpCtnt = subGrpCtnt;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd20
	 */
	public void setCtrlOfcCd20(String ctrlOfcCd20) {
		this.ctrlOfcCd20 = ctrlOfcCd20;
	}
	
	/**
	 * Column Info
	 * @param subGsoOfcCd
	 */
	public void setSubGsoOfcCd(String subGsoOfcCd) {
		this.subGsoOfcCd = subGsoOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd23
	 */
	public void setCtrlOfcCd23(String ctrlOfcCd23) {
		this.ctrlOfcCd23 = ctrlOfcCd23;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd22
	 */
	public void setCtrlOfcCd22(String ctrlOfcCd22) {
		this.ctrlOfcCd22 = ctrlOfcCd22;
	}
	
	/**
	 * Column Info
	 * @param chkOp
	 */
	public void setChkOp(String chkOp) {
		this.chkOp = chkOp;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param gsoOfcCd
	 */
	public void setGsoOfcCd(String gsoOfcCd) {
		this.gsoOfcCd = gsoOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd10
	 */
	public void setCtrlOfcCd10(String ctrlOfcCd10) {
		this.ctrlOfcCd10 = ctrlOfcCd10;
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
	 * @param ctrlOfcCd11
	 */
	public void setCtrlOfcCd11(String ctrlOfcCd11) {
		this.ctrlOfcCd11 = ctrlOfcCd11;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd12
	 */
	public void setCtrlOfcCd12(String ctrlOfcCd12) {
		this.ctrlOfcCd12 = ctrlOfcCd12;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd13
	 */
	public void setCtrlOfcCd13(String ctrlOfcCd13) {
		this.ctrlOfcCd13 = ctrlOfcCd13;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd14
	 */
	public void setCtrlOfcCd14(String ctrlOfcCd14) {
		this.ctrlOfcCd14 = ctrlOfcCd14;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd15
	 */
	public void setCtrlOfcCd15(String ctrlOfcCd15) {
		this.ctrlOfcCd15 = ctrlOfcCd15;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd16
	 */
	public void setCtrlOfcCd16(String ctrlOfcCd16) {
		this.ctrlOfcCd16 = ctrlOfcCd16;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd17
	 */
	public void setCtrlOfcCd17(String ctrlOfcCd17) {
		this.ctrlOfcCd17 = ctrlOfcCd17;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd18
	 */
	public void setCtrlOfcCd18(String ctrlOfcCd18) {
		this.ctrlOfcCd18 = ctrlOfcCd18;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd19
	 */
	public void setCtrlOfcCd19(String ctrlOfcCd19) {
		this.ctrlOfcCd19 = ctrlOfcCd19;
	}
	
	/**
	 * Column Info
	 * @param rgnOfcCd
	 */
	public void setRgnOfcCd(String rgnOfcCd) {
		this.rgnOfcCd = rgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd5
	 */
	public void setCtrlOfcCd5(String ctrlOfcCd5) {
		this.ctrlOfcCd5 = ctrlOfcCd5;
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
	 * @param ctrlOfcCd4
	 */
	public void setCtrlOfcCd4(String ctrlOfcCd4) {
		this.ctrlOfcCd4 = ctrlOfcCd4;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd3
	 */
	public void setCtrlOfcCd3(String ctrlOfcCd3) {
		this.ctrlOfcCd3 = ctrlOfcCd3;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd2
	 */
	public void setCtrlOfcCd2(String ctrlOfcCd2) {
		this.ctrlOfcCd2 = ctrlOfcCd2;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd9
	 */
	public void setCtrlOfcCd9(String ctrlOfcCd9) {
		this.ctrlOfcCd9 = ctrlOfcCd9;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd8
	 */
	public void setCtrlOfcCd8(String ctrlOfcCd8) {
		this.ctrlOfcCd8 = ctrlOfcCd8;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd7
	 */
	public void setCtrlOfcCd7(String ctrlOfcCd7) {
		this.ctrlOfcCd7 = ctrlOfcCd7;
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
	 * @param ctrlOfcCd6
	 */
	public void setCtrlOfcCd6(String ctrlOfcCd6) {
		this.ctrlOfcCd6 = ctrlOfcCd6;
	}
	
	/**
	 * Column Info
	 * @param siNtfcEml
	 */
	public void setSiNtfcEml(String siNtfcEml) {
		this.siNtfcEml = siNtfcEml;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param hndlOfcSeq
	 */
	public void setHndlOfcSeq(String hndlOfcSeq) {
		this.hndlOfcSeq = hndlOfcSeq;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd0
	 */
	public void setCtrlOfcCd0(String ctrlOfcCd0) {
		this.ctrlOfcCd0 = ctrlOfcCd0;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd1
	 */
	public void setCtrlOfcCd1(String ctrlOfcCd1) {
		this.ctrlOfcCd1 = ctrlOfcCd1;
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
		setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgNtfcEml(JSPUtil.getParameter(request, prefix + "bkg_ntfc_eml", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setCtrlOfcCd29(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_29", ""));
		setCtrlOfcCd28(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_28", ""));
		setCtrlOfcCd25(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_25", ""));
		setCtrlOfcCd24(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_24", ""));
		setCtrlOfcCd27(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_27", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setCtrlOfcCd26(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_26", ""));
		setCtrlOfcCd21(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_21", ""));
		setSubGrpCtnt(JSPUtil.getParameter(request, prefix + "sub_grp_ctnt", ""));
		setCtrlOfcCd20(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_20", ""));
		setSubGsoOfcCd(JSPUtil.getParameter(request, prefix + "sub_gso_ofc_cd", ""));
		setCtrlOfcCd23(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_23", ""));
		setCtrlOfcCd22(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_22", ""));
		setChkOp(JSPUtil.getParameter(request, prefix + "chk_op", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setGsoOfcCd(JSPUtil.getParameter(request, prefix + "gso_ofc_cd", ""));
		setCtrlOfcCd10(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_10", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrlOfcCd11(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_11", ""));
		setCtrlOfcCd12(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_12", ""));
		setCtrlOfcCd13(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_13", ""));
		setCtrlOfcCd14(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_14", ""));
		setCtrlOfcCd15(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_15", ""));
		setCtrlOfcCd16(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_16", ""));
		setCtrlOfcCd17(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_17", ""));
		setCtrlOfcCd18(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_18", ""));
		setCtrlOfcCd19(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_19", ""));
		setRgnOfcCd(JSPUtil.getParameter(request, prefix + "rgn_ofc_cd", ""));
		setCtrlOfcCd5(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_5", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setCtrlOfcCd4(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_4", ""));
		setCtrlOfcCd3(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_3", ""));
		setCtrlOfcCd2(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_2", ""));
		setCtrlOfcCd9(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_9", ""));
		setCtrlOfcCd8(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_8", ""));
		setCtrlOfcCd7(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_7", ""));
		setUseFlg(JSPUtil.getParameter(request, prefix + "use_flg", ""));
		setCtrlOfcCd6(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_6", ""));
		setSiNtfcEml(JSPUtil.getParameter(request, prefix + "si_ntfc_eml", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setHndlOfcSeq(JSPUtil.getParameter(request, prefix + "hndl_ofc_seq", ""));
		setCtrlOfcCd0(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_0", ""));
		setCtrlOfcCd1(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd_1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgEsvcHndlOfcVO[]
	 */
	public BkgEsvcHndlOfcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgEsvcHndlOfcVO[]
	 */
	public BkgEsvcHndlOfcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgEsvcHndlOfcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgNtfcEml = (JSPUtil.getParameter(request, prefix	+ "bkg_ntfc_eml", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] ctrlOfcCd29 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_29", length));
			String[] ctrlOfcCd28 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_28", length));
			String[] ctrlOfcCd25 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_25", length));
			String[] ctrlOfcCd24 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_24", length));
			String[] ctrlOfcCd27 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_27", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] ctrlOfcCd26 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_26", length));
			String[] ctrlOfcCd21 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_21", length));
			String[] subGrpCtnt = (JSPUtil.getParameter(request, prefix	+ "sub_grp_ctnt", length));
			String[] ctrlOfcCd20 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_20", length));
			String[] subGsoOfcCd = (JSPUtil.getParameter(request, prefix	+ "sub_gso_ofc_cd", length));
			String[] ctrlOfcCd23 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_23", length));
			String[] ctrlOfcCd22 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_22", length));
			String[] chkOp = (JSPUtil.getParameter(request, prefix	+ "chk_op", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] gsoOfcCd = (JSPUtil.getParameter(request, prefix	+ "gso_ofc_cd", length));
			String[] ctrlOfcCd10 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_10", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrlOfcCd11 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_11", length));
			String[] ctrlOfcCd12 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_12", length));
			String[] ctrlOfcCd13 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_13", length));
			String[] ctrlOfcCd14 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_14", length));
			String[] ctrlOfcCd15 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_15", length));
			String[] ctrlOfcCd16 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_16", length));
			String[] ctrlOfcCd17 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_17", length));
			String[] ctrlOfcCd18 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_18", length));
			String[] ctrlOfcCd19 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_19", length));
			String[] rgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "rgn_ofc_cd", length));
			String[] ctrlOfcCd5 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_5", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ctrlOfcCd4 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_4", length));
			String[] ctrlOfcCd3 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_3", length));
			String[] ctrlOfcCd2 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_2", length));
			String[] ctrlOfcCd9 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_9", length));
			String[] ctrlOfcCd8 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_8", length));
			String[] ctrlOfcCd7 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_7", length));
			String[] useFlg = (JSPUtil.getParameter(request, prefix	+ "use_flg", length));
			String[] ctrlOfcCd6 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_6", length));
			String[] siNtfcEml = (JSPUtil.getParameter(request, prefix	+ "si_ntfc_eml", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] hndlOfcSeq = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_seq", length));
			String[] ctrlOfcCd0 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_0", length));
			String[] ctrlOfcCd1 = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd_1", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgEsvcHndlOfcVO();
				if (hndlOfcCd[i] != null)
					model.setHndlOfcCd(hndlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgNtfcEml[i] != null)
					model.setBkgNtfcEml(bkgNtfcEml[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (ctrlOfcCd29[i] != null)
					model.setCtrlOfcCd29(ctrlOfcCd29[i]);
				if (ctrlOfcCd28[i] != null)
					model.setCtrlOfcCd28(ctrlOfcCd28[i]);
				if (ctrlOfcCd25[i] != null)
					model.setCtrlOfcCd25(ctrlOfcCd25[i]);
				if (ctrlOfcCd24[i] != null)
					model.setCtrlOfcCd24(ctrlOfcCd24[i]);
				if (ctrlOfcCd27[i] != null)
					model.setCtrlOfcCd27(ctrlOfcCd27[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (ctrlOfcCd26[i] != null)
					model.setCtrlOfcCd26(ctrlOfcCd26[i]);
				if (ctrlOfcCd21[i] != null)
					model.setCtrlOfcCd21(ctrlOfcCd21[i]);
				if (subGrpCtnt[i] != null)
					model.setSubGrpCtnt(subGrpCtnt[i]);
				if (ctrlOfcCd20[i] != null)
					model.setCtrlOfcCd20(ctrlOfcCd20[i]);
				if (subGsoOfcCd[i] != null)
					model.setSubGsoOfcCd(subGsoOfcCd[i]);
				if (ctrlOfcCd23[i] != null)
					model.setCtrlOfcCd23(ctrlOfcCd23[i]);
				if (ctrlOfcCd22[i] != null)
					model.setCtrlOfcCd22(ctrlOfcCd22[i]);
				if (chkOp[i] != null)
					model.setChkOp(chkOp[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (gsoOfcCd[i] != null)
					model.setGsoOfcCd(gsoOfcCd[i]);
				if (ctrlOfcCd10[i] != null)
					model.setCtrlOfcCd10(ctrlOfcCd10[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrlOfcCd11[i] != null)
					model.setCtrlOfcCd11(ctrlOfcCd11[i]);
				if (ctrlOfcCd12[i] != null)
					model.setCtrlOfcCd12(ctrlOfcCd12[i]);
				if (ctrlOfcCd13[i] != null)
					model.setCtrlOfcCd13(ctrlOfcCd13[i]);
				if (ctrlOfcCd14[i] != null)
					model.setCtrlOfcCd14(ctrlOfcCd14[i]);
				if (ctrlOfcCd15[i] != null)
					model.setCtrlOfcCd15(ctrlOfcCd15[i]);
				if (ctrlOfcCd16[i] != null)
					model.setCtrlOfcCd16(ctrlOfcCd16[i]);
				if (ctrlOfcCd17[i] != null)
					model.setCtrlOfcCd17(ctrlOfcCd17[i]);
				if (ctrlOfcCd18[i] != null)
					model.setCtrlOfcCd18(ctrlOfcCd18[i]);
				if (ctrlOfcCd19[i] != null)
					model.setCtrlOfcCd19(ctrlOfcCd19[i]);
				if (rgnOfcCd[i] != null)
					model.setRgnOfcCd(rgnOfcCd[i]);
				if (ctrlOfcCd5[i] != null)
					model.setCtrlOfcCd5(ctrlOfcCd5[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ctrlOfcCd4[i] != null)
					model.setCtrlOfcCd4(ctrlOfcCd4[i]);
				if (ctrlOfcCd3[i] != null)
					model.setCtrlOfcCd3(ctrlOfcCd3[i]);
				if (ctrlOfcCd2[i] != null)
					model.setCtrlOfcCd2(ctrlOfcCd2[i]);
				if (ctrlOfcCd9[i] != null)
					model.setCtrlOfcCd9(ctrlOfcCd9[i]);
				if (ctrlOfcCd8[i] != null)
					model.setCtrlOfcCd8(ctrlOfcCd8[i]);
				if (ctrlOfcCd7[i] != null)
					model.setCtrlOfcCd7(ctrlOfcCd7[i]);
				if (useFlg[i] != null)
					model.setUseFlg(useFlg[i]);
				if (ctrlOfcCd6[i] != null)
					model.setCtrlOfcCd6(ctrlOfcCd6[i]);
				if (siNtfcEml[i] != null)
					model.setSiNtfcEml(siNtfcEml[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (hndlOfcSeq[i] != null)
					model.setHndlOfcSeq(hndlOfcSeq[i]);
				if (ctrlOfcCd0[i] != null)
					model.setCtrlOfcCd0(ctrlOfcCd0[i]);
				if (ctrlOfcCd1[i] != null)
					model.setCtrlOfcCd1(ctrlOfcCd1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgEsvcHndlOfcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgEsvcHndlOfcVO[]
	 */
	public BkgEsvcHndlOfcVO[] getBkgEsvcHndlOfcVOs(){
		BkgEsvcHndlOfcVO[] vos = (BkgEsvcHndlOfcVO[])models.toArray(new BkgEsvcHndlOfcVO[models.size()]);
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
		this.hndlOfcCd = this.hndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNtfcEml = this.bkgNtfcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd29 = this.ctrlOfcCd29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd28 = this.ctrlOfcCd28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd25 = this.ctrlOfcCd25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd24 = this.ctrlOfcCd24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd27 = this.ctrlOfcCd27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd26 = this.ctrlOfcCd26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd21 = this.ctrlOfcCd21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subGrpCtnt = this.subGrpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd20 = this.ctrlOfcCd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subGsoOfcCd = this.subGsoOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd23 = this.ctrlOfcCd23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd22 = this.ctrlOfcCd22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOp = this.chkOp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gsoOfcCd = this.gsoOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd10 = this.ctrlOfcCd10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd11 = this.ctrlOfcCd11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd12 = this.ctrlOfcCd12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd13 = this.ctrlOfcCd13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd14 = this.ctrlOfcCd14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd15 = this.ctrlOfcCd15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd16 = this.ctrlOfcCd16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd17 = this.ctrlOfcCd17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd18 = this.ctrlOfcCd18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd19 = this.ctrlOfcCd19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnOfcCd = this.rgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd5 = this.ctrlOfcCd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd4 = this.ctrlOfcCd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd3 = this.ctrlOfcCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd2 = this.ctrlOfcCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd9 = this.ctrlOfcCd9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd8 = this.ctrlOfcCd8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd7 = this.ctrlOfcCd7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useFlg = this.useFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd6 = this.ctrlOfcCd6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siNtfcEml = this.siNtfcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcSeq = this.hndlOfcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd0 = this.ctrlOfcCd0 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd1 = this.ctrlOfcCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
