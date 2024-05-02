/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CsScreenBC.java
 *@FileTitle : Break Bulk Detail(s) Pop-up
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.ArrNtcInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BkgBlInfosVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrClmInfosVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrMvntVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.DgCgoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.SoInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.TopBlInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCustSvcInstrsVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgAwkCgoVO;
import com.clt.syscommon.common.table.BkgBbCgoVO;
import com.clt.syscommon.common.table.BkgCstmsAdvRsltVO;

/**
 *   CsScreenMgt Business Logic Basic Command implementation<br>
 * - CsScreenMgt handling business transaction.<br>
 *
 * @author
 * @see CsScreenBC
 * @since J2EE 1.4
 */

public interface CsScreenBC {

	/**
	 * DG Cargo Detail(s) Pop-up(UI_BKG-0659) retrieve event process..<br>
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @param String cntrNo Container No.
	 * @return List<DgCgoVO>
	 * @exception EventException
	 */
	public List<DgCgoVO> searchDgCargoList(String bkgNo, String cntrNo) throws EventException;

	/**
	 * Break Bulk Detail(s) Pop-up(UI_BKG-0660) retrieve event process..<br>
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @return List<BkgBbCgoVO>
	 * @exception EventException
	 */
	public List<BkgBbCgoVO> searchBbCargoList(String bkgNo) throws EventException;

	/**
	 * Awkward Dimension Detail(s) Pop-up(UI_BKG-0661) retrieve event process..<br>
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @param String cntrNo Container No.
	 * @return List<BkgAwkCgoVO>
	 * @exception EventException
	 */
	public List<BkgAwkCgoVO> searchAwkCargoList(String bkgNo, String cntrNo) throws EventException;
	
	/**
     * retrieve event process.<br>
     * retrieve B/L Info of UI_BKG_0292. 
     *
     * @author
     * @param String bkgNo Booking No.
     * @param SignOnUserAccount account
     * @return BlInfoVO
     * @exception EventException
     */
    public BlInfoVO searchBlInfo(String bkgNo, SignOnUserAccount account) throws EventException;	


    /**
	 * Movement retrieve event process..<br>
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @return CntrMvntVO
	 * @exception EventException
	 */
    public CntrMvntVO searchCntrMvntInfo(String bkgNo) throws EventException;	

    
    /**
	 * S/O Info retrieve event process..<br>
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @return SoInfoVO
	 * @exception EventException
	 */
    public SoInfoVO searchSoInfo(String bkgNo) throws EventException;	

    
    /**
     * retrieve event process.<br>
     * retrieve B/L Info of UI_BKG_0668. 
     * 
     * @author
     * @param String bkgNo Booking No.
     * @param SignOnUserAccount account
     * @return BlInfoVO
     * @exception EventException
     */
    public BlInfoVO searchUsBlInfo(String bkgNo, SignOnUserAccount account) throws EventException;	
    

    /**
     * retrieve event process.<br>
     * retrieve Customs Result of ESM_BKG_0668_5.
     * 
     * @author
     * @param String bkgNo Booking No.
     * @return List<BkgCstmsAdvRsltVO>
     * @exception EventException
     */
    public List<BkgCstmsAdvRsltVO> searchUsCstmsAdvRsltInfo(String bkgNo) throws EventException;
    
    /**
	 * Movement retrieve event process..<br>
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @return CntrMvntVO
	 * @exception EventException
	 */
    public CntrMvntVO searchCntrMvntInfoByUs(String bkgNo) throws EventException;
    
    /**
	 * retrieve CLM List.
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @param String cntrNo Container No.
	 * @return List<CntrClmInfosVO>
	 * @exception EventException
	 */
    public List<CntrClmInfosVO> searchCntrClmInfo(String bkgNo, String cntrNo) throws EventException;

    /**
	 * S/O Info retrieve event process..<br>
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @return SoInfoVO
	 * @exception EventException
	 */
    public SoInfoVO searchUsSoInfo(String bkgNo) throws EventException;	

