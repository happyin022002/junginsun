/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0020Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.eqholding.vo.EqDayMgmtVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0020HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0020Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private EqDayMgmtVO eqDayMgmtVO = null;	
	
	/** Multi Data 처리 - Create/Update/Delete */
	private EqDayMgmtVO[] eqDayMgmtVOs = null;
	

	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;
	

	/** Constructor */
	public EsmMas0020Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmMas0020Event";
	}

	/** ValueObject Setter */
	public void setEqDayMgmtVO(EqDayMgmtVO eqDayMgmtVO){
		this.eqDayMgmtVO = eqDayMgmtVO;
	}
	/** ValueObject Getter */
	public EqDayMgmtVO getEqDayMgmtVO(){
		return eqDayMgmtVO;
	}	
	
	/** ValueObject Array Getter - Create/Update/Delete */	
	public EqDayMgmtVO[] getEqDayMgmtVOs() {
//		return networkCostExceptionListVOs;
		EqDayMgmtVO[] rtnVOs = null;
		if (this.eqDayMgmtVOs != null) {
			rtnVOs = new EqDayMgmtVO[eqDayMgmtVOs.length];
			System.arraycopy(eqDayMgmtVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	/** ValueObject Array Setter - Create/Update/Delete */	
	public void setEqDayMgmtVOs(EqDayMgmtVO[] eqDayMgmtVOs) {
//		this.eqDayMgmtVOs = eqDayMgmtVOs;
		if (eqDayMgmtVOs != null) {
			EqDayMgmtVO[] tmpVOs = new EqDayMgmtVO[eqDayMgmtVOs.length];
			System.arraycopy(eqDayMgmtVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eqDayMgmtVOs = tmpVOs;
		}
	}

	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}		
		
}
