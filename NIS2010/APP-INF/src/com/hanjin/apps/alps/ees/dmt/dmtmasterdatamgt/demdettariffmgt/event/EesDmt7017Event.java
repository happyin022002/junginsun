/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesDmt7017Event.java
*@FileTitle : DEM/DET Deletion Authority Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : Lee Sung Hoon
*@LastVersion : 1.0
** 2015.01.27 Lee Sung Hoon
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.AftBkgPathSetupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChgDeltPathStupVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchChgDeltPathStupVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/** 
 * EES_DMT_7017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_7017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Sung Hoon
 * @see EES_DMT_7017HTMLAction 참조 
 * @since J2EE 1.6
 */

public class EesDmt7017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private SearchChgDeltPathStupVO searchChgDeltPathStupVO  = null;
    private ChgDeltPathStupVO[] chgDeltPathStupVOs = null;
    private AftBkgPathSetupVO aftBkgPathSetupVO = null;
    private AftBkgPathSetupVO[] aftBkgPathSetupVOs = null;
    
    
	public EesDmt7017Event(){}

	public SearchChgDeltPathStupVO getSearchChgDeltPathStupVO() {
		return searchChgDeltPathStupVO;
	}
	public void setSearchChgDeltPathStupVO(SearchChgDeltPathStupVO searchChgDeltPathStupVO) {
		this.searchChgDeltPathStupVO = searchChgDeltPathStupVO;
	}
	public ChgDeltPathStupVO[] getChgDeltPathStupVOs() {
		ChgDeltPathStupVO[] ret = null;
		
		if (this.chgDeltPathStupVOs != null) {
			ret = new ChgDeltPathStupVO[chgDeltPathStupVOs.length];
			
			for (int i=0; i<chgDeltPathStupVOs.length; i++) {
				ret[i] = this.chgDeltPathStupVOs[i];
			}
		}
		return ret;		
	}
	
	public void setChgDeltPathStupVOs(ChgDeltPathStupVO[] chgDeltPathStupVOs) {
		if (chgDeltPathStupVOs != null) {
			this.chgDeltPathStupVOs = new ChgDeltPathStupVO[chgDeltPathStupVOs.length];
			
			for (int i=0; i<chgDeltPathStupVOs.length; i++) {
				this.chgDeltPathStupVOs[i] = chgDeltPathStupVOs[i];
			}
		}
	}

	public AftBkgPathSetupVO getAftBkgPathSetupVO() {
		return aftBkgPathSetupVO;
	}

	public void setAftBkgPathSetupVO(AftBkgPathSetupVO aftBkgPathSetupVO) {
		this.aftBkgPathSetupVO = aftBkgPathSetupVO;
	}
	
	public AftBkgPathSetupVO[] getAftBkgPathSetupVOs() {
		AftBkgPathSetupVO[] ret = null;
		
		if (this.aftBkgPathSetupVOs != null) {
			ret = new AftBkgPathSetupVO[aftBkgPathSetupVOs.length];
			
			for (int i=0; i<aftBkgPathSetupVOs.length; i++) {
				ret[i] = this.aftBkgPathSetupVOs[i];
			}
		}
		return ret;		
	}
	
	public void setAftBkgPathSetupVOs(AftBkgPathSetupVO[] aftBkgPathSetupVOs) {
		if (aftBkgPathSetupVOs != null) {
			this.aftBkgPathSetupVOs = new AftBkgPathSetupVO[aftBkgPathSetupVOs.length];
			
			for (int i=0; i<aftBkgPathSetupVOs.length; i++) {
				this.aftBkgPathSetupVOs[i] = aftBkgPathSetupVOs[i];
			}
		}
	}
	
}