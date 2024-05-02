/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : EsdTrs0237Event.java
*@FileTitle      : Common Surcharge Management
*Open Issues     : 
*Change history  : 
*@LastModifyDate : 2014-11-05
*@LastModifier   : Hyungwook Choi
*@LastVersion    : 1.0
* 2014-11-05 Hyungwook Choi
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.AgmtAttachFileListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0237 에 대한 PDTO(Data Transfer Object including Parameters)
 * - ESD_TRS_0237HTMLAction 에서 작성
 * - ServiceCommand Layer 로 전달하는 PDTO 로 사용
 * @author Hyungwook Choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0238Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private AgmtAttachFileListVO agmtAttachFileListVO = null;
	private AgmtAttachFileListVO[] agmtAttachFileListVOs = null;
	private String[] keys = null;
	private String agmtNo = null;
	private String usrId = null;
	private String ofcCd = null;
	
	public AgmtAttachFileListVO getAgmtAttachFileListVO() {
		return agmtAttachFileListVO;
	}

	public void setAgmtAttachFileListVO(AgmtAttachFileListVO agmtAttachFileListVO) {
		this.agmtAttachFileListVO = agmtAttachFileListVO;
	}

	public String[] getKeys() {
		String[] rtnVOs = null;
    	if (this.keys != null) {
    		rtnVOs = Arrays.copyOf(keys, keys.length);
    	} // end if
        return rtnVOs;
	}

	public void setKeys(String[] keys) {
		if (keys != null) {
			String[] tmpVOs = Arrays.copyOf(keys, keys.length);
	        this.keys = tmpVOs;
		} // end if
	}
	
	public AgmtAttachFileListVO[] getAgmtAttachFileListVOs() {
		AgmtAttachFileListVO[] rtnVOs = null;
    	if (this.agmtAttachFileListVOs != null) {
    		rtnVOs = Arrays.copyOf(agmtAttachFileListVOs, agmtAttachFileListVOs.length);
    	} // end if
        return rtnVOs;
	}

	public void setAgmtAttachFileListVOs(
			AgmtAttachFileListVO[] agmtAttachFileListVOs) {
		if (agmtAttachFileListVOs != null) {
			AgmtAttachFileListVO[] tmpVOs = Arrays.copyOf(agmtAttachFileListVOs, agmtAttachFileListVOs.length);
            this.agmtAttachFileListVOs = tmpVOs;
    	} // end if
	}

	public String getAgmtNo() {
		return agmtNo;
	}

	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
}
