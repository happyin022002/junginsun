/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Esmagt0036Event.java
*@FileTitle : Agent Commission Approval No
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.08.12 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event;

import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtCommListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.AgtAgnCommVO;


/**
 * EsmAgt0036 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EsmAgt0036HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Jin
 * @see EsmAgt0036HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0036Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnCommVO agtAgnCommVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtAgnCommVO[] agtAgnCommVOs = null;
	
	private AgtCommListVO agtCommListVO = null;
	
	private AgtCommListVO[] agtCommListVOs = null;

	public EsmAgt0036Event(){}
	
	public void setAgtAgnCommVO(AgtAgnCommVO agtAgnCommVO){
		this. agtAgnCommVO = agtAgnCommVO;
	}

	public void setAgtAgnCommVOS(AgtAgnCommVO[] agtAgnCommVOs){
		this. agtAgnCommVOs = agtAgnCommVOs;
	}

	public AgtAgnCommVO getAgtAgnCommVO(){
		return agtAgnCommVO;
	}

	public AgtAgnCommVO[] getAgtAgnCommVOS(){
		return agtAgnCommVOs;
	}

	public AgtCommListVO getAgtCommListVO() {
		return agtCommListVO;
	}

	public void setAgtCommListVO(AgtCommListVO agtCommListVO) {
		this.agtCommListVO = agtCommListVO;
	}

	public AgtCommListVO[] getAgtCommListVOs() {
		return agtCommListVOs;
	}

	public void setAgtCommListVOs(AgtCommListVO[] agtCommListVOs) {
		this.agtCommListVOs = agtCommListVOs;
	}
	
	

}