/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdSce0090EventResponse.java
*@FileTitle : EsdSce0090
*Open Issues :
*Change history :
*@LastModifyDate : 2008-04-14
*@LastModifier : sanghyun_kim
*@LastVersion : 1.0
* 2008-04-14 sanghyun_kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.event.EventResponseSupport;

/**
 * EsdSce0090 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author sanghyun_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

@SuppressWarnings("deprecation")
public class EsdSce0090EventResponse extends EventResponseSupport {
	private static final long serialVersionUID = 1L;
	private DBRowSet rowSet = null;
	private String successFlag;
	
	 /**
     * @param rowSet_
     */
	public EsdSce0090EventResponse(DBRowSet rowSet_){
        this.rowSet = rowSet_;
    }
	
	/**
     * @param rowSet
     * @param successFlag
     */
	public EsdSce0090EventResponse(DBRowSet rowSet, String successFlag) {
		this.rowSet=rowSet;
		this.successFlag=successFlag;
	}
	
	/**
	 * @return Returns the EsdSce0090EventResponse.
	 */
	public String toString() {
        return "EsdSce0090EventResponse";
    }
	
	/**
	 * @return Returns EsdSce0090EventResponse.
	 */
	public String getEventName() {
        return "EsdSce0090EventResponse";
    }
	
	/**
	 * @return Returns the successFlag.
	 */
	public String getSuccessFlag() {
		return successFlag;
	}

	/**
     * @param successFlag
     */
	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}
	
	/**
	 * @return Returns the rowSet.
	 */
	public DBRowSet getRowSet() {
		return rowSet;
	}

	/**
	 * @param Returns the cnt.
	 */
	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
}
