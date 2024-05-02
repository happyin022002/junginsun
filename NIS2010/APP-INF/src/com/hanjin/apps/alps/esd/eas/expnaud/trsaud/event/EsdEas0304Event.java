/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0304Event.java
*@FileTitle : Rejection Notice Send History
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.26 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.event;


import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.SpecialSoOfTrsVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0304 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0304HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0304HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0304Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SpecialSoOfTrsVO specialSoOfTrsVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SpecialSoOfTrsVO[] specialSoOfTrsVOs = null;

	public EsdEas0304Event(){}

	public SpecialSoOfTrsVO getSpecialSoOfTrsVO() {
		return specialSoOfTrsVO;
	}

	public void setSpecialSoOfTrsVO(SpecialSoOfTrsVO specialSoOfTrsVO) {
		this.specialSoOfTrsVO = specialSoOfTrsVO;
	}

	public SpecialSoOfTrsVO[] getSpecialSoOfTrsVOs() {
		SpecialSoOfTrsVO[] rtnVOs = null;
		if (this.specialSoOfTrsVOs != null) {
			rtnVOs = new SpecialSoOfTrsVO[specialSoOfTrsVOs.length];
			System.arraycopy(specialSoOfTrsVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSpecialSoOfTrsVOs(SpecialSoOfTrsVO[] specialSoOfTrsVOs){
		if(specialSoOfTrsVOs != null){
			SpecialSoOfTrsVO[] tmpVOs = new SpecialSoOfTrsVO[specialSoOfTrsVOs.length];
			System.arraycopy(specialSoOfTrsVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.specialSoOfTrsVOs = tmpVOs;
		}
	}
}