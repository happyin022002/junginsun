/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0001Event.java
*@FileTitle : Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.01
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.01 정윤태
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.support.layer.event.EventSupport;
 

/**
 * AgreementCreation 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0001HTMLAction 에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGYOONTAE
 * @see ESM_FMS_0001HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0001Event extends EventSupport {
	
	private static final long serialVersionUID = 1821987575925859092L;
	
	private Map<String, Object> voMap = new HashMap<String, Object>();
	
	private List<String> keys = null;

	private String fletCtrtNo = "";
	private String fletCtrtTpCd = "";
	private String vslCd = "";
	private String custCntCd = "";
	private String custSeq = "";
	private String vndrSeq = "";
	private String cefFileCnt = "";
	private String cpfFileCnt = "";
	private String agmtDocNo = "";
	private String agmtDocDesc = "";
	
	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}

	public String getAgmtDocNo() {
		return agmtDocNo;
	}
	
	public void setAgmtDocNo(String agmtDocNo) {
		this.agmtDocNo = agmtDocNo;
	}

	public String getAgmtDocDesc() {
		return agmtDocDesc;
	}

	public void setAgmtDocDesc(String agmtDocDesc) {
		this.agmtDocDesc = agmtDocDesc;
	}
	
	
	public String getFletCtrtTpCd() {
		return fletCtrtTpCd;
	}

	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
	}
	
	public String getVslCd() {
		return vslCd;
	}
	
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	public String getCustCntCd() {
		return custCntCd;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	public String getCustSeq() {
		return custSeq;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	public String getCefFileCnt() {
		return cefFileCnt;
	}

	public void setCefFileCnt(String cefFileCnt) {
		this.cefFileCnt = cefFileCnt;
	}

	public String getCpfFileCnt() {
		return cpfFileCnt;
	}

	public void setCpfFileCnt(String cpfFileCnt) {
		this.cpfFileCnt = cpfFileCnt;
	}

	public void setVO(String key, Object vo) {
		voMap.put(key, vo);
	}
	
	public Object getVO(String key) {
		return voMap.get(key);
	}
}
