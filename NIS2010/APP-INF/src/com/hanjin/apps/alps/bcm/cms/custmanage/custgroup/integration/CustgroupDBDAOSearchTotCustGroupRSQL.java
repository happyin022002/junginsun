/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustgroupDBDAOSearchTotCustGroupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustgroupDBDAOSearchTotCustGroupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public CustgroupDBDAOSearchTotCustGroupRSQL(){
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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.integration").append("\n"); 
		query.append("FileName : CustgroupDBDAOSearchTotCustGroupRSQL").append("\n"); 
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
		query.append("FROM MDM_CUST_PERF_GRP A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${cust_grp_id} != '')" ).append("\n"); 
		query.append("AND A.CUST_GRP_ID like UPPER(@[cust_grp_id]) || '%'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${cust_grp_nm} != '')" ).append("\n"); 
		query.append("AND A.CUST_GRP_NM like '%' || UPPER(@[cust_grp_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD like '%' || UPPER(@[ofc_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '' && ${delt_flg} != 'ALL')" ).append("\n"); 
		query.append("and A.DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}