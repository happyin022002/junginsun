/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonCodeDBDAOSearchOfficeLevelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2011.02.22 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JongGeonByeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchOfficeLevelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfficeLevel
	  * </pre>
	  */
	public CommonCodeDBDAOSearchOfficeLevelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchOfficeLevelRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT OFFICE_LEVEL," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("RHQ_CD," ).append("\n"); 
		query.append("HO_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("----- HO -----" ).append("\n"); 
		query.append("SELECT 'H' OFFICE_LEVEL, OFC_CD, NULL AS RHQ_CD, OFC_CD HO_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND OFC_KND_CD = '1'" ).append("\n"); 
		query.append("AND OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("-----" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("----- RHQ -----" ).append("\n"); 
		query.append("SELECT DISTINCT 'R' AS OFFICE_LEVEL," ).append("\n"); 
		query.append("DECODE(PRNT_OFC_CD, ( SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE OFC_GRP_ID='000001' AND  SUB_SYS_CD='TPB' ), OFC_CD, PRNT_OFC_CD) AS OFC_CD," ).append("\n"); 
		query.append("DECODE(PRNT_OFC_CD, ( SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE OFC_GRP_ID='000001' AND  SUB_SYS_CD='TPB' ), OFC_CD, PRNT_OFC_CD) AS RHQ_CD," ).append("\n"); 
		query.append("NULL AS HO_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND OFC_KND_CD = '2'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("AND OFC_CD != ( SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE OFC_GRP_ID='000002' AND  SUB_SYS_CD='TPB' )" ).append("\n"); 
		query.append("-----" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("----- RHQ - SINWA -----" ).append("\n"); 
		query.append("SELECT DISTINCT 'R' AS OFFICE_LEVEL," ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("OFC_CD RHQ_CD," ).append("\n"); 
		query.append("NULL AS HO_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND OFC_KND_CD = '2'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("AND OFC_CD = ( SELECT OFC_CD FROM MDM_OFC_GRP_MAPG WHERE OFC_GRP_ID='000002' AND  SUB_SYS_CD='TPB' )" ).append("\n"); 
		query.append("-----" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("----- GO 1 -----" ).append("\n"); 
		query.append("SELECT 'G' OFFICE_LEVEL, N3PTY_OFC_CD, RHQ_CD, NULL AS HO_CD" ).append("\n"); 
		query.append("FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("WHERE N3PTY_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 

	}
}