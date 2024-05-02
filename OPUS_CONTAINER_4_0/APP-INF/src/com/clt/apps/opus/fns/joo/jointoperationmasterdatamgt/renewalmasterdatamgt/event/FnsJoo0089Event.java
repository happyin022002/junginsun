/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0002Event.java
*@FileTitle : Entry and Inquiry of Financial Affairs
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.04.28 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.event;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.FinancialAffairsMtxGrpVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.FinancialAffairsMtxVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.vo.MstConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * UI_JOO_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_JOO_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0002HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsJoo0089Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FinancialAffairsMtxVO financialAffairsMtxVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private FinancialAffairsMtxVO[] financialAffairsMtxVOs = null;
	
	private MstConditionVO mstConditionVO = null;
	
	private FinancialAffairsMtxGrpVO financialAffairsMtxGrpVO = new FinancialAffairsMtxGrpVO(); 

	public FnsJoo0089Event(){}
	
	public void setFinancialAffairsMtxVO(FinancialAffairsMtxVO financialAffairsMtxVO){
		this.financialAffairsMtxVO = financialAffairsMtxVO;
	}

	public void setFinancialAffairsMtxVOS(FinancialAffairsMtxVO[] financialAffairsMtxVOs){
		if (financialAffairsMtxVOs != null) {
			FinancialAffairsMtxVO[] tmpVOs = new FinancialAffairsMtxVO[financialAffairsMtxVOs.length];
			System.arraycopy(financialAffairsMtxVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.financialAffairsMtxVOs = tmpVOs;
		}
	}

	public void setMstConditionVO(MstConditionVO mstConditionVO){
		this.mstConditionVO = mstConditionVO;
	}

	public FinancialAffairsMtxVO getFinancialAffairsMtxVO(){
		return financialAffairsMtxVO;
	}

	public FinancialAffairsMtxVO[] getFinancialAffairsMtxVOS(){
		FinancialAffairsMtxVO[] tmpVOs = null;
		if (this.financialAffairsMtxVOs != null) {
			tmpVOs = new FinancialAffairsMtxVO[financialAffairsMtxVOs.length];
			System.arraycopy(financialAffairsMtxVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setFinancialAffairsMtxGrpVO(FinancialAffairsMtxVO[] pCarFinanMtrxVOs, String reDivrCd){
		List<FinancialAffairsMtxVO> listVOs = new ArrayList<FinancialAffairsMtxVO>();
		
		if (pCarFinanMtrxVOs != null){
			for(int inx=0; inx<pCarFinanMtrxVOs.length; inx++){
				listVOs.add(pCarFinanMtrxVOs[inx]);
			}
		}
		if ("R".equals(reDivrCd)){
			financialAffairsMtxGrpVO.setRevenueFinancialAffairsMtxVOs(listVOs);
		}else{
			financialAffairsMtxGrpVO.setExpenseFinancialAffairsMtxVOs(listVOs);
		}
	}
	
	public FinancialAffairsMtxGrpVO getFinancialAffairsMtxGrpVO(){
		return financialAffairsMtxGrpVO;
	}

	
	public MstConditionVO getMstConditionVO(){
		return mstConditionVO;
	}

}