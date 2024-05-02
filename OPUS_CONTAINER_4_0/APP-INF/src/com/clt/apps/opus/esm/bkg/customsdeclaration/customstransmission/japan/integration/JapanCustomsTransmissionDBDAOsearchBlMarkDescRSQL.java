/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : JapanCustomsTransmissionDBDAOsearchBlMarkDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanCustomsTransmissionDBDAOsearchBlMarkDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JapanCustomsTransmissionDBDAOsearchBlMarkDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.integration").append("\n"); 
		query.append("FileName : JapanCustomsTransmissionDBDAOsearchBlMarkDescRSQL").append("\n"); 
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
		query.append("SELECT --RPAD(DECODE(DIFF_RMK, 'N/M', DIFF_RMK, NVL(DIFF_RMK, 'N/M')), 140, ' ') AS DIFF_RMK," ).append("\n"); 
		query.append("       REPLACE(RPAD(DECODE(TRIM(DBMS_LOB.SUBSTR(DIFF_RMK, 200, 1)), 'N/M', 'NO MARK', '.', 'NO MARK', '..', 'NO MARK', '...', 'NO MARK', TRIM(DBMS_LOB.SUBSTR(DIFF_RMK, 200, 1))), 200, ' '), CHR(10), '#%&') AS DIFF_RMK," ).append("\n"); 
		query.append("       RPAD(NVL(BL_DESC, ' '), 70, ' ') AS BL_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_JP_BL_MK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND BL_SPLIT_NO = NVL(@[bl_split_no], '  ')" ).append("\n"); 

	}
}