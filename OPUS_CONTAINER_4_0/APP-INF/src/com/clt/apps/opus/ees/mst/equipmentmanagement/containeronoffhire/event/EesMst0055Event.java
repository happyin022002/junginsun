/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesMst0055Event.java
*@FileTitle : ERP FA Interface - Container List
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.FACntrListInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.MstEtcVO;
/**
 * EES_MST_0055 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0055HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_MST_0055HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0055Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MstEtcVO mstEtcVO = null;
	
	/** 검색리스트 처리  */
	private FACntrListInfoVO[] fACntrListInfoVOs = null;
	
	/**
	 * @return the mstEtcVO
	 */
	public MstEtcVO getMstEtcVO() {
		return mstEtcVO;
	}

	/**
	 * @return the fACntrListInfoVOs
	 */
	public FACntrListInfoVO[] getFACntrListInfoVOs() {
		FACntrListInfoVO[] tmpVOs = null;
		  if (this.fACntrListInfoVOs != null) {
		   tmpVOs = new FACntrListInfoVO[fACntrListInfoVOs.length];
		   System.arraycopy(fACntrListInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
		  }
		  return tmpVOs;

	}

	/**
	 * @param fACntrListInfoVOs the fACntrListInfoVOs to set
	 */
	public void setFACntrListInfoVOs(FACntrListInfoVO[] fACntrListInfoVOs) {
		  if (fACntrListInfoVOs != null) {
			  FACntrListInfoVO[] tmpVOs = new FACntrListInfoVO[fACntrListInfoVOs.length];
			   System.arraycopy(fACntrListInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			   this.fACntrListInfoVOs = tmpVOs;
			  }

	}

	/**
	 * @param mstEtcVO the mstEtcVO to set
	 */
	public void setMstEtcVO(MstEtcVO mstEtcVO) {
		this.mstEtcVO = mstEtcVO;
	}
}