/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOVerifyEqNoMgSetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.16
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2017.01.16 박찬우
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

public class ChassisGensetSOManageDBDAOVerifyEqNoMgSetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Genset verify
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOVerifyEqNoMgSetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOVerifyEqNoMgSetRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_NO" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.EQ_TPSZ_CD CHSS_TPSZ_DESC" ).append("\n"); 
		query.append("      ,SUBSTR(A.ONH_YD_CD,1,5) FM_LOC_VALUE" ).append("\n"); 
		query.append("      ,SUBSTR(A.ONH_YD_CD,6,2) FM_YARD_VALUE" ).append("\n"); 
		query.append("      ,A.VNDR_SEQ" ).append("\n"); 
		query.append("      ,B.VNDR_ABBR_NM" ).append("\n"); 
		query.append("      ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("  FROM CGM_EQUIPMENT A," ).append("\n"); 
		query.append("       MDM_VENDOR B" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = 'G'  --Equipment Kind Code : G(MGSet)" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.EQ_NO IN (" ).append("\n"); 
		query.append("#foreach(${key} IN ${eq_no})  " ).append("\n"); 
		query.append("	#if($velocityCount == 1)" ).append("\n"); 
		query.append("      	'$key'" ).append("\n"); 
		query.append("  	#else " ).append("\n"); 
		query.append("       ,'$key'" ).append("\n"); 
		query.append("  	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}