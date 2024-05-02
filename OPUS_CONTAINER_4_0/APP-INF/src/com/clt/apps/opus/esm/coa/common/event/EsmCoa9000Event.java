/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmCoa9000Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.18 SJH
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.common.event;

import com.clt.apps.opus.esm.coa.common.vo.BkgSokeupVO;
import com.clt.framework.support.layer.event.EventSupport;
import java.util.Arrays;									//SJH.20150507.소스품질

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
	
	//SJH.20150507.소스품질
	public void setBkgSokeupVOS(BkgSokeupVO[] bkgSokeupVOs){
		if(bkgSokeupVOs != null){
			BkgSokeupVO[] tmpVOs = Arrays.copyOf(bkgSokeupVOs, bkgSokeupVOs.length);
			this.bkgSokeupVOs = tmpVOs;
		}
	}

	public BkgSokeupVO getBkgSokeupVO(){
		return bkgSokeupVO;
	}
	
	//SJH.20150507.소스품질
	public BkgSokeupVO[] getBkgSokeupVOS(){
		BkgSokeupVO[] rtnVOs = null;
		if (this.bkgSokeupVOs != null) {
			rtnVOs = Arrays.copyOf(bkgSokeupVOs, bkgSokeupVOs.length);
		}
		return rtnVOs;
	}
}