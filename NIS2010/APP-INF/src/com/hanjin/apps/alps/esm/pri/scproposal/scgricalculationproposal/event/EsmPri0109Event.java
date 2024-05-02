/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0109Event.java
*@FileTitle : GRI Calculation - Arbitrary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 서호열
*@LastVersion : 1.0
* 2009.07.10 서호열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpArbGriGrpVO;
import com.hanjin.syscommon.common.table.PriSpScpArbGriRtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLSubListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLAllListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLArbitraryListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgCombo1VO;

/**
 * ESM_PRI_0109 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0109HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HoYeolSea
 * @see ESM_PRI_0109HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0109Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriSpScpTrspAddChgGriArbOKCLListVO priSpScpTrspAddChgGriArbOKCLListVO = null;
	/** Table Value Object Multi Data 처리 */
	private PriSpScpTrspAddChgGriArbOKCLListVO[] priSpScpTrspAddChgGriArbOKCLListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpTrspAddChgGriArbOKCLSubListVO priSpScpTrspAddChgGriArbOKCLSubListVO = null;
	/** Table Value Object Multi Data 처리 */
	private PriSpScpTrspAddChgGriArbOKCLSubListVO[] priSpScpTrspAddChgGriArbOKCLSubListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpTrspAddChgCombo1VO priSpScpTrspAddChgCombo1VO = null;
	/** Table Value Object Multi Data 처리 */
	private PriSpScpTrspAddChgCombo1VO[] priSpScpTrspAddChgCombo1VOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriSpScpTrspAddChgGriArbOKCLAllListVO priSpScpTrspAddChgGriArbOKCLAllListVO = null;
	/** Table Value Object Multi Data 처리 */
	private PriSpScpTrspAddChgGriArbOKCLAllListVO[] priSpScpTrspAddChgGriArbOKCLAllListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private PriSpScpTrspAddChgGriArbOKCLArbitraryListVO priSpScpTrspAddChgGriArbOKCLArbitraryListVO = null;
	/** Table Value Object Multi Data 처리 */
	private PriSpScpTrspAddChgGriArbOKCLArbitraryListVO[] priSpScpTrspAddChgGriArbOKCLArbitraryListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpArbGriGrpVO priSpScpArbGriGrpVO = null;
	/** Table Value Object Multi Data 처리 */
	private PriSpScpArbGriGrpVO[] priSpScpArbGriGrpVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpArbGriRtVO priSpScpArbGriRtVO = null;
	/** Table Value Object Multi Data 처리 */
	private PriSpScpArbGriRtVO[] priSpScpArbGriRtVOs = null;
	
	public EsmPri0109Event(){}
	
	/** Set */
	public void setPriSpScpTrspAddChgGriArbOKCLListVO(PriSpScpTrspAddChgGriArbOKCLListVO priSpScpTrspAddChgGriArbOKCLListVO){
		this.priSpScpTrspAddChgGriArbOKCLListVO = priSpScpTrspAddChgGriArbOKCLListVO;
	}
	public void setPriSpScpTrspAddChgGriArbOKCLListVOS(PriSpScpTrspAddChgGriArbOKCLListVO[] priSpScpTrspAddChgGriArbOKCLListVOs){
		this.priSpScpTrspAddChgGriArbOKCLListVOs = priSpScpTrspAddChgGriArbOKCLListVOs;
	}

	public void setPriSpScpTrspAddChgGriArbOKCLSubListVO(PriSpScpTrspAddChgGriArbOKCLSubListVO priSpScpTrspAddChgGriArbOKCLSubListVO){
		this.priSpScpTrspAddChgGriArbOKCLSubListVO = priSpScpTrspAddChgGriArbOKCLSubListVO;
	}
	public void setPriSpScpTrspAddChgGriArbOKCLSubListVOS(PriSpScpTrspAddChgGriArbOKCLSubListVO[] priSpScpTrspAddChgGriArbOKCLSubListVOs){
		this.priSpScpTrspAddChgGriArbOKCLSubListVOs = priSpScpTrspAddChgGriArbOKCLSubListVOs;
	}

	public void setPriSpScpTrspAddChgCombo1VO(PriSpScpTrspAddChgCombo1VO priSpScpTrspAddChgCombo1VO){
		this.priSpScpTrspAddChgCombo1VO = priSpScpTrspAddChgCombo1VO;
	}
	public void setPriSpScpTrspAddChgCombo1VOS(PriSpScpTrspAddChgCombo1VO[] priSpScpTrspAddChgCombo1VOs){
		this.priSpScpTrspAddChgCombo1VOs = priSpScpTrspAddChgCombo1VOs;
	}
	
	public void setPriSpScpTrspAddChgGriArbOKCLAllListVO(PriSpScpTrspAddChgGriArbOKCLAllListVO priSpScpTrspAddChgGriArbOKCLAllListVO){
		this.priSpScpTrspAddChgGriArbOKCLAllListVO = priSpScpTrspAddChgGriArbOKCLAllListVO;
	}
	public void setPriSpScpTrspAddChgGriArbOKCLAllListVOS(PriSpScpTrspAddChgGriArbOKCLAllListVO[] priSpScpTrspAddChgGriArbOKCLAllListVOs){
		this.priSpScpTrspAddChgGriArbOKCLAllListVOs = priSpScpTrspAddChgGriArbOKCLAllListVOs;
	}

	public void setPriSpScpTrspAddChgGriArbOKCLArbitraryListVO(PriSpScpTrspAddChgGriArbOKCLArbitraryListVO priSpScpTrspAddChgGriArbOKCLArbitraryListVO){
		this.priSpScpTrspAddChgGriArbOKCLArbitraryListVO = priSpScpTrspAddChgGriArbOKCLArbitraryListVO;
	}
	public void setPriSpScpTrspAddChgGriArbOKCLArbitraryListVOS(PriSpScpTrspAddChgGriArbOKCLArbitraryListVO[] priSpScpTrspAddChgGriArbOKCLArbitraryListVOs){
		this.priSpScpTrspAddChgGriArbOKCLArbitraryListVOs = priSpScpTrspAddChgGriArbOKCLArbitraryListVOs;
	}

	public void setPriSpScpArbGriGrpVO(PriSpScpArbGriGrpVO priSpScpArbGriGrpVO){
		this.priSpScpArbGriGrpVO = priSpScpArbGriGrpVO;
	}
	public void setPriSpScpArbGriGrpVOS(PriSpScpArbGriGrpVO[] priSpScpArbGriGrpVOs){
		this.priSpScpArbGriGrpVOs = priSpScpArbGriGrpVOs;
	}
	
	public void setPriSpScpArbGriRtVO(PriSpScpArbGriRtVO priSpScpArbGriRtVO){
		this.priSpScpArbGriRtVO = priSpScpArbGriRtVO;
	}
	public void setPriSpScpArbGriRtVOS(PriSpScpArbGriRtVO[] priSpScpArbGriRtVOs){
		this.priSpScpArbGriRtVOs = priSpScpArbGriRtVOs;
	}
	
	/** Get */
	public PriSpScpTrspAddChgGriArbOKCLListVO getPriSpScpTrspAddChgGriArbOKCLListVO(){
		return priSpScpTrspAddChgGriArbOKCLListVO;
	}
	public PriSpScpTrspAddChgGriArbOKCLListVO[] getPriSpScpTrspAddChgGriArbOKCLListVOS(){
		return priSpScpTrspAddChgGriArbOKCLListVOs;
	}

	public PriSpScpTrspAddChgGriArbOKCLSubListVO getPriSpScpTrspAddChgGriArbOKCLSubListVO(){
		return priSpScpTrspAddChgGriArbOKCLSubListVO;
	}
	public PriSpScpTrspAddChgGriArbOKCLSubListVO[] getPriSpScpTrspAddChgGriArbOKCLSubListVOS(){
		return priSpScpTrspAddChgGriArbOKCLSubListVOs;
	}
	
	public PriSpScpTrspAddChgCombo1VO getPriSpScpTrspAddChgCombo1VO(){
		return priSpScpTrspAddChgCombo1VO;
	}
	public PriSpScpTrspAddChgCombo1VO[] getPriSpScpTrspAddChgCombo1VOS(){
		return priSpScpTrspAddChgCombo1VOs;
	}
	
	public PriSpScpTrspAddChgGriArbOKCLAllListVO getPriSpScpTrspAddChgGriArbOKCLAllListVO(){
		return priSpScpTrspAddChgGriArbOKCLAllListVO;
	}
	public PriSpScpTrspAddChgGriArbOKCLAllListVO[] getPriSpScpTrspAddChgGriArbOKCLAllListVOS(){
		return priSpScpTrspAddChgGriArbOKCLAllListVOs;
	}

	public PriSpScpTrspAddChgGriArbOKCLArbitraryListVO getPriSpScpTrspAddChgGriArbOKCLArbitraryListVO(){
		return priSpScpTrspAddChgGriArbOKCLArbitraryListVO;
	}
	public PriSpScpTrspAddChgGriArbOKCLArbitraryListVO[] getPriSpScpTrspAddChgGriArbOKCLArbitraryListVOS(){
		return priSpScpTrspAddChgGriArbOKCLArbitraryListVOs;
	}

	public PriSpScpArbGriGrpVO getPriSpScpArbGriGrpVO(){
		return priSpScpArbGriGrpVO;
	}
	public PriSpScpArbGriGrpVO[] getPriSpScpArbGriGrpVOS(){
		return priSpScpArbGriGrpVOs;
	}
	
	public PriSpScpArbGriRtVO getPriSpScpArbGriRtVO(){
		return priSpScpArbGriRtVO;
	}
	public PriSpScpArbGriRtVO[] getPriSpScpArbGriRtVOS(){
		return priSpScpArbGriRtVOs;
	}

	
}