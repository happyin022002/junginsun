/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0090Event.java
*@FileTitle : RDR Download by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.21
*@LastModifier : Kim Sanggeun
*@LastVersion : 1.0
* 2012.06.21 Kim Sanggeun
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrRatioVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0090 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0090HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim sang geun
 * @see FNS_JOO_0090HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0090Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TdrRatioVO tdrRatioVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TdrRatioVO[] tdrRatioVOs = null;

	public FnsJoo0090Event(){}
	
	public void setTdrRatioVO(TdrRatioVO tdrRatioVO){
		this. tdrRatioVO = tdrRatioVO;
	}

	public void setTdrRatioVOS(TdrRatioVO[] tdrRatioVOs){
		if (tdrRatioVOs != null) {
			TdrRatioVO[] tmpVOs = new TdrRatioVO[tdrRatioVOs.length];
			System.arraycopy(tdrRatioVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tdrRatioVOs = tmpVOs;
		}		
	}

	public TdrRatioVO getTdrRatioVO(){
		return tdrRatioVO;
	}

	public TdrRatioVO[] getTdrRatioVOS(){
		TdrRatioVO[] rtnVOs = null;
		if (this.tdrRatioVOs != null) {
			rtnVOs = new TdrRatioVO[tdrRatioVOs.length];
			System.arraycopy(tdrRatioVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

}