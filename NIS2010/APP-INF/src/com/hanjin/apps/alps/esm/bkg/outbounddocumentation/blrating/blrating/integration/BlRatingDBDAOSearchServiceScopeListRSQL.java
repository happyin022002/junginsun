/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BlRatingDBDAOSearchServiceScopeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.11
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2014.09.11 김진주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jin Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchServiceScopeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG 에 해당되는 Service Scope 목록을 조회
	  * </pre>
	  */
	public BlRatingDBDAOSearchServiceScopeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchServiceScopeListRSQL").append("\n"); 
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
		query.append("SELECT T.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT SVC_SCP_CD FROM ( " ).append("\n"); 
		query.append("  SELECT A.SVC_SCP_CD  ,'A' A" ).append("\n"); 
		query.append("  FROM MDM_SVC_SCP  A, BKG_BKG_HIS B " ).append("\n"); 
		query.append("    WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("    AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND B.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("    AND 'N' = @[ca_flg]" ).append("\n"); 
		query.append("    AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("  UNION" ).append("\n"); 
		query.append("  SELECT a.svc_scp_cd ,'B' B" ).append("\n"); 
		query.append("  FROM mdm_svc_scp_lmt a" ).append("\n"); 
		query.append("      ,mdm_svc_scp_lmt b" ).append("\n"); 
		query.append("      ,mdm_svc_scp c" ).append("\n"); 
		query.append(" WHERE a.svc_scp_cd = b.svc_scp_cd" ).append("\n"); 
		query.append("   AND a.svc_scp_cd = c.svc_scp_cd" ).append("\n"); 
		query.append("   AND c.delt_flg = 'N'" ).append("\n"); 
		query.append("   AND a.org_dest_cd = 'O'" ).append("\n"); 
		query.append("   AND a.delt_flg = 'N'" ).append("\n"); 
		query.append("   AND a.svc_scp_ind_flg ='Y'" ).append("\n"); 
		query.append("   AND a.rgn_cd IN (SELECT rgn_cd" ).append("\n"); 
		query.append("                     FROM mdm_location" ).append("\n"); 
		query.append("                     WHERE loc_cd = (select POR_CD from BKG_BKG_HIS where BKG_NO = @[bkg_no] and 'Y' = @[ca_flg] and CORR_NO = 'TMP0000001')) -- BKG POR_CD" ).append("\n"); 
		query.append("   AND b.org_dest_cd = 'D'" ).append("\n"); 
		query.append("   AND b.delt_flg = 'N'" ).append("\n"); 
		query.append("   AND b.svc_scp_ind_flg ='Y'" ).append("\n"); 
		query.append("   AND b.rgn_cd IN (SELECT rgn_cd" ).append("\n"); 
		query.append("                    FROM mdm_location" ).append("\n"); 
		query.append("                    WHERE loc_cd = (select DEL_CD from BKG_BKG_HIS where BKG_NO =@[bkg_no] and 'Y' = @[ca_flg] and CORR_NO = 'TMP0000001') ) -- BKG DEL_CD" ).append("\n"); 
		query.append("    ORDER BY A)" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("SELECT T.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT SVC_SCP_CD FROM ( " ).append("\n"); 
		query.append("  SELECT A.SVC_SCP_CD  ,'A' A" ).append("\n"); 
		query.append("  FROM MDM_SVC_SCP  A, BKG_BOOKING B " ).append("\n"); 
		query.append("    WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("    AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("    AND B.BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("    AND 'N' = @[ca_flg]" ).append("\n"); 
		query.append("  UNION" ).append("\n"); 
		query.append("  SELECT a.svc_scp_cd ,'B' B" ).append("\n"); 
		query.append("  FROM mdm_svc_scp_lmt a" ).append("\n"); 
		query.append("      ,mdm_svc_scp_lmt b" ).append("\n"); 
		query.append("      ,mdm_svc_scp c" ).append("\n"); 
		query.append(" WHERE a.svc_scp_cd = b.svc_scp_cd" ).append("\n"); 
		query.append("   AND a.svc_scp_cd = c.svc_scp_cd" ).append("\n"); 
		query.append("   AND c.delt_flg = 'N'" ).append("\n"); 
		query.append("   AND a.org_dest_cd = 'O'" ).append("\n"); 
		query.append("   AND a.delt_flg = 'N'" ).append("\n"); 
		query.append("   AND a.svc_scp_ind_flg ='Y'" ).append("\n"); 
		query.append("   AND a.rgn_cd IN (SELECT rgn_cd" ).append("\n"); 
		query.append("                     FROM mdm_location" ).append("\n"); 
		query.append("                     WHERE loc_cd = (select POR_CD from BKG_BOOKING where BKG_NO = @[bkg_no] and 'N' = @[ca_flg])) -- BKG POR_CD" ).append("\n"); 
		query.append("   AND b.org_dest_cd = 'D'" ).append("\n"); 
		query.append("   AND b.delt_flg = 'N'" ).append("\n"); 
		query.append("   AND b.svc_scp_ind_flg ='Y'" ).append("\n"); 
		query.append("   AND b.rgn_cd IN (SELECT rgn_cd" ).append("\n"); 
		query.append("                    FROM mdm_location" ).append("\n"); 
		query.append("                    WHERE loc_cd = (select DEL_CD from BKG_BOOKING where BKG_NO =@[bkg_no] and 'N' = @[ca_flg]) ) -- BKG DEL_CD" ).append("\n"); 
		query.append("    ORDER BY A)" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}