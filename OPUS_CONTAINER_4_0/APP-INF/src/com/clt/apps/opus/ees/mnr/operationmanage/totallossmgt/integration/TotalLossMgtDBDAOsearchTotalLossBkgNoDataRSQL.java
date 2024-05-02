/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TotalLossMgtDBDAOsearchTotalLossBkgNoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TotalLossMgtDBDAOsearchTotalLossBkgNoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TotalLossMgtDBDAOsearchTotalLossBkgNoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_lss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.integration").append("\n"); 
		query.append("FileName : TotalLossMgtDBDAOsearchTotalLossBkgNoDataRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append("  FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE BKG_NO = " ).append("\n"); 
		query.append("(SELECT CASE WHEN                 " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#if(${eq_type} == 'U')" ).append("\n"); 
		query.append("  SELECT /*+ INDEX_DESC (A XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("        A.MVMT_STS_CD" ).append("\n"); 
		query.append("#elseif(${eq_type} == 'Z')" ).append("\n"); 
		query.append("  SELECT /*+ INDEX_DESC (A XAK17CTM_MOVEMENT) */" ).append("\n"); 
		query.append("        A.MVMT_STS_CD" ).append("\n"); 
		query.append("#elseif(${eq_type} == 'G')" ).append("\n"); 
		query.append("  SELECT /*+ INDEX_DESC (A XAK20CTM_MOVEMENT) */" ).append("\n"); 
		query.append("        A.MVMT_STS_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${eq_type} == 'U')" ).append("\n"); 
		query.append("   AND A.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("#elseif(${eq_type} == 'Z')" ).append("\n"); 
		query.append("   AND A.CHSS_NO = @[eq_no]" ).append("\n"); 
		query.append("#elseif(${eq_type} == 'G')" ).append("\n"); 
		query.append("   AND A.MGST_NO = @[eq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND TO_CHAR(A.CNMV_EVNT_DT, 'YYYY-MM-DD') <= @[ttl_lss_dt]" ).append("\n"); 
		query.append("   AND ROWNUM = 1) = 'MT' THEN 'XX'" ).append("\n"); 
		query.append("   ELSE" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("#if(${eq_type} == 'U')" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC (A XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("             A.BKG_NO" ).append("\n"); 
		query.append("#elseif(${eq_type} == 'Z')" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC (A XAK17CTM_MOVEMENT) */" ).append("\n"); 
		query.append("             A.BKG_NO" ).append("\n"); 
		query.append("#elseif(${eq_type} == 'G')" ).append("\n"); 
		query.append("        SELECT /*+ INDEX_DESC (A XAK20CTM_MOVEMENT) */" ).append("\n"); 
		query.append("             A.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM CTM_MOVEMENT A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${eq_type} == 'U')" ).append("\n"); 
		query.append("   AND A.CNTR_NO = @[eq_no]" ).append("\n"); 
		query.append("#elseif(${eq_type} == 'Z')" ).append("\n"); 
		query.append("   AND A.CHSS_NO = @[eq_no]" ).append("\n"); 
		query.append("#elseif(${eq_type} == 'G')" ).append("\n"); 
		query.append("   AND A.MGST_NO = @[eq_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND TO_CHAR(A.CNMV_EVNT_DT, 'YYYY-MM-DD') <= @[ttl_lss_dt]" ).append("\n"); 
		query.append("   AND ROWNUM = 1) END" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("  AND BKG_CGO_TP_CD IN ('F', 'R')" ).append("\n"); 

	}
}