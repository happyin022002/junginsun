/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOCustomSearchOfficeMappingManagementVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.29
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.11.29 원종규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOCustomSearchOfficeMappingManagementVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Office Mapping 정보 조회
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOCustomSearchOfficeMappingManagementVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cng_ofc_rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cng_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd_rhq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOCustomSearchOfficeMappingManagementVORSQL").append("\n"); 
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
		query.append("OFC_CD," ).append("\n"); 
		query.append("(SELECT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = C.OFC_CD) AS OFC_CD_RHQ," ).append("\n"); 
		query.append("CNG_OFC_CD," ).append("\n"); 
		query.append("(SELECT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = C.CNG_OFC_CD) AS CNG_OFC_RHQ," ).append("\n"); 
		query.append("EFF_DT," ).append("\n"); 
		query.append("EXP_DT," ).append("\n"); 
		query.append("OFC_CNG_RMK," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("CRE_USR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.OFC_CD," ).append("\n"); 
		query.append("A.CNG_OFC_CD," ).append("\n"); 
		query.append("A.EFF_DT," ).append("\n"); 
		query.append("A.EXP_DT," ).append("\n"); 
		query.append("A.OFC_CNG_RMK," ).append("\n"); 
		query.append("A.DELT_FLG," ).append("\n"); 
		query.append("A.UPD_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("A.CRE_DT," ).append("\n"); 
		query.append("A.CRE_USR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("joo_cng_ofc A" ).append("\n"); 
		query.append("#if (${ofc_cd_rhq} != '' || ${cng_ofc_rhq} != '')" ).append("\n"); 
		query.append(",MDM_ORGANIZATION B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("1=1" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cng_ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.CNG_OFC_CD = @[cng_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd_rhq} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND B.AR_HD_QTR_OFC_CD = @[ofc_cd_rhq]" ).append("\n"); 
		query.append("#elseif (${cng_ofc_rhq} != '')" ).append("\n"); 
		query.append("AND A.CNG_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND B.AR_HD_QTR_OFC_CD = @[cng_ofc_rhq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != 'A')" ).append("\n"); 
		query.append("AND A.DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") C" ).append("\n"); 

	}
}