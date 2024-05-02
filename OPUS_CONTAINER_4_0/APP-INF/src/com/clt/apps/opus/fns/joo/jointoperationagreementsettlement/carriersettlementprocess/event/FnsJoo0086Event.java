/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FnsJoo0086Event.java
*@FileTitle : Conversion Table
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.25
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.25 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConversionAndOptionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.CntrConversionConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0086 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0086HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0086HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0086Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrConversionAndOptionVO cntrConversionAndOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrConversionAndOptionVO[] cntrConversionAndOptionVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrConversionConditionVO cntrConversionConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrConversionAndOptionVO[] cntrTeuConversionAndOptionVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrConversionAndOptionVO[] cntrVoidConversionAndOptionVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrConversionAndOptionVO[] cntrDefaultVoidVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrConversionAndOptionVO[] cntrDefaultTpszVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private CntrConversionAndOptionVO[] cntrDefaultTpszConversionAndOptionVOs = null;

	public FnsJoo0086Event(){}

	public CntrConversionAndOptionVO getCntrConversionAndOptionVO() {
		return cntrConversionAndOptionVO;
	}

	public void setCntrConversionAndOptionVO(CntrConversionAndOptionVO cntrConversionAndOptionVO) {
		this.cntrConversionAndOptionVO = cntrConversionAndOptionVO;
	}

	public CntrConversionAndOptionVO[] getCntrDefaultTpszVOs() {
		CntrConversionAndOptionVO[] tmpVOs = null;
		if (this.cntrDefaultTpszVOs != null) {
			tmpVOs = new CntrConversionAndOptionVO[cntrDefaultTpszVOs.length];
			System.arraycopy(cntrDefaultTpszVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCntrDefaultTpszVOs(CntrConversionAndOptionVO[] cntrDefaultTpszVOs) {
		if (cntrConversionAndOptionVOs != null) {
			CntrConversionAndOptionVO[] tmpVOs = new CntrConversionAndOptionVO[cntrDefaultTpszVOs.length];
			System.arraycopy(cntrDefaultTpszVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrDefaultTpszVOs = tmpVOs;
		}
	}

	public CntrConversionAndOptionVO[] getCntrDefaultVoidVOs() {
		CntrConversionAndOptionVO[] tmpVOs = null;
		if (this.cntrDefaultVoidVOs != null) {
			tmpVOs = new CntrConversionAndOptionVO[cntrDefaultVoidVOs.length];
			System.arraycopy(cntrDefaultVoidVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCntrDefaultVoidVOs(CntrConversionAndOptionVO[] cntrDefaultVoidVOs) {
		if (cntrConversionAndOptionVOs != null) {
			CntrConversionAndOptionVO[] tmpVOs = new CntrConversionAndOptionVO[cntrDefaultVoidVOs.length];
			System.arraycopy(cntrDefaultVoidVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrDefaultVoidVOs = tmpVOs;
		}
	}

	public CntrConversionAndOptionVO[] getCntrConversionAndOptionVOs() {
		CntrConversionAndOptionVO[] tmpVOs = null;
		if (this.cntrConversionAndOptionVOs != null) {
			tmpVOs = new CntrConversionAndOptionVO[cntrConversionAndOptionVOs.length];
			System.arraycopy(cntrConversionAndOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCntrConversionAndOptionVOs(CntrConversionAndOptionVO[] cntrConversionAndOptionVOs) {
		if (cntrConversionAndOptionVOs != null) {
			CntrConversionAndOptionVO[] tmpVOs = new CntrConversionAndOptionVO[cntrConversionAndOptionVOs.length];
			System.arraycopy(cntrConversionAndOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrConversionAndOptionVOs = tmpVOs;
		}
	}

	public CntrConversionAndOptionVO[] getCntrTpszConversionAndOptionVOs() {
		CntrConversionAndOptionVO[] tmpVOs = null;
		if (this.cntrTpszConversionAndOptionVOs != null) {
			tmpVOs = new CntrConversionAndOptionVO[cntrTpszConversionAndOptionVOs.length];
			System.arraycopy(cntrTpszConversionAndOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCntrTpszConversionAndOptionVOs(CntrConversionAndOptionVO[] cntrTpszConversionAndOptionVOs) {
		if (cntrTpszConversionAndOptionVOs != null) {
			CntrConversionAndOptionVO[] tmpVOs = new CntrConversionAndOptionVO[cntrTpszConversionAndOptionVOs.length];
			System.arraycopy(cntrTpszConversionAndOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrTpszConversionAndOptionVOs = tmpVOs;
		}
	}

	public CntrConversionAndOptionVO[] getCntrTeuConversionAndOptionVOs() {
		CntrConversionAndOptionVO[] tmpVOs = null;
		if (this.cntrTeuConversionAndOptionVOs != null) {
			tmpVOs = new CntrConversionAndOptionVO[cntrTeuConversionAndOptionVOs.length];
			System.arraycopy(cntrTeuConversionAndOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCntrTeuConversionAndOptionVOs(CntrConversionAndOptionVO[] cntrTeuConversionAndOptionVOs) {
		if (cntrTeuConversionAndOptionVOs != null) {
			CntrConversionAndOptionVO[] tmpVOs = new CntrConversionAndOptionVO[cntrTeuConversionAndOptionVOs.length];
			System.arraycopy(cntrTeuConversionAndOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrTeuConversionAndOptionVOs = tmpVOs;
		}
	}

	public CntrConversionAndOptionVO[] getCntrVoidConversionAndOptionVOs() {
		CntrConversionAndOptionVO[] tmpVOs = null;
		if (this.cntrVoidConversionAndOptionVOs != null) {
			tmpVOs = new CntrConversionAndOptionVO[cntrVoidConversionAndOptionVOs.length];
			System.arraycopy(cntrVoidConversionAndOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCntrVoidConversionAndOptionVOs(CntrConversionAndOptionVO[] cntrVoidConversionAndOptionVOs) {
		if (cntrVoidConversionAndOptionVOs != null) {
			CntrConversionAndOptionVO[] tmpVOs = new CntrConversionAndOptionVO[cntrVoidConversionAndOptionVOs.length];
			System.arraycopy(cntrVoidConversionAndOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrVoidConversionAndOptionVOs = tmpVOs;
		}
	}

	public CntrConversionConditionVO getCntrConversionConditionVO() {
		return cntrConversionConditionVO;
	}

	public void setCntrConversionConditionVO(CntrConversionConditionVO cntrConversionConditionVO) {
		this.cntrConversionConditionVO = cntrConversionConditionVO;
	}

	public CntrConversionAndOptionVO[] getCntrDefaultTpszConversionAndOptionVOs() {
		CntrConversionAndOptionVO[] tmpVOs = null;
		if (this.cntrDefaultTpszConversionAndOptionVOs != null) {
			tmpVOs = new CntrConversionAndOptionVO[cntrDefaultTpszConversionAndOptionVOs.length];
			System.arraycopy(cntrDefaultTpszConversionAndOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setCntrDefaultTpszConversionAndOptionVOs(CntrConversionAndOptionVO[] cntrDefaultTpszConversionAndOptionVOs) {
		if (cntrDefaultTpszConversionAndOptionVOs != null) {
			CntrConversionAndOptionVO[] tmpVOs = new CntrConversionAndOptionVO[cntrDefaultTpszConversionAndOptionVOs.length];
			System.arraycopy(cntrDefaultTpszConversionAndOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cntrDefaultTpszConversionAndOptionVOs = tmpVOs;
		}
	}
	

}