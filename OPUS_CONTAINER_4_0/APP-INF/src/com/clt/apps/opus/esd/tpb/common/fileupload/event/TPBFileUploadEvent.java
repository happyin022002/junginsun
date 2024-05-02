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
package com.clt.apps.opus.esd.tpb.common.fileupload.event;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.clt.apps.opus.esd.tpb.common.fileupload.vo.CreateUploadFileInfoVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TpbTtlFileMgmtVO;


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
	
	private List<String> keys = null;
	private TpbTtlFileMgmtVO[] tpbTtlFileMgmtVOs	= null;

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

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	public TpbTtlFileMgmtVO[] getTpbTtlFileMgmtVOs() {
		TpbTtlFileMgmtVO[] rtnVOs = null;
		if (this.tpbTtlFileMgmtVOs != null) {
			rtnVOs = Arrays.copyOf(tpbTtlFileMgmtVOs, tpbTtlFileMgmtVOs.length);
		}
		return rtnVOs;
		
	}

	public void setTpbTtlFileMgmtVOs(TpbTtlFileMgmtVO[] tpbTtlFileMgmtVOs) {
		if(tpbTtlFileMgmtVOs != null){
			TpbTtlFileMgmtVO[] tmpVOs = Arrays.copyOf(tpbTtlFileMgmtVOs, tpbTtlFileMgmtVOs.length);
			this.tpbTtlFileMgmtVOs = tmpVOs;
		}
		
	}


}
