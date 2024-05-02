/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveEdiFromPartnerLinesMgtBC.java
*@FileTitle : Receive Edi From PartnerLines Mgt
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.basic;

import java.util.List; 

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo.FlatFilePartnerLineVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Receive Edi From PartnerLines Mgt<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.6
 */
public interface ReceiveEdiFromPartnerLinesMgtBC {
	/**
	 * assignFlatFileVO from MQ Messege<br>
	 *
	 * @param String flatFile
	 * @return FlatFilePartnerLineVO[]
	 * @exception EventException
	 **/
	public List<FlatFilePartnerLineVO> manageDGEDIfromPartnerLines( String flatFile) throws EventException;
	
	/**
	 * assignFlatFileVO from MQ Messege<br>
	 *
	 * @param String flatFile
	 * @exception EventException
	 **/
	public void manageAckDGEDIfromPartnerLines( String flatFile) throws EventException;
}
