/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmChsMasterEvent.java
*@FileTitle : s
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.07.01 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.event;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.ChsMasterMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * CGM_CHS_MASTER 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CGM_CHS_MASTERHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see CGM_CHS_MASTER_HTMLAction 참조
 * @since J2EE 1.6
 */

public class CgmMstContainerEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChsMasterMGTVO chsMasterMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChsMasterMGTVO[] chsMasterMGTVOs = null;

	public CgmMstContainerEvent(){}

	/**
	 * @return the chsMasterMGTVO
	 */
	public ChsMasterMGTVO getChsMasterMGTVO() {
		return chsMasterMGTVO;
	}

	/**
	 * @param chsMasterMGTVO the chsMasterMGTVO to set
	 */
	public void setChsMasterMGTVO(ChsMasterMGTVO chsMasterMGTVO) {
		this.chsMasterMGTVO = chsMasterMGTVO;
	}

	/**
	 * @return the chsMasterMGTVOs
	 */
	public ChsMasterMGTVO[] getChsMasterMGTVOs() {
		ChsMasterMGTVO[] rtnVOs = null;
		if (this.chsMasterMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(chsMasterMGTVOs, chsMasterMGTVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param chsMasterMGTVOs the chsMasterMGTVOs to set
	 */
	public void setChsMasterMGTVOs(ChsMasterMGTVO[] chsMasterMGTVOs){
		if(chsMasterMGTVOs != null){
			ChsMasterMGTVO[] tmpVOs = java.util.Arrays.copyOf(chsMasterMGTVOs, chsMasterMGTVOs.length);
			this.chsMasterMGTVOs = tmpVOs;
		}
	}
	
	 

}