/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg9466Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.23
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2014.09.23 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlCertiRqstVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_9466 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_9466HTMLAction에서 작성<br>
 * - ServiceCommand Layer 로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_BKG_9466HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg9466Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg9466Event(){}

	
	/** Table Value Object 조회 조건 및 단건 처리  입력VO   */
	private BlRiderInVO blRiderInVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  출력VO   */
	private BlRiderOutVO blRiderOutVO = null;
	private BlCertiRqstVO[] blCertiRqstVOs;
	private String blNo = null;

	/**
	 * @return the blRiderInVO
	 */
	public BlRiderInVO getBlRiderInVO() {
		return blRiderInVO;
	}
	/**
	 * @param blRiderInVO the blRiderInVO to set
	 */
	public void setBlRiderInVO(BlRiderInVO blRiderInVO) {
		this.blRiderInVO = blRiderInVO;
	}
	/**
	 * @return the blRiderOutVO
	 */
	public BlRiderOutVO getBlRiderOutVO() {
		return blRiderOutVO;
	}
	/**
	 * @param blRiderOutVO the blRiderOutVO to set
	 */
	public void setBlRiderOutVO(BlRiderOutVO blRiderOutVO) {
		this.blRiderOutVO = blRiderOutVO;
	}
	
	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

    
	public BlCertiRqstVO[] getBlCertiRqstVOs() {
		BlCertiRqstVO[] rtnVOs = null;
		if (this.blCertiRqstVOs != null) {
			rtnVOs = new BlCertiRqstVO[blCertiRqstVOs.length];
			System.arraycopy(blCertiRqstVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setBlCertiRqstVOs(BlCertiRqstVO[] blCertiRqstVOs){
		if(blCertiRqstVOs != null){
			BlCertiRqstVO[] tmpVOs = new BlCertiRqstVO[blCertiRqstVOs.length];
			System.arraycopy(blCertiRqstVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.blCertiRqstVOs = tmpVOs;
		}
	} 
}