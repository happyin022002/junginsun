/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAO.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
* History
* 2011.03.28 변종건 [CHM-201109427-01] [BKG] BKG Main 화면에서 Special(Reefer) cargo 변경 시 PSA로 변경 내용 I/F 요청
* 2011.05.03 이재위 [CHM-201108912] [Booking] AWK 화물의 weight Check 로직 생성 요청
* 2011.07.05 이일민 [CHM-201111757-01] [Special Cargo:Request로직] Group VVD assign, Next VVD Assign통한 자동 재승인요청
* 2011.07.15 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2011.10.21 변종건 [CHM-201113466-01] DG Cargo Application 기능 보완 요청
* 2012.05.22 김종호 [CHM-201217443][BKG]Special Cargo Reject건 자동이메일전송기능
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkAproInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbAproInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbCntrListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkDimVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgBbCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgDgCgoInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrInfoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrTypzQtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgAproInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgPackageVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.ImdgPckDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfAproInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.ScgImdgUnNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SegrGrpVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpecialCargoRjEmlVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS SpecialCargoReceiptDBDAO <br>
 * - ALPS-SpecialCargoBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Lee Byung Kyu
 * @see SpecialCargoReceiptBCImpl 참조
 * @since J2EE 1.6
 */
public class SpecialCargoReceiptDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5579379496997680490L;

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<AwkBkgInfoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<AwkBkgInfoVO> searchAwkBkgInfo(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<AwkBkgInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOAwkBkgInfoVORSQL template = new SpecialCargoReceiptDBDAOAwkBkgInfoVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, AwkBkgInfoVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return AwkAproInfoVO rsVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AwkAproInfoVO searchAwkApproval(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        AwkAproInfoVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOAwkAproInfoVORSQL template = new SpecialCargoReceiptDBDAOAwkAproInfoVORSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            List<AwkAproInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, AwkAproInfoVO.class);
            if(list!=null && list.size()>0){
                rsVO = list.get(0);
            }else{
            	rsVO = new AwkAproInfoVO();
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<BkgAwkCgoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<BkgAwkCgoVO> searchAwkCgoList(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgAwkCgoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOBkgAwkCgoVORSQL template = new SpecialCargoReceiptDBDAOBkgAwkCgoVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgAwkCgoVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<BkgAwkDimVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<BkgAwkDimVO> searchAwkDimDtl(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgAwkDimVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOBkgAwkDimVORSQL template = new SpecialCargoReceiptDBDAOBkgAwkDimVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgAwkDimVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String awkCgoSeq
	 * @param String caFlg
	 * @return List<BkgAwkDimVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<BkgAwkDimVO> searchDimension(String bkgNo, String awkCgoSeq, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgAwkDimVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("awk_cgo_seq", awkCgoSeq);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAODimensionRSQL template = new SpecialCargoReceiptDBDAODimensionRSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgAwkDimVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String spclTp
	 * @param String caFlg
	 * @return List<CntrTypzQtyVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<CntrTypzQtyVO> searchCntrTpszQty(String bkgNo, String spclTp, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrTypzQtyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            velParam.put("spcl_tp", spclTp);
            velParam.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOCntrTypzQtyVORSQL template = new SpecialCargoReceiptDBDAOCntrTypzQtyVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrTypzQtyVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgAwkCgoVO> insModels
	 * @param String uiId
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void addBkgAwkCgo(List<BkgAwkCgoVO> insModels, String uiId, String caFlg) throws DAOException {
	      try {
	          SQLExecuter sqlExe = new SQLExecuter("");
	          int insCnt[] = null;
	          Map<String, Object> velParam = new HashMap<String, Object>();
	          if(insModels.size() > 0){	        		        	  
	        	  velParam.put("ca_flg", caFlg); 
	        	  if("ESM_BKG_0229".equals(uiId) ){		        	 
	        		  SpecialCargoReceiptDBDAOEBookingBkgAwkCgoCSQL template = new SpecialCargoReceiptDBDAOEBookingBkgAwkCgoCSQL();
	        		  insCnt = sqlExe.executeBatch(template, insModels, velParam);
	        	  }else{	        	  
	        		  SpecialCargoReceiptDBDAOBkgAwkCgoVOCSQL template = new SpecialCargoReceiptDBDAOBkgAwkCgoVOCSQL();
	        		  insCnt = sqlExe.executeBatch(template, insModels, velParam);
	        	  }
	              
	              for(int i = 0; i < insCnt.length; i++){
	                  if(insCnt[i]== Statement.EXECUTE_FAILED)
	                      throw new DAOException("Fail to insert No"+ i + " SQL");
	              }
	          }
	      } catch (SQLException se) {
	          log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage(), se);
	      }catch(Exception ex){
	          log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	      }
	  }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgAwkCgoVO> insModels
	 * @param String uiId
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyBkgAwkCgo(List<BkgAwkCgoVO> insModels, String uiId, String caFlg) throws DAOException {
	      try {
	          SQLExecuter sqlExe = new SQLExecuter("");
	          int insCnt[] = null;
	          Map<String, Object> velParam = new HashMap<String, Object>();
	          if(insModels.size() > 0){
	        	  velParam.put("ca_flg", caFlg);   	        	  
	        	  if("ESM_BKG_0229".equals(uiId) ){
	        		  SpecialCargoReceiptDBDAOEBookingBkgAwkCgoUSQL template = new SpecialCargoReceiptDBDAOEBookingBkgAwkCgoUSQL();
		              insCnt = sqlExe.executeBatch(template, insModels, velParam);
	        	  }else{
	        		  SpecialCargoReceiptDBDAOBkgAwkCgoVOUSQL template = new SpecialCargoReceiptDBDAOBkgAwkCgoVOUSQL();
		              insCnt = sqlExe.executeBatch(template, insModels, velParam);
	        	  }	        	  
	              for(int i = 0; i < insCnt.length; i++){
	                  if(insCnt[i]== Statement.EXECUTE_FAILED)
	                      throw new DAOException("Fail to insert No"+ i + " SQL");
	              }
	          }
	      } catch (SQLException se) {
	          log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage(), se);
	      }catch(Exception ex){
	          log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	      }
	  }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgAwkCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void removeBkgAwkCgo(List<BkgAwkCgoVO> insModels, String caFlg) throws DAOException {
	      try {
	          SQLExecuter sqlExe = new SQLExecuter("");
	          int insCnt[] = null;
	          Map<String, Object> velParam = new HashMap<String, Object>();
	          if(insModels.size() > 0){
	        	  velParam.put("ca_flg", caFlg);   
	        	  
	        	  SpecialCargoReceiptDBDAOBkgAwkCgoVODSQL template = new SpecialCargoReceiptDBDAOBkgAwkCgoVODSQL();
	              insCnt = sqlExe.executeBatch(template, insModels, velParam);
	              for(int i = 0; i < insCnt.length; i++){
	                  if(insCnt[i]== Statement.EXECUTE_FAILED)
	                      throw new DAOException("Fail to insert No"+ i + " SQL");
	              }
	          }
	      } catch (SQLException se) {
	          log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage(), se);
	      }catch(Exception ex){
	          log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	      }
	  }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String spclTp
	 * @param String caFlg
	 * @return List<CntrComboVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<CntrComboVO> searchCntrList(String bkgNo, String spclTp, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);
            mapVO.put("spcl_tp", spclTp);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOBkgContainerRSQL template = new SpecialCargoReceiptDBDAOBkgContainerRSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrComboVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgAwkDimVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void addBkgAwkDim(List<BkgAwkDimVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			if(insModels.size() > 0){
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
        	  
				Map<String, String> mapVO = insModels.get(0).getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("ca_flg", caFlg);
				sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOBkgAwkDimVODSQL(), param, velParam);

				SpecialCargoReceiptDBDAOBkgAwkDimVOCSQL template = new SpecialCargoReceiptDBDAOBkgAwkDimVOCSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgAwkDimVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void removeBkgAwkDim(List<BkgAwkDimVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);
				SpecialCargoReceiptDBDAOBkgAwkDimVODSQL template = new SpecialCargoReceiptDBDAOBkgAwkDimVODSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
      	} catch (SQLException se) {
      		log.error(se.getMessage(),se);
          	throw new DAOException(new ErrorHandler(se).getMessage(), se);
      	}catch(Exception ex){
      		log.error(ex.getMessage(),ex);
          	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
      	}
	}	
	
	/**
	 * 저장시 Dg Sequence를 체크한다. (ESM_BKG_0055)
	 * @param String bkgNo
	 * @param String dgSn
	 * @param String caFlg
	 * @return String strResult
	 * @throws DAOException
	 */	
	public String searchDgSn(String bkgNo, String dgSn, String caFlg) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = null;
		
		Map<String, String> mapVO = new HashMap<String, String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{		
			param.put("bkg_no", bkgNo); 
			param.put("dcgo_seq", dgSn);
			
			param.putAll(mapVO);
            velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoReceiptDBDAODgSnRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("DGSN");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	
	/**
	 * 저장시 Dg UN_NO를 체크한다. (ESM_BKG_0055)
	 * @param String unNo
	 * @return String strResult	 
	 * @throws DAOException
	 */	
	public String searchUnNoIno(String unNo) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{		
			param.put("imdg_un_no", unNo); 
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpeckalCargoReceiptDBDAOsearchUnNoInoRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("IMDG_UN_NO");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	
	/**
	 * 저장시 Dg UN_NO를 체크한다. (ESM_BKG_0055)
	 * @param String bkgNo
	 * @param String dcgoSeq
	 * @param String imdgUnNo
	 * @param String imdgClssCd
	 * @return String strResult	 
	 * @throws DAOException
	 */	
	public String searchChnProhibit(String bkgNo, String dcgoSeq, String imdgUnNo, String imdgClssCd) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{		
			param.put("bkg_no"	  , bkgNo); 
			param.put("dcgo_seq"  , dcgoSeq); 
			param.put("imdg_un_no", imdgUnNo); 
			param.put("imdg_clss_cd", imdgClssCd); 
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpeckalCargoReceiptDBDAOsearchChnProhibitRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("FLAG");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	
	/**
	 * SAVE 전에 GRS_MAX_WGT를 체크한다. (ESM_BKG_0055)
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String grsWgt
	 * @param String cntrTpszCd
	 * @param String wgtUtCd
	 * @return String[] strResult	 
	 * @throws DAOException
	 */
	public String[] searchGrsMaxWgt(String bkgNo, String cntrNo, String grsWgt, String cntrTpszCd, String wgtUtCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] strResult = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{		
			param.put("bkg_no", bkgNo); 
			param.put("cntr_no", cntrNo); 
			param.put("grs_wgt", grsWgt); 
			param.put("cntr_tpsz_cd", cntrTpszCd);
			
			velParam.put("wgt_ut_cd", wgtUtCd);
			
			if(cntrNo!=null && cntrNo.length()!=0){ // 2011.07.14
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoReceiptDBDAOSearchGrsMaxWgtRSQL(), param, velParam);
			} else {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoReceiptDBDAOSearchGrsMaxWgtByTpszRSQL(), param, velParam);
			}
			if(dbRowset.next()) {
				strResult = new String[3];
				strResult[0] = dbRowset.getString("WGT_PASS");
				strResult[1] = dbRowset.getString("CNTR_TP_SZ_WGT_PASS");
				strResult[2] = dbRowset.getString("CNTR_TP_SZ_WGT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}	
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgAwkCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyDgAwkSeq1(List<BkgAwkCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
          	int insCnt[] = null;
          	Map<String, Object> velParam = new HashMap<String, Object>();        	  
	        	 
          	if(insModels.size() > 0){
          		velParam.put("ca_flg", caFlg);	        	  
          		SpecialCargoReceiptDBDAODcgoUSQL template = new SpecialCargoReceiptDBDAODcgoUSQL();
          		insCnt = sqlExe.executeBatch(template, insModels, velParam);
          		for(int i = 0; i < insCnt.length; i++){
          			if(insCnt[i]== Statement.EXECUTE_FAILED)
          				throw new DAOException("Fail to insert No"+ i + " SQL");
          		}
          	}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
          	log.error(ex.getMessage(),ex);
          	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgAwkCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyDgAwkSeq2(List<BkgAwkCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
	          
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);  
				SpecialCargoReceiptDBDAODcgo2USQL template = new SpecialCargoReceiptDBDAODcgo2USQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgRfCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyDgRfSeq1(List<BkgRfCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			int insCnt[] = null;
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);
				SpecialCargoReceiptDBDAODcgoRfUSQL template = new SpecialCargoReceiptDBDAODcgoRfUSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
          	log.error(se.getMessage(),se);
          	throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
          	log.error(ex.getMessage(),ex);
          	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgRfCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyDgRfSeq2(List<BkgRfCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);
				SpecialCargoReceiptDBDAODcgoRf2USQL template = new SpecialCargoReceiptDBDAODcgoRf2USQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
              	}	
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
          	log.error(ex.getMessage(),ex);
          	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
  	}
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<DgBkgInfoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<DgBkgInfoVO> searchDgBkgInfo(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<DgBkgInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAODgBkgInfoVORSQL template = new SpecialCargoReceiptDBDAODgBkgInfoVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DgBkgInfoVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return DgAproInfoVO rsVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DgAproInfoVO searchDgApproval(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        DgAproInfoVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAODgAproInfoVORSQL template = new SpecialCargoReceiptDBDAODgAproInfoVORSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            List<DgAproInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, DgAproInfoVO.class);
            if(list!=null && list.size()>0){
                rsVO = list.get(0);
            }else{
            	rsVO = new DgAproInfoVO();
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<BkgDgCgoInfoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<BkgDgCgoInfoVO> searchDgCgoList(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgDgCgoInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOBkgDgCgoInfoVORSQL template = new SpecialCargoReceiptDBDAOBkgDgCgoInfoVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgDgCgoInfoVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<DgCgoListVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<DgCgoListVO> searchDgList(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<DgCgoListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAODgCgoListVORSQL template = new SpecialCargoReceiptDBDAODgCgoListVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DgCgoListVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }	

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<CntrInfoListVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<CntrInfoListVO> searchCntrInfoList(String bkgNo, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<CntrInfoListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOCntrInfoListVORSQL template = new SpecialCargoReceiptDBDAOCntrInfoListVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, CntrInfoListVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String code
	 * @param String desc
	 * @param String pckTpCd
	 * @return List<DgPackageVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<DgPackageVO> searchDgPackage(String code, String desc, String pckTpCd) throws DAOException {
        DBRowSet dbRowset = null;
        List<DgPackageVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("imdg_pck_cd", code);
            mapVO.put("imdg_pck_desc", desc);
            mapVO.put("imdg_pck_tp_cd", pckTpCd);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAODgPackageVORSQL template = new SpecialCargoReceiptDBDAODgPackageVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, DgPackageVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
		
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String unNo
	 * @param String imdgClass
	 * @param String prpShpNm
	 * @return List<ScgImdgUnNoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<ScgImdgUnNoVO> searchDgUnNumber(String bkgNo, String unNo, String imdgClass, String prpShpNm) throws DAOException {
        DBRowSet dbRowset = null;
        List<ScgImdgUnNoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            
            if(unNo.indexOf("@@") > -1){
            	mapVO.put("imdg_un_no", unNo.split("@@")[0]);
            	mapVO.put("imdg_un_no_seq", unNo.split("@@")[1]);
            } else {
            	mapVO.put("imdg_un_no", unNo);
            }
            
            mapVO.put("imdg_clss_cd", imdgClass);
            mapVO.put("prp_shp_nm", prpShpNm);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOScgImdgUnNoVORSQL template = new SpecialCargoReceiptDBDAOScgImdgUnNoVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, ScgImdgUnNoVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }	
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String cntrNo
	 * @param String cntrTpszCd	 
	 * @param String caFlg	 
	 * @return List<BkgDgCgoInfoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<BkgDgCgoInfoVO> searchDgSequence(String bkgNo, String cntrNo, String cntrTpszCd, String caFlg) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgDgCgoInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo); 
            mapVO.put("cntr_no", cntrNo); 
            mapVO.put("cntr_tpsz_cd", cntrTpszCd); 
            
            velParam.put("cntr_no", cntrNo);
            velParam.put("cntr_tpsz_cd", cntrTpszCd);
            velParam.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAODgSequenceRSQL template = new SpecialCargoReceiptDBDAODgSequenceRSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgDgCgoInfoVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
		
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<DgCgoListVO> insModels
	 * @param String uiId
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void addDgCgoList(List<DgCgoListVO> insModels, String uiId, String caFlg) throws DAOException {
		try {
          	SQLExecuter sqlExe = new SQLExecuter("");
          	int insCnt[] = null;
          	Map<String, Object> velParam = new HashMap<String, Object>();
	          
          	if(insModels.size() > 0){
          		velParam.put("ca_flg", caFlg);
          		if("ESM_BKG_0229".equals(uiId) ){
          			SpecialCargoReceiptDBDAOEBookingBkgDgCgoCSQL template = new SpecialCargoReceiptDBDAOEBookingBkgDgCgoCSQL();
          			insCnt = sqlExe.executeBatch(template, insModels, velParam);
          		}else{
          			SpecialCargoReceiptDBDAODgCgoListVOCSQL template = new SpecialCargoReceiptDBDAODgCgoListVOCSQL();
          			insCnt = sqlExe.executeBatch(template, insModels, velParam);
          		}
          		for(int i = 0; i < insCnt.length; i++){
          			if(insCnt[i]== Statement.EXECUTE_FAILED)
          				throw new DAOException("Fail to insert No"+ i + " SQL");
          		}
          	}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<DgCgoListVO> insModels
	 * @param String uiId
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyDgCgoList(List<DgCgoListVO> insModels, String uiId, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){	        	  
				velParam.put("ca_flg", caFlg);
				if("ESM_BKG_0229".equals(uiId) ){
					SpecialCargoReceiptDBDAOEBookingBkgDgCgoUSQL template = new SpecialCargoReceiptDBDAOEBookingBkgDgCgoUSQL();
					insCnt = sqlExe.executeBatch(template, insModels, velParam);
				}else{
					SpecialCargoReceiptDBDAODgCgoListVOUSQL template = new SpecialCargoReceiptDBDAODgCgoListVOUSQL();
					insCnt = sqlExe.executeBatch(template, insModels, velParam);
				}
	              
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
      	}catch(Exception ex){
      		log.error(ex.getMessage(),ex);
      		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
      	}
	}

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<DgCgoListVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void removeDgCgoList(List<DgCgoListVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);
				SpecialCargoReceiptDBDAODgCgoListVODSQL template = new SpecialCargoReceiptDBDAODgCgoListVODSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgRfCgoVO> insModels
	 * @param String uiId
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void addBkgRfCgo(List<BkgRfCgoVO> insModels, String uiId, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);
				if("ESM_BKG_0229".equals(uiId) ){
					SpecialCargoReceiptDBDAOEBookingBkgRfCgoCSQL template = new SpecialCargoReceiptDBDAOEBookingBkgRfCgoCSQL();
					insCnt = sqlExe.executeBatch(template, insModels, velParam);
				}else{
					SpecialCargoReceiptDBDAOBkgRfCgoVOCSQL template = new SpecialCargoReceiptDBDAOBkgRfCgoVOCSQL();
					insCnt = sqlExe.executeBatch(template, insModels, velParam);
				}
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgRfCgoVO> insModels
	 * @param String uiId
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyBkgRfCgo(List<BkgRfCgoVO> insModels, String uiId, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);
				if("ESM_BKG_0229".equals(uiId) ){	        		  
					SpecialCargoReceiptDBDAOEBookingBkgRfCgoUSQL template = new SpecialCargoReceiptDBDAOEBookingBkgRfCgoUSQL();
					insCnt = sqlExe.executeBatch(template, insModels, velParam);
				}else{
					SpecialCargoReceiptDBDAOBkgRfCgoVOUSQL template = new SpecialCargoReceiptDBDAOBkgRfCgoVOUSQL();
					insCnt = sqlExe.executeBatch(template, insModels, velParam);
				}
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgRfCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void removeBkgRfCgo(List<BkgRfCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);
				SpecialCargoReceiptDBDAObkgRfCgoVODSQL template = new SpecialCargoReceiptDBDAObkgRfCgoVODSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
              	}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<RfBkgInfoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<RfBkgInfoVO> searchRfBkgInfo(String bkgNo, String caFlg) throws DAOException {		
        DBRowSet dbRowset = null;
        List<RfBkgInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAORfBkgInfoVORSQL template = new SpecialCargoReceiptDBDAORfBkgInfoVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RfBkgInfoVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return RfAproInfoVO rsVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public RfAproInfoVO searchRfApproval(String bkgNo, String caFlg) throws DAOException {		
        DBRowSet dbRowset = null;
        RfAproInfoVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAORfAproInfoVORSQL template = new SpecialCargoReceiptDBDAORfAproInfoVORSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            List<RfAproInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, RfAproInfoVO.class);
            if(list!=null && list.size()>0){
                rsVO = list.get(0);
            }else{
            	rsVO = new RfAproInfoVO();
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<BkgRfCgoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<BkgRfCgoVO> searchRfCgoList(String bkgNo, String caFlg) throws DAOException {		
        DBRowSet dbRowset = null;
        List<BkgRfCgoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOBkgRfCgoVORSQL template = new SpecialCargoReceiptDBDAOBkgRfCgoVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgRfCgoVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }		
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<BbBkgInfoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<BbBkgInfoVO> searchBbBkgInfo(String bkgNo, String caFlg) throws DAOException {		
        DBRowSet dbRowset = null;
        List<BbBkgInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOBbBkgInfoVORSQL template = new SpecialCargoReceiptDBDAOBbBkgInfoVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BbBkgInfoVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String caFlg
	 * @return BbAproInfoVO rsVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BbAproInfoVO searchBbApproval(String bkgNo, String caFlg) throws DAOException {		
        DBRowSet dbRowset = null;
        BbAproInfoVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOBbAproInfoVORSQL template = new SpecialCargoReceiptDBDAOBbAproInfoVORSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            List<BbAproInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BbAproInfoVO.class);
            if(list!=null && list.size()>0){
                rsVO = list.get(0);
            }else{
            	rsVO = new BbAproInfoVO();
            }
        } catch(SQLException ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            // log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsVO;
    }

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<BkgBbCgoVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<BkgBbCgoVO> searchBbCgoList(String bkgNo, String caFlg) throws DAOException {		
        DBRowSet dbRowset = null;
        List<BkgBbCgoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOBkgBbCgoVORSQL template = new SpecialCargoReceiptDBDAOBkgBbCgoVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgBbCgoVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }	
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<BbCntrListVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<BbCntrListVO> searchBbCgoCntrList(String bkgNo, String caFlg) throws DAOException {		
        DBRowSet dbRowset = null;
        List<BbCntrListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("ca_flg", caFlg);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOBbCntrListVORSQL template = new SpecialCargoReceiptDBDAOBbCntrListVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BbCntrListVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }		
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgBbCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void addBkgBbCgo(List<BkgBbCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);
	        	  
				SpecialCargoReceiptDBDAOBkgBbCgoVOCSQL template = new SpecialCargoReceiptDBDAOBkgBbCgoVOCSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
          	log.error(ex.getMessage(),ex);
          	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgBbCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyBkgBbCgo(List<BkgBbCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);
				SpecialCargoReceiptDBDAOBkgBbCgoVOUSQL template = new SpecialCargoReceiptDBDAOBkgBbCgoVOUSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
      	} catch (SQLException se) {
      		log.error(se.getMessage(),se);
      		throw new DAOException(new ErrorHandler(se).getMessage(), se);
      	}catch(Exception ex){
      		log.error(ex.getMessage(),ex);
      		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
      	}
	}

	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgBbCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void removeBkgBbCgo(List<BkgBbCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);
				SpecialCargoReceiptDBDAOBkgBbCgoVODSQL template = new SpecialCargoReceiptDBDAOBkgBbCgoVODSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgBbCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyDgBbSeq1(List<BkgBbCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);
				SpecialCargoReceiptDBDAODcgoBbUSQL template = new SpecialCargoReceiptDBDAODcgoBbUSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param List<BkgBbCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyDgBbSeq2(List<BkgBbCgoVO> insModels, String caFlg) throws DAOException {
      	try {
      		SQLExecuter sqlExe = new SQLExecuter("");
      		int insCnt[] = null;
      		Map<String, Object> velParam = new HashMap<String, Object>();
      		if(insModels.size() > 0){
      			velParam.put("ca_flg", caFlg);
      			SpecialCargoReceiptDBDAODcgoBb2USQL template = new SpecialCargoReceiptDBDAODcgoBb2USQL();
      			insCnt = sqlExe.executeBatch(template, insModels, velParam);
          		for(int i = 0; i < insCnt.length; i++){
          			if(insCnt[i]== Statement.EXECUTE_FAILED)
          				throw new DAOException("Fail to insert No"+ i + " SQL");
          		}
      		}
      	} catch (SQLException se) {
      		log.error(se.getMessage(),se);
      		throw new DAOException(new ErrorHandler(se).getMessage(), se);
      	}catch(Exception ex){
      		log.error(ex.getMessage(),ex);
      		throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
      	}
	}

	/**
	 * SpecialCargo CmdtCd로 정보 조회.(ESM_BKG_0498)<br>	 
	 * @param 		String imdgPckCd
	 * @param 		String imdgPckTpCd
	 * @return 		ImdgPckDescVO imdgPckDescVO
	 * @exception 	DAOException
	 */
	 @SuppressWarnings("unchecked")
	public ImdgPckDescVO searchImdgPckDesc(String imdgPckCd, String imdgPckTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ImdgPckDescVO> list = null;
		ImdgPckDescVO imdgPckDescVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("imdg_pck_cd", imdgPckCd);
			param.put("imdg_pck_tp_cd", imdgPckTpCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoReceiptDBDAOImdgPckDescVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ImdgPckDescVO .class);
			if(list != null && list.size() > 0){
				imdgPckDescVO = list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return imdgPckDescVO;
	}
	 
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @return String strResult
	 * @throws DAOException
	 */
	public String searchBkgVvdSlane(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{		
			param.put("bkg_no", bkgNo); 
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoReceiptDBDAOsearchBkgVvdSlaneRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("SLAN_CD");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}	
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo	 
	 * @return List<BkgVvdVO> list
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<BkgVvdVO> searchBkgVvd(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgVvdVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
           
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOBkgVvdVORSQL template = new SpecialCargoReceiptDBDAOBkgVvdVORSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgVvdVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

	/**
	 * 조회 이벤트 처리<br>
	 * T/S 화면에서 vvd 재지정시 Special cargo 재 request를 위한 vvd 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @param List<String> paramVvds
	 * @return ScgVvdAproRqstVO[]
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgVvdVO> searchBkgVvdTs(String bkgNo, List<String> paramVvds) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgVvdVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
           
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            velParam.put("vvds", paramVvds);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOSearchBkgVvdTsRSQL template = new SpecialCargoReceiptDBDAOSearchBkgVvdTsRSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgVvdVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * c/a 화면에서 vvd 재지정시 Special cargo 재 request를 위한 vvd 정보 조회<br>
	 *
	 * @param String bkgNo
	 * @return ScgVvdAproRqstVO[]
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgVvdVO> searchBkgVvdCa(String bkgNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgVvdVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
           
            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOSearchBkgVvdCaRSQL template = new SpecialCargoReceiptDBDAOSearchBkgVvdCaRSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgVvdVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
	}
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *  	 
	 * @param 	String bkgNo
	 * @param 	String aproCd
	 * @param 	String awkCgoSeq
	 * @param 	String rqstUsrId
	 * @throws 	DAOException
	 */
	public void modifyAwkReq(String bkgNo, String aproCd, String awkCgoSeq, String rqstUsrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("apro_cd", aproCd);
			param.put("awk_cgo_seq", awkCgoSeq);			
			param.put("rqst_usr_id", rqstUsrId);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("apro_cd", aproCd);
			velParam.put("awk_cgo_seq", awkCgoSeq);			
			velParam.put("rqst_usr_id", rqstUsrId);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOmodifyAwkReqUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String aproCd
	 * @param String dcgoSeq
	 * @param String rqstUsrId
	 * @throws DAOException
	 */
	public void modifyDgReq(String bkgNo, String aproCd, String dcgoSeq, String rqstUsrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("apro_cd", aproCd);
			param.put("dcgo_seq", dcgoSeq);				
			param.put("rqst_usr_id", rqstUsrId);			

			velParam.put("bkg_no", bkgNo);
			velParam.put("apro_cd", aproCd);
			velParam.put("dcgo_seq", dcgoSeq);				
			velParam.put("rqst_usr_id", rqstUsrId);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOmodifyDgReqUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String aproCd
	 * @param String bbCgoSeq
	 * @param String rqstUsrId
	 * @throws DAOException
	 */
	public void modifyBbReq(String bkgNo, String aproCd, String bbCgoSeq, String rqstUsrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("apro_cd", aproCd);
			param.put("bb_cgo_seq", bbCgoSeq);			
			param.put("rqst_usr_id", rqstUsrId);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("apro_cd", aproCd);
			velParam.put("bb_cgo_seq", bbCgoSeq);			
			velParam.put("rqst_usr_id", rqstUsrId);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOmodifyBbReqUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * SpecialCargoReceiptDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String bkgNo
	 * @param String aproCd
	 * @param String rcSeq
	 * @param String rqstUsrId
	 * @throws DAOException
	 */
	public void modifyRfReq(String bkgNo, String aproCd, String rcSeq, String rqstUsrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("bkg_no", bkgNo);
			param.put("apro_cd", aproCd);
			param.put("rc_seq", rcSeq);			
			param.put("rqst_usr_id", rqstUsrId);
			
			velParam.put("bkg_no", bkgNo);
			velParam.put("apro_cd", aproCd);
			velParam.put("rc_seq", rcSeq);			
			velParam.put("rqst_usr_id", rqstUsrId);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOmodifyRfReqUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
//	/**
//	 * booking split시 bkg_dg_cgo정보를 복사한다.<br>
//	 * 
//	 * @param BkgBlNoVO sourceBkg
//	 * @param BkgBlNoVO targetBkg
//	 * @param String dgSeq
//	 * @param SignOnUserAccount account
//	 * @exception DAOException
//	 */
//	public void copyDgCgoByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String dgSeq,SignOnUserAccount account) throws DAOException {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try{
//			if(sourceBkg != null){
//				param.put("dcgo_seq", dgSeq); 
//				param.put("bkg_no", sourceBkg.getBkgNo());
//				param.put("targetBkg", targetBkg.getBkgNo());
//				param.put("usr_id", account.getUsr_id());
//			}
//			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
//			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOcopyDgCgoBySplitCSQL(), param,velParam);
//			if(insCnt == Statement.EXECUTE_FAILED)            //SpecialCargoReceiptDBDAOcopyDgCgoBySplitCSQL
//				throw new DAOException("Fail to insert SQL");			
//		
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * booking split시 bkg_dg_cgo정보를 복사한다.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg 
	 * @param String cntrNo
	 * @param String dgSeq
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyDgCgoBySplit(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String cntrNo, String dgSeq,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("dcgo_seq", dgSeq); 
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
				param.put("cntr_no", cntrNo);
				velParam.put("dcgo_seq", dgSeq); 
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOcopyDgCgoBySplitCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * booking split시 bkg_rf_cgo정보를 복사한다.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String cntrNo
	 * @param String rfSeq
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyRfCgoBySplit(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String cntrNo,String rfSeq,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("rc_seq", rfSeq); 
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
				param.put("cntr_no", cntrNo);
				velParam.put("rc_seq", rfSeq); 
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOcopyRfCgoBySplitCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * booking split시 bkg_awk_cgo정보를 복사한다.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String cntrNo
	 * @param String akSeq
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyAkCgoBySplit(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String cntrNo,String akSeq,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("awk_cgo_seq", akSeq); 
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
				param.put("cntr_no", cntrNo);
				velParam.put("awk_cgo_seq", akSeq); 
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOcopyAkCgoBySplitCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * booking split시 bkg_awk_dim정보를 복사한다.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String cntrNo
	 * @param String akSeq
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyAkDimBySplit(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String cntrNo,String akSeq,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("awk_cgo_seq", akSeq); 
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
				param.put("cntr_no", cntrNo);
				velParam.put("awk_cgo_seq", akSeq); 
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOcopyAkDimBySplitCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * booking split시 bkg_bb_cgo정보를 복사한다.<br>
	 * 
	 * @param BkgBlNoVO sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String bbSeq
	 * @param SignOnUserAccount account
	 * @exception DAOException
	 */
	public void copyBbCgoBySplit(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String bbSeq,SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("bb_cgo_seq", bbSeq); 
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("targetBkg", targetBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
				velParam.put("bb_cgo_seq", bbSeq); 
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOcopyBbCgoBySplitCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * danger Cargo 정보 삭제 <br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String cntrNo
	 * @param String dgSeq
	 * @exception DAOException
	 */
	public void removeBkgDgCgo(BkgBlNoVO bkgBlNoVO, String cntrNo, String dgSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				param.put("dcgo_seq", dgSeq); 
				param.put("cntr_no", cntrNo);
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				velParam.put("dcgo_seq", dgSeq);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOremoveBkgDgCgoDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * reefer Cargo 정보 삭제<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String cntrNo
	 * @param String rfSeq
	 * @exception DAOException
	 */
	public void removeBkgRfCgo(BkgBlNoVO bkgBlNoVO, String cntrNo, String rfSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				param.put("rc_seq", rfSeq);  
				param.put("cntr_no", cntrNo);
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				velParam.put("rc_seq", rfSeq);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOremoveBkgRfCgoDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");				
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Awkward Cargo 정보 삭제 <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String cntrNo
	 * @param String akSeq
	 * @exception DAOException
	 */
	public void removeBkgAwkCgo(BkgBlNoVO bkgBlNoVO, String cntrNo,String akSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				param.put("awk_cgo_seq", akSeq);  
				param.put("cntr_no", cntrNo);
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				velParam.put("awk_cgo_seq", akSeq);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOremoveBkgAwkCgoDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Awkward Cargo Package Dimension 별 삭제 <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String cntrNo
	 * @param String akSeq
	 * @exception DAOException
	 */
	public void removeBkgAwkDim(BkgBlNoVO bkgBlNoVO, String cntrNo, String akSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				param.put("awk_cgo_seq", akSeq);  
				param.put("cntr_no", cntrNo);
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
				velParam.put("awk_cgo_seq", akSeq);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOremoveBkgAwkDimDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Break Bulk Cargo 정보 삭제 <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String bbSeq
	 * @exception DAOException
	 */
	public void removeBkgBbCgo(BkgBlNoVO bkgBlNoVO,String bbSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(bkgBlNoVO != null){
				param.put("bb_cgo_seq", bbSeq); 
				param.put("bkg_no", bkgBlNoVO.getBkgNo());
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOremoveBkgBbCgoDSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * sourceBkg의 bkg_dg_cgo정보를 targetBkg로 복사한다.(ESM_BKG_0076)
	 * @author 	Jun Yong Jin
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param String copyModeCd
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyDgCgoByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String copyModeCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("mst_bkg_no", targetBkg.getBkgNo());
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
			}
			velParam.put("copy_mode_cd", copyModeCd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOcopyDgCgoByBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * sourceBkg의 bkg_rf_cgo정보를 targetBkg로 복사한다.(ESM_BKG_0076)
	 * @author 	Jun Yong Jin
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param String copyModeCd
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyRfCgoByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String copyModeCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("mst_bkg_no", targetBkg.getBkgNo());
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());			
			}
            velParam.put("copy_mode_cd", copyModeCd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOcopyRfCgoByBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * sourceBkg의 bkg_awk_cgo정보를 targetBkg로 복사한다.(ESM_BKG_0076)
	 * @author 	Jun Yong Jin
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param String copyModeCd
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyAkCgoByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String copyModeCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("mst_bkg_no", targetBkg.getBkgNo());
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
			}
			velParam.put("copy_mode_cd", copyModeCd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOcopyAkCgoByBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * sourceBkg의 bkg_awk_dim정보를 targetBkg로 복사한다.(ESM_BKG_0076)
	 * @author 	Jun Yong Jin 
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param String copyModeCd
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyAkDimByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String copyModeCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("mst_bkg_no", targetBkg.getBkgNo());
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
			}
			velParam.put("copy_mode_cd", copyModeCd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOcopyAkDimByBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * sourceBkg의 bkg_bb_cgo정보를 targetBkg로 복사한다.(ESM_BKG_0076)
	 * @author 	Jun Yong Jin
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param String copyModeCd
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copyBBCgoByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, String copyModeCd, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(sourceBkg != null){
				param.put("mst_bkg_no", targetBkg.getBkgNo());
				param.put("bkg_no", sourceBkg.getBkgNo());
				param.put("usr_id", account.getUsr_id());
			}
			velParam.put("copy_mode_cd", copyModeCd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOcopyBBCgoByBkgCSQL(), param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
     * BKG, Container 별로 Awkward Cargo를 Copy 하여 생성한다.
     * @param CntrCopyVO cntrCopyVO
     */
    public void copyAkCgoByCntr(CntrCopyVO cntrCopyVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = cntrCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOAkCgoByCntrCSQL template = new SpecialCargoReceiptDBDAOAkCgoByCntrCSQL();
            int rcnt = sqlExe.executeUpdate(template, param,velParam);
            if(rcnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * BKG, Container 별로 Awkward Cargo Detail 정보를 Copy 하여 생성한다.
     * @param CntrCopyVO cntrCopyVO
     */
    public void copyAkDimByCntr(CntrCopyVO cntrCopyVO)  throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = cntrCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOAkDimByCntrCSQL template = new SpecialCargoReceiptDBDAOAkDimByCntrCSQL();
            int rcnt = sqlExe.executeUpdate(template, param,velParam);
            if(rcnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * BKG, Container 별로 Danger Cargo 정보를 Copy 하여 생성한다.
     * @param CntrCopyVO cntrCopyVO
     */
    public void copyDgCgoByCntr(CntrCopyVO cntrCopyVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = cntrCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAODgCgoByCntrCSQL template = new SpecialCargoReceiptDBDAODgCgoByCntrCSQL();
            int rcnt = sqlExe.executeUpdate(template, param,velParam);
            if(rcnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * BKG, Container 별로 Reefer Cargo 정보를 Copy 하여 생성한다.
     * @param CntrCopyVO cntrCopyVO
     */
    public void copyRfCgoByCntr(CntrCopyVO cntrCopyVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = cntrCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAORfCgoByCntrCSQL template = new SpecialCargoReceiptDBDAORfCgoByCntrCSQL();
            int rcnt = sqlExe.executeUpdate(template, param,velParam);
            if(rcnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * BKG, Container 별로 Awkward Cargo 정보를 삭제한다.
     * @param String bkgNo
     * @param String cntrNo
     * @param String seq
     */
    public void removeAwkCgoByCntr(String bkgNo, String cntrNo, String seq) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);            
            mapVO.put("dg_seq", seq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOAkCgoByCntrDSQL template = new SpecialCargoReceiptDBDAOAkCgoByCntrDSQL();
            int rcnt = sqlExe.executeUpdate(template, param,velParam);
            if(rcnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }        
    }

    /**
     * BKG, Container 별로 Awkward Cargo Detail 정보를 삭제한다.
     * @param String bkgNo
     * @param String cntrNo
     * @param String seq
     */
    public void removeAwkDimByCntr(String bkgNo, String cntrNo, String seq) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);            
            mapVO.put("dg_seq", seq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOAkDimByCntrDSQL template = new SpecialCargoReceiptDBDAOAkDimByCntrDSQL();
            int rcnt = sqlExe.executeUpdate(template, param,velParam);
            if(rcnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * BKG, Container 별로 Danger Cargo 정보를 삭제한다.
     * @param String bkgNo
     * @param String cntrNo
     * @param String seq
     */
    public void removeDgCgoByCntr(String bkgNo, String cntrNo, String seq) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);            
            mapVO.put("dg_seq", seq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAODgCgoByCntrDSQL template = new SpecialCargoReceiptDBDAODgCgoByCntrDSQL();
            int rcnt = sqlExe.executeUpdate(template, param,velParam);
            if(rcnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Container 별로 Reefer Application 을 삭제한다.
     * 
     * @param String bkgNo
     * @param String cntrNo
     * @param String seq
     */
    public void removeRfCgoByCntr(String bkgNo, String cntrNo, String seq) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            // set parameters
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("bkg_no", bkgNo);
            mapVO.put("cntr_no", cntrNo);            
            mapVO.put("rc_seq", seq);

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAORfCgoByCntrDSQL template = new SpecialCargoReceiptDBDAORfCgoByCntrDSQL();
            int rcnt = sqlExe.executeUpdate(template, param,velParam);
            if(rcnt == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        }catch(SQLException ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        } 
    }
    
	/**
	 * copyTypeCd에 따라, BKG_DG_CGO/BKG_DG_CGO_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeDgCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAORemoveDgCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd에 따라, BKG_RF_CGO/BKG_RF_CGO_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeRfCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAORemoveRfCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd에 따라, BKG_AWK_DIM/BKG_AWK_DIM_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeAkDimCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAORemoveAkDimCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd에 따라, BKG_AWK_CGO/BKG_AWK_CGO_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeAkCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAORemoveAkCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd에 따라, BKG_BB_CGO/BKG_BB_CGO_HIS 를 delete함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void removeBbCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAORemoveBbCADSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_DG_CGO/BKG_DG_CGO_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createDgCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOCreateDgCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_RF_CGO/BKG_RF_CGO_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createRfCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOCreateRfCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_AWK_DIM/BKG_AWK_DIM_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createAkDimCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOCreateAkDimCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_AWK_CGO/BKG_AWK_CGO_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createAkCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOCreateAkCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * copyTypeCd 에 따라, BKG_BB_CGO/BKG_BB_CGO_HIS 에 copy함
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO vo
	 * @param  String copyTypeCd
	 * @exception DAOException
	 */
	public void createBbCA(BkgBlNoVO vo, String copyTypeCd) throws DAOException {
		Map<String, Object> param    = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				param.put   ("copy_type_cd", copyTypeCd);
				velParam.putAll(mapVO);
				velParam.put("copy_type_cd", copyTypeCd);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOCreateBbCACSQL(), param, velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 해당 dg정보의 cntr volumn을 cntr기준으로 update한다.
	 * @author 		RYU DAE YOUNG
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @param       SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyBkgDgCgoVol(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);	
			param.put("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOModifyBkgDgCgoVolUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 해당 rf정보의 cntr volumn을 cntr기준으로 update한다.
	 * @author 		RYU DAE YOUNG
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @param       SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyBkgRfCgoVol(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);	
			param.put("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOModifyBkgRfCgoVolUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 해당 awk정보의 cntr volumn을 cntr기준으로 update한다.
	 * @author 		RYU DAE YOUNG
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @param       SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyBkgAwkCgoVol(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);	
			param.put("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOModifyBkgAwkCgoVolUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
	/**
	 * Awk의 RD Term을 수정한다.
	 * 
	 * @author 		KimByungKyu
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @param  		String rcvTermCd
	 * @param  		String deTermCd
	 * @param       	SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyAwkRDTerm(BkgBlNoVO bkgBlNoVO, String rcvTermCd , String deTermCd , SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);	
			param.put("upd_usr_id", account.getUsr_id());
			param.put("rcv_term_cd", rcvTermCd);
			param.put("de_term_cd", deTermCd);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOModifyAwkRDTermUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	/**
	 * BB의 RD Term을 수정한다.
	 * 
	 * @author 		KimByungKyu
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @param  		String rcvTermCd
	 * @param  		String deTermCd
	 * @param       	SignOnUserAccount account
	 * @exception 	DAOException
	 */
	public void modifyBbRDTerm(BkgBlNoVO bkgBlNoVO, String rcvTermCd , String deTermCd , SignOnUserAccount account)throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);	
			param.put("upd_usr_id", account.getUsr_id());
			param.put("rcv_term_cd", rcvTermCd);
			param.put("de_term_cd", deTermCd);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoReceiptDBDAOModifyBbRDTermUSQL(), param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * eBkg에서 awkward cargo 정보를 수정한다.<br>
	 *
	 * @param List<BkgAwkCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyBkgAwkCgoByXter(List<BkgAwkCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);   
				SpecialCargoReceiptDBDAOEBookingBkgAwkCgoUSQL template = new SpecialCargoReceiptDBDAOEBookingBkgAwkCgoUSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
	              
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * eBkg에서 B/Bulk cargo 정보를 수정한다.<br>
	 *
	 * @param List<BkgBbCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */ 
	public void modifyBkgBbCgoByXter(List<BkgBbCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){
				velParam.put("ca_flg", caFlg);   
				SpecialCargoReceiptDBDAOEBookingBkgBbCgoUSQL template = new SpecialCargoReceiptDBDAOEBookingBkgBbCgoUSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
	              
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * eBkg에서 awkward cargo 정보를 생성한다.<br>
	 *
	 * @param List<BkgAwkCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void addBkgAwkCgoByXter(List<BkgAwkCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){	        	  	        	  
				velParam.put("ca_flg", caFlg); 				
				SpecialCargoReceiptDBDAOEBookingBkgAwkCgoCSQL template = new SpecialCargoReceiptDBDAOEBookingBkgAwkCgoCSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
          
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}	
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * eBkg에서 B.Bulk cargo 정보를 생성한다.<br>
	 *
	 * @param List<BkgBbCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void addBkgBbCgoByXter(List<BkgBbCgoVO> insModels, String caFlg) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(insModels.size() > 0){	        	  	        	  
				velParam.put("ca_flg", caFlg); 				
				SpecialCargoReceiptDBDAOEBookingBkgBbCgoCSQL template = new SpecialCargoReceiptDBDAOEBookingBkgBbCgoCSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
          
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}	
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	/**
	 * eBkg에서 danger cargo 정보를 생성한다.<br>
	 *
	 * @param List<DgCgoListVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void addDgCgoListByXter(List<DgCgoListVO> insModels, String caFlg) throws DAOException {
		try {
		    SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			  
			if(insModels.size() > 0){				  
				velParam.put("ca_flg", caFlg);
				SpecialCargoReceiptDBDAOEBookingBkgDgCgoCSQL template = new SpecialCargoReceiptDBDAOEBookingBkgDgCgoCSQL();
				insCnt = sqlExe.executeBatch(template, insModels, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

	/**
	 * eBkg에서 danger cargo 정보를 수정한다.<br>
	 *
	 * @param List<DgCgoListVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyDgCgoListByXter(List<DgCgoListVO> insModels, String caFlg) throws DAOException {
	    try {
	    	SQLExecuter sqlExe = new SQLExecuter("");
	    	int insCnt[] = null;
	    	Map<String, Object> velParam = new HashMap<String, Object>();
	          
	    	if(insModels.size() > 0){	        	  
	    		velParam.put("ca_flg", caFlg);
	    		SpecialCargoReceiptDBDAOEBookingBkgDgCgoUSQL template = new SpecialCargoReceiptDBDAOEBookingBkgDgCgoUSQL();
	    		insCnt = sqlExe.executeBatch(template, insModels, velParam);
	    		for(int i = 0; i < insCnt.length; i++){
	    			if(insCnt[i]== Statement.EXECUTE_FAILED)
	    				throw new DAOException("Fail to insert No"+ i + " SQL");
	            }
	    	}
	    } catch (SQLException se) {
	    	log.error(se.getMessage(),se);
	    	throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	    	log.error(ex.getMessage(),ex);
	    	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	}

	/**
	 * eBkg에서 reefer cargo 정보를 생성한다.<br>
	 *
	 * @param List<BkgRfCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void addBkgRfCgoByXter(List<BkgRfCgoVO> insModels, String caFlg) throws DAOException {
	    try {
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int insCnt[] = null;
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        if(insModels.size() > 0){
	        	velParam.put("ca_flg", caFlg);	        	  
	        	SpecialCargoReceiptDBDAOEBookingBkgRfCgoCSQL template = new SpecialCargoReceiptDBDAOEBookingBkgRfCgoCSQL();
	            insCnt = sqlExe.executeBatch(template, insModels, velParam);
	              
	            for(int i = 0; i < insCnt.length; i++){
	                if(insCnt[i]== Statement.EXECUTE_FAILED)
	                    throw new DAOException("Fail to insert No"+ i + " SQL");
	            }
	        }
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	}

	/**
	 *  eBkg에서 reefer cargo 정보를 수정한다.<br>
	 *
	 * @param List<BkgRfCgoVO> insModels
	 * @param String caFlg
	 * @throws DAOException
	 */
	public void modifyBkgRfCgoByXter(List<BkgRfCgoVO> insModels, String caFlg) throws DAOException {
	    try {
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int insCnt[] = null;
	        Map<String, Object> velParam = new HashMap<String, Object>();
	        if(insModels.size() > 0){
	        	velParam.put("ca_flg", caFlg);			        	  
        		SpecialCargoReceiptDBDAOEBookingBkgRfCgoUSQL template = new SpecialCargoReceiptDBDAOEBookingBkgRfCgoUSQL();
        		insCnt = sqlExe.executeBatch(template, insModels, velParam);
        		  
	            for(int i = 0; i < insCnt.length; i++){
	                if(insCnt[i]== Statement.EXECUTE_FAILED)
	                    throw new DAOException("Fail to insert No"+ i + " SQL");
	            }
	        }
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	}
	
	/**
	 * VVD 변경시 prechecking 때문에 special request를 하게될 경우 Danger Cargo 정보를 수정한다.
	 * 
	 * @author 		Ryu DaeYoung
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @param  		String spclRqstDesc
	 * @param		String dcgoSeq
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyDgSpclRqstByVvdChange(BkgBlNoVO bkgBlNoVO, String spclRqstDesc, String dcgoSeq, SignOnUserAccount account) throws DAOException{
	    try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);
			param.put("spcl_rqst_desc", spclRqstDesc);
			param.put("dcgo_seq", dcgoSeq);
			param.put("usr_id", account.getUsr_id());
			
			velParam.putAll(mapVO);
			velParam.put("spcl_rqst_desc", spclRqstDesc);
			velParam.put("dcgo_seq", dcgoSeq);
			velParam.put("usr_id", account.getUsr_id());
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SpecialCargoReceiptDBDAOModifyDgSpclRqstByVvdChangeUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }		
	}
		
	/**
	 *  Temperature 수정<br>
	 *
	 * @param List<BkgRfCgoVO> updModels
	 * @throws DAOException
	 */
	public void modifyPsaCntrTemp(List<BkgRfCgoVO> updModels) throws DAOException {
	    try {
	        SQLExecuter sqlExe = new SQLExecuter("");
	        int insCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			
	        if(updModels.size() > 0){	        	
	        	SpecialCargoReceiptDBDAOModifyPsaCntrTempUSQL template = new SpecialCargoReceiptDBDAOModifyPsaCntrTempUSQL();
        		insCnt = sqlExe.executeBatch(template, updModels, velParam);
        		  
	            for(int i = 0; i < insCnt.length; i++){
	                if(insCnt[i]== Statement.EXECUTE_FAILED)
	                    throw new DAOException("Fail to insert No"+ i + " SQL");
	            }
	        }
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }
	}
		
	/**
	 * 유사한 화학적 특성을 갖는 위험물 격리군(Segregation Groups) 조회.<br>
	 * 
	 * @return List<SegrGrpVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public List<SegrGrpVO> searchSegrGrp() throws DAOException {
        DBRowSet dbRowset = null;
        List<SegrGrpVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = new HashMap<String, String>();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOSearchSegrGrpRSQL template = new SpecialCargoReceiptDBDAOSearchSegrGrpRSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, SegrGrpVO.class);
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
	
	/**
	 * IMDG UN NUMBER의 SPECIAL PROVISION No 조회.<br>
	 * 
	 * @param unNo
	 * @param unNoSeq
	 * @return String
	 * @throws DAOException
	 */
    public String searchSpclProviNo(String unNo, String unNoSeq) throws DAOException {
        DBRowSet dbRowset = null;
        String strResult = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {            
            if( unNo != null && unNoSeq != null ){
				param.put("imdg_un_no", unNo);
				param.put("imdg_un_no_seq", unNoSeq);
			}

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpecialCargoReceiptDBDAOSearchSpclProviNoRSQL template = new SpecialCargoReceiptDBDAOSearchSpclProviNoRSQL();

            dbRowset = sqlExe.executeQuery(template, param, velParam);
            if(dbRowset.next()) {
	    		strResult = dbRowset.getString("SPCL_PROVI_NO");
	    	}            
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return strResult;
    }
	
	/**
	 * SpecialCargo에 대한 Reject Mail 전송 처리<br>
	 * 
	 * @param String bkgNo
	 * @param String spclCgoTp
	 * @return SpecialCargoRjEmlVO emlVo
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public SpecialCargoRjEmlVO sendSpRejectMail(String bkgNo, String spclCgoTp) throws DAOException {
		DBRowSet dbRowset = null;
        List<SpecialCargoRjEmlVO> list = null;
		SpecialCargoRjEmlVO emlVo = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if( bkgNo != null ){
				param.put("bkg_no", bkgNo);
			}
			if( spclCgoTp != null ){
				velParam.put("spcl_cgo_tp", spclCgoTp);
			}						
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			SpecialCargoReceiptDBDAOSearchBkgRjEmlRSQL template = new SpecialCargoReceiptDBDAOSearchBkgRjEmlRSQL();
	        dbRowset = sqlExe.executeQuery(template, param, velParam);

	        list = (List) RowSetUtil.rowSetToVOs(dbRowset, SpecialCargoRjEmlVO.class);
	        emlVo = list.get(0);
	        emlVo.setBkgNo(bkgNo);	        
		} catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return emlVo;
	}
	
	/**
	 * SpecialCargo에 대한 Rject 갯수 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String spclCgoTp
	 * @return int 
	 * @exception EventException
	 */
	public int searchSpRejectCnt(String bkgNo, String spclCgoTp) throws DAOException {
		DBRowSet dbRowset = null;
        int rjCnt = 0;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if( bkgNo != null ){
				param.put("bkg_no", bkgNo);
			}
			if( spclCgoTp != null ){
				velParam.put("spcl_cgo_tp", spclCgoTp);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoReceiptDBDAOSearchSpRejectCntRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		rjCnt = dbRowset.getInt(1);
	    	}
		} catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rjCnt;
	}

	/**
	 * DG CARGO의 UN No에 해당하는 Stowage Code를 조회한다 <br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchImdgUnNoStwgCateCd(BkgBlNoVO bkgBlNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String result = "";
		try {			
			Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoReceiptDBDAOSearchImdgUnNoStwgCateCdRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		result = dbRowset.getString("IMDG_STWG_CATE_CD");
	    	}
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }		
	    return result;
	}

	/**
	 * Booking에 해당하는 CLL VVD를 조회한다<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchCLLVVD(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String result = "";
		try {			
			if( bkgNo != null ){
				param.put("bkg_no", bkgNo);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoReceiptDBDAOSearchCllVvdRSQL(), param, velParam);
            if(dbRowset.next()) {
            	result = dbRowset.getString("cll_vvd");
	    	}     
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }		
	    return result;
	}
	
	/**
	 * UN No에 해당되는 SUB Label이 설정되지 않거나, 맞지 않은 값이 설정되었는지 여부를 체크한다.
	 * @param bkgNo
	 * @return String Error Message
	 * @throws DAOException
	 */
	public String validateDGSubLabelByUNNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String result = "";
		try {			
			if( bkgNo != null ){
				param.put("bkg_no", bkgNo);
			}			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoReceiptDBDAOValidateDGSubLabelByUNNoRSQL(), param, velParam);
            if(dbRowset.next()) {
            	result = dbRowset.getString("w_msg");
	    	}     
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage(), se);
	    }catch(Exception ex){
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	    }		
	    return result;
	} 
}
