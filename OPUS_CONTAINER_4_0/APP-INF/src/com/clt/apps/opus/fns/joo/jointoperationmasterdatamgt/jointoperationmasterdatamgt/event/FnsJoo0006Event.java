/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0006Event.java
*@FileTitle : Carrier Merger
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.11 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.MstComInputVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.JooCrrMrgVO;


/**
 * FNS_JOO_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0006HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsJoo0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JooCrrMrgVO jooCrrMrgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private JooCrrMrgVO[] jooCrrMrgVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MstComInputVO mstComInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MstComInputVO[] mstComInputVOs = null;

	public FnsJoo0006Event(){}
	
	public void setJooCrrMrgVO(JooCrrMrgVO jooCrrMrgVO){
		this. jooCrrMrgVO = jooCrrMrgVO;
	}

	public void setJooCrrMrgVOS(JooCrrMrgVO[] jooCrrMrgVOs){
		if (jooCrrMrgVOs != null) {
			JooCrrMrgVO[] tmpVOs = new JooCrrMrgVO[jooCrrMrgVOs.length];
			System.arraycopy(jooCrrMrgVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.jooCrrMrgVOs = tmpVOs;
		}
	}

	public void setMstComInputVO(MstComInputVO mstComInputVO){
		this. mstComInputVO = mstComInputVO;
	}

	public void setMstComInputVOS(MstComInputVO[] mstComInputVOs){
		if (mstComInputVOs != null) {
			MstComInputVO[] tmpVOs = new MstComInputVO[mstComInputVOs.length];
			System.arraycopy(mstComInputVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mstComInputVOs = tmpVOs;
		}
	}

	public JooCrrMrgVO getJooCrrMrgVO(){
		return jooCrrMrgVO;
	}

	public JooCrrMrgVO[] getJooCrrMrgVOS(){
		JooCrrMrgVO[] tmpVOs = null;
		if (this.jooCrrMrgVOs != null) {
			tmpVOs = new JooCrrMrgVO[jooCrrMrgVOs.length];
			System.arraycopy(jooCrrMrgVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public MstComInputVO getMstComInputVO(){
		return mstComInputVO;
	}

	public MstComInputVO[] getMstComInputVOS(){
		MstComInputVO[] tmpVOs = null;
		if (this.mstComInputVOs != null) {
			tmpVOs = new MstComInputVO[mstComInputVOs.length];
			System.arraycopy(mstComInputVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}