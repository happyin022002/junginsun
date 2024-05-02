/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3501Event.java
*@FileTitle : Tariff General Information Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.10.06 김민아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.event;

import com.clt.apps.opus.esm.pri.tariff.tariffgeneralinformation.vo.TrfBzcMnVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriTrfBzcRoutPntVO;
import com.clt.syscommon.common.table.PriTrfBzcVO;


/**
 * ESM_PRI_3501 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3501HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM MINAH
 * @see ESM_PRI_3501HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3501Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfBzcVO priTrfBzcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTrfBzcVO[] priTrfBzcVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfBzcRoutPntVO priTrfBzcRoutPntVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TrfBzcMnVO trfBzcMnVO = null;

	public EsmPri3501Event(){}

	public PriTrfBzcVO getPriTrfBzcVO() {
		return priTrfBzcVO;
	}

	public PriTrfBzcVO[] getPriTrfBzcVOs() {
		PriTrfBzcVO[] tmpVOs = null;
		if (this.priTrfBzcVOs != null) {
			tmpVOs = new PriTrfBzcVO[priTrfBzcVOs.length];
			System.arraycopy(priTrfBzcVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriTrfBzcRoutPntVO getPriTrfBzcRoutPntVO() {
		return priTrfBzcRoutPntVO;
	}

	public TrfBzcMnVO getTrfBzcMnVO() {
		return trfBzcMnVO;
	}

	public void setPriTrfBzcVO(PriTrfBzcVO priTrfBzcVO) {
		this.priTrfBzcVO = priTrfBzcVO;
	}

	public void setPriTrfBzcVOs(PriTrfBzcVO[] priTrfBzcVOs) {
		if (priTrfBzcVOs != null) {
			PriTrfBzcVO[] tmpVOs = new PriTrfBzcVO[priTrfBzcVOs.length];
			System.arraycopy(priTrfBzcVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priTrfBzcVOs = tmpVOs;
		}
	}
	
	public void setPriTrfBzcRoutPntVO(PriTrfBzcRoutPntVO priTrfBzcRoutPntVO) {
		this.priTrfBzcRoutPntVO = priTrfBzcRoutPntVO;
	}
	
	public void setTrfBzcMnVO(TrfBzcMnVO trfBzcMnVO) {
		this.trfBzcMnVO = trfBzcMnVO;
	}


}