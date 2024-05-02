/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ModelManageDBDAOAddSmpCustHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.04
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2014.02.04 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOAddSmpCustHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SMP Customer History 정보를 저장합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * </pre>
	  */
	public ModelManageDBDAOAddSmpCustHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cng_itm_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_wk_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wk_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("old_cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOAddSmpCustHisCSQL").append("\n"); 
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
		query.append("    TRD_CD" ).append("\n"); 
		query.append("  , COST_YRWK" ).append("\n"); 
		query.append("  , VER_SEQ" ).append("\n"); 
		query.append("  , MODI_SEQ" ).append("\n"); 
		query.append("  , CUST_GRP_ID" ).append("\n"); 
		query.append("  , CUST_CNT_CD" ).append("\n"); 
		query.append("  , CUST_SEQ" ).append("\n"); 
		query.append("  , SC_NO" ).append("\n"); 
		query.append("  , RFA_NO" ).append("\n"); 
		query.append("  , CUST_CTRL_CD" ).append("\n"); 
		query.append("  , WK_MQC_QTY" ).append("\n"); 
		query.append("  , CNG_ITM_NM" ).append("\n"); 
		query.append("  , OLD_CUST_GRP_ID" ).append("\n"); 
		query.append("  , OLD_CUST_CNT_CD" ).append("\n"); 
		query.append("  , OLD_CUST_SEQ" ).append("\n"); 
		query.append("  , OLD_SC_NO" ).append("\n"); 
		query.append("  , OLD_RFA_NO" ).append("\n"); 
		query.append("  , OLD_CUST_CTRL_CD" ).append("\n"); 
		query.append("  , OLD_WK_MQC_QTY" ).append("\n"); 
		query.append("  , MODI_USR_ID" ).append("\n"); 
		query.append("  , MODI_GDT" ).append("\n"); 
		query.append("  , DELT_FLG" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append("  , SUB_TRD_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[trd_cd]" ).append("\n"); 
		query.append("  , @[cost_yrwk]" ).append("\n"); 
		query.append("  , @[ver_seq]" ).append("\n"); 
		query.append("  , (SELECT NVL(MAX(MODI_SEQ)+1,1)" ).append("\n"); 
		query.append("       FROM SPC_MDL_CUST_CTRL_HIS" ).append("\n"); 
		query.append("      WHERE TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("        AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("        AND VER_SEQ = @[ver_seq]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("  , (SELECT CUST_GRP_ID" ).append("\n"); 
		query.append("       FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("      WHERE CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("        AND CUST_SEQ = SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  , SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("  , SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("  , @[sc_no]" ).append("\n"); 
		query.append("  , @[rfa_no]" ).append("\n"); 
		query.append("  , @[cust_ctrl_cd]" ).append("\n"); 
		query.append("  , @[wk_mqc_qty]" ).append("\n"); 
		query.append("  , @[cng_itm_nm]" ).append("\n"); 
		query.append("  , (SELECT CUST_GRP_ID" ).append("\n"); 
		query.append("       FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("      WHERE CUST_CNT_CD = SUBSTR(@[old_cust_cd],1,2)" ).append("\n"); 
		query.append("        AND CUST_SEQ = SUBSTR(@[old_cust_cd],3)" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("  , SUBSTR(@[old_cust_cd],1,2)" ).append("\n"); 
		query.append("  , SUBSTR(@[old_cust_cd],3)" ).append("\n"); 
		query.append("  , @[old_sc_no]" ).append("\n"); 
		query.append("  , @[old_rfa_no]" ).append("\n"); 
		query.append("  , @[old_cust_ctrl_cd]" ).append("\n"); 
		query.append("  , @[old_wk_mqc_qty]" ).append("\n"); 
		query.append("  , @[usr_id]" ).append("\n"); 
		query.append("  , CAST(SYS_EXTRACT_UTC(TO_TIMESTAMP(@[modi_gdt], 'YYYY/MM/DD HH24:MI:SS')) AS DATE)" ).append("\n"); 
		query.append("  , 'N'" ).append("\n"); 
		query.append("  , @[usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , @[usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , NVL(@[sub_trd_cd],'*') -- 20130424 NVL 추가" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}