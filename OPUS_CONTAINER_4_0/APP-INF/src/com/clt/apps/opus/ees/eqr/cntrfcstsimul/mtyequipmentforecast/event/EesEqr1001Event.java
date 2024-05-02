/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCim1001Event.java
*@FileTitle : MTY Balance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.23 김종준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.event;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EES_CIM_1001HTMLAction;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceOptionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.MtyBalanceReferenceListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.OpmgFcstInputVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CIM_1001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CIM_1001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim jong jun
 * @see EES_CIM_1001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalanceOptionVO mtyBalanceOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MtyBalanceOptionVO[] mtyBalanceOptionVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalanceListVO mtyBalanceListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MtyBalanceListVO[] mtyBalanceListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyBalanceReferenceListVO mtyBalanceReferenceListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MtyBalanceReferenceListVO[] mtyBalanceReferenceListVOs = null;
	
	//OpmgFcstInputVO
	/** Table Value Object 조회 조건 및 단건 처리  */
	private OpmgFcstInputVO opmgFcstInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private OpmgFcstInputVO[] opmgFcstInputVOs = null;
	
	
	public EesEqr1001Event(){}
	//OpmgFcstInputVO
	public void setOpmgFcstInputVO(OpmgFcstInputVO opmgFcstInputVO){
		this. opmgFcstInputVO = opmgFcstInputVO;
	}

	public void setOpmgFcstInputVOS(OpmgFcstInputVO[] opmgFcstInputVOs){
		if (opmgFcstInputVOs != null) {
			OpmgFcstInputVO[] tmpVOs = new OpmgFcstInputVO[opmgFcstInputVOs.length];
			System.arraycopy(opmgFcstInputVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.opmgFcstInputVOs = tmpVOs;
		}
	}
	public OpmgFcstInputVO getOpmgFcstInputVO(){
		return opmgFcstInputVO;
	}

	public OpmgFcstInputVO[] getOpmgFcstInputVOS(){
		OpmgFcstInputVO[] tmpVOs = null;
		if (this.opmgFcstInputVOs != null) {
			tmpVOs = new OpmgFcstInputVO[opmgFcstInputVOs.length];
			System.arraycopy(opmgFcstInputVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	
	public void setMtyBalanceOptionVO(MtyBalanceOptionVO mtyBalanceOptionVO){
		this. mtyBalanceOptionVO = mtyBalanceOptionVO;
	}

	public void setMtyBalanceOptionVOS(MtyBalanceOptionVO[] mtyBalanceOptionVOs){
		if (mtyBalanceOptionVOs != null) {
			MtyBalanceOptionVO[] tmpVOs = new MtyBalanceOptionVO[mtyBalanceOptionVOs.length];
			System.arraycopy(mtyBalanceOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mtyBalanceOptionVOs = tmpVOs;
		}
	}
	public MtyBalanceOptionVO getMtyBalanceOptionVO(){
		return mtyBalanceOptionVO;
	}

	public MtyBalanceOptionVO[] getMtyBalanceOptionVOS(){
		MtyBalanceOptionVO[] tmpVOs = null;
		if (this.mtyBalanceOptionVOs != null) {
			tmpVOs = new MtyBalanceOptionVO[mtyBalanceOptionVOs.length];
			System.arraycopy(mtyBalanceOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	
	public void setMtyBalanceListVO(MtyBalanceListVO mtyBalanceListVO){
		this. mtyBalanceListVO = mtyBalanceListVO;
	}

	public void setMtyBalanceListVOS(MtyBalanceListVO[] mtyBalanceListVOs){
		if (mtyBalanceListVOs != null) {
			MtyBalanceListVO[] tmpVOs = new MtyBalanceListVO[mtyBalanceListVOs.length];
			System.arraycopy(mtyBalanceListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mtyBalanceListVOs = tmpVOs;
		}
	}
	public MtyBalanceListVO getMtyBalanceListVO(){
		return mtyBalanceListVO;
	}

	public MtyBalanceListVO[] getMtyBalanceListVOS(){
		MtyBalanceListVO[] tmpVOs = null;
		if (this.mtyBalanceListVOs != null) {
			tmpVOs = new MtyBalanceListVO[mtyBalanceListVOs.length];
			System.arraycopy(mtyBalanceListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}	
	
	
	
	
	public void setMtyBalanceReferenceListVO(MtyBalanceReferenceListVO mtyBalanceReferenceListVO){
		this. mtyBalanceReferenceListVO = mtyBalanceReferenceListVO;
	}

	public void setMtyBalanceReferenceListVOS(MtyBalanceReferenceListVO[] mtyBalanceReferenceListVOs){
		if (mtyBalanceReferenceListVOs != null) {
			MtyBalanceReferenceListVO[] tmpVOs = new MtyBalanceReferenceListVO[mtyBalanceReferenceListVOs.length];
			System.arraycopy(mtyBalanceReferenceListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mtyBalanceReferenceListVOs = tmpVOs;
		}
	}
	public MtyBalanceReferenceListVO getMtyBalanceReferenceListVO(){
		return mtyBalanceReferenceListVO;
	}

	public MtyBalanceReferenceListVO[] getMtyBalanceReferenceListVOS(){
		MtyBalanceReferenceListVO[] tmpVOs = null;
		if (this.mtyBalanceReferenceListVOs != null) {
			tmpVOs = new MtyBalanceReferenceListVO[mtyBalanceReferenceListVOs.length];
			System.arraycopy(mtyBalanceReferenceListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}		
}