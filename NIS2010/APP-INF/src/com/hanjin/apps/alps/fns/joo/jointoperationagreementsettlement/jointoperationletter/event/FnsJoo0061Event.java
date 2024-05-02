/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0061Event.java
*@FileTitle : Invoice Letter Information Text Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.24 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.JoTmpltNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.JooLtrTmpltVO;


/**
 * FNS_JOO_0061 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0061HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HAM DAE SUNG
 * @see FNS_JOO_0061HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0061Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooLtrTmpltVO jooLtrTmpltVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JooLtrTmpltVO[] jooLtrTmpltVOs = null;
	
	private JoTmpltNoVO joTmpltNoVO = null;
	
	private String copy = null; 

	public FnsJoo0061Event(){}
	
	public void setJooLtrTmpltVO(JooLtrTmpltVO jooLtrTmpltVO){
		this. jooLtrTmpltVO = jooLtrTmpltVO;
	}

	public void setJooLtrTmpltVOS(JooLtrTmpltVO[] jooLtrTmpltVOs){
		if (jooLtrTmpltVOs != null) {
			JooLtrTmpltVO[] tmpVOs = new JooLtrTmpltVO[jooLtrTmpltVOs.length];
			System.arraycopy(jooLtrTmpltVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooLtrTmpltVOs = tmpVOs;
		}		
	}

	public JooLtrTmpltVO getJooLtrTmpltVO(){
		return jooLtrTmpltVO;
	}

	public JooLtrTmpltVO[] getJooLtrTmpltVOS(){
		JooLtrTmpltVO[] rtnVOs = null;
		if (this.jooLtrTmpltVOs != null) {
			rtnVOs = new JooLtrTmpltVO[jooLtrTmpltVOs.length];
			System.arraycopy(jooLtrTmpltVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	/**
	 * @return the joTmpltNoVO
	 */
	public JoTmpltNoVO getJoTmpltNoVO() {
		return joTmpltNoVO;
	}

	/**
	 * @param joTmpltNoVO the joTmpltNoVO to set
	 */
	public void setJoTmpltNoVO(JoTmpltNoVO joTmpltNoVO) {
		this.joTmpltNoVO = joTmpltNoVO;
	}

	/**
	 * @return the copy
	 */
	public String getCopy() {
		return copy;
	}

	/**
	 * @param copy the copy to set
	 */
	public void setCopy(String copy) {
		this.copy = copy;
	} 
	
}