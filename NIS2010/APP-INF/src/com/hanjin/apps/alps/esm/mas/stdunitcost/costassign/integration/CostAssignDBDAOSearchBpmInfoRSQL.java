/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CostAssignDBDAOSearchBpmInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOSearchBpmInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BPM에 BKG정보제공하는 쿼리
	  * </pre>
	  */
	public CostAssignDBDAOSearchBpmInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOSearchBpmInfoRSQL").append("\n"); 
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
		query.append("      ,VSL_CD||SKD_VOY_NO||DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,BKG_OFC_CD" ).append("\n"); 
		query.append("      ,SUM(DECODE(BKG_STS_CD,'X',0, BKG_QTY)) AS BKG_QTY" ).append("\n"); 
		query.append("      ,ROUND(SUM(DECODE(BKG_STS_CD,'X',0,(BKG_REV+BKG_OFT_REV+BKG_MISC_REV+SCR_CHG_REV))),0) AS REV_AMT" ).append("\n"); 
		query.append("      ,ROUND(SUM(DECODE(BKG_STS_CD,'X',0, PA_CM_COST_TTL_AMT)),0) AS COST_AMT" ).append("\n"); 
		query.append("      ,TO_CHAR(SYSDATE,'YYYY-MM-DD') AS INS_DT" ).append("\n"); 
		query.append("  FROM MAS_BKG_EXPN_DTL" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_STS_CD      IN ('F','S','W','X')" ).append("\n"); 
		query.append("   AND BKG_CGO_TP_CD   <> 'P'" ).append("\n"); 
		query.append("   AND BL_NO_TP        IN ('M','0')" ).append("\n"); 
		query.append("GROUP BY BKG_NO" ).append("\n"); 
		query.append("        ,VSL_CD||SKD_VOY_NO||DIR_CD " ).append("\n"); 
		query.append("        ,BKG_OFC_CD   " ).append("\n"); 
		query.append("        ,TO_CHAR(SYSDATE,'YYYY-MM-DD')" ).append("\n"); 

	}
}