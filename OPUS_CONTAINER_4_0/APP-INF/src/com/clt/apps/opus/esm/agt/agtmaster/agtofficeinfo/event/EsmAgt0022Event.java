/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmAgt022Event.java
*@FileTitle : 중국 Outbound 대리점 정보 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.07.28 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgChnAgnVO;


/**
 * ESM_AGT_022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_AGT_022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Jin
 * @see ESM_AGT_0022HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAgt0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgChnAgnVO bkgChinaAgentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgChnAgnVO[] bkgChinaAgentVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgChinaAgentVO bKGChinaAgentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgChinaAgentVO[] bKGChinaAgentVOs = null;

	public EsmAgt0022Event(){}
	
	public void setBkgChnAgnVO(BkgChnAgnVO bkgChinaAgentVO){
		this. bkgChinaAgentVO = bkgChinaAgentVO;
	}

	public void setBkgChnAgnVOS(BkgChnAgnVO[] bkgChinaAgentVOs){
		this. bkgChinaAgentVOs = bkgChinaAgentVOs;
	}

	public BkgChnAgnVO getBkgChnAgnVO(){
		return bkgChinaAgentVO;
	}

	public BkgChnAgnVO[] getBkgChnAgnVOS(){
		return bkgChinaAgentVOs;
	}

	public BkgChinaAgentVO getBKGChinaAgentVO() {
		return bKGChinaAgentVO;
	}

	public void setBKGChinaAgentVO(BkgChinaAgentVO chinaAgentVO) {
		bKGChinaAgentVO = chinaAgentVO;
	}

	public BkgChinaAgentVO[] getBKGChinaAgentVOs() {
		return bKGChinaAgentVOs;
	}

	public void setBKGChinaAgentVOs(BkgChinaAgentVO[] chinaAgentVOs) {
		bKGChinaAgentVOs = chinaAgentVOs;
	}

}