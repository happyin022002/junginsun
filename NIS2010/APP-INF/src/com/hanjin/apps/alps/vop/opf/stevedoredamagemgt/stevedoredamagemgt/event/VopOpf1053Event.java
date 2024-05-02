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
* 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가 - 담당자 선택 기능 추가 및 Auto mailing 기능 추가
* 2011.11.21 김민아 [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD 및 Port 설정 기능 변경
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.hanjin.syscommon.common.table.OpfStvDmgDtlVO;
import com.hanjin.syscommon.common.table.OpfStvDmgEmlSndHisVO;
import com.hanjin.syscommon.common.table.OpfStvDmgRprVO;
import com.hanjin.syscommon.common.table.OpfStvDmgStlVO;
import com.hanjin.syscommon.common.table.OpfStvDmgVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.vo.OpfUtilSearchOptVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCmpnVO;


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
	private OpfStvDmgEmlSndHisVO opfStvDmgEmlSndHisVO = null;
	private VskVslPortSkdVO vskVslPortSkdVO = null;
	private OpfUtilSearchOptVO opfUtilSearchOptVO = null;
	
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
	private OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVOs = null;
	
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
 			rtnVOs = new OpfStvDmgVO[opfStvDmgVOs.length];
 			System.arraycopy(opfStvDmgVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;	
	}
	public void setOpfStvDmgVOs(OpfStvDmgVO[] opfStvDmgVOs) {
		if (opfStvDmgVOs != null) {
			OpfStvDmgVO[] tmpVOs = new OpfStvDmgVO[opfStvDmgVOs.length];
			System.arraycopy(opfStvDmgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgVOs = tmpVOs;
		}		
	}
	public OpfStvDmgDtlVO[] getOpfStvDmgDtlVOs() {
		OpfStvDmgDtlVO[] rtnVOs = null;

 		if (this.opfStvDmgDtlVOs != null) {
 			rtnVOs = new OpfStvDmgDtlVO[opfStvDmgDtlVOs.length];
 			System.arraycopy(opfStvDmgDtlVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
	public void setOpfStvDmgDtlVOs(OpfStvDmgDtlVO[] opfStvDmgDtlVOs) {
		if (opfStvDmgDtlVOs != null) {
			OpfStvDmgDtlVO[] tmpVOs = new OpfStvDmgDtlVO[opfStvDmgDtlVOs.length];
			System.arraycopy(opfStvDmgDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgDtlVOs = tmpVOs;
		}		
	}
	public OpfStvDmgRprVO[] getOpfStvDmgRprVOs() {
		OpfStvDmgRprVO[] rtnVOs = null;

 		if (this.opfStvDmgRprVOs != null) {
 			rtnVOs = new OpfStvDmgRprVO[opfStvDmgRprVOs.length];
 			System.arraycopy(opfStvDmgRprVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
	public void setOpfStvDmgRprVOs(OpfStvDmgRprVO[] opfStvDmgRprVOs) {
		if (opfStvDmgRprVOs != null) {
			OpfStvDmgRprVO[] tmpVOs = new OpfStvDmgRprVO[opfStvDmgRprVOs.length];
			System.arraycopy(opfStvDmgRprVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgRprVOs = tmpVOs;
		}
	}
	public OpfStvDmgCmpnVO[] getOpfStvDmgCmpnVOs() {
		OpfStvDmgCmpnVO[] rtnVOs = null;

 		if (this.opfStvDmgCmpnVOs != null) {
 			rtnVOs = new OpfStvDmgCmpnVO[opfStvDmgCmpnVOs.length];
 			System.arraycopy(opfStvDmgCmpnVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
	public void setOpfStvDmgCmpnVOs(OpfStvDmgCmpnVO[] opfStvDmgCmpnVOs) {
		if (opfStvDmgCmpnVOs != null) {
			OpfStvDmgCmpnVO[] tmpVOs = new OpfStvDmgCmpnVO[opfStvDmgCmpnVOs.length];
			System.arraycopy(opfStvDmgCmpnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgCmpnVOs = tmpVOs;
		}
	}
	public OpfStvDmgStlVO[] getOpfStvDmgStlVOs() {
		OpfStvDmgStlVO[] rtnVOs = null;

 		if (this.opfStvDmgStlVOs != null) {
 			rtnVOs = new OpfStvDmgStlVO[opfStvDmgStlVOs.length];
 			System.arraycopy(opfStvDmgStlVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;		 
	}
	public void setOpfStvDmgStlVOs(OpfStvDmgStlVO[] opfStvDmgStlVOs) {
		if (opfStvDmgStlVOs != null) {
			OpfStvDmgStlVO[] tmpVOs = new OpfStvDmgStlVO[opfStvDmgStlVOs.length];
			System.arraycopy(opfStvDmgStlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgStlVOs = tmpVOs;
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

	public OpfUtilSearchOptVO getOpfUtilSearchOptVO() {
		return opfUtilSearchOptVO;
	}

	public void setOpfUtilSearchOptVO(OpfUtilSearchOptVO opfUtilSearchOptVO) {
		this.opfUtilSearchOptVO = opfUtilSearchOptVO;
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
/*			if(opfStvDmgAtchFileVOs != null){				
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
*/	}
	
	public List<String> getKeys() {
		return keys;
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

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}	
	
	public OpfStvDmgEmlSndHisVO getOpfStvDmgEmlSndHisVO() {
		return opfStvDmgEmlSndHisVO;
	}

	public OpfStvDmgEmlSndHisVO[] getOpfStvDmgEmlSndHisVOs() {
		OpfStvDmgEmlSndHisVO[] rtnVOs = null;

 		if (this.opfStvDmgEmlSndHisVOs != null) {
 			rtnVOs = new OpfStvDmgEmlSndHisVO[opfStvDmgEmlSndHisVOs.length];
 			System.arraycopy(opfStvDmgEmlSndHisVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	public void setOpfStvDmgEmlSndHisVO(OpfStvDmgEmlSndHisVO opfStvDmgEmlSndHisVO) {
		this.opfStvDmgEmlSndHisVO = opfStvDmgEmlSndHisVO;
	}

	public void setOpfStvDmgEmlSndHisVOs(OpfStvDmgEmlSndHisVO[] opfStvDmgEmlSndHisVOs) {
		if (opfStvDmgEmlSndHisVOs != null) {
			OpfStvDmgEmlSndHisVO[] tmpVOs = new OpfStvDmgEmlSndHisVO[opfStvDmgEmlSndHisVOs.length];
			System.arraycopy(opfStvDmgEmlSndHisVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opfStvDmgEmlSndHisVOs = tmpVOs;
		}
	}
}