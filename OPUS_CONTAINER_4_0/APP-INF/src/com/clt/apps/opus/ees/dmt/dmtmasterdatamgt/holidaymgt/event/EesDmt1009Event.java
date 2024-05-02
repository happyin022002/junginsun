/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesDmt1009Event.java
*@FileTitle : SB45 Ruling Exceptions
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.event;

import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.Sb45RulingExceptionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_1009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_1009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_DMT_1009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt1009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private Sb45RulingExceptionVO sb45RulingExceptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private Sb45RulingExceptionVO[] sb45RulingExceptionVOs = null;

	public EesDmt1009Event(){}
	
	public void setSb45RulingExceptionVO(Sb45RulingExceptionVO sb45RulingExceptionVO){
		this. sb45RulingExceptionVO = sb45RulingExceptionVO;
	}

	public void setSb45RulingExceptionVOS(Sb45RulingExceptionVO[] sb45RulingExceptionVOs){
		if (sb45RulingExceptionVOs != null) {
			Sb45RulingExceptionVO[] tmpVOs = new Sb45RulingExceptionVO[sb45RulingExceptionVOs.length];
			System.arraycopy(sb45RulingExceptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sb45RulingExceptionVOs = tmpVOs;
		}
	}

	public Sb45RulingExceptionVO getSb45RulingExceptionVO(){
		return sb45RulingExceptionVO;
	}

	public Sb45RulingExceptionVO[] getSb45RulingExceptionVOS(){
		Sb45RulingExceptionVO[] tmpVOs = null;
		if (this.sb45RulingExceptionVOs != null) {
			tmpVOs = new Sb45RulingExceptionVO[sb45RulingExceptionVOs.length];
			System.arraycopy(sb45RulingExceptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}