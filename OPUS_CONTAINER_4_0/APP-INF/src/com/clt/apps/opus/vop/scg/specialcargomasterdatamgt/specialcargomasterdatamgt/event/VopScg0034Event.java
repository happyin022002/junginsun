/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VmsScg0034Event.java
*@FileTitle : Partner’s Contact Point for SPCL CGO (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.11 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgCntcPntVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ScgRgnShpOprCdVO;


/**
 * VMS_SCG-0034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VMS_SCG-0034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VMS_SCG-0034HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopScg0034Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgCntcPntVO scgCntcPntVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgRgnShpOprCdVO scgRgnShpOprCdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgCntcPntVO[] scgCntcPntVOs = null;

	public VopScg0034Event(){}
	
	public void setScgCntcPntVO(ScgCntcPntVO scgCntcPntVO){
		this. scgCntcPntVO = scgCntcPntVO;
	}

	public void setScgRgnShpOprCdVO(ScgRgnShpOprCdVO scgRgnShpOprCdVO){
		this. scgRgnShpOprCdVO = scgRgnShpOprCdVO;
	}

	public void setScgCntcPntVOS(ScgCntcPntVO[] scgCntcPntVOs){
		if(scgCntcPntVOs != null){
			ScgCntcPntVO[] tmpVOs = Arrays.copyOf(scgCntcPntVOs, scgCntcPntVOs.length);
			this.scgCntcPntVOs = tmpVOs;
		}
	}

	public ScgCntcPntVO getScgCntcPntVO(){
		return scgCntcPntVO;
	}

	public ScgRgnShpOprCdVO getScgRgnShpOprCdVO(){
		return scgRgnShpOprCdVO;
	}

	public ScgCntcPntVO[] getScgCntcPntVOS(){
		ScgCntcPntVO[] rtnVOs = null;
		if (this.scgCntcPntVOs != null) {
			rtnVOs = Arrays.copyOf(scgCntcPntVOs, scgCntcPntVOs.length);
		}
		return rtnVOs;
	}

}