/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0554Event.java
*@FileTitle : Package Table
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.20 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchWareHouseVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0554 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0554HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0554HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0554Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchWareHouseVO searchWareHouseVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchWareHouseVO[] searchWareHouseVOs = null;

	public EsmBkg0554Event(){}
	
	public void setBkgWarehouseVO(SearchWareHouseVO searchWareHouseVO){
		this. searchWareHouseVO = searchWareHouseVO;
	}

//	public void setBkgWarehouseVOS(SearchWareHouseVO[] searchWareHouseVOs){
//		this. searchWareHouseVOs = searchWareHouseVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgWarehouseVOS(SearchWareHouseVO[] searchWareHouseVOs){
		if (searchWareHouseVOs != null) {
			SearchWareHouseVO[] tmpVOs = new SearchWareHouseVO[searchWareHouseVOs.length];
			System.arraycopy(searchWareHouseVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchWareHouseVOs = tmpVOs;
		}		
	}	
	
	public SearchWareHouseVO getSearchWareHouseVO(){
		return searchWareHouseVO;
	}

//	public SearchWareHouseVO[] getSearchWareHouseVOS(){
//		return searchWareHouseVOs;
//	}
	
	//2015.04.10 Secure Coding 적용[CWE-496]
	public SearchWareHouseVO[] getSearchWareHouseVOS(){
		SearchWareHouseVO[] tmpVOs = null;
		if (this.searchWareHouseVOs != null) {
			tmpVOs = new SearchWareHouseVO[searchWareHouseVOs.length];
			System.arraycopy(searchWareHouseVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}	

}