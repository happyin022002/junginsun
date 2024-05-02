/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri3009Event.java
*@FileTitle : TRI Creation & Amendment - TRI Select
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.03 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.taaproposal.event;

import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaTriListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_3009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_3009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Custom Value Object 조회 조건 및 단건 처리  */
	private RsltTaaTriListVO rsltTaaTriListVO = null;
	
	/** Custom Value Object Multi Data 처리 */
	private RsltTaaMnVO rsltTaaMnVO = null;

	public EsmPri3009Event(){}
	
	public void setRsltTaaTriListVO(RsltTaaTriListVO rsltTaaTriListVO){
		this. rsltTaaTriListVO = rsltTaaTriListVO;
	}

	public RsltTaaTriListVO getRsltTaaTriListVO(){
		return rsltTaaTriListVO;
	}

    /**
     * @return the rsltTaaMnVO
     */
    public RsltTaaMnVO getRsltTaaMnVO () {
        return rsltTaaMnVO;
    }

    /**
     * @param rsltTaaMnVO the rsltTaaMnVO to set
     */
    public void setRsltTaaMnVO (RsltTaaMnVO rsltTaaMnVO) {
        this.rsltTaaMnVO = rsltTaaMnVO;
    }



}