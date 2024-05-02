/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CsScreenBC.java
*@FileTitle : Break Bulk Detail(s) Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.04.28 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.ArrNtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BkgBlInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrClmInfosVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.CntrMvntVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.DgCgoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.PkupNtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.SoInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.TopBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo.UsCustSvcInstrsVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgAwkCgoVO;
import com.hanjin.syscommon.common.table.BkgBbCgoVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRsltVO;

/**
 * ALPS-Csscreenmgt Business Logic Command Interface<br>
 * - ALPS-Csscreenmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Mi Ok
 * @see Ui_bkg-0660EventResponse 참조
 * @since J2EE 1.4
 */

public interface CsScreenBC {

	/**
	 * DG Cargo Detail(s) Pop-up(UI_BKG-0659) 화면에 대한 조회 이벤트 처리한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @param String cntrNo Container No.
	 * @return List<DgCgoVO>
	 * @exception EventException
	 */
	public List<DgCgoVO> searchDgCargoList(String bkgNo, String cntrNo) throws EventException;

	/**
	 * Break Bulk Detail(s) Pop-up(UI_BKG-0660) 화면에 대한 조회 이벤트 처리한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @return List<BkgBbCgoVO>
	 * @exception EventException
	 */
	public List<BkgBbCgoVO> searchBbCargoList(String bkgNo) throws EventException;

	/**
	 * Awkward Dimension Detail(s) Pop-up(UI_BKG-0661) 화면에 대한 조회 이벤트 처리한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @param String cntrNo Container No.
	 * @return List<BkgAwkCgoVO>
	 * @exception EventException
	 */
	public List<BkgAwkCgoVO> searchAwkCargoList(String bkgNo, String cntrNo) throws EventException;
	
    /**
     * 조회 이벤트 처리<br>
     * UI_BKG_0292 화면의 B/L Info 조회한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @param SignOnUserAccount account
     * @return BlInfoVO
     * @exception EventException
     */
    public BlInfoVO searchBlInfo(String bkgNo, SignOnUserAccount account) throws EventException;	


    /**
     * 조회 이벤트 처리<br>
     * UI_BKG_0292 화면의 Movement를 조회한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @return CntrMvntVO
     * @exception EventException
     */
    public CntrMvntVO searchCntrMvntInfo(String bkgNo) throws EventException;	

    
    /**
     * 조회 이벤트 처리<br>
     * UI_BKG_0292 화면의 S/O Info를 조회한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @return SoInfoVO
     * @exception EventException
     */
    public SoInfoVO searchSoInfo(String bkgNo) throws EventException;	

    
    /**
     * 조회 이벤트 처리<br>
     * UI_BKG_0668 화면의 B/L Info 조회한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @param SignOnUserAccount account
     * @return BlInfoVO
     * @exception EventException
     */
    public BlInfoVO searchUsBlInfo(String bkgNo, SignOnUserAccount account, String CntrNo) throws EventException;	
    

    /**
     * 조회 이벤트 처리<br>
     * ESM_BKG_0668_5 화면의 Customs Result 를 조회한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @return List<BkgCstmsAdvRsltVO>
     * @exception EventException
     */
    public List<BkgCstmsAdvRsltVO> searchUsCstmsAdvRsltInfo(String bkgNo) throws EventException;
    
    /**
     * 조회 이벤트 처리<br>
     * UI_BKG_0668 화면의 Movement를 조회한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @return CntrMvntVO
     * @exception EventException
     */
    public CntrMvntVO searchCntrMvntInfoByUs(String bkgNo) throws EventException;
    
    /**
     * 조회 이벤트 처리<br>
     * UI_BKG_0668 화면의 CLM 목록을 조회한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @param String cntrNo Container No.
     * @return CntrClmInfosVO
     * @exception EventException
     */
    public List<CntrClmInfosVO> searchCntrClmInfo(String bkgNo, String cntrNo) throws EventException;

    /**
     * 조회 이벤트 처리<br>
     * UI_BKG_0668-01 화면의 S/O Info를 조회한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @return SoInfoVO
     * @exception EventException
     */
    public SoInfoVO searchUsSoInfo(String bkgNo) throws EventException;	

	/**
	 * 조회 이벤트 처리<br>
	  *  Container No로 조회시 연계된 B/L이 LCL인 경우,관련 B/L List를 조회하고 <br>
	 *  LCL이 아닌 경우,단건의 B/L 정보를 조회한다.<br>
	 * @param String cntrNo Container No.
	 * @return List<BkgBlInfosVO>
	 * @exception EventException
	 */
	
