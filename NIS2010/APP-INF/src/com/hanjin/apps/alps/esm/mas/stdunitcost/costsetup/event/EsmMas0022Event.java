/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmMas0022Event.java
*@FileTitle : MTY Reposition Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.07
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2012.12.07 송호진
* 1.0 Creation
=========================================================
* History
* 2012.12.13 송호진 [CHM-201221879] [MAS] Manual Cost Set up 화면 로직 수정 ( 파일 신규 생성 )
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.vo.MtyRepoTESTRSCostVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_MAS_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SongHoJin
 * @see ESM_MAS_0022HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchConditionVO[] searchConditionVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MtyRepoTESTRSCostVO mtyRepoTESTRSCostVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOs = null;

	private String key = "";
	
	public EsmMas0022Event(){}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}

	public void setSearchConditionVOS(SearchConditionVO[] searchConditionVOs){
		this. searchConditionVOs = searchConditionVOs;
	}

	public void setMtyRepoTESTRSCostVO(MtyRepoTESTRSCostVO mtyRepoTESTRSCostVO){
		this. mtyRepoTESTRSCostVO = mtyRepoTESTRSCostVO;
	}

	public void setMtyRepoTESTRSCostVOS(MtyRepoTESTRSCostVO[] mtyRepoTESTRSCostVOs){
		this. mtyRepoTESTRSCostVOs = mtyRepoTESTRSCostVOs;
	}

	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

	public SearchConditionVO[] getSearchConditionVOS(){
		return searchConditionVOs;
	}

	public MtyRepoTESTRSCostVO getMtyRepoTESTRSCostVO(){
		return mtyRepoTESTRSCostVO;
	}

	public MtyRepoTESTRSCostVO[] getMtyRepoTESTRSCostVOS(){
		return mtyRepoTESTRSCostVOs;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	

}