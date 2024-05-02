/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchVlFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.29 
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

public class GeneralBookingReceiptDBDAOSearchVlFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBDAOSearchVlFlg
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchVlFlgRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchVlFlgRSQL").append("\n"); 
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
		query.append("SELECT 'Y' AS VL_FLG   FROM  BKG_BOOKING BK, BKG_CONTAINER CNTR, BKG_VVD VVD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND 'VL' = (SELECT /*+INDEX_DESC(CTM_MOVEMENT XUK1CTM_MOVEMENT) */ " ).append("\n"); 
		query.append("										 MVMT_STS_CD" ).append("\n"); 
		query.append("								  FROM	 CTM_MOVEMENT" ).append("\n"); 
		query.append("								  WHERE  CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("									 AND ROWNUM <= 1" ).append("\n"); 
		query.append("									 )" ).append("\n"); 
		query.append("									 " ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'Y' FROM CTM_MOVEMENT CTM" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND CRNT_VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                AND CRNT_SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND CRNT_SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND ROWNUM =1 )			" ).append("\n"); 
		query.append("AND 'Y' = (SELECT 'Y' FROM BKG_HRD_CDG_CTNT WHERE 1=1 AND HRD_CDG_ID ='BKG_VL_VALIDATION' AND ATTR_CTNT1 ='Y' AND ROWNUM =1 )                						 " ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 

	}
}