/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : CgmEdiSendBCImpl.java
 *@FileTitle : CgmEdiSend
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.07.18
 *@LastModifier : 두기민
 *@LastVersion : 1.0
 * 2016.07.18 두기민
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration.CgmEaiDBDAO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration.CgmEdiSendDBDAO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.vo.CgmEdiPodBookingListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-CgmCommon Business Logic Basic Command implementation<br>
 * - ALPS-CgmCommon에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author DOO KI MIN
 * @see CgmEdiSendBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class CgmEdiSendBCImpl extends BasicCommandSupport implements
		CgmEdiSendBC {

	// Database Access Object
	private transient CgmEdiSendDBDAO dbDao = null;
	private transient CgmEaiDBDAO eaiDao = null; //LIVE
	//private transient CgmEaiTestDBDAO eaiDao = null; //TEST

	/**
	 * CgmEdiSendBCImpl 객체 생성<br>
	 * CgmEdiSendDBDAO 생성한다.<br>
	 * CgmEaiDBDAO 생성한다.<br>
	 */
	public CgmEdiSendBCImpl() {
		dbDao = new CgmEdiSendDBDAO();
		eaiDao = new CgmEaiDBDAO();   //LIVE
		//eaiDao = new CgmEaiTestDBDAO(); //TEST
	}

	/**
	 * 오늘 시점에서 VVD의 bkg중에 미주(US,CA) POD 인것을 조회합니다.<br>
	 * 
	 * @return List<List<CgmEdiPodBookingListVO>>
	 * @exception EventException
	 */
	public List<List<CgmEdiPodBookingListVO>> searchEdiToUsCaImport()
			throws EventException {

		List<CgmEdiPodBookingListVO> list = null;
		List<List<CgmEdiPodBookingListVO>> cntArrList = new ArrayList<List<CgmEdiPodBookingListVO>>();

		try {
			list = dbDao.usCaPodBookingList();

			if (!list.isEmpty()) {

				for (int i = 0; i < list.size(); i++) {
					List<CgmEdiPodBookingListVO> cntlist = null;
					CgmEdiPodBookingListVO cgmEdiPodBookingListVO = new CgmEdiPodBookingListVO();
					cgmEdiPodBookingListVO = list.get(i);
					cntlist = dbDao
							.usCaPodContainerList(cgmEdiPodBookingListVO);

					if (0 < cntlist.size()) {
						cntArrList.add(cntlist);
					}
				}
			}

			return cntArrList;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage());
		}
	}

	/**
	 * 오늘시점에서 어제 하루동안 생성된 bkg (export) POL이 미주 및 캐나다 인것을 조회합니다.<br>
	 * 
	 * @return List<List<CgmEdiPodBookingListVO>>
	 * @exception EventException
	 */
	public List<List<CgmEdiPodBookingListVO>> searchEdiToUsCaExport()
			throws EventException {
		List<CgmEdiPodBookingListVO> list = null;
		List<List<CgmEdiPodBookingListVO>> cntArrList = new ArrayList<List<CgmEdiPodBookingListVO>>();

		try {
			list = dbDao.usCaPodBookingExportList();

			if (!list.isEmpty()) {

				for (int i = 0; i < list.size(); i++) {
					List<CgmEdiPodBookingListVO> cntlist = null;

					CgmEdiPodBookingListVO cgmEdiPodBookingListVO = new CgmEdiPodBookingListVO();
					cgmEdiPodBookingListVO = list.get(i);
					cntlist = dbDao
							.usCaPodContainerList(cgmEdiPodBookingListVO);

					if (0 < cntlist.size()) {
						cntArrList.add(cntlist);
					}
				}
			}

			return cntArrList;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage());
		}
	}

	/**
	 * 미주 및 캐나다에 EDI를 전송합니다.<br>
	 * 
	 * @param List
	 *            <List<CgmEdiPodBookingListVO>> arrList
	 * @return String
	 * @exception EventException
	 */
	public String sendEdiToUsCa(List<List<CgmEdiPodBookingListVO>> arrList)
			throws EventException {

		StringBuilder flatFile = new StringBuilder();

		/**************************************************************
		 * EDI 
		 **************************************************************/
		List<CgmEdiPodBookingListVO> booKinglist = null;
		List<CgmEdiPodBookingListVO> list = null;
		CgmEdiPodBookingListVO importVo = new CgmEdiPodBookingListVO();
		CgmEdiPodBookingListVO logVo = new CgmEdiPodBookingListVO();

		try {
			for (int i = 0; i < arrList.size(); i++) {
				String headerSeq = dbDao.searchEdiHdSeqToUsCa();
				String headInfo = "CHS301";
				
				if("IP".equals(importVo.getIeInd())){
					headInfo = "CHS310";
				}
				
				String header = dbDao.searchEdiHdToUsCa(headerSeq, headInfo);

				flatFile.append(header + "\n");
				
				importVo = arrList.get(i).get(0);
				
				booKinglist = dbDao.searchEdiMsgToUsCa(importVo);
				
				if (0 < booKinglist.size()) {
					
					logVo.setBkgnbr(booKinglist.get(0).getBkgnbr());
					logVo.setfmInd(booKinglist.get(0).getfmInd());
					logVo.setVslCd(booKinglist.get(0).getVslCd());
					logVo.setSkdVoy(booKinglist.get(0).getSkdVoy());
					logVo.setSdkDir(booKinglist.get(0).getSdkDir());
					
					if("IP".equals(booKinglist.get(0).getIeInd())){
						logVo.setIeInd("I");
					}else{
						logVo.setIeInd("E");
					}
					
					flatFile.append("BRAC:" + booKinglist.get(0).getBrac()
							+ "\n");
					flatFile.append("BKGNBR:" + booKinglist.get(0).getBkgnbr()
							+ "\n");
					flatFile.append("BLNBR:" + booKinglist.get(0).getBlnbr()
							+ "\n");
					flatFile.append("IE_IND:" + booKinglist.get(0).getIeInd()
							+ "\n");
					flatFile.append("RDTYP:" + booKinglist.get(0).getRdtyp()
							+ "\n");
					flatFile.append("FINAL_IND:" + booKinglist.get(0).getFinalInd()
							+ "\n");
					flatFile.append("VSL_CD:" + booKinglist.get(0).getVslCd()
							+ "\n");
					flatFile.append("VSL_VOY:"
							+ booKinglist.get(0).getSkdVoy() + "\n");
					flatFile.append("VSL_DIR:"
							+ booKinglist.get(0).getSdkDir() + "\n");
					flatFile.append("VSL_NAME:"
							+ booKinglist.get(0).getVslName() + "\n");
					flatFile.append("VSL_LLOYD:"
							+ booKinglist.get(0).getVslLloyd() + "\n");
					flatFile.append("POR_NAME:"
							+ booKinglist.get(0).getPorName() + "\n");
					flatFile.append("POR_AMSQUAL:"
							+ booKinglist.get(0).getPorAmsqual() + "\n");
					flatFile.append("POR_AMSPORT:"
							+ booKinglist.get(0).getPorAmsport() + "\n");
					flatFile.append("POR_UNLC:"
							+ booKinglist.get(0).getPorUnlc() + "\n");
					flatFile.append("POR_YDCD:"
							+ booKinglist.get(0).getPorYdcd() + "\n");
					flatFile.append("POL_NAME:"
							+ booKinglist.get(0).getPolName() + "\n");
					flatFile.append("POL_AMSQUAL:"
							+ booKinglist.get(0).getPolAmsqual() + "\n");
					flatFile.append("POL_AMSPORT:"
							+ booKinglist.get(0).getPolAmsport() + "\n");
					flatFile.append("POL_UNLC:"
							+ booKinglist.get(0).getPolUnlc() + "\n");
					flatFile.append("POL_YDCD:"
							+ booKinglist.get(0).getPolYdcd() + "\n");
					flatFile.append("POD_NAME:"
							+ booKinglist.get(0).getPodName() + "\n");
					flatFile.append("POD_AMSQUAL:"
							+ booKinglist.get(0).getPodAmsqual() + "\n");
					flatFile.append("POD_AMSPORT:"
							+ booKinglist.get(0).getPodAmsport() + "\n");
					flatFile.append("POD_UNLC:"
							+ booKinglist.get(0).getPodUnlc() + "\n");
					flatFile.append("POD_YDCD:"
							+ booKinglist.get(0).getPodYdcd() + "\n");
					flatFile.append("DEL_NAME:"
							+ booKinglist.get(0).getDelName() + "\n");
					flatFile.append("DEL_AMSQUAL:"
							+ booKinglist.get(0).getDelAmsqual() + "\n");
					flatFile.append("DEL_AMSPORT:"
							+ booKinglist.get(0).getDelAmsport() + "\n");
					flatFile.append("DEL_UNLC:"
							+ booKinglist.get(0).getDelUnlc() + "\n");
					flatFile.append("DEL_YDCD:"
							+ booKinglist.get(0).getDelYdcd() + "\n");
					flatFile.append("FM_IND:" + booKinglist.get(0).getfmInd()
							+ "\n");
					flatFile.append("RF_IND:" + booKinglist.get(0).getRfInd()
							+ "\n");
					flatFile.append("DG_IND:" + booKinglist.get(0).getDgInd()
							+ "\n");
					flatFile.append("AK_IND:" + booKinglist.get(0).getAkInd()
							+ "\n");
					flatFile.append("BK_IND:" + booKinglist.get(0).getBkInd()
							+ "\n");
					
					list = dbDao.searchUsCaCntrTpszCnt(importVo);

					if(0 >= list.size()){
						flatFile.append("{BL_CNTR\n");
						flatFile.append("CNTTYP:" + "\n");
						flatFile.append("CNT:" + "\n");
						flatFile.append("}BL_CNTR\n");
					}else{
						for (int a = 0; a < list.size(); a++) {
							flatFile.append("{BL_CNTR\n");
							flatFile.append("CNTTYP:" + list.get(a).getTCntrTpszCd()
									+ "\n");
							flatFile.append("CNT:" + list.get(a).getTCnt()
									+ "\n");
							flatFile.append("}BL_CNTR\n");
						}
					}
														
					for (int y = 0; y < arrList.get(i).size(); y++) {
											
						CgmEdiPodBookingListVO cgmEdiPodBookingListVO = new CgmEdiPodBookingListVO();
						cgmEdiPodBookingListVO = arrList.get(i).get(y);
						
						list = dbDao.chssExceptInfo(cgmEdiPodBookingListVO);
						if (0 < list.size()) {
							importVo = list.get(0);
							list = dbDao.chssExceptFlag(importVo);

							if (0 < list.size()) {
								
								importVo.setChzExcept(list.get(0).getChzExcept());
								list = dbDao.chssExceptDays(importVo);
								importVo.setChzExceptDays(list.get(0)
										.getChzExceptDays());
								
								list = dbDao.searchEdiMsgToUsCaCntInfo(importVo);
								
								flatFile.append("{CNTR_INFO\n");
								flatFile.append("CNTRNBR:"
											+ importVo.getCntrNo() + "\n");
								
								logVo.setCntrNo(importVo.getCntrNo());
								
								flatFile.append("CNTRTYPE:"
											+ importVo.getTpszCd() + "\n");
								
								list = dbDao.searchEdiMsgToUsCa(importVo);
								
								flatFile.append("CHSS_EXCEPT:"
										+ list.get(0).getChzExcept() + "\n");
								
								logVo.setChzExcept(list.get(0).getChzExcept());
								
								flatFile.append("CHSS_FREE_DAY:"
										+ list.get(0).getChzExceptDays() + "\n");
								
								logVo.setChzExceptDays(list.get(0).getChzExceptDays());
								
								flatFile.append("TWGT:" 
										+ list.get(0).getTwgt() + "\n");
								flatFile.append("TWUNIT:"
										+ list.get(0).getTwunit() + "\n");
								
								flatFile.append("CNTR_TOTAL_WGT:"
											+ list.get(0).getCntrTotalWgt() + "\n");
								flatFile.append("CNTR_TOTAL_WGT_UNIT:"
											+ list.get(0).getCntrTotalWgtUnit()
											+ "\n");
								
							    list = dbDao.searchEdiMsgToUsCaSealInfo(importVo);
									
									if(0 >= list.size()){
										flatFile.append("{CNTR_SEAL_NO\n");
										flatFile.append("SEAL_NO:\n");
										flatFile.append("}CNTR_SEAL_NO\n");
									}else{
										for (int v = 0; v < list.size(); v++) {
											flatFile.append("{CNTR_SEAL_NO\n");
											flatFile.append("SEAL_NO:"
													+ list.get(v).getSealNo() + "\n");
											flatFile.append("}CNTR_SEAL_NO\n");
										}
									}

									flatFile.append("}CNTR_INFO\n");
								}

							   dbDao.addCgmChssExptEdiHis(logVo);
							}
						}
					
					log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>" + flatFile);
					
					eaiDao.sendEdi(flatFile.toString());
					flatFile = new StringBuilder();
					
					}
				}
			
			return "SUCCESS";

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage());
		}
	}
}
