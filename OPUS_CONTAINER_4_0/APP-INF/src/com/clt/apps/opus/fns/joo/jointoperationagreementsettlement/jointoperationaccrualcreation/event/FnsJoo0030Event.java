/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiJoo0030Event.java
*@FileTitle : 공동운항추정 산출
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.04 함대성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.JooEstmClzVO;


/**
 * UI_JOO_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_JOO_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see FNS_JOO_0030HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class FnsJoo0030Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooEstmClzVO jooEstmClzVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JooEstmClzVO[] jooEstmClzVOs = null;

	public FnsJoo0030Event(){}
	
	public void setJooEstmClzVO(JooEstmClzVO jooEstmClzVO){
		this. jooEstmClzVO = jooEstmClzVO;
	}

	public void setJooEstmClzVOS(JooEstmClzVO[] jooEstmClzVOs){
		if (jooEstmClzVOs != null) {
			JooEstmClzVO[] tmpVOs = new JooEstmClzVO[jooEstmClzVOs.length];
			System.arraycopy(jooEstmClzVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooEstmClzVOs = tmpVOs;
		}
	}

	public JooEstmClzVO getJooEstmClzVO(){
		return jooEstmClzVO;
	}

	public JooEstmClzVO[] getJooEstmClzVOS(){
		JooEstmClzVO[] tmpVOs = null;
		if (this.jooEstmClzVOs != null) {
			tmpVOs = new JooEstmClzVO[jooEstmClzVOs.length];
			System.arraycopy(jooEstmClzVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}