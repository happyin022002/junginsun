/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesDmt7019Event.java
*@FileTitle : Charge Deletion Attached File List
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : Lee Sung Hoon
*@LastVersion : 1.0
** 2015.02.05 Lee Sung Hoon
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChgDeltRqstFileVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/** 
 * EES_DMT_7019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sung Hoon
 * @see EES_DMT_7019HTMLAction 참조 
 * @since J2EE 1.6
 */

public class EesDmt7019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ChgDeltRqstFileVO chgDeltRqstFileVO  = null;

	private ChgDeltRqstFileVO[] chgDeltRqstFileVOs = null;
    
	
	public EesDmt7019Event(){}

	public ChgDeltRqstFileVO getChgDeltRqstFileVO() {
		return chgDeltRqstFileVO;
	}
	public void setChgDeltRqstFileVO(ChgDeltRqstFileVO chgDeltRqstFileVO) {
		this.chgDeltRqstFileVO = chgDeltRqstFileVO;
	}
	public ChgDeltRqstFileVO[] getChgDeltRqstFileVOs() {
		ChgDeltRqstFileVO[] ret = null;
		
		if (this.chgDeltRqstFileVOs != null) {
			ret = new ChgDeltRqstFileVO[chgDeltRqstFileVOs.length];
			
			for (int i=0; i<chgDeltRqstFileVOs.length; i++) {
				ret[i] = this.chgDeltRqstFileVOs[i];
			}
		}
		return ret;		
	}
	public void setChgDeltRqstFileVOs(ChgDeltRqstFileVO[] chgDeltRqstFileVOs) {
		if (chgDeltRqstFileVOs != null) {
			this.chgDeltRqstFileVOs = new ChgDeltRqstFileVO[chgDeltRqstFileVOs.length];
			
			for (int i=0; i<chgDeltRqstFileVOs.length; i++) {
				this.chgDeltRqstFileVOs[i] = chgDeltRqstFileVOs[i];
			}
		}
	}
}