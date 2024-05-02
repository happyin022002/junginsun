/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchDoRlseStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchDoRlseStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchDoRlseStsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchDoRlseStsRSQL").append("\n"); 
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
		query.append("SELECT DTL.RLSE_STS_CD" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02152' AND INTG_CD_VAL_CTNT = DTL.RLSE_STS_CD) AS RLSE_STS_NM" ).append("\n"); 
		query.append("     , CASE WHEN SUBSTR(POD_CD,1,2) = 'JP' AND ( DTL.RLSE_STS_CD ='I' OR DTL.RLSE_STS_CD ='C' ) THEN BDO.DO_NO" ).append("\n"); 
		query.append("            WHEN SUBSTR(POD_CD,1,2) = 'JP' AND DTL.RLSE_STS_CD ='D' THEN NVL(BDO.JP_DO_ID,BDO.DO_NO)" ).append("\n"); 
		query.append("            ELSE BDO.DO_NO||BDO.DO_NO_SPLIT END AS DO_NO" ).append("\n"); 
		query.append("     , BDO.DO_NO_SPLIT" ).append("\n"); 
		query.append("     , TO_CHAR(DTL.EVNT_DT, 'YYYY-MM-DD HH24:MI:SS') AS EVNT_DT" ).append("\n"); 
		query.append("     , DTL.EVNT_USR_ID" ).append("\n"); 
		query.append("     , (SELECT USR_NM FROM COM_USER WHERE USR_ID = DTL.EVNT_USR_ID) AS UPD_USR_NM" ).append("\n"); 
		query.append("     , DTL.EVNT_OFC_CD" ).append("\n"); 
		query.append("     , DTL.BKG_NO     " ).append("\n"); 
		query.append("     , DTL.RLSE_SEQ" ).append("\n"); 
		query.append("     , DTL.RLSE_STS_SEQ" ).append("\n"); 
		query.append("     , BDO.SELF_TRNS_FLG" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("     , BKG_DO BDO" ).append("\n"); 
		query.append("     , BKG_DO_DTL DTL" ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("  AND BDO.BKG_NO    = BKGM.BKG_NO" ).append("\n"); 
		query.append("  AND DTL.BKG_NO    = BDO.BKG_NO    " ).append("\n"); 
		query.append("  AND DTL.RLSE_SEQ  = BDO.RLSE_SEQ   " ).append("\n"); 
		query.append("ORDER BY DTL.RLSE_STS_SEQ" ).append("\n"); 

	}
}