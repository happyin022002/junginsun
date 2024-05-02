/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : HoldNoticeDBDAOsearchHldNtcObStaffSetupInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HoldNoticeDBDAOsearchHldNtcObStaffSetupInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (HldNtcObStaffSetupInfoVO 생성)
	  * </pre>
	  */
	public HoldNoticeDBDAOsearchHldNtcObStaffSetupInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOsearchHldNtcObStaffSetupInfoRSQL").append("\n"); 
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
		query.append("-- HldNtcObStaffSetupInfoVO" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("	   SND_USR_ID" ).append("\n"); 
		query.append("      ,CUSER.USR_EML" ).append("\n"); 
		query.append("      ,CUSER.USR_NM" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_ADV_BL      ABL" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_EDI_BL_RSPN B_R" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ADV_SND_LOG SLOG" ).append("\n"); 
		query.append("      ,COM_USER              CUSER" ).append("\n"); 
		query.append("WHERE ABL.CNT_CD             = @[cnt_cd]" ).append("\n"); 
		query.append("  AND ABL.BL_NO              = @[bl_no] -- param" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND ABL.CNT_CD             = B_R.CNT_CD" ).append("\n"); 
		query.append("  AND ABL.BL_NO              = B_R.BL_NO" ).append("\n"); 
		query.append("  AND SLOG.CRR_BAT_NO        = B_R.CRR_BAT_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND SLOG.VSL_CD(+)         = ABL.VSL_CD" ).append("\n"); 
		query.append("  AND SLOG.SKD_VOY_NO(+)     = ABL.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND SLOG.SKD_DIR_CD(+)     = ABL.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND SLOG.POL_CD(+)         = ABL.CSTMS_POL_CD" ).append("\n"); 
		query.append("  AND SLOG.POD_CD(+)         = ABL.CSTMS_POD_CD" ).append("\n"); 
		query.append("  AND SLOG.CNT_CD(+)         = @[cnt_cd]" ).append("\n"); 
		query.append("  AND SLOG.IO_BND_CD(+)      ='I'" ).append("\n"); 
		query.append("  AND SLOG.TRSM_MSG_TP_ID(+) = @[msg_tp_id]" ).append("\n"); 
		query.append("  AND CUSER.USR_ID(+)        = SLOG.SND_USR_ID" ).append("\n"); 

	}
}