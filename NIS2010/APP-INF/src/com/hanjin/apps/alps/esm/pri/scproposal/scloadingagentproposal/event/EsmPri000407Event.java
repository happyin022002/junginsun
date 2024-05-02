/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000407Event.java
*@FileTitle : S/C Proposal Loading Agent - Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.07 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.vo.RsltLodgAgnListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.vo.RsltSvcScpCdCntVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpLodgAgnVO;


/**
 * ESM_PRI_0004_07 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0004_07HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0004_07HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri000407Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltLodgAgnListVO rsltLodgAgnListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltLodgAgnListVO[] rsltLodgAgnListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpLodgAgnVO priSpScpLodgAgnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpLodgAgnVO[] priSpScpLodgAgnVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSvcScpCdCntVO rsltSvcScpCdCntVO = null;

	public EsmPri000407Event(){}
	
	public void setPriSpScpLodgAgnVO(PriSpScpLodgAgnVO priSpScpLodgAgnVO){
		this. priSpScpLodgAgnVO = priSpScpLodgAgnVO;
	}

	public void setPriSpScpLodgAgnVOS(PriSpScpLodgAgnVO[] priSpScpLodgAgnVOs){
		this. priSpScpLodgAgnVOs = priSpScpLodgAgnVOs;
	}

	public PriSpScpLodgAgnVO getPriSpScpLodgAgnVO(){
		return priSpScpLodgAgnVO;
	}

	public PriSpScpLodgAgnVO[] getPriSpScpLodgAgnVOS(){
		return priSpScpLodgAgnVOs;
	}

	public RsltLodgAgnListVO getRsltLodgAgnListVO() {
		return rsltLodgAgnListVO;
	}

	public RsltLodgAgnListVO[] getRsltLodgAgnListVOs() {
		return rsltLodgAgnListVOs;
	}

	public void setRsltLodgAgnListVO(RsltLodgAgnListVO rsltLodgAgnListVO) {
		this.rsltLodgAgnListVO = rsltLodgAgnListVO;
	}

	public void setRsltLodgAgnListVOs(RsltLodgAgnListVO[] rsltLodgAgnListVOs) {
		this.rsltLodgAgnListVOs = rsltLodgAgnListVOs;
	}

	public RsltSvcScpCdCntVO getRsltSvcScpCdCntVO() {
		return rsltSvcScpCdCntVO;
	}

	public void setRsltSvcScpCdCntVO(RsltSvcScpCdCntVO rsltSvcScpCdCntVO) {
		this.rsltSvcScpCdCntVO = rsltSvcScpCdCntVO;
	}



}