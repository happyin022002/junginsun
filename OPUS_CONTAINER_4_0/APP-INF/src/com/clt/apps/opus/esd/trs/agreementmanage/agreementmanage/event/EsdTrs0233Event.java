/*=========================================================
 *@FileName : ESD_TRS_0233Event.java
 *@FileTitle : Agreement Header
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-05-17
 *@LastModifier : pjy
 *@LastVersion : 1.0
 * 2010-05-17 pjy
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import java.util.HashMap;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0233 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0233HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0233Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String comboSvcProvider		= null;	
	private String agmtRefNo			= null;
	private String ctrtOfcCd			= null;
	private String agmtNo   			= null;
	
	public EsdTrs0233Event(){}
	
	public String getComboSvcProvider() {
		return comboSvcProvider;
	}

	public void setComboSvcProvider(String comboSvcProvider) {
		this.comboSvcProvider = comboSvcProvider;
	}

	public String getAgmtRefNo() {
		return agmtRefNo;
	}

	public void setAgmtRefNo(String agmtRefNo) {
		this.agmtRefNo = agmtRefNo;
	}

	public String getCtrtOfcCd() {
		return ctrtOfcCd;
	}

	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
	}

	public String getAgmtNo() {
		return agmtNo;
	}

	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}

	/**	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		
		this.hashColumns.put("comboSvcProvider", 	this.getComboSvcProvider());
		this.hashColumns.put("agmtRefNo", 			this.getAgmtRefNo());
		this.hashColumns.put("ctrtOfcCd", 			this.getCtrtOfcCd());
		return this.hashColumns;
	}

	public String getEventName() {
		return "EsdTrs0233Event";
	}

	public String toString() {
		return "EsdTrs0233Event";
	}
}
