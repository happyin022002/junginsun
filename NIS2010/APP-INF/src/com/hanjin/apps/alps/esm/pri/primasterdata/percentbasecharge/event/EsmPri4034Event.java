/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmPri4034Event.java
*@FileTitle : Percent Base CHG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.02
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.09.02 송호진
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriScgPctBseChgVO;
import com.hanjin.syscommon.common.table.PriScgPctBseVO;


/**
 * ESM_PRI_4034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SongHoJin
 * @see ESM_PRI_4034HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private PriScgPctBseVO priScgPctBseVO = null;
	
	private PriScgPctBseVO[] priScgPctBseVOs = null;
	
	private PriScgPctBseChgVO priScgPctBseChgVO = null;
	
	private PriScgPctBseChgVO[] priScgPctBseChgVOs = null;

	public EsmPri4034Event(){}
	
	public PriScgPctBseVO getPriScgPctBseVO() {
		return priScgPctBseVO;
	}

	public void setPriScgPctBseVO(PriScgPctBseVO priScgPctBseVO) {
		this.priScgPctBseVO = priScgPctBseVO;
	}

	public PriScgPctBseVO[] getPriScgPctBseVOs() {
		PriScgPctBseVO[] rtnVOs = null;
		if (this.priScgPctBseVOs != null) {
			rtnVOs = new PriScgPctBseVO[priScgPctBseVOs.length];
			System.arraycopy(priScgPctBseVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriScgPctBseVOs(PriScgPctBseVO[] priScgPctBseVOs){
		if(priScgPctBseVOs != null){
			PriScgPctBseVO[] tmpVOs = new PriScgPctBseVO[priScgPctBseVOs.length];
			System.arraycopy(priScgPctBseVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgPctBseVOs = tmpVOs;
		}
	}

	public PriScgPctBseChgVO getPriScgPctBseChgVO() {
		return priScgPctBseChgVO;
	}

	public void setPriScgPctBseChgVO(PriScgPctBseChgVO priScgPctBseChgVO) {
		this.priScgPctBseChgVO = priScgPctBseChgVO;
	}

	public PriScgPctBseChgVO[] getPriScgPctBseChgVOs() {
		PriScgPctBseChgVO[] rtnVOs = null;
		if (this.priScgPctBseChgVOs != null) {
			rtnVOs = new PriScgPctBseChgVO[priScgPctBseChgVOs.length];
			System.arraycopy(priScgPctBseChgVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPriScgPctBseChgVOs(PriScgPctBseChgVO[] priScgPctBseChgVOs){
		if(priScgPctBseChgVOs != null){
			PriScgPctBseChgVO[] tmpVOs = new PriScgPctBseChgVO[priScgPctBseChgVOs.length];
			System.arraycopy(priScgPctBseChgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priScgPctBseChgVOs = tmpVOs;
		}
	}
	
}