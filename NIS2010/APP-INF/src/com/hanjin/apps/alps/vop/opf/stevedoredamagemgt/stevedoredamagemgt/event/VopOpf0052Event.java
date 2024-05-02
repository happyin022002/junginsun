/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0052Event.java
*@FileTitle : Damage Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.18 이선영
* 1.0 Creation
* 2010.10.12 이석준 [CSR전 사전 작업] VVD,VSL,Lane,Port 유효성 검사 로직 추가
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
* 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가 - 담당자 선택 기능 추가 및 Auto mailing 기능 추가
* 2011.11.21 김민아 [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD 및 Port 설정 기능 변경
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import java.util.List;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCreateVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.hanjin.syscommon.common.table.OpfStvDmgEmlSndHisVO;
import com.hanjin.syscommon.common.table.OpfStvDmgVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;


/**
 * VOP_OPF_0052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF_0052HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopOpf0052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgCreateVO opfStvDmgCreateVO = null;
	private SdmsOptionVO sdmsOptionVO = null;
	private OpfStvDmgAtchFileVO opfStvDmgAtchFileVO = null;
	private VskVslPortSkdVO vskVslPortSkdVO = null;
	private OpfStvDmgEmlSndHisVO opfStvDmgEmlSndHisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgCreateVO[] opfStvDmgCreateVOs = null;
	private SdmsOptionVO[] sdmsOptionVOs = null;
	private OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs = null;
	private OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVOs = null;
	
	private List<String> keys = null;
	
	private String[] 		strKeys	= null;	//::2011.11.22 append::jsk

	private VskVslSkdVO vskVslSkdVO = null;

	private OpfUtilSearchOptVO opfUtilSearchOptVO;
	private TerminalDepartureReportCondVO terminalDepartureReportCondVO;
	

	public VopOpf0052Event(){}
	
	public void setOpfStvDmgCreateVO(OpfStvDmgCreateVO opfStvDmgCreateVO){
		this. opfStvDmgCreateVO = opfStvDmgCreateVO;
	}

	public void setOpfStvDmgCreateVOS(OpfStvDmgCreateVO[] opfStvDmgCreateVOs){
		if (opfStvDmgCreateVOs != null) {
			OpfStvDmgCreateVO[] tmpVOs = new OpfStvDmgCreateVO[opfStvDmgCreateVOs.length];
			System.arraycopy(opfStvDmgCreateVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgCreateVOs = tmpVOs;
		}
	}
	
	public void setSdmsOptionVO(SdmsOptionVO sdmsOptionVO){
		this. sdmsOptionVO = sdmsOptionVO;
	}

	public void setSdmsOptionVOS(SdmsOptionVO[] sdmsOptionVOs){
		if (sdmsOptionVOs != null) {
			SdmsOptionVO[] tmpVOs = new SdmsOptionVO[sdmsOptionVOs.length];
			System.arraycopy(sdmsOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.sdmsOptionVOs = tmpVOs;
		}
	}
	
	public void setOpfStvDmgAtchFileVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileVO){
		this. opfStvDmgAtchFileVO = opfStvDmgAtchFileVO;
	}
	
	public void setOpfStvDmgAtchFileVOS(OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs){
		if (opfStvDmgAtchFileVOs != null) {
			OpfStvDmgAtchFileVO[] tmpVOs = new OpfStvDmgAtchFileVO[opfStvDmgAtchFileVOs.length];
			System.arraycopy(opfStvDmgAtchFileVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgAtchFileVOs = tmpVOs;
		}
	}
	
	public VskVslPortSkdVO getVskVslPortSkdVO() {
		return vskVslPortSkdVO;
	}

	public void setVskVslPortSkdVO(VskVslPortSkdVO vskVslPortSkdVO) {
		this.vskVslPortSkdVO = vskVslPortSkdVO;
	}
	
	public VskVslSkdVO getVskVslSkdVO() {
		return vskVslSkdVO;
	}
	
	public void setVskVslSkdVO(VskVslSkdVO vskVslSkdVO) {
		this.vskVslSkdVO = vskVslSkdVO; 		
	}
	
	public OpfUtilSearchOptVO getOpfUtilSearchOptVO() {
		return opfUtilSearchOptVO;
	}
	
	public void setOpfUtilSearchOptVO(OpfUtilSearchOptVO opfUtilSearchOptVO) {
		this.opfUtilSearchOptVO = opfUtilSearchOptVO;
	}

	public TerminalDepartureReportCondVO getTerminalDepartureReportCondVO() {
		return terminalDepartureReportCondVO;
	}

	public void setTerminalDepartureReportCondVO(TerminalDepartureReportCondVO terminalDepartureReportCondVO) {
		this.terminalDepartureReportCondVO = terminalDepartureReportCondVO;
	}

	public void setOpfStvDmgEmlSndHisVO(OpfStvDmgEmlSndHisVO opfStvDmgEmlSndHisVO) {
		this.opfStvDmgEmlSndHisVO = opfStvDmgEmlSndHisVO;
	}

	public void setOpfStvDmgEmlSndHisVOS(OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVOs) {
		if (opfStvDmgEmlSndHisVOs != null) {
			OpfStvDmgEmlSndHisVO[] tmpVOs = new OpfStvDmgEmlSndHisVO[opfStvDmgEmlSndHisVOs.length];
			System.arraycopy(opfStvDmgEmlSndHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgEmlSndHisVOs = tmpVOs;
		}
	}

	/**
	 * Stevedore Damage 에 첨부파일 생성 합니다. <br>
	 * 
	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs
	 */	
	public void addOpfStvDmgAtchFileVOS(OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs){
		if(this.opfStvDmgAtchFileVOs == null && opfStvDmgAtchFileVOs != null){
			OpfStvDmgAtchFileVO[] tmpVOs = new OpfStvDmgAtchFileVO[opfStvDmgAtchFileVOs.length];
			System.arraycopy(opfStvDmgAtchFileVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgAtchFileVOs = tmpVOs;
		}
		else{
			if(opfStvDmgAtchFileVOs != null){
				int totalLeng = this.opfStvDmgAtchFileVOs.length + opfStvDmgAtchFileVOs.length;
				OpfStvDmgAtchFileVO[] newVo = new OpfStvDmgAtchFileVO[totalLeng];
				
				OpfStvDmgAtchFileVO[] tmpVOs = new OpfStvDmgAtchFileVO[opfStvDmgAtchFileVOs.length];
				System.arraycopy(opfStvDmgAtchFileVOs, 0, tmpVOs, 0, tmpVOs.length);
				
				int i = 0;
				for(i=0; i<this.opfStvDmgAtchFileVOs.length; i++){
					newVo[i] = this.opfStvDmgAtchFileVOs[i];
				}
				for(int j=0; j<tmpVOs.length; j++){
					newVo[i++] = tmpVOs[j];
				}
				this.opfStvDmgAtchFileVOs = null;
				this.opfStvDmgAtchFileVOs = newVo;
				
			}
		}
	}
	
	public List<String> getKeys() {
		return keys;
	}
	
	public String[] getStrKeys(){
		String[]  rtnVOs = null;		
		
		if (this.strKeys != null) {
 			rtnVOs = new String[strKeys.length];
 			System.arraycopy(strKeys, 0, rtnVOs, 0, rtnVOs.length);
 		 }	
		 return rtnVOs; 
	}

	public OpfStvDmgCreateVO getOpfStvDmgCreateVO(){
		return opfStvDmgCreateVO;
	}

	public OpfStvDmgCreateVO[] getOpfStvDmgCreateVOS(){
		OpfStvDmgCreateVO[] rtnVOs = null;

 		if (this.opfStvDmgCreateVOs != null) {
 			rtnVOs = new OpfStvDmgCreateVO[opfStvDmgCreateVOs.length];
 			System.arraycopy(opfStvDmgCreateVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
 		 
	}
	
	public SdmsOptionVO getSdmsOptionVO(){
		return sdmsOptionVO;
	}

	public SdmsOptionVO[] getSdmsOptionVOS(){
		SdmsOptionVO[] rtnVOs = null;

 		if (this.sdmsOptionVOs != null) {
 			rtnVOs = new SdmsOptionVO[sdmsOptionVOs.length];
 			System.arraycopy(sdmsOptionVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
	
	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileVO(){
		return opfStvDmgAtchFileVO;
	}
	
	public OpfStvDmgAtchFileVO[] getOpfStvDmgAtchFileVOS(){
		OpfStvDmgAtchFileVO[] rtnVOs = null;

 		if (this.opfStvDmgAtchFileVOs != null) {
 			rtnVOs = new OpfStvDmgAtchFileVO[opfStvDmgAtchFileVOs.length];
 			System.arraycopy(opfStvDmgAtchFileVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
	
	public OpfStvDmgEmlSndHisVO getOpfStvDmgEmlSndHisVO() {
		return opfStvDmgEmlSndHisVO;
	}

	public OpfStvDmgEmlSndHisVO[] getOpfStvDmgEmlSndHisVOS() {
		OpfStvDmgEmlSndHisVO[] rtnVOs = null;

 		if (this.opfStvDmgEmlSndHisVOs != null) {
 			rtnVOs = new OpfStvDmgEmlSndHisVO[opfStvDmgEmlSndHisVOs.length];
 			System.arraycopy(opfStvDmgEmlSndHisVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}
	
	public void setStrKeys(String[] strKeys){
		if (strKeys != null) {
			String[] tmpVOs = new String[strKeys.length];
			System.arraycopy(strKeys, 0, tmpVOs, 0, tmpVOs.length);
			this.strKeys = tmpVOs;
		}
		
	}

}