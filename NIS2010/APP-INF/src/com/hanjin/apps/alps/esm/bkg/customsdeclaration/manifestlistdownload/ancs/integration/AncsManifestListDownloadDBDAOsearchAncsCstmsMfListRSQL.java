/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsMfListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.19
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2012.03.19 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOsearchAncsCstmsMfListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOsearchAncsCstmsMfListRSQL(){
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
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOsearchAncsCstmsMfListRSQL").append("\n"); 
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
		query.append("A.POL_CD AS POL," ).append("\n"); 
		query.append("C.VPS_ETD_DT AS POL_ATD, " ).append("\n"); 
		query.append("A.POD_CD AS POD," ).append("\n"); 
		query.append("DECODE(D.TRNK_AUTO_BDR_DT, NULL, DECODE(D.TRNK_MNL_BDR_DT, NULL, 'N', 'Y'), 'Y') AS BDR," ).append("\n"); 
		query.append("DECODE(D.TRNK_AUTO_BDR_DT, NULL, DECODE(D.TRNK_MNL_BDR_DT, NULL, NULL, TO_CHAR(D.TRNK_MNL_BDR_DT,'YYYY-MM-DD HH24:MI')), TO_CHAR(D.TRNK_AUTO_BDR_DT,'YYYY-MM-DD HH24:MI')) AS BDR_DATE," ).append("\n"); 
		query.append("COUNT(DISTINCT B.BKG_NO) AS BL," ).append("\n"); 
		query.append("COUNT(DISTINCT E.BKG_NO) AS DNLD," ).append("\n"); 
		query.append("COUNT(DISTINCT DECODE(E.ANR_MSG_STS_CD, 'A', E.BKG_NO, NULL)) AS ACPT," ).append("\n"); 
		query.append("COUNT(DISTINCT B.BKG_NO) - COUNT(DISTINCT E.BKG_NO) AS DIFF," ).append("\n"); 
		query.append("COUNT(DISTINCT H.CNTR_NO) AS CNTR," ).append("\n"); 
		query.append("COUNT(DISTINCT I.CNTR_NO) AS CNTR_DNLD," ).append("\n"); 
		query.append("COUNT(DISTINCT DECODE(I.ANR_MSG_STS_CD, 'A', I.CNTR_NO, NULL)) AS CNTR_ACPT," ).append("\n"); 
		query.append("(COUNT(DISTINCT H.CNTR_NO) - COUNT(DISTINCT I.CNTR_NO)) AS CNTR_DIFF" ).append("\n"); 
		query.append("FROM BKG_VVD A, BKG_BOOKING B, VSK_VSL_PORT_SKD C, " ).append("\n"); 
		query.append("     BKG_VVD_BDR_LOG D, BKG_CSTMS_ANR_BL E, BKG_CSTMS_ANR_VVD F," ).append("\n"); 
		query.append("     BKG_CSTMS_ANR_CNTR G, BKG_CONTAINER H, BKG_CSTMS_ANR_CNTR I" ).append("\n"); 
		query.append(" WHERE A.VSL_CD       =  SUBSTR( @[vvd],1,4 )" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO   =  SUBSTR( @[vvd],5,4 )" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD   =  SUBSTR( @[vvd],9,1 )" ).append("\n"); 
		query.append("   AND A.POD_CD = @[pod]" ).append("\n"); 
		query.append("AND B.BKG_NO       = A.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD   <> 'X'" ).append("\n"); 
		query.append("AND B.BKG_CGO_TP_CD IN ('F', 'B')" ).append("\n"); 
		query.append("AND C.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND C.VPS_PORT_CD  = A.POL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND C.CLPT_IND_SEQ = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND D.VSL_CD(+)       = A.VSL_CD" ).append("\n"); 
		query.append("AND D.SKD_VOY_NO(+)   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND D.SKD_DIR_CD(+)   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND D.POL_CLPT_IND_SEQ(+) = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND D.POD_CLPT_IND_SEQ(+) = A.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND D.POL_CD(+)  = A.POL_CD" ).append("\n"); 
		query.append("AND D.POD_CD(+)  = A.POD_CD" ).append("\n"); 
		query.append("AND E.VSL_CD(+)       = A.VSL_CD" ).append("\n"); 
		query.append("AND E.SKD_VOY_NO(+)   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND E.SKD_DIR_CD(+)   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND E.BKG_NO(+)       = A.BKG_NO" ).append("\n"); 
		query.append("AND F.VSL_CD   = A.VSL_CD" ).append("\n"); 
		query.append("AND F.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND F.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND G.VSL_CD(+)     = E.VSL_CD" ).append("\n"); 
		query.append("AND G.SKD_VOY_NO(+) = E.SKD_VOY_NO" ).append("\n"); 
		query.append("AND G.SKD_DIR_CD(+) = E.SKD_DIR_CD" ).append("\n"); 
		query.append("AND G.BKG_NO(+)     = E.BKG_NO" ).append("\n"); 
		query.append("AND H.BKG_NO(+)          = B.BKG_NO" ).append("\n"); 
		query.append("AND I.VSL_CD(+)       = E.VSL_CD" ).append("\n"); 
		query.append("AND I.SKD_VOY_NO(+)   = E.SKD_VOY_NO" ).append("\n"); 
		query.append("AND I.SKD_DIR_CD(+)   = E.SKD_DIR_CD" ).append("\n"); 
		query.append("AND I.BKG_NO(+)       = E.BKG_NO" ).append("\n"); 
		query.append("GROUP BY A.POL_CD, C.VPS_ETD_DT, A.POD_CD," ).append("\n"); 
		query.append("DECODE(D.TRNK_AUTO_BDR_DT, NULL, DECODE(D.TRNK_MNL_BDR_DT, NULL, 'N', 'Y'), 'Y')," ).append("\n"); 
		query.append("DECODE(D.TRNK_AUTO_BDR_DT, NULL, DECODE(D.TRNK_MNL_BDR_DT, NULL, NULL, TO_CHAR(D.TRNK_MNL_BDR_DT,'YYYY-MM-DD HH24:MI')), TO_CHAR(D.TRNK_AUTO_BDR_DT,'YYYY-MM-DD HH24:MI'))" ).append("\n"); 

	}
}