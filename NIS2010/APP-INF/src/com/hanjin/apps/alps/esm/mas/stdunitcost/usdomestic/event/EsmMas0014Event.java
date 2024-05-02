/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsmMas0014Event.java
*@FileTitle : US domestic cost/credit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.16
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.16 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.vo.SearchUSDomesticVO;



/**
 * ESM_MAS_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author BOBAE KIM
 * @see ESM_MAS_0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 입력 Data 처리 */
	private SearchUSDomesticVO searchUSDomesticVO = null;
	private SearchUSDomesticVO[] searchUSDomesticVOs = null;
	
	private String fCostYrmon = "";
	private String key = "";

	public EsmMas0014Event(){}
	


	public SearchUSDomesticVO getSearchUSDomesticVO() {
		return searchUSDomesticVO;
	}

	public void setSearchUSDomesticVO(SearchUSDomesticVO searchUSDomesticVO) {
		this.searchUSDomesticVO = searchUSDomesticVO;
	}

	

	public SearchUSDomesticVO[] getSearchUSDomesticVOs() {
		return searchUSDomesticVOs;
	}

	public void setSearchUSDomesticVOs(SearchUSDomesticVO[] searchUSDomesticVOs) {
		this.searchUSDomesticVOs = searchUSDomesticVOs;
	}




	public String getFCostYrmon() {
		return fCostYrmon;
	}

	public void setFCostYrmon(String fCostYrmon) {
		this.fCostYrmon = fCostYrmon;
	}



	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}