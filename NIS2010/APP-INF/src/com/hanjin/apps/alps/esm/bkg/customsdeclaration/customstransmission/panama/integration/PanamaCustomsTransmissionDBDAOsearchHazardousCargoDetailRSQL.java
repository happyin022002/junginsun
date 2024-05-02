/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PanamaCustomsTransmissionDBDAOsearchHazardousCargoDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.11.09 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PanamaCustomsTransmissionDBDAOsearchHazardousCargoDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchHazardousCargoDetail
	  * </pre>
	  */
	public PanamaCustomsTransmissionDBDAOsearchHazardousCargoDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.integration").append("\n"); 
		query.append("FileName : PanamaCustomsTransmissionDBDAOsearchHazardousCargoDetailRSQL").append("\n"); 
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
		query.append("E.IMDG_UN_NO IMDG_UN_NO," ).append("\n"); 
		query.append("E.IMDG_CLSS_CD  IMDG_CLSS_CD," ).append("\n"); 
		query.append("E.IMDG_COMP_GRP_CD IMDG_CO_GRP_CD," ).append("\n"); 
		query.append("E.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("TRANSLATE(E.FLSH_PNT_CDO_TEMP, '1234567890.-><+', '1234567890.-') VALUE1," ).append("\n"); 
		query.append("DECODE(ROUND((E.GRS_WGT * DECODE(E.WGT_UT_CD, 'LBS', 0.0005, 0.001)) + (X_CNTR_TARE_WGT / 1000), 3), 0, DECODE(X_BKG_COUNT, 1, X_BKG_WEIGHT, 0), ROUND((E.GRS_WGT * DECODE(E.WGT_UT_CD, 'LBS', 0.0005, 0.001)) + (X_CNTR_TARE_WGT / 1000), 3)) VALUE2," ).append("\n"); 
		query.append("'CONT' DG_KEPTIN," ).append("\n"); 
		query.append("E.CNTR_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("A.POL_CD POL_CD," ).append("\n"); 
		query.append("A.POD_CD POD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_VVD A," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD B," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD C," ).append("\n"); 
		query.append("BKG_BOOKING D," ).append("\n"); 
		query.append("BKG_DG_CGO E," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("J.CNTR_NO X_CNTR_NO," ).append("\n"); 
		query.append("NVL(K.CNTRTS_TARE_WGT, L.CNTR_TPSZ_TARE_WGT) / 1000 X_CNTR_TARE_WGT," ).append("\n"); 
		query.append("COUNT(J.CNTR_NO) X_CNTR_COUNT," ).append("\n"); 
		query.append("--COUNT(DISTINCT J.BKG_NO||J.BKG_NO_SPLIT||J.DG_CNTR_SEQ||J.CNTR_CGO_SEQ) X_BKG_COUNT," ).append("\n"); 
		query.append("COUNT(DISTINCT J.BKG_NO||J.DG_CNTR_SEQ||J.CNTR_CGO_SEQ) X_BKG_COUNT," ).append("\n"); 
		query.append("SUM(M.ACT_WGT * DECODE(M.WGT_UT_CD, 'KGS', 0.001, 0.0005)) X_BKG_WEIGHT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_VVD F," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD G," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD H," ).append("\n"); 
		query.append("BKG_BOOKING I," ).append("\n"); 
		query.append("BKG_DG_CGO J," ).append("\n"); 
		query.append("MDM_CNTR_TP_SZ L," ).append("\n"); 
		query.append("BKG_BL_DOC M," ).append("\n"); 
		query.append("(SELECT MC.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("MC.CNTR_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(NVL(S.TARE_WGT, 0), 0" ).append("\n"); 
		query.append(", DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0" ).append("\n"); 
		query.append(", DECODE(MC.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0)," ).append("\n"); 
		query.append("MDM.CNTR_TPSZ_TARE_WGT) , S.TARE_WGT ) CNTRTS_TARE_WGT" ).append("\n"); 
		query.append("FROM MST_CONTAINER MC, MST_CNTR_SPEC S, MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("WHERE MC.CNTR_SPEC_NO      =   S.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("AND MC.CNTR_TPSZ_CD          =   MDM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(") K" ).append("\n"); 
		query.append("WHERE F.VSL_CD        =  @[vsl_cd]" ).append("\n"); 
		query.append("AND F.SKD_VOY_NO    =  @[skd_voy_no]" ).append("\n"); 
		query.append("AND F.SKD_DIR_CD    =  @[skd_dir_cd]" ).append("\n"); 
		query.append("AND F.VSL_CD = G.VSL_CD(+)" ).append("\n"); 
		query.append("AND F.SKD_VOY_NO = G.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND F.SKD_DIR_CD = G.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND F.POL_CD = G.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND F.VSL_CD = H.VSL_CD(+)" ).append("\n"); 
		query.append("AND F.SKD_VOY_NO = H.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND F.SKD_DIR_CD = H.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND F.POD_CD = H.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND F.BKG_NO        =  I.BKG_NO" ).append("\n"); 
		query.append("--AND I.BKG_NO_SPLIT  =  F.BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND I.BKG_NO        =  J.BKG_NO" ).append("\n"); 
		query.append("--AND J.BKG_NO_SPLIT  =  I.BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND I.BKG_NO        =  M.BKG_NO" ).append("\n"); 
		query.append("--AND M.BKG_NO_SPLIT  =  I.BKG_NO_SPLIT" ).append("\n"); 
		query.append("AND J.CNTR_NO  =  K.CNTR_NO" ).append("\n"); 
		query.append("AND K.CNTR_TPSZ_CD(+)  =  L.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND NVL(H.CLPT_SEQ, 9999)  >  NVL(G.CLPT_SEQ, 0)" ).append("\n"); 
		query.append("AND NVL(G.CLPT_SEQ, 0)  <= @[clpt_seq]" ).append("\n"); 
		query.append("AND NVL(H.CLPT_SEQ, 9999)  >  @[clpt_seq]" ).append("\n"); 
		query.append("AND I.BKG_STS_CD       IN ('W', 'F')" ).append("\n"); 
		query.append("GROUP BY J.CNTR_NO, NVL(K.CNTRTS_TARE_WGT, L.CNTR_TPSZ_TARE_WGT)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE A.VSL_CD        =  @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO    =  @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD    =  @[skd_dir_cd]" ).append("\n"); 
		query.append("AND B.VSL_CD(+)     =  A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO(+) =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD(+) =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.VPS_PORT_CD(+) =  A.POL_CD" ).append("\n"); 
		query.append("AND C.VSL_CD(+)     =  A.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO(+) =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD(+) =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C.VPS_PORT_CD(+) =  A.POD_CD" ).append("\n"); 
		query.append("AND NVL(C.CLPT_SEQ, 9999)  >  NVL(B.CLPT_SEQ, 0)" ).append("\n"); 
		query.append("AND NVL(B.CLPT_SEQ, 0)  <= @[clpt_seq]" ).append("\n"); 
		query.append("AND NVL(C.CLPT_SEQ, 9999)  >  @[clpt_seq]" ).append("\n"); 
		query.append("AND D.BKG_NO        =  A.BKG_NO" ).append("\n"); 
		query.append("AND D.BKG_STS_CD       IN ('W', 'F')" ).append("\n"); 
		query.append("AND E.BKG_NO        =  D.BKG_NO" ).append("\n"); 
		query.append("AND X_CNTR_NO  =  E.CNTR_NO" ).append("\n"); 

	}
}