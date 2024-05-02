/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0210Event.java
*@FileTitle : Performance by office
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.30 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.event;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchOfcPerfVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchRegRptVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0210 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0210HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0210HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0210Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	public EsdEas0210Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchRegRptVO searchRegRptVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SearchRegRptVO[] searchRegRptVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchOfcPerfVO searchOfcPerfVO = null;
	
	/** Table Value Object Multi Data 처리 */
	SearchOfcPerfVO[] searchOfcPerfVOs = null;
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

	public SearchOfcPerfVO getSearchOfcPerfVO() {
		return searchOfcPerfVO;
	}

	public void setSearchOfcPerfVO(SearchOfcPerfVO searchOfcPerfVO) {
		this.searchOfcPerfVO = searchOfcPerfVO;
	}

	public SearchOfcPerfVO[] getSearchOfcPerfVOs() {
		SearchOfcPerfVO[] rtnVOs = null;
		if (this.searchOfcPerfVOs != null) {
			rtnVOs = new SearchOfcPerfVO[searchOfcPerfVOs.length];
			System.arraycopy(searchOfcPerfVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchOfcPerfVOs(SearchOfcPerfVO[] searchOfcPerfVOs){
		if(searchOfcPerfVOs != null){
			SearchOfcPerfVO[] tmpVOs = new SearchOfcPerfVO[searchOfcPerfVOs.length];
			System.arraycopy(searchOfcPerfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchOfcPerfVOs = tmpVOs;
		}
	}

}