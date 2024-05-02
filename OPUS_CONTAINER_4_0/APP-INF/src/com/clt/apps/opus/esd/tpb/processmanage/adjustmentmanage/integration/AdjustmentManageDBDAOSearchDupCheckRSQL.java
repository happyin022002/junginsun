/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AdjustmentManageDBDAOSearchDupCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentManageDBDAOSearchDupCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Adjustment Validation Check
	  * </pre>
	  */
	public AdjustmentManageDBDAOSearchDupCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.integration").append("\n"); 
		query.append("FileName : AdjustmentManageDBDAOSearchDupCheckRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(1),0,'N','Y') VALIDYN" ).append("\n"); 
		query.append("  FROM TPB_ADJ_STS" ).append("\n"); 
		query.append(" WHERE STL_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("   AND N3PTY_STL_TP_CD = 'O'" ).append("\n"); 
		query.append("   AND N3PTY_NO = @[n3pty_no]" ).append("\n"); 
		query.append("   AND STL_APRO_OFC_CD IS NULL" ).append("\n"); 
		query.append("   AND STL_RJCT_OFC_CD IS NULL" ).append("\n"); 
		query.append("   AND (STL_FWRD_OFC_CD IS NULL OR STL_FWRD_OFC_CD IN (" ).append("\n"); 
		query.append("                                                         SELECT DECODE(N3PTY_OFC_TP_CD,'R',OFC_CD,OFC_CD)" ).append("\n"); 
		query.append("                                                           FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("                                                          WHERE OFC_CD = @[s_user_ofc_cd]" ).append("\n"); 
		query.append("                                                            AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}