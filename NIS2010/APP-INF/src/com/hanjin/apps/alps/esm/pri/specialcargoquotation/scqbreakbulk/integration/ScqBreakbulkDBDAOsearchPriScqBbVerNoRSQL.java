/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqBreakbulkDBDAOsearchPriScqBbVerNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.18
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.03.18 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqBreakbulkDBDAOsearchPriScqBbVerNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchPriScqBbVerNo
	  * </pre>
	  */
	public ScqBreakbulkDBDAOsearchPriScqBbVerNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration ").append("\n"); 
		query.append("FileName : ScqBreakbulkDBDAOsearchPriScqBbVerNoRSQL").append("\n"); 
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
		query.append("SELECT SCQ_RQST_NO" ).append("\n"); 
		query.append("     , SCQ_VER_NO  " ).append("\n"); 
		query.append("     , NVL(INTG_CD_VAL_DP_DESC, MN.PROG_STS_CD) PROG_STS_CD" ).append("\n"); 
		query.append("     , DECODE(DELT_FLG,'Y','Deleted','') DELT_FLG     " ).append("\n"); 
		query.append("  FROM PRI_SCQ_BB_MN MN," ).append("\n"); 
		query.append("       (SELECT INTG_CD_VAL_CTNT, INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL  " ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD03161') CD" ).append("\n"); 
		query.append(" WHERE MN.SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("   AND MN.PROG_STS_CD = CD.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append(" ORDER BY SCQ_VER_NO DESC" ).append("\n"); 

	}
}