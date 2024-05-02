/*=========================================================
 *Copyright(c) SMLines
 *@FileName : EsmBkg0013Event.java
 *@FileTitle : CRN Delete
 *Open Issues :
 *Change history :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event;

import java.util.Arrays;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVslCrnNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_N011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_N011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 
 * @see ESM_BKG_N011HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkgN011Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO = null;
	private CndCstmsVslCrnNoVO[] cndCstmsVslCrnNoVOs = null;
	/**
	 * @return the cndCstmsVslCrnNoVO
	 */
	public CndCstmsVslCrnNoVO getCndCstmsVslCrnNoVO() {
		return cndCstmsVslCrnNoVO;
	}
	/**
	 * @param cndCstmsVslCrnNoVO the cndCstmsVslCrnNoVO to set
	 */
	public void setCndCstmsVslCrnNoVO(CndCstmsVslCrnNoVO cndCstmsVslCrnNoVO) {
		this.cndCstmsVslCrnNoVO = cndCstmsVslCrnNoVO;
	}
	/**
	 * @return the cndCstmsVslCrnNoVOs
	 */
	public CndCstmsVslCrnNoVO[] getCndCstmsVslCrnNoVOs() {
		CndCstmsVslCrnNoVO[] rtnVOs = null;
		if (this.cndCstmsVslCrnNoVOs != null) {
			rtnVOs = Arrays.copyOf(cndCstmsVslCrnNoVOs, cndCstmsVslCrnNoVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param cndCstmsVslCrnNoVOs the cndCstmsVslCrnNoVOs to set
	 */
	public void setCndCstmsVslCrnNoVOs(CndCstmsVslCrnNoVO[] cndCstmsVslCrnNoVOs){
		if(cndCstmsVslCrnNoVOs != null){
			CndCstmsVslCrnNoVO[] tmpVOs = Arrays.copyOf(cndCstmsVslCrnNoVOs, cndCstmsVslCrnNoVOs.length);
			this.cndCstmsVslCrnNoVOs = tmpVOs;
		}
	}

	
	
}