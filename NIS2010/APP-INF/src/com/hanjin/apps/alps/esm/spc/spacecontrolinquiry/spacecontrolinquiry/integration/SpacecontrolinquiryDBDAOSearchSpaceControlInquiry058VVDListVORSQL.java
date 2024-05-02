/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiry058VVDListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.25
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2013.11.25 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Shin Ja Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpacecontrolinquiryDBDAOSearchSpaceControlInquiry058VVDListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SpacecontrolinquiryDBDAOSearchSpaceControlInquiry058VVDListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("week1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.integration").append("\n"); 
		query.append("FileName : SpacecontrolinquiryDBDAOSearchSpaceControlInquiry058VVDListVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("SUBSTR(MV.SLS_YRMON, 1, 4)||MV.COST_WK     AS COST_YRWK," ).append("\n"); 
		query.append("VPS.VSL_CD||VPS.SKD_VOY_NO||VPS.SKD_DIR_CD AS VVD      ," ).append("\n"); 
		query.append("MIN(CASE WHEN VPS.TURN_PORT_IND_CD IN ('Y', 'N') THEN TVPS.SKD_VOY_NO||TVPS.SKD_DIR_CD END) || '/' || MAX(CASE WHEN VPS.TURN_PORT_IND_CD NOT IN ('Y', 'N') THEN TVPS.SKD_VOY_NO||TVPS.SKD_DIR_CD END) AS REL_VVD," ).append("\n"); 
		query.append("'' AS T" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD      TVPS," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD VPS ," ).append("\n"); 
		query.append("MAS_MON_VVD      MV  ," ).append("\n"); 
		query.append("MDM_REV_LANE     RL" ).append("\n"); 
		query.append("WHERE TVPS.VSL_CD    (+) = VPS.VSL_CD" ).append("\n"); 
		query.append("AND TVPS.SKD_VOY_NO(+) = VPS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("AND TVPS.SKD_DIR_CD(+) = VPS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("AND VPS.VSL_CD         = MV.VSL_CD" ).append("\n"); 
		query.append("AND VPS.SKD_VOY_NO     = MV.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VPS.SKD_DIR_CD     = MV.DIR_CD" ).append("\n"); 
		query.append("AND (VPS.SKD_CNG_STS_CD IS NULL OR VPS.SKD_CNG_STS_CD <> 'S')" ).append("\n"); 
		query.append("AND SUBSTR(MV.SLS_YRMON, 1, 4)||MV.COST_WK = @[year1]||@[week1]" ).append("\n"); 
		query.append("AND MV.DIR_CD    = @[bound]" ).append("\n"); 
		query.append("AND MV.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("AND MV.RLANE_CD  = RL.RLANE_CD" ).append("\n"); 
		query.append("AND MV.TRD_CD    = RL.REP_TRD_CD" ).append("\n"); 
		query.append("AND RL.RLANE_CD  = @[lane]" ).append("\n"); 
		query.append("AND RL.VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("GROUP BY MV.SLS_YRMON  ," ).append("\n"); 
		query.append("MV.COST_WK    ," ).append("\n"); 
		query.append("VPS.VSL_CD    ," ).append("\n"); 
		query.append("VPS.SKD_VOY_NO," ).append("\n"); 
		query.append("VPS.SKD_DIR_CD" ).append("\n"); 

	}
}
