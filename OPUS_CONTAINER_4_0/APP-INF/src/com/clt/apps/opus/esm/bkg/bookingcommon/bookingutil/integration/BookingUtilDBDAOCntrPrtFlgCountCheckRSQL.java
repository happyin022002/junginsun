/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOCntrPrtFlgCountCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.04
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.11.04 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOCntrPrtFlgCountCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingUtilDBDAOCntrPrtFlgCountCheckRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOCntrPrtFlgCountCheckRSQL").append("\n"); 
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
		query.append("SELECT B.BKG_NO" ).append("\n"); 
		query.append("FROM   BKG_CONTAINER A, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND    A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND    B.BKG_NO <> @[bkg_no]" ).append("\n"); 
		query.append("AND    (B.VSL_CD,B.SKD_VOY_NO,B.SKD_DIR_CD) = (SELECT BB.VSL_CD,BB.SKD_VOY_NO,BB.SKD_DIR_CD FROM BKG_BOOKING BB WHERE BB.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("AND    B.BKG_CGO_TP_CD = (SELECT BB.bkg_cgo_tp_cd FROM BKG_BOOKING BB WHERE BB.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("AND    (B.BKG_STS_CD = 'W' OR B.BKG_STS_CD = 'F')" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                 FROM BKG_BOOKING BK, BKG_CONTAINER BC" ).append("\n"); 
		query.append("                 WHERE 1=1                                    " ).append("\n"); 
		query.append("                   AND BC.CNTR_PRT_FLG ='Y'" ).append("\n"); 
		query.append("                   AND BK.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                   AND BK.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                   AND BK.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND BK.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND ROWNUM = 1 " ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}