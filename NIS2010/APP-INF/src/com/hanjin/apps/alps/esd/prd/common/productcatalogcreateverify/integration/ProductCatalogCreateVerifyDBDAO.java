/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ProductCatalogCreateVerifyDBDAO.java
 *@FileTitle : DAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-07-07
 *@LastModifier : noh seung bae
 *@LastVersion : 1.0
 * 2009-07-07 noh seung bae
 * 1.0 최초 생성
 * 2012.05.29 정선용 CHM-201217913-01	Pick Up CY for Export Booking 상, Cargo Type 추가에 따른 Logic 변경요청
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.productcatalogcreateverify.integration;

import java.sql.SQLException;
import com.hanjin.apps.alps.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import java.util.HashMap;
import java.util.Map;

/**
 * alps-PRD에 대한 DB 처리를 담당<br>
 * - alps-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author noh seung bae
 * @see ProductCatalogCreateVerifyBCImpl 참조
 * @since J2EE 1.5
 */
public class ProductCatalogCreateVerifyDBDAO extends DBDAOSupport{

	/**
	 * pc 가 하나도 생성 안됐을 경우 원인을 찾는 sql 실행
	 *
	 * @param prdCreateParamVO
	 * @param prdPcCreateVO
	 * @param prdPatternVO
	 * @return 
	 * @throws DAOException
	 */
	public DBRowSet getPcVerify(PrdCreateParamVO prdCreateParamVO, PrdPcCreateVO prdPcCreateVO, PrdPatternVO prdPatternVO) throws DAOException{

		DBRowSet rowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{

			param.put("rcv_t", prdCreateParamVO.getRcvT());
			param.put("por", prdCreateParamVO.getPor());
			param.put("pol", prdCreateParamVO.getPol());
			param.put("pod", prdCreateParamVO.getPod());
			param.put("del", prdCreateParamVO.getDel());
			param.put("por_n", prdCreateParamVO.getPorN());
			param.put("pol1", prdCreateParamVO.getPol1());
			param.put("pol2", prdCreateParamVO.getPol2());
			param.put("pol3", prdCreateParamVO.getPol3());
			param.put("pol4", prdCreateParamVO.getPol4());
			param.put("pod1", prdCreateParamVO.getPod1());
			param.put("pod2", prdCreateParamVO.getPod2());
			param.put("pod3", prdCreateParamVO.getPod3());
			param.put("pod4", prdCreateParamVO.getPod4());
			param.put("del_t", prdCreateParamVO.getDelT());
			param.put("del_n", prdCreateParamVO.getDelN());
			param.put("skd_date", prdPcCreateVO.getSkdDate());
			param.put("skd_type", prdPcCreateVO.getSkdType());
			param.put("vvd", prdCreateParamVO.getTVvd());
			if("".equals(prdCreateParamVO.getVvd1()) &&
					"".equals(prdCreateParamVO.getVvd2()) &&
					"".equals(prdCreateParamVO.getVvd3()) &&
					"".equals(prdCreateParamVO.getVvd4()) &&
					prdCreateParamVO.getTVvd().length()== 9 ) {
				
				param.put("vvd1", prdCreateParamVO.getTVvd());
			} else {
				
				param.put("vvd1", prdCreateParamVO.getVvd1());
			}
			param.put("vvd2", prdCreateParamVO.getVvd2());
			param.put("vvd3", prdCreateParamVO.getVvd3());
			param.put("vvd4", prdCreateParamVO.getVvd4());
			param.put("lane1", prdCreateParamVO.getLane1());
			param.put("lane2", prdCreateParamVO.getLane2());
			param.put("lane3", prdCreateParamVO.getLane3());
			param.put("lane4", prdCreateParamVO.getLane4());
			param.put("cgo_tp", prdCreateParamVO.getCgoTp());
			param.put("so_seq", "0");
			param.put("ob_trsp_mode", prdCreateParamVO.getObTrspMode());
			param.put("ib_trsp_mode", prdCreateParamVO.getIbTrspMode());
			param.put("bkg_no", prdCreateParamVO.getBkgNo());
			param.put("pod_n", prdCreateParamVO.getPodN());
			param.put("m_pu", prdCreateParamVO.getMPu());
			param.put("dg_spcl_flg", prdCreateParamVO.getDgF());  
			param.put("rf_spcl_flg", prdCreateParamVO.getRfF());  
			param.put("spcl_awk_cgo_flg", prdCreateParamVO.getAkF());
			
			if(prdPatternVO != null){
				param.put("ocn_str", prdPatternVO.getOcnItchgCtnt());
//				param.put("pod_n", prdCreateParamVO.getPodN());
				param.put("ib_str", prdPatternVO.getIbItchgCtnt());
				param.put("ob_str", prdPatternVO.getObItchgCtnt());
			}else{
				param.put("ocn_str", "");
//				param.put("pod_n", "");
				param.put("ib_str", "");
				param.put("ob_str", "");
			}
			
			//double calling 관련 seq
			param.put("n1st_pol_dc_seq", prdCreateParamVO.getN1stPolDcSeq());																
			param.put("n1st_pod_dc_seq", prdCreateParamVO.getN1stPodDcSeq());																
			param.put("n2nd_pol_dc_seq", prdCreateParamVO.getN2ndPolDcSeq());																
			param.put("n2nd_pod_dc_seq", prdCreateParamVO.getN2ndPodDcSeq());																
			param.put("n3rd_pol_dc_seq", prdCreateParamVO.getN3rdPolDcSeq());																
			param.put("n3rd_pod_dc_seq", prdCreateParamVO.getN3rdPodDcSeq());																
			param.put("n4th_pol_dc_seq", prdCreateParamVO.getN4thPolDcSeq());																
			param.put("n4th_pod_dc_seq", prdCreateParamVO.getN4thPodDcSeq());	
			param.put("pc_mode", prdCreateParamVO.getPcMode());
			param.put("pol_n", prdCreateParamVO.getPolN());

			rowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ProductCatalogCreateVerifyDBDAOSearchVerifyRSQL(), param, param);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowset;

	}
}
