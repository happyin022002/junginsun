/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmPri6002Event.java
*@FileTitle : Verify Rate
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.AplyRtInVO;
import com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo.PriSimRoutInfoVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComBakEndJbVO;


/**
 * ESM_PRI_6002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dong-Sun Moon
 * @see ESM_PRI_6002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PrdMainInfoVO prdMainInfoVO = null;
	private AplyRtInVO aplyRtInVO = null;
	private ComBakEndJbVO comBakEndJbVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private AplyRtInVO[] aplyRtInVOs = null;
	private PriSimRoutInfoVO[] priSimRoutInfoVOs = null;
	private String key = null;

	public EsmPri6002Event(){}

	public PrdMainInfoVO getPrdMainInfoVO() {
		return prdMainInfoVO;
	}

	public void setPrdMainInfoVO(PrdMainInfoVO prdMainInfoVO) {
		this.prdMainInfoVO = prdMainInfoVO;
	}

	public AplyRtInVO getAplyRtInVO() {
		return aplyRtInVO;
	}

	public void setAplyRtInVO(AplyRtInVO aplyRtInVO) {
		this.aplyRtInVO = aplyRtInVO;
	}
	
	public ComBakEndJbVO getComBakEndJbVO() {
		return comBakEndJbVO;
	}
	
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO) {
		this.comBakEndJbVO = comBakEndJbVO;
	}
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setAplyRtInVOS(AplyRtInVO[] aplyRtInVOs){
		if(aplyRtInVOs != null){
			AplyRtInVO[] tmpVOs = Arrays.copyOf(aplyRtInVOs, aplyRtInVOs.length);
			//System.arraycopy(manifestTransmitVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.aplyRtInVOs = tmpVOs;
		}
	}
	
	/** ValueObject Array Getter - Create/Update/Delete */
	public AplyRtInVO[] getAplyRtInVOs(){
		AplyRtInVO[] rtnVOs = null;
		if (this.aplyRtInVOs != null) {
			rtnVOs = Arrays.copyOf(aplyRtInVOs, aplyRtInVOs.length);
			//rtnVOs = new ManifestTransmitVO[manifestTransmitVOs.length];
			//System.arraycopy(manifestTransmitVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setPriSimRoutInfoVOs(PriSimRoutInfoVO[] priSimRoutInfoVOs){
		if(priSimRoutInfoVOs != null){
			PriSimRoutInfoVO[] tmpVOs = Arrays.copyOf(priSimRoutInfoVOs, priSimRoutInfoVOs.length);
			this.priSimRoutInfoVOs = tmpVOs;
		}
	}
	
	/** ValueObject Array Getter - Create/Update/Delete */
	public PriSimRoutInfoVO[] getPriSimRoutInfoVOs(){
		PriSimRoutInfoVO[] rtnVOs = null;
		if (this.priSimRoutInfoVOs != null) {
			rtnVOs = Arrays.copyOf(priSimRoutInfoVOs, priSimRoutInfoVOs.length);
		}
		return rtnVOs;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}