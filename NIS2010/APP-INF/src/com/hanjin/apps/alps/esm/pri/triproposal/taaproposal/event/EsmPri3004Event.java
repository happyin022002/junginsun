/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri3004Event.java
*@FileTitle : TAA List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.12.02 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTriMnVO;
import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;


/**
 * ESM_PRI_3004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_3004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltTaaMnVO rsltTaaMnVO = null;
	private PriTriMnVO priTriMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltTaaMnVO[] rsltTaaMnVOs = null;

	public EsmPri3004Event(){}
	
	/**
     * @param rsltTaaMnVO the rsltTaaMnVO to set
     */
	public void setRsltTaaMnVO(RsltTaaMnVO rsltTaaMnVO){
		this. rsltTaaMnVO = rsltTaaMnVO;
	}
	
	/**
     * @param rsltTaaMnVOs the rsltTaaMnVOs to set
     */
	public void setRsltTaaMnVOS(RsltTaaMnVO[] rsltTaaMnVOs){
		this. rsltTaaMnVOs = rsltTaaMnVOs;
	}
	
	 /**
     * @return the rsltTaaMnVO
     */
	public RsltTaaMnVO getRsltTaaMnVO(){
		return rsltTaaMnVO;
	}
	
	 /**
     * @return the rsltTaaMnVOs
     */
	public RsltTaaMnVO[] getRsltTaaMnVOS(){
		return rsltTaaMnVOs;
	}
	
	/**
     * @param priTriMnVO the priTriMnVO to set
     */
	public void setPriTriMnVO(PriTriMnVO priTriMnVO){
		this. priTriMnVO = priTriMnVO;
	}
	
	 /**
     * @return the priTriMnVO
     */
	public PriTriMnVO getPriTriMnVO() {
		return priTriMnVO;
	}
}