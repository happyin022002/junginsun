/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOCheckFirstVvdChgByCaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05 
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

public class GeneralBookingReceiptDBDAOCheckFirstVvdChgByCaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CA 를 통해 첫 VVD 가 바뀌는 지를 Check 함
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOCheckFirstVvdChgByCaRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOCheckFirstVvdChgByCaRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN     LENGTH(OLD_FIRST_VVD) = 9" ).append("\n"); 
		query.append("                 AND LENGTH(NEW_FIRST_VVD) = 9" ).append("\n"); 
		query.append("                 AND OLD_FIRST_VVD <> NEW_FIRST_VVD" ).append("\n"); 
		query.append("            THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END FIRST_VVD_CHG   " ).append("\n"); 
		query.append("  FROM (SELECT (SELECT NVL(FIRST_VVD,'') FIRST_VVD" ).append("\n"); 
		query.append("                  FROM (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD FIRST_VVD" ).append("\n"); 
		query.append("                          FROM BKG_VVD" ).append("\n"); 
		query.append("                         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                         ORDER BY VSL_PRE_PST_CD,VSL_SEQ )" ).append("\n"); 
		query.append("                 WHERE ROWNUM = 1) OLD_FIRST_VVD" ).append("\n"); 
		query.append("             , (SELECT FIRST_VVD" ).append("\n"); 
		query.append("                  FROM (SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD FIRST_VVD" ).append("\n"); 
		query.append("                          FROM BKG_VVD_HIS" ).append("\n"); 
		query.append("                         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                         ORDER BY VSL_PRE_PST_CD,VSL_SEQ )" ).append("\n"); 
		query.append("                 WHERE ROWNUM = 1) NEW_FIRST_VVD" ).append("\n"); 
		query.append("          FROM DUAL)" ).append("\n"); 

	}
}