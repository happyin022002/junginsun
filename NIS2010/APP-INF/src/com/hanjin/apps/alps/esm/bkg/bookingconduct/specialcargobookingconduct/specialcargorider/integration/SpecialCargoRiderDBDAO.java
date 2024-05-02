/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoRiderDBDAO.java
*@FileTitle : B/L Rider
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.16 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.AttachFileInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.AttachFileOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclCntrListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgImgStoVO;


/**
 * ALPS SpecialCargoRiderDBDAO <br>
 * - ALPS-SpecialCargoBookingConduct system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Lee Jin Seo
 * @see SpecialCargoRiderBCImpl 참조
 * @since J2EE 1.6
 */
public class SpecialCargoRiderDBDAO extends DBDAOSupport {







	/**
	 * SpecialCargoRiderDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @author Lee Jin Seo
	 * @param AttachFileInVO attachFileInVO
	 * @return List<BlRiderOutVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AttachFileOutVO> searchAttachFileList(AttachFileInVO attachFileInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AttachFileOutVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(attachFileInVO != null){
				Map<String, String> mapVO = attachFileInVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoRiderDBDAOsearchAttachFileListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AttachFileOutVO .class);
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
	 * SpecialCargoRiderDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @author Lee Jin Seo
	 * @param BlRiderInVO blRiderInVO
	 * @return List<BlRiderOutVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BlRiderOutVO> searchBlRiderList(BlRiderInVO blRiderInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BlRiderOutVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(blRiderInVO != null){
				Map<String, String> mapVO = blRiderInVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoRiderDBDAOsearchBlRiderListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlRiderOutVO .class);
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
	 * SpecialCargoRiderDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @author Lee Jin Seo
	 * @param SpclRiderInVO spclRiderInVO
	 * @return List<SpclRiderOutVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SpclRiderVO> searchSpclRiderList(SpclRiderInVO spclRiderInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpclRiderVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(spclRiderInVO != null){
				Map<String, String> mapVO = spclRiderInVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoRiderDBDAOsearchSpclRiderListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpclRiderVO .class);
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
	 * SpecialCargoRiderDBDAO의 컨테이너 번호에 따른 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @author Lee Jin Seo
	 * @param SpclRiderInVO spclRiderInVO
	 * @return List<SpclCntrListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SpclCntrListVO> searchSpclRiderList1(SpclRiderInVO spclRiderInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpclCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(spclRiderInVO != null){
				Map<String, String> mapVO = spclRiderInVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoRiderDBDAOsearchSpclRiderList1RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SpclCntrListVO .class);
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
	 * Rider Cargo의 BKG_IMG_STO 추가 (BkgImgStoVO) 데이터를 생성한다.<br>
	 * @author Lee Jin Seo
	 * @param List<BkgImgStoVO> listVO 데이터객체
	 * @return int
	 * @throws DAOException
	 */
	public int addBlRider(List<BkgImgStoVO> listVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
        int size = listVO.size();
		int insCnt = 0;

        try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<BkgImgStoVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		BkgImgStoVO bkgImgStoVO = (BkgImgStoVO)list.next();
					Map<String, String> mapVO = bkgImgStoVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoRiderDBDAOmanageBlRiderCSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
	        	}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}

	/**
	 * Rider Cargo의 BKG_IMG_STO 추가 (BkgImgStoVO) 데이터를 갱신한다.<br>
	 * @author Lee Jin Seo
	 * @param List<BkgImgStoVO> listVO 데이터객체
	 * @return int
	 * @throws DAOException
	 */
	public int modifyBlRider(List<BkgImgStoVO> listVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
        int size = listVO.size();
		int insCnt = 0;

        try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<BkgImgStoVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		BkgImgStoVO bkgImgStoVO = (BkgImgStoVO)list.next();
					Map<String, String> mapVO = bkgImgStoVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoRiderDBDAOmanageBlRiderUSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
	        	}
	        }

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}

	/**
	 * Rider Cargo의 BKG_IMG_STO 추가 (BkgImgStoVO) 데이터를 삭제한다.<br>
	 * @author Lee Jin Seo
	 * @param List<BkgImgStoVO> listVO 데이터객체
	 * @return int
	 * @throws DAOException
	 */
	public int removeBlRider(List<BkgImgStoVO> listVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
        int size = listVO.size();
		int insCnt = 0;

        try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<BkgImgStoVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		BkgImgStoVO bkgImgStoVO = (BkgImgStoVO)list.next();
					Map<String, String> mapVO = bkgImgStoVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoRiderDBDAOmanageBlRiderDSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
	        	}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}


	 /**
	 * Special Cargo의 BKG_IMG_STO 추가 (BkgImgStoVO)  데이터를 생성한다.<br>
	 * @author Lee Jin Seo
	 * @param List<BkgImgStoVO> listVO
	 * @return int
	 * @throws DAOException
	 */
	public int addSpclRider(List<BkgImgStoVO> listVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
       int size = listVO.size();
		int insCnt = 0;

       try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<BkgImgStoVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		BkgImgStoVO bkgImgStoVO = (BkgImgStoVO)list.next();
					Map<String, String> mapVO = bkgImgStoVO .getColumnValues();

					String seq = mapVO.get("dcgo_seq");// 총 선택된 값을 가지고 있음
					String[] cargo_seq = seq.split(",");
					int cnt = cargo_seq.length;
					for ( int i=0; i<cnt; i++ ) {
						mapVO.put("dcgo_seq", null);
						if("D".equals(mapVO.get("ridr_tp_cd"))){
							mapVO.put("dcgo_seq", cargo_seq[i]);
						}else if("A".equals(mapVO.get("ridr_tp_cd"))){
							mapVO.put("awk_cgo_seq", cargo_seq[i]);
						}else if("B".equals(mapVO.get("ridr_tp_cd"))){
							mapVO.put("bb_cgo_seq", "0");
						}
						param.putAll(mapVO);
						velParam.putAll(mapVO);
		    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoRiderDBDAOmanageBlRiderCSQL(), param,velParam);
		    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
					}
	        	}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}

	/**
	 * Special Cargo의 BKG_IMG_STO 추가 (BkgImgStoVO) 데이터를 갱신한다.<br>
	 * @author Lee Jin Seo
	 * @param List<BkgImgStoVO> listVO 데이터객체
	 * @return int
	 * @throws DAOException
	 */
	public int modifySpclRider(List<BkgImgStoVO> listVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
       int size = listVO.size();
		int insCnt = 0;

       try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<BkgImgStoVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		BkgImgStoVO bkgImgStoVO = (BkgImgStoVO)list.next();
					Map<String, String> mapVO = bkgImgStoVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoRiderDBDAOmanageBlRiderUSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
	        	}
	        }

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}

	/**
	 * Special Cargo의 BKG_IMG_STO 추가 (BkgImgStoVO) 데이터를 삭제한다.<br>
	 * @author Lee Jin Seo
	 * @param List<BkgImgStoVO> listVO 데이터객체
	 * @return int
	 * @throws DAOException
	 */
	public int removeSpclRider(List<BkgImgStoVO> listVO) throws DAOException,Exception {
       int size = listVO.size();
       int insCnt = 0;
       try {
	        if(size > 0) {
	        	Iterator<BkgImgStoVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		BkgImgStoVO bkgImgStoVO = (BkgImgStoVO)list.next();
	        		removeSpclRider(bkgImgStoVO);
	        	}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	/**
	 * Special Cargo의 BKG_IMG_STO 추가 (BkgImgStoVO) 데이터를 삭제한다.<br>
	 * @param bkgImgStoVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeSpclRider(BkgImgStoVO bkgImgStoVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt = 0;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = bkgImgStoVO.getColumnValues();
			mapVO.put("gubun", "SpclRider");// Special Cargo 구분자
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new SpecialCargoRiderDBDAOmanageBlRiderDSQL(),	param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	/**
     * sourceBkg의 DG rider정보를 targetBkg로 복사한다.(ESM_BKG_0076)
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO targetBkg
     * @param SignOnUserAccount account
     * @exception DAOException
     */
    public void copySpclRiderAfterCombine(BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws DAOException {
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
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoRiderDBDAOCopySpclRiderAfterCombineCSQL(), param,velParam);
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
     * DG rider를 Master booking에서 삭제
     * @param BkgBlNoVO vo
     * @exception DAOException
     */
    public void removeSpclRiderAfterCombine(BkgBlNoVO vo) throws DAOException {
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoRiderDBDAORemoveSpclRiderAfterCombineDSQL(), param,velParam);
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
}