/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri3017Event.java
*@FileTitle : TAA Creation & Amendment [Amend]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.12.01 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.event;

import com.hanjin.apps.alps.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTaaMnVO;


/**
 * ESM_PRI_3017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_3017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltTaaMnVO rsltTaaMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTaaMnVO[] priTaaMnVOs = null;

	public EsmPri3017Event(){}
	
	public void setPriTaaMnVOS(PriTaaMnVO[] priTaaMnVOs){
		this. priTaaMnVOs = priTaaMnVOs;
	}

	public PriTaaMnVO[] getPriTaaMnVOS(){
		return priTaaMnVOs;
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