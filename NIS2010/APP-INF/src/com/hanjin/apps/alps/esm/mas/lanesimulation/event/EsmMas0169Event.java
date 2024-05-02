/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : EsmMas0169Event.java
*@FileTitle      : 
*Open Issues     :
*Change history  :
*@LastModifyDate : 2007-12-18
*@LastModifier   : eunju park
*@LastVersion    : 1.0
* 2007-11-12 eunju park
* 1.0 최초 생성
* 2009.03.31 임옥영 S2K-09U-002(Lane Simulation System 개선)
* 2009.08.21 박은주 Alps전환작업 [ESM_MAS_0169]
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchTsVolumeVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasSimIntrTrnsVolVO;


/**
 *  1. 기능 : ESM_MAS_0169 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *  2. 처리개요 : <p>
 *    - ESM_MAS_0169HTMLAction에서 작성 <p>
 *    - ServiceCommand Layer로 전달하는 PDTO로 사용 <p>
 * 3. 주의사항 : <p>
 * ===================================<br>
 * 4. 작성자/작성일 : Yoon jin young/2009.08.28<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 * - 수정자/수정일 :<p>
 * - 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 *
 * @author Yoon jin young
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmMas0169Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/**/
	private SearchConditionVO searchConditionVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTsVolumeVO searchSimTsVolVO = null;
	/** Table Value Object Multi Data 처리 */
	private SearchTsVolumeVO[] searchSimTsVolVOs = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasSimIntrTrnsVolVO masSimIntrTrnsVolVO = null;
	/** Table Value Object Multi Data 처리 */
	private MasSimIntrTrnsVolVO[] masSimIntrTrnsVolVOs = null;
	public EsmMas0169Event(){}
	public void setSearchTsVolumeVO(SearchTsVolumeVO searchTsVolumeVO){
		this. searchSimTsVolVO = searchTsVolumeVO;
	}
	public void setSearchTsVolumeVOS(SearchTsVolumeVO[] searchTsVolumeVOs){
		this. searchSimTsVolVOs = searchTsVolumeVOs;
	}
	public void setMasSimIntrTrnsVolVO(MasSimIntrTrnsVolVO masSimIntrTrnsVolVO){
		this. masSimIntrTrnsVolVO = masSimIntrTrnsVolVO;
	}
	public void setMasSimIntrTrnsVolVOS(MasSimIntrTrnsVolVO[] masSimIntrTrnsVolVOs){
		this. masSimIntrTrnsVolVOs = masSimIntrTrnsVolVOs;
	}
	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}
	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}
	public SearchTsVolumeVO getSearchTsVolumeVO(){
		return searchSimTsVolVO;
	}
	public SearchTsVolumeVO[] getSearchTsVolumeVOS(){
		return searchSimTsVolVOs;
	}

	public MasSimIntrTrnsVolVO getMasSimIntrTrnsVolVO(){
		return masSimIntrTrnsVolVO;
	}

	public MasSimIntrTrnsVolVO[] getMasSimIntrTrnsVolVOS(){
		return masSimIntrTrnsVolVOs;
	}
	    
	/**
	 * Event 명을 반환한다.
	 */
	public String getEventName() {
        return "EsmMas0169Event";
    }

	/**
	 * Event 명을 반환한다.
	 */
    public String toString() {
        return "EsmMas0169Event";
    }

}
