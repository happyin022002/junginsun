/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi322ReceiveDBDAOSearchEdi322BkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi322ReceiveDBDAOSearchEdi322BkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdi322BkgNo
	  * </pre>
	  */
	public Edi322ReceiveDBDAOSearchEdi322BkgNoRSQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.integration").append("\n"); 
		query.append("FileName : Edi322ReceiveDBDAOSearchEdi322BkgNoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT BKG_NO, PRT FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT BKG_NO, 1 PRT FROM BKG_BOOKING A" ).append("\n"); 
		query.append("        WHERE A.BKG_NO = NVL(@[bkg_no], @[bl_no])" ).append("\n"); 
		query.append("          AND A.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT /*+ INDEX(BB XPKBKG_BOOKING) */ BB.BKG_NO, 2 PRT" ).append("\n"); 
		query.append("        FROM BKG_BOOKING BB," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT BKG_NO" ).append("\n"); 
		query.append("            FROM(" ).append("\n"); 
		query.append("                SELECT BKG_NO" ).append("\n"); 
		query.append("                FROM BKG_CONTAINER" ).append("\n"); 
		query.append("                WHERE CNTR_NO LIKE @[cntr_no] ||'%'" ).append("\n"); 
		query.append("        		AND    ( NVL(CNMV_ID_NO,0) <> 0 AND NVL(CNMV_ID_NO,0) <> 0)" ).append("\n"); 
		query.append("                ORDER BY CNTR_NO, CNMV_YR DESC, CNMV_ID_NO DESC, CNMV_CYC_NO DESC)" ).append("\n"); 
		query.append("           ) BC" ).append("\n"); 
		query.append("        WHERE BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("          AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("          AND BB.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("          AND ROWNUM = 1" ).append("\n"); 
		query.append("          AND 'F'= (SELECT /*+ INDEX_DESC(CTM XPKCTM_MOVEMENT) */ NVL(BKG_CGO_TP_CD, 'M') FROM CTM_MOVEMENT CTM WHERE CTM.CNTR_NO LIKE @[cntr_no] ||'%' AND ROWNUM=1)" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    ORDER BY PRT" ).append("\n"); 
		query.append(") WHERE ROWNUM=1" ).append("\n"); 

	}
}