/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdSce0035EventResponse.java
*@FileTitle : EsdSce0035
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-26
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import java.util.HashMap;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.support.layer.event.EventResponseSupport;

/**
 * EsdSce0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */

@SuppressWarnings({ "deprecation" })
public class EsdSce0035EventResponse  extends EventResponseSupport  {
	private static final long serialVersionUID = 1L;
	
	private DBRowSet rowSet = null;
    private String resultCd = "";
    private int cnt = 0;
    
    private String csGrpId = "";
    private String tpId = "";
    private String csDesc = "";
    private String ediSts = "";
    
    /**
	 * @return Returns the ediSts.
	 */
	public String getEdi_sts() {
		return ediSts;
	}


	/**
	 * @param ediSts The ediSts to set.
	 */
	public void setEdi_sts(String ediSts) {
		this.ediSts = ediSts;
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
	
	
	
    /**
     * Constructor
     * @param csGrpId
     * @param tpId
     * @param csDesc
     */
    public EsdSce0035EventResponse(String csGrpId, String tpId, String csDesc){
        this.csGrpId = csGrpId;
        this.tpId = tpId;
        this.csDesc = csDesc;
    }
    
    /**
     * Constructor
     * @param map
     */
    public EsdSce0035EventResponse(HashMap<String, String> map){
        this.csGrpId = JSPUtil.getNull((String)map.get("cs_grp_id"));
        this.tpId = JSPUtil.getNull((String)map.get("tp_id"));
        this.csDesc = JSPUtil.getNull((String)map.get("cs_desc"));
        this.ediSts = JSPUtil.getNull((String)map.get("edi_sts"));
        
    } 

    /**
     * Constructor
     * @param map
     * @param cnt
     */
    public EsdSce0035EventResponse(HashMap<String, String> map, int cnt){
    	this.csGrpId = JSPUtil.getNull((String)map.get("cs_grp_id"));
        this.tpId = JSPUtil.getNull((String)map.get("tp_id"));
        this.csDesc = JSPUtil.getNull((String)map.get("cs_desc"));
        this.ediSts = JSPUtil.getNull((String)map.get("edi_sts"));
    	this.cnt = cnt;
    }
    
	/** Constructor
     * @param rowSet_
     */
    public EsdSce0035EventResponse(DBRowSet rowSet_){
        this.rowSet = rowSet_;
    }
    
    
    /** Constructor
     * @param rowSet_
     * @param cnt
     */
    public EsdSce0035EventResponse(DBRowSet rowSet_, int cnt){
    	this.rowSet = rowSet_;
    	this.cnt = cnt;
    }
    

    /** Constructor
     * @param resultCd_
     */
    public EsdSce0035EventResponse(String resultCd_){
    	this.resultCd = resultCd_;
    }
    /**
     * @return
     */
    public String getResultCd() {
		return resultCd;
	}

	
    /** 객체 표현 문자열(EdiSendEventResponse)을 반환
     * @return String EsdSce35EventResponse
     */
    public String toString() {
        return "EsdSce35EventResponse";
    }

    /** 이벤트 명(EdiSendEventResponse)을 반환
     * @return String CustomerEdiEventResponse
     */
    public String getEventName() {
        return "EsdSce35EventResponse";
    }

    /**
     * @return Returns the rowSet.
     */
    public DBRowSet getRowSet() {
        return rowSet;
    }


	/**
	 * @return Returns the csDesc.
	 */
	public String getCs_desc() {
		return csDesc;
	}


	/**
	 * @param csDesc The csDesc to set.
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
	 * @param csGrpId The csGrpId to set.
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
	 * @param tpId The tpId to set.
	 */
	public void setTp_id(String tpId) {
		this.tpId = tpId;
	}
}
