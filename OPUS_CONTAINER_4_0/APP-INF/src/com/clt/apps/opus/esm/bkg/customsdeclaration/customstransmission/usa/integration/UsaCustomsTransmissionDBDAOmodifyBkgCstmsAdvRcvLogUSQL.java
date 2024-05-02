/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOmodifyBkgCstmsAdvRcvLogUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
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

public class UsaCustomsTransmissionDBDAOmodifyBkgCstmsAdvRcvLogUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBkgCstmsAdvRcvLog
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOmodifyBkgCstmsAdvRcvLogUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ir_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ir_date",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOmodifyBkgCstmsAdvRcvLogUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_RCV_LOG" ).append("\n"); 
		query.append("#if (${type} == 'RC') " ).append("\n"); 
		query.append("    #if (${bl_no} != '') " ).append("\n"); 
		query.append("   SET (POL_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, BL_NO) = " ).append("\n"); 
		query.append("       (SELECT CSTMS_POL_CD" ).append("\n"); 
		query.append("              ,VSL_CD" ).append("\n"); 
		query.append("              ,SKD_VOY_NO" ).append("\n"); 
		query.append("              ,SKD_DIR_CD" ).append("\n"); 
		query.append("              ,BL_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("         WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("    #elseif (${vsl_eng_nm} != '') " ).append("\n"); 
		query.append("    SET VSL_CD = (" ).append("\n"); 
		query.append("        SELECT NVL(VSL_CD, SUBSTR(@[vsl_eng_nm], 1, 4))" ).append("\n"); 
		query.append("          FROM MDM_VSL_CNTR A" ).append("\n"); 
		query.append("         WHERE A.VSL_ENG_NM = TRIM(@[vsl_eng_nm])" ).append("\n"); 
		query.append("           AND ROWNUM = 1       " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("#elseif (${type} == 'HR') " ).append("\n"); 
		query.append("   SET POL_CD =" ).append("\n"); 
		query.append("       (SELECT POL_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_SND_LOG" ).append("\n"); 
		query.append("         WHERE CRR_BAT_NO = @[crr_bat_no]" ).append("\n"); 
		query.append("           AND CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   SET (POL_CD, BL_NO) =" ).append("\n"); 
		query.append("       (SELECT A.POL_CD" ).append("\n"); 
		query.append("              ,B.BL_NO" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_SND_LOG     A" ).append("\n"); 
		query.append("              ,BKG_CSTMS_ADV_EDI_BL_RSPN B" ).append("\n"); 
		query.append("         WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("           AND A.CRR_BAT_NO = B.CRR_BAT_NO" ).append("\n"); 
		query.append("           AND A.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND A.CRR_BAT_NO = @[crr_bat_no]" ).append("\n"); 
		query.append("           AND ROWNUM = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("   AND RCV_DT = TO_DATE(@[ir_date], 'RRMMDDHH24MISS')" ).append("\n"); 
		query.append("   AND RCV_SEQ = @[ir_seq]" ).append("\n"); 

	}
}