/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr6003Event.java
*@FileTitle : MTY Discharge Plan by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.08.14 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event;

import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODVVDPortVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_6003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_6003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Prak Kwang Seok
 * @see EES_EQR_6003HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr6003Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EmptyCODVVDPortVO emptyCODVVDPortVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EmptyCODVVDPortVO[] emptyCODVVDPortVOs = null;

	public EesEqr6003Event(){}
	
	public void setEmptyCODVVDPortVO(EmptyCODVVDPortVO emptyCODVVDPortVO){
		this. emptyCODVVDPortVO = emptyCODVVDPortVO;
	}

	public void setEmptyCODVVDPortVOS(EmptyCODVVDPortVO[] emptyCODVVDPortVOs){
		if (emptyCODVVDPortVOs != null) {
			EmptyCODVVDPortVO[] tmpVOs = new EmptyCODVVDPortVO[emptyCODVVDPortVOs.length];
			System.arraycopy(emptyCODVVDPortVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.emptyCODVVDPortVOs = tmpVOs;
		}
	}

	public EmptyCODVVDPortVO getEmptyCODVVDPortVO(){
		return emptyCODVVDPortVO;
	}

	public EmptyCODVVDPortVO[] getEmptyCODVVDPortVOS(){
		EmptyCODVVDPortVO[] tmpVOs = null;
		if (this.emptyCODVVDPortVOs != null) {
			tmpVOs = new EmptyCODVVDPortVO[emptyCODVVDPortVOs.length];
			System.arraycopy(emptyCODVVDPortVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}