/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchRejNtcObStaffSenderInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.30 
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

public class UsaCustomsTransmissionDBDAOsearchRejNtcObStaffSenderInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sender 및 Booking Staff 메일정보 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchRejNtcObStaffSenderInfoRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_bat_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchRejNtcObStaffSenderInfoRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       SND_USR_ID " ).append("\n"); 
		query.append("       ,CUSER.USR_EML SND_EML" ).append("\n"); 
		query.append("       ,CUSER.USR_NM SND_USR_NM" ).append("\n"); 
		query.append("       ,BKG.DOC_USR_ID STAFF_ID" ).append("\n"); 
		query.append("       ,BKG.USR_EML STAFF_SND_EML" ).append("\n"); 
		query.append("       ,BKG.USR_NM STAFF_USR_NM" ).append("\n"); 
		query.append("       ,BKG.POD_CD" ).append("\n"); 
		query.append("       ,TO_DATE(@[ir_dt],'RRMMDDHH24MISS') IR_DATE" ).append("\n"); 
		query.append("       ,SLOG.TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("       ,POL_LOC.LOC_NM POL_LOC_NAME        " ).append("\n"); 
		query.append("       ,POD_LOC.LOC_NM POD_LOC_NAME    " ).append("\n"); 
		query.append("       ,S.CUST_NM SHIPPER_NM" ).append("\n"); 
		query.append("       ,C.CUST_NM CONSIGNEE_NM   " ).append("\n"); 
		query.append("FROM   BKG_CSTMS_ADV_BL      ABL" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_EDI_BL_RSPN B_R" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_SND_LOG SLOG" ).append("\n"); 
		query.append("      ,COM_USER CUSER" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("           SELECT A.BKG_NO, A.DOC_USR_ID, B.USR_EML, POD_CD, USR_NM " ).append("\n"); 
		query.append("           FROM BKG_BOOKING A, COM_USER B" ).append("\n"); 
		query.append("           WHERE BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("           AND A.DOC_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("       ) BKG" ).append("\n"); 
		query.append("      ,MDM_LOCATION POL_LOC" ).append("\n"); 
		query.append("      ,MDM_LOCATION POD_LOC" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_CUST S" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_CUST C" ).append("\n"); 
		query.append("WHERE ABL.CNT_CD             = 'US'" ).append("\n"); 
		query.append("  AND ABL.BL_NO              =  @[bl_no]" ).append("\n"); 
		query.append("  AND SLOG.CRR_BAT_NO = @[crr_bat_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND ABL.CNT_CD             = B_R.CNT_CD" ).append("\n"); 
		query.append("  AND ABL.BL_NO              = B_R.BL_NO" ).append("\n"); 
		query.append("  AND SLOG.CRR_BAT_NO        = B_R.CRR_BAT_NO" ).append("\n"); 
		query.append("  AND SLOG.VSL_CD(+)         = ABL.VSL_CD" ).append("\n"); 
		query.append("  AND SLOG.SKD_VOY_NO(+)     = ABL.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND SLOG.SKD_DIR_CD(+)     = ABL.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND SLOG.POL_CD(+)         = ABL.CSTMS_POL_CD" ).append("\n"); 
		query.append("  AND SLOG.POD_CD(+)         = ABL.CSTMS_POD_CD" ).append("\n"); 
		query.append("  AND SLOG.CNT_CD(+)         = 'US'" ).append("\n"); 
		query.append("  AND SLOG.IO_BND_CD(+)      ='I'" ).append("\n"); 
		query.append("  AND CUSER.USR_ID(+)        = SLOG.SND_USR_ID" ).append("\n"); 
		query.append("  AND ABL.BKG_NO             = BKG.BKG_NO(+)" ).append("\n"); 
		query.append("  AND ABL.POL_CD             = POL_LOC.LOC_CD" ).append("\n"); 
		query.append("  AND ABL.POD_CD             = POD_LOC.LOC_CD" ).append("\n"); 
		query.append("  AND S.BKG_CUST_TP_CD       = 'S'" ).append("\n"); 
		query.append("  AND ABL.CNT_CD             = S.CNT_CD  " ).append("\n"); 
		query.append("  AND ABL.BL_NO              = S.BL_NO" ).append("\n"); 
		query.append("  AND C.BKG_CUST_TP_CD       = 'C'" ).append("\n"); 
		query.append("  AND ABL.CNT_CD             = C.CNT_CD" ).append("\n"); 
		query.append("  AND ABL.BL_NO              = C.BL_NO" ).append("\n"); 

	}
}