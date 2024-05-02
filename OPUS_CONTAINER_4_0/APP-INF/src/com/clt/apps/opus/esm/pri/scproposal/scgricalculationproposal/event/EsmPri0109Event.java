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
package com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.event;


import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgCombo1VO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLAllListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLArbitraryListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLSubListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.PriSpScpArbGriGrpVO;
import com.clt.syscommon.common.table.PriSpScpArbGriRtVO;

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
		if (priSpScpTrspAddChgGriArbOKCLListVOs != null) {
			PriSpScpTrspAddChgGriArbOKCLListVO[] tmpVOs = new PriSpScpTrspAddChgGriArbOKCLListVO[priSpScpTrspAddChgGriArbOKCLListVOs.length];
			System.arraycopy(priSpScpTrspAddChgGriArbOKCLListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpTrspAddChgGriArbOKCLListVOs = tmpVOs;
		}
	}

	public void setPriSpScpTrspAddChgGriArbOKCLSubListVO(PriSpScpTrspAddChgGriArbOKCLSubListVO priSpScpTrspAddChgGriArbOKCLSubListVO){
		this.priSpScpTrspAddChgGriArbOKCLSubListVO = priSpScpTrspAddChgGriArbOKCLSubListVO;
	}
	public void setPriSpScpTrspAddChgGriArbOKCLSubListVOS(PriSpScpTrspAddChgGriArbOKCLSubListVO[] priSpScpTrspAddChgGriArbOKCLSubListVOs){
		if (priSpScpTrspAddChgGriArbOKCLSubListVOs != null) {
			PriSpScpTrspAddChgGriArbOKCLSubListVO[] tmpVOs = new PriSpScpTrspAddChgGriArbOKCLSubListVO[priSpScpTrspAddChgGriArbOKCLSubListVOs.length];
			System.arraycopy(priSpScpTrspAddChgGriArbOKCLSubListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpTrspAddChgGriArbOKCLSubListVOs = tmpVOs;
		}
	}

	public void setPriSpScpTrspAddChgCombo1VO(PriSpScpTrspAddChgCombo1VO priSpScpTrspAddChgCombo1VO){
		this.priSpScpTrspAddChgCombo1VO = priSpScpTrspAddChgCombo1VO;
	}
	public void setPriSpScpTrspAddChgCombo1VOS(PriSpScpTrspAddChgCombo1VO[] priSpScpTrspAddChgCombo1VOs){
		if (priSpScpTrspAddChgCombo1VOs != null) {
			PriSpScpTrspAddChgCombo1VO[] tmpVOs = new PriSpScpTrspAddChgCombo1VO[priSpScpTrspAddChgCombo1VOs.length];
			System.arraycopy(priSpScpTrspAddChgCombo1VOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpTrspAddChgCombo1VOs = tmpVOs;
		}
	}
	
	public void setPriSpScpTrspAddChgGriArbOKCLAllListVO(PriSpScpTrspAddChgGriArbOKCLAllListVO priSpScpTrspAddChgGriArbOKCLAllListVO){
		this.priSpScpTrspAddChgGriArbOKCLAllListVO = priSpScpTrspAddChgGriArbOKCLAllListVO;
	}
	public void setPriSpScpTrspAddChgGriArbOKCLAllListVOS(PriSpScpTrspAddChgGriArbOKCLAllListVO[] priSpScpTrspAddChgGriArbOKCLAllListVOs){
		if (priSpScpTrspAddChgGriArbOKCLAllListVOs != null) {
			PriSpScpTrspAddChgGriArbOKCLAllListVO[] tmpVOs = new PriSpScpTrspAddChgGriArbOKCLAllListVO[priSpScpTrspAddChgGriArbOKCLAllListVOs.length];
			System.arraycopy(priSpScpTrspAddChgGriArbOKCLAllListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpTrspAddChgGriArbOKCLAllListVOs = tmpVOs;
		}
	}

	public void setPriSpScpTrspAddChgGriArbOKCLArbitraryListVO(PriSpScpTrspAddChgGriArbOKCLArbitraryListVO priSpScpTrspAddChgGriArbOKCLArbitraryListVO){
		this.priSpScpTrspAddChgGriArbOKCLArbitraryListVO = priSpScpTrspAddChgGriArbOKCLArbitraryListVO;
	}
	public void setPriSpScpTrspAddChgGriArbOKCLArbitraryListVOS(PriSpScpTrspAddChgGriArbOKCLArbitraryListVO[] priSpScpTrspAddChgGriArbOKCLArbitraryListVOs){
		if (priSpScpTrspAddChgGriArbOKCLArbitraryListVOs != null) {
			PriSpScpTrspAddChgGriArbOKCLArbitraryListVO[] tmpVOs = new PriSpScpTrspAddChgGriArbOKCLArbitraryListVO[priSpScpTrspAddChgGriArbOKCLArbitraryListVOs.length];
			System.arraycopy(priSpScpTrspAddChgGriArbOKCLArbitraryListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpTrspAddChgGriArbOKCLArbitraryListVOs = tmpVOs;
		}
	}
	public void setPriSpScpArbGriGrpVO(PriSpScpArbGriGrpVO priSpScpArbGriGrpVO){
		this.priSpScpArbGriGrpVO = priSpScpArbGriGrpVO;
	}
	public void setPriSpScpArbGriGrpVOS(PriSpScpArbGriGrpVO[] priSpScpArbGriGrpVOs){
		if (priSpScpArbGriGrpVOs != null) {
			PriSpScpArbGriGrpVO[] tmpVOs = new PriSpScpArbGriGrpVO[priSpScpArbGriGrpVOs.length];
			System.arraycopy(priSpScpArbGriGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpArbGriGrpVOs = tmpVOs;
		}
	}
	
	public void setPriSpScpArbGriRtVO(PriSpScpArbGriRtVO priSpScpArbGriRtVO){
		this.priSpScpArbGriRtVO = priSpScpArbGriRtVO;
	}
	public void setPriSpScpArbGriRtVOS(PriSpScpArbGriRtVO[] priSpScpArbGriRtVOs){
		if (priSpScpArbGriRtVOs != null) {
			PriSpScpArbGriRtVO[] tmpVOs = new PriSpScpArbGriRtVO[priSpScpArbGriRtVOs.length];
			System.arraycopy(priSpScpArbGriRtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priSpScpArbGriRtVOs = tmpVOs;
		}
	}
	
	/** Get */
	public PriSpScpTrspAddChgGriArbOKCLListVO getPriSpScpTrspAddChgGriArbOKCLListVO(){
		return priSpScpTrspAddChgGriArbOKCLListVO;
	}
	public PriSpScpTrspAddChgGriArbOKCLListVO[] getPriSpScpTrspAddChgGriArbOKCLListVOS(){
		PriSpScpTrspAddChgGriArbOKCLListVO[] tmpVOs = null;
		if (this.priSpScpTrspAddChgGriArbOKCLListVOs != null) {
			tmpVOs = new PriSpScpTrspAddChgGriArbOKCLListVO[priSpScpTrspAddChgGriArbOKCLListVOs.length];
			System.arraycopy(priSpScpTrspAddChgGriArbOKCLListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSpScpTrspAddChgGriArbOKCLSubListVO getPriSpScpTrspAddChgGriArbOKCLSubListVO(){
		return priSpScpTrspAddChgGriArbOKCLSubListVO;
	}
	public PriSpScpTrspAddChgGriArbOKCLSubListVO[] getPriSpScpTrspAddChgGriArbOKCLSubListVOS(){
		PriSpScpTrspAddChgGriArbOKCLSubListVO[] tmpVOs = null;
		if (this.priSpScpTrspAddChgGriArbOKCLSubListVOs != null) {
			tmpVOs = new PriSpScpTrspAddChgGriArbOKCLSubListVO[priSpScpTrspAddChgGriArbOKCLSubListVOs.length];
			System.arraycopy(priSpScpTrspAddChgGriArbOKCLSubListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriSpScpTrspAddChgCombo1VO getPriSpScpTrspAddChgCombo1VO(){
		return priSpScpTrspAddChgCombo1VO;
	}
	public PriSpScpTrspAddChgCombo1VO[] getPriSpScpTrspAddChgCombo1VOS(){
		PriSpScpTrspAddChgCombo1VO[] tmpVOs = null;
		if (this.priSpScpTrspAddChgCombo1VOs != null) {
			tmpVOs = new PriSpScpTrspAddChgCombo1VO[priSpScpTrspAddChgCombo1VOs.length];
			System.arraycopy(priSpScpTrspAddChgCombo1VOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriSpScpTrspAddChgGriArbOKCLAllListVO getPriSpScpTrspAddChgGriArbOKCLAllListVO(){
		return priSpScpTrspAddChgGriArbOKCLAllListVO;
	}
	public PriSpScpTrspAddChgGriArbOKCLAllListVO[] getPriSpScpTrspAddChgGriArbOKCLAllListVOS(){
		PriSpScpTrspAddChgGriArbOKCLAllListVO[] tmpVOs = null;
		if (this.priSpScpTrspAddChgGriArbOKCLAllListVOs != null) {
			tmpVOs = new PriSpScpTrspAddChgGriArbOKCLAllListVO[priSpScpTrspAddChgGriArbOKCLAllListVOs.length];
			System.arraycopy(priSpScpTrspAddChgGriArbOKCLAllListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSpScpTrspAddChgGriArbOKCLArbitraryListVO getPriSpScpTrspAddChgGriArbOKCLArbitraryListVO(){
		return priSpScpTrspAddChgGriArbOKCLArbitraryListVO;
	}
	public PriSpScpTrspAddChgGriArbOKCLArbitraryListVO[] getPriSpScpTrspAddChgGriArbOKCLArbitraryListVOS(){
		PriSpScpTrspAddChgGriArbOKCLArbitraryListVO[] tmpVOs = null;
		if (this.priSpScpTrspAddChgGriArbOKCLArbitraryListVOs != null) {
			tmpVOs = new PriSpScpTrspAddChgGriArbOKCLArbitraryListVO[priSpScpTrspAddChgGriArbOKCLArbitraryListVOs.length];
			System.arraycopy(priSpScpTrspAddChgGriArbOKCLArbitraryListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public PriSpScpArbGriGrpVO getPriSpScpArbGriGrpVO(){
		return priSpScpArbGriGrpVO;
	}
	public PriSpScpArbGriGrpVO[] getPriSpScpArbGriGrpVOS(){
		PriSpScpArbGriGrpVO[] tmpVOs = null;
		if (this.priSpScpArbGriGrpVOs != null) {
			tmpVOs = new PriSpScpArbGriGrpVO[priSpScpArbGriGrpVOs.length];
			System.arraycopy(priSpScpArbGriGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public PriSpScpArbGriRtVO getPriSpScpArbGriRtVO(){
		return priSpScpArbGriRtVO;
	}
	public PriSpScpArbGriRtVO[] getPriSpScpArbGriRtVOS(){
		PriSpScpArbGriRtVO[] tmpVOs = null;
		if (this.priSpScpArbGriRtVOs != null) {
			tmpVOs = new PriSpScpArbGriRtVO[priSpScpArbGriRtVOs.length];
			System.arraycopy(priSpScpArbGriRtVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	
}