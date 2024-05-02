/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESD_EAS_0901Event.java
*@FileTitle : Remark Detail 조회/추가/수정
*Open Issues :
*Change history :
*@LastModifyDate : 2008-11-22
*@LastModifier : Yaini
*@LastVersion : 1.0
* 2008-11-24 Yaini
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.terminalmanage.event;

import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasLocationVO;
import com.hanjin.apps.alps.esd.eas.terminalmanage.vo.EasMdmCountryVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0901Event ���� PDTO(Data Transfer Object including Parameters)<br>
 * @author Yaini
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class EsdEas0910Event extends EventSupport {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/** LocationVO 조회 조건 및 단건 처리  */
	private EasLocationVO locationVO = null;
	
	/** LocationVO Multi Data 처리 */
	private EasLocationVO[] locationVOs = null;
		
	/** MdmCountryVO 조회 조건 및 단건 처리  */
	private EasMdmCountryVO mdmCountryVO = null;
	
	/** MdmCountryVO Multi Data 처리 */
	private EasMdmCountryVO[] mdmCountryVOs = null;

	/**
	 * @return the locationVO
	 */
	public EasLocationVO getLocationVO() {
		return locationVO;
	}

	/**
	 * @param locationVO the locationVO to set
	 */
	public void setLocationVO(EasLocationVO locationVO) {
		this.locationVO = locationVO;
	}

	/**
	 * @return the locationVOs
	 */
	public EasLocationVO[] getLocationVOs() {
		EasLocationVO[] rtnVOs = null;
		if (this.locationVOs != null) {
			rtnVOs = new EasLocationVO[locationVOs.length];
			System.arraycopy(locationVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param locationVOs the locationVOs to set
	 */
	public void setLocationVOs(EasLocationVO[] locationVOs){
		if(locationVOs != null){
			EasLocationVO[] tmpVOs = new EasLocationVO[locationVOs.length];
			System.arraycopy(locationVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.locationVOs = tmpVOs;
		}
	}

	/**
	 * @return the mdmCountryVO
	 */
	public EasMdmCountryVO getMdmCountryVO() {
		return mdmCountryVO;
	}

	/**
	 * @param mdmCountryVO the mdmCountryVO to set
	 */
	public void setMdmCountryVO(EasMdmCountryVO mdmCountryVO) {
		this.mdmCountryVO = mdmCountryVO;
	}

	/**
	 * @return the mdmCountryVOs
	 */
	public EasMdmCountryVO[] getMdmCountryVOs() {
		EasMdmCountryVO[] rtnVOs = null;
		if (this.mdmCountryVOs != null) {
			rtnVOs = new EasMdmCountryVO[mdmCountryVOs.length];
			System.arraycopy(mdmCountryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param mdmCountryVOs the mdmCountryVOs to set
	 */
	public void setMdmCountryVOs(EasMdmCountryVO[] mdmCountryVOs){
		if(mdmCountryVOs != null){
			EasMdmCountryVO[] tmpVOs = new EasMdmCountryVO[mdmCountryVOs.length];
			System.arraycopy(mdmCountryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmCountryVOs = tmpVOs;
		}
	}

	
}
