/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IHCGuideLineDBDAOSearchIHCDgOverWeightFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IHCGuideLineDBDAOSearchIHCDgOverWeightFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.08.01 전윤주 [CHM-201326002] Overweight, DG Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시
	  * </pre>
	  */
	public IHCGuideLineDBDAOSearchIHCDgOverWeightFlagRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ihc_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration").append("\n"); 
		query.append("FileName : IHCGuideLineDBDAOSearchIHCDgOverWeightFlagRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN SPCL_COUNT >= 1 THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END OVR_WGT_CGO_SVC_FLG" ).append("\n"); 
		query.append(" FROM(" ).append("\n"); 
		query.append("    SELECT COUNT(*) SPCL_COUNT" ).append("\n"); 
		query.append("     FROM PRI_TRF_IHC_SPCL_CGO_RT" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("      AND SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("      AND ORG_DEST_TP_CD = @[org_dest_tp_cd]" ).append("\n"); 
		query.append("      AND IHC_TRF_NO = @[ihc_trf_no]" ).append("\n"); 
		query.append("      AND (DCGO_SVC_FLG = 'Y' OR OVR_WGT_CGO_SVC_FLG = 'Y') -- service flag가 Y인 경우만 파란색으로 표시" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}