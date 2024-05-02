/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchPreEUportByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.23
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.05.23 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchPreEUportByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Finland (IE344) 용 / VVD 입력 후 FIKTK 이전의 EU port 를 조회한다.
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchPreEUportByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_fi_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_fi_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchPreEUportByVvdRSQL").append("\n"); 
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
		query.append("SELECT VPS_PORT_CD          AS P_FI_POL_CD" ).append("\n"); 
		query.append("     , SUBSTR(YD_CD, 6, 2)  AS P_FI_POL_YARD_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_CD_CONV_CTNT D" ).append("\n"); 
		query.append("     , (SELECT *" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("             , (SELECT B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, MAX(B.CLPT_SEQ) AS CLPT_SEQ" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A.VSL_CD = SUBSTR(@[p_fi_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = SUBSTR(@[p_fi_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = SUBSTR(@[p_fi_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                   AND NVL(A.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                   AND A.VPS_PORT_CD = @[p_fi_pod_cd]" ).append("\n"); 
		query.append("                   AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND NVL(B.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                   AND B.CLPT_SEQ < A.CLPT_SEQ" ).append("\n"); 
		query.append("              GROUP BY B.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD" ).append("\n"); 
		query.append("               ) AB" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND C.VSL_CD = AB.VSL_CD" ).append("\n"); 
		query.append("           AND C.SKD_VOY_NO = AB.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND C.SKD_DIR_CD = AB.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND NVL(C.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("           AND C.CLPT_SEQ = AB.CLPT_SEQ" ).append("\n"); 
		query.append("       ) ABC" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND D.CSTMS_DIV_ID = 'EU_MEMBER_CNT'" ).append("\n"); 
		query.append("   AND D.CNT_CD = 'EU'" ).append("\n"); 
		query.append("   AND SUBSTR(ABC.VPS_PORT_CD, 1, 2) = D.ATTR_CTNT1" ).append("\n"); 

	}
}