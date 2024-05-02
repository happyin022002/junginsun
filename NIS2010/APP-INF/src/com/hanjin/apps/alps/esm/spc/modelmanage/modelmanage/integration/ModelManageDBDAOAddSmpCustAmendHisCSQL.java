/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOAddSmpCustAmendHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOAddSmpCustAmendHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SMP Customer Amend History 정보를 저장합니다.
	  * 2014.03.06 [CHM-20142960] SMP/Allocation control보완 요청 - Amend 로직 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * </pre>
	  */
	public ModelManageDBDAOAddSmpCustAmendHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_rfa_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOAddSmpCustAmendHisCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_MDL_CUST_CTRL_HIS (" ).append("\n"); 
		query.append("       TRD_CD" ).append("\n"); 
		query.append("     , COST_YRWK" ).append("\n"); 
		query.append("     , VER_SEQ" ).append("\n"); 
		query.append("     , MODI_SEQ" ).append("\n"); 
		query.append("     , CUST_GRP_ID" ).append("\n"); 
		query.append("     , CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , SC_NO" ).append("\n"); 
		query.append("     , RFA_NO" ).append("\n"); 
		query.append("     , CNG_ITM_NM" ).append("\n"); 
		query.append("     , OLD_SC_NO" ).append("\n"); 
		query.append("     , OLD_RFA_NO" ).append("\n"); 
		query.append("     , PRE_SC_NO" ).append("\n"); 
		query.append("     , PRE_RFA_NO" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , MODI_USR_ID" ).append("\n"); 
		query.append("     , MODI_GDT" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT TRD_CD" ).append("\n"); 
		query.append("     , COST_YRWK" ).append("\n"); 
		query.append("     , VER_SEQ" ).append("\n"); 
		query.append("     , (SELECT NVL(MAX(MODI_SEQ) + 1, 1)" ).append("\n"); 
		query.append("          FROM SPC_MDL_CUST_CTRL_HIS" ).append("\n"); 
		query.append("         WHERE TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("           AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("           AND VER_SEQ   = @[ver_seq]" ).append("\n"); 
		query.append("       ) AS MODI_SEQ" ).append("\n"); 
		query.append("     , CUST_GRP_ID" ).append("\n"); 
		query.append("     , CUST_CNT_CD" ).append("\n"); 
		query.append("     , CUST_SEQ" ).append("\n"); 
		query.append("     , @[sc_no]  AS SC_NO" ).append("\n"); 
		query.append("     , @[rfa_no] AS RFA_NO" ).append("\n"); 
		query.append("     , DECODE(@[sc_rfa_flg], 'RFA', 'RFA UPDATE', 'S/C UPDATE') AS CNG_ITM_NM" ).append("\n"); 
		query.append("     , SC_NO         AS OLD_SC_NO" ).append("\n"); 
		query.append("     , RFA_NO        AS OLD_RFA_NO" ).append("\n"); 
		query.append("     , SC_NO         AS PRE_SC_NO" ).append("\n"); 
		query.append("     , RFA_NO        AS PRE_RFA_NO" ).append("\n"); 
		query.append("     , 'N'           AS DELT_FLG" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS MODI_USR_ID" ).append("\n"); 
		query.append("     , CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[modi_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE) AS MODI_GDT" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE       AS CRE_DT" ).append("\n"); 
		query.append("     , @[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE       AS UPD_DT" ).append("\n"); 
		query.append(" FROM SPC_MDL_CUST_CTRL" ).append("\n"); 
		query.append("WHERE TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("  AND COST_YRWK   = @[cost_yrwk]" ).append("\n"); 
		query.append("  AND VER_SEQ     = @[ver_seq]" ).append("\n"); 
		query.append("  AND CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("  AND CUST_SEQ    = @[cust_seq]" ).append("\n"); 
		query.append("#if (${pre_rfa_no} != '')" ).append("\n"); 
		query.append("  AND RFA_NO      = @[pre_rfa_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pre_sc_no} != '')" ).append("\n"); 
		query.append("  AND SC_NO       = @[pre_sc_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}