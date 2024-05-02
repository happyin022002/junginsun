/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Esmagt024Event.java
*@FileTitle : Inbound China Agent Office Info for Vessel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.07.30 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.AgtChnVslAgnVO;


/**
 * EsmAgt024 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EsmAgt024HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Jin
 * @see EsmAgt024HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0024Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtChnVslAgnVO agtChnVslAgnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtChnVslAgnVO[] agtChnVslAgnVOs = null;

	public EsmAgt0024Event(){}
	
	public void setAgtChnVslAgnVO(AgtChnVslAgnVO agtChnVslAgnVO){
		this. agtChnVslAgnVO = agtChnVslAgnVO;
	}

	public void setAgtChnVslAgnVOS(AgtChnVslAgnVO[] agtChnVslAgnVOs){
		this. agtChnVslAgnVOs = agtChnVslAgnVOs;
	}

	public AgtChnVslAgnVO getAgtChnVslAgnVO(){
		return agtChnVslAgnVO;
	}

	public AgtChnVslAgnVO[] getAgtChnVslAgnVOS(){
		return agtChnVslAgnVOs;
	}

}