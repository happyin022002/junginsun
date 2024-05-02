/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchBlForEdiErrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchBlForEdiErrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchBlForEdiErrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_key",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchBlForEdiErrRSQL").append("\n"); 
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
		query.append("SELECT DECODE(A.EUR_EDI_MSG_TP_ID, 'DIV', 'Diversion', 'ARN', 'AN', A.EUR_EDI_MSG_TP_ID) AS EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,A.CSTMS_PORT_CD" ).append("\n"); 
		query.append("      ,A.BL_NO" ).append("\n"); 
		query.append("      ,C.POL_CD" ).append("\n"); 
		query.append("      ,NVL(C.POD_CD, A.CSTMS_PORT_CD) AS POD_CD" ).append("\n"); 
		query.append("      ,B.RVIS_N1ST_CLPT_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_EUR_SND A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_EUR_VSL     B" ).append("\n"); 
		query.append("      ,BKG_CSTMS_EUR_BL      C" ).append("\n"); 
		query.append(" WHERE A.VSL_CD        = B.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO    = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD    = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.CSTMS_PORT_CD = B.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND A.VSL_CD        = C.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO    = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD    = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.CSTMS_PORT_CD = C.CSTMS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND A.BL_NO         = C.BL_NO(+)" ).append("\n"); 
		query.append("   AND A.EDI_SND_MSG_CTNT LIKE '%' || @[msg_key] || '%'" ).append("\n"); 
		query.append("   AND A.SND_DT > SYSDATE - 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.EUR_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("      ,A.VSL_CD" ).append("\n"); 
		query.append("      ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      ,A.CSTMS_PORT_CD" ).append("\n"); 
		query.append("      ,A.BL_NO" ).append("\n"); 
		query.append("      ,C.POL_CD" ).append("\n"); 
		query.append("      ,C.POD_CD" ).append("\n"); 
		query.append("      ,'' AS RVIS_N1ST_CLPT_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_EUR_IO_SND  A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_EUR_BL      C" ).append("\n"); 
		query.append(" WHERE A.VSL_CD        = C.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO    = C.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD    = C.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.CSTMS_PORT_CD = C.CSTMS_PORT_CD" ).append("\n"); 
		query.append("   AND A.BL_NO         = C.BL_NO" ).append("\n"); 
		query.append("   AND A.EDI_SND_MSG_CTNT LIKE '%' || @[msg_key] || '%'" ).append("\n"); 
		query.append("   AND A.SND_DT > SYSDATE - 1" ).append("\n"); 

	}
}