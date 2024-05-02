/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0085Event.java
*@FileTitle : Standard Wording for S/C Notes
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.13 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.standardwording.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriScStndWdgVO;


/**
 * ESM_PRI_0085 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0085HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0085HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0085Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScStndWdgVO priScStndWdgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScStndWdgVO[] priScStndWdgVOs = null;

	public EsmPri0085Event(){}
	
	public void setPriScStndWdgVO(PriScStndWdgVO priScStndWdgVO){
		this. priScStndWdgVO = priScStndWdgVO;
	}

	public void setPriScStndWdgVOS(PriScStndWdgVO[] priScStndWdgVOs){
		this. priScStndWdgVOs = priScStndWdgVOs;
	}

	public PriScStndWdgVO getPriScStndWdgVO(){
		return priScStndWdgVO;
	}

	public PriScStndWdgVO[] getPriScStndWdgVOS(){
		return priScStndWdgVOs;
	}

}