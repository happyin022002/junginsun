/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Esmagt016Event.java
*@FileTitle : Agent Commission Audit Management Service Command
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.08.06 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.AgtAgnCommDtlVO;
import com.clt.syscommon.common.table.AgtAgnCommVO;


/**
 * EsmAgt016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EsmAgt016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Jin
 * @see EsmAgt016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Agt_Agn_Comm Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnCommVO agtAgnCommVO = null;
	
	 /** Agt_Agn_Comm_Dtl Table Value Object 조회 조건 및 단건 처리  */
	private AgtAgnCommDtlVO agtAgnCommDtlVO = null;
	
	/** Agt_Agn_Comm Table Value Object Multi Data 처리 */
	private AgtAgnCommVO[] agtAgnCommVOs = null;
	
	/** Agt_Agn_Comm_Dtl Table Value Object Multi Data 처리 */
	private AgtAgnCommDtlVO[] agtAgnCommDtlVOs = null;
	
	public EsmAgt0016Event(){}
	
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
	
	
	public void setAgtAgnCommDtlVO(AgtAgnCommDtlVO agtAgnCommDtlVO){
		this. agtAgnCommDtlVO = agtAgnCommDtlVO;
	}

	public void setAgtAgnCommDtlVOS(AgtAgnCommDtlVO[] agtAgnCommDtlVOs){
		this. agtAgnCommDtlVOs = agtAgnCommDtlVOs;
	}

	public AgtAgnCommDtlVO getAgtAgnCommDtlVO(){
		return agtAgnCommDtlVO;
	}

	public AgtAgnCommDtlVO[] getAgtAgnCommDtlVOS(){
		return agtAgnCommDtlVOs;
	}

}