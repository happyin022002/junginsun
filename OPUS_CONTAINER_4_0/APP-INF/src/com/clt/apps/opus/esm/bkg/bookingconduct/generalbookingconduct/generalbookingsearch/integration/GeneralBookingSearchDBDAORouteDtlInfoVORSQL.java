/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAORouteDtlInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 전성진
*@LastVersion : 1.0
* 2010.01.06 전성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung Jin Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAORouteDtlInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RouteDtlInfoVO
	  * </pre>
	  */
	public GeneralBookingSearchDBDAORouteDtlInfoVORSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAORouteDtlInfoVORSQL").append("\n"); 
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
		query.append("SELECT A1.POR_CD" ).append("\n"); 
		query.append(",SUBSTR(A1.POR_NOD_CD, 6, 2) POR_NOD_CD" ).append("\n"); 
		query.append(",A1.POL_CD" ).append("\n"); 
		query.append(",SUBSTR(A1.POL_NOD_CD, 6, 2) POL_NOD_CD" ).append("\n"); 
		query.append(",A1.ORG_TRNS_MOD_CD" ).append("\n"); 
		query.append(",A1.POD_CD" ).append("\n"); 
		query.append(",SUBSTR(A1.POD_NOD_CD, 6, 2) POD_NOD_CD" ).append("\n"); 
		query.append(",A1.DEL_CD" ).append("\n"); 
		query.append(",SUBSTR(A1.DEL_NOD_CD, 6, 2) DEL_NOD_CD" ).append("\n"); 
		query.append(",A1.DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append(",TO_CHAR(A3.VPS_ETA_DT,'YYYY-MM-DD') VPS_ETA_DT_DATE" ).append("\n"); 
		query.append(",TO_CHAR(A3.VPS_ETA_DT,'HH24:MI') VPS_ETA_DT_TIME" ).append("\n"); 
		query.append(",TO_CHAR(A4.DEL_ETA, 'YYYY-MM-DD HH:MI') DEL_ETA" ).append("\n"); 
		query.append(",TO_CHAR(A4.DEL_ETA, 'YYYY-MM-DD') DEL_ETA_DAY" ).append("\n"); 
		query.append(",TO_CHAR(A4.DEL_ETA, 'HH24:MI') DEL_ETA_TIME" ).append("\n"); 
		query.append("FROM BKG_BOOKING A1" ).append("\n"); 
		query.append(",(SELECT BKG_NO" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",NVL(POL_CLPT_IND_SEQ, 1) AS POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND VSL_PRE_PST_CD IN ('S','T'))  A2" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD A3" ).append("\n"); 
		query.append(",(SELECT BK.BKG_NO" ).append("\n"); 
		query.append(",MAX(DTL.ESTM_DT) DEL_ETA" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append(",SCE_COP_HDR HDR" ).append("\n"); 
		query.append(",SCE_COP_DTL DTL" ).append("\n"); 
		query.append("WHERE BK.BKG_NO = HDR.BKG_NO(+)" ).append("\n"); 
		query.append("AND HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("AND BK.DEL_NOD_CD = DTL.NOD_CD(+)" ).append("\n"); 
		query.append("AND (   DTL.ACT_CD LIKE 'FI__A_'" ).append("\n"); 
		query.append("OR DTL.ACT_CD LIKE 'FU__U_')" ).append("\n"); 
		query.append("AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("GROUP BY BK.BKG_NO) A4" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A1.SKD_DIR_CD = A2.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND A1.POL_CD = A2.POL_CD (+)" ).append("\n"); 
		query.append("AND A2.VSL_CD = A3.VSL_CD (+)" ).append("\n"); 
		query.append("AND A2.SKD_VOY_NO = A3.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND A2.SKD_DIR_CD = A3.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND A2.POL_CD = A3.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("AND A2.POL_CLPT_IND_SEQ = A3.CLPT_IND_SEQ (+)" ).append("\n"); 
		query.append("AND A1.BKG_NO = A4.BKG_NO (+)" ).append("\n"); 

	}
}