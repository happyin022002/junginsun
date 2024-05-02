/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : EsmFms0096Event.java
 *@FileTitle : Owner's Account
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.02.18
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2016.02.18 민정호
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrAcctVO;

/**
 * ESM_FMS_0095 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_FMS_0095HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Son, Jin-Hwan
 * @see ESM_FMS_0095HTMLAction 참조 
 * @since J2EE 1.6
 */

public class EsmFms0096Event extends EventSupport {	
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	OwnrAcctVO ownrAcctVO = null;

	/** Table Value Object Multi Data 처리 */
	OwnrAcctVO[] ownrAcctVOs = null;

	public EsmFms0096Event() {
	}

	public void setOwnrAcctVO(OwnrAcctVO ownrAcctVO) {
		this.ownrAcctVO = ownrAcctVO;
	}

	public void setOwnrAcctVOs(OwnrAcctVO[] ownrAcctVOs) {
		if (ownrAcctVOs != null) {
			OwnrAcctVO[] tmpVOs = Arrays.copyOf(ownrAcctVOs,
					ownrAcctVOs.length);
			this.ownrAcctVOs = tmpVOs;
		}
	}
	
	public OwnrAcctVO getOwnrAcctVO() {
		return ownrAcctVO;
	}

	public OwnrAcctVO[] getOwnrAcctVOs() {
		OwnrAcctVO[] tmpVOs = null;
		if (this.ownrAcctVOs != null) {
			tmpVOs = Arrays.copyOf(ownrAcctVOs,
					ownrAcctVOs.length);
		}
		return tmpVOs;
	}
}