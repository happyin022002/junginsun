/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : SPP_TES_006Event.java
*@FileTitle	: SPP_TES_006Event
*Open Issues :
*Change	history	:
*@LastModifyDate : 2008-04-11
*@LastModifier : KJJ
*@LastVersion :	1.0
* 2008-04-11 KJJ
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.servicesio.terminalinvoice.event;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class SppTes0006Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	private String tmlSoOfcCtyCd = null;
	private String tmlSoSeq = null;
	private String seq = null;
	private String vslCd = null;
	private String skdVoyNo = null;
	private String skdDircd = null;
	private String ioBndCd = null;
	
	/**
	 * 
	 * @return
	 */
	public String getSeq() {
		return seq;
	}

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
		return skdDircd;
	}

	/**
	 * 
	 * @param skd_dir_cd
	 */
	public void setSkd_dir_cd(String skd_dir_cd) {
		this.skdDircd = skd_dir_cd;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * 
	 *
	 */
	public SppTes0006Event(){
		
	}
	
	/**
	 * 
	 * @param tml_so_ofc_cty_cd
	 * @param tml_so_seq
	 */
	public SppTes0006Event(
			String tml_so_ofc_cty_cd,
			String tml_so_seq
			){
		this.tmlSoOfcCtyCd = tml_so_ofc_cty_cd;
		this.tmlSoSeq = tml_so_seq;
	}
	
	/**
	 * 
	 * @param tml_so_ofc_cty_cd
	 * @param tml_so_seq
	 * @param seq
	 * @param vsl_cd
	 * @param skd_voy_no
	 * @param skd_dir_cd
	 * @param io_bnd_cd
	 */
	public SppTes0006Event(
			String tml_so_ofc_cty_cd,
			String tml_so_seq,
			String seq,
			String vsl_cd,
			String skd_voy_no,
			String skd_dir_cd,
			String io_bnd_cd
			){
		this.tmlSoOfcCtyCd = tml_so_ofc_cty_cd;
		this.tmlSoSeq = tml_so_seq;
		this.seq = seq;
		this.vslCd = vsl_cd;
		this.skdVoyNo = skd_voy_no;
		this.skdDircd = skd_dir_cd;
		this.ioBndCd = io_bnd_cd;
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
	
	/**
	 * 
	 * @return
	 */
    public String getEventName() {
        return "SPP_TES_006Event";
    }
	/**
	 * 
	 * @return
	 */
    public String toString() {
        return "SPP_TES_006Event";
    }	
}
