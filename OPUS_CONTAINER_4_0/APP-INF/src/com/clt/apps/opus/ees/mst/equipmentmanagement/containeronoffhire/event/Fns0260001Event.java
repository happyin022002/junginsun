/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Fns0260001Event.java
 *@FileTitle : F/A I/F(From ERP)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.02
 *@LastModifier : 이호선
 *@LastVersion : 1.0
 * 2009.09.02 이호선
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event;

import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterUpdateIFVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.FaCntrListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * Fns0260001Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - 작성된곳 없음<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Lee Ho Sun
 * @see 참조 없음
 * @since J2EE 1.6
 */

public class Fns0260001Event extends EventSupport {

	/**
	 * @return the faCntrListVO
	 */
	public FaCntrListVO getFaCntrListVO() {
		return faCntrListVO;
	}

	/**
	 * @param faCntrListVO
	 *            the faCntrListVO to set
	 */
	public void setFaCntrListVO(FaCntrListVO faCntrListVO) {
		this.faCntrListVO = faCntrListVO;
	}

	/**
	 * @return the faCntrListVOs
	 */
	public FaCntrListVO[] getFaCntrListVOs() {
		FaCntrListVO[] tmpVOs = null;
		if (this.faCntrListVOs != null) {
			tmpVOs = new FaCntrListVO[faCntrListVOs.length];
			System.arraycopy(faCntrListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;

	}

	/**
	 * @param faCntrListVOs
	 *            the faCntrListVOs to set
	 */
	public void setFaCntrListVOs(FaCntrListVO[] faCntrListVOs) {
		if (faCntrListVOs != null) {
			FaCntrListVO[] tmpVOs = new FaCntrListVO[faCntrListVOs.length];
			System.arraycopy(faCntrListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.faCntrListVOs = tmpVOs;
		}

	}

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private FaCntrListVO faCntrListVO = null;

	/** 검색리스트 처리 */
	private FaCntrListVO[] faCntrListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private CntrMasterUpdateIFVO cntrMasterUpdateIFVO = null;

	/**
	 * @return the cntrMasterUpdateIFVO
	 */
	public CntrMasterUpdateIFVO getCntrMasterUpdateIFVO() {
		return cntrMasterUpdateIFVO;
	}

	/**
	 * @param cntrMasterUpdateIFVO
	 *            the cntrMasterUpdateIFVO to set
	 */
	public void setCntrMasterUpdateIFVO(
			CntrMasterUpdateIFVO cntrMasterUpdateIFVO) {
		this.cntrMasterUpdateIFVO = cntrMasterUpdateIFVO;
	}

	/**
	 * @return the cntrMasterUpdateIFVOs
	 */
	public CntrMasterUpdateIFVO[] getCntrMasterUpdateIFVOs() {
		CntrMasterUpdateIFVO[] tmpVOs = null;
		if (this.cntrMasterUpdateIFVOs != null) {
			tmpVOs = new CntrMasterUpdateIFVO[cntrMasterUpdateIFVOs.length];
			System.arraycopy(cntrMasterUpdateIFVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;

	}

	/**
	 * @param cntrMasterUpdateIFVOs
	 *            the cntrMasterUpdateIFVOs to set
	 */
	public void setCntrMasterUpdateIFVOs(
			CntrMasterUpdateIFVO[] cntrMasterUpdateIFVOs) {
		if (cntrMasterUpdateIFVOs != null) {
			CntrMasterUpdateIFVO[] tmpVOs = new CntrMasterUpdateIFVO[cntrMasterUpdateIFVOs.length];
			System.arraycopy(cntrMasterUpdateIFVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrMasterUpdateIFVOs = tmpVOs;
		}

	}

	/** 검색리스트 처리 */
	private CntrMasterUpdateIFVO[] cntrMasterUpdateIFVOs = null;

}