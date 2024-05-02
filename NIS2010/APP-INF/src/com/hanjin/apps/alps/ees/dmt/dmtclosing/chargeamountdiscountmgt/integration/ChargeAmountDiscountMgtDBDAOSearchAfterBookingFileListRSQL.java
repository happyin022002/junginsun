/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingFileListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingFileListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingFileList
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingFileListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_bkg_file_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingFileListRSQL").append("\n"); 
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
		query.append("SELECT  ( SELECT ATTR_CTNT3" ).append("\n"); 
		query.append("            FROM DMT_HRD_CDG_CTNT " ).append("\n"); 
		query.append("           WHERE HRD_CDG_ID = 'AFT_BKG_SPEC_RSN_CD'" ).append("\n"); 
		query.append("             AND ATTR_CTNT1 = T1.AFT_BKG_FILE_DIV_CD" ).append("\n"); 
		query.append("             AND ATTR_CTNT2 = T1.AFT_BKG_RMK_LVL" ).append("\n"); 
		query.append("             AND ATTR_CTNT4 = 'file'" ).append("\n"); 
		query.append("		) AS AFT_BKG_RMK_LVL" ).append("\n"); 
		query.append("       ,T1.FILE_SAV_ID" ).append("\n"); 
		query.append("       ,NVL(T2.FILE_UPLD_NM,'')				AS FILE_NM" ).append("\n"); 
		query.append("       ,T2.FILE_SZ_CAPA     				AS FILE_SIZE" ).append("\n"); 
		query.append("       ,T2.FILE_PATH_URL    				AS FILE_PATH" ).append("\n"); 
		query.append("       ,TO_CHAR(T2.UPD_DT, 'YYYY-MM-DD')   	AS UPD_DT" ).append("\n"); 
		query.append("	   ,T1.AFT_BKG_FILE_DIV_CD" ).append("\n"); 
		query.append("  FROM  DMT_AFT_BKG_FILE_RQST  T1 " ).append("\n"); 
		query.append("       ,COM_UPLD_FILE           T2" ).append("\n"); 
		query.append(" WHERE  1=1" ).append("\n"); 
		query.append("   AND  T1.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("#if(${aft_bkg_file_div_cd} == 'All' )" ).append("\n"); 
		query.append("   AND  T1.AFT_BKG_FILE_DIV_CD IN ( SELECT ATTR_CTNT3 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'AFT_BKG_RSN_CD' )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND  T1.AFT_BKG_FILE_DIV_CD = @[aft_bkg_file_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND  T1.FILE_SAV_ID          = T2.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("   AND  T2.DELT_FLG(+)             = 'N'" ).append("\n"); 

	}
}