/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri000207Event.java
*@FileTitle : SC Guideline Contract Clause Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.10.01 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.event;

import com.clt.apps.opus.esm.pri.scguideline.sccontractclauseguideline.vo.CtrtCluzGlineVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSgCtrtCluzDtlVO;
import com.clt.syscommon.common.table.PriSgCtrtCluzVO;


/**
 * ESM_PRI_0002_07 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0002_07HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_PRI_0002_07HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri000207Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgCtrtCluzVO priSgCtrtCluzVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSgCtrtCluzDtlVO priSgCtrtCluzDtlVO = null;
		
	private CtrtCluzGlineVO ctrtCluzGlineVO = null;

	

	public CtrtCluzGlineVO getCtrtCluzGlineVO() {
		return ctrtCluzGlineVO;
	}

	public void setCtrtCluzGlineVO(CtrtCluzGlineVO ctrtCluzGlineVO) {
		this.ctrtCluzGlineVO = ctrtCluzGlineVO;
	}

	public EsmPri000207Event(){}
	
	public void setPriSgCtrtCluzVO(PriSgCtrtCluzVO priSgCtrtCluzVO){
		this. priSgCtrtCluzVO = priSgCtrtCluzVO;
	}

	public void setPriSgCtrtCluzDtlVO(PriSgCtrtCluzDtlVO priSgCtrtCluzDtlVO){
		this. priSgCtrtCluzDtlVO = priSgCtrtCluzDtlVO;
	}

	public PriSgCtrtCluzVO getPriSgCtrtCluzVO(){
		return priSgCtrtCluzVO;
	}

	public PriSgCtrtCluzDtlVO getPriSgCtrtCluzDtlVO(){
		return priSgCtrtCluzDtlVO;
	}

}