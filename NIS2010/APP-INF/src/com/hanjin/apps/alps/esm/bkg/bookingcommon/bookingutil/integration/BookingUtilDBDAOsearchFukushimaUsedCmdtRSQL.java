/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingUtilDBDAOsearchFukushimaUsedCmdtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.09.12 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchFukushimaUsedCmdtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 후쿠시마에서 Used Commodity가 특정 pod로 가는지 확인한다
	  * </pre>
	  */
	public BookingUtilDBDAOsearchFukushimaUsedCmdtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchFukushimaUsedCmdtRSQL").append("\n"); 
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
		query.append("SELECT 'Y' RESULT" ).append("\n"); 
		query.append("#if (${ca_flg} != 'Y')" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("         , BKG_VVD POL" ).append("\n"); 
		query.append("         , BKG_VVD POD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      FROM BKG_BKG_HIS BK" ).append("\n"); 
		query.append("         , BKG_VVD_HIS POL" ).append("\n"); 
		query.append("         , BKG_VVD_HIS POD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         , (SELECT ATTR_CTNT1 POL_CD" ).append("\n"); 
		query.append("                 , ATTR_CTNT2 POD_CD" ).append("\n"); 
		query.append("              FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("             WHERE HRD_CDG_ID = 'FUKUSHIMA_USED_POD') A" ).append("\n"); 
		query.append("     WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       AND BK.BKG_NO = POL.BKG_NO" ).append("\n"); 
		query.append("       AND BK.BKG_NO = POD.BKG_NO" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	   AND BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("	   AND POL.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("	   AND POD.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND (BK.POR_CD = A.POL_CD OR POL.POL_CD = A.POL_CD)" ).append("\n"); 
		query.append("       AND POD.POD_CD = A.POD_CD" ).append("\n"); 
		query.append("       AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("       AND BK.BKG_CGO_TP_CD = 'F'       " ).append("\n"); 
		query.append("#if (${cstms_desc} == '')" ).append("\n"); 
		query.append("       AND NVL(@[cmdt_cd], BK.CMDT_CD) IN (SELECT ATTR_CTNT1 CMDT_CD" ).append("\n"); 
		query.append("	                                         FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                                            WHERE HRD_CDG_ID = 'FUKUSHIMA_USED_CMDT')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	   AND UPPER(@[cstms_desc]) like '%USED%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}