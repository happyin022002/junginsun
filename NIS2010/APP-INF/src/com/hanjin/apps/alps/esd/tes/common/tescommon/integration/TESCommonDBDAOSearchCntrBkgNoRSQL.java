/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TESCommonDBDAOSearchCntrBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.21
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2011.11.21 윤태승
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yuntaeseung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESCommonDBDAOSearchCntrBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * * 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
	  * * 2011.11.21 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
	  * </pre>
	  */
	public TESCommonDBDAOSearchCntrBkgNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tescommon.integration").append("\n"); 
		query.append("FileName : TESCommonDBDAOSearchCntrBkgNoRSQL").append("\n"); 
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
		query.append("SELECT NVL(" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(COUNT(C.CNTR_NO) OVER (), 0) > 0" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("|| '|' || C.CNTR_TPSZ_CD || '|' ||" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN NVL(COUNT(C.CNTR_NO) OVER (), 0) > 0" ).append("\n"); 
		query.append("THEN (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN X.BKG_NO IS NOT NULL THEN X.BKG_NO" ).append("\n"); 
		query.append("WHEN Y.BKG_NO IS NOT NULL THEN Y.BKG_NO" ).append("\n"); 
		query.append("WHEN C.BKG_NO IS NOT NULL THEN C.BKG_NO" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END BKG_NO" ).append("\n"); 
		query.append("FROM MST_CONTAINER C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT X.BKG_NO, X.CNTR_NO FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("L.BKG_NO, L.CNTR_NO, DENSE_RANK() OVER (PARTITION BY L.CNTR_NO ORDER BY L.WORK_DT_DIFF ASC) DIFF_RANK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ABS(V.VPS_ETB_DT - TO_DATE(REPLACE(@[atb_dt],'-',''),'YYYYMMDD')) WORK_DT_DIFF," ).append("\n"); 
		query.append("DECODE(B.BKG_CGO_TP_CD,'F','F','B','F','R','R','M') FM, B.POL_CD POL," ).append("\n"); 
		query.append("B.BKG_STS_CD, BV.BKG_NO, BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD VVD, C.CNTR_NO, G.ORG_NOD_CD," ).append("\n"); 
		query.append("V.VPS_ETB_DT, M.CNTR_TPSZ_CD, H.COP_NO, G.PCTL_NO, G.PCTL_SEQ," ).append("\n"); 
		query.append("MIN(( SELECT MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM   SCE_COP_HDR HD, PRD_PROD_CTL_ROUT_DTL GD" ).append("\n"); 
		query.append("WHERE  H.CNTR_NO  = HD.CNTR_NO" ).append("\n"); 
		query.append("AND    HD.PCTL_NO = GD.PCTL_NO" ).append("\n"); 
		query.append("AND    H.BKG_NO   = HD.BKG_NO" ).append("\n"); 
		query.append("AND    GD.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("AND    GD.PCTL_SEQ < G.PCTL_SEQ )) R_SEQ," ).append("\n"); 
		query.append("MAX(( SELECT MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM   SCE_COP_HDR OD, PRD_PROD_CTL_ROUT_DTL OG" ).append("\n"); 
		query.append("WHERE  OD.CNTR_NO = H.CNTR_NO" ).append("\n"); 
		query.append("AND    OD.BKG_NO  = H.BKG_NO" ).append("\n"); 
		query.append("AND    OD.PCTL_NO = OG.PCTL_NO" ).append("\n"); 
		query.append("AND    OG.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("AND    OG.PCTL_SEQ > G.PCTL_SEQ )) O_SEQ" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, BKG_VVD BV, BKG_CONTAINER C," ).append("\n"); 
		query.append("SCE_COP_HDR H, PRD_PROD_CTL_ROUT_DTL G, VSK_VSL_PORT_SKD V, MST_CONTAINER M" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND    B.BKG_NO  = BV.BKG_NO" ).append("\n"); 
		query.append("AND    B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("AND    BV.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND    C.CNTR_NO = H.CNTR_NO" ).append("\n"); 
		query.append("AND    BV.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("AND    H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND    H.PCTL_NO = G.PCTL_NO(+)" ).append("\n"); 
		query.append("AND    G.NOD_LNK_DIV_CD(+) = 'N'" ).append("\n"); 
		query.append("AND    SUBSTR(G.ORG_NOD_CD,1,5) = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("AND    BV.SKD_VOY_NO    = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    BV.SKD_VOY_NO    = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    BV.SKD_DIR_CD    = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    LENGTH(@[vvd]) = 9" ).append("\n"); 
		query.append("AND    SUBSTR(@[vvd],1,4) <> 'CNTC'" ).append("\n"); 
		query.append("AND    V.VSL_CD         = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO     = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD     = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND    C.CNTR_NO        = M.CNTR_NO(+)" ).append("\n"); 
		query.append("AND    C.CNTR_NO        = @[cntr_no]" ).append("\n"); 
		query.append("GROUP BY B.BKG_CGO_TP_CD, B.BKG_STS_CD, B.POL_CD, BV.BKG_NO, BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD, C.CNTR_NO," ).append("\n"); 
		query.append("G.ORG_NOD_CD, V.VPS_ETB_DT, M.CNTR_TPSZ_CD, H.COP_NO, G.PCTL_NO, G.PCTL_SEQ" ).append("\n"); 
		query.append(") L, PRD_PROD_CTL_ROUT_DTL R, PRD_PROD_CTL_ROUT_DTL O" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND    L.PCTL_NO           = R.PCTL_NO(+)" ).append("\n"); 
		query.append("AND    R.NOD_LNK_DIV_CD(+) = 'L'" ).append("\n"); 
		query.append("AND    L.R_SEQ             = R.PCTL_SEQ(+)" ).append("\n"); 
		query.append("AND    L.PCTL_NO           = O.PCTL_NO(+)" ).append("\n"); 
		query.append("AND    O.NOD_LNK_DIV_CD(+) = 'L'" ).append("\n"); 
		query.append("AND    L.O_SEQ             = O.PCTL_SEQ(+)" ).append("\n"); 
		query.append("AND    NVL(@[io_bnd_cd],'N')    = DECODE(L.FM,'M',DECODE(SUBSTR(@[yd_cd],1,5),L.POL,'O','I')," ).append("\n"); 
		query.append("DECODE(NVL(R.TRSP_MOD_CD,'N')||NVL(O.TRSP_MOD_CD,'N')," ).append("\n"); 
		query.append("'WDTD','I',     'WDRD','I',     'VDTD','I'," ).append("\n"); 
		query.append("'VDRD','I',     'RDWD','O',     'RDVD','O'," ).append("\n"); 
		query.append("'TDWD','O',     'TDVD','O',     'WDN','I'," ).append("\n"); 
		query.append("'VDN','I',      'NVD','O',      'NWD','O'," ).append("\n"); 
		query.append("'WDVD',DECODE(L.VVD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("'VDWD',DECODE(L.VVD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("'WDWD',DECODE(L.VVD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("'VDVD',DECODE(L.VVD,R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')))" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE DIFF_RANK = 1" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT B.BKG_NO, M.CNTR_NO" ).append("\n"); 
		query.append("FROM   CTM_MOVEMENT M, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE  M.BKG_NO      = B.BKG_NO(+)" ).append("\n"); 
		query.append("AND    M.ORG_YD_CD   = @[yd_cd]" ).append("\n"); 
		query.append("AND    M.CNTR_NO     = @[cntr_no]" ).append("\n"); 
		query.append("AND    M.CNMV_EVNT_DT > TO_DATE(REPLACE(@[atb_dt],'-',''),'YYYYMMDD') - 7" ).append("\n"); 
		query.append("AND    M.CNMV_EVNT_DT < TO_DATE(REPLACE(@[atb_dt],'-',''),'YYYYMMDD') + 7" ).append("\n"); 
		query.append("AND    M.MVMT_STS_CD = DECODE(@[io_bnd_cd],'I','VD','VL')" ).append("\n"); 
		query.append("AND    M.FCNTR_FLG = 'Y' -- FULL CNTR" ).append("\n"); 
		query.append("AND    B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("AND    LENGTH(@[vvd]) = 9" ).append("\n"); 
		query.append("AND    SUBSTR(@[vvd],1,4) = 'CNTC'" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  DISTINCT B.BKG_NO, C.CNTR_NO" ).append("\n"); 
		query.append("FROM	BKG_BOOKING B, BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE	B.BKG_NO   = C.BKG_NO" ).append("\n"); 
		query.append("AND		C.CNTR_NO  = NVL(@[cntr_no],'')" ).append("\n"); 
		query.append("AND		B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("AND     C.CRE_DT BETWEEN TO_DATE(REPLACE(@[atb_dt],'-',''),'YYYYMMDD') - 7 AND TO_DATE(REPLACE(@[atb_dt],'-',''),'YYYYMMDD') + 7" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 
		query.append(") Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C.CNTR_NO = X.CNTR_NO(+)" ).append("\n"); 
		query.append("AND C.CNTR_NO = Y.CNTR_NO(+)" ).append("\n"); 
		query.append("AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN C.BKG_NO IS NOT NULL THEN C.BKG_NO" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END CNTR_CHK" ).append("\n"); 
		query.append("FROM MST_CONTAINER C" ).append("\n"); 
		query.append("WHERE C.CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",'N') CNTR_CHK FROM DUAL" ).append("\n"); 

	}
}