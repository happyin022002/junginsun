/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyVslNmBkgBlDocUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.19 
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

public class GeneralBookingReceiptDBDAOModifyVslNmBkgBlDocUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group VVD/Assign 시 변경된 VVD를 BKG_BL_DOC에도 적용
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyVslNmBkgBlDocUSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOModifyVslNmBkgBlDocUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BL_DOC" ).append("\n"); 
		query.append("SET VSL_NM = (" ).append("\n"); 
		query.append("                SELECT M.VSL_ENG_NM||' '||SKD_VOY_NO||SKD_DIR_CD NEW_VVD" ).append("\n"); 
		query.append("                FROM BKG_VVD V," ).append("\n"); 
		query.append("                     MDM_VSL_CNTR M" ).append("\n"); 
		query.append("                WHERE V.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                  AND V.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("                  AND V.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("              ) " ).append("\n"); 
		query.append("  ,PRE_VSL_NM = (" ).append("\n"); 
		query.append("                SELECT M.VSL_ENG_NM||' '||SKD_VOY_NO||SKD_DIR_CD NEW_PRE_VVD" ).append("\n"); 
		query.append("                FROM BKG_VVD V" ).append("\n"); 
		query.append("	                ,MDM_VSL_CNTR M" ).append("\n"); 
		query.append("                WHERE V.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	              AND V.VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("                  AND V.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("				  AND V.VSL_SEQ = 1" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}