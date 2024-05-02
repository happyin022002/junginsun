/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiCtm0406Event.java
*@FileTitle : International MVMT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.06.12 우경민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * SPP WebService 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KMWoo
 * @see EES_CTM_0406HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesCtm0999Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** Table Value Object Multi Data 처리 */
	private CusCtmMovementVO[] cusCtmMovementVOs = null;

	public EesCtm0999Event(){}

	/**
	 * EES_CTM_0499 Event 생성자<br>
	 * SPP에서 넘어온 VO를 Event에 등록한다.<br>
	 *
	 * @param CusCtmMovementVO[] cusCtmMovementVOs
	 * @exception EventException
	 */
	public EesCtm0999Event(CusCtmMovementVO[] cusCtmMovementVOs){
		this.cusCtmMovementVOs = cusCtmMovementVOs;
	}

	/**
	 * EES_CTM_0499<br>
	 * Event에서 Spp의 Vo를 Return.<br>
	 *
	 * @return CusCtmMovementVO[]
	 */
	public CusCtmMovementVO[] getCusCtmMovementVOS(){
		CusCtmMovementVO[] tmpVOs = null;
		if (this.cusCtmMovementVOs != null) {
			tmpVOs = new CusCtmMovementVO[cusCtmMovementVOs.length];
			System.arraycopy(cusCtmMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * EES_CTM_0499<br>
	 * SPP에서 넘어온 VO를 Event에 등록한다.<br>
	 *
	 * @param CusCtmMovementVO[] cusCtmMovementVOs
	 */
	public void setCusCtmMovementVOS(CusCtmMovementVO[] cusCtmMovementVOs){
		if (cusCtmMovementVOs != null) {
			CusCtmMovementVO[] tmpVOs = new CusCtmMovementVO[cusCtmMovementVOs.length];
			System.arraycopy(cusCtmMovementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cusCtmMovementVOs = tmpVOs;
		}
	}

}