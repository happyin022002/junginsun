/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301BlCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301BlCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301BlCntr
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301BlCntrRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301BlCntrRSQL").append("\n"); 
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
		query.append("SELECT	'{BL_CNTR'																|| CHR(10)" ).append("\n"); 
		query.append("	||	'HTYP:'			|| QTY.CNTR_TPSZ_CD										|| CHR(10)" ).append("\n"); 
		query.append("	||	'ITYP:'			|| TS.CNTR_TPSZ_ISO_CD									|| CHR(10)" ).append("\n"); 
		query.append("	||	'CNT:'			|| QTY.OP_CNTR_QTY										|| CHR(10)" ).append("\n"); 
		query.append("	||  'OLDCNT:'		|| NVL(OLDCNT.OP_CNTR_QTY, 0)							|| CHR(10)" ).append("\n"); 
		query.append("	||	'FLEX_IND:'		|| DECODE(NVL(QTY.FLEX_HGT_FLG,0),'Y','1','0')			|| CHR(10)" ).append("\n"); 
		query.append("	||	'}BL_CNTR' || CHR(10) BL_CNTR" ).append("\n"); 
		query.append("  FROM BKG_QUANTITY QTY, " ).append("\n"); 
		query.append("	   MDM_CNTR_TP_SZ TS" ).append("\n"); 
		query.append("       #if($typeCd_list.size() > 0)" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("	   		#foreach($type_cd IN ${typeCd_list})" ).append("\n"); 
		query.append("			#set($type_cd_loop_val = $velocityCount)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#foreach($cnt IN ${cnt_list})" ).append("\n"); 
		query.append("				#set($cnt_loop_val = $velocityCount)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					#if($type_cd_loop_val == $cnt_loop_val)" ).append("\n"); 
		query.append("						#if($type_cd_loop_val < $typeCd_list.size())" ).append("\n"); 
		query.append("							SELECT '$type_cd' AS CNTR_TPSZ_CD, $cnt AS OP_CNTR_QTY FROM DUAL UNION ALL" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							SELECT '$type_cd' AS CNTR_TPSZ_CD, $cnt AS OP_CNTR_QTY FROM DUAL" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		) OLDCNT" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		,(SELECT '' AS CNTR_TPSZ_CD, 0 AS OP_CNTR_QTY FROM DUAL ) OLDCNT" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append(" WHERE QTY.CNTR_TPSZ_CD = TS.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("   AND TS.CNTR_TPSZ_ISO_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND QTY.bkg_no		= @[bkg_no]" ).append("\n"); 
		query.append("   AND QTY.CNTR_TPSZ_CD = OLDCNT.CNTR_TPSZ_CD(+)" ).append("\n"); 

	}
}