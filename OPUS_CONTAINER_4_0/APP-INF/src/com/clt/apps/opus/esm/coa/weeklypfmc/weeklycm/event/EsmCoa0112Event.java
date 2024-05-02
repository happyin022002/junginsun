/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0112Event.java
*@FileTitle : VVD Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006.10.23 박은주 최초 생성
* 2009.09.08 박수훈 0112 화면 New Framework 적용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDChkWithARListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaMonVvdVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0112 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0112HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SOO HOON PARK
 * @see ESM_COA_0112HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0112Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchVVDChkWithARListVO searchVVDChkWithARListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchVVDChkWithARListVO[] searchVVDChkWithARListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaMonVvdVO coaMonVvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaMonVvdVO[] coaMonVvdVOs = null;
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmCoa0112Event(){}
	
	public void setSearchVVDChkWithARListVO(SearchVVDChkWithARListVO searchVVDChkWithARListVO){
		this. searchVVDChkWithARListVO = searchVVDChkWithARListVO;
	}
	//SJH.20150508.소스품질
	public void setSearchVVDChkWithARListVOS(SearchVVDChkWithARListVO[] searchVVDChkWithARListVOs){
		if(searchVVDChkWithARListVOs != null){
			SearchVVDChkWithARListVO[] tmpVOs = Arrays.copyOf(searchVVDChkWithARListVOs, searchVVDChkWithARListVOs.length);
			this.searchVVDChkWithARListVOs = tmpVOs;
		}
	}

	public void setCoaMonVvdVO(CoaMonVvdVO coaMonVvdVO){
		this. coaMonVvdVO = coaMonVvdVO;
	}
	//SJH.20150508.소스품질
	public void setCoaMonVvdVOS(CoaMonVvdVO[] coaMonVvdVOs){
		if(coaMonVvdVOs != null){
			CoaMonVvdVO[] tmpVOs = Arrays.copyOf(coaMonVvdVOs, coaMonVvdVOs.length);
			this.coaMonVvdVOs = tmpVOs;
		}
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}

	public SearchVVDChkWithARListVO getSearchVVDChkWithARListVO(){
		return searchVVDChkWithARListVO;
	}
	//SJH.20150508.소스품질
	public SearchVVDChkWithARListVO[] getSearchVVDChkWithARListVOS(){
		SearchVVDChkWithARListVO[] rtnVOs = null;
		if (this.searchVVDChkWithARListVOs != null) {
			rtnVOs = Arrays.copyOf(searchVVDChkWithARListVOs, searchVVDChkWithARListVOs.length);
		}
		return rtnVOs;
	}

	public CoaMonVvdVO getCoaMonVvdVO(){
		return coaMonVvdVO;
	}
	//SJH.20150508.소스품질
	public CoaMonVvdVO[] getCoaMonVvdVOS(){
		CoaMonVvdVO[] rtnVOs = null;
		if (this.coaMonVvdVOs != null) {
			rtnVOs = Arrays.copyOf(coaMonVvdVOs, coaMonVvdVOs.length);
		}
		return rtnVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}