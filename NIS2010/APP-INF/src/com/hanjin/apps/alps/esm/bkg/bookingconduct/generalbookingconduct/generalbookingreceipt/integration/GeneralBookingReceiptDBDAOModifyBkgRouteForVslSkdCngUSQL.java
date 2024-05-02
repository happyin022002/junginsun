/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyBkgRouteForVslSkdCngUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.28 
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

public class GeneralBookingReceiptDBDAOModifyBkgRouteForVslSkdCngUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PORT
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyBkgRouteForVslSkdCngUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyBkgRouteForVslSkdCngUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BOOKING" ).append("\n"); 
		query.append("   SET POR_NOD_CD       = CASE WHEN RCV_TERM_CD <> 'D' AND POR_NOD_CD = POL_NOD_CD " ).append("\n"); 
		query.append("										THEN DECODE(POL_CD, @[port_cd], @[new_yd_cd], POL_NOD_CD)" ).append("\n"); 
		query.append("							   ELSE POR_NOD_CD END" ).append("\n"); 
		query.append("	 , POL_NOD_CD		= DECODE(POL_CD, @[port_cd], @[new_yd_cd], POL_NOD_CD)" ).append("\n"); 
		query.append("  	 , POD_NOD_CD 		= DECODE(POD_CD, @[port_cd], @[new_yd_cd], POD_NOD_CD)	" ).append("\n"); 
		query.append("	 , DEL_NOD_CD		= CASE WHEN DE_TERM_CD <> 'D' AND DEL_NOD_CD = POD_NOD_CD" ).append("\n"); 
		query.append("										THEN DECODE(POD_CD, @[port_cd], @[new_yd_cd], POD_NOD_CD)" ).append("\n"); 
		query.append("							   ELSE DEL_NOD_CD END" ).append("\n"); 
		query.append("     , upd_usr_id 		= @[upd_usr_id]" ).append("\n"); 
		query.append("     , upd_dt 			= SYSDATE" ).append("\n"); 
		query.append(" WHERE BKG_NO IN" ).append("\n"); 
		query.append("		(SELECT V.BKG_NO" ).append("\n"); 
		query.append("		   FROM BKG_BOOKING B" ).append("\n"); 
		query.append("              , BKG_VVD V" ).append("\n"); 
		query.append("		  WHERE B.BKG_NO     = V.BKG_NO" ).append("\n"); 
		query.append("		    AND V.VSL_CD     = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("		    AND V.SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("			AND V.SKD_DIR_CD = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("			AND ((V.POL_CD     = @[port_cd]" ).append("\n"); 
		query.append("				  AND NVL(V.POL_CLPT_IND_SEQ, 1) = @[old_clpt_ind_seq])" ).append("\n"); 
		query.append("				OR " ).append("\n"); 
		query.append(" 				 (V.POD_CD     = @[port_cd]" ).append("\n"); 
		query.append("				  AND NVL(V.POD_CLPT_IND_SEQ, 1) = @[old_clpt_ind_seq])" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("            AND NOT EXISTS (SELECT 1 " ).append("\n"); 
		query.append("                              FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                             WHERE HRD_CDG_ID = 'VSK_YD_CHG_EXPT'" ).append("\n"); 
		query.append("                               AND NVL(ATTR_CTNT1,B.POL_CD)  = B.POL_CD" ).append("\n"); 
		query.append("                               AND NVL(ATTR_CTNT2,B.POD_CD)  = B.POD_CD" ).append("\n"); 
		query.append("                               AND NVL(ATTR_CTNT3,V.POL_CD)  = V.POL_CD" ).append("\n"); 
		query.append("                               AND NVL(ATTR_CTNT4,V.POD_CD)  = V.POD_CD )" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   AND (   (POL_CD     = @[port_cd]" ).append("\n"); 
		query.append("            AND POL_NOD_CD  = @[old_yd_cd] )" ).append("\n"); 
		query.append("        OR (POD_CD     = @[port_cd]" ).append("\n"); 
		query.append("            AND POD_NOD_CD  = @[old_yd_cd] )" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}