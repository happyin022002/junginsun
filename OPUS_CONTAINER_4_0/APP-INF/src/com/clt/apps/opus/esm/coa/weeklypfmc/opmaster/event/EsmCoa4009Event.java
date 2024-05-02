/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmCoa4009Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.15
*@LastModifier : SJH
*@LastVersion : 1.0
* 2014.09.15 SJH
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.event;

import com.clt.apps.opus.esm.coa.common.vo.CommonCoaRsVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.vo.MultiOmPortMngVO;  
import java.util.Arrays;

/**
 * ESM_COA_4009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_4009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_4009HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa4009Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	

	/** 단건처리 */
	private CommonCoaRsVO commonCoaRsVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CommonCoaRsVO[] commonCoaRsVOs = null;	
	
	/** Table Value Object Multi Data 처리 */
	private MultiOmPortMngVO[] multiOmPortMngVOs = null;

	/** Constructor */
	public EsmCoa4009Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa4009Event";
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
	
	/** ValueObject Array Setter - Create/Update/Delete */			//SJH.20150508.소스품질
	public void setCommonCoaRsVOs(CommonCoaRsVO[] commonCoaRsVOs){
		if(commonCoaRsVOs != null){
			CommonCoaRsVO[] tmpVOs = Arrays.copyOf(commonCoaRsVOs, commonCoaRsVOs.length);
			this.commonCoaRsVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete */			//SJH.20150508.소스품질
	public CommonCoaRsVO[] getCommonCoaRsVOs(){
		CommonCoaRsVO[] rtnVOs = null;
		if (this.commonCoaRsVOs != null) {
			rtnVOs = Arrays.copyOf(commonCoaRsVOs, commonCoaRsVOs.length);
		}
		return rtnVOs;
	}	
	
	//SJH.20150508.소스품질
	public void setMultiOmPortMngVOS(MultiOmPortMngVO[] multiOmPortMngVOs){
		if(multiOmPortMngVOs != null){
			MultiOmPortMngVO[] tmpVOs = Arrays.copyOf(multiOmPortMngVOs, multiOmPortMngVOs.length);
			this.multiOmPortMngVOs = tmpVOs;
		}
	}
	//SJH.20150508.소스품질
	public MultiOmPortMngVO[] getMultiOmPortMngVOS(){
		MultiOmPortMngVO[] rtnVOs = null;
		if (this.multiOmPortMngVOs != null) {
			rtnVOs = Arrays.copyOf(multiOmPortMngVOs, multiOmPortMngVOs.length);
		}
		return rtnVOs;
	}	
			
}
