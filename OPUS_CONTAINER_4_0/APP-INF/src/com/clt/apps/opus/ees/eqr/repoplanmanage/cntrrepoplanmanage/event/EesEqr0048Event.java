/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0048Event.java
*@FileTitle : 컨테이너 수급 예측실적 및 정확도 조회(RLA List)
*Open Issues :
*Change history :
* 1		1.0		jungran yang					2006-12-01		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun				2009.09.11		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.09.11
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.event;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0048ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0048MultiVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0048 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0048HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0048HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0048Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0048ConditionVO eesEqr0048ConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EesEqr0048MultiVO[] eesEqr0048MultiVOS = null;

	public EesEqr0048Event(){}

	/**
	 * @return the eesEqr0048ConditionVO
	 */
	public EesEqr0048ConditionVO getEesEqr0048ConditionVO() {
		return eesEqr0048ConditionVO;
	}

	/**
	 * @param eesEqr0048ConditionVO the eesEqr0048ConditionVO to set
	 */
	public void setEesEqr0048ConditionVO(EesEqr0048ConditionVO eesEqr0048ConditionVO) {
		this.eesEqr0048ConditionVO = eesEqr0048ConditionVO;
	}

	/**
	 * @return the eesEqr0048MultiVOS
	 */
	public EesEqr0048MultiVO[] getEesEqr0048MultiVOS() {
		EesEqr0048MultiVO[] tmpVOs = null;
		if (this.eesEqr0048MultiVOS != null) {
			tmpVOs = new EesEqr0048MultiVO[eesEqr0048MultiVOS.length];
			System.arraycopy(eesEqr0048MultiVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param eesEqr0048MultiVOS the eesEqr0048MultiVOS to set
	 */
	public void setEesEqr0048MultiVOS(EesEqr0048MultiVO[] eesEqr0048MultiVOS) {
		if (eesEqr0048MultiVOS != null) {
			EesEqr0048MultiVO[] tmpVOs = new EesEqr0048MultiVO[eesEqr0048MultiVOS.length];
			System.arraycopy(eesEqr0048MultiVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.eesEqr0048MultiVOS = tmpVOs;
		}
	}

}