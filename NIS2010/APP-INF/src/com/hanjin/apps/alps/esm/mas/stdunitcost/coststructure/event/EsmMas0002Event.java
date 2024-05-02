/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0002Event.java
*@FileTitle : EsmMas0002Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.EsmMas0002ComboVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasStndAcctVO;


/**
 * ESM_MAS_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_MAS_0002HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0002Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SearchConditionVO[] mSearchConditionVOs = null;	
	
	
	/** 단건처리 */
	private MasStndAcctVO mMasStndAcctVO = null;
	
	/** Multi Data 처리 */
	private MasStndAcctVO[] mMasStndAcctVOs = null;
	
	
	
	/** combo 조건 단건처리 */
	private EsmMas0002ComboVO mComboVO = null;		
	
	/**
	 * EsmMas0002Event class의 생성자
	 *
	 */
	public EsmMas0002Event(){}
	
	/**
	 * 클래스 명 리턴 
	 *
	 */
	public String getEventName() {
		return "EsmMas0002Event";
	}

	/**
	 * toString
	 *
	 */
	public String toString() {
		return "EsmMas0002Event";
	}


	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setSearchConditionVOs(SearchConditionVO[] searchConditionVOs){
		mSearchConditionVOs = searchConditionVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public SearchConditionVO[] getSearchConditionVOs(){
		return mSearchConditionVOs;
	}	

	
	/** ValueObject Setter */
	public void setMasStndAcctVO(MasStndAcctVO masStndAcctVO){
		this.mMasStndAcctVO = masStndAcctVO;
	}
	/** ValueObject Getter */
	public MasStndAcctVO getMasStndAcctVO(){
		return mMasStndAcctVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setMasStndAcctVOs(MasStndAcctVO[] masStndAcctVOs){
		mMasStndAcctVOs = masStndAcctVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public MasStndAcctVO[] getMasStndAcctVOs(){
		return mMasStndAcctVOs;
	}	

	
	public void setComboVO(EsmMas0002ComboVO comboVO){
		this.mComboVO = comboVO;
	}
	public EsmMas0002ComboVO getComboVO(){
		return mComboVO;
	}		
}
