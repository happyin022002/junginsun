/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GuaranteeCommonDBDAOSearchCntrBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.guaranteecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GuaranteeCommonDBDAOSearchCntrBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container No.로 BKG No. 조회
	  * </pre>
	  */
	public GuaranteeCommonDBDAOSearchCntrBkgNoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.guaranteecommon.integration").append("\n"); 
		query.append("FileName : GuaranteeCommonDBDAOSearchCntrBkgNoRSQL").append("\n"); 
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
		query.append("SELECT  (SELECT" ).append("\n"); 
		query.append("LTRIM(MAX(SYS_CONNECT_BY_PATH(BKG_NO,'|')),'|')" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  ROWNUM ROW_ID, Z.BKG_NO" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("#if (${cre_flg} == 'I')" ).append("\n"); 
		query.append("SELECT  'N/A' BKG_NO FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT BB.BKG_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  DISTINCT B.BKG_NO" ).append("\n"); 
		query.append("FROM	BKG_BOOKING B, BKG_CONTAINER C, CTM_MOVEMENT D" ).append("\n"); 
		query.append("WHERE	B.BKG_NO   = C.BKG_NO" ).append("\n"); 
		query.append("AND     C.CNTR_NO  = D.CNTR_NO" ).append("\n"); 
		query.append("AND     C.CNTR_NO  = NVL(@[cntr_no],'')" ).append("\n"); 
		query.append("AND     D.OB_CNTR_FLG  = 'N'" ).append("\n"); 
		query.append("AND     B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("AND     SUBSTR(D.ORG_YD_CD,1,2) IN ('US','CA')" ).append("\n"); 
		query.append("AND     (SUBSTR(B.POR_NOD_CD,1,2) IN ('US','CA') OR SUBSTR(B.DEL_NOD_CD,1,2) IN ('US','CA'))" ).append("\n"); 
		query.append("AND     D.CNMV_EVNT_DT BETWEEN TO_DATE(TO_CHAR(SYSDATE - 365, 'YYYYMMDD'), 'YYYY-MM-DD')  AND  TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'),'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND     B.CRE_DT BETWEEN TO_DATE(TO_CHAR(SYSDATE - 545, 'YYYYMMDD'), 'YYYY-MM-DD')  AND  TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'),'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT B.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, BKG_CONTAINER C" ).append("\n"); 
		query.append("WHERE	B.BKG_NO   = C.BKG_NO" ).append("\n"); 
		query.append("AND     C.CNTR_NO  = NVL(@[cntr_no],'')" ).append("\n"); 
		query.append("AND     B.BKG_STS_CD IN ('F','W')" ).append("\n"); 
		query.append("AND     SUBSTR(B.POD_CD,1,2) IN ('US','CA')" ).append("\n"); 
		query.append("AND     C.CNMV_STS_CD = 'VL') BB" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("CONNECT BY PRIOR ROW_ID = ROW_ID - 1" ).append("\n"); 
		query.append("START WITH ROW_ID = 1" ).append("\n"); 
		query.append(") BKG_NO_LIST" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}