/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.15 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOsearchUsWhfSendMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfSendMain
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfSendMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfSendMainRSQL").append("\n"); 
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
		query.append("SELECT  A.VSL_CD" ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,A.PORT_CD" ).append("\n"); 
		query.append("       ,A.IO_BND_CD" ).append("\n"); 
		query.append("       ,A.VSL_NM" ).append("\n"); 
		query.append("       ,A.CRR_CD" ).append("\n"); 
		query.append("       ,A.VSL_VOY_DIR_NO" ).append("\n"); 
		query.append("       ,TO_CHAR(A.DEP_DT, 'YYYY-MM-DD') AS DEP_DT" ).append("\n"); 
		query.append("       ,A.BIL_RCV_PTY_NM" ).append("\n"); 
		query.append("       ,TO_CHAR(A.ARR_DT, 'YYYY-MM-DD') AS ARR_DT" ).append("\n"); 
		query.append("       ,A.BRTH_DESC" ).append("\n"); 
		query.append("       ,A.BIL_SND_PTY_NM" ).append("\n"); 
		query.append("       ,TO_CHAR(A.LOCL_UPD_DT, 'YYYY-MM-DD') AS LOCL_UPD_DT" ).append("\n"); 
		query.append("       ,A.SND_RMK" ).append("\n"); 
		query.append("       ,A.WHF_DC_RT" ).append("\n"); 
		query.append("       ,A.DDCT_AMT" ).append("\n"); 
		query.append("  FROM  BKG_USA_WHF_SND A" ).append("\n"); 
		query.append(" WHERE  VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND  SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND  SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("   AND  PORT_CD = @[port]" ).append("\n"); 
		query.append("   AND  IO_BND_CD = @[bound]" ).append("\n"); 

	}
}