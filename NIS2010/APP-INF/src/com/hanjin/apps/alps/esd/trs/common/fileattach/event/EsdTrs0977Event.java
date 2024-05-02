package com.hanjin.apps.alps.esd.trs.common.fileattach.event;

import com.hanjin.apps.alps.esd.trs.common.fileattach.vo.TrsFileVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0977 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TRS_0977HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_TRS_0977HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTrs0977Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsdTrs0977Event(){}
	
	/** Table Value Object MultiCombo 조회 조건 및 단건 처리  */
	TrsFileVO trsFileVO = null;
	
	/** Table Value Object MultiCombo 다건 처리  */
	TrsFileVO[] trsFileVOs = null;
	public TrsFileVO getTrsFileVO() {
		return trsFileVO;
	}

	public void setTrsFileVO(TrsFileVO trsFileVO) {
		this.trsFileVO = trsFileVO;
	}

	public TrsFileVO[] getTrsFileVOs() {
		TrsFileVO[] rtnVOs = null;
		if (this.trsFileVOs != null) {
			rtnVOs = new TrsFileVO[this.trsFileVOs.length];
			System.arraycopy(this.trsFileVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setTrsFileVOs(TrsFileVO[] trsFileVOs){
		if(trsFileVOs != null){
			TrsFileVO[] tmpVOs = new TrsFileVO[trsFileVOs.length];
			System.arraycopy(trsFileVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.trsFileVOs = tmpVOs;
		}
	}

}