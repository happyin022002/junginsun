/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EServiceCompensationDBDAOPriCmpnEsvcVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.22
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.06.22 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SUNGMIN CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EServiceCompensationDBDAOPriCmpnEsvcVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * E-SVC Compensation Creation 화면조회
	  * </pre>
	  */
	public EServiceCompensationDBDAOPriCmpnEsvcVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration").append("\n"); 
		query.append("FileName : EServiceCompensationDBDAOPriCmpnEsvcVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	A.CMPN_SEQ" ).append("\n"); 
		query.append(",	A.SVC_SCP_CD" ).append("\n"); 
		query.append(",	A.CMPN_SEQ" ).append("\n"); 
		query.append(",	A.ORG_RGN_CD" ).append("\n"); 
		query.append(",	A.DEST_RGN_CD" ).append("\n"); 
		query.append(",   (SELECT DECODE(COUNT(*),0,0,1) AS PRC_ESVC_TP_CD_W FROM PRI_CMPN_ESVC_TP " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = A.SVC_SCP_CD " ).append("\n"); 
		query.append("        AND CMPN_SEQ = A.CMPN_SEQ " ).append("\n"); 
		query.append("        AND ESVC_TP_SEQ = '1' AND PRC_ESVC_TP_CD = 'W' ) AS PRC_ESVC_TP_CD_W" ).append("\n"); 
		query.append(",   (SELECT DECODE(COUNT(*),0,0,1) AS PRC_ESVC_TP_CD_W FROM PRI_CMPN_ESVC_TP " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = A.SVC_SCP_CD " ).append("\n"); 
		query.append("        AND CMPN_SEQ = A.CMPN_SEQ " ).append("\n"); 
		query.append("        AND ESVC_TP_SEQ = '2' AND PRC_ESVC_TP_CD = 'E' ) AS PRC_ESVC_TP_CD_E" ).append("\n"); 
		query.append(",   (SELECT DECODE(COUNT(*),0,0,1) AS PRC_ESVC_TP_CD_W FROM PRI_CMPN_ESVC_TP " ).append("\n"); 
		query.append("      WHERE SVC_SCP_CD = A.SVC_SCP_CD " ).append("\n"); 
		query.append("        AND CMPN_SEQ = A.CMPN_SEQ " ).append("\n"); 
		query.append("        AND ESVC_TP_SEQ = '3' AND PRC_ESVC_TP_CD = 'D' ) AS PRC_ESVC_TP_CD_D" ).append("\n"); 
		query.append(",	A.PRC_CTRT_TP_CD" ).append("\n"); 
		query.append(",	DECODE(A.PRC_CTRT_TP_CD,'S', A.SC_NO, A.RFA_NO) SC_NO" ).append("\n"); 
		query.append(",	A.RFA_NO" ).append("\n"); 
		query.append(",	A.CHG_CD" ).append("\n"); 
		query.append(",	A.CURR_CD" ).append("\n"); 
		query.append(",	A.FLT_PCT_TP_CD" ).append("\n"); 
		query.append(",	NVL2(A.CURR_CD,A.DC_AMT,NULL) AS DC_AMT" ).append("\n"); 
		query.append(",   NVL2(A.CURR_CD,NULL,A.DC_AMT) AS DC_PER" ).append("\n"); 
		query.append(",	TO_CHAR(A.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",	TO_CHAR(A.EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append(",	A.CMPN_RMK" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("FROM PRI_CMPN_ESVC A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '') " ).append("\n"); 
		query.append("AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_rgn_cd} != '') " ).append("\n"); 
		query.append("AND A.ORG_RGN_CD = @[org_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dest_rgn_cd} != '') " ).append("\n"); 
		query.append("AND A.DEST_RGN_CD = @[dest_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sc_no} != '') " ).append("\n"); 
		query.append("AND A.RFA_NO LIKE @[sc_no] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${chg_cd} != '') " ).append("\n"); 
		query.append("AND A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eff_dt} != '') " ).append("\n"); 
		query.append("AND TO_DATE(@[eff_dt],'YYYY-MM-DD') BETWEEN A.EFF_DT AND A.EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_ctrt_tp_cd} != '') " ).append("\n"); 
		query.append("AND A.PRC_CTRT_TP_CD = @[prc_ctrt_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}