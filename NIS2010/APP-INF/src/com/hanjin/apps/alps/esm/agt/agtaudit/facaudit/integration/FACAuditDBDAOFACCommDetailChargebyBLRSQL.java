/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FACAuditDBDAOFACCommDetailChargebyBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACAuditDBDAOFACCommDetailChargebyBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * (ESM_AGT_015) Charge Detail 목록 조회
	  * </pre>
	  */
	public FACAuditDBDAOFACCommDetailChargebyBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.facaudit.integration").append("\n"); 
		query.append("FileName : FACAuditDBDAOFACCommDetailChargebyBLRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("C.CHG_CD AS CHG_CD," ).append("\n"); 
		query.append("C.BKG_CHG_AMT AS BKG_CHG_AMT" ).append("\n"); 
		query.append("FROM AGT_COMM_BKG_INFO A," ).append("\n"); 
		query.append("AGT_FAC_COMM B," ).append("\n"); 
		query.append("AGT_FAC_CHG_DTL C" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.FAC_SEQ =" ).append("\n"); 
		query.append("(SELECT /*+INDEX_DESC(X XPKAGT_FAC_COMM) */" ).append("\n"); 
		query.append("X.FAC_SEQ" ).append("\n"); 
		query.append("FROM AGT_FAC_COMM X" ).append("\n"); 
		query.append("WHERE X.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND ROWNUM < 2)" ).append("\n"); 
		query.append("AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND B.FAC_SEQ = C.FAC_SEQ" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("AND A.BL_NO = NVL (@[bl_no], A.BL_NO)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}