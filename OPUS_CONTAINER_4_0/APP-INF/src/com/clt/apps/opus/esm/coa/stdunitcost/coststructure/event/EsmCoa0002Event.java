/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0002Event.java
*@FileTitle : EsmCoa0002Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.EsmCoa0002ComboVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaSpclRepoCntrRgstVO;
import com.clt.syscommon.common.table.CoaStndAcctVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0002HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0002Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SearchConditionVO[] mSearchConditionVOs = null;	
	
	
	/** 단건처리 */
	private CoaStndAcctVO mCoaStndAcctVO = null;
	
	/** Multi Data 처리 */
	private CoaStndAcctVO[] mCoaStndAcctVOs = null;
	
	
	
	/** combo 조건 단건처리 */
	private EsmCoa0002ComboVO mComboVO = null;		
	
	/**
	 * EsmCoa0002Event class의 생성자
	 *
	 */
	public EsmCoa0002Event(){}
	
	/**
	 * 클래스 명 리턴 
	 *
	 */
	public String getEventName() {
		return "EsmCoa0002Event";
	}

	/**
	 * toString
	 *
	 */
	public String toString() {
		return "EsmCoa0002Event";
	}


	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */		//SJH.20150508.소스품질
	public void setSearchConditionVOs(SearchConditionVO[] searchConditionVOs){
		if(searchConditionVOs != null){
			SearchConditionVO[] tmpVOs = Arrays.copyOf(searchConditionVOs, searchConditionVOs.length);
			this.mSearchConditionVOs = tmpVOs;
		}		
	}
	/** ValueObject Array Getter - Create/Update/Delete */		//SJH.20150508.소스품질
	public SearchConditionVO[] getSearchConditionVOs(){
		SearchConditionVO[] rtnVOs = null;
		if (this.mSearchConditionVOs != null) {
			rtnVOs = Arrays.copyOf(mSearchConditionVOs, mSearchConditionVOs.length);
		}
		return rtnVOs;
	}	

	
	/** ValueObject Setter */
	public void setCoaStndAcctVO(CoaStndAcctVO coaStndAcctVO){
		this.mCoaStndAcctVO = coaStndAcctVO;
	}
	/** ValueObject Getter */
	public CoaStndAcctVO getCoaStndAcctVO(){
		return mCoaStndAcctVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */		//SJH.20150508.소스품질
	public void setCoaStndAcctVOs(CoaStndAcctVO[] coaStndAcctVOs){
		if(coaStndAcctVOs != null){
			CoaStndAcctVO[] tmpVOs = Arrays.copyOf(coaStndAcctVOs, coaStndAcctVOs.length);
			this.mCoaStndAcctVOs = tmpVOs;
		}		
	}
	/** ValueObject Array Getter - Create/Update/Delete */		//SJH.20150508.소스품질
	public CoaStndAcctVO[] getCoaStndAcctVOs(){
		CoaStndAcctVO[] rtnVOs = null;
		if (this.mCoaStndAcctVOs != null) {
			rtnVOs = Arrays.copyOf(mCoaStndAcctVOs, mCoaStndAcctVOs.length);
		}
		return rtnVOs;
	}	

	
	public void setComboVO(EsmCoa0002ComboVO comboVO){
		this.mComboVO = comboVO;
	}
	public EsmCoa0002ComboVO getComboVO(){
		return mComboVO;
	}		
}
