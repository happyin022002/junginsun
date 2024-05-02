/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyPolForVslSkdCngUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.17 
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

public class GeneralBookingReceiptDBDAOmodifyPolForVslSkdCngUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSK에서 VSK_VSL_PORT_SKD에 CLPT_IND_SEQ나 YD_CD가 변경되었을 때 BKG_VVD에 UPDATE하기 위해 사용함
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyPolForVslSkdCngUSQL(){
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
		params.put("new_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyPolForVslSkdCngUSQL").append("\n"); 
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
		query.append("UPDATE BKG_VVD V" ).append("\n"); 
		query.append("   SET POL_YD_CD        = @[new_yd_cd]" ).append("\n"); 
		query.append("     , POL_CLPT_IND_SEQ = @[new_clpt_ind_seq]" ).append("\n"); 
		query.append("     , upd_usr_id       = @[upd_usr_id]" ).append("\n"); 
		query.append("	 , upd_dt           = SYSDATE" ).append("\n"); 
		query.append(" WHERE VSL_CD     = substr(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = substr(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND POL_CD     = @[port_cd]" ).append("\n"); 
		query.append("   AND POL_YD_CD  = @[old_yd_cd]" ).append("\n"); 
		query.append("   AND NVL(POL_CLPT_IND_SEQ, 1) = @[old_clpt_ind_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND BKG_NO IN" ).append("\n"); 
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
		query.append("		) " ).append("\n"); 

	}
}