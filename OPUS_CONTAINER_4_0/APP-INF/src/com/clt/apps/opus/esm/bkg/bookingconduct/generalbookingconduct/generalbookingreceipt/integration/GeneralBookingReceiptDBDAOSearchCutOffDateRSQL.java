/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchCutOffDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.12.03 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchCutOffDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Query to keep cut-off dates before change
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchCutOffDateRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchCutOffDateRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("        BKG_NO" ).append("\n"); 
		query.append("        ,CLZ_TP_CD" ).append("\n"); 
		query.append("        ,TO_CHAR(NVL(MNL_SET_DT, SYS_SET_DT), 'YYYY-MM-DD HH24:MI:SS') CUT_DT" ).append("\n"); 
		query.append("FROM    BKG_CLZ_TM" ).append("\n"); 
		query.append("WHERE   0=0" ).append("\n"); 
		query.append("AND     BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     CLZ_TP_CD IN ('R','T')" ).append("\n"); 
		query.append("ORDER BY CLZ_TP_CD" ).append("\n"); 

	}
}