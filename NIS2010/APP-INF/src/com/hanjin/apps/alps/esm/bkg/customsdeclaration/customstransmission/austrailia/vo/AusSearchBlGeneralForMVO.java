/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AusSearchBlGeneralForMVO.java
*@FileTitle : AusSearchBlGeneralForMVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.12.07 김승민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo;

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
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AusSearchBlGeneralForMVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AusSearchBlGeneralForMVO> models = new ArrayList<AusSearchBlGeneralForMVO>();
	
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String ntfy25 = null;
	/* Column Info */
	private String ntfy21 = null;
	/* Column Info */
	private String blpkgu = null;
	/* Column Info */
	private String ntfy22 = null;
	/* Column Info */
	private String bldel = null;
	/* Column Info */
	private String ntfy23 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ntfy24 = null;
	/* Column Info */
	private String blmea = null;
	/* Column Info */
	private String frtInd = null;
	/* Column Info */
	private String bkgSpeAk = null;
	/* Column Info */
	private String expo5 = null;
	/* Column Info */
	private String expo4 = null;
	/* Column Info */
	private String expo3 = null;
	/* Column Info */
	private String expo2 = null;
	/* Column Info */
	private String bkgSpeBb = null;
	/* Column Info */
	private String cnee5 = null;
	/* Column Info */
	private String cnee3 = null;
	/* Column Info */
	private String cnee4 = null;
	/* Column Info */
	private String cnee1 = null;
	/* Column Info */
	private String cnee2 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cmdtDesc = null;
	/* Column Info */
	private String bkgSpeRd = null;
	/* Column Info */
	private String blpod = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String blorg = null;
	/* Column Info */
	private String bkgSpeRf = null;
	/* Column Info */
	private String blplace = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String blnbr = null;
	/* Column Info */
	private String bldate = null;
	/* Column Info */
	private String blpkg = null;
	/* Column Info */
	private String blpor = null;
	/* Column Info */
	private String ausQuar = null;
	/* Column Info */
	private String blpol = null;
	/* Column Info */
	private String cargotype = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String ffwd5 = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String ffwd2 = null;
	/* Column Info */
	private String ffwd1 = null;
	/* Column Info */
	private String ffwd4 = null;
	/* Column Info */
	private String ffwd3 = null;
	/* Column Info */
	private String rdtype = null;
	/* Column Info */
	private String blrly = null;
	/* Column Info */
	private String shpr2 = null;
	/* Column Info */
	private String shpr1 = null;
	/* Column Info */
	private String blwgt = null;
	/* Column Info */
	private String shpr5 = null;
	/* Column Info */
	private String bkgSpeDg = null;
	/* Column Info */
	private String shpr4 = null;
	/* Column Info */
	private String expo1 = null;
	/* Column Info */
	private String shpr3 = null;
	/* Column Info */
	private String ntfy5 = null;
	/* Column Info */
	private String commodity = null;
	/* Column Info */
	private String ntfy4 = null;
	/* Column Info */
	private String ntfy3 = null;
	/* Column Info */
	private String ntfy2 = null;
	/* Column Info */
	private String ntfy1 = null;
	/* Column Info */
	private String bkgnbr = null;
	/* Column Info */
	private String blcopy = null;
	/* Column Info */
	private String eiInd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AusSearchBlGeneralForMVO() {}

	public AusSearchBlGeneralForMVO(String ibflag, String pagerows, String blnbr, String bkgnbr, String blpol, String blpod, String blpor, String bldel, String blrly, String blplace, String bldate, String custCd, String shpr1, String shpr2, String shpr3, String shpr4, String shpr5, String cnee1, String cnee2, String cnee3, String cnee4, String cnee5, String ntfy1, String ntfy2, String ntfy3, String ntfy4, String ntfy5, String ntfy21, String ntfy22, String ntfy23, String ntfy24, String ntfy25, String ffwd1, String ffwd2, String ffwd3, String ffwd4, String ffwd5, String expo1, String expo2, String expo3, String expo4, String expo5, String blcopy, String blorg, String blpkg, String blpkgu, String blwgt, String blmea, String rdtype, String cargotype, String commodity, String xterRmk, String ausQuar, String frtInd, String bkgNo, String bkgCgoTpCd, String bkgSpeDg, String bkgSpeRf, String bkgSpeAk, String bkgSpeBb, String bkgSpeRd, String cmdtCd, String cmdtDesc, String cstmsDesc, String eiInd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.ntfy25 = ntfy25;
		this.ntfy21 = ntfy21;
		this.blpkgu = blpkgu;
		this.ntfy22 = ntfy22;
		this.bldel = bldel;
		this.ntfy23 = ntfy23;
		this.pagerows = pagerows;
		this.ntfy24 = ntfy24;
		this.blmea = blmea;
		this.frtInd = frtInd;
		this.bkgSpeAk = bkgSpeAk;
		this.expo5 = expo5;
		this.expo4 = expo4;
		this.expo3 = expo3;
		this.expo2 = expo2;
		this.bkgSpeBb = bkgSpeBb;
		this.cnee5 = cnee5;
		this.cnee3 = cnee3;
		this.cnee4 = cnee4;
		this.cnee1 = cnee1;
		this.cnee2 = cnee2;
		this.bkgNo = bkgNo;
		this.cmdtDesc = cmdtDesc;
		this.bkgSpeRd = bkgSpeRd;
		this.blpod = blpod;
		this.custCd = custCd;
		this.blorg = blorg;
		this.bkgSpeRf = bkgSpeRf;
		this.blplace = blplace;
		this.xterRmk = xterRmk;
		this.blnbr = blnbr;
		this.bldate = bldate;
		this.blpkg = blpkg;
		this.blpor = blpor;
		this.ausQuar = ausQuar;
		this.blpol = blpol;
		this.cargotype = cargotype;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.ffwd5 = ffwd5;
		this.cstmsDesc = cstmsDesc;
		this.ffwd2 = ffwd2;
		this.ffwd1 = ffwd1;
		this.ffwd4 = ffwd4;
		this.ffwd3 = ffwd3;
		this.rdtype = rdtype;
		this.blrly = blrly;
		this.shpr2 = shpr2;
		this.shpr1 = shpr1;
		this.blwgt = blwgt;
		this.shpr5 = shpr5;
		this.bkgSpeDg = bkgSpeDg;
		this.shpr4 = shpr4;
		this.expo1 = expo1;
		this.shpr3 = shpr3;
		this.ntfy5 = ntfy5;
		this.commodity = commodity;
		this.ntfy4 = ntfy4;
		this.ntfy3 = ntfy3;
		this.ntfy2 = ntfy2;
		this.ntfy1 = ntfy1;
		this.bkgnbr = bkgnbr;
		this.blcopy = blcopy;
		this.eiInd = eiInd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("ntfy25", getNtfy25());
		this.hashColumns.put("ntfy21", getNtfy21());
		this.hashColumns.put("blpkgu", getBlpkgu());
		this.hashColumns.put("ntfy22", getNtfy22());
		this.hashColumns.put("bldel", getBldel());
		this.hashColumns.put("ntfy23", getNtfy23());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ntfy24", getNtfy24());
		this.hashColumns.put("blmea", getBlmea());
		this.hashColumns.put("frt_ind", getFrtInd());
		this.hashColumns.put("bkg_spe_ak", getBkgSpeAk());
		this.hashColumns.put("expo5", getExpo5());
		this.hashColumns.put("expo4", getExpo4());
		this.hashColumns.put("expo3", getExpo3());
		this.hashColumns.put("expo2", getExpo2());
		this.hashColumns.put("bkg_spe_bb", getBkgSpeBb());
		this.hashColumns.put("cnee5", getCnee5());
		this.hashColumns.put("cnee3", getCnee3());
		this.hashColumns.put("cnee4", getCnee4());
		this.hashColumns.put("cnee1", getCnee1());
		this.hashColumns.put("cnee2", getCnee2());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		this.hashColumns.put("bkg_spe_rd", getBkgSpeRd());
		this.hashColumns.put("blpod", getBlpod());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("blorg", getBlorg());
		this.hashColumns.put("bkg_spe_rf", getBkgSpeRf());
		this.hashColumns.put("blplace", getBlplace());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("bldate", getBldate());
		this.hashColumns.put("blpkg", getBlpkg());
		this.hashColumns.put("blpor", getBlpor());
		this.hashColumns.put("aus_quar", getAusQuar());
		this.hashColumns.put("blpol", getBlpol());
		this.hashColumns.put("cargotype", getCargotype());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("ffwd5", getFfwd5());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("ffwd2", getFfwd2());
		this.hashColumns.put("ffwd1", getFfwd1());
		this.hashColumns.put("ffwd4", getFfwd4());
		this.hashColumns.put("ffwd3", getFfwd3());
		this.hashColumns.put("rdtype", getRdtype());
		this.hashColumns.put("blrly", getBlrly());
		this.hashColumns.put("shpr2", getShpr2());
		this.hashColumns.put("shpr1", getShpr1());
		this.hashColumns.put("blwgt", getBlwgt());
		this.hashColumns.put("shpr5", getShpr5());
		this.hashColumns.put("bkg_spe_dg", getBkgSpeDg());
		this.hashColumns.put("shpr4", getShpr4());
		this.hashColumns.put("expo1", getExpo1());
		this.hashColumns.put("shpr3", getShpr3());
		this.hashColumns.put("ntfy5", getNtfy5());
		this.hashColumns.put("commodity", getCommodity());
		this.hashColumns.put("ntfy4", getNtfy4());
		this.hashColumns.put("ntfy3", getNtfy3());
		this.hashColumns.put("ntfy2", getNtfy2());
		this.hashColumns.put("ntfy1", getNtfy1());
		this.hashColumns.put("bkgnbr", getBkgnbr());
		this.hashColumns.put("blcopy", getBlcopy());
		this.hashColumns.put("ei_ind", getEiInd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("ntfy25", "ntfy25");
		this.hashFields.put("ntfy21", "ntfy21");
		this.hashFields.put("blpkgu", "blpkgu");
		this.hashFields.put("ntfy22", "ntfy22");
		this.hashFields.put("bldel", "bldel");
		this.hashFields.put("ntfy23", "ntfy23");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ntfy24", "ntfy24");
		this.hashFields.put("blmea", "blmea");
		this.hashFields.put("frt_ind", "frtInd");
		this.hashFields.put("bkg_spe_ak", "bkgSpeAk");
		this.hashFields.put("expo5", "expo5");
		this.hashFields.put("expo4", "expo4");
		this.hashFields.put("expo3", "expo3");
		this.hashFields.put("expo2", "expo2");
		this.hashFields.put("bkg_spe_bb", "bkgSpeBb");
		this.hashFields.put("cnee5", "cnee5");
		this.hashFields.put("cnee3", "cnee3");
		this.hashFields.put("cnee4", "cnee4");
		this.hashFields.put("cnee1", "cnee1");
		this.hashFields.put("cnee2", "cnee2");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
		this.hashFields.put("bkg_spe_rd", "bkgSpeRd");
		this.hashFields.put("blpod", "blpod");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("blorg", "blorg");
		this.hashFields.put("bkg_spe_rf", "bkgSpeRf");
		this.hashFields.put("blplace", "blplace");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("bldate", "bldate");
		this.hashFields.put("blpkg", "blpkg");
		this.hashFields.put("blpor", "blpor");
		this.hashFields.put("aus_quar", "ausQuar");
		this.hashFields.put("blpol", "blpol");
		this.hashFields.put("cargotype", "cargotype");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("ffwd5", "ffwd5");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("ffwd2", "ffwd2");
		this.hashFields.put("ffwd1", "ffwd1");
		this.hashFields.put("ffwd4", "ffwd4");
		this.hashFields.put("ffwd3", "ffwd3");
		this.hashFields.put("rdtype", "rdtype");
		this.hashFields.put("blrly", "blrly");
		this.hashFields.put("shpr2", "shpr2");
		this.hashFields.put("shpr1", "shpr1");
		this.hashFields.put("blwgt", "blwgt");
		this.hashFields.put("shpr5", "shpr5");
		this.hashFields.put("bkg_spe_dg", "bkgSpeDg");
		this.hashFields.put("shpr4", "shpr4");
		this.hashFields.put("expo1", "expo1");
		this.hashFields.put("shpr3", "shpr3");
		this.hashFields.put("ntfy5", "ntfy5");
		this.hashFields.put("commodity", "commodity");
		this.hashFields.put("ntfy4", "ntfy4");
		this.hashFields.put("ntfy3", "ntfy3");
		this.hashFields.put("ntfy2", "ntfy2");
		this.hashFields.put("ntfy1", "ntfy1");
		this.hashFields.put("bkgnbr", "bkgnbr");
		this.hashFields.put("blcopy", "blcopy");
		this.hashFields.put("ei_ind", "eiInd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntfy25
	 */
	public String getNtfy25() {
		return this.ntfy25;
	}
	
	/**
	 * Column Info
	 * @return ntfy21
	 */
	public String getNtfy21() {
		return this.ntfy21;
	}
	
	/**
	 * Column Info
	 * @return blpkgu
	 */
	public String getBlpkgu() {
		return this.blpkgu;
	}
	
	/**
	 * Column Info
	 * @return ntfy22
	 */
	public String getNtfy22() {
		return this.ntfy22;
	}
	
	/**
	 * Column Info
	 * @return bldel
	 */
	public String getBldel() {
		return this.bldel;
	}
	
	/**
	 * Column Info
	 * @return ntfy23
	 */
	public String getNtfy23() {
		return this.ntfy23;
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
	 * @return ntfy24
	 */
	public String getNtfy24() {
		return this.ntfy24;
	}
	
	/**
	 * Column Info
	 * @return blmea
	 */
	public String getBlmea() {
		return this.blmea;
	}
	
	/**
	 * Column Info
	 * @return frtInd
	 */
	public String getFrtInd() {
		return this.frtInd;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeAk
	 */
	public String getBkgSpeAk() {
		return this.bkgSpeAk;
	}
	
	/**
	 * Column Info
	 * @return expo5
	 */
	public String getExpo5() {
		return this.expo5;
	}
	
	/**
	 * Column Info
	 * @return expo4
	 */
	public String getExpo4() {
		return this.expo4;
	}
	
	/**
	 * Column Info
	 * @return expo3
	 */
	public String getExpo3() {
		return this.expo3;
	}
	
	/**
	 * Column Info
	 * @return expo2
	 */
	public String getExpo2() {
		return this.expo2;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeBb
	 */
	public String getBkgSpeBb() {
		return this.bkgSpeBb;
	}
	
	/**
	 * Column Info
	 * @return cnee5
	 */
	public String getCnee5() {
		return this.cnee5;
	}
	
	/**
	 * Column Info
	 * @return cnee3
	 */
	public String getCnee3() {
		return this.cnee3;
	}
	
	/**
	 * Column Info
	 * @return cnee4
	 */
	public String getCnee4() {
		return this.cnee4;
	}
	
	/**
	 * Column Info
	 * @return cnee1
	 */
	public String getCnee1() {
		return this.cnee1;
	}
	
	/**
	 * Column Info
	 * @return cnee2
	 */
	public String getCnee2() {
		return this.cnee2;
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
	 * @return cmdtDesc
	 */
	public String getCmdtDesc() {
		return this.cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeRd
	 */
	public String getBkgSpeRd() {
		return this.bkgSpeRd;
	}
	
	/**
	 * Column Info
	 * @return blpod
	 */
	public String getBlpod() {
		return this.blpod;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return blorg
	 */
	public String getBlorg() {
		return this.blorg;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeRf
	 */
	public String getBkgSpeRf() {
		return this.bkgSpeRf;
	}
	
	/**
	 * Column Info
	 * @return blplace
	 */
	public String getBlplace() {
		return this.blplace;
	}
	
	/**
	 * Column Info
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
	}
	
	/**
	 * Column Info
	 * @return blnbr
	 */
	public String getBlnbr() {
		return this.blnbr;
	}
	
	/**
	 * Column Info
	 * @return bldate
	 */
	public String getBldate() {
		return this.bldate;
	}
	
	/**
	 * Column Info
	 * @return blpkg
	 */
	public String getBlpkg() {
		return this.blpkg;
	}
	
	/**
	 * Column Info
	 * @return blpor
	 */
	public String getBlpor() {
		return this.blpor;
	}
	
	/**
	 * Column Info
	 * @return ausQuar
	 */
	public String getAusQuar() {
		return this.ausQuar;
	}
	
	/**
	 * Column Info
	 * @return blpol
	 */
	public String getBlpol() {
		return this.blpol;
	}
	
	/**
	 * Column Info
	 * @return cargotype
	 */
	public String getCargotype() {
		return this.cargotype;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return ffwd5
	 */
	public String getFfwd5() {
		return this.ffwd5;
	}
	
	/**
	 * Column Info
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return ffwd2
	 */
	public String getFfwd2() {
		return this.ffwd2;
	}
	
	/**
	 * Column Info
	 * @return ffwd1
	 */
	public String getFfwd1() {
		return this.ffwd1;
	}
	
	/**
	 * Column Info
	 * @return ffwd4
	 */
	public String getFfwd4() {
		return this.ffwd4;
	}
	
	/**
	 * Column Info
	 * @return ffwd3
	 */
	public String getFfwd3() {
		return this.ffwd3;
	}
	
	/**
	 * Column Info
	 * @return rdtype
	 */
	public String getRdtype() {
		return this.rdtype;
	}
	
	/**
	 * Column Info
	 * @return blrly
	 */
	public String getBlrly() {
		return this.blrly;
	}
	
	/**
	 * Column Info
	 * @return shpr2
	 */
	public String getShpr2() {
		return this.shpr2;
	}
	
	/**
	 * Column Info
	 * @return shpr1
	 */
	public String getShpr1() {
		return this.shpr1;
	}
	
	/**
	 * Column Info
	 * @return blwgt
	 */
	public String getBlwgt() {
		return this.blwgt;
	}
	
	/**
	 * Column Info
	 * @return shpr5
	 */
	public String getShpr5() {
		return this.shpr5;
	}
	
	/**
	 * Column Info
	 * @return bkgSpeDg
	 */
	public String getBkgSpeDg() {
		return this.bkgSpeDg;
	}
	
	/**
	 * Column Info
	 * @return shpr4
	 */
	public String getShpr4() {
		return this.shpr4;
	}
	
	/**
	 * Column Info
	 * @return expo1
	 */
	public String getExpo1() {
		return this.expo1;
	}
	
	/**
	 * Column Info
	 * @return shpr3
	 */
	public String getShpr3() {
		return this.shpr3;
	}
	
	/**
	 * Column Info
	 * @return ntfy5
	 */
	public String getNtfy5() {
		return this.ntfy5;
	}
	
	/**
	 * Column Info
	 * @return commodity
	 */
	public String getCommodity() {
		return this.commodity;
	}
	
	/**
	 * Column Info
	 * @return ntfy4
	 */
	public String getNtfy4() {
		return this.ntfy4;
	}
	
	/**
	 * Column Info
	 * @return ntfy3
	 */
	public String getNtfy3() {
		return this.ntfy3;
	}
	
	/**
	 * Column Info
	 * @return ntfy2
	 */
	public String getNtfy2() {
		return this.ntfy2;
	}
	
	/**
	 * Column Info
	 * @return ntfy1
	 */
	public String getNtfy1() {
		return this.ntfy1;
	}
	
	/**
	 * Column Info
	 * @return bkgnbr
	 */
	public String getBkgnbr() {
		return this.bkgnbr;
	}
	
	/**
	 * Column Info
	 * @return blcopy
	 */
	public String getBlcopy() {
		return this.blcopy;
	}
	
	/**
	 * Column Info
	 * @return eiInd
	 */
	public String getEiInd() {
		return this.eiInd;
	}
	

	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntfy25
	 */
	public void setNtfy25(String ntfy25) {
		this.ntfy25 = ntfy25;
	}
	
	/**
	 * Column Info
	 * @param ntfy21
	 */
	public void setNtfy21(String ntfy21) {
		this.ntfy21 = ntfy21;
	}
	
	/**
	 * Column Info
	 * @param blpkgu
	 */
	public void setBlpkgu(String blpkgu) {
		this.blpkgu = blpkgu;
	}
	
	/**
	 * Column Info
	 * @param ntfy22
	 */
	public void setNtfy22(String ntfy22) {
		this.ntfy22 = ntfy22;
	}
	
	/**
	 * Column Info
	 * @param bldel
	 */
	public void setBldel(String bldel) {
		this.bldel = bldel;
	}
	
	/**
	 * Column Info
	 * @param ntfy23
	 */
	public void setNtfy23(String ntfy23) {
		this.ntfy23 = ntfy23;
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
	 * @param ntfy24
	 */
	public void setNtfy24(String ntfy24) {
		this.ntfy24 = ntfy24;
	}
	
	/**
	 * Column Info
	 * @param blmea
	 */
	public void setBlmea(String blmea) {
		this.blmea = blmea;
	}
	
	/**
	 * Column Info
	 * @param frtInd
	 */
	public void setFrtInd(String frtInd) {
		this.frtInd = frtInd;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeAk
	 */
	public void setBkgSpeAk(String bkgSpeAk) {
		this.bkgSpeAk = bkgSpeAk;
	}
	
	/**
	 * Column Info
	 * @param expo5
	 */
	public void setExpo5(String expo5) {
		this.expo5 = expo5;
	}
	
	/**
	 * Column Info
	 * @param expo4
	 */
	public void setExpo4(String expo4) {
		this.expo4 = expo4;
	}
	
	/**
	 * Column Info
	 * @param expo3
	 */
	public void setExpo3(String expo3) {
		this.expo3 = expo3;
	}
	
	/**
	 * Column Info
	 * @param expo2
	 */
	public void setExpo2(String expo2) {
		this.expo2 = expo2;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeBb
	 */
	public void setBkgSpeBb(String bkgSpeBb) {
		this.bkgSpeBb = bkgSpeBb;
	}
	
	/**
	 * Column Info
	 * @param cnee5
	 */
	public void setCnee5(String cnee5) {
		this.cnee5 = cnee5;
	}
	
	/**
	 * Column Info
	 * @param cnee3
	 */
	public void setCnee3(String cnee3) {
		this.cnee3 = cnee3;
	}
	
	/**
	 * Column Info
	 * @param cnee4
	 */
	public void setCnee4(String cnee4) {
		this.cnee4 = cnee4;
	}
	
	/**
	 * Column Info
	 * @param cnee1
	 */
	public void setCnee1(String cnee1) {
		this.cnee1 = cnee1;
	}
	
	/**
	 * Column Info
	 * @param cnee2
	 */
	public void setCnee2(String cnee2) {
		this.cnee2 = cnee2;
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
	 * @param cmdtDesc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeRd
	 */
	public void setBkgSpeRd(String bkgSpeRd) {
		this.bkgSpeRd = bkgSpeRd;
	}
	
	/**
	 * Column Info
	 * @param blpod
	 */
	public void setBlpod(String blpod) {
		this.blpod = blpod;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param blorg
	 */
	public void setBlorg(String blorg) {
		this.blorg = blorg;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeRf
	 */
	public void setBkgSpeRf(String bkgSpeRf) {
		this.bkgSpeRf = bkgSpeRf;
	}
	
	/**
	 * Column Info
	 * @param blplace
	 */
	public void setBlplace(String blplace) {
		this.blplace = blplace;
	}
	
	/**
	 * Column Info
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
	}
	
	/**
	 * Column Info
	 * @param blnbr
	 */
	public void setBlnbr(String blnbr) {
		this.blnbr = blnbr;
	}
	
	/**
	 * Column Info
	 * @param bldate
	 */
	public void setBldate(String bldate) {
		this.bldate = bldate;
	}
	
	/**
	 * Column Info
	 * @param blpkg
	 */
	public void setBlpkg(String blpkg) {
		this.blpkg = blpkg;
	}
	
	/**
	 * Column Info
	 * @param blpor
	 */
	public void setBlpor(String blpor) {
		this.blpor = blpor;
	}
	
	/**
	 * Column Info
	 * @param ausQuar
	 */
	public void setAusQuar(String ausQuar) {
		this.ausQuar = ausQuar;
	}
	
	/**
	 * Column Info
	 * @param blpol
	 */
	public void setBlpol(String blpol) {
		this.blpol = blpol;
	}
	
	/**
	 * Column Info
	 * @param cargotype
	 */
	public void setCargotype(String cargotype) {
		this.cargotype = cargotype;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param ffwd5
	 */
	public void setFfwd5(String ffwd5) {
		this.ffwd5 = ffwd5;
	}
	
	/**
	 * Column Info
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param ffwd2
	 */
	public void setFfwd2(String ffwd2) {
		this.ffwd2 = ffwd2;
	}
	
	/**
	 * Column Info
	 * @param ffwd1
	 */
	public void setFfwd1(String ffwd1) {
		this.ffwd1 = ffwd1;
	}
	
	/**
	 * Column Info
	 * @param ffwd4
	 */
	public void setFfwd4(String ffwd4) {
		this.ffwd4 = ffwd4;
	}
	
	/**
	 * Column Info
	 * @param ffwd3
	 */
	public void setFfwd3(String ffwd3) {
		this.ffwd3 = ffwd3;
	}
	
	/**
	 * Column Info
	 * @param rdtype
	 */
	public void setRdtype(String rdtype) {
		this.rdtype = rdtype;
	}
	
	/**
	 * Column Info
	 * @param blrly
	 */
	public void setBlrly(String blrly) {
		this.blrly = blrly;
	}
	
	/**
	 * Column Info
	 * @param shpr2
	 */
	public void setShpr2(String shpr2) {
		this.shpr2 = shpr2;
	}
	
	/**
	 * Column Info
	 * @param shpr1
	 */
	public void setShpr1(String shpr1) {
		this.shpr1 = shpr1;
	}
	
	/**
	 * Column Info
	 * @param blwgt
	 */
	public void setBlwgt(String blwgt) {
		this.blwgt = blwgt;
	}
	
	/**
	 * Column Info
	 * @param shpr5
	 */
	public void setShpr5(String shpr5) {
		this.shpr5 = shpr5;
	}
	
	/**
	 * Column Info
	 * @param bkgSpeDg
	 */
	public void setBkgSpeDg(String bkgSpeDg) {
		this.bkgSpeDg = bkgSpeDg;
	}
	
	/**
	 * Column Info
	 * @param shpr4
	 */
	public void setShpr4(String shpr4) {
		this.shpr4 = shpr4;
	}
	
	/**
	 * Column Info
	 * @param expo1
	 */
	public void setExpo1(String expo1) {
		this.expo1 = expo1;
	}
	
	/**
	 * Column Info
	 * @param shpr3
	 */
	public void setShpr3(String shpr3) {
		this.shpr3 = shpr3;
	}
	
	/**
	 * Column Info
	 * @param ntfy5
	 */
	public void setNtfy5(String ntfy5) {
		this.ntfy5 = ntfy5;
	}
	
	/**
	 * Column Info
	 * @param commodity
	 */
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	
	/**
	 * Column Info
	 * @param ntfy4
	 */
	public void setNtfy4(String ntfy4) {
		this.ntfy4 = ntfy4;
	}
	
	/**
	 * Column Info
	 * @param ntfy3
	 */
	public void setNtfy3(String ntfy3) {
		this.ntfy3 = ntfy3;
	}
	
	/**
	 * Column Info
	 * @param ntfy2
	 */
	public void setNtfy2(String ntfy2) {
		this.ntfy2 = ntfy2;
	}
	
	/**
	 * Column Info
	 * @param ntfy1
	 */
	public void setNtfy1(String ntfy1) {
		this.ntfy1 = ntfy1;
	}
	
	/**
	 * Column Info
	 * @param bkgnbr
	 */
	public void setBkgnbr(String bkgnbr) {
		this.bkgnbr = bkgnbr;
	}
	
	/**
	 * Column Info
	 * @param blcopy
	 */
	public void setBlcopy(String blcopy) {
		this.blcopy = blcopy;
	}
	
	/**
	 * Column Info
	 * @param eiInd
	 */
	public void setEiInd(String eiInd) {
		this.eiInd = eiInd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setNtfy25(JSPUtil.getParameter(request, "ntfy25", ""));
		setNtfy21(JSPUtil.getParameter(request, "ntfy21", ""));
		setBlpkgu(JSPUtil.getParameter(request, "blpkgu", ""));
		setNtfy22(JSPUtil.getParameter(request, "ntfy22", ""));
		setBldel(JSPUtil.getParameter(request, "bldel", ""));
		setNtfy23(JSPUtil.getParameter(request, "ntfy23", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setNtfy24(JSPUtil.getParameter(request, "ntfy24", ""));
		setBlmea(JSPUtil.getParameter(request, "blmea", ""));
		setFrtInd(JSPUtil.getParameter(request, "frt_ind", ""));
		setBkgSpeAk(JSPUtil.getParameter(request, "bkg_spe_ak", ""));
		setExpo5(JSPUtil.getParameter(request, "expo5", ""));
		setExpo4(JSPUtil.getParameter(request, "expo4", ""));
		setExpo3(JSPUtil.getParameter(request, "expo3", ""));
		setExpo2(JSPUtil.getParameter(request, "expo2", ""));
		setBkgSpeBb(JSPUtil.getParameter(request, "bkg_spe_bb", ""));
		setCnee5(JSPUtil.getParameter(request, "cnee5", ""));
		setCnee3(JSPUtil.getParameter(request, "cnee3", ""));
		setCnee4(JSPUtil.getParameter(request, "cnee4", ""));
		setCnee1(JSPUtil.getParameter(request, "cnee1", ""));
		setCnee2(JSPUtil.getParameter(request, "cnee2", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCmdtDesc(JSPUtil.getParameter(request, "cmdt_desc", ""));
		setBkgSpeRd(JSPUtil.getParameter(request, "bkg_spe_rd", ""));
		setBlpod(JSPUtil.getParameter(request, "blpod", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setBlorg(JSPUtil.getParameter(request, "blorg", ""));
		setBkgSpeRf(JSPUtil.getParameter(request, "bkg_spe_rf", ""));
		setBlplace(JSPUtil.getParameter(request, "blplace", ""));
		setXterRmk(JSPUtil.getParameter(request, "xter_rmk", ""));
		setBlnbr(JSPUtil.getParameter(request, "blnbr", ""));
		setBldate(JSPUtil.getParameter(request, "bldate", ""));
		setBlpkg(JSPUtil.getParameter(request, "blpkg", ""));
		setBlpor(JSPUtil.getParameter(request, "blpor", ""));
		setAusQuar(JSPUtil.getParameter(request, "aus_quar", ""));
		setBlpol(JSPUtil.getParameter(request, "blpol", ""));
		setCargotype(JSPUtil.getParameter(request, "cargotype", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, "cmdt_cd", ""));
		setFfwd5(JSPUtil.getParameter(request, "ffwd5", ""));
		setCstmsDesc(JSPUtil.getParameter(request, "cstms_desc", ""));
		setFfwd2(JSPUtil.getParameter(request, "ffwd2", ""));
		setFfwd1(JSPUtil.getParameter(request, "ffwd1", ""));
		setFfwd4(JSPUtil.getParameter(request, "ffwd4", ""));
		setFfwd3(JSPUtil.getParameter(request, "ffwd3", ""));
		setRdtype(JSPUtil.getParameter(request, "rdtype", ""));
		setBlrly(JSPUtil.getParameter(request, "blrly", ""));
		setShpr2(JSPUtil.getParameter(request, "shpr2", ""));
		setShpr1(JSPUtil.getParameter(request, "shpr1", ""));
		setBlwgt(JSPUtil.getParameter(request, "blwgt", ""));
		setShpr5(JSPUtil.getParameter(request, "shpr5", ""));
		setBkgSpeDg(JSPUtil.getParameter(request, "bkg_spe_dg", ""));
		setShpr4(JSPUtil.getParameter(request, "shpr4", ""));
		setExpo1(JSPUtil.getParameter(request, "expo1", ""));
		setShpr3(JSPUtil.getParameter(request, "shpr3", ""));
		setNtfy5(JSPUtil.getParameter(request, "ntfy5", ""));
		setCommodity(JSPUtil.getParameter(request, "commodity", ""));
		setNtfy4(JSPUtil.getParameter(request, "ntfy4", ""));
		setNtfy3(JSPUtil.getParameter(request, "ntfy3", ""));
		setNtfy2(JSPUtil.getParameter(request, "ntfy2", ""));
		setNtfy1(JSPUtil.getParameter(request, "ntfy1", ""));
		setBkgnbr(JSPUtil.getParameter(request, "bkgnbr", ""));
		setBlcopy(JSPUtil.getParameter(request, "blcopy", ""));
		setEiInd(JSPUtil.getParameter(request, "ei_ind", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusSearchBlGeneralForMVO[]
	 */
	public AusSearchBlGeneralForMVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AusSearchBlGeneralForMVO[]
	 */
	public AusSearchBlGeneralForMVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusSearchBlGeneralForMVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] ntfy25 = (JSPUtil.getParameter(request, prefix	+ "ntfy25", length));
			String[] ntfy21 = (JSPUtil.getParameter(request, prefix	+ "ntfy21", length));
			String[] blpkgu = (JSPUtil.getParameter(request, prefix	+ "blpkgu", length));
			String[] ntfy22 = (JSPUtil.getParameter(request, prefix	+ "ntfy22", length));
			String[] bldel = (JSPUtil.getParameter(request, prefix	+ "bldel", length));
			String[] ntfy23 = (JSPUtil.getParameter(request, prefix	+ "ntfy23", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ntfy24 = (JSPUtil.getParameter(request, prefix	+ "ntfy24", length));
			String[] blmea = (JSPUtil.getParameter(request, prefix	+ "blmea", length));
			String[] frtInd = (JSPUtil.getParameter(request, prefix	+ "frt_ind", length));
			String[] bkgSpeAk = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_ak", length));
			String[] expo5 = (JSPUtil.getParameter(request, prefix	+ "expo5", length));
			String[] expo4 = (JSPUtil.getParameter(request, prefix	+ "expo4", length));
			String[] expo3 = (JSPUtil.getParameter(request, prefix	+ "expo3", length));
			String[] expo2 = (JSPUtil.getParameter(request, prefix	+ "expo2", length));
			String[] bkgSpeBb = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_bb", length));
			String[] cnee5 = (JSPUtil.getParameter(request, prefix	+ "cnee5", length));
			String[] cnee3 = (JSPUtil.getParameter(request, prefix	+ "cnee3", length));
			String[] cnee4 = (JSPUtil.getParameter(request, prefix	+ "cnee4", length));
			String[] cnee1 = (JSPUtil.getParameter(request, prefix	+ "cnee1", length));
			String[] cnee2 = (JSPUtil.getParameter(request, prefix	+ "cnee2", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			String[] bkgSpeRd = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_rd", length));
			String[] blpod = (JSPUtil.getParameter(request, prefix	+ "blpod", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] blorg = (JSPUtil.getParameter(request, prefix	+ "blorg", length));
			String[] bkgSpeRf = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_rf", length));
			String[] blplace = (JSPUtil.getParameter(request, prefix	+ "blplace", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr", length));
			String[] bldate = (JSPUtil.getParameter(request, prefix	+ "bldate", length));
			String[] blpkg = (JSPUtil.getParameter(request, prefix	+ "blpkg", length));
			String[] blpor = (JSPUtil.getParameter(request, prefix	+ "blpor", length));
			String[] ausQuar = (JSPUtil.getParameter(request, prefix	+ "aus_quar", length));
			String[] blpol = (JSPUtil.getParameter(request, prefix	+ "blpol", length));
			String[] cargotype = (JSPUtil.getParameter(request, prefix	+ "cargotype", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] ffwd5 = (JSPUtil.getParameter(request, prefix	+ "ffwd5", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] ffwd2 = (JSPUtil.getParameter(request, prefix	+ "ffwd2", length));
			String[] ffwd1 = (JSPUtil.getParameter(request, prefix	+ "ffwd1", length));
			String[] ffwd4 = (JSPUtil.getParameter(request, prefix	+ "ffwd4", length));
			String[] ffwd3 = (JSPUtil.getParameter(request, prefix	+ "ffwd3", length));
			String[] rdtype = (JSPUtil.getParameter(request, prefix	+ "rdtype", length));
			String[] blrly = (JSPUtil.getParameter(request, prefix	+ "blrly", length));
			String[] shpr2 = (JSPUtil.getParameter(request, prefix	+ "shpr2", length));
			String[] shpr1 = (JSPUtil.getParameter(request, prefix	+ "shpr1", length));
			String[] blwgt = (JSPUtil.getParameter(request, prefix	+ "blwgt", length));
			String[] shpr5 = (JSPUtil.getParameter(request, prefix	+ "shpr5", length));
			String[] bkgSpeDg = (JSPUtil.getParameter(request, prefix	+ "bkg_spe_dg", length));
			String[] shpr4 = (JSPUtil.getParameter(request, prefix	+ "shpr4", length));
			String[] expo1 = (JSPUtil.getParameter(request, prefix	+ "expo1", length));
			String[] shpr3 = (JSPUtil.getParameter(request, prefix	+ "shpr3", length));
			String[] ntfy5 = (JSPUtil.getParameter(request, prefix	+ "ntfy5", length));
			String[] commodity = (JSPUtil.getParameter(request, prefix	+ "commodity", length));
			String[] ntfy4 = (JSPUtil.getParameter(request, prefix	+ "ntfy4", length));
			String[] ntfy3 = (JSPUtil.getParameter(request, prefix	+ "ntfy3", length));
			String[] ntfy2 = (JSPUtil.getParameter(request, prefix	+ "ntfy2", length));
			String[] ntfy1 = (JSPUtil.getParameter(request, prefix	+ "ntfy1", length));
			String[] bkgnbr = (JSPUtil.getParameter(request, prefix	+ "bkgnbr", length));
			String[] blcopy = (JSPUtil.getParameter(request, prefix	+ "blcopy", length));
			String[] eiInd = (JSPUtil.getParameter(request, prefix	+ "ei_ind", length));
			
			for (int i = 0; i < length; i++) {
				model = new AusSearchBlGeneralForMVO();
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (ntfy25[i] != null)
					model.setNtfy25(ntfy25[i]);
				if (ntfy21[i] != null)
					model.setNtfy21(ntfy21[i]);
				if (blpkgu[i] != null)
					model.setBlpkgu(blpkgu[i]);
				if (ntfy22[i] != null)
					model.setNtfy22(ntfy22[i]);
				if (bldel[i] != null)
					model.setBldel(bldel[i]);
				if (ntfy23[i] != null)
					model.setNtfy23(ntfy23[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ntfy24[i] != null)
					model.setNtfy24(ntfy24[i]);
				if (blmea[i] != null)
					model.setBlmea(blmea[i]);
				if (frtInd[i] != null)
					model.setFrtInd(frtInd[i]);
				if (bkgSpeAk[i] != null)
					model.setBkgSpeAk(bkgSpeAk[i]);
				if (expo5[i] != null)
					model.setExpo5(expo5[i]);
				if (expo4[i] != null)
					model.setExpo4(expo4[i]);
				if (expo3[i] != null)
					model.setExpo3(expo3[i]);
				if (expo2[i] != null)
					model.setExpo2(expo2[i]);
				if (bkgSpeBb[i] != null)
					model.setBkgSpeBb(bkgSpeBb[i]);
				if (cnee5[i] != null)
					model.setCnee5(cnee5[i]);
				if (cnee3[i] != null)
					model.setCnee3(cnee3[i]);
				if (cnee4[i] != null)
					model.setCnee4(cnee4[i]);
				if (cnee1[i] != null)
					model.setCnee1(cnee1[i]);
				if (cnee2[i] != null)
					model.setCnee2(cnee2[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				if (bkgSpeRd[i] != null)
					model.setBkgSpeRd(bkgSpeRd[i]);
				if (blpod[i] != null)
					model.setBlpod(blpod[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (blorg[i] != null)
					model.setBlorg(blorg[i]);
				if (bkgSpeRf[i] != null)
					model.setBkgSpeRf(bkgSpeRf[i]);
				if (blplace[i] != null)
					model.setBlplace(blplace[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (blnbr[i] != null)
					model.setBlnbr(blnbr[i]);
				if (bldate[i] != null)
					model.setBldate(bldate[i]);
				if (blpkg[i] != null)
					model.setBlpkg(blpkg[i]);
				if (blpor[i] != null)
					model.setBlpor(blpor[i]);
				if (ausQuar[i] != null)
					model.setAusQuar(ausQuar[i]);
				if (blpol[i] != null)
					model.setBlpol(blpol[i]);
				if (cargotype[i] != null)
					model.setCargotype(cargotype[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (ffwd5[i] != null)
					model.setFfwd5(ffwd5[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (ffwd2[i] != null)
					model.setFfwd2(ffwd2[i]);
				if (ffwd1[i] != null)
					model.setFfwd1(ffwd1[i]);
				if (ffwd4[i] != null)
					model.setFfwd4(ffwd4[i]);
				if (ffwd3[i] != null)
					model.setFfwd3(ffwd3[i]);
				if (rdtype[i] != null)
					model.setRdtype(rdtype[i]);
				if (blrly[i] != null)
					model.setBlrly(blrly[i]);
				if (shpr2[i] != null)
					model.setShpr2(shpr2[i]);
				if (shpr1[i] != null)
					model.setShpr1(shpr1[i]);
				if (blwgt[i] != null)
					model.setBlwgt(blwgt[i]);
				if (shpr5[i] != null)
					model.setShpr5(shpr5[i]);
				if (bkgSpeDg[i] != null)
					model.setBkgSpeDg(bkgSpeDg[i]);
				if (shpr4[i] != null)
					model.setShpr4(shpr4[i]);
				if (expo1[i] != null)
					model.setExpo1(expo1[i]);
				if (shpr3[i] != null)
					model.setShpr3(shpr3[i]);
				if (ntfy5[i] != null)
					model.setNtfy5(ntfy5[i]);
				if (commodity[i] != null)
					model.setCommodity(commodity[i]);
				if (ntfy4[i] != null)
					model.setNtfy4(ntfy4[i]);
				if (ntfy3[i] != null)
					model.setNtfy3(ntfy3[i]);
				if (ntfy2[i] != null)
					model.setNtfy2(ntfy2[i]);
				if (ntfy1[i] != null)
					model.setNtfy1(ntfy1[i]);
				if (bkgnbr[i] != null)
					model.setBkgnbr(bkgnbr[i]);
				if (blcopy[i] != null)
					model.setBlcopy(blcopy[i]);
				if (eiInd[i] != null)
					model.setEiInd(eiInd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusSearchBlGeneralForMVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusSearchBlGeneralForMVO[]
	 */
	public AusSearchBlGeneralForMVO[] getAusSearchBlGeneralForMVOs(){
		AusSearchBlGeneralForMVO[] vos = (AusSearchBlGeneralForMVO[])models.toArray(new AusSearchBlGeneralForMVO[models.size()]);
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
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy25 = this.ntfy25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy21 = this.ntfy21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkgu = this.blpkgu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy22 = this.ntfy22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldel = this.bldel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy23 = this.ntfy23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy24 = this.ntfy24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blmea = this.blmea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtInd = this.frtInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeAk = this.bkgSpeAk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo5 = this.expo5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo4 = this.expo4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo3 = this.expo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo2 = this.expo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeBb = this.bkgSpeBb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee5 = this.cnee5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee3 = this.cnee3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee4 = this.cnee4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee1 = this.cnee1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee2 = this.cnee2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeRd = this.bkgSpeRd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpod = this.blpod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blorg = this.blorg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeRf = this.bkgSpeRf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplace = this.blplace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bldate = this.bldate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpkg = this.blpkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpor = this.blpor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ausQuar = this.ausQuar .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol = this.blpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cargotype = this.cargotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd5 = this.ffwd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd2 = this.ffwd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd1 = this.ffwd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd4 = this.ffwd4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffwd3 = this.ffwd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtype = this.rdtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blrly = this.blrly .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr2 = this.shpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr1 = this.shpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blwgt = this.blwgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr5 = this.shpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpeDg = this.bkgSpeDg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr4 = this.shpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expo1 = this.expo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr3 = this.shpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy5 = this.ntfy5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commodity = this.commodity .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy4 = this.ntfy4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy3 = this.ntfy3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2 = this.ntfy2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1 = this.ntfy1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgnbr = this.bkgnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blcopy = this.blcopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eiInd = this.eiInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
