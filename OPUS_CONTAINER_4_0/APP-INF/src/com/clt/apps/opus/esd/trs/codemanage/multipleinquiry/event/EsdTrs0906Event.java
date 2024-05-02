/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_906Event.java
*@FileTitle : Multiple Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-13 juhyun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.multipleinquiry.event;

import java.util.Collection;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.COM_USER;


/**
 * ESD_TRS_906 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_906HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0906Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** com_user Table  Value Object */
	private COM_USER mdmYd   = null;

	/** com_users Multi Action을 위한 Collection */
	private Collection mdmYds = null;

	/** ESD_TRS_906Event */
	public EsdTrs0906Event(){}

	/** ESD_TRS_906Event 
	 * 
	 * @param mdmYd
	 */
	public EsdTrs0906Event(COM_USER mdmYd) {
		this.mdmYd = mdmYd;
    }

	/** ESD_TRS_906Event 
	 * 
	 * @param mdmYd
	 * @param mdmYds
	 */
	public EsdTrs0906Event(COM_USER mdmYd, Collection mdmYds) {
		this.mdmYd = mdmYd;
		this.mdmYds = mdmYds;
    }

	/** getMDM_YD 
	 * @return */
	public COM_USER getMDM_YD(){
		return mdmYd;
	}

	/** getMDM_YDS 
	 * @return */
	public Collection getMDM_YDS(){
		return mdmYds;
	}

	/** getEventName */
	public String getEventName() {
		return "EsdTrs0906Event";
	}

	/** toString */
	public String toString() {
		return "EsdTrs0906Event";
	}

}
