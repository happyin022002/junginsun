/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModelManageDBDAOAddModelshipAcctCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.28 
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

public class ModelManageDBDAOAddModelshipAcctCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Season/Version의 Account 정보를 등록합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.06.09 TRADE가 'AES'일 경우만 RFA들어가도록 보완
	  * 2015.01.28 박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가
	  * </pre>
	  */
	public ModelManageDBDAOAddModelshipAcctCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("acct_pic_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wk_mqc_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOAddModelshipAcctCSQL").append("\n"); 
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
		query.append("INSERT INTO SPC_MDL_CUST_CTRL(" ).append("\n"); 
		query.append("    TRD_CD" ).append("\n"); 
		query.append("  , COST_YRWK" ).append("\n"); 
		query.append("  , VER_SEQ" ).append("\n"); 
		query.append("  , CUST_CNT_CD" ).append("\n"); 
		query.append("  , CUST_SEQ" ).append("\n"); 
		query.append("  , DTL_SEQ" ).append("\n"); 
		query.append("  , CUST_GRP_ID" ).append("\n"); 
		query.append("  , SC_NO" ).append("\n"); 
		query.append("  , RFA_NO" ).append("\n"); 
		query.append("  , CUST_CTRL_CD" ).append("\n"); 
		query.append("  , WK_MQC_QTY" ).append("\n"); 
		query.append("  , ACCT_PIC_NM" ).append("\n"); 
		query.append("  , DELT_FLG" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append("  , SUB_TRD_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[trade]" ).append("\n"); 
		query.append("  , @[cost_yrwk]" ).append("\n"); 
		query.append("  , @[ver_seq]" ).append("\n"); 
		query.append("  , SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("  , SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("  , (SELECT NVL(MAX(DTL_SEQ)+1,1)" ).append("\n"); 
		query.append("       FROM SPC_MDL_CUST_CTRL" ).append("\n"); 
		query.append("      WHERE TRD_CD = @[trade]" ).append("\n"); 
		query.append("        AND COST_YRWK = @[cost_yrwk]" ).append("\n"); 
		query.append("        AND VER_SEQ = @[ver_seq]" ).append("\n"); 
		query.append("        AND CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("        AND CUST_SEQ = SUBSTR(@[cust_cd],3)" ).append("\n"); 
		query.append("        AND SUB_TRD_CD = NVL(@[sub_trd_cd],'*')  -- 20130424 NVL 추가" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("  , @[cust_grp_id]" ).append("\n"); 
		query.append("  , @[sc_no]" ).append("\n"); 
		query.append("  , DECODE(@[trade],'AES',@[rfa_no],'IAS',@[rfa_no],'')" ).append("\n"); 
		query.append("  , @[cust_ctrl_cd]" ).append("\n"); 
		query.append("  , @[wk_mqc_qty]" ).append("\n"); 
		query.append("  , @[acct_pic_nm]" ).append("\n"); 
		query.append("  , 'N'" ).append("\n"); 
		query.append("  , @[cre_usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , @[cre_usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , NVL(@[sub_trd_cd],'*')  -- 20130424 NVL 추가" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}