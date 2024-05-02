/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchNmcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchNmcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NMC Form 을 조회한다.
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchNmcRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchNmcRSQL").append("\n"); 
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
		query.append("SELECT substr(d.CSTMS_DESC, 1, 200) ITEM_DESC," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    select c.CNTR_TPSZ_CD||' '||m.cntr_tpsz_desc" ).append("\n"); 
		query.append("    from mdm_cntr_tp_sz m" ).append("\n"); 
		query.append("    where c.CNTR_TPSZ_CD = m.CNTR_TPSZ_CD) TP," ).append("\n"); 
		query.append("  d.PCK_QTY||' '||(select m.PCK_NM from mdm_pck_tp m where d.PCK_TP_CD = m.pck_cd) QTY," ).append("\n"); 
		query.append("  d.ACT_WGT||' '||d.WGT_UT_CD WGT," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT L.LOC_NM||', '||C.CNT_NM" ).append("\n"); 
		query.append("    FROM MDM_LOCATION L," ).append("\n"); 
		query.append("      MDM_COUNTRY C" ).append("\n"); 
		query.append("    WHERE L.LOC_CD = B.POL_CD" ).append("\n"); 
		query.append("      AND L.CNT_CD = C.CNT_CD) POL," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT C.VSL_ENG_NM||' '||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("    FROM BKG_VVD V," ).append("\n"); 
		query.append("      MDM_VSL_CNTR C" ).append("\n"); 
		query.append("    WHERE V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND V.POL_CD = B.POL_CD" ).append("\n"); 
		query.append("      AND V.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("      AND ROWNUM = 1) INBOUND," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT TO_CHAR(VPS_ETA_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD S," ).append("\n"); 
		query.append("      BKG_VVD V" ).append("\n"); 
		query.append("    WHERE V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND B.POL_CD = V.POL_CD" ).append("\n"); 
		query.append("      AND S.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("      AND S.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND S.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND S.VPS_PORT_CD = V.POD_CD" ).append("\n"); 
		query.append("      AND S.CLPT_IND_SEQ = '1') A_DATE," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT L.LOC_NM||', '||'KOREA'" ).append("\n"); 
		query.append("    FROM MDM_LOCATION L," ).append("\n"); 
		query.append("      MDM_COUNTRY C," ).append("\n"); 
		query.append("      BKG_VVD V" ).append("\n"); 
		query.append("    WHERE V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND V.POL_CD LIKE 'KR%'" ).append("\n"); 
		query.append("      AND L.LOC_CD = V.POL_CD" ).append("\n"); 
		query.append("      AND L.CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("      AND ROWNUM = 1) KR_POL," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT C.VSL_ENG_NM||' '||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("    FROM BKG_VVD V," ).append("\n"); 
		query.append("      MDM_VSL_CNTR C" ).append("\n"); 
		query.append("    WHERE V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND V.POL_CD LIKE 'KR%'" ).append("\n"); 
		query.append("      AND V.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("      AND ROWNUM = 1) OUTBOUND," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT TO_CHAR(VPS_ETD_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD S," ).append("\n"); 
		query.append("      BKG_VVD V" ).append("\n"); 
		query.append("    WHERE V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("      AND V.POL_CD LIKE 'KR%'" ).append("\n"); 
		query.append("      AND S.VSL_CD = V.VSL_CD" ).append("\n"); 
		query.append("      AND S.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND S.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND S.VPS_PORT_CD = V.POL_CD" ).append("\n"); 
		query.append("      AND S.CLPT_IND_SEQ = '1') D_DATE," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT L.LOC_NM||', '||C.CNT_NM" ).append("\n"); 
		query.append("    FROM MDM_LOCATION L," ).append("\n"); 
		query.append("      MDM_COUNTRY C" ).append("\n"); 
		query.append("    WHERE L.LOC_CD = B.DEL_CD" ).append("\n"); 
		query.append("      AND L.CNT_CD = C.CNT_CD) DEL," ).append("\n"); 
		query.append("  'SMLM'||b.bkg_No BL_NO," ).append("\n"); 
		query.append("  c.cntr_no," ).append("\n"); 
		query.append("  TO_CHAR(SYSDATE, 'YYYY.MM.DD') TODAY" ).append("\n"); 
		query.append("FROM BKG_BOOKING B," ).append("\n"); 
		query.append("  bkg_container c," ).append("\n"); 
		query.append("  bkg_bl_doc d" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${bkg_no} !='') " ).append("\n"); 
		query.append("  AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} !='') " ).append("\n"); 
		query.append("  AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} !='') " ).append("\n"); 
		query.append("  AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  and b.bkg_no = c.bkg_no" ).append("\n"); 
		query.append("  and b.bkg_no = d.bkg_no" ).append("\n"); 
		query.append(" AND ROWNUM = 1" ).append("\n"); 

	}
}