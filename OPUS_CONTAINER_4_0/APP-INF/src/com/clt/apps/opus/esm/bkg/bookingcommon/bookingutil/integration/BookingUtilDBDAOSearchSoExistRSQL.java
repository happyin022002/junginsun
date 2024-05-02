/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOSearchSoExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.14
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.04.14 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchSoExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Check S/O is created or not
	  * </pre>
	  */
	public BookingUtilDBDAOSearchSoExistRSQL(){
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
		params.put("bound_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchSoExistRSQL").append("\n"); 
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
		query.append("SELECT	TRSP_BND_CD" ).append("\n"); 
		query.append("		,'SVC' FLAG" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND NVL(TRSP_FRST_FLG, 'X') <> 'Y'" ).append("\n"); 
		query.append("AND TRSP_BND_CD = DECODE(@[bound_cd], 'B', TRSP_BND_CD, @[bound_cd])" ).append("\n"); 
		query.append("AND TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("#if(${nod_cd} != '')" ).append("\n"); 
		query.append("	#if(${bound_cd} == 'O')" ).append("\n"); 
		query.append("		AND	TO_NOD_CD = @[nod_cd]" ).append("\n"); 
		query.append("	#elseif(${bound_cd} == 'I')" ).append("\n"); 
		query.append("		AND FM_NOD_CD = @[nod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	TRSP_BND_CD" ).append("\n"); 
		query.append("		,'RAIL' FLAG" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("WHERE 0=0" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND NVL(TRSP_FRST_FLG, 'X') <> 'Y'" ).append("\n"); 
		query.append("AND TRSP_BND_CD = DECODE(@[bound_cd], 'B', TRSP_BND_CD, @[bound_cd])" ).append("\n"); 
		query.append("AND CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("#if(${nod_cd} != '')" ).append("\n"); 
		query.append("	#if(${bound_cd} == 'O')" ).append("\n"); 
		query.append("		AND	TO_NOD_CD = @[nod_cd]" ).append("\n"); 
		query.append("	#elseif(${bound_cd} == 'I')" ).append("\n"); 
		query.append("		AND FM_NOD_CD = @[nod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}