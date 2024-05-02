/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4034Event.java
*@FileTitle : Route Location Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.04.13 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.event;

import com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.vo.RoutLocCdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_4034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_PRI_4034HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmPri4034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RoutLocCdVO routLocCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RoutLocCdVO[] routLocCdVOs = null;
	
	public EsmPri4034Event(){}
	

	public void setRoutLocCdVO(RoutLocCdVO routLocCdVO){
		this. routLocCdVO = routLocCdVO;
	}

	public void setRoutLocCdVOs(RoutLocCdVO[] routLocCdVOs){
		if (routLocCdVOs != null) {
			RoutLocCdVO[] tmpVOs = new RoutLocCdVO[routLocCdVOs.length];
			System.arraycopy(routLocCdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.routLocCdVOs = tmpVOs;
		}
	}

	public RoutLocCdVO getRoutLocCdVO(){
		return routLocCdVO;
	}

	public RoutLocCdVO[] getRoutLocCdVOs(){
		RoutLocCdVO[] tmpVOs = null;
		if (this.routLocCdVOs != null) {
			tmpVOs = new RoutLocCdVO[routLocCdVOs.length];
			System.arraycopy(routLocCdVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	


}