/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PanamaCustomsTransmissionDBDAOsearchGeneralCargoDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PanamaCustomsTransmissionDBDAOsearchGeneralCargoDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchGeneralCargoDetail
	  * </pre>
	  */
	public PanamaCustomsTransmissionDBDAOsearchGeneralCargoDetailRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration").append("\n"); 
		query.append("FileName : PanamaCustomsTransmissionDBDAOsearchGeneralCargoDetailRSQL").append("\n"); 
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
		query.append("E.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("A.POL_CD POL_CD," ).append("\n"); 
		query.append("A.POD_CD POD_CD," ).append("\n"); 
		query.append("DECODE(ROUND(E.CNTR_WGT * DECODE(E.WGT_UT_CD, 'LBS', 0.0005, 0.001), 3), 0, DECODE(SUBSTR(E.CNTR_TPSZ_CD, 2, 1), '2', 10, 15), ROUND((E.CNTR_WGT * DECODE(E.WGT_UT_CD, 'LBS', 0.0005, 0.001)) + (X_CNTR_TARE_WGT / 1000), 3)) VALUE2," ).append("\n"); 
		query.append("E.CNTR_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("--LTRIM(RTRIM(NVL(MIN(F.CNTR_MF_GDS_DESC), NVL(MIN(G.CMDT_NM), MIN(H.REP_CMDT_NM))))) VALUE1" ).append("\n"); 
		query.append("LTRIM(" ).append("\n"); 
		query.append("    RTRIM(   " ).append("\n"); 
		query.append("            NVL( BKG_SPCLCHAR_CONV_FNC(MIN(F.CNTR_MF_GDS_DESC), 'X'), " ).append("\n"); 
		query.append("                NVL( BKG_SPCLCHAR_CONV_FNC(MIN(G.CMDT_NM), 'X'), " ).append("\n"); 
		query.append("                        BKG_SPCLCHAR_CONV_FNC(MIN(H.REP_CMDT_NM), 'X') " ).append("\n"); 
		query.append("                   )   " ).append("\n"); 
		query.append("            )   " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append(") VALUE1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_VVD A, VSK_VSL_PORT_SKD B, VSK_VSL_PORT_SKD C, BKG_BOOKING D, BKG_CONTAINER E, BKG_CNTR_MF_DESC F, MDM_COMMODITY G,   MDM_REP_CMDT H," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT M.CNTR_NO X_CNTR_NO," ).append("\n"); 
		query.append("NVL(N.CNTRTS_TARE_WGT, O.CNTR_TPSZ_TARE_WGT) / 1000 X_CNTR_TARE_WGT," ).append("\n"); 
		query.append("COUNT(M.CNTR_NO) X_CNTR_COUNT" ).append("\n"); 
		query.append("FROM BKG_VVD I, VSK_VSL_PORT_SKD J, VSK_VSL_PORT_SKD K, BKG_BOOKING L, BKG_CONTAINER M, MDM_CNTR_TP_SZ O," ).append("\n"); 
		query.append("(SELECT MC.CNTR_NO CNTR_NO," ).append("\n"); 
		query.append("MC.CNTR_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("DECODE(NVL(S.TARE_WGT, 0), 0" ).append("\n"); 
		query.append(", DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0" ).append("\n"); 
		query.append(", DECODE(MC.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0)," ).append("\n"); 
		query.append("MDM.CNTR_TPSZ_TARE_WGT) , S.TARE_WGT ) CNTRTS_TARE_WGT" ).append("\n"); 
		query.append("FROM MST_CONTAINER MC, MST_CNTR_SPEC S, MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("WHERE MC.CNTR_SPEC_NO      =   S.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("AND MC.CNTR_TPSZ_CD          =   MDM.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(") N" ).append("\n"); 
		query.append("WHERE I.VSL_CD          =  @[vsl_cd]" ).append("\n"); 
		query.append("AND I.SKD_VOY_NO      =  @[skd_voy_no]" ).append("\n"); 
		query.append("AND I.SKD_DIR_CD      =  @[skd_dir_cd]" ).append("\n"); 
		query.append("AND I.VSL_CD = J.VSL_CD(+)" ).append("\n"); 
		query.append("AND I.SKD_VOY_NO = J.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND I.SKD_DIR_CD = J.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND I.POL_CD = J.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND I.VSL_CD = K.VSL_CD(+)" ).append("\n"); 
		query.append("AND I.SKD_VOY_NO = K.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND I.SKD_DIR_CD = K.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND I.POD_CD = K.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND I.BKG_NO          =  L.BKG_NO" ).append("\n"); 
		query.append("AND L.BKG_NO          =  M.BKG_NO" ).append("\n"); 
		query.append("AND M.CNTR_NO         =  N.CNTR_NO" ).append("\n"); 
		query.append("AND N.CNTR_TPSZ_CD(+)    =  O.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND NVL(K.CLPT_SEQ, 9999)  >  NVL(J.CLPT_SEQ, 0)" ).append("\n"); 
		query.append("AND NVL(J.CLPT_SEQ, 0)  <= @[clpt_seq]" ).append("\n"); 
		query.append("AND NVL(K.CLPT_SEQ, 9999)  >  @[clpt_seq]" ).append("\n"); 
		query.append("AND L.BKG_STS_CD         IN ('W', 'F')" ).append("\n"); 
		query.append("AND L.BKG_CGO_TP_CD   =  'F'" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT '*' FROM BKG_DG_CGO N WHERE N.BKG_NO = M.BKG_NO AND N.CNTR_NO = M.CNTR_NO)" ).append("\n"); 
		query.append("GROUP BY M.CNTR_NO," ).append("\n"); 
		query.append("NVL(N.CNTRTS_TARE_WGT, O.CNTR_TPSZ_TARE_WGT)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE A.VSL_CD          =  @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO      =  @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD      =  @[skd_dir_cd]" ).append("\n"); 
		query.append("AND B.VSL_CD(+)       =  A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO(+)   =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD(+)   =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.VPS_PORT_CD(+)   =  A.POL_CD" ).append("\n"); 
		query.append("AND C.VSL_CD(+)       =  A.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO(+)   =  A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD(+)   =  A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C.VPS_PORT_CD(+)   =  A.POD_CD" ).append("\n"); 
		query.append("AND NVL(C.CLPT_SEQ, 9999)  >  NVL(B.CLPT_SEQ, 0)" ).append("\n"); 
		query.append("AND NVL(B.CLPT_SEQ, 0)  <= @[clpt_seq]" ).append("\n"); 
		query.append("AND NVL(C.CLPT_SEQ, 9999)  >  @[clpt_seq]" ).append("\n"); 
		query.append("AND D.BKG_NO          =  A.BKG_NO" ).append("\n"); 
		query.append("AND D.BKG_STS_CD         IN ('W', 'F')" ).append("\n"); 
		query.append("AND D.BKG_CGO_TP_CD   =  'F'" ).append("\n"); 
		query.append("AND E.BKG_NO          =  D.BKG_NO" ).append("\n"); 
		query.append("AND F.BKG_NO(+)       =  E.BKG_NO" ).append("\n"); 
		query.append("AND F.CNTR_NO(+)      =  E.CNTR_NO" ).append("\n"); 
		query.append("--AND F.CNTR_MF_SEQ(+)  =  '01'" ).append("\n"); 
		query.append("AND G.CMDT_CD(+)      = D.CMDT_CD" ).append("\n"); 
		query.append("AND H.REP_CMDT_CD(+)  = D.REP_CMDT_CD" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT '*' FROM BKG_DG_CGO I WHERE I.BKG_NO = E.BKG_NO AND I.CNTR_NO = E.CNTR_NO)" ).append("\n"); 
		query.append("AND X_CNTR_NO         = E.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY E.CNTR_NO," ).append("\n"); 
		query.append("A.POL_CD," ).append("\n"); 
		query.append("A.POD_CD," ).append("\n"); 
		query.append("DECODE(ROUND(E.CNTR_WGT * DECODE(E.WGT_UT_CD, 'LBS', 0.0005, 0.001), 3), 0, DECODE(SUBSTR(E.CNTR_TPSZ_CD, 2, 1), '2', 10, 15), ROUND((E.CNTR_WGT * DECODE(E.WGT_UT_CD, 'LBS', 0.0005, 0.001)) + (X_CNTR_TARE_WGT / 1000), 3))," ).append("\n"); 
		query.append("E.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("ORDER BY E.CNTR_NO" ).append("\n"); 

	}
}