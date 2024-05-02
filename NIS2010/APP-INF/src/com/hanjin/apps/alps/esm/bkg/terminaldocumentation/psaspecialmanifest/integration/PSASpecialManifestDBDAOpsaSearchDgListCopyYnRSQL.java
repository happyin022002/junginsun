/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOpsaSearchDgListCopyYnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.19
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.09.19 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOpsaSearchDgListCopyYnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 위험물 조회조건 Declaration Type, VVD, PORT을 기준으로 먼저 세관쪽 DG테이블에 등록되어 있는지를 판단한다.
	  * </pre>
	  */
	public PSASpecialManifestDBDAOpsaSearchDgListCopyYnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOpsaSearchDgListCopyYnRSQL").append("\n"); 
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
		query.append("SELECT CASE" ).append("\n"); 
		query.append("          WHEN (NVL (EUR_DG_DECL_TP_CD, 'EMPTY') = 'EMPTY')" ).append("\n"); 
		query.append("             THEN (SELECT DECODE (NVL (EUR_DG_DECL_TP_CD, 'EMPTY')," ).append("\n"); 
		query.append("                                  'EMPTY', 'N'," ).append("\n"); 
		query.append("                                  'Y'" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("                     FROM BKG_CSTMS_EUR_DG RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("                          ON EUR_DG_DECL_TP_CD =" ).append("\n"); 
		query.append("                               DECODE (@[d_type]," ).append("\n"); 
		query.append("                                       'D', 'DO'," ).append("\n"); 
		query.append("                                       'DO', 'D'," ).append("\n"); 
		query.append("                                       'L', 'PL'," ).append("\n"); 
		query.append("                                       'PL', 'L'" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                        AND VSL_CD = SUBSTR (@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                        AND SKD_VOY_NO = SUBSTR (@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                        AND SKD_DIR_CD = SUBSTR (@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                        AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                    WHERE ROWNUM = 1)" ).append("\n"); 
		query.append("          ELSE 'N'" ).append("\n"); 
		query.append("       END RET" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_EUR_DG RIGHT OUTER JOIN DUAL" ).append("\n"); 
		query.append("       ON EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("     AND VSL_CD = SUBSTR (@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("     AND SKD_VOY_NO = SUBSTR (@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("     AND SKD_DIR_CD = SUBSTR (@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("     AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append(" WHERE ROWNUM = 1" ).append("\n"); 

	}
}