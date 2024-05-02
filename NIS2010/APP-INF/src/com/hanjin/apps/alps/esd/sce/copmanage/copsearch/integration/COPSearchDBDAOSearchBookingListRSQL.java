/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : COPSearchDBDAOSearchBookingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.19 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchBookingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search booking list
	  * </pre>
	  */
	public COPSearchDBDAOSearchBookingListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchBookingListRSQL").append("\n"); 
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
		query.append("SELECT cop_no " ).append("\n"); 
		query.append("     , bkg_no" ).append("\n"); 
		query.append("     , DECODE(COP_NO, MST_COP_NO, 'Y', '') AS mst_lcl_cd -- DECODE( mst_lcl_cd, 'p' , 'y', '') mst_lcl_cd , " ).append("\n"); 
		query.append("     , commcode_pkg.get_comdtl_name_fnc('CD00134', cop_sts_cd) AS cop_sts_cd " ).append("\n"); 
		query.append("     , cntr_tpsz_cd" ).append("\n"); 
		query.append("  , cre_dt" ).append("\n"); 
		query.append("  , cop_no || '@' || bkg_no || '@' || DECODE(COP_NO, MST_COP_NO, 'Y', '') || '@' ||commcode_pkg.get_comdtl_name_fnc('CD00134', cop_sts_cd)|| '@'||cntr_tpsz_cd || '@' ||cre_dt as code" ).append("\n"); 
		query.append("  FROM   sce_cop_hdr " ).append("\n"); 
		query.append(" WHERE 1 =1 " ).append("\n"); 
		query.append("#if (${cntr_no} != '')   " ).append("\n"); 
		query.append("   AND cntr_no  = DECODE (@[cntr_no], 'SMCU0000000', '', @[cntr_no])" ).append("\n"); 
		query.append("   AND cnmv_yr  IN (TO_CHAR(SYSDATE,'YYYY'),TO_CHAR(SYSDATE-365,'YYYY'))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND cntr_no = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY cop_no, bkg_no, cop_sts_cd, mst_cop_no, cntr_tpsz_cd,cre_dt" ).append("\n"); 
		query.append("#if (${cop_no} != '')" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT cop_no " ).append("\n"); 
		query.append("     , bkg_no" ).append("\n"); 
		query.append("     , DECODE(COP_NO, MST_COP_NO, 'Y', '') AS mst_lcl_cd -- DECODE( mst_lcl_cd, 'p' , 'y', '') mst_lcl_cd , " ).append("\n"); 
		query.append("     , commcode_pkg.get_comdtl_name_fnc('CD00134', cop_sts_cd) AS cop_sts_cd " ).append("\n"); 
		query.append("     , cntr_tpsz_cd" ).append("\n"); 
		query.append("  , cre_dt" ).append("\n"); 
		query.append("  , cop_no || '@' || bkg_no || '@' || DECODE(COP_NO, MST_COP_NO, 'Y', '') || '@' ||commcode_pkg.get_comdtl_name_fnc('CD00134', cop_sts_cd)|| '@'||cntr_tpsz_cd || '@' ||cre_dt as code" ).append("\n"); 
		query.append("  FROM   sce_cop_hdr" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND cntr_no  = DECODE(@[cntr_no], '', 'SMCU0000000', @[cntr_no])" ).append("\n"); 
		query.append("AND cop_no = @[cop_no]" ).append("\n"); 
		query.append("GROUP BY cop_no, bkg_no, cop_sts_cd, mst_cop_no, cntr_tpsz_cd,cre_dt" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY cre_dt DESC, bkg_no" ).append("\n"); 

	}
}