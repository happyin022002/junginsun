/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchVslCdByLloydNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchVslCdByLloydNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL_CD를 조회한다.
	  * </pre>
	  */
	public BookingUtilDBDAOSearchVslCdByLloydNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchVslCdByLloydNoRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DECODE(CNT.CNT, 1, VSL.VSL_CD, SKD.VSL_CD) VSL_CD" ).append("\n"); 
		query.append("              ,DECODE(CNT.CNT, 1, SYSDATE, SKD.CRE_DT) CRE_DT" ).append("\n"); 
		query.append("          FROM MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("              ,VSK_VSL_SKD SKD" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("               SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("                 FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("                WHERE LLOYD_NO = @[lloyd_no]" ).append("\n"); 
		query.append("                  AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("               ) CNT" ).append("\n"); 
		query.append("         WHERE VSL.LLOYD_NO  = @[lloyd_no]" ).append("\n"); 
		query.append("           AND VSL.DELT_FLG = 'N'" ).append("\n"); 
		query.append("           AND VSL.VSL_CD = SKD.VSL_CD(+)" ).append("\n"); 
		query.append("           AND SKD.SKD_VOY_NO(+) = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND SKD.SKD_DIR_CD(+) = @[skd_dir_cd]" ).append("\n"); 
		query.append("        ORDER BY SKD.CRE_DT DESC" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE CRE_DT IS NOT NULL" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}