/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg0445Event.java
*@FileTitle : SI Split Candidate
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.18
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.05.18 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsSiSplitBkgCntrHisVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsSiSplitCandidateVO;


/**
 * ESM_BKG_0445 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0445HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0445HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0445Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DpcsSiSplitCandidateVO dpcsSiSplitCandidateVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DpcsSiSplitCandidateVO[] dpcsSiSplitCandidateVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DpcsSiSplitBkgCntrHisVO dpcsSiSplitBkgCntrHisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DpcsSiSplitBkgCntrHisVO[] dpcsSiSplitBkgCntrHisVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SplitBlInfoVO SplitBlInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SplitBlInfoVO[] SplitBlInfoVOs = null;
	
	
	public EsmBkg0445Event(){}
	
	public void setDpcsSiSplitCandidateVO(DpcsSiSplitCandidateVO dpcsSiSplitCandidateVO){
		this. dpcsSiSplitCandidateVO = dpcsSiSplitCandidateVO;
	}

	public void setDpcsSiSplitCandidateVOS(DpcsSiSplitCandidateVO[] dpcsSiSplitCandidateVOs){
		if(dpcsSiSplitCandidateVOs != null){
			DpcsSiSplitCandidateVO[] tmpVOs = Arrays.copyOf(dpcsSiSplitCandidateVOs, dpcsSiSplitCandidateVOs.length);
			this.dpcsSiSplitCandidateVOs = tmpVOs;
		}
	}

	public DpcsSiSplitCandidateVO getDpcsSiSplitCandidateVO(){
		return dpcsSiSplitCandidateVO;
	}

	public DpcsSiSplitCandidateVO[] getDpcsSiSplitCandidateVOS(){
		DpcsSiSplitCandidateVO[] rtnVOs = null;
		if (this.dpcsSiSplitCandidateVOs != null) {
			rtnVOs = Arrays.copyOf(dpcsSiSplitCandidateVOs, dpcsSiSplitCandidateVOs.length);
		}
		return rtnVOs;
	}

	public DpcsSiSplitBkgCntrHisVO getDpcsSiSplitBkgCntrHisVO() {
		return dpcsSiSplitBkgCntrHisVO;
	}

	public void setDpcsSiSplitBkgCntrHisVO(
			DpcsSiSplitBkgCntrHisVO dpcsSiSplitBkgCntrHisVO) {
		this.dpcsSiSplitBkgCntrHisVO = dpcsSiSplitBkgCntrHisVO;
	}

	public DpcsSiSplitBkgCntrHisVO[] getDpcsSiSplitBkgCntrHisVOs() {
		DpcsSiSplitBkgCntrHisVO[] rtnVOs = null;
		if (this.dpcsSiSplitBkgCntrHisVOs != null) {
			rtnVOs = Arrays.copyOf(dpcsSiSplitBkgCntrHisVOs, dpcsSiSplitBkgCntrHisVOs.length);
		}
		return rtnVOs;
	}

	public void setDpcsSiSplitBkgCntrHisVOs(DpcsSiSplitBkgCntrHisVO[] dpcsSiSplitBkgCntrHisVOs){
		if(dpcsSiSplitBkgCntrHisVOs != null){
			DpcsSiSplitBkgCntrHisVO[] tmpVOs = Arrays.copyOf(dpcsSiSplitBkgCntrHisVOs, dpcsSiSplitBkgCntrHisVOs.length);
			this.dpcsSiSplitBkgCntrHisVOs = tmpVOs;
		}
	}

	public SplitBlInfoVO getSplitBlInfoVO() {
		return SplitBlInfoVO;
	}

	public void setSplitBlInfoVO(SplitBlInfoVO splitBlInfoVO) {
		this.SplitBlInfoVO = splitBlInfoVO;
	}

	public SplitBlInfoVO[] getSplitBlInfoVOs() {
		SplitBlInfoVO[] rtnVOs = null;
		if (this.SplitBlInfoVOs != null) {
			rtnVOs = Arrays.copyOf(SplitBlInfoVOs, SplitBlInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setSplitBlInfoVOs(SplitBlInfoVO[] splitBlInfoVOs){
		if(splitBlInfoVOs != null){
			SplitBlInfoVO[] tmpVOs = Arrays.copyOf(splitBlInfoVOs, splitBlInfoVOs.length);
			this.SplitBlInfoVOs = tmpVOs;
		}
	}

	
}