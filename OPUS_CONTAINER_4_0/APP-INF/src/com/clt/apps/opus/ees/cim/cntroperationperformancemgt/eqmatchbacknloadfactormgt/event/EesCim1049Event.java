/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim1049Event.java
 *@FileTitle : Load Factor by Trade
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.11
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.06.11 박광석
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByTradeLaneVvdVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_1049 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_1049HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Prak Kwang Seok
 * @see EES_CIM_1049HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim1049Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchOptionByTradeLaneVvdVO[] searchOptionByTradeLaneVvdVOs = null;

	public EesCim1049Event() {
	}

	public void setSearchOptionByTradeLaneVvdVO(
			SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO) {
		this.searchOptionByTradeLaneVvdVO = searchOptionByTradeLaneVvdVO;
	}

	public void setSearchOptionByTradeLaneVvdVOS(
			SearchOptionByTradeLaneVvdVO[] searchOptionByTradeLaneVvdVOs) {
		if (searchOptionByTradeLaneVvdVOs != null) {
			SearchOptionByTradeLaneVvdVO[] tmpVOs = new SearchOptionByTradeLaneVvdVO[searchOptionByTradeLaneVvdVOs.length];
			System.arraycopy(searchOptionByTradeLaneVvdVOs, 0, tmpVOs, 0,
					tmpVOs.length);
			this.searchOptionByTradeLaneVvdVOs = tmpVOs;
		}
	}

	public SearchOptionByTradeLaneVvdVO getSearchOptionByTradeLaneVvdVO() {
		return searchOptionByTradeLaneVvdVO;
	}

	public SearchOptionByTradeLaneVvdVO[] getSearchOptionByTradeLaneVvdVOS() {
		SearchOptionByTradeLaneVvdVO[] tmpVOs = null;
		if (this.searchOptionByTradeLaneVvdVOs != null) {
			tmpVOs = new SearchOptionByTradeLaneVvdVO[searchOptionByTradeLaneVvdVOs.length];
			System.arraycopy(searchOptionByTradeLaneVvdVOs, 0, tmpVOs, 0,
					tmpVOs.length);
		}
		return tmpVOs;
	}

}