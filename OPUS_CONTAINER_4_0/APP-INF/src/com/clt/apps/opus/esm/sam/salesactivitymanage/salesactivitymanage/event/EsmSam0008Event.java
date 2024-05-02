/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0008Event.java
*@FileTitle : Sales Activity Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SRepInfoVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SamCustSatsfcVO;
import com.clt.syscommon.common.table.SamSlsActVO;


/**
 * ESM_SAM_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONGJINHO
 * @see ESM_SAM_0008HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmSam0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SRepInfoVO sRepInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SRepInfoVO[] sRepInfoVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SamSlsActVO samSlsActVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SamCustSatsfcVO samCustSatsfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SamCustSatsfcVO[] samCustSatsfcVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SRepInfoVO satsfcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SRepInfoVO[] satsfcVOs = null;
	
	private String custSeq = null;
	private String custCntCd = null;
	private String custCd = null;
	private String srepCd = null;

	
	public EsmSam0008Event(){}
		
	public void setSRepInfoVO(SRepInfoVO sRepInfoVO){
		this. sRepInfoVO = sRepInfoVO;
	}

	public void setSRepInfoVOS(SRepInfoVO[] sRepInfoVOs){
		if(sRepInfoVOs != null){
			SRepInfoVO[] tmpVOs = Arrays.copyOf(sRepInfoVOs, sRepInfoVOs.length);
			this.sRepInfoVOs = tmpVOs;
		}
	}

	public SRepInfoVO getSRepInfoVO(){
		return sRepInfoVO;
	}

	public SRepInfoVO[] getSRepInfoVOS(){
		SRepInfoVO[] rtnVOs = null;
		if (this.sRepInfoVOs != null) {
			rtnVOs = Arrays.copyOf(sRepInfoVOs, sRepInfoVOs.length);
		}
		return rtnVOs;
	}
	
	
	public void setCustSeq(String custSeq){
		this. custSeq = custSeq;
	}
	
	public String getCustSeq(){
		return custSeq;
	}
	
	public void setSrepCd(String srepCd){
		this. srepCd = srepCd;
	}
	
	public String getSrepCd(){
		return srepCd;
	}
	
	public void setCustCd(String custCd){
		this. custCd = custCd;
	}
	
	public String getCustCd(){
		return custCd;
	}
	
	public void setCustCntCd(String custCntCd){
		this. custCntCd = custCntCd;
	}
	
	public String getCustCntCd(){
		return custCntCd;
	}

	public SamSlsActVO getSamSlsActVO() {
		return samSlsActVO;
	}

	public void setSamSlsActVO(SamSlsActVO samSlsActVO) {
		this.samSlsActVO = samSlsActVO;
	}

	public SamCustSatsfcVO getSamCustSatsfcVO() {
		return samCustSatsfcVO;
	}

	public void setSamCustSatsfcVO(SamCustSatsfcVO samCustSatsfcVO) {
		this.samCustSatsfcVO = samCustSatsfcVO;
	}

	public SamCustSatsfcVO[] getSamCustSatsfcVOs() {
		SamCustSatsfcVO[] rtnVOs = null;
		if (this.samCustSatsfcVOs != null) {
			rtnVOs = Arrays.copyOf(samCustSatsfcVOs, samCustSatsfcVOs.length);
		}
		return rtnVOs;
	}

	public void setSamCustSatsfcVOs(SamCustSatsfcVO[] samCustSatsfcVOs) {
		if(samCustSatsfcVOs != null){
			SamCustSatsfcVO[] tmpVOs = Arrays.copyOf(samCustSatsfcVOs, samCustSatsfcVOs.length);
			this.samCustSatsfcVOs = tmpVOs;
		}
	}

	public SRepInfoVO getSatsfcVO() {
		return satsfcVO;
	}

	public void setSatsfcVO(SRepInfoVO satsfcVO) {
		this.satsfcVO = satsfcVO;
	}

	public SRepInfoVO[] getSatsfcVOs() {
		SRepInfoVO[] rtnVOs = null;
		if (this.satsfcVOs != null) {
			rtnVOs = Arrays.copyOf(satsfcVOs, satsfcVOs.length);
		}
		return rtnVOs;
	}

	public void setSatsfcVOs(SRepInfoVO[] satsfcVOs) {
		if(satsfcVOs != null){
			SRepInfoVO[] tmpVOs = Arrays.copyOf(satsfcVOs, satsfcVOs.length);
			this.satsfcVOs = tmpVOs;
		}
	}
	


}