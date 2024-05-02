/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PRISimulationDBDAOCheckCtrtTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.13 
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

public class PRISimulationDBDAOCheckCtrtTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Checking Contract Type. (SC,RFA,TAA)
	  * </pre>
	  */
	public PRISimulationDBDAOCheckCtrtTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration ").append("\n"); 
		query.append("FileName : PRISimulationDBDAOCheckCtrtTypeRSQL").append("\n"); 
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
		query.append("   NVL((SELECT 'T'" ).append("\n"); 
		query.append("          FROM PRI_TAA_MN MN," ).append("\n"); 
		query.append("               PRI_TAA_HDR HDR" ).append("\n"); 
		query.append("         WHERE MN.TAA_PROP_NO = HDR.TAA_PROP_NO" ).append("\n"); 
		query.append("           AND HDR.TAA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("           AND CFM_FLG = 'Y'" ).append("\n"); 
		query.append("           AND ROWNUM = 1    --TAA" ).append("\n"); 
		query.append("       ),NVL(" ).append("\n"); 
		query.append("       (SELECT 'R'" ).append("\n"); 
		query.append("          FROM PRI_RP_MN MN," ).append("\n"); 
		query.append("               PRI_RP_HDR HDR" ).append("\n"); 
		query.append("         WHERE MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("           AND HDR.RFA_NO = @[ctrt_no]" ).append("\n"); 
		query.append("           AND PROP_STS_CD = 'A'" ).append("\n"); 
		query.append("           AND ROWNUM = 1   --RFA" ).append("\n"); 
		query.append("       )," ).append("\n"); 
		query.append("       (SELECT 'S'" ).append("\n"); 
		query.append("          FROM PRI_SP_MN MN," ).append("\n"); 
		query.append("               PRI_SP_HDR HDR," ).append("\n"); 
		query.append("               PRI_SP_CTRT_PTY PTY" ).append("\n"); 
		query.append("         WHERE MN.PROP_NO = HDR.PROP_NO" ).append("\n"); 
		query.append("           AND MN.PROP_NO = PTY.PROP_NO" ).append("\n"); 
		query.append("           AND MN.AMDT_SEQ = PTY.AMDT_SEQ" ).append("\n"); 
		query.append("           AND HDR.SC_NO = @[ctrt_no]" ).append("\n"); 
		query.append("           AND PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("           AND MN.PROP_STS_CD = 'F'" ).append("\n"); 
		query.append("           AND ROWNUM = 1   --SC" ).append("\n"); 
		query.append("       ))) AS CTRT_TP" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}