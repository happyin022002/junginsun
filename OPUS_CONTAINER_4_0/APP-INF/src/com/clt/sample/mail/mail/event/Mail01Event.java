/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Mail01Event.java
*@FileTitle : Mail Sample
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2009.05.22 김정훈
* 1.0 Creation
=========================================================*/
package com.clt.sample.mail.mail.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.framework.table.ComEmlSndInfoVO;
import com.clt.syscommon.common.table.ComUserVO;


/**
 * MAIL_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  MAIL_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong-Hoon, KIM
 * @see MAIL_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class Mail01Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComEmlSndInfoVO comEmlSndInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ComEmlSndInfoVO[] comEmlSndInfoVOs = null;

	public Mail01Event(){}
	
	public void setComEmlSndInfoVO(ComEmlSndInfoVO comEmlSndInfoVO){
		this. comEmlSndInfoVO = comEmlSndInfoVO;
	}

	public void setComEmlSndInfoVOS(ComEmlSndInfoVO[] comEmlSndInfoVOs){
		if(comEmlSndInfoVOs != null){
			ComEmlSndInfoVO[] tmpVOs = Arrays.copyOf(comEmlSndInfoVOs, comEmlSndInfoVOs.length);
			this.comEmlSndInfoVOs = tmpVOs;
		}
	}

	public ComEmlSndInfoVO getComEmlSndInfoVO(){
		return comEmlSndInfoVO;
	}

	public ComEmlSndInfoVO[] getComEmlSndInfoVOS(){
		ComEmlSndInfoVO[] tmpVOs = null;
		if (this.comEmlSndInfoVOs != null) {
			tmpVOs = Arrays.copyOf(comEmlSndInfoVOs, comEmlSndInfoVOs.length);
		}
		return tmpVOs;
	}

}