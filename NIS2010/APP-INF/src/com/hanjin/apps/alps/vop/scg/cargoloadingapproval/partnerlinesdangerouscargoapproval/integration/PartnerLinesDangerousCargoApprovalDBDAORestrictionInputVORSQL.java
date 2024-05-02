/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAORestrictionInputVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.12
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.06.12 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerLinesDangerousCargoApprovalDBDAORestrictionInputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Restrictions 화면의 Port Restrictions En-route 목록을 가져온다.
	  * </pre>
	  */
	public PartnerLinesDangerousCargoApprovalDBDAORestrictionInputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : PartnerLinesDangerousCargoApprovalDBDAORestrictionInputVORSQL").append("\n"); 
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
		query.append("WITH PORT_RSTR_TBL1 AS ( " ).append("\n"); 
		query.append("		SELECT RR.PROHI_LOD_FLG " ).append("\n"); 
		query.append("      	     , RR.PROHI_DCHG_FLG " ).append("\n"); 
		query.append("             , RR.PROHI_TS_FLG" ).append("\n"); 
		query.append("      	     , RR.PROHI_PASS_FLG " ).append("\n"); 
		query.append("      	     , RR.PORT_CD " ).append("\n"); 
		query.append("		     , RR.IMDG_UN_NO " ).append("\n"); 
		query.append("		     , RR.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("		     , RR.IMDG_CLSS_CD " ).append("\n"); 
		query.append("		     , RR.IMDG_PORT_RSTR_SEQ " ).append("\n"); 
		query.append("		  FROM SCG_IMDG_PORT_RSTR RR " ).append("\n"); 
		query.append("		 WHERE RR.IMDG_UN_NO     = @[imdg_un_no] " ).append("\n"); 
		query.append("		   AND RR.IMDG_UN_NO_SEQ = @[imdg_un_no_seq] " ).append("\n"); 
		query.append("		   AND RR.IMDG_CLSS_CD   = @[imdg_clss_cd] " ).append("\n"); 
		query.append("		), " ).append("\n"); 
		query.append("PORT_RSTR_TBL2 AS ( " ).append("\n"); 
		query.append("		SELECT CC.PROHI_LOD_FLG " ).append("\n"); 
		query.append("    		 , CC.PROHI_DCHG_FLG " ).append("\n"); 
		query.append("             , CC.PROHI_TS_FLG" ).append("\n"); 
		query.append("    		 , CC.PROHI_PASS_FLG " ).append("\n"); 
		query.append("    		 , CC.PORT_CD " ).append("\n"); 
		query.append("    		 , CC.IMDG_UN_NO " ).append("\n"); 
		query.append("    		 , CC.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("    		 , CC.IMDG_CLSS_CD " ).append("\n"); 
		query.append("    		 , CC.IMDG_PORT_RSTR_SEQ " ).append("\n"); 
		query.append("		  FROM SCG_IMDG_PORT_RSTR CC " ).append("\n"); 
		query.append("		 WHERE CC.IMDG_CLSS_CD   = @[imdg_clss_cd]" ).append("\n"); 
		query.append("		   AND CC.IMDG_UN_NO     IS NULL " ).append("\n"); 
		query.append("		   AND CC.IMDG_UN_NO_SEQ IS NULL " ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("BKG_VVD_TBL AS " ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("SELECT '' BKG_NO" ).append("\n"); 
		query.append("     , 'T' VSL_PRE_PST_CD" ).append("\n"); 
		query.append("     , 0 VSL_SEQ" ).append("\n"); 
		query.append("     , VP.SLAN_CD" ).append("\n"); 
		query.append("     , VP.VSL_CD" ).append("\n"); 
		query.append("     , VP.SKD_VOY_NO" ).append("\n"); 
		query.append("     , VP.SKD_DIR_CD" ).append("\n"); 
		query.append("     , MAX(DECODE(VP.PORT_CD,@[pol_port_cd],VP.PORT_CD,'')) POL_CD " ).append("\n"); 
		query.append("     , MAX(DECODE(VP.PORT_CD,@[pod_port_cd],VP.PORT_CD,'')) POD_CD " ).append("\n"); 
		query.append("     , SUM(DECODE(VP.PORT_CD,@[pol_port_cd],VP.CLPT_SEQ, 0)) POL_SEQ" ).append("\n"); 
		query.append("     , SUM(DECODE(VP.PORT_CD,@[pod_port_cd],VP.CLPT_SEQ, 0)) POD_SEQ" ).append("\n"); 
		query.append("  FROM SCG_VSL_PORT_SKD VP" ).append("\n"); 
		query.append(" WHERE VP.PORT_CD IN(@[pol_port_cd],@[pod_port_cd])" ).append("\n"); 
		query.append("   AND VP.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND VP.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND VP.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND VP.SLAN_CD    = @[slan_cd]" ).append("\n"); 
		query.append(" GROUP BY" ).append("\n"); 
		query.append("       VP.SLAN_CD" ).append("\n"); 
		query.append("     , VP.VSL_CD" ).append("\n"); 
		query.append("     , VP.SKD_VOY_NO" ).append("\n"); 
		query.append("     , VP.SKD_DIR_CD" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("ROUTE_TBL AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TVP2.PORT_CD" ).append("\n"); 
		query.append("     , TVP2.ORDER_NUM1 ORDER_NUM1" ).append("\n"); 
		query.append("     , TVP2.ORDER_NUM2 ORDER_NUM2" ).append("\n"); 
		query.append("     , DECODE(TVP2.PASS_FLG,'S','S', DECODE(TVP2.POL_SEQ,1,'L',DECODE(TVP2.POD_SEQ,1,'D',DECODE(TVP2.PORT_CD,TVP2.POD_CD,'T','P')))) PORT_TYPE" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("      SELECT TVP1.PORT_CD" ).append("\n"); 
		query.append("           , TVP1.POD_CD" ).append("\n"); 
		query.append("           , TVP1.ORDER_NUM1" ).append("\n"); 
		query.append("           , TVP1.ORDER_NUM2" ).append("\n"); 
		query.append("           , TVP1.PASS_FLG" ).append("\n"); 
		query.append("           , RANK() OVER(ORDER BY TVP1.ORDER_NUM1, TVP1.ORDER_NUM2)                              POL_SEQ" ).append("\n"); 
		query.append("           , DENSE_RANK() OVER(ORDER BY TVP1.ORDER_NUM1 DESC, TVP1.ORDER_NUM2 DESC)              POD_SEQ" ).append("\n"); 
		query.append("           , ROW_NUMBER() OVER(PARTITION BY TVP1.PORT_CD ORDER BY TVP1.PORT_CD, TVP1.ORDER_NUM1) TS_DUP_NUM" ).append("\n"); 
		query.append("        FROM " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("             SELECT VPS.PORT_CD AS              PORT_CD" ).append("\n"); 
		query.append("                  , VT1.POD_CD                 " ).append("\n"); 
		query.append("                  , VT1.VSL_PRE_PST_CD||VT1.VSL_SEQ ORDER_NUM1 " ).append("\n"); 
		query.append("                  , 1                               ORDER_NUM2" ).append("\n"); 
		query.append("                  , 'X'                             PASS_FLG" ).append("\n"); 
		query.append("              FROM SCG_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                 , BKG_VVD_TBL      VT1   " ).append("\n"); 
		query.append("             WHERE VT1.VSL_CD IS NULL" ).append("\n"); 
		query.append("               AND (VPS.PORT_CD = VT1.POL_CD" ).append("\n"); 
		query.append("                OR VPS.PORT_CD = VT1.POD_CD)   " ).append("\n"); 
		query.append("             GROUP BY" ).append("\n"); 
		query.append("                   VPS.PORT_CD" ).append("\n"); 
		query.append("                 , VT1.POD_CD                 " ).append("\n"); 
		query.append("                 , VT1.VSL_PRE_PST_CD||VT1.VSL_SEQ" ).append("\n"); 
		query.append("             ) TVP1" ).append("\n"); 
		query.append("       ) TVP2" ).append("\n"); 
		query.append(" WHERE TVP2.TS_DUP_NUM = 1" ).append("\n"); 
		query.append(" ORDER BY TVP2.ORDER_NUM1, TVP2.ORDER_NUM2" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TT.PORT_TYPE" ).append("\n"); 
		query.append("     , TT.PORT_CD" ).append("\n"); 
		query.append("     , TT.IMDG_CMPTN_AUTH_CD" ).append("\n"); 
		query.append("     , TT.TXT_DESC" ).append("\n"); 
		query.append("  FROM ( " ).append("\n"); 
		query.append("		SELECT ST.PORT_TYPE " ).append("\n"); 
		query.append("    		 , ST.PORT_CD " ).append("\n"); 
		query.append("    		 , ST.IMDG_CMPTN_AUTH_CD" ).append("\n"); 
		query.append("    		 , ST.TXT_DESC " ).append("\n"); 
		query.append("    		 , ST.IMDG_UN_NO " ).append("\n"); 
		query.append("    		 , ST.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("    		 , ST.ORDER_NUM1" ).append("\n"); 
		query.append("             , ST.ORDER_NUM2" ).append("\n"); 
		query.append("		  FROM ( " ).append("\n"); 
		query.append("		    SELECT DECODE(RT.PORT_TYPE,'S','Skip','L','POL','D','POD','T','T/S','Pass') PORT_TYPE " ).append("\n"); 
		query.append("		         , RT.PORT_CD " ).append("\n"); 
		query.append("        		 , DECODE(RT.PORT_TYPE,'S',''," ).append("\n"); 
		query.append("                   DECODE( " ).append("\n"); 
		query.append("        		          DECODE(RT.PORT_TYPE,'L', " ).append("\n"); 
		query.append("        		                 DECODE(R.PROHI_LOD_FLG,'Y','Prohibition', " ).append("\n"); 
		query.append("        		                        DECODE(LD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need') " ).append("\n"); 
		query.append("        		                 ),'D', " ).append("\n"); 
		query.append("        		                 DECODE(R.PROHI_DCHG_FLG,'Y','Prohibition', " ).append("\n"); 
		query.append("        		                        DECODE(DD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need') " ).append("\n"); 
		query.append("        		                 ),'T', " ).append("\n"); 
		query.append("        		                 DECODE(R.PROHI_TS_FLG,'Y','Prohibition', " ).append("\n"); 
		query.append("        		                        DECODE(TD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need') " ).append("\n"); 
		query.append("        		                 ), " ).append("\n"); 
		query.append("        		                 DECODE(R.PROHI_PASS_FLG,'Y','Prohibition', " ).append("\n"); 
		query.append("        		                        DECODE(PD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need') " ).append("\n"); 
		query.append("        		                 ) " ).append("\n"); 
		query.append("        		                 ),NULL, " ).append("\n"); 
		query.append("        		                 DECODE(RT.PORT_TYPE,'L', " ).append("\n"); 
		query.append("        		                        DECODE(C.PROHI_LOD_FLG,'Y','Prohibition', " ).append("\n"); 
		query.append("        		                               DECODE(LC.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need') " ).append("\n"); 
		query.append("        		                        ),'D', " ).append("\n"); 
		query.append("        		                        DECODE(C.PROHI_DCHG_FLG,'Y','Prohibition', " ).append("\n"); 
		query.append("        		                               DECODE(DC.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need') " ).append("\n"); 
		query.append("        		                        ),'T', " ).append("\n"); 
		query.append("        		                        DECODE(C.PROHI_TS_FLG,'Y','Prohibition', " ).append("\n"); 
		query.append("        		                               DECODE(TC.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need') " ).append("\n"); 
		query.append("        		                        ), " ).append("\n"); 
		query.append("        		                        DECODE(C.PROHI_PASS_FLG,'Y','Prohibition', " ).append("\n"); 
		query.append("        		                               DECODE(PC.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need') " ).append("\n"); 
		query.append("        		                        ) " ).append("\n"); 
		query.append("        		                        ), " ).append("\n"); 
		query.append("        		                        DECODE(RT.PORT_TYPE,'L', " ).append("\n"); 
		query.append("        		                               DECODE(R.PROHI_LOD_FLG,'Y','Prohibition', " ).append("\n"); 
		query.append("        		                                      DECODE(LD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need') " ).append("\n"); 
		query.append("        		                               ),'D', " ).append("\n"); 
		query.append("        		                               DECODE(R.PROHI_DCHG_FLG,'Y','Prohibition', " ).append("\n"); 
		query.append("        		                                      DECODE(DD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need') " ).append("\n"); 
		query.append("        		                               ),'T', " ).append("\n"); 
		query.append("        		                               DECODE(R.PROHI_TS_FLG,'Y','Prohibition', " ).append("\n"); 
		query.append("        		                                      DECODE(TD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need') " ).append("\n"); 
		query.append("        		                               ), " ).append("\n"); 
		query.append("        		                               DECODE(R.PROHI_PASS_FLG,'Y','Prohibition', " ).append("\n"); 
		query.append("        		                                      DECODE(PD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need') " ).append("\n"); 
		query.append("        		                               ) " ).append("\n"); 
		query.append("        		                        ) " ).append("\n"); 
		query.append("        		  )" ).append("\n"); 
		query.append("                  ) IMDG_CMPTN_AUTH_CD" ).append("\n"); 
		query.append("        		, DECODE(RT.PORT_TYPE,'S','',DECODE(RT.PORT_TYPE ,'L'," ).append("\n"); 
		query.append("                                                    DECODE(R.PROHI_LOD_FLG,NULL,LC.TXT_DESC,LD.TXT_DESC" ).append("\n"); 
		query.append("                                                    ),'D'," ).append("\n"); 
		query.append("                                                    DECODE(R.PROHI_DCHG_FLG,NULL,DC.TXT_DESC,DD.TXT_DESC" ).append("\n"); 
		query.append("                                                    ),'T'," ).append("\n"); 
		query.append("                                                    DECODE(R.PROHI_TS_FLG,NULL,TC.TXT_DESC,TD.TXT_DESC" ).append("\n"); 
		query.append("                                                    )," ).append("\n"); 
		query.append("                                                    DECODE(R.PROHI_PASS_FLG,NULL,PC.TXT_DESC,PD.TXT_DESC" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                  ) TXT_DESC " ).append("\n"); 
		query.append("        		, DECODE(RT.PORT_TYPE,'S','',DECODE(NVL(R.IMDG_UN_NO,''),'',C.IMDG_UN_NO,R.IMDG_UN_NO))                        IMDG_UN_NO " ).append("\n"); 
		query.append("        		, DECODE(RT.PORT_TYPE,'S','',DECODE(NVL(R.IMDG_UN_NO_SEQ,''),'',C.IMDG_UN_NO_SEQ,R.IMDG_UN_NO_SEQ))            IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("        		, RT.ORDER_NUM1" ).append("\n"); 
		query.append("                , RT.ORDER_NUM2" ).append("\n"); 
		query.append("		      FROM ROUTE_TBL              RT" ).append("\n"); 
		query.append("        		 , PORT_RSTR_TBL1         R " ).append("\n"); 
		query.append("        		 , SCG_IMDG_PORT_RSTR_DTL LD " ).append("\n"); 
		query.append("        		 , SCG_IMDG_PORT_RSTR_DTL DD " ).append("\n"); 
		query.append("                 , SCG_IMDG_PORT_RSTR_DTL TD" ).append("\n"); 
		query.append("        		 , SCG_IMDG_PORT_RSTR_DTL PD " ).append("\n"); 
		query.append("        		 , PORT_RSTR_TBL2         C " ).append("\n"); 
		query.append("        		 , SCG_IMDG_PORT_RSTR_DTL LC " ).append("\n"); 
		query.append("        		 , SCG_IMDG_PORT_RSTR_DTL DC " ).append("\n"); 
		query.append("                 , SCG_IMDG_PORT_RSTR_DTL TC " ).append("\n"); 
		query.append("        		 , SCG_IMDG_PORT_RSTR_DTL PC" ).append("\n"); 
		query.append("		     WHERE RT.PORT_CD              = R.PORT_CD(+)" ).append("\n"); 
		query.append("               AND RT.PORT_CD              = C.PORT_CD(+)" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("      		   AND R.PORT_CD              = LD.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND R.IMDG_PORT_RSTR_SEQ   = LD.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND LD.PORT_PROHI_TP_CD(+) = 'L' " ).append("\n"); 
		query.append("      		   AND R.PORT_CD              = DD.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND R.IMDG_PORT_RSTR_SEQ   = DD.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND DD.PORT_PROHI_TP_CD(+) = 'D' " ).append("\n"); 
		query.append("               AND R.PORT_CD              = TD.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND R.IMDG_PORT_RSTR_SEQ   = TD.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND TD.PORT_PROHI_TP_CD(+) = 'T'" ).append("\n"); 
		query.append("      		   AND R.PORT_CD              = PD.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND R.IMDG_PORT_RSTR_SEQ   = PD.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND PD.PORT_PROHI_TP_CD(+) = 'P' " ).append("\n"); 
		query.append("      		 " ).append("\n"); 
		query.append("      		   AND C.PORT_CD              = LC.PORT_CD(+) " ).append("\n"); 
		query.append("      	       AND C.IMDG_PORT_RSTR_SEQ   = LC.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND LC.PORT_PROHI_TP_CD(+) = 'L' " ).append("\n"); 
		query.append("      		   AND C.PORT_CD              = DC.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND C.IMDG_PORT_RSTR_SEQ   = DC.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND DC.PORT_PROHI_TP_CD(+) = 'D' " ).append("\n"); 
		query.append("               AND C.PORT_CD              = TC.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND C.IMDG_PORT_RSTR_SEQ   = TC.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND TC.PORT_PROHI_TP_CD(+) = 'T'" ).append("\n"); 
		query.append("      		   AND C.PORT_CD              = PC.PORT_CD(+) " ).append("\n"); 
		query.append("      		   AND C.IMDG_PORT_RSTR_SEQ   = PC.IMDG_PORT_RSTR_SEQ(+) " ).append("\n"); 
		query.append("      		   AND PC.PORT_PROHI_TP_CD(+) = 'P' " ).append("\n"); 
		query.append("		  ) ST " ).append("\n"); 
		query.append("         GROUP BY" ).append("\n"); 
		query.append("                   ST.PORT_TYPE " ).append("\n"); 
		query.append("    		     , ST.PORT_CD " ).append("\n"); 
		query.append("    		     , ST.IMDG_CMPTN_AUTH_CD" ).append("\n"); 
		query.append("    		     , ST.TXT_DESC " ).append("\n"); 
		query.append("    		     , ST.IMDG_UN_NO " ).append("\n"); 
		query.append("    		     , ST.IMDG_UN_NO_SEQ " ).append("\n"); 
		query.append("    		     , ST.ORDER_NUM1" ).append("\n"); 
		query.append("                 , ST.ORDER_NUM2" ).append("\n"); 
		query.append("  ) TT " ).append("\n"); 
		query.append(" ORDER BY" ).append("\n"); 
		query.append("       TT.ORDER_NUM1" ).append("\n"); 
		query.append("     , TT.ORDER_NUM2" ).append("\n"); 

	}
}