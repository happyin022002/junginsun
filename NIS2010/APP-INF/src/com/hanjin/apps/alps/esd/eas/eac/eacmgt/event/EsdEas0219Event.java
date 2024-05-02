/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0219Event.java
*@FileTitle : Performance by S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.30 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchRegRptVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchSpPerfVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0219 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0219HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0219HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0219Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsdEas0219Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchRegRptVO searchRegRptVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SearchRegRptVO[] searchRegRptVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchSpPerfVO searchSpPerfVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SearchSpPerfVO[] searchSpPerfVOs = null;
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

	public SearchSpPerfVO getSearchSpPerfVO() {
		return searchSpPerfVO;
	}

	public void setSearchSpPerfVO(SearchSpPerfVO searchSpPerfVO) {
		this.searchSpPerfVO = searchSpPerfVO;
	}

	public SearchSpPerfVO[] getSearchSpPerfVOs() {
		SearchSpPerfVO[] rtnVOs = null;
		if (this.searchSpPerfVOs != null) {
			rtnVOs = new SearchSpPerfVO[searchSpPerfVOs.length];
			System.arraycopy(searchSpPerfVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchSpPerfVOs(SearchSpPerfVO[] searchSpPerfVOs){
		if(searchSpPerfVOs != null){
			SearchSpPerfVO[] tmpVOs = new SearchSpPerfVO[searchSpPerfVOs.length];
			System.arraycopy(searchSpPerfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpPerfVOs = tmpVOs;
		}
	}

}