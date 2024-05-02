/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0505Event.java
*@FileTitle : EsmBkg0505Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.01 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInqInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCntrInqInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorContainerCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCustInqInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorElnoInqInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * ESM_BKG_0505 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0505HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author charves
 * @see ESM_BKG_0505HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0505Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private KorCntrInqInfoVO[] 	korCntrInqInfoVOs = null;
	private KorBlInqInfoVO 		korBlInqInfoVO = null;
	private KorElnoInqInfoVO[] 	korElnoInqInfoVOs = null;
	private KorCustInqInfoVO 	korCustInqInfoVO = null;
	private KorContainerCondVO  korContainerCondVO = null;
	
	public EsmBkg0505Event()
	{
		
	}
	
	/**
	 * @return the korContainerCondVO
	 */
	public KorContainerCondVO getKorContainerCondVO() {
		return korContainerCondVO;
	}

	/**
	 * @param korContainerCondVO the korContainerCondVO to set
	 */
	public void setKorContainerCondVO(KorContainerCondVO korContainerCondVO) {
		this.korContainerCondVO = korContainerCondVO;
	}

	/**
	 * @return the korCntrInqInfoVOs
	 */
	public KorCntrInqInfoVO[] getKorCntrInqInfoVOs() {
		return korCntrInqInfoVOs;
	}
	/**
	 * @param korCntrInqInfoVOs the korCntrInqInfoVOs to set
	 */
	public void setKorCntrInqInfoVOs(KorCntrInqInfoVO[] korCntrInqInfoVOs) {
		this.korCntrInqInfoVOs = korCntrInqInfoVOs;
	}
	/**
	 * @return the korBlInqInfoVO
	 */
	public KorBlInqInfoVO getKorBlInqInfoVO() {
		return korBlInqInfoVO;
	}
	/**
	 * @param korBlInqInfoVO the korBlInqInfoVO to set
	 */
	public void setKorBlInqInfoVO(KorBlInqInfoVO korBlInqInfoVO) {
		this.korBlInqInfoVO = korBlInqInfoVO;
	}
	/**
	 * @return the korElnoInqInfoVOs
	 */
	public KorElnoInqInfoVO[] getKorElnoInqInfoVOs() {
		return korElnoInqInfoVOs;
	}
	/**
	 * @param korElnoInqInfoVOs the korElnoInqInfoVOs to set
	 */
	public void setKorElnoInqInfoVOs(KorElnoInqInfoVO[] korElnoInqInfoVOs) {
		this.korElnoInqInfoVOs = korElnoInqInfoVOs;
	}
	/**
	 * @return the korCustInqInfoVO
	 */
	public KorCustInqInfoVO getKorCustInqInfoVO() {
		return korCustInqInfoVO;
	}
	/**
	 * @param korCustInqInfoVO the korCustInqInfoVO to set
	 */
	public void setKorCustInqInfoVO(KorCustInqInfoVO korCustInqInfoVO) {
		this.korCustInqInfoVO = korCustInqInfoVO;
	}
	
}