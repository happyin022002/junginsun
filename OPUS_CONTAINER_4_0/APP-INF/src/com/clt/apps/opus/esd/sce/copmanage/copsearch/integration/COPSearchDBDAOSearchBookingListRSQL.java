/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : COPSearchDBDAOSearchBookingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.09
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2017.01.09 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
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
		query.append("Path : com.clt.apps.opus.esd.sce.copmanage.copsearch.integration").append("\n"); 
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
		query.append("  FROM   sce_cop_hdr " ).append("\n"); 
		query.append(" WHERE 1 =1 " ).append("\n"); 
		query.append("#if (${cntr_no} != '')   " ).append("\n"); 
		query.append("   AND cntr_no  = @[cntr_no]" ).append("\n"); 
		query.append("   AND cnmv_yr  BETWEEN TO_CHAR(SYSDATE - (INTERVAL '1' YEAR),'YYYY') AND TO_CHAR(SYSDATE,'YYYY')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cop_no} != '')   " ).append("\n"); 
		query.append("   AND cop_no  = @[cop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} == '' && ${cop_no} == '')   " ).append("\n"); 
		query.append("   AND cntr_no = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY cop_no, bkg_no, cop_sts_cd, mst_cop_no, cntr_tpsz_cd" ).append("\n"); 
		query.append("ORDER BY bkg_no" ).append("\n"); 

	}
}