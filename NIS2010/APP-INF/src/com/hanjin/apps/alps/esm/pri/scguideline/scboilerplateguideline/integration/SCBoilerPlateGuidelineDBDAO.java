/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateGuidelineDAO.java
*@FileTitle : Boiler Plate Guideline
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.27 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.basic.SCBoilerPlateGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo.PriSgBlplExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scboilerplateguideline.vo.RsltPriSgBlplHdrCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSgBlplCtntVO;
import com.hanjin.syscommon.common.table.PriSgBlplHdrVO;
import com.hanjin.syscommon.common.table.PriSgBlplVO;


/**
 * NIS2010 SCBoilerPlateGuidelineDAO <br>
 * - NIS2010-SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Seung Jun Lee
 * @see SCBoilerPlateGuidelineBCImpl 참조
 * @since J2EE 1.4
 */
public class SCBoilerPlateGuidelineDBDAO extends DBDAOSupport {

    /**
     * 보일러 헤더 시퀀스 맥스값을 조회한다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlpHdrlVO
     * @return int
     * @exception DAOException
     */
    public int searchBoilerPlateHdrMaxSeq(PriSgBlplHdrVO priSgBlpHdrlVO) throws DAOException {
        int note_hdr_seq = -1;
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlpHdrlVO != null){
                Map<String, String> mapVO = priSgBlpHdrlVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOSearchPriSgBlplHdrMaxSeqRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
                note_hdr_seq = dbRowset.getInt("blpl_hdr_seq");
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return note_hdr_seq;
    }



    /**
     * 보일러 헤더별 타이틀 시퀀스 맥스값을 조회한다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlpHdrlVO
     * @return int
     * @exception DAOException
     */
    public int searchBoilerPlateMaxSeq(PriSgBlplHdrVO priSgBlpHdrlVO) throws DAOException {
        int note_seq = -1;
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlpHdrlVO != null){
                Map<String, String> mapVO = priSgBlpHdrlVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOSearchPriSgBlplMaxSeqRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
                note_seq = dbRowset.getInt("blpl_seq");
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return note_seq;
    }



    /**
     * 보일러 듀레이션이 겹치는지를 조회한다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlpHdrlVO
     * @return int
     * @exception DAOException
     */
    public int searchCheckBoilerPlateHdrCheckDate(PriSgBlplHdrVO priSgBlpHdrlVO) throws DAOException {
        int chk = 0;
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlpHdrlVO != null){
                Map<String, String> mapVO = priSgBlpHdrlVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOCheckPriSgBlplHdrDateRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
                chk = dbRowset.getInt("chk");
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return chk;
    }


    /**
     * 보일러 year가 겹치는지를 조회한다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlpHdrlVO
     * @return int
     * @exception DAOException
     */
    public int searchCheckBoilerPlateHdrCheckYear(PriSgBlplHdrVO priSgBlpHdrlVO) throws DAOException {
        int chk = 0;
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlpHdrlVO != null){
                Map<String, String> mapVO = priSgBlpHdrlVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOCheckPriSgBlplHdrYearRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
                chk = dbRowset.getInt("chk");
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return chk;
    }



