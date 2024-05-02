/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MgsetMovementHistoryDBDAOcheckMGSBareMvmtByopocDataRSQL.java
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

public class MgsetMovementHistoryDBDAOcheckMGSBareMvmtByopocDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MgsetMovementHistoryDBDAOcheckMGSBareMvmtByopocDataRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration ").append("\n"); 
		query.append("FileName : MgsetMovementHistoryDBDAOcheckMGSBareMvmtByopocDataRSQL").append("\n"); 
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
		query.append("  A.MGST_NO MGST_NO " ).append("\n"); 
		query.append(", TO_CHAR(A.MVMT_DT,'YYYYMMDDHH24MISS') MVMT_DT_1" ).append("\n"); 
		query.append(", TO_CHAR(B.MVMT_DT,'YYYYMMDDHH24MISS') MVMT_DT_2" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("	SELECT /*+ INDEX_DESC(A XAK1CGM_MGST_MVMT_HIS) */ " ).append("\n"); 
		query.append("     	  A.MGST_NO" ).append("\n"); 
		query.append("    	 ,A.GATE_IO_CD" ).append("\n"); 
		query.append("   		 ,A.MVMT_DT      " ).append("\n"); 
		query.append("	FROM   CGM_MGST_MVMT_HIS A, MDM_LOCATION B , MDM_EQ_ORZ_CHT C  " ).append("\n"); 
		query.append("	WHERE  A.CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("	AND    B.LOC_CD   = SUBSTR(A.YD_CD, 1, 5) " ).append("\n"); 
		query.append("	AND    C.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("	AND    C.LCC_CD = ( SELECT  B.LCC_CD FROM MDM_LOCATION A , MDM_EQ_ORZ_CHT B  " ).append("\n"); 
		query.append("                     WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("                     AND A.LOC_CD = substr(@[org_yd_cd],0,5)" ).append("\n"); 
		query.append("                     AND ROWNUM=1 )" ).append("\n"); 
		query.append("	AND    A.MGST_NO <> @[mgst_no]" ).append("\n"); 
		query.append("	AND    A.MVMT_STS_CD= 'MT'" ).append("\n"); 
		query.append("	AND    ROWNUM      = 1" ).append("\n"); 
		query.append("	) A, CGM_MGST_MVMT_HIS B, CGM_EQUIPMENT C" ).append("\n"); 
		query.append("WHERE B.MGST_NO =A.MGST_NO" ).append("\n"); 
		query.append("  AND B.MGST_NO = C.EQ_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}