/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0209Event.java
*@FileTitle : Audit Performance by office
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.30 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchOfcStatisticsVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchRegRptVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0209 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0209HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0209HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0209Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsdEas0209Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchRegRptVO searchRegRptVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SearchRegRptVO[] searchRegRptVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchOfcStatisticsVO searchOfcStatisticsVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SearchOfcStatisticsVO[] searchOfcStatisticsVOs = null;
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

	public SearchOfcStatisticsVO getSearchOfcStatisticsVO() {
		return searchOfcStatisticsVO;
	}

	public void setSearchOfcStatisticsVO(SearchOfcStatisticsVO searchOfcStatisticsVO) {
		this.searchOfcStatisticsVO = searchOfcStatisticsVO;
	}

	public SearchOfcStatisticsVO[] getSearchOfcStatisticsVOs() {
		SearchOfcStatisticsVO[] rtnVOs = null;
		if (this.searchOfcStatisticsVOs != null) {
			rtnVOs = new SearchOfcStatisticsVO[searchOfcStatisticsVOs.length];
			System.arraycopy(searchOfcStatisticsVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchOfcStatisticsVOs(SearchOfcStatisticsVO[] searchOfcStatisticsVOs){
		if(searchOfcStatisticsVOs != null){
			SearchOfcStatisticsVO[] tmpVOs = new SearchOfcStatisticsVO[searchOfcStatisticsVOs.length];
			System.arraycopy(searchOfcStatisticsVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchOfcStatisticsVOs = tmpVOs;
		}
	}


}