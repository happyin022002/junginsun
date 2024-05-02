/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOModifyRcvLogBlMvmtRefNoOBUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.20
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.07.20 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOModifyRcvLogBlMvmtRefNoOBUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOModifyRcvLogBlMvmtRefNoOBUSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOModifyRcvLogBlMvmtRefNoOBUSQL(){
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
		query.append("FileName : Eur24CustomsTransmissionDBDAOModifyRcvLogBlMvmtRefNoOBUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_EUR_IO_BL" ).append("\n"); 
		query.append("SET MVMT_REF_NO = @[mvmt_ref_no]," ).append("\n"); 
		query.append("    UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHERE  BND_TP_CD ='O' " ).append("\n"); 
		query.append("  AND (VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BL_NO, CSTMS_PORT_CD) IN" ).append("\n"); 
		query.append("     (SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BL_NO, CSTMS_PORT_CD" ).append("\n"); 
		query.append("        FROM   BKG_CSTMS_EUR_IO_SND" ).append("\n"); 
		query.append("        WHERE BND_TP_CD = 'O' " ).append("\n"); 
		query.append("				  AND MSG_SND_NO = @[msg_rcv_no]" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}