/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchPrntOfcCdBySRepCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchPrntOfcCdBySRepCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SLS_REP_CD 로 AS 인 PRN_ OFC_CD 정보를 조회한다.
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchPrntOfcCdBySRepCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration ").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchPrntOfcCdBySRepCdRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN SUBSTR(A.OFC_CD,4) = 'AS' THEN A.OFC_CD" ).append("\n"); 
		query.append("            WHEN SUBSTR(B.OFC_CD,4) = 'AS' THEN B.OFC_CD" ).append("\n"); 
		query.append("            WHEN SUBSTR(C.OFC_CD,4) = 'AS' THEN C.OFC_CD" ).append("\n"); 
		query.append("            WHEN SUBSTR(D.OFC_CD,4) = 'AS' THEN D.OFC_CD" ).append("\n"); 
		query.append("            ELSE A.OFC_CD" ).append("\n"); 
		query.append("       END  PRNT_OFC_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("     , MDM_ORGANIZATION B" ).append("\n"); 
		query.append("     , MDM_ORGANIZATION C" ).append("\n"); 
		query.append("     , MDM_ORGANIZATION D" ).append("\n"); 
		query.append(" WHERE A.OFC_CD    = (SELECT OFC_CD FROM MDM_SLS_REP WHERE SREP_CD = @[srep_cd] AND ROWNUM = 1)" ).append("\n"); 
		query.append("   AND B.OFC_CD(+) = A.PRNT_OFC_CD" ).append("\n"); 
		query.append("   AND C.OFC_CD(+) = B.PRNT_OFC_CD" ).append("\n"); 
		query.append("   AND D.OFC_CD(+) = C.PRNT_OFC_CD" ).append("\n"); 

	}
}