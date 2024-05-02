/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOVerifyEqNoChassisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.12
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2017.01.12 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOVerifyEqNoChassisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chassis Verify
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOVerifyEqNoChassisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOVerifyEqNoChassisRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_NO ," ).append("\n"); 
		query.append("       A.EQ_TPSZ_CD ," ).append("\n"); 
		query.append("       SUBSTR(A.ONH_YD_CD, 1, 5) FM_LOC_VALUE ," ).append("\n"); 
		query.append("       SUBSTR(A.ONH_YD_CD, 6, 2) FM_YARD_VALUE ," ).append("\n"); 
		query.append("       SUBSTR(A.CHSS_MVMT_DEST_YD_CD, 1, 5) TO_LOC_VALUE ," ).append("\n"); 
		query.append("       SUBSTR(A.CHSS_MVMT_DEST_YD_CD, 6, 2) TO_YARD_VALUE ," ).append("\n"); 
		query.append("       A.VNDR_SEQ ," ).append("\n"); 
		query.append("       C.VNDR_ABBR_NM ," ).append("\n"); 
		query.append("       A.AGMT_LSTM_CD LSTM_CD ," ).append("\n"); 
		query.append("       A.CHSS_OWNR_CO_CD OWNR_CO_CD ," ).append("\n"); 
		query.append("       A.LST_USE_CO_CD USR_CO_CD ," ).append("\n"); 
		query.append("       A.CHSS_MVMT_STS_CD MVMT_STS_CD ," ).append("\n"); 
		query.append("       D.MVMT_STS_NM ," ).append("\n"); 
		query.append("       E.STS_EVNT_YD_CD AS LST_STS_YD_CD ," ).append("\n"); 
		query.append("       TO_CHAR (A.CHSS_MVMT_DT, 'YYYYMMDD') MVMT_DT" ).append("\n"); 
		query.append("  FROM CGM_EQUIPMENT A ," ).append("\n"); 
		query.append("       CGM_EQ_TP_SZ B ," ).append("\n"); 
		query.append("       MDM_VENDOR C ," ).append("\n"); 
		query.append("       MDM_MVMT_STS D ," ).append("\n"); 
		query.append("       CGM_EQ_STS_HIS E" ).append("\n"); 
		query.append(" WHERE A.EQ_TPSZ_CD = B.EQ_TPSZ_CD" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = B.EQ_KND_CD" ).append("\n"); 
		query.append("   AND A.EQ_NO = E.EQ_NO" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = E.EQ_KND_CD" ).append("\n"); 
		query.append("   AND A.EQ_STS_SEQ = E.EQ_STS_SEQ" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = 'Z' --Equipment Kind Code : Z(Chassis)" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = C.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.CHSS_MVMT_STS_CD = D.MVMT_STS_CD(+)" ).append("\n"); 
		query.append("   AND A.EQ_NO IN (" ).append("\n"); 
		query.append("#foreach(${key} in ${eq_no})  " ).append("\n"); 
		query.append("	#if($velocityCount == 1)" ).append("\n"); 
		query.append("        '$key'" ).append("\n"); 
		query.append("  	#else " ).append("\n"); 
		query.append("       ,'$key'" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}