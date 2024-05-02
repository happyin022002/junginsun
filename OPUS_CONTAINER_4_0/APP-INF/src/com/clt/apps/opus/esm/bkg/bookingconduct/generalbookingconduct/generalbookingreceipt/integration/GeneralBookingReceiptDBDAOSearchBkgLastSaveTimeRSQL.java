/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBkgLastSaveTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBkgLastSaveTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBkgLastSaveTimeRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBkgLastSaveTimeRSQL").append("\n"); 
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
		query.append("SELECT ROWNUM, TAGET_NAME, LST_SAV_DT FROM (" ).append("\n"); 
		query.append("SELECT ROWNUM, TAGET_NAME, TO_CHAR(LST_SAV_DT, 'YYYYMMDDHH24MISS') AS LST_SAV_DT FROM(" ).append("\n"); 
		query.append("  SELECT" ).append("\n"); 
		query.append("    'BKG_BOOKING' TAGET_NAME," ).append("\n"); 
		query.append("    LST_SAV_DT" ).append("\n"); 
		query.append("  FROM BKG_BOOKING" ).append("\n"); 
		query.append("  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("  SELECT" ).append("\n"); 
		query.append("    'BKG_VVD' TAGET_NAME," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_VVD" ).append("\n"); 
		query.append("  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT" ).append("\n"); 
		query.append("    'BKG_QUANTITY' TAGET_NAME," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_QUANTITY" ).append("\n"); 
		query.append("  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  UNION ALL" ).append("\n"); 
		query.append("  SELECT" ).append("\n"); 
		query.append("    'BKG_QTY_DTL' TAGET_NAME," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_QTY_DTL" ).append("\n"); 
		query.append("  WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(") A " ).append("\n"); 
		query.append("ORDER BY LST_SAV_DT DESC" ).append("\n"); 
		query.append(")B" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}