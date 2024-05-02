/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaxSendEvent.java
*@FileTitle : fax_send
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2009.06.01 김정훈
* 1.0 Creation
=========================================================*/
package com.clt.sample.fax.faxsend.event;

import java.util.Arrays;
import java.util.List;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.framework.table.ComFaxSndInfoVO;


/**
 * fax_send 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  fax_sendHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong-Hoon, Kim
 * @see fax_sendHTMLAction 참조
 * @since J2EE 1.6
 */

public class FaxSendEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComFaxSndInfoVO comFaxSndInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ComFaxSndInfoVO[] comFaxSndInfoVOs = null;

	public FaxSendEvent(){}
	
	public void setComFaxSndInfoVO(ComFaxSndInfoVO comFaxSndInfoVO){
		this. comFaxSndInfoVO = comFaxSndInfoVO;
	}

	public void setComFaxSndInfoVOS(List<ComFaxSndInfoVO> comFaxSndInfoVOs){
		ComFaxSndInfoVO[] arrayComFaxSndInfoVO = new ComFaxSndInfoVO[comFaxSndInfoVOs.size()];
		this. comFaxSndInfoVOs = comFaxSndInfoVOs.toArray(arrayComFaxSndInfoVO);
	}

	public ComFaxSndInfoVO getComFaxSndInfoVO(){
		return comFaxSndInfoVO;
	}

	public  List<ComFaxSndInfoVO> getComFaxSndInfoVOS(){
		return Arrays.asList(comFaxSndInfoVOs);
	}

}