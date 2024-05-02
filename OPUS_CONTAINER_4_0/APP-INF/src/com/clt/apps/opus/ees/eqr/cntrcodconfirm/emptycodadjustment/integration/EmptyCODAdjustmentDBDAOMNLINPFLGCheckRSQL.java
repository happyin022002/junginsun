/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmptyCODAdjustmentDBDAOMNLINPFLGCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.31
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2014.03.31 신용찬
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YongChanShin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyCODAdjustmentDBDAOMNLINPFLGCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MNL_INP_FLG_Check
	  * </pre>
	  */
	public EmptyCODAdjustmentDBDAOMNLINPFLGCheckRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.integration").append("\n"); 
		query.append("FileName : EmptyCODAdjustmentDBDAOMNLINPFLGCheckRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(MAX(S.CONTI_CD),'A','Y','N')" ).append("\n"); 
		query.append("		FROM    VSK_VSL_PORT_SKD    K," ).append("\n"); 
		query.append("				MDM_COUNTRY         C, " ).append("\n"); 
		query.append("				MDM_SUBCONTINENT    S" ).append("\n"); 
		query.append("		WHERE   K.VSL_CD        =   SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("		AND     K.SKD_VOY_NO    =   SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("		AND     K.SKD_DIR_CD    =   SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("		AND     K.CLPT_SEQ      =   1" ).append("\n"); 
		query.append("		AND     SUBSTR(K.VPS_PORT_CD, 1, 2) = C.CNT_CD" ).append("\n"); 
		query.append("		AND     C.SCONTI_CD                 = S.SCONTI_CD " ).append("\n"); 
		query.append("		AND     NOT EXISTS  (         /* SKIP INTRA BKG  */" ).append("\n"); 
		query.append("                        	SELECT  *" ).append("\n"); 
		query.append("                        	FROM    EQR_MTY_COD_VVD V" ).append("\n"); 
		query.append("                        	WHERE   V.VSL_CD            =   K.VSL_CD" ).append("\n"); 
		query.append("                        	AND     V.SKD_VOY_NO        =   K.SKD_VOY_NO   " ).append("\n"); 
		query.append("                        	AND     V.SKD_DIR_CD        =   K.SKD_DIR_CD" ).append("\n"); 
		query.append("                        	AND     V.COD_CFM_DIV_CD    =   'B'" ).append("\n"); 
		query.append("                    		)" ).append("\n"); 

	}
}