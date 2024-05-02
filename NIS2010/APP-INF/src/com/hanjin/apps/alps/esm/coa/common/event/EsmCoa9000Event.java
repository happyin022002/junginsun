/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmCoa9000Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.24
*@LastModifier : 박찬민
*@LastVersion : 1.0
* 2013.04.24 박찬민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.common.event;

import com.hanjin.apps.alps.esm.coa.common.vo.BkgSokeupVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_COA_9000 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_9000Event에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chan Min Park
 * @see ESM_COA_9000Event 참조
 * @since J2EE 1.6
 */

public class EsmCoa9000Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgSokeupVO bkgSokeupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgSokeupVO[] bkgSokeupVOs = null;

	public EsmCoa9000Event(){}
	
	public void setBkgSokeupVO(BkgSokeupVO bkgSokeupVO){
		this. bkgSokeupVO = bkgSokeupVO;
	}

	public void setBkgSokeupVOS(BkgSokeupVO[] bkgSokeupVOs){
		this. bkgSokeupVOs = bkgSokeupVOs;
	}

	public BkgSokeupVO getBkgSokeupVO(){
		return bkgSokeupVO;
	}
	
	public BkgSokeupVO[] getBkgSokeupVOS(){
		return bkgSokeupVOs;
	}
}