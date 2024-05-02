/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchDgLoadorDischargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.01
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.02.01 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchDgLoadorDischargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Transit에서 Load쪽 데이터인지 Import쪽 데이터 인지 조회한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchDgLoadorDischargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchDgLoadorDischargeRSQL").append("\n"); 
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
		query.append("SELECT CLPT_SEQ" ).append("\n"); 
		query.append("FROM(SELECT A.VSL_CD " ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.SLAN_CD " ).append("\n"); 
		query.append("                     , A.VPS_PORT_CD " ).append("\n"); 
		query.append("                     , A.YD_CD          AS EU_1ST_PORT_YD_CD " ).append("\n"); 
		query.append("                     , ROW_NUMBER() OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                          ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ ) AS CLPT_SEQ" ).append("\n"); 
		query.append("                     , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , B.ATTR_CTNT1 EU" ).append("\n"); 
		query.append("                 FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                    , BKG_CSTMS_CD_CONV_CTNT B" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND A.VSL_CD        =   SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                  AND A.SKD_VOY_NO    =   SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                  AND A.SKD_DIR_CD    =   SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                  AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                  AND B.CSTMS_DIV_ID(+)='EU_MEMBER_CNT'" ).append("\n"); 
		query.append("                  AND B.CNT_CD(+) = 'EU'" ).append("\n"); 
		query.append("                  AND SUBSTR(A.VPS_PORT_CD, 1, 2) = B.ATTR_CTNT1(+) )" ).append("\n"); 
		query.append("WHERE EU IS NOT NULL      " ).append("\n"); 
		query.append("AND ROWNUM = 1 " ).append("\n"); 

	}
}