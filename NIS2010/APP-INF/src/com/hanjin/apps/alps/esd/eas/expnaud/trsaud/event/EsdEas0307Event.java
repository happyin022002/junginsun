/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0307Event.java
*@FileTitle : Rejection Notice Send History
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.26 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.event;

import com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo.UnmatchRouteBkgVsSoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0307 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0307HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0307HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0307Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	UnmatchRouteBkgVsSoVO unmatchRouteBkgVsSoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	UnmatchRouteBkgVsSoVO[] unmatchRouteBkgVsSoVOs = null;

	public EsdEas0307Event(){}
	
	// UnmatchRouteBkgVsSoVO
	public UnmatchRouteBkgVsSoVO getUnmatchRouteBkgVsSoVO() {
		return unmatchRouteBkgVsSoVO;
	}

	public void setUnmatchRouteBkgVsSoVO(UnmatchRouteBkgVsSoVO unmatchRouteBkgVsSoVO) {
		this.unmatchRouteBkgVsSoVO = unmatchRouteBkgVsSoVO;
	}

	public UnmatchRouteBkgVsSoVO[] getUnmatchRouteBkgVsSoVOs() {
		UnmatchRouteBkgVsSoVO[] rtnVOs = null;
		if (this.unmatchRouteBkgVsSoVOs != null) {
			rtnVOs = new UnmatchRouteBkgVsSoVO[unmatchRouteBkgVsSoVOs.length];
			System.arraycopy(unmatchRouteBkgVsSoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setUnmatchRouteBkgVsSoVOs(UnmatchRouteBkgVsSoVO[] unmatchRouteBkgVsSoVOs){
		if(unmatchRouteBkgVsSoVOs != null){
			UnmatchRouteBkgVsSoVO[] tmpVOs = new UnmatchRouteBkgVsSoVO[unmatchRouteBkgVsSoVOs.length];
			System.arraycopy(unmatchRouteBkgVsSoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.unmatchRouteBkgVsSoVOs = tmpVOs;
		}
	}

}