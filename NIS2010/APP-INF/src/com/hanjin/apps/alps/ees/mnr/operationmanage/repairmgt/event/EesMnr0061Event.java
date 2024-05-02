package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.AcepChkDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.AcepChkGrpVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.AcepChkHdrVO;
import com.hanjin.framework.support.layer.event.EventSupport;

public class EesMnr0061Event extends EventSupport {
	private static final long serialVersionUID = 1L;
    
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AcepChkHdrVO acepChkHdrVO = null;
	 
	/** Table Value Object Multi Data 처리 */
	private AcepChkDtlVO[] acepChkDtlVOs = null;
	
	private AcepChkGrpVO acepChkGrpVO = null;
     
	public EesMnr0061Event(){}

	/**
	 * @return the acepChkHdrVO
	 */
	public AcepChkHdrVO getAcepChkHdrVO() {
		return acepChkHdrVO;
	}

	/**
	 * @param acepChkHdrVO the acepChkHdrVO to set
	 */
	public void setAcepChkHdrVO(AcepChkHdrVO acepChkHdrVO) {
		this.acepChkHdrVO = acepChkHdrVO;
	}

	/**
	 * @return the acepChkDtlVOs
	 */
	public AcepChkDtlVO[] getAcepChkDtlVOs() {
		return acepChkDtlVOs;
	}

	/**
	 * @param acepChkDtlVOs the acepChkDtlVOs to set
	 */
	public void setAcepChkDtlVOs(AcepChkDtlVO[] acepChkDtlVOs) {
		this.acepChkDtlVOs = acepChkDtlVOs;
	}

	/**
	 * @return the acepChkGrpVO
	 */
	public AcepChkGrpVO getAcepChkGrpVO() {
		return acepChkGrpVO;
	}

	/**
	 * @param acepChkGrpVO the acepChkGrpVO to set
	 */
	public void setAcepChkGrpVO(AcepChkGrpVO acepChkGrpVO) {
		this.acepChkGrpVO = acepChkGrpVO;
	}
	
}
