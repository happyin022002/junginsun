/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailBillingVerifyManageDBDAOCheckMtyContainerStatusSeCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.18
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.11.18 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingVerifyManageDBDAOCheckMtyContainerStatusSeCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * without Cntr_no  EMPTY CNTR IRG 체크. PLAN ID 확보 CHECK
	  * </pre>
	  */
	public RailBillingVerifyManageDBDAOCheckMtyContainerStatusSeCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmYdCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.integration").append("\n"); 
		query.append("FileName : RailBillingVerifyManageDBDAOCheckMtyContainerStatusSeCntrRSQL").append("\n"); 
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
		query.append("SELECT REPO_PLN_ID," ).append("\n"); 
		query.append("       PLN_YRWK," ).append("\n"); 
		query.append("       REF_ID," ).append("\n"); 
		query.append("       REF_SEQ," ).append("\n"); 
		query.append("       TO_YD_CD," ).append("\n"); 
		query.append("       FM_YD_CD" ).append("\n"); 
		query.append("  FROM EQR_REPO_EXE_SO_IF EQR," ).append("\n"); 
		query.append("       PRD_INLND_ROUT_MST MST," ).append("\n"); 
		query.append("       EQR_WK_PRD WK" ).append("\n"); 
		query.append(" WHERE EQR.FM_YD_CD = MST.ROUT_ORG_NOD_CD (+)" ).append("\n"); 
		query.append("   AND EQR.TO_YD_CD = MST.ROUT_DEST_NOD_CD (+)" ).append("\n"); 
		query.append("   AND MST.PCTL_IO_BND_CD ='M'" ).append("\n"); 
		query.append("   AND NVL(MST.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("   AND MST.WRS_MTY_CMDT_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND FM_YD_CD = @[fmYdCd]" ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD = @[eqNo]" ).append("\n"); 
		query.append("   AND NVL( DECODE ( @[eqNo], 'D2', MST.D2_CAPA_FLG," ).append("\n"); 
		query.append("                              'D4', MST.D4_CAPA_FLG," ).append("\n"); 
		query.append("                              'D5', MST.D5_CAPA_FLG," ).append("\n"); 
		query.append("                              'D7', MST.D7_CAPA_FLG," ).append("\n"); 
		query.append("                              'O2', MST.O2_CAPA_FLG," ).append("\n"); 
		query.append("                              'O4', MST.O4_CAPA_FLG," ).append("\n"); 
		query.append("                              --'O5', MST.O5_CAPA_FLG," ).append("\n"); 
		query.append("                              'A2', MST.A2_CAPA_FLG," ).append("\n"); 
		query.append("                              'A4', MST.A4_CAPA_FLG," ).append("\n"); 
		query.append("                              --'A5', MST.A5_CAPA_FLG," ).append("\n"); 
		query.append("                              'R2', MST.R2_CAPA_FLG," ).append("\n"); 
		query.append("                              'R5', MST.R5_CAPA_FLG) , 'N') = 'Y'" ).append("\n"); 
		query.append("   AND EQR.TRSP_MOD_CD = 'R'" ).append("\n"); 
		query.append("   AND TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("   AND CNTR_NO IS NULL" ).append("\n"); 
		query.append("   AND WK.PLN_YR = SUBSTR(EQR.PLN_YRWK, 1, 4)" ).append("\n"); 
		query.append("   AND WK.PLN_WK = SUBSTR(EQR.PLN_YRWK, 5, 2)" ).append("\n"); 
		query.append("   AND TO_CHAR(SYSDATE , 'YYYYMMDD') BETWEEN WK.WK_ST_DT AND WK.WK_END_DT" ).append("\n"); 
		query.append(" GROUP BY REPO_PLN_ID," ).append("\n"); 
		query.append("          PLN_YRWK," ).append("\n"); 
		query.append("          REF_ID," ).append("\n"); 
		query.append("          REF_SEQ," ).append("\n"); 
		query.append("          TO_YD_CD," ).append("\n"); 
		query.append("          FM_YD_CD" ).append("\n"); 
		query.append(" ORDER BY COUNT(MST.ROUT_SEQ) DESC," ).append("\n"); 
		query.append("          REPO_PLN_ID," ).append("\n"); 
		query.append("          PLN_YRWK," ).append("\n"); 
		query.append("          REF_ID," ).append("\n"); 
		query.append("          REF_SEQ" ).append("\n"); 

	}
}