    /**
     * 보일러 타이틀 항목을 조회한다<br>
     *
     * @param PriSgBlplVO priSgBlplVO
     * @return List<PriSgBlplVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<PriSgBlplVO> searchBoilerPlateList(PriSgBlplVO priSgBlplVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriSgBlplVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlplVO != null){
                Map<String, String> mapVO = priSgBlplVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgBlplVO .class);
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
     * 보일러 본문 항목을 조회한다<br>
     *
     * @param PriSgBlplVO priSgBlplVO
     * @return List<PriSgBlplCtntVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<PriSgBlplCtntVO> searchBoilerPlateContentList(PriSgBlplVO priSgBlplVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriSgBlplCtntVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlplVO != null){
                Map<String, String> mapVO = priSgBlplVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgBlplCtntVO .class);
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
     * 보일러 헤더 항목을 조회한다<br>
     *
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return List<PriSgBlplHdrVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<PriSgBlplHdrVO> searchBoilerPlateHeader(PriSgBlplHdrVO priSgBlplHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriSgBlplHdrVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlplHdrVO != null){
                Map<String, String> mapVO = priSgBlplHdrVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgBlplHdrVO .class);
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
     * 보일러 헤더 항목을 조회한다<br>
     *
     * @param PriSgBlplVO priSgBlplVO
     * @return List<PriSgBlplHdrVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PriSgBlplHdrVO> searchBoilerPlateHeader(PriSgBlplVO priSgBlplVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriSgBlplHdrVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlplVO != null){
                Map<String, String> mapVO = priSgBlplVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgBlplHdrVO .class);
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
     * 단건의 Boiler Plate 데이터를 생성한다.<br>
     *
     * @param PriSgBlplVO priSgBlplVO
     * @exception DAOException
     */
    public void addBoilerPlate(PriSgBlplVO priSgBlplVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSgBlplVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplVOCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 단건의 Boiler Plate 데이터를 갱신한다.<br>
     *
     * @param PriSgBlplVO priSgBlplVO
     * @return int
     * @exception DAOException
     */
    public int modifyBoilerPlate(PriSgBlplVO priSgBlplVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = priSgBlplVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplVOUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
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
     * 헤더별 전체 Boiler Plate 데이터를 삭제한다.<br>
     *
     * @param PriSgBlplVO priSgBlplVO
     * @return int
     * @exception DAOException
     */
    public int removeBoilerPlate(PriSgBlplVO priSgBlplVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = priSgBlplVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplVODSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
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
     * 다건의 Boiler Plate 데이터를 일괄적으로 생성한다.<br>
     *
     * @param List<PriSgBlplVO> insModels
     * @exception DAOException
     */
    public void addBoilerPlate(List<PriSgBlplVO> insModels) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplVOCSQL(), insModels,null);
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
     * 다건의 Boiler Plate 데이터를 일괄적으로 갱신한다.<br>
     *
     * @param List<PriSgBlplVO> updModels
     * @exception DAOException
     */
    public void modifyBoilerPlate(List<PriSgBlplVO> updModels) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(updModels.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplVOUSQL(), updModels,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
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
     * 다건의 Boiler Plate 데이터를 일괄적으로 삭제한다.<br>
     *
     * @param List<PriSgBlplVO> delModels
     * @exception DAOException
     */
    public void removeBoilerPlate(List<PriSgBlplVO> delModels) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if(delModels.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplVO2DSQL(), delModels,null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
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
     * 단건의 Boiler Plate 데이터를 생성한다.<br>
     *
     * @param PriSgBlplCtntVO priSgBlplCtntVO
     * @exception DAOException
     */
    public void addBoilerPlateContent(PriSgBlplCtntVO priSgBlplCtntVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSgBlplCtntVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVOCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 단건의 Boiler Plate 데이터를 갱신한다.<br>
     *
     * @param PriSgBlplCtntVO priSgBlplCtntVO
     * @return int
     * @exception DAOException
     */
    public int modifyBoilerPlateContent(PriSgBlplCtntVO priSgBlplCtntVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = priSgBlplCtntVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVOUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
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
     * 단건의 Boiler Plate 데이터를 삭제한다.<br>
     *
     * @param PriSgBlplCtntVO priSgBlplCtntVO
     * @return int
     * @exception DAOException
     */
    public int removeBoilerPlateContent(PriSgBlplCtntVO priSgBlplCtntVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = priSgBlplCtntVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVODSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
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
     * 다건의 Boiler Plate 데이터를 일괄적으로 생성한다.<br>
     *
     * @param List<PriSgBlplCtntVO> insModels
     * @exception DAOException
     */
    public void addBoilerPlateContent(List<PriSgBlplCtntVO> insModels) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVOCSQL(), insModels,null);
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
     * 다건의 Boiler Plate 데이터를 일괄적으로 갱신한다.<br>
     *
     * @param List<PriSgBlplCtntVO> updModels
     * @exception DAOException
     */
    public void modifyBoilerPlateContent(List<PriSgBlplCtntVO> updModels) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(updModels.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVOUSQL(), updModels,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
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
     * 다건의 Boiler Plate 데이터를 일괄적으로 삭제한다.<br>
     *
     * @param List<PriSgBlplCtntVO> delModels
     * @exception DAOException
     */
    public void removeBoilerPlateContent(List<PriSgBlplCtntVO> delModels) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if(delModels.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVO2DSQL(), delModels,null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
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
     * 단건의 Boiler Plate 데이터를 생성한다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @exception DAOException
     */
    public void addBoilerPlateHeader(PriSgBlplHdrVO priSgBlplHdrVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSgBlplHdrVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrVOCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 단건의 Boiler Plate 데이터를 갱신한다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return int
     * @exception DAOException
     */
    public int modifyBoilerPlateHeader(PriSgBlplHdrVO priSgBlplHdrVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = priSgBlplHdrVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrVOUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
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
     * 단건의 Boiler Plate 데이터를 삭제한다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return int
     * @exception DAOException
     */
    public int removeBoilerPlateHeader(PriSgBlplHdrVO priSgBlplHdrVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = priSgBlplHdrVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrVODSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
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
     * 다건의 Boiler Plate 데이터를 일괄적으로 생성한다.<br>
     *
     * @param List<PriSgBlplHdrVO> insModels
     * @exception DAOException
     */
    public void addBoilerPlateHeader(List<PriSgBlplHdrVO> insModels) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrVOCSQL(), insModels,null);
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
     * 다건의 Boiler Plate 데이터를 일괄적으로 갱신한다.<br>
     *
     * @param List<PriSgBlplHdrVO> updModels
     * @exception DAOException
     */
    public void modifyBoilerPlateHeader(List<PriSgBlplHdrVO> updModels) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(updModels.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrVOUSQL(), updModels,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
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
     * 다건의 Boiler Plate 데이터를 일괄적으로 삭제한다.<br>
     *
     * @param List<PriSgBlplHdrVO> delModels
     * @exception DAOException
     */
    public void removeBoilerPlateHeader(List<PriSgBlplHdrVO> delModels) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if(delModels.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrVODSQL(), delModels,null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
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
     * 헤더별 타이틀을 조회하여 신규로 입력한다.<br>
     *
     * @param RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO
     * @exception DAOException
     */
    public void addCopyBoilerPlate(RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltPriSgBlplHdrCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOCopyPriSgBlplCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * 헤더별 타이틀별로 조회하여 신규로 입력한다.<br>
     *
     * @param RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO
     * @exception DAOException
     */
    public void addCopyBoilerPlateContent(RsltPriSgBlplHdrCopyVO rsltPriSgBlplHdrCopyVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = rsltPriSgBlplHdrCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOCopyPriSgBlplCtntCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * 단건의 Boiler Plate 데이터를 갱신한다.(컨폼)<br>
     *
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return int
     * @exception DAOException
     */
    public int modifyConfirmBoilerPlate(PriSgBlplHdrVO priSgBlplHdrVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = priSgBlplHdrVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrConfirmUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
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
     * 헤더 별 타이틀의 Boiler Plate 데이터를 삭제한다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return int
     * @exception DAOException
     */
    public int removeBoilerPlate(PriSgBlplHdrVO priSgBlplHdrVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = priSgBlplHdrVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplVODSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
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
     * 헤더 별 본문의 Boiler Plate 데이터를 삭제한다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return int
     * @exception DAOException
     */
    public int removeBoilerPlateContent(PriSgBlplHdrVO priSgBlplHdrVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = priSgBlplHdrVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVODSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
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
     * 헤더 별 본문별 디테일의 Boiler Plate 데이터를 삭제한다.<br>
     *
     * @param PriSgBlplVO priSgBlplVO
     * @return int
     * @exception DAOException
     */
    public int removeBoilerPlateContent(PriSgBlplVO priSgBlplVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = priSgBlplVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplCtntVODSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
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
     *  Boiler Plate Guideline Header를 조회합니다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return List<PriSgBlplHdrVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<PriSgBlplHdrVO> searchBoilerPlateHeaderInquiry(PriSgBlplHdrVO priSgBlplHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriSgBlplHdrVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlplHdrVO != null){
                Map<String, String> mapVO = priSgBlplHdrVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrInqVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgBlplHdrVO .class);
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
     *  Boiler Plate Guideline Header를 조회합니다.<br>
     *
     * @param PriSgBlplVO priSgBlplVO
     * @return List<PriSgBlplHdrVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<PriSgBlplHdrVO> searchBoilerPlateHeaderInquiry(PriSgBlplVO priSgBlplVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriSgBlplHdrVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlplVO != null){
                Map<String, String> mapVO = priSgBlplVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrInqVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgBlplHdrVO .class);
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
     * 보일러 타이틀 항목을 조회한다<br>
     *
     * @param PriSgBlplVO priSgBlplVO
     * @return List<PriSgBlplVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<PriSgBlplVO> searchBoilerPlateInquiryList(PriSgBlplVO priSgBlplVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriSgBlplVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlplVO != null){
                Map<String, String> mapVO = priSgBlplVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplInqVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgBlplVO .class);
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
     * Boiler Plate의 Content List를 조회합니다..<br>
     *
     * @param PriSgBlplVO priSgBlplVO
     * @return List<PriSgBlplCtntVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<PriSgBlplCtntVO> searchBoilerPlateContentInquiryList(PriSgBlplVO priSgBlplVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriSgBlplCtntVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlplVO != null){
                Map<String, String> mapVO = priSgBlplVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplCtntInqVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgBlplCtntVO .class);
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
     * Boiler Plate Header Year를 조회합니다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return List<PriSgBlplHdrVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<PriSgBlplHdrVO> searchBoilerPlateGuidelineInquiryYear(PriSgBlplHdrVO priSgBlplHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriSgBlplHdrVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlplHdrVO != null){
                Map<String, String> mapVO = priSgBlplHdrVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrInqYearRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgBlplHdrVO .class);
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
     * Boiler Plate Header Duration을 조회합니다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return List<PriSgBlplHdrVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PriSgBlplHdrVO> searchBoilerPlateGuidelineInquiryDuration(PriSgBlplHdrVO priSgBlplHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriSgBlplHdrVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlplHdrVO != null){
                Map<String, String> mapVO = priSgBlplHdrVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplHdrInqDurVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgBlplHdrVO .class);
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
     * Excel 로 저장할 Boiler Plate 정보를 조회합니다.<br>
     *
     * @param PriSgBlplHdrVO priSgBlplHdrVO
     * @return List<PriSgBlplExcelVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PriSgBlplExcelVO> searchBoilerPlateGuidelineListExcel(PriSgBlplHdrVO priSgBlplHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<PriSgBlplExcelVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priSgBlplHdrVO != null){
                Map<String, String> mapVO = priSgBlplHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBoilerPlateGuidelineDBDAOPriSgBlplExcelRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgBlplExcelVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
}
