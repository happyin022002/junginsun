/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RepairMgtDBDAOmodifyEstimateHDRSumDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOmodifyEstimateHDRSumDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyEstimateHDRSumData
	  * </pre>
	  */
	public RepairMgtDBDAOmodifyEstimateHDRSumDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOmodifyEstimateHDRSumDataUSQL").append("\n"); 
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
		query.append("UPDATE   MNR_RPR_RQST_HDR A" ).append("\n"); 
		query.append("SET      ( A.MNR_AGMT_AMT, A.MNR_WRK_AMT, A.N3PTY_BIL_TTL_AMT ) =" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   SUM(NVL(B.MNR_LBR_BZC_AMT,0) + NVL(B.LBR_MTRL_BZC_AMT,0))" ).append("\n"); 
		query.append("                  , SUM(NVL(B.LBR_COST_AMT,0) + NVL(B.MTRL_COST_AMT,0))" ).append("\n"); 
		query.append("                  , SUM(NVL(B.N3PTY_BIL_LBR_COST_AMT,0) + NVL(B.N3PTY_BIL_MTRL_COST_AMT,0))" ).append("\n"); 
		query.append("           FROM     MNR_RPR_RQST_DTL B" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      A.RQST_EQ_NO = B.RQST_EQ_NO" ).append("\n"); 
		query.append("           AND      A.RPR_RQST_SEQ = B.RPR_RQST_SEQ" ).append("\n"); 
		query.append("           AND      A.RPR_RQST_VER_NO = B.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("           GROUP BY B.RQST_EQ_NO" ).append("\n"); 
		query.append("                  , B.RPR_RQST_SEQ" ).append("\n"); 
		query.append("                  , B.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      A.RQST_EQ_NO = @[rqst_eq_no]      " ).append("\n"); 
		query.append("AND      A.RPR_RQST_SEQ = @[rpr_rqst_seq]" ).append("\n"); 
		query.append("AND      A.RPR_RQST_VER_NO = @[rpr_rqst_ver_no]" ).append("\n"); 
		query.append("AND      EXISTS" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   'X'" ).append("\n"); 
		query.append("           FROM     MNR_RPR_RQST_DTL B" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      A.RQST_EQ_NO = B.RQST_EQ_NO" ).append("\n"); 
		query.append("           AND      A.RPR_RQST_SEQ = B.RPR_RQST_SEQ" ).append("\n"); 
		query.append("           AND      A.RPR_RQST_VER_NO = B.RPR_RQST_VER_NO   " ).append("\n"); 
		query.append("           GROUP BY B.RQST_EQ_NO" ).append("\n"); 
		query.append("                  , B.RPR_RQST_SEQ" ).append("\n"); 
		query.append("                  , B.RPR_RQST_VER_NO  " ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}