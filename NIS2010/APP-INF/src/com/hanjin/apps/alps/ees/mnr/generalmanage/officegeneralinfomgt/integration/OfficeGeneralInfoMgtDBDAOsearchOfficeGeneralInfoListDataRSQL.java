/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OfficeGeneralInfoMgtDBDAOsearchOfficeGeneralInfoListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.02.17 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeGeneralInfoMgtDBDAOsearchOfficeGeneralInfoListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select searchOfficeGeneralInfolst
	  * </pre>
	  */
	public OfficeGeneralInfoMgtDBDAOsearchOfficeGeneralInfoListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.integration").append("\n"); 
		query.append("FileName : OfficeGeneralInfoMgtDBDAOsearchOfficeGeneralInfoListDataRSQL").append("\n"); 
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
		query.append("C.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append(",	A.OFC_CD AS OFC_CD" ).append("\n"); 
		query.append(",	A.MNR_GRP_TP_CD" ).append("\n"); 
		query.append(",	A.COST_CD" ).append("\n"); 
		query.append(",	A.EQ_KND_CD" ).append("\n"); 
		query.append(",	A.UPPR_OFC_CD" ).append("\n"); 
		query.append(",   TO_CHAR(A.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",	A.CURR_CD" ).append("\n"); 
		query.append(",	A.BFR_AUTO_APRO_AMT" ).append("\n"); 
		query.append(",	A.BFR_SELF_AUTH_AMT" ).append("\n"); 
		query.append(",	A.AFT_AUTO_APRO_AMT" ).append("\n"); 
		query.append(",	A.AFT_SELF_AUTH_AMT" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.OFC_CD AS ORG_OFC_CD" ).append("\n"); 
		query.append(",   A.MNR_GRP_TP_CD AS ORG_MNR_GRP_TP_CD" ).append("\n"); 
		query.append(",	A.COST_CD AS ORG_COST_CD" ).append("\n"); 
		query.append(",	A.OFC_CD AS ORG_OFC_CD" ).append("\n"); 
		query.append(",	A.MNR_GRP_TP_CD AS ORG_MNR_GRP_TP_CD" ).append("\n"); 
		query.append(",	A.COST_CD AS ORG_COST_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_ORGANIZATION C , MNR_OFC_GEN_INFO A" ).append("\n"); 
		query.append("WHERE A.MNR_GRP_TP_CD = @[mnr_grp_tp_cd]" ).append("\n"); 
		query.append("AND C.AR_HD_QTR_OFC_CD LIKE '%'|| NVL(@[ar_hd_qtr_ofc_cd], '') ||'%'" ).append("\n"); 
		query.append("AND A.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND A.OFC_CD LIKE  '%'|| NVL(@[ofc_cd], '') ||'%'" ).append("\n"); 
		query.append("AND A.COST_CD LIKE '%'|| NVL(@[cost_cd], '') ||'%'" ).append("\n"); 

	}
}