/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearch1J1CChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.01.22 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearch1J1CChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search1J1CChk
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearch1J1CChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("in_cntr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearch1J1CChkRSQL").append("\n"); 
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
		query.append("#if (${icr_code} == '4E') " ).append("\n"); 
		query.append("SELECT DECODE(DSPO_CD, '1J', 'J', 'N') AS DSPO_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_CNTR_RSLT" ).append("\n"); 
		query.append(" WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND CNTR_NO LIKE TRIM(@[in_cntr])||'%'" ).append("\n"); 
		query.append("   AND CSTMS_SEQ = (SELECT MAX(CSTMS_SEQ)" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_ADV_CNTR_RSLT" ).append("\n"); 
		query.append("                     WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                       AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                       AND CNTR_NO LIKE TRIM(@[in_cntr])||'%'" ).append("\n"); 
		query.append("                       AND DSPO_CD IN ('69', '1J')" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT DECODE(DSPO_CD, '69', 'N', '1J', 'J', '1C', 'Y', 'N') AS DSPO_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_CNTR_RSLT" ).append("\n"); 
		query.append(" WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND CNTR_NO LIKE TRIM(@[in_cntr])||'%'" ).append("\n"); 
		query.append("   AND CSTMS_SEQ = (SELECT MAX(CSTMS_SEQ)" ).append("\n"); 
		query.append("                      FROM BKG_CSTMS_ADV_CNTR_RSLT" ).append("\n"); 
		query.append("                     WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("                       AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                       AND CNTR_NO LIKE TRIM(@[in_cntr])||'%'" ).append("\n"); 
		query.append("                       AND DSPO_CD IN ('69', '1J', '1C')" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}