/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.05.11 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOsearchUsWhfSendHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfSendHis
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfSendHisRSQL(){
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
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendHisRSQL").append("\n"); 
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
		query.append("SELECT  TB.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT  A.CNTC_EML" ).append("\n"); 
		query.append("               ,A.FAX_EML_SND_RSLT_MSG" ).append("\n"); 
		query.append("               ,DECODE(A.SND_ID, NULL, '', A.SND_USR_ID) AS SND_ID" ).append("\n"); 
		query.append("               ,DECODE(A.SND_ID, NULL, '', B.USR_NM) AS SND_USR_ID" ).append("\n"); 
		query.append("               ,A.HIS_SEQ" ).append("\n"); 
		query.append("               ,ROW_NUMBER() OVER(ORDER BY A.HIS_SEQ DESC) AS RNUM" ).append("\n"); 
		query.append("               ,'M' AS NTC_VIA_CD" ).append("\n"); 
		query.append("               ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SND_RQST_DT, BKG_COM_USER_LOC_FNC(SND_USR_ID)), 'YYYY-MM-DD HH24:MI') AS SND_DT" ).append("\n"); 
		query.append("          FROM  BKG_USA_WHF_SND_HIS A" ).append("\n"); 
		query.append("               ,COM_USER B" ).append("\n"); 
		query.append("         WHERE  A.SND_USR_ID = B.USR_ID(+)" ).append("\n"); 
		query.append("           AND  A.VSL_CD(+) = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND  A.SKD_VOY_NO(+) = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND  A.SKD_DIR_CD(+) = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("           AND  A.PORT_CD(+) = @[port]" ).append("\n"); 
		query.append("           AND  A.IO_BND_CD(+) = @[bound]" ).append("\n"); 
		query.append("           AND  A.NTC_VIA_CD = 'M'" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("        SELECT  A.CNTC_FAX_NO" ).append("\n"); 
		query.append("               ,A.FAX_EML_SND_RSLT_MSG" ).append("\n"); 
		query.append("               ,DECODE(A.SND_ID, NULL, '', A.SND_USR_ID) AS SND_ID" ).append("\n"); 
		query.append("               ,DECODE(A.SND_ID, NULL, '', B.USR_NM) AS SND_USR_ID" ).append("\n"); 
		query.append("               ,A.HIS_SEQ" ).append("\n"); 
		query.append("               ,ROW_NUMBER() OVER(ORDER BY A.HIS_SEQ DESC) AS RNUM" ).append("\n"); 
		query.append("               ,'F' AS NTC_VIA_CD" ).append("\n"); 
		query.append("               ,TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SND_RQST_DT, BKG_COM_USER_LOC_FNC(SND_USR_ID)), 'YYYY-MM-DD HH24:MI') AS SND_DT" ).append("\n"); 
		query.append("          FROM  BKG_USA_WHF_SND_HIS A" ).append("\n"); 
		query.append("               ,COM_USER B" ).append("\n"); 
		query.append("         WHERE  A.SND_USR_ID = B.USR_ID(+)" ).append("\n"); 
		query.append("           AND  A.VSL_CD(+) = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND  A.SKD_VOY_NO(+) = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND  A.SKD_DIR_CD(+) = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("           AND  A.PORT_CD(+) = @[port]" ).append("\n"); 
		query.append("           AND  A.IO_BND_CD(+) = @[bound]" ).append("\n"); 
		query.append("           AND  A.NTC_VIA_CD = 'F'" ).append("\n"); 
		query.append("       ) TB" ).append("\n"); 
		query.append("ORDER BY NVL(SND_DT, '19990101') DESC" ).append("\n"); 

	}
}