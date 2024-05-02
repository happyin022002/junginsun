/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MstComEvent.java
 *@FileTitle : MST COMMON PAGE
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 이호선
 *@LastVersion : 1.0
 * 2009.06.18 이호선
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.event;

import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.AgmtInfoVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.ComboInitDataINVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * MST_COM 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - MST_COMHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Lee Ho Sun
 * @see MST_COMHTMLAction 참조
 * @since J2EE 1.6
 */

public class MstComEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private CommonListVO commonListVO = null;

	/** Table Value Object Multi Data 처리 */
	private CommonListVO[] commonListVOs = null;
	private ComboInitDataINVO[] comboInitDataINVOS = null; // SECRETWEAPON

	/** INTG CD ID 조회 조건 **/
	private String intgCdId = "";

	/** INTG CD VAL 조회 조건 **/
	private String intgCdVal = "";

	/** UserSearch 조회 조건 **/
	private String inputUser = ""; 
	/**
	 * @return the commonListVOs
	 */
	public CommonListVO[] getCommonListVOs() {
		CommonListVO[] tmpVOs = null;
		if (this.commonListVOs != null) {
			tmpVOs = new CommonListVO[commonListVOs.length];
			System.arraycopy(commonListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;

	}

	/**
	 * @param commonListVOs
	 *            the commonListVOs to set
	 */
	public void setCommonListVOs(CommonListVO[] commonListVOs) {
		if (commonListVOs != null) {
			CommonListVO[] tmpVOs = new CommonListVO[commonListVOs.length];
			System.arraycopy(commonListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.commonListVOs = tmpVOs;
		}

	}

	/**
	 * @return the agmtInfoVO
	 */
	public AgmtInfoVO getAgmtInfoVO() {
		return agmtInfoVO;
	}

	/**
	 * @param agmtInfoVO
	 *            the agmtInfoVO to set
	 */
	public void setAgmtInfoVO(AgmtInfoVO agmtInfoVO) {
		this.agmtInfoVO = agmtInfoVO;
	}

	/**
	 * @return the agmtInfoVOs
	 */
	public AgmtInfoVO[] getAgmtInfoVOs() {
		AgmtInfoVO[] tmpVOs = null;
		if (this.agmtInfoVOs != null) {
			tmpVOs = new AgmtInfoVO[agmtInfoVOs.length];
			System.arraycopy(agmtInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;

	}

	/**
	 * @param agmtInfoVOs
	 *            the agmtInfoVOs to set
	 */
	public void setAgmtInfoVOs(AgmtInfoVO[] agmtInfoVOs) {
		if (agmtInfoVOs != null) {
			AgmtInfoVO[] tmpVOs = new AgmtInfoVO[agmtInfoVOs.length];
			System.arraycopy(agmtInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.agmtInfoVOs = tmpVOs;
		}

	}

	private AgmtInfoVO agmtInfoVO = null;

	private AgmtInfoVO[] agmtInfoVOs = null;

	public MstComEvent() {
	}

	public void setCommonListVO(CommonListVO commonListVO) {
		this.commonListVO = commonListVO;
	}

	public void setCommonListVOS(CommonListVO[] commonListVOs) {
		if (commonListVOs != null) {
			CommonListVO[] tmpVOs = new CommonListVO[commonListVOs.length];
			System.arraycopy(commonListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.commonListVOs = tmpVOs;
		}

	}

	public CommonListVO getCommonListVO() {
		return commonListVO;
	}

	public CommonListVO[] getCommonListVOS() {
		CommonListVO[] tmpVOs = null;
		if (this.commonListVOs != null) {
			tmpVOs = new CommonListVO[commonListVOs.length];
			System.arraycopy(commonListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;

	}

	public ComboInitDataINVO[] getComboInitDataINVOS() {
		ComboInitDataINVO[] tmpVOs = null;
		if (this.comboInitDataINVOS != null) {
			tmpVOs = new ComboInitDataINVO[comboInitDataINVOS.length];
			System.arraycopy(comboInitDataINVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;

	}

	public void setComboInitDataINVOS(ComboInitDataINVO[] comboInitDataINVOS) {
		if (comboInitDataINVOS != null) {
			ComboInitDataINVO[] tmpVOs = new ComboInitDataINVO[comboInitDataINVOS.length];
			System.arraycopy(comboInitDataINVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.comboInitDataINVOS = tmpVOs;
		}

	}

	public String getIntgCdId() {
		return intgCdId;
	}

	public void setIntgCdVal(String intgCdVal) {
		this.intgCdVal = intgCdVal;
	}

	public String getIntgCdVal() {
		return intgCdVal;
	}

	public void setIntgCdId(String intgCdId) {
		this.intgCdId = intgCdId;
	}

	public String getInputUser() {
		return inputUser;
	}

	public void setInputUser(String inputUser) {
		this.inputUser = inputUser;
	}
}