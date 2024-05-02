package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;

public class EesMnr0167Event extends EventSupport {

	private static final long serialVersionUID = 1L;
		
	public EesMnr0167Event(){}     
		
	/** Disposal 조회 조건 및 단건 처리  */
	private DisposalGRPVO disposalGRPVO = null;
	
	public DisposalGRPVO getDisposalGRPVO() {
		return disposalGRPVO; 
	}  
 
	public void setDisposalGRPVO(DisposalGRPVO disposalGRPVO) {
		this.disposalGRPVO = disposalGRPVO;
	} 
	

}