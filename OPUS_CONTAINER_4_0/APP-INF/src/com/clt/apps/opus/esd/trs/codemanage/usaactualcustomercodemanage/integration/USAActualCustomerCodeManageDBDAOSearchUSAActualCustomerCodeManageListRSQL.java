/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerCodeManageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.08
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2010.06.08 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerCodeManageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual Customer Code 조회
	  * </pre>
	  */
	public USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerCodeManageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("input_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dor_nod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usaactualcustomercodemanage.integration").append("\n"); 
		query.append("FileName : USAActualCustomerCodeManageDBDAOSearchUSAActualCustomerCodeManageListRSQL").append("\n"); 
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
		query.append("A.trsp_act_cust_no," ).append("\n"); 
		query.append("A.delt_flg," ).append("\n"); 
		query.append("A.act_cust_bnd_cd," ).append("\n"); 
		query.append("SUBSTR(A.dor_nod_cd, 1, 5) dr_loc_value," ).append("\n"); 
		query.append("SUBSTR(A.dor_nod_cd, 6, 2) dr_yard_value," ).append("\n"); 
		query.append("A.dor_nod_cd," ).append("\n"); 
		query.append("NVL(A.act_cust_cnt_cd||A.act_cust_seq,'') act_cust_cnt_cd," ).append("\n"); 
		query.append("NVL(A.act_cust_nm,'') act_cust_nm," ).append("\n"); 
		query.append("to_char(A.cre_dt,'YYYYMMDD') cre_dt" ).append("\n"); 
		query.append("FROM TRS_TRSP_USA_ACT_CUST A, TRS_TRSP_USA_ACT_CUST_DTL B" ).append("\n"); 
		query.append("WHERE A.TRSP_ACT_CUST_NO <> 0" ).append("\n"); 
		query.append("AND A.trsp_act_cust_no = B.trsp_act_cust_no(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${status} != 'A')" ).append("\n"); 
		query.append("AND   A.delt_flg = @[status]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bound} != 'A')" ).append("\n"); 
		query.append("AND   A.act_cust_bnd_cd = @[bound]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("##${dor_nod}" ).append("\n"); 
		query.append("#if ($dor_nod.length() == 7)" ).append("\n"); 
		query.append("AND   A.dor_nod_cd      = @[dor_nod]" ).append("\n"); 
		query.append("#elseif ($dor_nod.length() == 5)" ).append("\n"); 
		query.append("AND substr(A.dor_nod_cd,1,5)    = @[dor_nod]" ).append("\n"); 
		query.append("#elseif ($dor_nod.length() > 0)" ).append("\n"); 
		query.append("AND A.dor_nod_cd like '%' || @[dor_nod] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${input_cust_cd} != '')" ).append("\n"); 
		query.append("AND A.act_cust_cnt_cd = SUBSTR(@[input_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND A.act_cust_seq    = to_number(SUBSTR(@[input_cust_cd], 3, 6))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("##${input_cust_nm}" ).append("\n"); 
		query.append("#if ($input_cust_nm.length() > 0)" ).append("\n"); 
		query.append("AND UPPER(B.act_cust_nm)     like '%' || @[input_cust_nm] ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ($OfcCd.size() > 0)" ).append("\n"); 
		query.append("AND B.cre_ofc_cd in (" ).append("\n"); 
		query.append("#foreach( ${key} in ${OfcCd})" ).append("\n"); 
		query.append("#if($velocityCount < $OfcCd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.trsp_act_cust_no, A.delt_flg, A.act_cust_bnd_cd," ).append("\n"); 
		query.append("A.dor_nod_cd, A.act_cust_cnt_cd,A.act_cust_seq," ).append("\n"); 
		query.append("A.act_cust_nm, A.cre_dt" ).append("\n"); 
		query.append("ORDER BY A.act_cust_bnd_cd, A.dor_nod_cd, A.act_cust_cnt_cd" ).append("\n"); 

	}
}