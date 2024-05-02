/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmPri4035Event.java
*@FileTitle : MOT Base Port Table Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2014.04.24 송호진
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.motfilinglocationproperty.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriMotFileLocPptVO;


/**
 * ESM_PRI_4035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SongHoJin
 * @see ESM_PRI_4035HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri4035Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	PriMotFileLocPptVO priMotFileLocPptVO = null;
	
	/** Table Value Object Multi Data 처리 */
	PriMotFileLocPptVO[] priMotFileLocPptVOs = null;

	public EsmPri4035Event(){}
	
	public void setPriMotFileLocPptVO(PriMotFileLocPptVO priMotFileLocPptVO){
		this. priMotFileLocPptVO = priMotFileLocPptVO;
	}

	public void setPriMotFileLocPptVOS(PriMotFileLocPptVO[] priMotFileLocPptVOs){
		this. priMotFileLocPptVOs = priMotFileLocPptVOs;
	}

	public PriMotFileLocPptVO getPriMotFileLocPptVO(){
		return priMotFileLocPptVO;
	}

	public PriMotFileLocPptVO[] getPriMotFileLocPptVOS(){
		return priMotFileLocPptVOs;
	}

}