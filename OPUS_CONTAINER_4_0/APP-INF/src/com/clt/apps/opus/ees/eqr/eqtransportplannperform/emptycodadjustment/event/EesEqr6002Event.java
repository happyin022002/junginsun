/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr6002Event.java
*@FileTitle : Remark by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.08.14 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event;

import com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.vo.EmptyCODVVDVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_6002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_6002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Prak Kwang Seok
 * @see EES_EQR_6002HTMLAction 참조
 * @since J2EE 1.6
 */
  
public class EesEqr6002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EmptyCODVVDVO emptyCODVVDVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EmptyCODVVDVO[] emptyCODVVDVOs = null;

	public EesEqr6002Event(){}
	
	public void setEmptyCODVVDVO(EmptyCODVVDVO emptyCODVVDVO){
		this. emptyCODVVDVO = emptyCODVVDVO;
	}

	public void setEmptyCODVVDVOS(EmptyCODVVDVO[] emptyCODVVDVOs){
		if (emptyCODVVDVOs != null) {
			EmptyCODVVDVO[] tmpVOs = new EmptyCODVVDVO[emptyCODVVDVOs.length];
			System.arraycopy(emptyCODVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.emptyCODVVDVOs = tmpVOs;
		}
	}

	public EmptyCODVVDVO getEmptyCODVVDVO(){
		return emptyCODVVDVO;
	}

	public EmptyCODVVDVO[] getEmptyCODVVDVOS(){
		EmptyCODVVDVO[] tmpVOs = null;
		if (this.emptyCODVVDVOs != null) {
			tmpVOs = new EmptyCODVVDVO[emptyCODVVDVOs.length];
			System.arraycopy(emptyCODVVDVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}