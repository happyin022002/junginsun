/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmPri0152Event.java
*@FileTitle : Korea MOF Filing (Base Table)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.apps.alps.esm.pri.screport.screport.vo.PriMofMapgHisVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.PriMofMapgVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_0152 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0152HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Min-Gyung Lee
 * @see ESM_PRI_0152HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0152Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
    PriMofMapgVO priMofMapgVO = null;
	/** Table Value Object Multi Data 처리 */
    PriMofMapgVO[] priMofMapgVOs = null;
    
	/** Table Value Object 조회 조건 및 단건 처리  */
    PriMofMapgHisVO priMofMapgHisVO = null;
	/** Table Value Object Multi Data 처리 */
    PriMofMapgHisVO[] priMofMapgHisVOs = null;
    
	/**
	 * @return  priMofMapgVO
	 */
	public PriMofMapgVO getPriMofMapgVO() {
		return priMofMapgVO;
	}
	
	/**
	 * @return PriMofMapgVO[] rtnVOs
	 */
	public PriMofMapgVO[] getPriMofMapgVOs() {
		PriMofMapgVO[] rtnVOs = null;
		if (this.priMofMapgVOs != null) {
			rtnVOs = new PriMofMapgVO[priMofMapgVOs.length];
			System.arraycopy(priMofMapgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param PriMofMapgVO priMofMapgVO
	 */
	public void setPriMofMapgVO(PriMofMapgVO priMofMapgVO) {
		this.priMofMapgVO = priMofMapgVO;
	}
	
	/**
	 * @param PriMofMapgVO[] priMofMapgVOs
	 */
	public void setPriMofMapgVOs(PriMofMapgVO[] priMofMapgVOs) {
		if(priMofMapgVOs != null) {
			PriMofMapgVO[] tmpVOs = new PriMofMapgVO[priMofMapgVOs.length];
			System.arraycopy(priMofMapgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priMofMapgVOs = tmpVOs;
		}
	}
	/**
	 * @return  priMofMapgHisVO
	 */
	public PriMofMapgHisVO getPriMofMapgHisVO() {
		return priMofMapgHisVO;
	}
	
	/**
	 * @return PriMofMapgHisVO[] rtnVOs
	 */
	public PriMofMapgHisVO[] getPriMofMapgHisVOs() {
		PriMofMapgHisVO[] rtnVOs = null;
		if (this.priMofMapgHisVOs != null) {
			rtnVOs = new PriMofMapgHisVO[priMofMapgHisVOs.length];
			System.arraycopy(priMofMapgHisVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	/**
	 * @param PriMofMapgHisVO priMofMapgHisVO
	 */
	public void setPriMofMapgHisVO(PriMofMapgHisVO priMofMapgHisVO) {
		this.priMofMapgHisVO = priMofMapgHisVO;
	}
	
	/**
	 * @param PriMofMapgHisVO[] priMofMapgHisVOs
	 */
	public void setPriMofMapgHisVOs(PriMofMapgHisVO[] priMofMapgHisVOs) {
		if(priMofMapgHisVOs != null) {
			PriMofMapgHisVO[] tmpVOs = new PriMofMapgHisVO[priMofMapgHisVOs.length];
			System.arraycopy(priMofMapgHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priMofMapgHisVOs = tmpVOs;
		}
	}
    
}
