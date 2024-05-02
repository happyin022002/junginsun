/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0316Event.java
*@FileTitle : Rehandling(BKG COD)
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 김현주
*@LastVersion : 1.0
* 2015.03.12 김현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.event;

import com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.vo.RehandlingBkgCodVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0316 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0316HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0316HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0316Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	RehandlingBkgCodVO rehandlingBkgCodVO = null;
	
	/** Table Value Object Multi Data 처리 */
	RehandlingBkgCodVO[] rehandlingBkgCodVOs = null;

	public EsdEas0316Event(){}
	
	// RehandlingBkgCodVO
	public RehandlingBkgCodVO getRehandlingBkgCodVO() {
		return rehandlingBkgCodVO;
	}

	public void setRehandlingBkgCodVO(RehandlingBkgCodVO rehandlingBkgCodVO) {
		this.rehandlingBkgCodVO = rehandlingBkgCodVO;
	}

	public RehandlingBkgCodVO[] getRehandlingBkgCodVOs() {
		RehandlingBkgCodVO[] rtnVOs = null;
		if (this.rehandlingBkgCodVOs != null) {
			rtnVOs = new RehandlingBkgCodVO[rehandlingBkgCodVOs.length];
			System.arraycopy(rehandlingBkgCodVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setRehandlingBkgCodVOs(RehandlingBkgCodVO[] rehandlingBkgCodVOs){
		if(rehandlingBkgCodVOs != null){
			RehandlingBkgCodVO[] tmpVOs = new RehandlingBkgCodVO[rehandlingBkgCodVOs.length];
			System.arraycopy(rehandlingBkgCodVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rehandlingBkgCodVOs = tmpVOs;
		}
	}

}