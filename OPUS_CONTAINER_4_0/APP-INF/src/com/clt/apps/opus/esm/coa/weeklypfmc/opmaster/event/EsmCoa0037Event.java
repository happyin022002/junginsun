/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0037Event.java
*@FileTitle : EsmCoa0037Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event;

import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event.ESM_COA_0037HTMLAction;
import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

import com.clt.syscommon.common.table.CoaVslRgstVO;
import com.clt.syscommon.common.table.CoaVslSubTrdCapaVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0037HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0037Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	

	/** 단건처리 */
	private CommonCoaRsVO commonCoaRsVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CommonCoaRsVO[] commonCoaRsVOs = null;

	
	/** 단건처리 */
	private CoaVslRgstVO coaVslRgstVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaVslRgstVO[] coaVslRgstVOs = null;
	

	/** 단건처리 */
	private CoaVslSubTrdCapaVO coaVslSubTrdCapaVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaVslSubTrdCapaVO[] coaVslSubTrdCapaVOs = null;	


	/** Constructor */
	public EsmCoa0037Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0037Event";
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
	public void setCommonCoaRsVO(CommonCoaRsVO commonCoaRsVO){
		this.commonCoaRsVO = commonCoaRsVO;
	}
	/** ValueObject Getter */
	public CommonCoaRsVO getCommonCoaRsVO(){
		return commonCoaRsVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */					//SJH.20150508.소스품질
	public void setCommonCoaRsVOs(CommonCoaRsVO[] commonCoaRsVOs){
		if(commonCoaRsVOs != null){
			CommonCoaRsVO[] tmpVOs = Arrays.copyOf(commonCoaRsVOs, commonCoaRsVOs.length);
			this.commonCoaRsVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete */					//SJH.20150508.소스품질
	public CommonCoaRsVO[] getCommonCoaRsVOs(){
		CommonCoaRsVO[] rtnVOs = null;
		if (this.commonCoaRsVOs != null) {
			rtnVOs = Arrays.copyOf(commonCoaRsVOs, commonCoaRsVOs.length);
		}
		return rtnVOs;
	}	
	
	
	
	/** ValueObject Setter */
	public void setCoaVslRgstVO(CoaVslRgstVO coaVslRgstVO){
		this.coaVslRgstVO = coaVslRgstVO;
	}
	/** ValueObject Getter */
	public CoaVslRgstVO getCoaVslRgstVO(){
		return coaVslRgstVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */					//SJH.20150508.소스품질
	public void setCoaVslRgstVOs(CoaVslRgstVO[] coaVslRgstVOs){
		if(coaVslRgstVOs != null){
			CoaVslRgstVO[] tmpVOs = Arrays.copyOf(coaVslRgstVOs, coaVslRgstVOs.length);
			this.coaVslRgstVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete */					//SJH.20150508.소스품질
	public CoaVslRgstVO[] getCoaVslRgstVOs(){
		CoaVslRgstVO[] rtnVOs = null;
		if (this.coaVslRgstVOs != null) {
			rtnVOs = Arrays.copyOf(coaVslRgstVOs, coaVslRgstVOs.length);
		}
		return rtnVOs;
	}	
	
	
	/** ValueObject Setter */
	public void setCoaVslSubTrdCapaVO(CoaVslSubTrdCapaVO coaVslSubTrdCapaVO){
		this.coaVslSubTrdCapaVO = coaVslSubTrdCapaVO;
	}
	/** ValueObject Getter */
	public CoaVslSubTrdCapaVO getCoaVslSubTrdCapaVO(){
		return coaVslSubTrdCapaVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */					//SJH.20150508.소스품질
	public void setCoaVslSubTrdCapaVOs(CoaVslSubTrdCapaVO[] coaVslSubTrdCapaVOs){
		if(coaVslSubTrdCapaVOs != null){
			CoaVslSubTrdCapaVO[] tmpVOs = Arrays.copyOf(coaVslSubTrdCapaVOs, coaVslSubTrdCapaVOs.length);
			this.coaVslSubTrdCapaVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete */					//SJH.20150508.소스품질
	public CoaVslSubTrdCapaVO[] getCoaVslSubTrdCapaVOs(){
		CoaVslSubTrdCapaVO[] rtnVOs = null;
		if (this.coaVslSubTrdCapaVOs != null) {
			rtnVOs = Arrays.copyOf(coaVslSubTrdCapaVOs, coaVslSubTrdCapaVOs.length);
		}
		return rtnVOs;
	}		
			
}
