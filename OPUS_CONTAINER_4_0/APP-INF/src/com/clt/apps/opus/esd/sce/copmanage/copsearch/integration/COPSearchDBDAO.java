/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COPManageDBDAO.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Seong-mun Kang
* 1.0 최초 생성
*  [1] - 2008.01.21 - 한정우 - CSR NO. N200801150002
*  [2] - 2009.02.03 - 엄유진 - CSR NO. N200901300016 특정 User에게 사용 권한 부여 
*  [3] - 2009.02.26 - 안정선 - CSR NO. N200902030014 COP Inquiry 화면과 COP Summary 화면을 하나의 화면으로 통합
*  [4] - 2009-05-25 [SCE]An Jeong-Seon [Project# S1L-09U-003] Rail Export Cargo Available Return Time 개발
*  [5] - 2009-06-15 [SCE]An Jeong-Seon [Project# S1L-09U-003] Rail Export Cargo Available Return Time 개발
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.clt.apps.opus.esd.sce.copmanage.copsearch.basic.COPSearchBCImpl;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.BookingInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPDetailVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPInquiryVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.COPReplanInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchActualInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchCOPDetailDtInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchCOPMainListVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchSCInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchSOCostInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchSceCopHdrInfoVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchTargetCOPInfoListVO;
import com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.SearchTransportationInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * SCE에 대한 DB 처리를 담당<br>
 * - SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Seong-mun Kang
 * @see COPSearchBCImpl 참조
 * @since J2EE 1.4
 */
public class COPSearchDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = -4139398838516729213L;
	
	/******************************************/
    /**
     * New COP Main 조회 검색 결과를 가져온다.<br>
     * @param COPInquiryVO inqVO
     * @return List<SearchCOPMainListVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchCOPMainListVO> searchCOPMainList(COPInquiryVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCOPMainListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
				log.debug( "inqVO ==> " +inqVO.toString());

				if (inqVO.getBkgNo() != null && inqVO.getBkgNo().trim().length() > 0) {
					velParam.put("bkg_no", inqVO.getBkgNo());
					param.put("bkg_no", inqVO.getBkgNo());					
				}
				if (inqVO.getBlNo() != null && inqVO.getBlNo().trim().length() > 0) {
					velParam.put("bl_no", inqVO.getBlNo());
					param.put("bl_no", inqVO.getBlNo());					
				}
				if (inqVO.getCntrNo() != null && inqVO.getCntrNo().trim().length() > 0) {
					velParam.put("cntr_no", inqVO.getCntrNo());
					param.put("cntr_no", inqVO.getCntrNo());					
				}
				if (inqVO.getSoNo() != null && inqVO.getSoNo().trim().length() > 0) {
					velParam.put("so_no", inqVO.getSoNo());
					param.put("so_no", inqVO.getSoNo());					
				}
				if (inqVO.getCopNo() != null && inqVO.getCopNo().trim().length() > 0) {
					velParam.put("cop_no", inqVO.getCopNo());
					param.put("cop_no", inqVO.getCopNo());					
				}
				if (inqVO.getBkgCreDt1() != null && inqVO.getBkgCreDt1().trim().length() > 0) {
					velParam.put("bkg_cre_dt1", inqVO.getBkgCreDt1());
					param.put("bkg_cre_dt1", inqVO.getBkgCreDt1());					
				}				
				if (inqVO.getBkgCreDt2() != null && inqVO.getBkgCreDt2().trim().length() > 0) {
					velParam.put("bkg_cre_dt2", inqVO.getBkgCreDt2());
					param.put("bkg_cre_dt2", inqVO.getBkgCreDt2());					
				}
				if (inqVO.getPageNo() != null && inqVO.getPageNo().trim().length() > 0) {
					velParam.put("page_no", inqVO.getPageNo());
					param.put("page_no", inqVO.getPageNo());					
				}				
				if (inqVO.getPagerows() != null && inqVO.getPagerows().trim().length() > 0) {
					velParam.put("pagerows", inqVO.getPagerows());
					param.put("pagerows", inqVO.getPagerows());					
				}	
				if (inqVO.getRefNo() != null && inqVO.getRefNo().trim().length() > 0) {
					velParam.put("ref_no", inqVO.getRefNo());
					param.put("ref_no", inqVO.getRefNo());					
				}				
				log.debug(velParam);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchCOPMainListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCOPMainListVO .class);				

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

        return list;
    }	

	 /** COP Inquriy 조회 한다.
    * @param COPInquiryVO inqVO
    * @return List<SearchSceCopHdrInfoVO>
    * @throws DAOException
    */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	 public List<SearchSceCopHdrInfoVO> searchSceCopHdrInfo(COPInquiryVO inqVO) throws DAOException{
		DBRowSet dbRowset = null;		 
		List<SearchSceCopHdrInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

        try{
			if (inqVO.getCntrNo() != null && inqVO.getCntrNo().trim().length() > 0) {
				param.put("cntr_no", inqVO.getCntrNo());					
			}

			log.debug("\n param:"+param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchSceCopHdrInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSceCopHdrInfoVO .class);				
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return list;
	 }
    

    /** COP Inquriy S/O 관련 여부 조회 한다.
     * @param COPInquiryVO inqVO
     * @return List<SearchSCInfoVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	 public List<SearchSCInfoVO> searchSCInfo(COPInquiryVO inqVO) throws DAOException{
		DBRowSet dbRowset = null;		 
		List<SearchSCInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

         try{
 			if (inqVO.getOldCopNo() != null && inqVO.getOldCopNo().trim().length() > 0) {
 				param.put("old_cop_no", inqVO.getOldCopNo());
 				
 				log.debug("\n param:"+param);
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchSCInfoRSQL(), param, velParam);
 				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSCInfoVO .class);				
			}
         } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		 } catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		 } 
		 return list;
	 }
	 
	/** COP Inquriy S/O SCE_COP_HDR update 쳐준다..
     * @param COPInquiryVO inqVO
     * @throws DAOException
     */
	 public void modifyPCopHdr(COPInquiryVO inqVO) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

	     try{
	    	 param.put("mst_lcl_cd", "P");	    	 
	    	 param.put("cop_no", inqVO.getNewCopNo());

			log.debug("\n param:"+param);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new COPSearchDBDAOModifyPCopHdrUSQL(), param, velParam);
	     } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		 } catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		 }
	 }
		
    /** COP Inquriy S/O trs 테이블쪽에 update 쳐준다..
     * @param SearchSCInfoVO inqVO
     * @throws DAOException
     */
	 public void modifyTrsRailSvcOrd(SearchSCInfoVO inqVO) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			param.put("cop_no", inqVO.getCopNo());
			param.put("bkg_no", inqVO.getBkgNo());				
			param.put("trsp_so_ofc_cty_cd", inqVO.getTrspSoOfcCtyCd());				
			param.put("trsp_so_seq", inqVO.getTrspSoSeq());				
							   
			log.debug("\n updateTrsRailSvcOrd  param:"+param);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new COPSearchDBDAOModifyTrsTrspRailBilOrdUSQL(), param, velParam);
	    	new SQLExecuter("").executeUpdate((ISQLTemplate)new COPSearchDBDAOModifyTrsTrspSvcOrdUSQL(), param, velParam);
		 } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		 } catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		 }
	 }	

	 /** 
	 * COP Inquriy S/O SCE_COP_HDR update 쳐준다..
     * @param COPInquiryVO inqVO
     * @throws DAOException
     */
	 public void modifyCopHdr(COPInquiryVO inqVO) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	 
	     try{
	    	 if (inqVO.getNewCopNo() != null && inqVO.getNewCopNo().trim().length() > 0) {	    	 
	    		 param.put("mst_lcl_cd", "P");	    	 
		    	 param.put("cop_no", inqVO.getNewCopNo());
		    	 log.debug(param);
		    	 new SQLExecuter("").executeUpdate((ISQLTemplate)new COPSearchDBDAOModifyPCopHdrUSQL(), param, velParam);
	    	 }
	    	 if (inqVO.getCopNoSlave() != null && inqVO.getCopNoSlave().trim().length() > 0) {
		    	 param.clear();
		    	 param.put("mst_lcl_cd", "X");			
		    	 param.put("cop_no", inqVO.getCopNoSlave());
		    	 log.debug("\n param:"+param);			
		    	 new SQLExecuter("").executeUpdate((ISQLTemplate)new COPSearchDBDAOModifyPCopHdrUSQL(), param, velParam);			
	    	 }
	     } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		 } catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		 } 
	 }

	 /** 
	 * COP Inquriy S/O SCE_COP_LOG insert
     * @param COPInquiryVO inqVO
     * @throws DAOException
     */
	 public void addSceCopHis(COPInquiryVO inqVO) throws DAOException{
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		log.debug( "inqVO ==> " +inqVO.toString());
		
	     try {
	    	 param.put("cop_no", inqVO.getNewCopNo());
	    	 param.put("bkg_event_tp_cd", inqVO.getBkgEventTpCd());    	 
	    	 param.put("cre_usr_id", inqVO.getUsrId());
			log.debug("\n param:"+param);
 			new SQLExecuter("").executeUpdate((ISQLTemplate)new COPSearchDBDAOInsertSceLogCSQL(), param, velParam);   	    	 
	     } catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	 }
	 
	    /**
	     * searchBookingAllDetail 정보를 가져온다.<br>
	     * @param COPInquiryVO inqVO
	     * @return DBRowSet
	     * @throws DAOException
	     */
		public DBRowSet searchBookingAllDetail(COPInquiryVO inqVO) throws DAOException {
			DBRowSet dbRowset = null;		 
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				param.put("bkg_no", inqVO.getBkgNo());				
	 			if (inqVO.getCopNo() != null && inqVO.getCopNo().trim().length() > 0) {
	 				param.put("cop_no", inqVO.getCopNo());
	 				velParam.put("cop_no", inqVO.getCopNo());	 				
				}
 				log.debug("\n param:"+param);
 				
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchBookingAllDetailRSQL(), param, velParam);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (DAOException de) {
				log.error(de.getMessage(), de);
				throw de;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(e.getMessage());
			}
			 return dbRowset;			
		}

	    /**
	     * searchBookingVVDDetail 정보를 가져온다.<br>
	     * @param COPInquiryVO inqVO
	     * @return List<BookingInfoVO>
	     * @throws DAOException
	     */
	    @SuppressWarnings({ "rawtypes", "unchecked" })
		public List<BookingInfoVO>  searchBookingVVDDetail(COPInquiryVO inqVO) throws DAOException {
			DBRowSet dbRowset = null;					
			List<BookingInfoVO> list = null;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				param.put("bkg_no", inqVO.getBkgNo());				
 				log.debug("\n param:"+param);
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchBookingVVDDetailRSQL(), param, velParam);
 				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BookingInfoVO .class);				
 					
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (DAOException de) {
				log.error(de.getMessage(), de);
				throw de;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(e.getMessage());
			}
			return list;
		}

		/**
		 * COP Summary의 Status Change 된 데이타 모델을 DB에 반영한다.<br>
		 *
		 * @param String copNo
		 * @param String copSubStsCd
		 * @throws DAOException
		 */
		public void modifyCOPStatusChange(String copNo,String copSubStsCd) throws DAOException {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			 try{
				param.put("cop_no", copNo);
				param.put("cop_sub_sts_cd", copSubStsCd);				
								   
		    	new SQLExecuter("").executeUpdate((ISQLTemplate)new COPSearchDBDAOModifyCOPStatusChangeUSQL(), param, velParam);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (DAOException de) {
				log.error(de.getMessage(), de);
				throw de;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(e.getMessage());
			} 
		}
		
	    /** get MT node
		 * @param String cop_no
		 * @return String
		 * @throws DAOException
		 */
		public String searchCopCurrentBound(String cop_no) throws DAOException {
			DBRowSet dbRowset = null;
			String bndCd = null;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				param.put("e_cop_no", cop_no);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchCopCurrentBoundRSQL(), param, velParam);
				if(dbRowset.getRowCount()> 0){
					if(dbRowset.next()){
						bndCd = dbRowset.getString("bnd_cd");
					}
				}			
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

	        return bndCd;
		}

    /**
     * COP Detail에서 booking 리스트를 가져온다.<br>
     * @param COPDetailVO inqVO
     * @return List<SearchSceCopHdrInfoVO>
     * @throws DAOException
     */
	    @SuppressWarnings({ "rawtypes", "unchecked" })
	    public  List<SearchSceCopHdrInfoVO> searchBookingList(COPDetailVO inqVO) throws DAOException {
			DBRowSet dbRowset = null;		 
			List<SearchSceCopHdrInfoVO> list = null;
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
				
			try{
				log.error("\n 2010-04-14  searchBookingList  param:"+param);					
				//if (inqVO.getCntrNo() != null && inqVO.getCntrNo().trim().length() > 0) {
 				param.put("cntr_no", inqVO.getCntrNo());
 				velParam.put("cntr_no", inqVO.getCntrNo());	 				
				//}
				//if (inqVO.getCopNo() != null && inqVO.getCopNo().trim().length() > 0) {
	 				param.put("cop_no", inqVO.getCopNo());
	 				velParam.put("cop_no", inqVO.getCopNo());	 				
				//}
				log.debug("\n param:"+param);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchBookingListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSceCopHdrInfoVO .class);				
		
				log.error("\n 2010-04-14  searchBookingList  param:"+param);

	        } catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (DAOException de) {
				log.error(de.getMessage(), de);
				throw de;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				throw new DAOException(e.getMessage());
			} 
	        return list;
	    }

    /**
     * COP Detail 의 Transportation 정보를 가져온다.<br>
     * 
     * @param COPDetailVO inqVO
     * @return List<SearchTransportationInfoVO>
     * @throws DAOException
     * 2009-06-15 [SCE]An Jeong-Seon [Project# S1L-09U-003] Rail Export Cargo Available Return Time 개발
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchTransportationInfoVO> searchTransportationInfo(COPDetailVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;					
		List<SearchTransportationInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inqVO.getCntrNo() != null && inqVO.getCntrNo().trim().length() > 0) {
				velParam.put("cntr_no", inqVO.getCntrNo());
				param.put("cntr_no", inqVO.getCntrNo());					
			}			
			param.put("bkg_no", inqVO.getBkgNo());		
			param.put("cop_no", inqVO.getCopNo());				

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchTransportationInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTransportationInfoVO .class);				
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
        return list;
    }

    /**
     * COP Detail 의 Transportation 정보를 가져온다.<br>
     * @param COPDetailVO inqVO
     * @return List<SearchCOPDetailDtInfoVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchCOPDetailDtInfoVO> searchCOPDetailDtInfo(COPDetailVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;					
		List<SearchCOPDetailDtInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inqVO.getCntrNo() != null && inqVO.getCntrNo().trim().length() > 0) {
				velParam.put("cntr_no", inqVO.getCntrNo());
				param.put("cntr_no", inqVO.getCntrNo());					
			}			
			param.put("bkg_no", inqVO.getBkgNo());		
			param.put("cop_no", inqVO.getCopNo());				
			log.debug("\n param:"+param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchCOPDetailDtInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCOPDetailDtInfoVO .class);				
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
        return list;
    }
    

    /**
     * COP Detail 의 SO/Cost 정보를 가져온다.<br>
     * @param COPDetailVO inqVO
     * @return List<SearchSOCostInfoVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchSOCostInfoVO> searchSOCostInfo(COPDetailVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;					
		List<SearchSOCostInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = inqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchSOCostInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSOCostInfoVO .class);				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
        return list;
    }

    /**
     * COP Detail 의 Actual Information 정보를 가져온다.<br>
     * @param COPDetailVO inqVO
     * @return List<SearchActualInfoVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<SearchActualInfoVO> searchActualInfo(COPDetailVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;					
		List<SearchActualInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = inqVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchActualInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchActualInfoVO .class);				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
        return list;
    }
 
	/**
     * Target COP Infomation 조회 검색 결과를 가져온다.<br>
     * 
     * @param COPReplanInfoVO inqVO
     * @return List<SearchTargetCOPInfoListVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchTargetCOPInfoListVO> searchTargetCOPInfoList(COPReplanInfoVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTargetCOPInfoListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Set<String> copNoSet  = new HashSet<String>();
	    try {
			log.debug( "inqVO ==> " +inqVO.toString());
			String[] copNo = inqVO.getCopNo().split("<>");
			if(copNo != null && copNo.length > 0){
				for(int i=0; i<copNo.length; i++){
					copNoSet.add("'"+copNo[i]+"'");
				}
			}

			param.put("cop_no", copNoSet.toArray());
			velParam.put("cop_no", copNoSet.toArray());			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchTargetCOPInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTargetCOPInfoListVO .class);				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
        return list;
    }

	/**
     * 대상 COP 정보 건수 조회<br>
     * @param COPReplanInfoVO inqVO
     * @return int
     * @throws DAOException
     */
	public int searchTargetCOPInfoList2Cnt(COPReplanInfoVO inqVO) throws DAOException {
        int maxCount = 0;		
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>(); 
        try {
			Map<String, String> mapVO = inqVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);        	
			log.debug(velParam);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchTargetCOPInfoList2CntRSQL(), param, velParam);
			if(dbRowset.getRowCount()> 0){
				if(dbRowset.next()){
					maxCount = dbRowset.getInt("max_cnt");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

        return maxCount;
    }
	
	/**
     * Target PC Infomation 조회 검색 결과를 가져온다.<br>
     * 2008-06-20 Combined Flag 추가
     * @param COPReplanInfoVO inqVO
     * @return List<SearchTargetCOPInfoListVO>
     * @throws DAOException
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchTargetCOPInfoListVO> searchTargetCOPInfoList2(COPReplanInfoVO inqVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTargetCOPInfoListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>(); 
        try {
			Map<String, String> mapVO = inqVO.getColumnValues();

			log.debug( "inqVO ==> " +inqVO.toString());
			param.putAll(mapVO);
			velParam.putAll(mapVO);        	
			log.debug(velParam);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchTargetCOPInfoList2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTargetCOPInfoListVO .class);				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

        return list;
    }

    /** get MT node
	 * @param String cop_no
	 * @param String ioBndCd
	 * @return String
	 * @throws DAOException
	 */
	public String getMTNode(String cop_no, String ioBndCd) throws DAOException {
		DBRowSet dbRowset = null;
		String nodCd = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			String seqNum = null;
	        if("O".equals(ioBndCd)){
	        	seqNum = "1";
			}else{
				seqNum = "6";
			}
			param.put("cop_no", cop_no);
			velParam.put("io_bnd_cd", ioBndCd);
			param.put("io_bnd_cd", ioBndCd);	
			param.put("seq_num", seqNum);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new COPSearchDBDAOSearchMTNodeRSQL(), param, velParam);
			if(dbRowset.getRowCount()> 0){
				if(dbRowset.next()){
					nodCd = dbRowset.getString("nod_cd");
				}
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

        return nodCd;
	}

}