	public List<BkgBlInfosVO> searchBlListByCntrNo(String cntrNo)  throws EventException ;
    
	/**
	 * 조회 이벤트 처리<br>
	 *  P.O. No에 둘이상의 B/L 또는 관련 B/L 목록을 List Up하고 아니면 단건의 B/L 항목을 조회한다.  <br>
	 * @param String poNo P/O No.
	 * @return List<BkgBlInfosVO>
	 * @exception EventException
	 */
	
	public List<BkgBlInfosVO> searchBlListByPoNo (String poNo) throws EventException ;

	/**
	 * 조회 이벤트 처리<br>
	 * HB/L No로 BKG NO 조회. <br>
	 * @param String hblNo H/BL No.
	 * @return List<BkgBlInfosVO>
	 * @exception EventException
	 */
	public  List<BkgBlInfosVO> searchBlListByHblNo (String hblNo) throws EventException ;

	/**
	 * 조회 이벤트 처리<br>
	 * BKG No로 SPLIT BL NO 조회. <br>
	 * @param String bkgNo Booking No.
	 * @return List<BkgBlInfosVO>
	 * @exception EventException
	 */
	public  List<BkgBlInfosVO> searchBlListByBkgSplit (String bkgNo) throws EventException ;
	
	/**
	 * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
	 * @param String bkgNo Booking No.
	 * @param SignOnUserAccount account
	 * @return ArrNtcBlCopyInfoVO
	 * @exception EventException
	 */
	public  ArrNtcInfoVO searchUsArrNtcInfo (String bkgNo, SignOnUserAccount account) throws EventException ;

//	/**
//	 * US 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
//	 * @param String bkgNo Booking No.
//	 * @param SignOnUserAccount account
//	 * @return ArrNtcBlCopyInfoVO
//	 * @exception EventException
//	 */
//	public  ArrNtcBlCopyInfoVO searchUsArrNtcBlCopyInfo (String bkgNo, SignOnUserAccount account) throws EventException ;

	
	/**
	 * B/L 단위로 Email 로 P/N를 송부한다. <br>
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return PkupNtcInfoVO
	 * @exception EventException
	 */
	public  PkupNtcInfoVO searchPkupNtcInfo (String bkgNo, SignOnUserAccount account) throws EventException ;
	
	/**
	 *  미주 Inbound Cargo Release에 대한 List를 Item별로 조회한다. <br>
	 * @param String bkgNo Booking No.
	 * @return BkgInfoVO
	 * @exception EventException
	 */
	public BlInfoVO searchUsCgoRlseInfo (String bkgNo) throws EventException ;

    /**
     * 조회 이벤트 처리<br>
     * C/S Screen Top부분의 공통적인 영역을 담당한다.<br>
     * 
     * @param String bkgNo Booking No.
     * @return TopBlInfoVO
     * @exception EventException
     */
    public TopBlInfoVO searchTopBlInfo(String bkgNo) throws EventException;		
    
	/**
	 * 고객 응대를 위한 Arrival Notice & B/L Copy 발송 정보 관리<br>
	 * @param String bkgNo Booking No.
	 * @param SignOnUserAccount account
	 * @return ArrNtcInfoVO
	 * @exception EventException
	 */
	public  ArrNtcInfoVO searchArrNtcInfo (String bkgNo, SignOnUserAccount account) throws EventException ;
	
	/**
	 * Inbound C/S_USA SCREEN에서 저장된 Remark를 조회한다.<br>
	 * 
	 * @param String bkgNo Booking No.
	 * @return List<usCustSvcInstrsVO>
	 * @exception EventException
	 */
	public List<UsCustSvcInstrsVO> searchUsCustSvcInstr(String bkgNo) throws EventException;

	/**
	 * Inbound C/S_USA SCREEN에서 저장된 Remark를 등록한다.<br>
	 * 
	 * @param UsCustSvcInstrsVO usCustSvcInstrs
	 * @exception EventException
	 */
	public void createUsCustSvcInstr(UsCustSvcInstrsVO usCustSvcInstrs) throws EventException;

	/**
	 * Inbound C/S_USA SCREEN에서 저장된 Remark를 삭제한다.<br>
	 * 
	 * @param UsCustSvcInstrsVO usCustSvcInstrs
	 * @exception EventException
	 */
	public void removeUsCustSvcInstr(UsCustSvcInstrsVO usCustSvcInstrs) throws EventException;
	
}