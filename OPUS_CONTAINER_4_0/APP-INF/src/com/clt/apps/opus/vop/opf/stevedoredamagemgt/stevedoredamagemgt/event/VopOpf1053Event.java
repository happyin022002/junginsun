/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf1053Event.java
*@FileTitle : Stevedore Damage Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.06.08 이선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCmpnVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.clt.syscommon.common.table.OpfStvDmgDtlVO;
import com.clt.syscommon.common.table.OpfStvDmgRprVO;
import com.clt.syscommon.common.table.OpfStvDmgStlVO;
import com.clt.syscommon.common.table.OpfStvDmgVO;


/**
 * VOP_OPF_1053 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_1053HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF_1053HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf1053Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgVO opfStvDmgVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgDtlVO opfStvDmgDtlVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgRprVO opfStvDmgRprVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgCmpnVO opfStvDmgCmpnVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpfStvDmgStlVO opfStvDmgStlVO = null;
	
	private OpfStvDmgAtchFileVO opfStvDmgAtchFileVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgVO[] opfStvDmgVOs = null;
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgDtlVO[] opfStvDmgDtlVOs = null;
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgRprVO[] opfStvDmgRprVOs = null;
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgCmpnVO[] opfStvDmgCmpnVOs = null;
	/** Table Value Object Multi Data 처리 */
	private OpfStvDmgStlVO[] opfStvDmgStlVOs = null;
	
	private OpfStvDmgAtchFileVO[] opfStvDmgAtchFileVOs = null;
	private List<String> keys = null;
	
	public VopOpf1053Event(){}
	
	public void setOpfStvDmgVO(OpfStvDmgVO opfStvDmgVO){
		this. opfStvDmgVO = opfStvDmgVO;
	}
	public OpfStvDmgVO getOpfStvDmgVO(){
		return opfStvDmgVO;
	}
	
	public OpfStvDmgDtlVO getOpfStvDmgDtlVO() {
		return opfStvDmgDtlVO;
	}
	public void setOpfStvDmgDtlVO(OpfStvDmgDtlVO opfStvDmgDtlVO) {
		this.opfStvDmgDtlVO = opfStvDmgDtlVO;
	}
	
	public OpfStvDmgRprVO getOpfStvDmgRprVO() {
		return opfStvDmgRprVO;
	}
	public void setOpfStvDmgRprVO(OpfStvDmgRprVO opfStvDmgRprVO) {
		this.opfStvDmgRprVO = opfStvDmgRprVO;
	}
	
	public OpfStvDmgCmpnVO getOpfStvDmgCmpnVO() {
		return opfStvDmgCmpnVO;
	}
	public void setOpfStvDmgCmpnVO(OpfStvDmgCmpnVO opfStvDmgCmpnVO) {
		this.opfStvDmgCmpnVO = opfStvDmgCmpnVO;
	}
	
	public OpfStvDmgStlVO getOpfStvDmgStlVO() {
		return opfStvDmgStlVO;
	}
	public void setOpfStvDmgStlVO(OpfStvDmgStlVO opfStvDmgStlVO) {
		this.opfStvDmgStlVO = opfStvDmgStlVO;
	}
	public OpfStvDmgVO[] getOpfStvDmgVOs() {
		OpfStvDmgVO[] rtnVOs = null;
		if (this.opfStvDmgVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfStvDmgVOs, this.opfStvDmgVOs.length);
		} // end if
		return rtnVOs;
	}
	public void setOpfStvDmgVOs(OpfStvDmgVO[] opfStvDmgVOs) {
		if (opfStvDmgVOs != null) {
			OpfStvDmgVO[] tmpVOs = Arrays.copyOf(opfStvDmgVOs, opfStvDmgVOs.length);
			this.opfStvDmgVOs = tmpVOs;
		} // end if
	}
	public OpfStvDmgDtlVO[] getOpfStvDmgDtlVOs() {
		OpfStvDmgDtlVO[] rtnVOs = null;
		if (this.opfStvDmgDtlVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfStvDmgDtlVOs, this.opfStvDmgDtlVOs.length);
		} // end if
		return rtnVOs;
	}
	public void setOpfStvDmgDtlVOs(OpfStvDmgDtlVO[] opfStvDmgDtlVOs) {
		if (opfStvDmgDtlVOs != null) {
			OpfStvDmgDtlVO[] tmpVOs = Arrays.copyOf(opfStvDmgDtlVOs, opfStvDmgDtlVOs.length);
			this.opfStvDmgDtlVOs = tmpVOs;
		} // end if

	}
	public OpfStvDmgRprVO[] getOpfStvDmgRprVOs() {
		OpfStvDmgRprVO[] rtnVOs = null;
		if (this.opfStvDmgRprVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfStvDmgRprVOs, this.opfStvDmgRprVOs.length);
		} // end if
		return rtnVOs;
	}
	public void setOpfStvDmgRprVOs(OpfStvDmgRprVO[] opfStvDmgRprVOs) {
		if (opfStvDmgRprVOs != null) {
			OpfStvDmgRprVO[] tmpVOs = Arrays.copyOf(opfStvDmgRprVOs, opfStvDmgRprVOs.length);
			this.opfStvDmgRprVOs = tmpVOs;
		} // end if
	}
	public OpfStvDmgCmpnVO[] getOpfStvDmgCmpnVOs() {
		OpfStvDmgCmpnVO[] rtnVOs = null;
		if (this.opfStvDmgCmpnVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfStvDmgCmpnVOs, this.opfStvDmgCmpnVOs.length);
		} // end if
		return rtnVOs;
	}
	public void setOpfStvDmgCmpnVOs(OpfStvDmgCmpnVO[] opfStvDmgCmpnVOs) {
		if (opfStvDmgCmpnVOs != null) {
			OpfStvDmgCmpnVO[] tmpVOs = Arrays.copyOf(opfStvDmgCmpnVOs, opfStvDmgCmpnVOs.length);
			this.opfStvDmgCmpnVOs = tmpVOs;
		} // end if
	}
	public OpfStvDmgStlVO[] getOpfStvDmgStlVOs() {
		OpfStvDmgStlVO[] rtnVOs = null;
		if (this.opfStvDmgStlVOs != null) {
			rtnVOs = Arrays.copyOf(this.opfStvDmgStlVOs, this.opfStvDmgStlVOs.length);
		} // end if
		return rtnVOs;
	}
	public void setOpfStvDmgStlVOs(OpfStvDmgStlVO[] opfStvDmgStlVOs) {
		if (opfStvDmgStlVOs != null) {
			OpfStvDmgStlVO[] tmpVOs = Arrays.copyOf(opfStvDmgStlVOs, opfStvDmgStlVOs.length);
			this.opfStvDmgStlVOs = tmpVOs;
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