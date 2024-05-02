/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingSearchDBDAORouteDtlVvdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2010.01.06 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAORouteDtlVvdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RouteDtlVvdVO
	  * </pre>
	  */
	public GeneralBookingSearchDBDAORouteDtlVvdVORSQL(){
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
		query.append("FileName : GeneralBookingSearchDBDAORouteDtlVvdVORSQL").append("\n"); 
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
		query.append("SELECT CASE A1.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("WHEN 'S' THEN 'Pre'||A1.VSL_SEQ" ).append("\n"); 
		query.append("WHEN 'U' THEN 'Post'||A1.VSL_SEQ" ).append("\n"); 
		query.append("ELSE 'Trunk' END VSL_PRE_PST_CD" ).append("\n"); 
		query.append(",A1.POL_CD" ).append("\n"); 
		query.append(",SUBSTR(A1.POL_YD_CD, 6, 2) POL_YD_CD" ).append("\n"); 
		query.append(",A1.POD_CD" ).append("\n"); 
		query.append(",SUBSTR(A1.POD_YD_CD, 6, 2) POD_YD_CD" ).append("\n"); 
		query.append(",A1.VSL_CD||A1.SKD_VOY_NO||A1.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append(",A1.SLAN_CD" ).append("\n"); 
		query.append(",to_char(A2.VPS_ETD_DT,'YYYY-MM-DD') VPS_ETD_DT_DATE" ).append("\n"); 
		query.append(",to_char(A2.VPS_ETD_DT,'HH24:MI') VPS_ETD_DT_TIME" ).append("\n"); 
		query.append(",to_char(A3.VPS_ETA_DT,'YYYY-MM-DD') VPS_ETA_DT_DATE" ).append("\n"); 
		query.append(",to_char(A3.VPS_ETA_DT,'HH24:MI') VPS_ETA_DT_TIME" ).append("\n"); 
		query.append("FROM BKG_VVD A1" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD A2" ).append("\n"); 
		query.append(",VSK_VSL_PORT_SKD A3" ).append("\n"); 
		query.append("WHERE A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A1.VSL_CD = A2.VSL_CD (+)" ).append("\n"); 
		query.append("AND A1.SKD_VOY_NO = A2.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND A1.SKD_DIR_CD = A2.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND A1.POL_CD = A2.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("AND A1.POL_CLPT_IND_SEQ = A2.CLPT_IND_SEQ (+)" ).append("\n"); 
		query.append("AND A1.VSL_CD = A3.VSL_CD (+)" ).append("\n"); 
		query.append("AND A1.SKD_VOY_NO = A3.SKD_VOY_NO (+)" ).append("\n"); 
		query.append("AND A1.SKD_DIR_CD = A3.SKD_DIR_CD (+)" ).append("\n"); 
		query.append("AND A1.POD_CD = A3.VPS_PORT_CD (+)" ).append("\n"); 
		query.append("AND A1.POD_CLPT_IND_SEQ = A3.CLPT_IND_SEQ (+)" ).append("\n"); 
		query.append("ORDER BY A1.VSL_PRE_PST_CD" ).append("\n"); 

	}
}