/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRISimulationDBDAOSearchTrnsModRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRISimulationDBDAOSearchTrnsModRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PRISimulationDBDAOSearchTrnsModRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration ").append("\n"); 
		query.append("FileName : PRISimulationDBDAOSearchTrnsModRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    (SELECT " ).append("\n"); 
		query.append("          CASE WHEN OB.TRSP_MOD_CD = 'WD' THEN DECODE(MST.POD_CD, MST.DEL_CD, 'F', 'B')" ).append("\n"); 
		query.append("    		   WHEN OB.TRSP_MOD_CD = 'RD' THEN 'R'" ).append("\n"); 
		query.append("    		   WHEN OB.TRSP_MOD_CD = 'TD' THEN 'T'" ).append("\n"); 
		query.append("    		   WHEN OB.TRSP_MOD_CD = 'TR' THEN 'A'" ).append("\n"); 
		query.append("    		   WHEN OB.TRSP_MOD_CD = 'TW' THEN DECODE(MST.POD_CD, MST.DEL_CD, 'E', 'U') END" ).append("\n"); 
		query.append("    	FROM PRD_INLND_ROUT_MST OB" ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
		query.append("         AND (OB.ROUT_ORG_NOD_CD, OB.ROUT_DEST_NOD_CD, OB.ROUT_SEQ) =" ).append("\n"); 
		query.append("					      (SELECT DTL.ROUT_ORG_NOD_CD, DTL.ROUT_DEST_NOD_CD, ROUT_SEQ " ).append("\n"); 
		query.append("					         FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("					        WHERE DTL.PCTL_NO        = MST.PCTL_NO   " ).append("\n"); 
		query.append("					          AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("						      AND DTL.ROUT_SEQ       <> 0" ).append("\n"); 
		query.append("							  AND ROWNUM = 1)" ).append("\n"); 
		query.append("	) ORG_TRNS_MOD_CD," ).append("\n"); 
		query.append("    (SELECT " ).append("\n"); 
		query.append("          CASE WHEN IB.TRSP_MOD_CD = 'WD' THEN DECODE(MST.POD_CD, MST.DEL_CD, 'F', 'B')" ).append("\n"); 
		query.append("    		   WHEN IB.TRSP_MOD_CD = 'RD' THEN 'R'" ).append("\n"); 
		query.append("    		   WHEN IB.TRSP_MOD_CD = 'TD' THEN 'T'" ).append("\n"); 
		query.append("    		   WHEN IB.TRSP_MOD_CD = 'TR' THEN 'A'" ).append("\n"); 
		query.append("    		   WHEN IB.TRSP_MOD_CD = 'TW' THEN DECODE(MST.POD_CD, MST.DEL_CD, 'E', 'U') END" ).append("\n"); 
		query.append("    	FROM PRD_INLND_ROUT_MST IB" ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
		query.append("         AND (IB.ROUT_ORG_NOD_CD, IB.ROUT_DEST_NOD_CD, IB.ROUT_SEQ) =" ).append("\n"); 
		query.append("					      (SELECT DTL.ROUT_ORG_NOD_CD, DTL.ROUT_DEST_NOD_CD, ROUT_SEQ " ).append("\n"); 
		query.append("					         FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("					        WHERE DTL.PCTL_NO        = MST.PCTL_NO   " ).append("\n"); 
		query.append("					          AND DTL.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("						      AND DTL.ROUT_SEQ       <> 0" ).append("\n"); 
		query.append("							  AND ROWNUM = 1)" ).append("\n"); 
		query.append("	) DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST MST" ).append("\n"); 
		query.append("WHERE MST.PCTL_NO = @[pctl_no]" ).append("\n"); 

	}
}