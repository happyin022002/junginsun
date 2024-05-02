/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByLessorAgmtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.18 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchMGSInventoryByLessorAgmtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090910 2077 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchMGSInventoryByLessorAgmtDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByLessorAgmtDataRSQL").append("\n"); 
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
		query.append("C.VNDR_ABBR_NM||' ('||A.VNDR_SEQ||')' AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(", A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append(", B.AGMT_REF_NO AS AGMT_REF_NO" ).append("\n"); 
		query.append(", COUNT(*) AS EQ_TPSZ_CD_TOTAL" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'UMG' THEN 1 END),0) AS EQ_TPSZ_CD_UMG" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN A.EQ_TPSZ_CD = 'CLG' THEN 1 END),0) AS EQ_TPSZ_CD_CLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A, CGM_AGREEMENT B, MDM_VENDOR C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO =  B.AGMT_VER_NO (+)" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD (+)" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ (+)" ).append("\n"); 
		query.append("AND A.VNDR_SEQ = C.VNDR_SEQ (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A.AGMT_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("AND A.VNDR_SEQ IS NOT NULL" ).append("\n"); 
		query.append("#if (${crnt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND B.AGMT_ISS_OFC_CD IN ($crnt_ofc_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("AND B.VNDR_SEQ IN ($vndr_seq)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_lstm_cd} != '')" ).append("\n"); 
		query.append("AND A.AGMT_LSTM_CD IN ($agmt_lstm_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY C.VNDR_ABBR_NM||' ('||A.VNDR_SEQ||')' , (A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')) , B.AGMT_REF_NO" ).append("\n"); 
		query.append("ORDER BY C.VNDR_ABBR_NM||' ('||A.VNDR_SEQ||')' , (A.AGMT_OFC_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0')) , B.AGMT_REF_NO" ).append("\n"); 

	}
}