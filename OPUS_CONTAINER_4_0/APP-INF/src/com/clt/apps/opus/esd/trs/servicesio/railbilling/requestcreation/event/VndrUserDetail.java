/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VndUserDetail.java
*@FileTitle : VndUserDetail Info
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : leebh
*@LastVersion : 1.0
* 2006-12-20 leebh
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.event;

/**
 * WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy Output Parameter<br>
 * - Event에서 변환하여 사용<br>
 *
 * @author leebh
 * @see RailBillingIWSProxy 참조
 * @since J2EE 1.4
 */
public class VndrUserDetail implements java.io.Serializable {
	/** (Param 객체) */
	private String provVndrSeq = null;
	private String provUsrId = null;
	private String provPhnNo = null;
	private String provFaxNo = null;
	private String provEml = null;
	private String provCfmMzdCd = null;
	
	/**
	 * @return Returns the prov_vndr_seq.
	 */
	public String getProv_vndr_seq() {
		return provVndrSeq;
	}
	/**
	 * @param prov_vndr_seq The prov_vndr_seq to set.
	 */
	public void setProv_vndr_seq(String prov_vndr_seq) {
		this.provVndrSeq = prov_vndr_seq;
	}
	/**
	 * @return Returns the prov_cfm_mzd_cd.
	 */
	public String getProv_cfm_mzd_cd() {
		return provCfmMzdCd;
	}
	/**
	 * @param prov_cfm_mzd_cd The prov_cfm_mzd_cd to set.
	 */
	public void setProv_cfm_mzd_cd(String prov_cfm_mzd_cd) {
		this.provCfmMzdCd = prov_cfm_mzd_cd;
	}
	/**
	 * @return Returns the prov_eml.
	 */
	public String getProv_eml() {
		return provEml;
	}
	/**
	 * @param prov_eml The prov_eml to set.
	 */
	public void setProv_eml(String prov_eml) {
		this.provEml = prov_eml;
	}
	/**
	 * @return Returns the prov_fax_no.
	 */
	public String getProv_fax_no() {
		return provFaxNo;
	}
	/**
	 * @param prov_fax_no The prov_fax_no to set.
	 */
	public void setProv_fax_no(String prov_fax_no) {
		this.provFaxNo = prov_fax_no;
	}
	/**
	 * @return Returns the prov_phn_no.
	 */
	public String getProv_phn_no() {
		return provPhnNo;
	}
	/**
	 * @param prov_phn_no The prov_phn_no to set.
	 */
	public void setProv_phn_no(String prov_phn_no) {
		this.provPhnNo = prov_phn_no;
	}
	/**
	 * @return Returns the prov_usr_id.
	 */
	public String getProv_usr_id() {
		return provUsrId;
	}
	/**
	 * @param prov_usr_id The prov_usr_id to set.
	 */
	public void setProv_usr_id(String prov_usr_id) {
		this.provUsrId = prov_usr_id;
	}
	
	
}
