/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonBC.java
*@FileTitle : AccountPayableCommonBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.14
* 1.0 Creation
=========================================================*/
 
package com.hanjin.bizcommon.accountpayablecommon.basic;

import java.util.List;

import com.hanjin.bizcommon.accountpayablecommon.vo.CenterListVO;
import com.hanjin.framework.core.layer.event.EventException;
/**
 * AccountPayableCommon Business Logic implementation 
 * 
 * @author 
 * @see AccountPayableCommonSC
 * @since J2EE 1.6
 */ 

public interface AccountPayableCommonBC {
	


    /**
     * [COM_COM_0440]
     * Cenetr List Popup<br>
     * 
     * @param CenterListVO centerListVO
     * @return List<CenterListVO>
     * @exception EventException
     */    
    public List<CenterListVO> searchPopCenterListVO(CenterListVO centerListVO) throws EventException ;

   
	
}