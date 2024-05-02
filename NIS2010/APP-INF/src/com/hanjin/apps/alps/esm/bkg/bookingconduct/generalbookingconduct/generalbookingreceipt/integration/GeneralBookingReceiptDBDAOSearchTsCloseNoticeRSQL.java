/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchTsCloseNoticeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.28
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.01.28 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchTsCloseNoticeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * T/S Close Notice에 대해서 수신인 email address를 찾는다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchTsCloseNoticeRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchTsCloseNoticeRSQL").append("\n"); 
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
		query.append("SELECT (SELECT NVL(USR_EML, DFLT_EML) " ).append("\n"); 
		query.append("          FROM COM_USER USR, BKG_BOOKING BK " ).append("\n"); 
		query.append("         WHERE BK.DOC_USR_ID = USR.USR_ID" ).append("\n"); 
		query.append("           AND BK.BKG_NO = @[bkg_no]) ORG_RCVR_EML" ).append("\n"); 
		query.append("     , A.RCVR_EML TS_RCVR_EML" ).append("\n"); 
		query.append("     , SKD.VSL_CD||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("	 , @[bkg_no] BKG_NO" ).append("\n"); 
		query.append("  FROM BKG_CLL_CNG_NTFY_SET A, VSK_VSL_SKD SKD" ).append("\n"); 
		query.append(" WHERE LOCL_TS_IND_CD = 'T'" ).append("\n"); 
		query.append("   AND A.SLAN_CD = SKD.VSL_SLAN_CD " ).append("\n"); 
		query.append("   AND A.DIR_CD  = SKD.SKD_DIR_CD   " ).append("\n"); 
		query.append("   AND SKD.VSL_CD || SKD.SKD_VOY_NO || SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("		IN (" ).append("\n"); 
		query.append("#foreach( ${vvd} in ${closed_vvds}) " ).append("\n"); 
		query.append("	#if($velocityCount < $closed_vvds.size()) '$vvd', #else '$vvd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}