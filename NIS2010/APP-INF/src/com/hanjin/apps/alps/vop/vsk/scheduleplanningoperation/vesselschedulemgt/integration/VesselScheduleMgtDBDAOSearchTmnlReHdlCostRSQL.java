/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchTmnlReHdlCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchTmnlReHdlCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchTmnlReHdlCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchTmnlReHdlCostRSQL").append("\n"); 
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
		query.append("SELECT P.TML_CD AS YD_CD," ).append("\n"); 
		query.append("		P.VSL_SLAN_CD," ).append("\n"); 
		query.append("		ROUND(MAX(DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS'," ).append("\n"); 
		query.append("		  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',DECODE(DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("			DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'O'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0))," ).append("\n"); 
		query.append("		  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TM',DECODE(DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("			DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'O'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0)),0) +" ).append("\n"); 
		query.append("		  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'SV',DECODE(DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("			DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'O'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0)),0)),0)*2)) TS_D2," ).append("\n"); 
		query.append("		ROUND(MAX(DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS'," ).append("\n"); 
		query.append("		  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',DECODE(DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("			DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'O'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0))," ).append("\n"); 
		query.append("		  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TM',DECODE(DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("			DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'O'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0)),0) +" ).append("\n"); 
		query.append("		  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'SV',DECODE(DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("			DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'O'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0)),0)),0)*2)) TS_D4," ).append("\n"); 
		query.append("		ROUND(MAX(DECODE(SUBSTR(D.LGS_COST_CD,5,2),'FL'," ).append("\n"); 
		query.append("		  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',DECODE(DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("			DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'O'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0))," ).append("\n"); 
		query.append("		  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TM',DECODE(DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("			DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'O'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0)),0) +" ).append("\n"); 
		query.append("		  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'SV',DECODE(DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("			DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'O'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D2',C.AGMT_RT,0),D.AGMT_UT_RT),0)),0)),0))) TM_D2," ).append("\n"); 
		query.append("		ROUND(MAX(DECODE(SUBSTR(D.LGS_COST_CD,5,2),'FL'," ).append("\n"); 
		query.append("		  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TP',DECODE(DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("			DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'O'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0))," ).append("\n"); 
		query.append("		  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'TM',DECODE(DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("			DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'O'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0)),0) +" ).append("\n"); 
		query.append("		  DECODE(SUBSTR(D.LGS_COST_CD,1,2),'SV',DECODE(DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("			DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'O'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("			  DECODE(NVL(D.IO_BND_CD,'N'),'S'," ).append("\n"); 
		query.append("				DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,'D4',C.AGMT_RT,0),D.AGMT_UT_RT),0)),0)),0))) TM_D4," ).append("\n"); 
		query.append("		D.CURR_CD CURR_CD" ).append("\n"); 
		query.append(" FROM   PRD_PORT_TML_MTX P, MDM_YARD V, TES_TML_AGMT_HDR H, TES_TML_AGMT_DTL D," ).append("\n"); 
		query.append("		TES_TML_AGMT_TP_SZ C, TES_TML_AGMT_DG_CGO_CLSS G, TES_TML_AGMT_APLY_DY A" ).append("\n"); 
		query.append(" WHERE  P.CRR_CD          = 'SML'" ).append("\n"); 
		query.append(" AND    P.VSL_SLAN_CD     = @[vsl_slan_cd]" ).append("\n"); 
		query.append(" AND    P.TML_CD          = V.YD_CD" ).append("\n"); 
		query.append(" AND    H.YD_CD           = P.TML_CD" ).append("\n"); 
		query.append(" AND    H.VNDR_SEQ        = V.N1ST_VNDR_SEQ" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_STS_CD = 'C'                                                               " ).append("\n"); 
		query.append(" AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("							  FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("							  WHERE  M.YD_CD           = P.TML_CD" ).append("\n"); 
		query.append("							  AND    M.YD_CD           = @[yd_cd]" ).append("\n"); 
		query.append("							  AND    M.VNDR_SEQ        = V.N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("							  AND    M.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("							  AND    M.DELT_FLG        = 'N' )" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_SEQ        = D.TML_AGMT_SEQ" ).append("\n"); 
		query.append(" AND    H.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO" ).append("\n"); 
		query.append(" AND    D.LGS_COST_CD         IN ('TPNDTS','SVLDTS','TMNDTS','TPNDFL','SVLDFL','TMNDFL')" ).append("\n"); 
		query.append(" AND    NVL(D.THRP_COST_CD_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append(" AND    TO_NUMBER(NVL(D.FM_TR_VOL_VAL,'1')) = 1 " ).append("\n"); 
		query.append(" AND    NVL(D.LANE_CD,'N')    = DECODE(NVL(D.LANE_CD,'N'),'N','N','Sam','Sam','OTH','OTH',P.VSL_SLAN_CD)" ).append("\n"); 
		query.append(" AND    NVL(D.IOC_CD,'N')     IN ('N','S','O')" ).append("\n"); 
		query.append(" AND    NVL(D.IO_BND_CD,'N')  IN ('N','S','O')" ).append("\n"); 
		query.append(" AND    NVL(D.TML_TRNS_MOD_CD,'N') = DECODE(NVL(D.TML_TRNS_MOD_CD,'N'),'N','N','S','S',D.TML_TRNS_MOD_CD)" ).append("\n"); 
		query.append(" AND    D.TML_AGMT_OFC_CTY_CD = C.TML_AGMT_OFC_CTY_CD	(+)                                                             " ).append("\n"); 
		query.append(" AND    D.TML_AGMT_SEQ        = C.TML_AGMT_SEQ			(+)                                                                           " ).append("\n"); 
		query.append(" AND    D.TML_AGMT_VER_NO     = C.TML_AGMT_VER_NO		(+)                                                                     " ).append("\n"); 
		query.append(" AND    D.TML_AGMT_DTL_SEQ    = C.TML_AGMT_DTL_SEQ		(+)                                                                   " ).append("\n"); 
		query.append(" AND    DECODE(D.TML_AGMT_VOL_UT_CD,'C',C.CNTR_TPSZ_CD,'N') IN ('D2','D4','N')" ).append("\n"); 
		query.append(" AND    D.TML_AGMT_OFC_CTY_CD = G.TML_AGMT_OFC_CTY_CD	(+)" ).append("\n"); 
		query.append(" AND    D.TML_AGMT_SEQ        = G.TML_AGMT_SEQ			(+)" ).append("\n"); 
		query.append(" AND    D.TML_AGMT_VER_NO     = G.TML_AGMT_VER_NO		(+)" ).append("\n"); 
		query.append(" AND    DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'N','N',D.TML_AGMT_DTL_SEQ)                                                                        " ).append("\n"); 
		query.append("		= DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'N','N',G.TML_AGMT_DTL_SEQ)" ).append("\n"); 
		query.append(" AND    DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'N','N',G.DCGO_APLY_TP_CD) = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'N','N','R')" ).append("\n"); 
		query.append(" AND    DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'A',DECODE('N','N',G.DCGO_NON_CLSS_FLG,'N'),'S',DECODE('N','N',G.DCGO_NON_CLSS_FLG,'N'),'N')     " ).append("\n"); 
		query.append("		= DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'A',DECODE('N','N','Y','N'),'S',DECODE('N','N','Y','N'),'N')" ).append("\n"); 
		query.append(" AND    D.TML_AGMT_OFC_CTY_CD  = A.TML_AGMT_OFC_CTY_CD	(+)                                                                                    " ).append("\n"); 
		query.append(" AND    D.TML_AGMT_SEQ         = A.TML_AGMT_SEQ			(+)                                                                                           " ).append("\n"); 
		query.append(" AND    D.TML_AGMT_VER_NO      = A.TML_AGMT_VER_NO		(+)                                                                                        " ).append("\n"); 
		query.append(" AND    D.TML_AGMT_DTL_SEQ     = A.TML_AGMT_DTL_SEQ		(+)" ).append("\n"); 
		query.append(" GROUP BY P.TML_CD, P.VSL_SLAN_CD, D.CURR_CD" ).append("\n"); 

	}
}