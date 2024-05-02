/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0036Event.java
 *@FileTitle : Yard별 CCT
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-09
 *@LastModifier : Jeongseon An
 *@LastVersion : 1.0
 * 2009-06-08 Jeongseon An
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.event;

import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.vo.NewCCTManageVO;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.vo.PrdCstSkdByPortVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Jeongseon An
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0036Event extends EventSupport {
	private static final long serialVersionUID = 6333237295305704560L;
	private NewCCTManageVO newCCTManageVO;
	private NewCCTManageVO[] newCCTManageVOs;

	private PrdCstSkdByPortVO prdCstSkdByPortVO = null;
	private PrdCstSkdByPortVO[] prdCstSkdByPortVOs = null;

	/**
	 * @return the NewCCTManageVO
	 */
	public NewCCTManageVO getNewCCTManageVO() {
		return newCCTManageVO;
	}

	/**
	 * @param NewCCTManageVO the NewCCTManageVO to set
	 */
	public void setNewCCTManageVO(NewCCTManageVO NewCCTManageVO) {
		this.newCCTManageVO = NewCCTManageVO;
	}

	/**
	 * @return the newCCTManageVOs
	 */
	public NewCCTManageVO[] getNewCCTManageVOs() {
		NewCCTManageVO[] tmpVOs = null;
		if (this.newCCTManageVOs != null) {
			tmpVOs = new NewCCTManageVO[this.newCCTManageVOs.length];
			System.arraycopy(this.newCCTManageVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * @param newCCTManageVOs the newCCTManageVOs to set
	 */
	public void setNewCCTManageVOs(NewCCTManageVO[] newCCTManageVOs) {
		if (newCCTManageVOs != null) {
			NewCCTManageVO[] tmpVOs = new NewCCTManageVO[newCCTManageVOs.length];
			System.arraycopy(newCCTManageVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.newCCTManageVOs = tmpVOs;
		}
	}

	public PrdCstSkdByPortVO getPrdCstSkdByPortVO() {
		return prdCstSkdByPortVO;
	}

	public void setPrdCstSkdByPortVO(PrdCstSkdByPortVO prdCstSkdByPortVO) {
		this.prdCstSkdByPortVO = prdCstSkdByPortVO;
	}

	/**
	 * 
	 * @return
	 */
	public PrdCstSkdByPortVO[] getPrdCstSkdByPortVOs() {
		PrdCstSkdByPortVO[] tmpVOs = null;
		if (this.prdCstSkdByPortVOs != null) {
			tmpVOs = new PrdCstSkdByPortVO[this.prdCstSkdByPortVOs.length];
			System.arraycopy(this.prdCstSkdByPortVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param prdCstSkdByPortVOs
	 */
	public void setPrdCstSkdByPortVOs(PrdCstSkdByPortVO[] prdCstSkdByPortVOs) {
		if (prdCstSkdByPortVOs != null) {
			PrdCstSkdByPortVO[] tmpVOs = new PrdCstSkdByPortVO[prdCstSkdByPortVOs.length];
			System.arraycopy(prdCstSkdByPortVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.prdCstSkdByPortVOs = tmpVOs;
		}
	}

}
