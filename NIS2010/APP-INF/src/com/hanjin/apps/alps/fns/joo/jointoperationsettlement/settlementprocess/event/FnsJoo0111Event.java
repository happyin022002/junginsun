/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0111Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.29 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.JoLoadingVO;

/**
 * FNS_JOO_0111 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0111HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0111HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0111Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TdrLoadVO tdrLoadVO = null;

	/** Table Value Object Multi Data 처리 */
	private TdrLoadVO[] tdrLoadVOs = null;

	/** Table Value Object Multi Data 처리 */
	private JoLoadingVO[] joLoadingVOs = null;
	
	private String rlaneCd = "";	
	
	public FnsJoo0111Event(){}
	
	public void setTdrLoadVO(TdrLoadVO tdrLoadVO){		
		this. tdrLoadVO = tdrLoadVO;
	}

	public TdrLoadVO getTdrLoadVO(){
		return tdrLoadVO;
	}

	public TdrLoadVO[] getTdrLoadVOs() {		
		TdrLoadVO[] rtnVOs = null;
		if (this.tdrLoadVOs != null) {
			rtnVOs = new TdrLoadVO[tdrLoadVOs.length];
			System.arraycopy(tdrLoadVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;							
	}

	public void setTdrLoadVOs(TdrLoadVO[] tdrLoadVOs) {
		if (tdrLoadVOs != null) {
			TdrLoadVO[] tmpVOs = new TdrLoadVO[tdrLoadVOs.length];
			System.arraycopy(tdrLoadVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tdrLoadVOs = tmpVOs;
		}						
	}

	public JoLoadingVO[] getJoLoadingVOs() {		
		JoLoadingVO[] rtnVOs = null;
		if (this.joLoadingVOs != null) {
			rtnVOs = new JoLoadingVO[joLoadingVOs.length];
			System.arraycopy(joLoadingVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;							
	}

	public void setJoLoadingVOs(JoLoadingVO[] joLoadingVOs) {
		if (joLoadingVOs != null) {
			JoLoadingVO[] tmpVOs = new JoLoadingVO[joLoadingVOs.length];
			System.arraycopy(joLoadingVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.joLoadingVOs = tmpVOs;
		}						
	}
		
	public String getRlaneCd() {
		return rlaneCd;
	}

	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}		
}