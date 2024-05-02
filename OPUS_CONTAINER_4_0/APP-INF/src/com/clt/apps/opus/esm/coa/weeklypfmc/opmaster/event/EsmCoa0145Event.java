/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0145Event.java
*@FileTitle : EsmCoa0145Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaLaneTpHisVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0145 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0145HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0145HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0145Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	


	
	/** 단건처리 */
	private CoaLaneTpHisVO coaLaneTpHisVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaLaneTpHisVO[] coaLaneTpHisVOs = null;	
	

	/** Constructor */
	public EsmCoa0145Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0145Event";
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
	public void setCoaLaneTpHisVO(CoaLaneTpHisVO coaLaneTpHisVO){
		this.coaLaneTpHisVO = coaLaneTpHisVO;
	}
	/** ValueObject Getter */
	public CoaLaneTpHisVO getCoaLaneTpHisVO(){
		return coaLaneTpHisVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */					//SJH.20150508.소스품질
	public void setCoaLaneTpHisVOs(CoaLaneTpHisVO[] coaLaneTpHisVOs){
		if(coaLaneTpHisVOs != null){
			CoaLaneTpHisVO[] tmpVOs = Arrays.copyOf(coaLaneTpHisVOs, coaLaneTpHisVOs.length);
			this.coaLaneTpHisVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete */					//SJH.20150508.소스품질
	public CoaLaneTpHisVO[] getCoaLaneTpHisVOs(){
		CoaLaneTpHisVO[] rtnVOs = null;
		if (this.coaLaneTpHisVOs != null) {
			rtnVOs = Arrays.copyOf(coaLaneTpHisVOs, coaLaneTpHisVOs.length);
		}
		return rtnVOs;
	}			
}
