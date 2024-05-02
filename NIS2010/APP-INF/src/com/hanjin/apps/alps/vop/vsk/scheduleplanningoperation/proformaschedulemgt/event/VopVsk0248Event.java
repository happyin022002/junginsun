/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0248Event.java
*@FileTitle : P/F SKD History Inquiry (Pop-up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.05.27 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo.VskPfSkdHisVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK-0248 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK-0248HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK-0248HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0248Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VskPfSkdHisVO vskPfSkdHisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VskPfSkdHisVO[] vskPfSkdHisVOs = null;

	public VopVsk0248Event(){}
	
	public void setVskPfSkdHisVO(VskPfSkdHisVO vskPfSkdHisVO){
		this. vskPfSkdHisVO = vskPfSkdHisVO;
	}

	public void setVskPfSkdHisVOS(VskPfSkdHisVO[] vskPfSkdHisVOs){
		if(vskPfSkdHisVOs != null){
			VskPfSkdHisVO[] tmpVOs = new VskPfSkdHisVO[vskPfSkdHisVOs.length];
			System.arraycopy(vskPfSkdHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPfSkdHisVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this. vskPfSkdHisVOs = vskPfSkdHisVOs;
	}

	public VskPfSkdHisVO getVskPfSkdHisVO(){
		return vskPfSkdHisVO;
	}

	public VskPfSkdHisVO[] getVskPfSkdHisVOS(){
		VskPfSkdHisVO[] rtnVOs =  null;
		if(this.vskPfSkdHisVOs != null){
			rtnVOs = new VskPfSkdHisVO[vskPfSkdHisVOs.length];
			System.arraycopy(vskPfSkdHisVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vskPfSkdHisVOs;
	}

}