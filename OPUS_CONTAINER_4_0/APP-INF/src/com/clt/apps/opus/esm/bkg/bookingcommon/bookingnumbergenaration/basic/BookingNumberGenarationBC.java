/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingNumberGenarationBC.java
*@FileTitle : BookingNumberGenarationBC
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.02.05 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingnumbergenaration.basic;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;


/**
 * Bookingcommon Business Logic Command Interface<br>
 * - Bookingcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Kim Ki Jong
 * @see BookingNumberGenarationBC 참조
 * @since J2EE 1.5
 */
public interface BookingNumberGenarationBC {

	/**
	 * Bkg No,Bl no 등 생성.<br>
	 * @param String divCd 
	 * @param String officeCd 
	 * @param String usrId 
	 * @return BkgBlNoVO
	 * @throws Exception
	 * @throws DAOException
	 */
		
	public BkgBlNoVO manageBkgNumberGeneration(String divCd,String officeCd,String usrId )throws EventException ;
	
	/**
	 * 
	 * @param divCd
	 * @param officeCd
	 * @param usrId
	 * @return
	 * @throws EventException
	 */
	public BkgBlNoVO manageToyotaBlNumberGeneration(String divCd,String officeCd,String usrId )throws EventException ;
	
	/**
	 * RPT ,JPD,D/O,CAD,UIT,C/A,KOR NO 등  ReferenceNumber 생성.<br>
	 * @param String divCd 
	 * @param String officeCd 
	 * @param String usrId 
	 * @return BkgReferenceNoGenerationVO
	 * @throws Exception
	 * @throws DAOException
	 */
		
	public BkgReferenceNoGenerationVO manageBkgReferenceNumberGeneration(String divCd,String officeCd,String usrId )throws EventException ;
	
	/**
	 * 
	 * @param bkgBlNoVO
	 * @return
	 * @throws EventException
	 */
	public String validationToyotaBlNo(BkgBlNoVO bkgBlNoVO)throws EventException; 
	
}