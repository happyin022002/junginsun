/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Edi315PrefixMainCOPInfoVO.java
*@FileTitle : Edi315PrefixMainCOPInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.29
*@LastModifier : 이경원
*@LastVersion : 1.0
* 2011.08.29 이경원 
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
 * @author 이경원
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315PrefixMainCOPInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315PrefixMainCOPInfoVO> models = new ArrayList<Edi315PrefixMainCOPInfoVO>();
	
	/* Column Info */
	private String delAta = null;
	/* Column Info */
	private String porAmsport = null;
	/* Column Info */
	private String polAtdGmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polAmsqual = null;
	/* Column Info */
	private String polEtd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podName = null;
	/* Column Info */
	private String delAtaGmt = null;
	/* Column Info */
	private String polCode = null;
	/* Column Info */
	private String polEtdGmt = null;
	/* Column Info */
	private String polName = null;
	/* Column Info */
	private String podAmsport = null;
	/* Column Info */
	private String porAmsqual = null;
	/* Column Info */
	private String polEta = null;
	/* Column Info */
	private String podEtd = null;
	/* Column Info */
	private String delNod = null;
	/* Column Info */
	private String porEtd = null;
	/* Column Info */
	private String podEtaGmt = null;
	/* Column Info */
	private String porName = null;
	/* Column Info */
	private String podAtdGmt = null;
	/* Column Info */
	private String podAtd = null;
	/* Column Info */
	private String delCode = null;
	/* Column Info */
	private String delAmsport = null;
	/* Column Info */
	private String polAta = null;
	/* Column Info */
	private String porCode = null;
	/* Column Info */
	private String porEtdGmt = null;
	/* Column Info */
	private String podAta = null;
	/* Column Info */
	private String polAtd = null;
	/* Column Info */
	private String polAtaGmt = null;
	/* Column Info */
	private String porAtdGmt = null;
	/* Column Info */
	private String delEta = null;
	/* Column Info */
	private String porAtd = null;
	/* Column Info */
	private String podAtb = null;
	/* Column Info */
	private String podEtbGmt = null;
	/* Column Info */
	private String podAtaGmt = null;
	/* Column Info */
	private String podCode = null;
	/* Column Info */
	private String polEtaGmt = null;
	/* Column Info */
	private String podAmsqual = null;
	/* Column Info */
	private String delAmsqual = null;
	/* Column Info */
	private String delEtaGmt = null;
	/* Column Info */
	private String podEtdGmt = null;
	/* Column Info */
	private String polAmsport = null;
	/* Column Info */
	private String podAtbGmt = null;
	/* Column Info */
	private String podEtb = null;
	/* Column Info */
	private String delName = null;
	/* Column Info */
	private String podEta = null;
	/* Column Info */
	private String ydNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315PrefixMainCOPInfoVO() {}

	public Edi315PrefixMainCOPInfoVO(String ibflag, String pagerows, String porName, String porCode, String porAmsqual, String porAmsport, String polName, String polCode, String polAmsqual, String polAmsport, String podName, String podCode, String podAmsqual, String podAmsport, String delName, String delCode, String delAmsqual, String delAmsport, String porEtd, String porEtdGmt, String porAtd, String porAtdGmt, String polEta, String polEtaGmt, String polAta, String polAtaGmt, String polEtd, String polEtdGmt, String polAtd, String polAtdGmt, String podEta, String podEtaGmt, String podAta, String podAtaGmt, String podEtd, String podEtdGmt, String podAtd, String podAtdGmt, String podEtb, String podEtbGmt, String podAtb, String podAtbGmt, String delEta, String delEtaGmt, String delAta, String delAtaGmt, String delNod, String ydNm) {
		this.delAta = delAta;
		this.porAmsport = porAmsport;
		this.polAtdGmt = polAtdGmt;
		this.pagerows = pagerows;
		this.polAmsqual = polAmsqual;
		this.polEtd = polEtd;
		this.ibflag = ibflag;
		this.podName = podName;
		this.delAtaGmt = delAtaGmt;
		this.polCode = polCode;
		this.polEtdGmt = polEtdGmt;
		this.polName = polName;
		this.podAmsport = podAmsport;
		this.porAmsqual = porAmsqual;
		this.polEta = polEta;
		this.podEtd = podEtd;
		this.delNod = delNod;
		this.porEtd = porEtd;
		this.podEtaGmt = podEtaGmt;
		this.porName = porName;
		this.podAtdGmt = podAtdGmt;
		this.podAtd = podAtd;
		this.delCode = delCode;
		this.delAmsport = delAmsport;
		this.polAta = polAta;
		this.porCode = porCode;
		this.porEtdGmt = porEtdGmt;
		this.podAta = podAta;
		this.polAtd = polAtd;
		this.polAtaGmt = polAtaGmt;
		this.porAtdGmt = porAtdGmt;
		this.delEta = delEta;
		this.porAtd = porAtd;
		this.podAtb = podAtb;
		this.podEtbGmt = podEtbGmt;
		this.podAtaGmt = podAtaGmt;
		this.podCode = podCode;
		this.polEtaGmt = polEtaGmt;
		this.podAmsqual = podAmsqual;
		this.delAmsqual = delAmsqual;
		this.delEtaGmt = delEtaGmt;
		this.podEtdGmt = podEtdGmt;
		this.polAmsport = polAmsport;
		this.podAtbGmt = podAtbGmt;
		this.podEtb = podEtb;
		this.delName = delName;
		this.podEta = podEta;
		this.ydNm = ydNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_ata", getDelAta());
		this.hashColumns.put("por_amsport", getPorAmsport());
		this.hashColumns.put("pol_atd_gmt", getPolAtdGmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_amsqual", getPolAmsqual());
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_name", getPodName());
		this.hashColumns.put("del_ata_gmt", getDelAtaGmt());
		this.hashColumns.put("pol_code", getPolCode());
		this.hashColumns.put("pol_etd_gmt", getPolEtdGmt());
		this.hashColumns.put("pol_name", getPolName());
		this.hashColumns.put("pod_amsport", getPodAmsport());
		this.hashColumns.put("por_amsqual", getPorAmsqual());
		this.hashColumns.put("pol_eta", getPolEta());
		this.hashColumns.put("pod_etd", getPodEtd());
		this.hashColumns.put("del_nod", getDelNod());
		this.hashColumns.put("por_etd", getPorEtd());
		this.hashColumns.put("pod_eta_gmt", getPodEtaGmt());
		this.hashColumns.put("por_name", getPorName());
		this.hashColumns.put("pod_atd_gmt", getPodAtdGmt());
		this.hashColumns.put("pod_atd", getPodAtd());
		this.hashColumns.put("del_code", getDelCode());
		this.hashColumns.put("del_amsport", getDelAmsport());
		this.hashColumns.put("pol_ata", getPolAta());
		this.hashColumns.put("por_code", getPorCode());
		this.hashColumns.put("por_etd_gmt", getPorEtdGmt());
		this.hashColumns.put("pod_ata", getPodAta());
		this.hashColumns.put("pol_atd", getPolAtd());
		this.hashColumns.put("pol_ata_gmt", getPolAtaGmt());
		this.hashColumns.put("por_atd_gmt", getPorAtdGmt());
		this.hashColumns.put("del_eta", getDelEta());
		this.hashColumns.put("por_atd", getPorAtd());
		this.hashColumns.put("pod_atb", getPodAtb());
		this.hashColumns.put("pod_etb_gmt", getPodEtbGmt());
		this.hashColumns.put("pod_ata_gmt", getPodAtaGmt());
		this.hashColumns.put("pod_code", getPodCode());
		this.hashColumns.put("pol_eta_gmt", getPolEtaGmt());
		this.hashColumns.put("pod_amsqual", getPodAmsqual());
		this.hashColumns.put("del_amsqual", getDelAmsqual());
		this.hashColumns.put("del_eta_gmt", getDelEtaGmt());
		this.hashColumns.put("pod_etd_gmt", getPodEtdGmt());
		this.hashColumns.put("pol_amsport", getPolAmsport());
		this.hashColumns.put("pod_atb_gmt", getPodAtbGmt());
		this.hashColumns.put("pod_etb", getPodEtb());
		this.hashColumns.put("del_name", getDelName());
		this.hashColumns.put("pod_eta", getPodEta());
		this.hashColumns.put("yd_nm", getYdNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_ata", "delAta");
		this.hashFields.put("por_amsport", "porAmsport");
		this.hashFields.put("pol_atd_gmt", "polAtdGmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_amsqual", "polAmsqual");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_name", "podName");
		this.hashFields.put("del_ata_gmt", "delAtaGmt");
		this.hashFields.put("pol_code", "polCode");
		this.hashFields.put("pol_etd_gmt", "polEtdGmt");
		this.hashFields.put("pol_name", "polName");
		this.hashFields.put("pod_amsport", "podAmsport");
		this.hashFields.put("por_amsqual", "porAmsqual");
		this.hashFields.put("pol_eta", "polEta");
		this.hashFields.put("pod_etd", "podEtd");
		this.hashFields.put("del_nod", "delNod");
		this.hashFields.put("por_etd", "porEtd");
		this.hashFields.put("pod_eta_gmt", "podEtaGmt");
		this.hashFields.put("por_name", "porName");
		this.hashFields.put("pod_atd_gmt", "podAtdGmt");
		this.hashFields.put("pod_atd", "podAtd");
		this.hashFields.put("del_code", "delCode");
		this.hashFields.put("del_amsport", "delAmsport");
		this.hashFields.put("pol_ata", "polAta");
		this.hashFields.put("por_code", "porCode");
		this.hashFields.put("por_etd_gmt", "porEtdGmt");
		this.hashFields.put("pod_ata", "podAta");
		this.hashFields.put("pol_atd", "polAtd");
		this.hashFields.put("pol_ata_gmt", "polAtaGmt");
		this.hashFields.put("por_atd_gmt", "porAtdGmt");
		this.hashFields.put("del_eta", "delEta");
		this.hashFields.put("por_atd", "porAtd");
		this.hashFields.put("pod_atb", "podAtb");
		this.hashFields.put("pod_etb_gmt", "podEtbGmt");
		this.hashFields.put("pod_ata_gmt", "podAtaGmt");
		this.hashFields.put("pod_code", "podCode");
		this.hashFields.put("pol_eta_gmt", "polEtaGmt");
		this.hashFields.put("pod_amsqual", "podAmsqual");
		this.hashFields.put("del_amsqual", "delAmsqual");
		this.hashFields.put("del_eta_gmt", "delEtaGmt");
		this.hashFields.put("pod_etd_gmt", "podEtdGmt");
		this.hashFields.put("pol_amsport", "polAmsport");
		this.hashFields.put("pod_atb_gmt", "podAtbGmt");
		this.hashFields.put("pod_etb", "podEtb");
		this.hashFields.put("del_name", "delName");
		this.hashFields.put("pod_eta", "podEta");
		this.hashFields.put("yd_nm", "ydNm");
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
	 * @return polAtdGmt
	 */
	public String getPolAtdGmt() {
		return this.polAtdGmt;
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
	 * @return polEtdGmt
	 */
	public String getPolEtdGmt() {
		return this.polEtdGmt;
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
	 * @return podAmsport
	 */
	public String getPodAmsport() {
		return this.podAmsport;
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
	 * @return polEta
	 */
	public String getPolEta() {
		return this.polEta;
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
	 * @return delNod
	 */
	public String getDelNod() {
		return this.delNod;
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
	 * @return podEtaGmt
	 */
	public String getPodEtaGmt() {
		return this.podEtaGmt;
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
	 * @return podAtdGmt
	 */
	public String getPodAtdGmt() {
		return this.podAtdGmt;
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
	 * @return delCode
	 */
	public String getDelCode() {
		return this.delCode;
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
	 * @return polAta
	 */
	public String getPolAta() {
		return this.polAta;
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
	 * @return porEtdGmt
	 */
	public String getPorEtdGmt() {
		return this.porEtdGmt;
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
	 * @return polAtd
	 */
	public String getPolAtd() {
		return this.polAtd;
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
	 * @return porAtdGmt
	 */
	public String getPorAtdGmt() {
		return this.porAtdGmt;
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
	 * @return porAtd
	 */
	public String getPorAtd() {
		return this.porAtd;
	}
	
	/**
	 * Column Info
	 * @return podAtb
	 */
	public String getPodAtb() {
		return this.podAtb;
	}
	
	/**
	 * Column Info
	 * @return podEtbGmt
	 */
	public String getPodEtbGmt() {
		return this.podEtbGmt;
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
	 * @return podCode
	 */
	public String getPodCode() {
		return this.podCode;
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
	 * @return podAmsqual
	 */
	public String getPodAmsqual() {
		return this.podAmsqual;
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
	 * @return delEtaGmt
	 */
	public String getDelEtaGmt() {
		return this.delEtaGmt;
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
	 * @return podAtbGmt
	 */
	public String getPodAtbGmt() {
		return this.podAtbGmt;
	}
	
	/**
	 * Column Info
	 * @return podEtb
	 */
	public String getPodEtb() {
		return this.podEtb;
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
	 * @return podEta
	 */
	public String getPodEta() {
		return this.podEta;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
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
	 * @param polAtdGmt
	 */
	public void setPolAtdGmt(String polAtdGmt) {
		this.polAtdGmt = polAtdGmt;
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
	 * @param polEtdGmt
	 */
	public void setPolEtdGmt(String polEtdGmt) {
		this.polEtdGmt = polEtdGmt;
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
	 * @param podAmsport
	 */
	public void setPodAmsport(String podAmsport) {
		this.podAmsport = podAmsport;
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
	 * @param polEta
	 */
	public void setPolEta(String polEta) {
		this.polEta = polEta;
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
	 * @param delNod
	 */
	public void setDelNod(String delNod) {
		this.delNod = delNod;
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
	 * @param podEtaGmt
	 */
	public void setPodEtaGmt(String podEtaGmt) {
		this.podEtaGmt = podEtaGmt;
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
	 * @param podAtdGmt
	 */
	public void setPodAtdGmt(String podAtdGmt) {
		this.podAtdGmt = podAtdGmt;
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
	 * @param delCode
	 */
	public void setDelCode(String delCode) {
		this.delCode = delCode;
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
	 * @param polAta
	 */
	public void setPolAta(String polAta) {
		this.polAta = polAta;
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
	 * @param porEtdGmt
	 */
	public void setPorEtdGmt(String porEtdGmt) {
		this.porEtdGmt = porEtdGmt;
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
	 * @param polAtd
	 */
	public void setPolAtd(String polAtd) {
		this.polAtd = polAtd;
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
	 * @param porAtdGmt
	 */
	public void setPorAtdGmt(String porAtdGmt) {
		this.porAtdGmt = porAtdGmt;
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
	 * @param porAtd
	 */
	public void setPorAtd(String porAtd) {
		this.porAtd = porAtd;
	}
	
	/**
	 * Column Info
	 * @param podAtb
	 */
	public void setPodAtb(String podAtb) {
		this.podAtb = podAtb;
	}
	
	/**
	 * Column Info
	 * @param podEtbGmt
	 */
	public void setPodEtbGmt(String podEtbGmt) {
		this.podEtbGmt = podEtbGmt;
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
	 * @param podCode
	 */
	public void setPodCode(String podCode) {
		this.podCode = podCode;
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
	 * @param podAmsqual
	 */
	public void setPodAmsqual(String podAmsqual) {
		this.podAmsqual = podAmsqual;
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
	 * @param delEtaGmt
	 */
	public void setDelEtaGmt(String delEtaGmt) {
		this.delEtaGmt = delEtaGmt;
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
	 * @param podAtbGmt
	 */
	public void setPodAtbGmt(String podAtbGmt) {
		this.podAtbGmt = podAtbGmt;
	}
	
	/**
	 * Column Info
	 * @param podEtb
	 */
	public void setPodEtb(String podEtb) {
		this.podEtb = podEtb;
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
	 * @param podEta
	 */
	public void setPodEta(String podEta) {
		this.podEta = podEta;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
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
		setPolAtdGmt(JSPUtil.getParameter(request, prefix + "pol_atd_gmt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolAmsqual(JSPUtil.getParameter(request, prefix + "pol_amsqual", ""));
		setPolEtd(JSPUtil.getParameter(request, prefix + "pol_etd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPodName(JSPUtil.getParameter(request, prefix + "pod_name", ""));
		setDelAtaGmt(JSPUtil.getParameter(request, prefix + "del_ata_gmt", ""));
		setPolCode(JSPUtil.getParameter(request, prefix + "pol_code", ""));
		setPolEtdGmt(JSPUtil.getParameter(request, prefix + "pol_etd_gmt", ""));
		setPolName(JSPUtil.getParameter(request, prefix + "pol_name", ""));
		setPodAmsport(JSPUtil.getParameter(request, prefix + "pod_amsport", ""));
		setPorAmsqual(JSPUtil.getParameter(request, prefix + "por_amsqual", ""));
		setPolEta(JSPUtil.getParameter(request, prefix + "pol_eta", ""));
		setPodEtd(JSPUtil.getParameter(request, prefix + "pod_etd", ""));
		setDelNod(JSPUtil.getParameter(request, prefix + "del_nod", ""));
		setPorEtd(JSPUtil.getParameter(request, prefix + "por_etd", ""));
		setPodEtaGmt(JSPUtil.getParameter(request, prefix + "pod_eta_gmt", ""));
		setPorName(JSPUtil.getParameter(request, prefix + "por_name", ""));
		setPodAtdGmt(JSPUtil.getParameter(request, prefix + "pod_atd_gmt", ""));
		setPodAtd(JSPUtil.getParameter(request, prefix + "pod_atd", ""));
		setDelCode(JSPUtil.getParameter(request, prefix + "del_code", ""));
		setDelAmsport(JSPUtil.getParameter(request, prefix + "del_amsport", ""));
		setPolAta(JSPUtil.getParameter(request, prefix + "pol_ata", ""));
		setPorCode(JSPUtil.getParameter(request, prefix + "por_code", ""));
		setPorEtdGmt(JSPUtil.getParameter(request, prefix + "por_etd_gmt", ""));
		setPodAta(JSPUtil.getParameter(request, prefix + "pod_ata", ""));
		setPolAtd(JSPUtil.getParameter(request, prefix + "pol_atd", ""));
		setPolAtaGmt(JSPUtil.getParameter(request, prefix + "pol_ata_gmt", ""));
		setPorAtdGmt(JSPUtil.getParameter(request, prefix + "por_atd_gmt", ""));
		setDelEta(JSPUtil.getParameter(request, prefix + "del_eta", ""));
		setPorAtd(JSPUtil.getParameter(request, prefix + "por_atd", ""));
		setPodAtb(JSPUtil.getParameter(request, prefix + "pod_atb", ""));
		setPodEtbGmt(JSPUtil.getParameter(request, prefix + "pod_etb_gmt", ""));
		setPodAtaGmt(JSPUtil.getParameter(request, prefix + "pod_ata_gmt", ""));
		setPodCode(JSPUtil.getParameter(request, prefix + "pod_code", ""));
		setPolEtaGmt(JSPUtil.getParameter(request, prefix + "pol_eta_gmt", ""));
		setPodAmsqual(JSPUtil.getParameter(request, prefix + "pod_amsqual", ""));
		setDelAmsqual(JSPUtil.getParameter(request, prefix + "del_amsqual", ""));
		setDelEtaGmt(JSPUtil.getParameter(request, prefix + "del_eta_gmt", ""));
		setPodEtdGmt(JSPUtil.getParameter(request, prefix + "pod_etd_gmt", ""));
		setPolAmsport(JSPUtil.getParameter(request, prefix + "pol_amsport", ""));
		setPodAtbGmt(JSPUtil.getParameter(request, prefix + "pod_atb_gmt", ""));
		setPodEtb(JSPUtil.getParameter(request, prefix + "pod_etb", ""));
		setDelName(JSPUtil.getParameter(request, prefix + "del_name", ""));
		setPodEta(JSPUtil.getParameter(request, prefix + "pod_eta", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315PrefixMainCOPInfoVO[]
	 */
	public Edi315PrefixMainCOPInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315PrefixMainCOPInfoVO[]
	 */
	public Edi315PrefixMainCOPInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315PrefixMainCOPInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delAta = (JSPUtil.getParameter(request, prefix	+ "del_ata", length));
			String[] porAmsport = (JSPUtil.getParameter(request, prefix	+ "por_amsport", length));
			String[] polAtdGmt = (JSPUtil.getParameter(request, prefix	+ "pol_atd_gmt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polAmsqual = (JSPUtil.getParameter(request, prefix	+ "pol_amsqual", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podName = (JSPUtil.getParameter(request, prefix	+ "pod_name", length));
			String[] delAtaGmt = (JSPUtil.getParameter(request, prefix	+ "del_ata_gmt", length));
			String[] polCode = (JSPUtil.getParameter(request, prefix	+ "pol_code", length));
			String[] polEtdGmt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_gmt", length));
			String[] polName = (JSPUtil.getParameter(request, prefix	+ "pol_name", length));
			String[] podAmsport = (JSPUtil.getParameter(request, prefix	+ "pod_amsport", length));
			String[] porAmsqual = (JSPUtil.getParameter(request, prefix	+ "por_amsqual", length));
			String[] polEta = (JSPUtil.getParameter(request, prefix	+ "pol_eta", length));
			String[] podEtd = (JSPUtil.getParameter(request, prefix	+ "pod_etd", length));
			String[] delNod = (JSPUtil.getParameter(request, prefix	+ "del_nod", length));
			String[] porEtd = (JSPUtil.getParameter(request, prefix	+ "por_etd", length));
			String[] podEtaGmt = (JSPUtil.getParameter(request, prefix	+ "pod_eta_gmt", length));
			String[] porName = (JSPUtil.getParameter(request, prefix	+ "por_name", length));
			String[] podAtdGmt = (JSPUtil.getParameter(request, prefix	+ "pod_atd_gmt", length));
			String[] podAtd = (JSPUtil.getParameter(request, prefix	+ "pod_atd", length));
			String[] delCode = (JSPUtil.getParameter(request, prefix	+ "del_code", length));
			String[] delAmsport = (JSPUtil.getParameter(request, prefix	+ "del_amsport", length));
			String[] polAta = (JSPUtil.getParameter(request, prefix	+ "pol_ata", length));
			String[] porCode = (JSPUtil.getParameter(request, prefix	+ "por_code", length));
			String[] porEtdGmt = (JSPUtil.getParameter(request, prefix	+ "por_etd_gmt", length));
			String[] podAta = (JSPUtil.getParameter(request, prefix	+ "pod_ata", length));
			String[] polAtd = (JSPUtil.getParameter(request, prefix	+ "pol_atd", length));
			String[] polAtaGmt = (JSPUtil.getParameter(request, prefix	+ "pol_ata_gmt", length));
			String[] porAtdGmt = (JSPUtil.getParameter(request, prefix	+ "por_atd_gmt", length));
			String[] delEta = (JSPUtil.getParameter(request, prefix	+ "del_eta", length));
			String[] porAtd = (JSPUtil.getParameter(request, prefix	+ "por_atd", length));
			String[] podAtb = (JSPUtil.getParameter(request, prefix	+ "pod_atb", length));
			String[] podEtbGmt = (JSPUtil.getParameter(request, prefix	+ "pod_etb_gmt", length));
			String[] podAtaGmt = (JSPUtil.getParameter(request, prefix	+ "pod_ata_gmt", length));
			String[] podCode = (JSPUtil.getParameter(request, prefix	+ "pod_code", length));
			String[] polEtaGmt = (JSPUtil.getParameter(request, prefix	+ "pol_eta_gmt", length));
			String[] podAmsqual = (JSPUtil.getParameter(request, prefix	+ "pod_amsqual", length));
			String[] delAmsqual = (JSPUtil.getParameter(request, prefix	+ "del_amsqual", length));
			String[] delEtaGmt = (JSPUtil.getParameter(request, prefix	+ "del_eta_gmt", length));
			String[] podEtdGmt = (JSPUtil.getParameter(request, prefix	+ "pod_etd_gmt", length));
			String[] polAmsport = (JSPUtil.getParameter(request, prefix	+ "pol_amsport", length));
			String[] podAtbGmt = (JSPUtil.getParameter(request, prefix	+ "pod_atb_gmt", length));
			String[] podEtb = (JSPUtil.getParameter(request, prefix	+ "pod_etb", length));
			String[] delName = (JSPUtil.getParameter(request, prefix	+ "del_name", length));
			String[] podEta = (JSPUtil.getParameter(request, prefix	+ "pod_eta", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315PrefixMainCOPInfoVO();
				if (delAta[i] != null)
					model.setDelAta(delAta[i]);
				if (porAmsport[i] != null)
					model.setPorAmsport(porAmsport[i]);
				if (polAtdGmt[i] != null)
					model.setPolAtdGmt(polAtdGmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polAmsqual[i] != null)
					model.setPolAmsqual(polAmsqual[i]);
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podName[i] != null)
					model.setPodName(podName[i]);
				if (delAtaGmt[i] != null)
					model.setDelAtaGmt(delAtaGmt[i]);
				if (polCode[i] != null)
					model.setPolCode(polCode[i]);
				if (polEtdGmt[i] != null)
					model.setPolEtdGmt(polEtdGmt[i]);
				if (polName[i] != null)
					model.setPolName(polName[i]);
				if (podAmsport[i] != null)
					model.setPodAmsport(podAmsport[i]);
				if (porAmsqual[i] != null)
					model.setPorAmsqual(porAmsqual[i]);
				if (polEta[i] != null)
					model.setPolEta(polEta[i]);
				if (podEtd[i] != null)
					model.setPodEtd(podEtd[i]);
				if (delNod[i] != null)
					model.setDelNod(delNod[i]);
				if (porEtd[i] != null)
					model.setPorEtd(porEtd[i]);
				if (podEtaGmt[i] != null)
					model.setPodEtaGmt(podEtaGmt[i]);
				if (porName[i] != null)
					model.setPorName(porName[i]);
				if (podAtdGmt[i] != null)
					model.setPodAtdGmt(podAtdGmt[i]);
				if (podAtd[i] != null)
					model.setPodAtd(podAtd[i]);
				if (delCode[i] != null)
					model.setDelCode(delCode[i]);
				if (delAmsport[i] != null)
					model.setDelAmsport(delAmsport[i]);
				if (polAta[i] != null)
					model.setPolAta(polAta[i]);
				if (porCode[i] != null)
					model.setPorCode(porCode[i]);
				if (porEtdGmt[i] != null)
					model.setPorEtdGmt(porEtdGmt[i]);
				if (podAta[i] != null)
					model.setPodAta(podAta[i]);
				if (polAtd[i] != null)
					model.setPolAtd(polAtd[i]);
				if (polAtaGmt[i] != null)
					model.setPolAtaGmt(polAtaGmt[i]);
				if (porAtdGmt[i] != null)
					model.setPorAtdGmt(porAtdGmt[i]);
				if (delEta[i] != null)
					model.setDelEta(delEta[i]);
				if (porAtd[i] != null)
					model.setPorAtd(porAtd[i]);
				if (podAtb[i] != null)
					model.setPodAtb(podAtb[i]);
				if (podEtbGmt[i] != null)
					model.setPodEtbGmt(podEtbGmt[i]);
				if (podAtaGmt[i] != null)
					model.setPodAtaGmt(podAtaGmt[i]);
				if (podCode[i] != null)
					model.setPodCode(podCode[i]);
				if (polEtaGmt[i] != null)
					model.setPolEtaGmt(polEtaGmt[i]);
				if (podAmsqual[i] != null)
					model.setPodAmsqual(podAmsqual[i]);
				if (delAmsqual[i] != null)
					model.setDelAmsqual(delAmsqual[i]);
				if (delEtaGmt[i] != null)
					model.setDelEtaGmt(delEtaGmt[i]);
				if (podEtdGmt[i] != null)
					model.setPodEtdGmt(podEtdGmt[i]);
				if (polAmsport[i] != null)
					model.setPolAmsport(polAmsport[i]);
				if (podAtbGmt[i] != null)
					model.setPodAtbGmt(podAtbGmt[i]);
				if (podEtb[i] != null)
					model.setPodEtb(podEtb[i]);
				if (delName[i] != null)
					model.setDelName(delName[i]);
				if (podEta[i] != null)
					model.setPodEta(podEta[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315PrefixMainCOPInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315PrefixMainCOPInfoVO[]
	 */
	public Edi315PrefixMainCOPInfoVO[] getEdi315PrefixMainCOPInfoVOs(){
		Edi315PrefixMainCOPInfoVO[] vos = (Edi315PrefixMainCOPInfoVO[])models.toArray(new Edi315PrefixMainCOPInfoVO[models.size()]);
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
		this.polAtdGmt = this.polAtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAmsqual = this.polAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podName = this.podName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAtaGmt = this.delAtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCode = this.polCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdGmt = this.polEtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polName = this.polName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAmsport = this.podAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAmsqual = this.porAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEta = this.polEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtd = this.podEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNod = this.delNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porEtd = this.porEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtaGmt = this.podEtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porName = this.porName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtdGmt = this.podAtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtd = this.podAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCode = this.delCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAmsport = this.delAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAta = this.polAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCode = this.porCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porEtdGmt = this.porEtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAta = this.podAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtd = this.polAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtaGmt = this.polAtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAtdGmt = this.porAtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEta = this.delEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAtd = this.porAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtb = this.podAtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtbGmt = this.podEtbGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtaGmt = this.podAtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCode = this.podCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtaGmt = this.polEtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAmsqual = this.podAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAmsqual = this.delAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delEtaGmt = this.delEtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtdGmt = this.podEtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAmsport = this.polAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtbGmt = this.podAtbGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtb = this.podEtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delName = this.delName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEta = this.podEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
