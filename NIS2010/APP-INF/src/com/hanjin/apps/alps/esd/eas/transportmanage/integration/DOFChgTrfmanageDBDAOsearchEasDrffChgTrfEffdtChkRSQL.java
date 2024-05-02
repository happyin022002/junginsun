/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchEasDrffChgTrfEffdtChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchEasDrffChgTrfEffdtChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop-off Charge조회
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchEasDrffChgTrfEffdtChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_trf_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchEasDrffChgTrfEffdtChkRSQL").append("\n"); 
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
		query.append("X.PREV_FM_EFF_DT, H.FM_EFF_DT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM EAS_DRFF_CHG_TRF_HDR H2" ).append("\n"); 
		query.append("WHERE H2.CNT_CD = H.CNT_CD" ).append("\n"); 
		query.append("AND H2.DRFF_CHG_TRF_SEQ = H.DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("AND H2.DRFF_CHG_TRF_VER_NO = H.DRFF_CHG_TRF_VER_NO-1" ).append("\n"); 
		query.append("AND NVL(H2.DELT_FLG,'N') <> 'Y')" ).append("\n"); 
		query.append("THEN CASE" ).append("\n"); 
		query.append("WHEN H.FM_EFF_DT IS NOT NULL AND X.PREV_FM_EFF_DT IS NOT NULL" ).append("\n"); 
		query.append("AND LENGTH(H.FM_EFF_DT)=8  AND LENGTH(X.PREV_FM_EFF_DT)=8" ).append("\n"); 
		query.append("AND SIGN(X.PREV_FM_EFF_DT-H.FM_EFF_DT) < 0" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("ELSE 'Y'" ).append("\n"); 
		query.append("END FM_EFF_DT_CHK" ).append("\n"); 
		query.append("FROM EAS_DRFF_CHG_TRF_HDR H," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT (" ).append("\n"); 
		query.append("SELECT H.FM_EFF_DT" ).append("\n"); 
		query.append("FROM EAS_DRFF_CHG_TRF_HDR H" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("WHERE H.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE H.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_SEQ = @[drff_chg_trf_seq]" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_VER_NO = TO_NUMBER(@[drff_chg_trf_ver_no])-1" ).append("\n"); 
		query.append(") PREV_FM_EFF_DT FROM DUAL" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND H.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND H.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_SEQ = @[drff_chg_trf_seq]" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_VER_NO = TO_NUMBER(@[drff_chg_trf_ver_no])" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}