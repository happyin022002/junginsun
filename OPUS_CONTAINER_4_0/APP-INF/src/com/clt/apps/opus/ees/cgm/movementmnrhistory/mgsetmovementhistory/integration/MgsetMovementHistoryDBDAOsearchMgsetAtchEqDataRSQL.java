/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MgsetMovementHistoryDBDAOsearchMgsetAtchEqDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MgsetMovementHistoryDBDAOsearchMgsetAtchEqDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MgsetMovementHistoryDBDAOsearchMgsetAtchEqDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration").append("\n"); 
		query.append("FileName : MgsetMovementHistoryDBDAOsearchMgsetAtchEqDataRSQL").append("\n"); 
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
		query.append("#if(${eq_tpsz_cd} == 'CLG')" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(A XPKCGM_EQ_ATCH_DTCH_HIS ) */" ).append("\n"); 
		query.append("       A.CNTR_NO," ).append("\n"); 
		query.append("       TO_CHAR(A.ATCH_DT, 'YYYYMMDDHH24MISS') AS ATCH_DT," ).append("\n"); 
		query.append("       A.DTCH_YD_CD" ).append("\n"); 
		query.append("  FROM CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append(" WHERE A.EQ_NO = @[mgst_no]" ).append("\n"); 
		query.append("   AND A.ATCH_DT <= TO_DATE(@[mvmt_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("#elseif(${eq_tpsz_cd} == 'UMG')" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(A XPKCGM_EQ_ATCH_DTCH_HIS ) */" ).append("\n"); 
		query.append("       A.CHSS_NO," ).append("\n"); 
		query.append("       TO_CHAR(A.ATCH_DT, 'YYYYMMDDHH24MISS') AS ATCH_DT," ).append("\n"); 
		query.append("       A.DTCH_YD_CD" ).append("\n"); 
		query.append("  FROM CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append(" WHERE A.EQ_NO = @[mgst_no]" ).append("\n"); 
		query.append("   AND A.ATCH_DT <= TO_DATE(@[mvmt_dt], 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}