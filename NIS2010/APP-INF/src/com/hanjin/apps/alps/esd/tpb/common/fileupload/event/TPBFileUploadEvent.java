/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBFileUploadEvent.java
*@FileTitle : 3자구상 파일업로드 공통팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2009-08-20 O Wan-Ki  1.0 최초생성
* 2009-12-02 Sun, CHOI 1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.fileupload.event;

import java.util.Collection;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.tpb.common.fileupload.vo.CreateUploadFileInfoVO;


/**
 * TPBFileUpload 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - TPBFileUploadHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun, CHOI
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class TPBFileUploadEvent extends EventSupport {

	/** tpb_ttl_file_mgmt Table  Value Object */
	private CreateUploadFileInfoVO tpbTtlFileMgmt = null;

	/** tpb_ttl_file_mgmts Multi Action을 위한 Collection */
	private Collection tpbTtlFileMgmts = null;

	/**
	 * 
	 */
	public TPBFileUploadEvent(){}

	/**
	 * @param tpb_ttl_file_mgmt
	 */
	public TPBFileUploadEvent(CreateUploadFileInfoVO tpb_ttl_file_mgmt) {
		this.tpbTtlFileMgmt = tpb_ttl_file_mgmt;
    }

	/**
	 * @param tpb_ttl_file_mgmt
	 * @param tpb_ttl_file_mgmts
	 */
	public TPBFileUploadEvent(CreateUploadFileInfoVO tpb_ttl_file_mgmt, Collection tpb_ttl_file_mgmts) {
		this.tpbTtlFileMgmt = tpb_ttl_file_mgmt;
		this.tpbTtlFileMgmts = tpb_ttl_file_mgmts;
    }

	/**
	 * @param tpb_ttl_file_mgmts
	 */
	public TPBFileUploadEvent(Collection tpb_ttl_file_mgmts) {
		this.tpbTtlFileMgmts = tpb_ttl_file_mgmts;
    }

	/**
	 * @return
	 */
	public CreateUploadFileInfoVO getTPB_TTL_FILE_MGMT(){
		return tpbTtlFileMgmt;
	}

	/**
	 * @return
	 */
	public Collection getTPB_TTL_FILE_MGMTS(){
		return tpbTtlFileMgmts;
	}

	/**
	 * @return
	 */
	public String getEventName() {
		return "TPBFileUploadEvent";
	}

	/**
	 * @return
	 */
	public String toString() {
		return "TPBFileUploadEvent";
	}

}
