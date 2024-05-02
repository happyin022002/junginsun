/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1007Event.java
*@FileTitle : Chassis Pool Inquiry/Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.06.04 박의수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqPoolInfoINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_1007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSEqPoolInfoINVO cHSEqPoolInfoINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSEqPoolInfoINVO[] cHSEqPoolInfoINVOs = null;

	public EesCgm1007Event(){}
	
	public void setCHSEqPoolInfoINVO(CHSEqPoolInfoINVO cHSEqPoolInfoINVO){
		this. cHSEqPoolInfoINVO = cHSEqPoolInfoINVO;
	}

	public void setCHSEqPoolInfoINVOS(CHSEqPoolInfoINVO[] cGHSqPoolInfoINVOs){
		if(cGHSqPoolInfoINVOs != null){
			CHSEqPoolInfoINVO[] tmpVOs = java.util.Arrays.copyOf(cGHSqPoolInfoINVOs, cGHSqPoolInfoINVOs.length);
			this.cHSEqPoolInfoINVOs = tmpVOs;
		}
	}

	public CHSEqPoolInfoINVO getCHSEqPoolInfoINVO(){
		return cHSEqPoolInfoINVO;
	}

	public CHSEqPoolInfoINVO[] getCHSEqPoolInfoINVOS(){
		CHSEqPoolInfoINVO[] rtnVOs = null;
		if (this.cHSEqPoolInfoINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSEqPoolInfoINVOs, cHSEqPoolInfoINVOs.length);
		}
		return rtnVOs;
	}
}
