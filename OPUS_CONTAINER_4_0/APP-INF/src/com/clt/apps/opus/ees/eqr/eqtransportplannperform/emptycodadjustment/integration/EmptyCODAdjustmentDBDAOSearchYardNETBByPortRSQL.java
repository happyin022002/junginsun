/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOSearchYardNETBByPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.02.23 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang HO Chae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOSearchYardNETBByPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOSearchYardNETBByPortRSQL(){
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
		params.put("editIbFlag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gPortCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOSearchYardNETBByPortRSQL").append("\n"); 
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
		query.append("#if(${gubun} == '1')" ).append("\n"); 
		query.append("SELECT		NVL(V.CLPT_IND_SEQ,'0')                         clptindseq," ).append("\n"); 
		query.append("			NVL(SUBSTR(V.YD_CD,6,2),'XX')					YD_CD	," ).append("\n"); 
		query.append("			DECODE( @[editIbFlag] , 'I' , TO_CHAR(V.VPS_ETB_DT,'YYYYMMDD') ," ).append("\n"); 
		query.append("			                              TO_CHAR(V.VPS_ETD_DT,'YYYYMMDD') )||'&&'||NVL(V.CLPT_IND_SEQ,'0')	ETB		" ).append("\n"); 
		query.append("	FROM	" ).append("\n"); 
		query.append("			VSK_VSL_PORT_SKD	V" ).append("\n"); 
		query.append("	WHERE	V.VSL_CD			=	SUBSTR( @[vvd] ,1,4)" ).append("\n"); 
		query.append("	AND		V.SKD_VOY_NO		=	SUBSTR( @[vvd] ,5,4)" ).append("\n"); 
		query.append("	AND		V.SKD_DIR_CD		=	SUBSTR( @[vvd] ,9,1)" ).append("\n"); 
		query.append("	AND		V.VPS_PORT_CD		=	@[gPortCd]" ).append("\n"); 
		query.append("	AND		NVL(V.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  '' clptindseq ,'' YD_CD , '' ETB" ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   LOC_CD          LIKE  @[gPortCd]||'%'" ).append("\n"); 
		query.append("AND     PORT_INLND_FLG   =   'Y'" ).append("\n"); 
		query.append("AND    ROWNUM =1 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}