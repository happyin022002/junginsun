/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0153Event.java
*@FileTitle : Chinese Booking Agent
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.06.08 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmYardVO;


/**
 * ESM_BKG_0153 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0153HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0153HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0153Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgChinaAgentVO searchChinaAgentCodeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgChinaAgentVO[] searchChinaAgentCodeVOs = null;

	public EsmBkg0153Event(){}
	
	public void setSearchChinaAgentCodeVO(BkgChinaAgentVO searchChinaAgentCodeVO){
		this. searchChinaAgentCodeVO = searchChinaAgentCodeVO;
	}

//	public void setSearchChinaAgentCodeVOS(BkgChinaAgentVO[] searchChinaAgentCodeVOs){
//		this. searchChinaAgentCodeVOs = searchChinaAgentCodeVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setSearchChinaAgentCodeVOS(BkgChinaAgentVO[] searchChinaAgentCodeVOs){
		if (searchChinaAgentCodeVOs != null) {
			BkgChinaAgentVO[] tmpVOs = new BkgChinaAgentVO[searchChinaAgentCodeVOs.length];
			System.arraycopy(searchChinaAgentCodeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchChinaAgentCodeVOs = tmpVOs;
		}		
	}	
	
	public BkgChinaAgentVO getSearchChinaAgentCodeVO(){
		return searchChinaAgentCodeVO;
	}

//	public BkgChinaAgentVO[] getSearchChinaAgentCodeVOS(){
//		return searchChinaAgentCodeVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]	
	public BkgChinaAgentVO[] getSearchChinaAgentCodeVOS(){
		BkgChinaAgentVO[] tmpVOs = null;
		if (this.searchChinaAgentCodeVOs != null) {
			tmpVOs = new BkgChinaAgentVO[searchChinaAgentCodeVOs.length];
			System.arraycopy(searchChinaAgentCodeVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;	
	}		
}