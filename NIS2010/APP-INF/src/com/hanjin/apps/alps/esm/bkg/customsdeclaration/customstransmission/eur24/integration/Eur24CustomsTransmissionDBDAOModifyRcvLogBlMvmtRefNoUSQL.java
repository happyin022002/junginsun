/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOModifyRcvLogBlMvmtRefNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2012.12.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOModifyRcvLogBlMvmtRefNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOModifyRcvLogBlMvmtRefNoUSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOModifyRcvLogBlMvmtRefNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_rcv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOModifyRcvLogBlMvmtRefNoUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_EUR_BL A" ).append("\n"); 
		query.append("SET A.UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("    ,A.MVMT_REF_NO = " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if(${mvmt_ref_no} != '')" ).append("\n"); 
		query.append("                  @[mvmt_ref_no]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                  (" ).append("\n"); 
		query.append("                        SELECT NVL(T1.MVMT_REF_NO, A.MVMT_REF_NO)" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("				      " ).append("\n"); 
		query.append("                            SELECT MVMT_REF_NO" ).append("\n"); 
		query.append("                            FROM BKG_CSTMS_ADV_EUR_RCV" ).append("\n"); 
		query.append("                            WHERE MSG_RCV_NO = (" ).append("\n"); 
		query.append("                                SELECT MAX(SND.MSG_SND_NO)" ).append("\n"); 
		query.append("                                FROM BKG_CSTMS_EUR_BL BL, BKG_CSTMS_ADV_EUR_SND SND, BKG_CSTMS_ADV_EUR_RCV RCV" ).append("\n"); 
		query.append("                                WHERE BL.MSG_SND_NO = @[msg_rcv_no]" ).append("\n"); 
		query.append("                                AND SND.MSG_SND_NO = RCV.MSG_RCV_NO(+)" ).append("\n"); 
		query.append("                                AND SND.MSG_SND_NO LIKE BL.BL_NO || '%'" ).append("\n"); 
		query.append("                                AND SND.CSTMS_PORT_CD = BL.CSTMS_PORT_CD" ).append("\n"); 
		query.append("                                AND RCV.ACK_KND_ID = 'A'" ).append("\n"); 
		query.append("                                AND RCV.ACK_RCV_STS_CD= 'A'" ).append("\n"); 
		query.append("                                AND RCV.MVMT_REF_NO IS NOT NULL  -- 수신 받은 MRN 값이 있고" ).append("\n"); 
		query.append("                                AND BL.MVMT_REF_NO IS NULL -- BL쪽에 MRN이 없을 경우만" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                              ) T1 RIGHT OUTER JOIN dual" ).append("\n"); 
		query.append("                       ON T1.MVMT_REF_NO IS NOT NULL       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("    #end                   " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("WHERE       (A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.BL_NO, A.CSTMS_PORT_CD) IN" ).append("\n"); 
		query.append("     (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BL_NO, CSTMS_PORT_CD" ).append("\n"); 
		query.append("        FROM   BKG_CSTMS_ADV_EUR_SND" ).append("\n"); 
		query.append("        WHERE  MSG_SND_NO = @[msg_rcv_no]" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}