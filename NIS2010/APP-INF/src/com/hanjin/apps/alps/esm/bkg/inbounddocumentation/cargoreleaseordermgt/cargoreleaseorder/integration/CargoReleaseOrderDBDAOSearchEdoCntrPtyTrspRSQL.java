/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoCntrPtyTrspRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdoCntrPtyTrspRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI_BKG_0133에서 사용하는 SQL문이다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoCntrPtyTrspRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqstNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoCntrPtyTrspRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM ( SELECT " ).append("\n"); 
		query.append("              NVL(EC.EDO_RQST_NO,@[rqstNo])  AS EDO_RQST_NO" ).append("\n"); 
		query.append("            , BC.CNTR_NO                     AS CNTR_NO" ).append("\n"); 
		query.append("            , EDO_CNTR_PTY_TRSP_SEQ" ).append("\n"); 
		query.append("            , RANK() OVER ( PARTITION BY BC.CNTR_NO ORDER BY EDO_CNTR_PTY_TRSP_SEQ DESC) SEQ    " ).append("\n"); 
		query.append("            , EC.EDO_ACK_CD                  AS EDO_ACK_CD " ).append("\n"); 
		query.append("			, PTY_BIZ_NO                     AS PTY_BIZ_NO" ).append("\n"); 
		query.append("            , PTY_NM                         AS PTY_NM" ).append("\n"); 
		query.append("            , PTY_CNTC_PSON_NM               AS PTY_CNTC_PSON_NM" ).append("\n"); 
		query.append("            , PTY_PHN_NO                     AS PTY_PHN_NO" ).append("\n"); 
		query.append("            , PTY_FAX_NO                     AS PTY_FAX_NO " ).append("\n"); 
		query.append("            , PTY_EML                        AS PTY_EML " ).append("\n"); 
		query.append("            , ACT_SHPR_NM                    AS ACT_SHPR_NM " ).append("\n"); 
		query.append("            , ACT_SHPR_PHN_NO                AS ACT_SHPR_PHN_NO" ).append("\n"); 
		query.append("            , DEP_AREA_NM                    AS DEP_AREA_NM" ).append("\n"); 
		query.append("            , ARR_AREA_NM                    AS ARR_AREA_NM " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           FROM   BKG_CONTAINER BC, BKG_EDO_CNTR_PTY_TRSP EC" ).append("\n"); 
		query.append("         WHERE EC.CNTR_NO(+)     = BC.CNTR_NO" ).append("\n"); 
		query.append("           AND EC.EDO_RQST_NO(+) = @[rqstNo]" ).append("\n"); 
		query.append("           AND BC.BKG_NO         = (SELECT BKG_NO" ).append("\n"); 
		query.append("                                      FROM BKG_EDO_MST EDOMST" ).append("\n"); 
		query.append("                                     WHERE EDOMST.EDO_RQST_NO = @[rqstNo]" ).append("\n"); 
		query.append("                                       AND ROWNUM =1" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("WHERE SEQ = 1 /* 가장 최근 수신된 것 가져옴*/" ).append("\n"); 

	}
}