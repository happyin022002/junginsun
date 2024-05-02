/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : StatusManageDBDAOUpdateCfmQtaAqCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.statusmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusManageDBDAOUpdateCfmQtaAqCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Freezing 후 CSQ_CFM_QTA 테이블의 AQ_CD를 업데이트한다.
	  * </pre>
	  */
	public StatusManageDBDAOUpdateCfmQtaAqCdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.statusmanage.integration").append("\n"); 
		query.append("FileName : StatusManageDBDAOUpdateCfmQtaAqCdUSQL").append("\n"); 
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
		query.append("UPDATE CSQ_CFM_QTA A1" ).append("\n"); 
		query.append("SET A1.AQ_CD = NVL((SELECT V.N3RD_PRNT_OFC_CD" ).append("\n"); 
		query.append("                FROM CSQ_ORGANIZATION_V V" ).append("\n"); 
		query.append("                WHERE V.OFC_CD   = A1.RGN_OFC_CD" ).append("\n"); 
		query.append("                AND V.DELT_FLG = 'N'), '')" ).append("\n"); 
		query.append("WHERE A1.BSE_TP_CD     = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND A1.BSE_YR        = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND A1.BSE_QTR_CD    = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 

	}
}