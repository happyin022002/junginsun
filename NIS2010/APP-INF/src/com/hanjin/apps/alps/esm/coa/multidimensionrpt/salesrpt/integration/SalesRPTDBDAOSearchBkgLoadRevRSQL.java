/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SalesRPTDBDAOSearchBkgLoadRevRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 김기식
*@LastVersion : 1.0
* 2009.10.21 김기식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki-Sik
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchBkgLoadRevRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inquiry by BKG (ABC/STP)
	  * </pre>
	  */
	public SalesRPTDBDAOSearchBkgLoadRevRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchBkgLoadRevRSQL").append("\n"); 
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
		query.append("SELECT DECODE(CPY_NO ,1, 'LOAD(BOX)', 2, 'G.REV') AS T1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($key IN ${allcols})" ).append("\n"); 
		query.append(",SUM(DECODE(cntr_tpsz_cd, '$key',  DECODE(cpy_no, 1, load, 2, g_rev), 0)) AS B$velocityCount" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT CNTR_TPSZ_CD, SUM(LOAD) LOAD, SUM(G_REV) G_REV" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("(SELECT DISTINCT SPCL_CNTR_TPSZ_CD TPSZ_CODE" ).append("\n"); 
		query.append("FROM COA_SPCL_REPO_CNTR_RGST" ).append("\n"); 
		query.append("WHERE NVL(DELT_FLG,'N')   = 'N'" ).append("\n"); 
		query.append("AND LIST_BX_SET_LVL_CD  = '0001'" ).append("\n"); 
		query.append("AND SPCL_CNTR_TPSZ_CD NOT LIKE 'Q%'" ).append("\n"); 
		query.append("AND SPCL_CNTR_TPSZ_CD = A2.SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(") CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",SUM(A2.BKG_QTY) LOAD" ).append("\n"); 
		query.append(",SUM(NVL(A2.BKG_REV, 0) + NVL(A2.BKG_OFT_REV, 0)) G_REV" ).append("\n"); 
		query.append("FROM COA_RGST_BKG A1" ).append("\n"); 
		query.append(",COA_BKG_REV_DTL A2" ).append("\n"); 
		query.append("WHERE A1.BKG_NO        = @[f_bkg_no]" ).append("\n"); 
		query.append("AND A1.BL_NO_TP      IN ('M','0')" ).append("\n"); 
		query.append("AND A1.BKG_STS_CD    IN ('F','S','W')" ).append("\n"); 
		query.append("AND A1.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("AND A1.BKG_NO        = A2.BKG_NO(+)" ).append("\n"); 
		query.append("GROUP BY A2.SPCL_CNTR_TPSZ_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append(") X," ).append("\n"); 
		query.append("(SELECT CPY_NO FROM COM_CPY_NO WHERE CPY_NO BETWEEN 1 AND 2) Y" ).append("\n"); 
		query.append("GROUP BY CPY_NO" ).append("\n"); 
		query.append("ORDER BY CPY_NO" ).append("\n"); 

	}
}