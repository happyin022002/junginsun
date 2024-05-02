/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOsearchEasDrffChgTrfHdrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOsearchEasDrffChgTrfHdrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop-off Charge조회
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOsearchEasDrffChgTrfHdrRSQL(){
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
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOsearchEasDrffChgTrfHdrRSQL").append("\n"); 
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
		query.append("SELECT ROW_NUMBER() OVER (ORDER BY X.DRFF_CHG_TRF_VER_NO ) SEQ ," ).append("\n"); 
		query.append("X.DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append(",X.DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append(",X.FM_EFF_DT" ).append("\n"); 
		query.append(",X.TO_EFF_DT" ).append("\n"); 
		query.append(",X.CRE_OFC_CD" ).append("\n"); 
		query.append(",X.CRE_USR_ID" ).append("\n"); 
		query.append(",X.CNT_CD" ).append("\n"); 
		query.append(",X.RFA_NO" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT H.DRFF_CHG_TRF_SEQ" ).append("\n"); 
		query.append(",H.DRFF_CHG_TRF_VER_NO" ).append("\n"); 
		query.append(",H.FM_EFF_DT" ).append("\n"); 
		query.append(",H.TO_EFF_DT" ).append("\n"); 
		query.append(",H.CRE_OFC_CD" ).append("\n"); 
		query.append(",H.CRE_USR_ID" ).append("\n"); 
		query.append(",H.CNT_CD" ).append("\n"); 
		query.append(",H.RFA_NO" ).append("\n"); 
		query.append("FROM EAS_DRFF_CHG_TRF_HDR H" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND FM_EFF_DT IS NOT NULL" ).append("\n"); 
		query.append("AND NVL(H.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("AND H.CNT_CD = @[cnt_cd] --cnt/rfa둘중하나만" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND H.RFA_NO = @[rfa_no] --cnt/rfa둘중하나만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY H.DRFF_CHG_TRF_SEQ DESC, H.DRFF_CHG_TRF_VER_NO  DESC" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("ORDER BY SEQ DESC" ).append("\n"); 

	}
}