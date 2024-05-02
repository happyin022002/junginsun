/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyLbpFlgForContainerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.18
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyLbpFlgForContainerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1) OLBP 일 경우 
	  *        1-1) POD = US 이면서 Rail 이 아닐 경우 => LBP Flag : Y
	  *        1-2) POD = CA 이면서 Rail 일 경우       => LBP Flag : Y
	  *        1-3) 그 외의 경우                               => LBP Flag : N
	  * 2) 그 외의 경우 					      => LBP Flag : N
	  * 
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyLbpFlgForContainerUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyLbpFlgForContainerUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_CNTR_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_CONTAINER" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("SET LBP_FLG = " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        CASE A.STWG_CD" ).append("\n"); 
		query.append("            WHEN 'OLBP' THEN " ).append("\n"); 
		query.append("                  CASE A.POD_CD" ).append("\n"); 
		query.append("                        WHEN 'US' THEN " ).append("\n"); 
		query.append("                                    CASE DEST_TRNS_MOD_CD " ).append("\n"); 
		query.append("                                         WHEN 'R' THEN 'N'" ).append("\n"); 
		query.append("                                         ELSE 'Y'" ).append("\n"); 
		query.append("                                         END" ).append("\n"); 
		query.append("                        WHEN 'CA' THEN" ).append("\n"); 
		query.append("                                    CASE DEST_TRNS_MOD_CD " ).append("\n"); 
		query.append("                                         WHEN 'R' THEN 'Y'" ).append("\n"); 
		query.append("                                         ELSE 'N'" ).append("\n"); 
		query.append("                                         END" ).append("\n"); 
		query.append("						ELSE 'N'" ).append("\n"); 
		query.append("                  END " ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("        END LBP_FLG" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("                    SELECT DEST_TRNS_MOD_CD, SUBSTR(POD_CD,0,2) POD_CD, STWG_CD" ).append("\n"); 
		query.append("                    FROM BKG_BKG_HIS" ).append("\n"); 
		query.append("                    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SET LBP_FLG = " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        CASE A.STWG_CD" ).append("\n"); 
		query.append("            WHEN 'OLBP' THEN " ).append("\n"); 
		query.append("                  CASE A.POD_CD" ).append("\n"); 
		query.append("                        WHEN 'US' THEN " ).append("\n"); 
		query.append("                                    CASE DEST_TRNS_MOD_CD " ).append("\n"); 
		query.append("                                         WHEN 'R' THEN 'N'" ).append("\n"); 
		query.append("                                         ELSE 'Y'" ).append("\n"); 
		query.append("                                         END" ).append("\n"); 
		query.append("                        WHEN 'CA' THEN" ).append("\n"); 
		query.append("                                    CASE DEST_TRNS_MOD_CD " ).append("\n"); 
		query.append("                                         WHEN 'R' THEN 'Y'" ).append("\n"); 
		query.append("                                         ELSE 'N'" ).append("\n"); 
		query.append("                                         END" ).append("\n"); 
		query.append("						ELSE 'N'" ).append("\n"); 
		query.append("                  END " ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("        END LBP_FLG" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("                    SELECT DEST_TRNS_MOD_CD, SUBSTR(POD_CD,0,2) POD_CD, STWG_CD" ).append("\n"); 
		query.append("                    FROM BKG_BOOKING" ).append("\n"); 
		query.append("                    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         ) A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}