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
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCreateVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsOptionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;


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
	
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgCreateVO[] opfStvDmgCreateVOs = null;
	private SdmsOptionVO[] sdmsOptionVOs = null;
	private OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs = null;
	
	private List<String> keys = null;
	

	public VopOpf0052Event(){}
	
	public void setOpfStvDmgCreateVO(OpfStvDmgCreateVO opfStvDmgCreateVO){
		this. opfStvDmgCreateVO = opfStvDmgCreateVO;
	}

	public void setOpfStvDmgCreateVOS(OpfStvDmgCreateVO[] opfStvDmgCreateVOs){
		if (opfStvDmgCreateVOs != null) {
			OpfStvDmgCreateVO[] tmpVOs = Arrays.copyOf(opfStvDmgCreateVOs, opfStvDmgCreateVOs.length);
			this.opfStvDmgCreateVOs = tmpVOs;
		} // end if
	}
	
	public void setSdmsOptionVO(SdmsOptionVO sdmsOptionVO){
		this. sdmsOptionVO = sdmsOptionVO;
	}

	public void setSdmsOptionVOS(SdmsOptionVO[] sdmsOptionVOs){
		if (sdmsOptionVOs != null) {
			SdmsOptionVO[] tmpVOs = Arrays.copyOf(sdmsOptionVOs, sdmsOptionVOs.length);
			this.sdmsOptionVOs = tmpVOs;
		} // end if
	}
	
	public void setOpfStvDmgAtchFileVO(OpfStvDmgAtchFileVO opfStvDmgAtchFileVO){
		this. opfStvDmgAtchFileVO = opfStvDmgAtchFileVO;
	}
	
	public void setOpfStvDmgAtchFileVOS(OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs){
		if (opfStvDmgAtchFileVOs != null) {
			OpfStvDmgAtchFileVO[] tmpVOs = Arrays.copyOf(opfStvDmgAtchFileVOs, opfStvDmgAtchFileVOs.length);
			this.opfStvDmgAtchFileVOs = tmpVOs;
		} // end if
	}
	
	public VskVslPortSkdVO getVskVslPortSkdVO() {
		return vskVslPortSkdVO;
	}

	public void setVskVslPortSkdVO(VskVslPortSkdVO vskVslPortSkdVO) {
		this.vskVslPortSkdVO = vskVslPortSkdVO;
	}

	/**
	 * Stevedore Damage 에 첨부파일 생성 합니다. <br>
	 * 
	 * @param OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs
	 */	
	public void addOpfStvDmgAtchFileVOS(OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs){
		
		if(this.opfStvDmgAtchFileVOs == null){
			if (opfStvDmgAtchFileVOs != null) {
				OpfStvDmgAtchFileVO[] tmpVOs = Arrays.copyOf(opfStvDmgAtchFileVOs, opfStvDmgAtchFileVOs.length);
				this.opfStvDmgAtchFileVOs = tmpVOs;
			} // end if
		}
		else{
			if(opfStvDmgAtchFileVOs != null){
				
				int totalLeng = this.opfStvDmgAtchFileVOs.length + opfStvDmgAtchFileVOs.length;
				OpfStvDmgAtchFileVO[] newVo = new OpfStvDmgAtchFileVO[totalLeng];
				int i = 0;
				for(i=0; i<this.opfStvDmgAtchFileVOs.length; i++){
					newVo[i] = this.opfStvDmgAtchFileVOs[i];
				}
				for(int j=0; j<opfStvDmgAtchFileVOs.length; j++){
					newVo[i++] = opfStvDmgAtchFileVOs[j];
				}
				this.opfStvDmgAtchFileVOs = null;
				this.opfStvDmgAtchFileVOs = newVo;
			}
		}
	}
	
	public List<String> getKeys() {
		return keys;
	}
	

	public OpfStvDmgCreateVO getOpfStvDmgCreateVO(){
		return opfStvDmgCreateVO;
	}

	public OpfStvDmgCreateVO[] getOpfStvDmgCreateVOS(){
		OpfStvDmgCreateVO[] rtnVOs = null;
		if (this.opfStvDmgCreateVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfStvDmgCreateVOs, this.opfStvDmgCreateVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public SdmsOptionVO getSdmsOptionVO(){
		return sdmsOptionVO;
	}

	public SdmsOptionVO[] getSdmsOptionVOS(){
		SdmsOptionVO[] rtnVOs = null;
		if (this.sdmsOptionVOs != null) {
			rtnVOs = Arrays.copyOf(this.sdmsOptionVOs, this.sdmsOptionVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public OpfStvDmgAtchFileVO getOpfStvDmgAtchFileVO(){
		return opfStvDmgAtchFileVO;
	}
	
	public OpfStvDmgAtchFileVO[] getOpfStvDmgAtchFileVOS(){
		OpfStvDmgAtchFileVO[] rtnVOs = null;
		if (this.opfStvDmgAtchFileVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfStvDmgAtchFileVOs, this.opfStvDmgAtchFileVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

}