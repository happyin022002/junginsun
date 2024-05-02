/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BookingSummary.java
*@FileTitle : Booking Summary Info
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.event;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy Output Parameter<br>
 * - EventResponse에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class BookingSummary implements java.io.Serializable {
	/** (Param 객체) */
	private String shipperNm = null;
	private String shipperFaxNo = null;
	private String porCd = null;
	private String porNm = null;
	private String polCd = null;
	private String polNm = null;

	private String bb = null;
	private String hd = null;
	private String rf = null;
	private String rd = null;
	private String dg = null;
	private String ak = null;
	private String sc = null;
	private String rb = null;
	private String bkgCmdtCd = null;
	private String porCntCd = null;
	private String polCntCd = null;
	private String statusCd = null;
	private String stopOffInd = null;
	private String rartDt = null;
	private String rrcvDtFm = null;
	private String rrcvDtTo = null;
	private String spclCustFlg = null;
	private String alocStsCd = null;
	private String nonRtStsCd = null;
	
	/**
	 * @return Returns the nonRtStsCd.
	 */
	public String getNonRtStsCd() {
		return nonRtStsCd;
	}
	/**
	 * @param nonRtStsCd The nonRtStsCd to set.
	 */
	public void setNonRtStsCd(String nonRtStsCd) {
		this.nonRtStsCd = nonRtStsCd;
	}
	/**
	 * @return Returns the alocStsCd.
	 */
	public String getAlocStsCd() {
		return alocStsCd;
	}
	/**
	 * @param alocStsCd The alocStsCd to set.
	 */
	public void setAlocStsCd(String alocStsCd) {
		this.alocStsCd = alocStsCd;
	}
	/**
	 * @return Returns the ak.
	 */
	public String getAk() {
		return ak;
	}
	/**
	 * @param ak The ak to set.
	 */
	public void setAk(String ak) {
		this.ak = ak;
	}
	/**
	 * @return Returns the bb.
	 */
	public String getBb() {
		return bb;
	}
	/**
	 * @param bb The bb to set.
	 */
	public void setBb(String bb) {
		this.bb = bb;
	}
	/**
	 * @return Returns the dg.
	 */
	public String getDg() {
		return dg;
	}
	/**
	 * @param dg The dg to set.
	 */
	public void setDg(String dg) {
		this.dg = dg;
	}
	/**
	 * @return Returns the hd.
	 */
	public String getHd() {
		return hd;
	}
	/**
	 * @param hd The hd to set.
	 */
	public void setHd(String hd) {
		this.hd = hd;
	}
	/**
	 * @return Returns the pol_cd.
	 */
	public String getPol_cd() {
		return polCd;
	}
	/**
	 * @param pol_cd The pol_cd to set.
	 */
	public void setPol_cd(String pol_cd) {
		this.polCd = pol_cd;
	}
	/**
	 * @return Returns the pol_cnt_cd.
	 */
	public String getPol_cnt_cd() {
		return polCntCd;
	}
	/**
	 * @param pol_cnt_cd The pol_cnt_cd to set.
	 */
	public void setPol_cnt_cd(String pol_cnt_cd) {
		this.polCntCd = pol_cnt_cd;
	}
	/**
	 * @return Returns the pol_nm.
	 */
	public String getPol_nm() {
		return polNm;
	}
	/**
	 * @param pol_nm The pol_nm to set.
	 */
	public void setPol_nm(String pol_nm) {
		this.polNm = pol_nm;
	}
	/**
	 * @return Returns the por_cd.
	 */
	public String getPor_cd() {
		return porCd;
	}
	/**
	 * @param por_cd The por_cd to set.
	 */
	public void setPor_cd(String por_cd) {
		this.porCd = por_cd;
	}
	/**
	 * @return Returns the por_cnt_cd.
	 */
	public String getPor_cnt_cd() {
		return porCntCd;
	}
	/**
	 * @param por_cnt_cd The por_cnt_cd to set.
	 */
	public void setPor_cnt_cd(String por_cnt_cd) {
		this.porCntCd = por_cnt_cd;
	}
	/**
	 * @return Returns the por_nm.
	 */
	public String getPor_nm() {
		return porNm;
	}
	/**
	 * @param por_nm The por_nm to set.
	 */
	public void setPor_nm(String por_nm) {
		this.porNm = por_nm;
	}
	/**
	 * @return Returns the rd.
	 */
	public String getRd() {
		return rd;
	}
	/**
	 * @param rd The rd to set.
	 */
	public void setRd(String rd) {
		this.rd = rd;
	}
	/**
	 * @return Returns the rf.
	 */
	public String getRf() {
		return rf;
	}
	/**
	 * @param rf The rf to set.
	 */
	public void setRf(String rf) {
		this.rf = rf;
	}
	/**
	 * @return Returns the sc.
	 */
	public String getSc() {
		return sc;
	}
	/**
	 * @param sc The sc to set.
	 */
	public void setSc(String sc) {
		this.sc = sc;
	}
	/**
	 * @return Returns the shipper_fax_no.
	 */
	public String getShipper_fax_no() {
		return shipperFaxNo;
	}
	/**
	 * @param shipper_fax_no The shipper_fax_no to set.
	 */
	public void setShipper_fax_no(String shipper_fax_no) {
		this.shipperFaxNo = shipper_fax_no;
	}
	/**
	 * @return Returns the shipper_nm.
	 */
	public String getShipper_nm() {
		return shipperNm;
	}
	/**
	 * @param shipper_nm The shipper_nm to set.
	 */
	public void setShipper_nm(String shipper_nm) {
		this.shipperNm = shipper_nm;
	}
	/**
	 * @return Returns the status_cd.
	 */
	public String getStatus_cd() {
		return statusCd;
	}
	/**
	 * @param status_cd The status_cd to set.
	 */
	public void setStatus_cd(String status_cd) {
		this.statusCd = status_cd;
	}
	/**
	 * @return Returns the stop_off_ind.
	 */
	public String getStop_off_ind() {
		return stopOffInd;
	}
	/**
	 * @param stop_off_ind The stop_off_ind to set.
	 */
	public void setStop_off_ind(String stop_off_ind) {
		this.stopOffInd = stop_off_ind;
	}
	/**
	 * @return Returns the rb.
	 */
	public String getRb() {
		return rb;
	}
	/**
	 * @param rb The rb to set.
	 */
	public void setRb(String rb) {
		this.rb = rb;
	}
	/**
	 * @return Returns the bkg_cmdt_cd.
	 */
	public String getBkg_cmdt_cd() {
		return bkgCmdtCd;
	}
	/**
	 * @param bkg_cmdt_cd The bkg_cmdt_cd to set.
	 */
	public void setBkg_cmdt_cd(String bkg_cmdt_cd) {
		this.bkgCmdtCd = bkg_cmdt_cd;
	}
	/**
	 * @return Returns the rart_dt.
	 */
	public String getRart_dt() {
		return rartDt;
	}
	/**
	 * @param rart_dt The rart_dt to set.
	 */
	public void setRart_dt(String rart_dt) {
		this.rartDt = rart_dt;
	}
	
	/**
	 * @return Returns the rrcv_dt_fm.
	 */
	public String getRrcv_dt_fm() {
		return rrcvDtFm;
	}
	/**
	 * @param rrcv_dt_fm The rrcv_dt_fm to set.
	 */
	public void setRrcv_dt_fm(String rrcv_dt_fm) {
		this.rrcvDtFm = rrcv_dt_fm;
	}
	
	/**
	 * @return Returns the rrcv_dt_to.
	 */
	public String getRrcv_dt_to() {
		return rrcvDtTo;
	}
	/**
	 * @param rrcv_dt_to The rrcv_dt_to to set.
	 */
	public void setRrcv_dt_to(String rrcv_dt_to) {
		this.rrcvDtTo = rrcv_dt_to;
	}
	/**
	 * @return Returns the spcl_cust_flg.
	 */
	public String getSpcl_cust_flg() {
		return spclCustFlg;
	}
	/**
	 * @param spcl_cust_flg The spcl_cust_flg to set.
	 */
	public void setSpcl_cust_flg(String spcl_cust_flg) {
		this.spclCustFlg = spcl_cust_flg;
	}
	
}
