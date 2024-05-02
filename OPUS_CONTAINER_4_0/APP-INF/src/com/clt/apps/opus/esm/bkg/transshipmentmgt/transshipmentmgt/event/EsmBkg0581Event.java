/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0581Event.java
*@FileTitle : OOP Code Match with Vessel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.19 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopInqVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgVslOopVO;
import com.clt.syscommon.common.table.BkgVslOpCrrCdVO;


/**
 * ESM_BKG_0581 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0581HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0581HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0581Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgVslOopVO bkgVslOopVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgVslOopVO[] bkgVslOopVOs = null; 
	
	private VslOopInqVO vslOopInqVo = null;
	
	private VslOopInqVO[] vslOopInqVos = null;
	
	private VslOopVO vslOopVO = null;
	
	private VslOopVO[] vslOopVOs = null;
	
	private BkgVslOpCrrCdVO bkgVslOpCrrCdVO = null; 
	
	private BkgVslOpCrrCdVO[] bkgVslOpCrrCdVOs = null; 
	
	private VslOopInputVO vslOopInputVO = null;
	
	private VslOopInputVO[] inputVOs = null;

	public EsmBkg0581Event(){}
	 
	public VslOopInputVO getVslOopInputVO() {
		return vslOopInputVO;
	}

	public void setVslOopInputVO(VslOopInputVO inputVO) {
		this.vslOopInputVO = inputVO;
	}

	public VslOopInputVO[] getInputVOS() {
		VslOopInputVO[] rtnVOs = null;
		if(this.inputVOs != null){
			rtnVOs= Arrays.copyOf(inputVOs, inputVOs.length);
		}
		return rtnVOs;
	}

	public void setVslOopInputVOS(VslOopInputVO[] inputVOs) {
		if(inputVOs != null){
			VslOopInputVO[] tmpVOs = Arrays.copyOf(inputVOs, inputVOs.length);
			this.inputVOs = tmpVOs;
		}
		
	}

	public BkgVslOpCrrCdVO getBkgVslOpCrrCdVO() {
		return bkgVslOpCrrCdVO;
	}

	public void setBkgVslOpCrrCdVO(BkgVslOpCrrCdVO bkgVslOpCrrCdVO) {
		this.bkgVslOpCrrCdVO = bkgVslOpCrrCdVO;
	}

	public BkgVslOpCrrCdVO[] getBkgVslOpCrrCdVOS() {
		BkgVslOpCrrCdVO[] rtnVOs = null;
		if(this.bkgVslOpCrrCdVOs != null){
			rtnVOs= Arrays.copyOf(bkgVslOpCrrCdVOs, bkgVslOpCrrCdVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgVslOpCrrCdVOS(BkgVslOpCrrCdVO[] bkgVslOpCrrCdVOs) {
		if(bkgVslOpCrrCdVOs != null){
			BkgVslOpCrrCdVO[] tmpVOs = Arrays.copyOf(bkgVslOpCrrCdVOs, bkgVslOpCrrCdVOs.length);
			this.bkgVslOpCrrCdVOs = tmpVOs;
		}
	}

	public VslOopInqVO getVslOopInqVo() {
		return vslOopInqVo;
	}

	public void setVslOopInqVo(VslOopInqVO vslOopInqVo) {
		this.vslOopInqVo = vslOopInqVo;
	}

	public VslOopInqVO[] getVslOopInqVoS() {
		VslOopInqVO[] rtnVOs = null;
		if(this.vslOopInqVos != null){
			rtnVOs= Arrays.copyOf(vslOopInqVos, vslOopInqVos.length);
		}
		return rtnVOs;
	}

	public void setVslOopInqVoS(VslOopInqVO[] vslOopInqVos) {
		if(vslOopInqVos != null){
			VslOopInqVO[] tmpVOs = Arrays.copyOf(vslOopInqVos, vslOopInqVos.length);
			this.vslOopInqVos = tmpVOs;
		}
	}

	public VslOopVO getVslOopVO() {
		return vslOopVO;
	}

	public void setVslOopVO(VslOopVO vslOopVO) {
		this.vslOopVO = vslOopVO;
	}

	public VslOopVO[] getVslOopVOS() {
		VslOopVO[] rtnVOs = null;
		if(this.vslOopVOs != null){
			rtnVOs= Arrays.copyOf(vslOopVOs, vslOopVOs.length);
		}
		return rtnVOs;
	}

	public void setVslOopVOS(VslOopVO[] vslOopVOs) {
		if(vslOopVOs != null){
			VslOopVO[] tmpVOs = Arrays.copyOf(vslOopVOs, vslOopVOs.length);
			this.vslOopVOs = tmpVOs;
		}
	}


	public void setBkgVslOopVO(BkgVslOopVO bkgVslOopVO){
		this. bkgVslOopVO = bkgVslOopVO;
	}

	public void setBkgVslOopVOS(BkgVslOopVO[] bkgVslOopVOs){
		if(bkgVslOopVOs != null){
			BkgVslOopVO[] tmpVOs = Arrays.copyOf(bkgVslOopVOs, bkgVslOopVOs.length);
			this.bkgVslOopVOs = tmpVOs;
		}
	}
 
	public BkgVslOopVO getBkgVslOopVO(){
		return bkgVslOopVO;
	}

	public BkgVslOopVO[] getBkgVslOopVOS(){
		BkgVslOopVO[] rtnVOs = null;
		if(this.bkgVslOopVOs != null){
			rtnVOs= Arrays.copyOf(bkgVslOopVOs, bkgVslOopVOs.length);
		}
		return rtnVOs;
	}
 

}