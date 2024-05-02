/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315PrefixMainVO.java
*@FileTitle : Edi315PrefixMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.24 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315PrefixMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315PrefixMainVO> models = new ArrayList<Edi315PrefixMainVO>();
	
	/* Column Info */
	private String delAta = null;
	/* Column Info */
	private String porAmsport = null;
	/* Column Info */
	private String ntfyCityNm = null;
	/* Column Info */
	private String cneeCityNm = null;
	/* Column Info */
	private String cneeCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cneeStatCd = null;
	/* Column Info */
	private String polEtdGmt = null;
	/* Column Info */
	private String porAmsqual = null;
	/* Column Info */
	private String ntfyCntCd = null;
	/* Column Info */
	private String cnee5 = null;
	/* Column Info */
	private String cnee3 = null;
	/* Column Info */
	private String delNod = null;
	/* Column Info */
	private String cnee4 = null;
	/* Column Info */
	private String cnee1 = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String cnee2 = null;
	/* Column Info */
	private String polAta = null;
	/* Column Info */
	private String delCode = null;
	/* Column Info */
	private String polAtd = null;
	/* Column Info */
	private String porAtdGmt = null;
	/* Column Info */
	private String porAtd = null;
	/* Column Info */
	private String cneeZipCd = null;
	/* Column Info */
	private String polEtaGmt = null;
	/* Column Info */
	private String podAtaGmt = null;
	/* Column Info */
	private String shprCityNm = null;
	/* Column Info */
	private String delAmsqual = null;
	/* Column Info */
	private String podAmsqual = null;
	/* Column Info */
	private String delEtaGmt = null;
	/* Column Info */
	private String delName = null;
	/* Column Info */
	private String ntfycode = null;
	/* Column Info */
	private String ntfyZipCd = null;
	/* Column Info */
	private String polAtdGmt = null;
	/* Column Info */
	private String polAmsqual = null;
	/* Column Info */
	private String polEtd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podName = null;
	/* Column Info */
	private String cneecode = null;
	/* Column Info */
	private String delAtaGmt = null;
	/* Column Info */
	private String polCode = null;
	/* Column Info */
	private String podAmsport = null;
	/* Column Info */
	private String polName = null;
	/* Column Info */
	private String polEta = null;
	/* Column Info */
	private String ntfyStatCd = null;
	/* Column Info */
	private String shprZipCd = null;
	/* Column Info */
	private String podEtd = null;
	/* Column Info */
	private String porEtd = null;
	/* Column Info */
	private String porName = null;
	/* Column Info */
	private String podEtaGmt = null;
	/* Column Info */
	private String shpr2 = null;
	/* Column Info */
	private String delAmsport = null;
	/* Column Info */
	private String podAtd = null;
	/* Column Info */
	private String podAtdGmt = null;
	/* Column Info */
	private String shpr1 = null;
	/* Column Info */
	private String porEtdGmt = null;
	/* Column Info */
	private String porCode = null;
	/* Column Info */
	private String shprcode = null;
	/* Column Info */
	private String polAtaGmt = null;
	/* Column Info */
	private String podAta = null;
	/* Column Info */
	private String shpr5 = null;
	/* Column Info */
	private String delEta = null;
	/* Column Info */
	private String shpr4 = null;
	/* Column Info */
	private String shpr3 = null;
	/* Column Info */
	private String ntfy5 = null;
	/* Column Info */
	private String ntfy4 = null;
	/* Column Info */
	private String podCode = null;
	/* Column Info */
	private String ntfy3 = null;
	/* Column Info */
	private String shprStatCd = null;
	/* Column Info */
	private String ntfy2 = null;
	/* Column Info */
	private String ntfy1 = null;
	/* Column Info */
	private String podEtdGmt = null;
	/* Column Info */
	private String polAmsport = null;
	/* Column Info */
	private String podEta = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315PrefixMainVO() {}

	public Edi315PrefixMainVO(String ibflag, String pagerows, String porName, String porCode, String porAmsqual, String porAmsport, String polName, String polCode, String polAmsqual, String polAmsport, String podName, String podCode, String podAmsqual, String podAmsport, String delName, String delCode, String delAmsqual, String delAmsport, String porEtd, String porEtdGmt, String porAtd, String porAtdGmt, String polEta, String polEtaGmt, String polAta, String polAtaGmt, String polEtd, String polEtdGmt, String polAtd, String polAtdGmt, String podEta, String podEtaGmt, String podAta, String podAtaGmt, String podEtd, String podEtdGmt, String podAtd, String podAtdGmt, String delEta, String delEtaGmt, String delAta, String delAtaGmt, String delNod, String shprcode, String shpr1, String shpr2, String shpr3, String shpr4, String shpr5, String shprCityNm, String shprStatCd, String shprZipCd, String shprCntCd, String cneecode, String cnee1, String cnee2, String cnee3, String cnee4, String cnee5, String cneeCityNm, String cneeStatCd, String cneeZipCd, String cneeCntCd, String ntfycode, String ntfy1, String ntfy2, String ntfy3, String ntfy4, String ntfy5, String ntfyCityNm, String ntfyStatCd, String ntfyZipCd, String ntfyCntCd) {
		this.delAta = delAta;
		this.porAmsport = porAmsport;
		this.ntfyCityNm = ntfyCityNm;
		this.cneeCityNm = cneeCityNm;
		this.cneeCntCd = cneeCntCd;
		this.pagerows = pagerows;
		this.cneeStatCd = cneeStatCd;
		this.polEtdGmt = polEtdGmt;
		this.porAmsqual = porAmsqual;
		this.ntfyCntCd = ntfyCntCd;
		this.cnee5 = cnee5;
		this.cnee3 = cnee3;
		this.delNod = delNod;
		this.cnee4 = cnee4;
		this.cnee1 = cnee1;
		this.shprCntCd = shprCntCd;
		this.cnee2 = cnee2;
		this.polAta = polAta;
		this.delCode = delCode;
		this.polAtd = polAtd;
		this.porAtdGmt = porAtdGmt;
		this.porAtd = porAtd;
		this.cneeZipCd = cneeZipCd;
		this.polEtaGmt = polEtaGmt;
		this.podAtaGmt = podAtaGmt;
		this.shprCityNm = shprCityNm;
		this.delAmsqual = delAmsqual;
		this.podAmsqual = podAmsqual;
		this.delEtaGmt = delEtaGmt;
		this.delName = delName;
		this.ntfycode = ntfycode;
		this.ntfyZipCd = ntfyZipCd;
		this.polAtdGmt = polAtdGmt;
		this.polAmsqual = polAmsqual;
		this.polEtd = polEtd;
		this.ibflag = ibflag;
		this.podName = podName;
		this.cneecode = cneecode;
		this.delAtaGmt = delAtaGmt;
		this.polCode = polCode;
		this.podAmsport = podAmsport;
		this.polName = polName;
		this.polEta = polEta;
		this.ntfyStatCd = ntfyStatCd;
		this.shprZipCd = shprZipCd;
		this.podEtd = podEtd;
		this.porEtd = porEtd;
		this.porName = porName;
		this.podEtaGmt = podEtaGmt;
		this.shpr2 = shpr2;
		this.delAmsport = delAmsport;
		this.podAtd = podAtd;
		this.podAtdGmt = podAtdGmt;
		this.shpr1 = shpr1;
		this.porEtdGmt = porEtdGmt;
		this.porCode = porCode;
		this.shprcode = shprcode;
		this.polAtaGmt = polAtaGmt;
		this.podAta = podAta;
		this.shpr5 = shpr5;
		this.delEta = delEta;
		this.shpr4 = shpr4;
		this.shpr3 = shpr3;
		this.ntfy5 = ntfy5;
		this.ntfy4 = ntfy4;
		this.podCode = podCode;
		this.ntfy3 = ntfy3;
		this.shprStatCd = shprStatCd;
		this.ntfy2 = ntfy2;
		this.ntfy1 = ntfy1;
		this.podEtdGmt = podEtdGmt;
		this.polAmsport = polAmsport;
		this.podEta = podEta;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_ata", getDelAta());
		this.hashColumns.put("por_amsport", getPorAmsport());
		this.hashColumns.put("ntfy_city_nm", getNtfyCityNm());
		this.hashColumns.put("cnee_city_nm", getCneeCityNm());
		this.hashColumns.put("cnee_cnt_cd", getCneeCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnee_stat_cd", getCneeStatCd());
		this.hashColumns.put("pol_etd_gmt", getPolEtdGmt());
		this.hashColumns.put("por_amsqual", getPorAmsqual());
		this.hashColumns.put("ntfy_cnt_cd", getNtfyCntCd());
		this.hashColumns.put("cnee5", getCnee5());
		this.hashColumns.put("cnee3", getCnee3());
		this.hashColumns.put("del_nod", getDelNod());
		this.hashColumns.put("cnee4", getCnee4());
		this.hashColumns.put("cnee1", getCnee1());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("cnee2", getCnee2());
		this.hashColumns.put("pol_ata", getPolAta());
		this.hashColumns.put("del_code", getDelCode());
		this.hashColumns.put("pol_atd", getPolAtd());
		this.hashColumns.put("por_atd_gmt", getPorAtdGmt());
		this.hashColumns.put("por_atd", getPorAtd());
		this.hashColumns.put("cnee_zip_cd", getCneeZipCd());
		this.hashColumns.put("pol_eta_gmt", getPolEtaGmt());
		this.hashColumns.put("pod_ata_gmt", getPodAtaGmt());
		this.hashColumns.put("shpr_city_nm", getShprCityNm());
		this.hashColumns.put("del_amsqual", getDelAmsqual());
		this.hashColumns.put("pod_amsqual", getPodAmsqual());
		this.hashColumns.put("del_eta_gmt", getDelEtaGmt());
		this.hashColumns.put("del_name", getDelName());
		this.hashColumns.put("ntfycode", getNtfycode());
		this.hashColumns.put("ntfy_zip_cd", getNtfyZipCd());
		this.hashColumns.put("pol_atd_gmt", getPolAtdGmt());
		this.hashColumns.put("pol_amsqual", getPolAmsqual());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_name", getPodName());
		this.hashColumns.put("cneecode", getCneecode());
		this.hashColumns.put("del_ata_gmt", getDelAtaGmt());
		this.hashColumns.put("pol_code", getPolCode());
		this.hashColumns.put("pod_amsport", getPodAmsport());
		this.hashColumns.put("pol_name", getPolName());
		this.hashColumns.put("pol_eta", getPolEta());
		this.hashColumns.put("ntfy_stat_cd", getNtfyStatCd());
		this.hashColumns.put("shpr_zip_cd", getShprZipCd());
		this.hashColumns.put("pod_etd", getPodEtd());
		this.hashColumns.put("por_etd", getPorEtd());
		this.hashColumns.put("por_name", getPorName());
		this.hashColumns.put("pod_eta_gmt", getPodEtaGmt());
		this.hashColumns.put("shpr2", getShpr2());
		this.hashColumns.put("del_amsport", getDelAmsport());
		this.hashColumns.put("pod_atd", getPodAtd());
		this.hashColumns.put("pod_atd_gmt", getPodAtdGmt());
		this.hashColumns.put("shpr1", getShpr1());
		this.hashColumns.put("por_etd_gmt", getPorEtdGmt());
		this.hashColumns.put("por_code", getPorCode());
		this.hashColumns.put("shprcode", getShprcode());
		this.hashColumns.put("pol_ata_gmt", getPolAtaGmt());
		this.hashColumns.put("pod_ata", getPodAta());
		this.hashColumns.put("shpr5", getShpr5());
		this.hashColumns.put("del_eta", getDelEta());
		this.hashColumns.put("shpr4", getShpr4());
		this.hashColumns.put("shpr3", getShpr3());
		this.hashColumns.put("ntfy5", getNtfy5());
		this.hashColumns.put("ntfy4", getNtfy4());
		this.hashColumns.put("pod_code", getPodCode());
		this.hashColumns.put("ntfy3", getNtfy3());
		this.hashColumns.put("shpr_stat_cd", getShprStatCd());
		this.hashColumns.put("ntfy2", getNtfy2());
		this.hashColumns.put("ntfy1", getNtfy1());
		this.hashColumns.put("pod_etd_gmt", getPodEtdGmt());
		this.hashColumns.put("pol_amsport", getPolAmsport());
		this.hashColumns.put("pod_eta", getPodEta());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_ata", "delAta");
		this.hashFields.put("por_amsport", "porAmsport");
		this.hashFields.put("ntfy_city_nm", "ntfyCityNm");
		this.hashFields.put("cnee_city_nm", "cneeCityNm");
		this.hashFields.put("cnee_cnt_cd", "cneeCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnee_stat_cd", "cneeStatCd");
		this.hashFields.put("pol_etd_gmt", "polEtdGmt");
		this.hashFields.put("por_amsqual", "porAmsqual");
		this.hashFields.put("ntfy_cnt_cd", "ntfyCntCd");
		this.hashFields.put("cnee5", "cnee5");
		this.hashFields.put("cnee3", "cnee3");
		this.hashFields.put("del_nod", "delNod");
		this.hashFields.put("cnee4", "cnee4");
		this.hashFields.put("cnee1", "cnee1");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("cnee2", "cnee2");
		this.hashFields.put("pol_ata", "polAta");
		this.hashFields.put("del_code", "delCode");
		this.hashFields.put("pol_atd", "polAtd");
		this.hashFields.put("por_atd_gmt", "porAtdGmt");
		this.hashFields.put("por_atd", "porAtd");
		this.hashFields.put("cnee_zip_cd", "cneeZipCd");
		this.hashFields.put("pol_eta_gmt", "polEtaGmt");
		this.hashFields.put("pod_ata_gmt", "podAtaGmt");
		this.hashFields.put("shpr_city_nm", "shprCityNm");
		this.hashFields.put("del_amsqual", "delAmsqual");
		this.hashFields.put("pod_amsqual", "podAmsqual");
		this.hashFields.put("del_eta_gmt", "delEtaGmt");
		this.hashFields.put("del_name", "delName");
		this.hashFields.put("ntfycode", "ntfycode");
		this.hashFields.put("ntfy_zip_cd", "ntfyZipCd");
		this.hashFields.put("pol_atd_gmt", "polAtdGmt");
		this.hashFields.put("pol_amsqual", "polAmsqual");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_name", "podName");
		this.hashFields.put("cneecode", "cneecode");
		this.hashFields.put("del_ata_gmt", "delAtaGmt");
		this.hashFields.put("pol_code", "polCode");
		this.hashFields.put("pod_amsport", "podAmsport");
		this.hashFields.put("pol_name", "polName");
		this.hashFields.put("pol_eta", "polEta");
		this.hashFields.put("ntfy_stat_cd", "ntfyStatCd");
		this.hashFields.put("shpr_zip_cd", "shprZipCd");
		this.hashFields.put("pod_etd", "podEtd");
		this.hashFields.put("por_etd", "porEtd");
		this.hashFields.put("por_name", "porName");
		this.hashFields.put("pod_eta_gmt", "podEtaGmt");
		this.hashFields.put("shpr2", "shpr2");
		this.hashFields.put("del_amsport", "delAmsport");
		this.hashFields.put("pod_atd", "podAtd");
		this.hashFields.put("pod_atd_gmt", "podAtdGmt");
		this.hashFields.put("shpr1", "shpr1");
		this.hashFields.put("por_etd_gmt", "porEtdGmt");
		this.hashFields.put("por_code", "porCode");
		this.hashFields.put("shprcode", "shprcode");
		this.hashFields.put("pol_ata_gmt", "polAtaGmt");
		this.hashFields.put("pod_ata", "podAta");
		this.hashFields.put("shpr5", "shpr5");
		this.hashFields.put("del_eta", "delEta");
		this.hashFields.put("shpr4", "shpr4");
		this.hashFields.put("shpr3", "shpr3");
		this.hashFields.put("ntfy5", "ntfy5");
		this.hashFields.put("ntfy4", "ntfy4");
		this.hashFields.put("pod_code", "podCode");
		this.hashFields.put("ntfy3", "ntfy3");
		this.hashFields.put("shpr_stat_cd", "shprStatCd");
		this.hashFields.put("ntfy2", "ntfy2");
		this.hashFields.put("ntfy1", "ntfy1");
		this.hashFields.put("pod_etd_gmt", "podEtdGmt");
		this.hashFields.put("pol_amsport", "polAmsport");
		this.hashFields.put("pod_eta", "podEta");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return delAta
	 */
	public String getDelAta() {
		return this.delAta;
	}
	
	/**
	 * Column Info
	 * @return porAmsport
	 */
	public String getPorAmsport() {
		return this.porAmsport;
	}
	
	/**
	 * Column Info
	 * @return ntfyCityNm
	 */
	public String getNtfyCityNm() {
		return this.ntfyCityNm;
	}
	
	/**
	 * Column Info
	 * @return cneeCityNm
	 */
	public String getCneeCityNm() {
		return this.cneeCityNm;
	}
	
	/**
	 * Column Info
	 * @return cneeCntCd
	 */
	public String getCneeCntCd() {
		return this.cneeCntCd;
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
	 * @return cneeStatCd
	 */
	public String getCneeStatCd() {
		return this.cneeStatCd;
	}
	
	/**
	 * Column Info
	 * @return polEtdGmt
	 */
	public String getPolEtdGmt() {
		return this.polEtdGmt;
	}
	
	/**
	 * Column Info
	 * @return porAmsqual
	 */
	public String getPorAmsqual() {
		return this.porAmsqual;
	}
	
	/**
	 * Column Info
	 * @return ntfyCntCd
	 */
	public String getNtfyCntCd() {
		return this.ntfyCntCd;
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
	 * @return delNod
	 */
	public String getDelNod() {
		return this.delNod;
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
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
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
	 * @return polAta
	 */
	public String getPolAta() {
		return this.polAta;
	}
	
	/**
	 * Column Info
	 * @return delCode
	 */
	public String getDelCode() {
		return this.delCode;
	}
	
	/**
	 * Column Info
	 * @return polAtd
	 */
	public String getPolAtd() {
		return this.polAtd;
	}
	
	/**
	 * Column Info
	 * @return porAtdGmt
	 */
	public String getPorAtdGmt() {
		return this.porAtdGmt;
	}
	
	/**
	 * Column Info
	 * @return porAtd
	 */
	public String getPorAtd() {
		return this.porAtd;
	}
	
	/**
	 * Column Info
	 * @return cneeZipCd
	 */
	public String getCneeZipCd() {
		return this.cneeZipCd;
	}
	
	/**
	 * Column Info
	 * @return polEtaGmt
	 */
	public String getPolEtaGmt() {
		return this.polEtaGmt;
	}
	
	/**
	 * Column Info
	 * @return podAtaGmt
	 */
	public String getPodAtaGmt() {
		return this.podAtaGmt;
	}
	
	/**
	 * Column Info
	 * @return shprCityNm
	 */
	public String getShprCityNm() {
		return this.shprCityNm;
	}
	
	/**
	 * Column Info
	 * @return delAmsqual
	 */
	public String getDelAmsqual() {
		return this.delAmsqual;
	}
	
	/**
	 * Column Info
	 * @return podAmsqual
	 */
	public String getPodAmsqual() {
		return this.podAmsqual;
	}
	
	/**
	 * Column Info
	 * @return delEtaGmt
	 */
	public String getDelEtaGmt() {
		return this.delEtaGmt;
	}
	
	/**
	 * Column Info
	 * @return delName
	 */
	public String getDelName() {
		return this.delName;
	}
	
	/**
	 * Column Info
	 * @return ntfycode
	 */
	public String getNtfycode() {
		return this.ntfycode;
	}
	
	/**
	 * Column Info
	 * @return ntfyZipCd
	 */
	public String getNtfyZipCd() {
		return this.ntfyZipCd;
	}
	
	/**
	 * Column Info
	 * @return polAtdGmt
	 */
	public String getPolAtdGmt() {
		return this.polAtdGmt;
	}
	
	/**
	 * Column Info
	 * @return polAmsqual
	 */
	public String getPolAmsqual() {
		return this.polAmsqual;
	}
	
	/**
	 * Column Info
	 * @return polEtd
	 */
	public String getPolEtd() {
		return this.polEtd;
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
	 * @return podName
	 */
	public String getPodName() {
		return this.podName;
	}
	
	/**
	 * Column Info
	 * @return cneecode
	 */
	public String getCneecode() {
		return this.cneecode;
	}
	
	/**
	 * Column Info
	 * @return delAtaGmt
	 */
	public String getDelAtaGmt() {
		return this.delAtaGmt;
	}
	
	/**
	 * Column Info
	 * @return polCode
	 */
	public String getPolCode() {
		return this.polCode;
	}
	
	/**
	 * Column Info
	 * @return podAmsport
	 */
	public String getPodAmsport() {
		return this.podAmsport;
	}
	
	/**
	 * Column Info
	 * @return polName
	 */
	public String getPolName() {
		return this.polName;
	}
	
	/**
	 * Column Info
	 * @return polEta
	 */
	public String getPolEta() {
		return this.polEta;
	}
	
	/**
	 * Column Info
	 * @return ntfyStatCd
	 */
	public String getNtfyStatCd() {
		return this.ntfyStatCd;
	}
	
	/**
	 * Column Info
	 * @return shprZipCd
	 */
	public String getShprZipCd() {
		return this.shprZipCd;
	}
	
	/**
	 * Column Info
	 * @return podEtd
	 */
	public String getPodEtd() {
		return this.podEtd;
	}
	
	/**
	 * Column Info
	 * @return porEtd
	 */
	public String getPorEtd() {
		return this.porEtd;
	}
	
	/**
	 * Column Info
	 * @return porName
	 */
	public String getPorName() {
		return this.porName;
	}
	
	/**
	 * Column Info
	 * @return podEtaGmt
	 */
	public String getPodEtaGmt() {
		return this.podEtaGmt;
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
	 * @return delAmsport
	 */
	public String getDelAmsport() {
		return this.delAmsport;
	}
	
	/**
	 * Column Info
	 * @return podAtd
	 */
	public String getPodAtd() {
		return this.podAtd;
	}
	
	/**
	 * Column Info
	 * @return podAtdGmt
	 */
	public String getPodAtdGmt() {
		return this.podAtdGmt;
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
	 * @return porEtdGmt
	 */
	public String getPorEtdGmt() {
		return this.porEtdGmt;
	}
	
	/**
	 * Column Info
	 * @return porCode
	 */
	public String getPorCode() {
		return this.porCode;
	}
	
	/**
	 * Column Info
	 * @return shprcode
	 */
	public String getShprcode() {
		return this.shprcode;
	}
	
	/**
	 * Column Info
	 * @return polAtaGmt
	 */
	public String getPolAtaGmt() {
		return this.polAtaGmt;
	}
	
	/**
	 * Column Info
	 * @return podAta
	 */
	public String getPodAta() {
		return this.podAta;
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
	 * @return delEta
	 */
	public String getDelEta() {
		return this.delEta;
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
	 * @return ntfy4
	 */
	public String getNtfy4() {
		return this.ntfy4;
	}
	
	/**
	 * Column Info
	 * @return podCode
	 */
	public String getPodCode() {
		return this.podCode;
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
	 * @return shprStatCd
	 */
	public String getShprStatCd() {
		return this.shprStatCd;
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
	 * @return podEtdGmt
	 */
	public String getPodEtdGmt() {
		return this.podEtdGmt;
	}
	
	/**
	 * Column Info
	 * @return polAmsport
	 */
	public String getPolAmsport() {
		return this.polAmsport;
	}
	
	/**
	 * Column Info
	 * @return podEta
	 */
	public String getPodEta() {
		return this.podEta;
	}
	

	/**
	 * Column Info
	 * @param delAta
	 */
	public void setDelAta(String delAta) {
		this.delAta = delAta;
	}
	
	/**
	 * Column Info
	 * @param porAmsport
	 */
	public void setPorAmsport(String porAmsport) {
		this.porAmsport = porAmsport;
	}
	
	/**
	 * Column Info
	 * @param ntfyCityNm
	 */
	public void setNtfyCityNm(String ntfyCityNm) {
		this.ntfyCityNm = ntfyCityNm;
	}
	
	/**
	 * Column Info
	 * @param cneeCityNm
	 */
	public void setCneeCityNm(String cneeCityNm) {
		this.cneeCityNm = cneeCityNm;
	}
	
	/**
	 * Column Info
	 * @param cneeCntCd
	 */
	public void setCneeCntCd(String cneeCntCd) {
		this.cneeCntCd = cneeCntCd;
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
	 * @param cneeStatCd
	 */
	public void setCneeStatCd(String cneeStatCd) {
		this.cneeStatCd = cneeStatCd;
	}
	
	/**
	 * Column Info
	 * @param polEtdGmt
	 */
	public void setPolEtdGmt(String polEtdGmt) {
		this.polEtdGmt = polEtdGmt;
	}
	
	/**
	 * Column Info
	 * @param porAmsqual
	 */
	public void setPorAmsqual(String porAmsqual) {
		this.porAmsqual = porAmsqual;
	}
	
	/**
	 * Column Info
	 * @param ntfyCntCd
	 */
	public void setNtfyCntCd(String ntfyCntCd) {
		this.ntfyCntCd = ntfyCntCd;
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
	 * @param delNod
	 */
	public void setDelNod(String delNod) {
		this.delNod = delNod;
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
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
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
	 * @param polAta
	 */
	public void setPolAta(String polAta) {
		this.polAta = polAta;
	}
	
	/**
	 * Column Info
	 * @param delCode
	 */
	public void setDelCode(String delCode) {
		this.delCode = delCode;
	}
	
	/**
	 * Column Info
	 * @param polAtd
	 */
	public void setPolAtd(String polAtd) {
		this.polAtd = polAtd;
	}
	
	/**
	 * Column Info
	 * @param porAtdGmt
	 */
	public void setPorAtdGmt(String porAtdGmt) {
		this.porAtdGmt = porAtdGmt;
	}
	
	/**
	 * Column Info
	 * @param porAtd
	 */
	public void setPorAtd(String porAtd) {
		this.porAtd = porAtd;
	}
	
	/**
	 * Column Info
	 * @param cneeZipCd
	 */
	public void setCneeZipCd(String cneeZipCd) {
		this.cneeZipCd = cneeZipCd;
	}
	
	/**
	 * Column Info
	 * @param polEtaGmt
	 */
	public void setPolEtaGmt(String polEtaGmt) {
		this.polEtaGmt = polEtaGmt;
	}
	
	/**
	 * Column Info
	 * @param podAtaGmt
	 */
	public void setPodAtaGmt(String podAtaGmt) {
		this.podAtaGmt = podAtaGmt;
	}
	
	/**
	 * Column Info
	 * @param shprCityNm
	 */
	public void setShprCityNm(String shprCityNm) {
		this.shprCityNm = shprCityNm;
	}
	
	/**
	 * Column Info
	 * @param delAmsqual
	 */
	public void setDelAmsqual(String delAmsqual) {
		this.delAmsqual = delAmsqual;
	}
	
	/**
	 * Column Info
	 * @param podAmsqual
	 */
	public void setPodAmsqual(String podAmsqual) {
		this.podAmsqual = podAmsqual;
	}
	
	/**
	 * Column Info
	 * @param delEtaGmt
	 */
	public void setDelEtaGmt(String delEtaGmt) {
		this.delEtaGmt = delEtaGmt;
	}
	
	/**
	 * Column Info
	 * @param delName
	 */
	public void setDelName(String delName) {
		this.delName = delName;
	}
	
	/**
	 * Column Info
	 * @param ntfycode
	 */
	public void setNtfycode(String ntfycode) {
		this.ntfycode = ntfycode;
	}
	
	/**
	 * Column Info
	 * @param ntfyZipCd
	 */
	public void setNtfyZipCd(String ntfyZipCd) {
		this.ntfyZipCd = ntfyZipCd;
	}
	
	/**
	 * Column Info
	 * @param polAtdGmt
	 */
	public void setPolAtdGmt(String polAtdGmt) {
		this.polAtdGmt = polAtdGmt;
	}
	
	/**
	 * Column Info
	 * @param polAmsqual
	 */
	public void setPolAmsqual(String polAmsqual) {
		this.polAmsqual = polAmsqual;
	}
	
	/**
	 * Column Info
	 * @param polEtd
	 */
	public void setPolEtd(String polEtd) {
		this.polEtd = polEtd;
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
	 * @param podName
	 */
	public void setPodName(String podName) {
		this.podName = podName;
	}
	
	/**
	 * Column Info
	 * @param cneecode
	 */
	public void setCneecode(String cneecode) {
		this.cneecode = cneecode;
	}
	
	/**
	 * Column Info
	 * @param delAtaGmt
	 */
	public void setDelAtaGmt(String delAtaGmt) {
		this.delAtaGmt = delAtaGmt;
	}
	
	/**
	 * Column Info
	 * @param polCode
	 */
	public void setPolCode(String polCode) {
		this.polCode = polCode;
	}
	
	/**
	 * Column Info
	 * @param podAmsport
	 */
	public void setPodAmsport(String podAmsport) {
		this.podAmsport = podAmsport;
	}
	
	/**
	 * Column Info
	 * @param polName
	 */
	public void setPolName(String polName) {
		this.polName = polName;
	}
	
	/**
	 * Column Info
	 * @param polEta
	 */
	public void setPolEta(String polEta) {
		this.polEta = polEta;
	}
	
	/**
	 * Column Info
	 * @param ntfyStatCd
	 */
	public void setNtfyStatCd(String ntfyStatCd) {
		this.ntfyStatCd = ntfyStatCd;
	}
	
	/**
	 * Column Info
	 * @param shprZipCd
	 */
	public void setShprZipCd(String shprZipCd) {
		this.shprZipCd = shprZipCd;
	}
	
	/**
	 * Column Info
	 * @param podEtd
	 */
	public void setPodEtd(String podEtd) {
		this.podEtd = podEtd;
	}
	
	/**
	 * Column Info
	 * @param porEtd
	 */
	public void setPorEtd(String porEtd) {
		this.porEtd = porEtd;
	}
	
	/**
	 * Column Info
	 * @param porName
	 */
	public void setPorName(String porName) {
		this.porName = porName;
	}
	
	/**
	 * Column Info
	 * @param podEtaGmt
	 */
	public void setPodEtaGmt(String podEtaGmt) {
		this.podEtaGmt = podEtaGmt;
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
	 * @param delAmsport
	 */
	public void setDelAmsport(String delAmsport) {
		this.delAmsport = delAmsport;
	}
	
	/**
	 * Column Info
	 * @param podAtd
	 */
	public void setPodAtd(String podAtd) {
		this.podAtd = podAtd;
	}
	
	/**
	 * Column Info
	 * @param podAtdGmt
	 */
	public void setPodAtdGmt(String podAtdGmt) {
		this.podAtdGmt = podAtdGmt;
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
	 * @param porEtdGmt
	 */
	public void setPorEtdGmt(String porEtdGmt) {
		this.porEtdGmt = porEtdGmt;
	}
	
	/**
	 * Column Info
	 * @param porCode
	 */
	public void setPorCode(String porCode) {
		this.porCode = porCode;
	}
	
	/**
	 * Column Info
	 * @param shprcode
	 */
	public void setShprcode(String shprcode) {
		this.shprcode = shprcode;
	}
	
	/**
	 * Column Info
	 * @param polAtaGmt
	 */
	public void setPolAtaGmt(String polAtaGmt) {
		this.polAtaGmt = polAtaGmt;
	}
	
	/**
	 * Column Info
	 * @param podAta
	 */
	public void setPodAta(String podAta) {
		this.podAta = podAta;
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
	 * @param delEta
	 */
	public void setDelEta(String delEta) {
		this.delEta = delEta;
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
	 * @param ntfy4
	 */
	public void setNtfy4(String ntfy4) {
		this.ntfy4 = ntfy4;
	}
	
	/**
	 * Column Info
	 * @param podCode
	 */
	public void setPodCode(String podCode) {
		this.podCode = podCode;
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
	 * @param shprStatCd
	 */
	public void setShprStatCd(String shprStatCd) {
		this.shprStatCd = shprStatCd;
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
	 * @param podEtdGmt
	 */
	public void setPodEtdGmt(String podEtdGmt) {
		this.podEtdGmt = podEtdGmt;
	}
	
	/**
	 * Column Info
	 * @param polAmsport
	 */
	public void setPolAmsport(String polAmsport) {
		this.polAmsport = polAmsport;
	}
	
	/**
	 * Column Info
	 * @param podEta
	 */
	public void setPodEta(String podEta) {
		this.podEta = podEta;
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
		setDelAta(JSPUtil.getParameter(request, prefix + "del_ata", ""));
		setPorAmsport(JSPUtil.getParameter(request, prefix + "por_amsport", ""));
		setNtfyCityNm(JSPUtil.getParameter(request, prefix + "ntfy_city_nm", ""));
		setCneeCityNm(JSPUtil.getParameter(request, prefix + "cnee_city_nm", ""));
		setCneeCntCd(JSPUtil.getParameter(request, prefix + "cnee_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCneeStatCd(JSPUtil.getParameter(request, prefix + "cnee_stat_cd", ""));
		setPolEtdGmt(JSPUtil.getParameter(request, prefix + "pol_etd_gmt", ""));
		setPorAmsqual(JSPUtil.getParameter(request, prefix + "por_amsqual", ""));
		setNtfyCntCd(JSPUtil.getParameter(request, prefix + "ntfy_cnt_cd", ""));
		setCnee5(JSPUtil.getParameter(request, prefix + "cnee5", ""));
		setCnee3(JSPUtil.getParameter(request, prefix + "cnee3", ""));
		setDelNod(JSPUtil.getParameter(request, prefix + "del_nod", ""));
		setCnee4(JSPUtil.getParameter(request, prefix + "cnee4", ""));
		setCnee1(JSPUtil.getParameter(request, prefix + "cnee1", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setCnee2(JSPUtil.getParameter(request, prefix + "cnee2", ""));
		setPolAta(JSPUtil.getParameter(request, prefix + "pol_ata", ""));
		setDelCode(JSPUtil.getParameter(request, prefix + "del_code", ""));
		setPolAtd(JSPUtil.getParameter(request, prefix + "pol_atd", ""));
		setPorAtdGmt(JSPUtil.getParameter(request, prefix + "por_atd_gmt", ""));
		setPorAtd(JSPUtil.getParameter(request, prefix + "por_atd", ""));
		setCneeZipCd(JSPUtil.getParameter(request, prefix + "cnee_zip_cd", ""));
		setPolEtaGmt(JSPUtil.getParameter(request, prefix + "pol_eta_gmt", ""));
		setPodAtaGmt(JSPUtil.getParameter(request, prefix + "pod_ata_gmt", ""));
		setShprCityNm(JSPUtil.getParameter(request, prefix + "shpr_city_nm", ""));
		setDelAmsqual(JSPUtil.getParameter(request, prefix + "del_amsqual", ""));
		setPodAmsqual(JSPUtil.getParameter(request, prefix + "pod_amsqual", ""));
		setDelEtaGmt(JSPUtil.getParameter(request, prefix + "del_eta_gmt", ""));
		setDelName(JSPUtil.getParameter(request, prefix + "del_name", ""));
		setNtfycode(JSPUtil.getParameter(request, prefix + "ntfycode", ""));
		setNtfyZipCd(JSPUtil.getParameter(request, prefix + "ntfy_zip_cd", ""));
		setPolAtdGmt(JSPUtil.getParameter(request, prefix + "pol_atd_gmt", ""));
		setPolAmsqual(JSPUtil.getParameter(request, prefix + "pol_amsqual", ""));
		setPolEtd(JSPUtil.getParameter(request, prefix + "pol_etd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPodName(JSPUtil.getParameter(request, prefix + "pod_name", ""));
		setCneecode(JSPUtil.getParameter(request, prefix + "cneecode", ""));
		setDelAtaGmt(JSPUtil.getParameter(request, prefix + "del_ata_gmt", ""));
		setPolCode(JSPUtil.getParameter(request, prefix + "pol_code", ""));
		setPodAmsport(JSPUtil.getParameter(request, prefix + "pod_amsport", ""));
		setPolName(JSPUtil.getParameter(request, prefix + "pol_name", ""));
		setPolEta(JSPUtil.getParameter(request, prefix + "pol_eta", ""));
		setNtfyStatCd(JSPUtil.getParameter(request, prefix + "ntfy_stat_cd", ""));
		setShprZipCd(JSPUtil.getParameter(request, prefix + "shpr_zip_cd", ""));
		setPodEtd(JSPUtil.getParameter(request, prefix + "pod_etd", ""));
		setPorEtd(JSPUtil.getParameter(request, prefix + "por_etd", ""));
		setPorName(JSPUtil.getParameter(request, prefix + "por_name", ""));
		setPodEtaGmt(JSPUtil.getParameter(request, prefix + "pod_eta_gmt", ""));
		setShpr2(JSPUtil.getParameter(request, prefix + "shpr2", ""));
		setDelAmsport(JSPUtil.getParameter(request, prefix + "del_amsport", ""));
		setPodAtd(JSPUtil.getParameter(request, prefix + "pod_atd", ""));
		setPodAtdGmt(JSPUtil.getParameter(request, prefix + "pod_atd_gmt", ""));
		setShpr1(JSPUtil.getParameter(request, prefix + "shpr1", ""));
		setPorEtdGmt(JSPUtil.getParameter(request, prefix + "por_etd_gmt", ""));
		setPorCode(JSPUtil.getParameter(request, prefix + "por_code", ""));
		setShprcode(JSPUtil.getParameter(request, prefix + "shprcode", ""));
		setPolAtaGmt(JSPUtil.getParameter(request, prefix + "pol_ata_gmt", ""));
		setPodAta(JSPUtil.getParameter(request, prefix + "pod_ata", ""));
		setShpr5(JSPUtil.getParameter(request, prefix + "shpr5", ""));
		setDelEta(JSPUtil.getParameter(request, prefix + "del_eta", ""));
		setShpr4(JSPUtil.getParameter(request, prefix + "shpr4", ""));
		setShpr3(JSPUtil.getParameter(request, prefix + "shpr3", ""));
		setNtfy5(JSPUtil.getParameter(request, prefix + "ntfy5", ""));
		setNtfy4(JSPUtil.getParameter(request, prefix + "ntfy4", ""));
		setPodCode(JSPUtil.getParameter(request, prefix + "pod_code", ""));
		setNtfy3(JSPUtil.getParameter(request, prefix + "ntfy3", ""));
		setShprStatCd(JSPUtil.getParameter(request, prefix + "shpr_stat_cd", ""));
		setNtfy2(JSPUtil.getParameter(request, prefix + "ntfy2", ""));
		setNtfy1(JSPUtil.getParameter(request, prefix + "ntfy1", ""));
		setPodEtdGmt(JSPUtil.getParameter(request, prefix + "pod_etd_gmt", ""));
		setPolAmsport(JSPUtil.getParameter(request, prefix + "pol_amsport", ""));
		setPodEta(JSPUtil.getParameter(request, prefix + "pod_eta", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315PrefixMainVO[]
	 */
	public Edi315PrefixMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315PrefixMainVO[]
	 */
	public Edi315PrefixMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315PrefixMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delAta = (JSPUtil.getParameter(request, prefix	+ "del_ata", length));
			String[] porAmsport = (JSPUtil.getParameter(request, prefix	+ "por_amsport", length));
			String[] ntfyCityNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_city_nm", length));
			String[] cneeCityNm = (JSPUtil.getParameter(request, prefix	+ "cnee_city_nm", length));
			String[] cneeCntCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cneeStatCd = (JSPUtil.getParameter(request, prefix	+ "cnee_stat_cd", length));
			String[] polEtdGmt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_gmt", length));
			String[] porAmsqual = (JSPUtil.getParameter(request, prefix	+ "por_amsqual", length));
			String[] ntfyCntCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cnt_cd", length));
			String[] cnee5 = (JSPUtil.getParameter(request, prefix	+ "cnee5", length));
			String[] cnee3 = (JSPUtil.getParameter(request, prefix	+ "cnee3", length));
			String[] delNod = (JSPUtil.getParameter(request, prefix	+ "del_nod", length));
			String[] cnee4 = (JSPUtil.getParameter(request, prefix	+ "cnee4", length));
			String[] cnee1 = (JSPUtil.getParameter(request, prefix	+ "cnee1", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] cnee2 = (JSPUtil.getParameter(request, prefix	+ "cnee2", length));
			String[] polAta = (JSPUtil.getParameter(request, prefix	+ "pol_ata", length));
			String[] delCode = (JSPUtil.getParameter(request, prefix	+ "del_code", length));
			String[] polAtd = (JSPUtil.getParameter(request, prefix	+ "pol_atd", length));
			String[] porAtdGmt = (JSPUtil.getParameter(request, prefix	+ "por_atd_gmt", length));
			String[] porAtd = (JSPUtil.getParameter(request, prefix	+ "por_atd", length));
			String[] cneeZipCd = (JSPUtil.getParameter(request, prefix	+ "cnee_zip_cd", length));
			String[] polEtaGmt = (JSPUtil.getParameter(request, prefix	+ "pol_eta_gmt", length));
			String[] podAtaGmt = (JSPUtil.getParameter(request, prefix	+ "pod_ata_gmt", length));
			String[] shprCityNm = (JSPUtil.getParameter(request, prefix	+ "shpr_city_nm", length));
			String[] delAmsqual = (JSPUtil.getParameter(request, prefix	+ "del_amsqual", length));
			String[] podAmsqual = (JSPUtil.getParameter(request, prefix	+ "pod_amsqual", length));
			String[] delEtaGmt = (JSPUtil.getParameter(request, prefix	+ "del_eta_gmt", length));
			String[] delName = (JSPUtil.getParameter(request, prefix	+ "del_name", length));
			String[] ntfycode = (JSPUtil.getParameter(request, prefix	+ "ntfycode", length));
			String[] ntfyZipCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_zip_cd", length));
			String[] polAtdGmt = (JSPUtil.getParameter(request, prefix	+ "pol_atd_gmt", length));
			String[] polAmsqual = (JSPUtil.getParameter(request, prefix	+ "pol_amsqual", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podName = (JSPUtil.getParameter(request, prefix	+ "pod_name", length));
			String[] cneecode = (JSPUtil.getParameter(request, prefix	+ "cneecode", length));
			String[] delAtaGmt = (JSPUtil.getParameter(request, prefix	+ "del_ata_gmt", length));
			String[] polCode = (JSPUtil.getParameter(request, prefix	+ "pol_code", length));
			String[] podAmsport = (JSPUtil.getParameter(request, prefix	+ "pod_amsport", length));
			String[] polName = (JSPUtil.getParameter(request, prefix	+ "pol_name", length));
			String[] polEta = (JSPUtil.getParameter(request, prefix	+ "pol_eta", length));
			String[] ntfyStatCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_stat_cd", length));
			String[] shprZipCd = (JSPUtil.getParameter(request, prefix	+ "shpr_zip_cd", length));
			String[] podEtd = (JSPUtil.getParameter(request, prefix	+ "pod_etd", length));
			String[] porEtd = (JSPUtil.getParameter(request, prefix	+ "por_etd", length));
			String[] porName = (JSPUtil.getParameter(request, prefix	+ "por_name", length));
			String[] podEtaGmt = (JSPUtil.getParameter(request, prefix	+ "pod_eta_gmt", length));
			String[] shpr2 = (JSPUtil.getParameter(request, prefix	+ "shpr2", length));
			String[] delAmsport = (JSPUtil.getParameter(request, prefix	+ "del_amsport", length));
			String[] podAtd = (JSPUtil.getParameter(request, prefix	+ "pod_atd", length));
			String[] podAtdGmt = (JSPUtil.getParameter(request, prefix	+ "pod_atd_gmt", length));
			String[] shpr1 = (JSPUtil.getParameter(request, prefix	+ "shpr1", length));
			String[] porEtdGmt = (JSPUtil.getParameter(request, prefix	+ "por_etd_gmt", length));
			String[] porCode = (JSPUtil.getParameter(request, prefix	+ "por_code", length));
			String[] shprcode = (JSPUtil.getParameter(request, prefix	+ "shprcode", length));
			String[] polAtaGmt = (JSPUtil.getParameter(request, prefix	+ "pol_ata_gmt", length));
			String[] podAta = (JSPUtil.getParameter(request, prefix	+ "pod_ata", length));
			String[] shpr5 = (JSPUtil.getParameter(request, prefix	+ "shpr5", length));
			String[] delEta = (JSPUtil.getParameter(request, prefix	+ "del_eta", length));
			String[] shpr4 = (JSPUtil.getParameter(request, prefix	+ "shpr4", length));
			String[] shpr3 = (JSPUtil.getParameter(request, prefix	+ "shpr3", length));
			String[] ntfy5 = (JSPUtil.getParameter(request, prefix	+ "ntfy5", length));
			String[] ntfy4 = (JSPUtil.getParameter(request, prefix	+ "ntfy4", length));
			String[] podCode = (JSPUtil.getParameter(request, prefix	+ "pod_code", length));
			String[] ntfy3 = (JSPUtil.getParameter(request, prefix	+ "ntfy3", length));
			String[] shprStatCd = (JSPUtil.getParameter(request, prefix	+ "shpr_stat_cd", length));
			String[] ntfy2 = (JSPUtil.getParameter(request, prefix	+ "ntfy2", length));
			String[] ntfy1 = (JSPUtil.getParameter(request, prefix	+ "ntfy1", length));
			String[] podEtdGmt = (JSPUtil.getParameter(request, prefix	+ "pod_etd_gmt", length));
			String[] polAmsport = (JSPUtil.getParameter(request, prefix	+ "pol_amsport", length));
			String[] podEta = (JSPUtil.getParameter(request, prefix	+ "pod_eta", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315PrefixMainVO();
				if (delAta[i] != null)
					model.setDelAta(delAta[i]);
				if (porAmsport[i] != null)
					model.setPorAmsport(porAmsport[i]);
				if (ntfyCityNm[i] != null)
					model.setNtfyCityNm(ntfyCityNm[i]);
				if (cneeCityNm[i] != null)
					model.setCneeCityNm(cneeCityNm[i]);
				if (cneeCntCd[i] != null)
					model.setCneeCntCd(cneeCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cneeStatCd[i] != null)
					model.setCneeStatCd(cneeStatCd[i]);
				if (polEtdGmt[i] != null)
					model.setPolEtdGmt(polEtdGmt[i]);
				if (porAmsqual[i] != null)
					model.setPorAmsqual(porAmsqual[i]);
				if (ntfyCntCd[i] != null)
					model.setNtfyCntCd(ntfyCntCd[i]);
				if (cnee5[i] != null)
					model.setCnee5(cnee5[i]);
				if (cnee3[i] != null)
					model.setCnee3(cnee3[i]);
				if (delNod[i] != null)
					model.setDelNod(delNod[i]);
				if (cnee4[i] != null)
					model.setCnee4(cnee4[i]);
				if (cnee1[i] != null)
					model.setCnee1(cnee1[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (cnee2[i] != null)
					model.setCnee2(cnee2[i]);
				if (polAta[i] != null)
					model.setPolAta(polAta[i]);
				if (delCode[i] != null)
					model.setDelCode(delCode[i]);
				if (polAtd[i] != null)
					model.setPolAtd(polAtd[i]);
				if (porAtdGmt[i] != null)
					model.setPorAtdGmt(porAtdGmt[i]);
				if (porAtd[i] != null)
					model.setPorAtd(porAtd[i]);
				if (cneeZipCd[i] != null)
					model.setCneeZipCd(cneeZipCd[i]);
				if (polEtaGmt[i] != null)
					model.setPolEtaGmt(polEtaGmt[i]);
				if (podAtaGmt[i] != null)
					model.setPodAtaGmt(podAtaGmt[i]);
				if (shprCityNm[i] != null)
					model.setShprCityNm(shprCityNm[i]);
				if (delAmsqual[i] != null)
					model.setDelAmsqual(delAmsqual[i]);
				if (podAmsqual[i] != null)
					model.setPodAmsqual(podAmsqual[i]);
				if (delEtaGmt[i] != null)
					model.setDelEtaGmt(delEtaGmt[i]);
				if (delName[i] != null)
					model.setDelName(delName[i]);
				if (ntfycode[i] != null)
					model.setNtfycode(ntfycode[i]);
				if (ntfyZipCd[i] != null)
					model.setNtfyZipCd(ntfyZipCd[i]);
				if (polAtdGmt[i] != null)
					model.setPolAtdGmt(polAtdGmt[i]);
				if (polAmsqual[i] != null)
					model.setPolAmsqual(polAmsqual[i]);
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podName[i] != null)
					model.setPodName(podName[i]);
				if (cneecode[i] != null)
					model.setCneecode(cneecode[i]);
				if (delAtaGmt[i] != null)
					model.setDelAtaGmt(delAtaGmt[i]);
				if (polCode[i] != null)
					model.setPolCode(polCode[i]);
				if (podAmsport[i] != null)
					model.setPodAmsport(podAmsport[i]);
				if (polName[i] != null)
					model.setPolName(polName[i]);
				if (polEta[i] != null)
					model.setPolEta(polEta[i]);
				if (ntfyStatCd[i] != null)
					model.setNtfyStatCd(ntfyStatCd[i]);
				if (shprZipCd[i] != null)
					model.setShprZipCd(shprZipCd[i]);
				if (podEtd[i] != null)
					model.setPodEtd(podEtd[i]);
				if (porEtd[i] != null)
					model.setPorEtd(porEtd[i]);
				if (porName[i] != null)
					model.setPorName(porName[i]);
				if (podEtaGmt[i] != null)
					model.setPodEtaGmt(podEtaGmt[i]);
				if (shpr2[i] != null)
					model.setShpr2(shpr2[i]);
				if (delAmsport[i] != null)
					model.setDelAmsport(delAmsport[i]);
				if (podAtd[i] != null)
					model.setPodAtd(podAtd[i]);
				if (podAtdGmt[i] != null)
					model.setPodAtdGmt(podAtdGmt[i]);
				if (shpr1[i] != null)
					model.setShpr1(shpr1[i]);
				if (porEtdGmt[i] != null)
					model.setPorEtdGmt(porEtdGmt[i]);
				if (porCode[i] != null)
					model.setPorCode(porCode[i]);
				if (shprcode[i] != null)
					model.setShprcode(shprcode[i]);
				if (polAtaGmt[i] != null)
					model.setPolAtaGmt(polAtaGmt[i]);
				if (podAta[i] != null)
					model.setPodAta(podAta[i]);
				if (shpr5[i] != null)
					model.setShpr5(shpr5[i]);
				if (delEta[i] != null)
					model.setDelEta(delEta[i]);
				if (shpr4[i] != null)
					model.setShpr4(shpr4[i]);
				if (shpr3[i] != null)
					model.setShpr3(shpr3[i]);
				if (ntfy5[i] != null)
					model.setNtfy5(ntfy5[i]);
				if (ntfy4[i] != null)
					model.setNtfy4(ntfy4[i]);
				if (podCode[i] != null)
					model.setPodCode(podCode[i]);
				if (ntfy3[i] != null)
					model.setNtfy3(ntfy3[i]);
				if (shprStatCd[i] != null)
					model.setShprStatCd(shprStatCd[i]);
				if (ntfy2[i] != null)
					model.setNtfy2(ntfy2[i]);
				if (ntfy1[i] != null)
					model.setNtfy1(ntfy1[i]);
				if (podEtdGmt[i] != null)
					model.setPodEtdGmt(podEtdGmt[i]);
				if (polAmsport[i] != null)
					model.setPolAmsport(polAmsport[i]);
				if (podEta[i] != null)
					model.setPodEta(podEta[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315PrefixMainVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315PrefixMainVO[]
	 */
	public Edi315PrefixMainVO[] getEdi315PrefixMainVOs(){
		Edi315PrefixMainVO[] vos = (Edi315PrefixMainVO[])models.toArray(new Edi315PrefixMainVO[models.size()]);
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
		this.delAta = this.delAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAmsport = this.porAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCityNm = this.ntfyCityNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCityNm = this.cneeCityNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCntCd = this.cneeCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeStatCd = this.cneeStatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdGmt = this.polEtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAmsqual = this.porAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCntCd = this.ntfyCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee5 = this.cnee5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee3 = this.cnee3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNod = this.delNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee4 = this.cnee4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee1 = this.cnee1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee2 = this.cnee2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAta = this.polAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCode = this.delCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtd = this.polAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAtdGmt = this.porAtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAtd = this.porAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeZipCd = this.cneeZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtaGmt = this.polEtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtaGmt = this.podAtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCityNm = this.shprCityNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAmsqual = this.delAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAmsqual = this.podAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEtaGmt = this.delEtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delName = this.delName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfycode = this.ntfycode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyZipCd = this.ntfyZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtdGmt = this.polAtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAmsqual = this.polAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podName = this.podName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneecode = this.cneecode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAtaGmt = this.delAtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCode = this.polCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAmsport = this.podAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polName = this.polName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEta = this.polEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyStatCd = this.ntfyStatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprZipCd = this.shprZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtd = this.podEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porEtd = this.porEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porName = this.porName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtaGmt = this.podEtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr2 = this.shpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAmsport = this.delAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtd = this.podAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtdGmt = this.podAtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr1 = this.shpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porEtdGmt = this.porEtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCode = this.porCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprcode = this.shprcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtaGmt = this.polAtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAta = this.podAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr5 = this.shpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEta = this.delEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr4 = this.shpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr3 = this.shpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy5 = this.ntfy5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy4 = this.ntfy4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCode = this.podCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy3 = this.ntfy3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprStatCd = this.shprStatCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy2 = this.ntfy2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfy1 = this.ntfy1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtdGmt = this.podEtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAmsport = this.polAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEta = this.podEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
