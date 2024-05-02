/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg007904Event.java
*@FileTitle : Container Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.19 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCustShpRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;


/**
 * ESM_BKG_0079_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0079_04HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see ESM_BKG_0079_04HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1134Event extends EventSupport {

	private static final long serialVersionUID = 1L;


	/** Table Value Object 조회 조건 및 단건 처리  */
    private BkgCustShpRqstVO bkgCustShpRqstVO = null;
	/** Table Value Object Multi Data 처리 */
	private BkgCustShpRqstVO[] bkgCustShpRqstVOs = null; 


    public EsmBkg1134Event(){}


    /**
     * @return the bkgCustShpRqstVO
     */
    public BkgCustShpRqstVO getBkgCustShpRqstVO() {
        return bkgCustShpRqstVO;
    }

    /**
     * @param bkgCustShpRqstVO 
     */
    public void setBkgCustShpRqstVO(BkgCustShpRqstVO bkgCustShpRqstVO) {
        this.bkgCustShpRqstVO = bkgCustShpRqstVO;
    }
    /**
     * @param bkgCustShpRqstVOs 
     */
    public void setBkgCustShpRqstVOs(BkgCustShpRqstVO[] bkgCustShpRqstVOs){
		this. bkgCustShpRqstVOs = bkgCustShpRqstVOs;
	}
    /**
     * @param bkgCustShpRqstVOs 
     * @return BkgCustShpRqstVO[]
     */
    public BkgCustShpRqstVO[] getBkgCustShpRqstVOs(){
		return bkgCustShpRqstVOs;
	}

    

}