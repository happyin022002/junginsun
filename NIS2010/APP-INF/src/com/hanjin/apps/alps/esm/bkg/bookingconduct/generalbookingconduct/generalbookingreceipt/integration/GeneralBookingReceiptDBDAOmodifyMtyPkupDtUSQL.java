/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyMtyPkupDtUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.13
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.13 
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

public class GeneralBookingReceiptDBDAOmodifyMtyPkupDtUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mty pick up date를 수정한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyMtyPkupDtUSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pls_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyMtyPkupDtUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BOOKING " ).append("\n"); 
		query.append("   SET MTY_PKUP_DT =  BKG_GET_WRK_DT_FNC((SELECT SKD.VPS_ETA_DT" ).append("\n"); 
		query.append("  										    FROM BKG_VVD VVD, BKG_BOOKING BK, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("  										   WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("  											 AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("											 AND VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("											 AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("											 AND (VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ) IN (SELECT MIN(VVD2.VSL_PRE_PST_CD||VVD2.VSL_SEQ)" ).append("\n"); 
		query.append("                                            											 FROM BKG_VVD VVD2" ).append("\n"); 
		query.append("                                           											    WHERE VVD.BKG_NO = VVD2.BKG_NO)" ).append("\n"); 
		query.append("											 AND VVD.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("											 AND VVD.SKD_VOY_NO =SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("											 AND VVD.SKD_DIR_CD =SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("											 AND VVD.POL_CD = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("											 AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("										 ,to_number(@[pls_dt]),@[pol_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}