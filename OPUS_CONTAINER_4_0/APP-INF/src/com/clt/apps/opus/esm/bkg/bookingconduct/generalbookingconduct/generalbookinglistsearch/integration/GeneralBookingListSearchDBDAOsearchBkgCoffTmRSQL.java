/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOsearchBkgCoffTmRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOsearchBkgCoffTmRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking close / reopen하기 위한 list를 조회한다.
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOsearchBkgCoffTmRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_clz_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOsearchBkgCoffTmRSQL").append("\n"); 
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
		query.append("SELECT BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("        , BKG.POL_CD" ).append("\n"); 
		query.append("        , BKG.YD_CD" ).append("\n"); 
		query.append("        , BKG.BKG_OFC_CD " ).append("\n"); 
		query.append("        , nvl(COFF.BKG_CLZ_STS_CD, 'O') BKG_CLZ_STS_CD" ).append("\n"); 
		query.append("        , decode(COFF.BKG_CLZ_STS_CD,null, 'Open','C','Closed','R','Re-open') BKG_CLZ_STS_NM" ).append("\n"); 
		query.append("        , USR.OFC_CD" ).append("\n"); 
		query.append("        , COFF.UPD_USR_ID" ).append("\n"); 
		query.append("        , (SELECT USR_NM FROM COM_USER WHERE USR_ID =COFF.UPD_USR_ID) USR_NM" ).append("\n"); 
		query.append("        , TO_CHAR(COFF.UPD_DT, 'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("        , BKG.VSL_CD" ).append("\n"); 
		query.append("        , BKG.SKD_VOY_NO" ).append("\n"); 
		query.append("        , BKG.SKD_DIR_CD" ).append("\n"); 
		query.append("        , BKG.POL_CLPT_IND_SEQ AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("  FROM        " ).append("\n"); 
		query.append("    (SELECT DISTINCT VVD.VSL_CD" ).append("\n"); 
		query.append("            , VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("            , VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("            , VVD.POL_CD" ).append("\n"); 
		query.append("            , SUBSTR(VVD.POL_YD_CD, 6, 2) YD_CD" ).append("\n"); 
		query.append("            , VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("            , BK.BKG_OFC_CD" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BK, BKG_VVD VVD" ).append("\n"); 
		query.append("     WHERE BK.BKG_NO        = VVD.BKG_NO " ).append("\n"); 
		query.append("       AND BK.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("       AND BK.POL_CD        = VVD.POL_CD" ).append("\n"); 
		query.append("#if (${vsl_cd}!='')" ).append("\n"); 
		query.append("       AND VVD.VSL_CD       = SUBSTR(@[vsl_cd], 1, 4) " ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO   = SUBSTR(@[vsl_cd], 5, 4) " ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD   = SUBSTR(@[vsl_cd], 9, 1) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd} != '' && ${yd_cd} != '')" ).append("\n"); 
		query.append("       AND VVD.POL_YD_CD    = @[pol_cd]||@[yd_cd]" ).append("\n"); 
		query.append("#elseif (${pol_cd} != '')" ).append("\n"); 
		query.append("       AND VVD.POL_CD       = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#if (${ofc_cd} != '' && ${ofc_cd} !='All' )       " ).append("\n"); 
		query.append("       AND BK.BKG_OFC_CD    = @[ofc_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) BKG " ).append("\n"); 
		query.append("        , BKG_COFF_TM COFF, COM_USER USR" ).append("\n"); 
		query.append("WHERE BKG.VSL_CD = COFF.VSL_CD(+)" ).append("\n"); 
		query.append("  AND BKG.SKD_VOY_NO = COFF.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND BKG.SKD_DIR_CD = COFF.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND BKG.POL_CD = COFF.POL_CD(+)        " ).append("\n"); 
		query.append("  AND BKG.BKG_OFC_CD = COFF.BKG_OFC_CD(+) " ).append("\n"); 
		query.append("  AND BKG.POL_CLPT_IND_SEQ = COFF.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("#if (${bkg_clz_sts_cd} != '' && ${bkg_clz_sts_cd} !='All' && ${bkg_clz_sts_cd} !='M') " ).append("\n"); 
		query.append("  AND nvl(COFF.BKG_CLZ_STS_CD, 'O') = @[bkg_clz_sts_cd]" ).append("\n"); 
		query.append("#elseif (${bkg_clz_sts_cd} != '' && ${bkg_clz_sts_cd} =='M') " ).append("\n"); 
		query.append("  AND nvl(COFF.BKG_CLZ_STS_CD, 'O') in ('O','R')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND COFF.UPD_USR_ID = USR.USR_ID(+)" ).append("\n"); 

	}
}