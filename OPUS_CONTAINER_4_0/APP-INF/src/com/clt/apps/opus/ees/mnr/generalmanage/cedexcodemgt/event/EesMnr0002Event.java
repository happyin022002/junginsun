/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiMnr0002Event.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.04.27 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event;

import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CodeRelationINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.ComponentCodeListINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCdRltByDmgVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCdRltByLocVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrEqCmpoCdVO;
import com.clt.framework.support.layer.event.EventSupport;
   

/**
 * UI_MNR_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_MNR_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author WanGyu Kim 
 * @see EES_MNR_0002HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComponentCodeListINVO componentCodeListINVO = null;
	private CodeRelationINVO codeRelationINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomMnrEqCmpoCdVO[] customMnrEqCmpoCdVOs = null;
	private CustomMnrCdRltByLocVO[] customMnrCdRltByLocVOs = null;
	private CustomMnrCdRltByDmgVO[] customMnrCdRltByDmgVOs = null;

	public EesMnr0002Event(){}
	
	public void setComponentCodeListINVO(ComponentCodeListINVO componentCodeListINVO){
		this. componentCodeListINVO = componentCodeListINVO;
	}
	public void setCustomMnrEqCmpoCdVOS(CustomMnrEqCmpoCdVO[] customMnrEqCmpoCdVOs){
		if(customMnrEqCmpoCdVOs != null){
			CustomMnrEqCmpoCdVO[] tmpVOs = java.util.Arrays.copyOf(customMnrEqCmpoCdVOs, customMnrEqCmpoCdVOs.length);
			this.customMnrEqCmpoCdVOs = tmpVOs;
		}
	}
	public ComponentCodeListINVO getComponentCodeListINVO(){
		return componentCodeListINVO;
	}
	public CustomMnrEqCmpoCdVO[] getCustomMnrEqCmpoCdVOS(){
		CustomMnrEqCmpoCdVO[] rtnVOs = null;
		if (this.customMnrEqCmpoCdVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrEqCmpoCdVOs, customMnrEqCmpoCdVOs.length);
		}
		return rtnVOs;
	}
	public CodeRelationINVO getCodeRelationINVO() {
		return codeRelationINVO;
	}

	public void setCodeRelationINVO(CodeRelationINVO codeRelationINVO) {
		this.codeRelationINVO = codeRelationINVO;
	}

	public CustomMnrCdRltByLocVO[] getCustomMnrCdRltByLocVOS() {
		CustomMnrCdRltByLocVO[] rtnVOs = null;
		if (this.customMnrCdRltByLocVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrCdRltByLocVOs, customMnrCdRltByLocVOs.length);
		}
		return rtnVOs;
	}

	public void setCustomMnrCdRltByLocVOS(CustomMnrCdRltByLocVO[] customMnrCdRltByLocVOs){
		if(customMnrCdRltByLocVOs != null){
			CustomMnrCdRltByLocVO[] tmpVOs = java.util.Arrays.copyOf(customMnrCdRltByLocVOs, customMnrCdRltByLocVOs.length);
			this.customMnrCdRltByLocVOs = tmpVOs;
		}
	}

	public CustomMnrCdRltByDmgVO[] getCustomMnrCdRltByDmgVOS() {
		CustomMnrCdRltByDmgVO[] rtnVOs = null;
		if (this.customMnrCdRltByDmgVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customMnrCdRltByDmgVOs, customMnrCdRltByDmgVOs.length);
		}
		return rtnVOs;
	}

	public void setCustomMnrCdRltByDmgVOS(CustomMnrCdRltByDmgVO[] customMnrCdRltByDmgVOs){
		if(customMnrCdRltByDmgVOs != null){
			CustomMnrCdRltByDmgVO[] tmpVOs = java.util.Arrays.copyOf(customMnrCdRltByDmgVOs, customMnrCdRltByDmgVOs.length);
			this.customMnrCdRltByDmgVOs = tmpVOs;
		}
	}
}