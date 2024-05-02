/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOTotalCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOTotalCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer list total count
	  * </pre>
	  */
	public CustMainDBDAOTotalCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_locl_lang_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOTotalCustomerRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("  	FROM MDM_CUSTOMER A " ).append("\n"); 
		query.append("#if(${zip_cd} != '')" ).append("\n"); 
		query.append("        ,MDM_CUST_ADDR B " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 	WHERE 1=1" ).append("\n"); 
		query.append("#if(${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("      AND A.CUST_CNT_CD =  @[cust_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_seq} != '')" ).append("\n"); 
		query.append("      AND A.CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_lgl_eng_nm} != '')" ).append("\n"); 
		query.append("	#if(${include} == 'on')" ).append("\n"); 
		query.append("	  AND upper(A.CUST_LGL_ENG_NM) LIKE '%' || upper(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	  AND upper(A.CUST_LGL_ENG_NM) LIKE upper(@[cust_lgl_eng_nm]) || '%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ofc_cd} != '')" ).append("\n"); 
		query.append("      AND A.OFC_CD LIKE @[ofc_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${zip_cd} != '')" ).append("\n"); 
		query.append("      AND A.CUST_CNT_CD = B.CUST_CNT_CD(+) " ).append("\n"); 
		query.append("      AND A.CUST_SEQ = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("      AND B.PRMRY_CHK_FLG(+) = 'Y' " ).append("\n"); 
		query.append("      AND B.ZIP_CD LIKE @[zip_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${cust_grp_id} != '')" ).append("\n"); 
		query.append("      AND A.CUST_GRP_ID = @[cust_grp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${loc_cd} != '')" ).append("\n"); 
		query.append("      AND A.LOC_CD like @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ste_cd} != '')" ).append("\n"); 
		query.append("      AND EXISTS (SELECT 'X' FROM MDM_LOCATION ML WHERE ML.LOC_CD = A.LOC_CD AND ML.STE_CD = @[ste_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${srep_cd} != '')" ).append("\n"); 
		query.append("      AND A.SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '' && ${delt_flg} != 'ALL')" ).append("\n"); 
		query.append("      AND A.DELT_FLG  = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_locl_lang_nm} != '' && ${cust_locl_lang_nm} != 'ALL')" ).append("\n"); 
		query.append("      AND upper(A.CUST_LOCL_LANG_NM LIKE @[cust_locl_lang_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_rgst_no} != '' && ${cust_rgst_no} != 'ALL')" ).append("\n"); 
		query.append("      AND upper(A.CUST_RGST_NO LIKE @[cust_rgst_no])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD <> 'TB'" ).append("\n"); 

	}
}