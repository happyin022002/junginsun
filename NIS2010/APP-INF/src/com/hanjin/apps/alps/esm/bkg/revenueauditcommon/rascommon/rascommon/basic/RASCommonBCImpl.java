/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PRICommonBCImpl.java
*@FileTitle : PRICommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.16
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.04.16 박성수
* 1.0 Creation
* 2013.07.30 김진주 [CHM-201325469] [BKG/DOC - Revenue Audit System] COD BKG Inquiry 기능 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration.RASCommonDBDAO;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmChargeVO;

/**
 * NIS2010-PRICommon Business Logic Basic Command implementation<br>
 * - NIS2010-PRICommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Park Sungsoo
 * @see PRICommonEventResponse,PRICommonBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class RASCommonBCImpl extends BasicCommandSupport implements RASCommonBC {

	// Database Access Object
	private transient RASCommonDBDAO dbDao = null;

	/**
	 * PRICommonBCImpl 객체 생성<br>
	 * RASCommonDBDAO를 생성한다.<br>
	 */
	public RASCommonBCImpl() {
		dbDao = new RASCommonDBDAO();
	}

	/**
	 * Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeCodeList (RsltCdListVO rsltcdlistvo) throws EventException {
        try {
            return dbDao.searchServiceScopeCodeList(rsltcdlistvo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
    }

	/**
	 *  ComCodeDescList 조회 이벤트 처리<br>
	 *  공통 코드,명칭 조회 이벤트 처리<br>
	 * 
	 * @param RsltCdListVO paramCdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
    public List<RsltCdListVO> searchComCodeDescList(RsltCdListVO paramCdlistvo) throws EventException {
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect(paramCdlistvo.getCd(),0);
			List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

			for (int i = 0; i < cdList.size(); i++) {
				RsltCdListVO rsltcdlistvo = new RsltCdListVO() ;
				rsltcdlistvo.setCd(cdList.get(i).getCode());
				
				if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD01701") ){
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD01714")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02128")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02141")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02085")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());	
				}else if (paramCdlistvo.getCd().toString().equalsIgnoreCase("CD02202")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());						
				}else {
					rsltcdlistvo.setNm(cdList.get(i).getName());
				}

				list.add(rsltcdlistvo);
			}

			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		}
	}	
	

	/**
	 *  ComCodeList 조회 이벤트 처리<br>
	 *  공통 코드,명칭 조회 이벤트 처리<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
    public List<RsltCdListVO> searchComCodeList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect(rsltcdlistvo.getCd(),0);
			List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

			for (int i = 0; i < cdList.size(); i++) {
				RsltCdListVO rowVo = new RsltCdListVO() ;
				rowVo.setCd(cdList.get(i).getCode());
				rowVo.setNm(cdList.get(i).getName());

				list.add(rowVo);
			}
			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		}
	}	


	/**
	 *  RasOrganizationList 조회 이벤트 처리<br>
	 *  조직도를 조회한다.(Ras)<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRasOrganizationList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchRasOrganizationList(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 *  seacrhRasContiList 조회 이벤트 처리<br>
	 *  조직도를 조회한다.(Ras)<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltContiListVO>
	 * @exception EventException
	 */
	public List<RsltContiListVO> seacrhRasContiList(RsltContiListVO rsltcontilistvo) throws EventException {
		try {
			return dbDao.seacrhRasContiList(rsltcontilistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	


	/**
	 *  UsExangeAmount 조회 이벤트 처리<br>
	 *  해당 CUR 별 US 환율을 가져와 현재 AMOUNT와 곱하여 리턴<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception EventException
	 */
	public String searchUsExangeAmount(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchUsExangeAmount(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	


	/**
	 * BkgRevUmchTpList 조회 이벤트 처리<br>
	 * BKG_REV_UMCH_TP 테이블 조회<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchTpList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchBkgRevUmchTpList(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	


	/**
	 * BkgRevUmchSubTpList 조회 이벤트 처리<br>
	 * BKG_REV_UMCH_SUB_TP 테이블 조회<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchBkgRevUmchSubTpList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchBkgRevUmchSubTpList(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}


	/**
	 * BKG_REV_UMCH_MNL_STL_TP 테이블 조회<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchManualSettleTypeCode(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchManualSettleTypeCode(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	

	/**
	 * 조회 이벤트 처리<br>
	 *  PRICommon화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRatingUnitCodeList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchRatingUnitCodeList(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	

	/**
	 * 조회 이벤트 처리<br>
	 *  PRICommon화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchContainerTypeSizeList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchContainerTypeSizeList(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	


	/**
	 * 조회 이벤트 처리<br>
	 *  PRICommon화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRepChargeCodeList(RsltCdListVO rsltcdlistvo) throws EventException {
		try {
			return dbDao.searchRepChargeCodeList(rsltcdlistvo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
	}	

	/**
     * charge 리스트를 조회합니다.<br>
     * 
     * @param  MdmChargeVO mdmChargeVO
     * @return List<MdmChargeVO>
     * @exception EventException
     */
    public List<MdmChargeVO> searchChargeList(MdmChargeVO mdmChargeVO) throws EventException {
        try {
            return dbDao.searchChargeList(mdmChargeVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * COD Request Reason Code 조회<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCodRequestResonCodeList (RsltCdListVO rsltcdlistvo) throws EventException {
        try {
            return dbDao.searchCodRequestResonCodeList(rsltcdlistvo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Note Conversion Type List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchNoteConversionTypeCodeList (RsltCdListVO rsltcdlistvo) throws EventException {
        try {
            return dbDao.searchNoteConversionTypeCodeList(rsltcdlistvo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Note Conversion Rule List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchNoteConversionRuleCodeList (RsltCdListVO rsltcdlistvo) throws EventException {
        try {
            return dbDao.searchNoteConversionRuleCodeList(rsltcdlistvo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Charge Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchChargeCodeList (RsltCdListVO rsltcdlistvo) throws EventException {
        try {
            return dbDao.searchChargeCodeList(rsltcdlistvo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("BKG00450", new String[]{}).getMessage(), ex);
        }
    }
	
    /**
     * VVD 존재여부 판단하는 함수 <br>
     * 
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
    public String validateVVD(String input_text)throws EventException {
        try {
            return dbDao.validateVVD(input_text);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
    
    /**
     * Invoice Number 존재여부 판단하는 함수 <br>
     * 
     * @param String input_text
     * @return String OUTPUT_TEXT
     * @throws EventException
     */
    public String validateInvoiceNumber(String input_text)throws EventException {
        try {
            return dbDao.validateInvoiceNumber(input_text);
        } catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
}