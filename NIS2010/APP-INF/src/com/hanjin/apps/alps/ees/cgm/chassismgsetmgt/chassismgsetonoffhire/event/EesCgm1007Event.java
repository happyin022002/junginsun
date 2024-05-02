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
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqPoolInfoINVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
		this. cHSEqPoolInfoINVOs = cGHSqPoolInfoINVOs;
	}

	public CHSEqPoolInfoINVO getCHSEqPoolInfoINVO(){
		return cHSEqPoolInfoINVO;
	}

	public CHSEqPoolInfoINVO[] getCHSEqPoolInfoINVOS(){
		return cHSEqPoolInfoINVOs;
	}
}
