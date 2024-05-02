/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlSccRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.30
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012.03.30 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlSccRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop-off Charge조회
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlSccRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_trf_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchEasDrffChgTrfDtlSccRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_ASC(A XPKMDM_EQ_ORZ_CHT) */" ).append("\n"); 
		query.append("DISTINCT" ).append("\n"); 
		query.append("A.SCC_CD, L.PORT_INLND_CD," ).append("\n"); 
		query.append("'EUR|USD'||DECODE((SELECT MAX(M.CURR_CD) CURR_CD FROM MDM_COUNTRY M WHERE M.CNT_CD LIKE SUBSTR(@[cnt_cd],1,2)||'%' AND M.CURR_CD NOT IN ('EUR','USD')),NULL,'','','','|')||(" ).append("\n"); 
		query.append("SELECT MAX(M.CURR_CD) CURR_CD FROM MDM_COUNTRY M WHERE M.CNT_CD LIKE SUBSTR(@[cnt_cd],1,2)||'%' AND M.CURR_CD NOT IN ('EUR','USD')) CURR_LIST_CTNT" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT A, MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.SCC_CD = L.LOC_CD(+)" ).append("\n"); 
		query.append("AND A.SCC_CD LIKE @[cnt_cd]||'%'" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM MDM_YARD Y" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND Y.YD_CD LIKE SUBSTR(A.SCC_CD,1,2)||'%'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND NOT EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM EAS_DRFF_CHG_TRF_HDR H, EAS_DRFF_CHG_TRF_DTL D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_SEQ = D.DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_VER_NO = D.DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_SEQ = @[drff_chg_trf_seq]" ).append("\n"); 
		query.append("AND H.DRFF_CHG_TRF_VER_NO = @[drff_chg_trf_ver_no]" ).append("\n"); 
		query.append("AND H.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}