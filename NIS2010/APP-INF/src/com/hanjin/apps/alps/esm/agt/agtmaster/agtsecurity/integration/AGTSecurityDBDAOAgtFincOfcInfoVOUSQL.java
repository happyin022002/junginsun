/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTSecurityDBDAOAgtFincOfcInfoVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.06
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.09.06 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTSecurityDBDAOAgtFincOfcInfoVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public AGTSecurityDBDAOAgtFincOfcInfoVOUSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtmaster.agtsecurity.integration").append("\n"); 
		query.append("FileName : AGTSecurityDBDAOAgtFincOfcInfoVOUSQL").append("\n"); 
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
		query.append("UPDATE AGT_FINC_OFC_INFO" ).append("\n"); 
		query.append("SET AR_OFC_CD    = @[ar_ofc_cd]," ).append("\n"); 
		query.append("CURR_CD      = @[curr_cd]," ).append("\n"); 
		query.append("DELT_FLG     = @[delt_flg]," ).append("\n"); 
		query.append("OFC_DELT_RSN = @[ofc_delt_rsn]," ).append("\n"); 
		query.append("COMM_OFC_FLG = @[comm_ofc_flg]," ).append("\n"); 
		query.append("UPD_USR_ID   = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT       = SYSDATE," ).append("\n"); 
		query.append("OFC_GRP_LVL  =" ).append("\n"); 
		query.append("(     SELECT" ).append("\n"); 
		query.append("DISTINCT B.OFC_GRP_LVL AS GRP_LVL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(     SELECT A.OFC_CD AS OFC_CD," ).append("\n"); 
		query.append("B.AR_OFC_CD AS AR_OFC" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("MDM_ORGANIZATION B" ).append("\n"); 
		query.append("WHERE A.OFC_CD     = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.OFC_CD     =" ).append("\n"); 
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
		query.append("WHERE A.OFC_CD     = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND A.OFC_CD     =" ).append("\n"); 
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
		query.append("WHERE AGN_CD       = @[agn_cd]" ).append("\n"); 

	}
}