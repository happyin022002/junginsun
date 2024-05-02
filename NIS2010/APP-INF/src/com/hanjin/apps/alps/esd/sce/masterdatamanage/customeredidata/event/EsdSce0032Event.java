/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : EsdSce0032Event.java
*@FileTitle : EsdSce0032Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-05
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2006-05-10 sanghyun-kim
* 1.0 최초 생성
* 2009-08-05
* 1.3 버전 커밋
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.CustomerEdiDBDAOOptionsVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchCustomerDataVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiStatusDataVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *  ESD_SCE_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_SCE_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see ESD_SCE_0032HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdSce0032Event extends EventSupport{
	private static final long serialVersionUID = 1L;
	
	/**조회를 위한 VO 정의*/
	public EsdSce0032Event(){}
	private CustomerEdiDBDAOOptionsVO cusEdiOpt = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerDataVO schCust = null;
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerDataVO[] schCusts = null; 
	
	/**SearchCustomerDataVO setter 함수
	 * @param schCust SearchCustomerDataVO 
	 * @return 
	 * @throws
	 */
	public void setSchCust(SearchCustomerDataVO schCust){
		this. schCust = schCust;
	}
	/**SearchCustomerDataVO[] setter 함수
	 * @param schCusts SearchCustomerDataVO[] 
	 * @return 
	 * @throws
	 */	
	public void setSchCusts(SearchCustomerDataVO[] schCusts){
		this. schCusts = schCusts;
	}
	/**SearchCustomerDataVO getter 함수
	 * @param  
	 * @return SearchCustomerDataVO
	 * @throws
	 */		
	public SearchCustomerDataVO getSchCust(){
		return schCust;
	}
	/**SearchCustomerDataVO[] getter 함수
	 * @param  
	 * @return SearchCustomerDataVO[]
	 * @throws
	 */	
	public SearchCustomerDataVO[] getSchCusts(){
		return schCusts;
	}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEdiStatusDataVO schEdit = null;
	/** Table Value Object Multi Data 처리 */
	private SearchEdiStatusDataVO[] schEdits = null; 
	
	/**SearchEdiStatusDataVO setter 함수
	 * @param schEdit SearchEdiStatusDataVO  
	 * @return 
	 * @throws
	 */		
	public void setSchEdit(SearchEdiStatusDataVO schEdit){
		this. schEdit = schEdit;
	}
	/**SearchEdiStatusDataVO[] setter 함수
	 * @param schEdits SearchEdiStatusDataVO[]   
	 * @return 
	 * @throws
	 */		
	public void setSchEdits(SearchEdiStatusDataVO[] schEdits){
		this. schEdits = schEdits;
	}
	/**SearchEdiStatusDataVO getter 함수
	 * @param    
	 * @return SearchEdiStatusDataVO
	 * @throws
	 */		
	public SearchEdiStatusDataVO getSchEdit(){
		return schEdit;
	}
	/**SearchEdiStatusDataVO[] getter 함수
	 * @param    
	 * @return SearchEdiStatusDataVO[]
	 * @throws
	 */	
	public SearchEdiStatusDataVO[] getSchEdits(){
		return schEdits;
	}	
	/**CustomerEdiDBDAOOptionsVO setter 함수
	 * @param cusEdiOpt CustomerEdiDBDAOOptionsVO 
	 * @return
	 * @throws
	 */		
	public void setCusEdiOpt(CustomerEdiDBDAOOptionsVO cusEdiOpt){
		this. cusEdiOpt = cusEdiOpt;
	}
	/**CustomerEdiDBDAOOptionsVO getter 함수
	 * @param    
	 * @return CustomerEdiDBDAOOptionsVO
	 * @throws
	 */		
	public CustomerEdiDBDAOOptionsVO getCusEdiOpt(){
		return cusEdiOpt;
	}	
	
}


