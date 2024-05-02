/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0065Event.java
*@FileTitle : S/C Prefix & Scope Mapping Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.04.17 문동규
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.scprefix.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriScPfxMapgVO;


/**
 * ESM_PRI_0065 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0065HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0065HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0065Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScPfxMapgVO priscpfxmapgvo = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScPfxMapgVO[] priscpfxmapgvos = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
//	private PriScPfxVO priscpfxvo = null;
	
	/** Table Value Object Multi Data 처리 */
//	private PriScPfxVO[] priscpfxvos = null;

	public EsmPri0065Event(){}
	
	public void setPriScPfxMapgVO(PriScPfxMapgVO priscpfxmapgvo){
		this. priscpfxmapgvo = priscpfxmapgvo;
	}

	public void setPriScPfxMapgVOS(PriScPfxMapgVO[] priscpfxmapgvos){
		if(priscpfxmapgvos != null){
			PriScPfxMapgVO[] tmpVOs = new PriScPfxMapgVO[priscpfxmapgvos.length];
			System.arraycopy(priscpfxmapgvos, 0, tmpVOs, 0, tmpVOs.length);
			this.priscpfxmapgvos = tmpVOs;
		}
	}

//	public void setPriScPfxVO(PriScPfxVO priscpfxvo){
//		this. priscpfxvo = priscpfxvo;
//	}

//	public void setPriScPfxVOS(PriScPfxVO[] priscpfxvos){
//		this. priscpfxvos = priscpfxvos;
//	}

	public PriScPfxMapgVO getPriScPfxMapgVO(){
		return priscpfxmapgvo;
	}

	public PriScPfxMapgVO[] getPriScPfxMapgVOS(){
		PriScPfxMapgVO[] rtnVOs = null;
		if (this.priscpfxmapgvos != null) {
			rtnVOs = new PriScPfxMapgVO[priscpfxmapgvos.length];
			System.arraycopy(priscpfxmapgvos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

//	public PriScPfxVO getPriScPfxVO(){
//		return priscpfxvo;
//	}

//	public PriScPfxVO[] getPriScPfxVOS(){
//		return priscpfxvos;
//	}

}