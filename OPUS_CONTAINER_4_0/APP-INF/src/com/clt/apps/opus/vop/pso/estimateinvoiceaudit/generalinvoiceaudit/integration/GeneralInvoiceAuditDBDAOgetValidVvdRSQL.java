/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetValidVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetValidVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 유효한 VVD 조회
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetValidVvdRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetValidVvdRSQL").append("\n"); 
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
		query.append("WITH V_PARAM AS (" ).append("\n"); 
		query.append("    SELECT @[vvd] AS VVD" ).append("\n"); 
		query.append("         , @[yd_cd] AS YD_CD   " ).append("\n"); 
		query.append("         , @[clpt_ind_seq] AS CLPT_IND_SEQ      " ).append("\n"); 
		query.append("      FROM DUAL" ).append("\n"); 
		query.append(")  " ).append("\n"); 
		query.append("SELECT VP.VSL_CD" ).append("\n"); 
		query.append("       || DECODE(VP.TURN_PORT_IND_CD, 'Y', VP.SKD_VOY_NO     , 'N', VP.SKD_VOY_NO   , VP.TURN_SKD_VOY_NO)" ).append("\n"); 
		query.append("       || DECODE(VP.TURN_PORT_IND_CD, 'Y', VP.SKD_DIR_CD     , 'N', VP.SKD_DIR_CD   , VP.TURN_SKD_DIR_CD)" ).append("\n"); 
		query.append("       ||'|'|| VP.YD_CD" ).append("\n"); 
		query.append("       ||'|'|| DECODE(VP.TURN_PORT_IND_CD, 'Y', VP.CLPT_IND_SEQ   , 'N', VP.CLPT_IND_SEQ , VP.TURN_CLPT_IND_SEQ)" ).append("\n"); 
		query.append("       ||'|'|| VP.VPS_PORT_CD AS VALID_VVD" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD VP" ).append("\n"); 
		query.append("     , V_PARAM P " ).append("\n"); 
		query.append(" WHERE VP.VSL_CD       = SUBSTR(P.VVD, 1, 4)" ).append("\n"); 
		query.append("   AND VP.SKD_VOY_NO   = SUBSTR(P.VVD, 5, 4)" ).append("\n"); 
		query.append("   AND VP.SKD_DIR_CD   = SUBSTR(P.VVD, 9)" ).append("\n"); 
		query.append("   AND VP.VPS_PORT_CD  = SUBSTR(P.YD_CD, 1, 5)" ).append("\n"); 
		query.append("   AND VP.YD_CD        = P.YD_CD" ).append("\n"); 
		query.append("   AND VP.CLPT_IND_SEQ = P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND NVL(VP.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("   AND NVL(VP.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 

	}
}