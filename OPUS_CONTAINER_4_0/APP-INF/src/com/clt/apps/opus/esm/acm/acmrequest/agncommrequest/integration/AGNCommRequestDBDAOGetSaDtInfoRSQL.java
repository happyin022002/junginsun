/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestDBDAOGetSaDtInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.20
*@LastModifier :
*@LastVersion : 1.0
* 2012.08.20
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOGetSaDtInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * GetSaDtInfo
	  * 부킹의 Sail Arrival Date를 구함
	  * </pre>
	  */
	public AGNCommRequestDBDAOGetSaDtInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration").append("\n");
		query.append("FileName : AGNCommRequestDBDAOGetSaDtInfoRSQL").append("\n");
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
		query.append("WITH O AS (" ).append("\n");
		query.append("" ).append("\n");
		query.append("    SELECT " ).append("\n");
		query.append("     ROW_NUMBER()OVER(PARTITION BY V.BKG_NO ORDER BY VSL_PRE_PST_CD,VSL_SEQ )           RN_ASK" ).append("\n");
		query.append("    ,ROW_NUMBER()OVER(PARTITION BY V.BKG_NO ORDER BY VSL_PRE_PST_CD DESC,VSL_SEQ DESC ) RN_DSK" ).append("\n");
		query.append("    ,V.BKG_NO,V.VSL_PRE_PST_CD,V.VSL_SEQ,V.SLAN_CD,V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD" ).append("\n");
		query.append("    ,V.POL_CD " ).append("\n");
		query.append("    ,TO_CHAR(POL.VPS_ETA_DT,'YYYYMMDD') POL_ETA " ).append("\n");
		query.append("    ,TO_CHAR(POL.VPS_ETD_DT,'YYYYMMDD') POL_ETD" ).append("\n");
		query.append("" ).append("\n");
		query.append("    ,DECODE(V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n");
		query.append("           ,SUBSTR(NVL(N1ST_FINC_VVD_CD,'X'),1,9),N1ST_RLANE_CD" ).append("\n");
		query.append("           ,SUBSTR(NVL(N2ND_FINC_VVD_CD,'X'),1,9),N2ND_RLANE_CD" ).append("\n");
		query.append("           ,SUBSTR(NVL(N3RD_FINC_VVD_CD,'X'),1,9),N3RD_RLANE_CD" ).append("\n");
		query.append("           ,SUBSTR(NVL(N4TH_FINC_VVD_CD,'X'),1,9),N4TH_RLANE_CD" ).append("\n");
		query.append("           ,'')                                AS RLANE_CD" ).append("\n");
		query.append("    ,DECODE(V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n");
		query.append("           ,SUBSTR(NVL(N1ST_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N1ST_FINC_VVD_CD,'X'),10,1)" ).append("\n");
		query.append("           ,SUBSTR(NVL(N2ND_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N2ND_FINC_VVD_CD,'X'),10,1)" ).append("\n");
		query.append("           ,SUBSTR(NVL(N3RD_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N3RD_FINC_VVD_CD,'X'),10,1)" ).append("\n");
		query.append("           ,SUBSTR(NVL(N4TH_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N4TH_FINC_VVD_CD,'X'),10,1)" ).append("\n");
		query.append("           ,'')                               AS REV_DIR_CD" ).append("\n");
		query.append("    FROM BKG_VVD V, " ).append("\n");
		query.append("         COA_RGST_BKG C," ).append("\n");
		query.append("         VSK_VSL_PORT_SKD POL" ).append("\n");
		query.append("    WHERE V.BKG_NO          = @[bkg_no] --'AAR200100200' AAR103480100" ).append("\n");
		query.append("    AND C.BKG_NO            = V.BKG_NO " ).append("\n");
		query.append("    " ).append("\n");
		query.append("    AND V.VSL_CD            = POL.VSL_CD" ).append("\n");
		query.append("    AND V.SKD_VOY_NO        = POL.SKD_VOY_NO" ).append("\n");
		query.append("    AND V.SKD_DIR_CD        = POL.SKD_DIR_CD" ).append("\n");
		query.append("    AND V.POL_CD            = POL.VPS_PORT_CD" ).append("\n");
		query.append("    AND NVL(V.POL_CLPT_IND_SEQ,1)  = NVL(POL.CLPT_IND_SEQ,1)" ).append("\n");
		query.append("    AND NVL(POL.SKD_CNG_STS_CD,'*') <> 'S' " ).append("\n");
		query.append("    ORDER BY V.VSL_PRE_PST_CD,V.VSL_SEQ" ).append("\n");
		query.append(")" ).append("\n");
		query.append(",I AS(" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("    SELECT " ).append("\n");
		query.append("     ROW_NUMBER()OVER(PARTITION BY V.BKG_NO ORDER BY VSL_PRE_PST_CD,VSL_SEQ )           RN_ASK" ).append("\n");
		query.append("    ,ROW_NUMBER()OVER(PARTITION BY V.BKG_NO ORDER BY VSL_PRE_PST_CD DESC,VSL_SEQ DESC ) RN_DSK" ).append("\n");
		query.append("    ,V.BKG_NO,V.VSL_PRE_PST_CD,V.VSL_SEQ,V.SLAN_CD,V.VSL_CD,V.SKD_VOY_NO,V.SKD_DIR_CD" ).append("\n");
		query.append("    ,V.POD_CD" ).append("\n");
		query.append("    ,TO_CHAR(POD.VPS_ETA_DT,'YYYYMMDD') POD_ETA" ).append("\n");
		query.append("    ,TO_CHAR(POD.VPS_ETD_DT,'YYYYMMDD') POD_ETD" ).append("\n");
		query.append("" ).append("\n");
		query.append("    ,DECODE(V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n");
		query.append("           ,SUBSTR(NVL(N1ST_FINC_VVD_CD,'X'),1,9),N1ST_RLANE_CD" ).append("\n");
		query.append("           ,SUBSTR(NVL(N2ND_FINC_VVD_CD,'X'),1,9),N2ND_RLANE_CD" ).append("\n");
		query.append("           ,SUBSTR(NVL(N3RD_FINC_VVD_CD,'X'),1,9),N3RD_RLANE_CD" ).append("\n");
		query.append("           ,SUBSTR(NVL(N4TH_FINC_VVD_CD,'X'),1,9),N4TH_RLANE_CD" ).append("\n");
		query.append("           ,'')                                AS RLANE_CD" ).append("\n");
		query.append("    ,DECODE(V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n");
		query.append("           ,SUBSTR(NVL(N1ST_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N1ST_FINC_VVD_CD,'X'),10,1)" ).append("\n");
		query.append("           ,SUBSTR(NVL(N2ND_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N2ND_FINC_VVD_CD,'X'),10,1)" ).append("\n");
		query.append("           ,SUBSTR(NVL(N3RD_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N3RD_FINC_VVD_CD,'X'),10,1)" ).append("\n");
		query.append("           ,SUBSTR(NVL(N4TH_FINC_VVD_CD,'X'),1,9),SUBSTR(NVL(N4TH_FINC_VVD_CD,'X'),10,1)" ).append("\n");
		query.append("           ,'')                               AS REV_DIR_CD" ).append("\n");
		query.append("    FROM BKG_VVD V, " ).append("\n");
		query.append("         COA_RGST_BKG C," ).append("\n");
		query.append("         VSK_VSL_PORT_SKD POD" ).append("\n");
		query.append("    WHERE V.BKG_NO          = @[bkg_no] --'AAR200100200' AAR103480100" ).append("\n");
		query.append("    AND C.BKG_NO            = V.BKG_NO " ).append("\n");
		query.append("    " ).append("\n");
		query.append("    AND V.VSL_CD            = POD.VSL_CD" ).append("\n");
		query.append("    AND V.SKD_VOY_NO        = POD.SKD_VOY_NO" ).append("\n");
		query.append("    AND V.SKD_DIR_CD        = POD.SKD_DIR_CD" ).append("\n");
		query.append("    AND V.POD_CD            = POD.VPS_PORT_CD" ).append("\n");
		query.append("    AND NVL(V.POD_CLPT_IND_SEQ,1)  = NVL(POD.CLPT_IND_SEQ,1)" ).append("\n");
		query.append("    AND NVL(POD.SKD_CNG_STS_CD,'*') <> 'S' " ).append("\n");
		query.append("" ).append("\n");
		query.append("    ORDER BY V.VSL_PRE_PST_CD,V.VSL_SEQ    " ).append("\n");
		query.append(")" ).append("\n");
		query.append("" ).append("\n");
		query.append("SELECT " ).append("\n");
		query.append("  OB.BKG_NO" ).append("\n");
		query.append(", OB.POL_ETD                              AS OB_SA_DT" ).append("\n");
		query.append(", OB.VSL_CD||OB.SKD_VOY_NO||OB.SKD_DIR_CD AS OB_VVD" ).append("\n");
		query.append(", OB.VSL_CD                               AS OB_VSL_CD" ).append("\n");
		query.append(", OB.SKD_VOY_NO                           AS OB_SKD_VOY_NO" ).append("\n");
		query.append(", OB.SKD_DIR_CD                           AS OB_SKD_DIR_CD" ).append("\n");
		query.append(", OB.POL_CD                               AS OB_PORT" ).append("\n");
		query.append(", OB.SLAN_CD                              AS OB_SLAN_CD" ).append("\n");
		query.append(", OB.RLANE_CD                             AS OB_RLANE_CD" ).append("\n");
		query.append(", OB.REV_DIR_CD                           AS OB_REV_DIR_CD" ).append("\n");
		query.append("" ).append("\n");
		query.append(", IB.POD_ETA                              AS IB_SA_DT" ).append("\n");
		query.append(", IB.VSL_CD||IB.SKD_VOY_NO||IB.SKD_DIR_CD AS IB_VVD" ).append("\n");
		query.append(", IB.VSL_CD                               AS IB_VSL_CD" ).append("\n");
		query.append(", IB.SKD_VOY_NO                           AS IB_SKD_VOY_NO" ).append("\n");
		query.append(", IB.SKD_DIR_CD                           AS IB_SKD_DIR_CD" ).append("\n");
		query.append(", IB.POD_CD                               AS IB_PORT" ).append("\n");
		query.append(", IB.SLAN_CD                              AS IB_SLAN_CD" ).append("\n");
		query.append(", IB.RLANE_CD                             AS IB_RLANE_CD" ).append("\n");
		query.append(", IB.REV_DIR_CD                           AS IB_REV_DIR_CD" ).append("\n");
		query.append("" ).append("\n");
		query.append("FROM O OB, I IB" ).append("\n");
		query.append("WHERE 1=1" ).append("\n");
		query.append("AND OB.VSL_PRE_PST_CD IN ( 'T','S' )" ).append("\n");
		query.append("AND OB.RN_ASK = 1" ).append("\n");
		query.append("AND IB.VSL_PRE_PST_CD IN ( 'T','U' )" ).append("\n");
		query.append("AND IB.RN_DSK = 1" ).append("\n");

	}
}