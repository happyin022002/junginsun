/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OpfUtilDBDAOVskVslPortEtaVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOVskVslPortEtaVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD의 Port 및 ETA를 조회합니다.
	  * 
	  * 2011.11.21 김민아 [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD 및 Port 설정 기능 변경
	  * </pre>
	  */
	public OpfUtilDBDAOVskVslPortEtaVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOVskVslPortEtaVORSQL").append("\n"); 
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
		query.append("SELECT  A.VPS_PORT_CD" ).append("\n"); 
		query.append("       ,A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("       ,TO_CHAR(A.VPS_ETA_DT, 'YYYY-MM-DD') AS VPS_ETA_DT" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT	A.VPS_PORT_CD" ).append("\n"); 
		query.append("               ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("               ,A.CLPT_SEQ" ).append("\n"); 
		query.append("               ,A.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("               ,A.YD_CD" ).append("\n"); 
		query.append("               ,A.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("               ,A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("               ,A.VPS_ETA_DT" ).append("\n"); 
		query.append("          FROM  VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("         WHERE  A.VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("           AND  A.SKD_VOY_NO    = @[voy_no]" ).append("\n"); 
		query.append("           AND  A.SKD_DIR_CD    = @[dir_cd]" ).append("\n"); 
		query.append("           AND  A.TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("           AND  NVL(A.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("       ,MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE	A.VPS_PORT_CD = B.LOC_CD" ).append("\n"); 
		query.append("ORDER   BY  CLPT_SEQ" ).append("\n"); 

	}
}