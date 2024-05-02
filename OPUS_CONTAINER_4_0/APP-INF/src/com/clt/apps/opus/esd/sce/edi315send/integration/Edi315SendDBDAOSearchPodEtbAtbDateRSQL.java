/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi315SendDBDAOSearchPodEtbAtbDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 김인규
*@LastVersion : 1.0
* 2015.01.02 김인규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author In Gyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchPodEtbAtbDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * POD 의 ETB, ATB DATE를 조회해온다.
	  * </pre>
	  */
	public Edi315SendDBDAOSearchPodEtbAtbDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchPodEtbAtbDateRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(B.VPS_ETB_DT,'YYYYMMDDHH24MI') POD_ETB" ).append("\n"); 
		query.append("     , DECODE(A.NOD_CD, NULL, '', DECODE(B.VPS_ETB_DT, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(A.NOD_CD,0,5), B.VPS_ETB_DT, 'GMT'), 'YYYYMMDDHH24MI'))) POD_ETB_GMT" ).append("\n"); 
		query.append("     , CASE WHEN PORT_SKD_STS_CD IN ('B','D') THEN TO_CHAR(B.VPS_ETB_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("            ELSE '' END POD_ATB" ).append("\n"); 
		query.append("     , CASE WHEN PORT_SKD_STS_CD IN ('B','D') THEN DECODE(A.NOD_CD, NULL, '', DECODE(B.VPS_ETB_DT, NULL, '', TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(A.NOD_CD,0,5), B.VPS_ETB_DT, 'GMT'), 'YYYYMMDDHH24MI')))" ).append("\n"); 
		query.append("            ELSE '' END POD_ATB_GMT" ).append("\n"); 
		query.append("  FROM SCE_COP_DTL A, VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append(" WHERE A.COP_NO = @[e_cop_no]" ).append("\n"); 
		query.append("   AND A.STND_EDI_STS_CD = 'UVD'" ).append("\n"); 
		query.append("   AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND A.VPS_PORT_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND A.CLPT_IND_SEQ = B.CLPT_IND_SEQ" ).append("\n"); 

	}
}