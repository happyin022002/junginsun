/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0013Event.java
*@FileTitle : SPCL CGO Irregular Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.05.29 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event;

import java.util.List;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.CNTRInfoInputVO;
import com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.vo.IrregularVO;


/**
 * VOP_SCG_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HyunUk Kim
 * @see VOP_SCG_0013HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IrregularVO irregularVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private IrregularVO[] irregularVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgBookingVO bkgBookingVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CNTRInfoInputVO cNTRInfoInputVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgContainerVO bkgContainerVO = null;
	
	private List<String> keys = null;

	public VopScg0013Event(){}
	
	public void setIrregularVO(IrregularVO irregularVO){
		this. irregularVO = irregularVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setIrregularVOS(IrregularVO[] irregularVOs){
		if (irregularVOs != null) {
			IrregularVO[] tmpVOs = new IrregularVO[irregularVOs.length];
			System.arraycopy(irregularVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.irregularVOs = tmpVOs;
		}
	}
	
	public void setBkgBookingVO(BkgBookingVO bkgBookingVO){
		this. bkgBookingVO = bkgBookingVO;
	}
	
	public void setCNTRInfoInputVO(CNTRInfoInputVO cNTRInfoInputVO){
		this. cNTRInfoInputVO = cNTRInfoInputVO;
	}
	
	public void setBkgContainerVO(BkgContainerVO bkgContainerVO){
		this. bkgContainerVO = bkgContainerVO;
	}
	
	public List<String> getKeys() {
		return keys;
	}

	public IrregularVO getIrregularVO(){
		return irregularVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public IrregularVO[] getIrregularVOS(){
		IrregularVO[] rtnVOs = null;
		if (this.irregularVOs != null) {
			rtnVOs = new IrregularVO[irregularVOs.length];
			System.arraycopy(irregularVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public BkgBookingVO getBkgBookingVO(){
		return bkgBookingVO;
	}
	
	public CNTRInfoInputVO getCNTRInfoInputVO(){
		return cNTRInfoInputVO;
	}
	
	public BkgContainerVO getBkgContainerVO(){
		return bkgContainerVO;
	}
	
	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

}