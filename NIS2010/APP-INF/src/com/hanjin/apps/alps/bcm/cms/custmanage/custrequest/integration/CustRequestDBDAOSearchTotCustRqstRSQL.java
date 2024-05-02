/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustRequestDBDAOSearchTotCustRqstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.20
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustRequestDBDAOSearchTotCustRqstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer request search
	  * </pre>
	  */
	public CustRequestDBDAOSearchTotCustRqstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.integration").append("\n"); 
		query.append("FileName : CustRequestDBDAOSearchTotCustRqstRSQL").append("\n"); 
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
		query.append("FROM MDM_CUSTOMER_RQST A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${rqst_no} != '')" ).append("\n"); 
		query.append("AND A.MDM_CUSTOMER_RQST_SEQ like UPPER(@[rqst_no]) || '%'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("AND A.CUST_LGL_ENG_NM like '%' || UPPER(@[cust_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.OFC_CD like '%' || UPPER(@[ofc_cd]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${delt_flg} != '' && ${delt_flg} != 'ALL')" ).append("\n"); 
		query.append("AND A.MST_RQST_STS_CD = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_fm_dt} != '')" ).append("\n"); 
		query.append("AND RQST_DT >= TO_DATE(@[rqst_fm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rqst_to_dt} != '')" ).append("\n"); 
		query.append("AND RQST_DT <= TO_DATE(@[rqst_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_fm_dt} != '')" ).append("\n"); 
		query.append("AND CRE_DT >= TO_DATE(@[cre_fm_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_to_dt} != '')" ).append("\n"); 
		query.append("AND CRE_DT <= TO_DATE(@[cre_to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}