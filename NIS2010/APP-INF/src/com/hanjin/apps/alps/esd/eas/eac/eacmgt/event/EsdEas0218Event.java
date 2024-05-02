/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0218Event.java
*@FileTitle : Audit Performance by RHQ
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.01
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.12.01 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchRegRptVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchRhqStatisticsVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0218 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0218HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0218HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0218Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsdEas0218Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchRegRptVO searchRegRptVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SearchRegRptVO[] searchRegRptVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchRhqStatisticsVO searchRhqStatisticsVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SearchRhqStatisticsVO[] searchRhqStatisticsVOs = null;
	public SearchRegRptVO getSearchRegRptVO() {
		return searchRegRptVO;
	}

	public void setSearchRegRptVO(SearchRegRptVO searchRegRptVO) {
		this.searchRegRptVO = searchRegRptVO;
	}

	public SearchRegRptVO[] getSearchRegRptVOs() {
		SearchRegRptVO[] rtnVOs = null;
		if (this.searchRegRptVOs != null) {
			rtnVOs = new SearchRegRptVO[searchRegRptVOs.length];
			System.arraycopy(searchRegRptVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchRegRptVOs(SearchRegRptVO[] searchRegRptVOs){
		if(searchRegRptVOs != null){
			SearchRegRptVO[] tmpVOs = new SearchRegRptVO[searchRegRptVOs.length];
			System.arraycopy(searchRegRptVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchRegRptVOs = tmpVOs;
		}
	}

	public SearchRhqStatisticsVO getSearchRhqStatisticsVO() {
		return searchRhqStatisticsVO;
	}

	public void setSearchRhqStatisticsVO(SearchRhqStatisticsVO searchRhqStatisticsVO) {
		this.searchRhqStatisticsVO = searchRhqStatisticsVO;
	}

	public SearchRhqStatisticsVO[] getSearchRhqStatisticsVOs() {
		SearchRhqStatisticsVO[] rtnVOs = null;
		if (this.searchRhqStatisticsVOs != null) {
			rtnVOs = new SearchRhqStatisticsVO[searchRhqStatisticsVOs.length];
			System.arraycopy(searchRhqStatisticsVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchRhqStatisticsVOs(SearchRhqStatisticsVO[] searchRhqStatisticsVOs){
		if(searchRhqStatisticsVOs != null){
			SearchRhqStatisticsVO[] tmpVOs = new SearchRhqStatisticsVO[searchRhqStatisticsVOs.length];
			System.arraycopy(searchRhqStatisticsVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchRhqStatisticsVOs = tmpVOs;
		}
	}

}