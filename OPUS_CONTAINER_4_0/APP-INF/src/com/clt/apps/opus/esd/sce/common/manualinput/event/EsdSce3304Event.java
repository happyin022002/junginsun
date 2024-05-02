/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TmpStd0001Event.java
*@FileTitle : Customs Error Code
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceCntrStsMsgMvmtMapgVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * PDTO(Data Transfer Object including Parameters) about ESM_BKG_3304<br>
 * -  Writing in ESM_BKG_3304HTMLAction<br>
 * Using as a PDTO transferred to ServiceCommand Layer
 * @author Kim KiTaek
 * @see referencing ESM_BKG_3304HTMLAction
 * @since J2EE 1.6
 */
public class EsdSce3304Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object Retreve conditions and single inquiry processing */
	private SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO = null;
	
	/** Processing Table Value Object Multi Data */
	private SceCntrStsMsgMvmtMapgVO[] sceCntrStsMsgMvmtMapgVOs = null;
	
	public SceCntrStsMsgMvmtMapgVO getSceCntrStsMsgMvmtMapgVO() {
		return sceCntrStsMsgMvmtMapgVO;
	}

	public void setSceCntrStsMsgMvmtMapgVO(SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO) {
		this.sceCntrStsMsgMvmtMapgVO = sceCntrStsMsgMvmtMapgVO;
	}

	public SceCntrStsMsgMvmtMapgVO[] getSceCntrStsMsgMvmtMapgVOs() {
		SceCntrStsMsgMvmtMapgVO[] rtnVOs = null;
		if (this.sceCntrStsMsgMvmtMapgVOs != null) {
			rtnVOs = Arrays.copyOf(sceCntrStsMsgMvmtMapgVOs, sceCntrStsMsgMvmtMapgVOs.length);
		}
		return rtnVOs;
	}

	public void setSceCntrStsMsgMvmtMapgVOs(SceCntrStsMsgMvmtMapgVO[] sceCntrStsMsgMvmtMapgVOs) {
		if(sceCntrStsMsgMvmtMapgVOs != null){
			SceCntrStsMsgMvmtMapgVO[] tmpVOs = Arrays.copyOf(sceCntrStsMsgMvmtMapgVOs, sceCntrStsMsgMvmtMapgVOs.length);
			this.sceCntrStsMsgMvmtMapgVOs = tmpVOs;
		}
	}

}