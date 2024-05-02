/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0089Event.java
*@FileTitle : Guideline Clause & Standard Wording List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.18 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scnoteproposal.vo.RsltCtrtCluzListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriScStndWdgVO;


/**
 * ESM_PRI_0089 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0089HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_0089HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0089Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltCtrtCluzListVO rsltCtrtCluzListVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScStndWdgVO priScStndWdgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltCtrtCluzListVO[] rsltCtrtCluzListVOs = null;

	public EsmPri0089Event(){}
	
	public void setRsltCtrtCluzListVO(RsltCtrtCluzListVO rsltCtrtCluzListVO){
		this. rsltCtrtCluzListVO = rsltCtrtCluzListVO;
	}

	public void setPriScStndWdgVO(PriScStndWdgVO priScStndWdgVO){
		this. priScStndWdgVO = priScStndWdgVO;
	}
	
	public void setRsltCtrtCluzListVOS(RsltCtrtCluzListVO[] rsltCtrtCluzListVOs){
		this. rsltCtrtCluzListVOs = rsltCtrtCluzListVOs;
	}

	public RsltCtrtCluzListVO getRsltCtrtCluzListVO(){
		return rsltCtrtCluzListVO;
	}

	public PriScStndWdgVO getPriScStndWdgVO(){
		return priScStndWdgVO;
	}
	
	public RsltCtrtCluzListVO[] getRsltCtrtCluzListVOS(){
		return rsltCtrtCluzListVOs;
	}

}