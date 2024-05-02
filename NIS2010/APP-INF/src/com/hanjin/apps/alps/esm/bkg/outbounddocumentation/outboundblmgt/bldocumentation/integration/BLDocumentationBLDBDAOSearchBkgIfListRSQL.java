/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLDocumentationBLDBDAOSearchBkgIfListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.10.31 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOSearchBkgIfListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLDocumentationBLDBDAOSearchBkgIfList
	  * </pre>
	  */
	public BLDocumentationBLDBDAOSearchBkgIfListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOSearchBkgIfListRSQL").append("\n"); 
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
		query.append("SELECT  BK.BKG_NO," ).append("\n"); 
		query.append("        SKD1.VSL_CD || SKD1.SKD_VOY_NO || SKD1.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("        BK.POL_CD," ).append("\n"); 
		query.append("        BK.POD_CD," ).append("\n"); 
		query.append("        TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD') VPS_ETD_DT" ).append("\n"); 
		query.append("FROM   BKG_VVD VVD, BKG_BOOKING BK, VSK_VSL_PORT_SKD SKD1" ).append("\n"); 
		query.append("  WHERE  1=1" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("    AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("    AND BK.BKG_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("    AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("    AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_dt} != '')" ).append("\n"); 
		query.append("    AND SKD1.VPS_ETD_DT >= TO_DATE(@[fm_dt] ,'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${to_dt} != '')" ).append("\n"); 
		query.append("    AND SKD1.VPS_ETD_DT <= TO_DATE(@[to_dt] ,'YYYY-MM-DD') +0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("    AND VVD.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("    AND VVD.SKD_VOY_NO = SUBSTR(@[vvd_cd],4,4)" ).append("\n"); 
		query.append("    AND VVD.SKD_DIR_CD = SUBSTR(@[vvd_cd],8,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND  SKD1.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("    AND  SKD1.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND  SKD1.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND  SKD1.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("    AND  SKD1.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    AND  VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("    AND  VVD.POL_CD = BK.POL_CD" ).append("\n"); 

	}
}