/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchVvdSkdForTsRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.26 
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

public class GeneralBookingReceiptDBDAOSearchVvdSkdForTsRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TS Route에서 VVD 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchVvdSkdForTsRouteRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchVvdSkdForTsRouteRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	VVD.BKG_NO" ).append("\n"); 
		query.append(",	VVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append(",	VVD.VSL_SEQ" ).append("\n"); 
		query.append(",	VVD.SLAN_CD" ).append("\n"); 
		query.append(",	VVD.VSL_CD" ).append("\n"); 
		query.append(",	VVD.SKD_VOY_NO" ).append("\n"); 
		query.append(",	VVD.SKD_DIR_CD" ).append("\n"); 
		query.append(",   VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD BKG_VVD_CD" ).append("\n"); 
		query.append(",   VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",   VVD.POD_CLPT_IND_SEQ " ).append("\n"); 
		query.append(",	VVD.OP_CD" ).append("\n"); 
		query.append(",	VVD.POL_CD" ).append("\n"); 
		query.append(",	SUBSTR(VVD.POL_YD_CD,6,2) POL_YD_CD" ).append("\n"); 
		query.append(",	VVD.POD_CD" ).append("\n"); 
		query.append(",	SUBSTR(VVD.POD_YD_CD,6,2) POD_YD_CD" ).append("\n"); 
		query.append(",	VVD.BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append(",	VVD.CNTR_LODG_FLG" ).append("\n"); 
		query.append(",	VVD.REV_VVD_FLG" ).append("\n"); 
		query.append(",	VVD.CRE_USR_ID" ).append("\n"); 
		query.append(",	VVD.CRE_DT" ).append("\n"); 
		query.append(",	VVD.UPD_USR_ID" ).append("\n"); 
		query.append(",	VVD.UPD_DT    " ).append("\n"); 
		query.append(",   (SELECT TO_CHAR(POL.VPS_ETD_DT,'YYYY-MM-DD') ETD_DAY" ).append("\n"); 
		query.append("       FROM VSK_VSL_PORT_SKD POL" ).append("\n"); 
		query.append("          , VSK_VSL_PORT_SKD POD" ).append("\n"); 
		query.append("      WHERE POL.VPS_PORT_CD  = VVD.POL_CD" ).append("\n"); 
		query.append("        AND POL.YD_CD        = VVD.POL_YD_CD" ).append("\n"); 
		query.append("        AND POL.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ           " ).append("\n"); 
		query.append("        AND POL.VSL_CD       = VVD.VSL_CD" ).append("\n"); 
		query.append("        AND POL.SKD_VOY_NO   = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND POL.SKD_DIR_CD   = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND POD.VPS_PORT_CD  = VVD.POD_CD" ).append("\n"); 
		query.append("        AND POD.YD_CD        = VVD.POD_YD_CD" ).append("\n"); 
		query.append("        AND POD.CLPT_IND_SEQ = VVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND POD.VSL_CD       = VVD.VSL_CD" ).append("\n"); 
		query.append("        AND POD.SKD_VOY_NO   = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND POD.SKD_DIR_CD   = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND POL.CLPT_SEQ     < POD.CLPT_SEQ" ).append("\n"); 
		query.append("        AND NVL(POL.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("        AND NVL(POD.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("     ) ETD_DAY" ).append("\n"); 
		query.append(",   (SELECT TO_CHAR(POD.VPS_ETA_DT,'YYYY-MM-DD') ETA_DAY " ).append("\n"); 
		query.append("       FROM VSK_VSL_PORT_SKD POL" ).append("\n"); 
		query.append("          , VSK_VSL_PORT_SKD POD" ).append("\n"); 
		query.append("      WHERE POL.VPS_PORT_CD  = VVD.POL_CD" ).append("\n"); 
		query.append("        AND POL.YD_CD        = VVD.POL_YD_CD" ).append("\n"); 
		query.append("        AND POL.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ           " ).append("\n"); 
		query.append("        AND POL.VSL_CD       = VVD.VSL_CD" ).append("\n"); 
		query.append("        AND POL.SKD_VOY_NO   = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND POL.SKD_DIR_CD   = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND POD.VPS_PORT_CD  = VVD.POD_CD" ).append("\n"); 
		query.append("        AND POD.YD_CD        = VVD.POD_YD_CD" ).append("\n"); 
		query.append("        AND POD.CLPT_IND_SEQ = VVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("        AND POD.VSL_CD       = VVD.VSL_CD" ).append("\n"); 
		query.append("        AND POD.SKD_VOY_NO   = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND POD.SKD_DIR_CD   = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND POL.CLPT_SEQ     < POD.CLPT_SEQ" ).append("\n"); 
		query.append("        AND NVL(POL.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("        AND NVL(POD.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("     ) ETA_DAY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("FROM BKG_VVD_HIS VVD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM BKG_VVD VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BKG_NO, VSL_PRE_PST_CD, VSL_SEQ" ).append("\n"); 

	}
}