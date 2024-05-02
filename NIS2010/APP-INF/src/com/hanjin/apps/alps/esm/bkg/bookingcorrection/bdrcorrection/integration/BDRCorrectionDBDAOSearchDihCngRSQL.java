/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchDihCngRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.05
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2012.04.05 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sangbo La
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchDihCngRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchDihCngRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchDihCngRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchDihCngRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(COUNT(*), 0, 'N', 'Y'), 'N') DIH_CNG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT '*'" ).append("\n"); 
		query.append("          FROM BKG_CORRECTION BC" ).append("\n"); 
		query.append("         WHERE BC.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("           AND BC.CORR_NO = 'TMP0000001'  " ).append("\n"); 
		query.append("           AND EXISTS ( SELECT 'X' " ).append("\n"); 
		query.append("                          FROM BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("                         WHERE BKG_NO  = BC.BKG_NO" ).append("\n"); 
		query.append("                           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                           AND CHG_CD  = 'DIH' )" ).append("\n"); 
		query.append("           AND EXISTS ( SELECT 'X' " ).append("\n"); 
		query.append("                          FROM BKG_CHG_RT" ).append("\n"); 
		query.append("                         WHERE BKG_NO = BC.BKG_NO )" ).append("\n"); 
		query.append("           AND EXISTS ( SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , OP_CNTR_QTY " ).append("\n"); 
		query.append("                          FROM (" ).append("\n"); 
		query.append("                                SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     , OP_CNTR_QTY " ).append("\n"); 
		query.append("                                  FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                 MINUS" ).append("\n"); 
		query.append("                                SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     , OP_CNTR_QTY " ).append("\n"); 
		query.append("                                  FROM BKG_QTY_HIS" ).append("\n"); 
		query.append("                                 WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("                                   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                             )" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT CNTR_TPSZ_CD, OP_CNTR_QTY " ).append("\n"); 
		query.append("						  FROM (" ).append("\n"); 
		query.append("                                SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     , OP_CNTR_QTY " ).append("\n"); 
		query.append("                                  FROM BKG_QTY_HIS" ).append("\n"); 
		query.append("                                 WHERE BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("                                   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                                MINUS" ).append("\n"); 
		query.append("                                SELECT CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                     , OP_CNTR_QTY " ).append("\n"); 
		query.append("                                  FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                                 WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                      ) " ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}