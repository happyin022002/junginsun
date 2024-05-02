/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0114Event.java
*@FileTitle : Multi Creation & Change Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.01.22 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.vo.StlStsVO;

/**
 * FNS_JOO_0114 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0114HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JungHo Min
 * @see FNS_JOO_0114HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsJoo0114Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private StlStsVO stlStsVO = null;

	/** Table Value Object Multi Data 처리 */
	private StlStsVO[] stlStsVOs = null;
		
	public FnsJoo0114Event(){}
	
	public void setStlStsVO(StlStsVO stlStsVO){		
		this. stlStsVO = stlStsVO;
	}

	public StlStsVO getStlStsVO(){
		return stlStsVO;
	}

	public StlStsVO[] getStlStsVOs() {
		
		StlStsVO[] rtnVOs = null;
		if (this.stlStsVOs != null) {
			rtnVOs = new StlStsVO[stlStsVOs.length];
			System.arraycopy(stlStsVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;							
	}

	public void setStlStsVOs(StlStsVO[] stlStsVOs) {
		if (stlStsVOs != null) {
			StlStsVO[] tmpVOs = new StlStsVO[stlStsVOs.length];
			System.arraycopy(stlStsVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.stlStsVOs = tmpVOs;
		}						
	}	
}