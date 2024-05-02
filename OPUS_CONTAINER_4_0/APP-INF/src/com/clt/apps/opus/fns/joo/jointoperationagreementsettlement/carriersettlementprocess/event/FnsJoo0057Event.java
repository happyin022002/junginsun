/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0056Event.java
*@FileTitle : RDR Download by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.17 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0057HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TdrLoadVO tdrLoadVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TdrLoadVO[] tdrLoadVOs = null;

	public FnsJoo0057Event(){}
	
	public void setTdrLoadVO(TdrLoadVO tdrLoadVO){
		this. tdrLoadVO = tdrLoadVO;
	}

	public void setTdrLoadVOS(TdrLoadVO[] tdrLoadVOs){
		if (tdrLoadVOs != null) {
			TdrLoadVO[] tmpVOs = new TdrLoadVO[tdrLoadVOs.length];
			System.arraycopy(tdrLoadVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tdrLoadVOs = tmpVOs;
		}
	}

	public TdrLoadVO getTdrLoadVO(){
		return tdrLoadVO;
	}

	public TdrLoadVO[] getTdrLoadVOS(){
		TdrLoadVO[] tmpVOs = null;
		if (this.tdrLoadVOs != null) {
			tmpVOs = new TdrLoadVO[tdrLoadVOs.length];
			System.arraycopy(tdrLoadVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}