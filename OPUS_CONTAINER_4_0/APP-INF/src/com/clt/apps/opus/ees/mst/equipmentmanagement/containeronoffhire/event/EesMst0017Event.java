/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0017Event.java
*@FileTitle : Own Container Interface to ERP FA
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.12 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.FaTargetListVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
/**
 * EES_MST_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MstEtcVO mstEtcVO = null;
	
	/** 검색리스트 처리  */
	private FaTargetListVO[] faTargetListVOs = null;
	
	/**
	 * @return the mstEtcVO
	 */
	public MstEtcVO getMstEtcVO() {
		return mstEtcVO;
	}

	/**
	 * @return the faTargetListVOs
	 */
	public FaTargetListVO[] getFaTargetListVOs() {
		FaTargetListVO[] tmpVOs = null;
		  if (this.faTargetListVOs != null) {
		   tmpVOs = new FaTargetListVO[faTargetListVOs.length];
		   System.arraycopy(faTargetListVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}

	/**
	 * @param faTargetListVOs the faTargetListVOs to set
	 */
	public void setFaTargetListVOs(FaTargetListVO[] faTargetListVOs) {
		  if (faTargetListVOs != null) {
			  FaTargetListVO[] tmpVOs = new FaTargetListVO[faTargetListVOs.length];
			   System.arraycopy(faTargetListVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.faTargetListVOs = tmpVOs;
			  }

	}

	/**
	 * @param mstEtcVO the mstEtcVO to set
	 */
	public void setMstEtcVO(MstEtcVO mstEtcVO) {
		this.mstEtcVO = mstEtcVO;
	}
}