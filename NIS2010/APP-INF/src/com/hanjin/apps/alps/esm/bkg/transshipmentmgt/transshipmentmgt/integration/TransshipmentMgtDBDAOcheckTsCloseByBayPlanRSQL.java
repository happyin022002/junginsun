/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TransshipmentMgtDBDAOcheckTsCloseByBayPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.28
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.01.28 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOcheckTsCloseByBayPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Transshipment Close에 해당되는지 확인
	  * </pre>
	  */
	public TransshipmentMgtDBDAOcheckTsCloseByBayPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("former_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOcheckTsCloseByBayPlanRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NEXT_VVD.BKG_CLZ_STS_CD, 'C', NEXT_VVD.VVD, NULL)" ).append("\n"); 
		query.append("            ||','||DECODE(NEW_VVD.BKG_CLZ_STS_CD, 'C', NEW_VVD.VVD, NULL) VVD" ).append("\n"); 
		query.append("  FROM                     " ).append("\n"); 
		query.append("    (SELECT VVD.BKG_NO, COFF.BKG_CLZ_STS_CD, VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      FROM BKG_VVD VVD, BKG_TS_COFF_TM COFF  " ).append("\n"); 
		query.append("     WHERE VVD.VSL_CD           = COFF.VSL_CD(+)" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO       = COFF.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD       = COFF.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("       AND VVD.POL_CD           = COFF.POL_CD(+)" ).append("\n"); 
		query.append("       AND VVD.POL_CLPT_IND_SEQ = COFF.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("       AND VVD.VSL_CD           = SUBSTR(NVL(@[next_vvd], @[former_vvd]), 1, 4)" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO       = SUBSTR(NVL(@[next_vvd], @[former_vvd]), 5, 4)" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD       = SUBSTR(NVL(@[next_vvd], @[former_vvd]), 9, 1)" ).append("\n"); 
		query.append("       AND VVD.BKG_NO           = @[bkg_no]) NEXT_VVD," ).append("\n"); 
		query.append("    (SELECT VVD.BKG_NO, COFF.BKG_CLZ_STS_CD, @[new_vvd] VVD" ).append("\n"); 
		query.append("      FROM BKG_VVD VVD, BKG_TS_COFF_TM COFF  " ).append("\n"); 
		query.append("     WHERE SUBSTR(@[new_vvd], 1, 4) = COFF.VSL_CD(+)" ).append("\n"); 
		query.append("       AND SUBSTR(@[new_vvd], 5, 4) = COFF.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("       AND SUBSTR(@[new_vvd], 9, 4) = COFF.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("       AND VVD.POL_CD           = COFF.POL_CD(+)" ).append("\n"); 
		query.append("       AND VVD.POL_CLPT_IND_SEQ = COFF.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("       AND VVD.VSL_CD           = SUBSTR(NVL(@[next_vvd], @[former_vvd]), 1, 4)" ).append("\n"); 
		query.append("       AND VVD.SKD_VOY_NO       = SUBSTR(NVL(@[next_vvd], @[former_vvd]), 5, 4)" ).append("\n"); 
		query.append("       AND VVD.SKD_DIR_CD       = SUBSTR(NVL(@[next_vvd], @[former_vvd]), 9, 1)" ).append("\n"); 
		query.append("       AND VVD.BKG_NO           = @[bkg_no]) NEW_VVD" ).append("\n"); 
		query.append(" WHERE NEXT_VVD.BKG_NO = NEW_VVD.BKG_NO(+)" ).append("\n"); 

	}
}