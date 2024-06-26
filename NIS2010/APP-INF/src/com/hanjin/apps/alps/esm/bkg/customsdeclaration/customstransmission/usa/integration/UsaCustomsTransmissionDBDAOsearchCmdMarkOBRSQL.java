/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCmdMarkOBRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCmdMarkOBRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaCustomsTransmissionDBDAOsearchCmdMarkOBRSQL
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCmdMarkOBRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration ").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCmdMarkOBRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	NVL(TRIM(BKG_SPCLCHAR_CONV_FNC(NVL(UPPER(MK_DESC),' '),'X')),'NO MARKS') cmd_mark_all," ).append("\n"); 
		query.append("	LENGTH(NVL(TRIM(BKG_SPCLCHAR_CONV_FNC(NVL(UPPER(MK_DESC),' '),'X')),'NO MARKS')) cmd_mark_len" ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT NVL(TRIM(REPLACE(REPLACE(UPPER(M.CNTR_MF_MK_DESC),CHR(13)||CHR(10),' '),CHR(9),' ')),'NO MARKS') AS MK_DESC" ).append("\n"); 
		query.append("    FROM    BKG_BOOKING B, " ).append("\n"); 
		query.append("            BKG_CONTAINER T," ).append("\n"); 
		query.append("            BKG_CNTR_MF_DESC M" ).append("\n"); 
		query.append("    WHERE   B.BKG_NO  = T.BKG_NO" ).append("\n"); 
		query.append("    AND     T.CNTR_NO = M.CNTR_NO" ).append("\n"); 
		query.append("    AND     T.BKG_NO  = M.BKG_NO" ).append("\n"); 
		query.append("    AND     B.BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("    AND     T.CNTR_NO = TRIM(@[cntr_no])" ).append("\n"); 
		query.append("    AND     M.CNTR_MF_SEQ = TRIM(@[cmd_seq])" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}