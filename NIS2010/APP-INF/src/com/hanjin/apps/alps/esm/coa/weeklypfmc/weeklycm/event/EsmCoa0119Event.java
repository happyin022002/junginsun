/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0119Event.java
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
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CoaTmlTrfGrpVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchUOM0119ListVO;


/**
 * ESM_COA_0119 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0119HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_COA_0119HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0119Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaTmlTrfGrpVO coaTmlTrfGrpVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaTmlTrfGrpVO[] coaTmlTrfGrpVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchUOM0119ListVO searchUOM0119ListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchUOM0119ListVO[] searchUOM0119ListVOs = null;

	public EsmCoa0119Event(){}
	
	public void setCoaTmlTrfGrpVO(CoaTmlTrfGrpVO coaTmlTrfGrpVO){
		this. coaTmlTrfGrpVO = coaTmlTrfGrpVO;
	}

	public void setCoaTmlTrfGrpVOS(CoaTmlTrfGrpVO[] coaTmlTrfGrpVOs){
		this. coaTmlTrfGrpVOs = coaTmlTrfGrpVOs;
	}

	public void setSearchUOM0119ListVO(SearchUOM0119ListVO searchUOM0119ListVO){
		this. searchUOM0119ListVO = searchUOM0119ListVO;
	}

	public void setSearchUOM0119ListVOS(SearchUOM0119ListVO[] searchUOM0119ListVOs){
		this. searchUOM0119ListVOs = searchUOM0119ListVOs;
	}

	public CoaTmlTrfGrpVO getCoaTmlTrfGrpVO(){
		return coaTmlTrfGrpVO;
	}

	public CoaTmlTrfGrpVO[] getCoaTmlTrfGrpVOS(){
		return coaTmlTrfGrpVOs;
	}

	public SearchUOM0119ListVO getSearchUOM0119ListVO(){
		return searchUOM0119ListVO;
	}

	public SearchUOM0119ListVO[] getSearchUOM0119ListVOS(){
		return searchUOM0119ListVOs;
	}

}