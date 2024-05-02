/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : MarineTerminalInvoiceDiscrepancyCntr.java
*@FileTitle	: MarineTerminalInvoiceDiscrepancyCntr
*Open Issues :
*Change	history	:
*@LastModifyDate : 2008-04-11
*@LastModifier : KJJ
*@LastVersion :	1.0
* 2008-04-11 KJJ
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event;

/**
 * @author 
 * @see TerminalInvoiceIWSProxy 참조
 * @since J2EE 1.4
 */
public class MarineTerminalInvoiceDiscrepancyCntr {
	
	private String tmlSoOfcCtyCd = null;
	private String tmlSoSeq = null;
	private String seq = null;
	private String vslCd = null;
	private String skdVoyNo = null;
	private String skdDirCd = null;
	private String ioBndCd = null;
	
	/**
	 * 
	 * @return
	 */
	public String getIo_bnd_cd() {
		return ioBndCd;
	}

	/**
	 * 
	 * @param io_bnd_cd
	 */
	public void setIo_bnd_cd(String io_bnd_cd) {
		this.ioBndCd = io_bnd_cd;
	}

	/**
	 * 
	 * @return
	 */
	public String getSkd_dir_cd() {
		return skdDirCd;
	}

	
	/**
	 * 
	 * @param skd_dir_cd
	 */
	public void setSkd_dir_cd(String skd_dir_cd) {
		this.skdDirCd = skd_dir_cd;
	}

	
	/**
	 * 
	 * @return
	 */
	public String getSkd_voy_no() {
		return skdVoyNo;
	}

	/**
	 * 
	 * @param skd_voy_no
	 */
	public void setSkd_voy_no(String skd_voy_no) {
		this.skdVoyNo = skd_voy_no;
	}

	/**
	 * 
	 * @return
	 */
	public String getVsl_cd() {
		return vslCd;
	}

	/**
	 * 
	 * @param vsl_cd
	 */
	public void setVsl_cd(String vsl_cd) {
		this.vslCd = vsl_cd;
	}

	/**
	 * 
	 * @return
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * 
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * 
	 * @return
	 */
	public String getTml_so_ofc_cty_cd() {
		return tmlSoOfcCtyCd;
	}
	
	/**
	 * 
	 * @param tml_so_ofc_cty_cd
	 */
	public void setTml_so_ofc_cty_cd(String tml_so_ofc_cty_cd) {
		this.tmlSoOfcCtyCd = tml_so_ofc_cty_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTml_so_seq() {
		return tmlSoSeq;
	}
	
	/**
	 * 
	 * @param tml_so_seq
	 */
	public void setTml_so_seq(String tml_so_seq) {
		this.tmlSoSeq = tml_so_seq;
	}
}
