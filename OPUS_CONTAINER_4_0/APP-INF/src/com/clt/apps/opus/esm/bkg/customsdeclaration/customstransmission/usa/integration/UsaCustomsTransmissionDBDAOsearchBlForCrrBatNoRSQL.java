/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchBlForCrrBatNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchBlForCrrBatNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchBlForCrrBatNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchBlForCrrBatNoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(C.BL_NO, NULL, 'AMS VSL Departure', 'AMS') AS IBFLAG" ).append("\n"); 
		query.append("      ,NVL(A.VVD, C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD) AS VVD" ).append("\n"); 
		query.append("      ,C.BL_NO" ).append("\n"); 
		query.append("      ,NVL(A.POL_CD, C.CSTMS_POL_CD) AS CSTMS_POL_CD" ).append("\n"); 
		query.append("      ,NVL(A.POD_CD, C.CSTMS_POD_CD) AS CSTMS_POD_CD" ).append("\n"); 
		query.append("  FROM (SELECT CNT_CD" ).append("\n"); 
		query.append("              ,CRR_BAT_NO" ).append("\n"); 
		query.append("              ,VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("              ,POL_CD" ).append("\n"); 
		query.append("              ,POD_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_SND_LOG" ).append("\n"); 
		query.append("         WHERE (CNT_CD, IO_BND_CD, SND_DT, HIS_SEQ) = (SELECT CNT_CD, IO_BND_CD, SND_DT, HIS_SEQ" ).append("\n"); 
		query.append("                                                         FROM BKG_CSTMS_ADV_SND_LOG_DTL" ).append("\n"); 
		query.append("                                                        WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                                                          AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                                          AND SND_DT > SYSDATE -2" ).append("\n"); 
		query.append("                                                          AND EDI_SND_LOG_CTNT LIKE '$$$%'" ).append("\n"); 
		query.append("                                                          AND EDI_SND_LOG_CTNT LIKE '%' || @[crr_bat_no] || '%'" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_EDI_BL_RSPN B" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_BL          C" ).append("\n"); 
		query.append(" WHERE A.CNT_CD     = B.CNT_CD(+)" ).append("\n"); 
		query.append("   AND A.CRR_BAT_NO = B.CRR_BAT_NO(+)" ).append("\n"); 
		query.append("   AND B.CNT_CD     = C.CNT_CD(+)" ).append("\n"); 
		query.append("   AND B.BL_NO      = C.BL_NO(+)" ).append("\n"); 

	}
}