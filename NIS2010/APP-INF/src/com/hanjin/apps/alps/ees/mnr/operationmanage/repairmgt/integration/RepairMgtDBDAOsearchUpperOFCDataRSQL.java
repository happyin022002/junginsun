/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairMgtDBDAOsearchUpperOFCDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.12.02 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOsearchUpperOFCDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUpperOFCData
	  * </pre>
	  */
	public RepairMgtDBDAOsearchUpperOFCDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration ").append("\n"); 
		query.append("FileName : RepairMgtDBDAOsearchUpperOFCDataRSQL").append("\n"); 
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
		query.append("C.OFC_CD," ).append("\n"); 
		query.append("C.UPPR_OFC_CD," ).append("\n"); 
		query.append("NVL(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC (TO_CHAR(SYSDATE, 'YYYYMM'),C.CURR_CD, @[curr_cd], C.AUTO_AMT),-1) AS AUTO_AMT," ).append("\n"); 
		query.append("NVL(MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC (TO_CHAR(SYSDATE, 'YYYYMM'),C.CURR_CD, @[curr_cd], C.APPOVAL_AMT),9999999999999) AS APPOVAL_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("UPPR_OFC_CD," ).append("\n"); 
		query.append("EQ_KND_CD," ).append("\n"); 
		query.append("DECODE(SIGN(SYSDATE - EFF_DT), 1, AFT_AUTO_APRO_AMT , BFR_AUTO_APRO_AMT) AUTO_AMT," ).append("\n"); 
		query.append("DECODE(SIGN(SYSDATE - EFF_DT), 1, AFT_SELF_AUTH_AMT , BFR_SELF_AUTH_AMT) APPOVAL_AMT," ).append("\n"); 
		query.append("SUBSTR(COST_CD, 3, 1) AS COST_PREFIX," ).append("\n"); 
		query.append("CURR_CD" ).append("\n"); 
		query.append("FROM  MNR_OFC_GEN_INFO" ).append("\n"); 
		query.append("WHERE MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append(") C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MSV.EQ_TYPE," ).append("\n"); 
		query.append("MSV.EQ_TPSZ_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MNR_EQ_STS_V MSV" ).append("\n"); 
		query.append("WHERE MSV.EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE C.OFC_CD(+) = @[cost_ofc_cd]" ).append("\n"); 
		query.append("AND C.EQ_KND_CD(+) = D.EQ_TYPE" ).append("\n"); 
		query.append("AND C.COST_PREFIX(+) = DECODE(LENGTH(D.EQ_TPSZ_CD),3,'Z',DECODE(SUBSTR(D.EQ_TPSZ_CD,1,1),'R','R','D'))" ).append("\n"); 
		query.append("AND ROWNUM =  1" ).append("\n"); 

	}
}