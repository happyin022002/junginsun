/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAO021SpcTeamQtaRtoByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2012.10.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAO021SpcTeamQtaRtoByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 항차별 Team QTA Ratio를 조회한다.
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAO021SpcTeamQtaRtoByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subtrade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAO021SpcTeamQtaRtoByVvdRSQL").append("\n"); 
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
		query.append("SELECT TRD_CD, " ).append("\n"); 
		query.append("       SUB_TRD_CD, " ).append("\n"); 
		query.append("       RLANE_CD, " ).append("\n"); 
		query.append("       SLS_REP_OFC_TEAM_CD, " ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       TEAM_QTA_RTO" ).append("\n"); 
		query.append("  FROM SPC_TEAM_QTA_RTO" ).append("\n"); 
		query.append(" WHERE QTA_APLY_CD = @[type]" ).append("\n"); 
		query.append("#if(${trade} != '')" ).append("\n"); 
		query.append("   AND TRD_CD      = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${subtrade} != '')" ).append("\n"); 
		query.append("   AND SUB_TRD_CD  = @[subtrade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${lane} != '')" ).append("\n"); 
		query.append("   AND RLANE_CD    = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY TRD_CD, " ).append("\n"); 
		query.append("          SUB_TRD_CD, " ).append("\n"); 
		query.append("          RLANE_CD, " ).append("\n"); 
		query.append("          DECODE(SLS_REP_OFC_TEAM_CD, 'OTHER', 0, 'SELBK', 1, 'SELBS', 2, 3)" ).append("\n"); 

	}
}