    /**
	 * retrieve event process.<br>
	 * retrieve B/L list by Container No.
	 * 
	 * @author
	 * @param String cntrNo Container No.
	 * @return List<BkgBlInfosVO>
	 * @exception EventException
	 */	
	public List<BkgBlInfosVO> searchBlListByCntrNo(String cntrNo)  throws EventException ;
    
	/**
	 * BKG Common UTIL <br>
	 * retrieve B/L list by P.O no.
	 *  
	 * @author
	 * @param String poNo P/O No.
	 * @return BkgBlInfosVO
	 * @exception EventException
	 */
	public List<BkgBlInfosVO> searchBlListByPoNo (String poNo) throws EventException ;

	/**
	 * retrieve event process.<br>
	 * retrieve BKG No by HB/L no.
	 * 
	 * @author
	 * @param String hblNo H.B/L No.
	 * @return List<BkgBlInfosVO>
	 * @exception EventException
	 */
	public  List<BkgBlInfosVO> searchBlListByHblNo (String hblNo) throws EventException ;

	/**
	 * retrieve event process.<br>
	 * retrieve SPLIT B/L No by BKG No.
	 *
	 * @author
	 * @param String bkgNo Booking No.
	 * @return List<BkgBlInfosVO>
	 * @exception EventException
	 */
	public  List<BkgBlInfosVO> searchBlListByBkgSplit (String bkgNo) throws EventException ;
	
	/**
	 * retrieve Arrival Notice and B/L Copy sending list for dealing with customers. 
	 * 
	 * @author
	 * @param String bkgNo Booking No.
     * @param SignOnUserAccount account
	 * @return ArrNtcInfoVO
	 * @exception EventException
	 */
	public  ArrNtcInfoVO searchUsArrNtcInfo (String bkgNo, SignOnUserAccount account) throws EventException ;
	
	/**
	 * send P/N by Email of group B/L
	 * 
	 * @author
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return PkupNtcInfoVO
	 * @exception EventException
	 */
	public  PkupNtcInfoVO searchPkupNtcInfo (String bkgNo, SignOnUserAccount account) throws EventException ;
	
	/**
	 * Retrieving List about American Inbound Cargo Release by Item
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @return BkgInfoVO
	 * @exception EventException
	 */
	public BlInfoVO searchUsCgoRlseInfo (String bkgNo) throws EventException ;

	/**
     * retrieve event process.<br>
     * retrieve Top B/L Info
     * 
     * @author
     * @param String bkgNo Booking No.
     * @return TopBlInfoVO
     * @exception EventException
     */
    public TopBlInfoVO searchTopBlInfo(String bkgNo) throws EventException;		
    
    /**
	 * retrieve Arrival Notice and B/L Copy sending list for dealing with customers. 
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @param SignOnUserAccount account
	 * @return ArrNtcInfoVO
	 * @exception EventException
	 */
	public  ArrNtcInfoVO searchArrNtcInfo (String bkgNo, SignOnUserAccount account) throws EventException ;
	
	/**
	 * retrieve Remark.
	 * 
	 * @author
	 * @param String bkgNo Booking No.
	 * @return List<usCustSvcInstrsVO>
	 * @exception EventException
	 */   
	public List<UsCustSvcInstrsVO> searchUsCustSvcInstr(String bkgNo) throws EventException;

	/**
	 * create Remark.
	 *
	 * @author
	 * @param UsCustSvcInstrsVO usCustSvcInstrs
	 * @exception EventException
	 */
	public void createUsCustSvcInstr(UsCustSvcInstrsVO usCustSvcInstrs) throws EventException;

	/**
	 * delete Remark.
	 * 
	 * @author
	 * @param UsCustSvcInstrsVO usCustSvcInstrs
	 * @exception EventException
	 */
	public void removeUsCustSvcInstr(UsCustSvcInstrsVO usCustSvcInstrs) throws EventException;
	
}