/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0040Event.java
*@FileTitle : EsmCoa0040Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
* 
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffDetailListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo.SearchPortTariffListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaPortTrfVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0040HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0040Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	

	
	/** 단건처리 */
	private CoaPortTrfVO coaPortTrfVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaPortTrfVO[] coaPortTrfVOs = null;	
    
	/** Multi Data 처리 */
	private SearchPortTariffListVO[] searchPortTariffListVOs = null;

	/** 단건처리 */
	private SearchPortTariffDetailListVO searchPortTariffDetailListVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs = null;	

	/** Constructor */
	public EsmCoa0040Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0040Event";
	}
	
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	
	/** ValueObject Setter */
	public void setCoaPortTrfVO(CoaPortTrfVO coaPortTrfVO){
		this.coaPortTrfVO = coaPortTrfVO;
	}
	/** ValueObject Getter */
	public CoaPortTrfVO getCoaPortTrfVO(){
		return coaPortTrfVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */				//SJH.20150508.소스품질
	public void setCoaPortTrfVOs(CoaPortTrfVO[] coaPortTrfVOs){
		if(coaPortTrfVOs != null){
			CoaPortTrfVO[] tmpVOs = Arrays.copyOf(coaPortTrfVOs, coaPortTrfVOs.length);
			this.coaPortTrfVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete */				//SJH.20150508.소스품질
	public CoaPortTrfVO[] getCoaPortTrfVOs(){
		CoaPortTrfVO[] rtnVOs = null;
		if (this.coaPortTrfVOs != null) {
			rtnVOs = Arrays.copyOf(coaPortTrfVOs, coaPortTrfVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150508.소스품질
	public SearchPortTariffListVO[] getSearchPortTariffListVOs() {
		SearchPortTariffListVO[] rtnVOs = null;
		if (this.searchPortTariffListVOs != null) {
			rtnVOs = Arrays.copyOf(searchPortTariffListVOs, searchPortTariffListVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150508.소스품질
	public void setSearchPortTariffListVOs(SearchPortTariffListVO[] searchPortTariffListVOs){
		if(searchPortTariffListVOs != null){
			SearchPortTariffListVO[] tmpVOs = Arrays.copyOf(searchPortTariffListVOs, searchPortTariffListVOs.length);
			this.searchPortTariffListVOs = tmpVOs;
		}
	}	
	
	public SearchPortTariffDetailListVO getSearchPortTariffDetailListVO() {
		return searchPortTariffDetailListVO;
	}

	public void setSearchPortTariffDetailListVO(
			SearchPortTariffDetailListVO searchPortTariffDetailListVO) {
		this.searchPortTariffDetailListVO = searchPortTariffDetailListVO;
	}
	//SJH.20150508.소스품질
	public SearchPortTariffDetailListVO[] getSearchPortTariffDetailListVOs() {
		SearchPortTariffDetailListVO[] rtnVOs = null;
		if (this.searchPortTariffDetailListVOs != null) {
			rtnVOs = Arrays.copyOf(searchPortTariffDetailListVOs, searchPortTariffDetailListVOs.length);
		}
		return rtnVOs;
	}
	//SJH.20150508.소스품질
	public void setSearchPortTariffDetailListVOs(SearchPortTariffDetailListVO[] searchPortTariffDetailListVOs){
		if(searchPortTariffDetailListVOs != null){
			SearchPortTariffDetailListVO[] tmpVOs = Arrays.copyOf(searchPortTariffDetailListVOs, searchPortTariffDetailListVOs.length);
			this.searchPortTariffDetailListVOs = tmpVOs;
		}
	}
	
}
