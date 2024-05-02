/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000107Event.java
*@FileTitle : SC Guideline Contract Clause
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.28 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.event;

import com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.vo.CtrtCluzGlineVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgCtrtCluzDtlVO;
import com.clt.syscommon.common.table.PriSgCtrtCluzVO;


/**
 * ESM_PRI_0001_07 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0001_07HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_0001_07HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000107Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgCtrtCluzVO priSgCtrtCluzVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgCtrtCluzVO[] priSgCtrtCluzVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgCtrtCluzDtlVO priSgCtrtCluzDtlVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSgCtrtCluzDtlVO[] priSgCtrtCluzDtlVOs = null;
	
	private CtrtCluzGlineVO ctrtCluzGlineVO = null;

	

	public CtrtCluzGlineVO getCtrtCluzGlineVO() {
		return ctrtCluzGlineVO;
	}

	public void setCtrtCluzGlineVO(CtrtCluzGlineVO ctrtCluzGlineVO) {
		this.ctrtCluzGlineVO = ctrtCluzGlineVO;
	}

	public EsmPri000107Event(){}
	
	public void setPriSgCtrtCluzVO(PriSgCtrtCluzVO priSgCtrtCluzVO){
		this. priSgCtrtCluzVO = priSgCtrtCluzVO;
	}

	public void setPriSgCtrtCluzVOS(PriSgCtrtCluzVO[] priSgCtrtCluzVOs){
		if (priSgCtrtCluzVOs != null) {
			PriSgCtrtCluzVO[] tmpVOs = new PriSgCtrtCluzVO[priSgCtrtCluzVOs.length];
			System.arraycopy(priSgCtrtCluzVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgCtrtCluzVOs = tmpVOs;
		}
	}

	public void setPriSgCtrtCluzDtlVO(PriSgCtrtCluzDtlVO priSgCtrtCluzDtlVO){
		this. priSgCtrtCluzDtlVO = priSgCtrtCluzDtlVO;
	}

	public void setPriSgCtrtCluzDtlVOS(PriSgCtrtCluzDtlVO[] priSgCtrtCluzDtlVOs){
		if (priSgCtrtCluzDtlVOs != null) {
			PriSgCtrtCluzDtlVO[] tmpVOs = new PriSgCtrtCluzDtlVO[priSgCtrtCluzDtlVOs.length];
			System.arraycopy(priSgCtrtCluzDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSgCtrtCluzDtlVOs = tmpVOs;
		}
	}

	public PriSgCtrtCluzVO getPriSgCtrtCluzVO(){
		return priSgCtrtCluzVO;
	}

	public PriSgCtrtCluzVO[] getPriSgCtrtCluzVOS(){
		PriSgCtrtCluzVO[] tmpVOs = null;
		if (this.priSgCtrtCluzVOs != null) {
			tmpVOs = new PriSgCtrtCluzVO[priSgCtrtCluzVOs.length];
			System.arraycopy(priSgCtrtCluzVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSgCtrtCluzDtlVO getPriSgCtrtCluzDtlVO(){
		return priSgCtrtCluzDtlVO;
	}

	public PriSgCtrtCluzDtlVO[] getPriSgCtrtCluzDtlVOS(){
		PriSgCtrtCluzDtlVO[] tmpVOs = null;
		if (this.priSgCtrtCluzDtlVOs != null) {
			tmpVOs = new PriSgCtrtCluzDtlVO[priSgCtrtCluzDtlVOs.length];
			System.arraycopy(priSgCtrtCluzDtlVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}