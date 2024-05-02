/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOmodifyBkgCstmsAdvRcvLogUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.02.18 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
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
		query.append("   SET POL_CD = " ).append("\n"); 
		query.append("#if (${type} == 'bl_no') " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT CSTMS_POL_CD " ).append("\n"); 
		query.append("         FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("        WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("          AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT A.CSTMS_POL_CD " ).append("\n"); 
		query.append("         FROM BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("             ,BKG_CSTMS_ADV_EDI_BL_RSPN B" ).append("\n"); 
		query.append("        WHERE A.CNT_CD = B.CNT_CD" ).append("\n"); 
		query.append("          AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("          AND B.CNT_CD = 'US'" ).append("\n"); 
		query.append("          AND B.CRR_BAT_NO = @[crr_bat_no]" ).append("\n"); 
		query.append("          AND ROWNUM = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("  AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("  AND RCV_DT = TO_DATE(@[ir_date], 'RRMMDDHH24MISS')" ).append("\n"); 
		query.append("  AND RCV_SEQ = @[ir_seq]" ).append("\n"); 

	}
}