/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0119Event.java
*@FileTitle : Acct Code Setting to select UOM
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2007.02.14 임옥영  최초 생성
* 2009.10.09 박수훈  0119  화면 New Framework 적용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasTmlTrfGrpVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchUOM0119ListVO;


/**
 * ESM_MAS_0119 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0119HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_MAS_0119HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0119Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasTmlTrfGrpVO masTmlTrfGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MasTmlTrfGrpVO[] masTmlTrfGrpVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchUOM0119ListVO searchUOM0119ListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchUOM0119ListVO[] searchUOM0119ListVOs = null;

	public EsmMas0119Event(){}
	
	public void setMasTmlTrfGrpVO(MasTmlTrfGrpVO masTmlTrfGrpVO){
		this. masTmlTrfGrpVO = masTmlTrfGrpVO;
	}

	public void setMasTmlTrfGrpVOS(MasTmlTrfGrpVO[] masTmlTrfGrpVOs){
		this. masTmlTrfGrpVOs = masTmlTrfGrpVOs;
	}

	public void setSearchUOM0119ListVO(SearchUOM0119ListVO searchUOM0119ListVO){
		this. searchUOM0119ListVO = searchUOM0119ListVO;
	}

	public void setSearchUOM0119ListVOS(SearchUOM0119ListVO[] searchUOM0119ListVOs){
		this. searchUOM0119ListVOs = searchUOM0119ListVOs;
	}

	public MasTmlTrfGrpVO getMasTmlTrfGrpVO(){
		return masTmlTrfGrpVO;
	}

	public MasTmlTrfGrpVO[] getMasTmlTrfGrpVOS(){
		return masTmlTrfGrpVOs;
	}

	public SearchUOM0119ListVO getSearchUOM0119ListVO(){
		return searchUOM0119ListVO;
	}

	public SearchUOM0119ListVO[] getSearchUOM0119ListVOS(){
		return searchUOM0119ListVOs;
	}

}