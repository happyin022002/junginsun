/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierRestrictionDBDAOPortRestrictionOptionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.05.14 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierRestrictionDBDAOPortRestrictionOptionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CarrierRestrictionDBDAOPortRestrictionOptionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_port_rotn_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_port_rotn_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration").append("\n"); 
		query.append("FileName : CarrierRestrictionDBDAOPortRestrictionOptionRSQL").append("\n"); 
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
		query.append("SELECT DECODE(P.PORT_ROTN_SEQ, PT.POL_SEQ, 'POL', " ).append("\n"); 
		query.append("                         	   PT.POD_SEQ, 'POD', " ).append("\n"); 
		query.append("                                           'Pass') AS PORT_TYPE" ).append("\n"); 
		query.append("     , P.PORT_CD " ).append("\n"); 
		query.append("     , DECODE(DECODE(R.PORT_CD, PT.POL_CD, DECODE(R.PROHI_LOD_FLG, 'Y','Prohibition',DECODE(LD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need'))," ).append("\n"); 
		query.append("                                PT.POD_CD, DECODE(R.PROHI_DCHG_FLG,'Y','Prohibition',DECODE(DD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need'))," ).append("\n"); 
		query.append("                                           DECODE(R.PROHI_PASS_FLG,'Y','Prohibition',DECODE(PD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need'))),NULL," ).append("\n"); 
		query.append("              DECODE(C.PORT_CD, PT.POL_CD, DECODE(C.PROHI_LOD_FLG, 'Y','Prohibition',DECODE(LC.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need'))," ).append("\n"); 
		query.append("                                PT.POD_CD, DECODE(C.PROHI_DCHG_FLG,'Y','Prohibition',DECODE(DC.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need'))," ).append("\n"); 
		query.append("                                           DECODE(C.PROHI_PASS_FLG,'Y','Prohibition',DECODE(PC.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')))," ).append("\n"); 
		query.append("              DECODE(P.PORT_ROTN_SEQ, PT.POL_SEQ, DECODE(R.PROHI_LOD_FLG, 'Y','Prohibition',DECODE(LD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need'))," ).append("\n"); 
		query.append("                                	  PT.POD_SEQ, DECODE(R.PROHI_DCHG_FLG,'Y','Prohibition',DECODE(DD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need'))," ).append("\n"); 
		query.append("                                           DECODE(R.PROHI_PASS_FLG,'Y','Prohibition',DECODE(PD.IMDG_CMPTN_AUTH_CD,'P','Permit','D','Declare','N','No Need')))) AS IMDG_CMPTN_AUTH_CD" ).append("\n"); 
		query.append("     , DECODE(P.PORT_ROTN_SEQ, PT.POL_SEQ, DECODE(R.PROHI_LOD_FLG,NULL,LC.TXT_DESC,LD.TXT_DESC), " ).append("\n"); 
		query.append("                         	   PT.POD_SEQ, DECODE(R.PROHI_DCHG_FLG,NULL,DC.TXT_DESC,DD.TXT_DESC)," ).append("\n"); 
		query.append("                                    DECODE(R.PROHI_PASS_FLG,NULL,PC.TXT_DESC,PD.TXT_DESC)) AS TXT_DESC" ).append("\n"); 
		query.append("     , '' POL_VPS_PORT_CD" ).append("\n"); 
		query.append("     , '' POD_VPS_PORT_CD" ).append("\n"); 
		query.append("     , '' IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , '' IMDG_UN_NO" ).append("\n"); 
		query.append("     , '' IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("     , '' SLAN_CD" ).append("\n"); 
		query.append("     , '' POL_PORT_CD" ).append("\n"); 
		query.append("     , '' POD_PORT_CD" ).append("\n"); 
		query.append("  FROM VSK_PF_CALL_PORT P" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT POL.DIR " ).append("\n"); 
		query.append("             , POL.DIR_SEQ" ).append("\n"); 
		query.append("             , POL.POL_CD" ).append("\n"); 
		query.append("             , POL.POL_SEQ" ).append("\n"); 
		query.append("             , POD.POD_CD" ).append("\n"); 
		query.append("             , POD.POD_SEQ" ).append("\n"); 
		query.append("             , POL.SLAN_CD" ).append("\n"); 
		query.append("             , POL.TP_CD" ).append("\n"); 
		query.append("          FROM VSK_PF_SKD H," ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT B.SKD_DIR_CD       DIR" ).append("\n"); 
		query.append("                     , D.VSL_SLAN_DIR_SEQ DIR_SEQ" ).append("\n"); 
		query.append("                     , A.PORT_ROTN_SEQ    POL_SEQ" ).append("\n"); 
		query.append("                     , B.PORT_CD          POL_CD" ).append("\n"); 
		query.append("                     , A.VSL_SLAN_CD      SLAN_CD" ).append("\n"); 
		query.append("                     , A.PF_SVC_TP_CD     TP_CD" ).append("\n"); 
		query.append("					 , A.CLPT_SEQ" ).append("\n"); 
		query.append("                   FROM VSK_PF_CALL_PORT     A" ).append("\n"); 
		query.append("                      , VSK_PF_SKD_DTL       B" ).append("\n"); 
		query.append("                      , MDM_VSL_SVC_LANE_DIR D" ).append("\n"); 
		query.append("                  WHERE A.VSL_SLAN_CD   = B.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("                    AND A.PF_SVC_TP_CD  = B.PF_SVC_TP_CD(+)" ).append("\n"); 
		query.append("                    AND A.SKD_DIR_CD    = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                    AND A.PORT_CD       = B.PORT_CD(+)" ).append("\n"); 
		query.append("                    AND B.VSL_SLAN_CD   = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("                    AND B.SKD_DIR_CD    = D.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                    AND B.TURN_PORT_IND_CD <> 'F'" ).append("\n"); 
		query.append("                  ORDER BY D.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("                         , B.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("               ) POL, " ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("                SELECT A.SKD_DIR_CD       DIR" ).append("\n"); 
		query.append("                     , D.VSL_SLAN_DIR_SEQ DIR_SEQ" ).append("\n"); 
		query.append("                     , A.PORT_ROTN_SEQ    POD_SEQ" ).append("\n"); 
		query.append("                     , A.PORT_CD          POD_CD" ).append("\n"); 
		query.append("                     , A.VSL_SLAN_CD      SLAN_CD" ).append("\n"); 
		query.append("                     , A.PF_SVC_TP_CD     TP_CD" ).append("\n"); 
		query.append("					 , A.CLPT_SEQ" ).append("\n"); 
		query.append("                  FROM VSK_PF_CALL_PORT     A" ).append("\n"); 
		query.append("                     , MDM_VSL_SVC_LANE_DIR D" ).append("\n"); 
		query.append("                 WHERE A.VSL_SLAN_CD  = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD   = D.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                   AND PORT_ROTN_SEQ <> 1" ).append("\n"); 
		query.append("                 ORDER BY D.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("                        , A.PORT_ROTN_SEQ" ).append("\n"); 
		query.append("               ) POD " ).append("\n"); 
		query.append("         WHERE H.SLAN_STND_FLG = 'Y'  " ).append("\n"); 
		query.append("           AND H.VSL_SLAN_CD   = POL.SLAN_CD" ).append("\n"); 
		query.append("           AND H.PF_SVC_TP_CD  = POL.TP_CD" ).append("\n"); 
		query.append("		   AND POL.SLAN_CD     = POD.SLAN_CD" ).append("\n"); 
		query.append("           AND POL.DIR         = POD.DIR " ).append("\n"); 
		query.append("           AND POL.DIR_SEQ     = POD.DIR_SEQ" ).append("\n"); 
		query.append("           AND POL.TP_CD       = POD.TP_CD" ).append("\n"); 
		query.append("           AND POL.POL_SEQ     < POD.POD_SEQ" ).append("\n"); 
		query.append("           AND POL.SLAN_CD     = @[slan_cd]       --:lane_cd" ).append("\n"); 
		query.append("           AND POL.POL_CD      = @[pol_port_cd]   --:pol_cd" ).append("\n"); 
		query.append("           AND POD.POD_CD      = @[pod_port_cd]   --:pod_cd" ).append("\n"); 
		query.append("	  #if (${pol_port_rotn_seq} != '') " ).append("\n"); 
		query.append("		   AND POL.CLPT_SEQ    =  @[pol_port_rotn_seq]	--:pol_clpt_cd" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("	  #if (${pod_port_rotn_seq} != '') " ).append("\n"); 
		query.append("		   AND POD.CLPT_SEQ    =  @[pod_port_rotn_seq]  --:pod_clpt_cd" ).append("\n"); 
		query.append("	  #end" ).append("\n"); 
		query.append("           AND ROWNUM          = 1" ).append("\n"); 
		query.append("         ORDER BY POL.DIR_SEQ" ).append("\n"); 
		query.append("                , POL.POL_SEQ" ).append("\n"); 
		query.append("                , POD.POD_SEQ" ).append("\n"); 
		query.append("       ) PT" ).append("\n"); 
		query.append("     , SCG_IMDG_PORT_RSTR R, SCG_IMDG_PORT_RSTR_DTL LD, SCG_IMDG_PORT_RSTR_DTL DD, SCG_IMDG_PORT_RSTR_DTL PD" ).append("\n"); 
		query.append("     , SCG_IMDG_PORT_RSTR C, SCG_IMDG_PORT_RSTR_DTL LC, SCG_IMDG_PORT_RSTR_DTL DC, SCG_IMDG_PORT_RSTR_DTL PC" ).append("\n"); 
		query.append(" WHERE P.VSL_SLAN_CD          = PT.SLAN_CD" ).append("\n"); 
		query.append("   AND P.PF_SVC_TP_CD         = PT.TP_CD" ).append("\n"); 
		query.append("   AND P.SKD_DIR_CD           = PT.DIR" ).append("\n"); 
		query.append("   AND P.PORT_ROTN_SEQ       >= PT.POL_SEQ" ).append("\n"); 
		query.append("   AND P.PORT_ROTN_SEQ       <= PT.POD_SEQ" ).append("\n"); 
		query.append("   AND P.PORT_CD              = R.PORT_CD(+) " ).append("\n"); 
		query.append("   AND R.IMDG_CLSS_CD(+)      = @[imdg_clss_cd]                      --:class_cd " ).append("\n"); 
		query.append("   AND R.IMDG_UN_NO(+)        = @[imdg_un_no]                        --:un_no " ).append("\n"); 
		query.append("   AND R.IMDG_UN_NO_SEQ(+)    = @[imdg_un_no_seq]                    --:un_no_seq" ).append("\n"); 
		query.append("   AND P.PORT_CD              = C.PORT_CD(+)" ).append("\n"); 
		query.append("   AND C.IMDG_CLSS_CD(+)      = @[imdg_clss_cd]                      --:class_cd " ).append("\n"); 
		query.append("   AND C.IMDG_UN_NO           IS NULL " ).append("\n"); 
		query.append("   AND C.IMDG_UN_NO_SEQ       IS NULL" ).append("\n"); 
		query.append("   AND R.PORT_CD              = LD.PORT_CD(+)" ).append("\n"); 
		query.append("   AND R.IMDG_PORT_RSTR_SEQ   = LD.IMDG_PORT_RSTR_SEQ(+)" ).append("\n"); 
		query.append("   AND LD.PORT_PROHI_TP_CD(+) = 'L'" ).append("\n"); 
		query.append("   AND R.PORT_CD              = DD.PORT_CD(+)" ).append("\n"); 
		query.append("   AND R.IMDG_PORT_RSTR_SEQ   = DD.IMDG_PORT_RSTR_SEQ(+)" ).append("\n"); 
		query.append("   AND DD.PORT_PROHI_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("   AND R.PORT_CD              = PD.PORT_CD(+)" ).append("\n"); 
		query.append("   AND R.IMDG_PORT_RSTR_SEQ   = PD.IMDG_PORT_RSTR_SEQ(+)" ).append("\n"); 
		query.append("   AND PD.PORT_PROHI_TP_CD(+) = 'P'" ).append("\n"); 
		query.append("   AND C.PORT_CD              = LC.PORT_CD(+)" ).append("\n"); 
		query.append("   AND C.IMDG_PORT_RSTR_SEQ   = LC.IMDG_PORT_RSTR_SEQ(+)" ).append("\n"); 
		query.append("   AND LC.PORT_PROHI_TP_CD(+) = 'L'" ).append("\n"); 
		query.append("   AND C.PORT_CD              = DC.PORT_CD(+)" ).append("\n"); 
		query.append("   AND C.IMDG_PORT_RSTR_SEQ   = DC.IMDG_PORT_RSTR_SEQ(+)" ).append("\n"); 
		query.append("   AND DC.PORT_PROHI_TP_CD(+) = 'D'" ).append("\n"); 
		query.append("   AND C.PORT_CD              = PC.PORT_CD(+)" ).append("\n"); 
		query.append("   AND C.IMDG_PORT_RSTR_SEQ   = PC.IMDG_PORT_RSTR_SEQ(+)" ).append("\n"); 
		query.append("   AND PC.PORT_PROHI_TP_CD(+) = 'P'" ).append("\n"); 
		query.append(" ORDER BY P.PORT_ROTN_SEQ" ).append("\n"); 

	}
}