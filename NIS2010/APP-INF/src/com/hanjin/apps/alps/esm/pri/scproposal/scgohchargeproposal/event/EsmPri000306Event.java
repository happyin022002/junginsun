/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000306Event.java
*@FileTitle : S/C Proposal 및 Amendment시  GOH 생성/수정하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.26 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.vo.CstPriSpScpGohChgVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSgGohChgVO;
import com.hanjin.syscommon.common.table.PriSpScpGohChgVO;


/**
 * ESM_PRI_0003_06 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0003_06HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_0003_06HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri000306Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpGohChgVO priSpScpGohChgVO = null;
	private CstPriSpScpGohChgVO cstPriSpScpGohChgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpGohChgVO[] priSpScpGohChgVOs = null;
	private PriSgGohChgVO[] priSgGohChgVOs = null;
	
	public EsmPri000306Event(){}
	
	public void setPriSpScpGohChgVO(PriSpScpGohChgVO priSpScpGohChgVO){
		this. priSpScpGohChgVO = priSpScpGohChgVO;
	}

	public void setPriSpScpGohChgVOS(PriSpScpGohChgVO[] priSpScpGohChgVOs){
		this. priSpScpGohChgVOs = priSpScpGohChgVOs;
	}

	public PriSpScpGohChgVO getPriSpScpGohChgVO(){
		return priSpScpGohChgVO;
	}

	public PriSpScpGohChgVO[] getPriSpScpGohChgVOS(){
		return priSpScpGohChgVOs;
	}
	
	public void setPriSgGohChgVOS(PriSgGohChgVO[] priSgGohChgVOs){
		this. priSgGohChgVOs = priSgGohChgVOs;
	}
	
	public PriSgGohChgVO[] getPriSgGohChgVOS(){
		return priSgGohChgVOs;
	}
	
	public void setCstPriSpScpGohChgVO(CstPriSpScpGohChgVO cstPriSpScpGohChgVO){
		this. cstPriSpScpGohChgVO = cstPriSpScpGohChgVO;
	}
	
	public CstPriSpScpGohChgVO getCstPriSpScpGohChgVO(){
		return cstPriSpScpGohChgVO;
	}
}