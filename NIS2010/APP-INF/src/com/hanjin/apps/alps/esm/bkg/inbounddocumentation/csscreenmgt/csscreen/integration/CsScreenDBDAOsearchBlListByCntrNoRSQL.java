/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CsScreenDBDAOsearchBlListByCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.18
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2011.08.18 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM BONG GYOON
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchBlListByCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container No로 조회시 연계된 B/L이 LCL인 경우, 관련 B/L List를 조회하고 LCL이 아닌 경우 단건의 B/L 정보를 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchBlListByCntrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_to_ord_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchBlListByCntrNoRSQL").append("\n"); 
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
		query.append("SELECT BKGM.BKG_NO     AS BKG_NO   " ).append("\n"); 
		query.append("     , BKGM.SPLIT_FLG  AS SPLIT_FLG       " ).append("\n"); 
		query.append("     , BKGM.BL_NO      AS BL_NO   " ).append("\n"); 
		query.append("     , BKGM.BL_TP_CD   AS BL_TP_CD   " ).append("\n"); 
		query.append("     , BCST.CUST_NM    AS CSTMS_DESC   " ).append("\n"); 
		query.append("FROM (SELECT CNTR_NO" ).append("\n"); 
		query.append("           , MAX(CNMV_CYC_NO)  AS CNMV_CYC_NO" ).append("\n"); 
		query.append("        FROM BKG_CONTAINER WHERE CNTR_NO  LIKE NVL(@[cntr_no],' ')|| '%'" ).append("\n"); 
		query.append("       GROUP BY CNTR_NO" ).append("\n"); 
		query.append("     ) CNTR_LIST" ).append("\n"); 
		query.append("     ,BKG_CONTAINER  BCNTR " ).append("\n"); 
		query.append("     ,BKG_BOOKING    BKGM  " ).append("\n"); 
		query.append("     ,BKG_CUSTOMER   BCST" ).append("\n"); 
		query.append("WHERE BCNTR.CNTR_NO       = CNTR_LIST.CNTR_NO" ).append("\n"); 
		query.append("AND   BCNTR.CNMV_CYC_NO   = CNTR_LIST.CNMV_CYC_NO" ).append("\n"); 
		query.append("AND   BKGM.BKG_NO         = BCNTR.BKG_NO" ).append("\n"); 
		query.append("AND   BKGM.BKG_NO         = BCST.BKG_NO" ).append("\n"); 
		query.append("AND   BCST.BKG_CUST_TP_CD = DECODE(BKGM.CUST_TO_ORD_FLG, @[cust_to_ord_flg], 'N', 'C')" ).append("\n"); 
		query.append("AND   BKGM.BL_NO IS NOT NULL" ).append("\n"); 

	}
}