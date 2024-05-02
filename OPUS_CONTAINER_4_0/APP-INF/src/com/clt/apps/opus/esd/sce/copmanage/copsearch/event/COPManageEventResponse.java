/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COPManageEventResponse.java
*@FileTitle : COPManage 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-25
*@LastModifier : Jongwon Park
*@LastVersion : 1.0
* 2006-09-25 Jongwon Park
* 1.0 ���� ��
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.event;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.event.EventResponseSupport;



/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - EsdSce0TEST_002 ��û; ó���� ���� ���� d��(DB ResultSet)�� ��: Data Transfer Object<br>
 * - EsdSce0TEST_002 ȣ��� ����� View(JSP) Layer�� Argument ���·� ��ȯ<br>
 *
 * @author Jongwon Park
 * @see COPManageSC ��v
 * @since J2EE 1.4
 */
@SuppressWarnings("deprecation")
public class COPManageEventResponse extends EventResponseSupport {
	private static final long serialVersionUID = 1L;

	// Database ResultSet
	private DBRowSet   rowSet;

	// Success Flag
	private String successFlag;

	/**
	 * COPManageEventResponse ��ü�� ��
	 */
	public COPManageEventResponse() {
	}

	/**
	 * COPManage ��û; ���(DB ResultSet)�� ��� COPManageEventResponse ��ü�� ��
	 * 
	 * @param rowSet ���� ���� ���
	 */
	public COPManageEventResponse(DBRowSet rowSet) {
		this.rowSet = rowSet;
	}

	/**
	 * COPManage ��û; (DB ResultSet)�� �����(successFlag)�� ��� COPManageEventResponse ��ü�� ��
	 * 
	 * @param rowSet ���� ���� ���
	 * @param successFlag �����
	 */
	public COPManageEventResponse(DBRowSet rowSet, String successFlag) {
		this.rowSet=rowSet;
		this.successFlag=successFlag;
	}

	/**
	 * DB ResultSet ��ȯ�۾�
	 * 
	 * @return DBRowSet ���� ���� ���
	 */
	public DBRowSet getRs() {
		return this.rowSet;
	}

	/**
	 * return SuccessFlg
	 */
	public String getSuccessFlag() {
		return this.successFlag ;
	}

	/**
	 * ��ü ǥ�� ���ڿ�(COPManageEventResponse); ��ȯ
	 * 
	 * @return String COPManageEventResponse
	 */
	public String toString() {
		return "COPManageEventResponse";
	}

	/**
	 * �̺�Ʈ ��(COPManageEventResponse); ��ȯ
	 * 
	 * @return String COPManageEventResponse
	 */
	public String getEventName() {
		return "COPManageEventResponse";
	}

}