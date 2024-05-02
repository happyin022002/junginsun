/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_CIM_0062HTMLAction.java
*@FileTitle : Mailing Service Setting
*Open Issues : 
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : Kim Chang Young
*@LastVersion : 1.0
* 2014.03.31 Kim Chang Young
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.MailingServiceSettingListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_0062 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_0062HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Young Du
 * @see EES_CIM_0062HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim0062Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MailingServiceSettingListVO  mailingServiceSettingListVO  = null;
	
	/** Table Value Object Multi Data 처리 */
	private MailingServiceSettingListVO [] mailingServiceSettingListVOs = null;
	
	public EesCim0062Event(){}
	
	public void setMailingServiceSettingListVO (MailingServiceSettingListVO  mailingServiceSettingListVO ){
		this. mailingServiceSettingListVO  = mailingServiceSettingListVO ;
	}

	public void setMailingServiceSettingListVOS(MailingServiceSettingListVO[] mailingServiceSettingListVOs){
		if (mailingServiceSettingListVOs != null) {
			MailingServiceSettingListVO[] tmpVOs = Arrays.copyOf(mailingServiceSettingListVOs, mailingServiceSettingListVOs.length);
			this.mailingServiceSettingListVOs = tmpVOs;
		}
	}

	public MailingServiceSettingListVO  getMailingServiceSettingListVO (){
		return mailingServiceSettingListVO ;
	}

	public MailingServiceSettingListVO [] getMailingServiceSettingListVOS(){
		MailingServiceSettingListVO[] rtnVOs = null;
		if (this.mailingServiceSettingListVOs != null) {
			rtnVOs = Arrays.copyOf(mailingServiceSettingListVOs, mailingServiceSettingListVOs.length);
		}
		return rtnVOs;
	}
	
}