/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchDgUnnoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.23 
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

public class UsaCustomsTransmissionDBDAOsearchDgUnnoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchDgUnnoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchDgUnnoRSQL").append("\n"); 
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
		query.append("SELECT RPAD('V01' || RPAD(D.IMDG_UN_NO, 10, ' ') || '    U' || RPAD(NVL(D.PRP_SHP_NM, ' '), 30, ' ') || RPAD(NVL(D.EMER_CNTC_PHN_NO_CTNT,' '), 24, ' '), 80, ' ') || CHR(10) AS V01" ).append("\n"); 
		query.append("      ,RPAD('V02' || LPAD(NVL(ROUND(ABS(D.FLSH_PNT_CDO_TEMP), 0), 0), 3, '0') || 'CE' || CASE WHEN NVL(D.FLSH_PNT_CDO_TEMP,0) < 0 THEN 'N' ELSE '' END, 80, ' ')|| CHR(10) AS V02" ).append("\n"); 
		query.append("      ,RPAD('V03' || RPAD(NVL(TRIM(REPLACE(REPLACE(UPPER(BKG_SPCLCHAR_CONV_FNC(D.HZD_DESC, 'X')),CHR(13)||CHR(10),' '),CHR(9),' ')), ' '), 30, ' ') " ).append("\n"); 
		query.append("                  || RPAD(NVL(D.IMDG_SUBS_RSK_LBL_CD1, ' '), 30, ' '), 80, ' ')|| CHR(10) AS V03" ).append("\n"); 
		query.append("  FROM BKG_BOOKING B" ).append("\n"); 
		query.append("      ,BKG_DG_CGO D" ).append("\n"); 
		query.append(" WHERE B.BKG_NO   = D.BKG_NO" ).append("\n"); 
		query.append("   AND B.bl_no    = @[bl_no]" ).append("\n"); 
		query.append("   AND D.cntr_no  = @[cntr_no]" ).append("\n"); 

	}
}