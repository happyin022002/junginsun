/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchHeaderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchHeaderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Flat File Header 정보를 조회한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchHeaderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofcCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchHeaderRSQL").append("\n"); 
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
		query.append("    RPAD(NVL(TRIM(SUB1.SENDER),' '),20,' ')||" ).append("\n"); 
		query.append("    RPAD(NVL(TRIM(SUB1.RECEIVER),' '),20,' ')||" ).append("\n"); 
		query.append("    RPAD(NVL(TRIM('IFTDGN'),' '),10,' ')||" ).append("\n"); 
		query.append("    RPAD('BKC' || TO_CHAR(SYSDATE, 'YYMMDD') || LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009')),15,' ') HEADER" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("                WHEN (SUBSTR(@[ofcCd],1,3) = 'ANR' OR SUBSTR(@[ofcCd],1,3) = 'RTM') THEN 'SMLINE'" ).append("\n"); 
		query.append("                WHEN (" ).append("\n"); 
		query.append("                            SUBSTR(@[ofcCd],1,3) = 'BRV' " ).append("\n"); 
		query.append("                        OR  SUBSTR(@[ofcCd],1,3) = 'HAM'" ).append("\n"); 
		query.append("                        OR  SUBSTR(@[ofcCd],1,3) = 'FXT'" ).append("\n"); 
		query.append("                        OR  SUBSTR(@[ofcCd],1,3) = 'LEH'" ).append("\n"); 
		query.append("                        OR  SUBSTR(@[ofcCd],1,3) = 'FOS'" ).append("\n"); 
		query.append("                     ) THEN 'SML'" ).append("\n"); 
		query.append("                ELSE 'TEST_SENDER'" ).append("\n"); 
		query.append("              END SENDER" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              ,CASE" ).append("\n"); 
		query.append("                WHEN SUBSTR(@[ofcCd],1,3) = 'ANR' THEN '102401'" ).append("\n"); 
		query.append("                WHEN SUBSTR(@[ofcCd],1,3) = 'BRV' THEN 'DBH'" ).append("\n"); 
		query.append("                WHEN SUBSTR(@[ofcCd],1,3) = 'HAM' THEN 'DAK'" ).append("\n"); 
		query.append("                WHEN SUBSTR(@[ofcCd],1,3) = 'FXT' THEN 'FCPHJN'" ).append("\n"); 
		query.append("                WHEN SUBSTR(@[ofcCd],1,3) = 'LEH' THEN 'FRHAVREPORTKBMD'" ).append("\n"); 
		query.append("                WHEN SUBSTR(@[ofcCd],1,3) = 'FOS' THEN 'APPLUS'" ).append("\n"); 
		query.append("                WHEN SUBSTR(@[ofcCd],1,3) = 'RTM' THEN 'NLRTMHBR'" ).append("\n"); 
		query.append("                ELSE 'TEST_RECEIVER'" ).append("\n"); 
		query.append("              END RECEIVER " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("    ) SUB1" ).append("\n"); 

	}
}