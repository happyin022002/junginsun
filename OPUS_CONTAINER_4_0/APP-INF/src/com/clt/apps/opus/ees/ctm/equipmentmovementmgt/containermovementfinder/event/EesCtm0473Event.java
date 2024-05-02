/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCtm0408Event.java
*@FileTitle : Each Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.19 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllEQRRefVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ees_ctm_0473 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_ctm_0473HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ees_ctm_0473HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesCtm0473Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAllEQRRefVO searchAllEQRRefVO = null;
	private SearchAllEQRRefVO[] searchAllEQRRefVOs = null;
	
	public EesCtm0473Event(){}

	public SearchAllEQRRefVO getSearchAllEQRRefVO() {
		return searchAllEQRRefVO;
	}

	public void setSearchAllEQRRefVO(SearchAllEQRRefVO searchAllEQRRefVO) {
		this.searchAllEQRRefVO = searchAllEQRRefVO;
	}

	public SearchAllEQRRefVO[] getSearchAllEQRRefVOs() {
		SearchAllEQRRefVO[] tmpVOs = null;
		if (this.searchAllEQRRefVOs != null) {
			tmpVOs = new SearchAllEQRRefVO[searchAllEQRRefVOs.length];
			System.arraycopy(searchAllEQRRefVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setSearchAllEQRRefVOs(SearchAllEQRRefVO[] searchAllEQRRefVOs) {
		if (searchAllEQRRefVOs != null) {
			SearchAllEQRRefVO[] tmpVOs = new SearchAllEQRRefVO[searchAllEQRRefVOs.length];
			System.arraycopy(searchAllEQRRefVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchAllEQRRefVOs = tmpVOs;
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}