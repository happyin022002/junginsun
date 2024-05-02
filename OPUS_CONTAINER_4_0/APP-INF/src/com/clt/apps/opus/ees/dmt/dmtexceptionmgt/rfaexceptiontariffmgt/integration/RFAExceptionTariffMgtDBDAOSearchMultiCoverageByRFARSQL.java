/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchMultiCoverageByRFARSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchMultiCoverageByRFARSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DAR No. 와 Version No. 에 해당되는 모든 Multi Origin or Destination 정보를 조회하는 쿼리
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchMultiCoverageByRFARSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_rqst_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchMultiCoverageByRFARSQL").append("\n"); 
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
		query.append("RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",	CVRG_CMB_SEQ" ).append("\n"); 
		query.append(",	ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append(",	ORG_DEST_CNT_CD" ).append("\n"); 
		query.append(",	ORG_DEST_RGN_CD" ).append("\n"); 
		query.append(",	ORG_DEST_STE_CD" ).append("\n"); 
		query.append(",	ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT  RFA_EXPT_DAR_NO, RFA_EXPT_MAPG_SEQ, RFA_EXPT_VER_SEQ, RFA_RQST_DTL_SEQ, CVRG_CMB_SEQ," ).append("\n"); 
		query.append("COUNT(CVRG_CMB_SEQ) OVER (PARTITION BY RFA_EXPT_DAR_NO, RFA_EXPT_MAPG_SEQ, RFA_EXPT_VER_SEQ, RFA_RQST_DTL_SEQ) IDX," ).append("\n"); 
		query.append("ORG_DEST_CONTI_CD, ORG_DEST_CNT_CD, ORG_DEST_RGN_CD, ORG_DEST_STE_CD, ORG_DEST_LOC_CD" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_CVRG_CMB" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO = @[rfa_expt_dar_no]" ).append("\n"); 
		query.append("AND RFA_EXPT_VER_SEQ = @[rfa_expt_ver_seq]" ).append("\n"); 
		query.append("#if(${rfa_rqst_dtl_seq} != '')" ).append("\n"); 
		query.append("AND	RFA_RQST_DTL_SEQ = @[rfa_rqst_dtl_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	IDX > 1" ).append("\n"); 

	}
}