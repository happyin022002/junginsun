/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000401Event.java
*@FileTitle : S/C Proposal Org/Dst Location Infomation - Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.09.04 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.event;

import com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.vo.RsltRoutPntLocListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpRoutPntVO;


/**
 * ESM_PRI_0004_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0004_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0004_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri000401Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltRoutPntLocListVO rsltRoutPntLocListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpRoutPntVO priSpScpRoutPntVO = null;
	
	public EsmPri000401Event(){}
	
	public void setRsltRoutPntLocListVO(RsltRoutPntLocListVO rsltRoutPntLocListVO){
		this. rsltRoutPntLocListVO = rsltRoutPntLocListVO;
	}

	public void setPriSpScpRoutPntVO(PriSpScpRoutPntVO priSpScpRoutPntVO){
		this. priSpScpRoutPntVO = priSpScpRoutPntVO;
	}

	public RsltRoutPntLocListVO getRsltRoutPntLocListVO(){
		return rsltRoutPntLocListVO;
	}

	public PriSpScpRoutPntVO getPriSpScpRoutPntVO(){
		return priSpScpRoutPntVO;
	}

}