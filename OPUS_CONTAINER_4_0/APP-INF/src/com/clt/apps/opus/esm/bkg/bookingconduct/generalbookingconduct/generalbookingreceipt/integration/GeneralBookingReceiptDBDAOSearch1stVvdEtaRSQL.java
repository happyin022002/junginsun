/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearch1stVvdEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.30
*@LastModifier : jklim
*@LastVersion : 1.0
* 2015.04.30 jklim
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jklim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearch1stVvdEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearch1stVvdEtaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearch1stVvdEtaRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(N1ST_ETA, 'yyyy-mm-dd hh24:mi') n1st_eta" ).append("\n"); 
		query.append("      ,TO_CHAR(N1ST_ETA, 'yyyy-mm-dd') 		 n1st_eta_day" ).append("\n"); 
		query.append("      ,TO_CHAR(N1ST_ETA, 'hh24:mi') 		 n1st_eta_time" ).append("\n"); 
		query.append("	  ,TO_CHAR(DEL_ETA,  'yyyy-mm-dd hh24:mi') del_eta" ).append("\n"); 
		query.append("      ,TO_CHAR(DEL_ETA,  'yyyy-mm-dd') 		 del_eta_day" ).append("\n"); 
		query.append("      ,TO_CHAR(DEL_ETA,  'hh24:mi') 		 del_eta_time" ).append("\n"); 
		query.append("  FROM (SELECT MAX(DTL.ESTM_DT) DEL_ETA" ).append("\n"); 
		query.append("		  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("				, SCE_COP_HDR HDR" ).append("\n"); 
		query.append("				, SCE_COP_DTL DTL" ).append("\n"); 
		query.append(" 		 WHERE BK.BKG_NO     = HDR.BKG_NO(+)" ).append("\n"); 
		query.append("		   AND HDR.COP_NO    = DTL.COP_NO" ).append("\n"); 
		query.append("  		   AND BK.DEL_NOD_CD = DTL.NOD_CD(+)" ).append("\n"); 
		query.append("		   AND (DTL.ACT_CD LIKE 'FI__A_' OR DTL.ACT_CD LIKE 'FU__U_')" ).append("\n"); 
		query.append("		   AND BK.BKG_NO  = @[bkg_no]) DEL_ETA" ).append("\n"); 
		query.append("	  ,(SELECT VPS_ETA_DT N1ST_ETA" ).append("\n"); 
		query.append("		  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("		 WHERE VPS_PORT_CD  = @[pol_cd]" ).append("\n"); 
		query.append("		   AND CLPT_IND_SEQ = NVL((SELECT VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("									 FROM BKG_VVD VVD" ).append("\n"); 
		query.append("								    WHERE VVD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("									  AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("								      AND VVD.VSL_CD       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("								      AND VVD.SKD_VOY_NO   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("								      AND VVD.SKD_DIR_CD   = substr(@[bkg_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("								      AND ROWNUM = 1), '1')" ).append("\n"); 
		query.append("		   AND VSL_CD       = substr(@[bkg_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("		   AND SKD_VOY_NO   = substr(@[bkg_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("		   AND SKD_DIR_CD   = substr(@[bkg_vvd_cd], 9, 1)) N1ST_ETA" ).append("\n"); 

	}
}