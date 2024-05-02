/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RuLabelManagementBC.java
*@FileTitle : RuLabelManagement
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.basic;

import java.util.List;

import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelListVO;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelInfoVO;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * RuLabelManagement Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_mst_0050EventResponse
 * @since J2EE 1.6
 */

public interface RuLabelManagementBC {

 
    /**
	 * EES_MST_0050 : retrieve <br>
	 * RU Label Maintenace
	 * @category EES_MST_0050
	 * @category searchRuLabelListBasic 
	 * @param RuLabelInfoVO ruLabelInfoVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelListBasic(RuLabelInfoVO ruLabelInfoVO) throws EventException;
	
	
	
	/**
	 * EES_MST_0050 : RU Label 중복체크 <br>
	 * RU Label Maintenace
	 * @category EES_MST_0050
	 * @category searchRuLabelDeleteCntBasic 
	 * @param ruLabelListVO RuLabelListVO
	 * @return String
	 * @exception EventException
	 */	
	public String searchRuLabelDeleteCntBasic(RuLabelListVO ruLabelListVO) throws EventException;
	
	
	/**
	 * EES_MST_0050 : save <br>
	 *  RU Label Maintenace
	 * @category EES_MST_0050
	 * @category actionRuLabelListBasic 
	 * @param RuLabelListVO[] ruLabelListVOs
	 * @exception EventException
	 */		
	public void actionRuLabelListBasic(RuLabelListVO[] ruLabelListVOs) throws EventException;
	
	
	/**
	 * EES_MST_0051 : retrieve <br>
	 * RU Label Attachment / Detachment
	 * @category EES_MST_0051
	 * @category searchCntrReeferUnitInfoBasic 
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelAttachListBasic(RuLabelListVO ruLabelListVO) throws EventException;
	
	
	
	/**
	 * EES_MST_0051 : cntr retrieve <br>
	 * RU Label Attachment / Detachment
	 * @category EES_MST_0051
	 * @category searchRuLabelAttachCntrListBasic 
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	 public List<RuLabelListVO> searchRuLabelAttachCntrListBasic(RuLabelListVO ruLabelListVO) throws EventException;
	 
	 
	 /**
	 * EES_MST_0051 : cntr retrieve <br>
	 * RU Label Attachment / Detachment
	 * @category EES_MST_0051
	 * @category searchRuLabelAttachCntrListBasic 
	 * @param ruLabelListVO RuLabelListVO
	 * @param String seqValue
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	 public List<RuLabelListVO> searchRuLabelAttachCntrExcelListBasic(RuLabelListVO ruLabelListVO, String seqValue) throws EventException;
		 
	 
	 /**
	 * EES_MST_0051 : retrieve <br>
	 * RU Label Value
	 * @category EES_MST_0051
	 * @category searchRuLabelValueListBasic 
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelValueListBasic(RuLabelListVO ruLabelListVO) throws EventException;
		
		
	 /**
	 * EES_MST_0051 : save <br>
	 *  RU Label Attachment
	 * @category EES_MST_0051
	 * @category actionRuLabelAttachListBasic 
	 * @param RuLabelListVO[] ruLabelListVOs
	 * @exception EventException
	 */		
	public void actionRuLabelAttachListBasic(RuLabelListVO[] ruLabelListVOs) throws EventException;
		
		
		
	/**
	 * EES_MST_0052 : retrieve <br>
	 * RU Label History
	 * @category EES_MST_0051
	 * @category searchRuLabelHistoryListBasic 
	 * @param RuLabelListVO ruLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelHistoryListBasic(RuLabelListVO ruLabelListVO) throws EventException;
		
		
	/**
	 * EES_MST_0051 : retrieve <br>
	 * checking for RU Label
	 * @category EES_MST_0051
	 * @category checkRuLabel 
	 * @param cntrNo String
	 * @param ruLabelType String
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public String checkRuLabel(String cntrNo, String ruLabelType) throws EventException;
		
	
	/**
	 * EES_MST_0053 : retrieve <br>
	 * RU Label Inquiry
	 * @category EES_MST_0053
	 * @category searchRuLabelInfoService 
	 * @param RuLabelListVO ruLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelInfoService(RuLabelListVO ruLabelListVO) throws EventException;
	
	
	/**
	  * EES_MST_0054 : retrieve <br>
	 * retrieving for RU Label - Search Condition
	 * @category EES_MST_0054
	 * @category searchRuLabelConditionService 
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelConditionService(RuLabelListVO ruLabelListVO) throws EventException;
	
	
	/**
	  * EES_MST_0051 : retrieve <br>
	 * retrieving for RU Label Attachment / Detachment
	 * @category EES_MST_0051
	 * @category searchCntrTotalRuLabelAttachListBasic 
	 * @param ruLabelListVO RuLabelListVO
	 * @return int 
	 * @exception EventException
	 */	
	public int searchCntrTotalRuLabelAttachListBasic(RuLabelListVO ruLabelListVO) throws EventException;
	
	
	/**
	 * [EES_MST_0051]Excel Load. <br>
	 *
	 * @param RuLabelListVO[] ruLabelListVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */      
	public String createMstTempBasic(RuLabelListVO[] ruLabelListVOs,SignOnUserAccount account) throws EventException;
	
	
	/**
	  * EES_MST_0051 : retrieve <br>
	 * retrieving for RU Label Attachment / Detachment
	 * @category EES_MST_0051
	 * @category searchRuLabelAttachExcelListBasic 
	 * @param ruLabelListVO RuLabelListVO
	 * @return List<RuLabelListVO> 
	 * @exception EventException
	 */	
	public List<RuLabelListVO> searchRuLabelAttachExcelListBasic(RuLabelListVO ruLabelListVO) throws EventException;
	

}