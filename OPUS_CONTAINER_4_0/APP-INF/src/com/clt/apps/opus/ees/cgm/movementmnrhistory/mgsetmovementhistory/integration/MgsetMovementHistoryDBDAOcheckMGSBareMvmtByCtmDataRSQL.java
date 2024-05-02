/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MgsetMovementHistoryDBDAOcheckMGSBareMvmtByCtmDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MgsetMovementHistoryDBDAOcheckMGSBareMvmtByCtmDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MgsetMovementHistoryDBDAOcheckMGSBareMvmtByCtmDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration ").append("\n"); 
		query.append("FileName : MgsetMovementHistoryDBDAOcheckMGSBareMvmtByCtmDataRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(B XPKCGM_MGST_MVMT_HIS ) */" ).append("\n"); 
		query.append("    A.MGST_NO CHSS_NO" ).append("\n"); 
		query.append("  , to_char(A.MVMT_DT,'yyyymmddHH24MIss') MVMT_DT_1" ).append("\n"); 
		query.append("  , to_char(B.MVMT_DT ,'yyyymmddHH24MIss') MVMT_DT_2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	 SELECT * FROM (" ).append("\n"); 
		query.append(" 		  SELECT MGST_NO, MVMT_DT" ).append("\n"); 
		query.append("        	FROM CGM_MGST_MVMT_HIS A" ).append("\n"); 
		query.append("          WHERE A.CNTR_NO =  @[cntr_no]" ).append("\n"); 
		query.append("            AND A.YD_CD IN  (   " ).append("\n"); 
		query.append("                            SELECT Y.YD_CD" ).append("\n"); 
		query.append("                            FROM MDM_EQ_ORZ_CHT B2, MDM_LOCATION A2, MDM_YARD Y" ).append("\n"); 
		query.append("                            WHERE B2.LCC_CD IN ( SELECT LCC_CD FROM MDM_LOCATION A1, MDM_EQ_ORZ_CHT B1" ).append("\n"); 
		query.append("                                                 WHERE A1.LOC_CD = substr(@[org_yd_cd],0,5)" ).append("\n"); 
		query.append("                                                 AND A1.SCC_CD = B1.SCC_CD )  " ).append("\n"); 
		query.append("                            AND B2.SCC_CD = A2.SCC_CD" ).append("\n"); 
		query.append("                            AND A2.LOC_CD = Y.LOC_CD" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("		  ORDER BY A.CNTR_NO, A.MVMT_DT  DESC" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	WHERE ROWNUM=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A , CGM_MGST_MVMT_HIS B" ).append("\n"); 
		query.append("WHERE A.MGST_NO = B.MGST_NO" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 

	}
}