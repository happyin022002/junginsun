/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas00016Event.java
*@FileTitle : EQ repo 회송 기여도 Credit setting
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.08.13 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchOPCreditRtPortPairVO;
import com.hanjin.syscommon.common.table.MasCntrRepoRuleVO;
import com.hanjin.syscommon.common.table.MasCntrRepoShtgInfoVO;


/**
 * ESM_MAS_0016 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0016HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_MAS_0016HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0222Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	private SearchOPCreditRtPortPairVO searchOPCreditRtPortPairVO = null;
	
	private SearchOPCreditRtPortPairVO[] searchOPCreditRtPortPairVOS = null;

	public SearchOPCreditRtPortPairVO[] getSearchOPCreditRtPortPairVOs() {
		return searchOPCreditRtPortPairVOS;
	}

	public void setSearchOPCreditRtPortPairVOs(
			SearchOPCreditRtPortPairVO[] searchOPCreditRtPortPairVOs) {
		this.searchOPCreditRtPortPairVOS = searchOPCreditRtPortPairVOs;
	}

	public SearchOPCreditRtPortPairVO getSearchOPCreditRtPortPairVO() {
		return searchOPCreditRtPortPairVO;
	}

	public void setSearchOPCreditRtPortPairVO(
			SearchOPCreditRtPortPairVO searchOPCreditRtPortPairVO) {
		this.searchOPCreditRtPortPairVO = searchOPCreditRtPortPairVO;
	}

	public EsmMas0222Event(){}
	

}