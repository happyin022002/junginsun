/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg1509Event.java
 *@FileTitle : Customer Code Setup for B/L Image
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.06
 *@LastModifier : 차상영
 *@LastVersion : 1.0
 * 2009.12.24 차상영
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event;
     

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.DraftBlImageVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1509에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1509HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Cha Sangyoung
 * @see ESM_BKG_1509HTMLAction 참조
 * @since J2EE 1.6
 */
   
public class EsmBkg1509Event extends EventSupport {

    private static final long serialVersionUID = 1L;

    private DraftBlImageVO draftBlImageVO = null;
    private DraftBlImageVO[] draftBlImageVOs = null;
    
    public EsmBkg1509Event() {}

	public DraftBlImageVO getDraftBlImageVO() {
		return draftBlImageVO;
	}

	public void setDraftBlImageVO(DraftBlImageVO draftBlImageVO) {
		this.draftBlImageVO = draftBlImageVO;
	}

	public DraftBlImageVO[] getDraftBlImageVOs() {
		return draftBlImageVOs;
	}

	public void setDraftBlImageVOs(DraftBlImageVO[] draftBlImageVOs) {
		this.draftBlImageVOs = draftBlImageVOs;
	}
	        
}