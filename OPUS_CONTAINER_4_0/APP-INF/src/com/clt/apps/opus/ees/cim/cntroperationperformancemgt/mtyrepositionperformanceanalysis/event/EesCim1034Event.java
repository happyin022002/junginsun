/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesCim1034Event.java
 *@FileTitle : Repo Result by Location
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.27
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.27 박광석
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByLocation;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_CIM_1034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_1034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Prak Kwang Seok
 * @see EES_CIM_1034HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCim1034Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private REPOResultSearchOptionByLocation rEPOResultSearchOptionByLocation = null;

	/** Table Value Object Multi Data 처리 */
	private REPOResultSearchOptionByLocation[] rEPOResultSearchOptionByLocations = null;

	public EesCim1034Event() {
	}

	public void setREPOResultSearchOptionByLocation(
			REPOResultSearchOptionByLocation rEPOResultSearchOptionByLocation) {
		this.rEPOResultSearchOptionByLocation = rEPOResultSearchOptionByLocation;
	}

	public void setREPOResultSearchOptionByLocationS(
			REPOResultSearchOptionByLocation[] rEPOResultSearchOptionByLocations) {
		if (rEPOResultSearchOptionByLocations != null) {
			REPOResultSearchOptionByLocation[] tmpVOs = new REPOResultSearchOptionByLocation[rEPOResultSearchOptionByLocations.length];
			System.arraycopy(rEPOResultSearchOptionByLocations, 0, tmpVOs, 0,
					tmpVOs.length);
			this.rEPOResultSearchOptionByLocations = tmpVOs;
		}
	}

	public REPOResultSearchOptionByLocation getREPOResultSearchOptionByLocation() {
		return rEPOResultSearchOptionByLocation;
	}

	public REPOResultSearchOptionByLocation[] getREPOResultSearchOptionByLocationS() {
		REPOResultSearchOptionByLocation[] tmpVOs = null;
		if (this.rEPOResultSearchOptionByLocations != null) {
			tmpVOs = new REPOResultSearchOptionByLocation[rEPOResultSearchOptionByLocations.length];
			System.arraycopy(rEPOResultSearchOptionByLocations, 0, tmpVOs, 0,
					tmpVOs.length);
		}
		return tmpVOs;
	}

}