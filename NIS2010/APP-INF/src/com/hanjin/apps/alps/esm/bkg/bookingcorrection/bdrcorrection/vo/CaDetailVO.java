package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * ESM_BKG_0079_02A 화면에서, 조회용 Container VO
 * @author 이남경
 * @since J2EE 1.5
 */
public class CaDetailVO {
	CaGeneralVO       caGeneralVO  = null;
	CaChargeVO        caChargeVO   = null;
	CaCustVO          caCustVO     = null;
	
	List<CaGeneralVO> caGeneralVOs = new ArrayList<CaGeneralVO>();
	List<CaChargeVO>  caChargeVOs  = new ArrayList<CaChargeVO>();
	List<CaCustVO>    caCustVOs    = new ArrayList<CaCustVO>();
	
	
	/**
	 * @return the caGeneralVO
	 */
	public CaGeneralVO getCaGeneralVO() {
		return caGeneralVO;
	}
	/**
	 * @param caGeneralVO the caGeneralVO to set
	 */
	public void setCaGeneralVO(CaGeneralVO caGeneralVO) {
		this.caGeneralVO = caGeneralVO;
	}
	/**
	 * @return the caChargeVO
	 */
	public CaChargeVO getCaChargeVO() {
		return caChargeVO;
	}
	/**
	 * @param caChargeVO the caChargeVO to set
	 */
	public void setCaChargeVO(CaChargeVO caChargeVO) {
		this.caChargeVO = caChargeVO;
	}
	/**
	 * @return the caCustVO
	 */
	public CaCustVO getCaCustVO() {
		return caCustVO;
	}
	/**
	 * @param caCustVO the caCustVO to set
	 */
	public void setCaCustVO(CaCustVO caCustVO) {
		this.caCustVO = caCustVO;
	}
	/**
	 * @return the caGeneralVOs
	 */
	public List<CaGeneralVO> getCaGeneralVOs() {
		return caGeneralVOs;
	}
	/**
	 * @param caGeneralVOs the caGeneralVOs to set
	 */
	public void setCaGeneralVOs(List<CaGeneralVO> caGeneralVOs) {
		this.caGeneralVOs = caGeneralVOs;
	}
	/**
	 * @return the caChargeVOs
	 */
	public List<CaChargeVO> getCaChargeVOs() {
		return caChargeVOs;
	}
	/**
	 * @param caChargeVOs the caChargeVOs to set
	 */
	public void setCaChargeVOs(List<CaChargeVO> caChargeVOs) {
		this.caChargeVOs = caChargeVOs;
	}
	/**
	 * @return the caCustVOs
	 */
	public List<CaCustVO> getCaCustVOs() {
		return caCustVOs;
	}
	/**
	 * @param caCustVOs the caCustVOs to set
	 */
	public void setCaCustVOs(List<CaCustVO> caCustVOs) {
		this.caCustVOs = caCustVOs;
	}
}