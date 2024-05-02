/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchHoldNtcSenderInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchHoldNtcSenderInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화주조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchHoldNtcSenderInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ir_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchHoldNtcSenderInfoRSQL").append("\n"); 
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
		query.append("SELECT B.CNTC_PSON_NM SND_USR_NM" ).append("\n"); 
		query.append("      ,S.CUST_CNT_CD||LPAD(S.CUST_SEQ,6,'0') SND_USR_ID" ).append("\n"); 
		query.append("      ,B.CNTC_PSON_EML SND_EML" ).append("\n"); 
		query.append("      ,TO_DATE(@[ir_dt],'RRMMDDHH24MISS') IR_DATE" ).append("\n"); 
		query.append("      ,POL_LOC.LOC_NM POL_LOC_NAME        " ).append("\n"); 
		query.append("      ,POD_LOC.LOC_NM POD_LOC_NAME" ).append("\n"); 
		query.append("      ,S.CUST_NM SHIPPER_NM" ).append("\n"); 
		query.append("      ,C.CUST_NM CONSIGNEE_NM" ).append("\n"); 
		query.append("      ,A.POL_CD" ).append("\n"); 
		query.append("      ,A.POD_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING A" ).append("\n"); 
		query.append("    ,BKG_CNTC_PSON B" ).append("\n"); 
		query.append("    ,MDM_LOCATION POL_LOC" ).append("\n"); 
		query.append("    ,MDM_LOCATION POD_LOC" ).append("\n"); 
		query.append("    ,BKG_CUSTOMER S" ).append("\n"); 
		query.append("    ,BKG_CUSTOMER C    " ).append("\n"); 
		query.append("WHERE A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_CNTC_PSON_TP_CD = 'SI' " ).append("\n"); 
		query.append("AND A.POL_CD = POL_LOC.LOC_CD" ).append("\n"); 
		query.append("AND A.POD_CD = POD_LOC.LOC_CD" ).append("\n"); 
		query.append("AND S.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND A.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("AND C.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 

	}
}