/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0026Event.java
*@FileTitle : Undeclared History
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.16
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.12.16 김도현
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.UndeclaredHistoryVO;


/**
 * VOP_AOM_0026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_AOM_0026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG_0026HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0026Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UndeclaredHistoryVO undeclaredHistoryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UndeclaredHistoryVO[] undeclaredHistoryVOs = null;

	private List<String> keys = null;
	
	public VopScg0026Event(){}
	
	public void setUndeclaredHistoryVO(UndeclaredHistoryVO undeclaredHistoryVO){
		this. undeclaredHistoryVO = undeclaredHistoryVO;
	}

	public void setUndeclaredHistoryVOS(UndeclaredHistoryVO[] undeclaredHistoryVOs){
		if (undeclaredHistoryVOs != null) {
			UndeclaredHistoryVO[] tmpVOs = new UndeclaredHistoryVO[undeclaredHistoryVOs.length];
			System.arraycopy(undeclaredHistoryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.undeclaredHistoryVOs = tmpVOs;
		}
	}

	public UndeclaredHistoryVO getUndeclaredHistoryVO(){
		return undeclaredHistoryVO;
	}

	public UndeclaredHistoryVO[] getUndeclaredHistoryVOS(){
		UndeclaredHistoryVO[] rtnVOs = null;
		if (this.undeclaredHistoryVOs != null) {
			rtnVOs = new UndeclaredHistoryVO[undeclaredHistoryVOs.length];
			System.arraycopy(undeclaredHistoryVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	
}