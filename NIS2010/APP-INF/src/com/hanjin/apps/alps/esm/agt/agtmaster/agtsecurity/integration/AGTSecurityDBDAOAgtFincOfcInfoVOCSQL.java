/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTSecurityDBDAOAgtFincOfcInfoVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTSecurityDBDAOAgtFincOfcInfoVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AGTSecurityDBDAOAgtFincOfcInfoVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_ofc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_delt_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.integration").append("\n"); 
		query.append("FileName : AGTSecurityDBDAOAgtFincOfcInfoVOCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO AGT_FINC_OFC_INFO" ).append("\n"); 
		query.append("( AGN_CD," ).append("\n"); 
		query.append("AR_OFC_CD," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("OFC_DELT_RSN," ).append("\n"); 
		query.append("COMM_OFC_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("OFC_GRP_LVL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[agn_cd]," ).append("\n"); 
		query.append("@[ar_ofc_cd]," ).append("\n"); 
		query.append("@[delt_flg]," ).append("\n"); 
		query.append("@[ofc_delt_rsn]," ).append("\n"); 
		query.append("@[comm_ofc_flg]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[curr_cd]," ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("DISTINCT B.OFC_GRP_LVL AS GRP_LVL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("A.OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("B.AR_OFC_CD AS AR_OFC" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.OFC_CD =" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.OFC_CD     = 'HKGBB' THEN B.AR_OFC_CD" ).append("\n"); 
		query.append("WHEN A.OFC_KND_CD = '2'     THEN B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("WHEN A.OFC_KND_CD = '3'     THEN B.AR_OFC_CD" ).append("\n"); 
		query.append("WHEN A.OFC_KND_CD = '4'     THEN B.AR_OFC_CD" ).append("\n"); 
		query.append("WHEN A.OFC_KND_CD = '5'     THEN B.AR_OFC_CD" ).append("\n"); 
		query.append("WHEN A.OFC_KND_CD = '6'     THEN B.AR_OFC_CD" ).append("\n"); 
		query.append("WHEN A.OFC_KND_CD = '9'     THEN B.AR_OFC_CD" ).append("\n"); 
		query.append("ELSE B.OFC_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("AGT_FINC_OFC_INFO B" ).append("\n"); 
		query.append("WHERE A.AR_OFC = B.AGN_CD" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT B.OFC_GRP_LVL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(     SELECT A.OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("B.AR_OFC_CD AS AR_OFC" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.OFC_CD =" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.OFC_CD     = 'HKGBB' THEN B.AR_OFC_CD" ).append("\n"); 
		query.append("WHEN A.OFC_KND_CD = '2'     THEN B.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("WHEN A.OFC_KND_CD = '3'     THEN B.AR_OFC_CD" ).append("\n"); 
		query.append("WHEN A.OFC_KND_CD = '4'     THEN B.AR_OFC_CD" ).append("\n"); 
		query.append("WHEN A.OFC_KND_CD = '5'     THEN B.AR_OFC_CD" ).append("\n"); 
		query.append("WHEN A.OFC_KND_CD = '6'     THEN B.AR_OFC_CD" ).append("\n"); 
		query.append("WHEN A.OFC_KND_CD = '9'     THEN B.AR_OFC_CD" ).append("\n"); 
		query.append("ELSE B.OFC_CD" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("AGT_FINC_OFC_INFO B" ).append("\n"); 
		query.append("WHERE A.AR_OFC = B.AR_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}