/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UnmatchBLDBDAOCreateSurchargeInputRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.06 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCreateSurchargeInputRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * createSurchargeInput
	  * </pre>
	  */
	public UnmatchBLDBDAOCreateSurchargeInputRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration ").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOCreateSurchargeInputRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- RFA" ).append("\n"); 
		query.append("NULL AS OA_ADD_CHG_SEQ" ).append("\n"); 
		query.append(",NULL AS POR_MTCH_FLG" ).append("\n"); 
		query.append(",NULL AS OIH_FLG" ).append("\n"); 
		query.append(",NULL AS DA_ADD_CHG_SEQ" ).append("\n"); 
		query.append(",NULL AS DEL_MTCH_FLG" ).append("\n"); 
		query.append(",NULL AS DIH_FLG" ).append("\n"); 
		query.append(",NULL AS BKG_BQ_SEQ" ).append("\n"); 
		query.append(",NULL AS BKG_BQ_OCCR_SEQ" ).append("\n"); 
		query.append(",NULL AS BKG_NO" ).append("\n"); 
		query.append(",NULL AS OFT_CMB_SEQ" ).append("\n"); 
		query.append(",NULL AS USR_ID" ).append("\n"); 
		query.append(",NULL AS OFRT_SEQ" ).append("\n"); 
		query.append(",NULL AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",NULL AS CTRT_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",NULL AS RCV_TERM_CD" ).append("\n"); 
		query.append(",NULL AS DE_TERM_CD" ).append("\n"); 
		query.append(",NULL AS DRY_CGO_FLG" ).append("\n"); 
		query.append(",NULL AS AWK_CGO_FLG" ).append("\n"); 
		query.append(",NULL AS DCGO_FLG" ).append("\n"); 
		query.append(",NULL AS RC_FLG" ).append("\n"); 
		query.append(",NULL AS BB_CGO_FLG" ).append("\n"); 
		query.append(",NULL AS SOC_FLG" ).append("\n"); 
		query.append(",NULL AS IMDG_CLSS_CD" ).append("\n"); 
		query.append(",NULL AS PRC_GEN_SPCL_RT_TP_CD" ).append("\n"); 
		query.append(",NULL AS PRC_CMDT_HDR_SEQ" ).append("\n"); 
		query.append(",NULL AS PRC_ROUT_SEQ" ).append("\n"); 
		query.append(",NULL AS PRC_RT_SEQ" ).append("\n"); 
		query.append(",NULL AS OP_CNTR_QTY" ).append("\n"); 
		query.append(",NULL AS CHG_CD" ).append("\n"); 
		query.append(",NULL AS CURR_CD" ).append("\n"); 
		query.append(",NULL AS CHG_UT_AMT" ).append("\n"); 
		query.append(",NULL AS RT_CALC_FRT_RT_AMT" ).append("\n"); 
		query.append(",NULL AS OA_CALC_FRT_RT_AMT" ).append("\n"); 
		query.append(",NULL AS DA_CALC_FRT_RT_AMT" ).append("\n"); 
		query.append(",NULL AS RAT_AS_QTY" ).append("\n"); 
		query.append(",NULL AS CHG_AMT" ).append("\n"); 
		query.append(",NULL AS RAT_UT_CD" ).append("\n"); 
		query.append(",NULL AS CGO_CATE_CD" ).append("\n"); 
		query.append(",NULL AS CRE_USR_ID" ).append("\n"); 
		query.append(",NULL AS CRE_DT" ).append("\n"); 
		query.append(",NULL AS UPD_USR_ID" ).append("\n"); 
		query.append(",NULL AS UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- TAA 추가" ).append("\n"); 
		query.append(",NULL AS TRI_PROP_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}