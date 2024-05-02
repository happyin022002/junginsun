package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.BkgNtcHisVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Container VO
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AllocStsChgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private List<BkgNtcHisVO> bkgNtcHisVOs = null;
	private String alocPopFlg = null;
	private String rcvrEml = null;
	private String ediHldFlg = null;
	private String ntcKndCd = null;
	private String oriAlocStsCd = null;
	private String alocStsCd = null;
	private String firmMsgFlg = null;

	/**
	 * @return the bkgNtcHisVOs
	 */
	public List<BkgNtcHisVO> getBkgNtcHisVOs() {
		return bkgNtcHisVOs;
	}
	/**
	 * @param bkgNtcHisVOs the bkgNtcHisVOs to set
	 */
	public void setBkgNtcHisVOs(List<BkgNtcHisVO> bkgNtcHisVOs) {
		this.bkgNtcHisVOs = bkgNtcHisVOs;
	}
	/**
	 * @return the alocPopFlg
	 */
	public String getAlocPopFlg() {
		return alocPopFlg;
	}
	/**
	 * @param alocPopFlg the alocPopFlg to set
	 */
	public void setAlocPopFlg(String alocPopFlg) {
		this.alocPopFlg = alocPopFlg;
	}
	/**
	 * @return the rcvrEml
	 */
	public String getRcvrEml() {
		return rcvrEml;
	}
	/**
	 * @param rcvrEml the rcvrEml to set
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
	}	
	/**
	 * @return the ediHldFlg
	 */
	public String getEdiHldFlg() {
		return ediHldFlg;
	}
	/**
	 * @param ediHldFlg the ediHldFlg to set
	 */
	public void setEdiHldFlg(String ediHldFlg) {
		this.ediHldFlg = ediHldFlg;
	}	
	/**
	 * @return the ntcKndCd
	 */
	public String getNtcKndCd() {
		return ntcKndCd;
	}
	/**
	 * @param ntcKndCd the ntcKndCd to set
	 */
	public void setNtcKndCd(String ntcKndCd) {
		this.ntcKndCd = ntcKndCd;
	}	
	/**
	 * @return the oriAlocStsCd
	 */
	public String getOriAlocStsCd() {
		return oriAlocStsCd;
	}
	/**
	 * @param oriAlocStsCd the oriAlocStsCd to set
	 */
	public void setOriAlocStsCd(String oriAlocStsCd) {
		this.oriAlocStsCd = oriAlocStsCd;
	}	
	/**
	 * @return the alocStsCd
	 */
	public String getAlocStsCd() {
		return alocStsCd;
	}
	/**
	 * @param alocStsCd the alocStsCd to set
	 */
	public void setAlocStsCd(String alocStsCd) {
		this.alocStsCd = alocStsCd;
	}		
	/**
	 * @return the firmMsgFlg
	 */
	public String getFirmMsgFlg() {
		return firmMsgFlg;
	}
	/**
	 * @param firmMsgFlg the firmMsgFlg to set
	 */
	public void setFirmMsgFlg(String firmMsgFlg) {
		this.firmMsgFlg = firmMsgFlg;
	}	
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
}