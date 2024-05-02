/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortLimitManagmentDBDAOSearchPortLimitsDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortLimitManagmentDBDAOSearchPortLimitsDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 관리 Port별 Port Limits Creation 정보를 조회한다.
	  * </pre>
	  */
	public PortLimitManagmentDBDAOSearchPortLimitsDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("un_loc_cd_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.portlimitmanagement.integration").append("\n"); 
		query.append("FileName : PortLimitManagmentDBDAOSearchPortLimitsDataRSQL").append("\n"); 
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
		query.append("WITH UNNO_T AS (" ).append("\n"); 
		query.append("    SELECT PORT_CD, " ).append("\n"); 
		query.append("    			 --LMT_WGT_TP_CD, " ).append("\n"); 
		query.append("    		   PORT_LMT_SEQ," ).append("\n"); 
		query.append("           substr(xmlagg(xmlelement(a, DECODE(IMDG_UN_NO, '', '', ',') || IMDG_UN_NO)" ).append("\n"); 
		query.append("                                        order by IMDG_UN_NO).extract('//text()'), 2) AS IMDG_UN_NO" ).append("\n"); 
		query.append("      FROM SCG_IMDG_PORT_LMT_UN_NO" ).append("\n"); 
		query.append("    GROUP BY PORT_CD, " ).append("\n"); 
		query.append("    			   --LMT_WGT_TP_CD, " ).append("\n"); 
		query.append("    			   PORT_LMT_SEQ" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("     CLSCOMP_T AS (" ).append("\n"); 
		query.append("      SELECT A.PORT_CD, " ).append("\n"); 
		query.append("      			 --A.LMT_WGT_TP_CD, " ).append("\n"); 
		query.append("      			 A.PORT_LMT_SEQ," ).append("\n"); 
		query.append("                 substr(xmlagg(xmlelement(a, DECODE(A.CLSS_COMP, '', '', ',') || A.CLSS_COMP)" ).append("\n"); 
		query.append("                              order by A.CLSS_COMP).extract('//text()'), 2) AS CLSS_COMP" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT A.PORT_CD, " ).append("\n"); 
		query.append("                    	   --A.LMT_WGT_TP_CD, " ).append("\n"); 
		query.append("                    	   A.PORT_LMT_SEQ," ).append("\n"); 
		query.append("                           A.IMDG_CLSS_CD, B.IMDG_COMP_GRP_CD, A.IMDG_CLSS_CD|| B.IMDG_COMP_GRP_CD AS CLSS_COMP" ).append("\n"); 
		query.append("                      FROM SCG_IMDG_PORT_LMT_CLSS_CD A, " ).append("\n"); 
		query.append("                                SCG_IMDG_PORT_LMT_COMP_GRP B" ).append("\n"); 
		query.append("                     WHERE A.PORT_CD = B.PORT_CD(+)" ).append("\n"); 
		query.append("                        --AND A.LMT_WGT_TP_CD = B.LMT_WGT_TP_CD(+)" ).append("\n"); 
		query.append("					   AND A.PORT_LMT_SEQ = B.PORT_LMT_SEQ(+) " ).append("\n"); 
		query.append("					   AND A.IMDG_CLSS_CD = B.IMDG_CLSS_CD(+)" ).append("\n"); 
		query.append("					   --AND A.PORT_LMT_CLSS_SEQ = B.PORT_LMT_CLSS_SEQ(+)" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("    GROUP BY A.PORT_CD, " ).append("\n"); 
		query.append("    		 --A.LMT_WGT_TP_CD, " ).append("\n"); 
		query.append("    		 A.PORT_LMT_SEQ" ).append("\n"); 
		query.append("    		 --,A.PORT_LMT_CLSS_SEQ" ).append("\n"); 
		query.append("), SUBRSK_T AS (" ).append("\n"); 
		query.append("    SELECT PORT_CD, " ).append("\n"); 
		query.append("           PORT_LMT_SEQ," ).append("\n"); 
		query.append("           substr(xmlagg(xmlelement(a, DECODE(IMDG_SUBS_RSK_LBL_CD, '', '', ',') || IMDG_SUBS_RSK_LBL_CD)" ).append("\n"); 
		query.append("                                              order by IMDG_SUBS_RSK_LBL_CD).extract('//text()'), 2) AS IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("      FROM SCG_IMDG_PORT_LMT_SUBS_RSK" ).append("\n"); 
		query.append("    GROUP BY PORT_CD, " ).append("\n"); 
		query.append("             PORT_LMT_SEQ      " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  A.DP_SEQ" ).append("\n"); 
		query.append("		   ,A.PORT_LMT_SEQ" ).append("\n"); 
		query.append("           ,A.PORT_CD" ).append("\n"); 
		query.append("           ,A.PIER_TP_CD" ).append("\n"); 
		query.append("           ,A.LMT_WGT_TP_CD" ).append("\n"); 
		query.append("           ,A.PORT_LMT_REP_DESC" ).append("\n"); 
		query.append("           ,(" ).append("\n"); 
		query.append("              CASE WHEN LENGTH(D.IMDG_SUBS_RSK_LBL_CD) >= 7" ).append("\n"); 
		query.append("                       THEN RPAD( SUBSTR(D.IMDG_SUBS_RSK_LBL_CD, 0, 7), 9, '.')" ).append("\n"); 
		query.append("                       ELSE D.IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("           ) AS V_IMDG_SUBS_RSK_LBL_CD " ).append("\n"); 
		query.append("           ,A.CMDT_CD" ).append("\n"); 
		query.append("           ,A.IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("           ,A.CNTR_TP_CD" ).append("\n"); 
		query.append("           ,A.ARR_DEP_PROHI_FLG" ).append("\n"); 
		query.append("           ,A.ARR_MAX_QTY" ).append("\n"); 
		query.append("           ,A.DEP_MAX_QTY" ).append("\n"); 
		query.append("           ,A.LDIS_APLY_TGT_FLG" ).append("\n"); 
		query.append("           ,A.LOD_MAX_QTY" ).append("\n"); 
		query.append("           ,A.DCHG_MAX_QTY" ).append("\n"); 
		query.append("           ,A.PORT_LMT_SUB_PPT_CD" ).append("\n"); 
		query.append("           ,A.FLSH_PNT_TEMP" ).append("\n"); 
		query.append("           ,A.PPT_EXPLO_FLG" ).append("\n"); 
		query.append("           ,DECODE(A.PPT_PROHI_FLG, 'Y', 'P', A.PPT_PROHI_FLG) AS PPT_PROHI_FLG" ).append("\n"); 
		query.append("           ,( DECODE(C.CLSS_COMP, NULL, '', ( CASE WHEN LENGTH(C.CLSS_COMP) >= 23" ).append("\n"); 
		query.append("                                                                       THEN RPAD( SUBSTR(C.CLSS_COMP, 0, 23), 25, '.')" ).append("\n"); 
		query.append("                                                                       ELSE C.CLSS_COMP" ).append("\n"); 
		query.append("                                                                 END" ).append("\n"); 
		query.append("                                                              )" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("            ||DECODE(C.CLSS_COMP, NULL, '', chr(10))" ).append("\n"); 
		query.append("            || CASE WHEN LENGTH(B.IMDG_UN_NO) >= 23" ).append("\n"); 
		query.append("                           THEN RPAD( SUBSTR(B.IMDG_UN_NO, 0, 23), 25, '.')" ).append("\n"); 
		query.append("                           ELSE B.IMDG_UN_NO" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("           ) AS V_CLSS_INFO" ).append("\n"); 
		query.append("           ,A.YD_CD" ).append("\n"); 
		query.append("           ,A.LOD_MAX_TEU_QTY" ).append("\n"); 
		query.append("           ,A.DCHG_MAX_TEU_QTY" ).append("\n"); 
		query.append("  FROM  SCG_IMDG_PORT_LMT_MST A," ).append("\n"); 
		query.append("             UNNO_T B," ).append("\n"); 
		query.append("             CLSCOMP_T C," ).append("\n"); 
		query.append("			 SUBRSK_T D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${un_loc_cd_flg} != '') " ).append("\n"); 
		query.append("   AND A.PORT_CD = DECODE(@[un_loc_cd_flg], 'S', 'SGSIN', 'J', 'SAJED', 'L', 'FRLEH', 'C', 'CNSHA')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND A.PORT_CD = B.PORT_CD(+)" ).append("\n"); 
		query.append("     --AND A.LMT_WGT_TP_CD = B.LMT_WGT_TP_CD(+)" ).append("\n"); 
		query.append("     AND A.PORT_LMT_SEQ = B.PORT_LMT_SEQ(+)" ).append("\n"); 
		query.append("     AND A.PORT_CD = C.PORT_CD(+)" ).append("\n"); 
		query.append("     --AND A.LMT_WGT_TP_CD = C.LMT_WGT_TP_CD(+)" ).append("\n"); 
		query.append("     AND A.PORT_LMT_SEQ = C.PORT_LMT_SEQ(+) " ).append("\n"); 
		query.append("     AND A.PORT_CD = D.PORT_CD(+)" ).append("\n"); 
		query.append("     AND A.PORT_LMT_SEQ = D.PORT_LMT_SEQ(+)" ).append("\n"); 
		query.append(" ORDER BY A.DP_SEQ, A.CRE_DT DESC" ).append("\n"); 

	}
}