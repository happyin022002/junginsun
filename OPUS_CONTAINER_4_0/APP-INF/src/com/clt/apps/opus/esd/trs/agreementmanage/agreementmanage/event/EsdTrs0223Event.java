/*=========================================================
 *@FileName : ESD_TRS_0223Event.java
 *@FileTitle : Agreement USA Rail Surcharge
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-08-12
 *@LastModifier : Sun, CHOI
 *@LastVersion : 1.1
* 2010-03-26 cjh	   	1.0  최초 생성
* 2010-08-12 Sun, CHOI	1.1 Agreement Reference No 조회 컬럼 추가 및 조회 조건 추가
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import java.util.Arrays;
import java.util.HashMap;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.RailSurchargeAgmtTmpVO;
import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.RailSurchargeAgmtVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0223 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0223HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0223Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String fmAgmtNo		 	= null;
	private String railRoadCode		= null;	
	private String effDt			= null;
	private String agmtRefNo		= null;
	private String sUsrId			= null;
	private String sctrlOfcCd		= null;
	/** Verify위한 Temp Sequence */
	private String agmtRailTmpSeq 	= null;
	private String scgKnd		 	= null;
	
	
	private RailSurchargeAgmtVO   railSurchargeAgmtVo;
		
	private RailSurchargeAgmtVO[] railSurchargeAgmtVos;
	
	private RailSurchargeAgmtTmpVO   railSurchargeAgmtTmpVo;
	
	private RailSurchargeAgmtTmpVO[] railSurchargeAgmtTmpVos;	
	
	public EsdTrs0223Event(){}
	
	public RailSurchargeAgmtVO getRailSurchargeAgmtVo() {
		return railSurchargeAgmtVo;
	}

	public void setRailSurchargeAgmtVo(RailSurchargeAgmtVO railSurchargeAgmtVoValue) {
		this.railSurchargeAgmtVo = railSurchargeAgmtVoValue;
	}

	public RailSurchargeAgmtVO[] getRailSurchargeAgmtVos() {
		RailSurchargeAgmtVO[] rtnVOs = null;
		if (this.railSurchargeAgmtVos != null) {
			rtnVOs = Arrays.copyOf(railSurchargeAgmtVos, railSurchargeAgmtVos.length);
		} // end if
		return rtnVOs;
	}

	public void setRailSurchargeAgmtVos(RailSurchargeAgmtVO[] railSurchargeAgmtVosValue) {
		if (railSurchargeAgmtVosValue != null) {
			RailSurchargeAgmtVO[] tmpVOs = Arrays.copyOf(railSurchargeAgmtVosValue, railSurchargeAgmtVosValue.length);
			this.railSurchargeAgmtVos = tmpVOs;
		} // end if
	}

	public RailSurchargeAgmtTmpVO getRailSurchargeAgmtTmpVo() {
		return railSurchargeAgmtTmpVo;
	}

	public void setRailSurchargeAgmtTmpVo(RailSurchargeAgmtTmpVO railSurchargeAgmtTmpVoValue) {
		this.railSurchargeAgmtTmpVo = railSurchargeAgmtTmpVoValue;
	}

	public RailSurchargeAgmtTmpVO[] getRailSurchargeAgmtTmpVos() {
		RailSurchargeAgmtTmpVO[] rtnVOs = null;
		if (this.railSurchargeAgmtTmpVos != null) {
			rtnVOs = Arrays.copyOf(railSurchargeAgmtTmpVos, railSurchargeAgmtTmpVos.length);
		} // end if
		return rtnVOs;
	}

	public void setRailSurchargeAgmtTmpVos(RailSurchargeAgmtTmpVO[] railSurchargeAgmtTmpVosValue) {
		if (railSurchargeAgmtTmpVosValue != null) {
			RailSurchargeAgmtTmpVO[] tmpVOs = Arrays.copyOf(railSurchargeAgmtTmpVosValue, railSurchargeAgmtTmpVosValue.length);
			this.railSurchargeAgmtTmpVos = tmpVOs;
		} // end if
	}

	public String getRailRoadCode() {
		return railRoadCode;
	}

	public void setRailRoadCode(String railRoadCode) {
		this.railRoadCode = railRoadCode;
	}

	public String getEffDt() {
		return effDt;
	}

	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	public String getAgmtRefNo() {
		return agmtRefNo;
	}

	public void setAgmtRefNo(String agmtRefNo) {
		this.agmtRefNo = agmtRefNo;
	}
	
	public String getSUsrId() {
		return sUsrId;
	}

	public void setSUsrId(String usrId) {
		this.sUsrId = usrId;
	}

	public String getSctrlOfcCd() {
		return sctrlOfcCd;
	}

	public void setSctrlOfcCd(String sctrlOfcCd) {
		this.sctrlOfcCd = sctrlOfcCd;
	}

	public String getAgmtRailTmpSeq() {
		return agmtRailTmpSeq;
	}

	public void setAgmtRailTmpSeq(String agmtRailTmpSeq) {
		this.agmtRailTmpSeq = agmtRailTmpSeq;
	}

	public String getScgKnd() {
		return scgKnd;
	}

	public void setScgKnd(String scgKnd) {
		this.scgKnd = scgKnd;
	}

	public String getFmAgmtNo() {
		return fmAgmtNo;
	}

	public void setFmAgmtNo(String fmAgmtNo) {
		this.fmAgmtNo = fmAgmtNo;
	}

	/**	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		
		this.hashColumns.put("fmAgmtNo", 		this.getFmAgmtNo());
		this.hashColumns.put("railRoadCode", 	this.getRailRoadCode());
		this.hashColumns.put("effDt", 			this.getEffDt());
		this.hashColumns.put("agmtRefNo", 		this.getAgmtRefNo());
		this.hashColumns.put("sUsrId", 			this.getSUsrId());
		this.hashColumns.put("sctrlOfcCd", 		this.getSctrlOfcCd());
		this.hashColumns.put("agmtRailTmpSeq", 	this.getAgmtRailTmpSeq());
		this.hashColumns.put("scgKnd", 			this.getScgKnd());
		return this.hashColumns;
	}

	public String getEventName() {
		return "EsdTrs0223Event";
	}

	public String toString() {
		return "EsdTrs0223Event";
	}
}
