/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdMstCnstExceptionUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdatePrdMstCnstExceptionUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PrdCreateManageDBDAOUpdatePrdMstCnstExceptionUSQL
	  * --1. POL : ASIA,  POD : US%/CA%, DEL : CA%, Type/Size : D7인 모든 BKG 을 Block
	  * --2. Only CAVAN port/local 허용, 타 CA port 의 경우는(CAVAN등) Port/Local Block (Hard coding 이 필요한 부분)
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdMstCnstExceptionUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdMstCnstExceptionUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("SET CNST_FLG = 'X'" ).append("\n"); 
		query.append("WHERE M.PCTL_NO LIKE DECODE(@[hd_pctl_no], NULL, NULL, @[hd_pctl_no]||'%') --R12081003113716" ).append("\n"); 
		query.append("AND EXISTS (" ).append("\n"); 
		query.append("    SELECT 'X' FROM PRD_PROD_CTL_MST MST , PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("    WHERE MST.PCTL_NO = M.PCTL_NO " ).append("\n"); 
		query.append("    AND MST.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("    AND 'A' = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = MST.POL_CD )" ).append("\n"); 
		query.append("    AND (MST.POD_CD LIKE 'US%' OR MST.POD_CD LIKE 'CA%' )" ).append("\n"); 
		query.append("    AND MST.DEL_CD LIKE 'CA%'" ).append("\n"); 
		query.append("    AND Q.CNTR_TPSZ_CD ='D7'" ).append("\n"); 
		query.append("    AND (MST.POD_CD NOT IN ('CAVAN') OR  MST.DEL_CD NOT IN ('CAVAN'))" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}