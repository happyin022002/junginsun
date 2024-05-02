/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0029Event.java
*@FileTitle : EsmCoa0029Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaMonVvdVO;
import com.clt.syscommon.common.table.CoaVslRgstVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0029HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0029Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	/** 단건처리 */
	private WeeklyCMCommonVO mWeeklyCMCommonVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private WeeklyCMCommonVO[] mWeeklyCMCommonVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO mSearchConditionVO = null;
	
	
	/** 단건처리 */
	private CoaMonVvdVO mCoaMonVvdVO = null;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaMonVvdVO[] mCoaMonVvdVOs = null;	



	/** Constructor */
	public EsmCoa0029Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0029Event";
	}

	/** ValueObject Setter */
	public void setWeeklyCMCommonVO(WeeklyCMCommonVO weeklyCMCommonVO){
		this.mWeeklyCMCommonVO = weeklyCMCommonVO;
	}
	/** ValueObject Getter */
	public WeeklyCMCommonVO getWeeklyCMCommonVO(){
		return mWeeklyCMCommonVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */					//SJH.20150508.소스품질
	public void setWeeklyCMCommonVOs(WeeklyCMCommonVO[] weeklyCMCommonVOs){
		if(weeklyCMCommonVOs != null){
			WeeklyCMCommonVO[] tmpVOs = Arrays.copyOf(weeklyCMCommonVOs, weeklyCMCommonVOs.length);
			this.mWeeklyCMCommonVOs = tmpVOs;
		}
	}
	/** ValueObject Array Getter - Create/Update/Delete */					//SJH.20150508.소스품질
	public WeeklyCMCommonVO[] getWeeklyCMCommonVOs(){
		WeeklyCMCommonVO[] rtnVOs = null;
		if (this.mWeeklyCMCommonVOs != null) {
			rtnVOs = Arrays.copyOf(mWeeklyCMCommonVOs, mWeeklyCMCommonVOs.length);
		}
		return rtnVOs;
	}	

	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}		
	
	
	/** ValueObject Setter */
	public void setCoaMonVvdVO(CoaMonVvdVO coaMonVvdVO){
		this.mCoaMonVvdVO = coaMonVvdVO;
	}
	/** ValueObject Getter */
	public CoaMonVvdVO getCoaMonVvdVO(){
		return mCoaMonVvdVO;
	}	
	
	/** ValueObject Array Setter - Create/Update/Delete */					//SJH.20150508.소스품질
	public void setCoaMonVvdVOs(CoaMonVvdVO[] coaMonVvdVOs){
		if(coaMonVvdVOs != null){
			CoaMonVvdVO[] tmpVOs = Arrays.copyOf(coaMonVvdVOs, coaMonVvdVOs.length);
			this.mCoaMonVvdVOs = tmpVOs;
		}		
	}
	/** ValueObject Array Getter - Create/Update/Delete */					//SJH.20150508.소스품질
	public CoaMonVvdVO[] getCoaMonVvdVOs(){
		CoaMonVvdVO[] rtnVOs = null;
		if (this.mCoaMonVvdVOs != null) {
			rtnVOs = Arrays.copyOf(mCoaMonVvdVOs, mCoaMonVvdVOs.length);
		}
		return rtnVOs;
	}	
			
}
