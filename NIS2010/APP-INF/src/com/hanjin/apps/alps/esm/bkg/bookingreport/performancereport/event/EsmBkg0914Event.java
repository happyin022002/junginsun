/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0914Event.java
*@FileTitle : Port Closing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.08.17 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.PortCloseBLlistVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.PortCloseOfficeListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0914 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0914HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0914HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg0914Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortCloseOfficeListVO pctlOfficeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortCloseOfficeListVO[] pctlOfficeListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortCloseBLlistVO portCloseBLlistVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortCloseBLlistVO[] portCloseBLlistVOs = null;

	public EsmBkg0914Event(){}
	
	public void setPctlOfficeListVO(PortCloseOfficeListVO pctlOfficeListVO){
		this. pctlOfficeListVO = pctlOfficeListVO;
	}

	public void setPctlOfficeListVOS(PortCloseOfficeListVO[] pctlOfficeListVOs){
		if(pctlOfficeListVOs != null){
			PortCloseOfficeListVO[] tmpVOs = new PortCloseOfficeListVO[pctlOfficeListVOs.length];
			System.arraycopy(pctlOfficeListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pctlOfficeListVOs = tmpVOs;
		}
	}

	public void setPortCloseBLlistVO(PortCloseBLlistVO portCloseBLlistVO){
		this. portCloseBLlistVO = portCloseBLlistVO;
	}

	public void setPortCloseBLlistVOS(PortCloseBLlistVO[] portCloseBLlistVOs){
		if(portCloseBLlistVOs != null){
			PortCloseBLlistVO[] tmpVOs = new PortCloseBLlistVO[portCloseBLlistVOs.length];
			System.arraycopy(portCloseBLlistVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portCloseBLlistVOs = tmpVOs;
		}
	}

	public PortCloseOfficeListVO getPctlOfficeListVO(){
		return pctlOfficeListVO;
	}

	public PortCloseOfficeListVO[] getPctlOfficeListVOS(){
		PortCloseOfficeListVO[] rtnVOs = null;
		if (this.pctlOfficeListVOs != null) {
			rtnVOs = new PortCloseOfficeListVO[pctlOfficeListVOs.length];
			System.arraycopy(pctlOfficeListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PortCloseBLlistVO getPortCloseBLlistVO(){
		return portCloseBLlistVO;
	}

	public PortCloseBLlistVO[] getPortCloseBLlistVOS(){
		PortCloseBLlistVO[] rtnVOs = null;
		if (this.portCloseBLlistVOs != null) {
			rtnVOs = new PortCloseBLlistVO[portCloseBLlistVOs.length];
			System.arraycopy(portCloseBLlistVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	


}