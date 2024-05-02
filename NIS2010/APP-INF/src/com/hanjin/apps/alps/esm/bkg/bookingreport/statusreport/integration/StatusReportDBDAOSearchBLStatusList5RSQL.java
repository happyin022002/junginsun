/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLStatusList5RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBLStatusList5RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SVC Scope 조회
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLStatusList5RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLStatusList5RSQL").append("\n"); 
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
		query.append("    CASE WHEN BKG.POR_CD = BKG.DEL_CD AND BKG.SVC_SCP_CD IS NULL " ).append("\n"); 
		query.append("			THEN" ).append("\n"); 
		query.append("			( " ).append("\n"); 
		query.append("              SELECT " ).append("\n"); 
		query.append("			      SUBSTR (MAX (SYS_CONNECT_BY_PATH (SVC_SCP_CD, '$')), 2)   AS SVC_SCP_CD" ).append("\n"); 
		query.append("			  FROM  (" ).append("\n"); 
		query.append("					  SELECT " ).append("\n"); 
		query.append("					  	ROWNUM AS RID, T.* " ).append("\n"); 
		query.append("					  FROM (" ).append("\n"); 
		query.append("				            SELECT A.SVC_SCP_CD||'-'||A.SVC_SCP_NM  AS SVC_SCP_CD " ).append("\n"); 
		query.append("							FROM MDM_SVC_SCP  A WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("				           ) T" ).append("\n"); 
		query.append("					)   " ).append("\n"); 
		query.append("				START WITH  RID =  1" ).append("\n"); 
		query.append("				CONNECT BY PRIOR RID + 1 = RID   " ).append("\n"); 
		query.append("			 )" ).append("\n"); 
		query.append("	 ELSE " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("        SUBSTR (MAX (SYS_CONNECT_BY_PATH (SVC_SCP_CD, '$')), 2)   AS SVC_SCP_CD" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                ROWNUM AS RID, T.* " ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("             SELECT DISTINCT SVC_SCP_CD FROM (SELECT A.SVC_SCP_CD ||'-'||C.SVC_SCP_NM AS SVC_SCP_CD" ).append("\n"); 
		query.append("                    ,'A' A" ).append("\n"); 
		query.append("             FROM BKG_BOOKING A,MDM_SVC_SCP C " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("             AND A.svc_scp_cd = C.svc_scp_cd" ).append("\n"); 
		query.append("             UNION" ).append("\n"); 
		query.append("             SELECT a.svc_scp_cd ||'-'||c.svc_scp_nm as SVC_SCP_CD" ).append("\n"); 
		query.append("                    ,'B' B" ).append("\n"); 
		query.append("             FROM mdm_svc_scp_lmt a" ).append("\n"); 
		query.append("                 ,mdm_svc_scp_lmt b" ).append("\n"); 
		query.append("                 ,mdm_svc_scp c" ).append("\n"); 
		query.append("             WHERE a.svc_scp_cd = b.svc_scp_cd" ).append("\n"); 
		query.append("             AND a.svc_scp_cd = c.svc_scp_cd" ).append("\n"); 
		query.append("             AND c.delt_flg = 'N'" ).append("\n"); 
		query.append("             AND a.org_dest_cd = 'O'" ).append("\n"); 
		query.append("             AND a.delt_flg = 'N'" ).append("\n"); 
		query.append("             AND a.svc_scp_ind_flg ='Y'" ).append("\n"); 
		query.append("             AND a.rgn_cd IN (SELECT rgn_cd" ).append("\n"); 
		query.append("             FROM mdm_location" ).append("\n"); 
		query.append("             WHERE loc_cd = (select POR_CD from BKG_BOOKING where BKG_NO = @[bkg_no] ))  -- BKG POR_CD" ).append("\n"); 
		query.append("             AND b.org_dest_cd = 'D'" ).append("\n"); 
		query.append("             AND b.delt_flg = 'N'" ).append("\n"); 
		query.append("             AND b.svc_scp_ind_flg ='Y'" ).append("\n"); 
		query.append("             AND b.rgn_cd IN (SELECT rgn_cd" ).append("\n"); 
		query.append("             FROM mdm_location" ).append("\n"); 
		query.append("             WHERE loc_cd = (select DEL_CD from BKG_BOOKING where BKG_NO = @[bkg_no] ) ) -- BKG DEL_CD" ).append("\n"); 
		query.append("             ORDER BY A)            " ).append("\n"); 
		query.append("            ) T" ).append("\n"); 
		query.append("        )   " ).append("\n"); 
		query.append("        START WITH  RID =  1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR RID + 1 = RID   " ).append("\n"); 
		query.append("    ) END SVC_SCP_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    BKG_BOOKING BKG, MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND  BKG.POR_CD = L.LOC_CD" ).append("\n"); 
		query.append("	AND  L.DELT_FLG ='N'" ).append("\n"); 

	}
}