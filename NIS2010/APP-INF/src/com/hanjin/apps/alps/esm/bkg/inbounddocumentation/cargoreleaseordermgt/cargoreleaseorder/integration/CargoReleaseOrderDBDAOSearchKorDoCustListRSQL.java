/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchKorDoCustListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.07.09 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim JinYoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchKorDoCustListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Cargo Release시 한국 지역에 한하여 위임자 및 수임자 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchKorDoCustListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atty_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atty_biz_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchKorDoCustListRSQL").append("\n"); 
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
		query.append("SELECT ATTY_BIZ_NO" ).append("\n"); 
		query.append(", ATTY_CUST_NM" ).append("\n"); 
		query.append(", CNTC_NO1" ).append("\n"); 
		query.append(", CNTC_NO2" ).append("\n"); 
		query.append(", DIFF_RMK" ).append("\n"); 
		query.append(", RGST_OFC_CD" ).append("\n"); 
		query.append(", RGST_DT" ).append("\n"); 
		query.append(", RGST_USR_ID" ).append("\n"); 
		query.append(", UPD_OFC_CD" ).append("\n"); 
		query.append(", TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", (SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) AS UPD_USR_NM" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", (SELECT COUNT(*) FROM BKG_DO_ATTY_DTL WHERE (FM_ATTY_BIZ_NO = A.ATTY_BIZ_NO OR TO_ATTY_BIZ_NO = A.ATTY_BIZ_NO)) AS CHILD_RECORD" ).append("\n"); 
		query.append("FROM BKG_DO_ATTY A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${atty_biz_no} != '')" ).append("\n"); 
		query.append("AND ATTY_BIZ_NO = @[atty_biz_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${atty_cust_nm} != '')" ).append("\n"); 
		query.append("AND LOWER(ATTY_CUST_NM) LIKE LOWER(TRIM(@[atty_cust_nm]))||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY UPD_DT DESC" ).append("\n"); 

	}
}