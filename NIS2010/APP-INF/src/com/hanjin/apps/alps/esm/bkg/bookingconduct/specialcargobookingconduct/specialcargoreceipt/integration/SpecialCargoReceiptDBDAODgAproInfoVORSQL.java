/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAODgAproInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAODgAproInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgAproInfoVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAODgAproInfoVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAODgAproInfoVORSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.RQST_USR_ID" ).append("\n"); 
		query.append("      ,A.RQST_DT" ).append("\n"); 
		query.append("      ,A.RQST_GDT" ).append("\n"); 
		query.append("      ,B.IMDG_UN_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     SELECT" ).append("\n"); 
		query.append("     max(RQST_USR_ID) RQST_USR_ID" ).append("\n"); 
		query.append("     , 	max(TO_CHAR(RQST_DT, 'yyyy-mm-dd HH24:MI')) RQST_DT" ).append("\n"); 
		query.append("     , 	max(TO_CHAR(RQST_GDT, 'yyyy-mm-dd HH24:MI')) RQST_GDT" ).append("\n"); 
		query.append("     FROM BKG_DG_CGO_his" ).append("\n"); 
		query.append("     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	 and CORR_NO = 'TMP0000001'  " ).append("\n"); 
		query.append(") A ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     SELECT IMDG_UN_NO " ).append("\n"); 
		query.append("	  FROM(" ).append("\n"); 
		query.append("             SELECT MIN(DCGO_SEQ) MIN_SEQ" ).append("\n"); 
		query.append("             FROM BKG_DG_CGO_his" ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("			 and CORR_NO = 'TMP0000001'   " ).append("\n"); 
		query.append("          ) M," ).append("\n"); 
		query.append("      BKG_DG_CGO_his DG" ).append("\n"); 
		query.append("      WHERE DG.BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append("      AND DG.DCGO_SEQ = M.MIN_SEQ" ).append("\n"); 
		query.append("	  and CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.RQST_USR_ID" ).append("\n"); 
		query.append("      ,A.RQST_DT" ).append("\n"); 
		query.append("      ,A.RQST_GDT" ).append("\n"); 
		query.append("      ,B.IMDG_UN_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     SELECT" ).append("\n"); 
		query.append("     max(RQST_USR_ID) RQST_USR_ID" ).append("\n"); 
		query.append("     , 	max(TO_CHAR(RQST_DT, 'yyyy-mm-dd HH24:MI')) RQST_DT" ).append("\n"); 
		query.append("     , 	max(TO_CHAR(RQST_GDT, 'yyyy-mm-dd HH24:MI')) RQST_GDT" ).append("\n"); 
		query.append("     FROM BKG_DG_CGO" ).append("\n"); 
		query.append("     WHERE BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append(") A ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("     SELECT IMDG_UN_NO FROM(" ).append("\n"); 
		query.append("                         SELECT MIN(DCGO_SEQ) MIN_SEQ" ).append("\n"); 
		query.append("                         FROM BKG_DG_CGO" ).append("\n"); 
		query.append("                         WHERE BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append("                      ) M, BKG_DG_CGO DG" ).append("\n"); 
		query.append("      WHERE DG.BKG_NO = @[bkg_no]  " ).append("\n"); 
		query.append("      AND DG.DCGO_SEQ = M.MIN_SEQ" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}