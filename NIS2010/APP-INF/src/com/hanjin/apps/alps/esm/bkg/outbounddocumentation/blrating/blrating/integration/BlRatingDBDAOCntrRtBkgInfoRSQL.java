/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOCntrRtBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOCntrRtBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BlRatingDBDAOCntrRtBkgInfoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOCntrRtBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",      A.BL_NO || A.BL_TP_CD BL_NO" ).append("\n"); 
		query.append(",      A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append(",      A.POR_CD" ).append("\n"); 
		query.append(",      A.POL_CD" ).append("\n"); 
		query.append(",      A.POD_CD" ).append("\n"); 
		query.append(",      A.DEL_CD" ).append("\n"); 
		query.append(",      A.PRE_RLY_PORT_CD" ).append("\n"); 
		query.append(",      A.PST_RLY_PORT_CD" ).append("\n"); 
		query.append(",      A.SC_NO || A.RFA_NO CONTRACT_NO" ).append("\n"); 
		query.append(",      B.CSTMS_DESC" ).append("\n"); 
		query.append(",      B.MST_CVRD_BL_NO" ).append("\n"); 
		query.append(",      to_char(C.RT_APLY_DT, 'YYYY-MM-DD') RT_APLY_DT" ).append("\n"); 
		query.append(",      C.RT_BL_TP_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_CNT_CD||CUST_SEQ FROM BKG_CUSTOMER WHERE BKG_NO=A.BKG_NO AND BKG_CUST_TP_CD='S') SHPR_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_NM FROM BKG_CUSTOMER WHERE BKG_NO=A.BKG_NO AND BKG_CUST_TP_CD='S') SHPR_NM" ).append("\n"); 
		query.append(",      (SELECT CUST_CNT_CD||CUST_SEQ FROM BKG_CUSTOMER WHERE BKG_NO=A.BKG_NO AND BKG_CUST_TP_CD='C') CNEE_CD" ).append("\n"); 
		query.append(",      (SELECT CUST_NM FROM BKG_CUSTOMER WHERE BKG_NO=A.BKG_NO AND BKG_CUST_TP_CD='C') CNEE_NM" ).append("\n"); 
		query.append(",      A.CRE_USR_ID" ).append("\n"); 
		query.append(",      A.UPD_USR_ID" ).append("\n"); 
		query.append("FROM BKG_BOOKING A, BKG_BL_DOC B, BKG_RATE C" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO (+)" ).append("\n"); 
		query.append("AND   A.BKG_NO = C.BKG_NO (+)" ).append("\n"); 
		query.append("AND   A.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}