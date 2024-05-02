/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KeyManInfoManageDBDAOsearchKeyManDetailInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KeyManInfoManageDBDAOsearchKeyManDetailInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KeyManInfoDBDAOsearchKeyManDetailInfo
	  * </pre>
	  */
	public KeyManInfoManageDBDAOsearchKeyManDetailInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_kman_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.integration").append("\n"); 
		query.append("FileName : KeyManInfoManageDBDAOsearchKeyManDetailInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("A.KMAN_N1ST_NM, A.KMAN_LST_NM, A.KMAN_GND_CD, A.JB_TIT_RMK, A.KMAN_DEPT_DESC, A.KMAN_BRDY_DT, A.KMAN_HBY_DESC, A.KMAN_SPS_NM, A.KMAN_OFC_ADDR, " ).append("\n"); 
		query.append("A.KMAN_HM_ADDR, A.BIZ_ISS_DESC, A.KMAN_RMK_DESC," ).append("\n"); 
		query.append("A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,0) CUST_CD, B.CUST_LGL_ENG_NM," ).append("\n"); 
		query.append("B.SREP_CD, " ).append("\n"); 
		query.append("A.KMAN_EML, A.CHG_DESC," ).append("\n"); 
		query.append("A.KMAN_SGNF_IND_CD, A.KMAN_NKNM_NM," ).append("\n"); 
		query.append("A.KMAN_EDU_CATE_CD, A.KMAN_MJR_DESC, A.KMAN_MARR_FLG, A.KMAN_SPS_BRDY_DT, A.KMAN_SPS_BRDY_DT, " ).append("\n"); 
		query.append("A.KMAN_WEDD_ANV_DT, A.KMAN_OFC_ADDR, A.KMAN_OFC_FAX_NO, A.INTL_PHN_NO" ).append("\n"); 
		query.append("FROM SAM_CUST_KMAN_INFO A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("AND   A.CUST_SEQ = B.CUST_SEQ" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD || LPAD(A.CUST_SEQ,6,0) = @[cust_cd]" ).append("\n"); 
		query.append("AND A.CUST_KMAN_SEQ = @[cust_kman_seq]" ).append("\n"); 

	}
}