/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchVslSkdCngNoticeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.11
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.07.11 류대영
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

public class GeneralBookingReceiptDBDAOsearchVslSkdCngNoticeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule Change Notice의 대상을 조회한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchVslSkdCngNoticeRSQL(){
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
		params.put("old_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_cng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOsearchVslSkdCngNoticeRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       USR.USR_ID" ).append("\n"); 
		query.append("     , NVL(USR.USR_EML, DFLT.DFLT_EML) USR_EML" ).append("\n"); 
		query.append("     , @[vvd] VVD" ).append("\n"); 
		query.append("     , @[port_cd] PORT_CD" ).append("\n"); 
		query.append("	 , @[skd_cng_tp_cd] SKD_CNG_TP_CD" ).append("\n"); 
		query.append("	 , TO_CHAR(TO_DATE(@[old_etd_dt], 'YYYYMMDDHH24MISS'),'YYYY-MM-DD hh24:mi') OLD_ETD_DT" ).append("\n"); 
		query.append("	 , TO_CHAR(TO_DATE(@[old_eta_dt], 'YYYYMMDDHH24MISS'),'YYYY-MM-DD hh24:mi') OLD_ETA_DT" ).append("\n"); 
		query.append("     , (SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD hh24:mi')" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("           AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("           AND CLPT_IND_SEQ = @[old_clpt_ind_seq]) NEW_ETD_DT" ).append("\n"); 
		query.append("     , (SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD hh24:mi')" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("         WHERE VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("           AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("           AND CLPT_IND_SEQ = @[old_clpt_ind_seq]) NEW_ETA_DT" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("        , BKG_BOOKING BK" ).append("\n"); 
		query.append("        , COM_USER USR" ).append("\n"); 
		query.append("        , BKG_USR_DFLT_SET DFLT" ).append("\n"); 
		query.append(" WHERE VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("   AND USR.USR_ID = BK.DOC_USR_ID" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND USR.USR_ID = DFLT.USR_ID" ).append("\n"); 
		query.append("   AND DFLT.VSKD_DLAY_FLG = 'Y'" ).append("\n"); 
		query.append("   AND VVD.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND VVD.POD_CD     = @[port_cd]" ).append("\n"); 
		query.append("   AND VVD.POD_YD_CD  = @[old_yd_cd]" ).append("\n"); 
		query.append("   AND NVL(VVD.POD_CLPT_IND_SEQ, 1) = @[old_clpt_ind_seq]" ).append("\n"); 
		query.append("   AND ROUND((SELECT VPS_ETA_DT" ).append("\n"); 
		query.append(" 		        FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("  		       WHERE VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("  		         AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   		         AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   		         AND VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("    		     AND CLPT_IND_SEQ = @[old_clpt_ind_seq]) " ).append("\n"); 
		query.append("       - TO_DATE(@[old_eta_dt], 'YYYYMMDDHH24MISS'), 10) >= ROUND(1 / 24 * 10, 10) --10시간 이상" ).append("\n"); 

	}
}