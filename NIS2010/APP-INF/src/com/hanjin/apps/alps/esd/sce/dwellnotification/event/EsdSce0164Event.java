/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsdSce0140Event.java
*@FileTitle : Dwell Notification
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.06
*@LastModifier : 손은주
*@LastVersion : 1.0
* 2011.07.06 손은주
* 1.0 Creation
* 
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.event;

import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchDwellReasonByVVDVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.SearchDwellVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_SCE_0164 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_SCE_0164HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author eunju son
 * @see HTMLAction 참조
 * @since J2EE 1.6 
 */
public class EsdSce0164Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private SearchDwellVO searchDwellVO = null;
	
	private SearchDwellReasonByVVDVO[] dwellRsnByVvdVOs = null;
	
	private String vvd_cd = null;
	
	private String fr_eta_dt = null;
	
	private String to_eta_dt = null;
	
	private String port_cd = null;
	
	private String usr_id = null;
	
	private String eml_addr = null;
	
	private String cntr_no = null;
	
	private String sc_no = null;
	
	private String eml_snd_dt = null;
	
	private String dwll_tm_tp_cd = null;
	
	private String rail_so_flg = null;
	
    private String cust_value1 = null;
	
	private String cust_value2 = null;
	
	private String cust_cd = null;
	
	public EsdSce0164Event(){}
	
	/**
	 * @param searchDwellVO
	 */
	public EsdSce0164Event(SearchDwellVO searchDwellVO) {
		this.searchDwellVO = searchDwellVO;
    }

	/**
	 * @param searchDwellVO the searchDwellVO to set
	 */
	public void setSearchDwellVO(SearchDwellVO searchDwellVO) {
		this.searchDwellVO = searchDwellVO;
	}

	/**
	 * @return the searchDwellVO
	 */
	public SearchDwellVO getSearchDwellVO() {
		return searchDwellVO;
	}
	
	public String getEventName() {
		return "EsdSce0164Event";
	}

	public String toString() {
		return "EsdSce0164Event";
	}

	/**
	 * @param vvd_cd the vvd_cd to set
	 */
	public void setVvd_cd(String vvd_cd) {
		this.vvd_cd = vvd_cd;
	}

	/**
	 * @return the vvd_cd
	 */
	public String getVvd_cd() {
		return vvd_cd;
	}

	/**
	 * @param fr_eta_dt the fr_eta_dt to set
	 */
	public void setFr_eta_dt(String fr_eta_dt) {
		this.fr_eta_dt = fr_eta_dt;
	}

	/**
	 * @return the fr_eta_dt
	 */
	public String getFr_eta_dt() {
		return fr_eta_dt;
	}

	/**
	 * @param to_eta_dt the to_eta_dt to set
	 */
	public void setTo_eta_dt(String to_eta_dt) {
		this.to_eta_dt = to_eta_dt;
	}

	/**
	 * @return the to_eta_dt
	 */
	public String getTo_eta_dt() {
		return to_eta_dt;
	}

	/**
	 * @param port_cd the port_cd to set
	 */
	public void setPort_cd(String port_cd) {
		this.port_cd = port_cd;
	}

	/**
	 * @return the port_cd
	 */
	public String getPort_cd() {
		return port_cd;
	}

	/**
	 * @param dwellRsnByVvdVOs the dwellRsnByVvdVOs to set
	 */
	public void setDwellRsnByVvdVOs(SearchDwellReasonByVVDVO[] dwellRsnByVvdVOs) {
		this.dwellRsnByVvdVOs = dwellRsnByVvdVOs;
	}

	/**
	 * @return the dwellRsnByVvdVOs
	 */
	public SearchDwellReasonByVVDVO[] getDwellRsnByVvdVOs() {
		return dwellRsnByVvdVOs;
	}

	/**
	 * @param usr_id the usr_id to set
	 */
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}

	/**
	 * @return the usr_id
	 */
	public String getUsr_id() {
		return usr_id;
	}

	/**
	 * @param eml_addr the eml_addr to set
	 */
	public void setEml_addr(String eml_addr) {
		this.eml_addr = eml_addr;
	}

	/**
	 * @return the eml_addr
	 */
	public String getEml_addr() {
		return eml_addr;
	}

	/**
	 * @param cntr_no the cntr_no to set
	 */
	public void setCntr_no(String cntr_no) {
		this.cntr_no = cntr_no;
	}

	/**
	 * @return the cntr_no
	 */
	public String getCntr_no() {
		return cntr_no;
	}

	/**
	 * @param sc_no the sc_no to set
	 */
	public void setSc_no(String sc_no) {
		this.sc_no = sc_no;
	}

	/**
	 * @return the sc_no
	 */
	public String getSc_no() {
		return sc_no;
	}

	/**
	 * @param eml_snd_dt the eml_snd_dt to set
	 */
	public void setEml_snd_dt(String eml_snd_dt) {
		this.eml_snd_dt = eml_snd_dt;
	}

	/**
	 * @return the eml_snd_dt
	 */
	public String getEml_snd_dt() {
		return eml_snd_dt;
	}

	/**
	 * @param dwll_tm_tp_cd the dwll_tm_tp_cd to set
	 */
	public void setDwll_tm_tp_cd(String dwll_tm_tp_cd) {
		this.dwll_tm_tp_cd = dwll_tm_tp_cd;
	}

	/**
	 * @return the dwll_tm_tp_cd
	 */
	public String getDwll_tm_tp_cd() {
		return dwll_tm_tp_cd;
	}

	public void setRail_so_flg(String rail_so_flg) {
		this.rail_so_flg = rail_so_flg;
	}

	public String getRail_so_flg() {
		return rail_so_flg;
	}

	/**
	 * @return the cust_value1
	 */
	public String getCust_value1() {
		return cust_value1;
	}

	/**
	 * @param cust_value1 the cust_value1 to set
	 */
	public void setCust_value1(String cust_value1) {
		this.cust_value1 = cust_value1;
	}

	/**
	 * @return the cust_value2
	 */
	public String getCust_value2() {
		return cust_value2;
	}

	/**
	 * @param cust_value2 the cust_value2 to set
	 */
	public void setCust_value2(String cust_value2) {
		this.cust_value2 = cust_value2;
	}
	
	/**
	 * @param cust_cd the cust_cd to set
	 */
	public void setCust_cd(String cust_cd) {
		this.cust_cd = cust_cd;
	}

	/**
	 * @return the cust_cd
	 */
	public String getCust_cd() {
		return cust_cd;
	}


}
