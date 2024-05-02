/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustgroupDBDAOSearchCustGroupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustgroupDBDAOSearchCustGroupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public CustgroupDBDAOSearchCustGroupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("startpart",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("endpart",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custgroup.integration").append("\n"); 
		query.append("FileName : CustgroupDBDAOSearchCustGroupRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("    ROWNUM NO, " ).append("\n"); 
		query.append("    CUST_GRP_ID" ).append("\n"); 
		query.append("   ,CUST_GRP_NM" ).append("\n"); 
		query.append("   ,OFC_CD" ).append("\n"); 
		query.append("   ,SREP_CD" ).append("\n"); 
		query.append("   ,(SELECT INTG_CD_VAL_DP_DESC B FROM COM_INTG_CD_DTL B WHERE B.INTG_CD_ID = 'CD00698' AND CUST_GRP.VBS_CLSS_CD = B.INTG_CD_VAL_CTNT AND ROWNUM = 1) VBS_CLSS_CD" ).append("\n"); 
		query.append("   ,(SELECT INTG_CD_VAL_DP_DESC B FROM COM_INTG_CD_DTL B WHERE B.INTG_CD_ID = 'CD00694' AND CUST_GRP.NBS_CLSS_CD1 = B.INTG_CD_VAL_CTNT AND ROWNUM = 1) NBS_CLSS_CD1" ).append("\n"); 
		query.append("   ,(SELECT INTG_CD_VAL_DP_DESC B FROM COM_INTG_CD_DTL B WHERE B.INTG_CD_ID = 'CD00695' AND CUST_GRP.NBS_CLSS_CD2 = B.INTG_CD_VAL_CTNT AND ROWNUM = 1) NBS_CLSS_CD2" ).append("\n"); 
		query.append("   ,(SELECT INTG_CD_VAL_DP_DESC B FROM COM_INTG_CD_DTL B WHERE B.INTG_CD_ID = 'CD00696' AND CUST_GRP.NBS_CLSS_CD3 = B.INTG_CD_VAL_CTNT AND ROWNUM = 1) NBS_CLSS_CD3" ).append("\n"); 
		query.append("   ,DECODE( DELT_FLG, 'N', 'Active', 'Y', 'Delete', '' ) DELT_FLG" ).append("\n"); 
		query.append("FROM MDM_CUST_PERF_GRP CUST_GRP" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${cust_grp_id} != '')" ).append("\n"); 
		query.append("AND CUST_GRP_ID like UPPER(@[cust_grp_id])||'%'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${cust_grp_nm} != '')" ).append("\n"); 
		query.append("AND CUST_GRP_NM like '%'||UPPER(@[cust_grp_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '' && ${delt_flg} != 'ALL')" ).append("\n"); 
		query.append("and DELT_FLG  = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND OFC_CD like '%' || UPPER(@[ofc_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CUST_GRP_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NO BETWEEN @[startpart] AND @[endpart]" ).append("\n"); 

	}
}