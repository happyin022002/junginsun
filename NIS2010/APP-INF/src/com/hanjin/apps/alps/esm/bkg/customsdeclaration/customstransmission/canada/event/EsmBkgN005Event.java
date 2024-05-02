/*=========================================================
 *Copyright(c) SMLines. All Rights Reserved.
 *@FileName : EsmBkgN005Event.java
 *@FileTitle : EsmBkgN005Event
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndHisListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsSndHisVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1530에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1530HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1530HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkgN005Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private CndCstmsSndHisListCondVO cndCstmsSndHisListCondVO = null;

	/** Receive History Log 결과리스트 */
	private CndCstmsSndHisVO[] cndCstmsSndHisVOs = null;


	public EsmBkgN005Event() {}


	public void setCndCstmsSndHisListCondVO(CndCstmsSndHisListCondVO cndCstmsSndHisListCondVO) {
		this.cndCstmsSndHisListCondVO = cndCstmsSndHisListCondVO;
	}

	public void setCndCstmsSndHisVOs(CndCstmsSndHisVO[] cndCstmsSndHisVOs) {
		if (cndCstmsSndHisVOs != null)
			this.cndCstmsSndHisVOs = Arrays.copyOf(cndCstmsSndHisVOs, cndCstmsSndHisVOs.length);;
	}

	public CndCstmsSndHisListCondVO getCndCstmsSndHisListCondVO() {
		return cndCstmsSndHisListCondVO;
	}

	public CndCstmsSndHisVO[] getCndCstmsSndHisVOs() {
		CndCstmsSndHisVO[] rtnVOs = null;
		if (cndCstmsSndHisVOs != null)
			rtnVOs = Arrays.copyOf(cndCstmsSndHisVOs, cndCstmsSndHisVOs.length);
		return rtnVOs;
	}


}
