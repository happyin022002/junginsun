/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchDgAproCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.05.13 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchDgAproCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search representative SPCL_CGO_APRO_CD of target booking
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchDgAproCdRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchDgAproCdRSQL").append("\n"); 
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
		query.append("SELECT SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT NVL(SPCL_CGO_APRO_CD,' ') SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("FROM BKG_DG_CGO" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("ORDER BY CASE WHEN NVL(SPCL_CGO_APRO_CD,' ') = 'N' THEN 1" ).append("\n"); 
		query.append("			  WHEN NVL(SPCL_CGO_APRO_CD,' ') = 'P' THEN 2" ).append("\n"); 
		query.append("			  WHEN NVL(SPCL_CGO_APRO_CD,' ') = 'R' THEN 3" ).append("\n"); 
		query.append("			  WHEN NVL(SPCL_CGO_APRO_CD,' ') = 'Y' THEN 4" ).append("\n"); 
		query.append("			  ELSE 5 " ).append("\n"); 
		query.append("		 END" ).append("\n"); 
		query.append(") WHERE ROWNUM = 1 " ).append("\n"); 

	}
}