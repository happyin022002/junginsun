/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdSce0073EventResponse.java
*@FileTitle : EsdSce0073
*Open Issues :
*Change history :
*@LastModifyDate : 2008-05-10
*@LastModifier : sanghyun-kim
*@LastVersion : 1.0
* 2008-05-10 sanghyun-kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import java.util.HashMap;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.support.layer.event.EventResponseSupport;

/**
 * EsdSce0073 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("deprecation")
public class EsdSce0073EventResponse extends EventResponseSupport  {
	private static final long serialVersionUID = 1L;
	private DBRowSet rowSet = null;
    private String resultCd = "";
    private int count = 0;
	private String custSts ;
    private String csGrpId = "";
    private String tpId = "";
    private String csDesc = "";
    private String ediSts = "";
	private String desc ;
	private int cnt = 0;
	private String successFlag;
	
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
	 * @param rowSet
     * @param successFlag
     */
	public EsdSce0073EventResponse(DBRowSet rowSet, String successFlag) {
		this.rowSet=rowSet;
		this.successFlag=successFlag;
	}
	/** 
     * @param rowSet_
     */
	public EsdSce0073EventResponse(DBRowSet rowSet_){
        this.rowSet = rowSet_;
    }
	
	/**
	 * @return Returns the rowSet.
	 */
	public DBRowSet getRowSet() {
        return rowSet;
    }
	/** 
     * @param count_
     */
	public EsdSce0073EventResponse(int count_){
		this.count = count_;
    }
	/** 
     * @param resultCd_
     */
	public EsdSce0073EventResponse(String resultCd_){
    	this.resultCd = resultCd_;
    }
	
	/**
	 * @return Returns the resultCd.
	 */
	public String getResultCd() {
		return resultCd;
	}
	/**
	 * @return Returns the EsdSce0073EventResponse.
	 */
	public String toString() {
        return "EsdSce0073EventResponse";
    }
	
	/**
	 * @return Returns the EsdSce0073EventResponse.
	 */
	public String getEventName() {
        return "EsdSce0073EventResponse";
    }
	
	/**
	 * Constructor
	 * @param map
	 * @param cnt
	 */
    public EsdSce0073EventResponse(HashMap<String, String> map, int cnt){
    	this.csGrpId = JSPUtil.getNull((String)map.get("cs_grp_id"));
        this.tpId	= JSPUtil.getNull((String)map.get("tp_id"));
        this.csDesc = JSPUtil.getNull((String)map.get("cs_desc"));
        this.ediSts = JSPUtil.getNull((String)map.get("edi_sts"));
    	this.cnt = cnt;
    }
    
	/**
	 * Constructor
	 * @param requestmap
	 */
	public EsdSce0073EventResponse(HashMap<String, String> requestmap){
		this.csGrpId = JSPUtil.getNull((String)requestmap.get("cs_grp_id"));
        this.tpId	= JSPUtil.getNull((String)requestmap.get("tp_id"));
        this.csDesc = JSPUtil.getNull((String)requestmap.get("cs_desc"));
        this.ediSts = JSPUtil.getNull((String)requestmap.get("edi_sts"));
    }

	/**
	 * @return Returns the custSts.
	 */
	public String getCust_sts() {
		return custSts;
	}
	
	/** 
     * @param custSts
     */
	public void setCust_sts(String custSts) {
		this.custSts = custSts;
	}

	/**
	 * @return Returns the desc.
	 */
	public String getDesc() {
		return desc;
	}

	/** 
     * @param desc
     */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return Returns the ediSts.
	 */
	public String getEdi_sts() {
		return ediSts;
	}

	/** 
     * @param ediSts
     */
	public void setEdi_sts(String ediSts) {
		this.ediSts = ediSts;
	}

	/**
	 * @return Returns the count.
	 */
	public int getCount() {
		return count;
	}

	/** 
     * @param count
     */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return Returns the csDesc.
	 */
	public String getCs_desc() {
		return csDesc;
	}

	/** 
     * @param csDesc
     */
	public void setCs_desc(String csDesc) {
		this.csDesc = csDesc;
	}

	/**
	 * @return Returns the csGrpId.
	 */
	public String getCs_grp_id() {
		return csGrpId;
	}

	/** 
     * @param csGrpId
     */
	public void setCs_grp_id(String csGrpId) {
		this.csGrpId = csGrpId;
	}

	/**
	 * @return Returns the tpId.
	 */
	public String getTp_id() {
		return tpId;
	}

	/** 
     * @param tpId
     */
	public void setTp_id(String tpId) {
		this.tpId = tpId;
	}
	/**
	 * @return Returns the cnt.
	 */
	public int getCnt() {
		return cnt;
	}


	/**
	 * @param cnt The cnt to set.
	 */
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
