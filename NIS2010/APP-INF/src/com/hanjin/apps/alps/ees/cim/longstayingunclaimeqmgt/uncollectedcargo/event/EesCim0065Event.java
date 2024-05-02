/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim0065Event.java
*@FileTitle : UC File Upload
*Open Issues :
*Change history : 
*@LastModifyDate : 2014.07.04
*@LastModifier : DO-HYUN KIM
*@LastVersion : 1.0
* 2014.07.04
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event;

import java.util.Collection;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.CreateUploadFileInfoVO;


/**
 * EES_CIM_0065 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_0065HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author DO-HYUN KIM
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesCim0065Event extends EventSupport {

	/** uc_ttl_file_mgmt Table  Value Object */
	private CreateUploadFileInfoVO ucTtlFileMgmt = null;

	/** uc_ttl_file_mgmts Multi Action을 위한 Collection */
	private Collection ucTtlFileMgmts = null;

	/**
	 * 
	 */
	public EesCim0065Event(){}

	/**
	 * @param uc_ttl_file_mgmt
	 */
	public EesCim0065Event(CreateUploadFileInfoVO uc_ttl_file_mgmt) {
		this.ucTtlFileMgmt = uc_ttl_file_mgmt;
    }

	/**
	 * @param uc_ttl_file_mgmt
	 * @param uc_ttl_file_mgmts
	 */
	public EesCim0065Event(CreateUploadFileInfoVO uc_ttl_file_mgmt, Collection uc_ttl_file_mgmts) {
		this.ucTtlFileMgmt = uc_ttl_file_mgmt;
		this.ucTtlFileMgmts = uc_ttl_file_mgmts;
    }

	/**
	 * @param uc_ttl_file_mgmts
	 */
	public EesCim0065Event(Collection uc_ttl_file_mgmts) {
		this.ucTtlFileMgmts = uc_ttl_file_mgmts;
    }

	/**
	 * @return
	 */
	public CreateUploadFileInfoVO getCIM_TTL_FILE_MGMT(){
		return ucTtlFileMgmt;
	}

	/**
	 * @return
	 */
	public Collection getCIM_TTL_FILE_MGMTS(){
		return ucTtlFileMgmts;
	}

	/**
	 * @return
	 */
	public String getEventName() {
		return "EesCim0065Event";
	}

	/**
	 * @return
	 */
	public String toString() {
		return "EesCim0065Event";
	}

}
