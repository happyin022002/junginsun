/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg036702Event.java
*@FileTitle : ESM_BKG_0367_02
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.16
*@LastModifier : Kim Tae Kyun
*@LastVersion : 1.0
* 2014.12.16 Kim Tae Kyun
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ExportReferencesVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0367_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  esm_bkg_0367_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see esm_bkg_0367_02HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg036702Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ExportReferencesVO exportReferencesVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ExportReferencesVO[] exportReferencesVOs = null;

	/**
	 * @return the exportReferencesVO
	 */
	public ExportReferencesVO getExportReferencesVO() {
		return exportReferencesVO;
	}

	/**
	 * @return the exportReferencesVOs
	 */
	public ExportReferencesVO[] getExportReferencesVOs() {
		ExportReferencesVO[] tmpVOs = null;
		if (this. exportReferencesVOs != null) {
			tmpVOs = Arrays.copyOf(exportReferencesVOs, exportReferencesVOs .length);
		}
		return tmpVOs;
	}

	/**
	 * @param exportReferencesVO the exportReferencesVO to set
	 */
	public void setExportReferencesVO(ExportReferencesVO exportReferencesVO) {
		this.exportReferencesVO = exportReferencesVO;
	}

	/**
	 * @param exportReferencesVOs the exportReferencesVOs to set
	 */
	public void setExportReferencesVOs(ExportReferencesVO[] exportReferencesVOs) {
		if (exportReferencesVOs != null) {
			ExportReferencesVO[] tmpVOs = Arrays.copyOf(exportReferencesVOs, exportReferencesVOs .length);
			this. exportReferencesVOs = tmpVOs;
		}
	}
}